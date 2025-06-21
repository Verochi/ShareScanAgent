package org.apache.tools.ant.taskdefs.cvslib;

/* loaded from: classes25.dex */
public class ChangeLogTask extends org.apache.tools.ant.taskdefs.AbstractCvsTask {
    public java.io.File Q;
    public java.io.File S;
    public java.io.File T;
    public java.util.Date U;
    public java.util.Date V;
    public java.lang.String X;
    public java.lang.String Y;
    public java.util.Vector R = new java.util.Vector();
    public boolean W = false;
    public final java.util.Vector Z = new java.util.Vector();

    public void addFileset(org.apache.tools.ant.types.FileSet fileSet) {
        this.Z.addElement(fileSet);
    }

    public void addUser(org.apache.tools.ant.taskdefs.cvslib.CvsUser cvsUser) {
        this.R.addElement(cvsUser);
    }

    public final org.apache.tools.ant.taskdefs.cvslib.CVSEntry[] e(org.apache.tools.ant.taskdefs.cvslib.CVSEntry[] cVSEntryArr) {
        java.util.Date date;
        java.util.Date date2;
        java.util.Vector vector = new java.util.Vector();
        for (org.apache.tools.ant.taskdefs.cvslib.CVSEntry cVSEntry : cVSEntryArr) {
            java.util.Date date3 = cVSEntry.getDate();
            if (date3 != null && (((date = this.U) == null || !date.after(date3)) && ((date2 = this.V) == null || !date2.before(date3)))) {
                vector.addElement(cVSEntry);
            }
        }
        org.apache.tools.ant.taskdefs.cvslib.CVSEntry[] cVSEntryArr2 = new org.apache.tools.ant.taskdefs.cvslib.CVSEntry[vector.size()];
        vector.copyInto(cVSEntryArr2);
        return cVSEntryArr2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00c1, code lost:
    
        r2 = "";
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ec A[Catch: all -> 0x0162, TryCatch #0 {all -> 0x0162, blocks: (B:3:0x0002, B:5:0x0017, B:7:0x0030, B:10:0x0038, B:12:0x0043, B:14:0x0077, B:15:0x008b, B:17:0x008f, B:20:0x0094, B:22:0x0098, B:23:0x00e4, B:25:0x00ec, B:26:0x00f2, B:28:0x00f8, B:29:0x010b, B:31:0x010e, B:34:0x0116, B:37:0x013d, B:39:0x0143, B:40:0x0146, B:46:0x0158, B:48:0x015e, B:49:0x0161, B:52:0x00c2, B:55:0x00c8, B:57:0x007b, B:36:0x013a), top: B:2:0x0002, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0143 A[Catch: all -> 0x0162, DONT_GENERATE, TryCatch #0 {all -> 0x0162, blocks: (B:3:0x0002, B:5:0x0017, B:7:0x0030, B:10:0x0038, B:12:0x0043, B:14:0x0077, B:15:0x008b, B:17:0x008f, B:20:0x0094, B:22:0x0098, B:23:0x00e4, B:25:0x00ec, B:26:0x00f2, B:28:0x00f8, B:29:0x010b, B:31:0x010e, B:34:0x0116, B:37:0x013d, B:39:0x0143, B:40:0x0146, B:46:0x0158, B:48:0x015e, B:49:0x0161, B:52:0x00c2, B:55:0x00c8, B:57:0x007b, B:36:0x013a), top: B:2:0x0002, inners: #1 }] */
    @Override // org.apache.tools.ant.taskdefs.AbstractCvsTask, org.apache.tools.ant.Task
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void execute() throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.taskdefs.cvslib.RedirectingStreamHandler redirectingStreamHandler;
        java.io.File file = this.S;
        try {
            validate();
            java.util.Properties properties = new java.util.Properties();
            f(properties);
            int size = this.R.size();
            for (int i = 0; i < size; i++) {
                org.apache.tools.ant.taskdefs.cvslib.CvsUser cvsUser = (org.apache.tools.ant.taskdefs.cvslib.CvsUser) this.R.get(i);
                cvsUser.validate();
                properties.put(cvsUser.getUserID(), cvsUser.getDisplayname());
            }
            java.lang.String str = "";
            if (this.W) {
                setCommand("");
                addCommandArgument("rlog");
                addCommandArgument("-S");
                addCommandArgument(org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.VALUE_NO);
            } else {
                setCommand("log");
                if (getTag() != null) {
                    org.apache.tools.ant.taskdefs.cvslib.CvsVersion cvsVersion = new org.apache.tools.ant.taskdefs.cvslib.CvsVersion();
                    cvsVersion.setProject(getProject());
                    cvsVersion.setTaskName("cvsversion");
                    cvsVersion.setCvsRoot(getCvsRoot());
                    cvsVersion.setCvsRsh(getCvsRsh());
                    cvsVersion.setPassfile(getPassFile());
                    cvsVersion.setDest(this.S);
                    cvsVersion.execute();
                    if (cvsVersion.supportsCvsLogWithSOption()) {
                        addCommandArgument("-S");
                    }
                }
            }
            java.lang.String str2 = this.X;
            try {
                if (str2 == null && this.Y == null) {
                    if (this.U != null) {
                        java.lang.String str3 = ">=" + new java.text.SimpleDateFormat("yyyy-MM-dd").format(this.U);
                        addCommandArgument("-d");
                        addCommandArgument(str3);
                    }
                    if (!this.Z.isEmpty()) {
                        java.util.Enumeration elements = this.Z.elements();
                        while (elements.hasMoreElements()) {
                            for (java.lang.String str4 : ((org.apache.tools.ant.types.FileSet) elements.nextElement()).getDirectoryScanner(getProject()).getIncludedFiles()) {
                                addCommandArgument(str4);
                            }
                        }
                    }
                    org.apache.tools.ant.taskdefs.cvslib.ChangeLogParser changeLogParser = new org.apache.tools.ant.taskdefs.cvslib.ChangeLogParser(this.W, getPackage(), getModules());
                    redirectingStreamHandler = new org.apache.tools.ant.taskdefs.cvslib.RedirectingStreamHandler(changeLogParser);
                    log(getCommand(), 3);
                    setDest(this.S);
                    setExecuteStreamHandler(redirectingStreamHandler);
                    super.execute();
                    org.apache.tools.ant.taskdefs.cvslib.CVSEntry[] e = e(changeLogParser.a());
                    g(properties, e);
                    h(e);
                    return;
                }
                super.execute();
                org.apache.tools.ant.taskdefs.cvslib.CVSEntry[] e2 = e(changeLogParser.a());
                g(properties, e2);
                h(e2);
                return;
            } finally {
                java.lang.String b = redirectingStreamHandler.b();
                if (b != null) {
                    log(b, 0);
                }
            }
            java.lang.String str5 = this.Y;
            if (str5 != null) {
                str = str5;
            }
            addCommandArgument("-r" + str2 + "::" + str);
            if (!this.Z.isEmpty()) {
            }
            org.apache.tools.ant.taskdefs.cvslib.ChangeLogParser changeLogParser2 = new org.apache.tools.ant.taskdefs.cvslib.ChangeLogParser(this.W, getPackage(), getModules());
            redirectingStreamHandler = new org.apache.tools.ant.taskdefs.cvslib.RedirectingStreamHandler(changeLogParser2);
            log(getCommand(), 3);
            setDest(this.S);
            setExecuteStreamHandler(redirectingStreamHandler);
        } finally {
            this.S = file;
        }
    }

    public final void f(java.util.Properties properties) throws org.apache.tools.ant.BuildException {
        if (this.Q != null) {
            try {
                properties.load(new java.io.FileInputStream(this.Q));
            } catch (java.io.IOException e) {
                throw new org.apache.tools.ant.BuildException(e.toString(), e);
            }
        }
    }

    public final void g(java.util.Properties properties, org.apache.tools.ant.taskdefs.cvslib.CVSEntry[] cVSEntryArr) {
        for (org.apache.tools.ant.taskdefs.cvslib.CVSEntry cVSEntry : cVSEntryArr) {
            if (properties.containsKey(cVSEntry.getAuthor())) {
                cVSEntry.setAuthor(properties.getProperty(cVSEntry.getAuthor()));
            }
        }
    }

    public final void h(org.apache.tools.ant.taskdefs.cvslib.CVSEntry[] cVSEntryArr) throws org.apache.tools.ant.BuildException {
        java.io.FileOutputStream fileOutputStream;
        java.io.FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new java.io.FileOutputStream(this.T);
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.io.UnsupportedEncodingException e) {
            e = e;
        } catch (java.io.IOException e2) {
            e = e2;
        }
        try {
            java.io.PrintWriter printWriter = new java.io.PrintWriter(new java.io.OutputStreamWriter(fileOutputStream, "UTF-8"));
            new org.apache.tools.ant.taskdefs.cvslib.ChangeLogWriter().printChangeLog(printWriter, cVSEntryArr);
            if (printWriter.checkError()) {
                throw new java.io.IOException("Encountered an error writing changelog");
            }
            org.apache.tools.ant.util.FileUtils.close(fileOutputStream);
        } catch (java.io.UnsupportedEncodingException e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            getProject().log(e.toString(), 0);
            org.apache.tools.ant.util.FileUtils.close(fileOutputStream2);
        } catch (java.io.IOException e4) {
            e = e4;
            throw new org.apache.tools.ant.BuildException(e.toString(), e);
        } catch (java.lang.Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            org.apache.tools.ant.util.FileUtils.close(fileOutputStream2);
            throw th;
        }
    }

    public void setDaysinpast(int i) {
        setStart(new java.util.Date(java.lang.System.currentTimeMillis() - ((((i * 24) * 60) * 60) * 1000)));
    }

    public void setDestfile(java.io.File file) {
        this.T = file;
    }

    public void setDir(java.io.File file) {
        this.S = file;
    }

    public void setEnd(java.util.Date date) {
        this.V = date;
    }

    public void setEndTag(java.lang.String str) {
        this.Y = str;
    }

    public void setRemote(boolean z) {
        this.W = z;
    }

    public void setStart(java.util.Date date) {
        this.U = date;
    }

    public void setStartTag(java.lang.String str) {
        this.X = str;
    }

    public void setUsersfile(java.io.File file) {
        this.Q = file;
    }

    public final void validate() throws org.apache.tools.ant.BuildException {
        if (this.S == null) {
            this.S = getProject().getBaseDir();
        }
        if (this.T == null) {
            throw new org.apache.tools.ant.BuildException("Destfile must be set.");
        }
        if (!this.S.exists()) {
            throw new org.apache.tools.ant.BuildException("Cannot find base dir " + this.S.getAbsolutePath());
        }
        java.io.File file = this.Q;
        if (file != null && !file.exists()) {
            throw new org.apache.tools.ant.BuildException("Cannot find user lookup list " + this.Q.getAbsolutePath());
        }
        if (this.X == null && this.Y == null) {
            return;
        }
        if (this.U != null || this.V != null) {
            throw new org.apache.tools.ant.BuildException("Specify either a tag or date range, not both");
        }
    }
}
