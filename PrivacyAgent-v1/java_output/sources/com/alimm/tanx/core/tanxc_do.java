package com.alimm.tanx.core;

/* loaded from: classes.dex */
public class tanxc_do {
    private android.app.Application tanxc_do;
    private com.alimm.tanx.core.config.TanxConfig tanxc_if;

    public com.alimm.tanx.core.config.TanxConfig tanxc_do() {
        return this.tanxc_if;
    }

    public void tanxc_do(android.app.Application application, com.alimm.tanx.core.config.TanxConfig tanxConfig, com.alimm.tanx.core.TanxCoreInstanceConfig tanxCoreInstanceConfig, com.alimm.tanx.core.TanxInitListener tanxInitListener) {
        this.tanxc_do = application;
        this.tanxc_if = tanxConfig;
        com.alimm.tanx.core.TanxCoreManager.getInstance().init(application, tanxConfig, tanxCoreInstanceConfig, tanxInitListener);
    }

    public com.alimm.tanx.core.ad.ITanxCoreManager tanxc_if() {
        return com.alimm.tanx.core.TanxCoreManager.getInstance();
    }
}
