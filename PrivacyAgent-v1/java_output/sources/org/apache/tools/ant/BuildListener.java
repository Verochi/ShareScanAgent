package org.apache.tools.ant;

/* loaded from: classes25.dex */
public interface BuildListener extends java.util.EventListener {
    void buildFinished(org.apache.tools.ant.BuildEvent buildEvent);

    void buildStarted(org.apache.tools.ant.BuildEvent buildEvent);

    void messageLogged(org.apache.tools.ant.BuildEvent buildEvent);

    void targetFinished(org.apache.tools.ant.BuildEvent buildEvent);

    void targetStarted(org.apache.tools.ant.BuildEvent buildEvent);

    void taskFinished(org.apache.tools.ant.BuildEvent buildEvent);

    void taskStarted(org.apache.tools.ant.BuildEvent buildEvent);
}
