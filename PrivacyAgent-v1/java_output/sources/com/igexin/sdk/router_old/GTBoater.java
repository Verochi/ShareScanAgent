package com.igexin.sdk.router_old;

/* loaded from: classes23.dex */
public class GTBoater extends com.igexin.base.boatman.Boater {
    private static com.igexin.sdk.router_old.GTBoater instance;

    private GTBoater() {
        com.igexin.base.api.ShipsManager.get().register(new com.igexin.sdk.router_old.site.BridgeMessageSite());
        com.igexin.base.api.ShipsManager.get().register(new com.igexin.sdk.router_old.site.InitSite());
    }

    public static com.igexin.sdk.router_old.GTBoater getInstance() {
        if (instance == null) {
            synchronized (com.igexin.sdk.router_old.GTBoater.class) {
                if (instance == null) {
                    instance = new com.igexin.sdk.router_old.GTBoater();
                }
            }
        }
        return instance;
    }

    @Override // com.igexin.base.boatman.Boater
    public java.lang.String getTag() {
        return "tag_gt";
    }

    @Override // com.igexin.base.boatman.Boater
    public java.lang.Object postSync(java.lang.Object obj) {
        return super.postSync(obj);
    }

    @Override // com.igexin.base.boatman.Boater
    public boolean removeSticky(java.lang.Object obj) {
        return super.removeSticky(obj);
    }
}
