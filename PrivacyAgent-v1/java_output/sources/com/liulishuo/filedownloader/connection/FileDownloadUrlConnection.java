package com.liulishuo.filedownloader.connection;

/* loaded from: classes23.dex */
public class FileDownloadUrlConnection implements com.liulishuo.filedownloader.connection.FileDownloadConnection {
    protected java.net.URLConnection mConnection;

    public static class Configuration {
        public java.net.Proxy a;
        public java.lang.Integer b;
        public java.lang.Integer c;

        public com.liulishuo.filedownloader.connection.FileDownloadUrlConnection.Configuration connectTimeout(int i) {
            this.c = java.lang.Integer.valueOf(i);
            return this;
        }

        public com.liulishuo.filedownloader.connection.FileDownloadUrlConnection.Configuration proxy(java.net.Proxy proxy) {
            this.a = proxy;
            return this;
        }

        public com.liulishuo.filedownloader.connection.FileDownloadUrlConnection.Configuration readTimeout(int i) {
            this.b = java.lang.Integer.valueOf(i);
            return this;
        }
    }

    public static class Creator implements com.liulishuo.filedownloader.util.FileDownloadHelper.ConnectionCreator {
        public final com.liulishuo.filedownloader.connection.FileDownloadUrlConnection.Configuration a;

        public Creator() {
            this(null);
        }

        public Creator(com.liulishuo.filedownloader.connection.FileDownloadUrlConnection.Configuration configuration) {
            this.a = configuration;
        }

        @Override // com.liulishuo.filedownloader.util.FileDownloadHelper.ConnectionCreator
        public com.liulishuo.filedownloader.connection.FileDownloadConnection create(java.lang.String str) throws java.io.IOException {
            return new com.liulishuo.filedownloader.connection.FileDownloadUrlConnection(str, this.a);
        }
    }

    public FileDownloadUrlConnection(java.lang.String str) throws java.io.IOException {
        this(str, (com.liulishuo.filedownloader.connection.FileDownloadUrlConnection.Configuration) null);
    }

    public FileDownloadUrlConnection(java.lang.String str, com.liulishuo.filedownloader.connection.FileDownloadUrlConnection.Configuration configuration) throws java.io.IOException {
        this(new java.net.URL(str), configuration);
    }

    public FileDownloadUrlConnection(java.net.URL url, com.liulishuo.filedownloader.connection.FileDownloadUrlConnection.Configuration configuration) throws java.io.IOException {
        if (configuration == null || configuration.a == null) {
            this.mConnection = url.openConnection();
        } else {
            this.mConnection = url.openConnection(configuration.a);
        }
        if (configuration != null) {
            if (configuration.b != null) {
                this.mConnection.setReadTimeout(configuration.b.intValue());
            }
            if (configuration.c != null) {
                this.mConnection.setConnectTimeout(configuration.c.intValue());
            }
        }
    }

    @Override // com.liulishuo.filedownloader.connection.FileDownloadConnection
    public void addHeader(java.lang.String str, java.lang.String str2) {
        this.mConnection.addRequestProperty(str, str2);
    }

    @Override // com.liulishuo.filedownloader.connection.FileDownloadConnection
    public boolean dispatchAddResumeOffset(java.lang.String str, long j) {
        return false;
    }

    @Override // com.liulishuo.filedownloader.connection.FileDownloadConnection
    public void ending() {
        try {
            this.mConnection.getInputStream().close();
        } catch (java.io.IOException unused) {
        }
    }

    @Override // com.liulishuo.filedownloader.connection.FileDownloadConnection
    public void execute() throws java.io.IOException {
        this.mConnection.connect();
    }

    @Override // com.liulishuo.filedownloader.connection.FileDownloadConnection
    public java.io.InputStream getInputStream() throws java.io.IOException {
        return this.mConnection.getInputStream();
    }

    @Override // com.liulishuo.filedownloader.connection.FileDownloadConnection
    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> getRequestHeaderFields() {
        return this.mConnection.getRequestProperties();
    }

    @Override // com.liulishuo.filedownloader.connection.FileDownloadConnection
    public int getResponseCode() throws java.io.IOException {
        java.net.URLConnection uRLConnection = this.mConnection;
        if (uRLConnection instanceof java.net.HttpURLConnection) {
            return ((java.net.HttpURLConnection) uRLConnection).getResponseCode();
        }
        return 0;
    }

    @Override // com.liulishuo.filedownloader.connection.FileDownloadConnection
    public java.lang.String getResponseHeaderField(java.lang.String str) {
        return this.mConnection.getHeaderField(str);
    }

    @Override // com.liulishuo.filedownloader.connection.FileDownloadConnection
    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> getResponseHeaderFields() {
        return this.mConnection.getHeaderFields();
    }

    @Override // com.liulishuo.filedownloader.connection.FileDownloadConnection
    public boolean setRequestMethod(java.lang.String str) throws java.net.ProtocolException {
        java.net.URLConnection uRLConnection = this.mConnection;
        if (!(uRLConnection instanceof java.net.HttpURLConnection)) {
            return false;
        }
        ((java.net.HttpURLConnection) uRLConnection).setRequestMethod(str);
        return true;
    }
}
