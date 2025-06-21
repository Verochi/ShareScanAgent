package com.huawei.secure.android.common;

@java.lang.Deprecated
/* loaded from: classes22.dex */
public class SecureSSLSocketFactory extends javax.net.ssl.SSLSocketFactory {
    public static final org.apache.http.conn.ssl.X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new org.apache.http.conn.ssl.BrowserCompatHostnameVerifier();
    public static final org.apache.http.conn.ssl.X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = new org.apache.http.conn.ssl.StrictHostnameVerifier();
    public static volatile com.huawei.secure.android.common.SecureSSLSocketFactory c = null;
    public javax.net.ssl.SSLContext a;
    public android.content.Context b;

    public SecureSSLSocketFactory(android.content.Context context) throws java.io.IOException, java.security.NoSuchAlgorithmException, java.security.cert.CertificateException, java.security.KeyStoreException, java.security.KeyManagementException, java.lang.IllegalAccessException {
        this.a = null;
        this.b = context;
        this.a = com.huawei.secure.android.common.ssl.SSLUtil.setSSLContext();
        this.a.init(null, new javax.net.ssl.X509TrustManager[]{new com.huawei.secure.android.common.SecureX509TrustManager(this.b)}, null);
    }

    @java.lang.Deprecated
    public SecureSSLSocketFactory(java.io.InputStream inputStream, java.lang.String str) throws java.io.IOException, java.security.NoSuchAlgorithmException, java.security.cert.CertificateException, java.security.KeyStoreException, java.security.KeyManagementException {
        this.a = null;
        this.a = com.huawei.secure.android.common.ssl.SSLUtil.setSSLContext();
        this.a.init(null, new javax.net.ssl.X509TrustManager[]{new com.huawei.secure.android.common.HiCloudX509TrustManager(inputStream, str)}, null);
    }

    @java.lang.Deprecated
    public static com.huawei.secure.android.common.SecureSSLSocketFactory getInstance(android.content.Context context) throws java.io.IOException, java.security.NoSuchAlgorithmException, java.security.cert.CertificateException, java.security.KeyStoreException, java.lang.IllegalAccessException, java.security.KeyManagementException {
        if (c == null) {
            synchronized (com.huawei.secure.android.common.SecureSSLSocketFactory.class) {
                if (c == null) {
                    c = new com.huawei.secure.android.common.SecureSSLSocketFactory(context);
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

    @Override // javax.net.SocketFactory
    public java.net.Socket createSocket(java.lang.String str, int i) throws java.io.IOException, java.net.UnknownHostException {
        java.net.Socket createSocket = this.a.getSocketFactory().createSocket(str, i);
        if (createSocket instanceof javax.net.ssl.SSLSocket) {
            a(createSocket);
        }
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public java.net.Socket createSocket(java.lang.String str, int i, java.net.InetAddress inetAddress, int i2) throws java.io.IOException, java.net.UnknownHostException {
        return createSocket(str, i);
    }

    @Override // javax.net.SocketFactory
    public java.net.Socket createSocket(java.net.InetAddress inetAddress, int i) throws java.io.IOException {
        return createSocket(inetAddress.getHostAddress(), i);
    }

    @Override // javax.net.SocketFactory
    public java.net.Socket createSocket(java.net.InetAddress inetAddress, int i, java.net.InetAddress inetAddress2, int i2) throws java.io.IOException {
        return createSocket(inetAddress.getHostAddress(), i);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public java.net.Socket createSocket(java.net.Socket socket, java.lang.String str, int i, boolean z) throws java.io.IOException {
        java.net.Socket createSocket = this.a.getSocketFactory().createSocket(socket, str, i, z);
        if (createSocket instanceof javax.net.ssl.SSLSocket) {
            a(createSocket);
        }
        return createSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public java.lang.String[] getDefaultCipherSuites() {
        return new java.lang.String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public java.lang.String[] getSupportedCipherSuites() {
        return new java.lang.String[0];
    }
}
