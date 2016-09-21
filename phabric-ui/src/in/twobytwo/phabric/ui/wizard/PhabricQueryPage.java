package in.twobytwo.phabric.ui.wizard;

import org.eclipse.mylyn.commons.workbench.forms.SectionComposite;
import org.eclipse.mylyn.tasks.core.IRepositoryQuery;
import org.eclipse.mylyn.tasks.core.TaskRepository;
import org.eclipse.mylyn.tasks.ui.wizards.AbstractRepositoryQueryPage2;

import in.twobytwo.phabric.ui.wizard.Messages;

public class PhabricQueryPage extends AbstractRepositoryQueryPage2 {

	private final static String PAGE_NAME = "PhabricQueryPage";

	public PhabricQueryPage(TaskRepository repository, IRepositoryQuery query) {
		super(PAGE_NAME, repository, query);
		setTitle(Messages.QueryPage_Enter_Query);
		setDescription(Messages.QueryPage_Description);
		setNeedsClear(true);
	}

	public PhabricQueryPage(TaskRepository repository) {
		this(repository, null);
	}

	@Override
	protected void createPageContent(SectionComposite parent) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doRefreshControls() {
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean hasRepositoryConfiguration() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean restoreState(IRepositoryQuery query) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void applyTo(IRepositoryQuery query) {
		// TODO Auto-generated method stub

	}

}
