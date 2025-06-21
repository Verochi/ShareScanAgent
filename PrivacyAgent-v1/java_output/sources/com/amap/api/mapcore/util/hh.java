package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public final class hh extends com.amap.api.mapcore.util.hb {
    private static com.amap.api.mapcore.util.hh f;
    private com.amap.api.mapcore.util.ii g;
    private android.os.Handler h;

    public static class a extends android.os.Handler {
        public a() {
        }

        private a(android.os.Looper looper) {
            super(looper);
        }

        public /* synthetic */ a(android.os.Looper looper, byte b) {
            this(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(android.os.Message message) {
            try {
                int i = message.what;
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private hh(boolean z) {
        if (z) {
            try {
                this.g = com.amap.api.mapcore.util.ii.a(new com.amap.api.mapcore.util.ih.a().a("amap-netmanger-threadpool-%d").b());
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, "NetManger", "NetManger1");
                th.printStackTrace();
                return;
            }
        }
        if (android.os.Looper.myLooper() == null) {
            this.h = new com.amap.api.mapcore.util.hh.a(android.os.Looper.getMainLooper(), (byte) 0);
        } else {
            this.h = new com.amap.api.mapcore.util.hh.a();
        }
    }

    private static synchronized com.amap.api.mapcore.util.hh a(boolean z) {
        com.amap.api.mapcore.util.hh hhVar;
        synchronized (com.amap.api.mapcore.util.hh.class) {
            try {
                com.amap.api.mapcore.util.hh hhVar2 = f;
                if (hhVar2 == null) {
                    f = new com.amap.api.mapcore.util.hh(z);
                } else if (z && hhVar2.g == null) {
                    hhVar2.g = com.amap.api.mapcore.util.ii.a(new com.amap.api.mapcore.util.ih.a().a("amap-netmanger-threadpool-%d").b());
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
            hhVar = f;
        }
        return hhVar;
    }

    private static java.util.Map<java.lang.String, java.lang.String> a(com.amap.api.mapcore.util.hi hiVar, com.amap.api.mapcore.util.hi.b bVar, int i) throws com.amap.api.mapcore.util.eu {
        try {
            com.amap.api.mapcore.util.hb.e(hiVar);
            hiVar.setDegradeType(bVar);
            hiVar.setReal_max_timeout(i);
            return new com.amap.api.mapcore.util.hf().a(hiVar);
        } catch (com.amap.api.mapcore.util.eu e) {
            throw e;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            throw new com.amap.api.mapcore.util.eu(com.amap.api.maps.AMapException.ERROR_UNKNOWN);
        }
    }

    public static com.amap.api.mapcore.util.hh b() {
        return a(true);
    }

    private static com.amap.api.mapcore.util.hj b(com.amap.api.mapcore.util.hi hiVar, com.amap.api.mapcore.util.hi.b bVar, int i) throws com.amap.api.mapcore.util.eu {
        try {
            com.amap.api.mapcore.util.hb.e(hiVar);
            hiVar.setDegradeType(bVar);
            hiVar.setReal_max_timeout(i);
            return new com.amap.api.mapcore.util.hf().b(hiVar);
        } catch (com.amap.api.mapcore.util.eu e) {
            throw e;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            throw new com.amap.api.mapcore.util.eu(com.amap.api.maps.AMapException.ERROR_UNKNOWN);
        }
    }

    public static com.amap.api.mapcore.util.hh c() {
        return a(false);
    }

    @java.lang.Deprecated
    public static java.util.Map<java.lang.String, java.lang.String> e(com.amap.api.mapcore.util.hi hiVar, boolean z) throws com.amap.api.mapcore.util.eu {
        com.amap.api.mapcore.util.hb.e(hiVar);
        hiVar.setHttpProtocol(z ? com.amap.api.mapcore.util.hi.c.HTTPS : com.amap.api.mapcore.util.hi.c.HTTP);
        java.util.Map<java.lang.String, java.lang.String> map = null;
        long j = 0;
        boolean z2 = false;
        if (com.amap.api.mapcore.util.hb.c(hiVar)) {
            boolean d = com.amap.api.mapcore.util.hb.d(hiVar);
            try {
                j = android.os.SystemClock.elapsedRealtime();
                map = a(hiVar, com.amap.api.mapcore.util.hb.b(hiVar, d), com.amap.api.mapcore.util.hb.d(hiVar, d));
            } catch (com.amap.api.mapcore.util.eu e) {
                if (!d) {
                    throw e;
                }
                z2 = true;
            }
        }
        if (map != null) {
            return map;
        }
        try {
            return a(hiVar, com.amap.api.mapcore.util.hb.c(hiVar, z2), com.amap.api.mapcore.util.hb.a(hiVar, j));
        } catch (com.amap.api.mapcore.util.eu e2) {
            throw e2;
        }
    }

    public static com.amap.api.mapcore.util.hj f(com.amap.api.mapcore.util.hi hiVar) throws com.amap.api.mapcore.util.eu {
        return f(hiVar, hiVar.isHttps());
    }

    @java.lang.Deprecated
    private static com.amap.api.mapcore.util.hj f(com.amap.api.mapcore.util.hi hiVar, boolean z) throws com.amap.api.mapcore.util.eu {
        byte[] bArr;
        com.amap.api.mapcore.util.hb.e(hiVar);
        hiVar.setHttpProtocol(z ? com.amap.api.mapcore.util.hi.c.HTTPS : com.amap.api.mapcore.util.hi.c.HTTP);
        com.amap.api.mapcore.util.hj hjVar = null;
        long j = 0;
        boolean z2 = false;
        if (com.amap.api.mapcore.util.hb.c(hiVar)) {
            boolean d = com.amap.api.mapcore.util.hb.d(hiVar);
            try {
                j = android.os.SystemClock.elapsedRealtime();
                hjVar = b(hiVar, com.amap.api.mapcore.util.hb.b(hiVar, d), com.amap.api.mapcore.util.hb.d(hiVar, d));
            } catch (com.amap.api.mapcore.util.eu e) {
                if (e.f() == 21 && hiVar.getDegradeAbility() == com.amap.api.mapcore.util.hi.a.INTERRUPT_IO) {
                    throw e;
                }
                if (!d) {
                    throw e;
                }
                z2 = true;
            }
        }
        if (hjVar != null && (bArr = hjVar.a) != null && bArr.length > 0) {
            return hjVar;
        }
        try {
            return b(hiVar, com.amap.api.mapcore.util.hb.c(hiVar, z2), com.amap.api.mapcore.util.hb.a(hiVar, j));
        } catch (com.amap.api.mapcore.util.eu e2) {
            throw e2;
        }
    }

    @Override // com.amap.api.mapcore.util.hb
    @java.lang.Deprecated
    public final byte[] a(com.amap.api.mapcore.util.hi hiVar) throws com.amap.api.mapcore.util.eu {
        try {
            com.amap.api.mapcore.util.hj a2 = com.amap.api.mapcore.util.hb.a(hiVar, false);
            if (a2 != null) {
                return a2.a;
            }
            return null;
        } catch (com.amap.api.mapcore.util.eu e) {
            throw e;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            com.amap.api.mapcore.util.gd.e().b(th, "NetManager", "makeSyncPostRequest");
            throw new com.amap.api.mapcore.util.eu(com.amap.api.maps.AMapException.ERROR_UNKNOWN);
        }
    }
}
