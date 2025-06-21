package org.apache.tools.ant.types.resources;

/* loaded from: classes26.dex */
public class FileResource extends org.apache.tools.ant.types.Resource implements org.apache.tools.ant.types.resources.Touchable, org.apache.tools.ant.types.resources.FileProvider, org.apache.tools.ant.types.ResourceFactory, org.apache.tools.ant.types.resources.Appendable {
    public static final org.apache.tools.ant.util.FileUtils A = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public static final int B = org.apache.tools.ant.types.Resource.getMagicNumber("null file".getBytes());
    public java.io.File y;
    public java.io.File z;

    public FileResource() {
    }

    public FileResource(java.io.File file) {
        setFile(file);
    }

    public FileResource(java.io.File file, java.lang.String str) {
        this.z = file;
        this.y = A.resolveFile(file, str);
    }

    public FileResource(org.apache.tools.ant.Project project, java.io.File file) {
        this(file);
        setProject(project);
    }

    public FileResource(org.apache.tools.ant.Project project, java.lang.String str) {
        this(project, project.resolveFile(str));
    }

    public final java.io.OutputStream b(boolean z) throws java.io.IOException {
        java.io.File notNullFile = getNotNullFile();
        if (!notNullFile.exists()) {
            java.io.File parentFile = notNullFile.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                parentFile.mkdirs();
            }
        } else if (notNullFile.isFile() && !z) {
            notNullFile.delete();
        }
        return z ? new java.io.FileOutputStream(notNullFile.getAbsolutePath(), true) : new java.io.FileOutputStream(notNullFile);
    }

    @Override // org.apache.tools.ant.types.Resource, java.lang.Comparable
    public int compareTo(org.apache.tools.ant.types.Resource resource) {
        if (isReference()) {
            return ((org.apache.tools.ant.types.Resource) getCheckedRef()).compareTo(resource);
        }
        if (equals(resource)) {
            return 0;
        }
        org.apache.tools.ant.types.resources.FileProvider fileProvider = (org.apache.tools.ant.types.resources.FileProvider) resource.as(org.apache.tools.ant.types.resources.FileProvider.class);
        if (fileProvider == null) {
            return super.compareTo(resource);
        }
        java.io.File file = getFile();
        if (file == null) {
            return -1;
        }
        java.io.File file2 = fileProvider.getFile();
        if (file2 == null) {
            return 1;
        }
        int compareTo = file.compareTo(file2);
        return compareTo != 0 ? compareTo : getName().compareTo(resource.getName());
    }

    @Override // org.apache.tools.ant.types.Resource
    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (isReference()) {
            return getCheckedRef().equals(obj);
        }
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        org.apache.tools.ant.types.resources.FileResource fileResource = (org.apache.tools.ant.types.resources.FileResource) obj;
        if (getFile() == null) {
            if (fileResource.getFile() == null) {
                return true;
            }
        } else if (getFile().equals(fileResource.getFile()) && getName().equals(fileResource.getName())) {
            return true;
        }
        return false;
    }

    @Override // org.apache.tools.ant.types.resources.Appendable
    public java.io.OutputStream getAppendOutputStream() throws java.io.IOException {
        return isReference() ? ((org.apache.tools.ant.types.resources.FileResource) getCheckedRef()).getAppendOutputStream() : b(true);
    }

    public java.io.File getBaseDir() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.resources.FileResource) getCheckedRef()).getBaseDir();
        }
        dieOnCircularReference();
        return this.z;
    }

    @Override // org.apache.tools.ant.types.resources.FileProvider
    public java.io.File getFile() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.resources.FileResource) getCheckedRef()).getFile();
        }
        dieOnCircularReference();
        synchronized (this) {
            if (this.y == null) {
                java.io.File baseDir = getBaseDir();
                java.lang.String name = super.getName();
                if (name != null) {
                    setFile(A.resolveFile(baseDir, name));
                }
            }
        }
        return this.y;
    }

    @Override // org.apache.tools.ant.types.Resource
    public java.io.InputStream getInputStream() throws java.io.IOException {
        return isReference() ? ((org.apache.tools.ant.types.Resource) getCheckedRef()).getInputStream() : new java.io.FileInputStream(getNotNullFile());
    }

    @Override // org.apache.tools.ant.types.Resource
    public long getLastModified() {
        return isReference() ? ((org.apache.tools.ant.types.Resource) getCheckedRef()).getLastModified() : getNotNullFile().lastModified();
    }

    @Override // org.apache.tools.ant.types.Resource
    public java.lang.String getName() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.Resource) getCheckedRef()).getName();
        }
        java.io.File baseDir = getBaseDir();
        return baseDir == null ? getNotNullFile().getName() : A.removeLeadingPath(baseDir, getNotNullFile());
    }

    public java.io.File getNotNullFile() {
        if (getFile() == null) {
            throw new org.apache.tools.ant.BuildException("file attribute is null!");
        }
        dieOnCircularReference();
        return getFile();
    }

    @Override // org.apache.tools.ant.types.Resource
    public java.io.OutputStream getOutputStream() throws java.io.IOException {
        return isReference() ? ((org.apache.tools.ant.types.resources.FileResource) getCheckedRef()).getOutputStream() : b(false);
    }

    @Override // org.apache.tools.ant.types.ResourceFactory
    public org.apache.tools.ant.types.Resource getResource(java.lang.String str) {
        org.apache.tools.ant.util.FileUtils fileUtils = A;
        java.io.File resolveFile = fileUtils.resolveFile(getFile(), str);
        org.apache.tools.ant.types.resources.FileResource fileResource = new org.apache.tools.ant.types.resources.FileResource(resolveFile);
        if (fileUtils.isLeadingPath(getBaseDir(), resolveFile)) {
            fileResource.setBaseDir(getBaseDir());
        }
        return fileResource;
    }

    @Override // org.apache.tools.ant.types.Resource
    public long getSize() {
        return isReference() ? ((org.apache.tools.ant.types.Resource) getCheckedRef()).getSize() : getNotNullFile().length();
    }

    @Override // org.apache.tools.ant.types.Resource
    public int hashCode() {
        if (isReference()) {
            return getCheckedRef().hashCode();
        }
        return org.apache.tools.ant.types.Resource.MAGIC * (getFile() == null ? B : getFile().hashCode());
    }

    @Override // org.apache.tools.ant.types.Resource
    public boolean isDirectory() {
        return isReference() ? ((org.apache.tools.ant.types.Resource) getCheckedRef()).isDirectory() : getNotNullFile().isDirectory();
    }

    @Override // org.apache.tools.ant.types.Resource
    public boolean isExists() {
        return isReference() ? ((org.apache.tools.ant.types.Resource) getCheckedRef()).isExists() : getNotNullFile().exists();
    }

    @Override // org.apache.tools.ant.types.Resource, org.apache.tools.ant.types.ResourceCollection
    public boolean isFilesystemOnly() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.resources.FileResource) getCheckedRef()).isFilesystemOnly();
        }
        dieOnCircularReference();
        return true;
    }

    public void setBaseDir(java.io.File file) {
        checkAttributesAllowed();
        this.z = file;
    }

    public void setFile(java.io.File file) {
        checkAttributesAllowed();
        this.y = file;
        if (file != null) {
            if (getBaseDir() == null || !A.isLeadingPath(getBaseDir(), file)) {
                setBaseDir(file.getParentFile());
            }
        }
    }

    @Override // org.apache.tools.ant.types.Resource, org.apache.tools.ant.types.DataType
    public void setRefid(org.apache.tools.ant.types.Reference reference) {
        if (this.y != null || this.z != null) {
            throw tooManyAttributes();
        }
        super.setRefid(reference);
    }

    @Override // org.apache.tools.ant.types.Resource, org.apache.tools.ant.types.DataType
    public java.lang.String toString() {
        if (isReference()) {
            return getCheckedRef().toString();
        }
        java.io.File file = this.y;
        if (file == null) {
            return "(unbound file resource)";
        }
        return A.normalize(file.getAbsolutePath()).getAbsolutePath();
    }

    @Override // org.apache.tools.ant.types.resources.Touchable
    public void touch(long j) {
        if (isReference()) {
            ((org.apache.tools.ant.types.resources.FileResource) getCheckedRef()).touch(j);
        } else {
            if (getNotNullFile().setLastModified(j)) {
                return;
            }
            log("Failed to change file modification time", 1);
        }
    }
}
