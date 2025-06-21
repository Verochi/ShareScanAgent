package com.vivo.push;

/* loaded from: classes19.dex */
public final class e {
    private static volatile com.vivo.push.e a;
    private android.content.Context h;
    private com.vivo.push.util.b j;
    private java.lang.String k;
    private java.lang.String l;
    private java.lang.Boolean o;
    private java.lang.Long p;
    private boolean q;

    /* renamed from: s, reason: collision with root package name */
    private int f459s;
    private long b = -1;
    private long c = -1;
    private long d = -1;
    private long e = -1;
    private long f = -1;
    private long g = -1;
    private boolean i = true;
    private android.util.SparseArray<com.vivo.push.e.a> m = new android.util.SparseArray<>();
    private int n = 0;
    private com.vivo.push.IPushClientFactory r = new com.vivo.push.d();

    public static class a {
        private com.vivo.push.IPushActionListener a;
        private com.vivo.push.b.c b;
        private com.vivo.push.IPushActionListener c;
        private java.lang.Runnable d;
        private java.lang.Object[] e;

        public a(com.vivo.push.b.c cVar, com.vivo.push.IPushActionListener iPushActionListener) {
            this.b = cVar;
            this.a = iPushActionListener;
        }

        public final void a() {
            java.lang.Runnable runnable = this.d;
            if (runnable == null) {
                com.vivo.push.util.p.a("PushClientManager", "task is null");
            } else {
                runnable.run();
            }
        }

        public final void a(int i, java.lang.Object... objArr) {
            this.e = objArr;
            com.vivo.push.IPushActionListener iPushActionListener = this.c;
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(i);
            }
            com.vivo.push.IPushActionListener iPushActionListener2 = this.a;
            if (iPushActionListener2 != null) {
                iPushActionListener2.onStateChanged(i);
            }
        }

        public final void a(com.vivo.push.IPushActionListener iPushActionListener) {
            this.c = iPushActionListener;
        }

        public final void a(java.lang.Runnable runnable) {
            this.d = runnable;
        }

        public final java.lang.Object[] b() {
            return this.e;
        }
    }

    private e() {
    }

    private com.vivo.push.e.a a(com.vivo.push.b.b bVar, com.vivo.push.IPushActionListener iPushActionListener) {
        com.vivo.push.e.a aVar = new com.vivo.push.e.a(bVar, iPushActionListener);
        java.lang.String a2 = a(aVar);
        bVar.b(a2);
        aVar.a(new com.vivo.push.h(this, bVar, a2));
        return aVar;
    }

    public static synchronized com.vivo.push.e a() {
        com.vivo.push.e eVar;
        synchronized (com.vivo.push.e.class) {
            if (a == null) {
                a = new com.vivo.push.e();
            }
            eVar = a;
        }
        return eVar;
    }

    private synchronized java.lang.String a(com.vivo.push.e.a aVar) {
        int i;
        this.m.put(this.n, aVar);
        i = this.n;
        this.n = i + 1;
        return java.lang.Integer.toString(i);
    }

    private static boolean a(long j) {
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        return j == -1 || elapsedRealtime <= j || elapsedRealtime >= j + 2000;
    }

    private void c(java.lang.String str) {
        com.vivo.push.m.c(new com.vivo.push.f(this, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized com.vivo.push.e.a d(java.lang.String str) {
        if (str != null) {
            try {
                int parseInt = java.lang.Integer.parseInt(str);
                com.vivo.push.e.a aVar = this.m.get(parseInt);
                this.m.delete(parseInt);
                return aVar;
            } catch (java.lang.Exception unused) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(java.lang.String str) {
        com.vivo.push.m.a(new com.vivo.push.k(this, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        this.l = null;
        this.j.b("APP_ALIAS");
    }

    private boolean n() {
        if (this.o == null) {
            this.o = java.lang.Boolean.valueOf(l() >= 1230 && com.vivo.push.util.z.d(this.h));
        }
        return this.o.booleanValue();
    }

    public final synchronized void a(android.content.Context context) {
        if (this.h == null) {
            this.h = com.vivo.push.util.ContextDelegate.getContext(context);
            this.q = com.vivo.push.util.t.c(context, context.getPackageName());
            com.vivo.push.util.w.b().a(this.h);
            a(new com.vivo.push.b.g());
            com.vivo.push.util.b bVar = new com.vivo.push.util.b();
            this.j = bVar;
            bVar.a(this.h, "com.vivo.push_preferences.appconfig_v1");
            this.k = f();
            this.l = this.j.b("APP_ALIAS", (java.lang.String) null);
        }
    }

    public final void a(android.content.Intent intent, com.vivo.push.sdk.PushMessageCallback pushMessageCallback) {
        com.vivo.push.o createReceiverCommand = this.r.createReceiverCommand(intent);
        android.content.Context context = a().h;
        if (createReceiverCommand == null) {
            com.vivo.push.util.p.a("PushClientManager", "sendCommand, null command!");
            if (context != null) {
                com.vivo.push.util.p.c(context, "[执行指令失败]指令空！");
                return;
            }
            return;
        }
        com.vivo.push.d.z createReceiveTask = this.r.createReceiveTask(createReceiverCommand);
        if (createReceiveTask != null) {
            if (context != null && !(createReceiverCommand instanceof com.vivo.push.b.n)) {
                com.vivo.push.util.p.a(context, "[接收指令]".concat(java.lang.String.valueOf(createReceiverCommand)));
            }
            createReceiveTask.a(pushMessageCallback);
            com.vivo.push.m.a((com.vivo.push.l) createReceiveTask);
            return;
        }
        com.vivo.push.util.p.a("PushClientManager", "sendCommand, null command task! pushCommand = ".concat(java.lang.String.valueOf(createReceiverCommand)));
        if (context != null) {
            com.vivo.push.util.p.c(context, "[执行指令失败]指令" + createReceiverCommand + "任务空！");
        }
    }

    public final void a(com.vivo.push.IPushActionListener iPushActionListener) {
        if (this.h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        java.lang.String f = f();
        this.k = f;
        if (!android.text.TextUtils.isEmpty(f)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
                return;
            }
            return;
        }
        if (!a(this.b)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        this.b = android.os.SystemClock.elapsedRealtime();
        java.lang.String packageName = this.h.getPackageName();
        com.vivo.push.e.a aVar = null;
        if (this.h != null) {
            com.vivo.push.b.b bVar = new com.vivo.push.b.b(true, packageName);
            bVar.g();
            bVar.d();
            bVar.e();
            bVar.a(100);
            if (this.q) {
                if (!n()) {
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(101);
                    }
                }
                aVar = a(bVar, iPushActionListener);
            } else {
                if (bVar.a(this.h) != 2) {
                    a(bVar);
                    if (iPushActionListener != null) {
                        iPushActionListener.onStateChanged(0);
                    }
                }
                aVar = a(bVar, iPushActionListener);
            }
        } else if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(102);
        }
        if (aVar == null) {
            return;
        }
        aVar.a(new com.vivo.push.g(this, aVar));
        aVar.a();
    }

    public final void a(com.vivo.push.o oVar) {
        android.content.Context context = a().h;
        if (oVar == null) {
            com.vivo.push.util.p.a("PushClientManager", "sendCommand, null command!");
            if (context != null) {
                com.vivo.push.util.p.c(context, "[执行指令失败]指令空！");
                return;
            }
            return;
        }
        com.vivo.push.l createTask = this.r.createTask(oVar);
        if (createTask != null) {
            com.vivo.push.util.p.d("PushClientManager", "client--sendCommand, command = ".concat(java.lang.String.valueOf(oVar)));
            com.vivo.push.m.a(createTask);
            return;
        }
        com.vivo.push.util.p.a("PushClientManager", "sendCommand, null command task! pushCommand = ".concat(java.lang.String.valueOf(oVar)));
        if (context != null) {
            com.vivo.push.util.p.c(context, "[执行指令失败]指令" + oVar + "任务空！");
        }
    }

    public final void a(java.lang.String str) {
        this.k = str;
        this.j.a("APP_TOKEN", str);
    }

    public final void a(java.lang.String str, int i) {
        com.vivo.push.e.a d = d(str);
        if (d != null) {
            d.a(i, new java.lang.Object[0]);
        } else {
            com.vivo.push.util.p.d("PushClientManager", "notifyStatusChanged token is null");
        }
    }

    public final void a(java.lang.String str, int i, java.lang.Object... objArr) {
        com.vivo.push.e.a d = d(str);
        if (d != null) {
            d.a(i, objArr);
        } else {
            com.vivo.push.util.p.d("PushClientManager", "notifyApp token is null");
        }
    }

    public final void a(java.lang.String str, com.vivo.push.IPushActionListener iPushActionListener) {
        if (this.h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (!android.text.TextUtils.isEmpty(this.l) && this.l.equals(str)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
                return;
            }
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(str);
        com.vivo.push.b.a aVar = new com.vivo.push.b.a(true, this.h.getPackageName(), arrayList);
        aVar.a(100);
        if (!this.q) {
            a(aVar);
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
                return;
            }
            return;
        }
        if (!n()) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(101);
                return;
            }
            return;
        }
        if (!a(this.d)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        this.d = android.os.SystemClock.elapsedRealtime();
        java.lang.String a2 = a(new com.vivo.push.e.a(aVar, iPushActionListener));
        aVar.b(a2);
        if (android.text.TextUtils.isEmpty(this.k)) {
            a(a2, com.igexin.sdk.PushConsts.ALIAS_ERROR_FREQUENCY);
            return;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            a(a2, com.igexin.sdk.PushConsts.ALIAS_OPERATE_PARAM_ERROR);
        } else if (str.length() > 70) {
            a(a2, com.igexin.sdk.PushConsts.ALIAS_REQUEST_FILTER);
        } else {
            a(aVar);
            e(a2);
        }
    }

    public final void a(java.util.ArrayList<java.lang.String> arrayList, com.vivo.push.IPushActionListener iPushActionListener) {
        android.content.Context context = this.h;
        if (context == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        com.vivo.push.b.z zVar = new com.vivo.push.b.z(true, context.getPackageName(), arrayList);
        zVar.a(500);
        if (!this.q) {
            a(zVar);
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
                return;
            }
            return;
        }
        if (!n()) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(101);
                return;
            }
            return;
        }
        if (!a(this.f)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        this.f = android.os.SystemClock.elapsedRealtime();
        java.lang.String a2 = a(new com.vivo.push.e.a(zVar, iPushActionListener));
        zVar.b(a2);
        if (android.text.TextUtils.isEmpty(this.k)) {
            a(a2, 20001);
            return;
        }
        if (arrayList.size() < 0) {
            a(a2, 20002);
            return;
        }
        if (arrayList.size() + c().size() > 500) {
            a(a2, 20004);
            return;
        }
        java.util.Iterator<java.lang.String> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().length() > 70) {
                a(a2, 20003);
                return;
            }
        }
        a(zVar);
        e(a2);
    }

    public final void a(java.util.List<java.lang.String> list) {
        try {
            if (list.size() <= 0) {
                return;
            }
            java.lang.String b = this.j.b("APP_TAGS", (java.lang.String) null);
            org.json.JSONObject jSONObject = android.text.TextUtils.isEmpty(b) ? new org.json.JSONObject() : new org.json.JSONObject(b);
            java.util.Iterator<java.lang.String> it = list.iterator();
            while (it.hasNext()) {
                jSONObject.put(it.next(), java.lang.System.currentTimeMillis());
            }
            java.lang.String jSONObject2 = jSONObject.toString();
            if (android.text.TextUtils.isEmpty(jSONObject2)) {
                this.j.b("APP_TAGS");
            } else {
                this.j.a("APP_TAGS", jSONObject2);
            }
        } catch (org.json.JSONException e) {
            e.printStackTrace();
            this.j.b("APP_TAGS");
        }
    }

    public final void a(boolean z) {
        this.i = z;
    }

    public final void b() {
        android.content.Context context = this.h;
        if (context != null) {
            com.vivo.push.util.z.b(context);
        }
    }

    public final void b(com.vivo.push.IPushActionListener iPushActionListener) {
        if (this.h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if ("".equals(this.k)) {
            iPushActionListener.onStateChanged(0);
            return;
        }
        if (!a(this.c)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        this.c = android.os.SystemClock.elapsedRealtime();
        java.lang.String packageName = this.h.getPackageName();
        com.vivo.push.e.a aVar = null;
        if (this.h != null) {
            com.vivo.push.b.b bVar = new com.vivo.push.b.b(false, packageName);
            bVar.d();
            bVar.e();
            bVar.g();
            bVar.a(100);
            if (this.q) {
                if (n()) {
                    aVar = new com.vivo.push.e.a(bVar, iPushActionListener);
                    java.lang.String a2 = a(aVar);
                    bVar.b(a2);
                    aVar.a(new com.vivo.push.j(this, bVar, a2));
                } else if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(101);
                }
            } else if (bVar.a(this.h) == 2) {
                aVar = a(bVar, iPushActionListener);
            } else {
                a(bVar);
                if (iPushActionListener != null) {
                    iPushActionListener.onStateChanged(0);
                }
            }
        } else if (iPushActionListener != null) {
            iPushActionListener.onStateChanged(102);
        }
        if (aVar == null) {
            return;
        }
        aVar.a(new com.vivo.push.i(this));
        aVar.a();
    }

    public final void b(java.lang.String str) {
        this.l = str;
        this.j.a("APP_ALIAS", str);
    }

    public final void b(java.lang.String str, com.vivo.push.IPushActionListener iPushActionListener) {
        if (this.h == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        if (android.text.TextUtils.isEmpty(this.l)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
                return;
            }
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        arrayList.add(str);
        com.vivo.push.b.a aVar = new com.vivo.push.b.a(false, this.h.getPackageName(), arrayList);
        aVar.a(100);
        if (!this.q) {
            a(aVar);
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
                return;
            }
            return;
        }
        if (!n()) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(101);
                return;
            }
            return;
        }
        if (!a(this.e)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        this.e = android.os.SystemClock.elapsedRealtime();
        java.lang.String a2 = a(new com.vivo.push.e.a(aVar, iPushActionListener));
        aVar.b(a2);
        if (android.text.TextUtils.isEmpty(this.k)) {
            a(a2, com.igexin.sdk.PushConsts.ALIAS_ERROR_FREQUENCY);
            return;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            a(a2, com.igexin.sdk.PushConsts.ALIAS_OPERATE_PARAM_ERROR);
        } else if (str.length() > 70) {
            a(a2, com.igexin.sdk.PushConsts.ALIAS_REQUEST_FILTER);
        } else {
            a(aVar);
            e(a2);
        }
    }

    public final void b(java.util.ArrayList<java.lang.String> arrayList, com.vivo.push.IPushActionListener iPushActionListener) {
        android.content.Context context = this.h;
        if (context == null) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(102);
                return;
            }
            return;
        }
        com.vivo.push.b.z zVar = new com.vivo.push.b.z(false, context.getPackageName(), arrayList);
        zVar.a(500);
        if (!this.q) {
            a(zVar);
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(0);
                return;
            }
            return;
        }
        if (!n()) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(101);
                return;
            }
            return;
        }
        if (!a(this.g)) {
            if (iPushActionListener != null) {
                iPushActionListener.onStateChanged(1002);
                return;
            }
            return;
        }
        this.g = android.os.SystemClock.elapsedRealtime();
        java.lang.String a2 = a(new com.vivo.push.e.a(zVar, iPushActionListener));
        zVar.b(a2);
        if (android.text.TextUtils.isEmpty(this.k)) {
            a(a2, 20001);
            return;
        }
        if (arrayList.size() < 0) {
            a(a2, 20002);
            return;
        }
        if (arrayList.size() > 500) {
            a(a2, 20004);
            return;
        }
        java.util.Iterator<java.lang.String> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().length() > 70) {
                a(a2, 20003);
                return;
            }
        }
        a(zVar);
        e(a2);
    }

    public final void b(java.util.List<java.lang.String> list) {
        try {
            if (list.size() <= 0) {
                return;
            }
            java.lang.String b = this.j.b("APP_TAGS", (java.lang.String) null);
            org.json.JSONObject jSONObject = android.text.TextUtils.isEmpty(b) ? new org.json.JSONObject() : new org.json.JSONObject(b);
            java.util.Iterator<java.lang.String> it = list.iterator();
            while (it.hasNext()) {
                jSONObject.remove(it.next());
            }
            java.lang.String jSONObject2 = jSONObject.toString();
            if (android.text.TextUtils.isEmpty(jSONObject2)) {
                this.j.b("APP_TAGS");
            } else {
                this.j.a("APP_TAGS", jSONObject2);
            }
        } catch (org.json.JSONException e) {
            e.printStackTrace();
            this.j.b("APP_TAGS");
        }
    }

    public final java.util.List<java.lang.String> c() {
        java.lang.String b = this.j.b("APP_TAGS", (java.lang.String) null);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
        } catch (org.json.JSONException unused) {
            this.j.b("APP_TAGS");
            arrayList.clear();
            com.vivo.push.util.p.d("PushClientManager", "getTags error");
        }
        if (android.text.TextUtils.isEmpty(b)) {
            return arrayList;
        }
        java.util.Iterator<java.lang.String> keys = new org.json.JSONObject(b).keys();
        while (keys.hasNext()) {
            arrayList.add(keys.next());
        }
        return arrayList;
    }

    public final void c(java.util.List<java.lang.String> list) {
        if (list.contains(this.l)) {
            m();
        }
    }

    public final boolean d() {
        if (this.h == null) {
            com.vivo.push.util.p.d("PushClientManager", "support:context is null");
            return false;
        }
        java.lang.Boolean valueOf = java.lang.Boolean.valueOf(n());
        this.o = valueOf;
        return valueOf.booleanValue();
    }

    public final boolean e() {
        return this.q;
    }

    public final java.lang.String f() {
        if (!android.text.TextUtils.isEmpty(this.k)) {
            return this.k;
        }
        com.vivo.push.util.b bVar = this.j;
        java.lang.String b = bVar != null ? bVar.b("APP_TOKEN", (java.lang.String) null) : "";
        c(b);
        return b;
    }

    public final boolean g() {
        return this.i;
    }

    public final android.content.Context h() {
        return this.h;
    }

    public final void i() {
        this.j.a();
    }

    public final java.lang.String j() {
        return this.l;
    }

    public final int k() {
        return this.f459s;
    }

    public final long l() {
        android.content.Context context = this.h;
        if (context == null) {
            return -1L;
        }
        if (this.p == null) {
            this.p = java.lang.Long.valueOf(com.vivo.push.util.z.a(context));
        }
        return this.p.longValue();
    }
}
