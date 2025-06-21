package com.igexin.sdk.router.boatman;

/* loaded from: classes23.dex */
public interface IShips {
    boolean isRegistered(com.igexin.sdk.router.boatman.receive.Site site);

    void register(com.igexin.sdk.router.boatman.receive.Site site);

    void unRegister(com.igexin.sdk.router.boatman.receive.Site site);
}
