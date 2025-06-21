package org.apache.tools.ant.taskdefs.optional.j2ee;

/* loaded from: classes25.dex */
public class GenericHotDeploymentTool extends org.apache.tools.ant.taskdefs.optional.j2ee.AbstractHotDeploymentTool {
    public static final java.lang.String[] h = {org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_DEPLOY};
    public org.apache.tools.ant.taskdefs.Java f;
    public java.lang.String g;

    public org.apache.tools.ant.types.Commandline.Argument createArg() {
        return this.f.createArg();
    }

    public org.apache.tools.ant.types.Commandline.Argument createJvmarg() {
        return this.f.createJvmarg();
    }

    @Override // org.apache.tools.ant.taskdefs.optional.j2ee.AbstractHotDeploymentTool, org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool
    public void deploy() throws org.apache.tools.ant.BuildException {
        this.f.setClassname(this.g);
        this.f.setClasspath(getClasspath());
        this.f.setFork(true);
        this.f.setFailonerror(true);
        this.f.execute();
    }

    public java.lang.String getClassName() {
        return this.g;
    }

    public org.apache.tools.ant.taskdefs.Java getJava() {
        return this.f;
    }

    @Override // org.apache.tools.ant.taskdefs.optional.j2ee.AbstractHotDeploymentTool
    public boolean isActionValid() {
        return getTask().getAction().equals(h[0]);
    }

    public void setClassName(java.lang.String str) {
        this.g = str;
    }

    @Override // org.apache.tools.ant.taskdefs.optional.j2ee.AbstractHotDeploymentTool, org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool
    public void setTask(org.apache.tools.ant.taskdefs.optional.j2ee.ServerDeploy serverDeploy) {
        super.setTask(serverDeploy);
        this.f = new org.apache.tools.ant.taskdefs.Java(serverDeploy);
    }

    @Override // org.apache.tools.ant.taskdefs.optional.j2ee.AbstractHotDeploymentTool, org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool
    public void validateAttributes() throws org.apache.tools.ant.BuildException {
        super.validateAttributes();
        if (this.g == null) {
            throw new org.apache.tools.ant.BuildException("The classname attribute must be set");
        }
    }
}
