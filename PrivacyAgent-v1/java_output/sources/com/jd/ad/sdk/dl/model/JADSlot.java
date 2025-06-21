package com.jd.ad.sdk.dl.model;

/* loaded from: classes23.dex */
public class JADSlot implements java.io.Serializable {
    private int adDataRequestSourceType;
    private float adImageHeight;
    private float adImageWidth;
    private int adType;
    private int atst;
    private int catp;
    private int clickAreaType;
    private long clickTime;
    private long dcdu;
    private long dedu;
    private long delayShowTime;
    private int displayScene;
    private int dstp;
    private com.jd.ad.sdk.bl.dynamicrender.DynamicRenderTemplateHelper dynamicRenderTemplateHelper = null;
    private long dynamicRenderViewInitSuccessTime;
    private long ecdu;
    private int eventInteractionType;
    private java.lang.String exposureExtend;
    private float height;
    private boolean hideClose;
    private final boolean hidePreloadLabel;
    private final boolean hideSkip;
    private int imm;
    private int interactionType;
    private boolean isFromNativeAd;
    private long loadSucTime;
    private long loadTime;
    private int mediaSpecSetType;
    private int modelClickAreaType;
    private int rem;
    private long renderSucTime;
    private java.lang.String requestId;
    private int scav;
    private long scdu;
    private long sedu;
    private int sen;
    private long showTime;
    private int skipTime;
    private final java.lang.String slotID;
    private int srtp;
    private int sspt;
    private int templateId;
    private float tolerateTime;
    private float width;

    public interface AdDataRequestSourceType {
        public static final int DATA_FROM_PRELOAD = 1;
        public static final int DATA_FROM_PRELOAD_CACHE = 2;
        public static final int DATA_FROM_REALTIME = 0;
    }

    public interface AdType {
        public static final int BANNER = 5;
        public static final int FEED = 2;
        public static final int INTERSTITIAL = 4;
        public static final int SPLASH = 1;
        public static final int UNKNOWN = 0;
    }

    public interface AdVideoPlayerStatus {
        public static final int VIDEO_PLAYER_STATUS_BUFFERED = 2;
        public static final int VIDEO_PLAYER_STATUS_DEFAULT = 0;
        public static final int VIDEO_PLAYER_STATUS_ERROR = 7;
        public static final int VIDEO_PLAYER_STATUS_FINISHED = 4;
        public static final int VIDEO_PLAYER_STATUS_PAUSED = 5;
        public static final int VIDEO_PLAYER_STATUS_RESUMED = 6;
        public static final int VIDEO_PLAYER_STATUS_STARTED = 3;
        public static final int VIDEO_PLAYER_STATUS_WILL_START = 1;
    }

    public interface AdVideoVoiceType {
        public static final int VOICE_DEFAULT = 0;
        public static final int VOICE_MUTED = 2;
        public static final int VOICE_NO_MUTED = 1;
    }

    public static class Builder {
        private float adImageHeight;
        private float adImageWidth;
        private int adType;
        private int eventInteractionType;
        private float height;
        private boolean hideClose;
        private boolean hidePreloadLabel;
        private boolean hideSkip;
        private java.lang.String slotID;
        private int templateId;
        private float width;
        private int skipTime = 5;
        private float tolerateTime = 5.0f;
        private int interactionType = 0;

        public com.jd.ad.sdk.dl.model.JADSlot build() {
            return new com.jd.ad.sdk.dl.model.JADSlot(this);
        }

        public com.jd.ad.sdk.dl.model.JADSlot.Builder setAdType(int i) {
            this.adType = i;
            return this;
        }

        public com.jd.ad.sdk.dl.model.JADSlot.Builder setCloseButtonHidden(boolean z) {
            this.hideClose = z;
            return this;
        }

        public com.jd.ad.sdk.dl.model.JADSlot.Builder setEventInteractionType(int i) {
            this.eventInteractionType = i;
            return this;
        }

        public com.jd.ad.sdk.dl.model.JADSlot.Builder setImageSize(float f, float f2) {
            this.adImageWidth = f;
            this.adImageHeight = f2;
            return this;
        }

        @java.lang.Deprecated
        public com.jd.ad.sdk.dl.model.JADSlot.Builder setInteractionType(int i) {
            this.interactionType = i;
            return this;
        }

        public com.jd.ad.sdk.dl.model.JADSlot.Builder setPreloadLabelHidden(boolean z) {
            this.hidePreloadLabel = z;
            return this;
        }

        public com.jd.ad.sdk.dl.model.JADSlot.Builder setSize(float f, float f2) {
            this.width = f;
            this.height = f2;
            return this;
        }

        public com.jd.ad.sdk.dl.model.JADSlot.Builder setSkipButtonHidden(boolean z) {
            this.hideSkip = z;
            return this;
        }

        public com.jd.ad.sdk.dl.model.JADSlot.Builder setSkipTime(int i) {
            if (i < 1) {
                this.skipTime = 5;
            } else {
                this.skipTime = i;
            }
            return this;
        }

        public com.jd.ad.sdk.dl.model.JADSlot.Builder setSlotID(@androidx.annotation.NonNull java.lang.String str) {
            this.slotID = str;
            return this;
        }

        public com.jd.ad.sdk.dl.model.JADSlot.Builder setTemplateId(int i) {
            this.templateId = i;
            return this;
        }

        public com.jd.ad.sdk.dl.model.JADSlot.Builder setTolerateTime(float f) {
            this.tolerateTime = java.lang.Math.max(f, 3.0f);
            return this;
        }
    }

    public interface EventInteractionType {
        public static final int EVENT_INTERACTION_TYPE_NORMAL = 0;
        public static final int EVENT_INTERACTION_TYPE_SHAKE = 1;
        public static final int EVENT_INTERACTION_TYPE_SWIPE_UP = 2;
    }

    @java.lang.Deprecated
    public interface InteractionType {
        public static final int NORMAL = 0;
        public static final int SHAKE = 1;
        public static final int SWIPE = 2;
    }

    public interface MediaSpecSetType {
        public static final int MEDIA_SPEC_SET_TYPE_FEED16_9_SINGLE = 10003;
        public static final int MEDIA_SPEC_SET_TYPE_FEED16_9_SINGLE_VIDEO = 10007;
        public static final int MEDIA_SPEC_SET_TYPE_FEED2_1_SINGLE = 10006;
        public static final int MEDIA_SPEC_SET_TYPE_FEED3_2_GROUP = 10005;
        public static final int MEDIA_SPEC_SET_TYPE_FEED3_2_SINGLE = 10004;
        public static final int MEDIA_SPEC_SET_TYPE_FEED9_16_SINGLE = 10010;
        public static final int MEDIA_SPEC_SET_TYPE_FEED9_16_SINGLE_VIDEO = 10008;
        public static final int MEDIA_SPEC_SET_TYPE_INTERSTITIAL9_16_SINGLE = 10011;
        public static final int MEDIA_SPEC_SET_TYPE_NORMAL = 0;
        public static final int MEDIA_SPEC_SET_TYPE_SPLASH2_3_SINGLE = 10001;
        public static final int MEDIA_SPEC_SET_TYPE_SPLASH9_16_SINGLE = 10002;
        public static final int MEDIA_SPEC_SET_TYPE_SPLASH9_16_SINGLE_VIDEO = 10009;
    }

    public JADSlot(com.jd.ad.sdk.dl.model.JADSlot.Builder builder) {
        this.skipTime = 5;
        this.slotID = builder.slotID;
        this.width = builder.width;
        this.height = builder.height;
        this.skipTime = builder.skipTime;
        this.hideClose = builder.hideClose;
        this.tolerateTime = builder.tolerateTime;
        this.adImageWidth = builder.adImageWidth;
        this.adImageHeight = builder.adImageHeight;
        this.adType = builder.adType;
        this.interactionType = builder.interactionType;
        this.hideSkip = builder.hideSkip;
        this.eventInteractionType = builder.eventInteractionType;
        this.templateId = builder.templateId;
        this.hidePreloadLabel = builder.hidePreloadLabel;
    }

    public int getAdDataRequestSourceType() {
        return this.adDataRequestSourceType;
    }

    public float getAdImageHeight() {
        return this.adImageHeight;
    }

    public float getAdImageWidth() {
        return this.adImageWidth;
    }

    public int getAdType() {
        return this.adType;
    }

    public int getAtst() {
        return this.atst;
    }

    public int getClickAreaType() {
        return this.clickAreaType;
    }

    public long getClickTime() {
        return this.clickTime;
    }

    public long getDcdu() {
        return this.dcdu;
    }

    public long getDedu() {
        return this.dedu;
    }

    public long getDelayShowTime() {
        return this.delayShowTime;
    }

    public int getDisplayScene() {
        return this.displayScene;
    }

    public int getDstp() {
        return this.dstp;
    }

    public int getDynamicInteractionType() {
        return this.interactionType;
    }

    public com.jd.ad.sdk.bl.dynamicrender.DynamicRenderTemplateHelper getDynamicRenderTemplateHelper() {
        return this.dynamicRenderTemplateHelper;
    }

    public long getDynamicRenderViewInitSuccessTime() {
        return this.dynamicRenderViewInitSuccessTime;
    }

    public long getEcdu() {
        return this.ecdu;
    }

    public int getEventInteractionType() {
        return this.eventInteractionType;
    }

    public java.lang.String getExposureExtend() {
        return this.exposureExtend;
    }

    public float getHeight() {
        return this.height;
    }

    public int getImm() {
        return this.imm;
    }

    public long getLoadSucTime() {
        return this.loadSucTime;
    }

    public long getLoadTime() {
        return this.loadTime;
    }

    public int getMediaSpecSetType() {
        return this.mediaSpecSetType;
    }

    public int getModelClickAreaType() {
        return this.modelClickAreaType;
    }

    public int getRem() {
        return this.rem;
    }

    public long getRenderSucTime() {
        return this.renderSucTime;
    }

    public java.lang.String getRequestId() {
        return this.requestId;
    }

    public int getScav() {
        return this.scav;
    }

    public long getScdu() {
        return this.scdu;
    }

    public long getSedu() {
        return this.sedu;
    }

    public int getSen() {
        return this.sen;
    }

    public long getShowTime() {
        return this.showTime;
    }

    public int getSkipTime() {
        return this.skipTime;
    }

    public java.lang.String getSlotID() {
        return this.slotID;
    }

    public int getSrtp() {
        return this.srtp;
    }

    public int getSspt() {
        return this.sspt;
    }

    public int getTemplateId() {
        return this.templateId;
    }

    public float getTolerateTime() {
        return this.tolerateTime;
    }

    public float getWidth() {
        return this.width;
    }

    public boolean isFromNativeAd() {
        return this.isFromNativeAd;
    }

    public boolean isHideClose() {
        return this.hideClose;
    }

    public boolean isHidePreloadLabel() {
        return this.hidePreloadLabel;
    }

    public boolean isHideSkip() {
        return this.hideSkip;
    }

    public void setAdDataRequestSourceType(int i) {
        this.adDataRequestSourceType = i;
    }

    public void setAdImageHeight(float f) {
        this.adImageHeight = f;
    }

    public void setAdImageWidth(float f) {
        this.adImageWidth = f;
    }

    public void setAdType(int i) {
        this.adType = i;
    }

    public void setAtst(int i) {
        this.atst = i;
    }

    public void setClickAreaType(int i) {
        this.clickAreaType = i;
    }

    public void setClickTime(long j) {
        this.clickTime = j;
    }

    public void setDcdu(long j) {
        this.dcdu = j;
    }

    public void setDedu(long j) {
        this.dedu = j;
    }

    public void setDelayShowTime(long j) {
        this.delayShowTime = j;
    }

    public void setDisplayScene(int i) {
        this.displayScene = i;
    }

    public void setDstp(int i) {
        this.dstp = i;
    }

    public void setDynamicRenderTemplateHelper(com.jd.ad.sdk.bl.dynamicrender.DynamicRenderTemplateHelper dynamicRenderTemplateHelper) {
        this.dynamicRenderTemplateHelper = dynamicRenderTemplateHelper;
    }

    public void setDynamicRenderViewInitSuccessTime(long j) {
        this.dynamicRenderViewInitSuccessTime = j;
    }

    public void setEcdu(long j) {
        this.ecdu = j;
    }

    public void setEventInteractionType(int i) {
        this.eventInteractionType = i;
    }

    public void setExposureExtend(java.lang.String str) {
        this.exposureExtend = str;
    }

    public void setFromNativeAd(boolean z) {
        this.isFromNativeAd = z;
    }

    public void setHeight(float f) {
        this.height = f;
    }

    public void setHideClose(boolean z) {
        this.hideClose = z;
    }

    public void setImm(int i) {
        this.imm = i;
    }

    public void setInteractionType(int i) {
        this.interactionType = i;
    }

    public void setLoadSucTime(long j) {
        this.loadSucTime = j;
    }

    public void setLoadTime(long j) {
        this.loadTime = j;
    }

    public void setMediaSpecSetType(int i) {
        this.mediaSpecSetType = i;
    }

    public void setModelClickAreaType(int i) {
        this.modelClickAreaType = i;
    }

    public void setRem(int i) {
        this.rem = i;
    }

    public void setRenderSucTime(long j) {
        this.renderSucTime = j;
    }

    public void setRequestId(java.lang.String str) {
        this.requestId = str;
    }

    public void setScav(int i) {
        this.scav = i;
    }

    public void setScdu(long j) {
        this.scdu = j;
    }

    public void setSedu(long j) {
        this.sedu = j;
    }

    public void setSen(int i) {
        this.sen = i;
    }

    public void setShowTime(long j) {
        this.showTime = j;
    }

    public void setSkipTime(int i) {
        if (i < 1) {
            this.skipTime = 5;
        } else {
            this.skipTime = i;
        }
    }

    public void setSrtp(int i) {
        this.srtp = i;
    }

    public void setSspt(int i) {
        this.sspt = i;
    }

    public void setTemplateId(int i) {
        this.templateId = i;
    }

    public void setTolerateTime(float f) {
        this.tolerateTime = f;
    }

    public void setWidth(float f) {
        this.width = f;
    }
}
