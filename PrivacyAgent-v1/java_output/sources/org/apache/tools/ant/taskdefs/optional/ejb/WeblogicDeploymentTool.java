package org.apache.tools.ant.taskdefs.optional.ejb;

/* loaded from: classes25.dex */
public class WeblogicDeploymentTool extends org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool {
    protected static final java.lang.String COMPILER_EJB11 = "weblogic.ejbc";
    protected static final java.lang.String COMPILER_EJB20 = "weblogic.ejbc20";
    protected static final java.lang.String DEFAULT_COMPILER = "default";
    protected static final java.lang.String DEFAULT_WL51_DTD_LOCATION = "/weblogic/ejb/deployment/xml/weblogic-ejb-jar.dtd";
    protected static final java.lang.String DEFAULT_WL51_EJB11_DTD_LOCATION = "/weblogic/ejb/deployment/xml/ejb-jar.dtd";
    protected static final java.lang.String DEFAULT_WL60_51_DTD_LOCATION = "/weblogic/ejb20/dd/xml/weblogic510-ejb-jar.dtd";
    protected static final java.lang.String DEFAULT_WL60_DTD_LOCATION = "/weblogic/ejb20/dd/xml/weblogic600-ejb-jar.dtd";
    protected static final java.lang.String DEFAULT_WL60_EJB11_DTD_LOCATION = "/weblogic/ejb20/dd/xml/ejb11-jar.dtd";
    protected static final java.lang.String DEFAULT_WL60_EJB20_DTD_LOCATION = "/weblogic/ejb20/dd/xml/ejb20-jar.dtd";
    protected static final java.lang.String DEFAULT_WL70_DTD_LOCATION = "/weblogic/ejb20/dd/xml/weblogic700-ejb-jar.dtd";
    public static final java.lang.String PUBLICID_EJB11 = "-//Sun Microsystems, Inc.//DTD Enterprise JavaBeans 1.1//EN";
    public static final java.lang.String PUBLICID_EJB20 = "-//Sun Microsystems, Inc.//DTD Enterprise JavaBeans 2.0//EN";
    public static final java.lang.String PUBLICID_WEBLOGIC_EJB510 = "-//BEA Systems, Inc.//DTD WebLogic 5.1.0 EJB//EN";
    public static final java.lang.String PUBLICID_WEBLOGIC_EJB600 = "-//BEA Systems, Inc.//DTD WebLogic 6.0.0 EJB//EN";
    public static final java.lang.String PUBLICID_WEBLOGIC_EJB700 = "-//BEA Systems, Inc.//DTD WebLogic 7.0.0 EJB//EN";
    public static final org.apache.tools.ant.util.FileUtils R = org.apache.tools.ant.util.FileUtils.getFileUtils();
    protected static final java.lang.String WL_CMP_DD = "weblogic-cmp-rdbms-jar.xml";
    protected static final java.lang.String WL_DD = "weblogic-ejb-jar.xml";
    public java.lang.String C;
    public java.lang.String D;
    public java.io.File Q;
    public java.lang.String B = ".jar";
    public boolean E = false;
    public java.lang.String F = null;
    public java.lang.String G = "";
    public java.lang.String H = "";
    public boolean I = false;
    public java.lang.String J = null;
    public boolean K = true;
    public boolean L = false;
    public boolean M = false;
    public org.apache.tools.ant.types.Path N = null;
    public java.util.Vector O = new java.util.Vector();
    public java.lang.Integer P = null;

    /* renamed from: org.apache.tools.ant.taskdefs.optional.ejb.WeblogicDeploymentTool$1, reason: invalid class name */
    public class AnonymousClass1 extends org.apache.tools.ant.taskdefs.optional.ejb.DescriptorHandler {
        public final /* synthetic */ java.io.File A;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(org.apache.tools.ant.Task task, java.io.File file, java.io.File file2) {
            super(task, file);
            this.A = file2;
        }

        @Override // org.apache.tools.ant.taskdefs.optional.ejb.DescriptorHandler
        public void processElement() {
            if (this.currentElement.equals("type-storage")) {
                java.lang.String str = this.currentText;
                this.ejbFiles.put(str, new java.io.File(this.A, str.substring(9, str.length())));
            }
        }
    }

    public void addSysproperty(org.apache.tools.ant.types.Environment.Variable variable) {
        this.O.add(variable);
    }

    @Override // org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool
    public void addVendorFiles(java.util.Hashtable hashtable, java.lang.String str) {
        java.io.File file = new java.io.File(getConfig().b, str + WL_DD);
        if (!file.exists()) {
            log("Unable to locate weblogic deployment descriptor. It was expected to be in " + file.getPath(), 1);
            return;
        }
        hashtable.put("META-INF/weblogic-ejb-jar.xml", file);
        if (!this.M) {
            log("The old method for locating CMP files has been DEPRECATED.", 3);
            log("Please adjust your weblogic descriptor and set newCMP=\"true\" to use the new CMP descriptor inclusion mechanism. ", 3);
            java.io.File file2 = new java.io.File(getConfig().b, str + WL_CMP_DD);
            if (file2.exists()) {
                hashtable.put("META-INF/weblogic-cmp-rdbms-jar.xml", file2);
                return;
            }
            return;
        }
        try {
            java.io.File file3 = (java.io.File) hashtable.get("META-INF/ejb-jar.xml");
            javax.xml.parsers.SAXParserFactory newInstance = javax.xml.parsers.SAXParserFactory.newInstance();
            newInstance.setValidating(true);
            javax.xml.parsers.SAXParser newSAXParser = newInstance.newSAXParser();
            org.apache.tools.ant.taskdefs.optional.ejb.DescriptorHandler weblogicDescriptorHandler = getWeblogicDescriptorHandler(file3.getParentFile());
            newSAXParser.parse(new org.xml.sax.InputSource(new java.io.FileInputStream(file)), weblogicDescriptorHandler);
            java.util.Hashtable files = weblogicDescriptorHandler.getFiles();
            java.util.Enumeration keys = files.keys();
            while (keys.hasMoreElements()) {
                java.lang.String str2 = (java.lang.String) keys.nextElement();
                hashtable.put(str2, files.get(str2));
            }
        } catch (java.lang.Exception e) {
            throw new org.apache.tools.ant.BuildException("Exception while adding Vendor specific files: " + e.toString(), e);
        }
    }

    public final void b(java.io.File file, java.io.File file2, java.lang.String str) {
        if (this.L) {
            try {
                R.copyFile(file, file2);
                if (this.E) {
                    return;
                }
                file.delete();
                return;
            } catch (java.io.IOException e) {
                throw new org.apache.tools.ant.BuildException("Unable to write EJB jar", e);
            }
        }
        java.lang.String str2 = this.F;
        try {
            org.apache.tools.ant.taskdefs.Java java = new org.apache.tools.ant.taskdefs.Java(getTask());
            java.setTaskName("ejbc");
            java.createJvmarg().setLine(this.H);
            if (!this.O.isEmpty()) {
                java.util.Enumeration elements = this.O.elements();
                while (elements.hasMoreElements()) {
                    java.addSysproperty((org.apache.tools.ant.types.Environment.Variable) elements.nextElement());
                }
            }
            if (getJvmDebugLevel() != null) {
                java.createJvmarg().setLine(" -Dweblogic.StdoutSeverityLevel=" + this.P);
            }
            if (str2 == null) {
                if (!"-//Sun Microsystems, Inc.//DTD Enterprise JavaBeans 1.1//EN".equals(str)) {
                    if ("-//Sun Microsystems, Inc.//DTD Enterprise JavaBeans 2.0//EN".equals(str)) {
                        str2 = COMPILER_EJB20;
                    } else {
                        log("Unrecognized publicId " + str + " - using EJB 1.1 compiler", 1);
                    }
                }
                str2 = COMPILER_EJB11;
            }
            java.setClassname(str2);
            java.createArg().setLine(this.G);
            if (this.E) {
                java.createArg().setValue("-keepgenerated");
            }
            java.lang.String str3 = this.J;
            if (str3 == null) {
                java.lang.String property = getTask().getProject().getProperty("build.compiler");
                if (property != null && property.equals("jikes")) {
                    java.createArg().setValue("-compiler");
                    java.createArg().setValue("jikes");
                }
            } else if (!str3.equals("default")) {
                java.createArg().setValue("-compiler");
                java.createArg().setLine(this.J);
            }
            org.apache.tools.ant.types.Path combinedClasspath = getCombinedClasspath();
            if (this.N != null && combinedClasspath != null && combinedClasspath.toString().trim().length() > 0) {
                java.createArg().setValue("-classpath");
                java.createArg().setPath(combinedClasspath);
            }
            java.createArg().setValue(file.getPath());
            if (this.Q == null) {
                java.createArg().setValue(file2.getPath());
            } else {
                java.createArg().setValue(this.Q.getPath());
            }
            org.apache.tools.ant.types.Path path = this.N;
            if (path == null) {
                path = getCombinedClasspath();
            }
            java.setFork(true);
            if (path != null) {
                java.setClasspath(path);
            }
            log("Calling " + str2 + " for " + file.toString(), 3);
            if (java.executeJava() == 0) {
            } else {
                throw new org.apache.tools.ant.BuildException("Ejbc reported an error");
            }
        } catch (java.lang.Exception e2) {
            throw new org.apache.tools.ant.BuildException("Exception while calling " + str2 + ". Details: " + e2.toString(), e2);
        }
    }

    public org.apache.tools.ant.types.Path createWLClasspath() {
        if (this.N == null) {
            this.N = new org.apache.tools.ant.types.Path(getTask().getProject());
        }
        return this.N.createPath();
    }

    public java.lang.ClassLoader getClassLoaderFromJar(java.io.File file) throws java.io.IOException {
        org.apache.tools.ant.types.Path path = new org.apache.tools.ant.types.Path(getTask().getProject());
        path.setLocation(file);
        org.apache.tools.ant.types.Path combinedClasspath = getCombinedClasspath();
        if (combinedClasspath != null) {
            path.append(combinedClasspath);
        }
        return getTask().getProject().createClassLoader(path);
    }

    public java.lang.String getEjbcClass() {
        return this.F;
    }

    public java.lang.Integer getJvmDebugLevel() {
        return this.P;
    }

    @Override // org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool
    public java.io.File getVendorOutputJarFile(java.lang.String str) {
        return new java.io.File(getDestDir(), str + this.B);
    }

    public org.apache.tools.ant.taskdefs.optional.ejb.DescriptorHandler getWeblogicDescriptorHandler(java.io.File file) {
        org.apache.tools.ant.taskdefs.optional.ejb.WeblogicDeploymentTool.AnonymousClass1 anonymousClass1 = new org.apache.tools.ant.taskdefs.optional.ejb.WeblogicDeploymentTool.AnonymousClass1(getTask(), file, file);
        anonymousClass1.registerDTD(PUBLICID_WEBLOGIC_EJB510, DEFAULT_WL51_DTD_LOCATION);
        anonymousClass1.registerDTD(PUBLICID_WEBLOGIC_EJB510, DEFAULT_WL60_51_DTD_LOCATION);
        anonymousClass1.registerDTD(PUBLICID_WEBLOGIC_EJB600, DEFAULT_WL60_DTD_LOCATION);
        anonymousClass1.registerDTD(PUBLICID_WEBLOGIC_EJB700, DEFAULT_WL70_DTD_LOCATION);
        anonymousClass1.registerDTD(PUBLICID_WEBLOGIC_EJB510, this.C);
        anonymousClass1.registerDTD(PUBLICID_WEBLOGIC_EJB600, this.C);
        java.util.Iterator it = getConfig().h.iterator();
        while (it.hasNext()) {
            org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.DTDLocation dTDLocation = (org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.DTDLocation) it.next();
            anonymousClass1.registerDTD(dTDLocation.getPublicId(), dTDLocation.getLocation());
        }
        return anonymousClass1;
    }

    /* JADX WARN: Not initialized variable reg: 16, insn: 0x031e: MOVE (r3 I:??[OBJECT, ARRAY]) = (r16 I:??[OBJECT, ARRAY]), block:B:190:0x031d */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x031d: MOVE (r5 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:190:0x031d */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0320: MOVE (r16 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]), block:B:190:0x031d */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:127:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0336 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x032c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0325 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01dd A[Catch: all -> 0x022a, IOException -> 0x022f, ClassNotFoundException -> 0x0236, TryCatch #15 {IOException -> 0x022f, ClassNotFoundException -> 0x0236, all -> 0x022a, blocks: (B:58:0x019b, B:59:0x01a2, B:61:0x01a8, B:63:0x01bc, B:66:0x01c9, B:67:0x01d3, B:69:0x01dd, B:70:0x0209, B:71:0x0215, B:73:0x021c, B:75:0x0221, B:76:0x0205, B:77:0x01cf), top: B:57:0x019b }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x021c A[Catch: all -> 0x022a, IOException -> 0x022f, ClassNotFoundException -> 0x0236, LOOP:4: B:71:0x0215->B:73:0x021c, LOOP_END, TryCatch #15 {IOException -> 0x022f, ClassNotFoundException -> 0x0236, all -> 0x022a, blocks: (B:58:0x019b, B:59:0x01a2, B:61:0x01a8, B:63:0x01bc, B:66:0x01c9, B:67:0x01d3, B:69:0x01dd, B:70:0x0209, B:71:0x0215, B:73:0x021c, B:75:0x0221, B:76:0x0205, B:77:0x01cf), top: B:57:0x019b }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0205 A[Catch: all -> 0x022a, IOException -> 0x022f, ClassNotFoundException -> 0x0236, TryCatch #15 {IOException -> 0x022f, ClassNotFoundException -> 0x0236, all -> 0x022a, blocks: (B:58:0x019b, B:59:0x01a2, B:61:0x01a8, B:63:0x01bc, B:66:0x01c9, B:67:0x01d3, B:69:0x01dd, B:70:0x0209, B:71:0x0215, B:73:0x021c, B:75:0x0221, B:76:0x0205, B:77:0x01cf), top: B:57:0x019b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean isRebuildRequired(java.io.File file, java.io.File file2) {
        java.lang.Throwable th;
        java.io.File file3;
        java.util.jar.JarFile jarFile;
        java.lang.ClassLoader classLoader;
        java.lang.ClassLoader classLoader2;
        java.io.File file4;
        java.util.jar.JarOutputStream jarOutputStream;
        java.util.jar.JarOutputStream jarOutputStream2;
        java.util.jar.JarFile jarFile2;
        java.io.File file5;
        java.lang.ClassLoader classLoader3;
        java.util.jar.JarFile jarFile3;
        boolean z;
        java.util.jar.JarOutputStream jarOutputStream3;
        java.util.jar.JarFile jarFile4;
        boolean z2;
        java.util.Hashtable hashtable;
        java.util.Hashtable hashtable2;
        java.util.Hashtable hashtable3;
        java.lang.ClassLoader classLoaderFromJar;
        boolean z3;
        java.io.File file6;
        java.io.InputStream inputStream;
        int read;
        try {
            try {
                log("Checking if weblogic Jar needs to be rebuilt for jar " + file2.getName(), 3);
                if (file.exists() && file.isFile() && file2.exists() && file2.isFile()) {
                    java.util.jar.JarFile jarFile5 = new java.util.jar.JarFile(file);
                    try {
                        jarFile2 = new java.util.jar.JarFile(file2);
                        try {
                            hashtable = new java.util.Hashtable();
                            hashtable2 = new java.util.Hashtable();
                            hashtable3 = new java.util.Hashtable();
                            java.util.Enumeration<java.util.jar.JarEntry> entries = jarFile5.entries();
                            while (entries.hasMoreElements()) {
                                java.util.jar.JarEntry nextElement = entries.nextElement();
                                hashtable.put(nextElement.getName().replace('\\', '/'), nextElement);
                            }
                            java.util.Enumeration<java.util.jar.JarEntry> entries2 = jarFile2.entries();
                            while (entries2.hasMoreElements()) {
                                java.util.jar.JarEntry nextElement2 = entries2.nextElement();
                                hashtable2.put(nextElement2.getName(), nextElement2);
                            }
                            classLoaderFromJar = getClassLoaderFromJar(file);
                        } catch (java.io.IOException e) {
                            e = e;
                        } catch (java.lang.ClassNotFoundException e2) {
                            e = e2;
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            jarFile = jarFile5;
                            file3 = null;
                            classLoader2 = null;
                            jarOutputStream2 = null;
                            if (jarFile != null) {
                            }
                            if (jarFile2 != null) {
                            }
                            org.apache.tools.ant.util.FileUtils.close(jarOutputStream2);
                            if (jarOutputStream2 != null) {
                            }
                            if (classLoader2 != null) {
                            }
                        }
                    } catch (java.io.IOException e3) {
                        e = e3;
                        throw new org.apache.tools.ant.BuildException("IOException while processing ejb-jar file . Details: " + e.getMessage(), e);
                    } catch (java.lang.ClassNotFoundException e4) {
                        e = e4;
                        throw new org.apache.tools.ant.BuildException("ClassNotFoundException while processing ejb-jar file. Details: " + e.getMessage(), e);
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        jarFile = jarFile5;
                        file3 = null;
                        classLoader2 = null;
                        jarFile2 = null;
                        jarOutputStream2 = null;
                        if (jarFile != null) {
                        }
                        if (jarFile2 != null) {
                        }
                        org.apache.tools.ant.util.FileUtils.close(jarOutputStream2);
                        if (jarOutputStream2 != null) {
                        }
                        if (classLoader2 != null) {
                        }
                    }
                    try {
                        java.util.Enumeration keys = hashtable.keys();
                        while (keys.hasMoreElements()) {
                            java.lang.String str = (java.lang.String) keys.nextElement();
                            if (hashtable2.containsKey(str)) {
                                java.util.jar.JarEntry jarEntry = (java.util.jar.JarEntry) hashtable.get(str);
                                java.util.jar.JarEntry jarEntry2 = (java.util.jar.JarEntry) hashtable2.get(str);
                                if (jarEntry.getCrc() != jarEntry2.getCrc() || jarEntry.getSize() != jarEntry2.getSize()) {
                                    if (jarEntry.getName().endsWith(".class")) {
                                        java.lang.String replace = jarEntry.getName().replace(java.io.File.separatorChar, '.').replace('/', '.');
                                        java.lang.Class<?> loadClass = classLoaderFromJar.loadClass(replace.substring(0, replace.lastIndexOf(".class")));
                                        if (loadClass.isInterface()) {
                                            log("Interface " + loadClass.getName() + " has changed", 3);
                                        } else {
                                            hashtable3.put(str, jarEntry);
                                        }
                                    } else if (!jarEntry.getName().equals("META-INF/MANIFEST.MF")) {
                                        log("Non class file " + jarEntry.getName() + " has changed", 3);
                                    }
                                }
                            } else {
                                log("File " + str + " not present in weblogic jar", 3);
                            }
                            z3 = true;
                        }
                        z3 = false;
                        if (z3) {
                            log("Weblogic Jar rebuild needed due to changed interface or XML", 3);
                            jarOutputStream3 = null;
                            file6 = null;
                        } else {
                            log("No rebuild needed - updating jar", 3);
                            file3 = new java.io.File(file2.getAbsolutePath() + com.anythink.china.common.a.a.e);
                            try {
                                if (file3.exists()) {
                                    file3.delete();
                                }
                                jarOutputStream3 = new java.util.jar.JarOutputStream(new java.io.FileOutputStream(file3));
                            } catch (java.io.IOException e5) {
                                e = e5;
                            } catch (java.lang.ClassNotFoundException e6) {
                                e = e6;
                            } catch (java.lang.Throwable th4) {
                                th = th4;
                                jarOutputStream2 = null;
                                classLoader2 = classLoaderFromJar;
                                jarFile = jarFile5;
                                if (jarFile != null) {
                                    try {
                                        jarFile.close();
                                    } catch (java.io.IOException unused) {
                                    }
                                }
                                if (jarFile2 != null) {
                                    try {
                                        jarFile2.close();
                                    } catch (java.io.IOException unused2) {
                                    }
                                }
                                org.apache.tools.ant.util.FileUtils.close(jarOutputStream2);
                                if (jarOutputStream2 != null) {
                                    try {
                                        R.rename(file3, file2);
                                    } catch (java.io.IOException e7) {
                                        log(e7.getMessage(), 1);
                                    }
                                }
                                if (classLoader2 != null) {
                                    throw th;
                                }
                                if (!(classLoader2 instanceof org.apache.tools.ant.AntClassLoader)) {
                                    throw th;
                                }
                                ((org.apache.tools.ant.AntClassLoader) classLoader2).cleanup();
                                throw th;
                            }
                            try {
                                jarOutputStream3.setLevel(0);
                                java.util.Enumeration elements = hashtable2.elements();
                                while (elements.hasMoreElements()) {
                                    byte[] bArr = new byte[1024];
                                    java.util.jar.JarEntry jarEntry3 = (java.util.jar.JarEntry) elements.nextElement();
                                    if (jarEntry3.getCompressedSize() != -1 && jarEntry3.getCompressedSize() != jarEntry3.getSize()) {
                                        jarOutputStream3.setLevel(9);
                                        if (hashtable3.containsKey(jarEntry3.getName())) {
                                            inputStream = jarFile2.getInputStream(jarEntry3);
                                        } else {
                                            log("Updating Bean class from generic Jar " + jarEntry3.getName(), 3);
                                            jarEntry3 = (java.util.jar.JarEntry) hashtable3.get(jarEntry3.getName());
                                            inputStream = jarFile5.getInputStream(jarEntry3);
                                        }
                                        jarOutputStream3.putNextEntry(new java.util.jar.JarEntry(jarEntry3.getName()));
                                        while (true) {
                                            read = inputStream.read(bArr);
                                            if (read == -1) {
                                                jarOutputStream3.write(bArr, 0, read);
                                            }
                                        }
                                        inputStream.close();
                                    }
                                    jarOutputStream3.setLevel(0);
                                    if (hashtable3.containsKey(jarEntry3.getName())) {
                                    }
                                    jarOutputStream3.putNextEntry(new java.util.jar.JarEntry(jarEntry3.getName()));
                                    while (true) {
                                        read = inputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        jarOutputStream3.write(bArr, 0, read);
                                    }
                                    inputStream.close();
                                }
                                file6 = file3;
                            } catch (java.io.IOException e8) {
                                e = e8;
                                throw new org.apache.tools.ant.BuildException("IOException while processing ejb-jar file . Details: " + e.getMessage(), e);
                            } catch (java.lang.ClassNotFoundException e9) {
                                e = e9;
                                throw new org.apache.tools.ant.BuildException("ClassNotFoundException while processing ejb-jar file. Details: " + e.getMessage(), e);
                            } catch (java.lang.Throwable th5) {
                                jarOutputStream2 = jarOutputStream3;
                                th = th5;
                                classLoader2 = classLoaderFromJar;
                                jarFile = jarFile5;
                                if (jarFile != null) {
                                }
                                if (jarFile2 != null) {
                                }
                                org.apache.tools.ant.util.FileUtils.close(jarOutputStream2);
                                if (jarOutputStream2 != null) {
                                }
                                if (classLoader2 != null) {
                                }
                            }
                        }
                        classLoader3 = classLoaderFromJar;
                        jarFile3 = jarFile5;
                        z = z3;
                        file5 = file6;
                        jarFile4 = jarFile2;
                    } catch (java.io.IOException e10) {
                        e = e10;
                        throw new org.apache.tools.ant.BuildException("IOException while processing ejb-jar file . Details: " + e.getMessage(), e);
                    } catch (java.lang.ClassNotFoundException e11) {
                        e = e11;
                        throw new org.apache.tools.ant.BuildException("ClassNotFoundException while processing ejb-jar file. Details: " + e.getMessage(), e);
                    } catch (java.lang.Throwable th6) {
                        th = th6;
                        file3 = null;
                    }
                } else {
                    file5 = null;
                    classLoader3 = null;
                    jarFile3 = null;
                    z = true;
                    jarOutputStream3 = null;
                    jarFile4 = null;
                }
                if (jarFile3 != null) {
                    try {
                        jarFile3.close();
                    } catch (java.io.IOException unused3) {
                    }
                }
                if (jarFile4 != null) {
                    try {
                        jarFile4.close();
                    } catch (java.io.IOException unused4) {
                    }
                }
                org.apache.tools.ant.util.FileUtils.close(jarOutputStream3);
                if (jarOutputStream3 != null) {
                    try {
                        R.rename(file5, file2);
                    } catch (java.io.IOException e12) {
                        log(e12.getMessage(), 1);
                        z2 = true;
                    }
                }
                z2 = z;
                if (classLoader3 != null && (classLoader3 instanceof org.apache.tools.ant.AntClassLoader)) {
                    ((org.apache.tools.ant.AntClassLoader) classLoader3).cleanup();
                }
                return z2;
            } catch (java.lang.Throwable th7) {
                classLoader2 = classLoader;
                file3 = file4;
                jarOutputStream2 = jarOutputStream;
                th = th7;
            }
        } catch (java.io.IOException e13) {
            e = e13;
        } catch (java.lang.ClassNotFoundException e14) {
            e = e14;
        } catch (java.lang.Throwable th8) {
            th = th8;
            file3 = null;
            jarFile = null;
        }
    }

    @Override // org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool
    public void registerKnownDTDs(org.apache.tools.ant.taskdefs.optional.ejb.DescriptorHandler descriptorHandler) {
        descriptorHandler.registerDTD("-//Sun Microsystems, Inc.//DTD Enterprise JavaBeans 1.1//EN", DEFAULT_WL51_EJB11_DTD_LOCATION);
        descriptorHandler.registerDTD("-//Sun Microsystems, Inc.//DTD Enterprise JavaBeans 1.1//EN", DEFAULT_WL60_EJB11_DTD_LOCATION);
        descriptorHandler.registerDTD("-//Sun Microsystems, Inc.//DTD Enterprise JavaBeans 1.1//EN", this.D);
        descriptorHandler.registerDTD("-//Sun Microsystems, Inc.//DTD Enterprise JavaBeans 2.0//EN", DEFAULT_WL60_EJB20_DTD_LOCATION);
    }

    public void setArgs(java.lang.String str) {
        this.G = str;
    }

    public void setCompiler(java.lang.String str) {
        this.J = str;
    }

    public void setEJBdtd(java.lang.String str) {
        this.D = str;
    }

    public void setEjbcClass(java.lang.String str) {
        this.F = str;
    }

    public void setJvmDebugLevel(java.lang.Integer num) {
        this.P = num;
    }

    public void setJvmargs(java.lang.String str) {
        this.H = str;
    }

    public void setKeepgenerated(java.lang.String str) {
        this.E = java.lang.Boolean.valueOf(str).booleanValue();
    }

    public void setKeepgeneric(boolean z) {
        this.I = z;
    }

    public void setNewCMP(boolean z) {
        this.M = z;
    }

    public void setNoEJBC(boolean z) {
        this.L = z;
    }

    public void setOldCMP(boolean z) {
        this.M = !z;
    }

    public void setOutputDir(java.io.File file) {
        this.Q = file;
    }

    public void setRebuild(boolean z) {
        this.K = z;
    }

    public void setSuffix(java.lang.String str) {
        this.B = str;
    }

    public void setWLClasspath(org.apache.tools.ant.types.Path path) {
        this.N = path;
    }

    public void setWLdtd(java.lang.String str) {
        this.C = str;
    }

    public void setWeblogicdtd(java.lang.String str) {
        setEJBdtd(str);
    }

    @Override // org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool, org.apache.tools.ant.taskdefs.optional.ejb.EJBDeploymentTool
    public void validateConfigured() throws org.apache.tools.ant.BuildException {
        super.validateConfigured();
    }

    @Override // org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool
    public void writeJar(java.lang.String str, java.io.File file, java.util.Hashtable hashtable, java.lang.String str2) throws org.apache.tools.ant.BuildException {
        java.io.File vendorOutputJarFile = super.getVendorOutputJarFile(str);
        super.writeJar(str, vendorOutputJarFile, hashtable, str2);
        if (this.K || isRebuildRequired(vendorOutputJarFile, file)) {
            b(vendorOutputJarFile, file, str2);
        }
        if (this.I) {
            return;
        }
        log("deleting generic jar " + vendorOutputJarFile.toString(), 3);
        vendorOutputJarFile.delete();
    }
}
