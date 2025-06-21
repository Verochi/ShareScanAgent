package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public class CPUNovelAd {
    private com.baidu.mobads.sdk.internal.cx mCpuNovelProd;

    public interface CpuNovelListener {
        void onAdClick();

        void onAdImpression();

        void onReadTime(long j);
    }

    public CPUNovelAd(android.content.Context context, java.lang.String str, com.baidu.mobads.sdk.api.CPUWebAdRequestParam cPUWebAdRequestParam, com.baidu.mobads.sdk.api.CPUNovelAd.CpuNovelListener cpuNovelListener) {
        com.baidu.mobads.sdk.internal.cx cxVar = new com.baidu.mobads.sdk.internal.cx(context, str, cPUWebAdRequestParam);
        this.mCpuNovelProd = cxVar;
        cxVar.a(cpuNovelListener);
        this.mCpuNovelProd.a();
    }

    public void destory() {
        com.baidu.mobads.sdk.internal.cx cxVar = this.mCpuNovelProd;
        if (cxVar != null) {
            cxVar.y();
        }
    }

    public android.view.View getNovelView() {
        return this.mCpuNovelProd.w();
    }
}
