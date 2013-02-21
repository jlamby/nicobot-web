package com.st.nicobot.web.listener;

import javax.servlet.ServletContextEvent;

import org.picocontainer.ComponentMonitor;
import org.picocontainer.LifecycleStrategy;
import org.picocontainer.gems.monitors.Slf4jComponentMonitor;
import org.picocontainer.lifecycle.ReflectionLifecycleStrategy;
import org.picocontainer.web.PicoServletContainerListener;
import org.picocontainer.web.ScopedContainers;

import com.st.nicobot.bot.NicoBot;
import com.st.nicobot.bot.utils.NicobotProperty;
import com.st.nicobot.services.PropertiesService;


public class ApplicationListener extends PicoServletContainerListener {

	private static final long serialVersionUID = 1L;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		super.contextInitialized(arg0);
		
		ScopedContainers scopedContainers = (ScopedContainers) arg0.getServletContext().getAttribute(ScopedContainers.class.getName());
		
		PropertiesService props = scopedContainers.getApplicationContainer().getComponent(PropertiesService.class);
		NicoBot bot = scopedContainers.getApplicationContainer().getComponent(NicoBot.class);
		
		try {
			bot.connect(props.get(NicobotProperty.BOT_SERVER));
			bot.joinChannel(props.get(NicobotProperty.BOT_CHAN));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	protected ComponentMonitor makeAppComponentMonitor() {
		return new Slf4jComponentMonitor();
	}
	
	@Override
	protected LifecycleStrategy makeLifecycleStrategy() {
		return new ReflectionLifecycleStrategy(makeAppComponentMonitor());
	}
}
