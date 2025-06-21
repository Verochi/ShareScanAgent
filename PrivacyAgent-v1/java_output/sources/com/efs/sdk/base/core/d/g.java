package com.efs.sdk.base.core.d;

/* loaded from: classes22.dex */
public final class g extends com.efs.sdk.base.core.d.a {
    private java.util.concurrent.ConcurrentHashMap<java.lang.String, com.efs.sdk.base.core.d.g.a> b = new java.util.concurrent.ConcurrentHashMap<>(10);

    public static class a {
        java.lang.String a;
        java.lang.String b;
        java.lang.String c;
        java.util.concurrent.atomic.AtomicInteger d = new java.util.concurrent.atomic.AtomicInteger(0);

        public a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
        }
    }

    @Override // com.efs.sdk.base.core.d.a
    public final void a() {
        com.efs.sdk.base.core.d.f fVar;
        try {
            if (this.a != null && com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
                java.util.Iterator<java.util.Map.Entry<java.lang.String, com.efs.sdk.base.core.d.g.a>> it = this.b.entrySet().iterator();
                while (it.hasNext()) {
                    com.efs.sdk.base.core.d.g.a value = it.next().getValue();
                    int i = value.d.get();
                    if (i > 0) {
                        com.efs.sdk.base.core.controller.ControllerCenter controllerCenter = this.a;
                        java.lang.String str = value.a;
                        java.lang.String str2 = value.b;
                        java.lang.String str3 = value.c;
                        fVar = com.efs.sdk.base.core.d.f.a.a;
                        com.efs.sdk.base.core.d.b bVar = new com.efs.sdk.base.core.d.b("efs_core", "req_succ_rate", fVar.a.c);
                        bVar.put("rep_code", str);
                        bVar.put("px_code", str2);
                        bVar.put("path", str3);
                        bVar.put("cnt", java.lang.Integer.valueOf(i));
                        controllerCenter.send(bVar);
                        value.d.addAndGet(i * (-1));
                    }
                }
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    public final void a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.String str4 = str + "_" + str2 + "_" + str3.trim();
        if (!this.b.containsKey(str4) || this.b.get(str4) == null) {
            this.b.putIfAbsent(str4, new com.efs.sdk.base.core.d.g.a(str, str2, str3));
        }
        this.b.get(str4).d.incrementAndGet();
    }
}
