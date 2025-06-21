package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Javac extends org.apache.tools.ant.taskdefs.MatchingTask {
    public static final org.apache.tools.ant.util.FileUtils e0 = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public static final byte[] f0 = {-54, -2, -70, -66, 0, 0, 0, org.apache.tools.tar.TarConstants.LF_LINK, 0, 7, 7, 0, 5, 7, 0, 6, 1, 0, 10, org.apache.tools.tar.TarConstants.LF_GNUTYPE_SPARSE, 111, 117, 114, 99, 101, 70, 105, 108, 101, 1, 0, 17, 112, 97, 99, 107, 97, org.apache.tools.tar.TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, 101, 45, 105, 110, 102, 111, 46, 106, 97, 118, 97, 1};
    public static final byte[] g0 = {47, 112, 97, 99, 107, 97, org.apache.tools.tar.TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, 101, 45, 105, 110, 102, 111, 1, 0, 16, 106, 97, 118, 97, 47, 108, 97, 110, org.apache.tools.tar.TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, 47, 79, 98, 106, 101, 99, 116, 2, 0, 0, 1, 0, 2, 0, 0, 0, 0, 0, 0, 0, 1, 0, 3, 0, 0, 0, 2, 0, 4};
    public org.apache.tools.ant.types.Path A;
    public org.apache.tools.ant.types.Path B;
    public java.lang.String C;
    public java.lang.String I;
    public java.lang.String J;
    public org.apache.tools.ant.types.Path K;
    public org.apache.tools.ant.types.Path L;
    public java.lang.Boolean M;
    public java.lang.String R;
    public java.lang.String S;
    public org.apache.tools.ant.util.facade.FacadeTaskHelper T;
    public java.lang.String V;
    public java.lang.String W;
    public java.io.File X;
    public java.lang.String Y;
    public java.lang.String Z;
    public org.apache.tools.ant.types.Path u;
    public java.io.File v;
    public java.io.File w;
    public org.apache.tools.ant.types.Path x;
    public org.apache.tools.ant.types.Path y;
    public org.apache.tools.ant.types.Path z;
    public boolean D = false;
    public boolean E = false;
    public boolean F = false;
    public boolean G = false;
    public boolean H = false;
    public boolean N = false;
    public boolean O = false;
    public java.lang.String P = null;
    public boolean Q = false;
    protected boolean failOnError = true;
    protected boolean listFiles = false;
    protected java.io.File[] compileList = new java.io.File[0];
    public java.util.Map<java.lang.String, java.lang.Long> U = new java.util.HashMap();
    public boolean a0 = true;
    public boolean b0 = true;
    public org.apache.tools.ant.taskdefs.compilers.CompilerAdapter c0 = null;
    public boolean d0 = true;

    /* renamed from: org.apache.tools.ant.taskdefs.Javac$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.io.FileFilter {
        @Override // java.io.FileFilter
        public boolean accept(java.io.File file) {
            return file.isDirectory();
        }
    }

    public class ImplementationSpecificArgument extends org.apache.tools.ant.util.facade.ImplementationSpecificArgument {
        public ImplementationSpecificArgument() {
        }

        public void setCompiler(java.lang.String str) {
            super.setImplementation(str);
        }
    }

    public Javac() {
        this.T = null;
        this.T = new org.apache.tools.ant.util.facade.FacadeTaskHelper(c());
    }

    public static java.util.Collection<? extends java.lang.CharSequence> f(java.lang.CharSequence charSequence) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(new java.lang.StringBuilder());
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        int i = 0;
        while (i < charSequence.length()) {
            char charAt = charSequence.charAt(i);
            if (charAt != '{') {
                sb.append(charAt);
            } else {
                int l = l(charSequence, i);
                if (l < 0) {
                    throw new org.apache.tools.ant.BuildException(java.lang.String.format("Unclosed group %s, starting at: %d", charSequence, java.lang.Integer.valueOf(i)));
                }
                java.util.Collection<? extends java.lang.CharSequence> o = o(charSequence.subSequence(i + 1, l));
                int size = o.size();
                if (size != 0) {
                    if (size != 1) {
                        java.util.ArrayList arrayList2 = new java.util.ArrayList(arrayList.size() * o.size());
                        for (java.lang.CharSequence charSequence2 : o) {
                            java.util.Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                java.lang.StringBuilder sb2 = new java.lang.StringBuilder((java.lang.CharSequence) it.next());
                                sb2.append((java.lang.CharSequence) sb);
                                sb2.append(charSequence2);
                                arrayList2.add(sb2);
                            }
                        }
                        sb = new java.lang.StringBuilder();
                        arrayList = arrayList2;
                    } else {
                        sb.append(o.iterator().next());
                    }
                }
                i = l;
            }
            i++;
        }
        java.util.Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((java.lang.StringBuilder) it2.next()).append((java.lang.CharSequence) sb);
        }
        return arrayList;
    }

    public static void g(java.io.File file, java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.util.Collection<java.io.File>> map) {
        java.io.File resolveFile = org.apache.tools.ant.util.FileUtils.getFileUtils().resolveFile(file, str);
        if (resolveFile.isDirectory()) {
            for (java.io.File file2 : resolveFile.listFiles(new org.apache.tools.ant.taskdefs.Javac.AnonymousClass1())) {
                java.lang.String name = file2.getName();
                if (str2 != null) {
                    file2 = new java.io.File(file2, str2);
                }
                java.util.Collection<java.io.File> collection = map.get(name);
                if (collection == null) {
                    collection = new java.util.ArrayList<>();
                    map.put(name, collection);
                }
                collection.add(file2);
            }
        }
    }

    public static void h(java.io.File file, java.lang.String str, java.util.Map<java.lang.String, java.util.Collection<java.io.File>> map) {
        java.lang.String replace = str.replace('/', java.io.File.separatorChar).replace('\\', java.io.File.separatorChar);
        int indexOf = replace.indexOf("*");
        if (indexOf == -1) {
            g(file, replace, null, map);
            return;
        }
        if (indexOf == 0) {
            throw new org.apache.tools.ant.BuildException("The modulesourcepath entry must be a folder.");
        }
        int i = indexOf + 1;
        if (replace.charAt(indexOf - 1) != java.io.File.separatorChar) {
            throw new org.apache.tools.ant.BuildException("The module mark must be preceded by separator");
        }
        if (i < replace.length() && replace.charAt(i) != java.io.File.separatorChar) {
            throw new org.apache.tools.ant.BuildException("The module mark must be followed by separator");
        }
        if (replace.indexOf("*", i) != -1) {
            throw new org.apache.tools.ant.BuildException("The modulesourcepath entry must contain at most one module mark");
        }
        g(file, replace.substring(0, indexOf), i != replace.length() ? replace.substring(i + 1) : null, map);
    }

    public static int l(java.lang.CharSequence charSequence, int i) {
        int i2 = 0;
        while (i < charSequence.length()) {
            char charAt = charSequence.charAt(i);
            if (charAt == '{') {
                i2++;
            } else if (charAt == '}' && i2 - 1 == 0) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static boolean m(org.apache.tools.ant.types.Path path) {
        return path != null && path.size() > 0;
    }

    public static java.util.Collection<? extends java.lang.CharSequence> o(java.lang.CharSequence charSequence) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < charSequence.length(); i3++) {
            char charAt = charSequence.charAt(i3);
            if (charAt != ',') {
                if (charAt == '{') {
                    i2++;
                } else if (charAt == '}') {
                    i2--;
                }
            } else if (i2 == 0) {
                arrayList.addAll(f(charSequence.subSequence(i, i3)));
                i = i3 + 1;
            }
        }
        arrayList.addAll(f(charSequence.subSequence(i, charSequence.length())));
        return arrayList;
    }

    public static java.util.Map<java.lang.String, java.util.Collection<java.io.File>> p(java.io.File file, java.lang.String str) {
        java.util.TreeMap treeMap = new java.util.TreeMap();
        java.util.Iterator<? extends java.lang.CharSequence> it = f(str).iterator();
        while (it.hasNext()) {
            h(file, it.next().toString(), treeMap);
        }
        return treeMap;
    }

    public void add(org.apache.tools.ant.taskdefs.compilers.CompilerAdapter compilerAdapter) {
        if (this.c0 != null) {
            throw new org.apache.tools.ant.BuildException("Can't have more than one compiler adapter");
        }
        this.c0 = compilerAdapter;
    }

    public final java.lang.String c() {
        return org.apache.tools.ant.util.JavaEnvUtils.isJavaVersion("1.4") ? "javac1.4" : org.apache.tools.ant.util.JavaEnvUtils.isJavaVersion(org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5) ? "javac1.5" : org.apache.tools.ant.util.JavaEnvUtils.isJavaVersion(org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_6) ? "javac1.6" : org.apache.tools.ant.util.JavaEnvUtils.isJavaVersion(org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_7) ? "javac1.7" : org.apache.tools.ant.util.JavaEnvUtils.isJavaVersion(org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_8) ? "javac1.8" : org.apache.tools.ant.util.JavaEnvUtils.isAtLeastJavaVersion(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QQ) ? "javac10+" : org.apache.tools.ant.util.JavaEnvUtils.isJavaVersion("9") ? "javac9" : "classic";
    }

    public void checkParameters() throws org.apache.tools.ant.BuildException {
        if (m(this.u)) {
            if (m(this.B)) {
                throw new org.apache.tools.ant.BuildException("modulesourcepath cannot be combined with srcdir attribute!", getLocation());
            }
        } else {
            if (!m(this.B)) {
                throw new org.apache.tools.ant.BuildException("either srcdir or modulesourcepath attribute must be set!", getLocation());
            }
            if (m(this.u) || m(this.A)) {
                throw new org.apache.tools.ant.BuildException("modulesourcepath cannot be combined with srcdir or sourcepath !", getLocation());
            }
            if (this.v == null) {
                throw new org.apache.tools.ant.BuildException("modulesourcepath requires destdir attribute to be set!", getLocation());
            }
        }
        java.io.File file = this.v;
        if (file != null && !file.isDirectory()) {
            throw new org.apache.tools.ant.BuildException("destination directory \"" + this.v + "\" does not exist or is not a directory", getLocation());
        }
        if (this.M == null && getProject().getProperty(org.apache.tools.ant.MagicNames.BUILD_SYSCLASSPATH) == null) {
            log(getLocation() + "warning: 'includeantruntime' was not set, defaulting to build.sysclasspath=last; set to false for repeatable builds", 1);
        }
    }

    public void compile() {
        java.lang.String compiler = getCompiler();
        if (this.compileList.length > 0) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Compiling ");
            sb.append(this.compileList.length);
            sb.append(" source file");
            java.lang.String str = "";
            sb.append(this.compileList.length == 1 ? "" : "s");
            if (this.v != null) {
                str = " to " + this.v;
            }
            sb.append(str);
            log(sb.toString());
            if (this.listFiles) {
                int i = 0;
                while (true) {
                    java.io.File[] fileArr = this.compileList;
                    if (i >= fileArr.length) {
                        break;
                    }
                    log(fileArr[i].getAbsolutePath());
                    i++;
                }
            }
            org.apache.tools.ant.taskdefs.compilers.CompilerAdapter compilerAdapter = this.c0;
            if (compilerAdapter == null) {
                compilerAdapter = org.apache.tools.ant.taskdefs.compilers.CompilerAdapterFactory.getCompiler(compiler, this, createCompilerClasspath());
            }
            compilerAdapter.setJavac(this);
            if (!compilerAdapter.execute()) {
                this.a0 = false;
                if (this.Z != null) {
                    getProject().setNewProperty(this.Z, com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE);
                }
                if (this.failOnError) {
                    throw new org.apache.tools.ant.BuildException("Compile failed; see the compiler error output for details.", getLocation());
                }
                log("Compile failed; see the compiler error output for details.", 0);
                return;
            }
            if (this.d0) {
                try {
                    java.io.File file = this.v;
                    if (file == null) {
                        file = getProject().resolveFile(this.u.list()[0]);
                    }
                    j(file);
                } catch (java.io.IOException e) {
                    throw new org.apache.tools.ant.BuildException(e, getLocation());
                }
            }
        }
    }

    public org.apache.tools.ant.types.Path createBootclasspath() {
        if (this.K == null) {
            this.K = new org.apache.tools.ant.types.Path(getProject());
        }
        return this.K.createPath();
    }

    public org.apache.tools.ant.types.Path createClasspath() {
        if (this.x == null) {
            this.x = new org.apache.tools.ant.types.Path(getProject());
        }
        return this.x.createPath();
    }

    public org.apache.tools.ant.taskdefs.Javac.ImplementationSpecificArgument createCompilerArg() {
        org.apache.tools.ant.taskdefs.Javac.ImplementationSpecificArgument implementationSpecificArgument = new org.apache.tools.ant.taskdefs.Javac.ImplementationSpecificArgument();
        this.T.addImplementationArgument(implementationSpecificArgument);
        return implementationSpecificArgument;
    }

    public org.apache.tools.ant.types.Path createCompilerClasspath() {
        return this.T.getImplementationClasspath(getProject());
    }

    public org.apache.tools.ant.types.Path createExtdirs() {
        if (this.L == null) {
            this.L = new org.apache.tools.ant.types.Path(getProject());
        }
        return this.L.createPath();
    }

    public org.apache.tools.ant.types.Path createModulepath() {
        if (this.y == null) {
            this.y = new org.apache.tools.ant.types.Path(getProject());
        }
        return this.y.createPath();
    }

    public org.apache.tools.ant.types.Path createModulesourcepath() {
        if (this.B == null) {
            this.B = new org.apache.tools.ant.types.Path(getProject());
        }
        return this.B.createPath();
    }

    public org.apache.tools.ant.types.Path createSourcepath() {
        if (this.A == null) {
            this.A = new org.apache.tools.ant.types.Path(getProject());
        }
        return this.A.createPath();
    }

    public org.apache.tools.ant.types.Path createSrc() {
        if (this.u == null) {
            this.u = new org.apache.tools.ant.types.Path(getProject());
        }
        return this.u.createPath();
    }

    public org.apache.tools.ant.types.Path createUpgrademodulepath() {
        if (this.z == null) {
            this.z = new org.apache.tools.ant.types.Path(getProject());
        }
        return this.z.createPath();
    }

    public final void d() {
        org.apache.tools.ant.util.FileUtils fileUtils = org.apache.tools.ant.util.FileUtils.getFileUtils();
        for (java.lang.String str : this.B.list()) {
            boolean z = false;
            for (java.util.Map.Entry<java.lang.String, java.util.Collection<java.io.File>> entry : p(getProject().getBaseDir(), str).entrySet()) {
                java.lang.String key = entry.getKey();
                for (java.io.File file : entry.getValue()) {
                    if (file.exists()) {
                        scanDir(file, fileUtils.resolveFile(this.v, key), getDirectoryScanner(file).getIncludedFiles());
                        z = true;
                    }
                }
            }
            if (!z) {
                throw new org.apache.tools.ant.BuildException("modulesourcepath \"" + str + "\" does not exist!", getLocation());
            }
        }
    }

    public final void e() {
        for (java.lang.String str : this.u.list()) {
            java.io.File resolveFile = getProject().resolveFile(str);
            if (!resolveFile.exists()) {
                throw new org.apache.tools.ant.BuildException("srcdir \"" + resolveFile.getPath() + "\" does not exist!", getLocation());
            }
            java.lang.String[] includedFiles = getDirectoryScanner(resolveFile).getIncludedFiles();
            java.io.File file = this.v;
            if (file == null) {
                file = resolveFile;
            }
            scanDir(resolveFile, file, includedFiles);
        }
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        checkParameters();
        resetFileLists();
        if (m(this.u)) {
            e();
        } else {
            d();
        }
        compile();
        if (this.Y == null || !this.a0 || this.compileList.length == 0) {
            return;
        }
        getProject().setNewProperty(this.Y, com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE);
    }

    public org.apache.tools.ant.types.Path getBootclasspath() {
        return this.K;
    }

    public org.apache.tools.ant.types.Path getClasspath() {
        return this.x;
    }

    public java.lang.String getCompiler() {
        java.lang.String compilerVersion = getCompilerVersion();
        if (!this.O) {
            return compilerVersion;
        }
        if (isJdkCompiler(compilerVersion)) {
            return "extJavac";
        }
        log("Since compiler setting isn't classic or modern, ignoring fork setting.", 1);
        return compilerVersion;
    }

    public java.lang.String getCompilerVersion() {
        this.T.setMagicValue(getProject().getProperty("build.compiler"));
        return this.T.getImplementation();
    }

    public java.lang.String[] getCurrentCompilerArgs() {
        java.lang.String explicitChoice = this.T.getExplicitChoice();
        try {
            this.T.setImplementation(getCompiler());
            java.lang.String[] args = this.T.getArgs();
            java.lang.String k = k(this.T.getImplementation());
            if (args.length == 0 && k != null) {
                this.T.setImplementation(k);
                args = this.T.getArgs();
            }
            return args;
        } finally {
            this.T.setImplementation(explicitChoice);
        }
    }

    public boolean getDebug() {
        return this.D;
    }

    public java.lang.String getDebugLevel() {
        return this.W;
    }

    public boolean getDepend() {
        return this.G;
    }

    public boolean getDeprecation() {
        return this.F;
    }

    public java.io.File getDestdir() {
        return this.v;
    }

    public java.lang.String getEncoding() {
        return this.C;
    }

    public java.lang.String getExecutable() {
        return this.P;
    }

    public org.apache.tools.ant.types.Path getExtdirs() {
        return this.L;
    }

    public boolean getFailonerror() {
        return this.failOnError;
    }

    public java.io.File[] getFileList() {
        return this.compileList;
    }

    public boolean getIncludeantruntime() {
        java.lang.Boolean bool = this.M;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public boolean getIncludejavaruntime() {
        return this.N;
    }

    public java.lang.String getJavacExecutable() {
        if (this.P == null && isForkedJavac()) {
            this.P = getSystemJavac();
        } else if (this.P != null && !isForkedJavac()) {
            this.P = null;
        }
        return this.P;
    }

    public boolean getListfiles() {
        return this.listFiles;
    }

    public java.lang.String getMemoryInitialSize() {
        return this.R;
    }

    public java.lang.String getMemoryMaximumSize() {
        return this.S;
    }

    public org.apache.tools.ant.types.Path getModulepath() {
        return this.y;
    }

    public org.apache.tools.ant.types.Path getModulesourcepath() {
        return this.B;
    }

    public java.io.File getNativeHeaderDir() {
        return this.w;
    }

    public boolean getNowarn() {
        return this.Q;
    }

    public boolean getOptimize() {
        return this.E;
    }

    public java.lang.String getRelease() {
        return this.J;
    }

    public java.lang.String getSource() {
        java.lang.String str = this.V;
        return str != null ? str : getProject().getProperty(org.apache.tools.ant.MagicNames.BUILD_JAVAC_SOURCE);
    }

    public org.apache.tools.ant.types.Path getSourcepath() {
        return this.A;
    }

    public org.apache.tools.ant.types.Path getSrcdir() {
        return this.u;
    }

    public java.lang.String getSystemJavac() {
        return org.apache.tools.ant.util.JavaEnvUtils.getJdkExecutable("javac");
    }

    public java.lang.String getTarget() {
        java.lang.String str = this.I;
        return str != null ? str : getProject().getProperty(org.apache.tools.ant.MagicNames.BUILD_JAVAC_TARGET);
    }

    public boolean getTaskSuccess() {
        return this.a0;
    }

    public java.io.File getTempdir() {
        return this.X;
    }

    public org.apache.tools.ant.types.Path getUpgrademodulepath() {
        return this.z;
    }

    public boolean getVerbose() {
        return this.H;
    }

    public final java.lang.String[] i() {
        java.lang.String compiler = getCompiler();
        org.apache.tools.ant.taskdefs.compilers.CompilerAdapter compilerAdapter = this.c0;
        if (compilerAdapter == null) {
            compilerAdapter = org.apache.tools.ant.taskdefs.compilers.CompilerAdapterFactory.getCompiler(compiler, this, createCompilerClasspath());
        }
        java.lang.String[] supportedFileExtensions = compilerAdapter instanceof org.apache.tools.ant.taskdefs.compilers.CompilerAdapterExtension ? ((org.apache.tools.ant.taskdefs.compilers.CompilerAdapterExtension) compilerAdapter).getSupportedFileExtensions() : null;
        if (supportedFileExtensions == null) {
            supportedFileExtensions = new java.lang.String[]{com.uc.crashsdk.export.LogType.JAVA_TYPE};
        }
        for (int i = 0; i < supportedFileExtensions.length; i++) {
            if (!supportedFileExtensions[i].startsWith("*.")) {
                supportedFileExtensions[i] = "*." + supportedFileExtensions[i];
            }
        }
        return supportedFileExtensions;
    }

    public boolean isForkedJavac() {
        return this.O || "extJavac".equalsIgnoreCase(getCompiler());
    }

    public boolean isIncludeDestClasses() {
        return this.b0;
    }

    public boolean isJdkCompiler(java.lang.String str) {
        return "modern".equals(str) || "classic".equals(str) || "javac10+".equals(str) || "javac9".equals(str) || "javac1.8".equals(str) || "javac1.7".equals(str) || "javac1.6".equals(str) || "javac1.5".equals(str) || "javac1.4".equals(str) || "javac1.3".equals(str) || "javac1.2".equals(str) || "javac1.1".equals(str);
    }

    public final void j(java.io.File file) throws java.io.IOException {
        for (java.util.Map.Entry<java.lang.String, java.lang.Long> entry : this.U.entrySet()) {
            java.lang.String key = entry.getKey();
            java.lang.Long value = entry.getValue();
            java.io.File file2 = new java.io.File(file, key.replace('/', java.io.File.separatorChar));
            file2.mkdirs();
            java.io.File file3 = new java.io.File(file2, "package-info.class");
            if (!file3.isFile() || file3.lastModified() < value.longValue()) {
                log("Creating empty " + file3);
                java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(file3);
                try {
                    fileOutputStream.write(f0);
                    byte[] bytes = key.getBytes("UTF-8");
                    byte length = (byte) (bytes.length + 13);
                    fileOutputStream.write(length / 256);
                    fileOutputStream.write(length % 256);
                    fileOutputStream.write(bytes);
                    fileOutputStream.write(g0);
                } finally {
                    fileOutputStream.close();
                }
            }
        }
    }

    public final java.lang.String k(java.lang.String str) {
        if ("javac10+".equalsIgnoreCase(str) || "javac9".equalsIgnoreCase(str) || "javac1.9".equalsIgnoreCase(str) || "javac1.8".equalsIgnoreCase(str) || "javac1.7".equalsIgnoreCase(str) || "javac1.6".equalsIgnoreCase(str) || "javac1.5".equalsIgnoreCase(str) || "javac1.4".equalsIgnoreCase(str) || "javac1.3".equalsIgnoreCase(str)) {
            return "modern";
        }
        if ("javac1.2".equalsIgnoreCase(str) || "javac1.1".equalsIgnoreCase(str)) {
            return "classic";
        }
        if ("modern".equalsIgnoreCase(str)) {
            java.lang.String c = c();
            if ("javac10+".equalsIgnoreCase(str) || "javac9".equalsIgnoreCase(c) || "javac1.8".equalsIgnoreCase(c) || "javac1.7".equalsIgnoreCase(c) || "javac1.6".equalsIgnoreCase(c) || "javac1.5".equalsIgnoreCase(c) || "javac1.4".equalsIgnoreCase(c) || "javac1.3".equalsIgnoreCase(c)) {
                return c;
            }
        }
        if ("classic".equalsIgnoreCase(str) || "extJavac".equalsIgnoreCase(str)) {
            return c();
        }
        return null;
    }

    public final void n(java.io.File file, java.io.File[] fileArr) {
        for (java.io.File file2 : fileArr) {
            if (file2.getName().equals("package-info.java")) {
                java.lang.String replace = e0.removeLeadingPath(file, file2).replace(java.io.File.separatorChar, '/');
                if (replace.endsWith("/package-info.java")) {
                    this.U.put(replace.substring(0, replace.length() - 18), new java.lang.Long(file2.lastModified()));
                } else {
                    log("anomalous package-info.java path: " + replace, 1);
                }
            }
        }
    }

    public org.apache.tools.ant.types.Path recreateSrc() {
        this.u = null;
        return createSrc();
    }

    public void resetFileLists() {
        this.compileList = new java.io.File[0];
        this.U = new java.util.HashMap();
    }

    public void scanDir(java.io.File file, java.io.File file2, java.lang.String[] strArr) {
        org.apache.tools.ant.util.GlobPatternMapper globPatternMapper = new org.apache.tools.ant.util.GlobPatternMapper();
        for (java.lang.String str : i()) {
            globPatternMapper.setFrom(str);
            globPatternMapper.setTo("*.class");
            java.io.File[] restrictAsFiles = new org.apache.tools.ant.util.SourceFileScanner(this).restrictAsFiles(strArr, file, file2, globPatternMapper);
            if (restrictAsFiles.length > 0) {
                n(file, restrictAsFiles);
                java.io.File[] fileArr = this.compileList;
                java.io.File[] fileArr2 = new java.io.File[fileArr.length + restrictAsFiles.length];
                java.lang.System.arraycopy(fileArr, 0, fileArr2, 0, fileArr.length);
                java.lang.System.arraycopy(restrictAsFiles, 0, fileArr2, this.compileList.length, restrictAsFiles.length);
                this.compileList = fileArr2;
            }
        }
    }

    public void setBootClasspathRef(org.apache.tools.ant.types.Reference reference) {
        createBootclasspath().setRefid(reference);
    }

    public void setBootclasspath(org.apache.tools.ant.types.Path path) {
        org.apache.tools.ant.types.Path path2 = this.K;
        if (path2 == null) {
            this.K = path;
        } else {
            path2.append(path);
        }
    }

    public void setClasspath(org.apache.tools.ant.types.Path path) {
        org.apache.tools.ant.types.Path path2 = this.x;
        if (path2 == null) {
            this.x = path;
        } else {
            path2.append(path);
        }
    }

    public void setClasspathRef(org.apache.tools.ant.types.Reference reference) {
        createClasspath().setRefid(reference);
    }

    public void setCompiler(java.lang.String str) {
        this.T.setImplementation(str);
    }

    public void setCreateMissingPackageInfoClass(boolean z) {
        this.d0 = z;
    }

    public void setDebug(boolean z) {
        this.D = z;
    }

    public void setDebugLevel(java.lang.String str) {
        this.W = str;
    }

    public void setDepend(boolean z) {
        this.G = z;
    }

    public void setDeprecation(boolean z) {
        this.F = z;
    }

    public void setDestdir(java.io.File file) {
        this.v = file;
    }

    public void setEncoding(java.lang.String str) {
        this.C = str;
    }

    public void setErrorProperty(java.lang.String str) {
        this.Z = str;
    }

    public void setExecutable(java.lang.String str) {
        this.P = str;
    }

    public void setExtdirs(org.apache.tools.ant.types.Path path) {
        org.apache.tools.ant.types.Path path2 = this.L;
        if (path2 == null) {
            this.L = path;
        } else {
            path2.append(path);
        }
    }

    public void setFailonerror(boolean z) {
        this.failOnError = z;
    }

    public void setFork(boolean z) {
        this.O = z;
    }

    public void setIncludeDestClasses(boolean z) {
        this.b0 = z;
    }

    public void setIncludeantruntime(boolean z) {
        this.M = java.lang.Boolean.valueOf(z);
    }

    public void setIncludejavaruntime(boolean z) {
        this.N = z;
    }

    public void setListfiles(boolean z) {
        this.listFiles = z;
    }

    public void setMemoryInitialSize(java.lang.String str) {
        this.R = str;
    }

    public void setMemoryMaximumSize(java.lang.String str) {
        this.S = str;
    }

    public void setModulepath(org.apache.tools.ant.types.Path path) {
        org.apache.tools.ant.types.Path path2 = this.y;
        if (path2 == null) {
            this.y = path;
        } else {
            path2.append(path);
        }
    }

    public void setModulepathRef(org.apache.tools.ant.types.Reference reference) {
        createModulepath().setRefid(reference);
    }

    public void setModulesourcepath(org.apache.tools.ant.types.Path path) {
        org.apache.tools.ant.types.Path path2 = this.B;
        if (path2 == null) {
            this.B = path;
        } else {
            path2.append(path);
        }
    }

    public void setModulesourcepathRef(org.apache.tools.ant.types.Reference reference) {
        createModulesourcepath().setRefid(reference);
    }

    public void setNativeHeaderDir(java.io.File file) {
        this.w = file;
    }

    public void setNowarn(boolean z) {
        this.Q = z;
    }

    public void setOptimize(boolean z) {
        this.E = z;
    }

    public void setProceed(boolean z) {
        this.failOnError = !z;
    }

    public void setRelease(java.lang.String str) {
        this.J = str;
    }

    public void setSource(java.lang.String str) {
        this.V = str;
    }

    public void setSourcepath(org.apache.tools.ant.types.Path path) {
        org.apache.tools.ant.types.Path path2 = this.A;
        if (path2 == null) {
            this.A = path;
        } else {
            path2.append(path);
        }
    }

    public void setSourcepathRef(org.apache.tools.ant.types.Reference reference) {
        createSourcepath().setRefid(reference);
    }

    public void setSrcdir(org.apache.tools.ant.types.Path path) {
        org.apache.tools.ant.types.Path path2 = this.u;
        if (path2 == null) {
            this.u = path;
        } else {
            path2.append(path);
        }
    }

    public void setTarget(java.lang.String str) {
        this.I = str;
    }

    public void setTempdir(java.io.File file) {
        this.X = file;
    }

    public void setUpdatedProperty(java.lang.String str) {
        this.Y = str;
    }

    public void setUpgrademodulepath(org.apache.tools.ant.types.Path path) {
        org.apache.tools.ant.types.Path path2 = this.z;
        if (path2 == null) {
            this.z = path;
        } else {
            path2.append(path);
        }
    }

    public void setUpgrademodulepathRef(org.apache.tools.ant.types.Reference reference) {
        createUpgrademodulepath().setRefid(reference);
    }

    public void setVerbose(boolean z) {
        this.H = z;
    }
}
