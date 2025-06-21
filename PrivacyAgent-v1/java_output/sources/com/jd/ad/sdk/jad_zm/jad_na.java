package com.jd.ad.sdk.jad_zm;

/* loaded from: classes23.dex */
public class jad_na extends javax.net.ssl.SSLSocketFactory {
    public java.lang.String jad_an = "SSLExtensionSocketFactory";
    public javax.net.ssl.SSLSocketFactory jad_bo;

    public jad_na(android.content.Context context) {
        try {
            javax.net.ssl.SSLContext sSLContext = javax.net.ssl.SSLContext.getDefault();
            javax.net.ssl.SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
            this.jad_bo = socketFactory;
            if (socketFactory == null) {
                this.jad_bo = (javax.net.ssl.SSLSocketFactory) javax.net.ssl.SSLSocketFactory.getDefault();
            }
            if (context != null) {
                jad_an(new android.net.SSLSessionCache(context), sSLContext);
            }
        } catch (java.lang.Exception e) {
            e.getMessage();
        }
    }

    @Override // javax.net.SocketFactory
    public java.net.Socket createSocket(java.lang.String str, int i) {
        return jad_an(this.jad_bo.createSocket(str, i));
    }

    @Override // javax.net.SocketFactory
    public java.net.Socket createSocket(java.lang.String str, int i, java.net.InetAddress inetAddress, int i2) {
        return jad_an(this.jad_bo.createSocket(str, i, inetAddress, i2));
    }

    @Override // javax.net.SocketFactory
    public java.net.Socket createSocket(java.net.InetAddress inetAddress, int i) {
        return jad_an(this.jad_bo.createSocket(inetAddress, i));
    }

    @Override // javax.net.SocketFactory
    public java.net.Socket createSocket(java.net.InetAddress inetAddress, int i, java.net.InetAddress inetAddress2, int i2) {
        return jad_an(this.jad_bo.createSocket(inetAddress, i, inetAddress2, i2));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public java.net.Socket createSocket(java.net.Socket socket, java.lang.String str, int i, boolean z) {
        return jad_an(this.jad_bo.createSocket(socket, str, i, z));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public java.lang.String[] getDefaultCipherSuites() {
        return this.jad_bo.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public java.lang.String[] getSupportedCipherSuites() {
        return this.jad_bo.getSupportedCipherSuites();
    }

    public final java.net.Socket jad_an(java.net.Socket socket) {
        if ((socket instanceof javax.net.ssl.SSLSocket) && android.os.Build.VERSION.SDK_INT >= 29) {
            android.net.ssl.SSLSockets.setUseSessionTickets((javax.net.ssl.SSLSocket) socket, true);
        }
        return socket;
    }

    public final void jad_an(android.net.SSLSessionCache sSLSessionCache, javax.net.ssl.SSLContext sSLContext) {
        try {
            java.lang.reflect.Field declaredField = sSLSessionCache.getClass().getDeclaredField("mSessionCache");
            declaredField.setAccessible(true);
            sSLContext.getClientSessionContext().getClass().getMethod("setPersistentCache", java.lang.Class.forName("com.android.org.conscrypt.SSLClientSessionCache")).invoke(sSLContext.getClientSessionContext(), declaredField.get(sSLSessionCache));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
