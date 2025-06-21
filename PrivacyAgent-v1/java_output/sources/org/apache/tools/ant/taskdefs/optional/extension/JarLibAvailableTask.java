package org.apache.tools.ant.taskdefs.optional.extension;

/* loaded from: classes25.dex */
public class JarLibAvailableTask extends org.apache.tools.ant.Task {
    public java.io.File u;
    public final java.util.Vector v = new java.util.Vector();
    public java.lang.String w;
    public org.apache.tools.ant.taskdefs.optional.extension.ExtensionAdapter x;

    public void addConfiguredExtension(org.apache.tools.ant.taskdefs.optional.extension.ExtensionAdapter extensionAdapter) {
        if (this.x != null) {
            throw new org.apache.tools.ant.BuildException("Can not specify extension to search for multiple times.");
        }
        this.x = extensionAdapter;
    }

    public void addConfiguredExtensionSet(org.apache.tools.ant.taskdefs.optional.extension.ExtensionSet extensionSet) {
        this.v.addElement(extensionSet);
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        validate();
        org.apache.tools.ant.taskdefs.optional.extension.Extension b = this.x.b();
        if (this.v.isEmpty()) {
            for (org.apache.tools.ant.taskdefs.optional.extension.Extension extension : org.apache.tools.ant.taskdefs.optional.extension.Extension.getAvailable(org.apache.tools.ant.taskdefs.optional.extension.ExtensionUtil.e(this.u))) {
                if (extension.isCompatibleWith(b)) {
                    getProject().setNewProperty(this.w, com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE);
                }
            }
            return;
        }
        java.util.Iterator it = this.v.iterator();
        while (it.hasNext()) {
            for (org.apache.tools.ant.taskdefs.optional.extension.Extension extension2 : ((org.apache.tools.ant.taskdefs.optional.extension.ExtensionSet) it.next()).toExtensions(getProject())) {
                if (extension2.isCompatibleWith(b)) {
                    getProject().setNewProperty(this.w, com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE);
                }
            }
        }
    }

    public void setFile(java.io.File file) {
        this.u = file;
    }

    public void setProperty(java.lang.String str) {
        this.w = str;
    }

    public final void validate() throws org.apache.tools.ant.BuildException {
        if (this.x == null) {
            throw new org.apache.tools.ant.BuildException("Extension element must be specified.");
        }
        if (this.u == null && this.v.isEmpty()) {
            throw new org.apache.tools.ant.BuildException("File attribute not specified.");
        }
        java.io.File file = this.u;
        if (file != null && !file.exists()) {
            throw new org.apache.tools.ant.BuildException("File '" + this.u + "' does not exist.");
        }
        java.io.File file2 = this.u;
        if (file2 == null || file2.isFile()) {
            return;
        }
        throw new org.apache.tools.ant.BuildException("'" + this.u + "' is not a file.");
    }
}
