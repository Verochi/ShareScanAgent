package org.apache.tools.ant.taskdefs.optional.unix;

/* loaded from: classes25.dex */
public class Chown extends org.apache.tools.ant.taskdefs.optional.unix.AbstractAccessTask {
    public boolean W = false;

    public Chown() {
        super.setExecutable("chown");
    }

    @Override // org.apache.tools.ant.taskdefs.ExecuteOn, org.apache.tools.ant.taskdefs.ExecTask
    public void checkConfiguration() {
        if (!this.W) {
            throw new org.apache.tools.ant.BuildException("Required attribute owner not set in chown", getLocation());
        }
        super.checkConfiguration();
    }

    @Override // org.apache.tools.ant.taskdefs.ExecTask
    public void setExecutable(java.lang.String str) {
        throw new org.apache.tools.ant.BuildException(getTaskType() + " doesn't support the executable attribute", getLocation());
    }

    public void setOwner(java.lang.String str) {
        createArg().setValue(str);
        this.W = true;
    }
}
