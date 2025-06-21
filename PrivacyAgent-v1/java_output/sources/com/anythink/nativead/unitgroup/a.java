package com.anythink.nativead.unitgroup;

/* loaded from: classes12.dex */
public abstract class a extends com.anythink.core.api.BaseAd {
    private static final java.lang.String TAG = "a";
    protected com.anythink.core.common.f.h mAdTrackingInfo;
    protected com.anythink.core.api.ATEventInterface mDownloadListener;
    private com.anythink.core.common.b.m mNativeEventListener;
    private com.anythink.nativead.api.ATNativePrepareInfo nativePrepareInfo;
    public final int NETWORK_UNKNOW = -1;
    protected java.lang.String mAdSourceType = "0";
    protected int mNetworkType = -1;

    public abstract void bindDislikeListener(android.view.View.OnClickListener onClickListener);

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public abstract android.view.View getAdIconView();

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public abstract android.view.View getAdMediaView(java.lang.Object... objArr);

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public final java.lang.String getAdType() {
        return this.mAdSourceType;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public com.anythink.core.api.IATAdvertiserInfoOperate getAdvertiserInfoOperate() {
        return null;
    }

    @Override // com.anythink.core.api.BaseAd
    public final com.anythink.core.common.f.h getDetail() {
        return this.mAdTrackingInfo;
    }

    public final com.anythink.nativead.api.ATNativePrepareInfo getNativePrepareInfo() {
        return this.nativePrepareInfo;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public android.view.View getShakeView(int i, int i2, com.anythink.core.api.ATShakeViewListener aTShakeViewListener) {
        return null;
    }

    @Override // com.anythink.core.api.IATThirdPartyMaterial
    public android.view.View getSlideView(int i, int i2, int i3, com.anythink.core.api.ATShakeViewListener aTShakeViewListener) {
        return null;
    }

    public abstract boolean isNativeExpress();

    public final void notifyAdClicked() {
        com.anythink.core.common.b.m mVar = this.mNativeEventListener;
        if (mVar != null) {
            mVar.onAdClicked(null);
        }
    }

    public final void notifyAdDislikeClick() {
        com.anythink.core.common.b.m mVar = this.mNativeEventListener;
        if (mVar != null) {
            mVar.onAdDislikeButtonClick();
        }
    }

    public final void notifyAdImpression() {
        com.anythink.core.common.b.m mVar = this.mNativeEventListener;
        if (mVar != null) {
            mVar.onAdImpressed();
        }
    }

    public final void notifyAdVideoEnd() {
        com.anythink.core.common.b.m mVar = this.mNativeEventListener;
        if (mVar != null) {
            mVar.onAdVideoEnd();
        }
    }

    public final void notifyAdVideoPlayProgress(int i) {
        com.anythink.core.common.b.m mVar = this.mNativeEventListener;
        if (mVar != null) {
            mVar.onAdVideoProgress(i);
        }
    }

    public final void notifyAdVideoStart() {
        com.anythink.core.common.b.m mVar = this.mNativeEventListener;
        if (mVar != null) {
            mVar.onAdVideoStart();
        }
    }

    public final void notifyAdVideoVideoPlayFail(java.lang.String str, java.lang.String str2) {
        com.anythink.core.common.b.m mVar = this.mNativeEventListener;
        if (mVar == null || !(mVar instanceof com.anythink.core.common.b.n)) {
            return;
        }
        ((com.anythink.core.common.b.n) mVar).a(str, str2);
    }

    public final void notifyDeeplinkCallback(boolean z) {
        com.anythink.core.common.b.m mVar = this.mNativeEventListener;
        if (mVar != null) {
            mVar.onDeeplinkCallback(z);
        }
    }

    public final void notifyDownloadConfirm(android.content.Context context, android.view.View view, com.anythink.core.api.ATNetworkConfirmInfo aTNetworkConfirmInfo) {
        com.anythink.core.common.b.m mVar = this.mNativeEventListener;
        if (mVar != null) {
            mVar.onDownloadConfirmCallback(context, view, aTNetworkConfirmInfo);
        }
    }

    public abstract void onPause();

    public abstract void onResume();

    public abstract void pauseVideo();

    public abstract void prepare(android.view.View view, com.anythink.nativead.api.ATNativePrepareInfo aTNativePrepareInfo);

    public abstract void resumeVideo();

    public final void setDownloadListener(com.anythink.core.api.ATEventInterface aTEventInterface) {
        this.mDownloadListener = aTEventInterface;
    }

    @Override // com.anythink.core.api.BaseAd
    public void setNativeEventListener(com.anythink.core.common.b.m mVar) {
        this.mNativeEventListener = mVar;
    }

    public final void setNativePrepareInfo(com.anythink.nativead.api.ATNativePrepareInfo aTNativePrepareInfo) {
        this.nativePrepareInfo = aTNativePrepareInfo;
    }

    @Override // com.anythink.core.api.BaseAd
    public final void setTrackingInfo(com.anythink.core.common.f.h hVar) {
        this.mAdTrackingInfo = hVar;
    }
}
