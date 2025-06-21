package org.apache.tools.ant.types;

/* loaded from: classes26.dex */
public class FileSet extends org.apache.tools.ant.types.AbstractFileSet implements org.apache.tools.ant.types.ResourceCollection {
    public FileSet() {
    }

    public FileSet(org.apache.tools.ant.types.FileSet fileSet) {
        super(fileSet);
    }

    @Override // org.apache.tools.ant.types.AbstractFileSet, org.apache.tools.ant.types.DataType, org.apache.tools.ant.ProjectComponent
    public java.lang.Object clone() {
        return isReference() ? ((org.apache.tools.ant.types.FileSet) getRef(getProject())).clone() : super.clone();
    }

    public boolean isFilesystemOnly() {
        return true;
    }

    public java.util.Iterator<org.apache.tools.ant.types.Resource> iterator() {
        return isReference() ? ((org.apache.tools.ant.types.FileSet) getRef(getProject())).iterator() : new org.apache.tools.ant.types.resources.FileResourceIterator(getProject(), getDir(getProject()), getDirectoryScanner(getProject()).getIncludedFiles());
    }

    public int size() {
        return isReference() ? ((org.apache.tools.ant.types.FileSet) getRef(getProject())).size() : getDirectoryScanner(getProject()).getIncludedFilesCount();
    }
}
