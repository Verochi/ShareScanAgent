package com.igexin.push.c;

import com.igexin.push.c.e.AnonymousClass1;

/* loaded from: classes31.dex */
public abstract class h {
    private static final java.lang.String e = com.igexin.push.c.b.a + com.igexin.push.c.h.class.getName();
    protected long a;
    private android.os.Handler i;
    protected final java.util.Map<java.lang.String, com.igexin.push.c.e> b = new java.util.LinkedHashMap();
    protected final java.util.Map<java.lang.String, com.igexin.push.c.d> c = new java.util.HashMap();
    private final java.lang.Object f = new java.lang.Object();
    private final java.lang.Object g = new java.lang.Object();
    protected com.igexin.push.c.a d = new com.igexin.push.c.a();
    private final java.util.Comparator<java.util.Map.Entry<java.lang.String, com.igexin.push.c.d>> h = new com.igexin.push.c.h.AnonymousClass1();

    /* renamed from: com.igexin.push.c.h$1, reason: invalid class name */
    /* loaded from: classes23.dex */
    public class AnonymousClass1 implements java.util.Comparator<java.util.Map.Entry<java.lang.String, com.igexin.push.c.d>> {
        public AnonymousClass1() {
        }

        private static int a(java.util.Map.Entry<java.lang.String, com.igexin.push.c.d> entry, java.util.Map.Entry<java.lang.String, com.igexin.push.c.d> entry2) {
            return (int) (entry.getValue().c() - entry2.getValue().c());
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(java.util.Map.Entry<java.lang.String, com.igexin.push.c.d> entry, java.util.Map.Entry<java.lang.String, com.igexin.push.c.d> entry2) {
            return (int) (entry.getValue().c() - entry2.getValue().c());
        }
    }

    /* renamed from: com.igexin.push.c.h$2, reason: invalid class name */
    /* loaded from: classes23.dex */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            java.lang.String unused = com.igexin.push.c.h.e;
            try {
                com.igexin.push.c.h.this.j();
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0103 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public h(java.lang.String str, java.lang.String str2) {
        org.json.JSONObject jSONObject;
        org.json.JSONArray jSONArray;
        java.util.List<java.lang.String> a;
        if (!com.igexin.push.config.SDKUrlConfig.hasMultipleXfr()) {
            a();
            return;
        }
        org.json.JSONObject jSONObject2 = null;
        if (!android.text.TextUtils.isEmpty(str)) {
            try {
                jSONObject = new org.json.JSONObject(str);
            } catch (org.json.JSONException e2) {
                com.igexin.c.a.c.a.a(e2);
                jSONObject = null;
            }
            if (jSONObject != null && jSONObject.length() != 0) {
                if (jSONObject.has("lastDetectTime")) {
                    try {
                        this.a = jSONObject.getLong("lastDetectTime");
                    } catch (org.json.JSONException e3) {
                        com.igexin.c.a.c.a.a(e3);
                    }
                }
                if (java.lang.Math.abs(java.lang.System.currentTimeMillis() - this.a) < com.igexin.push.c.b.c) {
                    if (jSONObject.has(org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_LIST)) {
                        try {
                            jSONArray = jSONObject.getJSONArray(org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_LIST);
                        } catch (org.json.JSONException e4) {
                            com.igexin.c.a.c.a.a(e4);
                        }
                        if (jSONArray != null && jSONArray.length() != 0) {
                            a = a(jSONArray);
                            if (!a.isEmpty()) {
                                java.util.List<java.lang.String> defaultXfrList = com.igexin.push.config.SDKUrlConfig.getDefaultXfrList();
                                java.util.ArrayList arrayList = new java.util.ArrayList(defaultXfrList);
                                arrayList.retainAll(a);
                                if (arrayList.size() == a.size()) {
                                    java.lang.String str3 = e;
                                    com.igexin.c.a.c.a.a(str3, "db cache xfr == default, use cache");
                                    com.igexin.c.a.c.a.a(str3 + " | db cache xfr == default, use cache", new java.lang.Object[0]);
                                    b(jSONArray);
                                    if (android.text.TextUtils.isEmpty(str2)) {
                                        try {
                                            jSONObject2 = new org.json.JSONObject(str2);
                                        } catch (org.json.JSONException e5) {
                                            com.igexin.c.a.c.a.a(e5);
                                        }
                                        if (jSONObject2 == null || jSONObject2.length() == 0) {
                                            return;
                                        }
                                        if (jSONObject2.has("loginFailedlCnt")) {
                                            try {
                                                this.d.g = jSONObject2.getInt("loginFailedlCnt");
                                            } catch (org.json.JSONException e6) {
                                                com.igexin.c.a.c.a.a(e6);
                                            }
                                        }
                                        if (jSONObject2.has("lastChange2BackupTime")) {
                                            try {
                                                this.d.h = jSONObject2.getLong("lastChange2BackupTime");
                                            } catch (org.json.JSONException e7) {
                                                com.igexin.c.a.c.a.a(e7);
                                            }
                                        }
                                        if (jSONObject2.has("lastOfflineTime")) {
                                            try {
                                                this.d.i = jSONObject2.getLong("lastOfflineTime");
                                            } catch (org.json.JSONException e8) {
                                                com.igexin.c.a.c.a.a(e8);
                                            }
                                        }
                                        if (jSONObject2.has("domainType")) {
                                            try {
                                                this.d.e = com.igexin.push.c.a.EnumC0370a.a(jSONObject2.getInt("domainType"));
                                                if (this.d.e == com.igexin.push.c.a.EnumC0370a.BACKUP) {
                                                    this.d.f.set(true);
                                                    return;
                                                }
                                                return;
                                            } catch (org.json.JSONException e9) {
                                                com.igexin.c.a.c.a.a(e9);
                                                return;
                                            }
                                        }
                                        return;
                                    }
                                    return;
                                }
                                java.lang.String str4 = e;
                                com.igexin.c.a.c.a.a(str4, "db cache xfr != default, use default");
                                com.igexin.c.a.c.a.a(str4 + " | db cache xfr != default, use default", new java.lang.Object[0]);
                                arrayList.clear();
                                defaultXfrList.clear();
                                a.clear();
                            }
                        }
                    }
                    jSONArray = null;
                    if (jSONArray != null) {
                        a = a(jSONArray);
                        if (!a.isEmpty()) {
                        }
                    }
                }
            }
        }
        a();
        if (android.text.TextUtils.isEmpty(str2)) {
        }
    }

    private static com.igexin.push.c.d a(org.json.JSONObject jSONObject) throws java.lang.Exception {
        if (!jSONObject.has("domain")) {
            return null;
        }
        com.igexin.push.c.d dVar = new com.igexin.push.c.d();
        dVar.a(jSONObject.getString("domain"));
        if (jSONObject.has(tv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_PORT)) {
            dVar.b = jSONObject.getInt(tv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_PORT);
        }
        if (jSONObject.has("ip")) {
            dVar.a = jSONObject.getString("ip");
        }
        if (jSONObject.has("consumeTime")) {
            dVar.c = jSONObject.getLong("consumeTime");
        }
        if (jSONObject.has("detectSuccessTime")) {
            dVar.d = jSONObject.getLong("detectSuccessTime");
        }
        if (jSONObject.has("isDomain")) {
            dVar.e = jSONObject.getBoolean("isDomain");
        }
        return dVar;
    }

    private static java.util.List<java.lang.String> a(org.json.JSONArray jSONArray) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                arrayList.add(jSONArray.getJSONObject(i).getString("domain"));
            } catch (java.lang.Exception e2) {
                com.igexin.c.a.c.a.a(e2);
            }
        }
        return arrayList;
    }

    private void a() {
        this.a = 0L;
        if (r()) {
            if (com.igexin.push.core.e.ap != null) {
                com.igexin.push.core.e.f.a().b(com.igexin.push.core.b.m, true);
            }
        } else if (com.igexin.push.core.e.aq != null) {
            com.igexin.push.core.e.f.a().b(com.igexin.push.core.b.m, false);
        }
        java.util.List<java.lang.String> defaultXfrList = com.igexin.push.config.SDKUrlConfig.getDefaultXfrList();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.String str : defaultXfrList) {
            com.igexin.push.c.d dVar = new com.igexin.push.c.d(str, java.lang.Integer.parseInt(com.igexin.c.a.b.g.a(str)[2]));
            if (defaultXfrList.size() > 1) {
                b(dVar);
            }
            arrayList.add(dVar);
        }
        this.d.b(arrayList);
        defaultXfrList.clear();
    }

    private static java.util.List<java.lang.String> b() {
        return com.igexin.push.config.SDKUrlConfig.getDefaultXfrList();
    }

    private void b(com.igexin.push.c.d dVar) {
        com.igexin.push.c.e eVar = new com.igexin.push.c.e();
        eVar.d = c() == com.igexin.push.c.b.EnumC0371b.a;
        eVar.a(d());
        eVar.b = dVar;
        synchronized (this.g) {
            this.b.put(dVar.a(), eVar);
        }
    }

    private void b(java.lang.String str) {
        org.json.JSONObject jSONObject;
        if (android.text.TextUtils.isEmpty(str)) {
            a();
            return;
        }
        org.json.JSONArray jSONArray = null;
        try {
            jSONObject = new org.json.JSONObject(str);
        } catch (org.json.JSONException e2) {
            com.igexin.c.a.c.a.a(e2);
            jSONObject = null;
        }
        if (jSONObject == null || jSONObject.length() == 0) {
            a();
            return;
        }
        if (jSONObject.has("lastDetectTime")) {
            try {
                this.a = jSONObject.getLong("lastDetectTime");
            } catch (org.json.JSONException e3) {
                com.igexin.c.a.c.a.a(e3);
            }
        }
        if (java.lang.Math.abs(java.lang.System.currentTimeMillis() - this.a) >= com.igexin.push.c.b.c) {
            a();
            return;
        }
        if (jSONObject.has(org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_LIST)) {
            try {
                jSONArray = jSONObject.getJSONArray(org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_LIST);
            } catch (org.json.JSONException e4) {
                com.igexin.c.a.c.a.a(e4);
            }
        }
        if (jSONArray == null || jSONArray.length() == 0) {
            a();
            return;
        }
        java.util.List<java.lang.String> a = a(jSONArray);
        if (a.isEmpty()) {
            a();
            return;
        }
        java.util.List<java.lang.String> defaultXfrList = com.igexin.push.config.SDKUrlConfig.getDefaultXfrList();
        java.util.ArrayList arrayList = new java.util.ArrayList(defaultXfrList);
        arrayList.retainAll(a);
        if (arrayList.size() == a.size()) {
            java.lang.String str2 = e;
            com.igexin.c.a.c.a.a(str2, "db cache xfr == default, use cache");
            com.igexin.c.a.c.a.a(str2 + " | db cache xfr == default, use cache", new java.lang.Object[0]);
            b(jSONArray);
            return;
        }
        java.lang.String str3 = e;
        com.igexin.c.a.c.a.a(str3, "db cache xfr != default, use default");
        com.igexin.c.a.c.a.a(str3 + " | db cache xfr != default, use default", new java.lang.Object[0]);
        arrayList.clear();
        defaultXfrList.clear();
        a.clear();
        a();
    }

    private void b(org.json.JSONArray jSONArray) {
        com.igexin.push.c.d dVar;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                org.json.JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject.has("domain")) {
                    dVar = new com.igexin.push.c.d();
                    dVar.a(jSONObject.getString("domain"));
                    if (jSONObject.has(tv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_PORT)) {
                        dVar.b = jSONObject.getInt(tv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_PORT);
                    }
                    if (jSONObject.has("ip")) {
                        dVar.a = jSONObject.getString("ip");
                    }
                    if (jSONObject.has("consumeTime")) {
                        dVar.c = jSONObject.getLong("consumeTime");
                    }
                    if (jSONObject.has("detectSuccessTime")) {
                        dVar.d = jSONObject.getLong("detectSuccessTime");
                    }
                    if (jSONObject.has("isDomain")) {
                        dVar.e = jSONObject.getBoolean("isDomain");
                    }
                } else {
                    dVar = null;
                }
                if (dVar != null) {
                    this.c.put(dVar.a(), dVar);
                } else {
                    try {
                        dVar = d(jSONObject.getString("domain"));
                    } catch (java.lang.Exception e2) {
                        com.igexin.c.a.c.a.a(e2);
                        com.igexin.c.a.c.a.a(e + "|initWithCacheData exception " + e2.toString(), new java.lang.Object[0]);
                        this.c.clear();
                        a();
                        return;
                    }
                }
                if (dVar != null) {
                    b(dVar);
                    arrayList.add(dVar);
                }
            } catch (java.lang.Exception e3) {
                com.igexin.c.a.c.a.a(e3);
                com.igexin.c.a.c.a.a(e + "|initWithCacheData exception " + e3.toString(), new java.lang.Object[0]);
                return;
            }
        }
        this.d.b(arrayList);
    }

    private void c(java.lang.String str) {
        org.json.JSONObject jSONObject;
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject = new org.json.JSONObject(str);
        } catch (org.json.JSONException e2) {
            com.igexin.c.a.c.a.a(e2);
            jSONObject = null;
        }
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        if (jSONObject.has("loginFailedlCnt")) {
            try {
                this.d.g = jSONObject.getInt("loginFailedlCnt");
            } catch (org.json.JSONException e3) {
                com.igexin.c.a.c.a.a(e3);
            }
        }
        if (jSONObject.has("lastChange2BackupTime")) {
            try {
                this.d.h = jSONObject.getLong("lastChange2BackupTime");
            } catch (org.json.JSONException e4) {
                com.igexin.c.a.c.a.a(e4);
            }
        }
        if (jSONObject.has("lastOfflineTime")) {
            try {
                this.d.i = jSONObject.getLong("lastOfflineTime");
            } catch (org.json.JSONException e5) {
                com.igexin.c.a.c.a.a(e5);
            }
        }
        if (jSONObject.has("domainType")) {
            try {
                this.d.e = com.igexin.push.c.a.EnumC0370a.a(jSONObject.getInt("domainType"));
                if (this.d.e == com.igexin.push.c.a.EnumC0370a.BACKUP) {
                    this.d.f.set(true);
                }
            } catch (org.json.JSONException e6) {
                com.igexin.c.a.c.a.a(e6);
            }
        }
    }

    private static com.igexin.push.c.d d(java.lang.String str) {
        com.igexin.push.c.d dVar = new com.igexin.push.c.d();
        java.lang.String[] a = com.igexin.c.a.b.g.a(str);
        dVar.a(str);
        dVar.b = java.lang.Integer.parseInt(a[2]);
        return dVar;
    }

    public static void k() {
        com.igexin.push.core.e.f.a().b(com.igexin.push.core.b.m, true);
        com.igexin.push.core.e.f.a().b(com.igexin.push.core.b.m, false);
    }

    private void p() {
        synchronized (this.f) {
            this.c.clear();
        }
    }

    private boolean q() {
        long abs = java.lang.Math.abs(java.lang.System.currentTimeMillis() - this.a);
        long j = com.igexin.push.c.b.c;
        if (abs >= (2 * j) - com.anythink.expressad.d.a.b.P) {
            com.igexin.c.a.c.a.a(e + "|current time - last detect time > " + (j / 1000) + " s, detect = true", new java.lang.Object[0]);
            com.igexin.push.c.f.a.set(true);
            return true;
        }
        if (!com.igexin.push.c.f.a.getAndSet(true)) {
            long abs2 = java.lang.Math.abs(j - abs);
            com.igexin.push.c.f.g().a(abs2, java.util.concurrent.TimeUnit.MILLISECONDS);
            com.igexin.c.a.c.a.a(e + "|set next detect time = " + abs2, new java.lang.Object[0]);
        }
        return false;
    }

    private boolean r() {
        return c() == com.igexin.push.c.b.EnumC0371b.b;
    }

    public final com.igexin.push.c.e a(java.lang.String str) {
        synchronized (this.g) {
            for (java.util.Map.Entry<java.lang.String, com.igexin.push.c.e> entry : this.b.entrySet()) {
                if (entry.getKey().equals(str)) {
                    return entry.getValue();
                }
            }
            return null;
        }
    }

    public final void a(com.igexin.push.c.d dVar) {
        synchronized (this.f) {
            this.c.put(dVar.a(), dVar);
        }
        com.igexin.push.c.a aVar = this.d;
        synchronized (aVar.d) {
            aVar.b = 0;
            java.util.Collections.sort(aVar.c, aVar.k);
        }
    }

    public abstract int c();

    public abstract com.igexin.push.c.i d();

    /*  JADX ERROR: ConcurrentModificationException in pass: ConstructorVisitor
        java.util.ConcurrentModificationException
        	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1096)
        	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1050)
        	at jadx.core.dex.visitors.ConstructorVisitor.insertPhiInsn(ConstructorVisitor.java:139)
        	at jadx.core.dex.visitors.ConstructorVisitor.processInvoke(ConstructorVisitor.java:91)
        	at jadx.core.dex.visitors.ConstructorVisitor.replaceInvoke(ConstructorVisitor.java:56)
        	at jadx.core.dex.visitors.ConstructorVisitor.visit(ConstructorVisitor.java:42)
        */
    public final void e() {
        /*
            r9 = this;
            long r0 = java.lang.System.currentTimeMillis()
            long r2 = r9.a
            long r0 = r0 - r2
            long r0 = java.lang.Math.abs(r0)
            long r2 = com.igexin.push.c.b.c
            r4 = 2
            long r4 = r4 * r2
            r6 = 3600(0xe10, double:1.7786E-320)
            long r4 = r4 - r6
            r6 = 1
            r7 = 0
            int r8 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r8 < 0) goto L43
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = com.igexin.push.c.h.e
            r0.append(r1)
            java.lang.String r1 = "|current time - last detect time > "
            r0.append(r1)
            r4 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 / r4
            r0.append(r2)
            java.lang.String r1 = " s, detect = true"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r1 = new java.lang.Object[r7]
            com.igexin.c.a.c.a.a(r0, r1)
            java.util.concurrent.atomic.AtomicBoolean r0 = com.igexin.push.c.f.a
            r0.set(r6)
            goto L75
        L43:
            java.util.concurrent.atomic.AtomicBoolean r4 = com.igexin.push.c.f.a
            boolean r4 = r4.getAndSet(r6)
            if (r4 != 0) goto L74
            long r2 = r2 - r0
            long r0 = java.lang.Math.abs(r2)
            com.igexin.push.c.f r2 = com.igexin.push.c.f.g()
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS
            r2.a(r0, r3)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = com.igexin.push.c.h.e
            r2.append(r3)
            java.lang.String r3 = "|set next detect time = "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.Object[] r1 = new java.lang.Object[r7]
            com.igexin.c.a.c.a.a(r0, r1)
        L74:
            r6 = 0
        L75:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            if (r6 != 0) goto L90
            r0.<init>()
            java.lang.String r1 = com.igexin.push.c.h.e
            r0.append(r1)
            java.lang.String r1 = "|startDetect detect = false, return !!!"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r1 = new java.lang.Object[r7]
            com.igexin.c.a.c.a.a(r0, r1)
            return
        L90:
            r0.<init>()
            java.lang.String r1 = com.igexin.push.c.h.e
            r0.append(r1)
            java.lang.String r1 = "|startDetect detect = true, start detect !!!"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r1 = new java.lang.Object[r7]
            com.igexin.c.a.c.a.a(r0, r1)
            r9.i()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.c.h.e():void");
    }

    public final void f() {
        synchronized (this.g) {
            for (java.util.Map.Entry<java.lang.String, com.igexin.push.c.e> entry : this.b.entrySet()) {
                entry.getValue().a((com.igexin.push.c.i) null);
                entry.getValue().a();
            }
        }
    }

    public final void g() {
        f();
        p();
        java.util.List<java.lang.String> defaultXfrList = com.igexin.push.config.SDKUrlConfig.getDefaultXfrList();
        synchronized (this.g) {
            int size = this.b.size();
            if (defaultXfrList.size() < size) {
                int size2 = size - defaultXfrList.size();
                java.util.Iterator<java.util.Map.Entry<java.lang.String, com.igexin.push.c.e>> it = this.b.entrySet().iterator();
                for (int i = 0; it.hasNext() && i < size2; i++) {
                    it.next().getValue().b();
                    it.remove();
                }
            }
            java.util.ArrayList arrayList = new java.util.ArrayList(this.b.values());
            this.b.clear();
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            for (int i2 = 0; i2 < defaultXfrList.size(); i2++) {
                com.igexin.push.c.d dVar = new com.igexin.push.c.d();
                java.lang.String[] a = com.igexin.c.a.b.g.a(defaultXfrList.get(i2));
                dVar.a(defaultXfrList.get(i2));
                dVar.b = java.lang.Integer.parseInt(a[2]);
                if (i2 < size) {
                    com.igexin.push.c.e eVar = (com.igexin.push.c.e) arrayList.get(i2);
                    eVar.b = dVar;
                    this.b.put(dVar.a(), eVar);
                } else {
                    b(dVar);
                }
                arrayList2.add(dVar);
            }
            this.d.b(arrayList2);
        }
    }

    public final void h() {
        f();
        p();
        java.util.List<java.lang.String> defaultXfrList = com.igexin.push.config.SDKUrlConfig.getDefaultXfrList();
        synchronized (this.g) {
            java.util.Iterator<java.util.Map.Entry<java.lang.String, com.igexin.push.c.e>> it = this.b.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().b();
            }
            this.b.clear();
            java.util.ArrayList arrayList = new java.util.ArrayList();
            com.igexin.push.c.d dVar = new com.igexin.push.c.d();
            java.lang.String[] a = com.igexin.c.a.b.g.a(defaultXfrList.get(0));
            dVar.a(defaultXfrList.get(0));
            dVar.b = java.lang.Integer.parseInt(a[2]);
            arrayList.add(dVar);
            this.d.b(arrayList);
            arrayList.clear();
        }
    }

    public final void i() {
        this.a = java.lang.System.currentTimeMillis();
        synchronized (this.g) {
            for (java.util.Map.Entry<java.lang.String, com.igexin.push.c.e> entry : this.b.entrySet()) {
                entry.getValue();
                entry.getValue().a(d());
                if (entry.getValue().b != null) {
                    entry.getValue().b.b();
                }
                com.igexin.push.c.e value = entry.getValue();
                synchronized (com.igexin.push.c.i.class) {
                    if (value.c != null) {
                        value.a = com.igexin.b.a.a().a.submit(value.new AnonymousClass1());
                    }
                }
            }
        }
    }

    public final synchronized void j() {
        this.a = java.lang.System.currentTimeMillis();
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        synchronized (this.g) {
            try {
                jSONObject.put("lastDetectTime", this.a);
                jSONObject.put(org.apache.tools.ant.taskdefs.optional.j2ee.HotDeploymentTool.ACTION_LIST, jSONArray);
                java.util.Iterator<java.util.Map.Entry<java.lang.String, com.igexin.push.c.e>> it = this.b.entrySet().iterator();
                while (it.hasNext()) {
                    org.json.JSONObject f = it.next().getValue().b.f();
                    if (f != null) {
                        jSONArray.put(f);
                    }
                }
            } catch (java.lang.Exception e2) {
                com.igexin.c.a.c.a.a(e2);
            }
        }
        if (jSONObject.length() > 0) {
            if (r()) {
                com.igexin.push.core.e.f.a().b(jSONObject.toString(), true);
                return;
            }
            com.igexin.push.core.e.f.a().b(jSONObject.toString(), false);
        }
    }

    public final synchronized void l() {
        com.igexin.push.c.a aVar = this.d;
        com.igexin.push.c.a.EnumC0370a enumC0370a = aVar.e;
        com.igexin.c.a.c.a.a(com.igexin.push.c.a.a + "|detect success, current type = " + aVar.e, new java.lang.Object[0]);
        if (aVar.e == com.igexin.push.c.a.EnumC0370a.BACKUP) {
            aVar.a(com.igexin.push.c.a.EnumC0370a.TRY_NORMAL);
            com.igexin.push.core.d unused = com.igexin.push.core.d.a.a;
            com.igexin.push.e.a.a(true);
        }
    }

    public final void m() {
        synchronized (com.igexin.push.c.h.class) {
            if (this.i == null) {
                android.os.HandlerThread handlerThread = new android.os.HandlerThread("NetDetect-T");
                handlerThread.start();
                this.i = new android.os.Handler(handlerThread.getLooper());
            }
        }
        this.i.removeCallbacksAndMessages("detToken");
        this.i.postAtTime(new com.igexin.push.c.h.AnonymousClass2(), "detToken", android.os.SystemClock.uptimeMillis() + 5000);
    }

    public final synchronized void n() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("loginFailedlCnt", this.d.g);
            jSONObject.put("lastChange2BackupTime", this.d.h);
            jSONObject.put("lastOfflineTime", this.d.i);
            jSONObject.put("domainType", this.d.e.d);
        } catch (java.lang.Exception e2) {
            com.igexin.c.a.c.a.a(e2);
        }
        if (jSONObject.length() > 0) {
            if (r()) {
                com.igexin.push.core.e.f.a().a(jSONObject.toString(), true);
                return;
            }
            com.igexin.push.core.e.f.a().a(jSONObject.toString(), false);
        }
    }
}
