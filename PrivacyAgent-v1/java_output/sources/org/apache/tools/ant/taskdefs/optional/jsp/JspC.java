package org.apache.tools.ant.taskdefs.optional.jsp;

/* loaded from: classes25.dex */
public class JspC extends org.apache.tools.ant.taskdefs.MatchingTask {
    public java.lang.String A;
    public boolean B;
    public java.io.File E;
    public java.io.File F;
    public java.io.File G;
    public org.apache.tools.ant.types.Path u;
    public org.apache.tools.ant.types.Path v;
    public org.apache.tools.ant.types.Path w;
    protected org.apache.tools.ant.taskdefs.optional.jsp.JspC.WebAppParameter webApp;
    public java.io.File x;
    public java.lang.String y;
    public java.lang.String z = "jasper";
    public int C = 0;
    protected java.util.Vector compileList = new java.util.Vector();
    public java.util.Vector D = new java.util.Vector();
    protected boolean failOnError = true;

    public static class WebAppParameter {
        public java.io.File a;

        public java.io.File getDirectory() {
            return this.a;
        }

        public void setBaseDir(java.io.File file) {
            this.a = file;
        }
    }

    public void addWebApp(org.apache.tools.ant.taskdefs.optional.jsp.JspC.WebAppParameter webAppParameter) throws org.apache.tools.ant.BuildException {
        if (this.webApp != null) {
            throw new org.apache.tools.ant.BuildException("Only one webapp can be specified");
        }
        this.webApp = webAppParameter;
    }

    public final void c(org.apache.tools.ant.taskdefs.optional.jsp.compilers.JspCompilerAdapter jspCompilerAdapter) throws org.apache.tools.ant.BuildException {
        jspCompilerAdapter.setJspc(this);
        if (jspCompilerAdapter.execute()) {
            return;
        }
        if (this.failOnError) {
            throw new org.apache.tools.ant.BuildException("Compile failed, messages should have been provided.", getLocation());
        }
        log("Compile failed, messages should have been provided.", 0);
    }

    public org.apache.tools.ant.types.Path createClasspath() {
        if (this.u == null) {
            this.u = new org.apache.tools.ant.types.Path(getProject());
        }
        return this.u.createPath();
    }

    public org.apache.tools.ant.types.Path createCompilerclasspath() {
        if (this.v == null) {
            this.v = new org.apache.tools.ant.types.Path(getProject());
        }
        return this.v.createPath();
    }

    public final java.io.File d() {
        if (this.y == null) {
            return this.x;
        }
        return new java.io.File(this.x.getPath() + java.io.File.separatorChar + this.y.replace('.', java.io.File.separatorChar));
    }

    public void deleteEmptyJavaFiles() {
        java.util.Vector vector = this.D;
        if (vector != null) {
            java.util.Enumeration elements = vector.elements();
            while (elements.hasMoreElements()) {
                java.io.File file = (java.io.File) elements.nextElement();
                if (file.exists() && file.length() == 0) {
                    log("deleting empty output file " + file);
                    file.delete();
                }
            }
        }
    }

    public final boolean e(java.io.File file, java.io.File file2) {
        if (!file2.exists()) {
            log("Compiling " + file.getPath() + " because java file " + file2.getPath() + " does not exist", 3);
            return true;
        }
        if (file.lastModified() > file2.lastModified()) {
            log("Compiling " + file.getPath() + " because it is out of date with respect to " + file2.getPath(), 3);
            return true;
        }
        if (file2.length() != 0) {
            return false;
        }
        log("Compiling " + file.getPath() + " because java file " + file2.getPath() + " is empty", 3);
        return true;
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        java.io.File file = this.x;
        if (file == null) {
            throw new org.apache.tools.ant.BuildException("destdir attribute must be set!", getLocation());
        }
        if (!file.isDirectory()) {
            throw new org.apache.tools.ant.BuildException("destination directory \"" + this.x + "\" does not exist or is not a directory", getLocation());
        }
        java.io.File d = d();
        org.apache.tools.ant.AntClassLoader antClassLoader = null;
        try {
            java.lang.String str = this.z;
            org.apache.tools.ant.AntClassLoader createClassLoader = getProject().createClassLoader(this.v);
            org.apache.tools.ant.taskdefs.optional.jsp.compilers.JspCompilerAdapter compiler = org.apache.tools.ant.taskdefs.optional.jsp.compilers.JspCompilerAdapterFactory.getCompiler(str, this, createClassLoader);
            if (this.webApp != null) {
                c(compiler);
                if (createClassLoader != null) {
                    createClassLoader.cleanup();
                    return;
                }
                return;
            }
            org.apache.tools.ant.types.Path path = this.w;
            if (path == null) {
                throw new org.apache.tools.ant.BuildException("srcdir attribute must be set!", getLocation());
            }
            java.lang.String[] list = path.list();
            if (list.length == 0) {
                throw new org.apache.tools.ant.BuildException("srcdir attribute must be set!", getLocation());
            }
            if (compiler.implementsOwnDependencyChecking()) {
                c(compiler);
                if (createClassLoader != null) {
                    createClassLoader.cleanup();
                    return;
                }
                return;
            }
            org.apache.tools.ant.taskdefs.optional.jsp.JspMangler createMangler = compiler.createMangler();
            resetFileLists();
            int length = list.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                java.io.File resolveFile = getProject().resolveFile(list[i]);
                if (!resolveFile.exists()) {
                    throw new org.apache.tools.ant.BuildException("srcdir \"" + resolveFile.getPath() + "\" does not exist!", getLocation());
                }
                java.lang.String[] includedFiles = getDirectoryScanner(resolveFile).getIncludedFiles();
                int length2 = includedFiles.length;
                scanDir(resolveFile, d, createMangler, includedFiles);
                i++;
                i2 = length2;
            }
            log("compiling " + this.compileList.size() + " files", 3);
            if (this.compileList.size() > 0) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Compiling ");
                sb.append(this.compileList.size());
                sb.append(" source file");
                sb.append(this.compileList.size() == 1 ? "" : "s");
                sb.append(" to ");
                sb.append(d);
                log(sb.toString());
                c(compiler);
            } else if (i2 == 0) {
                log("there were no files to compile", 2);
            } else {
                log("all files are up to date", 3);
            }
            if (createClassLoader != null) {
                createClassLoader.cleanup();
            }
        } catch (java.lang.Throwable th) {
            if (0 != 0) {
                antClassLoader.cleanup();
            }
            throw th;
        }
    }

    public org.apache.tools.ant.types.Path getClasspath() {
        return this.u;
    }

    public java.util.Vector getCompileList() {
        return this.compileList;
    }

    public org.apache.tools.ant.types.Path getCompilerclasspath() {
        return this.v;
    }

    public java.io.File getDestdir() {
        return this.x;
    }

    public boolean getFailonerror() {
        return this.failOnError;
    }

    public java.lang.String getIeplugin() {
        return this.A;
    }

    public java.lang.String getPackage() {
        return this.y;
    }

    public org.apache.tools.ant.types.Path getSrcDir() {
        return this.w;
    }

    public java.io.File getUribase() {
        return this.E;
    }

    public java.io.File getUriroot() {
        return this.E;
    }

    public int getVerbose() {
        return this.C;
    }

    public org.apache.tools.ant.taskdefs.optional.jsp.JspC.WebAppParameter getWebApp() {
        return this.webApp;
    }

    public java.io.File getWebinc() {
        return this.F;
    }

    public java.io.File getWebxml() {
        return this.G;
    }

    public boolean isMapped() {
        return this.B;
    }

    public java.io.File mapToJavaFile(org.apache.tools.ant.taskdefs.optional.jsp.JspMangler jspMangler, java.io.File file, java.io.File file2, java.io.File file3) {
        if (file.getName().endsWith(".jsp")) {
            return new java.io.File(file3, jspMangler.mapJspToJavaName(file));
        }
        return null;
    }

    public void resetFileLists() {
        this.compileList.removeAllElements();
    }

    public void scanDir(java.io.File file, java.io.File file2, org.apache.tools.ant.taskdefs.optional.jsp.JspMangler jspMangler, java.lang.String[] strArr) {
        long time = new java.util.Date().getTime();
        for (java.lang.String str : strArr) {
            java.io.File file3 = new java.io.File(file, str);
            java.io.File mapToJavaFile = mapToJavaFile(jspMangler, file3, file, file2);
            if (mapToJavaFile != null) {
                if (file3.lastModified() > time) {
                    log("Warning: file modified in the future: " + str, 1);
                }
                if (e(file3, mapToJavaFile)) {
                    this.compileList.addElement(file3.getAbsolutePath());
                    this.D.addElement(mapToJavaFile);
                }
            }
        }
    }

    public void setClasspath(org.apache.tools.ant.types.Path path) {
        org.apache.tools.ant.types.Path path2 = this.u;
        if (path2 == null) {
            this.u = path;
        } else {
            path2.append(path);
        }
    }

    public void setClasspathRef(org.apache.tools.ant.types.Reference reference) {
        createClasspath().setRefid(reference);
    }

    public void setCompiler(java.lang.String str) {
        this.z = str;
    }

    public void setCompilerclasspath(org.apache.tools.ant.types.Path path) {
        org.apache.tools.ant.types.Path path2 = this.v;
        if (path2 == null) {
            this.v = path;
        } else {
            path2.append(path);
        }
    }

    public void setDestdir(java.io.File file) {
        this.x = file;
    }

    public void setFailonerror(boolean z) {
        this.failOnError = z;
    }

    public void setIeplugin(java.lang.String str) {
        this.A = str;
    }

    public void setMapped(boolean z) {
        this.B = z;
    }

    public void setPackage(java.lang.String str) {
        this.y = str;
    }

    public void setSrcDir(org.apache.tools.ant.types.Path path) {
        org.apache.tools.ant.types.Path path2 = this.w;
        if (path2 == null) {
            this.w = path;
        } else {
            path2.append(path);
        }
    }

    public void setUribase(java.io.File file) {
        log("Uribase is currently an unused parameter", 1);
    }

    public void setUriroot(java.io.File file) {
        this.E = file;
    }

    public void setVerbose(int i) {
        this.C = i;
    }

    public void setWebinc(java.io.File file) {
        this.F = file;
    }

    public void setWebxml(java.io.File file) {
        this.G = file;
    }
}
