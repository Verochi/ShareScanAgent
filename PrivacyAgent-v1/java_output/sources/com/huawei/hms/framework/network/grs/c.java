package com.huawei.hms.framework.network.grs;

/* loaded from: classes22.dex */
public class c {
    private static final java.lang.String i = "c";
    private static final java.util.concurrent.ExecutorService j = com.huawei.hms.framework.common.ExecutorsUtils.newSingleThreadExecutor("GRS_GrsClient-Init");
    private static java.util.concurrent.atomic.AtomicInteger k = new java.util.concurrent.atomic.AtomicInteger(0);
    private com.huawei.hms.framework.network.grs.GrsBaseInfo a;
    private android.content.Context b;
    private com.huawei.hms.framework.network.grs.g.h c;
    private com.huawei.hms.framework.network.grs.e.a d;
    private com.huawei.hms.framework.network.grs.e.c e;
    private com.huawei.hms.framework.network.grs.e.c f;
    private com.huawei.hms.framework.network.grs.a g;
    private java.util.concurrent.FutureTask<java.lang.Boolean> h;

    public class a implements java.util.concurrent.Callable<java.lang.Boolean> {
        final /* synthetic */ android.content.Context a;
        final /* synthetic */ com.huawei.hms.framework.network.grs.GrsBaseInfo b;

        public a(android.content.Context context, com.huawei.hms.framework.network.grs.GrsBaseInfo grsBaseInfo) {
            this.a = context;
            this.b = grsBaseInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public java.lang.Boolean call() {
            com.huawei.hms.framework.network.grs.c.this.c = new com.huawei.hms.framework.network.grs.g.h();
            com.huawei.hms.framework.network.grs.c.this.e = new com.huawei.hms.framework.network.grs.e.c(this.a, com.huawei.hms.framework.network.grs.GrsApp.getInstance().getBrand("_") + "share_pre_grs_conf_");
            com.huawei.hms.framework.network.grs.c.this.f = new com.huawei.hms.framework.network.grs.e.c(this.a, com.huawei.hms.framework.network.grs.GrsApp.getInstance().getBrand("_") + "share_pre_grs_services_");
            com.huawei.hms.framework.network.grs.c cVar = com.huawei.hms.framework.network.grs.c.this;
            cVar.d = new com.huawei.hms.framework.network.grs.e.a(cVar.e, com.huawei.hms.framework.network.grs.c.this.f, com.huawei.hms.framework.network.grs.c.this.c);
            com.huawei.hms.framework.network.grs.c cVar2 = com.huawei.hms.framework.network.grs.c.this;
            cVar2.g = new com.huawei.hms.framework.network.grs.a(cVar2.a, com.huawei.hms.framework.network.grs.c.this.d, com.huawei.hms.framework.network.grs.c.this.c, com.huawei.hms.framework.network.grs.c.this.f);
            if (com.huawei.hms.framework.network.grs.c.k.incrementAndGet() <= 2 || com.huawei.hms.framework.network.grs.f.b.a(this.a.getPackageName(), com.huawei.hms.framework.network.grs.c.this.a) == null) {
                new com.huawei.hms.framework.network.grs.f.b(this.a, this.b, true).a(this.b);
            }
            java.lang.String c = new com.huawei.hms.framework.network.grs.g.k.c(this.b, this.a).c();
            com.huawei.hms.framework.common.Logger.v(com.huawei.hms.framework.network.grs.c.i, "scan serviceSet is:" + c);
            java.lang.String a = com.huawei.hms.framework.network.grs.c.this.f.a("services", "");
            java.lang.String a2 = com.huawei.hms.framework.network.grs.g.i.a(a, c);
            if (!android.text.TextUtils.isEmpty(a2)) {
                com.huawei.hms.framework.network.grs.c.this.f.b("services", a2);
                com.huawei.hms.framework.common.Logger.i(com.huawei.hms.framework.network.grs.c.i, "postList is:" + com.huawei.hms.framework.common.StringUtils.anonymizeMessage(a2));
                com.huawei.hms.framework.common.Logger.i(com.huawei.hms.framework.network.grs.c.i, "currentServices:" + com.huawei.hms.framework.common.StringUtils.anonymizeMessage(a));
                if (!a2.equals(a)) {
                    com.huawei.hms.framework.network.grs.c.this.c.a(com.huawei.hms.framework.network.grs.c.this.a.getGrsParasKey(true, true, this.a));
                    com.huawei.hms.framework.network.grs.c.this.c.a(new com.huawei.hms.framework.network.grs.g.k.c(this.b, this.a), (java.lang.String) null, com.huawei.hms.framework.network.grs.c.this.f);
                }
            }
            com.huawei.hms.framework.network.grs.c cVar3 = com.huawei.hms.framework.network.grs.c.this;
            cVar3.a(cVar3.e.a());
            com.huawei.hms.framework.network.grs.c.this.d.b(this.b, this.a);
            return java.lang.Boolean.TRUE;
        }
    }

    public c(android.content.Context context, com.huawei.hms.framework.network.grs.GrsBaseInfo grsBaseInfo) {
        this.h = null;
        this.b = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        a(grsBaseInfo);
        com.huawei.hms.framework.network.grs.GrsBaseInfo grsBaseInfo2 = this.a;
        java.util.concurrent.FutureTask<java.lang.Boolean> futureTask = new java.util.concurrent.FutureTask<>(new com.huawei.hms.framework.network.grs.c.a(this.b, grsBaseInfo2));
        this.h = futureTask;
        j.execute(futureTask);
        com.huawei.hms.framework.common.Logger.i(i, "GrsClient Instance is init, GRS SDK version: %s, GrsBaseInfoParam: app_name=%s, reg_country=%s, ser_country=%s, issue_country=%s", com.huawei.hms.framework.network.grs.h.a.a(), grsBaseInfo2.getAppName(), grsBaseInfo.getRegCountry(), grsBaseInfo.getSerCountry(), grsBaseInfo.getIssueCountry());
    }

    public c(com.huawei.hms.framework.network.grs.GrsBaseInfo grsBaseInfo) {
        this.h = null;
        a(grsBaseInfo);
    }

    private void a(com.huawei.hms.framework.network.grs.GrsBaseInfo grsBaseInfo) {
        try {
            this.a = grsBaseInfo.m54clone();
        } catch (java.lang.CloneNotSupportedException e) {
            com.huawei.hms.framework.common.Logger.w(i, "GrsClient catch CloneNotSupportedException", e);
            this.a = grsBaseInfo.copy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.util.Map<java.lang.String, ?> map) {
        if (map == null || map.isEmpty()) {
            com.huawei.hms.framework.common.Logger.v(i, "sp's content is empty.");
            return;
        }
        for (java.lang.String str : map.keySet()) {
            if (str.endsWith("time")) {
                java.lang.String a2 = this.e.a(str, "");
                long j2 = 0;
                if (!android.text.TextUtils.isEmpty(a2) && a2.matches("\\d+")) {
                    try {
                        j2 = java.lang.Long.parseLong(a2);
                    } catch (java.lang.NumberFormatException e) {
                        com.huawei.hms.framework.common.Logger.w(i, "convert expire time from String to Long catch NumberFormatException.", e);
                    }
                }
                if (!a(j2)) {
                    com.huawei.hms.framework.common.Logger.i(i, "init interface auto clear some invalid sp's data.");
                    java.lang.String substring = str.substring(0, str.length() - 4);
                    this.e.a(substring);
                    this.e.a(str);
                    this.e.a(substring + "ETag");
                }
            }
        }
    }

    private boolean a(long j2) {
        return java.lang.System.currentTimeMillis() - j2 <= 604800000;
    }

    private boolean e() {
        java.lang.String str;
        java.lang.String str2;
        java.util.concurrent.FutureTask<java.lang.Boolean> futureTask = this.h;
        if (futureTask == null) {
            return false;
        }
        try {
            return futureTask.get(8L, java.util.concurrent.TimeUnit.SECONDS).booleanValue();
        } catch (java.lang.InterruptedException e) {
            e = e;
            str = i;
            str2 = "init compute task interrupted.";
            com.huawei.hms.framework.common.Logger.w(str, str2, e);
            return false;
        } catch (java.util.concurrent.CancellationException unused) {
            com.huawei.hms.framework.common.Logger.i(i, "init compute task canceled.");
            return false;
        } catch (java.util.concurrent.ExecutionException e2) {
            e = e2;
            str = i;
            str2 = "init compute task failed.";
            com.huawei.hms.framework.common.Logger.w(str, str2, e);
            return false;
        } catch (java.util.concurrent.TimeoutException unused2) {
            com.huawei.hms.framework.common.Logger.w(i, "init compute task timed out");
            return false;
        } catch (java.lang.Exception e3) {
            e = e3;
            str = i;
            str2 = "init compute task occur unknown Exception";
            com.huawei.hms.framework.common.Logger.w(str, str2, e);
            return false;
        }
    }

    public java.lang.String a(java.lang.String str, java.lang.String str2) {
        if (this.a == null || str == null || str2 == null) {
            com.huawei.hms.framework.common.Logger.w(i, "invalid para!");
            return null;
        }
        if (e()) {
            return this.g.a(str, str2, this.b);
        }
        return null;
    }

    public java.util.Map<java.lang.String, java.lang.String> a(java.lang.String str) {
        if (this.a != null && str != null) {
            return e() ? this.g.a(str, this.b) : new java.util.HashMap();
        }
        com.huawei.hms.framework.common.Logger.w(i, "invalid para!");
        return new java.util.HashMap();
    }

    public void a() {
        if (e()) {
            java.lang.String grsParasKey = this.a.getGrsParasKey(true, true, this.b);
            this.e.a(grsParasKey);
            this.e.a(grsParasKey + "time");
            this.e.a(grsParasKey + "ETag");
            this.c.a(grsParasKey);
        }
    }

    public void a(java.lang.String str, com.huawei.hms.framework.network.grs.IQueryUrlsCallBack iQueryUrlsCallBack) {
        if (iQueryUrlsCallBack == null) {
            com.huawei.hms.framework.common.Logger.w(i, "IQueryUrlsCallBack is must not null for process continue.");
            return;
        }
        if (this.a == null || str == null) {
            iQueryUrlsCallBack.onCallBackFail(-6);
        } else if (e()) {
            this.g.a(str, iQueryUrlsCallBack, this.b);
        } else {
            com.huawei.hms.framework.common.Logger.i(i, "grs init task has not completed.");
            iQueryUrlsCallBack.onCallBackFail(-7);
        }
    }

    public void a(java.lang.String str, java.lang.String str2, com.huawei.hms.framework.network.grs.IQueryUrlCallBack iQueryUrlCallBack) {
        if (iQueryUrlCallBack == null) {
            com.huawei.hms.framework.common.Logger.w(i, "IQueryUrlCallBack is must not null for process continue.");
            return;
        }
        if (this.a == null || str == null || str2 == null) {
            iQueryUrlCallBack.onCallBackFail(-6);
        } else if (e()) {
            this.g.a(str, str2, iQueryUrlCallBack, this.b);
        } else {
            com.huawei.hms.framework.common.Logger.i(i, "grs init task has not completed.");
            iQueryUrlCallBack.onCallBackFail(-7);
        }
    }

    public boolean a(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && com.huawei.hms.framework.network.grs.c.class == obj.getClass() && (obj instanceof com.huawei.hms.framework.network.grs.c)) {
            return this.a.compare(((com.huawei.hms.framework.network.grs.c) obj).a);
        }
        return false;
    }

    public boolean b() {
        com.huawei.hms.framework.network.grs.GrsBaseInfo grsBaseInfo;
        android.content.Context context;
        if (!e() || (grsBaseInfo = this.a) == null || (context = this.b) == null) {
            return false;
        }
        this.d.a(grsBaseInfo, context);
        return true;
    }
}
