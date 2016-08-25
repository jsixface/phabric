package in.twobytwo.phabric.ui.wizard;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.mylyn.tasks.core.RepositoryStatus;
import org.eclipse.mylyn.tasks.core.RepositoryTemplate;
import org.eclipse.mylyn.tasks.core.TaskRepository;
import org.eclipse.mylyn.tasks.ui.wizards.AbstractRepositorySettingsPage;
import org.eclipse.mylyn.tasks.ui.wizards.ITaskRepositoryPage;
import org.eclipse.swt.widgets.Composite;

import in.twobytwo.phabric.core.PhabricatorCorePlugin;
import in.twobytwo.phabric.core.client.PhabricatorClient;
import in.twobytwo.phabric.core.model.PhUser;
import in.twobytwo.phabric.ui.PhabricatorUiPlugin;

public class PhabricRepositorySettingsPage extends AbstractRepositorySettingsPage implements ITaskRepositoryPage {

	private static final String API_TOKEN = "apiToken";
	private StringFieldEditor fldToken;

	public PhabricRepositorySettingsPage(TaskRepository repository) {
		super("Phabricator Repository Settings", "Settings for Phabricator repository", repository);
		setNeedsAnonymousLogin(false);
		setNeedsEncoding(false);
		setNeedsTimeZone(false);
		setNeedsRepositoryCredentials(false);
	}

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		addRepositoryTemplatesToServerUrlCombo();

		fldToken = new StringFieldEditor(API_TOKEN, "API Token", StringFieldEditor.UNLIMITED,
				innerComposite.getContent()) {
			@Override
			protected void valueChanged() {
				super.valueChanged();
				if (getWizard() != null) {
					getWizard().getContainer().updateButtons();
				}
			}

			@Override
			public int getNumberOfControls() {
				return 2;
			}
		};
		fldToken.setStringValue(getRepository() == null ? "" : getRepository().getProperty(API_TOKEN));
	}

	@Override
	public boolean isPageComplete() {
		// make sure "Automatic" is not selected as a version
		return super.isPageComplete() && fldToken != null && fldToken.getStringValue() != null
				&& fldToken.getStringValue() != "";
	}

	@Override
	protected void repositoryTemplateSelected(RepositoryTemplate template) {
		repositoryLabelEditor.setStringValue(template.label);
		setUrl(template.repositoryUrl);
		getContainer().updateButtons();
	}

	@Override
	public String getConnectorKind() {
		return PhabricatorCorePlugin.CONNECTOR_KIND;
	}

	@Override
	protected void createAdditionalControls(Composite parent) {
	}

	@Override
	public void performFinish(TaskRepository repository) {
		repository.setProperty(API_TOKEN, fldToken != null ? fldToken.getStringValue() : "");
		super.performFinish(repository);
	}

	public class PhabricatorValidator extends Validator {
		private String repositoryUrl;
		private String apiToken;

		public PhabricatorValidator(TaskRepository repository, String apiToken) {
			this.repositoryUrl = repository.getUrl();
			this.apiToken = apiToken;
		}

		@Override
		public void run(IProgressMonitor monitor) throws CoreException {
			PhabricatorClient client = new PhabricatorClient(repositoryUrl, apiToken);
			PhUser user = client.whoAmI();
			if (user == null) {
				setStatus(RepositoryStatus.createStatus(repositoryUrl, IStatus.ERROR, PhabricatorUiPlugin.ID_PLUGIN,
						in.twobytwo.phabric.ui.Messages.PRSP_VALIDATION_FAILURE));
			} else {
				setStatus(RepositoryStatus.createStatus(repositoryUrl, IStatus.INFO, PhabricatorUiPlugin.ID_PLUGIN,
						in.twobytwo.phabric.ui.Messages.PRSP_VALIDATION_SUCCESSFUL));
				System.out.println(user);
			}
		}
	}

	@Override
	protected Validator getValidator(TaskRepository repository) {
		String apiToken = fldToken != null ? fldToken.getStringValue() : "";

		return new PhabricatorValidator(repository, apiToken);
	}

}
