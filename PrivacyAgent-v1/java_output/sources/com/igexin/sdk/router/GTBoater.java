package com.igexin.sdk.router;

/* loaded from: classes23.dex */
public class GTBoater extends com.igexin.sdk.router.boatman.Boater {
    private static com.igexin.sdk.router.GTBoater instance;

    public static com.igexin.sdk.router.GTBoater getInstance() {
        if (instance == null) {
            synchronized (com.igexin.sdk.router.GTBoater.class) {
                if (instance == null) {
                    instance = new com.igexin.sdk.router.GTBoater();
                }
            }
        }
        return instance;
    }

    @Override // com.igexin.sdk.router.boatman.Boater
    public java.lang.String getTag() {
        return "tag_gt";
    }

    public void initialize() {
        com.igexin.sdk.router.boatman.ShipsManager.get().register(new com.igexin.sdk.router.site.BridgeMessageSite());
        com.igexin.sdk.router.boatman.ShipsManager.get().register(new com.igexin.sdk.router.site.InitSite());
    }

    @Override // com.igexin.sdk.router.boatman.Boater
    public java.lang.Object postSync(java.lang.Object obj) {
        return super.postSync(obj);
    }

    @Override // com.igexin.sdk.router.boatman.Boater
    public boolean removeSticky(java.lang.Object obj) {
        return super.removeSticky(obj);
    }
}
