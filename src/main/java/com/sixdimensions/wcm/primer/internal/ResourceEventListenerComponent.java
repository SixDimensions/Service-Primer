package com.sixdimensions.wcm.primer.internal;

import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResourceEventListenerComponent {
	private static final Logger log = LoggerFactory
			.getLogger(ResourceEventListenerComponent.class);

	private ServiceRegistration registration;
	

	protected void registerEventLisener(BundleContext bundleContext) {
		String[] topics = new String[] { "org/apache/sling/api/resource/Resource/*" };

		EventHandler handler = new EventHandler() {
			public void handleEvent(Event event) {
				String title = (String) event.getProperty("title");
				String path = (String) event.getProperty("path");
				log.info("Title: {} Path: {}", new Object[] { title,
						path });
			}
		};
		Dictionary<Object, Object[]> props = new Hashtable<Object, Object[]>();
		props.put(EventConstants.EVENT_TOPIC, topics);
		registration = bundleContext.registerService(EventHandler.class.getName(),
				handler, props);
	}

}
