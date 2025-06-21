package org.apache.tools.ant.util.depend;

/* loaded from: classes26.dex */
public abstract class AbstractAnalyzer implements org.apache.tools.ant.util.depend.DependencyAnalyzer {
    public static final int MAX_LOOPS = 1000;
    public java.util.Vector<java.io.File> e;
    public java.util.Vector<java.lang.String> f;
    public org.apache.tools.ant.types.Path a = new org.apache.tools.ant.types.Path(null);
    public org.apache.tools.ant.types.Path b = new org.apache.tools.ant.types.Path(null);
    public final java.util.Vector<java.lang.String> c = new org.apache.tools.ant.util.VectorSet();
    public boolean d = false;
    public boolean g = true;

    public AbstractAnalyzer() {
        reset();
    }

    public final java.io.File a(java.lang.String str, java.lang.String[] strArr) throws java.io.IOException {
        int length = strArr.length;
        int i = 0;
        while (true) {
            java.util.zip.ZipFile zipFile = null;
            if (i >= length) {
                return null;
            }
            java.io.File file = new java.io.File(strArr[i]);
            if (file.exists()) {
                if (file.isDirectory()) {
                    java.io.File file2 = new java.io.File(file, str);
                    if (file2.exists()) {
                        return file2;
                    }
                } else {
                    try {
                        java.util.zip.ZipFile zipFile2 = new java.util.zip.ZipFile(file);
                        try {
                            if (zipFile2.getEntry(str) != null) {
                                zipFile2.close();
                                return file;
                            }
                            zipFile2.close();
                        } catch (java.lang.Throwable th) {
                            th = th;
                            zipFile = zipFile2;
                            if (zipFile != null) {
                                zipFile.close();
                            }
                            throw th;
                        }
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                    }
                }
            }
            i++;
        }
    }

    @Override // org.apache.tools.ant.util.depend.DependencyAnalyzer
    public void addClassPath(org.apache.tools.ant.types.Path path) {
        if (path == null) {
            return;
        }
        this.b.append(path);
        this.b.setProject(path.getProject());
    }

    @Override // org.apache.tools.ant.util.depend.DependencyAnalyzer
    public void addRootClass(java.lang.String str) {
        if (str == null || this.c.contains(str)) {
            return;
        }
        this.c.addElement(str);
    }

    @Override // org.apache.tools.ant.util.depend.DependencyAnalyzer
    public void addSourcePath(org.apache.tools.ant.types.Path path) {
        if (path == null) {
            return;
        }
        this.a.append(path);
        this.a.setProject(path.getProject());
    }

    @Override // org.apache.tools.ant.util.depend.DependencyAnalyzer
    public void config(java.lang.String str, java.lang.Object obj) {
    }

    public abstract void determineDependencies(java.util.Vector<java.io.File> vector, java.util.Vector<java.lang.String> vector2);

    @Override // org.apache.tools.ant.util.depend.DependencyAnalyzer
    public java.io.File getClassContainer(java.lang.String str) throws java.io.IOException {
        return a(str.replace('.', '/') + ".class", this.b.list());
    }

    @Override // org.apache.tools.ant.util.depend.DependencyAnalyzer
    public java.util.Enumeration<java.lang.String> getClassDependencies() {
        if (!this.d) {
            determineDependencies(this.e, this.f);
        }
        return this.f.elements();
    }

    @Override // org.apache.tools.ant.util.depend.DependencyAnalyzer
    public java.util.Enumeration<java.io.File> getFileDependencies() {
        if (!supportsFileDependencies()) {
            throw new org.apache.tools.ant.BuildException("File dependencies are not supported by this analyzer");
        }
        if (!this.d) {
            determineDependencies(this.e, this.f);
        }
        return this.e.elements();
    }

    public java.util.Enumeration<java.lang.String> getRootClasses() {
        return this.c.elements();
    }

    @Override // org.apache.tools.ant.util.depend.DependencyAnalyzer
    public java.io.File getSourceContainer(java.lang.String str) throws java.io.IOException {
        return a(str.replace('.', '/') + ".java", this.a.list());
    }

    public boolean isClosureRequired() {
        return this.g;
    }

    @Override // org.apache.tools.ant.util.depend.DependencyAnalyzer
    public void reset() {
        this.c.removeAllElements();
        this.d = false;
        this.e = new java.util.Vector<>();
        this.f = new java.util.Vector<>();
    }

    @Override // org.apache.tools.ant.util.depend.DependencyAnalyzer
    public void setClosure(boolean z) {
        this.g = z;
    }

    public abstract boolean supportsFileDependencies();
}
