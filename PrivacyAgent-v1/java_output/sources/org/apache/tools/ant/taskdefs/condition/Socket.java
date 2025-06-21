package org.apache.tools.ant.taskdefs.condition;

/* loaded from: classes25.dex */
public class Socket extends org.apache.tools.ant.ProjectComponent implements org.apache.tools.ant.taskdefs.condition.Condition {
    public java.lang.String n = null;
    public int t = 0;

    @Override // org.apache.tools.ant.taskdefs.condition.Condition
    public boolean eval() throws org.apache.tools.ant.BuildException {
        if (this.n == null) {
            throw new org.apache.tools.ant.BuildException("No server specified in socket condition");
        }
        if (this.t == 0) {
            throw new org.apache.tools.ant.BuildException("No port specified in socket condition");
        }
        log("Checking for listener at " + this.n + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + this.t, 3);
        try {
            try {
                new java.net.Socket(this.n, this.t).close();
                return true;
            } catch (java.io.IOException unused) {
                return true;
            }
        } catch (java.io.IOException unused2) {
            return false;
        }
    }

    public void setPort(int i) {
        this.t = i;
    }

    public void setServer(java.lang.String str) {
        this.n = str;
    }
}
