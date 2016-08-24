package in.twobytwo.phabric.ui;

import org.eclipse.jface.wizard.IWizard;
import org.eclipse.mylyn.tasks.core.AbstractRepositoryConnector;
import org.eclipse.mylyn.tasks.core.IRepositoryQuery;
import org.eclipse.mylyn.tasks.core.ITaskMapping;
import org.eclipse.mylyn.tasks.core.TaskRepository;
import org.eclipse.mylyn.tasks.ui.AbstractRepositoryConnectorUi;
import org.eclipse.mylyn.tasks.ui.wizards.ITaskRepositoryPage;

import in.twobytwo.phabric.core.PhabricatorCorePlugin;
import in.twobytwo.phabric.ui.wizard.PhabricRepositorySettingsPage;

public class PhabricConnectorUI extends AbstractRepositoryConnectorUi {

	public PhabricConnectorUI(AbstractRepositoryConnector connector) {
		super(connector);
		// TODO Auto-generated constructor stub
	}

	public PhabricConnectorUI() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getConnectorKind() {
		return PhabricatorCorePlugin.CONNECTOR_KIND;
	}

	@Override
	public ITaskRepositoryPage getSettingsPage(TaskRepository repository) {
		return new PhabricRepositorySettingsPage(repository);
	}

	@Override
	public IWizard getQueryWizard(TaskRepository repository, IRepositoryQuery query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IWizard getNewTaskWizard(TaskRepository repository, ITaskMapping selection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasSearchPage() {
		// TODO Auto-generated method stub
		return false;
	}

}
