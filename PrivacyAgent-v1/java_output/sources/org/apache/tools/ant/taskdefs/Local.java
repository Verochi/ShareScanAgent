package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Local extends org.apache.tools.ant.Task {
    public java.lang.String u;

    @Override // org.apache.tools.ant.Task
    public void execute() {
        if (this.u == null) {
            throw new org.apache.tools.ant.BuildException("Missing attribute name");
        }
        org.apache.tools.ant.property.LocalProperties.get(getProject()).addLocal(this.u);
    }

    public void setName(java.lang.String str) {
        this.u = str;
    }
}
