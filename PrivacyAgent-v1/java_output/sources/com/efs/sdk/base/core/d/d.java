package com.efs.sdk.base.core.d;

/* loaded from: classes22.dex */
public final class d extends com.efs.sdk.base.core.d.a {
    private java.util.concurrent.atomic.AtomicInteger d = new java.util.concurrent.atomic.AtomicInteger(0);
    private java.util.concurrent.atomic.AtomicInteger e = new java.util.concurrent.atomic.AtomicInteger(0);
    public java.util.concurrent.atomic.AtomicInteger b = new java.util.concurrent.atomic.AtomicInteger(0);
    private java.util.concurrent.atomic.AtomicInteger f = new java.util.concurrent.atomic.AtomicInteger(0);
    public java.util.concurrent.atomic.AtomicInteger c = new java.util.concurrent.atomic.AtomicInteger(0);

    @Override // com.efs.sdk.base.core.d.a
    public final void a() {
        com.efs.sdk.base.core.d.f fVar;
        if ((this.d.get() == 0 && this.e.get() == 0 && this.b.get() == 0 && this.c.get() == 0 && this.f.get() == 0) || this.a == null || !com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
            return;
        }
        com.efs.sdk.base.core.controller.ControllerCenter controllerCenter = this.a;
        int i = this.d.get();
        int i2 = this.e.get();
        int i3 = this.b.get();
        int i4 = this.c.get();
        int i5 = this.f.get();
        fVar = com.efs.sdk.base.core.d.f.a.a;
        com.efs.sdk.base.core.d.b bVar = new com.efs.sdk.base.core.d.b("efs_core", "lf_st", fVar.a.c);
        bVar.put("create_cnt", java.lang.Integer.valueOf(i));
        bVar.put("cache_cnt", java.lang.Integer.valueOf(i2));
        bVar.put("req_cnt", java.lang.Integer.valueOf(i3));
        bVar.put("err_cnt", java.lang.Integer.valueOf(i4));
        bVar.put("expire_cnt", java.lang.Integer.valueOf(i5));
        this.d.addAndGet(i * (-1));
        this.e.addAndGet(i2 * (-1));
        this.b.addAndGet(i3 * (-1));
        this.c.addAndGet(i4 * (-1));
        this.f.addAndGet(i5 * (-1));
        controllerCenter.send(bVar);
    }

    public final void b() {
        this.d.incrementAndGet();
    }

    public final void c() {
        this.e.incrementAndGet();
    }

    public final void d() {
        this.f.incrementAndGet();
    }
}
