package org.apache.tools.ant.types;

/* loaded from: classes26.dex */
public class FileList extends org.apache.tools.ant.types.DataType implements org.apache.tools.ant.types.ResourceCollection {
    public java.util.List<java.lang.String> n;
    public java.io.File t;

    public static class FileName {
        public java.lang.String a;

        public java.lang.String getName() {
            return this.a;
        }

        public void setName(java.lang.String str) {
            this.a = str;
        }
    }

    public FileList() {
        this.n = new java.util.ArrayList();
    }

    public FileList(org.apache.tools.ant.types.FileList fileList) {
        this.n = new java.util.ArrayList();
        this.t = fileList.t;
        this.n = fileList.n;
        setProject(fileList.getProject());
    }

    public void addConfiguredFile(org.apache.tools.ant.types.FileList.FileName fileName) {
        if (fileName.getName() == null) {
            throw new org.apache.tools.ant.BuildException("No name specified in nested file element");
        }
        this.n.add(fileName.getName());
    }

    public java.io.File getDir(org.apache.tools.ant.Project project) {
        return isReference() ? getRef(project).getDir(project) : this.t;
    }

    public java.lang.String[] getFiles(org.apache.tools.ant.Project project) {
        if (isReference()) {
            return getRef(project).getFiles(project);
        }
        if (this.t == null) {
            throw new org.apache.tools.ant.BuildException("No directory specified for filelist.");
        }
        if (this.n.size() == 0) {
            throw new org.apache.tools.ant.BuildException("No files specified for filelist.");
        }
        java.util.List<java.lang.String> list = this.n;
        return (java.lang.String[]) list.toArray(new java.lang.String[list.size()]);
    }

    public org.apache.tools.ant.types.FileList getRef(org.apache.tools.ant.Project project) {
        return (org.apache.tools.ant.types.FileList) getCheckedRef(project);
    }

    @Override // org.apache.tools.ant.types.ResourceCollection
    public boolean isFilesystemOnly() {
        return true;
    }

    @Override // org.apache.tools.ant.types.ResourceCollection, java.lang.Iterable
    public java.util.Iterator<org.apache.tools.ant.types.Resource> iterator() {
        if (isReference()) {
            return getRef(getProject()).iterator();
        }
        org.apache.tools.ant.Project project = getProject();
        java.io.File file = this.t;
        java.util.List<java.lang.String> list = this.n;
        return new org.apache.tools.ant.types.resources.FileResourceIterator(project, file, (java.lang.String[]) list.toArray(new java.lang.String[list.size()]));
    }

    public void setDir(java.io.File file) throws org.apache.tools.ant.BuildException {
        checkAttributesAllowed();
        this.t = file;
    }

    public void setFiles(java.lang.String str) {
        checkAttributesAllowed();
        if (str == null || str.length() <= 0) {
            return;
        }
        java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(str, ", \t\n\r\f", false);
        while (stringTokenizer.hasMoreTokens()) {
            this.n.add(stringTokenizer.nextToken());
        }
    }

    @Override // org.apache.tools.ant.types.DataType
    public void setRefid(org.apache.tools.ant.types.Reference reference) throws org.apache.tools.ant.BuildException {
        if (this.t != null || this.n.size() != 0) {
            throw tooManyAttributes();
        }
        super.setRefid(reference);
    }

    @Override // org.apache.tools.ant.types.ResourceCollection
    public int size() {
        return isReference() ? getRef(getProject()).size() : this.n.size();
    }
}
