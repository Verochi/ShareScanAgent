package com.qq.e.ads.nativ;

/* loaded from: classes19.dex */
public class NativeUnifiedADDataAdapter implements com.qq.e.ads.nativ.NativeUnifiedADData, com.qq.e.comm.compliance.DownloadConfirmListener {
    private com.qq.e.ads.nativ.NativeUnifiedADData a;
    private com.qq.e.ads.nativ.NativeADEventListener b;
    private com.qq.e.ads.nativ.NativeADMediaListener c;
    private com.qq.e.comm.compliance.DownloadConfirmListener d;
    private com.qq.e.comm.listeners.NegativeFeedbackListener e;

    public class UnifiedAdListener implements com.qq.e.comm.adevent.ADListener {
        private UnifiedAdListener() {
        }

        public /* synthetic */ UnifiedAdListener(com.qq.e.ads.nativ.NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter, com.qq.e.ads.nativ.NativeUnifiedADDataAdapter.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(com.qq.e.comm.adevent.ADEvent aDEvent) {
            if (com.qq.e.ads.nativ.NativeUnifiedADDataAdapter.a(com.qq.e.ads.nativ.NativeUnifiedADDataAdapter.this, aDEvent) || com.qq.e.ads.nativ.NativeUnifiedADDataAdapter.b(com.qq.e.ads.nativ.NativeUnifiedADDataAdapter.this, aDEvent)) {
                return;
            }
            com.qq.e.ads.nativ.NativeUnifiedADDataAdapter.c(com.qq.e.ads.nativ.NativeUnifiedADDataAdapter.this, aDEvent);
        }
    }

    public NativeUnifiedADDataAdapter(com.qq.e.ads.nativ.NativeUnifiedADData nativeUnifiedADData) {
        this.a = nativeUnifiedADData;
        if (nativeUnifiedADData instanceof com.qq.e.comm.adevent.ADEventListener) {
            ((com.qq.e.comm.adevent.ADEventListener) nativeUnifiedADData).setAdListener(new com.qq.e.ads.nativ.NativeUnifiedADDataAdapter.UnifiedAdListener(this, null));
        }
    }

    public static boolean a(com.qq.e.ads.nativ.NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter, com.qq.e.comm.adevent.ADEvent aDEvent) {
        if (nativeUnifiedADDataAdapter.b != null) {
            int type = aDEvent.getType();
            if (type == 103) {
                nativeUnifiedADDataAdapter.b.onADExposed();
            } else if (type == 105) {
                com.qq.e.ads.nativ.NativeADEventListener nativeADEventListener = nativeUnifiedADDataAdapter.b;
                if (nativeADEventListener instanceof com.qq.e.ads.nativ.NativeADEventListenerWithClickInfo) {
                    ((com.qq.e.ads.nativ.NativeADEventListenerWithClickInfo) nativeUnifiedADDataAdapter.b).onADClicked((android.view.View) aDEvent.getParam(android.view.View.class));
                } else {
                    nativeADEventListener.onADClicked();
                }
            } else if (type == 107) {
                java.lang.Integer num = (java.lang.Integer) aDEvent.getParam(java.lang.Integer.class);
                if (num != null) {
                    nativeUnifiedADDataAdapter.b.onADError(com.qq.e.comm.util.AdErrorConvertor.formatErrorCode(num.intValue()));
                }
            } else if (type == 111) {
                nativeUnifiedADDataAdapter.b.onADStatusChanged();
            }
            return true;
        }
        return false;
    }

    public static boolean b(com.qq.e.ads.nativ.NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter, com.qq.e.comm.adevent.ADEvent aDEvent) {
        if (nativeUnifiedADDataAdapter.c != null) {
            switch (aDEvent.getType()) {
                case 201:
                    java.lang.Integer num = (java.lang.Integer) aDEvent.getParam(java.lang.Integer.class);
                    if (num != null) {
                        nativeUnifiedADDataAdapter.c.onVideoLoaded(num.intValue());
                    }
                    return true;
                case 202:
                    nativeUnifiedADDataAdapter.c.onVideoStart();
                    return true;
                case 203:
                    nativeUnifiedADDataAdapter.c.onVideoResume();
                    return true;
                case 204:
                    nativeUnifiedADDataAdapter.c.onVideoPause();
                    return true;
                case com.qq.e.comm.adevent.AdEventType.VIDEO_STOP /* 205 */:
                    nativeUnifiedADDataAdapter.c.onVideoStop();
                    return true;
                case com.qq.e.comm.adevent.AdEventType.VIDEO_COMPLETE /* 206 */:
                    nativeUnifiedADDataAdapter.c.onVideoCompleted();
                    return true;
                case com.qq.e.comm.adevent.AdEventType.VIDEO_ERROR /* 207 */:
                    java.lang.Integer num2 = (java.lang.Integer) aDEvent.getParam(java.lang.Integer.class);
                    if (num2 != null) {
                        nativeUnifiedADDataAdapter.c.onVideoError(com.qq.e.comm.util.AdErrorConvertor.formatErrorCode(num2.intValue()));
                    }
                    return true;
                case com.qq.e.comm.adevent.AdEventType.VIDEO_CLICKED /* 208 */:
                    nativeUnifiedADDataAdapter.c.onVideoClicked();
                    return true;
                case com.qq.e.comm.adevent.AdEventType.VIDEO_INIT /* 209 */:
                    nativeUnifiedADDataAdapter.c.onVideoInit();
                    return true;
                case com.qq.e.comm.adevent.AdEventType.VIDEO_READY /* 210 */:
                    nativeUnifiedADDataAdapter.c.onVideoReady();
                    return true;
                case com.qq.e.comm.adevent.AdEventType.VIDEO_LOADING /* 211 */:
                    nativeUnifiedADDataAdapter.c.onVideoLoading();
                    return true;
            }
        }
        return false;
    }

    public static boolean c(com.qq.e.ads.nativ.NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter, com.qq.e.comm.adevent.ADEvent aDEvent) {
        if (nativeUnifiedADDataAdapter.e == null || aDEvent.getType() != 304) {
            return false;
        }
        nativeUnifiedADDataAdapter.e.onComplainSuccess();
        return true;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindAdToCustomVideo(android.view.ViewGroup viewGroup, android.content.Context context, java.util.List<android.view.View> list, java.util.List<android.view.View> list2) {
        this.a.bindAdToCustomVideo(viewGroup, context, list, list2);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindAdToView(android.content.Context context, com.qq.e.ads.nativ.widget.NativeAdContainer nativeAdContainer, android.widget.FrameLayout.LayoutParams layoutParams, java.util.List<android.view.View> list) {
        this.a.bindAdToView(context, nativeAdContainer, layoutParams, list);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindAdToView(android.content.Context context, com.qq.e.ads.nativ.widget.NativeAdContainer nativeAdContainer, android.widget.FrameLayout.LayoutParams layoutParams, java.util.List<android.view.View> list, java.util.List<android.view.View> list2) {
        this.a.bindAdToView(context, nativeAdContainer, layoutParams, list, list2);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindCTAViews(java.util.List<android.view.View> list) {
        this.a.bindCTAViews(list);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindImageViews(java.util.List<android.widget.ImageView> list, int i) {
        this.a.bindImageViews(list, i);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindImageViews(java.util.List<android.widget.ImageView> list, byte[] bArr) {
        this.a.bindImageViews(list, bArr);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void bindMediaView(com.qq.e.ads.nativ.MediaView mediaView, com.qq.e.ads.cfg.VideoOption videoOption, com.qq.e.ads.nativ.NativeADMediaListener nativeADMediaListener) {
        this.c = nativeADMediaListener;
        this.a.bindMediaView(mediaView, videoOption, nativeADMediaListener);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void destroy() {
        this.a.destroy();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean equalsAdData(com.qq.e.ads.nativ.NativeUnifiedADData nativeUnifiedADData) {
        return this.a.equalsAdData(nativeUnifiedADData);
    }

    public com.qq.e.ads.nativ.NativeUnifiedADData getAdData() {
        return this.a;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAdPatternType() {
        return this.a.getAdPatternType();
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public java.lang.String getApkInfoUrl() {
        return this.a.getApkInfoUrl();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo getAppMiitInfo() {
        return this.a.getAppMiitInfo();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public double getAppPrice() {
        return this.a.getAppPrice();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAppScore() {
        return this.a.getAppScore();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getAppStatus() {
        return this.a.getAppStatus();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public java.lang.String getButtonText() {
        return this.a.getButtonText();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public java.lang.String getCTAText() {
        return this.a.getCTAText();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public com.qq.e.ads.nativ.CustomizeVideo getCustomizeVideo() {
        return this.a.getCustomizeVideo();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public java.lang.String getDesc() {
        return this.a.getDesc();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public long getDownloadCount() {
        return this.a.getDownloadCount();
    }

    @Override // com.qq.e.comm.pi.LADI
    public int getECPM() {
        return this.a.getECPM();
    }

    @Override // com.qq.e.comm.pi.LADI
    public java.lang.String getECPMLevel() {
        return this.a.getECPMLevel();
    }

    @Override // com.qq.e.comm.pi.LADI
    public java.util.Map<java.lang.String, java.lang.Object> getExtraInfo() {
        return this.a.getExtraInfo();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public java.lang.String getIconUrl() {
        return this.a.getIconUrl();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public java.util.List<java.lang.String> getImgList() {
        return this.a.getImgList();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public java.lang.String getImgUrl() {
        return this.a.getImgUrl();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getPictureHeight() {
        return this.a.getPictureHeight();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getPictureWidth() {
        return this.a.getPictureWidth();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getProgress() {
        return this.a.getProgress();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public java.lang.String getTitle() {
        return this.a.getTitle();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getVideoCurrentPosition() {
        return this.a.getVideoCurrentPosition();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public int getVideoDuration() {
        return this.a.getVideoDuration();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean isAppAd() {
        return this.a.isAppAd();
    }

    @Override // com.qq.e.comm.pi.LADI
    public boolean isValid() {
        return this.a.isValid();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public boolean isWeChatCanvasAd() {
        return this.a.isWeChatCanvasAd();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void negativeFeedback() {
        this.a.negativeFeedback();
    }

    @Override // com.qq.e.comm.compliance.DownloadConfirmListener
    public void onDownloadConfirm(android.app.Activity activity, int i, java.lang.String str, com.qq.e.comm.compliance.DownloadConfirmCallBack downloadConfirmCallBack) {
        com.qq.e.comm.compliance.DownloadConfirmListener downloadConfirmListener = this.d;
        if (downloadConfirmListener != null) {
            downloadConfirmListener.onDownloadConfirm(activity, i, str, downloadConfirmCallBack);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void pauseAppDownload() {
        this.a.pauseAppDownload();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void pauseVideo() {
        this.a.pauseVideo();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resume() {
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resumeAppDownload() {
        this.a.resumeAppDownload();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void resumeVideo() {
        this.a.resumeVideo();
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(int i, int i2, java.lang.String str) {
        this.a.sendLossNotification(i, i2, str);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendLossNotification(java.util.Map<java.lang.String, java.lang.Object> map) {
        this.a.sendLossNotification(map);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(int i) {
        this.a.sendWinNotification(i);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void sendWinNotification(java.util.Map<java.lang.String, java.lang.Object> map) {
        this.a.sendWinNotification(map);
    }

    @Override // com.qq.e.comm.pi.IBidding
    public void setBidECPM(int i) {
        this.a.setBidECPM(i);
    }

    @Override // com.qq.e.comm.compliance.ApkDownloadComplianceInterface
    public void setDownloadConfirmListener(com.qq.e.comm.compliance.DownloadConfirmListener downloadConfirmListener) {
        this.d = downloadConfirmListener;
        com.qq.e.ads.nativ.NativeUnifiedADData nativeUnifiedADData = this.a;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.setDownloadConfirmListener(this);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void setNativeAdEventListener(com.qq.e.ads.nativ.NativeADEventListener nativeADEventListener) {
        this.b = nativeADEventListener;
    }

    @Override // com.qq.e.comm.pi.NFBI
    public void setNegativeFeedbackListener(com.qq.e.comm.listeners.NegativeFeedbackListener negativeFeedbackListener) {
        this.e = negativeFeedbackListener;
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void setVideoMute(boolean z) {
        this.a.setVideoMute(z);
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void startVideo() {
        this.a.startVideo();
    }

    @Override // com.qq.e.ads.nativ.NativeUnifiedADData
    public void stopVideo() {
        this.a.stopVideo();
    }
}
