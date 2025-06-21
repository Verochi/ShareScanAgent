package org.apache.tools.ant.types;

/* loaded from: classes26.dex */
public class TarFileSet extends org.apache.tools.ant.types.ArchiveFileSet {
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public java.lang.String R;
    public java.lang.String S;
    public int T;
    public int U;

    public TarFileSet() {
        this.R = "";
        this.S = "";
    }

    public TarFileSet(org.apache.tools.ant.types.FileSet fileSet) {
        super(fileSet);
        this.R = "";
        this.S = "";
    }

    public TarFileSet(org.apache.tools.ant.types.TarFileSet tarFileSet) {
        super((org.apache.tools.ant.types.ArchiveFileSet) tarFileSet);
        this.R = "";
        this.S = "";
    }

    @Override // org.apache.tools.ant.types.ArchiveFileSet, org.apache.tools.ant.types.FileSet, org.apache.tools.ant.types.AbstractFileSet, org.apache.tools.ant.types.DataType, org.apache.tools.ant.ProjectComponent
    public java.lang.Object clone() {
        return isReference() ? ((org.apache.tools.ant.types.TarFileSet) getRef(getProject())).clone() : super.clone();
    }

    @Override // org.apache.tools.ant.types.ArchiveFileSet
    public void configureFileSet(org.apache.tools.ant.types.ArchiveFileSet archiveFileSet) {
        super.configureFileSet(archiveFileSet);
        if (archiveFileSet instanceof org.apache.tools.ant.types.TarFileSet) {
            org.apache.tools.ant.types.TarFileSet tarFileSet = (org.apache.tools.ant.types.TarFileSet) archiveFileSet;
            tarFileSet.setUserName(this.R);
            tarFileSet.setGroup(this.S);
            tarFileSet.setUid(this.T);
            tarFileSet.setGid(this.U);
        }
    }

    public final void d() {
        if (getProject() == null || (isReference() && (getRefid().getReferencedObject(getProject()) instanceof org.apache.tools.ant.types.TarFileSet))) {
            checkAttributesAllowed();
        }
    }

    public int getGid() {
        return isReference() ? ((org.apache.tools.ant.types.TarFileSet) getCheckedRef()).getGid() : this.U;
    }

    public java.lang.String getGroup() {
        return isReference() ? ((org.apache.tools.ant.types.TarFileSet) getCheckedRef()).getGroup() : this.S;
    }

    @Override // org.apache.tools.ant.types.AbstractFileSet
    public org.apache.tools.ant.types.AbstractFileSet getRef(org.apache.tools.ant.Project project) {
        dieOnCircularReference(project);
        java.lang.Object referencedObject = getRefid().getReferencedObject(project);
        if (referencedObject instanceof org.apache.tools.ant.types.TarFileSet) {
            return (org.apache.tools.ant.types.AbstractFileSet) referencedObject;
        }
        if (referencedObject instanceof org.apache.tools.ant.types.FileSet) {
            org.apache.tools.ant.types.TarFileSet tarFileSet = new org.apache.tools.ant.types.TarFileSet((org.apache.tools.ant.types.FileSet) referencedObject);
            configureFileSet(tarFileSet);
            return tarFileSet;
        }
        throw new org.apache.tools.ant.BuildException(getRefid().getRefId() + " doesn't denote a tarfileset or a fileset");
    }

    public int getUid() {
        return isReference() ? ((org.apache.tools.ant.types.TarFileSet) getCheckedRef()).getUid() : this.T;
    }

    public java.lang.String getUserName() {
        return isReference() ? ((org.apache.tools.ant.types.TarFileSet) getCheckedRef()).getUserName() : this.R;
    }

    public boolean hasGroupBeenSet() {
        return this.O;
    }

    public boolean hasGroupIdBeenSet() {
        return this.Q;
    }

    public boolean hasUserIdBeenSet() {
        return this.P;
    }

    public boolean hasUserNameBeenSet() {
        return this.N;
    }

    @Override // org.apache.tools.ant.types.ArchiveFileSet
    public org.apache.tools.ant.types.ArchiveScanner newArchiveScanner() {
        org.apache.tools.ant.types.TarScanner tarScanner = new org.apache.tools.ant.types.TarScanner();
        tarScanner.setEncoding(getEncoding());
        return tarScanner;
    }

    public void setGid(int i) {
        d();
        this.Q = true;
        this.U = i;
    }

    public void setGroup(java.lang.String str) {
        d();
        this.O = true;
        this.S = str;
    }

    @Override // org.apache.tools.ant.types.AbstractFileSet, org.apache.tools.ant.types.DataType
    public void setRefid(org.apache.tools.ant.types.Reference reference) throws org.apache.tools.ant.BuildException {
        if (this.N || this.P || this.O || this.Q) {
            throw tooManyAttributes();
        }
        super.setRefid(reference);
    }

    public void setUid(int i) {
        d();
        this.P = true;
        this.T = i;
    }

    public void setUserName(java.lang.String str) {
        d();
        this.N = true;
        this.R = str;
    }
}
