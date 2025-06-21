package com.alipay.android.phone.mrpc.core;

/* loaded from: classes.dex */
public final class h extends com.alipay.android.phone.mrpc.core.w {
    public android.content.Context a;

    public h(android.content.Context context) {
        this.a = context;
    }

    @Override // com.alipay.android.phone.mrpc.core.w
    public final <T> T a(java.lang.Class<T> cls, com.alipay.android.phone.mrpc.core.aa aaVar) {
        return (T) new com.alipay.android.phone.mrpc.core.x(new com.alipay.android.phone.mrpc.core.i(this, aaVar)).a(cls);
    }
}
