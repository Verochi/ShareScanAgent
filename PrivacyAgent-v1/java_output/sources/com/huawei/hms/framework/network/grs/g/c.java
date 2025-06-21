package com.huawei.hms.framework.network.grs.g;

/* loaded from: classes22.dex */
public class c {
    private static final java.lang.String n = "c";
    private final com.huawei.hms.framework.network.grs.GrsBaseInfo a;
    private final android.content.Context b;
    private final com.huawei.hms.framework.network.grs.e.a c;
    private com.huawei.hms.framework.network.grs.g.d d;
    private final com.huawei.hms.framework.network.grs.g.k.c j;
    private com.huawei.hms.framework.network.grs.g.k.d k;
    private final java.util.Map<java.lang.String, java.util.concurrent.Future<com.huawei.hms.framework.network.grs.g.d>> e = new java.util.concurrent.ConcurrentHashMap(16);
    private final java.util.List<com.huawei.hms.framework.network.grs.g.d> f = new java.util.concurrent.CopyOnWriteArrayList();
    private final org.json.JSONArray g = new org.json.JSONArray();
    private final java.util.List<java.lang.String> h = new java.util.concurrent.CopyOnWriteArrayList();
    private final java.util.List<java.lang.String> i = new java.util.concurrent.CopyOnWriteArrayList();
    private java.lang.String l = "";
    private long m = 1;

    public class a implements java.util.concurrent.Callable<com.huawei.hms.framework.network.grs.g.d> {
        final /* synthetic */ java.util.concurrent.ExecutorService a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ com.huawei.hms.framework.network.grs.e.c c;

        public a(java.util.concurrent.ExecutorService executorService, java.lang.String str, com.huawei.hms.framework.network.grs.e.c cVar) {
            this.a = executorService;
            this.b = str;
            this.c = cVar;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.huawei.hms.framework.network.grs.g.d call() {
            return com.huawei.hms.framework.network.grs.g.c.this.b(this.a, this.b, this.c);
        }
    }

    public c(com.huawei.hms.framework.network.grs.g.k.c cVar, com.huawei.hms.framework.network.grs.e.a aVar) {
        this.j = cVar;
        this.a = cVar.b();
        this.b = cVar.a();
        this.c = aVar;
        c();
        d();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0098 A[LOOP:0: B:2:0x0005->B:13:0x0098, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0090 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private com.huawei.hms.framework.network.grs.g.d a(java.util.concurrent.ExecutorService executorService, java.util.List<java.lang.String> list, java.lang.String str, com.huawei.hms.framework.network.grs.e.c cVar) {
        boolean z;
        com.huawei.hms.framework.network.grs.g.d dVar;
        com.huawei.hms.framework.network.grs.g.d dVar2 = null;
        int i = 0;
        while (true) {
            if (i >= list.size()) {
                break;
            }
            java.lang.String str2 = list.get(i);
            if (!android.text.TextUtils.isEmpty(str2)) {
                java.util.concurrent.Future<com.huawei.hms.framework.network.grs.g.d> submit = executorService.submit(new com.huawei.hms.framework.network.grs.g.a(str2, i, this, this.b, str, this.a, cVar).g());
                this.e.put(str2, submit);
                z = true;
                try {
                    dVar = submit.get(this.m, java.util.concurrent.TimeUnit.SECONDS);
                } catch (java.lang.InterruptedException e) {
                    e = e;
                } catch (java.util.concurrent.CancellationException unused) {
                } catch (java.util.concurrent.ExecutionException e2) {
                    e = e2;
                } catch (java.util.concurrent.TimeoutException unused2) {
                }
                if (dVar != null) {
                    try {
                    } catch (java.lang.InterruptedException e3) {
                        e = e3;
                        dVar2 = dVar;
                        com.huawei.hms.framework.common.Logger.w(n, "the current thread was interrupted while waiting", e);
                        if (!z) {
                        }
                    } catch (java.util.concurrent.CancellationException unused3) {
                        dVar2 = dVar;
                        com.huawei.hms.framework.common.Logger.i(n, "{requestServer} the computation was cancelled");
                        if (!z) {
                        }
                    } catch (java.util.concurrent.ExecutionException e4) {
                        e = e4;
                        dVar2 = dVar;
                        com.huawei.hms.framework.common.Logger.w(n, "the computation threw an ExecutionException", e);
                        z = false;
                        if (!z) {
                        }
                    } catch (java.util.concurrent.TimeoutException unused4) {
                        dVar2 = dVar;
                        com.huawei.hms.framework.common.Logger.w(n, "the wait timed out");
                        z = false;
                        if (!z) {
                        }
                    }
                    if (dVar.o() || dVar.m()) {
                        com.huawei.hms.framework.common.Logger.i(n, "grs request return body is not null and is OK.");
                        dVar2 = dVar;
                        if (!z) {
                            com.huawei.hms.framework.common.Logger.v(n, "needBreak is true so need break current circulation");
                            break;
                        }
                        i++;
                    }
                }
                dVar2 = dVar;
            }
            z = false;
            if (!z) {
            }
        }
        return b(dVar2);
    }

    private void a(java.lang.String str, java.lang.String str2) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str2);
        sb.append(str);
        java.lang.String grsReqParamJoint = this.a.getGrsReqParamJoint(false, false, e(), this.b);
        if (!android.text.TextUtils.isEmpty(grsReqParamJoint)) {
            sb.append("?");
            sb.append(grsReqParamJoint);
        }
        this.i.add(sb.toString());
    }

    private com.huawei.hms.framework.network.grs.g.d b(com.huawei.hms.framework.network.grs.g.d dVar) {
        java.lang.String str;
        java.lang.String str2;
        for (java.util.Map.Entry<java.lang.String, java.util.concurrent.Future<com.huawei.hms.framework.network.grs.g.d>> entry : this.e.entrySet()) {
            if (dVar != null && (dVar.o() || dVar.m())) {
                break;
            }
            try {
                dVar = entry.getValue().get(40000L, java.util.concurrent.TimeUnit.MILLISECONDS);
            } catch (java.lang.InterruptedException e) {
                e = e;
                str = n;
                str2 = "{checkResponse} when check result, find InterruptedException, check others";
                com.huawei.hms.framework.common.Logger.w(str, str2, e);
            } catch (java.util.concurrent.CancellationException unused) {
                com.huawei.hms.framework.common.Logger.i(n, "{checkResponse} when check result, find CancellationException, check others");
            } catch (java.util.concurrent.ExecutionException e2) {
                e = e2;
                str = n;
                str2 = "{checkResponse} when check result, find ExecutionException, check others";
                com.huawei.hms.framework.common.Logger.w(str, str2, e);
            } catch (java.util.concurrent.TimeoutException unused2) {
                com.huawei.hms.framework.common.Logger.w(n, "{checkResponse} when check result, find TimeoutException, cancel current request task");
                if (!entry.getValue().isCancelled()) {
                    entry.getValue().cancel(true);
                }
            }
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.huawei.hms.framework.network.grs.g.d b(java.util.concurrent.ExecutorService executorService, java.lang.String str, com.huawei.hms.framework.network.grs.e.c cVar) {
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        com.huawei.hms.framework.network.grs.g.d a2 = a(executorService, this.i, str, cVar);
        int b = a2 == null ? 0 : a2.b();
        java.lang.String str2 = n;
        com.huawei.hms.framework.common.Logger.v(str2, "use 2.0 interface return http's code is：{%s}", java.lang.Integer.valueOf(b));
        if (b == 404 || b == 401) {
            if (android.text.TextUtils.isEmpty(e()) && android.text.TextUtils.isEmpty(this.a.getAppName())) {
                com.huawei.hms.framework.common.Logger.i(str2, "request grs server use 1.0 API must set appName,please check.");
                return null;
            }
            this.e.clear();
            com.huawei.hms.framework.common.Logger.i(str2, "this env has not deploy new interface,so use old interface.");
            a2 = a(executorService, this.h, str, cVar);
        }
        com.huawei.hms.framework.network.grs.g.e.a(new java.util.ArrayList(this.f), android.os.SystemClock.elapsedRealtime() - elapsedRealtime, this.g, this.b);
        this.f.clear();
        return a2;
    }

    private void b(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(this.a.getAppName()) && android.text.TextUtils.isEmpty(e())) {
            return;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str2);
        java.util.Locale locale = java.util.Locale.ROOT;
        java.lang.Object[] objArr = new java.lang.Object[1];
        objArr[0] = android.text.TextUtils.isEmpty(e()) ? this.a.getAppName() : e();
        sb.append(java.lang.String.format(locale, str, objArr));
        java.lang.String grsReqParamJoint = this.a.getGrsReqParamJoint(false, false, "1.0", this.b);
        if (!android.text.TextUtils.isEmpty(grsReqParamJoint)) {
            sb.append("?");
            sb.append(grsReqParamJoint);
        }
        this.h.add(sb.toString());
    }

    private void c() {
        com.huawei.hms.framework.network.grs.g.k.d a2 = com.huawei.hms.framework.network.grs.g.j.a.a(this.b);
        if (a2 == null) {
            com.huawei.hms.framework.common.Logger.w(n, "g*s***_se****er_conf*** maybe has a big error");
            return;
        }
        a(a2);
        java.util.List<java.lang.String> a3 = a2.a();
        if (a3 == null || a3.size() <= 0) {
            com.huawei.hms.framework.common.Logger.v(n, "maybe grs_base_url config with [],please check.");
            return;
        }
        if (a3.size() > 10) {
            throw new java.lang.IllegalArgumentException("grs_base_url's count is larger than MAX value 10");
        }
        java.lang.String c = a2.c();
        java.lang.String b = a2.b();
        if (a3.size() > 0) {
            for (java.lang.String str : a3) {
                if (str.startsWith("https://")) {
                    b(c, str);
                    a(b, str);
                } else {
                    com.huawei.hms.framework.common.Logger.w(n, "grs server just support https scheme url,please check.");
                }
            }
        }
        com.huawei.hms.framework.common.Logger.v(n, "request to GRS server url is{%s} and {%s}", this.h, this.i);
    }

    private void d() {
        java.lang.String grsParasKey = this.a.getGrsParasKey(true, true, this.b);
        this.l = this.c.a().a(grsParasKey + "ETag", "");
    }

    private java.lang.String e() {
        com.huawei.hms.framework.network.grs.f.b a2 = com.huawei.hms.framework.network.grs.f.b.a(this.b.getPackageName(), this.a);
        com.huawei.hms.framework.network.grs.local.model.a a3 = a2 != null ? a2.a() : null;
        if (a3 == null) {
            return "";
        }
        java.lang.String b = a3.b();
        com.huawei.hms.framework.common.Logger.v(n, "get appName from local assets is{%s}", b);
        return b;
    }

    public com.huawei.hms.framework.network.grs.g.d a(java.util.concurrent.ExecutorService executorService, java.lang.String str, com.huawei.hms.framework.network.grs.e.c cVar) {
        java.lang.String str2;
        java.lang.String str3;
        if (this.h.isEmpty() && this.i.isEmpty()) {
            return null;
        }
        try {
            return (com.huawei.hms.framework.network.grs.g.d) executorService.submit(new com.huawei.hms.framework.network.grs.g.c.a(executorService, str, cVar)).get(b() != null ? r0.d() : 10, java.util.concurrent.TimeUnit.SECONDS);
        } catch (java.lang.InterruptedException e) {
            e = e;
            str2 = n;
            str3 = "{submitExcutorTaskWithTimeout} the current thread was interrupted while waiting";
            com.huawei.hms.framework.common.Logger.w(str2, str3, e);
            return null;
        } catch (java.util.concurrent.CancellationException unused) {
            com.huawei.hms.framework.common.Logger.i(n, "{submitExcutorTaskWithTimeout} the computation was cancelled");
            return null;
        } catch (java.util.concurrent.ExecutionException e2) {
            e = e2;
            str2 = n;
            str3 = "{submitExcutorTaskWithTimeout} the computation threw an ExecutionException";
            com.huawei.hms.framework.common.Logger.w(str2, str3, e);
            return null;
        } catch (java.util.concurrent.TimeoutException unused2) {
            com.huawei.hms.framework.common.Logger.w(n, "{submitExcutorTaskWithTimeout} the wait timed out");
            return null;
        } catch (java.lang.Exception e3) {
            e = e3;
            str2 = n;
            str3 = "{submitExcutorTaskWithTimeout} catch Exception";
            com.huawei.hms.framework.common.Logger.w(str2, str3, e);
            return null;
        }
    }

    public java.lang.String a() {
        return this.l;
    }

    public synchronized void a(com.huawei.hms.framework.network.grs.g.d dVar) {
        this.f.add(dVar);
        com.huawei.hms.framework.network.grs.g.d dVar2 = this.d;
        if (dVar2 != null && (dVar2.o() || this.d.m())) {
            com.huawei.hms.framework.common.Logger.v(n, "grsResponseResult is ok");
            return;
        }
        if (dVar.n()) {
            com.huawei.hms.framework.common.Logger.i(n, "GRS server open 503 limiting strategy.");
            com.huawei.hms.framework.network.grs.h.d.a(this.a.getGrsParasKey(true, true, this.b), new com.huawei.hms.framework.network.grs.h.d.a(dVar.k(), android.os.SystemClock.elapsedRealtime()));
            return;
        }
        if (dVar.m()) {
            com.huawei.hms.framework.common.Logger.i(n, "GRS server open 304 Not Modified.");
        }
        if (!dVar.o() && !dVar.m()) {
            com.huawei.hms.framework.common.Logger.v(n, "grsResponseResult has exception so need return");
            return;
        }
        this.d = dVar;
        this.c.a(this.a, dVar, this.b, this.j);
        for (java.util.Map.Entry<java.lang.String, java.util.concurrent.Future<com.huawei.hms.framework.network.grs.g.d>> entry : this.e.entrySet()) {
            if (!entry.getKey().equals(dVar.l()) && !entry.getValue().isCancelled()) {
                com.huawei.hms.framework.common.Logger.i(n, "future cancel");
                entry.getValue().cancel(true);
            }
        }
    }

    public void a(com.huawei.hms.framework.network.grs.g.k.d dVar) {
        this.k = dVar;
    }

    public com.huawei.hms.framework.network.grs.g.k.d b() {
        return this.k;
    }
}
