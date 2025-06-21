package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class War extends org.apache.tools.ant.taskdefs.Jar {
    public static final org.apache.tools.ant.util.FileUtils u0 = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public java.io.File r0;
    public boolean s0 = true;
    public java.io.File t0;

    public War() {
        this.archiveType = "war";
        this.emptyBehavior = "create";
    }

    public void addClasses(org.apache.tools.ant.types.ZipFileSet zipFileSet) {
        zipFileSet.setPrefix("WEB-INF/classes/");
        super.addFileset(zipFileSet);
    }

    public void addLib(org.apache.tools.ant.types.ZipFileSet zipFileSet) {
        zipFileSet.setPrefix("WEB-INF/lib/");
        super.addFileset(zipFileSet);
    }

    public void addWebinf(org.apache.tools.ant.types.ZipFileSet zipFileSet) {
        zipFileSet.setPrefix("WEB-INF/");
        super.addFileset(zipFileSet);
    }

    @Override // org.apache.tools.ant.taskdefs.Jar, org.apache.tools.ant.taskdefs.Zip
    public void cleanUp() {
        if (this.t0 == null && this.r0 == null && this.s0 && !isInUpdateMode() && hasUpdatedFile()) {
            throw new org.apache.tools.ant.BuildException("No WEB-INF/web.xml file was added.\nIf this is your intent, set needxmlfile='false' ");
        }
        this.t0 = null;
        super.cleanUp();
    }

    @Override // org.apache.tools.ant.taskdefs.Jar, org.apache.tools.ant.taskdefs.Zip
    public void initZipOutputStream(org.apache.tools.zip.ZipOutputStream zipOutputStream) throws java.io.IOException, org.apache.tools.ant.BuildException {
        super.initZipOutputStream(zipOutputStream);
    }

    public void setNeedxmlfile(boolean z) {
        this.s0 = z;
    }

    @java.lang.Deprecated
    public void setWarfile(java.io.File file) {
        setDestFile(file);
    }

    public void setWebxml(java.io.File file) {
        this.r0 = file;
        if (file.exists()) {
            org.apache.tools.ant.types.ZipFileSet zipFileSet = new org.apache.tools.ant.types.ZipFileSet();
            zipFileSet.setFile(this.r0);
            zipFileSet.setFullpath("WEB-INF/web.xml");
            super.addFileset(zipFileSet);
            return;
        }
        throw new org.apache.tools.ant.BuildException("Deployment descriptor: " + this.r0 + org.apache.tools.ant.DirectoryScanner.DOES_NOT_EXIST_POSTFIX);
    }

    @Override // org.apache.tools.ant.taskdefs.Zip
    public void zipFile(java.io.File file, org.apache.tools.zip.ZipOutputStream zipOutputStream, java.lang.String str, int i) throws java.io.IOException {
        boolean z = true;
        if ("WEB-INF/web.xml".equalsIgnoreCase(str)) {
            java.io.File file2 = this.t0;
            if (file2 != null) {
                if (!u0.fileNameEquals(file2, file)) {
                    logWhenWriting("Warning: selected " + this.archiveType + " files include a second WEB-INF/web.xml which will be ignored.\nThe duplicate entry is at " + file + "\nThe file that will be used is " + this.t0, 1);
                }
                z = false;
            } else {
                this.t0 = file;
                this.r0 = file;
            }
        }
        if (z) {
            super.zipFile(file, zipOutputStream, str, i);
        }
    }
}
