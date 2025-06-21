package okhttp3.internal.platform;

/* loaded from: classes24.dex */
public class Platform {
    public static final int INFO = 4;
    public static final int WARN = 5;
    public static final okhttp3.internal.platform.Platform a = d();
    public static final java.util.logging.Logger b = java.util.logging.Logger.getLogger(okhttp3.OkHttpClient.class.getName());

    public static byte[] a(java.util.List<okhttp3.Protocol> list) {
        okio.Buffer buffer = new okio.Buffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            okhttp3.Protocol protocol = list.get(i);
            if (protocol != okhttp3.Protocol.HTTP_1_0) {
                buffer.writeByte(protocol.toString().length());
                buffer.writeUtf8(protocol.toString());
            }
        }
        return buffer.readByteArray();
    }

    public static java.util.List<java.lang.String> alpnProtocolNames(java.util.List<okhttp3.Protocol> list) {
        java.util.ArrayList arrayList = new java.util.ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            okhttp3.Protocol protocol = list.get(i);
            if (protocol != okhttp3.Protocol.HTTP_1_0) {
                arrayList.add(protocol.toString());
            }
        }
        return arrayList;
    }

    public static okhttp3.internal.platform.Platform b() {
        okhttp3.internal.platform.Platform h = okhttp3.internal.platform.Android10Platform.h();
        if (h != null) {
            return h;
        }
        okhttp3.internal.platform.Platform h2 = okhttp3.internal.platform.AndroidPlatform.h();
        if (h2 != null) {
            return h2;
        }
        throw new java.lang.NullPointerException("No platform found on Android");
    }

    public static okhttp3.internal.platform.Platform c() {
        okhttp3.internal.platform.ConscryptPlatform buildIfSupported;
        if (isConscryptPreferred() && (buildIfSupported = okhttp3.internal.platform.ConscryptPlatform.buildIfSupported()) != null) {
            return buildIfSupported;
        }
        okhttp3.internal.platform.Jdk9Platform f = okhttp3.internal.platform.Jdk9Platform.f();
        if (f != null) {
            return f;
        }
        okhttp3.internal.platform.Platform f2 = okhttp3.internal.platform.Jdk8WithJettyBootPlatform.f();
        return f2 != null ? f2 : new okhttp3.internal.platform.Platform();
    }

    public static okhttp3.internal.platform.Platform d() {
        return isAndroid() ? b() : c();
    }

    @javax.annotation.Nullable
    public static <T> T e(java.lang.Object obj, java.lang.Class<T> cls, java.lang.String str) {
        java.lang.Object e;
        for (java.lang.Class<?> cls2 = obj.getClass(); cls2 != java.lang.Object.class; cls2 = cls2.getSuperclass()) {
            try {
                java.lang.reflect.Field declaredField = cls2.getDeclaredField(str);
                declaredField.setAccessible(true);
                java.lang.Object obj2 = declaredField.get(obj);
                if (cls.isInstance(obj2)) {
                    return cls.cast(obj2);
                }
                return null;
            } catch (java.lang.IllegalAccessException unused) {
                throw new java.lang.AssertionError();
            } catch (java.lang.NoSuchFieldException unused2) {
            }
        }
        if (str.equals("delegate") || (e = e(obj, java.lang.Object.class, "delegate")) == null) {
            return null;
        }
        return (T) e(e, cls, str);
    }

    public static okhttp3.internal.platform.Platform get() {
        return a;
    }

    public static boolean isAndroid() {
        return "Dalvik".equals(java.lang.System.getProperty("java.vm.name"));
    }

    public static boolean isConscryptPreferred() {
        if ("conscrypt".equals(okhttp3.internal.Util.getSystemProperty("okhttp.platform", null))) {
            return true;
        }
        return "Conscrypt".equals(java.security.Security.getProviders()[0].getName());
    }

    public void afterHandshake(javax.net.ssl.SSLSocket sSLSocket) {
    }

    public okhttp3.internal.tls.CertificateChainCleaner buildCertificateChainCleaner(javax.net.ssl.SSLSocketFactory sSLSocketFactory) {
        javax.net.ssl.X509TrustManager trustManager = trustManager(sSLSocketFactory);
        if (trustManager != null) {
            return buildCertificateChainCleaner(trustManager);
        }
        throw new java.lang.IllegalStateException("Unable to extract the trust manager on " + get() + ", sslSocketFactory is " + sSLSocketFactory.getClass());
    }

    public okhttp3.internal.tls.CertificateChainCleaner buildCertificateChainCleaner(javax.net.ssl.X509TrustManager x509TrustManager) {
        return new okhttp3.internal.tls.BasicCertificateChainCleaner(buildTrustRootIndex(x509TrustManager));
    }

    public okhttp3.internal.tls.TrustRootIndex buildTrustRootIndex(javax.net.ssl.X509TrustManager x509TrustManager) {
        return new okhttp3.internal.tls.BasicTrustRootIndex(x509TrustManager.getAcceptedIssuers());
    }

    public void configureSslSocketFactory(javax.net.ssl.SSLSocketFactory sSLSocketFactory) {
    }

    public void configureTlsExtensions(javax.net.ssl.SSLSocket sSLSocket, @javax.annotation.Nullable java.lang.String str, java.util.List<okhttp3.Protocol> list) throws java.io.IOException {
    }

    public void connectSocket(java.net.Socket socket, java.net.InetSocketAddress inetSocketAddress, int i) throws java.io.IOException {
        socket.connect(inetSocketAddress, i);
    }

    public java.lang.String getPrefix() {
        return "OkHttp";
    }

    public javax.net.ssl.SSLContext getSSLContext() {
        try {
            return javax.net.ssl.SSLContext.getInstance("TLS");
        } catch (java.security.NoSuchAlgorithmException e) {
            throw new java.lang.IllegalStateException("No TLS provider", e);
        }
    }

    @javax.annotation.Nullable
    public java.lang.String getSelectedProtocol(javax.net.ssl.SSLSocket sSLSocket) {
        return null;
    }

    @javax.annotation.Nullable
    public java.lang.Object getStackTraceForCloseable(java.lang.String str) {
        if (b.isLoggable(java.util.logging.Level.FINE)) {
            return new java.lang.Throwable(str);
        }
        return null;
    }

    public boolean isCleartextTrafficPermitted(java.lang.String str) {
        return true;
    }

    public void log(int i, java.lang.String str, @javax.annotation.Nullable java.lang.Throwable th) {
        b.log(i == 5 ? java.util.logging.Level.WARNING : java.util.logging.Level.INFO, str, th);
    }

    public void logCloseableLeak(java.lang.String str, java.lang.Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        log(5, str, (java.lang.Throwable) obj);
    }

    public java.lang.String toString() {
        return getClass().getSimpleName();
    }

    @javax.annotation.Nullable
    public javax.net.ssl.X509TrustManager trustManager(javax.net.ssl.SSLSocketFactory sSLSocketFactory) {
        try {
            java.lang.Object e = e(sSLSocketFactory, java.lang.Class.forName("sun.security.ssl.SSLContextImpl"), "context");
            if (e == null) {
                return null;
            }
            return (javax.net.ssl.X509TrustManager) e(e, javax.net.ssl.X509TrustManager.class, "trustManager");
        } catch (java.lang.ClassNotFoundException unused) {
            return null;
        }
    }
}
