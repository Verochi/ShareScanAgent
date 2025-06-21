package org.apache.tools.ant.helper;

/* loaded from: classes25.dex */
public class IgnoreDependenciesExecutor implements org.apache.tools.ant.Executor {
    public static final org.apache.tools.ant.helper.SingleCheckExecutor a = new org.apache.tools.ant.helper.SingleCheckExecutor();

    @Override // org.apache.tools.ant.Executor
    public void executeTargets(org.apache.tools.ant.Project project, java.lang.String[] strArr) throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.Target target;
        java.util.Hashtable<java.lang.String, org.apache.tools.ant.Target> targets = project.getTargets();
        org.apache.tools.ant.BuildException e = null;
        for (java.lang.String str : strArr) {
            try {
                target = targets.get(str);
            } catch (org.apache.tools.ant.BuildException e2) {
                e = e2;
                if (!project.isKeepGoingMode()) {
                    throw e;
                }
            }
            if (target == null) {
                throw new org.apache.tools.ant.BuildException("Unknown target " + str);
            }
            target.performTasks();
        }
        if (e != null) {
            throw e;
        }
    }

    @Override // org.apache.tools.ant.Executor
    public org.apache.tools.ant.Executor getSubProjectExecutor() {
        return a;
    }
}
