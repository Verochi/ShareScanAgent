package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class ManifestClassPath extends org.apache.tools.ant.Task {
    public java.lang.String u;
    public java.io.File v;
    public int w = 2;
    public org.apache.tools.ant.types.Path x;

    public void addClassPath(org.apache.tools.ant.types.Path path) {
        this.x = path;
    }

    @Override // org.apache.tools.ant.Task
    public void execute() {
        if (this.u == null) {
            throw new org.apache.tools.ant.BuildException("Missing 'property' attribute!");
        }
        if (this.v == null) {
            throw new org.apache.tools.ant.BuildException("Missing 'jarfile' attribute!");
        }
        if (getProject().getProperty(this.u) != null) {
            throw new org.apache.tools.ant.BuildException("Property '" + this.u + "' already set!");
        }
        if (this.x == null) {
            throw new org.apache.tools.ant.BuildException("Missing nested <classpath>!");
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (int i = 0; i < this.w + 1; i++) {
            stringBuffer.append("../");
        }
        java.lang.String stringBuffer2 = stringBuffer.toString();
        org.apache.tools.ant.util.FileUtils fileUtils = org.apache.tools.ant.util.FileUtils.getFileUtils();
        this.v = fileUtils.normalize(this.v.getAbsolutePath());
        java.lang.String[] list = this.x.list();
        java.lang.StringBuffer stringBuffer3 = new java.lang.StringBuffer();
        for (java.lang.String str : list) {
            java.lang.String absolutePath = new java.io.File(str).getAbsolutePath();
            java.io.File normalize = fileUtils.normalize(absolutePath);
            try {
                java.lang.String relativePath = this.v.equals(normalize) ? "." : org.apache.tools.ant.util.FileUtils.getRelativePath(this.v, normalize);
                java.lang.String canonicalPath = normalize.getCanonicalPath();
                char c = java.io.File.separatorChar;
                if (c != '/') {
                    canonicalPath = canonicalPath.replace(c, '/');
                }
                if (relativePath.equals(canonicalPath) || relativePath.startsWith(stringBuffer2)) {
                    throw new org.apache.tools.ant.BuildException("No suitable relative path from " + this.v + " to " + absolutePath);
                }
                if (normalize.isDirectory() && !relativePath.endsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                    relativePath = relativePath + '/';
                }
                try {
                    stringBuffer3.append(org.apache.tools.ant.launch.Locator.encodeURI(relativePath));
                    stringBuffer3.append(' ');
                } catch (java.io.UnsupportedEncodingException e) {
                    throw new org.apache.tools.ant.BuildException(e);
                }
            } catch (java.lang.Exception e2) {
                throw new org.apache.tools.ant.BuildException("error trying to get the relative path from " + this.v + " to " + absolutePath, e2);
            }
        }
        getProject().setNewProperty(this.u, stringBuffer3.toString().trim());
    }

    public void setJarFile(java.io.File file) {
        java.io.File parentFile = file.getParentFile();
        if (parentFile.isDirectory()) {
            this.v = parentFile;
            return;
        }
        throw new org.apache.tools.ant.BuildException("Jar's directory not found: " + parentFile);
    }

    public void setMaxParentLevels(int i) {
        if (i < 0) {
            throw new org.apache.tools.ant.BuildException("maxParentLevels must not be a negative number");
        }
        this.w = i;
    }

    public void setProperty(java.lang.String str) {
        this.u = str;
    }
}
