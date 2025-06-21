package cn.fly.verify;

/* loaded from: classes.dex */
public class v extends javax.net.ssl.SSLSocketFactory {
    private static final java.lang.String[] b = {"TLSv1.2"};
    protected javax.net.ssl.SSLSocketFactory a;
    private java.lang.String c;

    public v(javax.net.ssl.SSLSocketFactory sSLSocketFactory) {
        javax.net.ssl.HttpsURLConnection.getDefaultSSLSocketFactory();
        this.a = sSLSocketFactory;
    }

    private java.net.Socket a(java.net.Socket socket) {
        this.c = socket.getLocalAddress().getHostAddress();
        return socket;
    }

    public java.lang.String a() {
        return this.c;
    }

    @Override // javax.net.SocketFactory
    public java.net.Socket createSocket() throws java.io.IOException {
        return a(this.a.createSocket());
    }

    @Override // javax.net.SocketFactory
    public java.net.Socket createSocket(java.lang.String str, int i) throws java.io.IOException {
        return a(this.a.createSocket(str, i));
    }

    @Override // javax.net.SocketFactory
    public java.net.Socket createSocket(java.lang.String str, int i, java.net.InetAddress inetAddress, int i2) throws java.io.IOException {
        return a(this.a.createSocket(str, i, inetAddress, i2));
    }

    @Override // javax.net.SocketFactory
    public java.net.Socket createSocket(java.net.InetAddress inetAddress, int i) throws java.io.IOException {
        return a(this.a.createSocket(inetAddress, i));
    }

    @Override // javax.net.SocketFactory
    public java.net.Socket createSocket(java.net.InetAddress inetAddress, int i, java.net.InetAddress inetAddress2, int i2) throws java.io.IOException {
        return a(this.a.createSocket(inetAddress, i, inetAddress2, i2));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public java.net.Socket createSocket(java.net.Socket socket, java.lang.String str, int i, boolean z) throws java.io.IOException {
        return a(this.a.createSocket(socket, str, i, z));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public java.lang.String[] getDefaultCipherSuites() {
        return this.a.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public java.lang.String[] getSupportedCipherSuites() {
        return this.a.getSupportedCipherSuites();
    }

    public java.lang.String toString() {
        return "Tls12SocketFactory";
    }
}
