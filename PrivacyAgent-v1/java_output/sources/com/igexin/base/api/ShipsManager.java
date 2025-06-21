package com.igexin.base.api;

/* loaded from: classes22.dex */
public class ShipsManager {
    public static final java.lang.String TAG_EXTENSION_INIT = "tag_extension_init";
    public static final java.lang.String TAG_FEEDBACK = "tag_feedback";
    public static final java.lang.String TAG_GKT = "tag_gkt";
    public static final java.lang.String TAG_GT = "tag_gt";
    private static com.igexin.base.api.ShipsManager mInstance;
    private final com.igexin.base.boatman.b mBase = new com.igexin.base.boatman.b();

    private ShipsManager() {
    }

    public static com.igexin.base.api.ShipsManager get() {
        if (mInstance == null) {
            synchronized (com.igexin.base.api.ShipsManager.class) {
                if (mInstance == null) {
                    mInstance = new com.igexin.base.api.ShipsManager();
                }
            }
        }
        return mInstance;
    }

    public com.igexin.base.boatman.b getShip() {
        return this.mBase;
    }

    public boolean isRegistered(com.igexin.base.boatman.receive.Site site) {
        return this.mBase.b.containsKey(site.getTag());
    }

    public void register(com.igexin.base.boatman.receive.Site site) {
        com.igexin.base.boatman.b bVar = this.mBase;
        java.lang.String tag = site.getTag();
        bVar.a.lock();
        try {
            bVar.b.put(tag, site);
            java.util.List<com.igexin.base.boatman.a> list = bVar.c.get(tag);
            if (list != null && list.size() > 0) {
                java.util.Iterator<com.igexin.base.boatman.a> it = list.iterator();
                while (it.hasNext()) {
                    com.igexin.base.boatman.a next = it.next();
                    com.igexin.base.boatman.receive.IBoatResult iBoatResult = next.b;
                    if (iBoatResult != null) {
                        site.onArrived(next.a, iBoatResult);
                    }
                    it.remove();
                }
            }
        } finally {
            bVar.a.unlock();
        }
    }

    public void unRegister(com.igexin.base.boatman.receive.Site site) {
        com.igexin.base.boatman.b bVar = this.mBase;
        bVar.a.lock();
        try {
            bVar.b.remove(site.getTag());
        } finally {
            bVar.a.unlock();
        }
    }
}
