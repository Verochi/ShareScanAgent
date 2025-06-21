package okhttp3.internal.connection;

/* loaded from: classes23.dex */
final class ConnectionSpecSelector {
    public final java.util.List<okhttp3.ConnectionSpec> a;
    public int b = 0;
    public boolean c;
    public boolean d;

    public ConnectionSpecSelector(java.util.List<okhttp3.ConnectionSpec> list) {
        this.a = list;
    }

    public okhttp3.ConnectionSpec a(javax.net.ssl.SSLSocket sSLSocket) throws java.io.IOException {
        okhttp3.ConnectionSpec connectionSpec;
        int i = this.b;
        int size = this.a.size();
        while (true) {
            if (i >= size) {
                connectionSpec = null;
                break;
            }
            connectionSpec = this.a.get(i);
            if (connectionSpec.isCompatible(sSLSocket)) {
                this.b = i + 1;
                break;
            }
            i++;
        }
        if (connectionSpec != null) {
            this.c = c(sSLSocket);
            okhttp3.internal.Internal.instance.apply(connectionSpec, sSLSocket, this.d);
            return connectionSpec;
        }
        throw new java.net.UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.d + ", modes=" + this.a + ", supported protocols=" + java.util.Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public boolean b(java.io.IOException iOException) {
        this.d = true;
        if (!this.c || (iOException instanceof java.net.ProtocolException) || (iOException instanceof java.io.InterruptedIOException)) {
            return false;
        }
        if (((iOException instanceof javax.net.ssl.SSLHandshakeException) && (iOException.getCause() instanceof java.security.cert.CertificateException)) || (iOException instanceof javax.net.ssl.SSLPeerUnverifiedException)) {
            return false;
        }
        return iOException instanceof javax.net.ssl.SSLException;
    }

    public final boolean c(javax.net.ssl.SSLSocket sSLSocket) {
        for (int i = this.b; i < this.a.size(); i++) {
            if (this.a.get(i).isCompatible(sSLSocket)) {
                return true;
            }
        }
        return false;
    }
}
