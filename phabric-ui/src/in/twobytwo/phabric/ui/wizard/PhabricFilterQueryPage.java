package in.twobytwo.phabric.ui.wizard;

import org.eclipse.mylyn.tasks.core.IRepositoryQuery;
import org.eclipse.mylyn.tasks.core.TaskRepository;
import org.eclipse.mylyn.tasks.ui.wizards.AbstractRepositoryQueryPage;
import org.eclipse.swt.widgets.Composite;

public class PhabricFilterQueryPage extends AbstractRepositoryQueryPage {

	private static final String TITLE = Messages.FilterQueryPage_New_Trac_Query;

	private static final String DESCRIPTION = Messages.FilterQueryPage_Add_search_filters_to_define_query;

	private static final String TITLE_QUERY_TITLE = Messages.FilterQueryPage_Query_Title;

	public PhabricFilterQueryPage(String pageName, TaskRepository taskRepository, IRepositoryQuery query) {
		super(TITLE, taskRepository, query);
		setTitle(TITLE);
		setDescription(DESCRIPTION);
	}

	@Override
	public void createControl(Composite arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void applyTo(IRepositoryQuery arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public String getQueryTitle() {
		// TODO Auto-generated method stub
		return null;
	}

}
