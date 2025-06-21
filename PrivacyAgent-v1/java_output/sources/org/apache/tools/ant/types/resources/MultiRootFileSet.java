package org.apache.tools.ant.types.resources;

/* loaded from: classes26.dex */
public class MultiRootFileSet extends org.apache.tools.ant.types.AbstractFileSet implements org.apache.tools.ant.types.ResourceCollection {
    public org.apache.tools.ant.types.resources.MultiRootFileSet.SetType D = org.apache.tools.ant.types.resources.MultiRootFileSet.SetType.file;
    public boolean E = true;
    public java.util.List<java.io.File> F = new java.util.ArrayList();
    public org.apache.tools.ant.types.resources.Union G;

    public enum SetType {
        file,
        dir,
        both
    }

    public static class Worker extends org.apache.tools.ant.types.AbstractFileSet implements org.apache.tools.ant.types.ResourceCollection {
        public final org.apache.tools.ant.types.resources.MultiRootFileSet.SetType D;

        public Worker(org.apache.tools.ant.types.resources.MultiRootFileSet multiRootFileSet, org.apache.tools.ant.types.resources.MultiRootFileSet.SetType setType, java.io.File file) {
            super(multiRootFileSet);
            this.D = setType;
            setDir(file);
        }

        public /* synthetic */ Worker(org.apache.tools.ant.types.resources.MultiRootFileSet multiRootFileSet, org.apache.tools.ant.types.resources.MultiRootFileSet.SetType setType, java.io.File file, org.apache.tools.ant.types.resources.MultiRootFileSet.AnonymousClass1 anonymousClass1) {
            this(multiRootFileSet, setType, file);
        }

        @Override // org.apache.tools.ant.types.ResourceCollection
        public boolean isFilesystemOnly() {
            return true;
        }

        @Override // org.apache.tools.ant.types.ResourceCollection, java.lang.Iterable
        public java.util.Iterator<org.apache.tools.ant.types.Resource> iterator() {
            org.apache.tools.ant.DirectoryScanner directoryScanner = getDirectoryScanner(getProject());
            java.lang.String[] includedFiles = this.D == org.apache.tools.ant.types.resources.MultiRootFileSet.SetType.file ? directoryScanner.getIncludedFiles() : directoryScanner.getIncludedDirectories();
            if (this.D == org.apache.tools.ant.types.resources.MultiRootFileSet.SetType.both) {
                java.lang.String[] includedFiles2 = directoryScanner.getIncludedFiles();
                java.lang.String[] strArr = new java.lang.String[includedFiles.length + includedFiles2.length];
                java.lang.System.arraycopy(includedFiles, 0, strArr, 0, includedFiles.length);
                java.lang.System.arraycopy(includedFiles2, 0, strArr, includedFiles.length, includedFiles2.length);
                includedFiles = strArr;
            }
            return new org.apache.tools.ant.types.resources.FileResourceIterator(getProject(), getDir(getProject()), includedFiles);
        }

        @Override // org.apache.tools.ant.types.ResourceCollection
        public int size() {
            org.apache.tools.ant.DirectoryScanner directoryScanner = getDirectoryScanner(getProject());
            int includedFilesCount = this.D == org.apache.tools.ant.types.resources.MultiRootFileSet.SetType.file ? directoryScanner.getIncludedFilesCount() : directoryScanner.getIncludedDirsCount();
            return this.D == org.apache.tools.ant.types.resources.MultiRootFileSet.SetType.both ? includedFilesCount + directoryScanner.getIncludedFilesCount() : includedFilesCount;
        }
    }

    public void addConfiguredBaseDir(org.apache.tools.ant.types.resources.FileResource fileResource) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        this.F.add(fileResource.getFile());
    }

    public final synchronized org.apache.tools.ant.types.resources.Union c() {
        org.apache.tools.ant.types.resources.Union union;
        if (this.E && (union = this.G) != null) {
            return union;
        }
        org.apache.tools.ant.types.resources.Union union2 = new org.apache.tools.ant.types.resources.Union();
        d(union2);
        if (this.E) {
            this.G = union2;
        }
        return union2;
    }

    @Override // org.apache.tools.ant.types.AbstractFileSet, org.apache.tools.ant.types.DataType, org.apache.tools.ant.ProjectComponent
    public java.lang.Object clone() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.resources.MultiRootFileSet) getRef(getProject())).clone();
        }
        org.apache.tools.ant.types.resources.MultiRootFileSet multiRootFileSet = (org.apache.tools.ant.types.resources.MultiRootFileSet) super.clone();
        multiRootFileSet.F = new java.util.ArrayList(this.F);
        multiRootFileSet.G = null;
        return multiRootFileSet;
    }

    public final void d(org.apache.tools.ant.types.resources.Union union) {
        java.util.Iterator<java.io.File> it = this.F.iterator();
        while (it.hasNext()) {
            union.add(new org.apache.tools.ant.types.resources.MultiRootFileSet.Worker(this, this.D, it.next(), null));
        }
    }

    @Override // org.apache.tools.ant.types.ResourceCollection
    public boolean isFilesystemOnly() {
        return true;
    }

    @Override // org.apache.tools.ant.types.ResourceCollection, java.lang.Iterable
    public java.util.Iterator<org.apache.tools.ant.types.Resource> iterator() {
        return isReference() ? ((org.apache.tools.ant.types.resources.MultiRootFileSet) getRef(getProject())).iterator() : c().iterator();
    }

    public void setBaseDirs(java.lang.String str) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        if (str == null || str.length() <= 0) {
            return;
        }
        for (java.lang.String str2 : str.split(",")) {
            this.F.add(getProject().resolveFile(str2));
        }
    }

    public synchronized void setCache(boolean z) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        this.E = z;
    }

    @Override // org.apache.tools.ant.types.AbstractFileSet
    public void setDir(java.io.File file) {
        throw new org.apache.tools.ant.BuildException(getDataTypeName() + " doesn't support the dir attribute");
    }

    @Override // org.apache.tools.ant.types.AbstractFileSet, org.apache.tools.ant.types.DataType
    public void setRefid(org.apache.tools.ant.types.Reference reference) {
        if (!this.F.isEmpty()) {
            throw tooManyAttributes();
        }
        super.setRefid(reference);
    }

    public void setType(org.apache.tools.ant.types.resources.MultiRootFileSet.SetType setType) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        this.D = setType;
    }

    @Override // org.apache.tools.ant.types.ResourceCollection
    public int size() {
        return isReference() ? ((org.apache.tools.ant.types.resources.MultiRootFileSet) getRef(getProject())).size() : c().size();
    }

    @Override // org.apache.tools.ant.types.AbstractFileSet, org.apache.tools.ant.types.DataType
    public java.lang.String toString() {
        return isReference() ? ((org.apache.tools.ant.types.resources.MultiRootFileSet) getRef(getProject())).toString() : c().toString();
    }
}
