package com.amap.api.mapcore.util;

/* loaded from: classes12.dex */
public class am {
    public static java.lang.String a = "";
    public static boolean b = false;
    public static java.lang.String d = "";
    private static volatile com.amap.api.mapcore.util.am k;
    public com.amap.api.mapcore.util.aq f;
    com.amap.api.mapcore.util.as g;
    private android.content.Context i;
    private com.amap.api.mapcore.util.am.a l;
    private com.amap.api.mapcore.util.av m;
    private com.amap.api.mapcore.util.bb n;
    private boolean j = true;
    java.util.List<com.amap.api.mapcore.util.al> c = new java.util.Vector();
    private com.amap.api.mapcore.util.ii o = null;
    private com.amap.api.mapcore.util.ii p = null;
    private com.amap.api.mapcore.util.ii q = null;
    com.amap.api.mapcore.util.am.b e = null;
    com.amap.api.mapcore.util.ap h = null;
    private boolean r = true;

    /* renamed from: com.amap.api.mapcore.util.am$1, reason: invalid class name */
    public class AnonymousClass1 extends com.amap.api.mapcore.util.ij {
        final /* synthetic */ java.lang.String a;

        public AnonymousClass1(java.lang.String str) {
            this.a = str;
        }

        @Override // com.amap.api.mapcore.util.ij
        public final void runTask() {
            com.amap.api.mapcore.util.al i = com.amap.api.mapcore.util.am.this.i(this.a);
            if (i != null) {
                try {
                    if (!i.c().equals(i.c) && !i.c().equals(i.e)) {
                        java.lang.String pinyin = i.getPinyin();
                        if (pinyin.length() > 0) {
                            java.lang.String d = com.amap.api.mapcore.util.am.this.n.d(pinyin);
                            if (d == null) {
                                d = i.getVersion();
                            }
                            if (com.amap.api.mapcore.util.am.d.length() > 0 && d != null && com.amap.api.mapcore.util.am.b(com.amap.api.mapcore.util.am.d, d)) {
                                i.j();
                            }
                        }
                    }
                    if (com.amap.api.mapcore.util.am.this.l != null) {
                        synchronized (com.amap.api.mapcore.util.am.this) {
                            try {
                                com.amap.api.mapcore.util.am.this.l.b(i);
                            } finally {
                                return;
                            }
                        }
                        return;
                    }
                    return;
                } catch (java.lang.Exception unused) {
                    if (com.amap.api.mapcore.util.am.this.l != null) {
                        synchronized (com.amap.api.mapcore.util.am.this) {
                            try {
                                com.amap.api.mapcore.util.am.this.l.b(i);
                            } finally {
                                return;
                            }
                            return;
                        }
                    }
                    return;
                } catch (java.lang.Throwable th) {
                    if (com.amap.api.mapcore.util.am.this.l != null) {
                        synchronized (com.amap.api.mapcore.util.am.this) {
                            try {
                                com.amap.api.mapcore.util.am.this.l.b(i);
                            } finally {
                                throw th;
                            }
                        }
                    }
                    throw th;
                }
            }
            com.amap.api.mapcore.util.am.this.j();
            com.amap.api.mapcore.util.an c = new com.amap.api.mapcore.util.ao(com.amap.api.mapcore.util.am.this.i, com.amap.api.mapcore.util.am.d).c();
            if (com.amap.api.mapcore.util.am.this.l != null) {
                if (c == null) {
                    if (com.amap.api.mapcore.util.am.this.l != null) {
                        synchronized (com.amap.api.mapcore.util.am.this) {
                            try {
                                com.amap.api.mapcore.util.am.this.l.b(i);
                            } finally {
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                if (c.a()) {
                    com.amap.api.mapcore.util.am.this.c();
                }
            }
            if (com.amap.api.mapcore.util.am.this.l != null) {
                synchronized (com.amap.api.mapcore.util.am.this) {
                    try {
                        com.amap.api.mapcore.util.am.this.l.b(i);
                    } finally {
                    }
                }
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.am$2, reason: invalid class name */
    public class AnonymousClass2 extends com.amap.api.mapcore.util.ij {
        final /* synthetic */ com.amap.api.mapcore.util.al a;
        final /* synthetic */ boolean b;

        public AnonymousClass2(com.amap.api.mapcore.util.al alVar, boolean z) {
            this.a = alVar;
            this.b = z;
        }

        @Override // com.amap.api.mapcore.util.ij
        public final void runTask() {
            try {
                if (this.a.c().equals(this.a.a)) {
                    if (com.amap.api.mapcore.util.am.this.l != null) {
                        com.amap.api.mapcore.util.am.this.l.c(this.a);
                        return;
                    }
                    return;
                }
                if (this.a.getState() != 7 && this.a.getState() != -1) {
                    com.amap.api.mapcore.util.am.this.g.a(this.a);
                    if (com.amap.api.mapcore.util.am.this.l != null) {
                        com.amap.api.mapcore.util.am.this.l.c(this.a);
                        return;
                    }
                    return;
                }
                com.amap.api.mapcore.util.am.this.g.a(this.a);
                if (!this.b || com.amap.api.mapcore.util.am.this.l == null) {
                    return;
                }
                com.amap.api.mapcore.util.am.this.l.c(this.a);
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, "requestDelete", "removeExcecRunnable");
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.am$3, reason: invalid class name */
    public class AnonymousClass3 extends com.amap.api.mapcore.util.ij {
        final /* synthetic */ com.amap.api.mapcore.util.al a;

        public AnonymousClass3(com.amap.api.mapcore.util.al alVar) {
            this.a = alVar;
        }

        @Override // com.amap.api.mapcore.util.ij
        public final void runTask() {
            try {
                if (com.amap.api.mapcore.util.am.this.j) {
                    com.amap.api.mapcore.util.am.this.j();
                    com.amap.api.mapcore.util.an c = new com.amap.api.mapcore.util.ao(com.amap.api.mapcore.util.am.this.i, com.amap.api.mapcore.util.am.d).c();
                    if (c != null) {
                        com.amap.api.mapcore.util.am.f(com.amap.api.mapcore.util.am.this);
                        if (c.a()) {
                            com.amap.api.mapcore.util.am.this.c();
                        }
                    }
                }
                this.a.setVersion(com.amap.api.mapcore.util.am.d);
                this.a.f();
            } catch (com.amap.api.maps.AMapException e) {
                e.printStackTrace();
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, "OfflineDownloadManager", "startDownloadRunnable");
            }
        }
    }

    public interface a {
        void a();

        void a(com.amap.api.mapcore.util.al alVar);

        void b(com.amap.api.mapcore.util.al alVar);

        void c(com.amap.api.mapcore.util.al alVar);
    }

    public class b extends android.os.Handler {
        public b(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(android.os.Message message) {
            try {
                message.getData();
                java.lang.Object obj = message.obj;
                if (obj instanceof com.amap.api.mapcore.util.al) {
                    com.amap.api.mapcore.util.al alVar = (com.amap.api.mapcore.util.al) obj;
                    alVar.getCity();
                    alVar.getcompleteCode();
                    alVar.getState();
                    if (com.amap.api.mapcore.util.am.this.l != null) {
                        com.amap.api.mapcore.util.am.this.l.a(alVar);
                    }
                }
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private am(android.content.Context context) {
        this.i = context;
    }

    public static com.amap.api.mapcore.util.am a(android.content.Context context) {
        if (k == null) {
            synchronized (com.amap.api.mapcore.util.am.class) {
                if (k == null && !b) {
                    k = new com.amap.api.mapcore.util.am(context.getApplicationContext());
                }
            }
        }
        return k;
    }

    private void a(com.amap.api.mapcore.util.al alVar, boolean z) {
        if (this.g == null) {
            this.g = new com.amap.api.mapcore.util.as(this.i);
        }
        if (this.p == null) {
            this.p = com.amap.api.mapcore.util.dk.a("AMapOfflineRemove");
        }
        try {
            this.p.a(new com.amap.api.mapcore.util.am.AnonymousClass2(alVar, z));
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "requestDelete", "removeExcecRunnable");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(java.lang.String str, java.lang.String str2) {
        for (int i = 0; i < str2.length(); i++) {
            try {
                if (str.charAt(i) > str2.charAt(i)) {
                    return true;
                }
                if (str.charAt(i) < str2.charAt(i)) {
                    return false;
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        return false;
    }

    private void f(com.amap.api.mapcore.util.al alVar) throws com.amap.api.maps.AMapException {
        j();
        if (alVar == null) {
            throw new com.amap.api.maps.AMapException("无效的参数 - IllegalArgumentException");
        }
        if (this.q == null) {
            this.q = com.amap.api.mapcore.util.dk.a("AMapOfflineDownload");
        }
        try {
            this.q.a(new com.amap.api.mapcore.util.am.AnonymousClass3(alVar));
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "startDownload", "downloadExcecRunnable");
        }
    }

    public static /* synthetic */ boolean f(com.amap.api.mapcore.util.am amVar) {
        amVar.j = false;
        return false;
    }

    private void g() {
        try {
            com.amap.api.mapcore.util.aw a2 = this.n.a("000001");
            if (a2 != null) {
                this.n.c("000001");
                a2.c(com.alimm.tanx.core.constant.AdConstants.PID_STYLE_DEFAULT_ID);
                this.n.a(a2);
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "OfflineDownloadManager", "changeBadCase");
        }
    }

    private void h() {
        if ("".equals(com.amap.api.mapcore.util.dl.c(this.i))) {
            return;
        }
        java.io.File file = new java.io.File(com.amap.api.mapcore.util.dl.c(this.i) + "offlinemapv4.png");
        java.lang.String a2 = !file.exists() ? com.amap.api.mapcore.util.bj.a(this.i, "offlinemapv4.png") : com.amap.api.mapcore.util.bj.c(file);
        if (a2 != null) {
            try {
                h(a2);
            } catch (org.json.JSONException e) {
                if (file.exists()) {
                    file.delete();
                }
                com.amap.api.mapcore.util.gd.c(e, "MapDownloadManager", "paseJson io");
                e.printStackTrace();
            }
        }
    }

    private void h(java.lang.String str) throws org.json.JSONException {
        com.amap.api.mapcore.util.aq aqVar;
        java.util.List<com.amap.api.maps.offlinemap.OfflineMapProvince> a2 = com.amap.api.mapcore.util.bj.a(str, this.i.getApplicationContext());
        if (a2 == null || a2.size() == 0 || (aqVar = this.f) == null) {
            return;
        }
        aqVar.a(a2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.amap.api.mapcore.util.al i(java.lang.String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        synchronized (this.c) {
            for (com.amap.api.mapcore.util.al alVar : this.c) {
                if (str.equals(alVar.getCity()) || str.equals(alVar.getPinyin())) {
                    return alVar;
                }
            }
            return null;
        }
    }

    private void i() {
        java.util.Iterator<com.amap.api.mapcore.util.aw> it = this.n.a().iterator();
        while (it.hasNext()) {
            com.amap.api.mapcore.util.aw next = it.next();
            if (next != null && next.c() != null && next.e().length() > 0) {
                int i = next.l;
                if (i != 4 && i != 7 && i >= 0) {
                    next.l = 3;
                }
                com.amap.api.mapcore.util.al i2 = i(next.c());
                if (i2 != null) {
                    java.lang.String d2 = next.d();
                    if (d2 == null || !b(d, d2)) {
                        i2.a(next.l);
                        i2.setCompleteCode(next.g());
                    } else {
                        i2.a(7);
                    }
                    if (next.d().length() > 0) {
                        i2.setVersion(next.d());
                    }
                    java.util.List<java.lang.String> b2 = this.n.b(next.e());
                    java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
                    java.util.Iterator<java.lang.String> it2 = b2.iterator();
                    while (it2.hasNext()) {
                        stringBuffer.append(it2.next());
                        stringBuffer.append(com.alipay.sdk.m.u.i.b);
                    }
                    i2.a(stringBuffer.toString());
                    com.amap.api.mapcore.util.aq aqVar = this.f;
                    if (aqVar != null) {
                        aqVar.a(i2);
                    }
                }
            }
        }
    }

    private com.amap.api.mapcore.util.al j(java.lang.String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        synchronized (this.c) {
            for (com.amap.api.mapcore.util.al alVar : this.c) {
                if (str.equals(alVar.getCode())) {
                    return alVar;
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() throws com.amap.api.maps.AMapException {
        if (!com.amap.api.mapcore.util.dl.d(this.i)) {
            throw new com.amap.api.maps.AMapException(com.amap.api.maps.AMapException.ERROR_CONNECTION);
        }
    }

    private static void k() {
        k = null;
        b = true;
    }

    private static void k(java.lang.String str) {
        a = str;
    }

    private void l() {
        synchronized (this) {
            this.l = null;
        }
    }

    public final void a() {
        this.n = com.amap.api.mapcore.util.bb.a(this.i.getApplicationContext());
        g();
        this.e = new com.amap.api.mapcore.util.am.b(this.i.getMainLooper());
        this.f = new com.amap.api.mapcore.util.aq(this.i);
        this.m = com.amap.api.mapcore.util.av.a();
        k(com.amap.api.mapcore.util.dl.c(this.i));
        try {
            h();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        synchronized (this.c) {
            java.util.Iterator<com.amap.api.maps.offlinemap.OfflineMapProvince> it = this.f.a().iterator();
            while (it.hasNext()) {
                java.util.Iterator<com.amap.api.maps.offlinemap.OfflineMapCity> it2 = it.next().getCityList().iterator();
                while (it2.hasNext()) {
                    com.amap.api.maps.offlinemap.OfflineMapCity next = it2.next();
                    if (next != null) {
                        this.c.add(new com.amap.api.mapcore.util.al(this.i, next));
                    }
                }
            }
        }
        com.amap.api.mapcore.util.ap apVar = new com.amap.api.mapcore.util.ap(this.i);
        this.h = apVar;
        apVar.start();
    }

    public final void a(com.amap.api.mapcore.util.al alVar) {
        a(alVar, false);
    }

    public final void a(com.amap.api.mapcore.util.am.a aVar) {
        this.l = aVar;
    }

    public final void a(java.lang.String str) {
        try {
            if (str != null) {
                if (this.o == null) {
                    this.o = com.amap.api.mapcore.util.dk.a("AMapOfflineCheckUpdate");
                }
                this.o.a(new com.amap.api.mapcore.util.am.AnonymousClass1(str));
            } else {
                com.amap.api.mapcore.util.am.a aVar = this.l;
                if (aVar != null) {
                    aVar.b(null);
                }
            }
        } catch (java.lang.Throwable th) {
            com.amap.api.mapcore.util.gd.c(th, "OfflineDownloadManager", "checkUpdate");
        }
    }

    public final void b() {
        i();
        com.amap.api.mapcore.util.am.a aVar = this.l;
        if (aVar != null) {
            try {
                aVar.a();
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, "OfflineDownloadManager", "verifyCallBack");
            }
        }
    }

    public final void b(com.amap.api.mapcore.util.al alVar) {
        try {
            com.amap.api.mapcore.util.av avVar = this.m;
            if (avVar != null) {
                avVar.a(alVar, this.i);
            }
        } catch (com.amap.api.mapcore.util.eu e) {
            e.printStackTrace();
        }
    }

    public final boolean b(java.lang.String str) {
        return i(str) != null;
    }

    public final void c() throws com.amap.api.maps.AMapException {
        if (this.f == null) {
            return;
        }
        com.amap.api.mapcore.util.at atVar = new com.amap.api.mapcore.util.at(this.i, "");
        atVar.a(this.i);
        java.util.List<com.amap.api.maps.offlinemap.OfflineMapProvince> c = atVar.c();
        if (this.c != null) {
            this.f.a(c);
        }
        java.util.List<com.amap.api.mapcore.util.al> list = this.c;
        if (list != null) {
            synchronized (list) {
                java.util.Iterator<com.amap.api.maps.offlinemap.OfflineMapProvince> it = this.f.a().iterator();
                while (it.hasNext()) {
                    java.util.Iterator<com.amap.api.maps.offlinemap.OfflineMapCity> it2 = it.next().getCityList().iterator();
                    while (it2.hasNext()) {
                        com.amap.api.maps.offlinemap.OfflineMapCity next = it2.next();
                        for (com.amap.api.mapcore.util.al alVar : this.c) {
                            if (next.getPinyin().equals(alVar.getPinyin())) {
                                java.lang.String version = alVar.getVersion();
                                if (alVar.getState() == 4 && d.length() > 0 && b(d, version)) {
                                    alVar.j();
                                    alVar.setUrl(next.getUrl());
                                    alVar.s();
                                } else {
                                    alVar.setCity(next.getCity());
                                    alVar.setUrl(next.getUrl());
                                    alVar.s();
                                    alVar.setAdcode(next.getAdcode());
                                    alVar.setVersion(next.getVersion());
                                    alVar.setSize(next.getSize());
                                    alVar.setCode(next.getCode());
                                    alVar.setJianpin(next.getJianpin());
                                    alVar.setPinyin(next.getPinyin());
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public final void c(com.amap.api.mapcore.util.al alVar) {
        com.amap.api.mapcore.util.aq aqVar = this.f;
        if (aqVar != null) {
            aqVar.a(alVar);
        }
        com.amap.api.mapcore.util.am.b bVar = this.e;
        if (bVar != null) {
            android.os.Message obtainMessage = bVar.obtainMessage();
            obtainMessage.obj = alVar;
            this.e.sendMessage(obtainMessage);
        }
    }

    public final void c(java.lang.String str) {
        com.amap.api.mapcore.util.al i = i(str);
        if (i != null) {
            d(i);
            a(i, true);
            return;
        }
        com.amap.api.mapcore.util.am.a aVar = this.l;
        if (aVar != null) {
            try {
                aVar.c(i);
            } catch (java.lang.Throwable th) {
                com.amap.api.mapcore.util.gd.c(th, "OfflineDownloadManager", "remove");
            }
        }
    }

    public final void d() {
        synchronized (this.c) {
            for (com.amap.api.mapcore.util.al alVar : this.c) {
                if (alVar.c().equals(alVar.c) || alVar.c().equals(alVar.b)) {
                    d(alVar);
                    alVar.g();
                }
            }
        }
    }

    public final void d(com.amap.api.mapcore.util.al alVar) {
        com.amap.api.mapcore.util.av avVar = this.m;
        if (avVar != null) {
            avVar.a(alVar);
        }
    }

    public final void d(java.lang.String str) {
        com.amap.api.mapcore.util.al i = i(str);
        if (i != null) {
            i.f();
        }
    }

    public final void e() {
        synchronized (this.c) {
            java.util.Iterator<com.amap.api.mapcore.util.al> it = this.c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.amap.api.mapcore.util.al next = it.next();
                if (next.c().equals(next.c)) {
                    next.g();
                    break;
                }
            }
        }
    }

    public final void e(com.amap.api.mapcore.util.al alVar) {
        com.amap.api.mapcore.util.av avVar = this.m;
        if (avVar != null) {
            avVar.b(alVar);
        }
    }

    public final void e(java.lang.String str) throws com.amap.api.maps.AMapException {
        com.amap.api.mapcore.util.al i = i(str);
        if (str == null || str.length() <= 0 || i == null) {
            throw new com.amap.api.maps.AMapException("无效的参数 - IllegalArgumentException");
        }
        f(i);
    }

    public final void f() {
        com.amap.api.mapcore.util.ii iiVar = this.o;
        if (iiVar != null) {
            iiVar.d();
        }
        com.amap.api.mapcore.util.ii iiVar2 = this.q;
        if (iiVar2 != null) {
            iiVar2.d();
            this.q = null;
        }
        com.amap.api.mapcore.util.ap apVar = this.h;
        if (apVar != null) {
            if (apVar.isAlive()) {
                this.h.interrupt();
            }
            this.h = null;
        }
        com.amap.api.mapcore.util.am.b bVar = this.e;
        if (bVar != null) {
            bVar.removeCallbacksAndMessages(null);
            this.e = null;
        }
        com.amap.api.mapcore.util.av avVar = this.m;
        if (avVar != null) {
            avVar.b();
            this.m = null;
        }
        com.amap.api.mapcore.util.aq aqVar = this.f;
        if (aqVar != null) {
            aqVar.g();
        }
        k();
        this.j = true;
        l();
    }

    public final void f(java.lang.String str) throws com.amap.api.maps.AMapException {
        com.amap.api.mapcore.util.al j = j(str);
        if (j == null) {
            throw new com.amap.api.maps.AMapException("无效的参数 - IllegalArgumentException");
        }
        f(j);
    }

    public final java.lang.String g(java.lang.String str) {
        com.amap.api.mapcore.util.al i;
        return (str == null || (i = i(str)) == null) ? "" : i.getAdcode();
    }
}
