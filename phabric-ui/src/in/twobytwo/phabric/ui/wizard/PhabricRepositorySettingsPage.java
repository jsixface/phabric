package in.twobytwo.phabric.ui.wizard;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.mylyn.tasks.core.RepositoryTemplate;
import org.eclipse.mylyn.tasks.core.TaskRepository;
import org.eclipse.mylyn.tasks.ui.wizards.AbstractRepositorySettingsPage;
import org.eclipse.mylyn.tasks.ui.wizards.ITaskRepositoryPage;
import org.eclipse.swt.widgets.Composite;

import in.twobytwo.phabric.core.PhabricatorCorePlugin;

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
		// TODO Auto-generated method stub

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
			// TODO Auto-generated method stub

		}

	}

	@Override
	protected Validator getValidator(TaskRepository repository) {
		return new PhabricatorValidator(repository, getApiToken());
	}

	private String getApiToken() {

		return fldToken.getStringValue();
	}
}
