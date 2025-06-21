package org.apache.tools.ant.taskdefs.optional;

/* loaded from: classes25.dex */
public class Cab extends org.apache.tools.ant.taskdefs.MatchingTask {
    public static final org.apache.tools.ant.util.FileUtils A = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public java.io.File u;
    public java.io.File v;
    public java.lang.String z;
    public java.util.Vector w = new java.util.Vector();
    public boolean x = true;
    public boolean y = false;
    protected java.lang.String archiveType = "cab";

    public void addFileset(org.apache.tools.ant.types.FileSet fileSet) {
        if (this.w.size() > 0) {
            throw new org.apache.tools.ant.BuildException("Only one nested fileset allowed");
        }
        this.w.addElement(fileSet);
    }

    public void appendFiles(java.util.Vector vector, org.apache.tools.ant.DirectoryScanner directoryScanner) {
        for (java.lang.String str : directoryScanner.getIncludedFiles()) {
            vector.addElement(str);
        }
    }

    public void checkConfiguration() throws org.apache.tools.ant.BuildException {
        if (this.v == null && this.w.size() == 0) {
            throw new org.apache.tools.ant.BuildException("basedir attribute or one nested fileset is required!", getLocation());
        }
        java.io.File file = this.v;
        if (file != null && !file.exists()) {
            throw new org.apache.tools.ant.BuildException("basedir does not exist!", getLocation());
        }
        if (this.v != null && this.w.size() > 0) {
            throw new org.apache.tools.ant.BuildException("Both basedir attribute and a nested fileset is not allowed");
        }
        if (this.u == null) {
            throw new org.apache.tools.ant.BuildException("cabfile attribute must be set!", getLocation());
        }
    }

    public org.apache.tools.ant.taskdefs.ExecTask createExec() throws org.apache.tools.ant.BuildException {
        return new org.apache.tools.ant.taskdefs.ExecTask(this);
    }

    public java.io.File createListFile(java.util.Vector vector) throws java.io.IOException {
        java.io.File createTempFile = A.createTempFile(getProject(), "ant", "", null, true, true);
        java.io.BufferedWriter bufferedWriter = null;
        try {
            java.io.BufferedWriter bufferedWriter2 = new java.io.BufferedWriter(new java.io.FileWriter(createTempFile));
            try {
                int size = vector.size();
                for (int i = 0; i < size; i++) {
                    bufferedWriter2.write(kotlin.text.Typography.quote + vector.elementAt(i).toString() + kotlin.text.Typography.quote);
                    bufferedWriter2.newLine();
                }
                org.apache.tools.ant.util.FileUtils.close(bufferedWriter2);
                return createTempFile;
            } catch (java.lang.Throwable th) {
                th = th;
                bufferedWriter = bufferedWriter2;
                org.apache.tools.ant.util.FileUtils.close(bufferedWriter);
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00fe A[Catch: IOException -> 0x0114, TRY_LEAVE, TryCatch #3 {IOException -> 0x0114, blocks: (B:14:0x0071, B:17:0x0088, B:19:0x00ce, B:22:0x00d2, B:23:0x00f8, B:25:0x00fe, B:31:0x00e4, B:34:0x0080), top: B:13:0x0071 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    @Override // org.apache.tools.ant.Task
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void execute() throws org.apache.tools.ant.BuildException {
        int i;
        checkConfiguration();
        java.util.Vector fileList = getFileList();
        if (isUpToDate(fileList)) {
            return;
        }
        log("Building " + this.archiveType + ": " + this.u.getAbsolutePath());
        java.io.File file = null;
        if (org.apache.tools.ant.taskdefs.condition.Os.isFamily(org.apache.tools.ant.taskdefs.condition.Os.FAMILY_WINDOWS)) {
            try {
                java.io.File createListFile = createListFile(fileList);
                org.apache.tools.ant.taskdefs.ExecTask createExec = createExec();
                createExec.setFailonerror(true);
                createExec.setDir(this.v);
                if (!this.y) {
                    file = A.createTempFile(getProject(), "ant", "", null, true, true);
                    createExec.setOutput(file);
                }
                createExec.setExecutable("cabarc");
                createExec.createArg().setValue("-r");
                createExec.createArg().setValue("-p");
                if (!this.x) {
                    createExec.createArg().setValue("-m");
                    createExec.createArg().setValue("none");
                }
                if (this.z != null) {
                    createExec.createArg().setLine(this.z);
                }
                createExec.createArg().setValue(com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT);
                createExec.createArg().setFile(this.u);
                createExec.createArg().setValue("@" + createListFile.getAbsolutePath());
                createExec.execute();
                if (file != null) {
                    file.delete();
                }
                createListFile.delete();
                return;
            } catch (java.io.IOException e) {
                throw new org.apache.tools.ant.BuildException("Problem creating " + this.u + " " + e.getMessage(), getLocation());
            }
        }
        log("Using listcab/libcabinet", 3);
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        java.util.Enumeration elements = fileList.elements();
        while (elements.hasMoreElements()) {
            stringBuffer.append(elements.nextElement());
            stringBuffer.append("\n");
        }
        stringBuffer.append("\n");
        stringBuffer.append(this.u.getAbsolutePath());
        stringBuffer.append("\n");
        try {
            org.apache.tools.ant.Project project = getProject();
            java.lang.String[] strArr = {"listcab"};
            java.io.File file2 = this.v;
            if (file2 == null) {
                file2 = getProject().getBaseDir();
            }
            java.lang.Process launch = org.apache.tools.ant.taskdefs.Execute.launch(project, strArr, null, file2, true);
            java.io.OutputStream outputStream = launch.getOutputStream();
            org.apache.tools.ant.taskdefs.LogOutputStream logOutputStream = new org.apache.tools.ant.taskdefs.LogOutputStream((org.apache.tools.ant.Task) this, 3);
            org.apache.tools.ant.taskdefs.LogOutputStream logOutputStream2 = new org.apache.tools.ant.taskdefs.LogOutputStream((org.apache.tools.ant.Task) this, 0);
            org.apache.tools.ant.taskdefs.StreamPumper streamPumper = new org.apache.tools.ant.taskdefs.StreamPumper(launch.getInputStream(), logOutputStream);
            org.apache.tools.ant.taskdefs.StreamPumper streamPumper2 = new org.apache.tools.ant.taskdefs.StreamPumper(launch.getErrorStream(), logOutputStream2);
            new java.lang.Thread(streamPumper).start();
            new java.lang.Thread(streamPumper2).start();
            outputStream.write(stringBuffer.toString().getBytes());
            outputStream.flush();
            outputStream.close();
            try {
                i = launch.waitFor();
            } catch (java.lang.InterruptedException e2) {
                e = e2;
                i = -99;
            }
            try {
                streamPumper.waitFor();
                logOutputStream.close();
                streamPumper2.waitFor();
                logOutputStream2.close();
            } catch (java.lang.InterruptedException e3) {
                e = e3;
                log("Thread interrupted: " + e);
                if (org.apache.tools.ant.taskdefs.Execute.isFailure(i)) {
                }
            }
            if (org.apache.tools.ant.taskdefs.Execute.isFailure(i)) {
                return;
            }
            log("Error executing listcab; error code: " + i);
        } catch (java.io.IOException e4) {
            throw new org.apache.tools.ant.BuildException("Problem creating " + this.u + " " + e4.getMessage(), getLocation());
        }
    }

    public java.util.Vector getFileList() throws org.apache.tools.ant.BuildException {
        java.util.Vector vector = new java.util.Vector();
        java.io.File file = this.v;
        if (file != null) {
            appendFiles(vector, super.getDirectoryScanner(file));
        } else {
            org.apache.tools.ant.types.FileSet fileSet = (org.apache.tools.ant.types.FileSet) this.w.elementAt(0);
            this.v = fileSet.getDir();
            appendFiles(vector, fileSet.getDirectoryScanner(getProject()));
        }
        return vector;
    }

    public boolean isUpToDate(java.util.Vector vector) {
        int size = vector.size();
        boolean z = true;
        for (int i = 0; i < size && z; i++) {
            if (A.resolveFile(this.v, vector.elementAt(i).toString()).lastModified() > this.u.lastModified()) {
                z = false;
            }
        }
        return z;
    }

    public void setBasedir(java.io.File file) {
        this.v = file;
    }

    public void setCabfile(java.io.File file) {
        this.u = file;
    }

    public void setCompress(boolean z) {
        this.x = z;
    }

    public void setOptions(java.lang.String str) {
        this.z = str;
    }

    public void setVerbose(boolean z) {
        this.y = z;
    }
}
