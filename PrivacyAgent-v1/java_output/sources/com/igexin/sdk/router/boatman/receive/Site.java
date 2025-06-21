package com.igexin.sdk.router.boatman.receive;

/* loaded from: classes23.dex */
public abstract class Site<Bag, V> {
    public abstract java.lang.String getTag();

    public abstract V onArrived(Bag bag);

    public abstract void onArrived(Bag bag, com.igexin.sdk.router.boatman.receive.IBoatResult<V> iBoatResult);
}
