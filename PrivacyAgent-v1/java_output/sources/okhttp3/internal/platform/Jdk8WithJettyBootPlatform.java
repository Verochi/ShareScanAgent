package okhttp3.internal.platform;

/* loaded from: classes24.dex */
class Jdk8WithJettyBootPlatform extends okhttp3.internal.platform.Platform {
    public final java.lang.reflect.Method c;
    public final java.lang.reflect.Method d;
    public final java.lang.reflect.Method e;
    public final java.lang.Class<?> f;
    public final java.lang.Class<?> g;

    public static class AlpnProvider implements java.lang.reflect.InvocationHandler {
        public final java.util.List<java.lang.String> n;
        public boolean t;
        public java.lang.String u;

        public AlpnProvider(java.util.List<java.lang.String> list) {
            this.n = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public java.lang.Object invoke(java.lang.Object obj, java.lang.reflect.Method method, java.lang.Object[] objArr) throws java.lang.Throwable {
            java.lang.String name = method.getName();
            java.lang.Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = okhttp3.internal.Util.EMPTY_STRING_ARRAY;
            }
            if (name.equals("supports") && java.lang.Boolean.TYPE == returnType) {
                return java.lang.Boolean.TRUE;
            }
            if (name.equals("unsupported") && java.lang.Void.TYPE == returnType) {
                this.t = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.n;
            }
            if ((name.equals("selectProtocol") || name.equals("select")) && java.lang.String.class == returnType && objArr.length == 1) {
                java.lang.Object obj2 = objArr[0];
                if (obj2 instanceof java.util.List) {
                    java.util.List list = (java.util.List) obj2;
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        java.lang.String str = (java.lang.String) list.get(i);
                        if (this.n.contains(str)) {
                            this.u = str;
                            return str;
                        }
                    }
                    java.lang.String str2 = this.n.get(0);
                    this.u = str2;
                    return str2;
                }
            }
            if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                return method.invoke(this, objArr);
            }
            this.u = (java.lang.String) objArr[0];
            return null;
        }
    }

    public Jdk8WithJettyBootPlatform(java.lang.reflect.Method method, java.lang.reflect.Method method2, java.lang.reflect.Method method3, java.lang.Class<?> cls, java.lang.Class<?> cls2) {
        this.c = method;
        this.d = method2;
        this.e = method3;
        this.f = cls;
        this.g = cls2;
    }

    public static okhttp3.internal.platform.Platform f() {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
            java.lang.Class<?> cls2 = java.lang.Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
            return new okhttp3.internal.platform.Jdk8WithJettyBootPlatform(cls.getMethod("put", javax.net.ssl.SSLSocket.class, cls2), cls.getMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, javax.net.ssl.SSLSocket.class), cls.getMethod("remove", javax.net.ssl.SSLSocket.class), java.lang.Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null), java.lang.Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null));
        } catch (java.lang.ClassNotFoundException | java.lang.NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public void afterHandshake(javax.net.ssl.SSLSocket sSLSocket) {
        try {
            this.e.invoke(null, sSLSocket);
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException e) {
            throw new java.lang.AssertionError("failed to remove ALPN", e);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(javax.net.ssl.SSLSocket sSLSocket, java.lang.String str, java.util.List<okhttp3.Protocol> list) {
        try {
            this.c.invoke(null, sSLSocket, java.lang.reflect.Proxy.newProxyInstance(okhttp3.internal.platform.Platform.class.getClassLoader(), new java.lang.Class[]{this.f, this.g}, new okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider(okhttp3.internal.platform.Platform.alpnProtocolNames(list))));
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException e) {
            throw new java.lang.AssertionError("failed to set ALPN", e);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    @javax.annotation.Nullable
    public java.lang.String getSelectedProtocol(javax.net.ssl.SSLSocket sSLSocket) {
        try {
            okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider alpnProvider = (okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider) java.lang.reflect.Proxy.getInvocationHandler(this.d.invoke(null, sSLSocket));
            boolean z = alpnProvider.t;
            if (!z && alpnProvider.u == null) {
                okhttp3.internal.platform.Platform.get().log(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", null);
                return null;
            }
            if (z) {
                return null;
            }
            return alpnProvider.u;
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException e) {
            throw new java.lang.AssertionError("failed to get ALPN selected protocol", e);
        }
    }
}
