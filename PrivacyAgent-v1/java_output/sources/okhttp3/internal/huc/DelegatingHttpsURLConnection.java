package okhttp3.internal.huc;

/* loaded from: classes24.dex */
abstract class DelegatingHttpsURLConnection extends javax.net.ssl.HttpsURLConnection {
    public final java.net.HttpURLConnection a;

    public DelegatingHttpsURLConnection(java.net.HttpURLConnection httpURLConnection) {
        super(httpURLConnection.getURL());
        this.a = httpURLConnection;
    }

    @Override // java.net.URLConnection
    public void addRequestProperty(java.lang.String str, java.lang.String str2) {
        this.a.addRequestProperty(str, str2);
    }

    @Override // java.net.URLConnection
    public void connect() throws java.io.IOException {
        ((javax.net.ssl.HttpsURLConnection) this).connected = true;
        this.a.connect();
    }

    @Override // java.net.HttpURLConnection
    public void disconnect() {
        this.a.disconnect();
    }

    @Override // java.net.URLConnection
    public boolean getAllowUserInteraction() {
        return this.a.getAllowUserInteraction();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public java.lang.String getCipherSuite() {
        okhttp3.Handshake handshake = handshake();
        if (handshake != null) {
            return handshake.cipherSuite().javaName();
        }
        return null;
    }

    @Override // java.net.URLConnection
    public int getConnectTimeout() {
        return this.a.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public java.lang.Object getContent() throws java.io.IOException {
        return this.a.getContent();
    }

    @Override // java.net.URLConnection
    public java.lang.Object getContent(java.lang.Class[] clsArr) throws java.io.IOException {
        return this.a.getContent(clsArr);
    }

    @Override // java.net.URLConnection
    public java.lang.String getContentEncoding() {
        return this.a.getContentEncoding();
    }

    @Override // java.net.URLConnection
    public int getContentLength() {
        return this.a.getContentLength();
    }

    @Override // java.net.URLConnection
    @org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
    public long getContentLengthLong() {
        long contentLengthLong;
        contentLengthLong = this.a.getContentLengthLong();
        return contentLengthLong;
    }

    @Override // java.net.URLConnection
    public java.lang.String getContentType() {
        return this.a.getContentType();
    }

    @Override // java.net.URLConnection
    public long getDate() {
        return this.a.getDate();
    }

    @Override // java.net.URLConnection
    public boolean getDefaultUseCaches() {
        return this.a.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public boolean getDoInput() {
        return this.a.getDoInput();
    }

    @Override // java.net.URLConnection
    public boolean getDoOutput() {
        return this.a.getDoOutput();
    }

    @Override // java.net.HttpURLConnection
    public java.io.InputStream getErrorStream() {
        return this.a.getErrorStream();
    }

    @Override // java.net.URLConnection
    public long getExpiration() {
        return this.a.getExpiration();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public java.lang.String getHeaderField(int i) {
        return this.a.getHeaderField(i);
    }

    @Override // java.net.URLConnection
    public java.lang.String getHeaderField(java.lang.String str) {
        return this.a.getHeaderField(str);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public long getHeaderFieldDate(java.lang.String str, long j) {
        return this.a.getHeaderFieldDate(str, j);
    }

    @Override // java.net.URLConnection
    public int getHeaderFieldInt(java.lang.String str, int i) {
        return this.a.getHeaderFieldInt(str, i);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public java.lang.String getHeaderFieldKey(int i) {
        return this.a.getHeaderFieldKey(i);
    }

    @Override // java.net.URLConnection
    @org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
    public long getHeaderFieldLong(java.lang.String str, long j) {
        long headerFieldLong;
        headerFieldLong = this.a.getHeaderFieldLong(str, j);
        return headerFieldLong;
    }

    @Override // java.net.URLConnection
    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> getHeaderFields() {
        return this.a.getHeaderFields();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public abstract javax.net.ssl.HostnameVerifier getHostnameVerifier();

    @Override // java.net.URLConnection
    public long getIfModifiedSince() {
        return this.a.getIfModifiedSince();
    }

    @Override // java.net.URLConnection
    public java.io.InputStream getInputStream() throws java.io.IOException {
        return this.a.getInputStream();
    }

    @Override // java.net.HttpURLConnection
    public boolean getInstanceFollowRedirects() {
        return this.a.getInstanceFollowRedirects();
    }

    @Override // java.net.URLConnection
    public long getLastModified() {
        return this.a.getLastModified();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public java.security.cert.Certificate[] getLocalCertificates() {
        okhttp3.Handshake handshake = handshake();
        if (handshake == null) {
            return null;
        }
        java.util.List<java.security.cert.Certificate> localCertificates = handshake.localCertificates();
        if (localCertificates.isEmpty()) {
            return null;
        }
        return (java.security.cert.Certificate[]) localCertificates.toArray(new java.security.cert.Certificate[localCertificates.size()]);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public java.security.Principal getLocalPrincipal() {
        okhttp3.Handshake handshake = handshake();
        if (handshake != null) {
            return handshake.localPrincipal();
        }
        return null;
    }

    @Override // java.net.URLConnection
    public java.io.OutputStream getOutputStream() throws java.io.IOException {
        return this.a.getOutputStream();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public java.security.Principal getPeerPrincipal() throws javax.net.ssl.SSLPeerUnverifiedException {
        okhttp3.Handshake handshake = handshake();
        if (handshake != null) {
            return handshake.peerPrincipal();
        }
        return null;
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public java.security.Permission getPermission() throws java.io.IOException {
        return this.a.getPermission();
    }

    @Override // java.net.URLConnection
    public int getReadTimeout() {
        return this.a.getReadTimeout();
    }

    @Override // java.net.HttpURLConnection
    public java.lang.String getRequestMethod() {
        return this.a.getRequestMethod();
    }

    @Override // java.net.URLConnection
    public java.util.Map<java.lang.String, java.util.List<java.lang.String>> getRequestProperties() {
        return this.a.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public java.lang.String getRequestProperty(java.lang.String str) {
        return this.a.getRequestProperty(str);
    }

    @Override // java.net.HttpURLConnection
    public int getResponseCode() throws java.io.IOException {
        return this.a.getResponseCode();
    }

    @Override // java.net.HttpURLConnection
    public java.lang.String getResponseMessage() throws java.io.IOException {
        return this.a.getResponseMessage();
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public abstract javax.net.ssl.SSLSocketFactory getSSLSocketFactory();

    @Override // javax.net.ssl.HttpsURLConnection
    public java.security.cert.Certificate[] getServerCertificates() throws javax.net.ssl.SSLPeerUnverifiedException {
        okhttp3.Handshake handshake = handshake();
        if (handshake == null) {
            return null;
        }
        java.util.List<java.security.cert.Certificate> peerCertificates = handshake.peerCertificates();
        if (peerCertificates.isEmpty()) {
            return null;
        }
        return (java.security.cert.Certificate[]) peerCertificates.toArray(new java.security.cert.Certificate[peerCertificates.size()]);
    }

    @Override // java.net.URLConnection
    public java.net.URL getURL() {
        return this.a.getURL();
    }

    @Override // java.net.URLConnection
    public boolean getUseCaches() {
        return this.a.getUseCaches();
    }

    public abstract okhttp3.Handshake handshake();

    @Override // java.net.URLConnection
    public void setAllowUserInteraction(boolean z) {
        this.a.setAllowUserInteraction(z);
    }

    @Override // java.net.HttpURLConnection
    public void setChunkedStreamingMode(int i) {
        this.a.setChunkedStreamingMode(i);
    }

    @Override // java.net.URLConnection
    public void setConnectTimeout(int i) {
        this.a.setConnectTimeout(i);
    }

    @Override // java.net.URLConnection
    public void setDefaultUseCaches(boolean z) {
        this.a.setDefaultUseCaches(z);
    }

    @Override // java.net.URLConnection
    public void setDoInput(boolean z) {
        this.a.setDoInput(z);
    }

    @Override // java.net.URLConnection
    public void setDoOutput(boolean z) {
        this.a.setDoOutput(z);
    }

    @Override // java.net.HttpURLConnection
    public void setFixedLengthStreamingMode(int i) {
        this.a.setFixedLengthStreamingMode(i);
    }

    @Override // java.net.HttpURLConnection
    @org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
    public void setFixedLengthStreamingMode(long j) {
        this.a.setFixedLengthStreamingMode(j);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public abstract void setHostnameVerifier(javax.net.ssl.HostnameVerifier hostnameVerifier);

    @Override // java.net.URLConnection
    public void setIfModifiedSince(long j) {
        this.a.setIfModifiedSince(j);
    }

    @Override // java.net.HttpURLConnection
    public void setInstanceFollowRedirects(boolean z) {
        this.a.setInstanceFollowRedirects(z);
    }

    @Override // java.net.URLConnection
    public void setReadTimeout(int i) {
        this.a.setReadTimeout(i);
    }

    @Override // java.net.HttpURLConnection
    public void setRequestMethod(java.lang.String str) throws java.net.ProtocolException {
        this.a.setRequestMethod(str);
    }

    @Override // java.net.URLConnection
    public void setRequestProperty(java.lang.String str, java.lang.String str2) {
        this.a.setRequestProperty(str, str2);
    }

    @Override // javax.net.ssl.HttpsURLConnection
    public abstract void setSSLSocketFactory(javax.net.ssl.SSLSocketFactory sSLSocketFactory);

    @Override // java.net.URLConnection
    public void setUseCaches(boolean z) {
        this.a.setUseCaches(z);
    }

    @Override // java.net.URLConnection
    public java.lang.String toString() {
        return this.a.toString();
    }

    @Override // java.net.HttpURLConnection
    public boolean usingProxy() {
        return this.a.usingProxy();
    }
}
