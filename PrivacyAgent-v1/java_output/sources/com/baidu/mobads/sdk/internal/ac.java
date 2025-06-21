package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
class ac implements com.baidu.mobads.sdk.internal.bz.c {
    final /* synthetic */ com.baidu.mobads.sdk.internal.aa a;

    public ac(com.baidu.mobads.sdk.internal.aa aaVar) {
        this.a = aaVar;
    }

    @Override // com.baidu.mobads.sdk.internal.bz.c
    public void a(boolean z) {
        com.baidu.mobads.sdk.api.IXAdContainerFactory iXAdContainerFactory;
        if (z) {
            try {
                com.baidu.mobads.sdk.internal.bz bzVar = com.baidu.mobads.sdk.internal.h.a;
                if (bzVar != null) {
                    this.a.b = bzVar.i();
                    iXAdContainerFactory = this.a.b;
                    if (iXAdContainerFactory != null) {
                        this.a.k();
                        return;
                    }
                }
            } catch (java.lang.Exception unused) {
                this.a.a("加载dex异常");
                return;
            }
        }
        com.baidu.mobads.sdk.internal.h.a = null;
        this.a.a("加载dex失败");
    }
}
