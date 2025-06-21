package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class VerifyJar extends org.apache.tools.ant.taskdefs.AbstractJarSignerTask {
    public static final java.lang.String ERROR_NO_FILE = "Not found :";
    public static final java.lang.String ERROR_NO_VERIFY = "Failed to verify ";
    public boolean C = false;
    public org.apache.tools.ant.taskdefs.VerifyJar.BufferingOutputFilter D = new org.apache.tools.ant.taskdefs.VerifyJar.BufferingOutputFilter(null);
    public java.lang.String E = null;

    public static class BufferingOutputFilter implements org.apache.tools.ant.filters.ChainableReader {
        public org.apache.tools.ant.taskdefs.VerifyJar.BufferingOutputFilterReader n;

        public BufferingOutputFilter() {
        }

        public /* synthetic */ BufferingOutputFilter(org.apache.tools.ant.taskdefs.VerifyJar.AnonymousClass1 anonymousClass1) {
            this();
        }

        public void a() {
            org.apache.tools.ant.taskdefs.VerifyJar.BufferingOutputFilterReader bufferingOutputFilterReader = this.n;
            if (bufferingOutputFilterReader != null) {
                bufferingOutputFilterReader.a();
            }
        }

        @Override // org.apache.tools.ant.filters.ChainableReader
        public java.io.Reader chain(java.io.Reader reader) {
            org.apache.tools.ant.taskdefs.VerifyJar.BufferingOutputFilterReader bufferingOutputFilterReader = new org.apache.tools.ant.taskdefs.VerifyJar.BufferingOutputFilterReader(reader);
            this.n = bufferingOutputFilterReader;
            return bufferingOutputFilterReader;
        }

        public java.lang.String toString() {
            return this.n.toString();
        }
    }

    public static class BufferingOutputFilterReader extends java.io.Reader {
        public java.io.Reader n;
        public java.lang.StringBuffer t = new java.lang.StringBuffer();

        public BufferingOutputFilterReader(java.io.Reader reader) {
            this.n = reader;
        }

        public void a() {
            this.t = new java.lang.StringBuffer();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws java.io.IOException {
            this.n.close();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws java.io.IOException {
            int read = this.n.read(cArr, i, i2);
            this.t.append(cArr, i, i2);
            return read;
        }

        public java.lang.String toString() {
            return this.t.toString();
        }
    }

    @Override // org.apache.tools.ant.taskdefs.AbstractJarSignerTask
    public void beginExecution() {
        java.lang.String str = this.storepass;
        if (str != null) {
            this.E = str;
            setStorepass(null);
        }
        super.beginExecution();
    }

    public final void d(java.io.File file) {
        if (!file.exists()) {
            throw new org.apache.tools.ant.BuildException(ERROR_NO_FILE + file);
        }
        org.apache.tools.ant.taskdefs.ExecTask createJarSigner = createJarSigner();
        setCommonOptions(createJarSigner);
        bindToKeystore(createJarSigner);
        if (this.E != null) {
            addValue(createJarSigner, "-storepass");
            addValue(createJarSigner, this.E);
        }
        addValue(createJarSigner, "-verify");
        if (this.C) {
            addValue(createJarSigner, "-certs");
        }
        addValue(createJarSigner, file.getPath());
        java.lang.String str = this.alias;
        if (str != null) {
            addValue(createJarSigner, str);
        }
        log("Verifying JAR: " + file.getAbsolutePath());
        this.D.a();
        try {
            createJarSigner.execute();
            e = null;
        } catch (org.apache.tools.ant.BuildException e) {
            e = e;
        }
        java.lang.String bufferingOutputFilter = this.D.toString();
        if (e != null) {
            if (!bufferingOutputFilter.contains("zip file closed")) {
                throw e;
            }
            log("You are running jarsigner against a JVM with a known bug that manifests as an IllegalStateException.", 1);
        }
        if (bufferingOutputFilter.contains("jar verified.")) {
            return;
        }
        throw new org.apache.tools.ant.BuildException(ERROR_NO_VERIFY + file);
    }

    @Override // org.apache.tools.ant.taskdefs.AbstractJarSignerTask
    public void endExecution() {
        java.lang.String str = this.E;
        if (str != null) {
            setStorepass(str);
            this.E = null;
        }
        super.endExecution();
    }

    @Override // org.apache.tools.ant.Task
    public void execute() throws org.apache.tools.ant.BuildException {
        if (!(this.jar != null) && !hasResources()) {
            throw new org.apache.tools.ant.BuildException(org.apache.tools.ant.taskdefs.AbstractJarSignerTask.ERROR_NO_SOURCE);
        }
        beginExecution();
        org.apache.tools.ant.types.RedirectorElement redirector = getRedirector();
        redirector.setAlwaysLog(true);
        redirector.createOutputFilterChain().add(this.D);
        try {
            java.util.Iterator<org.apache.tools.ant.types.Resource> it = createUnifiedSourcePath().iterator();
            while (it.hasNext()) {
                d(((org.apache.tools.ant.types.resources.FileProvider) it.next().as(org.apache.tools.ant.types.resources.FileProvider.class)).getFile());
            }
        } finally {
            endExecution();
        }
    }

    public void setCertificates(boolean z) {
        this.C = z;
    }
}
