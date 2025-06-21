package org.apache.tools.ant.taskdefs.optional.ejb;

/* loaded from: classes25.dex */
public class WeblogicTOPLinkDeploymentTool extends org.apache.tools.ant.taskdefs.optional.ejb.WeblogicDeploymentTool {
    public java.lang.String S;
    public java.lang.String T;

    @Override // org.apache.tools.ant.taskdefs.optional.ejb.WeblogicDeploymentTool, org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool
    public void addVendorFiles(java.util.Hashtable hashtable, java.lang.String str) {
        super.addVendorFiles(hashtable, str);
        java.io.File file = new java.io.File(getConfig().b, str + this.S);
        if (file.exists()) {
            hashtable.put("META-INF/" + this.S, file);
            return;
        }
        log("Unable to locate toplink deployment descriptor. It was expected to be in " + file.getPath(), 1);
    }

    @Override // org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool
    public org.apache.tools.ant.taskdefs.optional.ejb.DescriptorHandler getDescriptorHandler(java.io.File file) {
        org.apache.tools.ant.taskdefs.optional.ejb.DescriptorHandler descriptorHandler = super.getDescriptorHandler(file);
        java.lang.String str = this.T;
        if (str != null) {
            descriptorHandler.registerDTD("-//The Object People, Inc.//DTD TOPLink for WebLogic CMP 2.5.1//EN", str);
        } else {
            descriptorHandler.registerDTD("-//The Object People, Inc.//DTD TOPLink for WebLogic CMP 2.5.1//EN", "http://www.objectpeople.com/tlwl/dtd/toplink-cmp_2_5_1.dtd");
        }
        return descriptorHandler;
    }

    public void setToplinkdescriptor(java.lang.String str) {
        this.S = str;
    }

    public void setToplinkdtd(java.lang.String str) {
        this.T = str;
    }

    @Override // org.apache.tools.ant.taskdefs.optional.ejb.WeblogicDeploymentTool, org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool, org.apache.tools.ant.taskdefs.optional.ejb.EJBDeploymentTool
    public void validateConfigured() throws org.apache.tools.ant.BuildException {
        super.validateConfigured();
        if (this.S == null) {
            throw new org.apache.tools.ant.BuildException("The toplinkdescriptor attribute must be specified");
        }
    }
}
