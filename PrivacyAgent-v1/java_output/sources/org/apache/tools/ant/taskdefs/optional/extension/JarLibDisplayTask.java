package org.apache.tools.ant.taskdefs.optional.extension;

/* loaded from: classes25.dex */
public class JarLibDisplayTask extends org.apache.tools.ant.Task {
    public java.io.File u;
    public final java.util.Vector v = new java.util.Vector();

    public void addFileset(org.apache.tools.ant.types.FileSet fileSet) {
        this.v.addElement(fileSet);
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        validate();
        org.apache.tools.ant.taskdefs.optional.extension.LibraryDisplayer libraryDisplayer = new org.apache.tools.ant.taskdefs.optional.extension.LibraryDisplayer();
        if (this.v.isEmpty()) {
            libraryDisplayer.a(this.u);
            return;
        }
        java.util.Iterator it = this.v.iterator();
        while (it.hasNext()) {
            org.apache.tools.ant.DirectoryScanner directoryScanner = ((org.apache.tools.ant.types.FileSet) it.next()).getDirectoryScanner(getProject());
            java.io.File basedir = directoryScanner.getBasedir();
            for (java.lang.String str : directoryScanner.getIncludedFiles()) {
                libraryDisplayer.a(new java.io.File(basedir, str));
            }
        }
    }

    public void setFile(java.io.File file) {
        this.u = file;
    }

    public final void validate() throws org.apache.tools.ant.BuildException {
        if (this.u == null && this.v.isEmpty()) {
            throw new org.apache.tools.ant.BuildException("File attribute not specified.");
        }
        java.io.File file = this.u;
        if (file != null && !file.exists()) {
            throw new org.apache.tools.ant.BuildException("File '" + this.u + "' does not exist.");
        }
        java.io.File file2 = this.u;
        if (file2 == null || file2.isFile()) {
            return;
        }
        throw new org.apache.tools.ant.BuildException("'" + this.u + "' is not a file.");
    }
}
