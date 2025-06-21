package org.apache.tools.ant.types;

/* loaded from: classes26.dex */
public abstract class ArchiveScanner extends org.apache.tools.ant.DirectoryScanner {
    public org.apache.tools.ant.types.Resource K;
    public org.apache.tools.ant.types.Resource L;
    public java.lang.String Q;
    protected java.io.File srcFile;
    public java.util.Map<java.lang.String, org.apache.tools.ant.types.Resource> M = new java.util.TreeMap();
    public java.util.Map<java.lang.String, org.apache.tools.ant.types.Resource> N = new java.util.TreeMap();
    public java.util.Map<java.lang.String, org.apache.tools.ant.types.Resource> O = new java.util.TreeMap();
    public java.util.Map<java.lang.String, org.apache.tools.ant.types.Resource> P = new java.util.TreeMap();
    public boolean R = true;

    public static final java.lang.String trimSeparator(java.lang.String str) {
        return str.endsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR) ? str.substring(0, str.length() - 1) : str;
    }

    public abstract void fillMapsFromArchive(org.apache.tools.ant.types.Resource resource, java.lang.String str, java.util.Map<java.lang.String, org.apache.tools.ant.types.Resource> map, java.util.Map<java.lang.String, org.apache.tools.ant.types.Resource> map2, java.util.Map<java.lang.String, org.apache.tools.ant.types.Resource> map3, java.util.Map<java.lang.String, org.apache.tools.ant.types.Resource> map4);

    @Override // org.apache.tools.ant.DirectoryScanner, org.apache.tools.ant.FileScanner
    public java.lang.String[] getIncludedDirectories() {
        if (this.K == null) {
            return super.getIncludedDirectories();
        }
        z();
        return (java.lang.String[]) this.P.keySet().toArray(new java.lang.String[this.P.size()]);
    }

    @Override // org.apache.tools.ant.DirectoryScanner
    public int getIncludedDirsCount() {
        if (this.K == null) {
            return super.getIncludedDirsCount();
        }
        z();
        return this.P.size();
    }

    @Override // org.apache.tools.ant.DirectoryScanner, org.apache.tools.ant.FileScanner
    public java.lang.String[] getIncludedFiles() {
        if (this.K == null) {
            return super.getIncludedFiles();
        }
        z();
        return (java.lang.String[]) this.O.keySet().toArray(new java.lang.String[this.O.size()]);
    }

    @Override // org.apache.tools.ant.DirectoryScanner
    public int getIncludedFilesCount() {
        if (this.K == null) {
            return super.getIncludedFilesCount();
        }
        z();
        return this.O.size();
    }

    @Override // org.apache.tools.ant.DirectoryScanner, org.apache.tools.ant.types.ResourceFactory
    public org.apache.tools.ant.types.Resource getResource(java.lang.String str) {
        if (this.K == null) {
            return super.getResource(str);
        }
        if (str.equals("")) {
            return new org.apache.tools.ant.types.Resource("", true, Long.MAX_VALUE, true);
        }
        z();
        if (this.M.containsKey(str)) {
            return this.M.get(str);
        }
        java.lang.String trimSeparator = trimSeparator(str);
        return this.N.containsKey(trimSeparator) ? this.N.get(trimSeparator) : new org.apache.tools.ant.types.Resource(trimSeparator);
    }

    public void init() {
        if (this.includes == null) {
            this.includes = new java.lang.String[]{org.apache.tools.ant.types.selectors.SelectorUtils.DEEP_TREE_MATCH};
        }
        if (this.excludes == null) {
            this.excludes = new java.lang.String[0];
        }
    }

    public boolean match(java.lang.String str) {
        if (str.length() > 0) {
            str = str.replace('/', java.io.File.separatorChar).replace('\\', java.io.File.separatorChar);
            if (str.charAt(0) == java.io.File.separatorChar) {
                str = str.substring(1);
            }
        }
        return isIncluded(str) && !isExcluded(str);
    }

    @Override // org.apache.tools.ant.DirectoryScanner, org.apache.tools.ant.FileScanner
    public void scan() {
        org.apache.tools.ant.types.Resource resource = this.K;
        if (resource != null) {
            if (resource.isExists() || this.R) {
                super.scan();
            }
        }
    }

    public void setEncoding(java.lang.String str) {
        this.Q = str;
    }

    public void setErrorOnMissingArchive(boolean z) {
        this.R = z;
    }

    public void setSrc(java.io.File file) {
        setSrc(new org.apache.tools.ant.types.resources.FileResource(file));
    }

    public void setSrc(org.apache.tools.ant.types.Resource resource) {
        this.K = resource;
        org.apache.tools.ant.types.resources.FileProvider fileProvider = (org.apache.tools.ant.types.resources.FileProvider) resource.as(org.apache.tools.ant.types.resources.FileProvider.class);
        if (fileProvider != null) {
            this.srcFile = fileProvider.getFile();
        }
    }

    public java.util.Iterator<org.apache.tools.ant.types.Resource> y(org.apache.tools.ant.Project project) {
        if (this.K == null) {
            return new org.apache.tools.ant.types.resources.FileResourceIterator(project, getBasedir(), getIncludedFiles());
        }
        z();
        return this.O.values().iterator();
    }

    public final void z() {
        if (this.K.isExists() || this.R) {
            org.apache.tools.ant.types.Resource resource = new org.apache.tools.ant.types.Resource(this.K.getName(), this.K.isExists(), this.K.getLastModified());
            org.apache.tools.ant.types.Resource resource2 = this.L;
            if (resource2 != null && resource2.getName().equals(resource.getName()) && this.L.getLastModified() == resource.getLastModified()) {
                return;
            }
            init();
            this.M.clear();
            this.N.clear();
            this.O.clear();
            this.P.clear();
            fillMapsFromArchive(this.K, this.Q, this.M, this.O, this.N, this.P);
            this.L = resource;
        }
    }
}
