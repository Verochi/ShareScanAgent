package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public abstract class Definer extends org.apache.tools.ant.taskdefs.DefBase {
    public static final java.lang.ThreadLocal<java.util.Map<java.net.URL, org.apache.tools.ant.Location>> K = new org.apache.tools.ant.taskdefs.Definer.AnonymousClass1();
    public java.io.File A;
    public java.lang.String B;
    public boolean C = false;
    public int D = 0;
    public boolean E = false;
    public int F = 0;
    public java.lang.String G;
    public java.lang.String H;
    public java.lang.Class<?> I;
    public java.lang.Class<?> J;
    public java.lang.String y;
    public java.lang.String z;

    /* renamed from: org.apache.tools.ant.taskdefs.Definer$1, reason: invalid class name */
    public static class AnonymousClass1 extends java.lang.ThreadLocal<java.util.Map<java.net.URL, org.apache.tools.ant.Location>> {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public java.util.Map<java.net.URL, org.apache.tools.ant.Location> initialValue() {
            return new java.util.HashMap();
        }
    }

    public static class Format extends org.apache.tools.ant.types.EnumeratedAttribute {
        public static final int PROPERTIES = 0;
        public static final int XML = 1;

        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return new java.lang.String[]{"properties", com.aliyun.auth.common.AliyunVodHttpCommon.Format.FORMAT_XML};
        }
    }

    public static class OnError extends org.apache.tools.ant.types.EnumeratedAttribute {
        public static final int FAIL = 0;
        public static final int FAIL_ALL = 3;
        public static final int IGNORE = 2;
        public static final java.lang.String POLICY_FAIL = "fail";
        public static final java.lang.String POLICY_FAILALL = "failall";
        public static final java.lang.String POLICY_IGNORE = "ignore";
        public static final java.lang.String POLICY_REPORT = "report";
        public static final int REPORT = 1;

        public OnError() {
        }

        public OnError(java.lang.String str) {
            setValue(str);
        }

        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return new java.lang.String[]{"fail", POLICY_REPORT, POLICY_IGNORE, POLICY_FAILALL};
        }
    }

    public static java.lang.String makeResourceFromURI(java.lang.String str) {
        java.lang.String substring = str.substring(7);
        if (!substring.startsWith("//")) {
            return substring.replace('.', '/') + "/antlib.xml";
        }
        java.lang.String substring2 = substring.substring(2);
        if (substring2.endsWith(".xml")) {
            return substring2;
        }
        return substring2 + "/antlib.xml";
    }

    public void addDefinition(java.lang.ClassLoader classLoader, java.lang.String str, java.lang.String str2) throws org.apache.tools.ant.BuildException {
        try {
            try {
                java.lang.String genComponentName = org.apache.tools.ant.ProjectHelper.genComponentName(getURI(), str);
                java.lang.Class<?> cls = this.F != 2 ? java.lang.Class.forName(str2, true, classLoader) : null;
                java.lang.String str3 = this.G;
                if (str3 != null) {
                    this.I = java.lang.Class.forName(str3, true, classLoader);
                }
                java.lang.String str4 = this.H;
                if (str4 != null) {
                    this.J = java.lang.Class.forName(str4, true, classLoader);
                }
                org.apache.tools.ant.AntTypeDefinition antTypeDefinition = new org.apache.tools.ant.AntTypeDefinition();
                antTypeDefinition.setName(genComponentName);
                antTypeDefinition.setClassName(str2);
                antTypeDefinition.setClass(cls);
                antTypeDefinition.setAdapterClass(this.I);
                antTypeDefinition.setAdaptToClass(this.J);
                antTypeDefinition.setRestrict(this.C);
                antTypeDefinition.setClassLoader(classLoader);
                if (cls != null) {
                    antTypeDefinition.checkClass(getProject());
                }
                org.apache.tools.ant.ComponentHelper.getComponentHelper(getProject()).addDataTypeDefinition(antTypeDefinition);
            } catch (java.lang.ClassNotFoundException e) {
                throw new org.apache.tools.ant.BuildException(getTaskName() + " class " + str2 + " cannot be found\n using the classloader " + classLoader, e, getLocation());
            } catch (java.lang.NoClassDefFoundError e2) {
                throw new org.apache.tools.ant.BuildException(getTaskName() + " A class needed by class " + str2 + " cannot be found: " + e2.getMessage() + "\n using the classloader " + classLoader, e2, getLocation());
            }
        } catch (org.apache.tools.ant.BuildException e3) {
            int i = this.F;
            if (i != 0) {
                if (i == 1) {
                    log(e3.getLocation() + "Warning: " + e3.getMessage(), 1);
                    return;
                }
                if (i != 3) {
                    log(e3.getLocation() + e3.getMessage(), 4);
                    return;
                }
            }
            throw e3;
        }
    }

    public final java.net.URL d() {
        java.lang.String str;
        if (this.A.exists()) {
            str = null;
        } else {
            str = "File " + this.A + " does not exist";
        }
        if (str == null && !this.A.isFile()) {
            str = "File " + this.A + " is not a file";
        }
        if (str == null) {
            try {
                return org.apache.tools.ant.util.FileUtils.getFileUtils().getFileURL(this.A);
            } catch (java.lang.Exception e) {
                str = "File " + this.A + " cannot use as URL: " + e.toString();
            }
        }
        int i = this.F;
        if (i == 0 || i == 1) {
            log(str, 1);
        } else if (i == 2) {
            log(str, 3);
        } else if (i == 3) {
            throw new org.apache.tools.ant.BuildException(str);
        }
        return null;
    }

    public final void e(java.lang.ClassLoader classLoader, java.net.URL url) {
        try {
            org.apache.tools.ant.taskdefs.Antlib createAntlib = org.apache.tools.ant.taskdefs.Antlib.createAntlib(getProject(), url, getURI());
            createAntlib.setClassLoader(classLoader);
            createAntlib.setURI(getURI());
            createAntlib.execute();
        } catch (org.apache.tools.ant.BuildException e) {
            throw org.apache.tools.ant.ProjectHelper.addLocationToBuildException(e, getLocation());
        }
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        java.util.Enumeration<java.net.URL> enumeration;
        java.lang.ClassLoader createLoader = createLoader();
        if (!this.E) {
            if (getURI() == null) {
                throw new org.apache.tools.ant.BuildException("name, file or resource attribute of " + getTaskName() + " is undefined", getLocation());
            }
            if (!getURI().startsWith("antlib:")) {
                throw new org.apache.tools.ant.BuildException("Only antlib URIs can be located from the URI alone, not the URI '" + getURI() + "'");
            }
            setResource(makeResourceFromURI(getURI()));
        }
        java.lang.String str = this.y;
        if (str != null) {
            java.lang.String str2 = this.z;
            if (str2 != null) {
                addDefinition(createLoader, str, str2);
                return;
            }
            throw new org.apache.tools.ant.BuildException("classname attribute of " + getTaskName() + " element is undefined", getLocation());
        }
        if (this.z != null) {
            throw new org.apache.tools.ant.BuildException("You must not specify classname together with file or resource.", getLocation());
        }
        if (this.A == null) {
            enumeration = f(createLoader);
        } else {
            java.net.URL d = d();
            if (d == null) {
                return;
            } else {
                enumeration = java.util.Collections.enumeration(java.util.Collections.singleton(d));
            }
        }
        while (enumeration.hasMoreElements()) {
            java.net.URL nextElement = enumeration.nextElement();
            int i = this.D;
            if (nextElement.getPath().toLowerCase(java.util.Locale.ENGLISH).endsWith(".xml")) {
                i = 1;
            }
            if (i == 0) {
                loadProperties(createLoader, nextElement);
                return;
            }
            java.lang.ThreadLocal<java.util.Map<java.net.URL, org.apache.tools.ant.Location>> threadLocal = K;
            if (threadLocal.get().get(nextElement) != null) {
                log("Warning: Recursive loading of " + nextElement + " ignored at " + getLocation() + " originally loaded at " + threadLocal.get().get(nextElement), 1);
            } else {
                try {
                    threadLocal.get().put(nextElement, getLocation());
                    e(createLoader, nextElement);
                    threadLocal.get().remove(nextElement);
                } catch (java.lang.Throwable th) {
                    K.get().remove(nextElement);
                    throw th;
                }
            }
        }
    }

    public final java.util.Enumeration<java.net.URL> f(java.lang.ClassLoader classLoader) {
        try {
            java.util.Enumeration<java.net.URL> resources = classLoader.getResources(this.B);
            if (!resources.hasMoreElements()) {
                java.lang.String str = "Could not load definitions from resource " + this.B + org.apache.tools.ant.taskdefs.Rmic.ERROR_NOT_FOUND;
                int i = this.F;
                if (i == 0 || i == 1) {
                    log(str, 1);
                } else if (i == 2) {
                    log(str, 3);
                } else if (i == 3) {
                    throw new org.apache.tools.ant.BuildException(str);
                }
            }
            return resources;
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException("Could not fetch resources named " + this.B, e, getLocation());
        }
    }

    public final void g() {
        throw new org.apache.tools.ant.BuildException("Only one of the attributes name, file and resource can be set", getLocation());
    }

    public java.lang.String getClassname() {
        return this.z;
    }

    public java.io.File getFile() {
        return this.A;
    }

    public java.lang.String getName() {
        return this.y;
    }

    public java.lang.String getResource() {
        return this.B;
    }

    public void loadProperties(java.lang.ClassLoader classLoader, java.net.URL url) {
        try {
            try {
                java.io.InputStream openStream = url.openStream();
                if (openStream == null) {
                    log("Could not load definitions from " + url, 1);
                    org.apache.tools.ant.util.FileUtils.close(openStream);
                    return;
                }
                java.util.Properties properties = new java.util.Properties();
                properties.load(openStream);
                java.util.Enumeration keys = properties.keys();
                while (keys.hasMoreElements()) {
                    java.lang.String str = (java.lang.String) keys.nextElement();
                    this.y = str;
                    java.lang.String property = properties.getProperty(str);
                    this.z = property;
                    addDefinition(classLoader, this.y, property);
                }
                org.apache.tools.ant.util.FileUtils.close(openStream);
            } catch (java.io.IOException e) {
                throw new org.apache.tools.ant.BuildException(e, getLocation());
            }
        } catch (java.lang.Throwable th) {
            org.apache.tools.ant.util.FileUtils.close((java.io.InputStream) null);
            throw th;
        }
    }

    public void setAdaptTo(java.lang.String str) {
        this.H = str;
    }

    public void setAdaptToClass(java.lang.Class<?> cls) {
        this.J = cls;
    }

    public void setAdapter(java.lang.String str) {
        this.G = str;
    }

    public void setAdapterClass(java.lang.Class<?> cls) {
        this.I = cls;
    }

    public void setAntlib(java.lang.String str) {
        if (this.E) {
            g();
        }
        if (!str.startsWith("antlib:")) {
            throw new org.apache.tools.ant.BuildException("Invalid antlib attribute - it must start with antlib:");
        }
        setURI(str);
        this.B = str.substring(7).replace('.', '/') + "/antlib.xml";
        this.E = true;
    }

    public void setClassname(java.lang.String str) {
        this.z = str;
    }

    public void setFile(java.io.File file) {
        if (this.E) {
            g();
        }
        this.E = true;
        this.A = file;
    }

    public void setFormat(org.apache.tools.ant.taskdefs.Definer.Format format) {
        this.D = format.getIndex();
    }

    public void setName(java.lang.String str) {
        if (this.E) {
            g();
        }
        this.E = true;
        this.y = str;
    }

    public void setOnError(org.apache.tools.ant.taskdefs.Definer.OnError onError) {
        this.F = onError.getIndex();
    }

    public void setResource(java.lang.String str) {
        if (this.E) {
            g();
        }
        this.E = true;
        this.B = str;
    }

    public void setRestrict(boolean z) {
        this.C = z;
    }
}
