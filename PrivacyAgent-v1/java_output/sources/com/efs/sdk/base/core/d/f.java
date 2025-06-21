package com.efs.sdk.base.core.d;

/* loaded from: classes22.dex */
public final class f {
    public com.efs.sdk.base.core.d.c a;
    public com.efs.sdk.base.core.controller.ControllerCenter b;
    public com.efs.sdk.base.core.d.d c;
    public com.efs.sdk.base.core.d.g d;

    public static class a {
        private static final com.efs.sdk.base.core.d.f a = new com.efs.sdk.base.core.d.f((byte) 0);
    }

    private f() {
        this.a = new com.efs.sdk.base.core.d.c();
        this.c = new com.efs.sdk.base.core.d.d();
        this.d = new com.efs.sdk.base.core.d.g();
    }

    public /* synthetic */ f(byte b) {
        this();
    }

    public final com.efs.sdk.base.core.d.b a(java.lang.String str, int i) {
        com.efs.sdk.base.core.d.b bVar = new com.efs.sdk.base.core.d.b("efs_core", str, this.a.c);
        bVar.put("cver", java.lang.Integer.valueOf(i));
        return bVar;
    }

    public final void a(int i) {
        com.efs.sdk.base.core.controller.ControllerCenter controllerCenter = this.b;
        if (controllerCenter != null) {
            controllerCenter.send(a("flow_limit", i));
        }
    }

    public final void a(int i, java.lang.String str) {
        if (this.b != null || com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
            com.efs.sdk.base.core.d.b a2 = a("flow_limit_type", i);
            a2.put("code", str);
            this.b.send(a2);
        }
    }

    public final void a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.d.a(str, str2, str3);
    }
}
