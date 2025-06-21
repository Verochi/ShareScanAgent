package org.apache.tools.ant.taskdefs.cvslib;

/* loaded from: classes25.dex */
public class CvsUser {
    public java.lang.String a;
    public java.lang.String b;

    public java.lang.String getDisplayname() {
        return this.b;
    }

    public java.lang.String getUserID() {
        return this.a;
    }

    public void setDisplayname(java.lang.String str) {
        this.b = str;
    }

    public void setUserid(java.lang.String str) {
        this.a = str;
    }

    public void validate() throws org.apache.tools.ant.BuildException {
        if (this.a == null) {
            throw new org.apache.tools.ant.BuildException("Username attribute must be set.");
        }
        if (this.b != null) {
            return;
        }
        throw new org.apache.tools.ant.BuildException("Displayname attribute must be set for userID " + this.a);
    }
}
