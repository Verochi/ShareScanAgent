package org.apache.tools.ant.taskdefs.optional.j2ee;

/* loaded from: classes25.dex */
public class JonasHotDeploymentTool extends org.apache.tools.ant.taskdefs.optional.j2ee.GenericHotDeploymentTool {
    protected static final java.lang.String DEFAULT_ORB = "RMI";
    public static final java.lang.String[] m = {"delete", org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_DEPLOY, org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_LIST, org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_UNDEPLOY, "update"};
    public java.io.File i;
    public java.lang.String j = null;
    public java.lang.String k;
    public int l;

    @Override // org.apache.tools.ant.taskdefs.optional.j2ee.AbstractHotDeploymentTool
    public org.apache.tools.ant.types.Path getClasspath() {
        org.apache.tools.ant.types.Path classpath = super.getClasspath();
        if (classpath == null) {
            classpath = new org.apache.tools.ant.types.Path(getTask().getProject());
        }
        if (this.j != null) {
            java.lang.String file = new java.io.File(this.i, "lib/" + this.j + "_jonas.jar").toString();
            java.lang.String file2 = new java.io.File(this.i, "config/").toString();
            classpath.append(new org.apache.tools.ant.types.Path(classpath.getProject(), file + java.io.File.pathSeparator + file2));
        }
        return classpath;
    }

    @Override // org.apache.tools.ant.taskdefs.optional.j2ee.GenericHotDeploymentTool, org.apache.tools.ant.taskdefs.optional.j2ee.AbstractHotDeploymentTool
    public boolean isActionValid() {
        java.lang.String action = getTask().getAction();
        int i = 0;
        while (true) {
            java.lang.String[] strArr = m;
            if (i >= strArr.length) {
                return false;
            }
            if (action.equals(strArr[i])) {
                return true;
            }
            i++;
        }
    }

    public void setDavidhost(java.lang.String str) {
        this.k = str;
    }

    public void setDavidport(int i) {
        this.l = i;
    }

    public void setJonasroot(java.io.File file) {
        this.i = file;
    }

    public void setOrb(java.lang.String str) {
        this.j = str;
    }

    @Override // org.apache.tools.ant.taskdefs.optional.j2ee.GenericHotDeploymentTool, org.apache.tools.ant.taskdefs.optional.j2ee.AbstractHotDeploymentTool, org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool
    public void validateAttributes() throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.taskdefs.Java java = getJava();
        java.lang.String action = getTask().getAction();
        if (action == null) {
            throw new org.apache.tools.ant.BuildException("The \"action\" attribute must be set");
        }
        if (!isActionValid()) {
            throw new org.apache.tools.ant.BuildException("Invalid action \"" + action + "\" passed");
        }
        if (getClassName() == null) {
            setClassName("org.objectweb.jonas.adm.JonasAdmin");
        }
        java.io.File file = this.i;
        if (file == null || file.isDirectory()) {
            java.createJvmarg().setValue("-Dinstall.root=" + this.i);
            java.createJvmarg().setValue("-Djava.security.policy=" + this.i + "/config/java.policy");
            if ("DAVID".equals(this.j)) {
                java.createJvmarg().setValue("-Dorg.omg.CORBA.ORBClass=org.objectweb.david.libs.binding.orbs.iiop.IIOPORB");
                java.createJvmarg().setValue("-Dorg.omg.CORBA.ORBSingletonClass=org.objectweb.david.libs.binding.orbs.ORBSingletonClass");
                java.createJvmarg().setValue("-Djavax.rmi.CORBA.StubClass=org.objectweb.david.libs.stub_factories.rmi.StubDelegate");
                java.createJvmarg().setValue("-Djavax.rmi.CORBA.PortableRemoteObjectClass=org.objectweb.david.libs.binding.rmi.ORBPortableRemoteObjectDelegate");
                java.createJvmarg().setValue("-Djavax.rmi.CORBA.UtilClass=org.objectweb.david.libs.helpers.RMIUtilDelegate");
                java.createJvmarg().setValue("-Ddavid.CosNaming.default_method=0");
                java.createJvmarg().setValue("-Ddavid.rmi.ValueHandlerClass=com.sun.corba.se.internal.io.ValueHandlerImpl");
                if (this.k != null) {
                    java.createJvmarg().setValue("-Ddavid.CosNaming.default_host=" + this.k);
                }
                if (this.l != 0) {
                    java.createJvmarg().setValue("-Ddavid.CosNaming.default_port=" + this.l);
                }
            }
        }
        if (getServer() != null) {
            java.createArg().setLine("-n " + getServer());
        }
        if (action.equals(org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_DEPLOY) || action.equals("update") || action.equals("redeploy")) {
            java.createArg().setLine("-a " + getTask().getSource());
            return;
        }
        if (!action.equals("delete") && !action.equals(org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_UNDEPLOY)) {
            if (action.equals(org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_LIST)) {
                java.createArg().setValue("-l");
            }
        } else {
            java.createArg().setLine("-r " + getTask().getSource());
        }
    }
}
