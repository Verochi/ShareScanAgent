package org.apache.tools.ant.taskdefs.optional.ejb;

/* loaded from: classes25.dex */
public class JonasDeploymentTool extends org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool {
    protected static final java.lang.String DAVID_ORB = "DAVID";
    protected static final java.lang.String EJB_JAR_1_1_DTD = "ejb-jar_1_1.dtd";
    protected static final java.lang.String EJB_JAR_1_1_PUBLIC_ID = "-//Sun Microsystems, Inc.//DTD Enterprise JavaBeans 1.1//EN";
    protected static final java.lang.String EJB_JAR_2_0_DTD = "ejb-jar_2_0.dtd";
    protected static final java.lang.String EJB_JAR_2_0_PUBLIC_ID = "-//Sun Microsystems, Inc.//DTD Enterprise JavaBeans 2.0//EN";
    protected static final java.lang.String GENIC_CLASS = "org.objectweb.jonas_ejb.genic.GenIC";
    protected static final java.lang.String JEREMIE_ORB = "JEREMIE";
    protected static final java.lang.String JONAS_DD = "jonas-ejb-jar.xml";
    protected static final java.lang.String JONAS_EJB_JAR_2_4_DTD = "jonas-ejb-jar_2_4.dtd";
    protected static final java.lang.String JONAS_EJB_JAR_2_4_PUBLIC_ID = "-//ObjectWeb//DTD JOnAS 2.4//EN";
    protected static final java.lang.String JONAS_EJB_JAR_2_5_DTD = "jonas-ejb-jar_2_5.dtd";
    protected static final java.lang.String JONAS_EJB_JAR_2_5_PUBLIC_ID = "-//ObjectWeb//DTD JOnAS 2.5//EN";
    protected static final java.lang.String OLD_GENIC_CLASS_1 = "org.objectweb.jonas_ejb.tools.GenWholeIC";
    protected static final java.lang.String OLD_GENIC_CLASS_2 = "org.objectweb.jonas_ejb.tools.GenIC";
    protected static final java.lang.String RMI_ORB = "RMI";
    public java.lang.String B;
    public java.lang.String C;
    public java.io.File D;
    public java.lang.String H;
    public java.lang.String I;
    public java.lang.String J;
    public java.lang.String M;
    public java.io.File N;
    public java.lang.String Q;
    public boolean E = false;
    public boolean F = false;
    public boolean G = false;
    public boolean K = false;
    public boolean L = false;
    public boolean O = false;
    public java.lang.String P = ".jar";
    public boolean R = false;

    @Override // org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool
    public void addVendorFiles(java.util.Hashtable hashtable, java.lang.String str) {
        this.C = g();
        java.io.File file = new java.io.File(getConfig().b, this.C);
        if (file.exists()) {
            hashtable.put("META-INF/jonas-ejb-jar.xml", file);
            return;
        }
        log("Unable to locate the JOnAS deployment descriptor. It was expected to be in: " + file.getPath() + ".", 1);
    }

    public final void b(java.io.File file, java.lang.String str, java.util.Hashtable hashtable) {
        if (!file.exists()) {
            throw new java.lang.IllegalArgumentException();
        }
        if (!file.isDirectory()) {
            hashtable.put(str, file);
            return;
        }
        java.io.File[] listFiles = file.listFiles();
        for (int i = 0; i < listFiles.length; i++) {
            b(listFiles[i], str.length() > 0 ? str + java.io.File.separator + listFiles[i].getName() : listFiles[i].getName(), hashtable);
        }
    }

    public final void c(java.io.File file, java.util.Hashtable hashtable) {
        if (this.R) {
            return;
        }
        org.apache.tools.ant.taskdefs.Java java = new org.apache.tools.ant.taskdefs.Java(getTask());
        java.setTaskName("genic");
        java.setFork(true);
        java.createJvmarg().setValue("-Dinstall.root=" + this.N);
        java.lang.String str = this.N + java.io.File.separator + "config";
        java.io.File file2 = new java.io.File(str, "java.policy");
        if (file2.exists()) {
            java.createJvmarg().setValue("-Djava.security.policy=" + file2.toString());
        }
        try {
            this.D = d();
            log("Using temporary output directory: " + this.D, 3);
            java.createArg().setValue("-d");
            java.createArg().setFile(this.D);
            java.util.Enumeration keys = hashtable.keys();
            while (keys.hasMoreElements()) {
                new java.io.File(this.D + java.io.File.separator + ((java.lang.String) keys.nextElement())).getParentFile().mkdirs();
            }
            log("Worked around a bug of GenIC 2.5.", 3);
            org.apache.tools.ant.types.Path combinedClasspath = getCombinedClasspath();
            if (combinedClasspath == null) {
                combinedClasspath = new org.apache.tools.ant.types.Path(getTask().getProject());
            }
            combinedClasspath.append(new org.apache.tools.ant.types.Path(combinedClasspath.getProject(), str));
            combinedClasspath.append(new org.apache.tools.ant.types.Path(combinedClasspath.getProject(), this.D.toString()));
            if (this.Q != null) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(this.N);
                java.lang.String str2 = java.io.File.separator;
                sb.append(str2);
                sb.append("lib");
                sb.append(str2);
                sb.append(this.Q);
                sb.append("_jonas.jar");
                combinedClasspath.append(new org.apache.tools.ant.types.Path(combinedClasspath.getProject(), sb.toString()));
            }
            log("Using classpath: " + combinedClasspath.toString(), 3);
            java.setClasspath(combinedClasspath);
            java.lang.String f = f(combinedClasspath);
            if (f == null) {
                log("Cannot find GenIC class in classpath.", 0);
                throw new org.apache.tools.ant.BuildException("GenIC class not found, please check the classpath.");
            }
            log("Using '" + f + "' GenIC class.", 3);
            java.setClassname(f);
            if (this.E) {
                java.createArg().setValue("-keepgenerated");
            }
            if (this.F) {
                java.createArg().setValue("-nocompil");
            }
            if (this.G) {
                java.createArg().setValue("-novalidation");
            }
            if (this.H != null) {
                java.createArg().setValue("-javac");
                java.createArg().setLine(this.H);
            }
            java.lang.String str3 = this.I;
            if (str3 != null && !str3.equals("")) {
                java.createArg().setValue("-javacopts");
                java.createArg().setLine(this.I);
            }
            java.lang.String str4 = this.J;
            if (str4 != null && !str4.equals("")) {
                java.createArg().setValue("-rmicopts");
                java.createArg().setLine(this.J);
            }
            if (this.K) {
                java.createArg().setValue("-secpropag");
            }
            if (this.L) {
                java.createArg().setValue(org.apache.tools.ant.taskdefs.optional.sos.SOSCmd.FLAG_VERBOSE);
            }
            if (this.M != null) {
                java.createArg().setValue(this.M);
            }
            java.createArg().setValue("-noaddinjar");
            java.createArg().setValue(file.getPath());
            log("Calling " + f + " for " + getConfig().b + java.io.File.separator + this.B + ".", 3);
            if (java.executeJava() == 0) {
                b(this.D, "", hashtable);
                return;
            }
            log("Deleting temp output directory '" + this.D + "'.", 3);
            e(this.D);
            if (!this.O) {
                log("Deleting generic JAR " + file.toString(), 3);
                file.delete();
            }
            throw new org.apache.tools.ant.BuildException("GenIC reported an error.");
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException("Cannot create temp dir: " + e.getMessage(), e);
        }
    }

    @Override // org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool
    public void checkConfiguration(java.lang.String str, javax.xml.parsers.SAXParser sAXParser) throws org.apache.tools.ant.BuildException {
        java.io.File file = this.N;
        if (file == null) {
            throw new org.apache.tools.ant.BuildException("The jonasroot attribut is not set.");
        }
        if (!file.isDirectory()) {
            throw new org.apache.tools.ant.BuildException("The jonasroot attribut '" + this.N + "' is not a valid directory.");
        }
        java.lang.String str2 = this.Q;
        if (str2 == null || str2.equals(RMI_ORB) || this.Q.equals(JEREMIE_ORB) || this.Q.equals(DAVID_ORB)) {
            java.lang.String str3 = this.M;
            if (str3 != null && str3.equals("")) {
                throw new org.apache.tools.ant.BuildException("Empty additionalargs attribut.");
            }
            java.lang.String str4 = this.H;
            if (str4 != null && str4.equals("")) {
                throw new org.apache.tools.ant.BuildException("Empty javac attribut.");
            }
            return;
        }
        throw new org.apache.tools.ant.BuildException("The orb attribut '" + this.Q + "' is not valid (must be either " + RMI_ORB + ", " + JEREMIE_ORB + " or " + DAVID_ORB + ").");
    }

    public final java.io.File d() throws java.io.IOException {
        java.io.File createTempFile = java.io.File.createTempFile("genic", null, null);
        createTempFile.delete();
        if (createTempFile.mkdir()) {
            return createTempFile;
        }
        throw new java.io.IOException("Cannot create the temporary directory '" + createTempFile + "'.");
    }

    public final void e(java.io.File file) {
        if (file.isDirectory()) {
            for (java.io.File file2 : file.listFiles()) {
                e(file2);
            }
        }
        file.delete();
    }

    public java.lang.String f(org.apache.tools.ant.types.Path path) {
        log("Looking for GenIC class in classpath: " + path.toString(), 3);
        org.apache.tools.ant.AntClassLoader antClassLoader = null;
        try {
            org.apache.tools.ant.AntClassLoader createClassLoader = path.getProject().createClassLoader(path);
            try {
                try {
                    createClassLoader.loadClass(GENIC_CLASS);
                    log("Found GenIC class 'org.objectweb.jonas_ejb.genic.GenIC' in classpath.", 3);
                    createClassLoader.cleanup();
                    return GENIC_CLASS;
                } catch (java.lang.ClassNotFoundException unused) {
                    log("GenIC class 'org.objectweb.jonas_ejb.genic.GenIC' not found in classpath.", 3);
                    try {
                        createClassLoader.loadClass(OLD_GENIC_CLASS_1);
                        log("Found GenIC class 'org.objectweb.jonas_ejb.tools.GenWholeIC' in classpath.", 3);
                        createClassLoader.cleanup();
                        return OLD_GENIC_CLASS_1;
                    } catch (java.lang.ClassNotFoundException unused2) {
                        log("GenIC class 'org.objectweb.jonas_ejb.tools.GenWholeIC' not found in classpath.", 3);
                        try {
                            createClassLoader.loadClass(OLD_GENIC_CLASS_2);
                            log("Found GenIC class 'org.objectweb.jonas_ejb.tools.GenIC' in classpath.", 3);
                            createClassLoader.cleanup();
                            return OLD_GENIC_CLASS_2;
                        } catch (java.lang.ClassNotFoundException unused3) {
                            log("GenIC class 'org.objectweb.jonas_ejb.tools.GenIC' not found in classpath.", 3);
                            if (createClassLoader != null) {
                                createClassLoader.cleanup();
                            }
                            return null;
                        }
                    }
                }
            } catch (java.lang.Throwable th) {
                th = th;
                antClassLoader = createClassLoader;
                if (antClassLoader != null) {
                    antClassLoader.cleanup();
                }
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    public final java.lang.String g() {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        int lastIndexOf = this.B.lastIndexOf(java.io.File.separatorChar);
        boolean z = false;
        if (lastIndexOf != -1) {
            int i = lastIndexOf + 1;
            str2 = this.B.substring(0, i);
            str = this.B.substring(i);
        } else {
            str = this.B;
            str2 = "";
        }
        if (str.startsWith("ejb-jar.xml")) {
            return str2 + JONAS_DD;
        }
        int indexOf = this.B.indexOf(getConfig().c, lastIndexOf);
        if (indexOf < 0) {
            int lastIndexOf2 = this.B.lastIndexOf(46) - 1;
            if (lastIndexOf2 < 0) {
                lastIndexOf2 = this.B.length() - 1;
            }
            indexOf = lastIndexOf2;
            z = true;
        }
        int i2 = indexOf + 1;
        java.lang.String substring = this.B.substring(lastIndexOf + 1, i2);
        java.lang.String substring2 = this.B.substring(i2);
        if (z) {
            str3 = str2 + "jonas-" + substring + ".xml";
        } else {
            str3 = str2 + substring + "jonas-" + substring2;
        }
        log("Standard EJB descriptor name: " + this.B, 3);
        log("JOnAS-specific descriptor name: " + str3, 3);
        return str3;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0043  */
    @Override // org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.lang.String getJarBaseName(java.lang.String str) {
        java.lang.String str2;
        if (getConfig().i.getValue().equals(org.apache.tools.ant.taskdefs.optional.ejb.EjbJar.NamingScheme.DESCRIPTOR) && !str.contains(getConfig().c)) {
            int lastIndexOf = str.replace('\\', '/').lastIndexOf(47);
            int indexOf = lastIndexOf != -1 ? str.indexOf(".xml", lastIndexOf) : str.indexOf(".xml");
            if (indexOf != -1) {
                str2 = str.substring(0, indexOf);
                if (str2 == null) {
                    str2 = super.getJarBaseName(str);
                }
                log("JAR base name: " + str2, 3);
                return str2;
            }
        }
        str2 = null;
        if (str2 == null) {
        }
        log("JAR base name: " + str2, 3);
        return str2;
    }

    @Override // org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool
    public java.io.File getVendorOutputJarFile(java.lang.String str) {
        return new java.io.File(getDestDir(), str + this.P);
    }

    @Override // org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool, org.apache.tools.ant.taskdefs.optional.ejb.EJBDeploymentTool
    public void processDescriptor(java.lang.String str, javax.xml.parsers.SAXParser sAXParser) {
        this.B = str;
        log("JOnAS Deployment Tool processing: " + this.B, 3);
        super.processDescriptor(this.B, sAXParser);
        if (this.D != null) {
            log("Deleting temp output directory '" + this.D + "'.", 3);
            e(this.D);
        }
    }

    @Override // org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool
    public void registerKnownDTDs(org.apache.tools.ant.taskdefs.optional.ejb.DescriptorHandler descriptorHandler) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.N);
        java.lang.String str = java.io.File.separator;
        sb.append(str);
        sb.append(com.aliyun.auth.common.AliyunVodHttpCommon.Format.FORMAT_XML);
        sb.append(str);
        sb.append(EJB_JAR_1_1_DTD);
        descriptorHandler.registerDTD("-//Sun Microsystems, Inc.//DTD Enterprise JavaBeans 1.1//EN", sb.toString());
        descriptorHandler.registerDTD("-//Sun Microsystems, Inc.//DTD Enterprise JavaBeans 2.0//EN", this.N + str + com.aliyun.auth.common.AliyunVodHttpCommon.Format.FORMAT_XML + str + EJB_JAR_2_0_DTD);
        descriptorHandler.registerDTD(JONAS_EJB_JAR_2_4_PUBLIC_ID, this.N + str + com.aliyun.auth.common.AliyunVodHttpCommon.Format.FORMAT_XML + str + JONAS_EJB_JAR_2_4_DTD);
        descriptorHandler.registerDTD(JONAS_EJB_JAR_2_5_PUBLIC_ID, this.N + str + com.aliyun.auth.common.AliyunVodHttpCommon.Format.FORMAT_XML + str + JONAS_EJB_JAR_2_5_DTD);
    }

    public void setAdditionalargs(java.lang.String str) {
        this.M = str;
    }

    public void setJarsuffix(java.lang.String str) {
        this.P = str;
    }

    public void setJavac(java.lang.String str) {
        this.H = str;
    }

    public void setJavacopts(java.lang.String str) {
        this.I = str;
    }

    public void setJonasroot(java.io.File file) {
        this.N = file;
    }

    public void setKeepgenerated(boolean z) {
        this.E = z;
    }

    public void setKeepgeneric(boolean z) {
        this.O = z;
    }

    public void setNocompil(boolean z) {
        this.F = z;
    }

    public void setNogenic(boolean z) {
        this.R = z;
    }

    public void setNovalidation(boolean z) {
        this.G = z;
    }

    public void setOrb(java.lang.String str) {
        this.Q = str;
    }

    public void setRmicopts(java.lang.String str) {
        this.J = str;
    }

    public void setSecpropag(boolean z) {
        this.K = z;
    }

    public void setVerbose(boolean z) {
        this.L = z;
    }

    @Override // org.apache.tools.ant.taskdefs.optional.ejb.GenericDeploymentTool
    public void writeJar(java.lang.String str, java.io.File file, java.util.Hashtable hashtable, java.lang.String str2) throws org.apache.tools.ant.BuildException {
        java.io.File vendorOutputJarFile = super.getVendorOutputJarFile(str);
        super.writeJar(str, vendorOutputJarFile, hashtable, str2);
        c(vendorOutputJarFile, hashtable);
        super.writeJar(str, getVendorOutputJarFile(str), hashtable, str2);
        if (this.O) {
            return;
        }
        log("Deleting generic JAR " + vendorOutputJarFile.toString(), 3);
        vendorOutputJarFile.delete();
    }
}
