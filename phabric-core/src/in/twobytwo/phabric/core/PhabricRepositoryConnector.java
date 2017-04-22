package in.twobytwo.phabric.core;

import static in.twobytwo.phabric.core.PhabricConstants.PROP_API_TOKEN;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.mylyn.tasks.core.AbstractRepositoryConnector;
import org.eclipse.mylyn.tasks.core.IRepositoryQuery;
import org.eclipse.mylyn.tasks.core.ITask;
import org.eclipse.mylyn.tasks.core.TaskRepository;
import org.eclipse.mylyn.tasks.core.data.TaskData;
import org.eclipse.mylyn.tasks.core.data.TaskDataCollector;
import org.eclipse.mylyn.tasks.core.sync.ISynchronizationSession;

import in.twobytwo.phabric.core.client.PhabricatorClient;

public class PhabricRepositoryConnector extends AbstractRepositoryConnector {

	private Map<String, PhabricatorClient> clientMap = new HashMap<String, PhabricatorClient>();

	@Override
	public boolean canCreateNewTask(TaskRepository repository) {
		return true;
	}

	@Override
	public boolean canCreateTaskFromKey(TaskRepository repository) {
		return true;
	}

	@Override
	public String getConnectorKind() {
		return PhabricatorCorePlugin.CONNECTOR_KIND;
	}

	@Override
	public String getLabel() {
		return "Phabricator Repository";
	}

	@Override
	public String getRepositoryUrlFromTaskUrl(String taskUrl) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaskData getTaskData(TaskRepository repository, String taskId, IProgressMonitor monitor)
			throws CoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTaskIdFromTaskUrl(String taskUrl) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTaskUrl(String repositoryUrl, String taskIdOrKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasTaskChanged(TaskRepository taskRepository, ITask task, TaskData taskData) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IStatus performQuery(TaskRepository repository, IRepositoryQuery query, TaskDataCollector collector,
			ISynchronizationSession session, IProgressMonitor monitor) {
		System.out.println(this.getClass() + "performing Query alright.");
		return Status.OK_STATUS;
	}

	@Override
	public void updateRepositoryConfiguration(TaskRepository taskRepository, IProgressMonitor monitor)
			throws CoreException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateTaskFromTaskData(TaskRepository taskRepository, ITask task, TaskData taskData) {
		// TODO Auto-generated method stub

	}

	public PhabricatorClient getPhabricatorClient(TaskRepository repo) {
		String url = repo.getRepositoryUrl();
		PhabricatorClient client = clientMap.get(url);
		if (client == null) {
			String token = repo.getProperty(PROP_API_TOKEN);
			client = new PhabricatorClient(url, token);
			clientMap.put(url, client);
		}
		return client;
	}

}
