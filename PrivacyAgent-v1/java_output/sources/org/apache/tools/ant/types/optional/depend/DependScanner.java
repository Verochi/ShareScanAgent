package org.apache.tools.ant.types.optional.depend;

/* loaded from: classes26.dex */
public class DependScanner extends org.apache.tools.ant.DirectoryScanner {
    public static final java.lang.String DEFAULT_ANALYZER_CLASS = "org.apache.tools.ant.util.depend.bcel.FullAnalyzer";
    public java.util.Vector<java.lang.String> K;
    public java.util.Vector<java.lang.String> L;
    public java.util.Vector<java.io.File> M = new java.util.Vector<>();
    public org.apache.tools.ant.DirectoryScanner N;

    public DependScanner(org.apache.tools.ant.DirectoryScanner directoryScanner) {
        this.N = directoryScanner;
    }

    public void addBasedir(java.io.File file) {
        this.M.addElement(file);
    }

    @Override // org.apache.tools.ant.DirectoryScanner, org.apache.tools.ant.FileScanner
    public void addDefaultExcludes() {
    }

    @Override // org.apache.tools.ant.DirectoryScanner, org.apache.tools.ant.FileScanner
    public java.lang.String[] getExcludedDirectories() {
        return null;
    }

    @Override // org.apache.tools.ant.DirectoryScanner, org.apache.tools.ant.FileScanner
    public java.lang.String[] getExcludedFiles() {
        return null;
    }

    @Override // org.apache.tools.ant.DirectoryScanner, org.apache.tools.ant.FileScanner
    public java.lang.String[] getIncludedDirectories() {
        return new java.lang.String[0];
    }

    @Override // org.apache.tools.ant.DirectoryScanner
    public int getIncludedDirsCount() {
        return 0;
    }

    @Override // org.apache.tools.ant.DirectoryScanner, org.apache.tools.ant.FileScanner
    public java.lang.String[] getIncludedFiles() {
        int includedFilesCount = getIncludedFilesCount();
        java.lang.String[] strArr = new java.lang.String[includedFilesCount];
        for (int i = 0; i < includedFilesCount; i++) {
            strArr[i] = this.L.elementAt(i);
        }
        return strArr;
    }

    @Override // org.apache.tools.ant.DirectoryScanner
    public synchronized int getIncludedFilesCount() {
        java.util.Vector<java.lang.String> vector;
        vector = this.L;
        if (vector == null) {
            throw new java.lang.IllegalStateException();
        }
        return vector.size();
    }

    @Override // org.apache.tools.ant.DirectoryScanner, org.apache.tools.ant.FileScanner
    public java.lang.String[] getNotIncludedDirectories() {
        return null;
    }

    @Override // org.apache.tools.ant.DirectoryScanner, org.apache.tools.ant.FileScanner
    public java.lang.String[] getNotIncludedFiles() {
        return null;
    }

    @Override // org.apache.tools.ant.DirectoryScanner, org.apache.tools.ant.FileScanner
    public synchronized void scan() throws java.lang.IllegalStateException {
        this.L = new java.util.Vector<>();
        try {
            org.apache.tools.ant.util.depend.DependencyAnalyzer dependencyAnalyzer = (org.apache.tools.ant.util.depend.DependencyAnalyzer) java.lang.Class.forName("org.apache.tools.ant.util.depend.bcel.FullAnalyzer").asSubclass(org.apache.tools.ant.util.depend.DependencyAnalyzer.class).newInstance();
            dependencyAnalyzer.addClassPath(new org.apache.tools.ant.types.Path(null, this.basedir.getPath()));
            java.util.Enumeration<java.io.File> elements = this.M.elements();
            while (elements.hasMoreElements()) {
                dependencyAnalyzer.addClassPath(new org.apache.tools.ant.types.Path(null, elements.nextElement().getPath()));
            }
            java.util.Enumeration<java.lang.String> elements2 = this.K.elements();
            while (elements2.hasMoreElements()) {
                dependencyAnalyzer.addRootClass(elements2.nextElement());
            }
            java.util.Enumeration<java.lang.String> classDependencies = dependencyAnalyzer.getClassDependencies();
            java.lang.String[] includedFiles = this.N.getIncludedFiles();
            java.util.Hashtable hashtable = new java.util.Hashtable();
            for (java.lang.String str : includedFiles) {
                hashtable.put(str, str);
            }
            while (classDependencies.hasMoreElements()) {
                java.lang.String str2 = classDependencies.nextElement().replace('.', java.io.File.separatorChar) + ".class";
                if (new java.io.File(this.basedir, str2).exists() && hashtable.containsKey(str2)) {
                    this.L.addElement(str2);
                }
            }
        } catch (java.lang.Exception e) {
            throw new org.apache.tools.ant.BuildException("Unable to load dependency analyzer: org.apache.tools.ant.util.depend.bcel.FullAnalyzer", e);
        }
    }

    @Override // org.apache.tools.ant.DirectoryScanner, org.apache.tools.ant.FileScanner
    public void setCaseSensitive(boolean z) {
    }

    @Override // org.apache.tools.ant.DirectoryScanner, org.apache.tools.ant.FileScanner
    public void setExcludes(java.lang.String[] strArr) {
    }

    @Override // org.apache.tools.ant.DirectoryScanner, org.apache.tools.ant.FileScanner
    public void setIncludes(java.lang.String[] strArr) {
    }

    public synchronized void setRootClasses(java.util.Vector<java.lang.String> vector) {
        this.K = vector;
    }
}
