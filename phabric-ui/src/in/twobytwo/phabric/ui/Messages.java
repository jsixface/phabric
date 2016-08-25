
package in.twobytwo.phabric.ui;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "in.twobytwo.phabric.ui.messages";

	static {
		reloadMessages();
	}

	public static void reloadMessages() {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	public static String PRSP_VALIDATION_SUCCESSFUL;
	public static String PRSP_VALIDATION_FAILURE;

}
