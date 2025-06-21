package com.igexin.sdk.router.boatman;

/* loaded from: classes23.dex */
public abstract class Boater<Bag, V> {
    public abstract java.lang.String getTag();

    public void postASync(Bag bag, com.igexin.sdk.router.boatman.receive.IBoatResult<V> iBoatResult) {
        com.igexin.sdk.router.boatman.ShipsManager.get().getShip().postASync(this, bag, iBoatResult);
    }

    public void postSticky(Bag bag, com.igexin.sdk.router.boatman.receive.IBoatResult<V> iBoatResult) {
        com.igexin.sdk.router.boatman.ShipsManager.get().getShip().postSticky(this, bag, iBoatResult);
    }

    public V postSync(Bag bag) {
        return (V) com.igexin.sdk.router.boatman.ShipsManager.get().getShip().postSync(this, bag);
    }

    public boolean removeSticky(Bag bag) {
        return com.igexin.sdk.router.boatman.ShipsManager.get().getShip().removeSticky(this, bag);
    }
}
