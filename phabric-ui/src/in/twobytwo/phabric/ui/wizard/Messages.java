
package in.twobytwo.phabric.ui.wizard;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "in.twobytwo.phabric.ui.wizard.messages";

	static {
		reloadMessages();
	}

	public static void reloadMessages() {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	public static String QueryPage_Enter_Query;
	public static String QueryPage_Description;

	public static String FilterQueryPage_New_Trac_Query;
	public static String FilterQueryPage_Add_search_filters_to_define_query;
	public static String FilterQueryPage_Query_Title;
}
