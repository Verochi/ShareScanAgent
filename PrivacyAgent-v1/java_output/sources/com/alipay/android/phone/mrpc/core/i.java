package com.alipay.android.phone.mrpc.core;

/* loaded from: classes.dex */
public final class i implements com.alipay.android.phone.mrpc.core.g {
    public final /* synthetic */ com.alipay.android.phone.mrpc.core.aa a;
    public final /* synthetic */ com.alipay.android.phone.mrpc.core.h b;

    public i(com.alipay.android.phone.mrpc.core.h hVar, com.alipay.android.phone.mrpc.core.aa aaVar) {
        this.b = hVar;
        this.a = aaVar;
    }

    @Override // com.alipay.android.phone.mrpc.core.g
    public final java.lang.String a() {
        return this.a.a();
    }

    @Override // com.alipay.android.phone.mrpc.core.g
    public final com.alipay.android.phone.mrpc.core.ab b() {
        android.content.Context context;
        context = this.b.a;
        return com.alipay.android.phone.mrpc.core.l.a(context.getApplicationContext());
    }

    @Override // com.alipay.android.phone.mrpc.core.g
    public final com.alipay.android.phone.mrpc.core.aa c() {
        return this.a;
    }

    @Override // com.alipay.android.phone.mrpc.core.g
    public final boolean d() {
        return this.a.c();
    }
}
