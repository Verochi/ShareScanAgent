package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class hg extends javax.net.ssl.SSLSocketFactory {
    private javax.net.ssl.SSLSocketFactory a;
    private android.content.Context b;
    private javax.net.ssl.SSLContext c;

    public hg(android.content.Context context, javax.net.ssl.SSLContext sSLContext) {
        if (context != null) {
            try {
                this.b = context.getApplicationContext();
            } catch (java.lang.Throwable th) {
                try {
                    com.amap.api.mapcore.util.gd.c(th, "myssl", "<init>");
                    try {
                        if (this.c == null) {
                            this.c = javax.net.ssl.SSLContext.getDefault();
                        }
                    } catch (java.lang.Throwable th2) {
                        com.amap.api.mapcore.util.gd.c(th2, "myssl", "<init2>");
                    }
                    try {
                        if (this.a == null) {
                            this.a = (javax.net.ssl.SSLSocketFactory) javax.net.ssl.SSLSocketFactory.getDefault();
                            return;
                        }
                        return;
                    } catch (java.lang.Throwable th3) {
                        com.amap.api.mapcore.util.gd.c(th3, "myssl", "<init3>");
                        return;
                    }
                } catch (java.lang.Throwable th4) {
                    try {
                        if (this.c == null) {
                            this.c = javax.net.ssl.SSLContext.getDefault();
                        }
                    } catch (java.lang.Throwable th5) {
                        com.amap.api.mapcore.util.gd.c(th5, "myssl", "<init2>");
                    }
                    try {
                        if (this.a != null) {
                            throw th4;
                        }
                        this.a = (javax.net.ssl.SSLSocketFactory) javax.net.ssl.SSLSocketFactory.getDefault();
                        throw th4;
                    } catch (java.lang.Throwable th6) {
                        com.amap.api.mapcore.util.gd.c(th6, "myssl", "<init3>");
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
            com.amap.api.mapcore.util.gd.c(th7, "myssl", "<init2>");
        }
        try {
            if (this.a == null) {
                this.a = (javax.net.ssl.SSLSocketFactory) javax.net.ssl.SSLSocketFactory.getDefault();
            }
        } catch (java.lang.Throwable th8) {
            com.amap.api.mapcore.util.gd.c(th8, "myssl", "<init3>");
        }
    }

    private static java.net.Socket a(java.net.Socket socket) {
        try {
            if (com.amap.api.mapcore.util.ew.e.b && (socket instanceof javax.net.ssl.SSLSocket)) {
                ((javax.net.ssl.SSLSocket) socket).setEnabledProtocols(new java.lang.String[]{"TLSv1.2"});
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "myssl", "stlv2");
        }
        return socket;
    }

    private void a(android.net.SSLSessionCache sSLSessionCache) {
        javax.net.ssl.SSLContext sSLContext = this.c;
        if (sSLContext == null) {
            return;
        }
        try {
            javax.net.ssl.SSLSessionContext clientSessionContext = sSLContext.getClientSessionContext();
            java.lang.reflect.Field declaredField = sSLSessionCache.getClass().getDeclaredField(com.amap.api.mapcore.util.fi.c("UbVNlc3Npb25DYWNoZQ"));
            declaredField.setAccessible(true);
            java.lang.Object obj = declaredField.get(sSLSessionCache);
            java.lang.reflect.Method[] methods = clientSessionContext.getClass().getMethods();
            java.lang.String c = com.amap.api.mapcore.util.fi.c("Yc2V0UGVyc2lzdGVudENhY2hl");
            for (java.lang.reflect.Method method : methods) {
                if (method.getName().equals(c)) {
                    method.invoke(clientSessionContext, obj);
                    return;
                }
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "myssl", "isc2");
        }
    }

    private static void b(java.net.Socket socket) {
        int i = android.os.Build.VERSION.SDK_INT;
        if (com.amap.api.mapcore.util.ew.e.c && com.amap.api.mapcore.util.ew.e.e && (socket instanceof javax.net.ssl.SSLSocket)) {
            int i2 = com.amap.api.mapcore.util.ew.e.f;
            int i3 = com.amap.api.mapcore.util.ew.e.d;
            if (i2 <= i3) {
                i3 = com.amap.api.mapcore.util.ew.e.f;
            }
            if (i3 <= 17 || i <= i3) {
                try {
                    socket.getClass().getMethod(com.amap.api.mapcore.util.fi.c("Cc2V0VXNlU2Vzc2lvblRpY2tldHM"), java.lang.Boolean.TYPE).invoke(socket, java.lang.Boolean.TRUE);
                } catch (java.lang.Throwable th) {
                    com.amap.api.mapcore.util.gd.c(th, "myssl", "sust");
                }
            }
        }
    }

    public final void a() {
        int i = android.os.Build.VERSION.SDK_INT;
        if (!com.amap.api.mapcore.util.ew.e.c || this.b == null || this.c == null) {
            return;
        }
        int i2 = com.amap.api.mapcore.util.ew.e.d;
        if (i2 <= 17 || i <= i2) {
            android.net.SSLSessionCache sSLSessionCache = new android.net.SSLSessionCache(this.b);
            if (i >= 28) {
                a(sSLSessionCache);
                return;
            }
            try {
                sSLSessionCache.getClass().getMethod(com.amap.api.mapcore.util.fi.c("MaW5zdGFsbA"), android.net.SSLSessionCache.class, javax.net.ssl.SSLContext.class).invoke(sSLSessionCache, sSLSessionCache, this.c);
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, "myssl", "isc1");
                a(sSLSessionCache);
            }
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
            b(a);
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
            b(a);
            return a;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "myssl", "cs3");
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
            b(a);
            return a;
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "myssl", "cs4");
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
            b(a);
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
            b(a);
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
            b(a);
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
            com.amap.api.mapcore.util.gd.c(th, "myssl", "gdcs");
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
            com.amap.api.mapcore.util.gd.c(th, "myssl", "gscs");
        }
        return new java.lang.String[0];
    }
}
