package com.igexin.base.boatman.receive;

/* loaded from: classes22.dex */
public abstract class Site<Bag, V> {
    public abstract java.lang.String getTag();

    public abstract V onArrived(Bag bag);

    public abstract void onArrived(Bag bag, com.igexin.base.boatman.receive.IBoatResult<V> iBoatResult);
}
