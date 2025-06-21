package com.igexin.sdk.router.boatman;

/* loaded from: classes23.dex */
public class BoatBean {
    private java.lang.Object bag;
    private com.igexin.sdk.router.boatman.receive.IBoatResult listener;

    public BoatBean() {
    }

    public BoatBean(java.lang.Object obj, com.igexin.sdk.router.boatman.receive.IBoatResult iBoatResult) {
        this.bag = obj;
        this.listener = iBoatResult;
    }

    public java.lang.Object getBag() {
        return this.bag;
    }

    public com.igexin.sdk.router.boatman.receive.IBoatResult getListener() {
        return this.listener;
    }

    public void setBag(java.lang.Object obj) {
        this.bag = obj;
    }

    public void setListener(com.igexin.sdk.router.boatman.receive.IBoatResult iBoatResult) {
        this.listener = iBoatResult;
    }
}
