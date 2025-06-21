package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Ear extends org.apache.tools.ant.taskdefs.Jar {
    public static final org.apache.tools.ant.util.FileUtils t0 = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public java.io.File r0;
    public boolean s0;

    public Ear() {
        this.archiveType = "ear";
        this.emptyBehavior = "create";
    }

    public void addArchives(org.apache.tools.ant.types.ZipFileSet zipFileSet) {
        zipFileSet.setPrefix(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
        super.addFileset(zipFileSet);
    }

    @Override // org.apache.tools.ant.taskdefs.Jar, org.apache.tools.ant.taskdefs.Zip
    public void cleanUp() {
        this.s0 = false;
        super.cleanUp();
    }

    @Override // org.apache.tools.ant.taskdefs.Jar, org.apache.tools.ant.taskdefs.Zip
    public void initZipOutputStream(org.apache.tools.zip.ZipOutputStream zipOutputStream) throws java.io.IOException, org.apache.tools.ant.BuildException {
        if (this.r0 == null && !isInUpdateMode()) {
            throw new org.apache.tools.ant.BuildException("appxml attribute is required", getLocation());
        }
        super.initZipOutputStream(zipOutputStream);
    }

    public void setAppxml(java.io.File file) {
        this.r0 = file;
        if (file.exists()) {
            org.apache.tools.ant.types.ZipFileSet zipFileSet = new org.apache.tools.ant.types.ZipFileSet();
            zipFileSet.setFile(this.r0);
            zipFileSet.setFullpath("META-INF/application.xml");
            super.addFileset(zipFileSet);
            return;
        }
        throw new org.apache.tools.ant.BuildException("Deployment descriptor: " + this.r0 + org.apache.tools.ant.DirectoryScanner.DOES_NOT_EXIST_POSTFIX);
    }

    public void setEarfile(java.io.File file) {
        setDestFile(file);
    }

    @Override // org.apache.tools.ant.taskdefs.Zip
    public void zipFile(java.io.File file, org.apache.tools.zip.ZipOutputStream zipOutputStream, java.lang.String str, int i) throws java.io.IOException {
        if (!"META-INF/application.xml".equalsIgnoreCase(str)) {
            super.zipFile(file, zipOutputStream, str, i);
            return;
        }
        java.io.File file2 = this.r0;
        if (file2 != null && t0.fileNameEquals(file2, file) && !this.s0) {
            super.zipFile(file, zipOutputStream, str, i);
            this.s0 = true;
            return;
        }
        logWhenWriting("Warning: selected " + this.archiveType + " files include a META-INF/application.xml which will be ignored (please use appxml attribute to " + this.archiveType + " task)", 1);
    }
}
