package org.apache.tools.ant.taskdefs.optional.i18n;

/* loaded from: classes25.dex */
public class Translate extends org.apache.tools.ant.taskdefs.MatchingTask {
    public static final org.apache.tools.ant.util.FileUtils L = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public java.lang.String A;
    public java.lang.String B;
    public java.lang.String C;
    public java.lang.String D;
    public boolean E;
    public long I;
    public long J;
    public java.lang.String u;
    public java.lang.String v;
    public java.lang.String w;
    public java.lang.String x;
    public java.io.File y;
    public java.lang.String z;
    public java.util.Vector F = new java.util.Vector();
    public java.util.Hashtable G = new java.util.Hashtable();
    public long[] H = new long[7];
    public boolean K = false;

    public void addFileset(org.apache.tools.ant.types.FileSet fileSet) {
        this.F.addElement(fileSet);
    }

    public final void c(java.io.FileInputStream fileInputStream) throws org.apache.tools.ant.BuildException {
        try {
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(fileInputStream, this.B));
            while (true) {
                java.lang.String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    return;
                }
                if (readLine.trim().length() > 1 && '#' != readLine.charAt(0) && '!' != readLine.charAt(0)) {
                    int indexOf = readLine.indexOf(61);
                    if (-1 == indexOf) {
                        indexOf = readLine.indexOf(58);
                    }
                    if (-1 == indexOf) {
                        int i = 0;
                        while (true) {
                            if (i >= readLine.length()) {
                                break;
                            }
                            if (java.lang.Character.isSpaceChar(readLine.charAt(i))) {
                                indexOf = i;
                                break;
                            }
                            i++;
                        }
                    }
                    if (-1 != indexOf) {
                        java.lang.String trim = readLine.substring(0, indexOf).trim();
                        java.lang.String trim2 = readLine.substring(indexOf + 1).trim();
                        while (trim2.endsWith("\\")) {
                            trim2 = trim2.substring(0, trim2.length() - 1);
                            java.lang.String readLine2 = bufferedReader.readLine();
                            if (readLine2 == null) {
                                break;
                            }
                            trim2 = trim2 + readLine2.trim();
                        }
                        if (trim.length() > 0 && this.G.get(trim) == null) {
                            this.G.put(trim, trim2);
                        }
                    }
                }
            }
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException(e.getMessage(), getLocation());
        }
    }

    public final void d() throws org.apache.tools.ant.BuildException {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String str5;
        java.util.Locale locale = new java.util.Locale(this.v, this.w, this.x);
        java.lang.String str6 = "";
        if (locale.getLanguage().length() > 0) {
            str = "_" + locale.getLanguage();
        } else {
            str = "";
        }
        if (locale.getCountry().length() > 0) {
            str2 = "_" + locale.getCountry();
        } else {
            str2 = "";
        }
        if (locale.getVariant().length() > 0) {
            str3 = "_" + locale.getVariant();
        } else {
            str3 = "";
        }
        e(this.u + str + str2 + str3, 0, false);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.u);
        sb.append(str);
        sb.append(str2);
        e(sb.toString(), 1, false);
        e(this.u + str, 2, false);
        e(this.u, 3, false);
        java.util.Locale locale2 = java.util.Locale.getDefault();
        if (locale2.getLanguage().length() > 0) {
            str4 = "_" + locale2.getLanguage();
        } else {
            str4 = "";
        }
        if (locale2.getCountry().length() > 0) {
            str5 = "_" + locale2.getCountry();
        } else {
            str5 = "";
        }
        if (locale2.getVariant().length() > 0) {
            str6 = "_" + locale2.getVariant();
        }
        this.B = java.lang.System.getProperty("file.encoding");
        e(this.u + str4 + str5 + str6, 4, false);
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(this.u);
        sb2.append(str4);
        sb2.append(str5);
        e(sb2.toString(), 5, false);
        e(this.u + str4, 6, true);
    }

    public final void e(java.lang.String str, int i, boolean z) throws org.apache.tools.ant.BuildException {
        java.io.File resolveFile = getProject().resolveFile(str + ".properties");
        try {
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(resolveFile);
            this.K = true;
            this.H[i] = resolveFile.lastModified();
            log("Using " + resolveFile, 4);
            c(fileInputStream);
        } catch (java.io.IOException e) {
            log(resolveFile + " not found.", 4);
            if (!this.K && z) {
                throw new org.apache.tools.ant.BuildException(e.getMessage(), getLocation());
            }
        }
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        if (this.u == null) {
            throw new org.apache.tools.ant.BuildException("The bundle attribute must be set.", getLocation());
        }
        if (this.C == null) {
            throw new org.apache.tools.ant.BuildException("The starttoken attribute must be set.", getLocation());
        }
        if (this.D == null) {
            throw new org.apache.tools.ant.BuildException("The endtoken attribute must be set.", getLocation());
        }
        if (this.v == null) {
            this.v = java.util.Locale.getDefault().getLanguage();
        }
        if (this.w == null) {
            this.w = java.util.Locale.getDefault().getCountry();
        }
        if (this.x == null) {
            this.x = new java.util.Locale(this.v, this.w).getVariant();
        }
        java.io.File file = this.y;
        if (file == null) {
            throw new org.apache.tools.ant.BuildException("The todir attribute must be set.", getLocation());
        }
        if (!file.exists()) {
            this.y.mkdirs();
        } else if (this.y.isFile()) {
            throw new org.apache.tools.ant.BuildException(this.y + " is not a directory");
        }
        if (this.z == null) {
            this.z = java.lang.System.getProperty("file.encoding");
        }
        if (this.A == null) {
            this.A = this.z;
        }
        if (this.B == null) {
            this.B = this.z;
        }
        d();
        f();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a1 A[Catch: IOException -> 0x00db, TryCatch #1 {IOException -> 0x00db, blocks: (B:8:0x0028, B:13:0x005c, B:15:0x0078, B:23:0x008c, B:27:0x009c, B:33:0x00a1, B:36:0x00bb, B:42:0x0044, B:10:0x0030, B:12:0x003f), top: B:7:0x0028, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bb A[Catch: IOException -> 0x00db, TRY_LEAVE, TryCatch #1 {IOException -> 0x00db, blocks: (B:8:0x0028, B:13:0x005c, B:15:0x0078, B:23:0x008c, B:27:0x009c, B:33:0x00a1, B:36:0x00bb, B:42:0x0044, B:10:0x0030, B:12:0x003f), top: B:7:0x0028, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void f() throws org.apache.tools.ant.BuildException {
        int i;
        boolean z;
        int size = this.F.size();
        int i2 = 0;
        int i3 = 0;
        while (i3 < size) {
            org.apache.tools.ant.DirectoryScanner directoryScanner = ((org.apache.tools.ant.types.FileSet) this.F.elementAt(i3)).getDirectoryScanner(getProject());
            java.lang.String[] includedFiles = directoryScanner.getIncludedFiles();
            int length = includedFiles.length;
            int i4 = i2;
            int i5 = 0;
            while (i5 < length) {
                java.lang.String str = includedFiles[i5];
                try {
                    java.io.File resolveFile = L.resolveFile(this.y, str);
                    try {
                        java.io.File file = new java.io.File(resolveFile.getParent());
                        if (!file.exists()) {
                            file.mkdirs();
                        }
                    } catch (java.lang.Exception e) {
                        log("Exception occurred while trying to check/create  parent directory.  " + e.getMessage(), 4);
                    }
                    this.J = resolveFile.lastModified();
                    java.io.File resolveFile2 = L.resolveFile(directoryScanner.getBasedir(), str);
                    long lastModified = resolveFile2.lastModified();
                    this.I = lastModified;
                    if (this.E) {
                        i = i3;
                    } else {
                        i = i3;
                        if (this.J >= lastModified) {
                            z = false;
                            if (!z) {
                                for (int i6 = 0; i6 < 7; i6++) {
                                    z = this.J < this.H[i6];
                                    if (z) {
                                        break;
                                    }
                                }
                            }
                            if (z) {
                                log("Skipping " + str + " as destination file is up to date", 3);
                            } else {
                                log("Processing " + str, 4);
                                g(resolveFile2, resolveFile);
                                i4++;
                            }
                            i5++;
                            i3 = i;
                        }
                    }
                    z = true;
                    if (!z) {
                    }
                    if (z) {
                    }
                    i5++;
                    i3 = i;
                } catch (java.io.IOException e2) {
                    throw new org.apache.tools.ant.BuildException(e2.getMessage(), getLocation());
                }
            }
            i3++;
            i2 = i4;
        }
        log("Translation performed on " + i2 + " file(s).", 4);
    }

    public final void g(java.io.File file, java.io.File file2) throws java.io.IOException {
        java.io.BufferedWriter bufferedWriter;
        java.lang.Throwable th;
        java.io.BufferedReader bufferedReader;
        java.lang.String str;
        int length;
        try {
            bufferedWriter = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(file2), this.A));
            try {
                bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream(file), this.z));
                try {
                    org.apache.tools.ant.util.LineTokenizer lineTokenizer = new org.apache.tools.ant.util.LineTokenizer();
                    lineTokenizer.setIncludeDelims(true);
                    java.lang.String token = lineTokenizer.getToken(bufferedReader);
                    while (token != null) {
                        int indexOf = token.indexOf(this.C);
                        while (indexOf >= 0 && this.C.length() + indexOf <= token.length()) {
                            int indexOf2 = token.indexOf(this.D, this.C.length() + indexOf);
                            if (indexOf2 >= 0) {
                                java.lang.String substring = token.substring(this.C.length() + indexOf, indexOf2);
                                boolean z = true;
                                for (int i = 0; i < substring.length() && z; i++) {
                                    char charAt = substring.charAt(i);
                                    if (charAt == ':' || charAt == '=' || java.lang.Character.isSpaceChar(charAt)) {
                                        z = false;
                                    }
                                }
                                if (z) {
                                    if (this.G.containsKey(substring)) {
                                        str = (java.lang.String) this.G.get(substring);
                                    } else {
                                        log("Replacement string missing for: " + substring, 3);
                                        str = this.C + substring + this.D;
                                    }
                                    token = token.substring(0, indexOf) + str + token.substring(indexOf2 + this.D.length());
                                    length = indexOf + str.length();
                                    indexOf = token.indexOf(this.C, length);
                                }
                            }
                            length = indexOf + 1;
                            indexOf = token.indexOf(this.C, length);
                        }
                        bufferedWriter.write(token);
                        token = lineTokenizer.getToken(bufferedReader);
                    }
                    org.apache.tools.ant.util.FileUtils.close(bufferedReader);
                    org.apache.tools.ant.util.FileUtils.close(bufferedWriter);
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    org.apache.tools.ant.util.FileUtils.close(bufferedReader);
                    org.apache.tools.ant.util.FileUtils.close(bufferedWriter);
                    throw th;
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (java.lang.Throwable th4) {
            bufferedWriter = null;
            th = th4;
            bufferedReader = null;
        }
    }

    public void setBundle(java.lang.String str) {
        this.u = str;
    }

    public void setBundleCountry(java.lang.String str) {
        this.w = str;
    }

    public void setBundleEncoding(java.lang.String str) {
        this.B = str;
    }

    public void setBundleLanguage(java.lang.String str) {
        this.v = str;
    }

    public void setBundleVariant(java.lang.String str) {
        this.x = str;
    }

    public void setDestEncoding(java.lang.String str) {
        this.A = str;
    }

    public void setEndToken(java.lang.String str) {
        this.D = str;
    }

    public void setForceOverwrite(boolean z) {
        this.E = z;
    }

    public void setSrcEncoding(java.lang.String str) {
        this.z = str;
    }

    public void setStartToken(java.lang.String str) {
        this.C = str;
    }

    public void setToDir(java.io.File file) {
        this.y = file;
    }
}
