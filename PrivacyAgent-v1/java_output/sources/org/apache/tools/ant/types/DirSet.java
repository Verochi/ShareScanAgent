package org.apache.tools.ant.types;

/* loaded from: classes26.dex */
public class DirSet extends org.apache.tools.ant.types.AbstractFileSet implements org.apache.tools.ant.types.ResourceCollection {
    public DirSet() {
    }

    public DirSet(org.apache.tools.ant.types.DirSet dirSet) {
        super(dirSet);
    }

    @Override // org.apache.tools.ant.types.AbstractFileSet, org.apache.tools.ant.types.DataType, org.apache.tools.ant.ProjectComponent
    public java.lang.Object clone() {
        return isReference() ? ((org.apache.tools.ant.types.DirSet) getRef(getProject())).clone() : super.clone();
    }

    @Override // org.apache.tools.ant.types.ResourceCollection
    public boolean isFilesystemOnly() {
        return true;
    }

    @Override // org.apache.tools.ant.types.ResourceCollection, java.lang.Iterable
    public java.util.Iterator<org.apache.tools.ant.types.Resource> iterator() {
        return isReference() ? ((org.apache.tools.ant.types.DirSet) getRef(getProject())).iterator() : new org.apache.tools.ant.types.resources.FileResourceIterator(getProject(), getDir(getProject()), getDirectoryScanner(getProject()).getIncludedDirectories());
    }

    @Override // org.apache.tools.ant.types.ResourceCollection
    public int size() {
        return isReference() ? ((org.apache.tools.ant.types.DirSet) getRef(getProject())).size() : getDirectoryScanner(getProject()).getIncludedDirsCount();
    }

    @Override // org.apache.tools.ant.types.AbstractFileSet, org.apache.tools.ant.types.DataType
    public java.lang.String toString() {
        java.lang.String[] includedDirectories = getDirectoryScanner(getProject()).getIncludedDirectories();
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (int i = 0; i < includedDirectories.length; i++) {
            if (i > 0) {
                stringBuffer.append(';');
            }
            stringBuffer.append(includedDirectories[i]);
        }
        return stringBuffer.toString();
    }
}
