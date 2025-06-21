package org.apache.tools.ant.taskdefs.optional.ejb;

/* loaded from: classes25.dex */
public class WebsphereDeploymentTool extends org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool {
    public static final java.lang.String PUBLICID_EJB11 = "-//Sun Microsystems, Inc.//DTD Enterprise JavaBeans 1.1//EN";
    public static final java.lang.String PUBLICID_EJB20 = "-//Sun Microsystems, Inc.//DTD Enterprise JavaBeans 2.0//EN";
    protected static final java.lang.String SCHEMA_DIR = "Schema/";
    public static final org.apache.tools.ant.util.FileUtils V = org.apache.tools.ant.util.FileUtils.getFileUtils();
    protected static final java.lang.String WAS_BND = "ibm-ejb-jar-bnd.xmi";
    protected static final java.lang.String WAS_CMP_MAP = "Map.mapxmi";
    protected static final java.lang.String WAS_CMP_SCHEMA = "Schema.dbxmi";
    protected static final java.lang.String WAS_EXT = "ibm-ejb-jar-ext.xmi";
    public java.lang.String C;
    public java.lang.String I;
    public java.lang.String J;
    public java.lang.String K;
    public boolean L;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public java.lang.String R;
    public boolean S;
    public java.io.File U;
    public java.lang.String B = ".jar";
    public boolean D = false;
    public boolean E = true;
    public boolean F = true;
    public boolean G = false;
    public org.apache.tools.ant.types.Path H = null;
    public boolean M = true;
    public java.lang.String T = "_ejbdeploy_temp";

    /* renamed from: org.apache.tools.ant.taskdefs.optional.ejb.WebsphereDeploymentTool$1, reason: invalid class name */
    public class AnonymousClass1 extends org.apache.tools.ant.taskdefs.optional.ejb.DescriptorHandler {
        public AnonymousClass1(org.apache.tools.ant.Task task, java.io.File file) {
            super(task, file);
        }

        @Override // org.apache.tools.ant.taskdefs.optional.ejb.DescriptorHandler
        public void processElement() {
        }
    }

    @Override // org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool
    public void addVendorFiles(java.util.Hashtable hashtable, java.lang.String str) {
        java.lang.String str2 = "";
        if (usingBaseJarName()) {
            str = "";
        }
        if (this.I != null) {
            str2 = this.I + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER;
        }
        java.io.File file = new java.io.File(getConfig().b, str + WAS_EXT);
        if (file.exists()) {
            hashtable.put("META-INF/ibm-ejb-jar-ext.xmi", file);
        } else {
            log("Unable to locate websphere extensions. It was expected to be in " + file.getPath(), 3);
        }
        java.io.File file2 = new java.io.File(getConfig().b, str + WAS_BND);
        if (file2.exists()) {
            hashtable.put("META-INF/ibm-ejb-jar-bnd.xmi", file2);
        } else {
            log("Unable to locate websphere bindings. It was expected to be in " + file2.getPath(), 3);
        }
        if (!this.G) {
            log("The old method for locating CMP files has been DEPRECATED.", 3);
            log("Please adjust your websphere descriptor and set newCMP=\"true\" to use the new CMP descriptor inclusion mechanism. ", 3);
            return;
        }
        try {
            java.io.File file3 = new java.io.File(getConfig().b, str + str2 + WAS_CMP_MAP);
            if (file3.exists()) {
                hashtable.put("META-INF/Map.mapxmi", file3);
            } else {
                log("Unable to locate the websphere Map: " + file3.getPath(), 3);
            }
            java.io.File file4 = new java.io.File(getConfig().b, str + str2 + WAS_CMP_SCHEMA);
            if (file4.exists()) {
                hashtable.put("META-INF/Schema/Schema.dbxmi", file4);
                return;
            }
            log("Unable to locate the websphere Schema: " + file4.getPath(), 3);
        } catch (java.lang.Exception e) {
            throw new org.apache.tools.ant.BuildException("Exception while adding Vendor specific files: " + e.toString(), e);
        }
    }

    public final void b(java.io.File file, java.io.File file2) {
        try {
            if (this.F) {
                org.apache.tools.ant.taskdefs.Java java = new org.apache.tools.ant.taskdefs.Java(getTask());
                java.createJvmarg().setValue("-Xms64m");
                java.createJvmarg().setValue("-Xmx128m");
                org.apache.tools.ant.types.Environment.Variable variable = new org.apache.tools.ant.types.Environment.Variable();
                variable.setKey("websphere.lib.dir");
                variable.setValue(new java.io.File(this.U, "lib").getAbsolutePath());
                java.addSysproperty(variable);
                java.setDir(this.U);
                java.setTaskName("ejbdeploy");
                java.setClassname("com.ibm.etools.ejbdeploy.EJBDeploy");
                java.createArg().setValue(file.getPath());
                java.createArg().setValue(this.T);
                java.createArg().setValue(file2.getPath());
                java.createArg().setLine(getOptions());
                if (getCombinedClasspath() != null && getCombinedClasspath().toString().length() > 0) {
                    java.createArg().setValue("-cp");
                    java.createArg().setValue(getCombinedClasspath().toString());
                }
                org.apache.tools.ant.types.Path path = this.H;
                if (path == null) {
                    path = getCombinedClasspath();
                }
                java.setFork(true);
                if (path != null) {
                    java.setClasspath(path);
                }
                log("Calling websphere.ejbdeploy for " + file.toString(), 3);
                java.execute();
            }
        } catch (java.lang.Exception e) {
            throw new org.apache.tools.ant.BuildException("Exception while calling ejbdeploy. Details: " + e.toString(), e);
        }
    }

    public org.apache.tools.ant.types.Path createWASClasspath() {
        if (this.H == null) {
            this.H = new org.apache.tools.ant.types.Path(getTask().getProject());
        }
        return this.H.createPath();
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

    @Override // org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool
    public org.apache.tools.ant.taskdefs.optional.ejb.DescriptorHandler getDescriptorHandler(java.io.File file) {
        org.apache.tools.ant.taskdefs.optional.ejb.DescriptorHandler descriptorHandler = new org.apache.tools.ant.taskdefs.optional.ejb.DescriptorHandler(getTask(), file);
        descriptorHandler.registerDTD("-//Sun Microsystems, Inc.//DTD Enterprise JavaBeans 1.1//EN", this.C);
        java.util.Iterator it = getConfig().h.iterator();
        while (it.hasNext()) {
            org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.DTDLocation dTDLocation = (org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.DTDLocation) it.next();
            descriptorHandler.registerDTD(dTDLocation.getPublicId(), dTDLocation.getLocation());
        }
        return descriptorHandler;
    }

    public java.lang.String getOptions() {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        if (this.I != null) {
            stringBuffer.append(" -dbvendor ");
            stringBuffer.append(this.I);
        }
        if (this.J != null) {
            stringBuffer.append(" -dbname \"");
            stringBuffer.append(this.J);
            stringBuffer.append("\"");
        }
        if (this.K != null) {
            stringBuffer.append(" -dbschema \"");
            stringBuffer.append(this.K);
            stringBuffer.append("\"");
        }
        if (this.L) {
            stringBuffer.append(" -codegen");
        }
        if (this.M) {
            stringBuffer.append(" -quiet");
        }
        if (this.N) {
            stringBuffer.append(" -novalidate");
        }
        if (this.O) {
            stringBuffer.append(" -nowarn");
        }
        if (this.P) {
            stringBuffer.append(" -noinform");
        }
        if (this.Q) {
            stringBuffer.append(" -trace");
        }
        if (this.S) {
            stringBuffer.append(" -35");
        }
        if (this.R != null) {
            stringBuffer.append(" -rmic \"");
            stringBuffer.append(this.R);
            stringBuffer.append("\"");
        }
        return stringBuffer.toString();
    }

    @Override // org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool
    public java.io.File getVendorOutputJarFile(java.lang.String str) {
        return new java.io.File(getDestDir(), str + this.B);
    }

    public org.apache.tools.ant.taskdefs.optional.ejb.DescriptorHandler getWebsphereDescriptorHandler(java.io.File file) {
        org.apache.tools.ant.taskdefs.optional.ejb.WebsphereDeploymentTool.AnonymousClass1 anonymousClass1 = new org.apache.tools.ant.taskdefs.optional.ejb.WebsphereDeploymentTool.AnonymousClass1(getTask(), file);
        java.util.Iterator it = getConfig().h.iterator();
        while (it.hasNext()) {
            org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.DTDLocation dTDLocation = (org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.DTDLocation) it.next();
            anonymousClass1.registerDTD(dTDLocation.getPublicId(), dTDLocation.getLocation());
        }
        return anonymousClass1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0159, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Not initialized variable reg: 16, insn: 0x0315: MOVE (r3 I:??[OBJECT, ARRAY]) = (r16 I:??[OBJECT, ARRAY]), block:B:189:0x0314 */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0314: MOVE (r5 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:189:0x0314 */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0317: MOVE (r16 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]), block:B:189:0x0314 */
    /* JADX WARN: Removed duplicated region for block: B:123:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:128:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x032d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0323 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x031c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01d4 A[Catch: all -> 0x0221, IOException -> 0x0226, ClassNotFoundException -> 0x022d, TryCatch #14 {IOException -> 0x0226, ClassNotFoundException -> 0x022d, all -> 0x0221, blocks: (B:59:0x0192, B:60:0x0199, B:62:0x019f, B:64:0x01b3, B:67:0x01c0, B:68:0x01ca, B:70:0x01d4, B:71:0x0200, B:72:0x020c, B:74:0x0213, B:76:0x0218, B:77:0x01fc, B:78:0x01c6), top: B:58:0x0192 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0213 A[Catch: all -> 0x0221, IOException -> 0x0226, ClassNotFoundException -> 0x022d, LOOP:4: B:72:0x020c->B:74:0x0213, LOOP_END, TryCatch #14 {IOException -> 0x0226, ClassNotFoundException -> 0x022d, all -> 0x0221, blocks: (B:59:0x0192, B:60:0x0199, B:62:0x019f, B:64:0x01b3, B:67:0x01c0, B:68:0x01ca, B:70:0x01d4, B:71:0x0200, B:72:0x020c, B:74:0x0213, B:76:0x0218, B:77:0x01fc, B:78:0x01c6), top: B:58:0x0192 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01fc A[Catch: all -> 0x0221, IOException -> 0x0226, ClassNotFoundException -> 0x022d, TryCatch #14 {IOException -> 0x0226, ClassNotFoundException -> 0x022d, all -> 0x0221, blocks: (B:59:0x0192, B:60:0x0199, B:62:0x019f, B:64:0x01b3, B:67:0x01c0, B:68:0x01ca, B:70:0x01d4, B:71:0x0200, B:72:0x020c, B:74:0x0213, B:76:0x0218, B:77:0x01fc, B:78:0x01c6), top: B:58:0x0192 }] */
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
        java.io.File file6;
        java.io.InputStream inputStream;
        int read;
        try {
            try {
                log("Checking if websphere Jar needs to be rebuilt for jar " + file2.getName(), 3);
                if (file.exists() && file.isFile() && file2.exists() && file2.isFile()) {
                    java.util.jar.JarFile jarFile5 = new java.util.jar.JarFile(file);
                    try {
                        jarFile2 = new java.util.jar.JarFile(file2);
                    } catch (java.io.IOException e) {
                        e = e;
                        throw new org.apache.tools.ant.BuildException("IOException while processing ejb-jar file . Details: " + e.getMessage(), e);
                    } catch (java.lang.ClassNotFoundException e2) {
                        e = e2;
                        throw new org.apache.tools.ant.BuildException("ClassNotFoundException while processing ejb-jar file. Details: " + e.getMessage(), e);
                    } catch (java.lang.Throwable th2) {
                        th = th2;
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
                    } catch (java.io.IOException e3) {
                        e = e3;
                    } catch (java.lang.ClassNotFoundException e4) {
                        e = e4;
                    } catch (java.lang.Throwable th3) {
                        th = th3;
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
                    try {
                        java.util.Enumeration keys = hashtable.keys();
                        while (true) {
                            if (!keys.hasMoreElements()) {
                                break;
                            }
                            java.lang.String str = (java.lang.String) keys.nextElement();
                            if (!hashtable2.containsKey(str)) {
                                log("File " + str + " not present in websphere jar", 3);
                                break;
                            }
                            java.util.jar.JarEntry jarEntry = (java.util.jar.JarEntry) hashtable.get(str);
                            java.util.jar.JarEntry jarEntry2 = (java.util.jar.JarEntry) hashtable2.get(str);
                            if (jarEntry.getCrc() != jarEntry2.getCrc() || jarEntry.getSize() != jarEntry2.getSize()) {
                                if (jarEntry.getName().endsWith(".class")) {
                                    java.lang.String replace = jarEntry.getName().replace(java.io.File.separatorChar, '.');
                                    java.lang.Class<?> loadClass = classLoaderFromJar.loadClass(replace.substring(0, replace.lastIndexOf(".class")));
                                    if (loadClass.isInterface()) {
                                        log("Interface " + loadClass.getName() + " has changed", 3);
                                        break;
                                    }
                                    hashtable3.put(str, jarEntry);
                                } else if (!jarEntry.getName().equals("META-INF/MANIFEST.MF")) {
                                    log("Non class file " + jarEntry.getName() + " has changed", 3);
                                }
                            }
                        }
                        boolean z3 = false;
                        if (z3) {
                            log("websphere Jar rebuild needed due to changed interface or XML", 3);
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
                                        V.rename(file3, file2);
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
                        V.rename(file5, file2);
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

    public void setCodegen(boolean z) {
        this.L = z;
    }

    public void setDbname(java.lang.String str) {
        this.J = str;
    }

    public void setDbschema(java.lang.String str) {
        this.K = str;
    }

    public void setDbvendor(java.lang.String str) {
        this.I = str;
    }

    public void setEJBdtd(java.lang.String str) {
        this.C = str;
    }

    public void setEjbdeploy(boolean z) {
        this.F = z;
    }

    public void setKeepgeneric(boolean z) {
        this.D = z;
    }

    public void setNewCMP(boolean z) {
        this.G = z;
    }

    public void setNoinform(boolean z) {
        this.P = z;
    }

    public void setNovalidate(boolean z) {
        this.N = z;
    }

    public void setNowarn(boolean z) {
        this.O = z;
    }

    public void setOldCMP(boolean z) {
        this.G = !z;
    }

    public void setQuiet(boolean z) {
        this.M = z;
    }

    public void setRebuild(boolean z) {
        this.E = z;
    }

    public void setRmicoptions(java.lang.String str) {
        this.R = str;
    }

    public void setSuffix(java.lang.String str) {
        this.B = str;
    }

    public void setTempdir(java.lang.String str) {
        this.T = str;
    }

    public void setTrace(boolean z) {
        this.Q = z;
    }

    public void setUse35(boolean z) {
        this.S = z;
    }

    public void setWASClasspath(org.apache.tools.ant.types.Path path) {
        this.H = path;
    }

    @Override // org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool, org.apache.tools.ant.taskdefs.optional.ejb.EJBDeploymentTool
    public void validateConfigured() throws org.apache.tools.ant.BuildException {
        super.validateConfigured();
        if (this.F) {
            java.lang.String property = getTask().getProject().getProperty("websphere.home");
            if (property == null) {
                throw new org.apache.tools.ant.BuildException("The 'websphere.home' property must be set when 'ejbdeploy=true'");
            }
            this.U = getTask().getProject().resolveFile(property);
        }
    }

    @Override // org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool
    public void writeJar(java.lang.String str, java.io.File file, java.util.Hashtable hashtable, java.lang.String str2) throws org.apache.tools.ant.BuildException {
        if (!this.F) {
            super.writeJar(str, file, hashtable, str2);
            return;
        }
        java.io.File vendorOutputJarFile = super.getVendorOutputJarFile(str);
        super.writeJar(str, vendorOutputJarFile, hashtable, str2);
        if (this.E || isRebuildRequired(vendorOutputJarFile, file)) {
            b(vendorOutputJarFile, file);
        }
        if (this.D) {
            return;
        }
        log("deleting generic jar " + vendorOutputJarFile.toString(), 3);
        vendorOutputJarFile.delete();
    }
}
