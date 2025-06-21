package com.alimm.tanx.ui;

/* loaded from: classes.dex */
public class tanxu_do implements com.alimm.tanx.core.TanxInitListener {

    /* renamed from: tanxu_do, reason: collision with root package name */
    final /* synthetic */ android.app.Application f79tanxu_do;
    final /* synthetic */ com.alimm.tanx.core.TanxInitListener tanxu_for;
    final /* synthetic */ com.alimm.tanx.core.config.TanxConfig tanxu_if;

    public tanxu_do(android.app.Application application, com.alimm.tanx.core.config.TanxConfig tanxConfig, com.alimm.tanx.core.TanxInitListener tanxInitListener) {
        this.f79tanxu_do = application;
        this.tanxu_if = tanxConfig;
        this.tanxu_for = tanxInitListener;
    }

    @Override // com.alimm.tanx.core.TanxInitListener
    public void error(int i, java.lang.String str) {
        com.alimm.tanx.ui.TanxSdk.mIsInit.set(-1);
        this.tanxu_for.error(i, str);
    }

    @Override // com.alimm.tanx.core.TanxInitListener
    public void succ() {
        com.alimm.tanx.ui.tanxu_if tanxu_ifVar;
        com.alimm.tanx.core.utils.LogUtils.d("TanxSdk", "TanxCoreSdk Init succ");
        tanxu_ifVar = com.alimm.tanx.ui.TanxSdk.mInitializer;
        tanxu_ifVar.tanxu_do(this.f79tanxu_do, this.tanxu_if);
        com.alimm.tanx.ui.TanxSdk.mIsInit.set(2);
        this.tanxu_for.succ();
    }
}
