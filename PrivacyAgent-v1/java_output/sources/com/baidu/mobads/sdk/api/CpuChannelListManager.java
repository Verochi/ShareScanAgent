package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public class CpuChannelListManager {
    private static final java.lang.String TAG = "CpuChannelListManager";
    private com.baidu.mobads.sdk.internal.o mCPUChannelListProd;
    private com.baidu.mobads.sdk.api.CpuChannelListManager.CpuChannelListListener mChannelIdListListener;

    public interface CpuChannelListListener {
        void onChannelListError(java.lang.String str, int i);

        void onChannelListLoaded(java.util.List<com.baidu.mobads.sdk.api.CpuChannelResponse> list);
    }

    public CpuChannelListManager(android.content.Context context, com.baidu.mobads.sdk.api.CpuChannelListManager.CpuChannelListListener cpuChannelListListener) {
        com.baidu.mobads.sdk.internal.o oVar = new com.baidu.mobads.sdk.internal.o(context);
        this.mCPUChannelListProd = oVar;
        this.mChannelIdListListener = cpuChannelListListener;
        oVar.a(cpuChannelListListener);
    }

    public void loadChannelList(java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str2)) {
            com.baidu.mobads.sdk.internal.bt.a().c(TAG, "SubChannelId is null!");
            com.baidu.mobads.sdk.api.CpuChannelListManager.CpuChannelListListener cpuChannelListListener = this.mChannelIdListListener;
            if (cpuChannelListListener != null) {
                cpuChannelListListener.onChannelListError("SubChannelId is null.", com.baidu.mobads.sdk.internal.bp.INTERFACE_USE_PROBLEM.b());
                return;
            }
            return;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            com.baidu.mobads.sdk.internal.bt.a().c(TAG, "appsid is null!");
            com.baidu.mobads.sdk.api.CpuChannelListManager.CpuChannelListListener cpuChannelListListener2 = this.mChannelIdListListener;
            if (cpuChannelListListener2 != null) {
                cpuChannelListListener2.onChannelListError("appsid is null.", com.baidu.mobads.sdk.internal.bp.INTERFACE_USE_PROBLEM.b());
                return;
            }
            return;
        }
        try {
            int parseInt = java.lang.Integer.parseInt(str2);
            com.baidu.mobads.sdk.internal.o oVar = this.mCPUChannelListProd;
            if (oVar != null) {
                oVar.a(str, parseInt);
                this.mCPUChannelListProd.a();
            }
        } catch (java.lang.Exception unused) {
            com.baidu.mobads.sdk.internal.bt.a().c(TAG, "SubChannelId is not Integer!");
            if (this.mChannelIdListListener != null) {
                this.mChannelIdListListener.onChannelListError("SubChannelId is not Integer!", com.baidu.mobads.sdk.internal.bp.INTERFACE_USE_PROBLEM.b());
            }
        }
    }
}
