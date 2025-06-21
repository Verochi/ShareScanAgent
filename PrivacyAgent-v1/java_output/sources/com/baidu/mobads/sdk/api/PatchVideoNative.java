package com.baidu.mobads.sdk.api;

/* loaded from: classes.dex */
public class PatchVideoNative {
    private java.lang.String mAdPlaceId;
    private com.baidu.mobads.sdk.api.PrerollVideoResponse mAdResponse;
    private java.lang.String mAppSid;
    private com.baidu.mobads.sdk.api.BaiduNativeManager mBaiduNativeManager;
    private android.content.Context mContext;
    private boolean mIsMute;
    private com.baidu.mobads.sdk.api.PatchVideoNative.IPatchVideoNativeListener mListener;
    private android.widget.RelativeLayout mParentView;
    private com.baidu.mobads.sdk.api.PatchAdView mPatchView;

    /* renamed from: com.baidu.mobads.sdk.api.PatchVideoNative$1, reason: invalid class name */
    class AnonymousClass1 implements com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener {
        public AnonymousClass1() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onLpClosed() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onNativeFail(int i, java.lang.String str, com.baidu.mobads.sdk.api.NativeResponse nativeResponse) {
            com.baidu.mobads.sdk.api.PatchVideoNative.this.callLoadFail(i, str);
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onNativeLoad(java.util.List<com.baidu.mobads.sdk.api.NativeResponse> list) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(new com.baidu.mobads.sdk.api.XAdVideoResponse(list.get(i)));
            }
            com.baidu.mobads.sdk.api.PatchVideoNative.this.mAdResponse = (com.baidu.mobads.sdk.api.PrerollVideoResponse) arrayList.get(0);
            com.baidu.mobads.sdk.api.PatchVideoNative.this.callLoadSucc();
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onNoAd(int i, java.lang.String str, com.baidu.mobads.sdk.api.NativeResponse nativeResponse) {
            com.baidu.mobads.sdk.api.PatchVideoNative.this.callLoadFail(i, str);
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onVideoDownloadFailed() {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
        public void onVideoDownloadSuccess() {
        }
    }

    /* renamed from: com.baidu.mobads.sdk.api.PatchVideoNative$2, reason: invalid class name */
    class AnonymousClass2 implements com.baidu.mobads.sdk.api.IPatchAdListener {
        public AnonymousClass2() {
        }

        @Override // com.baidu.mobads.sdk.api.IPatchAdListener
        public void onAdClicked() {
            com.baidu.mobads.sdk.api.PatchVideoNative.this.callAdClick();
        }

        @Override // com.baidu.mobads.sdk.api.IPatchAdListener
        public void onAdShow() {
            com.baidu.mobads.sdk.api.PatchVideoNative.this.callAdShow();
        }

        @Override // com.baidu.mobads.sdk.api.IPatchAdListener
        public void playCompletion() {
            com.baidu.mobads.sdk.api.PatchVideoNative.this.callPlayCompletion();
        }

        @Override // com.baidu.mobads.sdk.api.IPatchAdListener
        public void playError() {
            com.baidu.mobads.sdk.api.PatchVideoNative.this.callPlayError();
        }
    }

    public interface IPatchVideoNativeListener {
        void onAdClick();

        void onAdFailed(int i, java.lang.String str);

        void onAdLoad(java.lang.String str);

        void onAdShow();

        void playCompletion();

        void playError();
    }

    public PatchVideoNative(android.content.Context context, java.lang.String str, android.widget.RelativeLayout relativeLayout, com.baidu.mobads.sdk.api.PatchVideoNative.IPatchVideoNativeListener iPatchVideoNativeListener) {
        this.mContext = context;
        this.mAdPlaceId = str;
        this.mParentView = relativeLayout;
        this.mListener = iPatchVideoNativeListener;
        this.mBaiduNativeManager = new com.baidu.mobads.sdk.api.BaiduNativeManager(this.mContext, this.mAdPlaceId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callAdClick() {
        com.baidu.mobads.sdk.api.PatchVideoNative.IPatchVideoNativeListener iPatchVideoNativeListener = this.mListener;
        if (iPatchVideoNativeListener != null) {
            iPatchVideoNativeListener.onAdClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callAdShow() {
        com.baidu.mobads.sdk.api.PatchVideoNative.IPatchVideoNativeListener iPatchVideoNativeListener = this.mListener;
        if (iPatchVideoNativeListener != null) {
            iPatchVideoNativeListener.onAdShow();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callLoadFail(int i, java.lang.String str) {
        com.baidu.mobads.sdk.api.PatchVideoNative.IPatchVideoNativeListener iPatchVideoNativeListener = this.mListener;
        if (iPatchVideoNativeListener != null) {
            iPatchVideoNativeListener.onAdFailed(i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callLoadSucc() {
        com.baidu.mobads.sdk.api.PatchVideoNative.IPatchVideoNativeListener iPatchVideoNativeListener = this.mListener;
        if (iPatchVideoNativeListener != null) {
            iPatchVideoNativeListener.onAdLoad(this.mAdResponse.getMaterialType());
        }
        com.baidu.mobads.sdk.api.PatchAdView patchAdView = new com.baidu.mobads.sdk.api.PatchAdView(this.mContext);
        this.mPatchView = patchAdView;
        patchAdView.setVideoVolume(this.mIsMute);
        this.mParentView.addView(this.mPatchView, new android.widget.RelativeLayout.LayoutParams(-1, -1));
        this.mPatchView.setPatchAdListener(new com.baidu.mobads.sdk.api.PatchVideoNative.AnonymousClass2());
        this.mPatchView.setAdData((com.baidu.mobads.sdk.api.XAdVideoResponse) this.mAdResponse);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callPlayCompletion() {
        com.baidu.mobads.sdk.api.PatchVideoNative.IPatchVideoNativeListener iPatchVideoNativeListener = this.mListener;
        if (iPatchVideoNativeListener != null) {
            iPatchVideoNativeListener.playCompletion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callPlayError() {
        com.baidu.mobads.sdk.api.PatchVideoNative.IPatchVideoNativeListener iPatchVideoNativeListener = this.mListener;
        if (iPatchVideoNativeListener != null) {
            iPatchVideoNativeListener.playError();
        }
    }

    public long getCurrentPosition() {
        com.baidu.mobads.sdk.api.PatchAdView patchAdView = this.mPatchView;
        if (patchAdView != null) {
            return patchAdView.getCurrentPosition();
        }
        return 0L;
    }

    public long getDuration() {
        com.baidu.mobads.sdk.api.PatchAdView patchAdView = this.mPatchView;
        if (patchAdView != null) {
            return patchAdView.getDuration();
        }
        return 0L;
    }

    public void requestAd(com.baidu.mobads.sdk.api.RequestParameters requestParameters) {
        com.baidu.mobads.sdk.api.BaiduNativeManager baiduNativeManager = this.mBaiduNativeManager;
        if (baiduNativeManager != null) {
            baiduNativeManager.setAppSid(this.mAppSid);
            this.mBaiduNativeManager.loadPrerollVideo(requestParameters, new com.baidu.mobads.sdk.api.PatchVideoNative.AnonymousClass1());
        }
    }

    public void setAppSid(java.lang.String str) {
        this.mAppSid = str;
    }

    public void setVideoMute(boolean z) {
        this.mIsMute = z;
        com.baidu.mobads.sdk.api.PatchAdView patchAdView = this.mPatchView;
        if (patchAdView != null) {
            patchAdView.setVideoVolume(z);
        }
    }
}
