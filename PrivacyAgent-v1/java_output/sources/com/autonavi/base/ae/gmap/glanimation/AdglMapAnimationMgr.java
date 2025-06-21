package com.autonavi.base.ae.gmap.glanimation;

/* loaded from: classes12.dex */
public class AdglMapAnimationMgr {
    private java.util.List<com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimation> list = java.util.Collections.synchronizedList(new java.util.ArrayList());
    private com.amap.api.maps.AMap.CancelableCallback mCancelCallback;
    private com.autonavi.base.ae.gmap.glanimation.AdglMapAnimationMgr.MapAnimationListener mMapAnimationListener;

    public interface MapAnimationListener {
        void onMapAnimationFinish(com.amap.api.maps.AMap.CancelableCallback cancelableCallback);
    }

    public void addAnimation(com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimation abstractAdglAnimation, com.amap.api.maps.AMap.CancelableCallback cancelableCallback) {
        if (abstractAdglAnimation == null) {
            return;
        }
        synchronized (this.list) {
            if (!abstractAdglAnimation.isOver() && this.list.size() > 0) {
                com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimation abstractAdglAnimation2 = this.list.get(r1.size() - 1);
                if (abstractAdglAnimation2 != null && (abstractAdglAnimation instanceof com.autonavi.base.ae.gmap.glanimation.AdglMapAnimGroup) && (abstractAdglAnimation2 instanceof com.autonavi.base.ae.gmap.glanimation.AdglMapAnimGroup) && ((com.autonavi.base.ae.gmap.glanimation.AdglMapAnimGroup) abstractAdglAnimation).typeEqueal((com.autonavi.base.ae.gmap.glanimation.AdglMapAnimGroup) abstractAdglAnimation2) && !((com.autonavi.base.ae.gmap.glanimation.AdglMapAnimGroup) abstractAdglAnimation).needMove) {
                    this.list.remove(abstractAdglAnimation2);
                }
            }
            this.list.add(abstractAdglAnimation);
            this.mCancelCallback = cancelableCallback;
        }
    }

    public synchronized void clearAnimations() {
        this.list.clear();
    }

    public synchronized void doAnimations(com.autonavi.base.ae.gmap.GLMapState gLMapState) {
        if (gLMapState == null) {
            return;
        }
        if (this.list.size() <= 0) {
            return;
        }
        com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimation abstractAdglAnimation = this.list.get(0);
        if (abstractAdglAnimation == null) {
            return;
        }
        if (!abstractAdglAnimation.isOver()) {
            abstractAdglAnimation.doAnimation(gLMapState);
            return;
        }
        com.autonavi.base.ae.gmap.glanimation.AdglMapAnimationMgr.MapAnimationListener mapAnimationListener = this.mMapAnimationListener;
        if (mapAnimationListener != null) {
            mapAnimationListener.onMapAnimationFinish(this.mCancelCallback);
        }
        this.list.remove(abstractAdglAnimation);
    }

    public synchronized int getAnimationsCount() {
        return this.list.size();
    }

    public com.amap.api.maps.AMap.CancelableCallback getCancelCallback() {
        return this.mCancelCallback;
    }

    public void setMapAnimationListener(com.autonavi.base.ae.gmap.glanimation.AdglMapAnimationMgr.MapAnimationListener mapAnimationListener) {
        synchronized (this) {
            this.mMapAnimationListener = mapAnimationListener;
        }
    }

    public void setMapCoreListener() {
    }
}
