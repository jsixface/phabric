package in.twobytwo.phabric.ui.wizard;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.mylyn.commons.workbench.forms.SectionComposite;
import org.eclipse.mylyn.tasks.core.IRepositoryQuery;
import org.eclipse.mylyn.tasks.core.TaskRepository;
import org.eclipse.mylyn.tasks.ui.wizards.AbstractRepositoryQueryPage2;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import in.twobytwo.phabric.ui.wizard.Messages;

public class PhabricQueryPage extends AbstractRepositoryQueryPage2 {

	private final static String PAGE_NAME = "PhabricQueryPage";

	private final Map<String, Control> controlMap = new HashMap<>();

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
		Composite control = parent.getContent();

		GridLayout layout = new GridLayout(4, false);
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		control.setLayout(layout);

		createDefaultGroup(control);
	}

	private void createDefaultGroup(Composite control) {
		Label searchLabel = new Label(control, SWT.LEFT);
		searchLabel.setText("Search For");

		Text search = new Text(control, SWT.RIGHT);
		controlMap.put("keyword", search);

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
		query.setSummary(getQueryTitle());
		for (String fieldName : controlMap.keySet()) {
			Control field = controlMap.get(fieldName);
			if (field instanceof Text) {
				Text textfield = (Text) field;
				query.setAttribute(fieldName, textfield.getText());
				System.out.println(fieldName + " -- " + textfield.getText());
			}
		}
	}
}
