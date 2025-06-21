package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
class co extends com.baidu.mobads.sdk.internal.j {
    final /* synthetic */ com.baidu.mobads.sdk.internal.cn b;

    public co(com.baidu.mobads.sdk.internal.cn cnVar) {
        this.b = cnVar;
    }

    @Override // com.baidu.mobads.sdk.internal.j
    public java.lang.Object i() {
        java.lang.String a;
        java.lang.String a2;
        android.content.Context context;
        java.lang.String a3;
        try {
            a = this.b.a("key_crash_trace");
            a2 = this.b.a("key_crash_ad");
            if (android.text.TextUtils.isEmpty(a)) {
                return null;
            }
            com.baidu.mobads.sdk.internal.ck a4 = com.baidu.mobads.sdk.internal.ck.a();
            context = this.b.m;
            a4.a(context);
            a3 = this.b.a("key_crash_source");
            a4.a(a3, a, a2);
            this.b.g();
            return null;
        } catch (java.lang.Exception e) {
            com.baidu.mobads.sdk.internal.bt.a().a(e);
            return null;
        }
    }
}
