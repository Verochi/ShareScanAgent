package okhttp3.internal.platform;

/* loaded from: classes24.dex */
public class ConscryptPlatform extends okhttp3.internal.platform.Platform {
    public static okhttp3.internal.platform.ConscryptPlatform buildIfSupported() {
        try {
            java.lang.Class.forName("org.conscrypt.Conscrypt");
            if (org.conscrypt.Conscrypt.isAvailable()) {
                return new okhttp3.internal.platform.ConscryptPlatform();
            }
            return null;
        } catch (java.lang.ClassNotFoundException unused) {
            return null;
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureSslSocketFactory(javax.net.ssl.SSLSocketFactory sSLSocketFactory) {
        if (org.conscrypt.Conscrypt.isConscrypt(sSLSocketFactory)) {
            org.conscrypt.Conscrypt.setUseEngineSocket(sSLSocketFactory, true);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(javax.net.ssl.SSLSocket sSLSocket, java.lang.String str, java.util.List<okhttp3.Protocol> list) throws java.io.IOException {
        if (!org.conscrypt.Conscrypt.isConscrypt(sSLSocket)) {
            super.configureTlsExtensions(sSLSocket, str, list);
            return;
        }
        if (str != null) {
            org.conscrypt.Conscrypt.setUseSessionTickets(sSLSocket, true);
            org.conscrypt.Conscrypt.setHostname(sSLSocket, str);
        }
        org.conscrypt.Conscrypt.setApplicationProtocols(sSLSocket, (java.lang.String[]) okhttp3.internal.platform.Platform.alpnProtocolNames(list).toArray(new java.lang.String[0]));
    }

    public final java.security.Provider f() {
        return org.conscrypt.Conscrypt.newProviderBuilder().provideTrustManager().build();
    }

    @Override // okhttp3.internal.platform.Platform
    public javax.net.ssl.SSLContext getSSLContext() {
        try {
            return javax.net.ssl.SSLContext.getInstance("TLSv1.3", f());
        } catch (java.security.NoSuchAlgorithmException e) {
            try {
                return javax.net.ssl.SSLContext.getInstance("TLS", f());
            } catch (java.security.NoSuchAlgorithmException unused) {
                throw new java.lang.IllegalStateException("No TLS provider", e);
            }
        }
    }

    @Override // okhttp3.internal.platform.Platform
    @javax.annotation.Nullable
    public java.lang.String getSelectedProtocol(javax.net.ssl.SSLSocket sSLSocket) {
        return org.conscrypt.Conscrypt.isConscrypt(sSLSocket) ? org.conscrypt.Conscrypt.getApplicationProtocol(sSLSocket) : super.getSelectedProtocol(sSLSocket);
    }

    @Override // okhttp3.internal.platform.Platform
    @javax.annotation.Nullable
    public javax.net.ssl.X509TrustManager trustManager(javax.net.ssl.SSLSocketFactory sSLSocketFactory) {
        if (!org.conscrypt.Conscrypt.isConscrypt(sSLSocketFactory)) {
            return super.trustManager(sSLSocketFactory);
        }
        try {
            java.lang.Object e = okhttp3.internal.platform.Platform.e(sSLSocketFactory, java.lang.Object.class, "sslParameters");
            if (e != null) {
                return (javax.net.ssl.X509TrustManager) okhttp3.internal.platform.Platform.e(e, javax.net.ssl.X509TrustManager.class, "x509TrustManager");
            }
            return null;
        } catch (java.lang.Exception e2) {
            throw new java.lang.UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on Conscrypt", e2);
        }
    }
}
