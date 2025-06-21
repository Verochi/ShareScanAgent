package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class FixCRLF extends org.apache.tools.ant.taskdefs.MatchingTask implements org.apache.tools.ant.filters.ChainableReader {
    public static final org.apache.tools.ant.util.FileUtils C = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public static final java.lang.String ERROR_FILE_AND_SRCDIR = "<fixcrlf> error: srcdir and file are mutually exclusive";
    public java.io.File v;
    public java.io.File x;
    public boolean u = false;
    public java.io.File w = null;
    public org.apache.tools.ant.filters.FixCrLfFilter y = new org.apache.tools.ant.filters.FixCrLfFilter();
    public java.util.Vector<org.apache.tools.ant.types.FilterChain> z = null;
    public java.lang.String A = null;
    public java.lang.String B = null;

    public static class AddAsisRemove extends org.apache.tools.ant.types.EnumeratedAttribute {
        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return new java.lang.String[]{com.anythink.expressad.d.a.b.ay, "asis", "remove"};
        }
    }

    public static class CrLf extends org.apache.tools.ant.types.EnumeratedAttribute {
        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return new java.lang.String[]{"asis", com.getui.gtc.extension.distribution.gbd.f.h.p, "lf", "crlf", "mac", org.apache.tools.ant.taskdefs.condition.Os.FAMILY_UNIX, org.apache.tools.ant.taskdefs.condition.Os.FAMILY_DOS};
        }
    }

    public class OneLiner implements java.util.Enumeration<java.lang.Object> {
        public int a;
        public java.io.BufferedReader d;
        public java.io.File g;
        public java.lang.StringBuffer b = new java.lang.StringBuffer(200);
        public java.lang.StringBuffer c = new java.lang.StringBuffer();
        public java.lang.StringBuffer e = new java.lang.StringBuffer();
        public boolean f = false;

        public class BufferLine {
            public java.lang.String d;
            public java.lang.String e;
            public int c = -1;
            public int a = 0;
            public int b = 0;

            public BufferLine(java.lang.String str, java.lang.String str2) throws org.apache.tools.ant.BuildException {
                this.d = str;
                this.e = str2;
            }
        }

        public OneLiner(java.io.File file) throws org.apache.tools.ant.BuildException {
            this.a = org.apache.tools.ant.taskdefs.FixCRLF.this.y.getJavafiles() ? 1 : 0;
            this.g = file;
            try {
                this.d = new java.io.BufferedReader(org.apache.tools.ant.taskdefs.FixCRLF.this.A == null ? new java.io.FileReader(file) : new java.io.InputStreamReader(new java.io.FileInputStream(file), org.apache.tools.ant.taskdefs.FixCRLF.this.A), 8192);
                nextLine();
            } catch (java.io.IOException e) {
                throw new org.apache.tools.ant.BuildException(file + ": " + e.getMessage(), e, org.apache.tools.ant.taskdefs.FixCRLF.this.getLocation());
            }
        }

        public void close() throws java.io.IOException {
            java.io.BufferedReader bufferedReader = this.d;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }

        public java.lang.String getEofStr() {
            return this.c.substring(0);
        }

        public int getState() {
            return this.a;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return !this.f;
        }

        @Override // java.util.Enumeration
        public java.lang.Object nextElement() throws java.util.NoSuchElementException {
            if (!hasMoreElements()) {
                throw new java.util.NoSuchElementException("OneLiner");
            }
            org.apache.tools.ant.taskdefs.FixCRLF.OneLiner.BufferLine bufferLine = new org.apache.tools.ant.taskdefs.FixCRLF.OneLiner.BufferLine(this.e.toString(), this.b.substring(0));
            nextLine();
            return bufferLine;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0085 A[Catch: IOException -> 0x00c3, TryCatch #0 {IOException -> 0x00c3, blocks: (B:3:0x000e, B:8:0x001f, B:12:0x002f, B:14:0x0037, B:17:0x003a, B:22:0x0085, B:23:0x008b, B:25:0x008e, B:29:0x0099, B:31:0x00a2, B:33:0x00b5, B:35:0x00bd, B:40:0x0042, B:44:0x0059, B:45:0x005f, B:47:0x0068, B:48:0x0071, B:49:0x0077, B:51:0x007d), top: B:2:0x000e }] */
        /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void nextLine() throws org.apache.tools.ant.BuildException {
            char c;
            this.b = new java.lang.StringBuffer();
            this.e = new java.lang.StringBuffer();
            try {
                int read = this.d.read();
                while (read != -1 && read != 13 && read != 10) {
                    this.e.append((char) read);
                    read = this.d.read();
                }
                if (read == -1 && this.e.length() == 0) {
                    this.f = true;
                    return;
                }
                char c2 = (char) read;
                if (c2 != '\n') {
                    if (c2 != '\r') {
                        c = 0;
                    } else {
                        this.b.append('\r');
                        c = 2;
                        this.d.mark(2);
                        int read2 = this.d.read();
                        if (read2 != -1) {
                            if (read2 == 10) {
                                this.b.append('\n');
                            } else if (read2 != 13) {
                                this.d.reset();
                            } else if (((char) this.d.read()) == '\n') {
                                this.b.append("\r\n");
                                c = 3;
                            } else {
                                this.d.reset();
                            }
                        }
                    }
                    if (c != 0) {
                        int length = this.e.length();
                        do {
                            length--;
                            if (length < 0) {
                                break;
                            }
                        } while (this.e.charAt(length) == 26);
                        if (length < this.e.length() - 1) {
                            int i = length + 1;
                            this.c.append(this.e.toString().substring(i));
                            if (length >= 0) {
                                this.e.setLength(i);
                                return;
                            } else {
                                this.e.setLength(0);
                                this.f = true;
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                this.b.append('\n');
                c = 1;
                if (c != 0) {
                }
            } catch (java.io.IOException e) {
                throw new org.apache.tools.ant.BuildException(this.g + ": " + e.getMessage(), e, org.apache.tools.ant.taskdefs.FixCRLF.this.getLocation());
            }
        }

        public void setState(int i) {
            this.a = i;
        }
    }

    @Override // org.apache.tools.ant.filters.ChainableReader
    public final java.io.Reader chain(java.io.Reader reader) {
        return this.y.chain(reader);
    }

    public final void e(java.lang.String str) throws org.apache.tools.ant.BuildException {
        java.io.File file;
        org.apache.tools.ant.util.FileUtils fileUtils;
        boolean z;
        java.io.File file2 = new java.io.File(this.v, str);
        long lastModified = file2.lastModified();
        java.io.File file3 = this.w;
        if (file3 == null) {
            file3 = this.v;
        }
        java.io.File file4 = file3;
        if (this.z == null) {
            org.apache.tools.ant.types.FilterChain filterChain = new org.apache.tools.ant.types.FilterChain();
            filterChain.add(this.y);
            java.util.Vector<org.apache.tools.ant.types.FilterChain> vector = new java.util.Vector<>(1);
            this.z = vector;
            vector.add(filterChain);
        }
        org.apache.tools.ant.util.FileUtils fileUtils2 = C;
        java.io.File createTempFile = fileUtils2.createTempFile(getProject(), "fixcrlf", "", null, true, true);
        try {
            java.util.Vector<org.apache.tools.ant.types.FilterChain> vector2 = this.z;
            java.lang.String str2 = this.A;
            java.lang.String str3 = this.B;
            try {
                fileUtils2.copyFile(file2, createTempFile, (org.apache.tools.ant.types.FilterSetCollection) null, (java.util.Vector) vector2, true, false, str2, str3 == null ? str2 : str3, getProject());
                java.io.File file5 = new java.io.File(file4, str);
                if (file5.exists()) {
                    log("destFile " + file5 + " exists", 4);
                    fileUtils = fileUtils2;
                    file = createTempFile;
                    try {
                        try {
                            z = !fileUtils.contentEquals(file5, file);
                            java.lang.StringBuilder sb = new java.lang.StringBuilder();
                            sb.append(file5);
                            sb.append(z ? " is being written" : " is not written, as the contents are identical");
                            log(sb.toString(), 4);
                        } catch (java.io.IOException e) {
                            e = e;
                            throw new org.apache.tools.ant.BuildException("error running fixcrlf on file " + file2, e);
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                        if (file != null && file.exists()) {
                            C.tryHardToDelete(file);
                        }
                        throw th;
                    }
                } else {
                    fileUtils = fileUtils2;
                    file = createTempFile;
                    z = true;
                }
                if (z) {
                    fileUtils.rename(file, file5);
                    if (this.u) {
                        log("preserved lastModified for " + file5, 4);
                        fileUtils.setFileLastModified(file5, lastModified);
                    }
                }
                if (file == null || !file.exists()) {
                    return;
                }
                fileUtils.tryHardToDelete(file);
            } catch (java.io.IOException e2) {
                e = e2;
                file = createTempFile;
            } catch (java.lang.Throwable th2) {
                th = th2;
                file = createTempFile;
                if (file != null) {
                    C.tryHardToDelete(file);
                }
                throw th;
            }
        } catch (java.io.IOException e3) {
            e = e3;
            file = createTempFile;
        } catch (java.lang.Throwable th3) {
            th = th3;
            file = createTempFile;
        }
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        validate();
        java.lang.String str = this.A;
        if (str == null) {
            str = "default";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("options: eol=");
        sb.append(this.y.getEol().getValue());
        sb.append(" tab=");
        sb.append(this.y.getTab().getValue());
        sb.append(" eof=");
        sb.append(this.y.getEof().getValue());
        sb.append(" tablength=");
        sb.append(this.y.getTablength());
        sb.append(" encoding=");
        sb.append(str);
        sb.append(" outputencoding=");
        java.lang.String str2 = this.B;
        if (str2 != null) {
            str = str2;
        }
        sb.append(str);
        log(sb.toString(), 3);
        for (java.lang.String str3 : super.getDirectoryScanner(this.v).getIncludedFiles()) {
            e(str3);
        }
    }

    public void setCr(org.apache.tools.ant.taskdefs.FixCRLF.AddAsisRemove addAsisRemove) {
        log("DEPRECATED: The cr attribute has been deprecated,", 1);
        log("Please use the eol attribute instead", 1);
        java.lang.String value = addAsisRemove.getValue();
        org.apache.tools.ant.taskdefs.FixCRLF.CrLf crLf = new org.apache.tools.ant.taskdefs.FixCRLF.CrLf();
        if (value.equals("remove")) {
            crLf.setValue("lf");
        } else if (value.equals("asis")) {
            crLf.setValue("asis");
        } else {
            crLf.setValue("crlf");
        }
        setEol(crLf);
    }

    public void setDestdir(java.io.File file) {
        this.w = file;
    }

    public void setEncoding(java.lang.String str) {
        this.A = str;
    }

    public void setEof(org.apache.tools.ant.taskdefs.FixCRLF.AddAsisRemove addAsisRemove) {
        this.y.setEof(org.apache.tools.ant.filters.FixCrLfFilter.AddAsisRemove.newInstance(addAsisRemove.getValue()));
    }

    public void setEol(org.apache.tools.ant.taskdefs.FixCRLF.CrLf crLf) {
        this.y.setEol(org.apache.tools.ant.filters.FixCrLfFilter.CrLf.newInstance(crLf.getValue()));
    }

    public void setFile(java.io.File file) {
        this.x = file;
    }

    public void setFixlast(boolean z) {
        this.y.setFixlast(z);
    }

    public void setJavafiles(boolean z) {
        this.y.setJavafiles(z);
    }

    public void setOutputEncoding(java.lang.String str) {
        this.B = str;
    }

    public void setPreserveLastModified(boolean z) {
        this.u = z;
    }

    public void setSrcdir(java.io.File file) {
        this.v = file;
    }

    public void setTab(org.apache.tools.ant.taskdefs.FixCRLF.AddAsisRemove addAsisRemove) {
        this.y.setTab(org.apache.tools.ant.filters.FixCrLfFilter.AddAsisRemove.newInstance(addAsisRemove.getValue()));
    }

    public void setTablength(int i) throws org.apache.tools.ant.BuildException {
        try {
            this.y.setTablength(i);
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException(e.getMessage(), e);
        }
    }

    public final void validate() throws org.apache.tools.ant.BuildException {
        java.io.File file = this.x;
        if (file != null) {
            if (this.v != null) {
                throw new org.apache.tools.ant.BuildException(ERROR_FILE_AND_SRCDIR);
            }
            this.fileset.setFile(file);
            this.v = this.x.getParentFile();
        }
        java.io.File file2 = this.v;
        if (file2 == null) {
            throw new org.apache.tools.ant.BuildException("<fixcrlf> error: srcdir attribute must be set!");
        }
        if (!file2.exists()) {
            throw new org.apache.tools.ant.BuildException("<fixcrlf> error: srcdir does not exist: '" + this.v + "'");
        }
        if (!this.v.isDirectory()) {
            throw new org.apache.tools.ant.BuildException("<fixcrlf> error: srcdir is not a directory: '" + this.v + "'");
        }
        java.io.File file3 = this.w;
        if (file3 != null) {
            if (!file3.exists()) {
                throw new org.apache.tools.ant.BuildException("<fixcrlf> error: destdir does not exist: '" + this.w + "'");
            }
            if (this.w.isDirectory()) {
                return;
            }
            throw new org.apache.tools.ant.BuildException("<fixcrlf> error: destdir is not a directory: '" + this.w + "'");
        }
    }
}
