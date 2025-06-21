package okhttp3.internal.huc;

/* loaded from: classes24.dex */
public final class OkHttpsURLConnection extends okhttp3.internal.huc.DelegatingHttpsURLConnection {
    public final okhttp3.internal.huc.OkHttpURLConnection b;

    public OkHttpsURLConnection(java.net.URL url, okhttp3.OkHttpClient okHttpClient) {
        this(new okhttp3.internal.huc.OkHttpURLConnection(url, okHttpClient));
    }

    public OkHttpsURLConnection(java.net.URL url, okhttp3.OkHttpClient okHttpClient, okhttp3.internal.URLFilter uRLFilter) {
        this(new okhttp3.internal.huc.OkHttpURLConnection(url, okHttpClient, uRLFilter));
    }

    public OkHttpsURLConnection(okhttp3.internal.huc.OkHttpURLConnection okHttpURLConnection) {
        super(okHttpURLConnection);
        this.b = okHttpURLConnection;
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ void addRequestProperty(java.lang.String str, java.lang.String str2) {
        super.addRequestProperty(str, str2);
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ void connect() throws java.io.IOException {
        super.connect();
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.HttpURLConnection
    public /* bridge */ /* synthetic */ void disconnect() {
        super.disconnect();
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ boolean getAllowUserInteraction() {
        return super.getAllowUserInteraction();
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, javax.net.ssl.HttpsURLConnection
    public /* bridge */ /* synthetic */ java.lang.String getCipherSuite() {
        return super.getCipherSuite();
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ int getConnectTimeout() {
        return super.getConnectTimeout();
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ java.lang.Object getContent() throws java.io.IOException {
        return super.getContent();
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ java.lang.Object getContent(java.lang.Class[] clsArr) throws java.io.IOException {
        return super.getContent(clsArr);
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ java.lang.String getContentEncoding() {
        return super.getContentEncoding();
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ int getContentLength() {
        return super.getContentLength();
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.URLConnection
    @org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
    public /* bridge */ /* synthetic */ long getContentLengthLong() {
        return super.getContentLengthLong();
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ java.lang.String getContentType() {
        return super.getContentType();
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ long getDate() {
        return super.getDate();
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ boolean getDefaultUseCaches() {
        return super.getDefaultUseCaches();
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ boolean getDoInput() {
        return super.getDoInput();
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ boolean getDoOutput() {
        return super.getDoOutput();
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.HttpURLConnection
    public /* bridge */ /* synthetic */ java.io.InputStream getErrorStream() {
        return super.getErrorStream();
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ long getExpiration() {
        return super.getExpiration();
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.HttpURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ java.lang.String getHeaderField(int i) {
        return super.getHeaderField(i);
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ java.lang.String getHeaderField(java.lang.String str) {
        return super.getHeaderField(str);
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.HttpURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ long getHeaderFieldDate(java.lang.String str, long j) {
        return super.getHeaderFieldDate(str, j);
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ int getHeaderFieldInt(java.lang.String str, int i) {
        return super.getHeaderFieldInt(str, i);
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.HttpURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ java.lang.String getHeaderFieldKey(int i) {
        return super.getHeaderFieldKey(i);
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.URLConnection
    @org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
    public /* bridge */ /* synthetic */ long getHeaderFieldLong(java.lang.String str, long j) {
        return super.getHeaderFieldLong(str, j);
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ java.util.Map getHeaderFields() {
        return super.getHeaderFields();
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, javax.net.ssl.HttpsURLConnection
    public javax.net.ssl.HostnameVerifier getHostnameVerifier() {
        return this.b.n.hostnameVerifier();
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ long getIfModifiedSince() {
        return super.getIfModifiedSince();
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ java.io.InputStream getInputStream() throws java.io.IOException {
        return super.getInputStream();
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.HttpURLConnection
    public /* bridge */ /* synthetic */ boolean getInstanceFollowRedirects() {
        return super.getInstanceFollowRedirects();
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ long getLastModified() {
        return super.getLastModified();
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, javax.net.ssl.HttpsURLConnection
    public /* bridge */ /* synthetic */ java.security.cert.Certificate[] getLocalCertificates() {
        return super.getLocalCertificates();
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, javax.net.ssl.HttpsURLConnection
    public /* bridge */ /* synthetic */ java.security.Principal getLocalPrincipal() {
        return super.getLocalPrincipal();
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ java.io.OutputStream getOutputStream() throws java.io.IOException {
        return super.getOutputStream();
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, javax.net.ssl.HttpsURLConnection
    public /* bridge */ /* synthetic */ java.security.Principal getPeerPrincipal() throws javax.net.ssl.SSLPeerUnverifiedException {
        return super.getPeerPrincipal();
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.HttpURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ java.security.Permission getPermission() throws java.io.IOException {
        return super.getPermission();
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ int getReadTimeout() {
        return super.getReadTimeout();
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.HttpURLConnection
    public /* bridge */ /* synthetic */ java.lang.String getRequestMethod() {
        return super.getRequestMethod();
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ java.util.Map getRequestProperties() {
        return super.getRequestProperties();
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ java.lang.String getRequestProperty(java.lang.String str) {
        return super.getRequestProperty(str);
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.HttpURLConnection
    public /* bridge */ /* synthetic */ int getResponseCode() throws java.io.IOException {
        return super.getResponseCode();
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.HttpURLConnection
    public /* bridge */ /* synthetic */ java.lang.String getResponseMessage() throws java.io.IOException {
        return super.getResponseMessage();
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, javax.net.ssl.HttpsURLConnection
    public javax.net.ssl.SSLSocketFactory getSSLSocketFactory() {
        return this.b.n.sslSocketFactory();
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, javax.net.ssl.HttpsURLConnection
    public /* bridge */ /* synthetic */ java.security.cert.Certificate[] getServerCertificates() throws javax.net.ssl.SSLPeerUnverifiedException {
        return super.getServerCertificates();
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ java.net.URL getURL() {
        return super.getURL();
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ boolean getUseCaches() {
        return super.getUseCaches();
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection
    public okhttp3.Handshake handshake() {
        okhttp3.internal.huc.OkHttpURLConnection okHttpURLConnection = this.b;
        if (okHttpURLConnection.w != null) {
            return okHttpURLConnection.G;
        }
        throw new java.lang.IllegalStateException("Connection has not yet been established");
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ void setAllowUserInteraction(boolean z) {
        super.setAllowUserInteraction(z);
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.HttpURLConnection
    public /* bridge */ /* synthetic */ void setChunkedStreamingMode(int i) {
        super.setChunkedStreamingMode(i);
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ void setConnectTimeout(int i) {
        super.setConnectTimeout(i);
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ void setDefaultUseCaches(boolean z) {
        super.setDefaultUseCaches(z);
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ void setDoInput(boolean z) {
        super.setDoInput(z);
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ void setDoOutput(boolean z) {
        super.setDoOutput(z);
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.HttpURLConnection
    public /* bridge */ /* synthetic */ void setFixedLengthStreamingMode(int i) {
        super.setFixedLengthStreamingMode(i);
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.HttpURLConnection
    @org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
    public /* bridge */ /* synthetic */ void setFixedLengthStreamingMode(long j) {
        super.setFixedLengthStreamingMode(j);
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, javax.net.ssl.HttpsURLConnection
    public void setHostnameVerifier(javax.net.ssl.HostnameVerifier hostnameVerifier) {
        okhttp3.internal.huc.OkHttpURLConnection okHttpURLConnection = this.b;
        okHttpURLConnection.n = okHttpURLConnection.n.newBuilder().hostnameVerifier(hostnameVerifier).build();
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ void setIfModifiedSince(long j) {
        super.setIfModifiedSince(j);
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.HttpURLConnection
    public /* bridge */ /* synthetic */ void setInstanceFollowRedirects(boolean z) {
        super.setInstanceFollowRedirects(z);
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ void setReadTimeout(int i) {
        super.setReadTimeout(i);
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.HttpURLConnection
    public /* bridge */ /* synthetic */ void setRequestMethod(java.lang.String str) throws java.net.ProtocolException {
        super.setRequestMethod(str);
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ void setRequestProperty(java.lang.String str, java.lang.String str2) {
        super.setRequestProperty(str, str2);
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, javax.net.ssl.HttpsURLConnection
    public void setSSLSocketFactory(javax.net.ssl.SSLSocketFactory sSLSocketFactory) {
        if (sSLSocketFactory == null) {
            throw new java.lang.IllegalArgumentException("sslSocketFactory == null");
        }
        okhttp3.internal.huc.OkHttpURLConnection okHttpURLConnection = this.b;
        okHttpURLConnection.n = okHttpURLConnection.n.newBuilder().sslSocketFactory(sSLSocketFactory).build();
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ void setUseCaches(boolean z) {
        super.setUseCaches(z);
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.URLConnection
    public /* bridge */ /* synthetic */ java.lang.String toString() {
        return super.toString();
    }

    @Override // okhttp3.internal.huc.DelegatingHttpsURLConnection, java.net.HttpURLConnection
    public /* bridge */ /* synthetic */ boolean usingProxy() {
        return super.usingProxy();
    }
}
