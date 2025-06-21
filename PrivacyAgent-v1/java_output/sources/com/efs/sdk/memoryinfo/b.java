package com.efs.sdk.memoryinfo;

/* loaded from: classes22.dex */
final class b {
    final com.efs.sdk.base.EfsReporter a;
    boolean b = false;
    final android.content.Context mContext;

    /* renamed from: com.efs.sdk.memoryinfo.b$1, reason: invalid class name */
    public class AnonymousClass1 implements com.efs.sdk.base.observer.IConfigCallback {

        /* renamed from: com.efs.sdk.memoryinfo.b$1$1, reason: invalid class name and collision with other inner class name */
        public class HandlerC02851 extends android.os.Handler {
            final /* synthetic */ android.os.HandlerThread d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public HandlerC02851(android.os.Looper looper, android.os.HandlerThread handlerThread) {
                super(looper);
                this.d = handlerThread;
            }

            @Override // android.os.Handler
            public final void handleMessage(android.os.Message message) {
                super.handleMessage(message);
                if (message.what == 1) {
                    try {
                        this.d.quit();
                    } catch (java.lang.Throwable unused) {
                    }
                }
            }
        }

        /* renamed from: com.efs.sdk.memoryinfo.b$1$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            final /* synthetic */ android.os.Handler f;
            final /* synthetic */ int g;
            final /* synthetic */ int h;

            public AnonymousClass2(android.os.Handler handler, int i, int i2) {
                this.f = handler;
                this.g = i;
                this.h = i2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    java.lang.String uuid = java.util.UUID.randomUUID().toString();
                    java.lang.String lowerCase = com.umeng.commonsdk.utils.UMUtils.MD5(android.os.Process.myPid() + uuid).toLowerCase();
                    com.efs.sdk.memoryinfo.b bVar = com.efs.sdk.memoryinfo.b.this;
                    android.os.Handler handler = this.f;
                    handler.post(bVar.new AnonymousClass2(android.os.SystemClock.elapsedRealtime(), this.h, handler, new com.efs.sdk.memoryinfo.e(bVar.mContext, bVar.a), lowerCase, this.g));
                } catch (java.lang.Throwable unused) {
                    this.f.sendEmptyMessage(1);
                }
            }
        }

        public AnonymousClass1() {
        }

        @Override // com.efs.sdk.base.observer.IConfigCallback
        public final void onChange(java.util.Map<java.lang.String, java.lang.Object> map) {
            java.lang.Object obj;
            boolean z;
            java.lang.Object obj2;
            java.lang.Object obj3;
            try {
                if (com.efs.sdk.memoryinfo.b.this.b || (obj = map.get("apm_memperf_sampling_rate")) == null) {
                    return;
                }
                int parseInt = java.lang.Integer.parseInt(obj.toString());
                if (parseInt == 0 || (parseInt != 100 && !com.efs.sdk.base.samplingwhitelist.SamplingWhiteListUtil.isHitWL() && new java.util.Random().nextInt(100) > parseInt)) {
                    z = false;
                    if ((z && !com.efs.sdk.base.integrationtesting.IntegrationTestingUtil.isIntegrationTestingInPeriod()) || (obj2 = map.get("apm_memperf_collect_interval")) == null || (obj3 = map.get("apm_memperf_collect_max_period_sec")) == null) {
                        return;
                    }
                    int parseInt2 = java.lang.Integer.parseInt(obj2.toString());
                    int parseInt3 = java.lang.Integer.parseInt(obj3.toString());
                    android.os.HandlerThread handlerThread = new android.os.HandlerThread("mem-info");
                    handlerThread.start();
                    com.efs.sdk.memoryinfo.b.AnonymousClass1.HandlerC02851 handlerC02851 = new com.efs.sdk.memoryinfo.b.AnonymousClass1.HandlerC02851(handlerThread.getLooper(), handlerThread);
                    handlerC02851.post(new com.efs.sdk.memoryinfo.b.AnonymousClass1.AnonymousClass2(handlerC02851, parseInt2, parseInt3));
                    com.efs.sdk.memoryinfo.b.this.b = true;
                }
                z = true;
                if (z) {
                }
                int parseInt22 = java.lang.Integer.parseInt(obj2.toString());
                int parseInt32 = java.lang.Integer.parseInt(obj3.toString());
                android.os.HandlerThread handlerThread2 = new android.os.HandlerThread("mem-info");
                handlerThread2.start();
                com.efs.sdk.memoryinfo.b.AnonymousClass1.HandlerC02851 handlerC028512 = new com.efs.sdk.memoryinfo.b.AnonymousClass1.HandlerC02851(handlerThread2.getLooper(), handlerThread2);
                handlerC028512.post(new com.efs.sdk.memoryinfo.b.AnonymousClass1.AnonymousClass2(handlerC028512, parseInt22, parseInt32));
                com.efs.sdk.memoryinfo.b.this.b = true;
            } catch (java.lang.Throwable th) {
                com.efs.sdk.memoryinfo.f.a("collect ", th);
            }
        }
    }

    /* renamed from: com.efs.sdk.memoryinfo.b$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ android.os.Handler f;
        final /* synthetic */ long i;
        final /* synthetic */ int j;
        final /* synthetic */ com.efs.sdk.memoryinfo.e k;
        final /* synthetic */ java.lang.String l;
        final /* synthetic */ int m;

        public AnonymousClass2(long j, int i, android.os.Handler handler, com.efs.sdk.memoryinfo.e eVar, java.lang.String str, int i2) {
            this.i = j;
            this.j = i;
            this.f = handler;
            this.k = eVar;
            this.l = str;
            this.m = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (android.os.SystemClock.elapsedRealtime() - this.i > this.j * 1000) {
                this.f.sendEmptyMessage(1);
                return;
            }
            try {
                com.efs.sdk.memoryinfo.b.a(com.efs.sdk.memoryinfo.b.this, this.k, this.l);
            } catch (java.lang.Throwable th) {
                com.efs.sdk.memoryinfo.f.a("collect ", th);
            }
            this.f.postDelayed(this, this.m * 1000);
        }
    }

    public b(android.content.Context context, com.efs.sdk.base.EfsReporter efsReporter) {
        this.mContext = context.getApplicationContext();
        this.a = efsReporter;
    }

    public static /* synthetic */ void a(com.efs.sdk.memoryinfo.b bVar, com.efs.sdk.memoryinfo.e eVar, java.lang.String str) {
        com.efs.sdk.memoryinfo.c cVar = new com.efs.sdk.memoryinfo.c(bVar.mContext);
        com.efs.sdk.base.protocol.record.EfsJSONLog efsJSONLog = new com.efs.sdk.base.protocol.record.EfsJSONLog("memperf");
        efsJSONLog.put("w_pgid", str);
        efsJSONLog.put("crver", "0.0.4.umeng");
        efsJSONLog.put("k_st", cVar.bg);
        efsJSONLog.put("w_url", cVar.activity);
        efsJSONLog.put("wl_tpss", java.lang.Long.valueOf(cVar.n));
        efsJSONLog.put("wl_jpss", java.lang.Long.valueOf(cVar.o));
        efsJSONLog.put("wl_npss", java.lang.Long.valueOf(cVar.p));
        efsJSONLog.put("wl_heap", java.lang.Long.valueOf(cVar.q));
        efsJSONLog.put("wf_heap_used_rate", java.lang.Float.valueOf(cVar.r));
        efsJSONLog.put("wl_graphics", java.lang.Long.valueOf(cVar.f305s));
        efsJSONLog.put("wl_vmsize", java.lang.Long.valueOf(cVar.t));
        synchronized (com.efs.sdk.memoryinfo.e.class) {
            if (eVar.C) {
                eVar.a(efsJSONLog);
            } else {
                eVar.B.add(efsJSONLog);
            }
        }
    }
}
