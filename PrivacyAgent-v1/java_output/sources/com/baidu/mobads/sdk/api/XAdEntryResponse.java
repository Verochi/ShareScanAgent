package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public class XAdEntryResponse implements com.baidu.mobads.sdk.api.EntryResponse {
    private static final java.lang.String TAG = "XAdEntryResponse";
    private boolean isDownloadApp;
    private com.baidu.mobads.sdk.internal.a mAdInfo;
    private com.baidu.mobads.sdk.api.EntryResponse.EntryAdInteractionListener mAdInteractionListener;
    private android.content.Context mCxt;
    private com.baidu.mobads.sdk.internal.de mFeedsProd;
    private com.baidu.mobads.sdk.internal.cq mUriUtils;

    public XAdEntryResponse(android.content.Context context, com.baidu.mobads.sdk.internal.de deVar, com.baidu.mobads.sdk.internal.a aVar) {
        this.isDownloadApp = false;
        this.mCxt = context;
        this.mFeedsProd = deVar;
        this.mAdInfo = aVar;
        if (aVar.p() == 2) {
            this.isDownloadApp = true;
        }
        this.mUriUtils = com.baidu.mobads.sdk.internal.cq.a();
    }

    @Override // com.baidu.mobads.sdk.api.EntryResponse
    public java.lang.String getAdLogoUrl() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInfo;
        return aVar != null ? aVar.h() : "https://cpro.baidustatic.com/cpro/logo/sdk/mob-adIcon_2x.png";
    }

    @Override // com.baidu.mobads.sdk.api.EntryResponse
    public java.lang.String getBaiduLogoUrl() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInfo;
        return aVar != null ? aVar.i() : "https://cpro.baidustatic.com/cpro/logo/sdk/new-bg-logo.png";
    }

    @Override // com.baidu.mobads.sdk.api.EntryResponse
    public java.lang.String getTitle() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInfo;
        return aVar != null ? aVar.a() : "";
    }

    public java.lang.String getUniqueId() {
        com.baidu.mobads.sdk.internal.a aVar = this.mAdInfo;
        return aVar != null ? aVar.I() : "";
    }

    @Override // com.baidu.mobads.sdk.api.EntryResponse
    public boolean isAdAvailable() {
        return this.mAdInfo != null && java.lang.System.currentTimeMillis() - this.mAdInfo.y() <= this.mAdInfo.G();
    }

    public void onADExposed() {
        com.baidu.mobads.sdk.api.EntryResponse.EntryAdInteractionListener entryAdInteractionListener = this.mAdInteractionListener;
        if (entryAdInteractionListener != null) {
            entryAdInteractionListener.onADExposed();
        }
    }

    public void onADExposureFailed(int i) {
        com.baidu.mobads.sdk.api.EntryResponse.EntryAdInteractionListener entryAdInteractionListener = this.mAdInteractionListener;
        if (entryAdInteractionListener != null) {
            entryAdInteractionListener.onADExposureFailed(i);
        }
    }

    public void onAdClick() {
        com.baidu.mobads.sdk.api.EntryResponse.EntryAdInteractionListener entryAdInteractionListener = this.mAdInteractionListener;
        if (entryAdInteractionListener != null) {
            entryAdInteractionListener.onAdClick();
        }
    }

    public void onAdUnionClick() {
        com.baidu.mobads.sdk.api.EntryResponse.EntryAdInteractionListener entryAdInteractionListener = this.mAdInteractionListener;
        if (entryAdInteractionListener != null) {
            entryAdInteractionListener.onAdUnionClick();
        }
    }

    @Override // com.baidu.mobads.sdk.api.EntryResponse
    public void registerViewForInteraction(android.view.View view, java.util.List<android.view.View> list, java.util.List<android.view.View> list2, com.baidu.mobads.sdk.api.EntryResponse.EntryAdInteractionListener entryAdInteractionListener) {
        this.mAdInteractionListener = entryAdInteractionListener;
        if (this.mFeedsProd != null) {
            try {
                java.util.HashMap hashMap = new java.util.HashMap();
                hashMap.put("adView", view);
                hashMap.put("clickViews", list);
                hashMap.put("creativeViews", list2);
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put("msg", "registerViewForInteraction");
                jSONObject.put("uniqueId", getUniqueId());
                jSONObject.put("isDownloadApp", this.isDownloadApp);
                this.mFeedsProd.a(jSONObject, hashMap);
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    @Override // com.baidu.mobads.sdk.api.EntryResponse
    public void unionLogoClick() {
        com.baidu.mobads.sdk.internal.cq cqVar;
        if (this.mFeedsProd == null || (cqVar = this.mUriUtils) == null) {
            return;
        }
        java.lang.String c = cqVar.c("http://union.baidu.com/");
        org.json.JSONObject U = this.mAdInfo.U();
        try {
            U.put("unionUrl", c);
            U.put("msg", "unionLogoClick");
        } catch (java.lang.Throwable unused) {
        }
        this.mFeedsProd.a(U);
    }
}
