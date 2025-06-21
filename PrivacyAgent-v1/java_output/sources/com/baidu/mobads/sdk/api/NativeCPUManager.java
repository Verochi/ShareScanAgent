package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public class NativeCPUManager {
    private static final java.lang.String TAG = "NativeCPUManager";
    private com.baidu.mobads.sdk.api.NativeCPUManager.CPUAdListener mCPUAdListener;
    private com.baidu.mobads.sdk.internal.ae mCPUAdProd;
    private android.content.Context mContext;
    private int mPageSize = 10;
    private java.util.HashMap<java.lang.String, java.lang.Object> mParams = new java.util.HashMap<>();

    public interface CPUAdListener {
        void onAdError(java.lang.String str, int i);

        void onAdLoaded(java.util.List<com.baidu.mobads.sdk.api.IBasicCPUData> list);

        void onDisLikeAdClick(int i, java.lang.String str);

        void onExitLp();

        void onLpCustomEventCallBack(java.util.HashMap<java.lang.String, java.lang.Object> hashMap, com.baidu.mobads.sdk.api.NativeCPUManager.DataPostBackListener dataPostBackListener);

        void onVideoDownloadFailed();

        void onVideoDownloadSuccess();
    }

    public interface DataPostBackListener {
        void postback(org.json.JSONObject jSONObject);
    }

    public NativeCPUManager(android.content.Context context, java.lang.String str, com.baidu.mobads.sdk.api.NativeCPUManager.CPUAdListener cPUAdListener) {
        this.mCPUAdProd = null;
        if (context == null || android.text.TextUtils.isEmpty(str)) {
            com.baidu.mobads.sdk.internal.bt.a().c(TAG, "Init params error!");
            if (cPUAdListener != null) {
                cPUAdListener.onAdError("Input params error.", com.baidu.mobads.sdk.internal.bp.INTERFACE_USE_PROBLEM.b());
                return;
            }
            return;
        }
        this.mCPUAdListener = cPUAdListener;
        this.mContext = context;
        com.baidu.mobads.sdk.internal.ae aeVar = new com.baidu.mobads.sdk.internal.ae(context, str, this);
        this.mCPUAdProd = aeVar;
        aeVar.a(cPUAdListener);
    }

    private void loadAd(int i, int[] iArr, boolean z) {
        if (i <= 0 || iArr == null) {
            com.baidu.mobads.sdk.internal.bt.a().c(TAG, "LoadAd with terrible params!");
            return;
        }
        com.baidu.mobads.sdk.internal.ae aeVar = this.mCPUAdProd;
        if (aeVar != null) {
            aeVar.a(i, this.mPageSize, iArr, z, this.mParams);
            this.mCPUAdProd.e();
            this.mCPUAdProd.a();
        }
    }

    public void loadAd(int i, int i2, boolean z) {
        loadAd(i, new int[]{i2}, z);
    }

    public void openAppActivity(java.lang.String str) {
        com.baidu.mobads.sdk.internal.ae aeVar = this.mCPUAdProd;
        if (aeVar != null) {
            aeVar.a(str);
            this.mCPUAdProd.a();
        }
    }

    public void setPageSize(int i) {
        if (i <= 0 || i > 20) {
            com.baidu.mobads.sdk.internal.bt.a().c(TAG, "Input page size is wrong which should be in (0,20]!");
        } else {
            this.mPageSize = i;
        }
    }

    public void setRequestParameter(com.baidu.mobads.sdk.api.CPUAdRequest cPUAdRequest) {
        if (cPUAdRequest == null || cPUAdRequest.getExtras() == null) {
            return;
        }
        this.mParams = cPUAdRequest.getExtras();
    }

    public void setRequestTimeoutMillis(int i) {
        com.baidu.mobads.sdk.internal.ae aeVar = this.mCPUAdProd;
        if (aeVar != null) {
            aeVar.a(i);
        }
    }
}
