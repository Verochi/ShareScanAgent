package org.apache.tools.ant;

/* loaded from: classes25.dex */
public interface Executor {
    void executeTargets(org.apache.tools.ant.Project project, java.lang.String[] strArr) throws org.apache.tools.ant.BuildException;

    org.apache.tools.ant.Executor getSubProjectExecutor();
}
