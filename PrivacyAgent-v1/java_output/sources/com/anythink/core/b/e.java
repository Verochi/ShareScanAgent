package com.anythink.core.b;

import com.anythink.core.b.i.AnonymousClass1;

/* loaded from: classes12.dex */
public abstract class e extends com.anythink.core.b.d {
    public static final double i = 10000.0d;
    final java.lang.String j;
    protected final java.util.List<org.json.JSONObject> k;
    java.util.List<com.anythink.core.common.f.au> l;
    java.util.List<com.anythink.core.common.f.au> m;
    java.lang.String n;
    java.lang.String o;
    java.lang.String p;
    com.anythink.core.b.b.a q;
    long r;

    /* renamed from: s, reason: collision with root package name */
    protected java.util.concurrent.atomic.AtomicBoolean f158s;
    protected java.util.concurrent.atomic.AtomicBoolean t;
    java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.core.common.f.au> u;
    java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.core.common.f.au> v;
    java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.core.common.f.au> w;
    java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.core.common.f.au> x;
    com.anythink.core.common.m.b y;

    /* renamed from: com.anythink.core.b.e$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.core.common.m.b {

        /* renamed from: com.anythink.core.b.e$1$1, reason: invalid class name and collision with other inner class name */
        public class RunnableC01601 implements java.lang.Runnable {
            public RunnableC01601() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.core.b.e.this.g();
            }
        }

        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.anythink.core.common.o.b.b.a().a(new com.anythink.core.b.e.AnonymousClass1.RunnableC01601());
        }
    }

    /* renamed from: com.anythink.core.b.e$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.core.b.i.a {
        public AnonymousClass2() {
        }

        @Override // com.anythink.core.b.i.a
        public final void a(com.anythink.core.common.f.au auVar, com.anythink.core.api.ATBaseAdAdapter aTBaseAdAdapter) {
            com.anythink.core.b.b.a aVar = com.anythink.core.b.e.this.q;
            if (aVar != null) {
                aVar.a(auVar, aTBaseAdAdapter);
            }
        }

        @Override // com.anythink.core.b.i.a
        public final void a(com.anythink.core.common.f.au auVar, org.json.JSONObject jSONObject) {
            if (com.anythink.core.b.e.this.h.get()) {
                return;
            }
            com.anythink.core.b.e.this.w.remove(auVar.u());
            com.anythink.core.b.e.a(com.anythink.core.b.e.this, auVar);
            if (!com.anythink.core.b.e.this.f158s.get() || (com.anythink.core.b.e.this.f158s.get() && com.anythink.core.b.e.this.f.n.g())) {
                com.anythink.core.b.e.a(com.anythink.core.b.e.this, jSONObject, auVar);
            } else {
                a(com.anythink.core.api.ATBidRequestInfo.BIDTOKEN_OBTAIN_TIMEOUT_TYPE, auVar);
            }
        }

        @Override // com.anythink.core.b.i.a
        public final void a(java.lang.String str, com.anythink.core.common.f.au auVar) {
            if (com.anythink.core.b.e.this.h.get()) {
                return;
            }
            if (str == null) {
                str = "";
            }
            com.anythink.core.b.e.this.w.remove(auVar.u());
            com.anythink.core.b.e.this.u.remove(auVar.u());
            com.anythink.core.b.e.a(com.anythink.core.b.e.this, str, auVar);
            switch (str) {
                case "Request Token or Custom bid info Timeout.":
                case "Network BidToken or Custom bid info is Empty.":
                    com.anythink.core.b.e.this.b(auVar, str, 0L, -2);
                    break;
                case "Network init error.":
                case "This network don't support header bidding in current AT's version.":
                case "The parameter is abnormal.":
                case "There is no Network Adapter.":
                    com.anythink.core.b.e.this.b(auVar, str, 0L, -9);
                    break;
                default:
                    com.anythink.core.b.e.this.b(auVar, "Unknown error: ".concat(str), 0L, -9);
                    break;
            }
            com.anythink.core.b.e.a(com.anythink.core.b.e.this, (org.json.JSONObject) null, (com.anythink.core.common.f.au) null);
        }
    }

    /* renamed from: com.anythink.core.b.e$3, reason: invalid class name */
    public class AnonymousClass3 implements com.anythink.core.common.h.k {
        final /* synthetic */ long a;
        final /* synthetic */ java.util.Map b;

        public AnonymousClass3(long j, java.util.Map map) {
            this.a = j;
            this.b = map;
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadCanceled(int i) {
            synchronized (com.anythink.core.b.e.this) {
                com.anythink.core.b.e.this.t.set(false);
                com.anythink.core.b.e.this.d();
                com.anythink.core.b.e.this.a((java.util.List<com.anythink.core.common.f.q>) null, android.os.SystemClock.elapsedRealtime() - this.a, "onLoadCanceled.", (java.util.Map<java.lang.String, com.anythink.core.common.f.au>) this.b);
            }
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadError(int i, java.lang.String str, com.anythink.core.api.AdError adError) {
            synchronized (com.anythink.core.b.e.this) {
                com.anythink.core.b.e.this.t.set(false);
                com.anythink.core.b.e.this.d();
                com.anythink.core.b.e.this.a((java.util.List<com.anythink.core.common.f.q>) null, android.os.SystemClock.elapsedRealtime() - this.a, adError != null ? adError.getPlatformMSG() : "", (java.util.Map<java.lang.String, com.anythink.core.common.f.au>) this.b);
            }
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadFinish(int i, java.lang.Object obj) {
            synchronized (com.anythink.core.b.e.this) {
                com.anythink.core.b.e.this.t.set(false);
                long elapsedRealtime = android.os.SystemClock.elapsedRealtime() - this.a;
                java.util.ArrayList arrayList = new java.util.ArrayList();
                if (obj instanceof org.json.JSONObject) {
                    org.json.JSONArray optJSONArray = ((org.json.JSONObject) obj).optJSONArray("data");
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        arrayList.add(com.anythink.core.common.f.q.a(optJSONArray.optString(i2)));
                    }
                }
                com.anythink.core.b.e.this.a(arrayList, elapsedRealtime, (java.lang.String) null, (java.util.Map<java.lang.String, com.anythink.core.common.f.au>) this.b);
                com.anythink.core.b.e.this.d();
            }
        }

        @Override // com.anythink.core.common.h.k
        public final void onLoadStart(int i) {
        }
    }

    /* renamed from: com.anythink.core.b.e$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            synchronized (com.anythink.core.b.e.this) {
                if (com.anythink.core.b.e.this.e()) {
                    com.anythink.core.b.e.this.b(android.os.SystemClock.elapsedRealtime());
                }
            }
        }
    }

    public e(com.anythink.core.common.f.a aVar) {
        super(aVar);
        this.j = getClass().getSimpleName() + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR;
        this.k = new java.util.ArrayList();
        this.l = new java.util.ArrayList();
        this.m = new java.util.ArrayList();
        this.f158s = new java.util.concurrent.atomic.AtomicBoolean(false);
        this.t = new java.util.concurrent.atomic.AtomicBoolean(false);
        this.u = new java.util.concurrent.ConcurrentHashMap<>();
        this.v = new java.util.concurrent.ConcurrentHashMap<>();
        this.w = new java.util.concurrent.ConcurrentHashMap<>();
        this.x = new java.util.concurrent.ConcurrentHashMap<>();
        this.y = new com.anythink.core.b.e.AnonymousClass1();
        java.util.List<com.anythink.core.common.f.au> list = aVar.j;
        if (list != null && list.size() > 0) {
            for (com.anythink.core.common.f.au auVar : aVar.j) {
                if (auVar != null) {
                    this.u.put(auVar.u(), auVar);
                    this.w.put(auVar.u(), auVar);
                }
            }
        }
        java.util.List<com.anythink.core.common.f.au> list2 = aVar.k;
        if (list2 != null && list2.size() > 0) {
            for (com.anythink.core.common.f.au auVar2 : aVar.k) {
                this.v.put(auVar2.u(), auVar2);
                this.x.put(auVar2.u(), auVar2);
            }
        }
        org.json.JSONObject jSONObject = aVar.r;
        if (jSONObject != null) {
            this.k.add(jSONObject);
        }
        this.n = aVar.d;
        this.o = aVar.e;
        this.p = b();
    }

    private static java.util.List<com.anythink.core.common.f.q> a(java.lang.Object obj) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (obj instanceof org.json.JSONObject) {
            org.json.JSONArray optJSONArray = ((org.json.JSONObject) obj).optJSONArray("data");
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                arrayList.add(com.anythink.core.common.f.q.a(optJSONArray.optString(i2)));
            }
        }
        return arrayList;
    }

    private void a(long j) {
        com.anythink.core.common.m.d.a().a(this.y, j, false);
    }

    private void a(long j, int i2, java.lang.String str, java.util.Map<java.lang.String, com.anythink.core.common.f.au> map) {
        for (com.anythink.core.common.f.au auVar : map.values()) {
            if (a(auVar, str, i2)) {
                this.m.add(auVar);
            } else {
                b(auVar, str, j, i2);
            }
        }
        map.clear();
    }

    public static /* synthetic */ void a(com.anythink.core.b.e eVar, com.anythink.core.common.f.au auVar) {
        int d = auVar.d();
        com.anythink.core.common.n.c.a(auVar, eVar.f, android.os.SystemClock.elapsedRealtime() - eVar.r, true, com.anythink.core.b.f.a().b(d));
        com.anythink.core.b.f.a().a(d);
    }

    public static /* synthetic */ void a(com.anythink.core.b.e eVar, java.lang.String str, com.anythink.core.common.f.au auVar) {
        if (android.text.TextUtils.equals(str, com.anythink.core.api.ATBidRequestInfo.NO_ADAPTER_ERROR_TYPE) || android.text.TextUtils.equals(str, com.anythink.core.api.ATBidRequestInfo.NO_SUPPORT_BIDDING_TYPE)) {
            return;
        }
        int d = auVar.d();
        com.anythink.core.common.n.c.a(auVar, eVar.f, android.os.SystemClock.elapsedRealtime() - eVar.r, false, com.anythink.core.b.f.a().b(d));
        com.anythink.core.b.f.a().a(d);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0050 A[Catch: all -> 0x0071, TryCatch #0 {, blocks: (B:10:0x001f, B:14:0x002d, B:17:0x0037, B:19:0x003f, B:26:0x0050, B:27:0x0055), top: B:9:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0057 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void a(com.anythink.core.b.e eVar, org.json.JSONObject jSONObject, com.anythink.core.common.f.au auVar) {
        boolean z;
        java.lang.String str = eVar.j;
        boolean z2 = true;
        if (eVar.w.size() == 0) {
            eVar.f();
            if (!eVar.t.get()) {
                z = true;
                synchronized (eVar) {
                    if (jSONObject != null && auVar != null) {
                        eVar.k.add(jSONObject);
                        eVar.x.put(auVar.u(), auVar);
                    }
                    if (eVar.k.size() > 0) {
                        if (!z) {
                            if (eVar.f158s.get() && !eVar.t.get()) {
                            }
                        }
                        if (!z2) {
                            eVar.b(eVar.r);
                            return;
                        } else {
                            if (eVar.l.size() <= 0 || !eVar.m()) {
                                return;
                            }
                            eVar.a((java.util.List<com.anythink.core.common.f.q>) null, 0L, "", (java.util.Map<java.lang.String, com.anythink.core.common.f.au>) null);
                            return;
                        }
                    }
                    z2 = false;
                    if (!z2) {
                    }
                }
            }
        }
        z = false;
        synchronized (eVar) {
        }
    }

    private void a(java.lang.String str, com.anythink.core.common.f.au auVar) {
        if (android.text.TextUtils.equals(str, com.anythink.core.api.ATBidRequestInfo.NO_ADAPTER_ERROR_TYPE) || android.text.TextUtils.equals(str, com.anythink.core.api.ATBidRequestInfo.NO_SUPPORT_BIDDING_TYPE)) {
            return;
        }
        int d = auVar.d();
        com.anythink.core.common.n.c.a(auVar, this.f, android.os.SystemClock.elapsedRealtime() - this.r, false, com.anythink.core.b.f.a().b(d));
        com.anythink.core.b.f.a().a(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(java.util.List<com.anythink.core.common.f.q> list, long j, java.lang.String str, java.util.Map<java.lang.String, com.anythink.core.common.f.au> map) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    java.util.Collections.sort(list);
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        com.anythink.core.common.f.q qVar = list.get(i2);
                        this.u.remove(qVar.k);
                        com.anythink.core.common.f.au remove = map.remove(qVar.k);
                        if (remove == null && this.v.containsKey(qVar.k)) {
                            remove = this.v.remove(qVar.k);
                            this.v.clear();
                        }
                        com.anythink.core.common.f.au auVar = remove;
                        if (auVar != null) {
                            if (qVar.isSuccessWithUseType()) {
                                int i3 = i2 + 1;
                                a(auVar.d(), qVar, i3 < list.size() ? list.get(i3).getSortPrice() : 0.0d, qVar.isSamePrice());
                            }
                            a(auVar, qVar, j);
                        }
                    }
                }
            } catch (java.lang.Throwable th) {
                throw th;
            }
        }
        if (map != null) {
            for (java.lang.String str2 : map.keySet()) {
                if (str2 != null) {
                    this.u.remove(str2);
                }
                if (this.v.containsKey(str2)) {
                    this.v.clear();
                }
            }
        }
        if (map != null) {
            a(j, -4, android.text.TextUtils.isEmpty(str) ? "No Response error." : "No Response error." + str, map);
        }
        if (this.m.size() >= 2) {
            java.util.Collections.sort(this.m);
        }
        l();
        k();
        j();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004e A[Catch: all -> 0x006f, TryCatch #0 {, blocks: (B:10:0x001d, B:14:0x002b, B:17:0x0035, B:19:0x003d, B:26:0x004e, B:27:0x0053), top: B:9:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0055 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(org.json.JSONObject jSONObject, com.anythink.core.common.f.au auVar) {
        boolean z;
        boolean z2 = true;
        if (this.w.size() == 0) {
            f();
            if (!this.t.get()) {
                z = true;
                synchronized (this) {
                    if (jSONObject != null && auVar != null) {
                        this.k.add(jSONObject);
                        this.x.put(auVar.u(), auVar);
                    }
                    if (this.k.size() > 0) {
                        if (!z) {
                            if (this.f158s.get() && !this.t.get()) {
                            }
                        }
                        if (!z2) {
                            b(this.r);
                            return;
                        } else {
                            if (this.l.size() <= 0 || !m()) {
                                return;
                            }
                            a((java.util.List<com.anythink.core.common.f.q>) null, 0L, "", (java.util.Map<java.lang.String, com.anythink.core.common.f.au>) null);
                            return;
                        }
                    }
                    z2 = false;
                    if (!z2) {
                    }
                }
            }
        }
        z = false;
        synchronized (this) {
        }
    }

    private static /* synthetic */ java.util.List b(java.lang.Object obj) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (obj instanceof org.json.JSONObject) {
            org.json.JSONArray optJSONArray = ((org.json.JSONObject) obj).optJSONArray("data");
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                arrayList.add(com.anythink.core.common.f.q.a(optJSONArray.optString(i2)));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(long j) {
        if (this.t.get()) {
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.concurrent.ConcurrentHashMap concurrentHashMap = new java.util.concurrent.ConcurrentHashMap();
        a(arrayList, concurrentHashMap);
        this.t.set(true);
        a(arrayList, new com.anythink.core.b.e.AnonymousClass3(j, concurrentHashMap));
    }

    private void b(com.anythink.core.common.f.au auVar) {
        int d = auVar.d();
        com.anythink.core.common.n.c.a(auVar, this.f, android.os.SystemClock.elapsedRealtime() - this.r, true, com.anythink.core.b.f.a().b(d));
        com.anythink.core.b.f.a().a(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(com.anythink.core.common.f.au auVar, java.lang.String str, long j, int i2) {
        com.anythink.core.b.d.a(auVar, str, j, i2);
        this.l.add(auVar);
    }

    private void f() {
        com.anythink.core.common.m.d.a().b(this.y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g() {
        if (this.h.get()) {
            return;
        }
        this.f158s.set(true);
        if (this.k.size() > 0) {
            b(android.os.SystemClock.elapsedRealtime());
        }
    }

    private boolean h() {
        return this.f158s.get() && !this.t.get();
    }

    private synchronized void i() {
        if (!this.h.get()) {
            this.h.set(true);
            f();
            this.w.clear();
            a(0L, -3, com.anythink.core.api.ATBidRequestInfo.BIDDING_REQUEST_TIMEOUT_TYPE, this.u);
            a(0L, -3, com.anythink.core.api.ATBidRequestInfo.BIDDING_REQUEST_TIMEOUT_TYPE, this.v);
            l();
            k();
            j();
        }
    }

    private void j() {
        com.anythink.core.b.b.a aVar;
        if ((this.m.size() > 0 || this.l.size() > 0) && (aVar = this.q) != null) {
            aVar.a(this.m, this.l);
        }
        this.m.clear();
        this.l.clear();
    }

    private synchronized void k() {
        if (m()) {
            this.h.set(true);
        }
    }

    private void l() {
        if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
            if (this.m.size() > 0 || this.l.size() > 0) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                try {
                    jSONObject.put("S2S HeadBidding Success List", com.anythink.core.b.d.a(this.m));
                    jSONObject.put("S2S HeadBidding Fail List", com.anythink.core.b.d.a(this.l));
                } catch (java.lang.Exception unused) {
                }
                com.anythink.core.common.o.o.a(com.anythink.core.common.o.o.a, jSONObject.toString(), false);
            }
        }
    }

    private boolean m() {
        return this.u.size() == 0 && this.v.size() == 0 && this.w.size() == 0;
    }

    @Override // com.anythink.core.b.d
    public final void a() {
        i();
    }

    @Override // com.anythink.core.b.d
    public final void a(com.anythink.core.b.b.a aVar) {
        java.util.List<com.anythink.core.common.f.au> list;
        this.r = android.os.SystemClock.elapsedRealtime();
        this.q = aVar;
        if (com.anythink.core.api.ATSDK.isNetworkLogDebug()) {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put("S2S Start HeadBidding List", com.anythink.core.b.d.a(this.f.j));
                jSONObject.put("S2S Start HeadBidding List(Directly)", com.anythink.core.b.d.b(this.k));
            } catch (java.lang.Exception unused) {
            }
            com.anythink.core.common.o.o.a(com.anythink.core.common.o.o.a, jSONObject.toString(), false);
        }
        if (this.f.j.size() == 0 && (list = this.f.k) != null && list.size() > 0) {
            b(this.r);
            return;
        }
        long o = this.f.n.o();
        if (o <= 0) {
            o = 500;
        }
        com.anythink.core.common.m.d.a().a(this.y, o, false);
        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.anythink.core.common.f.au>> it = this.u.entrySet().iterator();
        while (it.hasNext()) {
            com.anythink.core.common.f.au value = it.next().getValue();
            com.anythink.core.b.i iVar = new com.anythink.core.b.i(this.f);
            com.anythink.core.b.e.AnonymousClass2 anonymousClass2 = new com.anythink.core.b.e.AnonymousClass2();
            iVar.d = anonymousClass2;
            com.anythink.core.api.ATBaseAdAdapter a = com.anythink.core.common.o.j.a(value);
            if (a == null) {
                anonymousClass2.a(com.anythink.core.api.ATBidRequestInfo.NO_ADAPTER_ERROR_TYPE, value);
            } else {
                com.anythink.core.common.o.b.b.a().a(iVar.new AnonymousClass1(a, value));
            }
        }
    }

    @Override // com.anythink.core.b.d
    public void a(com.anythink.core.common.f.au auVar, com.anythink.core.common.f.o oVar, long j) {
        java.lang.String str;
        int i2;
        if (oVar instanceof com.anythink.core.common.f.q) {
            com.anythink.core.common.f.q qVar = (com.anythink.core.common.f.q) oVar;
            if (qVar.isSuccessWithUseType()) {
                auVar.a(j);
                this.m.add(auVar);
                if (auVar.m() == 3 || auVar.m() == 7) {
                    qVar.f = qVar.e + java.lang.System.currentTimeMillis();
                } else {
                    qVar.f = auVar.o() + java.lang.System.currentTimeMillis();
                }
                a(auVar, qVar);
                return;
            }
            int i3 = 0;
            if (qVar.useType == 2) {
                auVar.P();
                str = "filter by s2s bid max count";
                i3 = 1;
                i2 = 0;
            } else {
                str = "errorCode:[" + qVar.a + "],errorMsg:[" + qVar.errorMsg + "]";
                i2 = -1;
            }
            if (a(auVar, str, i2, i3)) {
                this.m.add(auVar);
            } else {
                b(auVar, str, j, i2);
            }
        }
    }

    public abstract void a(java.util.List<org.json.JSONObject> list, com.anythink.core.common.h.k kVar);

    public synchronized void a(java.util.List<org.json.JSONObject> list, java.util.Map<java.lang.String, com.anythink.core.common.f.au> map) {
        list.addAll(this.k);
        this.k.clear();
        map.putAll(this.x);
        this.x.clear();
    }

    @Override // com.anythink.core.b.d
    public final void a(boolean z) {
        this.g = z;
    }

    public abstract java.lang.String b();

    public final synchronized void d() {
        if (e()) {
            com.anythink.core.common.o.b.b.a().a(new com.anythink.core.b.e.AnonymousClass4());
        }
    }

    public final boolean e() {
        return !this.t.get() && this.k.size() > 0;
    }
}
