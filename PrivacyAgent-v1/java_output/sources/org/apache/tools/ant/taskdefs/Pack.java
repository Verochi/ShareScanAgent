package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public abstract class Pack extends org.apache.tools.ant.Task {
    protected java.io.File source;
    public org.apache.tools.ant.types.Resource u;
    protected java.io.File zipFile;

    public void addConfigured(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        if (resourceCollection.size() == 0) {
            throw new org.apache.tools.ant.BuildException("No resource selected, " + getTaskName() + " needs exactly one resource.");
        }
        if (resourceCollection.size() == 1) {
            setSrcResource(resourceCollection.iterator().next());
            return;
        }
        throw new org.apache.tools.ant.BuildException(getTaskName() + " cannot handle multiple resources at once. (" + resourceCollection.size() + " resources were selected.)");
    }

    public final void c(java.io.InputStream inputStream, java.io.OutputStream outputStream) throws java.io.IOException {
        byte[] bArr = new byte[8192];
        int i = 0;
        do {
            outputStream.write(bArr, 0, i);
            i = inputStream.read(bArr, 0, 8192);
        } while (i != -1);
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        validate();
        org.apache.tools.ant.types.Resource srcResource = getSrcResource();
        if (!srcResource.isExists()) {
            log("Nothing to do: " + srcResource.toString() + " doesn't exist.");
            return;
        }
        if (this.zipFile.lastModified() < srcResource.getLastModified()) {
            log("Building: " + this.zipFile.getAbsolutePath());
            pack();
            return;
        }
        log("Nothing to do: " + this.zipFile.getAbsolutePath() + " is up to date.");
    }

    public org.apache.tools.ant.types.Resource getSrcResource() {
        return this.u;
    }

    public abstract void pack();

    public void setDestfile(java.io.File file) {
        setZipfile(file);
    }

    public void setSrc(java.io.File file) {
        setSrcResource(new org.apache.tools.ant.types.resources.FileResource(file));
    }

    public void setSrcResource(org.apache.tools.ant.types.Resource resource) {
        if (resource.isDirectory()) {
            throw new org.apache.tools.ant.BuildException("the source can't be a directory");
        }
        org.apache.tools.ant.types.resources.FileProvider fileProvider = (org.apache.tools.ant.types.resources.FileProvider) resource.as(org.apache.tools.ant.types.resources.FileProvider.class);
        if (fileProvider != null) {
            this.source = fileProvider.getFile();
        } else if (!supportsNonFileResources()) {
            throw new org.apache.tools.ant.BuildException("Only FileSystem resources are supported.");
        }
        this.u = resource;
    }

    public void setZipfile(java.io.File file) {
        this.zipFile = file;
    }

    public boolean supportsNonFileResources() {
        return false;
    }

    public final void validate() throws org.apache.tools.ant.BuildException {
        java.io.File file = this.zipFile;
        if (file == null) {
            throw new org.apache.tools.ant.BuildException("zipfile attribute is required", getLocation());
        }
        if (file.isDirectory()) {
            throw new org.apache.tools.ant.BuildException("zipfile attribute must not represent a directory!", getLocation());
        }
        if (getSrcResource() == null) {
            throw new org.apache.tools.ant.BuildException("src attribute or nested resource is required", getLocation());
        }
    }

    public void zipFile(java.io.File file, java.io.OutputStream outputStream) throws java.io.IOException {
        zipResource(new org.apache.tools.ant.types.resources.FileResource(file), outputStream);
    }

    public void zipResource(org.apache.tools.ant.types.Resource resource, java.io.OutputStream outputStream) throws java.io.IOException {
        java.io.InputStream inputStream = resource.getInputStream();
        try {
            c(inputStream, outputStream);
        } finally {
            inputStream.close();
        }
    }
}
