package com.ss.android.downloadad.api.download;

/* loaded from: classes19.dex */
public class AdDownloadController implements com.ss.android.download.api.download.DownloadController {
    protected int mDownloadMode;
    protected java.lang.Object mExtraClickOperation;
    protected org.json.JSONObject mExtraJson;
    protected java.lang.Object mExtraObject;
    protected int mInterceptFlag;
    protected boolean mIsAddToDownloadManage;
    protected boolean mIsAutoDownloadOnCardShow;
    protected boolean mIsEnableBackDialog;
    protected int mLinkMode;
    protected boolean mShouldUseNewWebView;
    protected boolean mEnableShowComplianceDialog = true;
    protected boolean mEnableNewActivity = true;
    protected boolean mEnableAH = true;
    protected boolean mEnableAM = true;
    protected boolean mEnableOppoAutoDownload = true;

    public static final class Builder {
        com.ss.android.downloadad.api.download.AdDownloadController controller = new com.ss.android.downloadad.api.download.AdDownloadController();

        public com.ss.android.downloadad.api.download.AdDownloadController build() {
            return this.controller;
        }

        @java.lang.Deprecated
        public com.ss.android.downloadad.api.download.AdDownloadController.Builder setDowloadChunkCount(int i) {
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadController.Builder setDownloadMode(int i) {
            this.controller.mDownloadMode = i;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadController.Builder setEnableAH(boolean z) {
            this.controller.mEnableAH = z;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadController.Builder setEnableAM(boolean z) {
            this.controller.mEnableAM = z;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadController.Builder setEnableNewActivity(boolean z) {
            this.controller.mEnableNewActivity = z;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadController.Builder setEnableOppoAutoDownload(boolean z) {
            this.controller.mEnableOppoAutoDownload = z;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadController.Builder setEnableShowComplianceDialog(boolean z) {
            this.controller.mEnableShowComplianceDialog = z;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadController.Builder setExtraJson(org.json.JSONObject jSONObject) {
            this.controller.mExtraJson = jSONObject;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadController.Builder setExtraObject(java.lang.Object obj) {
            this.controller.mExtraObject = obj;
            return this;
        }

        @java.lang.Deprecated
        public com.ss.android.downloadad.api.download.AdDownloadController.Builder setExtraOperation(java.lang.Object obj) {
            this.controller.mExtraClickOperation = obj;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadController.Builder setInterceptFlag(int i) {
            this.controller.mInterceptFlag = i;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadController.Builder setIsAddToDownloadManage(boolean z) {
            this.controller.mIsAddToDownloadManage = z;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadController.Builder setIsAutoDownloadOnCardShow(boolean z) {
            this.controller.mIsAutoDownloadOnCardShow = z;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadController.Builder setIsEnableBackDialog(boolean z) {
            this.controller.mIsEnableBackDialog = z;
            return this;
        }

        @java.lang.Deprecated
        public com.ss.android.downloadad.api.download.AdDownloadController.Builder setIsEnableMultipleDownload(boolean z) {
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadController.Builder setLinkMode(int i) {
            this.controller.mLinkMode = i;
            return this;
        }

        public com.ss.android.downloadad.api.download.AdDownloadController.Builder setShouldUseNewWebView(boolean z) {
            this.controller.mShouldUseNewWebView = z;
            return this;
        }
    }

    public static com.ss.android.downloadad.api.download.AdDownloadController fromJson(org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        com.ss.android.downloadad.api.download.AdDownloadController.Builder builder = new com.ss.android.downloadad.api.download.AdDownloadController.Builder();
        try {
            builder.setLinkMode(jSONObject.optInt(com.ss.android.socialbase.downloader.constants.DbJsonConstants.DBJSON_KEY_LINK_MODE));
            builder.setDownloadMode(jSONObject.optInt("download_mode"));
            builder.setIsEnableBackDialog(jSONObject.optInt("enable_back_dialog") == 1);
            builder.setIsAddToDownloadManage(jSONObject.optInt("add_to_manage") == 1);
            builder.setShouldUseNewWebView(jSONObject.optInt("use_new_webview") == 1);
            builder.setInterceptFlag(jSONObject.optInt("intercept_flag"));
            builder.setEnableShowComplianceDialog(jSONObject.optInt("enable_show_compliance_dialog", 1) == 1);
            builder.setIsAutoDownloadOnCardShow(jSONObject.optInt("is_auto_download_on_card_show") == 1);
            builder.setEnableNewActivity(jSONObject.optInt("enable_new_activity", 1) == 1);
            builder.setEnableAH(jSONObject.optInt("enable_ah", 1) == 1);
            builder.setEnableAM(jSONObject.optInt("enable_am", 1) == 1);
            builder.setExtraJson(jSONObject.optJSONObject("extra"));
            builder.setEnableOppoAutoDownload(jSONObject.optInt("enable_oppo_auto_download", 1) == 1);
        } catch (java.lang.Exception e) {
            com.ss.android.downloadlib.addownload.z.q().vw(e, "AdDownloadController fromJson");
        }
        return builder.build();
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean enableAH() {
        return this.mEnableAH;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean enableAM() {
        return this.mEnableAM;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean enableNewActivity() {
        return this.mEnableNewActivity;
    }

    public boolean enableOppoAutoDownload() {
        return this.mEnableOppoAutoDownload;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean enableShowComplianceDialog() {
        return this.mEnableShowComplianceDialog;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public int getDowloadChunkCount() {
        return 1;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public int getDownloadMode() {
        return this.mDownloadMode;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public java.lang.Object getExtraClickOperation() {
        return this.mExtraClickOperation;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public org.json.JSONObject getExtraJson() {
        return this.mExtraJson;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public java.lang.Object getExtraObject() {
        return this.mExtraObject;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public int getInterceptFlag() {
        return this.mInterceptFlag;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public int getLinkMode() {
        return this.mLinkMode;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean isAddToDownloadManage() {
        return this.mIsAddToDownloadManage;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean isAutoDownloadOnCardShow() {
        return this.mIsAutoDownloadOnCardShow;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean isEnableBackDialog() {
        return this.mIsEnableBackDialog;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean isEnableMultipleDownload() {
        return false;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public void setDownloadMode(int i) {
        this.mDownloadMode = i;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public void setEnableNewActivity(boolean z) {
        this.mEnableNewActivity = z;
    }

    public void setEnableOppoAutoDownload(boolean z) {
        this.mEnableOppoAutoDownload = z;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public void setEnableShowComplianceDialog(boolean z) {
        this.mEnableShowComplianceDialog = z;
    }

    public void setExtraJson(org.json.JSONObject jSONObject) {
        this.mExtraJson = jSONObject;
    }

    public void setExtraObject(java.lang.Object obj) {
        this.mExtraObject = obj;
    }

    public void setIsAutoDownloadOnCardShow(boolean z) {
        this.mIsAutoDownloadOnCardShow = z;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public void setLinkMode(int i) {
        this.mLinkMode = i;
    }

    @Override // com.ss.android.download.api.download.DownloadController
    public boolean shouldUseNewWebView() {
        return this.mShouldUseNewWebView;
    }

    public org.json.JSONObject toJson() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.putOpt(com.ss.android.socialbase.downloader.constants.DbJsonConstants.DBJSON_KEY_LINK_MODE, java.lang.Integer.valueOf(this.mLinkMode));
            jSONObject.putOpt("download_mode", java.lang.Integer.valueOf(this.mDownloadMode));
            int i = 1;
            jSONObject.putOpt("enable_back_dialog", java.lang.Integer.valueOf(this.mIsEnableBackDialog ? 1 : 0));
            jSONObject.putOpt("add_to_manage", java.lang.Integer.valueOf(this.mIsAddToDownloadManage ? 1 : 0));
            jSONObject.putOpt("use_new_webview", java.lang.Integer.valueOf(this.mShouldUseNewWebView ? 1 : 0));
            jSONObject.putOpt("intercept_flag", java.lang.Integer.valueOf(this.mInterceptFlag));
            jSONObject.putOpt("enable_show_compliance_dialog", java.lang.Integer.valueOf(this.mEnableShowComplianceDialog ? 1 : 0));
            jSONObject.putOpt("is_auto_download_on_card_show", java.lang.Integer.valueOf(this.mIsAutoDownloadOnCardShow ? 1 : 0));
            jSONObject.putOpt("extra", this.mExtraJson);
            jSONObject.putOpt("enable_new_activity", java.lang.Integer.valueOf(this.mEnableNewActivity ? 1 : 0));
            jSONObject.putOpt("enable_ah", java.lang.Integer.valueOf(this.mEnableAH ? 1 : 0));
            jSONObject.putOpt("enable_am", java.lang.Integer.valueOf(this.mEnableAM ? 1 : 0));
            if (!this.mEnableOppoAutoDownload) {
                i = 0;
            }
            jSONObject.putOpt("enable_oppo_auto_download", java.lang.Integer.valueOf(i));
        } catch (java.lang.Exception e) {
            com.ss.android.downloadlib.addownload.z.q().vw(e, "AdDownloadController toJson");
        }
        return jSONObject;
    }
}
