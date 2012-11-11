package com.st.nicobot.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.st.nicobot.NicoBot;


public class ApplicationListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		try {
			NicoBot bot = new NicoBot("nicobot");
			
			//moar logs
			bot.setVerbose(true);
			
			bot.connect("nl.quakenet.org");
			bot.joinChannel("#zqsd");
		}
		catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
}
