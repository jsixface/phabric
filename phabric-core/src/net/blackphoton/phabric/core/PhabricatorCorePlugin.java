package net.blackphoton.phabric.core;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class PhabricatorCorePlugin implements BundleActivator {

	public static final String CONNECTOR_KIND = "phabric";
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext bundleContext) throws Exception {
		PhabricatorCorePlugin.context = bundleContext;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		PhabricatorCorePlugin.context = null;
	}

}
