package org.apache.tools.ant.taskdefs.optional.ejb;

/* loaded from: classes25.dex */
public class JbossDeploymentTool extends org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool {
    protected static final java.lang.String JBOSS_CMP10D = "jaws.xml";
    protected static final java.lang.String JBOSS_CMP20D = "jbosscmp-jdbc.xml";
    protected static final java.lang.String JBOSS_DD = "jboss.xml";
    public java.lang.String B = ".jar";

    @Override // org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool
    public void addVendorFiles(java.util.Hashtable hashtable, java.lang.String str) {
        java.io.File file = new java.io.File(getConfig().b, str + JBOSS_DD);
        if (!file.exists()) {
            log("Unable to locate jboss deployment descriptor. It was expected to be in " + file.getPath(), 1);
            return;
        }
        hashtable.put("META-INF/jboss.xml", file);
        java.lang.String str2 = "2.0".equals(b().getCmpversion()) ? JBOSS_CMP20D : JBOSS_CMP10D;
        java.io.File file2 = new java.io.File(getConfig().b, str + str2);
        if (file2.exists()) {
            hashtable.put("META-INF/" + str2, file2);
            return;
        }
        log("Unable to locate jboss cmp descriptor. It was expected to be in " + file2.getPath(), 3);
    }

    public final org.apache.tools.ant.taskdefs.optional.ejb.EjbJar b() {
        return (org.apache.tools.ant.taskdefs.optional.ejb.EjbJar) getTask();
    }

    @Override // org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool
    public java.io.File getVendorOutputJarFile(java.lang.String str) {
        if (getDestDir() == null && b().getDestdir() == null) {
            throw new org.apache.tools.ant.BuildException("DestDir not specified");
        }
        if (getDestDir() == null) {
            return new java.io.File(b().getDestdir(), str + this.B);
        }
        return new java.io.File(getDestDir(), str + this.B);
    }

    public void setSuffix(java.lang.String str) {
        this.B = str;
    }

    @Override // org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool, org.apache.tools.ant.taskdefs.optional.ejb.EJBDeploymentTool
    public void validateConfigured() throws org.apache.tools.ant.BuildException {
    }
}
