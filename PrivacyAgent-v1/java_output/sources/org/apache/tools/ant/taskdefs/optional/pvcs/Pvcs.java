package org.apache.tools.ant.taskdefs.optional.pvcs;

/* loaded from: classes25.dex */
public class Pvcs extends org.apache.tools.ant.Task {
    public java.lang.String C;
    public java.lang.String H;
    public java.lang.String I;
    public java.lang.String w = null;
    public java.util.Vector x = new java.util.Vector();
    public java.lang.String y = null;
    public java.lang.String v = null;
    public java.lang.String u = null;
    public java.lang.String z = null;
    public java.lang.String A = null;
    public java.lang.String B = null;
    public boolean D = false;
    public boolean E = false;
    public java.lang.String G = "\"P:";
    public java.lang.String F = "{0}-arc({1})";

    public void addPvcsproject(org.apache.tools.ant.taskdefs.optional.pvcs.PvcsProject pvcsProject) {
        this.x.addElement(pvcsProject);
    }

    public final void c(java.io.File file) throws java.io.IOException, java.text.ParseException {
        java.io.BufferedReader bufferedReader = null;
        try {
            java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(new java.io.FileReader(file));
            try {
                java.text.MessageFormat messageFormat = new java.text.MessageFormat(getFilenameFormat());
                for (java.lang.String readLine = bufferedReader2.readLine(); readLine != null; readLine = bufferedReader2.readLine()) {
                    log("Considering \"" + readLine + "\"", 3);
                    if (!readLine.startsWith("\"\\") && !readLine.startsWith("\"/") && (readLine.length() <= 3 || !readLine.startsWith("\"") || !java.lang.Character.isLetter(readLine.charAt(1)) || !java.lang.String.valueOf(readLine.charAt(2)).equals(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR) || !java.lang.String.valueOf(readLine.charAt(3)).equals("\\"))) {
                        log("Skipped \"" + readLine + "\"", 3);
                    }
                    java.lang.String str = (java.lang.String) messageFormat.parse(readLine)[1];
                    int lastIndexOf = str.lastIndexOf(java.io.File.separator);
                    if (lastIndexOf > -1) {
                        java.io.File file2 = new java.io.File(str.substring(0, lastIndexOf));
                        if (file2.exists()) {
                            log(file2.getAbsolutePath() + " exists. Skipping", 3);
                        } else {
                            log("Creating " + file2.getAbsolutePath(), 3);
                            if (!file2.mkdirs() && !file2.isDirectory()) {
                                log("Failed to create " + file2.getAbsolutePath(), 2);
                            }
                            log("Created " + file2.getAbsolutePath(), 2);
                        }
                    } else {
                        log("File separator problem with " + readLine, 1);
                    }
                }
                org.apache.tools.ant.util.FileUtils.close(bufferedReader2);
            } catch (java.lang.Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
                org.apache.tools.ant.util.FileUtils.close(bufferedReader);
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public final java.lang.String d(java.lang.String str) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        if (getPvcsbin() != null) {
            java.lang.String str2 = this.u;
            java.lang.String str3 = java.io.File.separator;
            if (str2.endsWith(str3)) {
                stringBuffer.append(this.u);
            } else {
                stringBuffer.append(this.u);
                stringBuffer.append(str3);
            }
        }
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    public final void e(java.io.File file, java.io.File file2) throws java.io.IOException {
        java.io.BufferedWriter bufferedWriter;
        java.io.BufferedReader bufferedReader = null;
        try {
            java.io.BufferedReader bufferedReader2 = new java.io.BufferedReader(new java.io.FileReader(file));
            try {
                bufferedWriter = new java.io.BufferedWriter(new java.io.FileWriter(file2));
                while (true) {
                    try {
                        java.lang.String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            org.apache.tools.ant.util.FileUtils.close(bufferedReader2);
                            org.apache.tools.ant.util.FileUtils.close(bufferedWriter);
                            return;
                        } else {
                            bufferedWriter.write(readLine.replace('\\', '/'));
                            bufferedWriter.newLine();
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        org.apache.tools.ant.util.FileUtils.close(bufferedReader);
                        org.apache.tools.ant.util.FileUtils.close(bufferedWriter);
                        throw th;
                    }
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                bufferedWriter = null;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            bufferedWriter = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [org.apache.tools.ant.ProjectComponent, org.apache.tools.ant.Task, org.apache.tools.ant.taskdefs.optional.pvcs.Pvcs] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v11 */
    /* JADX WARN: Type inference failed for: r9v12, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r9v13, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r9v7 */
    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        ?? r9;
        java.io.File file;
        java.io.FileOutputStream fileOutputStream;
        java.lang.String str = this.v;
        if (str == null || str.trim().equals("")) {
            throw new org.apache.tools.ant.BuildException("Required argument repository not specified");
        }
        org.apache.tools.ant.types.Commandline commandline = new org.apache.tools.ant.types.Commandline();
        commandline.setExecutable(d("pcli"));
        commandline.createArgument().setValue("lvf");
        commandline.createArgument().setValue("-z");
        commandline.createArgument().setValue("-aw");
        if (getWorkspace() != null) {
            commandline.createArgument().setValue("-sp" + getWorkspace());
        }
        commandline.createArgument().setValue("-pr" + getRepository());
        java.lang.String userId = getUserId();
        if (userId != null) {
            org.apache.tools.ant.types.Commandline.Argument createArgument = commandline.createArgument();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            r9 = "-id";
            sb.append("-id");
            sb.append(userId);
            createArgument.setValue(sb.toString());
        }
        if (getPvcsproject() == null && getPvcsprojects().isEmpty()) {
            this.w = net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR;
        }
        if (getPvcsproject() != null) {
            commandline.createArgument().setValue(getPvcsproject());
        }
        if (!getPvcsprojects().isEmpty()) {
            java.util.Enumeration elements = getPvcsprojects().elements();
            while (elements.hasMoreElements()) {
                java.lang.String name = ((org.apache.tools.ant.taskdefs.optional.pvcs.PvcsProject) elements.nextElement()).getName();
                if (name == null || name.trim().equals("")) {
                    throw new org.apache.tools.ant.BuildException("name is a required attribute of pvcsproject");
                }
                commandline.createArgument().setValue(name);
            }
        }
        java.io.File file2 = null;
        try {
            try {
                java.util.Random random = new java.util.Random(java.lang.System.currentTimeMillis());
                file = new java.io.File("pvcs_ant_" + random.nextLong() + com.anythink.china.common.a.a.f);
                try {
                    fileOutputStream = new java.io.FileOutputStream(file);
                    r9 = new java.io.File("pvcs_ant_" + random.nextLong() + com.anythink.china.common.a.a.f);
                } catch (java.io.FileNotFoundException e) {
                    e = e;
                } catch (java.io.IOException e2) {
                    e = e2;
                } catch (java.text.ParseException e3) {
                    e = e3;
                } catch (java.lang.Throwable th) {
                    th = th;
                    r9 = 0;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.io.FileNotFoundException e4) {
            e = e4;
        } catch (java.io.IOException e5) {
            e = e5;
        } catch (java.text.ParseException e6) {
            e = e6;
        } catch (java.lang.Throwable th3) {
            th = th3;
            r9 = 0;
        }
        try {
            log(commandline.describeCommand(), 3);
            try {
                int runCmd = runCmd(commandline, new org.apache.tools.ant.taskdefs.PumpStreamHandler(fileOutputStream, new org.apache.tools.ant.taskdefs.LogOutputStream((org.apache.tools.ant.Task) this, 1)));
                org.apache.tools.ant.util.FileUtils.close(fileOutputStream);
                if (org.apache.tools.ant.taskdefs.Execute.isFailure(runCmd) && !this.D) {
                    throw new org.apache.tools.ant.BuildException("Failed executing: " + commandline.toString(), getLocation());
                }
                if (!file.exists()) {
                    throw new org.apache.tools.ant.BuildException("Communication between ant and pvcs failed. No output generated from executing PVCS commandline interface \"pcli\" and \"get\"");
                }
                log("Creating folders", 2);
                c(file);
                e(file, r9);
                commandline.clearArgs();
                commandline.setExecutable(d(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET));
                if (getConfig() != null && getConfig().length() > 0) {
                    commandline.createArgument().setValue("-c" + getConfig());
                }
                if (getForce() == null || !getForce().equals("yes")) {
                    commandline.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.VALUE_NO);
                } else {
                    commandline.createArgument().setValue("-Y");
                }
                if (getPromotiongroup() != null) {
                    commandline.createArgument().setValue("-G" + getPromotiongroup());
                } else if (getLabel() != null) {
                    commandline.createArgument().setValue("-v" + getLabel());
                } else if (getRevision() != null) {
                    commandline.createArgument().setValue("-r" + getRevision());
                }
                if (this.E) {
                    commandline.createArgument().setValue(org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.FLAG_USER);
                }
                commandline.createArgument().setValue("@" + r9.getAbsolutePath());
                log("Getting files", 2);
                log("Executing " + commandline.toString(), 3);
                int runCmd2 = runCmd(commandline, new org.apache.tools.ant.taskdefs.LogStreamHandler((org.apache.tools.ant.Task) this, 2, 1));
                if (runCmd2 != 0 && !this.D) {
                    throw new org.apache.tools.ant.BuildException("Failed executing: " + commandline.toString() + ". Return code was " + runCmd2, getLocation());
                }
                file.delete();
                r9.delete();
            } catch (java.lang.Throwable th4) {
                org.apache.tools.ant.util.FileUtils.close(fileOutputStream);
                throw th4;
            }
        } catch (java.io.FileNotFoundException e7) {
            e = e7;
            throw new org.apache.tools.ant.BuildException("Failed executing: " + commandline.toString() + ". Exception: " + e.getMessage(), getLocation());
        } catch (java.io.IOException e8) {
            e = e8;
            throw new org.apache.tools.ant.BuildException("Failed executing: " + commandline.toString() + ". Exception: " + e.getMessage(), getLocation());
        } catch (java.text.ParseException e9) {
            e = e9;
            throw new org.apache.tools.ant.BuildException("Failed executing: " + commandline.toString() + ". Exception: " + e.getMessage(), getLocation());
        } catch (java.lang.Throwable th5) {
            th = th5;
            file2 = file;
            if (file2 != null) {
                file2.delete();
            }
            if (r9 != 0) {
                r9.delete();
            }
            throw th;
        }
    }

    public java.lang.String getConfig() {
        return this.I;
    }

    public java.lang.String getFilenameFormat() {
        return this.F;
    }

    public java.lang.String getForce() {
        return this.z;
    }

    public boolean getIgnoreReturnCode() {
        return this.D;
    }

    public java.lang.String getLabel() {
        return this.B;
    }

    public java.lang.String getLineStart() {
        return this.G;
    }

    public java.lang.String getPromotiongroup() {
        return this.A;
    }

    public java.lang.String getPvcsbin() {
        return this.u;
    }

    public java.lang.String getPvcsproject() {
        return this.w;
    }

    public java.util.Vector getPvcsprojects() {
        return this.x;
    }

    public java.lang.String getRepository() {
        return this.v;
    }

    public java.lang.String getRevision() {
        return this.C;
    }

    public boolean getUpdateOnly() {
        return this.E;
    }

    public java.lang.String getUserId() {
        return this.H;
    }

    public java.lang.String getWorkspace() {
        return this.y;
    }

    public int runCmd(org.apache.tools.ant.types.Commandline commandline, org.apache.tools.ant.taskdefs.ExecuteStreamHandler executeStreamHandler) {
        try {
            org.apache.tools.ant.Project project = getProject();
            org.apache.tools.ant.taskdefs.Execute execute = new org.apache.tools.ant.taskdefs.Execute(executeStreamHandler);
            execute.setAntRun(project);
            execute.setWorkingDirectory(project.getBaseDir());
            execute.setCommandline(commandline.getCommandline());
            return execute.execute();
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException("Failed executing: " + commandline.toString() + ". Exception: " + e.getMessage(), getLocation());
        }
    }

    public void setConfig(java.io.File file) {
        this.I = file.toString();
    }

    public void setFilenameFormat(java.lang.String str) {
        this.F = str;
    }

    public void setForce(java.lang.String str) {
        if (str == null || !str.equalsIgnoreCase("yes")) {
            this.z = "no";
        } else {
            this.z = "yes";
        }
    }

    public void setIgnoreReturnCode(boolean z) {
        this.D = z;
    }

    public void setLabel(java.lang.String str) {
        this.B = str;
    }

    public void setLineStart(java.lang.String str) {
        this.G = str;
    }

    public void setPromotiongroup(java.lang.String str) {
        this.A = str;
    }

    public void setPvcsbin(java.lang.String str) {
        this.u = str;
    }

    public void setPvcsproject(java.lang.String str) {
        this.w = str;
    }

    public void setRepository(java.lang.String str) {
        this.v = str;
    }

    public void setRevision(java.lang.String str) {
        this.C = str;
    }

    public void setUpdateOnly(boolean z) {
        this.E = z;
    }

    public void setUserId(java.lang.String str) {
        this.H = str;
    }

    public void setWorkspace(java.lang.String str) {
        this.y = str;
    }
}
