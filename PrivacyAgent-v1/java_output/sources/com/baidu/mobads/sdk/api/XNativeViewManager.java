package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public class XNativeViewManager {
    private static com.baidu.mobads.sdk.api.XNativeViewManager sInstance;
    private final java.util.ArrayList<com.baidu.mobads.sdk.api.XNativeView> mViewList = new java.util.ArrayList<>();

    private XNativeViewManager() {
    }

    public static com.baidu.mobads.sdk.api.XNativeViewManager getInstance() {
        if (sInstance == null) {
            synchronized (com.baidu.mobads.sdk.api.XNativeViewManager.class) {
                if (sInstance == null) {
                    sInstance = new com.baidu.mobads.sdk.api.XNativeViewManager();
                }
            }
        }
        return sInstance;
    }

    public void addItem(com.baidu.mobads.sdk.api.XNativeView xNativeView) {
        this.mViewList.add(xNativeView);
    }

    public void removeNativeView(com.baidu.mobads.sdk.api.XNativeView xNativeView) {
        if (this.mViewList.size() == 0) {
            return;
        }
        this.mViewList.remove(xNativeView);
    }

    public void resetAllPlayer(com.baidu.mobads.sdk.api.XNativeView xNativeView) {
        if (this.mViewList.size() == 0) {
            return;
        }
        java.util.Iterator<com.baidu.mobads.sdk.api.XNativeView> it = this.mViewList.iterator();
        while (it.hasNext()) {
            com.baidu.mobads.sdk.api.XNativeView next = it.next();
            if (next != xNativeView) {
                next.stop();
                next.handleCover();
            }
        }
    }
}
