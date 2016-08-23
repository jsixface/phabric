package net.blackphoton.phabric.ui.wizard;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.mylyn.tasks.core.RepositoryTemplate;
import org.eclipse.mylyn.tasks.core.TaskRepository;
import org.eclipse.mylyn.tasks.ui.wizards.AbstractRepositorySettingsPage;
import org.eclipse.mylyn.tasks.ui.wizards.ITaskRepositoryPage;
import org.eclipse.swt.widgets.Composite;

import net.blackphoton.phabric.core.PhabricatorCorePlugin;

public class PhabricRepositorySettingsPage extends AbstractRepositorySettingsPage implements ITaskRepositoryPage {

	private StringFieldEditor lblToken;

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

		lblToken = new StringFieldEditor("apiToken", "API Token", StringFieldEditor.UNLIMITED,
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
		return super.isPageComplete() && lblToken != null && lblToken.getStringValue() != null
				&& lblToken.getStringValue() != "";
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

		@Override
		public void run(IProgressMonitor monitor) throws CoreException {
			// TODO Auto-generated method stub

		}

	}

}
