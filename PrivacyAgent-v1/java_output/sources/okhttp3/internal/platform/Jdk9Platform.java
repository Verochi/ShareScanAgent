package okhttp3.internal.platform;

/* loaded from: classes24.dex */
final class Jdk9Platform extends okhttp3.internal.platform.Platform {
    public final java.lang.reflect.Method c;
    public final java.lang.reflect.Method d;

    public Jdk9Platform(java.lang.reflect.Method method, java.lang.reflect.Method method2) {
        this.c = method;
        this.d = method2;
    }

    public static okhttp3.internal.platform.Jdk9Platform f() {
        try {
            return new okhttp3.internal.platform.Jdk9Platform(javax.net.ssl.SSLParameters.class.getMethod("setApplicationProtocols", java.lang.String[].class), javax.net.ssl.SSLSocket.class.getMethod("getApplicationProtocol", new java.lang.Class[0]));
        } catch (java.lang.NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(javax.net.ssl.SSLSocket sSLSocket, java.lang.String str, java.util.List<okhttp3.Protocol> list) {
        try {
            javax.net.ssl.SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            java.util.List<java.lang.String> alpnProtocolNames = okhttp3.internal.platform.Platform.alpnProtocolNames(list);
            this.c.invoke(sSLParameters, alpnProtocolNames.toArray(new java.lang.String[alpnProtocolNames.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException e) {
            throw new java.lang.AssertionError("failed to set SSL parameters", e);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    @javax.annotation.Nullable
    public java.lang.String getSelectedProtocol(javax.net.ssl.SSLSocket sSLSocket) {
        try {
            java.lang.String str = (java.lang.String) this.d.invoke(sSLSocket, new java.lang.Object[0]);
            if (str != null) {
                if (!str.equals("")) {
                    return str;
                }
            }
            return null;
        } catch (java.lang.IllegalAccessException e) {
            throw new java.lang.AssertionError("failed to get ALPN selected protocol", e);
        } catch (java.lang.reflect.InvocationTargetException e2) {
            if (e2.getCause() instanceof java.lang.UnsupportedOperationException) {
                return null;
            }
            throw new java.lang.AssertionError("failed to get ALPN selected protocol", e2);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public javax.net.ssl.X509TrustManager trustManager(javax.net.ssl.SSLSocketFactory sSLSocketFactory) {
        throw new java.lang.UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
    }
}
