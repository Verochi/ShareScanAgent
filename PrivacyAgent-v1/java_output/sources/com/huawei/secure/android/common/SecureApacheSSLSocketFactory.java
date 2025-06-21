package com.huawei.secure.android.common;

@java.lang.Deprecated
/* loaded from: classes22.dex */
public class SecureApacheSSLSocketFactory extends org.apache.http.conn.ssl.SSLSocketFactory {
    public static final org.apache.http.conn.ssl.X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new org.apache.http.conn.ssl.BrowserCompatHostnameVerifier();
    public static final org.apache.http.conn.ssl.X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = new org.apache.http.conn.ssl.StrictHostnameVerifier();
    public static volatile com.huawei.secure.android.common.SecureApacheSSLSocketFactory c = null;
    public javax.net.ssl.SSLContext a;
    public android.content.Context b;

    public SecureApacheSSLSocketFactory(java.security.KeyStore keyStore, android.content.Context context) throws java.security.NoSuchAlgorithmException, java.security.KeyManagementException, java.security.KeyStoreException, java.security.UnrecoverableKeyException, java.security.cert.CertificateException, java.io.IOException, java.lang.IllegalAccessException {
        super(keyStore);
        this.b = context;
        this.a = com.huawei.secure.android.common.ssl.SSLUtil.setSSLContext();
        this.a.init(null, new javax.net.ssl.X509TrustManager[]{new com.huawei.secure.android.common.SecureX509TrustManager(this.b)}, null);
    }

    @java.lang.Deprecated
    public SecureApacheSSLSocketFactory(java.security.KeyStore keyStore, java.io.InputStream inputStream, java.lang.String str) throws java.security.NoSuchAlgorithmException, java.security.KeyManagementException, java.security.KeyStoreException, java.security.UnrecoverableKeyException, java.security.cert.CertificateException, java.io.IOException {
        super(keyStore);
        this.a = com.huawei.secure.android.common.ssl.SSLUtil.setSSLContext();
        this.a.init(null, new javax.net.ssl.X509TrustManager[]{new com.huawei.secure.android.common.HiCloudX509TrustManager(inputStream, str)}, null);
    }

    @java.lang.Deprecated
    public static com.huawei.secure.android.common.SecureApacheSSLSocketFactory getInstance(java.security.KeyStore keyStore, android.content.Context context) throws java.security.NoSuchAlgorithmException, java.security.KeyManagementException, java.security.KeyStoreException, java.security.UnrecoverableKeyException, java.security.cert.CertificateException, java.io.IOException, java.lang.IllegalAccessException {
        if (c == null) {
            synchronized (com.huawei.secure.android.common.SecureApacheSSLSocketFactory.class) {
                if (c == null) {
                    c = new com.huawei.secure.android.common.SecureApacheSSLSocketFactory(keyStore, context);
                }
            }
        }
        return c;
    }

    public final void a(java.net.Socket socket) {
        javax.net.ssl.SSLSocket sSLSocket = (javax.net.ssl.SSLSocket) socket;
        com.huawei.secure.android.common.ssl.SSLUtil.setEnabledProtocols(sSLSocket);
        com.huawei.secure.android.common.ssl.SSLUtil.setEnableSafeCipherSuites(sSLSocket);
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public java.net.Socket createSocket() throws java.io.IOException {
        java.net.Socket createSocket = this.a.getSocketFactory().createSocket();
        a(createSocket);
        return createSocket;
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public java.net.Socket createSocket(java.net.Socket socket, java.lang.String str, int i, boolean z) throws java.io.IOException {
        java.net.Socket createSocket = this.a.getSocketFactory().createSocket(socket, str, i, z);
        a(createSocket);
        return createSocket;
    }
}
