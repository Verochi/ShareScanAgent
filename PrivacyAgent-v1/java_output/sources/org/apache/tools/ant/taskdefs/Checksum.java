package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Checksum extends org.apache.tools.ant.taskdefs.MatchingTask implements org.apache.tools.ant.taskdefs.condition.Condition {
    public java.lang.String C;
    public boolean D;
    public java.lang.String E;
    public java.security.MessageDigest H;
    public boolean I;
    public java.io.File v;
    public java.lang.String y;
    public java.lang.String z;
    public java.io.File u = null;
    public java.lang.String w = "MD5";
    public java.lang.String x = null;
    public java.util.Map<java.io.File, byte[]> A = new java.util.HashMap();
    public java.util.Map<java.io.File, java.lang.String> B = new java.util.HashMap();
    public org.apache.tools.ant.taskdefs.Checksum.FileUnion F = null;
    public java.util.Hashtable<java.io.File, java.lang.Object> G = new java.util.Hashtable<>();
    public int J = 8192;
    public java.text.MessageFormat K = org.apache.tools.ant.taskdefs.Checksum.FormatElement.getDefault().getFormat();

    /* renamed from: org.apache.tools.ant.taskdefs.Checksum$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.Comparator<java.io.File> {
        public AnonymousClass1() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(java.io.File file, java.io.File file2) {
            if (file == null) {
                return file2 == null ? 0 : -1;
            }
            if (file2 == null) {
                return 1;
            }
            return org.apache.tools.ant.taskdefs.Checksum.this.h(file).compareTo(org.apache.tools.ant.taskdefs.Checksum.this.h(file2));
        }
    }

    public static class FileUnion extends org.apache.tools.ant.types.resources.Restrict {
        public org.apache.tools.ant.types.resources.Union u;

        public FileUnion() {
            org.apache.tools.ant.types.resources.Union union = new org.apache.tools.ant.types.resources.Union();
            this.u = union;
            super.add(union);
            super.add(org.apache.tools.ant.types.resources.selectors.Type.FILE);
        }

        @Override // org.apache.tools.ant.types.resources.Restrict
        public void add(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
            this.u.add(resourceCollection);
        }
    }

    public static class FormatElement extends org.apache.tools.ant.types.EnumeratedAttribute {
        public static java.util.HashMap<java.lang.String, java.text.MessageFormat> b;

        static {
            java.util.HashMap<java.lang.String, java.text.MessageFormat> hashMap = new java.util.HashMap<>();
            b = hashMap;
            hashMap.put("CHECKSUM", new java.text.MessageFormat("{0}"));
            b.put("MD5SUM", new java.text.MessageFormat("{0} *{1}"));
            b.put("SVF", new java.text.MessageFormat("MD5 ({1}) = {0}"));
        }

        public static org.apache.tools.ant.taskdefs.Checksum.FormatElement getDefault() {
            org.apache.tools.ant.taskdefs.Checksum.FormatElement formatElement = new org.apache.tools.ant.taskdefs.Checksum.FormatElement();
            formatElement.setValue("CHECKSUM");
            return formatElement;
        }

        public java.text.MessageFormat getFormat() {
            return b.get(getValue());
        }

        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return new java.lang.String[]{"CHECKSUM", "MD5SUM", "SVF"};
        }
    }

    public static byte[] decodeHex(char[] cArr) throws org.apache.tools.ant.BuildException {
        int length = cArr.length;
        if ((length & 1) != 0) {
            throw new org.apache.tools.ant.BuildException("odd number of characters.");
        }
        byte[] bArr = new byte[length >> 1];
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            bArr[i2] = (byte) (((java.lang.Character.digit(cArr[i], 16) << 4) | java.lang.Character.digit(cArr[i3], 16)) & 255);
            i2++;
            i = i3 + 1;
        }
        return bArr;
    }

    public void add(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        if (resourceCollection == null) {
            return;
        }
        org.apache.tools.ant.taskdefs.Checksum.FileUnion fileUnion = this.F;
        if (fileUnion == null) {
            fileUnion = new org.apache.tools.ant.taskdefs.Checksum.FileUnion();
        }
        this.F = fileUnion;
        fileUnion.add(resourceCollection);
    }

    public void addFileset(org.apache.tools.ant.types.FileSet fileSet) {
        add(fileSet);
    }

    public final void d(java.io.File file) throws org.apache.tools.ant.BuildException {
        if (!file.exists()) {
            java.lang.String str = "Could not find file " + file.getAbsolutePath() + " to generate checksum for.";
            log(str);
            throw new org.apache.tools.ant.BuildException(str, getLocation());
        }
        java.lang.String str2 = this.z;
        if (str2 != null) {
            this.G.put(file, str2);
            return;
        }
        java.io.File g = g(file);
        if (this.D || this.I || file.lastModified() > g.lastModified()) {
            this.G.put(file, g);
            return;
        }
        log(file + " omitted as " + g + " is up to date.", 3);
        if (this.C != null) {
            this.A.put(file, decodeHex(i(g).toCharArray()));
        }
    }

    public final java.lang.String e(byte[] bArr) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (byte b : bArr) {
            java.lang.String hexString = java.lang.Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                sb.append("0");
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    @Override // org.apache.tools.ant.taskdefs.condition.Condition
    public boolean eval() throws org.apache.tools.ant.BuildException {
        this.I = true;
        return j();
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        this.I = false;
        boolean j = j();
        if (this.E != null) {
            getProject().setNewProperty(this.E, (j ? java.lang.Boolean.TRUE : java.lang.Boolean.FALSE).toString());
        }
    }

    public final boolean f() throws org.apache.tools.ant.BuildException {
        java.io.FileOutputStream fileOutputStream;
        boolean z;
        int i;
        byte[] bArr = new byte[this.J];
        java.io.FileInputStream fileInputStream = null;
        try {
            java.util.Iterator<java.util.Map.Entry<java.io.File, java.lang.Object>> it = this.G.entrySet().iterator();
            loop0: while (true) {
                z = true;
                while (true) {
                    r6 = false;
                    boolean z2 = false;
                    if (!it.hasNext()) {
                        break loop0;
                    }
                    java.util.Map.Entry<java.io.File, java.lang.Object> next = it.next();
                    this.H.reset();
                    java.io.File key = next.getKey();
                    if (!this.I) {
                        log("Calculating " + this.w + " checksum for " + key, 3);
                    }
                    java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(key);
                    try {
                        java.security.DigestInputStream digestInputStream = new java.security.DigestInputStream(fileInputStream2, this.H);
                        do {
                        } while (digestInputStream.read(bArr, 0, this.J) != -1);
                        digestInputStream.close();
                        fileInputStream2.close();
                        byte[] digest = this.H.digest();
                        if (this.C != null) {
                            this.A.put(key, digest);
                        }
                        java.lang.String e = e(digest);
                        java.lang.Object value = next.getValue();
                        if (value instanceof java.lang.String) {
                            java.lang.String str = (java.lang.String) value;
                            if (this.I) {
                                if (z && e.equals(this.z)) {
                                    break;
                                }
                                z = false;
                            } else {
                                getProject().setNewProperty(str, e);
                            }
                        } else if (!(value instanceof java.io.File)) {
                            continue;
                        } else if (this.I) {
                            java.io.File file = (java.io.File) value;
                            if (file.exists()) {
                                try {
                                    java.lang.String i2 = i(file);
                                    if (z && e.equals(i2)) {
                                        z2 = true;
                                    }
                                    z = z2;
                                } catch (org.apache.tools.ant.BuildException unused) {
                                }
                            }
                            z = false;
                        } else {
                            java.io.File file2 = (java.io.File) value;
                            fileOutputStream = new java.io.FileOutputStream(file2);
                            try {
                                try {
                                    fileOutputStream.write(this.K.format(new java.lang.Object[]{e, key.getName(), org.apache.tools.ant.util.FileUtils.getRelativePath(file2.getParentFile(), key), org.apache.tools.ant.util.FileUtils.getRelativePath(getProject().getBaseDir(), key), key.getAbsolutePath()}).getBytes());
                                    fileOutputStream.write(org.apache.tools.ant.util.StringUtils.LINE_SEP.getBytes());
                                    fileOutputStream.close();
                                } catch (java.lang.Exception e2) {
                                    e = e2;
                                    throw new org.apache.tools.ant.BuildException(e, getLocation());
                                }
                            } catch (java.lang.Throwable th) {
                                th = th;
                                org.apache.tools.ant.util.FileUtils.close(fileInputStream);
                                org.apache.tools.ant.util.FileUtils.close(fileOutputStream);
                                throw th;
                            }
                        }
                    } catch (java.lang.Exception e3) {
                        e = e3;
                        fileOutputStream = null;
                        fileInputStream = fileInputStream2;
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        fileOutputStream = null;
                        fileInputStream = fileInputStream2;
                        org.apache.tools.ant.util.FileUtils.close(fileInputStream);
                        org.apache.tools.ant.util.FileUtils.close(fileOutputStream);
                        throw th;
                    }
                }
            }
            if (this.C != null) {
                java.io.File[] fileArr = (java.io.File[]) this.A.keySet().toArray(new java.io.File[this.A.size()]);
                java.util.Arrays.sort(fileArr, new org.apache.tools.ant.taskdefs.Checksum.AnonymousClass1());
                this.H.reset();
                for (java.io.File file3 : fileArr) {
                    this.H.update(this.A.get(file3));
                    this.H.update(h(file3).getBytes());
                }
                getProject().setNewProperty(this.C, e(this.H.digest()));
            }
            org.apache.tools.ant.util.FileUtils.close((java.io.InputStream) null);
            org.apache.tools.ant.util.FileUtils.close((java.io.OutputStream) null);
            return z;
        } catch (java.lang.Exception e4) {
            e = e4;
            fileOutputStream = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    public final java.io.File g(java.io.File file) {
        java.io.File parentFile;
        if (this.v != null) {
            parentFile = new java.io.File(this.v, h(file)).getParentFile();
            parentFile.mkdirs();
        } else {
            parentFile = file.getParentFile();
        }
        return new java.io.File(parentFile, file.getName() + this.y);
    }

    public final java.lang.String h(java.io.File file) {
        java.lang.String str = this.B.get(file);
        if (str != null) {
            return str;
        }
        throw new org.apache.tools.ant.BuildException("Internal error: relativeFilePaths could not match file " + file + "\nplease file a bug report on this");
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0068: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:25:0x0068 */
    public final java.lang.String i(java.io.File file) {
        java.text.ParseException e;
        java.io.IOException e2;
        java.io.Reader reader;
        java.lang.Object obj;
        java.io.Reader reader2 = null;
        try {
            try {
                java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.FileReader(file));
                try {
                    java.lang.Object[] parse = this.K.parse(bufferedReader.readLine());
                    if (parse == null || parse.length == 0 || (obj = parse[0]) == null) {
                        throw new org.apache.tools.ant.BuildException("failed to find a checksum");
                    }
                    java.lang.String str = (java.lang.String) obj;
                    org.apache.tools.ant.util.FileUtils.close(bufferedReader);
                    return str;
                } catch (java.io.IOException e3) {
                    e2 = e3;
                    throw new org.apache.tools.ant.BuildException("Couldn't read checksum file " + file, e2);
                } catch (java.text.ParseException e4) {
                    e = e4;
                    throw new org.apache.tools.ant.BuildException("Couldn't read checksum file " + file, e);
                }
            } catch (java.lang.Throwable th) {
                th = th;
                reader2 = reader;
                org.apache.tools.ant.util.FileUtils.close(reader2);
                throw th;
            }
        } catch (java.io.IOException e5) {
            e2 = e5;
        } catch (java.text.ParseException e6) {
            e = e6;
        } catch (java.lang.Throwable th2) {
            th = th2;
            org.apache.tools.ant.util.FileUtils.close(reader2);
            throw th;
        }
    }

    public final boolean j() throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.taskdefs.Checksum.FileUnion fileUnion;
        java.lang.String str = this.y;
        if (this.u == null && ((fileUnion = this.F) == null || fileUnion.size() == 0)) {
            throw new org.apache.tools.ant.BuildException("Specify at least one source - a file or a resource collection.");
        }
        org.apache.tools.ant.taskdefs.Checksum.FileUnion fileUnion2 = this.F;
        if (fileUnion2 != null && !fileUnion2.isFilesystemOnly()) {
            throw new org.apache.tools.ant.BuildException("Can only calculate checksums for file-based resources.");
        }
        java.io.File file = this.u;
        if (file != null && file.exists() && this.u.isDirectory()) {
            throw new org.apache.tools.ant.BuildException("Checksum cannot be generated for directories");
        }
        if (this.u != null && this.C != null) {
            throw new org.apache.tools.ant.BuildException("File and Totalproperty cannot co-exist.");
        }
        java.lang.String str2 = this.z;
        if (str2 != null && this.y != null) {
            throw new org.apache.tools.ant.BuildException("Property and FileExt cannot co-exist.");
        }
        if (str2 != null) {
            if (this.D) {
                throw new org.apache.tools.ant.BuildException("ForceOverwrite cannot be used when Property is specified");
            }
            org.apache.tools.ant.taskdefs.Checksum.FileUnion fileUnion3 = this.F;
            int size = fileUnion3 != null ? 0 + fileUnion3.size() : 0;
            if (this.u != null) {
                size++;
            }
            if (size > 1) {
                throw new org.apache.tools.ant.BuildException("Multiple files cannot be used when Property is specified");
            }
        }
        java.lang.String str3 = this.E;
        if (str3 != null) {
            this.I = true;
        }
        if (str3 != null && this.D) {
            throw new org.apache.tools.ant.BuildException("VerifyProperty and ForceOverwrite cannot co-exist.");
        }
        if (this.I && this.D) {
            throw new org.apache.tools.ant.BuildException("ForceOverwrite cannot be used when conditions are being used.");
        }
        this.H = null;
        java.lang.String str4 = this.x;
        if (str4 != null) {
            try {
                this.H = java.security.MessageDigest.getInstance(this.w, str4);
            } catch (java.security.NoSuchAlgorithmException e) {
                throw new org.apache.tools.ant.BuildException(e, getLocation());
            } catch (java.security.NoSuchProviderException e2) {
                throw new org.apache.tools.ant.BuildException(e2, getLocation());
            }
        } else {
            try {
                this.H = java.security.MessageDigest.getInstance(this.w);
            } catch (java.security.NoSuchAlgorithmException e3) {
                throw new org.apache.tools.ant.BuildException(e3, getLocation());
            }
        }
        if (this.H == null) {
            throw new org.apache.tools.ant.BuildException("Unable to create Message Digest", getLocation());
        }
        java.lang.String str5 = this.y;
        if (str5 == null) {
            this.y = "." + this.w;
        } else if (str5.trim().length() == 0) {
            throw new org.apache.tools.ant.BuildException("File extension when specified must not be an empty string");
        }
        try {
            org.apache.tools.ant.taskdefs.Checksum.FileUnion fileUnion4 = this.F;
            if (fileUnion4 != null) {
                java.util.Iterator<org.apache.tools.ant.types.Resource> it = fileUnion4.iterator();
                while (it.hasNext()) {
                    org.apache.tools.ant.types.Resource next = it.next();
                    java.io.File file2 = ((org.apache.tools.ant.types.resources.FileProvider) next.as(org.apache.tools.ant.types.resources.FileProvider.class)).getFile();
                    if (this.C != null || this.v != null) {
                        this.B.put(file2, next.getName().replace(java.io.File.separatorChar, '/'));
                    }
                    d(file2);
                }
            }
            java.io.File file3 = this.u;
            if (file3 != null) {
                if (this.C != null || this.v != null) {
                    this.B.put(file3, file3.getName().replace(java.io.File.separatorChar, '/'));
                }
                d(this.u);
            }
            return f();
        } finally {
            this.y = str;
            this.G.clear();
        }
    }

    public void setAlgorithm(java.lang.String str) {
        this.w = str;
    }

    public void setFile(java.io.File file) {
        this.u = file;
    }

    public void setFileext(java.lang.String str) {
        this.y = str;
    }

    public void setForceOverwrite(boolean z) {
        this.D = z;
    }

    public void setFormat(org.apache.tools.ant.taskdefs.Checksum.FormatElement formatElement) {
        this.K = formatElement.getFormat();
    }

    public void setPattern(java.lang.String str) {
        this.K = new java.text.MessageFormat(str);
    }

    public void setProperty(java.lang.String str) {
        this.z = str;
    }

    public void setProvider(java.lang.String str) {
        this.x = str;
    }

    public void setReadBufferSize(int i) {
        this.J = i;
    }

    public void setTodir(java.io.File file) {
        this.v = file;
    }

    public void setTotalproperty(java.lang.String str) {
        this.C = str;
    }

    public void setVerifyproperty(java.lang.String str) {
        this.E = str;
    }
}
