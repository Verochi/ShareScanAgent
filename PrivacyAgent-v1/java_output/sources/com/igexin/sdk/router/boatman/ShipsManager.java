package com.igexin.sdk.router.boatman;

/* loaded from: classes23.dex */
public class ShipsManager implements com.igexin.sdk.router.boatman.IShips {
    public static final java.lang.String TAG_EXTENSION_INIT = "tag_extension_init";
    public static final java.lang.String TAG_FEEDBACK = "tag_feedback";
    public static final java.lang.String TAG_GKT = "tag_gkt";
    public static final java.lang.String TAG_GT = "tag_gt";
    private static com.igexin.sdk.router.boatman.ShipsManager mInstance;
    private final com.igexin.sdk.router.boatman.ShipsManagerImpl mBase = new com.igexin.sdk.router.boatman.ShipsManagerImpl();

    private ShipsManager() {
    }

    public static com.igexin.sdk.router.boatman.ShipsManager get() {
        if (mInstance == null) {
            synchronized (com.igexin.sdk.router.boatman.ShipsManager.class) {
                if (mInstance == null) {
                    mInstance = new com.igexin.sdk.router.boatman.ShipsManager();
                }
            }
        }
        return mInstance;
    }

    public com.igexin.sdk.router.boatman.ShipsManagerImpl getShip() {
        return this.mBase;
    }

    @Override // com.igexin.sdk.router.boatman.IShips
    public boolean isRegistered(com.igexin.sdk.router.boatman.receive.Site site) {
        return this.mBase.isRegistered(site);
    }

    @Override // com.igexin.sdk.router.boatman.IShips
    public void register(com.igexin.sdk.router.boatman.receive.Site site) {
        this.mBase.register(site);
    }

    @Override // com.igexin.sdk.router.boatman.IShips
    public void unRegister(com.igexin.sdk.router.boatman.receive.Site site) {
        this.mBase.unRegister(site);
    }
}
