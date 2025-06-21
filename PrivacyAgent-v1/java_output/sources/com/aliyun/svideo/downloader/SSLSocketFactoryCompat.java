package com.aliyun.svideo.downloader;

/* loaded from: classes.dex */
public class SSLSocketFactoryCompat extends javax.net.ssl.SSLSocketFactory {
    private static final java.lang.String[] TLS_V12_ONLY = {"TLSv1.2"};
    private final javax.net.ssl.SSLSocketFactory delegate;

    public SSLSocketFactoryCompat() throws java.security.KeyManagementException, java.security.NoSuchAlgorithmException {
        javax.net.ssl.SSLContext sSLContext = javax.net.ssl.SSLContext.getInstance("TLS");
        sSLContext.init(null, null, null);
        this.delegate = sSLContext.getSocketFactory();
    }

    public SSLSocketFactoryCompat(javax.net.ssl.SSLSocketFactory sSLSocketFactory) {
        sSLSocketFactory.getClass();
        this.delegate = sSLSocketFactory;
    }

    private java.net.Socket enableTls12(java.net.Socket socket) {
        return socket;
    }

    @Override // javax.net.SocketFactory
    public java.net.Socket createSocket(java.lang.String str, int i) throws java.io.IOException {
        return enableTls12(this.delegate.createSocket(str, i));
    }

    @Override // javax.net.SocketFactory
    public java.net.Socket createSocket(java.lang.String str, int i, java.net.InetAddress inetAddress, int i2) throws java.io.IOException {
        return enableTls12(this.delegate.createSocket(str, i, inetAddress, i2));
    }

    @Override // javax.net.SocketFactory
    public java.net.Socket createSocket(java.net.InetAddress inetAddress, int i) throws java.io.IOException {
        return enableTls12(this.delegate.createSocket(inetAddress, i));
    }

    @Override // javax.net.SocketFactory
    public java.net.Socket createSocket(java.net.InetAddress inetAddress, int i, java.net.InetAddress inetAddress2, int i2) throws java.io.IOException {
        return enableTls12(this.delegate.createSocket(inetAddress, i, inetAddress2, i2));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public java.net.Socket createSocket(java.net.Socket socket, java.lang.String str, int i, boolean z) throws java.io.IOException {
        return enableTls12(this.delegate.createSocket(socket, str, i, z));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public java.lang.String[] getDefaultCipherSuites() {
        return this.delegate.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public java.lang.String[] getSupportedCipherSuites() {
        return this.delegate.getSupportedCipherSuites();
    }
}
