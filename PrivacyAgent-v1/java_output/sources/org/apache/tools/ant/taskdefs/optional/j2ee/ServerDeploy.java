package org.apache.tools.ant.taskdefs.optional.j2ee;

/* loaded from: classes25.dex */
public class ServerDeploy extends org.apache.tools.ant.Task {
    public java.lang.String u;
    public java.io.File v;
    public java.util.Vector w = new java.util.Vector();

    public void addGeneric(org.apache.tools.ant.taskdefs.optional.j2ee.GenericHotDeploymentTool genericHotDeploymentTool) {
        genericHotDeploymentTool.setTask(this);
        this.w.addElement(genericHotDeploymentTool);
    }

    public void addJonas(org.apache.tools.ant.taskdefs.optional.j2ee.JonasHotDeploymentTool jonasHotDeploymentTool) {
        jonasHotDeploymentTool.setTask(this);
        this.w.addElement(jonasHotDeploymentTool);
    }

    public void addWeblogic(org.apache.tools.ant.taskdefs.optional.j2ee.WebLogicHotDeploymentTool webLogicHotDeploymentTool) {
        webLogicHotDeploymentTool.setTask(this);
        this.w.addElement(webLogicHotDeploymentTool);
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        java.util.Enumeration elements = this.w.elements();
        while (elements.hasMoreElements()) {
            org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool hotDeploymentTool = (org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool) elements.nextElement();
            hotDeploymentTool.validateAttributes();
            hotDeploymentTool.deploy();
        }
    }

    public java.lang.String getAction() {
        return this.u;
    }

    public java.io.File getSource() {
        return this.v;
    }

    public void setAction(java.lang.String str) {
        this.u = str;
    }

    public void setSource(java.io.File file) {
        this.v = file;
    }
}
