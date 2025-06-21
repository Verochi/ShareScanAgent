package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Property extends org.apache.tools.ant.Task {
    public boolean A;
    protected org.apache.tools.ant.types.Path classpath;
    protected java.lang.String env;
    protected java.io.File file;
    protected java.lang.String name;
    protected java.lang.String prefix;
    protected org.apache.tools.ant.types.Reference ref;
    protected java.lang.String resource;
    public java.lang.String u;
    protected java.net.URL url;
    protected boolean userProperty;
    public org.apache.tools.ant.Project v;
    protected java.lang.String value;
    public java.lang.Object w;
    public boolean x;
    public boolean y;
    public java.io.File z;

    public Property() {
        this(false);
    }

    public Property(boolean z) {
        this(z, null);
    }

    public Property(boolean z, org.apache.tools.ant.Project project) {
        this.x = false;
        this.y = false;
        this.A = false;
        this.userProperty = z;
        this.v = project;
    }

    public void addProperties(java.util.Properties properties) {
        java.util.HashMap hashMap = new java.util.HashMap(properties);
        e(hashMap);
        for (java.lang.Object obj : hashMap.keySet()) {
            if (obj instanceof java.lang.String) {
                java.lang.String str = (java.lang.String) obj;
                if (this.prefix != null) {
                    str = this.prefix + str;
                }
                addProperty(str, hashMap.get(obj));
            }
        }
    }

    public void addProperty(java.lang.String str, java.lang.Object obj) {
        org.apache.tools.ant.PropertyHelper propertyHelper = org.apache.tools.ant.PropertyHelper.getPropertyHelper(getProject());
        if (!this.userProperty) {
            propertyHelper.setNewProperty(str, obj);
            return;
        }
        if (propertyHelper.getUserProperty(str) == null) {
            propertyHelper.setInheritedProperty(str, obj);
            return;
        }
        log("Override ignored for " + str, 3);
    }

    public void addProperty(java.lang.String str, java.lang.String str2) {
        addProperty(str, (java.lang.Object) str2);
    }

    public void addText(java.lang.String str) {
        if (this.x) {
            if (str.trim().length() > 0) {
                throw new org.apache.tools.ant.BuildException("can't combine nested text with value attribute");
            }
            return;
        }
        java.lang.String replaceProperties = getProject().replaceProperties(str);
        java.lang.String value = getValue();
        if (value != null) {
            replaceProperties = value + replaceProperties;
        }
        c(replaceProperties);
    }

    public final void c(java.lang.Object obj) {
        this.w = obj;
        this.value = obj == null ? null : obj.toString();
    }

    public org.apache.tools.ant.types.Path createClasspath() {
        if (this.classpath == null) {
            this.classpath = new org.apache.tools.ant.types.Path(getProject());
        }
        return this.classpath.createPath();
    }

    public final void d(java.util.Properties properties, java.io.InputStream inputStream, boolean z) throws java.io.IOException {
        if (z) {
            properties.loadFromXML(inputStream);
        } else {
            properties.load(inputStream);
        }
    }

    public final void e(java.util.Map map) throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.PropertyHelper propertyHelper = org.apache.tools.ant.PropertyHelper.getPropertyHelper(getProject());
        new org.apache.tools.ant.property.ResolvePropertyMap(getProject(), propertyHelper, propertyHelper.getExpanders()).resolveAllProperties(map, getPrefix(), getPrefixValues());
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        org.apache.tools.ant.types.Reference reference;
        java.lang.Object obj;
        if (getProject() == null) {
            throw new java.lang.IllegalStateException("project has not been set");
        }
        java.lang.String str = this.name;
        if (str != null) {
            if (this.w == null && this.ref == null) {
                throw new org.apache.tools.ant.BuildException("You must specify value, location or refid with the name attribute", getLocation());
            }
        } else if (this.url == null && this.file == null && this.resource == null && this.env == null && this.u == null) {
            throw new org.apache.tools.ant.BuildException("You must specify url, file, resource, environment or runtime when not using the name attribute", getLocation());
        }
        if (this.url == null && this.file == null && this.resource == null && this.prefix != null) {
            throw new org.apache.tools.ant.BuildException("Prefix is only valid when loading from a url, file or resource", getLocation());
        }
        if (str != null && (obj = this.w) != null) {
            if (this.y) {
                try {
                    java.io.File file = obj instanceof java.io.File ? (java.io.File) obj : new java.io.File(this.w.toString());
                    java.io.File file2 = this.z;
                    if (file2 == null) {
                        file2 = getProject().getBaseDir();
                    }
                    addProperty(this.name, org.apache.tools.ant.util.FileUtils.getRelativePath(file2, file).replace('/', java.io.File.separatorChar));
                } catch (java.lang.Exception e) {
                    throw new org.apache.tools.ant.BuildException(e, getLocation());
                }
            } else {
                addProperty(str, obj);
            }
        }
        java.io.File file3 = this.file;
        if (file3 != null) {
            loadFile(file3);
        }
        java.net.URL url = this.url;
        if (url != null) {
            loadUrl(url);
        }
        java.lang.String str2 = this.resource;
        if (str2 != null) {
            loadResource(str2);
        }
        java.lang.String str3 = this.env;
        if (str3 != null) {
            loadEnvironment(str3);
        }
        java.lang.String str4 = this.u;
        if (str4 != null) {
            loadRuntime(str4);
        }
        java.lang.String str5 = this.name;
        if (str5 == null || (reference = this.ref) == null) {
            return;
        }
        try {
            addProperty(str5, reference.getReferencedObject(getProject()).toString());
        } catch (org.apache.tools.ant.BuildException e2) {
            org.apache.tools.ant.Project project = this.v;
            if (project == null) {
                throw e2;
            }
            addProperty(this.name, this.ref.getReferencedObject(project).toString());
        }
    }

    public org.apache.tools.ant.types.Path getClasspath() {
        return this.classpath;
    }

    public java.lang.String getEnvironment() {
        return this.env;
    }

    public java.io.File getFile() {
        return this.file;
    }

    public java.lang.String getName() {
        return this.name;
    }

    public java.lang.String getPrefix() {
        return this.prefix;
    }

    public boolean getPrefixValues() {
        return this.A;
    }

    public org.apache.tools.ant.types.Reference getRefid() {
        return this.ref;
    }

    public java.lang.String getResource() {
        return this.resource;
    }

    public java.lang.String getRuntime() {
        return this.u;
    }

    public java.net.URL getUrl() {
        return this.url;
    }

    public java.lang.String getValue() {
        return this.value;
    }

    public void loadEnvironment(java.lang.String str) {
        java.util.Properties properties = new java.util.Properties();
        if (!str.endsWith(".")) {
            str = str + ".";
        }
        log("Loading Environment " + str, 3);
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : org.apache.tools.ant.taskdefs.Execute.getEnvironmentVariables().entrySet()) {
            properties.put(str + ((java.lang.Object) entry.getKey()), entry.getValue());
        }
        addProperties(properties);
    }

    public void loadFile(java.io.File file) throws org.apache.tools.ant.BuildException {
        java.io.FileInputStream fileInputStream;
        java.util.Properties properties = new java.util.Properties();
        log("Loading " + file.getAbsolutePath(), 3);
        try {
            if (!file.exists()) {
                log("Unable to find property file: " + file.getAbsolutePath(), 3);
                return;
            }
            java.io.FileInputStream fileInputStream2 = null;
            try {
                fileInputStream = new java.io.FileInputStream(file);
            } catch (java.lang.Throwable th) {
                th = th;
            }
            try {
                d(properties, fileInputStream, file.getName().endsWith(".xml"));
                org.apache.tools.ant.util.FileUtils.close(fileInputStream);
                addProperties(properties);
            } catch (java.lang.Throwable th2) {
                th = th2;
                fileInputStream2 = fileInputStream;
                org.apache.tools.ant.util.FileUtils.close(fileInputStream2);
                throw th;
            }
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException(e, getLocation());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.lang.ClassLoader] */
    public void loadResource(java.lang.String str) {
        boolean z;
        org.apache.tools.ant.AntClassLoader createClassLoader;
        boolean z2;
        java.util.Properties properties = new java.util.Properties();
        log("Resource Loading " + str, 3);
        org.apache.tools.ant.AntClassLoader antClassLoader = null;
        try {
            try {
                if (this.classpath != null) {
                    try {
                        createClassLoader = getProject().createClassLoader(this.classpath);
                        z2 = true;
                    } catch (java.io.IOException e) {
                        e = e;
                        throw new org.apache.tools.ant.BuildException(e, getLocation());
                    } catch (java.lang.Throwable th) {
                        th = th;
                        antClassLoader = null;
                        z = true;
                        org.apache.tools.ant.util.FileUtils.close((java.io.InputStream) null);
                        if (z && antClassLoader != null) {
                            antClassLoader.cleanup();
                        }
                        throw th;
                    }
                } else {
                    createClassLoader = getClass().getClassLoader();
                    z2 = false;
                }
                try {
                    java.io.InputStream systemResourceAsStream = createClassLoader == null ? java.lang.ClassLoader.getSystemResourceAsStream(str) : createClassLoader.getResourceAsStream(str);
                    if (systemResourceAsStream != null) {
                        d(properties, systemResourceAsStream, str.endsWith(".xml"));
                        addProperties(properties);
                    } else {
                        log("Unable to find resource " + str, 1);
                    }
                    org.apache.tools.ant.util.FileUtils.close(systemResourceAsStream);
                    if (!z2 || createClassLoader == null) {
                        return;
                    }
                    createClassLoader.cleanup();
                } catch (java.io.IOException e2) {
                    e = e2;
                    throw new org.apache.tools.ant.BuildException(e, getLocation());
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.io.IOException e3) {
            e = e3;
        } catch (java.lang.Throwable th3) {
            th = th3;
            antClassLoader = null;
            z = false;
        }
    }

    public void loadRuntime(java.lang.String str) {
        java.util.Properties properties = new java.util.Properties();
        if (!str.endsWith(".")) {
            str = str + ".";
        }
        log("Loading Runtime properties " + str, 3);
        java.lang.Runtime runtime = java.lang.Runtime.getRuntime();
        properties.put(str + "availableProcessors", java.lang.String.valueOf(runtime.availableProcessors()));
        properties.put(str + "freeMemory", java.lang.String.valueOf(runtime.freeMemory()));
        properties.put(str + "maxMemory", java.lang.String.valueOf(runtime.maxMemory()));
        properties.put(str + "totalMemory", java.lang.String.valueOf(runtime.totalMemory()));
        addProperties(properties);
    }

    public void loadUrl(java.net.URL url) throws org.apache.tools.ant.BuildException {
        java.util.Properties properties = new java.util.Properties();
        log("Loading " + url, 3);
        try {
            java.io.InputStream openStream = url.openStream();
            try {
                d(properties, openStream, url.getFile().endsWith(".xml"));
                addProperties(properties);
            } finally {
                if (openStream != null) {
                    openStream.close();
                }
            }
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException(e, getLocation());
        }
    }

    public void setBasedir(java.io.File file) {
        this.z = file;
    }

    public void setClasspath(org.apache.tools.ant.types.Path path) {
        org.apache.tools.ant.types.Path path2 = this.classpath;
        if (path2 == null) {
            this.classpath = path;
        } else {
            path2.append(path);
        }
    }

    public void setClasspathRef(org.apache.tools.ant.types.Reference reference) {
        createClasspath().setRefid(reference);
    }

    public void setEnvironment(java.lang.String str) {
        this.env = str;
    }

    public void setFile(java.io.File file) {
        this.file = file;
    }

    public void setLocation(java.io.File file) {
        if (this.y) {
            c(file);
        } else {
            setValue(file.getAbsolutePath());
        }
    }

    public void setName(java.lang.String str) {
        this.name = str;
    }

    public void setPrefix(java.lang.String str) {
        this.prefix = str;
        if (str == null || str.endsWith(".")) {
            return;
        }
        this.prefix += ".";
    }

    public void setPrefixValues(boolean z) {
        this.A = z;
    }

    public void setRefid(org.apache.tools.ant.types.Reference reference) {
        this.ref = reference;
    }

    public void setRelative(boolean z) {
        this.y = z;
    }

    public void setResource(java.lang.String str) {
        this.resource = str;
    }

    public void setRuntime(java.lang.String str) {
        this.u = str;
    }

    public void setUrl(java.net.URL url) {
        this.url = url;
    }

    @java.lang.Deprecated
    public void setUserProperty(boolean z) {
        log("DEPRECATED: Ignoring request to set user property in Property task.", 1);
    }

    public void setValue(java.lang.Object obj) {
        this.x = true;
        c(obj);
    }

    public void setValue(java.lang.String str) {
        setValue((java.lang.Object) str);
    }

    public java.lang.String toString() {
        java.lang.String str = this.value;
        return str == null ? "" : str;
    }
}
