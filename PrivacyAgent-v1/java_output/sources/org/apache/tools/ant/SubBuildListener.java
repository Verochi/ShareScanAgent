package org.apache.tools.ant;

/* loaded from: classes25.dex */
public interface SubBuildListener extends org.apache.tools.ant.BuildListener {
    void subBuildFinished(org.apache.tools.ant.BuildEvent buildEvent);

    void subBuildStarted(org.apache.tools.ant.BuildEvent buildEvent);
}
