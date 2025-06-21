package org.apache.tools.ant;

/* loaded from: classes25.dex */
public class TaskConfigurationChecker {
    public java.util.List<java.lang.String> a = new java.util.ArrayList();
    public final org.apache.tools.ant.Task b;

    public TaskConfigurationChecker(org.apache.tools.ant.Task task) {
        this.b = task;
    }

    public void assertConfig(boolean z, java.lang.String str) {
        if (z) {
            return;
        }
        this.a.add(str);
    }

    public void checkErrors() throws org.apache.tools.ant.BuildException {
        if (this.a.isEmpty()) {
            return;
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append("Configuration error on <");
        stringBuffer.append(this.b.getTaskName());
        stringBuffer.append(">:");
        stringBuffer.append(java.lang.System.getProperty("line.separator"));
        for (java.lang.String str : this.a) {
            stringBuffer.append("- ");
            stringBuffer.append(str);
            stringBuffer.append(java.lang.System.getProperty("line.separator"));
        }
        throw new org.apache.tools.ant.BuildException(stringBuffer.toString(), this.b.getLocation());
    }

    public void fail(java.lang.String str) {
        this.a.add(str);
    }
}
