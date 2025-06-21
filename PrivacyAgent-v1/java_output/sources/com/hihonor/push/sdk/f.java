package com.hihonor.push.sdk;

/* loaded from: classes22.dex */
public class f implements java.lang.Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ com.hihonor.push.sdk.g.a b;

    public f(com.hihonor.push.sdk.g.a aVar, int i) {
        this.b = aVar;
        this.a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.a(com.hihonor.push.sdk.common.data.ErrorEnum.fromCode(this.a));
    }
}
