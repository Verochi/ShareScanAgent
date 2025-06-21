package org.apache.tools.ant.taskdefs;

/* loaded from: classes25.dex */
public class Get extends org.apache.tools.ant.Task {
    public static final org.apache.tools.ant.util.FileUtils J = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public java.io.File v;
    public final org.apache.tools.ant.types.resources.Resources u = new org.apache.tools.ant.types.resources.Resources();
    public boolean w = false;
    public boolean x = false;
    public boolean y = false;
    public boolean z = false;
    public java.lang.String A = null;
    public java.lang.String B = null;
    public long C = 0;
    public int D = 3;
    public boolean E = false;
    public boolean F = true;
    public boolean G = false;
    public org.apache.tools.ant.types.Mapper H = null;
    public java.lang.String I = java.lang.System.getProperty(org.apache.tools.ant.MagicNames.HTTP_AGENT_PROPERTY, "Apache Ant/" + org.apache.tools.ant.Main.getShortAntVersion());

    public static class Base64Converter extends org.apache.tools.ant.util.Base64Converter {
    }

    public interface DownloadProgress {
        void beginDownload();

        void endDownload();

        void onTick();
    }

    public class GetThread extends java.lang.Thread {
        public java.net.URLConnection D;
        public java.lang.String F;
        public final java.net.URL n;
        public final java.io.File t;
        public final boolean u;
        public final long v;
        public final org.apache.tools.ant.taskdefs.Get.DownloadProgress w;
        public final int x;
        public boolean y = false;
        public java.io.IOException z = null;
        public org.apache.tools.ant.BuildException A = null;
        public java.io.InputStream B = null;
        public java.io.OutputStream C = null;
        public int E = 0;

        public GetThread(java.net.URL url, java.io.File file, boolean z, long j, org.apache.tools.ant.taskdefs.Get.DownloadProgress downloadProgress, int i, java.lang.String str) {
            this.n = url;
            this.t = file;
            this.u = z;
            this.v = j;
            this.w = downloadProgress;
            this.x = i;
            this.F = str;
        }

        public void a() {
            interrupt();
            org.apache.tools.ant.util.FileUtils.close(this.C);
            org.apache.tools.ant.util.FileUtils.close(this.B);
            if (this.y || !this.t.exists()) {
                return;
            }
            this.t.delete();
        }

        public final boolean b() throws java.io.IOException {
            int read;
            for (int i = 0; i < org.apache.tools.ant.taskdefs.Get.this.D; i++) {
                try {
                    this.B = this.D.getInputStream();
                    break;
                } catch (java.io.IOException e) {
                    org.apache.tools.ant.taskdefs.Get.this.log("Error opening connection " + e, this.x);
                }
            }
            if (this.B == null) {
                org.apache.tools.ant.taskdefs.Get.this.log("Can't get " + this.n + " to " + this.t, this.x);
                if (org.apache.tools.ant.taskdefs.Get.this.z) {
                    return false;
                }
                throw new org.apache.tools.ant.BuildException("Can't get " + this.n + " to " + this.t, org.apache.tools.ant.taskdefs.Get.this.getLocation());
            }
            if (org.apache.tools.ant.taskdefs.Get.this.G && "gzip".equals(this.D.getContentEncoding())) {
                this.B = new java.util.zip.GZIPInputStream(this.B);
            }
            this.C = new java.io.FileOutputStream(this.t);
            this.w.beginDownload();
            try {
                byte[] bArr = new byte[102400];
                while (!isInterrupted() && (read = this.B.read(bArr)) >= 0) {
                    this.C.write(bArr, 0, read);
                    this.w.onTick();
                }
                boolean z = !isInterrupted();
                org.apache.tools.ant.util.FileUtils.close(this.C);
                org.apache.tools.ant.util.FileUtils.close(this.B);
                if (!z) {
                    this.t.delete();
                }
                this.w.endDownload();
                return true;
            } catch (java.lang.Throwable th) {
                org.apache.tools.ant.util.FileUtils.close(this.C);
                org.apache.tools.ant.util.FileUtils.close(this.B);
                this.t.delete();
                throw th;
            }
        }

        public final boolean c() throws java.io.IOException, org.apache.tools.ant.BuildException {
            java.net.URLConnection e = e(this.n);
            this.D = e;
            if (e == null) {
                return false;
            }
            boolean b = b();
            if (b && org.apache.tools.ant.taskdefs.Get.this.y) {
                g();
            }
            return b;
        }

        public final boolean d(int i) {
            return i == 301 || i == 302 || i == 303 || i == 307;
        }

        public final java.net.URLConnection e(java.net.URL url) throws java.io.IOException {
            java.net.URLConnection openConnection = url.openConnection();
            if (this.u) {
                openConnection.setIfModifiedSince(this.v);
            }
            openConnection.addRequestProperty("User-Agent", this.F);
            if (org.apache.tools.ant.taskdefs.Get.this.A != null || org.apache.tools.ant.taskdefs.Get.this.B != null) {
                java.lang.String encode = new org.apache.tools.ant.taskdefs.Get.Base64Converter().encode((org.apache.tools.ant.taskdefs.Get.this.A + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + org.apache.tools.ant.taskdefs.Get.this.B).getBytes());
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Basic ");
                sb.append(encode);
                openConnection.setRequestProperty("Authorization", sb.toString());
            }
            if (org.apache.tools.ant.taskdefs.Get.this.G) {
                openConnection.setRequestProperty(com.google.common.net.HttpHeaders.ACCEPT_ENCODING, "gzip");
            }
            boolean z = openConnection instanceof java.net.HttpURLConnection;
            if (z) {
                ((java.net.HttpURLConnection) openConnection).setInstanceFollowRedirects(false);
                openConnection.setUseCaches(org.apache.tools.ant.taskdefs.Get.this.F);
            }
            try {
                openConnection.connect();
                if (z) {
                    java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) openConnection;
                    int responseCode = httpURLConnection.getResponseCode();
                    if (d(responseCode)) {
                        java.lang.String headerField = httpURLConnection.getHeaderField("Location");
                        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                        sb2.append(url);
                        sb2.append(responseCode == 301 ? " permanently" : "");
                        sb2.append(" moved to ");
                        sb2.append(headerField);
                        org.apache.tools.ant.taskdefs.Get.this.log(sb2.toString(), this.x);
                        java.net.URL url2 = new java.net.URL(url, headerField);
                        if (f(url, url2)) {
                            return e(url2);
                        }
                        return null;
                    }
                    long lastModified = httpURLConnection.getLastModified();
                    if (responseCode == 304 || (lastModified != 0 && this.u && this.v >= lastModified)) {
                        org.apache.tools.ant.taskdefs.Get.this.log("Not modified - so not downloaded", this.x);
                        return null;
                    }
                    if (responseCode == 401) {
                        if (!org.apache.tools.ant.taskdefs.Get.this.z) {
                            throw new org.apache.tools.ant.BuildException("HTTP Authorization failure");
                        }
                        org.apache.tools.ant.taskdefs.Get.this.log("HTTP Authorization failure", this.x);
                        return null;
                    }
                }
                return openConnection;
            } catch (java.lang.NullPointerException e) {
                throw new org.apache.tools.ant.BuildException("Failed to parse " + this.n.toString(), e);
            }
        }

        public final boolean f(java.net.URL url, java.net.URL url2) {
            if (url.getProtocol().equals(url2.getProtocol()) || (com.alipay.sdk.m.l.a.q.equals(url.getProtocol()) && "https".equals(url2.getProtocol()))) {
                int i = this.E + 1;
                this.E = i;
                if (i <= 25) {
                    return true;
                }
                if (!org.apache.tools.ant.taskdefs.Get.this.z) {
                    throw new org.apache.tools.ant.BuildException("More than 25 times redirected, giving up");
                }
                org.apache.tools.ant.taskdefs.Get.this.log("More than 25 times redirected, giving up", this.x);
                return false;
            }
            java.lang.String str = "Redirection detected from " + url.getProtocol() + " to " + url2.getProtocol() + ". Protocol switch unsafe, not allowed.";
            if (!org.apache.tools.ant.taskdefs.Get.this.z) {
                throw new org.apache.tools.ant.BuildException(str);
            }
            org.apache.tools.ant.taskdefs.Get.this.log(str, this.x);
            return false;
        }

        public final void g() {
            long lastModified = this.D.getLastModified();
            if (org.apache.tools.ant.taskdefs.Get.this.w) {
                java.util.Date date = new java.util.Date(lastModified);
                org.apache.tools.ant.taskdefs.Get get = org.apache.tools.ant.taskdefs.Get.this;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("last modified = ");
                sb.append(date.toString());
                sb.append(lastModified == 0 ? " - using current time instead" : "");
                get.log(sb.toString(), this.x);
            }
            if (lastModified != 0) {
                org.apache.tools.ant.taskdefs.Get.J.setFileLastModified(this.t, lastModified);
            }
        }

        public boolean h() throws java.io.IOException, org.apache.tools.ant.BuildException {
            java.io.IOException iOException = this.z;
            if (iOException != null) {
                throw iOException;
            }
            org.apache.tools.ant.BuildException buildException = this.A;
            if (buildException == null) {
                return this.y;
            }
            throw buildException;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                this.y = c();
            } catch (java.io.IOException e) {
                this.z = e;
            } catch (org.apache.tools.ant.BuildException e2) {
                this.A = e2;
            }
        }
    }

    public static class NullProgress implements org.apache.tools.ant.taskdefs.Get.DownloadProgress {
        @Override // org.apache.tools.ant.taskdefs.Get.DownloadProgress
        public void beginDownload() {
        }

        @Override // org.apache.tools.ant.taskdefs.Get.DownloadProgress
        public void endDownload() {
        }

        @Override // org.apache.tools.ant.taskdefs.Get.DownloadProgress
        public void onTick() {
        }
    }

    public static class VerboseProgress implements org.apache.tools.ant.taskdefs.Get.DownloadProgress {
        public int a = 0;
        public java.io.PrintStream b;

        public VerboseProgress(java.io.PrintStream printStream) {
            this.b = printStream;
        }

        @Override // org.apache.tools.ant.taskdefs.Get.DownloadProgress
        public void beginDownload() {
            this.a = 0;
        }

        @Override // org.apache.tools.ant.taskdefs.Get.DownloadProgress
        public void endDownload() {
            this.b.println();
            this.b.flush();
        }

        @Override // org.apache.tools.ant.taskdefs.Get.DownloadProgress
        public void onTick() {
            this.b.print(".");
            int i = this.a;
            this.a = i + 1;
            if (i > 50) {
                this.b.flush();
                this.a = 0;
            }
        }
    }

    public void add(org.apache.tools.ant.types.ResourceCollection resourceCollection) {
        this.u.add(resourceCollection);
    }

    public void add(org.apache.tools.ant.util.FileNameMapper fileNameMapper) {
        createMapper().add(fileNameMapper);
    }

    public org.apache.tools.ant.types.Mapper createMapper() throws org.apache.tools.ant.BuildException {
        if (this.H != null) {
            throw new org.apache.tools.ant.BuildException(org.apache.tools.ant.taskdefs.Expand.ERROR_MULTIPLE_MAPPERS, getLocation());
        }
        org.apache.tools.ant.types.Mapper mapper = new org.apache.tools.ant.types.Mapper(getProject());
        this.H = mapper;
        return mapper;
    }

    @java.lang.Deprecated
    public boolean doGet(int i, org.apache.tools.ant.taskdefs.Get.DownloadProgress downloadProgress) throws java.io.IOException {
        l();
        java.util.Iterator<org.apache.tools.ant.types.Resource> it = this.u.iterator();
        if (it.hasNext()) {
            return doGet(((org.apache.tools.ant.types.resources.URLProvider) it.next().as(org.apache.tools.ant.types.resources.URLProvider.class)).getURL(), this.v, i, downloadProgress);
        }
        return false;
    }

    public boolean doGet(java.net.URL url, java.io.File file, int i, org.apache.tools.ant.taskdefs.Get.DownloadProgress downloadProgress) throws java.io.IOException {
        long j;
        boolean z;
        if (file.exists() && this.E) {
            log("Destination already exists (skipping): " + file.getAbsolutePath(), i);
            return true;
        }
        org.apache.tools.ant.taskdefs.Get.DownloadProgress nullProgress = downloadProgress == null ? new org.apache.tools.ant.taskdefs.Get.NullProgress() : downloadProgress;
        log("Getting: " + url, i);
        log("To: " + file.getAbsolutePath(), i);
        if (this.y && file.exists()) {
            long lastModified = file.lastModified();
            if (this.w) {
                log("local file date : " + new java.util.Date(lastModified).toString(), i);
            }
            j = lastModified;
            z = true;
        } else {
            j = 0;
            z = false;
        }
        org.apache.tools.ant.taskdefs.Get.GetThread getThread = new org.apache.tools.ant.taskdefs.Get.GetThread(url, file, z, j, nullProgress, i, this.I);
        getThread.setDaemon(true);
        getProject().registerThreadTask(getThread, this);
        getThread.start();
        try {
            getThread.join(this.C * 1000);
        } catch (java.lang.InterruptedException unused) {
            log("interrupted waiting for GET to finish", 3);
        }
        if (!getThread.isAlive()) {
            return getThread.h();
        }
        java.lang.String str = "The GET operation took longer than " + this.C + " seconds, stopping it.";
        if (this.z) {
            log(str);
        }
        getThread.a();
        if (this.z) {
            return false;
        }
        throw new org.apache.tools.ant.BuildException(str);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:4|(1:53)(2:6|(6:45|46|(1:48)|49|(1:51)|52)(3:8|(3:42|43|44)(3:10|11|(3:39|40|41)(3:13|14|(3:36|37|38)(2:16|17)))|26))|18|(1:20)(1:35)|21|22|23|25|26|2) */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00d6, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00d7, code lost:
    
        log("Error getting " + r2 + " to " + r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00f5, code lost:
    
        if (r8.z != false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0102, code lost:
    
        throw new org.apache.tools.ant.BuildException(r1, getLocation());
     */
    @Override // org.apache.tools.ant.Task
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void execute() throws org.apache.tools.ant.BuildException {
        l();
        java.util.Iterator<org.apache.tools.ant.types.Resource> it = this.u.iterator();
        while (it.hasNext()) {
            org.apache.tools.ant.types.Resource next = it.next();
            java.net.URL url = ((org.apache.tools.ant.types.resources.URLProvider) next.as(org.apache.tools.ant.types.resources.URLProvider.class)).getURL();
            java.io.File file = this.v;
            if (file.isDirectory()) {
                org.apache.tools.ant.types.Mapper mapper = this.H;
                if (mapper == null) {
                    java.lang.String path = url.getPath();
                    if (path.endsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)) {
                        path = path.substring(0, path.length() - 1);
                    }
                    int lastIndexOf = path.lastIndexOf(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
                    if (lastIndexOf > -1) {
                        path = path.substring(lastIndexOf + 1);
                    }
                    file = new java.io.File(this.v, path);
                } else {
                    java.lang.String[] mapFileName = mapper.getImplementation().mapFileName(url.toString());
                    if (mapFileName == null) {
                        log("skipping " + next + " - mapper can't handle it", 1);
                    } else if (mapFileName.length == 0) {
                        log("skipping " + next + " - mapper returns no file name", 1);
                    } else if (mapFileName.length > 1) {
                        log("skipping " + next + " - mapper returns multiple file names", 1);
                    } else {
                        file = new java.io.File(this.v, mapFileName[0]);
                    }
                }
            }
            doGet(url, file, 2, this.w ? new org.apache.tools.ant.taskdefs.Get.VerboseProgress(java.lang.System.out) : null);
        }
    }

    public final void l() {
        java.lang.String str = this.I;
        if (str == null || str.trim().length() == 0) {
            throw new org.apache.tools.ant.BuildException("userAgent may not be null or empty");
        }
        if (this.u.size() == 0) {
            throw new org.apache.tools.ant.BuildException("at least one source is required", getLocation());
        }
        java.util.Iterator<org.apache.tools.ant.types.Resource> it = this.u.iterator();
        while (it.hasNext()) {
            if (((org.apache.tools.ant.types.resources.URLProvider) it.next().as(org.apache.tools.ant.types.resources.URLProvider.class)) == null) {
                throw new org.apache.tools.ant.BuildException("Only URLProvider resources are supported", getLocation());
            }
        }
        java.io.File file = this.v;
        if (file == null) {
            throw new org.apache.tools.ant.BuildException("dest attribute is required", getLocation());
        }
        if (file.exists() && this.u.size() > 1 && !this.v.isDirectory()) {
            throw new org.apache.tools.ant.BuildException("The specified destination is not a directory", getLocation());
        }
        if (this.v.exists() && !this.v.canWrite()) {
            throw new org.apache.tools.ant.BuildException("Can't write to " + this.v.getAbsolutePath(), getLocation());
        }
        if (this.u.size() <= 1 || this.v.exists()) {
            return;
        }
        this.v.mkdirs();
    }

    @Override // org.apache.tools.ant.Task, org.apache.tools.ant.ProjectComponent
    public void log(java.lang.String str, int i) {
        if (!this.x || i <= 0) {
            super.log(str, i);
        }
    }

    public void setDest(java.io.File file) {
        this.v = file;
    }

    public void setHttpUseCaches(boolean z) {
        this.F = z;
    }

    public void setIgnoreErrors(boolean z) {
        this.z = z;
    }

    public void setMaxTime(long j) {
        this.C = j;
    }

    public void setPassword(java.lang.String str) {
        this.B = str;
    }

    public void setQuiet(boolean z) {
        this.x = z;
    }

    public void setRetries(int i) {
        if (i <= 0) {
            log("Setting retries to " + i + " will make the task not even try to reach the URI at all", 1);
        }
        this.D = i;
    }

    public void setSkipExisting(boolean z) {
        this.E = z;
    }

    public void setSrc(java.net.URL url) {
        add(new org.apache.tools.ant.types.resources.URLResource(url));
    }

    public void setTryGzipEncoding(boolean z) {
        this.G = z;
    }

    public void setUseTimestamp(boolean z) {
        this.y = z;
    }

    public void setUserAgent(java.lang.String str) {
        this.I = str;
    }

    public void setUsername(java.lang.String str) {
        this.A = str;
    }

    public void setVerbose(boolean z) {
        this.w = z;
    }
}
