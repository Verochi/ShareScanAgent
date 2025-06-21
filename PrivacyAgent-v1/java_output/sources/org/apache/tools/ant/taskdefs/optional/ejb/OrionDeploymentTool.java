package org.apache.tools.ant.taskdefs.optional.ejb;

/* loaded from: classes25.dex */
public class OrionDeploymentTool extends org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool {
    protected static final java.lang.String ORION_DD = "orion-ejb-jar.xml";
    public java.lang.String B = ".jar";

    @Override // org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool
    public void addVendorFiles(java.util.Hashtable hashtable, java.lang.String str) {
        if (usingBaseJarName()) {
            str = "";
        }
        java.io.File file = new java.io.File(getConfig().b, str + ORION_DD);
        if (file.exists()) {
            hashtable.put("META-INF/orion-ejb-jar.xml", file);
            return;
        }
        log("Unable to locate Orion deployment descriptor. It was expected to be in " + file.getPath(), 1);
    }

    @Override // org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool
    public java.io.File getVendorOutputJarFile(java.lang.String str) {
        return new java.io.File(getDestDir(), str + this.B);
    }
}
