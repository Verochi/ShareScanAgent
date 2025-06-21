package org.apache.tools.ant.taskdefs.optional.ejb;

/* loaded from: classes25.dex */
public class GenericDeploymentTool implements org.apache.tools.ant.taskdefs.optional.ejb.EJBDeploymentTool {
    public static final java.lang.String ANALYZER_CLASS_FULL = "org.apache.tools.ant.util.depend.bcel.FullAnalyzer";
    public static final java.lang.String ANALYZER_CLASS_SUPER = "org.apache.tools.ant.util.depend.bcel.AncestorAnalyzer";
    public static final java.lang.String ANALYZER_FULL = "full";
    public static final java.lang.String ANALYZER_NONE = "none";
    public static final java.lang.String ANALYZER_SUPER = "super";
    public static final java.lang.String DEFAULT_ANALYZER = "super";
    public static final int DEFAULT_BUFFER_SIZE = 1024;
    protected static final java.lang.String EJB_DD = "ejb-jar.xml";
    public static final int JAR_COMPRESS_LEVEL = 9;
    protected static final java.lang.String MANIFEST = "META-INF/MANIFEST.MF";
    protected static final java.lang.String META_DIR = "META-INF/";
    public org.apache.tools.ant.util.depend.DependencyAnalyzer A;
    public org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.Config n;
    public java.io.File t;
    public org.apache.tools.ant.types.Path u;
    public org.apache.tools.ant.Task w;
    public java.util.Set y;
    public org.apache.tools.ant.taskdefs.optional.ejb.DescriptorHandler z;
    public java.lang.String v = "-generic.jar";
    public java.lang.ClassLoader x = null;

    public final void a() {
        java.lang.String str = this.n.k;
        if (str == null) {
            str = "super";
        }
        if (str.equals("none")) {
            return;
        }
        if (str.equals("super")) {
            str = ANALYZER_CLASS_SUPER;
        } else if (str.equals("full")) {
            str = "org.apache.tools.ant.util.depend.bcel.FullAnalyzer";
        }
        try {
            org.apache.tools.ant.util.depend.DependencyAnalyzer dependencyAnalyzer = (org.apache.tools.ant.util.depend.DependencyAnalyzer) java.lang.Class.forName(str).newInstance();
            this.A = dependencyAnalyzer;
            dependencyAnalyzer.addClassPath(new org.apache.tools.ant.types.Path(this.w.getProject(), this.n.a.getPath()));
            this.A.addClassPath(this.n.f);
        } catch (java.lang.Exception e) {
            this.A = null;
            this.w.log("Unable to load dependency analyzer: " + str + " - exception: " + e.getMessage(), 1);
        } catch (java.lang.NoClassDefFoundError e2) {
            this.A = null;
            this.w.log("Unable to load dependency analyzer: " + str + " - dependent class not found: " + e2.getMessage(), 1);
        }
    }

    public void addFileToJar(java.util.jar.JarOutputStream jarOutputStream, java.io.File file, java.lang.String str) throws org.apache.tools.ant.BuildException {
        java.io.FileInputStream fileInputStream = null;
        try {
            try {
                if (!this.y.contains(str)) {
                    java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(file);
                    try {
                        jarOutputStream.putNextEntry(new java.util.zip.ZipEntry(str.replace('\\', '/')));
                        byte[] bArr = new byte[2048];
                        int i = 0;
                        do {
                            jarOutputStream.write(bArr, 0, i);
                            i = fileInputStream2.read(bArr, 0, 2048);
                        } while (i != -1);
                        this.y.add(str);
                        fileInputStream = fileInputStream2;
                    } catch (java.io.IOException e) {
                        e = e;
                        fileInputStream = fileInputStream2;
                        log("WARNING: IOException while adding entry " + str + " to jarfile from " + file.getPath() + " " + e.getClass().getName() + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + e.getMessage(), 1);
                        org.apache.tools.ant.util.FileUtils.close(fileInputStream);
                    } catch (java.lang.Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        org.apache.tools.ant.util.FileUtils.close(fileInputStream);
                        throw th;
                    }
                }
            } catch (java.io.IOException e2) {
                e = e2;
            }
            org.apache.tools.ant.util.FileUtils.close(fileInputStream);
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public void addSupportClasses(java.util.Hashtable hashtable) {
        org.apache.tools.ant.Project project = this.w.getProject();
        for (org.apache.tools.ant.types.FileSet fileSet : this.n.g) {
            java.io.File dir = fileSet.getDir(project);
            org.apache.tools.ant.DirectoryScanner directoryScanner = fileSet.getDirectoryScanner(project);
            directoryScanner.scan();
            java.lang.String[] includedFiles = directoryScanner.getIncludedFiles();
            for (int i = 0; i < includedFiles.length; i++) {
                hashtable.put(includedFiles[i], new java.io.File(dir, includedFiles[i]));
            }
        }
    }

    public void addVendorFiles(java.util.Hashtable hashtable, java.lang.String str) {
    }

    public void checkAndAddDependants(java.util.Hashtable hashtable) throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.util.depend.DependencyAnalyzer dependencyAnalyzer = this.A;
        if (dependencyAnalyzer == null) {
            return;
        }
        dependencyAnalyzer.reset();
        for (java.lang.String str : hashtable.keySet()) {
            if (str.endsWith(".class")) {
                this.A.addRootClass(str.substring(0, str.length() - 6).replace(java.io.File.separatorChar, '/').replace('/', '.'));
            }
        }
        java.util.Enumeration<java.lang.String> classDependencies = this.A.getClassDependencies();
        while (classDependencies.hasMoreElements()) {
            java.lang.String nextElement = classDependencies.nextElement();
            java.lang.String str2 = nextElement.replace('.', java.io.File.separatorChar) + ".class";
            java.io.File file = new java.io.File(this.n.a, str2);
            if (file.exists()) {
                hashtable.put(str2, file);
                log("dependent class: " + nextElement + " - " + file, 3);
            }
        }
    }

    public void checkConfiguration(java.lang.String str, javax.xml.parsers.SAXParser sAXParser) throws org.apache.tools.ant.BuildException {
    }

    @Override // org.apache.tools.ant.taskdefs.optional.ejb.EJBDeploymentTool
    public void configure(org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.Config config) {
        this.n = config;
        a();
        this.x = null;
    }

    public org.apache.tools.ant.types.Path createClasspath() {
        if (this.u == null) {
            this.u = new org.apache.tools.ant.types.Path(this.w.getProject());
        }
        return this.u.createPath();
    }

    public java.lang.ClassLoader getClassLoaderForBuild() {
        java.lang.ClassLoader classLoader = this.x;
        if (classLoader != null) {
            return classLoader;
        }
        org.apache.tools.ant.types.Path combinedClasspath = getCombinedClasspath();
        if (combinedClasspath == null) {
            this.x = getClass().getClassLoader();
        } else {
            this.x = getTask().getProject().createClassLoader(combinedClasspath);
        }
        return this.x;
    }

    public org.apache.tools.ant.types.Path getCombinedClasspath() {
        org.apache.tools.ant.types.Path path = this.u;
        org.apache.tools.ant.types.Path path2 = this.n.f;
        if (path2 == null) {
            return path;
        }
        if (path == null) {
            return path2;
        }
        path.append(path2);
        return path;
    }

    public org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.Config getConfig() {
        return this.n;
    }

    public org.apache.tools.ant.taskdefs.optional.ejb.DescriptorHandler getDescriptorHandler(java.io.File file) {
        org.apache.tools.ant.taskdefs.optional.ejb.DescriptorHandler descriptorHandler = new org.apache.tools.ant.taskdefs.optional.ejb.DescriptorHandler(getTask(), file);
        registerKnownDTDs(descriptorHandler);
        java.util.Iterator it = getConfig().h.iterator();
        while (it.hasNext()) {
            org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.DTDLocation dTDLocation = (org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.DTDLocation) it.next();
            descriptorHandler.registerDTD(dTDLocation.getPublicId(), dTDLocation.getLocation());
        }
        return descriptorHandler;
    }

    public java.io.File getDestDir() {
        return this.t;
    }

    public java.lang.String getJarBaseName(java.lang.String str) {
        if (this.n.i.getValue().equals(org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.NamingScheme.BASEJARNAME)) {
            int lastIndexOf = str.replace('\\', '/').lastIndexOf(47);
            return (lastIndexOf != -1 ? str.substring(0, lastIndexOf + 1) : "") + this.n.d;
        }
        if (this.n.i.getValue().equals(org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.NamingScheme.DESCRIPTOR)) {
            int lastIndexOf2 = str.lastIndexOf(java.io.File.separator);
            int indexOf = lastIndexOf2 != -1 ? str.indexOf(this.n.c, lastIndexOf2) : str.indexOf(this.n.c);
            if (indexOf != -1) {
                return str.substring(0, indexOf);
            }
            throw new org.apache.tools.ant.BuildException("Unable to determine jar name from descriptor \"" + str + "\"");
        }
        if (!this.n.i.getValue().equals(org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.NamingScheme.DIRECTORY)) {
            return this.n.i.getValue().equals(org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.NamingScheme.EJB_NAME) ? this.z.getEjbName() : "";
        }
        java.lang.String absolutePath = new java.io.File(this.n.b, str).getAbsolutePath();
        java.lang.String str2 = java.io.File.separator;
        int lastIndexOf3 = absolutePath.lastIndexOf(str2);
        if (lastIndexOf3 == -1) {
            throw new org.apache.tools.ant.BuildException("Unable to determine directory name holding descriptor");
        }
        java.lang.String substring = absolutePath.substring(0, lastIndexOf3);
        int lastIndexOf4 = substring.lastIndexOf(str2);
        if (lastIndexOf4 != -1) {
            substring = substring.substring(lastIndexOf4 + 1);
        }
        return substring;
    }

    public org.apache.tools.ant.Location getLocation() {
        return getTask().getLocation();
    }

    public java.io.File getManifestFile(java.lang.String str) {
        java.io.File file = new java.io.File(getConfig().b, str + "manifest.mf");
        if (file.exists()) {
            return file;
        }
        java.io.File file2 = this.n.j;
        if (file2 != null) {
            return file2;
        }
        return null;
    }

    public java.lang.String getPublicId() {
        return this.z.getPublicId();
    }

    public org.apache.tools.ant.Task getTask() {
        return this.w;
    }

    public java.lang.String getVendorDDPrefix(java.lang.String str, java.lang.String str2) {
        if (this.n.i.getValue().equals(org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.NamingScheme.DESCRIPTOR)) {
            return str + this.n.c;
        }
        if (!this.n.i.getValue().equals(org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.NamingScheme.BASEJARNAME) && !this.n.i.getValue().equals(org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.NamingScheme.EJB_NAME) && !this.n.i.getValue().equals(org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.NamingScheme.DIRECTORY)) {
            return null;
        }
        int lastIndexOf = str2.replace('\\', '/').lastIndexOf(47);
        return lastIndexOf == -1 ? "" : str2.substring(0, lastIndexOf + 1);
    }

    public java.io.File getVendorOutputJarFile(java.lang.String str) {
        return new java.io.File(this.t, str + this.v);
    }

    public void log(java.lang.String str, int i) {
        getTask().log(str, i);
    }

    public boolean needToRebuild(java.util.Hashtable hashtable, java.io.File file) {
        if (!file.exists()) {
            return true;
        }
        long lastModified = file.lastModified();
        for (java.io.File file2 : hashtable.values()) {
            if (lastModified < file2.lastModified()) {
                log("Build needed because " + file2.getPath() + " is out of date", 3);
                return true;
            }
        }
        return false;
    }

    public java.util.Hashtable parseEjbFiles(java.lang.String str, javax.xml.parsers.SAXParser sAXParser) throws java.io.IOException, org.xml.sax.SAXException {
        java.io.FileInputStream fileInputStream = null;
        try {
            java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(new java.io.File(this.n.b, str));
            try {
                sAXParser.parse(new org.xml.sax.InputSource(fileInputStream2), this.z);
                java.util.Hashtable files = this.z.getFiles();
                org.apache.tools.ant.util.FileUtils.close(fileInputStream2);
                return files;
            } catch (java.lang.Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                org.apache.tools.ant.util.FileUtils.close(fileInputStream);
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    @Override // org.apache.tools.ant.taskdefs.optional.ejb.EJBDeploymentTool
    public void processDescriptor(java.lang.String str, javax.xml.parsers.SAXParser sAXParser) {
        checkConfiguration(str, sAXParser);
        try {
            this.z = getDescriptorHandler(this.n.a);
            java.util.Hashtable parseEjbFiles = parseEjbFiles(str, sAXParser);
            addSupportClasses(parseEjbFiles);
            java.lang.String jarBaseName = getJarBaseName(str);
            java.lang.String vendorDDPrefix = getVendorDDPrefix(jarBaseName, str);
            java.io.File manifestFile = getManifestFile(vendorDDPrefix);
            if (manifestFile != null) {
                parseEjbFiles.put(MANIFEST, manifestFile);
            }
            parseEjbFiles.put("META-INF/ejb-jar.xml", new java.io.File(this.n.b, str));
            addVendorFiles(parseEjbFiles, vendorDDPrefix);
            checkAndAddDependants(parseEjbFiles);
            if (this.n.e && jarBaseName.length() != 0) {
                int lastIndexOf = jarBaseName.lastIndexOf(java.io.File.separator);
                if (lastIndexOf == -1) {
                    lastIndexOf = 0;
                }
                jarBaseName = jarBaseName.substring(lastIndexOf, jarBaseName.length());
            }
            java.io.File vendorOutputJarFile = getVendorOutputJarFile(jarBaseName);
            if (!needToRebuild(parseEjbFiles, vendorOutputJarFile)) {
                log(vendorOutputJarFile.toString() + " is up to date.", 3);
                return;
            }
            log("building " + vendorOutputJarFile.getName() + " with " + java.lang.String.valueOf(parseEjbFiles.size()) + " files", 2);
            writeJar(jarBaseName, vendorOutputJarFile, parseEjbFiles, getPublicId());
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException("IOException while parsing'" + str + "'.  This probably indicates that the descriptor doesn't exist. Details: " + e.getMessage(), e);
        } catch (org.xml.sax.SAXException e2) {
            throw new org.apache.tools.ant.BuildException("SAXException while parsing '" + str + "'. This probably indicates badly-formed XML.  Details: " + e2.getMessage(), e2);
        }
    }

    public void registerKnownDTDs(org.apache.tools.ant.taskdefs.optional.ejb.DescriptorHandler descriptorHandler) {
    }

    public void setClasspath(org.apache.tools.ant.types.Path path) {
        this.u = path;
    }

    public void setDestdir(java.io.File file) {
        this.t = file;
    }

    public void setGenericJarSuffix(java.lang.String str) {
        this.v = str;
    }

    @Override // org.apache.tools.ant.taskdefs.optional.ejb.EJBDeploymentTool
    public void setTask(org.apache.tools.ant.Task task) {
        this.w = task;
    }

    public boolean usingBaseJarName() {
        return this.n.d != null;
    }

    @Override // org.apache.tools.ant.taskdefs.optional.ejb.EJBDeploymentTool
    public void validateConfigured() throws org.apache.tools.ant.BuildException {
        java.io.File file = this.t;
        if (file == null || !file.isDirectory()) {
            throw new org.apache.tools.ant.BuildException("A valid destination directory must be specified using the \"destdir\" attribute.", getLocation());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void writeJar(java.lang.String str, java.io.File file, java.util.Hashtable hashtable, java.lang.String str2) throws org.apache.tools.ant.BuildException {
        java.io.InputStream resourceAsStream;
        java.util.jar.JarOutputStream jarOutputStream = null;
        java.lang.Object[] objArr = 0;
        try {
            try {
                java.util.Set set = this.y;
                if (set == null) {
                    this.y = new java.util.HashSet();
                } else {
                    set.clear();
                }
                if (file.exists()) {
                    file.delete();
                }
                try {
                    file.getParentFile().mkdirs();
                    file.createNewFile();
                } catch (java.lang.Throwable th) {
                    th = th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.io.IOException e) {
            e = e;
        }
        try {
            java.io.File file2 = (java.io.File) hashtable.get(MANIFEST);
            try {
                if (file2 == null || !file2.exists()) {
                    resourceAsStream = getClass().getResourceAsStream("/org/apache/tools/ant/defaultManifest.mf");
                    if (resourceAsStream == null) {
                        throw new org.apache.tools.ant.BuildException("Could not find default manifest: /org/apache/tools/ant/defaultManifest.mf");
                    }
                } else {
                    resourceAsStream = new java.io.FileInputStream(file2);
                }
                java.util.jar.Manifest manifest = new java.util.jar.Manifest(resourceAsStream);
                resourceAsStream.close();
                java.util.jar.JarOutputStream jarOutputStream2 = new java.util.jar.JarOutputStream(new java.io.FileOutputStream(file), manifest);
                try {
                    jarOutputStream2.setMethod(8);
                    for (java.lang.String str3 : hashtable.keySet()) {
                        if (!str3.equals(MANIFEST)) {
                            java.io.File file3 = (java.io.File) hashtable.get(str3);
                            log("adding file '" + str3 + "'", 3);
                            addFileToJar(jarOutputStream2, file3, str3);
                            java.lang.String[] list = file3.getParentFile().list(new org.apache.tools.ant.taskdefs.optional.ejb.InnerClassFilenameFilter(file3.getName()));
                            if (list != null) {
                                int length = list.length;
                                for (int i = 0; i < length; i++) {
                                    int lastIndexOf = str3.lastIndexOf(file3.getName()) - 1;
                                    str3 = lastIndexOf < 0 ? list[i] : str3.substring(0, lastIndexOf) + java.io.File.separatorChar + list[i];
                                    file3 = new java.io.File(this.n.a, str3);
                                    log("adding innerclass file '" + str3 + "'", 3);
                                    addFileToJar(jarOutputStream2, file3, str3);
                                }
                            }
                        }
                    }
                    org.apache.tools.ant.util.FileUtils.close(jarOutputStream2);
                } catch (java.io.IOException e2) {
                    e = e2;
                    throw new org.apache.tools.ant.BuildException("IOException while processing ejb-jar file '" + file.toString() + "'. Details: " + e.getMessage(), e);
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    jarOutputStream = jarOutputStream2;
                    org.apache.tools.ant.util.FileUtils.close(jarOutputStream);
                    throw th;
                }
            } catch (java.io.IOException e3) {
                e = e3;
                throw new org.apache.tools.ant.BuildException("Unable to read manifest", e, getLocation());
            }
        } catch (java.io.IOException e4) {
            e = e4;
        } catch (java.lang.Throwable th4) {
            th = th4;
            if (0 != 0) {
                (objArr == true ? 1 : 0).close();
            }
            throw th;
        }
    }
}
