package okhttp3.internal.platform;

@android.annotation.SuppressLint({"NewApi"})
/* loaded from: classes24.dex */
class Android10Platform extends okhttp3.internal.platform.AndroidPlatform {
    public Android10Platform(java.lang.Class<?> cls) {
        super(cls, null, null, null, null, null);
    }

    @javax.annotation.Nullable
    public static okhttp3.internal.platform.Platform h() {
        if (!okhttp3.internal.platform.Platform.isAndroid()) {
            return null;
        }
        try {
            if (okhttp3.internal.platform.AndroidPlatform.i() >= 29) {
                return new okhttp3.internal.platform.Android10Platform(java.lang.Class.forName("com.android.org.conscrypt.SSLParametersImpl"));
            }
        } catch (java.lang.ReflectiveOperationException unused) {
        }
        return null;
    }

    @Override // okhttp3.internal.platform.AndroidPlatform, okhttp3.internal.platform.Platform
    @android.annotation.SuppressLint({"NewApi"})
    @org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
    public void configureTlsExtensions(javax.net.ssl.SSLSocket sSLSocket, java.lang.String str, java.util.List<okhttp3.Protocol> list) throws java.io.IOException {
        try {
            j(sSLSocket);
            javax.net.ssl.SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            sSLParameters.setApplicationProtocols((java.lang.String[]) okhttp3.internal.platform.Platform.alpnProtocolNames(list).toArray(new java.lang.String[0]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (java.lang.IllegalArgumentException e) {
            throw new java.io.IOException("Android internal error", e);
        }
    }

    @Override // okhttp3.internal.platform.AndroidPlatform, okhttp3.internal.platform.Platform
    @javax.annotation.Nullable
    @org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement
    public java.lang.String getSelectedProtocol(javax.net.ssl.SSLSocket sSLSocket) {
        java.lang.String applicationProtocol;
        applicationProtocol = sSLSocket.getApplicationProtocol();
        if (applicationProtocol == null || applicationProtocol.isEmpty()) {
            return null;
        }
        return applicationProtocol;
    }

    public final void j(javax.net.ssl.SSLSocket sSLSocket) {
        boolean isSupportedSocket;
        isSupportedSocket = android.net.ssl.SSLSockets.isSupportedSocket(sSLSocket);
        if (isSupportedSocket) {
            android.net.ssl.SSLSockets.setUseSessionTickets(sSLSocket, true);
        }
    }
}
