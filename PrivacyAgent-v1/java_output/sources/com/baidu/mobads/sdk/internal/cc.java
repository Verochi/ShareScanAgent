package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
class cc implements com.baidu.mobads.sdk.internal.cn.a {
    final /* synthetic */ com.baidu.mobads.sdk.internal.bz a;

    public cc(com.baidu.mobads.sdk.internal.bz bzVar) {
        this.a = bzVar;
    }

    @Override // com.baidu.mobads.sdk.internal.cn.a
    public void a(java.lang.String str) {
        try {
            this.a.b();
            this.a.a(str);
        } catch (java.lang.Throwable th) {
            com.baidu.mobads.sdk.internal.bt.a().a(th);
        }
    }
}
