package com.tencent.open.utils;

@android.annotation.TargetApi(17)
/* loaded from: classes19.dex */
public class k implements org.apache.http.conn.scheme.LayeredSocketFactory {
    private static final javax.net.ssl.HostnameVerifier a = new org.apache.http.conn.ssl.StrictHostnameVerifier();
    private static final android.net.SSLCertificateSocketFactory b = (android.net.SSLCertificateSocketFactory) android.net.SSLCertificateSocketFactory.getDefault(0, null);

    @Override // org.apache.http.conn.scheme.SocketFactory
    public java.net.Socket connectSocket(java.net.Socket socket, java.lang.String str, int i, java.net.InetAddress inetAddress, int i2, org.apache.http.params.HttpParams httpParams) throws java.io.IOException {
        socket.connect(new java.net.InetSocketAddress(str, i));
        return socket;
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    public java.net.Socket createSocket() {
        return new java.net.Socket();
    }

    @Override // org.apache.http.conn.scheme.LayeredSocketFactory
    public java.net.Socket createSocket(java.net.Socket socket, java.lang.String str, int i, boolean z) throws java.io.IOException {
        com.tencent.open.log.SLog.v("openSDK_LOG.SNISocketFactory", "createSocket " + socket.toString() + " host:" + str + " port:" + i + " autoClose:" + z);
        java.net.InetAddress inetAddress = socket.getInetAddress();
        if (z) {
            socket.close();
        }
        android.net.SSLCertificateSocketFactory sSLCertificateSocketFactory = b;
        javax.net.ssl.SSLSocket sSLSocket = (javax.net.ssl.SSLSocket) sSLCertificateSocketFactory.createSocket(inetAddress, i);
        sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
        com.tencent.open.log.SLog.v("openSDK_LOG.SNISocketFactory", "Setting SNI hostname");
        sSLCertificateSocketFactory.setHostname(sSLSocket, str);
        if (a.verify(str, sSLSocket.getSession())) {
            return sSLSocket;
        }
        throw new javax.net.ssl.SSLPeerUnverifiedException("Cannot verify hostname: " + str);
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    public boolean isSecure(java.net.Socket socket) throws java.lang.IllegalArgumentException {
        if (socket instanceof javax.net.ssl.SSLSocket) {
            return ((javax.net.ssl.SSLSocket) socket).isConnected();
        }
        return false;
    }
}
