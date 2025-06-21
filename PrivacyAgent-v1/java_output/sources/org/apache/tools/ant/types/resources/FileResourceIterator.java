package org.apache.tools.ant.types.resources;

/* loaded from: classes26.dex */
public class FileResourceIterator implements java.util.Iterator<org.apache.tools.ant.types.Resource> {
    public org.apache.tools.ant.Project n;
    public java.io.File t;
    public java.lang.String[] u;
    public int v;

    @java.lang.Deprecated
    public FileResourceIterator() {
        this.v = 0;
    }

    @java.lang.Deprecated
    public FileResourceIterator(java.io.File file) {
        this((org.apache.tools.ant.Project) null, file);
    }

    @java.lang.Deprecated
    public FileResourceIterator(java.io.File file, java.lang.String[] strArr) {
        this(null, file, strArr);
    }

    public FileResourceIterator(org.apache.tools.ant.Project project) {
        this.v = 0;
        this.n = project;
    }

    public FileResourceIterator(org.apache.tools.ant.Project project, java.io.File file) {
        this(project);
        this.t = file;
    }

    public FileResourceIterator(org.apache.tools.ant.Project project, java.io.File file, java.lang.String[] strArr) {
        this(project, file);
        addFiles(strArr);
    }

    public void addFiles(java.lang.String[] strArr) {
        java.lang.String[] strArr2 = this.u;
        int length = strArr2 == null ? 0 : strArr2.length;
        java.lang.String[] strArr3 = new java.lang.String[strArr.length + length];
        if (length > 0) {
            java.lang.System.arraycopy(strArr2, 0, strArr3, 0, length);
        }
        this.u = strArr3;
        java.lang.System.arraycopy(strArr, 0, strArr3, length, strArr.length);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.v < this.u.length;
    }

    @Override // java.util.Iterator
    public org.apache.tools.ant.types.Resource next() {
        return nextResource();
    }

    public org.apache.tools.ant.types.resources.FileResource nextResource() {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException();
        }
        java.io.File file = this.t;
        java.lang.String[] strArr = this.u;
        int i = this.v;
        this.v = i + 1;
        org.apache.tools.ant.types.resources.FileResource fileResource = new org.apache.tools.ant.types.resources.FileResource(file, strArr[i]);
        fileResource.setProject(this.n);
        return fileResource;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new java.lang.UnsupportedOperationException();
    }
}
