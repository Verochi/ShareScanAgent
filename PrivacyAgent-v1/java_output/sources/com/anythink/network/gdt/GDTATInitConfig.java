package com.anythink.network.gdt;

/* loaded from: classes12.dex */
public class GDTATInitConfig extends com.anythink.core.api.ATInitConfig {
    public GDTATInitConfig(java.lang.String str) {
        this.paramMap.put("app_id", str);
        this.initMediation = com.anythink.network.gdt.GDTATInitManager.getInstance();
    }
}
