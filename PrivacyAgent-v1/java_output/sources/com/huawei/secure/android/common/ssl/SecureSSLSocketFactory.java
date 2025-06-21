package com.huawei.secure.android.common.ssl;

@java.lang.Deprecated
/* loaded from: classes22.dex */
public class SecureSSLSocketFactory extends javax.net.ssl.SSLSocketFactory {

    @java.lang.Deprecated
    public static final org.apache.http.conn.ssl.X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new org.apache.http.conn.ssl.BrowserCompatHostnameVerifier();

    @java.lang.Deprecated
    public static final org.apache.http.conn.ssl.X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = new org.apache.http.conn.ssl.StrictHostnameVerifier();
    public static final java.lang.String i = com.huawei.secure.android.common.ssl.SecureSSLSocketFactory.class.getSimpleName();
    public static volatile com.huawei.secure.android.common.ssl.SecureSSLSocketFactory j = null;
    public javax.net.ssl.SSLContext a;
    public javax.net.ssl.SSLSocket b;
    public android.content.Context c;
    public java.lang.String[] d;
    public javax.net.ssl.X509TrustManager e;
    public java.lang.String[] f;
    public java.lang.String[] g;
    public java.lang.String[] h;

    public SecureSSLSocketFactory(android.content.Context context) throws java.security.NoSuchAlgorithmException, java.security.cert.CertificateException, java.security.KeyStoreException, java.io.IOException, java.security.KeyManagementException {
        this.a = null;
        this.b = null;
        if (context == null) {
            com.huawei.secure.android.common.ssl.util.g.b(i, "SecureSSLSocketFactory: context is null");
            return;
        }
        setContext(context);
        setSslContext(com.huawei.secure.android.common.ssl.SSLUtil.setSSLContext());
        com.huawei.secure.android.common.ssl.SecureX509TrustManager secureX509SingleInstance = com.huawei.secure.android.common.ssl.SecureX509SingleInstance.getInstance(context);
        this.e = secureX509SingleInstance;
        this.a.init(null, new javax.net.ssl.X509TrustManager[]{secureX509SingleInstance}, null);
    }

    public SecureSSLSocketFactory(java.io.InputStream inputStream, java.lang.String str) throws java.io.IOException, java.security.NoSuchAlgorithmException, java.security.cert.CertificateException, java.security.KeyStoreException, java.security.KeyManagementException, java.lang.IllegalArgumentException {
        this.a = null;
        this.b = null;
        this.a = com.huawei.secure.android.common.ssl.SSLUtil.setSSLContext();
        com.huawei.secure.android.common.ssl.HiCloudX509TrustManager hiCloudX509TrustManager = new com.huawei.secure.android.common.ssl.HiCloudX509TrustManager(inputStream, str);
        setX509TrustManager(hiCloudX509TrustManager);
        this.a.init(null, new javax.net.ssl.X509TrustManager[]{hiCloudX509TrustManager}, null);
    }

    public SecureSSLSocketFactory(javax.net.ssl.X509TrustManager x509TrustManager) throws java.security.NoSuchAlgorithmException, java.security.KeyManagementException, java.lang.IllegalArgumentException {
        this.a = null;
        this.b = null;
        this.a = com.huawei.secure.android.common.ssl.SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.a.init(null, new javax.net.ssl.X509TrustManager[]{x509TrustManager}, null);
    }

    public static void b(javax.net.ssl.X509TrustManager x509TrustManager) {
        com.huawei.secure.android.common.ssl.util.g.c(i, "ssf update socket factory trust manager");
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        try {
            j = new com.huawei.secure.android.common.ssl.SecureSSLSocketFactory(x509TrustManager);
        } catch (java.security.KeyManagementException unused) {
            com.huawei.secure.android.common.ssl.util.g.b(i, "KeyManagementException");
        } catch (java.security.NoSuchAlgorithmException unused2) {
            com.huawei.secure.android.common.ssl.util.g.b(i, "NoSuchAlgorithmException");
        }
        com.huawei.secure.android.common.ssl.util.g.a(i, "update: cost : " + (java.lang.System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public static com.huawei.secure.android.common.ssl.SecureSSLSocketFactory getInstance(android.content.Context context) throws java.io.IOException, java.security.NoSuchAlgorithmException, java.security.cert.CertificateException, java.security.KeyStoreException, java.lang.IllegalAccessException, java.security.KeyManagementException, java.lang.IllegalArgumentException {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        com.huawei.secure.android.common.ssl.util.c.a(context);
        if (j == null) {
            synchronized (com.huawei.secure.android.common.ssl.SecureSSLSocketFactory.class) {
                if (j == null) {
                    j = new com.huawei.secure.android.common.ssl.SecureSSLSocketFactory(context);
                }
            }
        }
        if (j.c == null && context != null) {
            j.setContext(context);
        }
        com.huawei.secure.android.common.ssl.util.g.a(i, "getInstance: cost : " + (java.lang.System.currentTimeMillis() - currentTimeMillis) + " ms");
        return j;
    }

    public final void a(java.net.Socket socket) {
        boolean z;
        boolean z2 = true;
        if (com.huawei.secure.android.common.ssl.util.a.a(this.h)) {
            z = false;
        } else {
            com.huawei.secure.android.common.ssl.util.g.c(i, "set protocols");
            com.huawei.secure.android.common.ssl.SSLUtil.setEnabledProtocols((javax.net.ssl.SSLSocket) socket, this.h);
            z = true;
        }
        if (com.huawei.secure.android.common.ssl.util.a.a(this.g) && com.huawei.secure.android.common.ssl.util.a.a(this.f)) {
            z2 = false;
        } else {
            com.huawei.secure.android.common.ssl.util.g.c(i, "set white cipher or black cipher");
            javax.net.ssl.SSLSocket sSLSocket = (javax.net.ssl.SSLSocket) socket;
            com.huawei.secure.android.common.ssl.SSLUtil.setEnabledProtocols(sSLSocket);
            if (com.huawei.secure.android.common.ssl.util.a.a(this.g)) {
                com.huawei.secure.android.common.ssl.SSLUtil.setBlackListCipherSuites(sSLSocket, this.f);
            } else {
                com.huawei.secure.android.common.ssl.SSLUtil.setWhiteListCipherSuites(sSLSocket, this.g);
            }
        }
        if (!z) {
            com.huawei.secure.android.common.ssl.util.g.c(i, "set default protocols");
            com.huawei.secure.android.common.ssl.SSLUtil.setEnabledProtocols((javax.net.ssl.SSLSocket) socket);
        }
        if (z2) {
            return;
        }
        com.huawei.secure.android.common.ssl.util.g.c(i, "set default cipher suites");
        com.huawei.secure.android.common.ssl.SSLUtil.setEnableSafeCipherSuites((javax.net.ssl.SSLSocket) socket);
    }

    @Override // javax.net.SocketFactory
    public java.net.Socket createSocket(java.lang.String str, int i2) throws java.io.IOException {
        com.huawei.secure.android.common.ssl.util.g.c(i, "createSocket: host , port");
        java.net.Socket createSocket = this.a.getSocketFactory().createSocket(str, i2);
        if (createSocket instanceof javax.net.ssl.SSLSocket) {
            a(createSocket);
            javax.net.ssl.SSLSocket sSLSocket = (javax.net.ssl.SSLSocket) createSocket;
            this.b = sSLSocket;
            this.d = (java.lang.String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public java.net.Socket createSocket(java.lang.String str, int i2, java.net.InetAddress inetAddress, int i3) throws java.io.IOException, java.net.UnknownHostException {
        return createSocket(str, i2);
    }

    @Override // javax.net.SocketFactory
    public java.net.Socket createSocket(java.net.InetAddress inetAddress, int i2) throws java.io.IOException {
        return createSocket(inetAddress.getHostAddress(), i2);
    }

    @Override // javax.net.SocketFactory
    public java.net.Socket createSocket(java.net.InetAddress inetAddress, int i2, java.net.InetAddress inetAddress2, int i3) throws java.io.IOException {
        return createSocket(inetAddress.getHostAddress(), i2);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public java.net.Socket createSocket(java.net.Socket socket, java.lang.String str, int i2, boolean z) throws java.io.IOException {
        com.huawei.secure.android.common.ssl.util.g.c(i, "createSocket s host port autoClose");
        java.net.Socket createSocket = this.a.getSocketFactory().createSocket(socket, str, i2, z);
        if (createSocket instanceof javax.net.ssl.SSLSocket) {
            a(createSocket);
            javax.net.ssl.SSLSocket sSLSocket = (javax.net.ssl.SSLSocket) createSocket;
            this.b = sSLSocket;
            this.d = (java.lang.String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public java.lang.String[] getBlackCiphers() {
        return this.f;
    }

    public java.security.cert.X509Certificate[] getChain() {
        javax.net.ssl.X509TrustManager x509TrustManager = this.e;
        return x509TrustManager instanceof com.huawei.secure.android.common.ssl.SecureX509TrustManager ? ((com.huawei.secure.android.common.ssl.SecureX509TrustManager) x509TrustManager).getChain() : new java.security.cert.X509Certificate[0];
    }

    public android.content.Context getContext() {
        return this.c;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public java.lang.String[] getDefaultCipherSuites() {
        return new java.lang.String[0];
    }

    public java.lang.String[] getProtocols() {
        return this.h;
    }

    public javax.net.ssl.SSLContext getSslContext() {
        return this.a;
    }

    public javax.net.ssl.SSLSocket getSslSocket() {
        return this.b;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public java.lang.String[] getSupportedCipherSuites() {
        java.lang.String[] strArr = this.d;
        return strArr != null ? strArr : new java.lang.String[0];
    }

    public java.lang.String[] getWhiteCiphers() {
        return this.g;
    }

    public javax.net.ssl.X509TrustManager getX509TrustManager() {
        return this.e;
    }

    public void setBlackCiphers(java.lang.String[] strArr) {
        this.f = strArr;
    }

    public void setContext(android.content.Context context) {
        this.c = context.getApplicationContext();
    }

    public void setProtocols(java.lang.String[] strArr) {
        this.h = strArr;
    }

    public void setSslContext(javax.net.ssl.SSLContext sSLContext) {
        this.a = sSLContext;
    }

    public void setWhiteCiphers(java.lang.String[] strArr) {
        this.g = strArr;
    }

    public void setX509TrustManager(javax.net.ssl.X509TrustManager x509TrustManager) {
        this.e = x509TrustManager;
    }
}
