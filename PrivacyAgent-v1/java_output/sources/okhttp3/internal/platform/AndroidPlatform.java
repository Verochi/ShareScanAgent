package okhttp3.internal.platform;

/* loaded from: classes24.dex */
class AndroidPlatform extends okhttp3.internal.platform.Platform {
    public final java.lang.Class<?> c;
    public final java.lang.Class<?> d;
    public final java.lang.reflect.Method e;
    public final java.lang.reflect.Method f;
    public final java.lang.reflect.Method g;
    public final java.lang.reflect.Method h;
    public final okhttp3.internal.platform.AndroidPlatform.CloseGuard i = okhttp3.internal.platform.AndroidPlatform.CloseGuard.b();

    public static final class AndroidCertificateChainCleaner extends okhttp3.internal.tls.CertificateChainCleaner {
        public final java.lang.Object a;
        public final java.lang.reflect.Method b;

        public AndroidCertificateChainCleaner(java.lang.Object obj, java.lang.reflect.Method method) {
            this.a = obj;
            this.b = method;
        }

        @Override // okhttp3.internal.tls.CertificateChainCleaner
        public java.util.List<java.security.cert.Certificate> clean(java.util.List<java.security.cert.Certificate> list, java.lang.String str) throws javax.net.ssl.SSLPeerUnverifiedException {
            try {
                return (java.util.List) this.b.invoke(this.a, (java.security.cert.X509Certificate[]) list.toArray(new java.security.cert.X509Certificate[list.size()]), com.alipay.sdk.m.n.d.a, str);
            } catch (java.lang.IllegalAccessException e) {
                throw new java.lang.AssertionError(e);
            } catch (java.lang.reflect.InvocationTargetException e2) {
                javax.net.ssl.SSLPeerUnverifiedException sSLPeerUnverifiedException = new javax.net.ssl.SSLPeerUnverifiedException(e2.getMessage());
                sSLPeerUnverifiedException.initCause(e2);
                throw sSLPeerUnverifiedException;
            }
        }

        public boolean equals(java.lang.Object obj) {
            return obj instanceof okhttp3.internal.platform.AndroidPlatform.AndroidCertificateChainCleaner;
        }

        public int hashCode() {
            return 0;
        }
    }

    public static final class CloseGuard {
        public final java.lang.reflect.Method a;
        public final java.lang.reflect.Method b;
        public final java.lang.reflect.Method c;

        public CloseGuard(java.lang.reflect.Method method, java.lang.reflect.Method method2, java.lang.reflect.Method method3) {
            this.a = method;
            this.b = method2;
            this.c = method3;
        }

        public static okhttp3.internal.platform.AndroidPlatform.CloseGuard b() {
            java.lang.reflect.Method method;
            java.lang.reflect.Method method2;
            java.lang.reflect.Method method3;
            try {
                java.lang.Class<?> cls = java.lang.Class.forName("dalvik.system.CloseGuard");
                method = cls.getMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, new java.lang.Class[0]);
                method3 = cls.getMethod(com.igexin.sdk.PushBuildConfig.sdk_conf_channelid, java.lang.String.class);
                method2 = cls.getMethod("warnIfOpen", new java.lang.Class[0]);
            } catch (java.lang.Exception unused) {
                method = null;
                method2 = null;
                method3 = null;
            }
            return new okhttp3.internal.platform.AndroidPlatform.CloseGuard(method, method3, method2);
        }

        public java.lang.Object a(java.lang.String str) {
            java.lang.reflect.Method method = this.a;
            if (method != null) {
                try {
                    java.lang.Object invoke = method.invoke(null, new java.lang.Object[0]);
                    this.b.invoke(invoke, str);
                    return invoke;
                } catch (java.lang.Exception unused) {
                }
            }
            return null;
        }

        public boolean c(java.lang.Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                this.c.invoke(obj, new java.lang.Object[0]);
                return true;
            } catch (java.lang.Exception unused) {
                return false;
            }
        }
    }

    public static final class CustomTrustRootIndex implements okhttp3.internal.tls.TrustRootIndex {
        public final javax.net.ssl.X509TrustManager a;
        public final java.lang.reflect.Method b;

        public CustomTrustRootIndex(javax.net.ssl.X509TrustManager x509TrustManager, java.lang.reflect.Method method) {
            this.b = method;
            this.a = x509TrustManager;
        }

        public boolean equals(java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof okhttp3.internal.platform.AndroidPlatform.CustomTrustRootIndex)) {
                return false;
            }
            okhttp3.internal.platform.AndroidPlatform.CustomTrustRootIndex customTrustRootIndex = (okhttp3.internal.platform.AndroidPlatform.CustomTrustRootIndex) obj;
            return this.a.equals(customTrustRootIndex.a) && this.b.equals(customTrustRootIndex.b);
        }

        @Override // okhttp3.internal.tls.TrustRootIndex
        public java.security.cert.X509Certificate findByIssuerAndSignature(java.security.cert.X509Certificate x509Certificate) {
            try {
                java.security.cert.TrustAnchor trustAnchor = (java.security.cert.TrustAnchor) this.b.invoke(this.a, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
                return null;
            } catch (java.lang.IllegalAccessException e) {
                throw new java.lang.AssertionError("unable to get issues and signature", e);
            } catch (java.lang.reflect.InvocationTargetException unused) {
                return null;
            }
        }

        public int hashCode() {
            return this.a.hashCode() + (this.b.hashCode() * 31);
        }
    }

    public AndroidPlatform(java.lang.Class<?> cls, java.lang.Class<?> cls2, java.lang.reflect.Method method, java.lang.reflect.Method method2, java.lang.reflect.Method method3, java.lang.reflect.Method method4) {
        this.c = cls;
        this.d = cls2;
        this.e = method;
        this.f = method2;
        this.g = method3;
        this.h = method4;
    }

    @javax.annotation.Nullable
    public static okhttp3.internal.platform.Platform h() {
        if (!okhttp3.internal.platform.Platform.isAndroid()) {
            return null;
        }
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            java.lang.Class<?> cls2 = java.lang.Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl");
            try {
                return new okhttp3.internal.platform.AndroidPlatform(cls, cls2, cls2.getDeclaredMethod("setUseSessionTickets", java.lang.Boolean.TYPE), cls2.getMethod("setHostname", java.lang.String.class), cls2.getMethod("getAlpnSelectedProtocol", new java.lang.Class[0]), cls2.getMethod("setAlpnProtocols", byte[].class));
            } catch (java.lang.NoSuchMethodException unused) {
                throw new java.lang.IllegalStateException("Expected Android API level 21+ but was " + android.os.Build.VERSION.SDK_INT);
            }
        } catch (java.lang.ClassNotFoundException unused2) {
            return null;
        }
    }

    public static int i() {
        try {
            return android.os.Build.VERSION.SDK_INT;
        } catch (java.lang.NoClassDefFoundError unused) {
            return 0;
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public okhttp3.internal.tls.CertificateChainCleaner buildCertificateChainCleaner(javax.net.ssl.X509TrustManager x509TrustManager) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.net.http.X509TrustManagerExtensions");
            return new okhttp3.internal.platform.AndroidPlatform.AndroidCertificateChainCleaner(cls.getConstructor(javax.net.ssl.X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", java.security.cert.X509Certificate[].class, java.lang.String.class, java.lang.String.class));
        } catch (java.lang.Exception unused) {
            return super.buildCertificateChainCleaner(x509TrustManager);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public okhttp3.internal.tls.TrustRootIndex buildTrustRootIndex(javax.net.ssl.X509TrustManager x509TrustManager) {
        try {
            java.lang.reflect.Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", java.security.cert.X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new okhttp3.internal.platform.AndroidPlatform.CustomTrustRootIndex(x509TrustManager, declaredMethod);
        } catch (java.lang.NoSuchMethodException unused) {
            return super.buildTrustRootIndex(x509TrustManager);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(javax.net.ssl.SSLSocket sSLSocket, java.lang.String str, java.util.List<okhttp3.Protocol> list) throws java.io.IOException {
        if (this.d.isInstance(sSLSocket)) {
            if (str != null) {
                try {
                    this.e.invoke(sSLSocket, java.lang.Boolean.TRUE);
                    this.f.invoke(sSLSocket, str);
                } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException e) {
                    throw new java.lang.AssertionError(e);
                }
            }
            this.h.invoke(sSLSocket, okhttp3.internal.platform.Platform.a(list));
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public void connectSocket(java.net.Socket socket, java.net.InetSocketAddress inetSocketAddress, int i) throws java.io.IOException {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (java.lang.AssertionError e) {
            if (!okhttp3.internal.Util.isAndroidGetsocknameError(e)) {
                throw e;
            }
            throw new java.io.IOException(e);
        } catch (java.lang.ClassCastException e2) {
            if (android.os.Build.VERSION.SDK_INT != 26) {
                throw e2;
            }
            throw new java.io.IOException("Exception in connect", e2);
        }
    }

    public final boolean f(java.lang.String str, java.lang.Class<?> cls, java.lang.Object obj) throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException {
        try {
            return ((java.lang.Boolean) cls.getMethod("isCleartextTrafficPermitted", new java.lang.Class[0]).invoke(obj, new java.lang.Object[0])).booleanValue();
        } catch (java.lang.NoSuchMethodException unused) {
            return super.isCleartextTrafficPermitted(str);
        }
    }

    public final boolean g(java.lang.String str, java.lang.Class<?> cls, java.lang.Object obj) throws java.lang.reflect.InvocationTargetException, java.lang.IllegalAccessException {
        try {
            return ((java.lang.Boolean) cls.getMethod("isCleartextTrafficPermitted", java.lang.String.class).invoke(obj, str)).booleanValue();
        } catch (java.lang.NoSuchMethodException unused) {
            return f(str, cls, obj);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public javax.net.ssl.SSLContext getSSLContext() {
        boolean z = true;
        try {
            if (android.os.Build.VERSION.SDK_INT >= 22) {
                z = false;
            }
        } catch (java.lang.NoClassDefFoundError unused) {
        }
        if (z) {
            try {
                return javax.net.ssl.SSLContext.getInstance("TLSv1.2");
            } catch (java.security.NoSuchAlgorithmException unused2) {
            }
        }
        try {
            return javax.net.ssl.SSLContext.getInstance("TLS");
        } catch (java.security.NoSuchAlgorithmException e) {
            throw new java.lang.IllegalStateException("No TLS provider", e);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    @javax.annotation.Nullable
    public java.lang.String getSelectedProtocol(javax.net.ssl.SSLSocket sSLSocket) {
        if (!this.d.isInstance(sSLSocket)) {
            return null;
        }
        try {
            byte[] bArr = (byte[]) this.g.invoke(sSLSocket, new java.lang.Object[0]);
            if (bArr != null) {
                return new java.lang.String(bArr, java.nio.charset.StandardCharsets.UTF_8);
            }
            return null;
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException e) {
            throw new java.lang.AssertionError(e);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    @javax.annotation.Nullable
    public java.lang.Object getStackTraceForCloseable(java.lang.String str) {
        return this.i.a(str);
    }

    @Override // okhttp3.internal.platform.Platform
    public boolean isCleartextTrafficPermitted(java.lang.String str) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.security.NetworkSecurityPolicy");
            return g(str, cls, cls.getMethod("getInstance", new java.lang.Class[0]).invoke(null, new java.lang.Object[0]));
        } catch (java.lang.ClassNotFoundException | java.lang.NoSuchMethodException unused) {
            return super.isCleartextTrafficPermitted(str);
        } catch (java.lang.IllegalAccessException e) {
            e = e;
            throw new java.lang.AssertionError("unable to determine cleartext support", e);
        } catch (java.lang.IllegalArgumentException e2) {
            e = e2;
            throw new java.lang.AssertionError("unable to determine cleartext support", e);
        } catch (java.lang.reflect.InvocationTargetException e3) {
            e = e3;
            throw new java.lang.AssertionError("unable to determine cleartext support", e);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public void log(int i, java.lang.String str, @javax.annotation.Nullable java.lang.Throwable th) {
        int min;
        int i2 = i != 5 ? 3 : 5;
        if (th != null) {
            str = str + '\n' + android.util.Log.getStackTraceString(th);
        }
        int length = str.length();
        int i3 = 0;
        while (i3 < length) {
            int indexOf = str.indexOf(10, i3);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = java.lang.Math.min(indexOf, i3 + 4000);
                android.util.Log.println(i2, "OkHttp", str.substring(i3, min));
                if (min >= indexOf) {
                    break;
                } else {
                    i3 = min;
                }
            }
            i3 = min + 1;
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public void logCloseableLeak(java.lang.String str, java.lang.Object obj) {
        if (this.i.c(obj)) {
            return;
        }
        log(5, str, null);
    }

    @Override // okhttp3.internal.platform.Platform
    @javax.annotation.Nullable
    public javax.net.ssl.X509TrustManager trustManager(javax.net.ssl.SSLSocketFactory sSLSocketFactory) {
        java.lang.Object e = okhttp3.internal.platform.Platform.e(sSLSocketFactory, this.c, "sslParameters");
        if (e == null) {
            try {
                e = okhttp3.internal.platform.Platform.e(sSLSocketFactory, java.lang.Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, sSLSocketFactory.getClass().getClassLoader()), "sslParameters");
            } catch (java.lang.ClassNotFoundException unused) {
                return super.trustManager(sSLSocketFactory);
            }
        }
        javax.net.ssl.X509TrustManager x509TrustManager = (javax.net.ssl.X509TrustManager) okhttp3.internal.platform.Platform.e(e, javax.net.ssl.X509TrustManager.class, "x509TrustManager");
        return x509TrustManager != null ? x509TrustManager : (javax.net.ssl.X509TrustManager) okhttp3.internal.platform.Platform.e(e, javax.net.ssl.X509TrustManager.class, "trustManager");
    }
}
