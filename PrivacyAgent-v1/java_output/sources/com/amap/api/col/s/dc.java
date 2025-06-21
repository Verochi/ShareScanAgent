package com.amap.api.col.s;

/* loaded from: classes12.dex */
public final class dc extends com.amap.api.col.s.cx {
    public static com.amap.api.col.s.dc h;
    public android.os.Handler g;

    public static class a extends android.os.Handler {
        public a() {
        }

        public a(android.os.Looper looper) {
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

    public dc() {
        try {
            if (android.os.Looper.myLooper() == null) {
                this.g = new com.amap.api.col.s.dc.a(android.os.Looper.getMainLooper(), (byte) 0);
            } else {
                this.g = new com.amap.api.col.s.dc.a();
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.col.s.cj.c(th, "NetManger", "NetManger1");
            th.printStackTrace();
        }
    }

    public static com.amap.api.col.s.dc b() {
        return e();
    }

    public static com.amap.api.col.s.de b(com.amap.api.col.s.dd ddVar, com.amap.api.col.s.dd.b bVar, int i) throws com.amap.api.col.s.bh {
        try {
            com.amap.api.col.s.cx.d(ddVar);
            ddVar.a(bVar);
            ddVar.c(i);
            return new com.amap.api.col.s.da().d(ddVar);
        } catch (com.amap.api.col.s.bh e) {
            throw e;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            throw new com.amap.api.col.s.bh(com.amap.api.maps.AMapException.ERROR_UNKNOWN);
        }
    }

    @java.lang.Deprecated
    public static com.amap.api.col.s.de d(com.amap.api.col.s.dd ddVar, boolean z) throws com.amap.api.col.s.bh {
        byte[] bArr;
        com.amap.api.col.s.cx.d(ddVar);
        ddVar.a(z ? com.amap.api.col.s.dd.c.HTTPS : com.amap.api.col.s.dd.c.HTTP);
        com.amap.api.col.s.de deVar = null;
        long j = 0;
        boolean z2 = false;
        if (com.amap.api.col.s.cx.b(ddVar)) {
            boolean c = com.amap.api.col.s.cx.c(ddVar);
            try {
                j = android.os.SystemClock.elapsedRealtime();
                deVar = b(ddVar, com.amap.api.col.s.cx.a(ddVar, c), com.amap.api.col.s.cx.c(ddVar, c));
            } catch (com.amap.api.col.s.bh e) {
                if (e.f() == 21 && ddVar.o() == com.amap.api.col.s.dd.a.INTERRUPT_IO) {
                    throw e;
                }
                if (!c) {
                    throw e;
                }
                z2 = true;
            }
        }
        if (deVar != null && (bArr = deVar.a) != null && bArr.length > 0) {
            return deVar;
        }
        try {
            return b(ddVar, com.amap.api.col.s.cx.b(ddVar, z2), com.amap.api.col.s.cx.a(ddVar, j));
        } catch (com.amap.api.col.s.bh e2) {
            throw e2;
        }
    }

    public static synchronized com.amap.api.col.s.dc e() {
        synchronized (com.amap.api.col.s.dc.class) {
            try {
                if (h == null) {
                    h = new com.amap.api.col.s.dc();
                }
            } finally {
                return h;
            }
        }
        return h;
    }

    public static com.amap.api.col.s.de e(com.amap.api.col.s.dd ddVar) throws com.amap.api.col.s.bh {
        return d(ddVar, ddVar.r());
    }
}
