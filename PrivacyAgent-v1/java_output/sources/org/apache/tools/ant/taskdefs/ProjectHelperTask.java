package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class ProjectHelperTask extends org.apache.tools.ant.Task {
    public java.util.List u = new java.util.ArrayList();

    public synchronized void addConfigured(org.apache.tools.ant.ProjectHelper projectHelper) {
        this.u.add(projectHelper);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.ProjectHelperRepository projectHelperRepository = org.apache.tools.ant.ProjectHelperRepository.getInstance();
        java.util.Iterator it = this.u.iterator();
        while (it.hasNext()) {
            projectHelperRepository.registerProjectHelper((java.lang.Class<? extends org.apache.tools.ant.ProjectHelper>) ((org.apache.tools.ant.ProjectHelper) it.next()).getClass());
        }
    }
}
