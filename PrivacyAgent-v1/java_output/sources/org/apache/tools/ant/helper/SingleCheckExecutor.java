package org.apache.tools.ant.helper;

/* loaded from: classes25.dex */
public class SingleCheckExecutor implements org.apache.tools.ant.Executor {
    @Override // org.apache.tools.ant.Executor
    public void executeTargets(org.apache.tools.ant.Project project, java.lang.String[] strArr) throws org.apache.tools.ant.BuildException {
        project.executeSortedTargets(project.topoSort(strArr, project.getTargets(), false));
    }

    @Override // org.apache.tools.ant.Executor
    public org.apache.tools.ant.Executor getSubProjectExecutor() {
        return this;
    }
}
