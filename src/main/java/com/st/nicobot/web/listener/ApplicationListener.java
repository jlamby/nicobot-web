package com.st.nicobot.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.st.nicobot.BotMain;


public class ApplicationListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		try {
			BotMain.main(new String[] {});
		}
		catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
}
