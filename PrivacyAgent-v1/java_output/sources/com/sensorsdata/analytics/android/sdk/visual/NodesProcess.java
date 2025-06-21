package com.sensorsdata.analytics.android.sdk.visual;

/* loaded from: classes19.dex */
public class NodesProcess {
    private static volatile com.sensorsdata.analytics.android.sdk.visual.NodesProcess mSingleton;
    private volatile com.sensorsdata.analytics.android.sdk.visual.FlutterNodesManager mFlutterNodesManager;
    private volatile com.sensorsdata.analytics.android.sdk.visual.WebNodesManager mWebNodesManager;

    public static com.sensorsdata.analytics.android.sdk.visual.NodesProcess getInstance() {
        if (mSingleton == null) {
            synchronized (com.sensorsdata.analytics.android.sdk.visual.NodesProcess.class) {
                if (mSingleton == null) {
                    mSingleton = new com.sensorsdata.analytics.android.sdk.visual.NodesProcess();
                }
            }
        }
        return mSingleton;
    }

    public com.sensorsdata.analytics.android.sdk.visual.FlutterNodesManager getFlutterNodesManager() {
        if (this.mFlutterNodesManager == null) {
            synchronized (com.sensorsdata.analytics.android.sdk.visual.FlutterNodesManager.class) {
                if (this.mFlutterNodesManager == null) {
                    this.mFlutterNodesManager = new com.sensorsdata.analytics.android.sdk.visual.FlutterNodesManager();
                }
            }
        }
        return this.mFlutterNodesManager;
    }

    public com.sensorsdata.analytics.android.sdk.visual.WebNodesManager getWebNodesManager() {
        if (this.mWebNodesManager == null) {
            synchronized (com.sensorsdata.analytics.android.sdk.visual.WebNodesManager.class) {
                if (this.mWebNodesManager == null) {
                    this.mWebNodesManager = new com.sensorsdata.analytics.android.sdk.visual.WebNodesManager();
                }
            }
        }
        return this.mWebNodesManager;
    }
}
