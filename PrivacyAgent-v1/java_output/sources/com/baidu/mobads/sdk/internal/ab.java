package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
class ab implements java.lang.Runnable {
    final /* synthetic */ com.baidu.mobads.sdk.internal.aa a;

    public ab(com.baidu.mobads.sdk.internal.aa aaVar) {
        this.a = aaVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.a("加载dex超过5秒");
    }
}
