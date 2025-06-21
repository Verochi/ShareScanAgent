package com.alipay.android.phone.mrpc.core;

/* loaded from: classes.dex */
public final class l implements com.alipay.android.phone.mrpc.core.ab {
    public static com.alipay.android.phone.mrpc.core.l b;
    public static final java.util.concurrent.ThreadFactory i = new com.alipay.android.phone.mrpc.core.n();
    public android.content.Context a;
    public java.util.concurrent.ThreadPoolExecutor c;
    public com.alipay.android.phone.mrpc.core.b d = com.alipay.android.phone.mrpc.core.b.a(com.aliyun.vod.log.core.AliyunLogCommon.OPERATION_SYSTEM);
    public long e;
    public long f;
    public long g;
    public int h;

    public l(android.content.Context context) {
        this.a = context;
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = new java.util.concurrent.ThreadPoolExecutor(10, 11, 3L, java.util.concurrent.TimeUnit.SECONDS, new java.util.concurrent.ArrayBlockingQueue(20), i, new java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy());
        this.c = threadPoolExecutor;
        try {
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        } catch (java.lang.Exception unused) {
        }
        android.webkit.CookieSyncManager.createInstance(this.a);
        android.webkit.CookieManager.getInstance().setAcceptCookie(true);
    }

    public static final com.alipay.android.phone.mrpc.core.l a(android.content.Context context) {
        com.alipay.android.phone.mrpc.core.l lVar = b;
        return lVar != null ? lVar : b(context);
    }

    public static final synchronized com.alipay.android.phone.mrpc.core.l b(android.content.Context context) {
        synchronized (com.alipay.android.phone.mrpc.core.l.class) {
            com.alipay.android.phone.mrpc.core.l lVar = b;
            if (lVar != null) {
                return lVar;
            }
            com.alipay.android.phone.mrpc.core.l lVar2 = new com.alipay.android.phone.mrpc.core.l(context);
            b = lVar2;
            return lVar2;
        }
    }

    public final com.alipay.android.phone.mrpc.core.b a() {
        return this.d;
    }

    @Override // com.alipay.android.phone.mrpc.core.ab
    public final java.util.concurrent.Future<com.alipay.android.phone.mrpc.core.u> a(com.alipay.android.phone.mrpc.core.t tVar) {
        if (com.alipay.android.phone.mrpc.core.s.a(this.a)) {
            java.lang.String str = "HttpManager" + hashCode() + ": Active Task = %d, Completed Task = %d, All Task = %d,Avarage Speed = %d KB/S, Connetct Time = %d ms, All data size = %d bytes, All enqueueConnect time = %d ms, All socket time = %d ms, All request times = %d times";
            java.lang.Object[] objArr = new java.lang.Object[9];
            objArr[0] = java.lang.Integer.valueOf(this.c.getActiveCount());
            objArr[1] = java.lang.Long.valueOf(this.c.getCompletedTaskCount());
            objArr[2] = java.lang.Long.valueOf(this.c.getTaskCount());
            long j = this.g;
            objArr[3] = java.lang.Long.valueOf(j == 0 ? 0L : ((this.e * 1000) / j) >> 10);
            int i2 = this.h;
            objArr[4] = java.lang.Long.valueOf(i2 != 0 ? this.f / i2 : 0L);
            objArr[5] = java.lang.Long.valueOf(this.e);
            objArr[6] = java.lang.Long.valueOf(this.f);
            objArr[7] = java.lang.Long.valueOf(this.g);
            objArr[8] = java.lang.Integer.valueOf(this.h);
            java.lang.String.format(str, objArr);
        }
        com.alipay.android.phone.mrpc.core.q qVar = new com.alipay.android.phone.mrpc.core.q(this, (com.alipay.android.phone.mrpc.core.o) tVar);
        com.alipay.android.phone.mrpc.core.m mVar = new com.alipay.android.phone.mrpc.core.m(this, qVar, qVar);
        this.c.execute(mVar);
        return mVar;
    }

    public final void a(long j) {
        this.e += j;
    }

    public final void b(long j) {
        this.f += j;
        this.h++;
    }

    public final void c(long j) {
        this.g += j;
    }
}
