package org.apache.tools.ant.taskdefs.condition;

/* loaded from: classes25.dex */
public class IsSet extends org.apache.tools.ant.ProjectComponent implements org.apache.tools.ant.taskdefs.condition.Condition {
    public java.lang.String n;

    @Override // org.apache.tools.ant.taskdefs.condition.Condition
    public boolean eval() throws org.apache.tools.ant.BuildException {
        if (this.n != null) {
            return getProject().getProperty(this.n) != null;
        }
        throw new org.apache.tools.ant.BuildException("No property specified for isset condition");
    }

    public void setProperty(java.lang.String str) {
        this.n = str;
    }
}
