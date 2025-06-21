package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public abstract class Unpack extends org.apache.tools.ant.Task {
    protected java.io.File dest;
    protected java.io.File source;
    protected org.apache.tools.ant.types.Resource srcResource;

    public void addConfigured(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        if (resourceCollection.size() != 1) {
            throw new org.apache.tools.ant.BuildException("only single argument resource collections are supported as archives");
        }
        setSrcResource(resourceCollection.iterator().next());
    }

    public final void c(java.lang.String str) {
        java.io.File file = this.source;
        java.lang.String d = file == null ? d(this.srcResource) : file.getName();
        int length = d.length();
        if (str == null || length <= str.length() || !str.equalsIgnoreCase(d.substring(length - str.length()))) {
            this.dest = new java.io.File(this.dest, d);
        } else {
            this.dest = new java.io.File(this.dest, d.substring(0, length - str.length()));
        }
    }

    public final java.lang.String d(org.apache.tools.ant.types.Resource resource) {
        java.lang.String name = resource.getName();
        int lastIndexOf = name.lastIndexOf(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
        return lastIndexOf < 0 ? name : name.substring(lastIndexOf + 1);
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        java.io.File file = this.dest;
        try {
            validate();
            extract();
        } finally {
            this.dest = file;
        }
    }

    public abstract void extract();

    public abstract java.lang.String getDefaultExtension();

    public void setDest(java.io.File file) {
        this.dest = file;
    }

    public void setDest(java.lang.String str) {
        log("DEPRECATED - The setDest(String) method has been deprecated. Use setDest(File) instead.");
        setDest(getProject().resolveFile(str));
    }

    public void setSrc(java.io.File file) {
        setSrcResource(new org.apache.tools.ant.types.resources.FileResource(file));
    }

    public void setSrc(java.lang.String str) {
        log("DEPRECATED - The setSrc(String) method has been deprecated. Use setSrc(File) instead.");
        setSrc(getProject().resolveFile(str));
    }

    public void setSrcResource(org.apache.tools.ant.types.Resource resource) {
        if (!resource.isExists()) {
            throw new org.apache.tools.ant.BuildException("the archive " + resource.getName() + " doesn't exist");
        }
        if (resource.isDirectory()) {
            throw new org.apache.tools.ant.BuildException("the archive " + resource.getName() + " can't be a directory");
        }
        org.apache.tools.ant.types.resources.FileProvider fileProvider = (org.apache.tools.ant.types.resources.FileProvider) resource.as(org.apache.tools.ant.types.resources.FileProvider.class);
        if (fileProvider != null) {
            this.source = fileProvider.getFile();
        } else if (!supportsNonFileResources()) {
            throw new org.apache.tools.ant.BuildException("The source " + resource.getName() + " is not a FileSystem Only FileSystem resources are supported.");
        }
        this.srcResource = resource;
    }

    public boolean supportsNonFileResources() {
        return false;
    }

    public final void validate() throws org.apache.tools.ant.BuildException {
        if (this.srcResource == null) {
            throw new org.apache.tools.ant.BuildException("No Src specified", getLocation());
        }
        if (this.dest == null) {
            if (this.source == null) {
                throw new org.apache.tools.ant.BuildException("dest is required when using a non-filesystem source", getLocation());
            }
            this.dest = new java.io.File(this.source.getParent());
        }
        if (this.dest.isDirectory()) {
            c(getDefaultExtension());
        }
    }
}
