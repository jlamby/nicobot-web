package org.picocontainer.web;

import org.picocontainer.MutablePicoContainer;
import org.picocontainer.behaviors.Storing;

/**
 * @author Julien
 *
 */
public class ScopedContainers{

	private final MutablePicoContainer applicationContainer;
    private final MutablePicoContainer sessionContainer;
    private final MutablePicoContainer requestContainer;
    private final Storing sessionStoring;
    private final Storing requestStoring;
    private final ThreadLocalLifecycleState sessionState;
    private final ThreadLocalLifecycleState requestState;

    public ScopedContainers(MutablePicoContainer applicationContainer, MutablePicoContainer sessionContainer, MutablePicoContainer requestContainer, Storing sessionStoring, Storing requestStoring, ThreadLocalLifecycleState sessionState, ThreadLocalLifecycleState requestState) {
        this.applicationContainer = applicationContainer;
        this.sessionContainer = sessionContainer;
        this.requestContainer = requestContainer;
        this.sessionStoring = sessionStoring;
        this.requestStoring = requestStoring;
        this.sessionState = sessionState;
        this.requestState = requestState;
    }

    public MutablePicoContainer getApplicationContainer() {
        return applicationContainer;
    }

    public MutablePicoContainer getSessionContainer() {
        return sessionContainer;
    }

    public MutablePicoContainer getRequestContainer() {
        return requestContainer;
    }

    public Storing getSessionStoring() {
        return sessionStoring;
    }

    public Storing getRequestStoring() {
        return requestStoring;

    }

    public ThreadLocalLifecycleState getSessionState() {
        return sessionState;
    }

    public ThreadLocalLifecycleState getRequestState() {
        return requestState;
    }
	
}
