package org.apache.tools.ant.types.resources;

/* loaded from: classes26.dex */
public class BCFileSet extends org.apache.tools.ant.types.FileSet {
    public BCFileSet() {
    }

    public BCFileSet(org.apache.tools.ant.types.FileSet fileSet) {
        super(fileSet);
    }

    @Override // org.apache.tools.ant.types.FileSet, org.apache.tools.ant.types.ResourceCollection, java.lang.Iterable
    public java.util.Iterator<org.apache.tools.ant.types.Resource> iterator() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.FileSet) getRef(getProject())).iterator();
        }
        org.apache.tools.ant.types.resources.FileResourceIterator fileResourceIterator = new org.apache.tools.ant.types.resources.FileResourceIterator(getProject(), getDir());
        fileResourceIterator.addFiles(getDirectoryScanner().getIncludedFiles());
        fileResourceIterator.addFiles(getDirectoryScanner().getIncludedDirectories());
        return fileResourceIterator;
    }

    @Override // org.apache.tools.ant.types.FileSet, org.apache.tools.ant.types.ResourceCollection
    public int size() {
        return isReference() ? ((org.apache.tools.ant.types.FileSet) getRef(getProject())).size() : getDirectoryScanner().getIncludedFilesCount() + getDirectoryScanner().getIncludedDirsCount();
    }
}
