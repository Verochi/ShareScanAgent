package com.zx.a.I8b7;

/* loaded from: classes19.dex */
public class e3 implements java.lang.Runnable {
    public final /* synthetic */ java.lang.String a;
    public final /* synthetic */ com.zx.sdk.api.ZXIDChangedListener b;

    public e3(com.zx.a.I8b7.x2 x2Var, java.lang.String str, com.zx.sdk.api.ZXIDChangedListener zXIDChangedListener) {
        this.a = str;
        this.b = zXIDChangedListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.zx.a.I8b7.h3 a = com.zx.a.I8b7.x2.a();
            java.lang.String str = this.a;
            com.zx.sdk.api.ZXIDChangedListener zXIDChangedListener = this.b;
            com.zx.a.I8b7.q2 q2Var = a.c;
            q2Var.getClass();
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            java.util.LinkedList<com.zx.sdk.api.ZXIDChangedListener> linkedList = q2Var.a.get(str);
            if (linkedList == null) {
                linkedList = new java.util.LinkedList<>();
            }
            linkedList.add(zXIDChangedListener);
            q2Var.a.put(str, linkedList);
        } catch (java.lang.Throwable th) {
            com.zx.a.I8b7.g3.a(th, com.zx.a.I8b7.f3.a("ZXManager.allowPermissionDialog failed: "));
        }
    }
}
