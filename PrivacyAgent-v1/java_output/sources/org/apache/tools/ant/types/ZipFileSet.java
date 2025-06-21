package org.apache.tools.ant.types;

/* loaded from: classes26.dex */
public class ZipFileSet extends org.apache.tools.ant.types.ArchiveFileSet {
    public ZipFileSet() {
    }

    public ZipFileSet(org.apache.tools.ant.types.FileSet fileSet) {
        super(fileSet);
    }

    public ZipFileSet(org.apache.tools.ant.types.ZipFileSet zipFileSet) {
        super((org.apache.tools.ant.types.ArchiveFileSet) zipFileSet);
    }

    @Override // org.apache.tools.ant.types.ArchiveFileSet, org.apache.tools.ant.types.FileSet, org.apache.tools.ant.types.AbstractFileSet, org.apache.tools.ant.types.DataType, org.apache.tools.ant.ProjectComponent
    public java.lang.Object clone() {
        return isReference() ? ((org.apache.tools.ant.types.ZipFileSet) getRef(getProject())).clone() : super.clone();
    }

    @Override // org.apache.tools.ant.types.AbstractFileSet
    public org.apache.tools.ant.types.AbstractFileSet getRef(org.apache.tools.ant.Project project) {
        dieOnCircularReference(project);
        java.lang.Object referencedObject = getRefid().getReferencedObject(project);
        if (referencedObject instanceof org.apache.tools.ant.types.ZipFileSet) {
            return (org.apache.tools.ant.types.AbstractFileSet) referencedObject;
        }
        if (referencedObject instanceof org.apache.tools.ant.types.FileSet) {
            org.apache.tools.ant.types.ZipFileSet zipFileSet = new org.apache.tools.ant.types.ZipFileSet((org.apache.tools.ant.types.FileSet) referencedObject);
            configureFileSet(zipFileSet);
            return zipFileSet;
        }
        throw new org.apache.tools.ant.BuildException(getRefid().getRefId() + " doesn't denote a zipfileset or a fileset");
    }

    @Override // org.apache.tools.ant.types.ArchiveFileSet
    public org.apache.tools.ant.types.ArchiveScanner newArchiveScanner() {
        org.apache.tools.ant.types.ZipScanner zipScanner = new org.apache.tools.ant.types.ZipScanner();
        zipScanner.setEncoding(getEncoding());
        return zipScanner;
    }
}
