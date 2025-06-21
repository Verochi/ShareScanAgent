package org.apache.tools.ant.helper;

/* loaded from: classes25.dex */
public class DefaultExecutor implements org.apache.tools.ant.Executor {
    public static final org.apache.tools.ant.helper.SingleCheckExecutor a = new org.apache.tools.ant.helper.SingleCheckExecutor();

    @Override // org.apache.tools.ant.Executor
    public void executeTargets(org.apache.tools.ant.Project project, java.lang.String[] strArr) throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.BuildException e = null;
        for (java.lang.String str : strArr) {
            try {
                project.executeTarget(str);
            } catch (org.apache.tools.ant.BuildException e2) {
                e = e2;
                if (!project.isKeepGoingMode()) {
                    throw e;
                }
            }
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
