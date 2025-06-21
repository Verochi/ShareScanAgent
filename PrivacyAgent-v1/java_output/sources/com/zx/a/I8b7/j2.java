package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class j2 implements com.zx.module.base.ZXModule {
    public com.zx.a.I8b7.o3 a;
    public final com.zx.a.I8b7.h2 b = new com.zx.a.I8b7.h2();

    @Override // com.zx.module.base.ZXModule
    public java.lang.String getModuleIdentifier() {
        return "core-n";
    }

    @Override // com.zx.module.base.ZXModule
    public java.lang.String getModuleVersion() {
        return "3.3.4.43514";
    }

    @Override // com.zx.module.base.ZXModule
    public java.lang.String invoke(java.lang.String str, java.lang.String str2) throws com.zx.module.exception.ZXModuleInvokeException {
        com.zx.a.I8b7.h2 h2Var = this.b;
        h2Var.getClass();
        try {
            java.lang.String substring = com.zx.a.I8b7.p.a(str, "SHA256").substring(0, 16);
            if (((java.util.HashSet) com.zx.a.I8b7.h2.b).contains(substring)) {
                java.lang.reflect.Method declaredMethod = com.zx.a.I8b7.h2.class.getDeclaredMethod("f".concat(java.lang.String.valueOf(substring)), java.lang.String.class);
                declaredMethod.setAccessible(true);
                return (java.lang.String) declaredMethod.invoke(h2Var, str2);
            }
            return h2Var.a(str + " not in invokableMethods", 3);
        } catch (java.lang.Exception e) {
            com.zx.a.I8b7.r2.a(e);
            throw new com.zx.module.exception.ZXModuleInvokeException("Cannot invoke " + str + ", nested exception is " + e.getMessage(), e);
        }
    }

    @Override // com.zx.module.base.ZXModule
    public java.lang.String invokeAsync(java.lang.String str, java.lang.String str2, com.zx.module.base.Callback callback) throws com.zx.module.exception.ZXModuleInvokeException {
        com.zx.a.I8b7.h2 h2Var = this.b;
        h2Var.getClass();
        try {
            java.lang.String substring = com.zx.a.I8b7.p.a(str, "SHA256").substring(0, 16);
            if (!((java.util.HashSet) com.zx.a.I8b7.h2.b).contains(substring)) {
                java.lang.String a = h2Var.a(str + " not in invokableMethods", 3);
                callback.callback(a);
                return a;
            }
            com.zx.a.I8b7.r2.a("开始执行invokeAsync: method:" + str + "; " + str2 + ":cb");
            java.lang.reflect.Method declaredMethod = com.zx.a.I8b7.h2.class.getDeclaredMethod("f".concat(java.lang.String.valueOf(substring)), java.lang.String.class, com.zx.module.base.Callback.class);
            declaredMethod.setAccessible(true);
            return (java.lang.String) declaredMethod.invoke(h2Var, str2, callback);
        } catch (java.lang.Exception e) {
            java.lang.StringBuilder a2 = com.zx.a.I8b7.f3.a("开始执行invokeAsync:");
            a2.append(e.getMessage());
            com.zx.a.I8b7.r2.b(a2.toString());
            throw new com.zx.module.exception.ZXModuleInvokeException("Cannot invokeAsync " + str + ", nested exception is " + e.getMessage(), e);
        }
    }

    @Override // com.zx.module.base.ZXModule
    public void onCreate(com.zx.module.context.ContextHolder contextHolder) throws com.zx.module.exception.ZXModuleOnCreateException {
        com.zx.a.I8b7.t3 t3Var = new com.zx.a.I8b7.t3();
        this.a = t3Var;
        android.content.Context context = (android.content.Context) contextHolder.getContext();
        try {
            if (!t3Var.b.getAndSet(true)) {
                com.zx.a.I8b7.v3.f.a.a.execute(new com.zx.a.I8b7.s3(t3Var, context));
            }
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.g3.a(th, com.zx.a.I8b7.f3.a("ZXCore init failed: "));
            t3Var.b.set(false);
        }
        this.b.a = this.a;
    }

    @Override // com.zx.module.base.ZXModule
    public void onDestroy() throws com.zx.module.exception.ZXModuleOnDestroyException {
    }

    @Override // com.zx.module.base.ZXModule
    public void setMessageListener(com.zx.module.base.Listener listener) {
        com.zx.a.I8b7.t3 t3Var = (com.zx.a.I8b7.t3) this.a;
        t3Var.getClass();
        t3Var.c = new com.zx.a.I8b7.p3(t3Var, listener);
    }

    @Override // com.zx.module.base.ZXModule
    public void start() throws com.zx.module.exception.ZXModuleStartException {
        com.zx.a.I8b7.t3 t3Var = (com.zx.a.I8b7.t3) this.a;
        if (t3Var.a.compareAndSet(false, true)) {
            try {
                com.zx.a.I8b7.v3.f.a.a.execute(new com.zx.sdk.common.utils.ZXTask(new com.zx.a.I8b7.q3(t3Var), new com.zx.a.I8b7.r3(t3Var)));
            } catch (java.lang.Throwable th) {
                t3Var.c.onMessage("MESSAGE_ON_ZXID_RECEIVED", com.zx.a.I8b7.e2.a(10007, th.getMessage()));
                com.zx.a.I8b7.g3.a(th, new java.lang.StringBuilder("ZXCore start failed: "));
            }
        }
    }
}
