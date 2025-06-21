package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class db extends javax.net.ssl.SSLSocketFactory {
    public javax.net.ssl.SSLSocketFactory a;
    public android.content.Context b;
    public javax.net.ssl.SSLContext c;

    public db(android.content.Context context, javax.net.ssl.SSLContext sSLContext) {
        if (context != null) {
            try {
                this.b = context.getApplicationContext();
            } catch (java.lang.Throwable th) {
                try {
                    com.amap.api.col.s.cj.c(th, "myssl", "<init>");
                    try {
                        if (this.c == null) {
                            this.c = javax.net.ssl.SSLContext.getDefault();
                        }
                    } catch (java.lang.Throwable th2) {
                        com.amap.api.col.s.cj.c(th2, "myssl", "<init2>");
                    }
                    try {
                        if (this.a == null) {
                            this.a = (javax.net.ssl.SSLSocketFactory) javax.net.ssl.SSLSocketFactory.getDefault();
                            return;
                        }
                        return;
                    } catch (java.lang.Throwable th3) {
                        com.amap.api.col.s.cj.c(th3, "myssl", "<init3>");
                        return;
                    }
                } catch (java.lang.Throwable th4) {
                    try {
                        if (this.c == null) {
                            this.c = javax.net.ssl.SSLContext.getDefault();
                        }
                    } catch (java.lang.Throwable th5) {
                        com.amap.api.col.s.cj.c(th5, "myssl", "<init2>");
                    }
                    try {
                        if (this.a != null) {
                            throw th4;
                        }
                        this.a = (javax.net.ssl.SSLSocketFactory) javax.net.ssl.SSLSocketFactory.getDefault();
                        throw th4;
                    } catch (java.lang.Throwable th6) {
                        com.amap.api.col.s.cj.c(th6, "myssl", "<init3>");
                        throw th4;
                    }
                }
            }
        }
        this.c = sSLContext;
        if (sSLContext != null) {
            this.a = sSLContext.getSocketFactory();
        }
        try {
            if (this.c == null) {
                this.c = javax.net.ssl.SSLContext.getDefault();
            }
        } catch (java.lang.Throwable th7) {
            com.amap.api.col.s.cj.c(th7, "myssl", "<init2>");
        }
        try {
            if (this.a == null) {
                this.a = (javax.net.ssl.SSLSocketFactory) javax.net.ssl.SSLSocketFactory.getDefault();
            }
        } catch (java.lang.Throwable th8) {
            com.amap.api.col.s.cj.c(th8, "myssl", "<init3>");
        }
    }

    public static java.net.Socket a(java.net.Socket socket) {
        try {
            if (com.amap.api.col.s.bj.f.b && (socket instanceof javax.net.ssl.SSLSocket)) {
                ((javax.net.ssl.SSLSocket) socket).setEnabledProtocols(new java.lang.String[]{"TLSv1.2"});
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.cj.c(th, "myssl", "stlv2");
        }
        return socket;
    }

    public static void c(java.net.Socket socket) {
        int i = android.os.Build.VERSION.SDK_INT;
        if (com.amap.api.col.s.bj.f.c && com.amap.api.col.s.bj.f.e && (socket instanceof javax.net.ssl.SSLSocket)) {
            int i2 = com.amap.api.col.s.bj.f.f;
            int i3 = com.amap.api.col.s.bj.f.d;
            if (i2 <= i3) {
                i3 = com.amap.api.col.s.bj.f.f;
            }
            if (i3 <= 17 || i <= i3) {
                try {
                    socket.getClass().getMethod(com.amap.api.col.s.bu.c("Cc2V0VXNlU2Vzc2lvblRpY2tldHM"), java.lang.Boolean.TYPE).invoke(socket, java.lang.Boolean.TRUE);
                } catch (java.lang.Throwable th) {
                    com.amap.api.col.s.cj.c(th, "myssl", "sust");
                }
            }
        }
    }

    public final void a() {
        int i = android.os.Build.VERSION.SDK_INT;
        if (!com.amap.api.col.s.bj.f.c || this.b == null || this.c == null) {
            return;
        }
        int i2 = com.amap.api.col.s.bj.f.d;
        if (i2 <= 17 || i <= i2) {
            android.net.SSLSessionCache sSLSessionCache = new android.net.SSLSessionCache(this.b);
            if (i >= 28) {
                b(sSLSessionCache);
                return;
            }
            try {
                sSLSessionCache.getClass().getMethod(com.amap.api.col.s.bu.c("MaW5zdGFsbA"), android.net.SSLSessionCache.class, javax.net.ssl.SSLContext.class).invoke(sSLSessionCache, sSLSessionCache, this.c);
            } catch (java.lang.Throwable th) {
                com.amap.api.col.s.cj.c(th, "myssl", "isc1");
                b(sSLSessionCache);
            }
        }
    }

    public final void b(android.net.SSLSessionCache sSLSessionCache) {
        javax.net.ssl.SSLContext sSLContext = this.c;
        if (sSLContext == null) {
            return;
        }
        try {
            javax.net.ssl.SSLSessionContext clientSessionContext = sSLContext.getClientSessionContext();
            java.lang.reflect.Field declaredField = sSLSessionCache.getClass().getDeclaredField(com.amap.api.col.s.bu.c("UbVNlc3Npb25DYWNoZQ"));
            declaredField.setAccessible(true);
            java.lang.Object obj = declaredField.get(sSLSessionCache);
            java.lang.reflect.Method[] methods = clientSessionContext.getClass().getMethods();
            java.lang.String c = com.amap.api.col.s.bu.c("Yc2V0UGVyc2lzdGVudENhY2hl");
            for (java.lang.reflect.Method method : methods) {
                if (method.getName().equals(c)) {
                    method.invoke(clientSessionContext, obj);
                    return;
                }
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.cj.c(th, "myssl", "isc2");
        }
    }

    @Override // javax.net.SocketFactory
    public final java.net.Socket createSocket() throws java.io.IOException {
        boolean z;
        java.io.IOException iOException;
        try {
            javax.net.ssl.SSLSocketFactory sSLSocketFactory = this.a;
            if (sSLSocketFactory == null) {
                return null;
            }
            java.net.Socket a = a(sSLSocketFactory.createSocket());
            c(a);
            return a;
        } finally {
            if (!z) {
            }
        }
    }

    @Override // javax.net.SocketFactory
    public final java.net.Socket createSocket(java.lang.String str, int i) throws java.io.IOException, java.net.UnknownHostException {
        try {
            javax.net.ssl.SSLSocketFactory sSLSocketFactory = this.a;
            if (sSLSocketFactory == null) {
                return null;
            }
            java.net.Socket a = a(sSLSocketFactory.createSocket(str, i));
            c(a);
            return a;
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.cj.c(th, "myssl", "cs3");
            if (th instanceof java.net.UnknownHostException) {
                throw th;
            }
            if (th instanceof java.io.IOException) {
                throw th;
            }
            return null;
        }
    }

    @Override // javax.net.SocketFactory
    public final java.net.Socket createSocket(java.lang.String str, int i, java.net.InetAddress inetAddress, int i2) throws java.io.IOException, java.net.UnknownHostException {
        try {
            javax.net.ssl.SSLSocketFactory sSLSocketFactory = this.a;
            if (sSLSocketFactory == null) {
                return null;
            }
            java.net.Socket a = a(sSLSocketFactory.createSocket(str, i, inetAddress, i2));
            c(a);
            return a;
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.cj.c(th, "myssl", "cs4");
            if (th instanceof java.net.UnknownHostException) {
                throw th;
            }
            if (th instanceof java.io.IOException) {
                throw th;
            }
            return null;
        }
    }

    @Override // javax.net.SocketFactory
    public final java.net.Socket createSocket(java.net.InetAddress inetAddress, int i) throws java.io.IOException {
        boolean z;
        java.io.IOException iOException;
        try {
            javax.net.ssl.SSLSocketFactory sSLSocketFactory = this.a;
            if (sSLSocketFactory == null) {
                return null;
            }
            java.net.Socket a = a(sSLSocketFactory.createSocket(inetAddress, i));
            c(a);
            return a;
        } finally {
            if (!z) {
            }
        }
    }

    @Override // javax.net.SocketFactory
    public final java.net.Socket createSocket(java.net.InetAddress inetAddress, int i, java.net.InetAddress inetAddress2, int i2) throws java.io.IOException {
        boolean z;
        java.io.IOException iOException;
        try {
            javax.net.ssl.SSLSocketFactory sSLSocketFactory = this.a;
            if (sSLSocketFactory == null) {
                return null;
            }
            java.net.Socket a = a(sSLSocketFactory.createSocket(inetAddress, i, inetAddress2, i2));
            c(a);
            return a;
        } finally {
            if (!z) {
            }
        }
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final java.net.Socket createSocket(java.net.Socket socket, java.lang.String str, int i, boolean z) throws java.io.IOException {
        boolean z2;
        java.io.IOException iOException;
        try {
            javax.net.ssl.SSLSocketFactory sSLSocketFactory = this.a;
            if (sSLSocketFactory == null) {
                return null;
            }
            java.net.Socket a = a(sSLSocketFactory.createSocket(socket, str, i, z));
            c(a);
            return a;
        } finally {
            if (!z2) {
            }
        }
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final java.lang.String[] getDefaultCipherSuites() {
        try {
            javax.net.ssl.SSLSocketFactory sSLSocketFactory = this.a;
            if (sSLSocketFactory != null) {
                return sSLSocketFactory.getDefaultCipherSuites();
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.cj.c(th, "myssl", "gdcs");
        }
        return new java.lang.String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final java.lang.String[] getSupportedCipherSuites() {
        try {
            javax.net.ssl.SSLSocketFactory sSLSocketFactory = this.a;
            if (sSLSocketFactory != null) {
                return sSLSocketFactory.getSupportedCipherSuites();
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.cj.c(th, "myssl", "gscs");
        }
        return new java.lang.String[0];
    }
}
