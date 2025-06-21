package com.sensorsdata.sf.core;

/* loaded from: classes19.dex */
public class SFConfigOptions {
    private static final java.lang.String TAG = "SFConfigOptions";
    private java.lang.String mApiBaseUrl;
    private com.sensorsdata.sf.ui.listener.SensorsFocusCampaignListener mCampaignListener;
    private java.util.Set<java.lang.Integer> mDelayActivityCode;
    private com.sensorsdata.sf.ui.listener.PopupListener mPopupListener;
    private android.graphics.Bitmap placeholderBitmap;
    private boolean mIsPreloadImage = true;
    private boolean mEnablePopup = true;
    private int placeholderResourceId = -1;

    public SFConfigOptions(java.lang.String str) {
        this.mApiBaseUrl = str;
    }

    @java.lang.Deprecated
    public com.sensorsdata.sf.core.SFConfigOptions enablePopup(boolean z) {
        this.mEnablePopup = z;
        return this;
    }

    public java.lang.String getApiBaseUrl() {
        return this.mApiBaseUrl;
    }

    public com.sensorsdata.sf.ui.listener.SensorsFocusCampaignListener getCampaignListener() {
        return this.mCampaignListener;
    }

    public android.graphics.Bitmap getPlaceholderImage() {
        return this.placeholderBitmap;
    }

    public int getPlaceholderResourceId() {
        return this.placeholderResourceId;
    }

    public com.sensorsdata.sf.ui.listener.PopupListener getPopupListener() {
        return this.mPopupListener;
    }

    public java.util.Set<java.lang.Integer> getSplashActivity() {
        return this.mDelayActivityCode;
    }

    public boolean isEnablePopup() {
        return this.mEnablePopup;
    }

    public boolean isPreloadImage() {
        return this.mIsPreloadImage;
    }

    public com.sensorsdata.sf.core.SFConfigOptions preloadImage(boolean z) {
        this.mIsPreloadImage = z;
        return this;
    }

    public com.sensorsdata.sf.core.SFConfigOptions setCampaignListener(com.sensorsdata.sf.ui.listener.SensorsFocusCampaignListener sensorsFocusCampaignListener) {
        this.mCampaignListener = sensorsFocusCampaignListener;
        return this;
    }

    public com.sensorsdata.sf.core.SFConfigOptions setDelayPopupActivity(java.util.Set<java.lang.Class<?>> set) {
        if (set != null) {
            if (this.mDelayActivityCode == null) {
                this.mDelayActivityCode = new java.util.HashSet();
            }
            for (java.lang.Class<?> cls : set) {
                if (cls != null) {
                    this.mDelayActivityCode.add(java.lang.Integer.valueOf(cls.getName().hashCode()));
                }
            }
        }
        return this;
    }

    public com.sensorsdata.sf.core.SFConfigOptions setPlaceholderImage(android.graphics.Bitmap bitmap) {
        this.placeholderBitmap = bitmap;
        return this;
    }

    public com.sensorsdata.sf.core.SFConfigOptions setPlaceholderResourceId(int i) {
        this.placeholderResourceId = i;
        this.placeholderBitmap = null;
        return this;
    }

    public com.sensorsdata.sf.core.SFConfigOptions setPopupListener(com.sensorsdata.sf.ui.listener.PopupListener popupListener) {
        this.mPopupListener = popupListener;
        return this;
    }

    public java.lang.String toString() {
        return "SFConfigOptions{mApiBaseUrl='" + this.mApiBaseUrl + "', mPopupListener=" + this.mPopupListener + ", mCampaignListener=" + this.mCampaignListener + ", mIsPreloadImage=" + this.mIsPreloadImage + ", mEnablePopup=" + this.mEnablePopup + ", mSplashActivity=" + this.mDelayActivityCode + '}';
    }
}
