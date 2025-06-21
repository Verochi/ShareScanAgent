package org.apache.tools.ant.taskdefs.optional.unix;

/* loaded from: classes25.dex */
public class Symlink extends org.apache.tools.ant.dispatch.DispatchTask {
    public static final org.apache.tools.ant.util.FileUtils C = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public static final org.apache.tools.ant.util.SymbolicLinkUtils D = org.apache.tools.ant.util.SymbolicLinkUtils.getSymbolicLinkUtils();
    public boolean A;
    public java.lang.String v;
    public java.lang.String w;
    public java.lang.String y;
    public boolean z;
    public java.util.Vector x = new java.util.Vector();
    public boolean B = false;

    @java.lang.Deprecated
    public static void deleteSymlink(java.io.File file) throws java.io.IOException {
        D.deleteSymbolicLink(file, null);
    }

    @java.lang.Deprecated
    public static void deleteSymlink(java.lang.String str) throws java.io.IOException {
        D.deleteSymbolicLink(new java.io.File(str), null);
    }

    public void addFileset(org.apache.tools.ant.types.FileSet fileSet) {
        this.x.addElement(fileSet);
    }

    public final void c(java.lang.String str, java.lang.String str2) throws org.apache.tools.ant.BuildException {
        java.io.File file = new java.io.File(str2);
        java.lang.String str3 = "-s";
        if (this.z) {
            str3 = "-sf";
            if (file.exists()) {
                try {
                    D.deleteSymbolicLink(file, this);
                } catch (java.io.FileNotFoundException unused) {
                    log("Symlink disappeared before it was deleted: " + str2);
                } catch (java.io.IOException e) {
                    log("Unable to overwrite preexisting link or file: " + str2, e, 2);
                }
            }
        }
        try {
            org.apache.tools.ant.taskdefs.Execute.runCommand(this, new java.lang.String[]{"ln", str3, str, str2});
        } catch (org.apache.tools.ant.BuildException e2) {
            if (this.A) {
                throw e2;
            }
            log(e2.getMessage(), e2, 2);
        }
    }

    public final java.util.HashSet d(java.util.Vector vector) {
        java.util.HashSet hashSet = new java.util.HashSet();
        int size = vector.size();
        for (int i = 0; i < size; i++) {
            org.apache.tools.ant.types.FileSet fileSet = (org.apache.tools.ant.types.FileSet) vector.get(i);
            org.apache.tools.ant.DirectoryScanner directoryScanner = fileSet.getDirectoryScanner(getProject());
            java.lang.String[][] strArr = {directoryScanner.getIncludedFiles(), directoryScanner.getIncludedDirectories()};
            java.io.File dir = fileSet.getDir(getProject());
            for (int i2 = 0; i2 < 2; i2++) {
                for (int i3 = 0; i3 < strArr[i2].length; i3++) {
                    try {
                        java.io.File file = new java.io.File(dir, strArr[i2][i3]);
                        java.io.File parentFile = file.getParentFile();
                        java.lang.String name = file.getName();
                        if (D.isSymbolicLink(parentFile, name)) {
                            hashSet.add(new java.io.File(parentFile.getCanonicalFile(), name));
                        }
                    } catch (java.io.IOException unused) {
                        handleError("IOException: " + strArr[i2][i3] + " omitted");
                    }
                }
            }
        }
        return hashSet;
    }

    public void delete() throws org.apache.tools.ant.BuildException {
        try {
            try {
            } catch (java.io.FileNotFoundException e) {
                handleError(e.toString());
            } catch (java.io.IOException e2) {
                handleError(e2.toString());
            }
            if (this.w == null) {
                handleError("Must define the link name for symlink!");
                return;
            }
            log("Removing symlink: " + this.w);
            D.deleteSymbolicLink(C.resolveFile(new java.io.File("."), this.w), this);
        } finally {
            f();
        }
    }

    public final java.util.Properties e(java.util.Vector vector) {
        java.io.BufferedInputStream bufferedInputStream;
        java.util.Properties properties = new java.util.Properties();
        int size = vector.size();
        for (int i = 0; i < size; i++) {
            org.apache.tools.ant.types.FileSet fileSet = (org.apache.tools.ant.types.FileSet) vector.elementAt(i);
            org.apache.tools.ant.DirectoryScanner directoryScanner = new org.apache.tools.ant.DirectoryScanner();
            fileSet.setupDirectoryScanner(directoryScanner, getProject());
            directoryScanner.setFollowSymlinks(false);
            directoryScanner.scan();
            java.lang.String[] includedFiles = directoryScanner.getIncludedFiles();
            java.io.File dir = fileSet.getDir(getProject());
            for (int i2 = 0; i2 < includedFiles.length; i2++) {
                java.io.File file = new java.io.File(dir, includedFiles[i2]);
                java.io.File parentFile = file.getParentFile();
                java.util.Properties properties2 = new java.util.Properties();
                java.io.BufferedInputStream bufferedInputStream2 = null;
                try {
                    try {
                        bufferedInputStream = new java.io.BufferedInputStream(new java.io.FileInputStream(file));
                    } catch (java.lang.Throwable th) {
                        th = th;
                    }
                } catch (java.io.FileNotFoundException unused) {
                } catch (java.io.IOException unused2) {
                }
                try {
                    properties2.load(bufferedInputStream);
                    java.io.File canonicalFile = parentFile.getCanonicalFile();
                    org.apache.tools.ant.util.FileUtils.close(bufferedInputStream);
                    properties2.list(new java.io.PrintStream(new org.apache.tools.ant.taskdefs.LogOutputStream((org.apache.tools.ant.Task) this, 2)));
                    for (java.lang.String str : properties2.keySet()) {
                        properties.put(new java.io.File(canonicalFile, str).getAbsolutePath(), properties2.getProperty(str));
                    }
                } catch (java.io.FileNotFoundException unused3) {
                    bufferedInputStream2 = bufferedInputStream;
                    handleError("Unable to find " + includedFiles[i2] + "; skipping it.");
                    org.apache.tools.ant.util.FileUtils.close(bufferedInputStream2);
                } catch (java.io.IOException unused4) {
                    bufferedInputStream2 = bufferedInputStream;
                    handleError("Unable to open " + includedFiles[i2] + " or its parent dir; skipping it.");
                    org.apache.tools.ant.util.FileUtils.close(bufferedInputStream2);
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    bufferedInputStream2 = bufferedInputStream;
                    org.apache.tools.ant.util.FileUtils.close(bufferedInputStream2);
                    throw th;
                }
            }
        }
        return properties;
    }

    @Override // org.apache.tools.ant.Task
    public synchronized void execute() throws org.apache.tools.ant.BuildException {
        if (this.B) {
            throw new org.apache.tools.ant.BuildException("Infinite recursion detected in Symlink.execute()");
        }
        try {
            this.B = true;
            org.apache.tools.ant.dispatch.DispatchUtils.execute(this);
        } finally {
            this.B = false;
        }
    }

    public final void f() {
        this.v = null;
        this.w = null;
        this.y = null;
        this.A = true;
        this.z = false;
        setAction("single");
        this.x.clear();
    }

    public final void g(java.util.Properties properties, java.io.File file) throws org.apache.tools.ant.BuildException {
        java.io.BufferedOutputStream bufferedOutputStream;
        java.io.BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                bufferedOutputStream = new java.io.BufferedOutputStream(new java.io.FileOutputStream(new java.io.File(file, this.y)));
            } catch (java.lang.Throwable th) {
                th = th;
            }
        } catch (java.io.IOException e) {
            e = e;
        }
        try {
            properties.store(bufferedOutputStream, "Symlinks from " + file);
            org.apache.tools.ant.util.FileUtils.close(bufferedOutputStream);
        } catch (java.io.IOException e2) {
            e = e2;
            throw new org.apache.tools.ant.BuildException(e, getLocation());
        } catch (java.lang.Throwable th2) {
            th = th2;
            bufferedOutputStream2 = bufferedOutputStream;
            org.apache.tools.ant.util.FileUtils.close(bufferedOutputStream2);
            throw th;
        }
    }

    public final void handleError(java.lang.String str) {
        if (this.A) {
            throw new org.apache.tools.ant.BuildException(str);
        }
        log(str);
    }

    @Override // org.apache.tools.ant.Task
    public void init() throws org.apache.tools.ant.BuildException {
        super.init();
        f();
    }

    public void record() throws org.apache.tools.ant.BuildException {
        try {
            if (this.x.isEmpty()) {
                handleError("Fileset identifying links to record required");
                return;
            }
            if (this.y == null) {
                handleError("Name of file to record links in required");
                return;
            }
            java.util.Hashtable hashtable = new java.util.Hashtable();
            java.util.Iterator it = d(this.x).iterator();
            while (it.hasNext()) {
                java.io.File file = (java.io.File) it.next();
                java.io.File parentFile = file.getParentFile();
                java.util.Vector vector = (java.util.Vector) hashtable.get(parentFile);
                if (vector == null) {
                    vector = new java.util.Vector();
                    hashtable.put(parentFile, vector);
                }
                vector.addElement(file);
            }
            for (java.io.File file2 : hashtable.keySet()) {
                java.util.Vector vector2 = (java.util.Vector) hashtable.get(file2);
                java.util.Properties properties = new java.util.Properties();
                java.util.Iterator it2 = vector2.iterator();
                while (it2.hasNext()) {
                    java.io.File file3 = (java.io.File) it2.next();
                    try {
                        properties.put(file3.getName(), file3.getCanonicalPath());
                    } catch (java.io.IOException unused) {
                        handleError("Couldn't get canonical name of parent link");
                    }
                }
                g(properties, file2);
            }
        } finally {
            f();
        }
    }

    public void recreate() throws org.apache.tools.ant.BuildException {
        try {
            if (this.x.isEmpty()) {
                handleError("File set identifying link file(s) required for action recreate");
                return;
            }
            java.util.Properties e = e(this.x);
            for (java.lang.String str : e.keySet()) {
                java.lang.String property = e.getProperty(str);
                try {
                    java.io.File file = new java.io.File(str);
                    org.apache.tools.ant.util.SymbolicLinkUtils symbolicLinkUtils = D;
                    if (!symbolicLinkUtils.isSymbolicLink(str)) {
                        c(property, str);
                    } else if (!file.getCanonicalPath().equals(new java.io.File(property).getCanonicalPath())) {
                        symbolicLinkUtils.deleteSymbolicLink(file, this);
                        c(property, str);
                    }
                } catch (java.io.IOException unused) {
                    handleError("IO exception while creating link");
                }
            }
        } finally {
            f();
        }
    }

    @Override // org.apache.tools.ant.dispatch.DispatchTask
    public void setAction(java.lang.String str) {
        super.setAction(str);
    }

    public void setFailOnError(boolean z) {
        this.A = z;
    }

    public void setLink(java.lang.String str) {
        this.w = str;
    }

    public void setLinkfilename(java.lang.String str) {
        this.y = str;
    }

    public void setOverwrite(boolean z) {
        this.z = z;
    }

    public void setResource(java.lang.String str) {
        this.v = str;
    }

    public void single() throws org.apache.tools.ant.BuildException {
        try {
            java.lang.String str = this.v;
            if (str == null) {
                handleError("Must define the resource to symlink to!");
                return;
            }
            java.lang.String str2 = this.w;
            if (str2 == null) {
                handleError("Must define the link name for symlink!");
            } else {
                c(str, str2);
            }
        } finally {
            f();
        }
    }
}
