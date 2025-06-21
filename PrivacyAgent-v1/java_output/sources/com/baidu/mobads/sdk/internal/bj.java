package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
class bj implements com.baidu.mobads.sdk.internal.aa.a {
    final /* synthetic */ com.baidu.mobads.sdk.internal.bi c;

    public bj(com.baidu.mobads.sdk.internal.bi biVar) {
        this.c = biVar;
    }

    @Override // com.baidu.mobads.sdk.internal.aa.a
    public void onFailure() {
        this.c.k.a(com.baidu.mobads.sdk.internal.bi.b, "AbstractProdTemplate,load-dex请求，回调失败");
        this.c.i();
    }

    @Override // com.baidu.mobads.sdk.internal.aa.a
    public void onSuccess() {
        this.c.k.a(com.baidu.mobads.sdk.internal.bi.b, "AbstractProdTemplate,load-dex请求，回调成功");
        this.c.h();
    }
}
