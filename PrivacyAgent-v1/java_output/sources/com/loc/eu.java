package com.loc;

/* loaded from: classes23.dex */
public final class eu implements com.loc.eo {
    private static long k;
    android.content.Context a;
    com.loc.dy d;
    com.loc.bx e;
    private android.os.Handler g;
    private android.location.LocationManager h;
    private com.loc.eu.a i;
    private java.util.ArrayList<com.loc.de> f = new java.util.ArrayList<>();
    com.loc.fj b = null;
    com.loc.fd c = null;
    private volatile boolean j = false;

    /* renamed from: com.loc.eu$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.loc.fj fjVar;
            try {
                com.loc.eu euVar = com.loc.eu.this;
                if (euVar.d == null || (fjVar = euVar.b) == null) {
                    return;
                }
                com.loc.dy.b(fjVar.a());
            } catch (java.lang.Throwable th) {
                com.loc.fv.a(th, "cl", "upwr");
            }
        }
    }

    public static class a implements android.location.LocationListener {
        private com.loc.eu a;

        public a(com.loc.eu euVar) {
            this.a = euVar;
        }

        public final void a() {
            this.a = null;
        }

        public final void a(com.loc.eu euVar) {
            this.a = euVar;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(android.location.Location location) {
            try {
                com.loc.eu euVar = this.a;
                if (euVar != null) {
                    euVar.a(location);
                }
            } catch (java.lang.Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(java.lang.String str) {
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(java.lang.String str) {
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(java.lang.String str, int i, android.os.Bundle bundle) {
        }
    }

    public class b extends com.loc.cu {
        private int b;
        private android.location.Location c;

        public b(int i) {
            this.b = i;
        }

        public b(com.loc.eu euVar, android.location.Location location) {
            this(1);
            this.c = location;
        }

        private void b() {
            try {
                com.loc.fx.a();
                if (this.c != null && com.loc.eu.this.j) {
                    if (com.loc.gd.m(com.loc.eu.this.a)) {
                        com.loc.fx.a();
                        return;
                    }
                    android.os.Bundle extras = this.c.getExtras();
                    int i = extras != null ? extras.getInt("satellites") : 0;
                    if (com.loc.gd.a(this.c, i)) {
                        return;
                    }
                    com.loc.fj fjVar = com.loc.eu.this.b;
                    if (fjVar != null && !fjVar.f408s) {
                        fjVar.f();
                    }
                    java.util.ArrayList<com.loc.ei> a = com.loc.eu.this.b.a();
                    java.util.List<com.loc.eb> a2 = com.loc.eu.this.c.a();
                    com.loc.dc.a aVar = new com.loc.dc.a();
                    com.loc.eh ehVar = new com.loc.eh();
                    ehVar.i = this.c.getAccuracy();
                    ehVar.f = this.c.getAltitude();
                    ehVar.d = this.c.getLatitude();
                    ehVar.h = this.c.getBearing();
                    ehVar.e = this.c.getLongitude();
                    ehVar.j = this.c.isFromMockProvider();
                    ehVar.a = this.c.getProvider();
                    ehVar.g = this.c.getSpeed();
                    ehVar.l = (byte) i;
                    ehVar.b = java.lang.System.currentTimeMillis();
                    ehVar.c = this.c.getTime();
                    ehVar.k = this.c.getTime();
                    aVar.a = ehVar;
                    aVar.b = a;
                    android.net.wifi.WifiInfo c = com.loc.eu.this.b.c();
                    if (c != null) {
                        aVar.c = com.loc.ei.a(com.loc.fg.a(c));
                    }
                    aVar.d = com.loc.fj.z;
                    aVar.f = this.c.getTime();
                    aVar.g = (byte) com.loc.p.i(com.loc.eu.this.a);
                    aVar.h = com.loc.p.n(com.loc.eu.this.a);
                    aVar.e = com.loc.eu.this.b.l();
                    aVar.j = com.loc.gd.a(com.loc.eu.this.a);
                    aVar.i = a2;
                    com.loc.de a3 = com.loc.dy.a(aVar);
                    if (a3 == null) {
                        return;
                    }
                    synchronized (com.loc.eu.this.f) {
                        com.loc.eu.this.f.add(a3);
                        if (com.loc.eu.this.f.size() >= 5) {
                            com.loc.eu.this.e();
                        }
                    }
                    com.loc.eu.this.d();
                }
            } catch (java.lang.Throwable th) {
                com.loc.fv.a(th, "cl", "coll");
            }
        }

        private void c() {
            com.loc.fx.a();
            if (com.loc.gd.m(com.loc.eu.this.a)) {
                com.loc.fx.a();
                return;
            }
            com.loc.bm bmVar = null;
            try {
                long unused = com.loc.eu.k = java.lang.System.currentTimeMillis();
                if (com.loc.eu.this.e.f.c()) {
                    bmVar = com.loc.bm.a(new java.io.File(com.loc.eu.this.e.a), com.loc.eu.this.e.b);
                    java.util.ArrayList arrayList = new java.util.ArrayList();
                    byte[] f = com.loc.eu.f();
                    if (f == null) {
                        try {
                            bmVar.close();
                            return;
                        } catch (java.lang.Throwable unused2) {
                            return;
                        }
                    }
                    java.util.List b = com.loc.eu.b(bmVar, com.loc.eu.this.e, arrayList, f);
                    if (b != null && b.size() != 0) {
                        com.loc.eu.this.e.f.a(true);
                        if (com.loc.dy.a(com.loc.y.b(com.loc.dy.a(com.loc.fk.a(f), com.loc.q.b(f, com.loc.dy.a(), com.loc.y.c()), b)))) {
                            com.loc.eu.b(bmVar, arrayList);
                        }
                    }
                    try {
                        bmVar.close();
                        return;
                    } catch (java.lang.Throwable unused3) {
                        return;
                    }
                }
                if (bmVar != null) {
                    try {
                        bmVar.close();
                    } catch (java.lang.Throwable unused4) {
                    }
                }
            } catch (java.lang.Throwable th) {
                try {
                    com.loc.aw.b(th, "leg", "uts");
                    if (bmVar != null) {
                        try {
                            bmVar.close();
                        } catch (java.lang.Throwable unused5) {
                        }
                    }
                } catch (java.lang.Throwable th2) {
                    if (bmVar != null) {
                        try {
                            bmVar.close();
                        } catch (java.lang.Throwable unused6) {
                        }
                    }
                    throw th2;
                }
            }
        }

        @Override // com.loc.cu
        public final void a() {
            int i = this.b;
            if (i == 1) {
                b();
            } else if (i == 2) {
                c();
            } else if (i == 3) {
                com.loc.eu.this.g();
            }
        }
    }

    public eu(android.content.Context context) {
        this.a = null;
        this.a = context;
        com.loc.bx bxVar = new com.loc.bx();
        this.e = bxVar;
        com.loc.cd.a(this.a, bxVar, com.loc.au.k, 100, 1024000, "0");
        com.loc.bx bxVar2 = this.e;
        int i = com.loc.fu.g;
        boolean z = com.loc.fu.e;
        int i2 = com.loc.fu.f;
        bxVar2.f = new com.loc.cp(context, i, "kKey", new com.loc.cn(context, z, i2, i2 * 10, "carrierLocKey"));
        this.e.e = new com.loc.bf();
    }

    private static int a(byte[] bArr) {
        return ((bArr[0] & 255) << 24) | (bArr[3] & 255) | ((bArr[2] & 255) << 8) | ((bArr[1] & 255) << 16);
    }

    private static byte[] a(int i) {
        try {
            javax.crypto.KeyGenerator keyGenerator = javax.crypto.KeyGenerator.getInstance("AES");
            if (keyGenerator == null) {
                return null;
            }
            keyGenerator.init(i);
            return keyGenerator.generateKey().getEncoded();
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(6:15|(3:16|17|18)|(2:19|20)|(0)(3:30|31|(1:(2:34|35))(3:38|39|(10:43|(7:46|47|48|49|50|51|44)|69|70|71|72|73|74|75|(6:77|78|57|58|60|25)(0))(0)))|26|27) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
    
        if (r9 != null) goto L99;
     */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00fb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static java.util.List<com.loc.de> b(com.loc.bm bmVar, com.loc.bx bxVar, java.util.List<java.lang.String> list, byte[] bArr) {
        java.lang.String[] list2;
        java.lang.String[] strArr;
        java.io.InputStream inputStream;
        com.loc.bm.b bVar;
        java.lang.String str;
        byte[] a2;
        byte[] bArr2;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            java.io.File b2 = bmVar.b();
            if (b2 == null || !b2.exists() || (list2 = b2.list()) == null) {
                return arrayList;
            }
            int length = list2.length;
            char c = 0;
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                java.lang.String str2 = list2[i];
                if (str2.contains(".0")) {
                    inputStream = null;
                    try {
                        str = str2.split("\\.")[c];
                    } catch (java.lang.Throwable unused) {
                    }
                    try {
                        bVar = bmVar.a(str);
                    } catch (java.lang.Throwable unused2) {
                        strArr = list2;
                        bVar = null;
                        if (inputStream != null) {
                        }
                        if (bVar == null) {
                        }
                        try {
                            bVar.close();
                        } catch (java.lang.Throwable unused3) {
                        }
                        i++;
                        list2 = strArr;
                        c = 0;
                    }
                    if (bVar != null) {
                        try {
                            inputStream = bVar.a();
                        } catch (java.lang.Throwable unused4) {
                            strArr = list2;
                        }
                        if (inputStream != null) {
                            byte[] bArr3 = new byte[2];
                            inputStream.read(bArr3);
                            int b3 = com.loc.gd.b(bArr3);
                            if (b3 != 0 && b3 <= 65535) {
                                byte[] bArr4 = new byte[b3];
                                inputStream.read(bArr4);
                                byte[] bArr5 = new byte[2];
                                int i3 = 0;
                                while (inputStream.read(bArr5) >= 0) {
                                    try {
                                        byte[] bArr6 = new byte[com.loc.gd.b(bArr5)];
                                        inputStream.read(bArr6);
                                        a2 = com.loc.q.a(bArr4, bArr6, com.loc.y.c());
                                        i3 += a2.length;
                                        bArr2 = new byte[4];
                                        inputStream.read(bArr2);
                                        strArr = list2;
                                    } catch (java.lang.Throwable unused5) {
                                        strArr = list2;
                                    }
                                    try {
                                        arrayList.add(new com.loc.de(a(bArr2), com.loc.q.b(bArr, com.loc.y.b(a2), com.loc.y.c())));
                                        list2 = strArr;
                                    } catch (java.lang.Throwable unused6) {
                                        if (inputStream != null) {
                                        }
                                        if (bVar == null) {
                                        }
                                        bVar.close();
                                        i++;
                                        list2 = strArr;
                                        c = 0;
                                    }
                                }
                                strArr = list2;
                                i2 += i3;
                                try {
                                    list.add(str);
                                    try {
                                    } catch (java.lang.Throwable unused7) {
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (java.lang.Throwable unused8) {
                                            }
                                        }
                                        if (bVar == null) {
                                            i++;
                                            list2 = strArr;
                                            c = 0;
                                        }
                                        bVar.close();
                                        i++;
                                        list2 = strArr;
                                        c = 0;
                                    }
                                } catch (java.lang.Throwable unused9) {
                                }
                                if (i2 <= bxVar.f.b()) {
                                    try {
                                        inputStream.close();
                                    } catch (java.lang.Throwable unused10) {
                                    }
                                    bVar.close();
                                    i++;
                                    list2 = strArr;
                                    c = 0;
                                }
                            }
                        } else if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (java.lang.Throwable unused11) {
                            }
                        }
                    }
                    bVar.close();
                }
                strArr = list2;
                i++;
                list2 = strArr;
                c = 0;
            }
            try {
                inputStream.close();
            } catch (java.lang.Throwable unused12) {
            }
            try {
                bVar.close();
                break;
            } catch (java.lang.Throwable unused13) {
            }
            return arrayList;
        } catch (java.lang.Throwable th) {
            com.loc.aw.b(th, "aps", "upc");
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.loc.bm bmVar, java.util.List<java.lang.String> list) {
        if (bmVar != null) {
            try {
                java.util.Iterator<java.lang.String> it = list.iterator();
                while (it.hasNext()) {
                    bmVar.c(it.next());
                }
                bmVar.close();
            } catch (java.lang.Throwable th) {
                com.loc.aw.b(th, "aps", "dlo");
            }
        }
    }

    private static byte[] b(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    private static byte[] c(int i) {
        return new byte[]{(byte) ((i & androidx.core.view.MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8), (byte) (i & 255)};
    }

    public static /* synthetic */ byte[] f() {
        return a(128);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        try {
            com.loc.fx.a();
            if (com.loc.gd.m(this.a)) {
                com.loc.fx.a();
                return;
            }
            java.util.ArrayList<com.loc.de> arrayList = this.f;
            if (arrayList != null && arrayList.size() != 0) {
                java.util.ArrayList arrayList2 = new java.util.ArrayList();
                synchronized (this.f) {
                    arrayList2.addAll(this.f);
                    this.f.clear();
                }
                java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                byte[] a2 = a(256);
                if (a2 == null) {
                    return;
                }
                byteArrayOutputStream.write(c(a2.length));
                byteArrayOutputStream.write(a2);
                java.util.Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    com.loc.de deVar = (com.loc.de) it.next();
                    byte[] b2 = deVar.b();
                    if (b2.length >= 10 && b2.length <= 65535) {
                        byte[] b3 = com.loc.q.b(a2, b2, com.loc.y.c());
                        byteArrayOutputStream.write(c(b3.length));
                        byteArrayOutputStream.write(b3);
                        byteArrayOutputStream.write(b(deVar.a()));
                    }
                }
                com.loc.by.a(java.lang.Long.toString(java.lang.System.currentTimeMillis()), byteArrayOutputStream.toByteArray(), this.e);
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "clm", "wtD");
        }
    }

    @Override // com.loc.eo
    public final com.loc.en a(com.loc.em emVar) {
        try {
            com.loc.fp fpVar = new com.loc.fp();
            fpVar.a(emVar.b);
            fpVar.b(emVar.a);
            fpVar.a(emVar.d);
            com.loc.bp.a();
            com.loc.bv a2 = com.loc.bp.a(fpVar);
            com.loc.en enVar = new com.loc.en();
            enVar.c = a2.a;
            enVar.b = a2.b;
            enVar.a = 200;
            return enVar;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public final void a() {
        android.location.LocationManager locationManager;
        if (com.loc.gd.m(this.a)) {
            com.loc.fx.a();
            return;
        }
        try {
            com.loc.eu.a aVar = this.i;
            if (aVar != null && (locationManager = this.h) != null) {
                locationManager.removeUpdates(aVar);
            }
            com.loc.eu.a aVar2 = this.i;
            if (aVar2 != null) {
                aVar2.a();
            }
            if (this.j) {
                g();
                this.b.a((com.loc.eu) null);
                this.c.a((com.loc.eu) null);
                this.c = null;
                this.b = null;
                this.g = null;
                this.j = false;
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "clm", "stc");
        }
    }

    public final void a(android.location.Location location) {
        try {
            android.os.Handler handler = this.g;
            if (handler != null) {
                handler.post(new com.loc.eu.b(this, location));
            }
        } catch (java.lang.Throwable th) {
            com.loc.aw.b(th, "cl", "olcc");
        }
    }

    public final void a(com.loc.fd fdVar, com.loc.fj fjVar, android.os.Handler handler) {
        android.location.LocationManager locationManager;
        com.loc.fx.a();
        if (this.j || fdVar == null || fjVar == null || handler == null) {
            return;
        }
        if (com.loc.gd.m(this.a)) {
            com.loc.fx.a();
            return;
        }
        this.j = true;
        this.c = fdVar;
        this.b = fjVar;
        fjVar.a(this);
        this.c.a(this);
        this.g = handler;
        try {
            if (this.h == null) {
                this.h = (android.location.LocationManager) this.a.getSystemService(com.alibaba.sdk.android.oss.common.RequestParameters.SUBRESOURCE_LOCATION);
            }
            if (this.i == null) {
                this.i = new com.loc.eu.a(this);
            }
            this.i.a(this);
            com.loc.eu.a aVar = this.i;
            if (aVar != null && (locationManager = this.h) != null) {
                locationManager.requestLocationUpdates("passive", 1000L, -1.0f, aVar);
            }
            if (this.d == null) {
                com.loc.dy dyVar = new com.loc.dy("6.4.5", com.loc.m.f(this.a), "S128DF1572465B890OE3F7A13167KLEI", com.loc.m.c(this.a), this);
                this.d = dyVar;
                dyVar.a(com.loc.p.k()).b(com.loc.p.f(this.a)).c(com.loc.p.a(this.a)).d(com.loc.p.e(this.a)).e(com.loc.p.n()).f(com.loc.p.f()).g(android.os.Build.MODEL).h(android.os.Build.MANUFACTURER).i(android.os.Build.BRAND).a(android.os.Build.VERSION.SDK_INT).j(android.os.Build.VERSION.RELEASE).a(com.loc.ei.a(com.loc.p.h())).k(com.loc.p.h());
                com.loc.dy.b();
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "col", "init");
        }
    }

    public final void b() {
        try {
            com.loc.fx.a();
            android.os.Handler handler = this.g;
            if (handler != null) {
                handler.post(new com.loc.eu.AnonymousClass1());
            }
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "cl", "upw");
        }
    }

    public final void c() {
        com.loc.fd fdVar;
        try {
            com.loc.fx.a();
            if (this.d == null || (fdVar = this.c) == null) {
                return;
            }
            com.loc.dy.a(fdVar.a());
        } catch (java.lang.Throwable th) {
            com.loc.fv.a(th, "cl", "upc");
        }
    }

    public final void d() {
        try {
            if (com.loc.gd.m(this.a)) {
                com.loc.fx.a();
            } else {
                if (java.lang.System.currentTimeMillis() - k < 60000) {
                    return;
                }
                com.loc.ct.a().b(new com.loc.eu.b(2));
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public final void e() {
        try {
            com.loc.ct.a().b(new com.loc.eu.b(3));
        } catch (java.lang.Throwable unused) {
        }
    }
}
