package org.apache.tools.ant.taskdefs.condition;

/* loaded from: classes25.dex */
public class Contains implements org.apache.tools.ant.taskdefs.condition.Condition {
    public java.lang.String n;
    public java.lang.String t;
    public boolean u = true;

    @Override // org.apache.tools.ant.taskdefs.condition.Condition
    public boolean eval() throws org.apache.tools.ant.BuildException {
        java.lang.String str;
        java.lang.String str2 = this.n;
        if (str2 == null || (str = this.t) == null) {
            throw new org.apache.tools.ant.BuildException("both string and substring are required in contains");
        }
        return this.u ? str2.contains(str) : str2.toLowerCase().contains(this.t.toLowerCase());
    }

    public void setCasesensitive(boolean z) {
        this.u = z;
    }

    public void setString(java.lang.String str) {
        this.n = str;
    }

    public void setSubstring(java.lang.String str) {
        this.t = str;
    }
}
