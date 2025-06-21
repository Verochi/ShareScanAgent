package org.apache.tools.ant.types.resources;

/* loaded from: classes26.dex */
public class URLResource extends org.apache.tools.ant.types.Resource implements org.apache.tools.ant.types.resources.URLProvider {
    public static final org.apache.tools.ant.util.FileUtils C = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public static final int D = org.apache.tools.ant.types.Resource.getMagicNumber("null URL".getBytes());
    public java.net.URL A;
    public java.lang.String B;
    public java.net.URL y;
    public java.net.URLConnection z;

    /* renamed from: org.apache.tools.ant.types.resources.URLResource$1, reason: invalid class name */
    public class AnonymousClass1 implements org.apache.tools.ant.types.resources.URLResource.ConnectionUser {
        public AnonymousClass1() {
        }

        @Override // org.apache.tools.ant.types.resources.URLResource.ConnectionUser
        public long a(java.net.URLConnection uRLConnection) {
            return org.apache.tools.ant.types.resources.URLResource.this.z.getLastModified();
        }
    }

    /* renamed from: org.apache.tools.ant.types.resources.URLResource$2, reason: invalid class name */
    public class AnonymousClass2 implements org.apache.tools.ant.types.resources.URLResource.ConnectionUser {
        public AnonymousClass2() {
        }

        @Override // org.apache.tools.ant.types.resources.URLResource.ConnectionUser
        public long a(java.net.URLConnection uRLConnection) {
            return org.apache.tools.ant.types.resources.URLResource.this.z.getContentLength();
        }
    }

    public interface ConnectionUser {
        long a(java.net.URLConnection uRLConnection);
    }

    public URLResource() {
    }

    public URLResource(java.io.File file) {
        setFile(file);
    }

    public URLResource(java.lang.String str) {
        this(d(str));
    }

    public URLResource(java.net.URL url) {
        setURL(url);
    }

    public URLResource(org.apache.tools.ant.types.resources.URLProvider uRLProvider) {
        setURL(uRLProvider.getURL());
    }

    public static java.net.URL d(java.lang.String str) {
        try {
            return new java.net.URL(str);
        } catch (java.net.MalformedURLException e) {
            throw new org.apache.tools.ant.BuildException(e);
        }
    }

    public final synchronized boolean c(boolean z) {
        if (getURL() == null) {
            return false;
        }
        try {
            connect(3);
            java.net.URLConnection uRLConnection = this.z;
            if (uRLConnection instanceof java.net.HttpURLConnection) {
                boolean z2 = ((java.net.HttpURLConnection) uRLConnection).getResponseCode() < 400;
                if (z) {
                    close();
                }
                return z2;
            }
            try {
                if (this.y.getProtocol().startsWith("ftp")) {
                    try {
                        org.apache.tools.ant.util.FileUtils.close(this.z.getInputStream());
                        z = true;
                    } catch (java.lang.Throwable th) {
                        org.apache.tools.ant.util.FileUtils.close((java.io.InputStream) null);
                        throw th;
                    }
                }
                if (z) {
                    close();
                }
                return true;
            } catch (java.io.IOException unused) {
                z = true;
                if (z) {
                    close();
                }
                return false;
            } catch (java.lang.Throwable th2) {
                th = th2;
                z = true;
                if (z) {
                    close();
                }
                throw th;
            }
        } catch (java.io.IOException unused2) {
        } catch (java.lang.Throwable th3) {
            th = th3;
        }
    }

    public final synchronized void close() {
        try {
            org.apache.tools.ant.util.FileUtils.close(this.z);
        } finally {
            this.z = null;
        }
    }

    public void connect() throws java.io.IOException {
        connect(0);
    }

    public synchronized void connect(int i) throws java.io.IOException {
        java.net.URL url = getURL();
        if (url == null) {
            throw new org.apache.tools.ant.BuildException("URL not set");
        }
        if (this.z == null) {
            try {
                java.net.URLConnection openConnection = url.openConnection();
                this.z = openConnection;
                openConnection.connect();
            } catch (java.io.IOException e) {
                log(e.toString(), i);
                this.z = null;
                throw e;
            }
        }
    }

    public final long e(org.apache.tools.ant.types.resources.URLResource.ConnectionUser connectionUser, long j) {
        try {
            java.net.URLConnection uRLConnection = this.z;
            if (uRLConnection != null) {
                return connectionUser.a(uRLConnection);
            }
            try {
                connect();
                return connectionUser.a(this.z);
            } finally {
                close();
            }
        } catch (java.io.IOException unused) {
            return j;
        }
    }

    @Override // org.apache.tools.ant.types.Resource
    public synchronized boolean equals(java.lang.Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (isReference()) {
            return getCheckedRef().equals(obj);
        }
        if (obj != null && obj.getClass() == getClass()) {
            org.apache.tools.ant.types.resources.URLResource uRLResource = (org.apache.tools.ant.types.resources.URLResource) obj;
            if (getURL() != null) {
                z = getURL().equals(uRLResource.getURL());
            } else if (uRLResource.getURL() != null) {
                z = false;
            }
            return z;
        }
        return false;
    }

    @Override // org.apache.tools.ant.types.Resource
    public synchronized java.io.InputStream getInputStream() throws java.io.IOException {
        if (isReference()) {
            return ((org.apache.tools.ant.types.Resource) getCheckedRef()).getInputStream();
        }
        connect();
        try {
            return this.z.getInputStream();
        } finally {
            this.z = null;
        }
    }

    @Override // org.apache.tools.ant.types.Resource
    public synchronized long getLastModified() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.Resource) getCheckedRef()).getLastModified();
        }
        if (!c(false)) {
            return 0L;
        }
        return e(new org.apache.tools.ant.types.resources.URLResource.AnonymousClass1(), 0L);
    }

    @Override // org.apache.tools.ant.types.Resource
    public synchronized java.lang.String getName() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.Resource) getCheckedRef()).getName();
        }
        java.lang.String file = getURL().getFile();
        if (!"".equals(file)) {
            file = file.substring(1);
        }
        return file;
    }

    @Override // org.apache.tools.ant.types.Resource
    public synchronized java.io.OutputStream getOutputStream() throws java.io.IOException {
        if (isReference()) {
            return ((org.apache.tools.ant.types.Resource) getCheckedRef()).getOutputStream();
        }
        connect();
        try {
            return this.z.getOutputStream();
        } finally {
            this.z = null;
        }
    }

    @Override // org.apache.tools.ant.types.Resource
    public synchronized long getSize() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.Resource) getCheckedRef()).getSize();
        }
        if (!c(false)) {
            return 0L;
        }
        return e(new org.apache.tools.ant.types.resources.URLResource.AnonymousClass2(), -1L);
    }

    @Override // org.apache.tools.ant.types.resources.URLProvider
    public synchronized java.net.URL getURL() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.resources.URLResource) getCheckedRef()).getURL();
        }
        if (this.y == null && this.A != null) {
            if (this.B == null) {
                throw new org.apache.tools.ant.BuildException("must provide relativePath attribute when using baseURL.");
            }
            try {
                this.y = new java.net.URL(this.A, this.B);
            } catch (java.net.MalformedURLException e) {
                throw new org.apache.tools.ant.BuildException(e);
            }
        }
        return this.y;
    }

    @Override // org.apache.tools.ant.types.Resource
    public synchronized int hashCode() {
        if (isReference()) {
            return getCheckedRef().hashCode();
        }
        return org.apache.tools.ant.types.Resource.MAGIC * (getURL() == null ? D : getURL().hashCode());
    }

    @Override // org.apache.tools.ant.types.Resource
    public synchronized boolean isDirectory() {
        return isReference() ? ((org.apache.tools.ant.types.Resource) getCheckedRef()).isDirectory() : getName().endsWith(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR);
    }

    @Override // org.apache.tools.ant.types.Resource
    public synchronized boolean isExists() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.Resource) getCheckedRef()).isExists();
        }
        return c(false);
    }

    public synchronized void setBaseURL(java.net.URL url) {
        checkAttributesAllowed();
        if (this.y != null) {
            throw new org.apache.tools.ant.BuildException("can't define URL and baseURL attribute");
        }
        this.A = url;
    }

    public synchronized void setFile(java.io.File file) {
        try {
            setURL(C.getFileURL(file));
        } catch (java.net.MalformedURLException e) {
            throw new org.apache.tools.ant.BuildException(e);
        }
    }

    @Override // org.apache.tools.ant.types.Resource, org.apache.tools.ant.types.DataType
    public synchronized void setRefid(org.apache.tools.ant.types.Reference reference) {
        if (this.y != null || this.A != null || this.B != null) {
            throw tooManyAttributes();
        }
        super.setRefid(reference);
    }

    public synchronized void setRelativePath(java.lang.String str) {
        checkAttributesAllowed();
        if (this.y != null) {
            throw new org.apache.tools.ant.BuildException("can't define URL and relativePath attribute");
        }
        this.B = str;
    }

    public synchronized void setURL(java.net.URL url) {
        checkAttributesAllowed();
        this.y = url;
    }

    @Override // org.apache.tools.ant.types.Resource, org.apache.tools.ant.types.DataType
    public synchronized java.lang.String toString() {
        return isReference() ? getCheckedRef().toString() : java.lang.String.valueOf(getURL());
    }
}
