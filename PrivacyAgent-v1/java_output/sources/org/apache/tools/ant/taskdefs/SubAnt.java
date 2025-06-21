package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class SubAnt extends org.apache.tools.ant.Task {
    public org.apache.tools.ant.types.Path u;
    public org.apache.tools.ant.taskdefs.Ant v = null;
    public java.lang.String w = null;
    public java.lang.String x = getDefaultBuildFile();
    public java.io.File y = null;
    public boolean z = false;
    public boolean A = false;
    public boolean B = false;
    public boolean C = true;
    public java.lang.String D = null;
    public java.util.Vector E = new java.util.Vector();
    public java.util.Vector F = new java.util.Vector();
    public java.util.Vector G = new java.util.Vector();
    public java.util.Vector H = new java.util.Vector();

    public static void c(org.apache.tools.ant.taskdefs.Property property, org.apache.tools.ant.taskdefs.Property property2) {
        property.setName(property2.getName());
        if (property2.getValue() != null) {
            property.setValue(property2.getValue());
        }
        if (property2.getFile() != null) {
            property.setFile(property2.getFile());
        }
        if (property2.getResource() != null) {
            property.setResource(property2.getResource());
        }
        if (property2.getPrefix() != null) {
            property.setPrefix(property2.getPrefix());
        }
        if (property2.getRefid() != null) {
            property.setRefid(property2.getRefid());
        }
        if (property2.getEnvironment() != null) {
            property.setEnvironment(property2.getEnvironment());
        }
        if (property2.getClasspath() != null) {
            property.setClasspath(property2.getClasspath());
        }
    }

    public void add(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        f().add(resourceCollection);
    }

    public void addConfiguredTarget(org.apache.tools.ant.taskdefs.Ant.TargetElement targetElement) {
        if ("".equals(targetElement.getName())) {
            throw new org.apache.tools.ant.BuildException("target name must not be empty");
        }
        this.H.add(targetElement);
    }

    public void addDirset(org.apache.tools.ant.types.DirSet dirSet) {
        add(dirSet);
    }

    public void addFilelist(org.apache.tools.ant.types.FileList fileList) {
        add(fileList);
    }

    public void addFileset(org.apache.tools.ant.types.FileSet fileSet) {
        add(fileSet);
    }

    public void addProperty(org.apache.tools.ant.taskdefs.Property property) {
        this.E.addElement(property);
    }

    public void addPropertyset(org.apache.tools.ant.types.PropertySet propertySet) {
        this.G.addElement(propertySet);
    }

    public void addReference(org.apache.tools.ant.taskdefs.Ant.Reference reference) {
        this.F.addElement(reference);
    }

    public org.apache.tools.ant.types.Path createBuildpath() {
        return f().createPath();
    }

    public org.apache.tools.ant.types.Path.PathElement createBuildpathElement() {
        return f().createPathElement();
    }

    public final org.apache.tools.ant.taskdefs.Ant d(java.io.File file) {
        org.apache.tools.ant.taskdefs.Ant ant = new org.apache.tools.ant.taskdefs.Ant(this);
        ant.init();
        java.lang.String str = this.w;
        if (str != null && str.length() > 0) {
            ant.setTarget(this.w);
        }
        java.lang.String str2 = this.D;
        if (str2 != null) {
            ant.setOutput(str2);
        }
        if (file != null) {
            ant.setDir(file);
        } else {
            ant.setUseNativeBasedir(true);
        }
        ant.setInheritAll(this.A);
        java.util.Enumeration elements = this.E.elements();
        while (elements.hasMoreElements()) {
            c(ant.createProperty(), (org.apache.tools.ant.taskdefs.Property) elements.nextElement());
        }
        java.util.Enumeration elements2 = this.G.elements();
        while (elements2.hasMoreElements()) {
            ant.addPropertyset((org.apache.tools.ant.types.PropertySet) elements2.nextElement());
        }
        ant.setInheritRefs(this.B);
        java.util.Enumeration elements3 = this.F.elements();
        while (elements3.hasMoreElements()) {
            ant.addReference((org.apache.tools.ant.taskdefs.Ant.Reference) elements3.nextElement());
        }
        return ant;
    }

    public final void e(java.io.File file, java.io.File file2) throws org.apache.tools.ant.BuildException {
        if (!file.exists() || file.isDirectory() || !file.canRead()) {
            java.lang.String str = "Invalid file: " + file;
            if (this.C) {
                throw new org.apache.tools.ant.BuildException(str);
            }
            log(str, 1);
            return;
        }
        this.v = d(file2);
        java.lang.String absolutePath = file.getAbsolutePath();
        this.v.setAntfile(absolutePath);
        int size = this.H.size();
        for (int i = 0; i < size; i++) {
            this.v.addConfiguredTarget((org.apache.tools.ant.taskdefs.Ant.TargetElement) this.H.get(i));
        }
        try {
            try {
                if (this.z) {
                    log("Executing: " + absolutePath, 2);
                }
                this.v.execute();
            } finally {
                this.v = null;
            }
        } catch (org.apache.tools.ant.BuildException e) {
            if (this.C || g(e)) {
                throw e;
            }
            log("Failure for target '" + this.w + "' of: " + absolutePath + "\n" + e.getMessage(), 1);
        } catch (java.lang.Throwable th) {
            if (this.C || g(th)) {
                throw new org.apache.tools.ant.BuildException(th);
            }
            log("Failure for target '" + this.w + "' of: " + absolutePath + "\n" + th.toString(), 1);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x015d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0098 A[SYNTHETIC] */
    @Override // org.apache.tools.ant.Task
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void execute() {
        java.io.File file;
        java.lang.String str;
        java.io.File file2;
        org.apache.tools.ant.types.Path path = this.u;
        if (path == null) {
            throw new org.apache.tools.ant.BuildException("No buildpath specified");
        }
        java.lang.String[] list = path.list();
        if (list.length < 1) {
            log("No sub-builds to iterate on", 1);
            return;
        }
        org.apache.tools.ant.BuildException buildException = null;
        for (java.lang.String str2 : list) {
            try {
                file = new java.io.File(str2);
                try {
                    if (file.isDirectory()) {
                        if (this.z) {
                            str = file.getPath();
                            try {
                                log("Entering directory: " + str + "\n", 2);
                            } catch (java.lang.RuntimeException e) {
                                e = e;
                                if (!getProject().isKeepGoingMode()) {
                                    if (this.z && str != null) {
                                        log("Leaving directory: " + str + "\n", 2);
                                    }
                                    throw e;
                                }
                                if (e != null) {
                                }
                            } catch (java.lang.Throwable th) {
                                e = th;
                                if (!getProject().isKeepGoingMode()) {
                                    if (this.z && str != null) {
                                        log("Leaving directory: " + str + "\n", 2);
                                    }
                                    throw new org.apache.tools.ant.BuildException(e);
                                }
                                if (e != null) {
                                }
                            }
                        } else {
                            str = null;
                        }
                        java.io.File file3 = this.y;
                        if (file3 != null) {
                            file = file3;
                            file2 = file;
                        } else {
                            file = new java.io.File(file, this.x);
                            file2 = null;
                        }
                    } else {
                        file2 = null;
                        str = null;
                    }
                    e(file, file2);
                    if (this.z && str != null) {
                        log("Leaving directory: " + str + "\n", 2);
                    }
                    e = null;
                } catch (java.lang.RuntimeException e2) {
                    e = e2;
                    str = null;
                    if (!getProject().isKeepGoingMode()) {
                    }
                    if (e != null) {
                    }
                } catch (java.lang.Throwable th2) {
                    e = th2;
                    str = null;
                    if (!getProject().isKeepGoingMode()) {
                    }
                    if (e != null) {
                    }
                }
            } catch (java.lang.RuntimeException e3) {
                e = e3;
                file = null;
            } catch (java.lang.Throwable th3) {
                e = th3;
                file = null;
            }
            if (e != null) {
                if (e instanceof org.apache.tools.ant.BuildException) {
                    log("File '" + file + "' failed with message '" + e.getMessage() + "'.", 0);
                    if (buildException == null) {
                        buildException = (org.apache.tools.ant.BuildException) e;
                    }
                } else {
                    log("Target '" + file + "' failed with message '" + e.getMessage() + "'.", 0);
                    log(org.apache.tools.ant.util.StringUtils.getStackTrace(e), 0);
                    if (buildException == null) {
                        buildException = new org.apache.tools.ant.BuildException(e);
                    }
                }
                if (this.z && str != null) {
                    log("Leaving directory: " + str + "\n", 2);
                }
            }
        }
        if (buildException != null) {
            throw buildException;
        }
    }

    public final org.apache.tools.ant.types.Path f() {
        if (this.u == null) {
            this.u = new org.apache.tools.ant.types.Path(getProject());
        }
        return this.u;
    }

    public final boolean g(java.lang.Throwable th) {
        return th instanceof org.apache.tools.ant.BuildException ? g(th.getCause()) : (th instanceof java.lang.OutOfMemoryError) || (th instanceof java.lang.ThreadDeath);
    }

    public java.lang.String getDefaultBuildFile() {
        return org.apache.tools.ant.Main.DEFAULT_BUILD_FILENAME;
    }

    @Override // org.apache.tools.ant.Task
    public void handleErrorFlush(java.lang.String str) {
        org.apache.tools.ant.taskdefs.Ant ant = this.v;
        if (ant != null) {
            ant.handleErrorFlush(str);
        } else {
            super.handleErrorFlush(str);
        }
    }

    @Override // org.apache.tools.ant.Task
    public void handleErrorOutput(java.lang.String str) {
        org.apache.tools.ant.taskdefs.Ant ant = this.v;
        if (ant != null) {
            ant.handleErrorOutput(str);
        } else {
            super.handleErrorOutput(str);
        }
    }

    @Override // org.apache.tools.ant.Task
    public void handleFlush(java.lang.String str) {
        org.apache.tools.ant.taskdefs.Ant ant = this.v;
        if (ant != null) {
            ant.handleFlush(str);
        } else {
            super.handleFlush(str);
        }
    }

    @Override // org.apache.tools.ant.Task
    public int handleInput(byte[] bArr, int i, int i2) throws java.io.IOException {
        org.apache.tools.ant.taskdefs.Ant ant = this.v;
        return ant != null ? ant.handleInput(bArr, i, i2) : super.handleInput(bArr, i, i2);
    }

    @Override // org.apache.tools.ant.Task
    public void handleOutput(java.lang.String str) {
        org.apache.tools.ant.taskdefs.Ant ant = this.v;
        if (ant != null) {
            ant.handleOutput(str);
        } else {
            super.handleOutput(str);
        }
    }

    public void setAntfile(java.lang.String str) {
        this.x = str;
    }

    public void setBuildpath(org.apache.tools.ant.types.Path path) {
        f().append(path);
    }

    public void setBuildpathRef(org.apache.tools.ant.types.Reference reference) {
        createBuildpath().setRefid(reference);
    }

    public void setFailonerror(boolean z) {
        this.C = z;
    }

    public void setGenericAntfile(java.io.File file) {
        this.y = file;
    }

    public void setInheritall(boolean z) {
        this.A = z;
    }

    public void setInheritrefs(boolean z) {
        this.B = z;
    }

    public void setOutput(java.lang.String str) {
        this.D = str;
    }

    public void setTarget(java.lang.String str) {
        this.w = str;
    }

    public void setVerbose(boolean z) {
        this.z = z;
    }
}
