package com.huawei.hms.framework.network.grs.g;

/* loaded from: classes22.dex */
public class h {
    private final java.util.concurrent.ExecutorService a = com.huawei.hms.framework.common.ExecutorsUtils.newCachedThreadPool("GRS_RequestController-Task");
    private final java.util.Map<java.lang.String, com.huawei.hms.framework.network.grs.g.k.b> b = new java.util.concurrent.ConcurrentHashMap(16);
    private final java.lang.Object c = new java.lang.Object();
    private com.huawei.hms.framework.network.grs.e.a d;

    public class a implements java.util.concurrent.Callable<com.huawei.hms.framework.network.grs.g.d> {
        final /* synthetic */ com.huawei.hms.framework.network.grs.g.k.c a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ com.huawei.hms.framework.network.grs.e.c c;

        public a(com.huawei.hms.framework.network.grs.g.k.c cVar, java.lang.String str, com.huawei.hms.framework.network.grs.e.c cVar2) {
            this.a = cVar;
            this.b = str;
            this.c = cVar2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public com.huawei.hms.framework.network.grs.g.d call() {
            return new com.huawei.hms.framework.network.grs.g.c(this.a, com.huawei.hms.framework.network.grs.g.h.this.d).a(com.huawei.hms.framework.network.grs.g.h.this.a, this.b, this.c);
        }
    }

    public class b implements java.lang.Runnable {
        final /* synthetic */ com.huawei.hms.framework.network.grs.g.k.c a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ com.huawei.hms.framework.network.grs.e.c c;
        final /* synthetic */ com.huawei.hms.framework.network.grs.b d;

        public b(com.huawei.hms.framework.network.grs.g.k.c cVar, java.lang.String str, com.huawei.hms.framework.network.grs.e.c cVar2, com.huawei.hms.framework.network.grs.b bVar) {
            this.a = cVar;
            this.b = str;
            this.c = cVar2;
            this.d = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.huawei.hms.framework.network.grs.g.h hVar = com.huawei.hms.framework.network.grs.g.h.this;
            hVar.a(hVar.a(this.a, this.b, this.c), this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.huawei.hms.framework.network.grs.g.d dVar, com.huawei.hms.framework.network.grs.b bVar) {
        if (bVar != null) {
            if (dVar == null) {
                com.huawei.hms.framework.common.Logger.v("RequestController", "GrsResponse is null");
                bVar.a();
            } else {
                com.huawei.hms.framework.common.Logger.v("RequestController", "GrsResponse is not null");
                bVar.a(dVar);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0069, code lost:
    
        if (r2.a() != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006d, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public com.huawei.hms.framework.network.grs.g.d a(com.huawei.hms.framework.network.grs.g.k.c cVar, java.lang.String str, com.huawei.hms.framework.network.grs.e.c cVar2) {
        java.util.concurrent.Future<com.huawei.hms.framework.network.grs.g.d> submit;
        java.lang.String str2;
        java.lang.String str3;
        com.huawei.hms.framework.common.Logger.d("RequestController", "request to server with service name is: " + str);
        java.lang.String grsParasKey = cVar.b().getGrsParasKey(true, true, cVar.a());
        com.huawei.hms.framework.common.Logger.v("RequestController", "request spUrlKey: " + grsParasKey);
        synchronized (this.c) {
            if (!com.huawei.hms.framework.common.NetworkUtil.isNetworkAvailable(cVar.a())) {
                return null;
            }
            com.huawei.hms.framework.network.grs.h.d.a a2 = com.huawei.hms.framework.network.grs.h.d.a(grsParasKey);
            com.huawei.hms.framework.network.grs.g.k.b bVar = this.b.get(grsParasKey);
            try {
                if (bVar != null && bVar.b()) {
                    submit = bVar.a();
                    return submit.get();
                }
                return submit.get();
            } catch (java.lang.InterruptedException e) {
                e = e;
                str2 = "RequestController";
                str3 = "when check result, find InterruptedException, check others";
                com.huawei.hms.framework.common.Logger.w(str2, str3, e);
                return null;
            } catch (java.util.concurrent.CancellationException e2) {
                e = e2;
                str2 = "RequestController";
                str3 = "when check result, find CancellationException, check others";
                com.huawei.hms.framework.common.Logger.w(str2, str3, e);
                return null;
            } catch (java.util.concurrent.ExecutionException e3) {
                e = e3;
                str2 = "RequestController";
                str3 = "when check result, find ExecutionException, check others";
                com.huawei.hms.framework.common.Logger.w(str2, str3, e);
                return null;
            }
            com.huawei.hms.framework.common.Logger.d("RequestController", "hitGrsRequestBean == null or request block is released.");
            submit = this.a.submit(new com.huawei.hms.framework.network.grs.g.h.a(cVar, str, cVar2));
            this.b.put(grsParasKey, new com.huawei.hms.framework.network.grs.g.k.b(submit));
        }
    }

    public void a(com.huawei.hms.framework.network.grs.e.a aVar) {
        this.d = aVar;
    }

    public void a(com.huawei.hms.framework.network.grs.g.k.c cVar, com.huawei.hms.framework.network.grs.b bVar, java.lang.String str, com.huawei.hms.framework.network.grs.e.c cVar2) {
        this.a.execute(new com.huawei.hms.framework.network.grs.g.h.b(cVar, str, cVar2, bVar));
    }

    public void a(java.lang.String str) {
        synchronized (this.c) {
            this.b.remove(str);
        }
    }
}
