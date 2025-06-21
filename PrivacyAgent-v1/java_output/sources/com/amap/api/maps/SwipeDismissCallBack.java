package com.amap.api.maps;

/* loaded from: classes12.dex */
public class SwipeDismissCallBack implements com.amap.api.maps.SwipeDismissTouchListener.DismissCallbacks {
    com.amap.api.maps.SwipeDismissView a;

    public SwipeDismissCallBack(com.amap.api.maps.SwipeDismissView swipeDismissView) {
        this.a = swipeDismissView;
    }

    @Override // com.amap.api.maps.SwipeDismissTouchListener.DismissCallbacks
    public boolean canDismiss(java.lang.Object obj) {
        return true;
    }

    @Override // com.amap.api.maps.SwipeDismissTouchListener.DismissCallbacks
    public void onDismiss(android.view.View view, java.lang.Object obj) {
        com.amap.api.maps.WearMapView.OnDismissCallback onDismissCallback = this.a.onDismissCallback;
        if (onDismissCallback != null) {
            onDismissCallback.onDismiss();
        }
    }

    @Override // com.amap.api.maps.SwipeDismissTouchListener.DismissCallbacks
    public void onNotifySwipe() {
        com.amap.api.maps.WearMapView.OnDismissCallback onDismissCallback = this.a.onDismissCallback;
        if (onDismissCallback != null) {
            onDismissCallback.onNotifySwipe();
        }
    }
}
