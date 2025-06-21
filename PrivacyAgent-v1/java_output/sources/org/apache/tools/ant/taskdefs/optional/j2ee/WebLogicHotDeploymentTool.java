package org.apache.tools.ant.taskdefs.optional.j2ee;

/* loaded from: classes25.dex */
public class WebLogicHotDeploymentTool extends org.apache.tools.ant.taskdefs.optional.j2ee.AbstractHotDeploymentTool {
    public static final java.lang.String[] i = {"delete", org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_DEPLOY, org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_LIST, org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_UNDEPLOY, "update"};
    public boolean f;
    public java.lang.String g;
    public java.lang.String h;

    public java.lang.StringBuffer buildArgsPrefix() {
        java.lang.String str;
        org.apache.tools.ant.taskdefs.optional.j2ee.ServerDeploy task = getTask();
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(1024);
        java.lang.String str2 = "";
        if (getServer() != null) {
            str = "-url " + getServer();
        } else {
            str = "";
        }
        stringBuffer.append(str);
        stringBuffer.append(" ");
        stringBuffer.append(this.f ? "-debug " : "");
        if (getUserName() != null) {
            str2 = "-username " + getUserName();
        }
        stringBuffer.append(str2);
        stringBuffer.append(" ");
        stringBuffer.append(task.getAction());
        stringBuffer.append(" ");
        stringBuffer.append(getPassword());
        stringBuffer.append(" ");
        return stringBuffer;
    }

    public java.lang.String buildDeployArgs() {
        java.lang.StringBuffer buildArgsPrefix = buildArgsPrefix();
        buildArgsPrefix.append(this.g);
        buildArgsPrefix.append(" ");
        buildArgsPrefix.append(getTask().getSource());
        java.lang.String stringBuffer = buildArgsPrefix.toString();
        if (this.h == null) {
            return stringBuffer;
        }
        return "-component " + this.h + " " + stringBuffer;
    }

    public java.lang.String buildListArgs() {
        return buildArgsPrefix().toString();
    }

    public java.lang.String buildUndeployArgs() {
        java.lang.StringBuffer buildArgsPrefix = buildArgsPrefix();
        buildArgsPrefix.append(this.g);
        buildArgsPrefix.append(" ");
        return buildArgsPrefix.toString();
    }

    @Override // org.apache.tools.ant.taskdefs.optional.j2ee.AbstractHotDeploymentTool, org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool
    public void deploy() {
        org.apache.tools.ant.taskdefs.Java java = new org.apache.tools.ant.taskdefs.Java(getTask());
        java.setFork(true);
        java.setFailonerror(true);
        java.setClasspath(getClasspath());
        java.setClassname("weblogic.deploy");
        java.createArg().setLine(getArguments());
        java.execute();
    }

    public java.lang.String getArguments() throws org.apache.tools.ant.BuildException {
        java.lang.String action = getTask().getAction();
        if (action.equals(org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_DEPLOY) || action.equals("update")) {
            return buildDeployArgs();
        }
        if (action.equals("delete") || action.equals(org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_UNDEPLOY)) {
            return buildUndeployArgs();
        }
        if (action.equals(org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_LIST)) {
            return buildListArgs();
        }
        return null;
    }

    @Override // org.apache.tools.ant.taskdefs.optional.j2ee.AbstractHotDeploymentTool
    public boolean isActionValid() {
        java.lang.String action = getTask().getAction();
        int i2 = 0;
        while (true) {
            java.lang.String[] strArr = i;
            if (i2 >= strArr.length) {
                return false;
            }
            if (action.equals(strArr[i2])) {
                return true;
            }
            i2++;
        }
    }

    public void setApplication(java.lang.String str) {
        this.g = str;
    }

    public void setComponent(java.lang.String str) {
        this.h = str;
    }

    public void setDebug(boolean z) {
        this.f = z;
    }

    @Override // org.apache.tools.ant.taskdefs.optional.j2ee.AbstractHotDeploymentTool, org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool
    public void validateAttributes() throws org.apache.tools.ant.BuildException {
        super.validateAttributes();
        java.lang.String action = getTask().getAction();
        if (getPassword() == null) {
            throw new org.apache.tools.ant.BuildException("The password attribute must be set.");
        }
        if ((action.equals(org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_DEPLOY) || action.equals("update")) && this.g == null) {
            throw new org.apache.tools.ant.BuildException("The application attribute must be set if action = " + action);
        }
        if ((action.equals(org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_DEPLOY) || action.equals("update")) && getTask().getSource() == null) {
            throw new org.apache.tools.ant.BuildException("The source attribute must be set if action = " + action);
        }
        if ((action.equals("delete") || action.equals(org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_UNDEPLOY)) && this.g == null) {
            throw new org.apache.tools.ant.BuildException("The application attribute must be set if action = " + action);
        }
    }
}
