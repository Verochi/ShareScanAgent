package org.apache.tools.ant.taskdefs.optional.unix;

/* loaded from: classes25.dex */
public class Chgrp extends org.apache.tools.ant.taskdefs.optional.unix.AbstractAccessTask {
    public boolean W = false;

    public Chgrp() {
        super.setExecutable("chgrp");
    }

    @Override // org.apache.tools.ant.taskdefs.ExecuteOn, org.apache.tools.ant.taskdefs.ExecTask
    public void checkConfiguration() {
        if (!this.W) {
            throw new org.apache.tools.ant.BuildException("Required attribute group not set in chgrp", getLocation());
        }
        super.checkConfiguration();
    }

    @Override // org.apache.tools.ant.taskdefs.ExecTask
    public void setExecutable(java.lang.String str) {
        throw new org.apache.tools.ant.BuildException(getTaskType() + " doesn't support the executable attribute", getLocation());
    }

    public void setGroup(java.lang.String str) {
        createArg().setValue(str);
        this.W = true;
    }
}
