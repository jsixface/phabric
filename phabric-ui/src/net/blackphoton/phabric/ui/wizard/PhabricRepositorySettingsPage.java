package net.blackphoton.phabric.ui.wizard;

import org.eclipse.mylyn.tasks.core.RepositoryTemplate;
import org.eclipse.mylyn.tasks.core.TaskRepository;
import org.eclipse.mylyn.tasks.ui.wizards.AbstractRepositorySettingsPage;
import org.eclipse.mylyn.tasks.ui.wizards.ITaskRepositoryPage;
import org.eclipse.swt.widgets.Composite;

import net.blackphoton.phabric.core.PhabricatorCorePlugin;

public class PhabricRepositorySettingsPage extends AbstractRepositorySettingsPage implements ITaskRepositoryPage {

	public PhabricRepositorySettingsPage(TaskRepository repository) {
		super("Phabricator Repository Settings", "Settings for Phabricator repository", repository);
		setNeedsAnonymousLogin(false);
		setNeedsEncoding(false);
		setNeedsTimeZone(false);
		setNeedsProxy(false);
		setNeedsAdvanced(false);
	}

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		addRepositoryTemplatesToServerUrlCombo();
	}

	@Override
	protected void repositoryTemplateSelected(RepositoryTemplate template) {
		repositoryLabelEditor.setStringValue(template.label);
		setUrl(template.repositoryUrl);
		setUserId("user");
		setPassword("pass");
		
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

}
