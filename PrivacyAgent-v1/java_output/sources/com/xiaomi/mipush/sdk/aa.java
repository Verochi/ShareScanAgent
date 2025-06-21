package com.xiaomi.mipush.sdk;

/* loaded from: classes19.dex */
class aa implements java.lang.Runnable {
    final /* synthetic */ com.xiaomi.mipush.sdk.MiTinyDataClient.a.C0532a a;

    /* renamed from: a, reason: collision with other field name */
    final /* synthetic */ com.xiaomi.push.go f19a;

    public aa(com.xiaomi.mipush.sdk.MiTinyDataClient.a.C0532a c0532a, com.xiaomi.push.go goVar) {
        this.a = c0532a;
        this.f19a = goVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.f14a.add(this.f19a);
        this.a.a();
    }
}
