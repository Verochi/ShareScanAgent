package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class SignJar extends org.apache.tools.ant.taskdefs.AbstractJarSignerTask {
    public static final java.lang.String ERROR_BAD_MAP = "Cannot map source file to anything sensible: ";
    public static final java.lang.String ERROR_MAPPER_WITHOUT_DEST = "The destDir attribute is required if a mapper is set";
    public static final java.lang.String ERROR_NO_ALIAS = "alias attribute must be set";
    public static final java.lang.String ERROR_NO_STOREPASS = "storepass attribute must be set";
    public static final java.lang.String ERROR_SIGNEDJAR_AND_PATHS = "You cannot specify the signed JAR when using paths or filesets";
    public static final java.lang.String ERROR_TODIR_AND_SIGNEDJAR = "'destdir' and 'signedjar' cannot both be set";
    public static final java.lang.String ERROR_TOO_MANY_MAPPERS = "Too many mappers";
    public static final org.apache.tools.ant.util.FileUtils H = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public boolean C;
    public org.apache.tools.ant.util.FileNameMapper D;
    public boolean E = false;
    public java.lang.String F;
    public java.lang.String G;
    protected java.io.File destDir;
    protected boolean internalsf;
    protected boolean lazy;
    protected boolean sectionsonly;
    protected java.lang.String sigfile;
    protected java.io.File signedjar;
    protected java.lang.String tsacert;
    protected java.lang.String tsaproxyhost;
    protected java.lang.String tsaproxyport;
    protected java.lang.String tsaurl;

    public void add(org.apache.tools.ant.util.FileNameMapper fileNameMapper) {
        if (this.D != null) {
            throw new org.apache.tools.ant.BuildException(ERROR_TOO_MANY_MAPPERS);
        }
        this.D = fileNameMapper;
    }

    public final void d(org.apache.tools.ant.taskdefs.ExecTask execTask, java.lang.String str) {
        addValue(execTask, "-J-D" + str + ".proxyHost=" + this.tsaproxyhost);
        if (this.tsaproxyport != null) {
            addValue(execTask, "-J-D" + str + ".proxyPort=" + this.tsaproxyport);
        }
    }

    public final void e(org.apache.tools.ant.taskdefs.ExecTask execTask) {
        if (this.tsaurl != null) {
            addValue(execTask, "-tsa");
            addValue(execTask, this.tsaurl);
        }
        if (this.tsacert != null) {
            addValue(execTask, "-tsacert");
            addValue(execTask, this.tsacert);
        }
        if (this.tsaproxyhost != null) {
            java.lang.String str = this.tsaurl;
            if (str == null || str.startsWith("https")) {
                d(execTask, "https");
            }
            java.lang.String str2 = this.tsaurl;
            if (str2 == null || !str2.startsWith("https")) {
                d(execTask, com.alipay.sdk.m.l.a.q);
            }
        }
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        boolean z = this.jar != null;
        boolean z2 = this.signedjar != null;
        boolean z3 = this.destDir != null;
        boolean z4 = this.D != null;
        if (!z && !hasResources()) {
            throw new org.apache.tools.ant.BuildException(org.apache.tools.ant.taskdefs.AbstractJarSignerTask.ERROR_NO_SOURCE);
        }
        if (this.alias == null) {
            throw new org.apache.tools.ant.BuildException(ERROR_NO_ALIAS);
        }
        if (this.storepass == null) {
            throw new org.apache.tools.ant.BuildException(ERROR_NO_STOREPASS);
        }
        if (z3 && z2) {
            throw new org.apache.tools.ant.BuildException(ERROR_TODIR_AND_SIGNEDJAR);
        }
        if (hasResources() && z2) {
            throw new org.apache.tools.ant.BuildException(ERROR_SIGNEDJAR_AND_PATHS);
        }
        if (!z3 && z4) {
            throw new org.apache.tools.ant.BuildException(ERROR_MAPPER_WITHOUT_DEST);
        }
        beginExecution();
        try {
            if (z && z2) {
                f(this.jar, this.signedjar);
                return;
            }
            org.apache.tools.ant.types.Path createUnifiedSourcePath = createUnifiedSourcePath();
            org.apache.tools.ant.util.FileNameMapper identityMapper = z4 ? this.D : new org.apache.tools.ant.util.IdentityMapper();
            java.util.Iterator<org.apache.tools.ant.types.Resource> it = createUnifiedSourcePath.iterator();
            while (it.hasNext()) {
                org.apache.tools.ant.types.resources.FileResource asFileResource = org.apache.tools.ant.util.ResourceUtils.asFileResource((org.apache.tools.ant.types.resources.FileProvider) it.next().as(org.apache.tools.ant.types.resources.FileProvider.class));
                java.io.File baseDir = z3 ? this.destDir : asFileResource.getBaseDir();
                java.lang.String[] mapFileName = identityMapper.mapFileName(asFileResource.getName());
                if (mapFileName == null || mapFileName.length != 1) {
                    throw new org.apache.tools.ant.BuildException(ERROR_BAD_MAP + asFileResource.getFile());
                }
                f(asFileResource.getFile(), new java.io.File(baseDir, mapFileName[0]));
            }
        } finally {
            endExecution();
        }
    }

    public final void f(java.io.File file, java.io.File file2) throws org.apache.tools.ant.BuildException {
        if (file2 == null) {
            file2 = file;
        }
        if (isUpToDate(file, file2)) {
            return;
        }
        long lastModified = file.lastModified();
        org.apache.tools.ant.taskdefs.ExecTask createJarSigner = createJarSigner();
        setCommonOptions(createJarSigner);
        bindToKeystore(createJarSigner);
        if (this.sigfile != null) {
            addValue(createJarSigner, "-sigfile");
            addValue(createJarSigner, this.sigfile);
        }
        try {
            org.apache.tools.ant.util.FileUtils fileUtils = H;
            if (!fileUtils.areSame(file, file2)) {
                addValue(createJarSigner, "-signedjar");
                addValue(createJarSigner, file2.getPath());
            }
            if (this.internalsf) {
                addValue(createJarSigner, "-internalsf");
            }
            if (this.sectionsonly) {
                addValue(createJarSigner, "-sectionsonly");
            }
            if (this.F != null) {
                addValue(createJarSigner, "-sigalg");
                addValue(createJarSigner, this.F);
            }
            if (this.G != null) {
                addValue(createJarSigner, "-digestalg");
                addValue(createJarSigner, this.G);
            }
            e(createJarSigner);
            addValue(createJarSigner, file.getPath());
            addValue(createJarSigner, this.alias);
            log("Signing JAR: " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + " as " + this.alias);
            createJarSigner.execute();
            if (this.C) {
                fileUtils.setFileLastModified(file2, lastModified);
            }
        } catch (java.io.IOException e) {
            throw new org.apache.tools.ant.BuildException(e);
        }
    }

    public java.lang.String getDigestAlg() {
        return this.G;
    }

    public org.apache.tools.ant.util.FileNameMapper getMapper() {
        return this.D;
    }

    public java.lang.String getSigAlg() {
        return this.F;
    }

    public java.lang.String getTsacert() {
        return this.tsacert;
    }

    public java.lang.String getTsaproxyhost() {
        return this.tsaproxyhost;
    }

    public java.lang.String getTsaproxyport() {
        return this.tsaproxyport;
    }

    public java.lang.String getTsaurl() {
        return this.tsaurl;
    }

    public boolean isForce() {
        return this.E;
    }

    public boolean isSigned(java.io.File file) {
        try {
            java.lang.String str = this.sigfile;
            if (str == null) {
                str = this.alias;
            }
            return org.apache.tools.ant.taskdefs.condition.IsSigned.isSigned(file, str);
        } catch (java.io.IOException e) {
            log(e.toString(), 3);
            return false;
        }
    }

    public boolean isUpToDate(java.io.File file, java.io.File file2) {
        if (isForce() || file == null || !file.exists()) {
            return false;
        }
        if (file2 == null) {
            file2 = file;
        }
        if (!file.equals(file2)) {
            return H.isUpToDate(file, file2);
        }
        if (this.lazy) {
            return isSigned(file);
        }
        return false;
    }

    public void setDestDir(java.io.File file) {
        this.destDir = file;
    }

    public void setDigestAlg(java.lang.String str) {
        this.G = str;
    }

    public void setForce(boolean z) {
        this.E = z;
    }

    public void setInternalsf(boolean z) {
        this.internalsf = z;
    }

    public void setLazy(boolean z) {
        this.lazy = z;
    }

    public void setPreserveLastModified(boolean z) {
        this.C = z;
    }

    public void setSectionsonly(boolean z) {
        this.sectionsonly = z;
    }

    public void setSigAlg(java.lang.String str) {
        this.F = str;
    }

    public void setSigfile(java.lang.String str) {
        this.sigfile = str;
    }

    public void setSignedjar(java.io.File file) {
        this.signedjar = file;
    }

    public void setTsacert(java.lang.String str) {
        this.tsacert = str;
    }

    public void setTsaproxyhost(java.lang.String str) {
        this.tsaproxyhost = str;
    }

    public void setTsaproxyport(java.lang.String str) {
        this.tsaproxyport = str;
    }

    public void setTsaurl(java.lang.String str) {
        this.tsaurl = str;
    }
}
