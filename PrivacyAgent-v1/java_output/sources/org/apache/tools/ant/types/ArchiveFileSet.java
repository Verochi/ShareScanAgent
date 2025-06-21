package org.apache.tools.ant.types;

/* loaded from: classes26.dex */
public abstract class ArchiveFileSet extends org.apache.tools.ant.types.FileSet {
    public static final int DEFAULT_DIR_MODE = 16877;
    public static final int DEFAULT_FILE_MODE = 33188;
    public org.apache.tools.ant.types.Resource D;
    public java.lang.String E;
    public java.lang.String F;
    public boolean G;
    public int H;
    public int I;
    public boolean J;
    public boolean K;
    public boolean L;
    public java.lang.String M;

    public ArchiveFileSet() {
        this.D = null;
        this.E = "";
        this.F = "";
        this.G = false;
        this.H = 33188;
        this.I = 16877;
        this.J = false;
        this.K = false;
        this.L = true;
        this.M = null;
    }

    public ArchiveFileSet(org.apache.tools.ant.types.ArchiveFileSet archiveFileSet) {
        super(archiveFileSet);
        this.D = null;
        this.E = "";
        this.F = "";
        this.G = false;
        this.H = 33188;
        this.I = 16877;
        this.J = false;
        this.K = false;
        this.L = true;
        this.M = null;
        this.D = archiveFileSet.D;
        this.E = archiveFileSet.E;
        this.F = archiveFileSet.F;
        this.G = archiveFileSet.G;
        this.H = archiveFileSet.H;
        this.I = archiveFileSet.I;
        this.J = archiveFileSet.J;
        this.K = archiveFileSet.K;
        this.L = archiveFileSet.L;
        this.M = archiveFileSet.M;
    }

    public ArchiveFileSet(org.apache.tools.ant.types.FileSet fileSet) {
        super(fileSet);
        this.D = null;
        this.E = "";
        this.F = "";
        this.G = false;
        this.H = 33188;
        this.I = 16877;
        this.J = false;
        this.K = false;
        this.L = true;
        this.M = null;
    }

    public void addConfigured(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        checkChildrenAllowed();
        if (resourceCollection.size() != 1) {
            throw new org.apache.tools.ant.BuildException("only single argument resource collections are supported as archives");
        }
        setSrcResource(resourceCollection.iterator().next());
    }

    public final void c() {
        if (getProject() == null || (isReference() && (getRefid().getReferencedObject(getProject()) instanceof org.apache.tools.ant.types.ArchiveFileSet))) {
            checkAttributesAllowed();
        }
    }

    @Override // org.apache.tools.ant.types.FileSet, org.apache.tools.ant.types.AbstractFileSet, org.apache.tools.ant.types.DataType, org.apache.tools.ant.ProjectComponent
    public java.lang.Object clone() {
        return isReference() ? ((org.apache.tools.ant.types.ArchiveFileSet) getCheckedRef(org.apache.tools.ant.types.ArchiveFileSet.class, getDataTypeName(), getProject())).clone() : super.clone();
    }

    public void configureFileSet(org.apache.tools.ant.types.ArchiveFileSet archiveFileSet) {
        archiveFileSet.setPrefix(this.E);
        archiveFileSet.setFullpath(this.F);
        archiveFileSet.J = this.J;
        archiveFileSet.H = this.H;
        archiveFileSet.K = this.K;
        archiveFileSet.I = this.I;
    }

    @Override // org.apache.tools.ant.types.AbstractFileSet, org.apache.tools.ant.types.DataType
    public synchronized void dieOnCircularReference(java.util.Stack<java.lang.Object> stack, org.apache.tools.ant.Project project) throws org.apache.tools.ant.BuildException {
        if (isChecked()) {
            return;
        }
        super.dieOnCircularReference(stack, project);
        if (!isReference()) {
            org.apache.tools.ant.types.Resource resource = this.D;
            if (resource != null) {
                org.apache.tools.ant.types.DataType.pushAndInvokeCircularReferenceCheck(resource, stack, project);
            }
            setChecked(true);
        }
    }

    @Override // org.apache.tools.ant.types.DataType
    public java.lang.Object getCheckedRef(org.apache.tools.ant.Project project) {
        return getRef(project);
    }

    public int getDirMode() {
        return this.I;
    }

    public int getDirMode(org.apache.tools.ant.Project project) {
        if (isReference()) {
            return ((org.apache.tools.ant.types.ArchiveFileSet) getRef(project)).getDirMode(project);
        }
        dieOnCircularReference();
        return this.I;
    }

    @Override // org.apache.tools.ant.types.AbstractFileSet
    public org.apache.tools.ant.DirectoryScanner getDirectoryScanner(org.apache.tools.ant.Project project) {
        if (isReference()) {
            return getRef(project).getDirectoryScanner(project);
        }
        dieOnCircularReference();
        org.apache.tools.ant.types.Resource resource = this.D;
        if (resource == null) {
            return super.getDirectoryScanner(project);
        }
        if (!resource.isExists() && this.L) {
            throw new org.apache.tools.ant.BuildException("The archive " + this.D.getName() + " doesn't exist");
        }
        if (this.D.isDirectory()) {
            throw new org.apache.tools.ant.BuildException("The archive " + this.D.getName() + " can't be a directory");
        }
        org.apache.tools.ant.types.ArchiveScanner newArchiveScanner = newArchiveScanner();
        newArchiveScanner.setErrorOnMissingArchive(this.L);
        newArchiveScanner.setSrc(this.D);
        super.setDir(project.getBaseDir());
        setupDirectoryScanner(newArchiveScanner, project);
        newArchiveScanner.init();
        return newArchiveScanner;
    }

    public java.lang.String getEncoding() {
        if (!isReference()) {
            return this.M;
        }
        org.apache.tools.ant.types.AbstractFileSet ref = getRef(getProject());
        if (ref instanceof org.apache.tools.ant.types.ArchiveFileSet) {
            return ((org.apache.tools.ant.types.ArchiveFileSet) ref).getEncoding();
        }
        return null;
    }

    public int getFileMode() {
        return this.H;
    }

    public int getFileMode(org.apache.tools.ant.Project project) {
        if (isReference()) {
            return ((org.apache.tools.ant.types.ArchiveFileSet) getRef(project)).getFileMode(project);
        }
        dieOnCircularReference();
        return this.H;
    }

    public java.lang.String getFullpath() {
        return this.F;
    }

    public java.lang.String getFullpath(org.apache.tools.ant.Project project) {
        if (isReference()) {
            return ((org.apache.tools.ant.types.ArchiveFileSet) getRef(project)).getFullpath(project);
        }
        dieOnCircularReference(project);
        return this.F;
    }

    public java.lang.String getPrefix() {
        return this.E;
    }

    public java.lang.String getPrefix(org.apache.tools.ant.Project project) {
        if (isReference()) {
            return ((org.apache.tools.ant.types.ArchiveFileSet) getRef(project)).getPrefix(project);
        }
        dieOnCircularReference(project);
        return this.E;
    }

    public java.io.File getSrc() {
        org.apache.tools.ant.types.resources.FileProvider fileProvider;
        if (isReference()) {
            return ((org.apache.tools.ant.types.ArchiveFileSet) getCheckedRef()).getSrc();
        }
        dieOnCircularReference();
        org.apache.tools.ant.types.Resource resource = this.D;
        if (resource == null || (fileProvider = (org.apache.tools.ant.types.resources.FileProvider) resource.as(org.apache.tools.ant.types.resources.FileProvider.class)) == null) {
            return null;
        }
        return fileProvider.getFile();
    }

    public java.io.File getSrc(org.apache.tools.ant.Project project) {
        return isReference() ? ((org.apache.tools.ant.types.ArchiveFileSet) getRef(project)).getSrc(project) : getSrc();
    }

    public boolean hasDirModeBeenSet() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.ArchiveFileSet) getRef(getProject())).hasDirModeBeenSet();
        }
        dieOnCircularReference();
        return this.K;
    }

    public boolean hasFileModeBeenSet() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.ArchiveFileSet) getRef(getProject())).hasFileModeBeenSet();
        }
        dieOnCircularReference();
        return this.J;
    }

    public void integerSetDirMode(int i) {
        this.K = true;
        this.I = i | 16384;
    }

    public void integerSetFileMode(int i) {
        this.J = true;
        this.H = i | 32768;
    }

    @Override // org.apache.tools.ant.types.FileSet, org.apache.tools.ant.types.ResourceCollection
    public boolean isFilesystemOnly() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.ArchiveFileSet) getCheckedRef()).isFilesystemOnly();
        }
        dieOnCircularReference();
        return this.D == null;
    }

    @Override // org.apache.tools.ant.types.FileSet, org.apache.tools.ant.types.ResourceCollection, java.lang.Iterable
    public java.util.Iterator<org.apache.tools.ant.types.Resource> iterator() {
        return isReference() ? ((org.apache.tools.ant.types.ResourceCollection) getRef(getProject())).iterator() : this.D == null ? super.iterator() : ((org.apache.tools.ant.types.ArchiveScanner) getDirectoryScanner(getProject())).y(getProject());
    }

    public abstract org.apache.tools.ant.types.ArchiveScanner newArchiveScanner();

    @Override // org.apache.tools.ant.types.AbstractFileSet
    public void setDir(java.io.File file) throws org.apache.tools.ant.BuildException {
        checkAttributesAllowed();
        if (this.D != null) {
            throw new org.apache.tools.ant.BuildException("Cannot set both dir and src attributes");
        }
        super.setDir(file);
        this.G = true;
    }

    public void setDirMode(java.lang.String str) {
        c();
        integerSetDirMode(java.lang.Integer.parseInt(str, 8));
    }

    public void setEncoding(java.lang.String str) {
        checkAttributesAllowed();
        this.M = str;
    }

    public void setErrorOnMissingArchive(boolean z) {
        checkAttributesAllowed();
        this.L = z;
    }

    public void setFileMode(java.lang.String str) {
        c();
        integerSetFileMode(java.lang.Integer.parseInt(str, 8));
    }

    public void setFullpath(java.lang.String str) {
        c();
        if (!"".equals(this.E) && !"".equals(str)) {
            throw new org.apache.tools.ant.BuildException("Cannot set both fullpath and prefix attributes");
        }
        this.F = str;
    }

    public void setPrefix(java.lang.String str) {
        c();
        if (!"".equals(str) && !"".equals(this.F)) {
            throw new org.apache.tools.ant.BuildException("Cannot set both fullpath and prefix attributes");
        }
        this.E = str;
    }

    public void setSrc(java.io.File file) {
        setSrcResource(new org.apache.tools.ant.types.resources.FileResource(file));
    }

    public void setSrcResource(org.apache.tools.ant.types.Resource resource) {
        c();
        if (this.G) {
            throw new org.apache.tools.ant.BuildException("Cannot set both dir and src attributes");
        }
        this.D = resource;
        setChecked(false);
    }

    @Override // org.apache.tools.ant.types.FileSet, org.apache.tools.ant.types.ResourceCollection
    public int size() {
        return isReference() ? ((org.apache.tools.ant.types.ResourceCollection) getRef(getProject())).size() : this.D == null ? super.size() : ((org.apache.tools.ant.types.ArchiveScanner) getDirectoryScanner(getProject())).getIncludedFilesCount();
    }

    @Override // org.apache.tools.ant.types.AbstractFileSet, org.apache.tools.ant.types.DataType
    public java.lang.String toString() {
        if (this.G && getProject() != null) {
            return super.toString();
        }
        org.apache.tools.ant.types.Resource resource = this.D;
        if (resource == null) {
            return null;
        }
        return resource.getName();
    }
}
