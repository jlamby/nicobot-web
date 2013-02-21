package com.st.nicobot.web.composer;

import javax.servlet.ServletContext;

import org.picocontainer.MutablePicoContainer;
import org.picocontainer.web.WebappComposer;

import com.st.nicobot.context.ClassLoader;
import com.st.nicobot.context.ComponentUtils;
import com.st.nicobot.context.annotations.Component;


/**
 * @author jlamby
 *
 */
public class NicoWebappComposer implements WebappComposer {
	
	@Override
	public void composeApplication(MutablePicoContainer container, ServletContext servletContext) {
		ComponentUtils.loadComponents(container, ClassLoader.getAllInstantiableClasses());
		ComponentUtils.loadComponents(container, ClassLoader.getClassAnnotedWith(Component.class));

		ComponentUtils.publishApplicationContext(container);
	}

	@Override
	public void composeSession(MutablePicoContainer container) {
		
	}

	@Override
	public void composeRequest(MutablePicoContainer container) {
		
	}

}
