package org.apache.tools.ant.taskdefs.optional.j2ee;

/* loaded from: classes25.dex */
public abstract class AbstractHotDeploymentTool implements org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool {
    public org.apache.tools.ant.taskdefs.optional.j2ee.ServerDeploy a;
    public org.apache.tools.ant.types.Path b;
    public java.lang.String c;
    public java.lang.String d;
    public java.lang.String e;

    public org.apache.tools.ant.types.Path createClasspath() {
        if (this.b == null) {
            this.b = new org.apache.tools.ant.types.Path(this.a.getProject());
        }
        return this.b.createPath();
    }

    @Override // org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool
    public abstract void deploy() throws org.apache.tools.ant.BuildException;

    public org.apache.tools.ant.types.Path getClasspath() {
        return this.b;
    }

    public java.lang.String getPassword() {
        return this.d;
    }

    public java.lang.String getServer() {
        return this.e;
    }

    public org.apache.tools.ant.taskdefs.optional.j2ee.ServerDeploy getTask() {
        return this.a;
    }

    public java.lang.String getUserName() {
        return this.c;
    }

    public abstract boolean isActionValid();

    public void setClasspath(org.apache.tools.ant.types.Path path) {
        this.b = path;
    }

    public void setPassword(java.lang.String str) {
        this.d = str;
    }

    public void setServer(java.lang.String str) {
        this.e = str;
    }

    @Override // org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool
    public void setTask(org.apache.tools.ant.taskdefs.optional.j2ee.ServerDeploy serverDeploy) {
        this.a = serverDeploy;
    }

    public void setUserName(java.lang.String str) {
        this.c = str;
    }

    @Override // org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool
    public void validateAttributes() throws org.apache.tools.ant.BuildException {
        if (this.a.getAction() == null) {
            throw new org.apache.tools.ant.BuildException("The \"action\" attribute must be set");
        }
        if (isActionValid()) {
            if (this.b == null) {
                throw new org.apache.tools.ant.BuildException("The classpath attribute must be set");
            }
        } else {
            throw new org.apache.tools.ant.BuildException("Invalid action \"" + this.a.getAction() + "\" passed");
        }
    }
}
