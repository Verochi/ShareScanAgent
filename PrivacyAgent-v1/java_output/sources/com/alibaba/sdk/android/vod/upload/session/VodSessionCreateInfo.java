package com.alibaba.sdk.android.vod.upload.session;

/* loaded from: classes.dex */
public class VodSessionCreateInfo {
    private final java.lang.String accessKeyId;
    private final java.lang.String accessKeySecret;
    private final java.lang.String appId;
    private final java.lang.String expriedTime;
    private final java.lang.String imagePath;
    private final boolean isTranscode;
    private final long partSize;
    private final java.lang.String requestID;
    private final java.lang.String securityToken;
    private final java.lang.String storageLocation;
    private final com.alibaba.sdk.android.vod.upload.model.SvideoInfo svideoInfo;
    private final java.lang.String templateGroupId;
    private final java.lang.String videoPath;
    private final com.alibaba.sdk.android.vod.upload.session.VodHttpClientConfig vodHttpClientConfig;
    private final java.lang.String workFlowId;

    public static final class Builder {
        private java.lang.String _AccessKeyId;
        private java.lang.String _AccessKeySecret;
        private java.lang.String _ExpriedTime;
        private java.lang.String _ImagePath;
        private boolean _IsTranscode;
        private long _PartSize;
        private java.lang.String _RequestID;
        private java.lang.String _SecurityToken;
        private com.alibaba.sdk.android.vod.upload.model.SvideoInfo _SvideoInfo;
        private java.lang.String _TemplateGroupId;
        private java.lang.String _VideoPath;
        com.alibaba.sdk.android.vod.upload.session.VodHttpClientConfig _VodHttpClientConfig = new com.alibaba.sdk.android.vod.upload.session.VodHttpClientConfig.Builder().build();
        private java.lang.String _appId;
        private java.lang.String _storageLocation;
        private java.lang.String _workFlowId;

        public com.alibaba.sdk.android.vod.upload.session.VodSessionCreateInfo build() {
            return new com.alibaba.sdk.android.vod.upload.session.VodSessionCreateInfo(this);
        }

        public com.alibaba.sdk.android.vod.upload.session.VodSessionCreateInfo.Builder setAccessKeyId(java.lang.String str) {
            this._AccessKeyId = str;
            return this;
        }

        public com.alibaba.sdk.android.vod.upload.session.VodSessionCreateInfo.Builder setAccessKeySecret(java.lang.String str) {
            this._AccessKeySecret = str;
            return this;
        }

        public com.alibaba.sdk.android.vod.upload.session.VodSessionCreateInfo.Builder setAppId(java.lang.String str) {
            this._appId = str;
            return this;
        }

        public com.alibaba.sdk.android.vod.upload.session.VodSessionCreateInfo.Builder setExpriedTime(java.lang.String str) {
            this._ExpriedTime = str;
            return this;
        }

        public com.alibaba.sdk.android.vod.upload.session.VodSessionCreateInfo.Builder setImagePath(java.lang.String str) {
            this._ImagePath = str;
            return this;
        }

        public com.alibaba.sdk.android.vod.upload.session.VodSessionCreateInfo.Builder setIsTranscode(java.lang.Boolean bool) {
            this._IsTranscode = bool.booleanValue();
            return this;
        }

        public com.alibaba.sdk.android.vod.upload.session.VodSessionCreateInfo.Builder setPartSize(long j) {
            this._PartSize = j;
            return this;
        }

        public com.alibaba.sdk.android.vod.upload.session.VodSessionCreateInfo.Builder setRequestID(java.lang.String str) {
            this._RequestID = str;
            return this;
        }

        public com.alibaba.sdk.android.vod.upload.session.VodSessionCreateInfo.Builder setSecurityToken(java.lang.String str) {
            this._SecurityToken = str;
            return this;
        }

        public com.alibaba.sdk.android.vod.upload.session.VodSessionCreateInfo.Builder setStorageLocation(java.lang.String str) {
            this._storageLocation = str;
            return this;
        }

        public com.alibaba.sdk.android.vod.upload.session.VodSessionCreateInfo.Builder setSvideoInfo(com.alibaba.sdk.android.vod.upload.model.SvideoInfo svideoInfo) {
            this._SvideoInfo = svideoInfo;
            return this;
        }

        public com.alibaba.sdk.android.vod.upload.session.VodSessionCreateInfo.Builder setTemplateGroupId(java.lang.String str) {
            this._TemplateGroupId = str;
            return this;
        }

        public com.alibaba.sdk.android.vod.upload.session.VodSessionCreateInfo.Builder setVideoPath(java.lang.String str) {
            this._VideoPath = str;
            return this;
        }

        public com.alibaba.sdk.android.vod.upload.session.VodSessionCreateInfo.Builder setVodHttpClientConfig(com.alibaba.sdk.android.vod.upload.session.VodHttpClientConfig vodHttpClientConfig) {
            this._VodHttpClientConfig = vodHttpClientConfig;
            return this;
        }

        public com.alibaba.sdk.android.vod.upload.session.VodSessionCreateInfo.Builder setWorkFlowId(java.lang.String str) {
            this._workFlowId = str;
            return this;
        }
    }

    public VodSessionCreateInfo(com.alibaba.sdk.android.vod.upload.session.VodSessionCreateInfo.Builder builder) {
        this.videoPath = builder._VideoPath;
        this.imagePath = builder._ImagePath;
        this.accessKeyId = builder._AccessKeyId;
        this.accessKeySecret = builder._AccessKeySecret;
        this.securityToken = builder._SecurityToken;
        this.expriedTime = builder._ExpriedTime;
        this.requestID = builder._RequestID;
        this.svideoInfo = builder._SvideoInfo;
        this.isTranscode = builder._IsTranscode;
        this.partSize = builder._PartSize;
        this.vodHttpClientConfig = builder._VodHttpClientConfig;
        this.templateGroupId = builder._TemplateGroupId;
        this.storageLocation = builder._storageLocation;
        this.appId = builder._appId;
        this.workFlowId = builder._workFlowId;
    }

    public java.lang.String getAccessKeyId() {
        return this.accessKeyId;
    }

    public java.lang.String getAccessKeySecret() {
        return this.accessKeySecret;
    }

    public java.lang.String getAppId() {
        return this.appId;
    }

    public java.lang.String getExpriedTime() {
        return this.expriedTime;
    }

    public java.lang.String getImagePath() {
        return this.imagePath;
    }

    public long getPartSize() {
        return this.partSize;
    }

    public java.lang.String getRequestID() {
        return this.requestID;
    }

    public java.lang.String getSecurityToken() {
        return this.securityToken;
    }

    public java.lang.String getStorageLocation() {
        return this.storageLocation;
    }

    public com.alibaba.sdk.android.vod.upload.model.SvideoInfo getSvideoInfo() {
        return this.svideoInfo;
    }

    public java.lang.String getTemplateGroupId() {
        return this.templateGroupId;
    }

    public java.lang.String getVideoPath() {
        return this.videoPath;
    }

    public com.alibaba.sdk.android.vod.upload.session.VodHttpClientConfig getVodHttpClientConfig() {
        return this.vodHttpClientConfig;
    }

    public java.lang.String getWorkFlowId() {
        return this.workFlowId;
    }

    public boolean isTranscode() {
        return this.isTranscode;
    }
}
