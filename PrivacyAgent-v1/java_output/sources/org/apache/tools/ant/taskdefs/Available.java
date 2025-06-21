package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Available extends org.apache.tools.ant.Task implements org.apache.tools.ant.taskdefs.condition.Condition {
    public static final org.apache.tools.ant.util.FileUtils H = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public org.apache.tools.ant.taskdefs.Available.FileDir A;
    public org.apache.tools.ant.types.Path B;
    public org.apache.tools.ant.AntClassLoader C;
    public java.lang.Object D = com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty.SURFACE_ROTATION_MODE_TRUE;
    public boolean E = false;
    public boolean F = false;
    public boolean G = false;
    public java.lang.String u;
    public java.lang.String v;
    public java.lang.String w;
    public java.io.File x;
    public org.apache.tools.ant.types.Path y;
    public java.lang.String z;

    public static class FileDir extends org.apache.tools.ant.types.EnumeratedAttribute {
        public static final java.lang.String[] b = {"file", "dir"};

        @Override // org.apache.tools.ant.types.EnumeratedAttribute
        public java.lang.String[] getValues() {
            return b;
        }

        public boolean isDir() {
            return "dir".equalsIgnoreCase(getValue());
        }

        public boolean isFile() {
            return "file".equalsIgnoreCase(getValue());
        }
    }

    public final boolean c(java.lang.String str) {
        try {
            if (this.F) {
                org.apache.tools.ant.AntClassLoader createClassLoader = getProject().createClassLoader(this.B);
                this.C = createClassLoader;
                createClassLoader.setParentFirst(false);
                this.C.addJavaLibraries();
                try {
                    this.C.findClass(str);
                } catch (java.lang.SecurityException unused) {
                    return true;
                }
            } else {
                org.apache.tools.ant.AntClassLoader antClassLoader = this.C;
                if (antClassLoader != null) {
                    antClassLoader.loadClass(str);
                } else {
                    java.lang.ClassLoader classLoader = getClass().getClassLoader();
                    if (classLoader != null) {
                        java.lang.Class.forName(str, true, classLoader);
                    } else {
                        java.lang.Class.forName(str);
                    }
                }
            }
            return true;
        } catch (java.lang.ClassNotFoundException unused2) {
            log("class \"" + str + "\" was not found", 4);
            return false;
        } catch (java.lang.NoClassDefFoundError e) {
            log("Could not load dependent class \"" + e.getMessage() + "\" for class \"" + str + "\"", 4);
            return false;
        }
    }

    public org.apache.tools.ant.types.Path createClasspath() {
        if (this.B == null) {
            this.B = new org.apache.tools.ant.types.Path(getProject());
        }
        return this.B.createPath();
    }

    public org.apache.tools.ant.types.Path createFilepath() {
        if (this.y == null) {
            this.y = new org.apache.tools.ant.types.Path(getProject());
        }
        return this.y.createPath();
    }

    public final boolean d() {
        org.apache.tools.ant.types.Path path = this.y;
        if (path == null) {
            return e(this.x, this.w);
        }
        java.lang.String[] list = path.list();
        for (int i = 0; i < list.length; i++) {
            log("Searching " + list[i], 3);
            java.io.File file = new java.io.File(list[i]);
            if (file.exists() && (this.w.equals(list[i]) || this.w.equals(file.getName()))) {
                org.apache.tools.ant.taskdefs.Available.FileDir fileDir = this.A;
                if (fileDir == null) {
                    log("Found: " + file, 3);
                    return true;
                }
                if (fileDir.isDir() && file.isDirectory()) {
                    log("Found directory: " + file, 3);
                    return true;
                }
                if (!this.A.isFile() || !file.isFile()) {
                    return false;
                }
                log("Found file: " + file, 3);
                return true;
            }
            java.io.File parentFile = file.getParentFile();
            if (parentFile != null && parentFile.exists() && this.w.equals(parentFile.getAbsolutePath())) {
                org.apache.tools.ant.taskdefs.Available.FileDir fileDir2 = this.A;
                if (fileDir2 == null) {
                    log("Found: " + parentFile, 3);
                    return true;
                }
                if (!fileDir2.isDir()) {
                    return false;
                }
                log("Found directory: " + parentFile, 3);
                return true;
            }
            if (file.exists() && file.isDirectory()) {
                if (e(new java.io.File(file, this.w), this.w + " in " + file)) {
                    return true;
                }
            }
            while (this.G && parentFile != null && parentFile.exists()) {
                if (e(new java.io.File(parentFile, this.w), this.w + " in " + parentFile)) {
                    return true;
                }
                parentFile = parentFile.getParentFile();
            }
        }
        return false;
    }

    public final boolean e(java.io.File file, java.lang.String str) {
        org.apache.tools.ant.taskdefs.Available.FileDir fileDir = this.A;
        if (fileDir != null) {
            if (fileDir.isDir()) {
                if (file.isDirectory()) {
                    log("Found directory: " + str, 3);
                }
                return file.isDirectory();
            }
            if (this.A.isFile()) {
                if (file.isFile()) {
                    log("Found file: " + str, 3);
                }
                return file.isFile();
            }
        }
        if (file.exists()) {
            log("Found: " + str, 3);
        }
        return file.exists();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.apache.tools.ant.taskdefs.condition.Condition
    public boolean eval() throws org.apache.tools.ant.BuildException {
        try {
            if (this.v == null && this.x == null && this.z == null) {
                throw new org.apache.tools.ant.BuildException("At least one of (classname|file|resource) is required", getLocation());
            }
            if (this.A != null && this.x == null) {
                throw new org.apache.tools.ant.BuildException("The type attribute is only valid when specifying the file attribute.", getLocation());
            }
            org.apache.tools.ant.types.Path path = this.B;
            if (path != null) {
                path.setProject(getProject());
                this.C = getProject().createClassLoader(this.B);
            }
            java.lang.String str = "";
            if (this.E) {
                str = " to set property " + this.u;
            } else {
                setTaskName("available");
            }
            java.lang.String str2 = this.v;
            if (str2 != null && !c(str2)) {
                log("Unable to load class " + this.v + str, 3);
                return false;
            }
            if (this.x != null && !d()) {
                java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("Unable to find ");
                org.apache.tools.ant.taskdefs.Available.FileDir fileDir = this.A;
                if (fileDir != null) {
                    stringBuffer.append(fileDir);
                    stringBuffer.append(' ');
                }
                stringBuffer.append(this.w);
                stringBuffer.append(str);
                log(stringBuffer.toString(), 3);
                org.apache.tools.ant.AntClassLoader antClassLoader = this.C;
                if (antClassLoader != null) {
                    antClassLoader.cleanup();
                    this.C = null;
                }
                if (!this.E) {
                    setTaskName(null);
                }
                return false;
            }
            java.lang.String str3 = this.z;
            if (str3 == null || f(str3)) {
                org.apache.tools.ant.AntClassLoader antClassLoader2 = this.C;
                if (antClassLoader2 != null) {
                    antClassLoader2.cleanup();
                    this.C = null;
                }
                if (this.E) {
                    return true;
                }
                setTaskName(null);
                return true;
            }
            log("Unable to load resource " + this.z + str, 3);
            org.apache.tools.ant.AntClassLoader antClassLoader3 = this.C;
            if (antClassLoader3 != null) {
                antClassLoader3.cleanup();
                this.C = null;
            }
            if (!this.E) {
                setTaskName(null);
            }
            return false;
        } finally {
            org.apache.tools.ant.AntClassLoader antClassLoader4 = this.C;
            if (antClassLoader4 != null) {
                antClassLoader4.cleanup();
                this.C = null;
            }
            if (!this.E) {
                setTaskName(null);
            }
        }
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        if (this.u == null) {
            throw new org.apache.tools.ant.BuildException("property attribute is required", getLocation());
        }
        this.E = true;
        try {
            if (eval()) {
                org.apache.tools.ant.PropertyHelper propertyHelper = org.apache.tools.ant.PropertyHelper.getPropertyHelper(getProject());
                java.lang.Object property = propertyHelper.getProperty(this.u);
                if (property != null && !property.equals(this.D)) {
                    log("DEPRECATED - <available> used to override an existing property." + org.apache.tools.ant.util.StringUtils.LINE_SEP + "  Build file should not reuse the same property name for different values.", 1);
                }
                propertyHelper.setProperty(this.u, this.D, true);
            }
        } finally {
            this.E = false;
        }
    }

    public final boolean f(java.lang.String str) {
        java.io.InputStream resourceAsStream;
        try {
            org.apache.tools.ant.AntClassLoader antClassLoader = this.C;
            if (antClassLoader != null) {
                resourceAsStream = antClassLoader.getResourceAsStream(str);
            } else {
                java.lang.ClassLoader classLoader = getClass().getClassLoader();
                resourceAsStream = classLoader != null ? classLoader.getResourceAsStream(str) : java.lang.ClassLoader.getSystemResourceAsStream(str);
            }
            boolean z = resourceAsStream != null;
            org.apache.tools.ant.util.FileUtils.close(resourceAsStream);
            return z;
        } catch (java.lang.Throwable th) {
            org.apache.tools.ant.util.FileUtils.close((java.io.InputStream) null);
            throw th;
        }
    }

    public void setClassname(java.lang.String str) {
        if ("".equals(str)) {
            return;
        }
        this.v = str;
    }

    public void setClasspath(org.apache.tools.ant.types.Path path) {
        createClasspath().append(path);
    }

    public void setClasspathRef(org.apache.tools.ant.types.Reference reference) {
        createClasspath().setRefid(reference);
    }

    public void setFile(java.io.File file) {
        this.x = file;
        this.w = H.removeLeadingPath(getProject().getBaseDir(), file);
    }

    public void setFilepath(org.apache.tools.ant.types.Path path) {
        createFilepath().append(path);
    }

    public void setIgnoresystemclasses(boolean z) {
        this.F = z;
    }

    public void setProperty(java.lang.String str) {
        this.u = str;
    }

    public void setResource(java.lang.String str) {
        this.z = str;
    }

    public void setSearchParents(boolean z) {
        this.G = z;
    }

    public void setType(java.lang.String str) {
        log("DEPRECATED - The setType(String) method has been deprecated. Use setType(Available.FileDir) instead.", 1);
        org.apache.tools.ant.taskdefs.Available.FileDir fileDir = new org.apache.tools.ant.taskdefs.Available.FileDir();
        this.A = fileDir;
        fileDir.setValue(str);
    }

    public void setType(org.apache.tools.ant.taskdefs.Available.FileDir fileDir) {
        this.A = fileDir;
    }

    public void setValue(java.lang.Object obj) {
        this.D = obj;
    }

    public void setValue(java.lang.String str) {
        setValue((java.lang.Object) str);
    }
}
