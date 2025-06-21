package org.apache.tools.ant.taskdefs.optional;

/* loaded from: classes25.dex */
public class Javah extends org.apache.tools.ant.Task {
    public org.apache.tools.ant.types.Path D;
    public org.apache.tools.ant.util.facade.FacadeTaskHelper E;
    public java.lang.String v;
    public java.io.File w;
    public java.util.Vector u = new java.util.Vector(2);
    public org.apache.tools.ant.types.Path x = null;
    public java.io.File y = null;
    public boolean z = false;
    public boolean A = false;
    public boolean B = false;
    public boolean C = false;
    public java.util.Vector F = new java.util.Vector();
    public org.apache.tools.ant.taskdefs.optional.javah.JavahAdapter G = null;

    public class ClassArgument {
        public java.lang.String a;

        public ClassArgument() {
        }

        public java.lang.String getName() {
            return this.a;
        }

        public void setName(java.lang.String str) {
            this.a = str;
        }
    }

    public Javah() {
        this.E = null;
        this.E = new org.apache.tools.ant.util.facade.FacadeTaskHelper(org.apache.tools.ant.taskdefs.optional.javah.JavahAdapterFactory.getDefault());
    }

    public void add(org.apache.tools.ant.taskdefs.optional.javah.JavahAdapter javahAdapter) {
        if (this.G != null) {
            throw new org.apache.tools.ant.BuildException("Can't have more than one javah adapter");
        }
        this.G = javahAdapter;
    }

    public void addFileSet(org.apache.tools.ant.types.FileSet fileSet) {
        this.F.add(fileSet);
    }

    public org.apache.tools.ant.util.facade.ImplementationSpecificArgument createArg() {
        org.apache.tools.ant.util.facade.ImplementationSpecificArgument implementationSpecificArgument = new org.apache.tools.ant.util.facade.ImplementationSpecificArgument();
        this.E.addImplementationArgument(implementationSpecificArgument);
        return implementationSpecificArgument;
    }

    public org.apache.tools.ant.types.Path createBootclasspath() {
        if (this.D == null) {
            this.D = new org.apache.tools.ant.types.Path(getProject());
        }
        return this.D.createPath();
    }

    public org.apache.tools.ant.taskdefs.optional.Javah.ClassArgument createClass() {
        org.apache.tools.ant.taskdefs.optional.Javah.ClassArgument classArgument = new org.apache.tools.ant.taskdefs.optional.Javah.ClassArgument();
        this.u.addElement(classArgument);
        return classArgument;
    }

    public org.apache.tools.ant.types.Path createClasspath() {
        if (this.x == null) {
            this.x = new org.apache.tools.ant.types.Path(getProject());
        }
        return this.x.createPath();
    }

    public org.apache.tools.ant.types.Path createImplementationClasspath() {
        return this.E.getImplementationClasspath(getProject());
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        if (this.v == null && this.u.size() == 0 && this.F.size() == 0) {
            throw new org.apache.tools.ant.BuildException("class attribute must be set!", getLocation());
        }
        if (this.v != null && this.u.size() > 0 && this.F.size() > 0) {
            throw new org.apache.tools.ant.BuildException("set class attribute OR class element OR fileset, not 2 or more of them.", getLocation());
        }
        java.io.File file = this.w;
        if (file != null) {
            if (!file.isDirectory()) {
                throw new org.apache.tools.ant.BuildException("destination directory \"" + this.w + "\" does not exist or is not a directory", getLocation());
            }
            if (this.y != null) {
                throw new org.apache.tools.ant.BuildException("destdir and outputFile are mutually exclusive", getLocation());
            }
        }
        org.apache.tools.ant.types.Path path = this.x;
        if (path == null) {
            this.x = new org.apache.tools.ant.types.Path(getProject()).concatSystemClasspath("last");
        } else {
            this.x = path.concatSystemClasspath(org.apache.tools.ant.taskdefs.Definer.OnError.POLICY_IGNORE);
        }
        org.apache.tools.ant.taskdefs.optional.javah.JavahAdapter javahAdapter = this.G;
        if (javahAdapter == null) {
            javahAdapter = org.apache.tools.ant.taskdefs.optional.javah.JavahAdapterFactory.getAdapter(this.E.getImplementation(), this, createImplementationClasspath());
        }
        if (!javahAdapter.compile(this)) {
            throw new org.apache.tools.ant.BuildException("compilation failed");
        }
    }

    public org.apache.tools.ant.types.Path getBootclasspath() {
        return this.D;
    }

    public java.lang.String[] getClasses() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (this.v != null) {
            java.util.StringTokenizer stringTokenizer = new java.util.StringTokenizer(this.v, ",", false);
            while (stringTokenizer.hasMoreTokens()) {
                arrayList.add(stringTokenizer.nextToken().trim());
            }
        }
        if (this.F.size() > 0) {
            java.util.Enumeration elements = this.F.elements();
            while (elements.hasMoreElements()) {
                java.lang.String[] includedFiles = ((org.apache.tools.ant.types.FileSet) elements.nextElement()).getDirectoryScanner(getProject()).getIncludedFiles();
                for (int i = 0; i < includedFiles.length; i++) {
                    arrayList.add(includedFiles[i].replace('\\', '.').replace('/', '.').substring(0, includedFiles[i].length() - 6));
                }
            }
        }
        java.util.Enumeration elements2 = this.u.elements();
        while (elements2.hasMoreElements()) {
            arrayList.add(((org.apache.tools.ant.taskdefs.optional.Javah.ClassArgument) elements2.nextElement()).getName());
        }
        return (java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]);
    }

    public org.apache.tools.ant.types.Path getClasspath() {
        return this.x;
    }

    public java.lang.String[] getCurrentArgs() {
        return this.E.getArgs();
    }

    public java.io.File getDestdir() {
        return this.w;
    }

    public boolean getForce() {
        return this.A;
    }

    public boolean getOld() {
        return this.B;
    }

    public java.io.File getOutputfile() {
        return this.y;
    }

    public boolean getStubs() {
        return this.C;
    }

    public boolean getVerbose() {
        return this.z;
    }

    public void logAndAddFiles(org.apache.tools.ant.types.Commandline commandline) {
        logAndAddFilesToCompile(commandline);
    }

    public void logAndAddFilesToCompile(org.apache.tools.ant.types.Commandline commandline) {
        log("Compilation " + commandline.describeArguments(), 3);
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        java.lang.String[] classes = getClasses();
        for (int i = 0; i < classes.length; i++) {
            commandline.createArgument().setValue(classes[i]);
            stringBuffer.append("    ");
            stringBuffer.append(classes[i]);
            stringBuffer.append(org.apache.tools.ant.util.StringUtils.LINE_SEP);
        }
        java.lang.StringBuffer stringBuffer2 = new java.lang.StringBuffer("Class");
        if (classes.length > 1) {
            stringBuffer2.append("es");
        }
        stringBuffer2.append(" to be compiled:");
        stringBuffer2.append(org.apache.tools.ant.util.StringUtils.LINE_SEP);
        log(stringBuffer2.toString() + stringBuffer.toString(), 3);
    }

    public void setBootClasspathRef(org.apache.tools.ant.types.Reference reference) {
        createBootclasspath().setRefid(reference);
    }

    public void setBootclasspath(org.apache.tools.ant.types.Path path) {
        org.apache.tools.ant.types.Path path2 = this.D;
        if (path2 == null) {
            this.D = path;
        } else {
            path2.append(path);
        }
    }

    public void setClass(java.lang.String str) {
        this.v = str;
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

    public void setDestdir(java.io.File file) {
        this.w = file;
    }

    public void setForce(boolean z) {
        this.A = z;
    }

    public void setImplementation(java.lang.String str) {
        if ("default".equals(str)) {
            this.E.setImplementation(org.apache.tools.ant.taskdefs.optional.javah.JavahAdapterFactory.getDefault());
        } else {
            this.E.setImplementation(str);
        }
    }

    public void setOld(boolean z) {
        this.B = z;
    }

    public void setOutputFile(java.io.File file) {
        this.y = file;
    }

    public void setStubs(boolean z) {
        this.C = z;
    }

    public void setVerbose(boolean z) {
        this.z = z;
    }
}
