package com.ss.android.downloadad.api.download;

/* loaded from: classes19.dex */
public class AdDownloadEventConfig implements com.ss.android.download.api.download.DownloadEventConfig {
    protected java.lang.String mClickButtonTag;
    protected java.lang.String mClickContinueLabel;
    protected java.lang.String mClickInstallLabel;
    protected java.lang.String mClickItemTag;
    protected java.lang.String mClickLabel;
    protected java.lang.String mClickPauseLabel;
    protected java.lang.String mClickStartLabel;
    protected int mDownloadScene;
    protected transient java.lang.Object mExtraEventObject;
    protected org.json.JSONObject mExtraJson;
    protected boolean mIsEnableClickEvent;
    protected boolean mIsEnableV3Event;
    protected org.json.JSONObject mParamsJson;
    protected java.lang.String mRefer;
    protected java.lang.String mStorageDenyLabel;

    public static final class Builder {
        com.ss.android.downloadad.api.download.AdDownloadEventConfig eventConfig = new com.ss.android.downloadad.api.download.AdDownloadEventConfig();

        public com.ss.android.downloadad.api.download.AdDownloadEventConfig build() {
            return this.eventConfig;
        }

        public com.ss.android.downloadad.api.download.AdDownloadEventConfig.Builder setClickButtonTag(java.lang.String str) {
            this.eventConfig.mClickButtonTag = str;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadEventConfig.Builder setClickContinueLabel(java.lang.String str) {
            this.eventConfig.mClickContinueLabel = str;
            return this;
        }

        @java.lang.Deprecated
        public com.ss.android.downloadad.api.download.AdDownloadEventConfig.Builder setClickContinueTag(java.lang.String str) {
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadEventConfig.Builder setClickInstallLabel(java.lang.String str) {
            this.eventConfig.mClickInstallLabel = str;
            return this;
        }

        @java.lang.Deprecated
        public com.ss.android.downloadad.api.download.AdDownloadEventConfig.Builder setClickInstallTag(java.lang.String str) {
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadEventConfig.Builder setClickItemTag(java.lang.String str) {
            this.eventConfig.mClickItemTag = str;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadEventConfig.Builder setClickLabel(java.lang.String str) {
            this.eventConfig.mClickLabel = str;
            return this;
        }

        @java.lang.Deprecated
        public com.ss.android.downloadad.api.download.AdDownloadEventConfig.Builder setClickOpenLabel(java.lang.String str) {
            return this;
        }

        @java.lang.Deprecated
        public com.ss.android.downloadad.api.download.AdDownloadEventConfig.Builder setClickOpenTag(java.lang.String str) {
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadEventConfig.Builder setClickPauseLabel(java.lang.String str) {
            this.eventConfig.mClickPauseLabel = str;
            return this;
        }

        @java.lang.Deprecated
        public com.ss.android.downloadad.api.download.AdDownloadEventConfig.Builder setClickPauseTag(java.lang.String str) {
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadEventConfig.Builder setClickStartLabel(java.lang.String str) {
            this.eventConfig.mClickStartLabel = str;
            return this;
        }

        @java.lang.Deprecated
        public com.ss.android.downloadad.api.download.AdDownloadEventConfig.Builder setClickStartTag(java.lang.String str) {
            return this;
        }

        @java.lang.Deprecated
        public com.ss.android.downloadad.api.download.AdDownloadEventConfig.Builder setClickTag(java.lang.String str) {
            return this;
        }

        @java.lang.Deprecated
        public com.ss.android.downloadad.api.download.AdDownloadEventConfig.Builder setCompletedEventTag(java.lang.String str) {
            return this;
        }

        @java.lang.Deprecated
        public com.ss.android.downloadad.api.download.AdDownloadEventConfig.Builder setDownloadFailedLabel(java.lang.String str) {
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadEventConfig.Builder setDownloadScene(int i) {
            this.eventConfig.mDownloadScene = i;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadEventConfig.Builder setExtraEventObject(java.lang.Object obj) {
            this.eventConfig.mExtraEventObject = obj;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadEventConfig.Builder setExtraJson(org.json.JSONObject jSONObject) {
            this.eventConfig.mExtraJson = jSONObject;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadEventConfig.Builder setIsEnableClickEvent(boolean z) {
            this.eventConfig.mIsEnableClickEvent = z;
            return this;
        }

        @java.lang.Deprecated
        public com.ss.android.downloadad.api.download.AdDownloadEventConfig.Builder setIsEnableCompletedEvent(boolean z) {
            return this;
        }

        @java.lang.Deprecated
        public com.ss.android.downloadad.api.download.AdDownloadEventConfig.Builder setIsEnableNoChargeClickEvent(boolean z) {
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadEventConfig.Builder setIsEnableV3Event(boolean z) {
            this.eventConfig.mIsEnableV3Event = z;
            return this;
        }

        @java.lang.Deprecated
        public com.ss.android.downloadad.api.download.AdDownloadEventConfig.Builder setOpenLabel(java.lang.String str) {
            return this;
        }

        @java.lang.Deprecated
        public com.ss.android.downloadad.api.download.AdDownloadEventConfig.Builder setOpenTag(java.lang.String str) {
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadEventConfig.Builder setParamsJson(org.json.JSONObject jSONObject) {
            this.eventConfig.mParamsJson = jSONObject;
            return this;
        }

        @java.lang.Deprecated
        public com.ss.android.downloadad.api.download.AdDownloadEventConfig.Builder setQuickAppEventTag(java.lang.String str) {
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadEventConfig.Builder setRefer(java.lang.String str) {
            this.eventConfig.mRefer = str;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadEventConfig.Builder setStorageDenyLabel(java.lang.String str) {
            this.eventConfig.mStorageDenyLabel = str;
            return this;
        }

        @java.lang.Deprecated
        public com.ss.android.downloadad.api.download.AdDownloadEventConfig.Builder setStorageDenyTag(java.lang.String str) {
            return this;
        }
    }

    public AdDownloadEventConfig() {
        this.mIsEnableClickEvent = true;
        this.mIsEnableV3Event = false;
    }

    public AdDownloadEventConfig(com.ss.android.downloadad.api.download.AdDownloadEventConfig adDownloadEventConfig) {
        this.mIsEnableClickEvent = true;
        this.mIsEnableV3Event = false;
        if (adDownloadEventConfig == null) {
            return;
        }
        this.mClickButtonTag = adDownloadEventConfig.mClickButtonTag;
        this.mClickItemTag = adDownloadEventConfig.mClickItemTag;
        this.mClickLabel = adDownloadEventConfig.mClickLabel;
        this.mClickStartLabel = adDownloadEventConfig.mClickStartLabel;
        this.mClickPauseLabel = adDownloadEventConfig.mClickPauseLabel;
        this.mClickContinueLabel = adDownloadEventConfig.mClickContinueLabel;
        this.mClickInstallLabel = adDownloadEventConfig.mClickInstallLabel;
        this.mStorageDenyLabel = adDownloadEventConfig.mStorageDenyLabel;
        this.mDownloadScene = adDownloadEventConfig.mDownloadScene;
        this.mIsEnableClickEvent = adDownloadEventConfig.mIsEnableClickEvent;
        this.mIsEnableV3Event = adDownloadEventConfig.mIsEnableV3Event;
        this.mRefer = adDownloadEventConfig.mRefer;
        this.mExtraJson = adDownloadEventConfig.mExtraJson;
        this.mParamsJson = adDownloadEventConfig.mParamsJson;
    }

    public static com.ss.android.downloadad.api.download.AdDownloadEventConfig fromJson(org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.ss.android.downloadad.api.download.AdDownloadEventConfig.Builder builder = new com.ss.android.downloadad.api.download.AdDownloadEventConfig.Builder();
        try {
            builder.setClickButtonTag(jSONObject.optString("click_button_tag"));
            builder.setClickItemTag(jSONObject.optString("click_item_tag"));
            builder.setClickLabel(jSONObject.optString("click_label"));
            builder.setClickStartLabel(jSONObject.optString("click_start_label"));
            builder.setClickContinueLabel(jSONObject.optString("click_continue_label"));
            builder.setClickPauseLabel(jSONObject.optString("click_pause_label"));
            builder.setClickInstallLabel(jSONObject.optString("click_install_label"));
            builder.setStorageDenyLabel(jSONObject.optString("storage_deny_label"));
            builder.setRefer(jSONObject.optString(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_REFER));
            builder.setDownloadScene(jSONObject.optInt("download_scene"));
            builder.setIsEnableClickEvent(jSONObject.optInt("enable_click_event") == 1);
            builder.setIsEnableV3Event(jSONObject.optInt("enable_v3_event") == 1);
            builder.setExtraJson(jSONObject.optJSONObject("extra"));
            builder.setParamsJson(jSONObject.optJSONObject("params_json"));
        } catch (java.lang.Exception e) {
            com.ss.android.downloadlib.addownload.z.q().vw(e, "AdDownloadEventConfig fromJson");
        }
        return builder.build();
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public java.lang.String getClickButtonTag() {
        return this.mClickButtonTag;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public java.lang.String getClickContinueLabel() {
        return this.mClickContinueLabel;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public java.lang.String getClickInstallLabel() {
        return this.mClickInstallLabel;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public java.lang.String getClickItemTag() {
        return this.mClickItemTag;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public java.lang.String getClickLabel() {
        return this.mClickLabel;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public java.lang.String getClickPauseLabel() {
        return this.mClickPauseLabel;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public java.lang.String getClickStartLabel() {
        return this.mClickStartLabel;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public int getDownloadScene() {
        return this.mDownloadScene;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public java.lang.Object getExtraEventObject() {
        return this.mExtraEventObject;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public org.json.JSONObject getExtraJson() {
        return this.mExtraJson;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public org.json.JSONObject getParamsJson() {
        return this.mParamsJson;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public java.lang.String getRefer() {
        return this.mRefer;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public java.lang.String getStorageDenyLabel() {
        return this.mStorageDenyLabel;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableClickEvent() {
        return this.mIsEnableClickEvent;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableV3Event() {
        return this.mIsEnableV3Event;
    }

    public void setClickButtonTag(java.lang.String str) {
        this.mClickButtonTag = str;
    }

    public void setClickItemTag(java.lang.String str) {
        this.mClickItemTag = str;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setDownloadScene(int i) {
        this.mDownloadScene = i;
    }

    public void setExtraEventObject(java.lang.Object obj) {
        this.mExtraEventObject = obj;
    }

    public void setExtraJson(org.json.JSONObject jSONObject) {
        this.mExtraJson = jSONObject;
    }

    public void setParamsJson(org.json.JSONObject jSONObject) {
        this.mParamsJson = jSONObject;
    }

    @java.lang.Deprecated
    public void setQuickAppEventTag(java.lang.String str) {
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setRefer(java.lang.String str) {
        this.mRefer = str;
    }

    public org.json.JSONObject toJson() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.putOpt("click_button_tag", this.mClickButtonTag);
            jSONObject.putOpt("click_item_tag", this.mClickItemTag);
            jSONObject.putOpt("click_label", this.mClickLabel);
            jSONObject.putOpt("click_start_label", this.mClickStartLabel);
            jSONObject.putOpt("click_continue_label", this.mClickContinueLabel);
            jSONObject.putOpt("click_pause_label", this.mClickPauseLabel);
            jSONObject.putOpt("click_install_label", this.mClickInstallLabel);
            jSONObject.putOpt("storage_deny_label", this.mStorageDenyLabel);
            jSONObject.putOpt(com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_REFER, this.mRefer);
            jSONObject.putOpt("download_scene", java.lang.Integer.valueOf(this.mDownloadScene));
            int i = 1;
            jSONObject.putOpt("enable_click_event", java.lang.Integer.valueOf(this.mIsEnableClickEvent ? 1 : 0));
            if (!this.mIsEnableV3Event) {
                i = 0;
            }
            jSONObject.putOpt("enable_v3_event", java.lang.Integer.valueOf(i));
            jSONObject.putOpt("extra", this.mExtraJson);
            jSONObject.putOpt("params_json", this.mParamsJson);
        } catch (java.lang.Exception e) {
            com.ss.android.downloadlib.addownload.z.q().vw(e, "AdDownloadEventConfig toJson");
        }
        return jSONObject;
    }
}
