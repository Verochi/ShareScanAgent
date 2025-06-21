package com.alibaba.sdk.android.vod.upload;

/* loaded from: classes.dex */
public class VODSVideoUploadClientImpl implements com.alibaba.sdk.android.vod.upload.VODSVideoUploadClient {
    private static final java.lang.String TAG = "VOD_UPLOAD";
    private static final int VOD_GENERATE_IMAGE = 1;
    private static final int VOD_GENERATE_VIDEO = 1;
    private com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth aliyunVodAuth;
    private com.alibaba.sdk.android.oss.ClientConfiguration configuration;
    private java.lang.ref.WeakReference<android.content.Context> context;
    private java.lang.String domainRegion;
    private java.util.List<com.alibaba.sdk.android.vod.upload.model.UploadFileInfo> fileList;
    private long imageSize;
    private com.aliyun.vod.jasonparse.JSONSupport jsonSupport;
    private com.alibaba.sdk.android.vod.upload.model.OSSConfig ossConfig;
    private boolean reportEnabled = true;
    private com.alibaba.sdk.android.vod.upload.common.RequestIDSession requestIDSession;
    private com.alibaba.sdk.android.vod.upload.internal.ResumeableSession resumeableSession;
    private com.alibaba.sdk.android.vod.upload.model.SVideoConfig sVideoConfig;
    private com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStatus status;
    private com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStep step;
    private java.lang.String uploadAddress;
    private java.lang.String uploadAuth;
    private com.alibaba.sdk.android.vod.upload.internal.OSSUploader uploader;
    private long videoSize;
    private com.alibaba.sdk.android.vod.upload.VODSVideoUploadCallback videoUploadCallback;

    public class AliyunAuthCallback implements com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.VodAuthCallBack {
        public AliyunAuthCallback() {
        }

        @Override // com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.VodAuthCallBack
        public void onCreateUploadImaged(com.aliyun.auth.model.CreateImageForm createImageForm) {
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug(com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.TAG, "[VODSVideoUploader]: stepVODSVideoStepCreateImageFinish");
            com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.step = com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStep.VODSVideoStepCreateImageFinish;
            com.alibaba.sdk.android.vod.upload.model.SVideoConfig sVideoConfig = com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.sVideoConfig;
            com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl vODSVideoUploadClientImpl = com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this;
            sVideoConfig.setVodInfo(vODSVideoUploadClientImpl.generateVodInfo(1, vODSVideoUploadClientImpl.sVideoConfig, createImageForm.getImageURL()));
            com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.uploadAuth = createImageForm.getUploadAuth();
            com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.uploadAddress = createImageForm.getUploadAddress();
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(new java.lang.String(android.util.Base64.decode(com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.uploadAuth, 0)));
                java.lang.String optString = jSONObject.optString("Region");
                java.lang.String optString2 = jSONObject.optString("ExpireUTCTime");
                com.alibaba.sdk.android.oss.common.OSSLog.logDebug(com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.TAG, "region : " + optString + ", expUTC : " + optString2);
                if (!android.text.TextUtils.isEmpty(optString2)) {
                    com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.sVideoConfig.setExpriedTime(optString2);
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
            com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl vODSVideoUploadClientImpl2 = com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this;
            vODSVideoUploadClientImpl2.startUpload(vODSVideoUploadClientImpl2.uploadAuth, com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.uploadAddress, com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.sVideoConfig);
        }

        @Override // com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.VodAuthCallBack
        public void onCreateUploadVideoed(com.aliyun.auth.model.CreateVideoForm createVideoForm, java.lang.String str) {
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug(com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.TAG, "VODSVideoStepCreateVideoFinish");
            com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.step = com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStep.VODSVideoStepCreateVideoFinish;
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug(com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.TAG, "[VODSVideoUploader]: step" + com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.step);
            com.alibaba.sdk.android.vod.upload.model.SVideoConfig sVideoConfig = com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.sVideoConfig;
            com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl vODSVideoUploadClientImpl = com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this;
            sVideoConfig.setVodInfo(vODSVideoUploadClientImpl.generateVodInfo(1, vODSVideoUploadClientImpl.sVideoConfig, str));
            com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.sVideoConfig.setVideoId(createVideoForm.getVideoId());
            com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.uploadAuth = createVideoForm.getUploadAuth();
            com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.uploadAddress = createVideoForm.getUploadAddress();
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(new java.lang.String(android.util.Base64.decode(com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.uploadAuth, 0)));
                java.lang.String optString = jSONObject.optString("Region");
                java.lang.String optString2 = jSONObject.optString("ExpireUTCTime");
                com.alibaba.sdk.android.oss.common.OSSLog.logDebug(com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.TAG, "region : " + optString + ", expUTC : " + optString2);
                if (!android.text.TextUtils.isEmpty(optString)) {
                    if (com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.aliyunVodAuth == null && com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.aliyunVodAuth == null) {
                        com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl vODSVideoUploadClientImpl2 = com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this;
                        vODSVideoUploadClientImpl2.aliyunVodAuth = new com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth(vODSVideoUploadClientImpl2.new AliyunAuthCallback());
                    }
                    com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.aliyunVodAuth.setDomainRegion(com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.domainRegion);
                    com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.domainRegion = optString;
                }
                if (!android.text.TextUtils.isEmpty(optString2)) {
                    com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.sVideoConfig.setExpriedTime(optString2);
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
            com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl vODSVideoUploadClientImpl3 = com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this;
            vODSVideoUploadClientImpl3.startUpload(vODSVideoUploadClientImpl3.uploadAuth, com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.uploadAddress, com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.sVideoConfig);
        }

        @Override // com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.VodAuthCallBack
        public void onError(java.lang.String str, java.lang.String str2) {
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug(com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.TAG, "[VODSVideoUploader]: onCreateAuthErrorcode" + str + "message" + str2);
            if (com.aliyun.auth.core.AliyunVodErrorCode.VODERRORCODE_INVALIDVIDEO.equals(str) && com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.resumeableSession != null) {
                com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.resumeableSession.deleteResumeableFileInfo(com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.step == com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStep.VODSVideoStepCreateImage ? com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.sVideoConfig.getImagePath() : com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.step == com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStep.VODSVideoStepCreateVideo ? com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.sVideoConfig.getVideoPath() : null);
                if (com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.step == com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStep.VODSVideoStepCreateVideo) {
                    com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.refreshSTStoken();
                    return;
                }
            }
            if (com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.videoUploadCallback != null) {
                com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.videoUploadCallback.onUploadFailed(str, str2);
            }
        }

        @Override // com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.VodAuthCallBack
        public void onSTSExpired(com.aliyun.auth.common.AliyunVodUploadType aliyunVodUploadType) {
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug(com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.TAG, "[VODSVideoUploader]: statusonSTSExpired");
            if (com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.videoUploadCallback != null) {
                com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.videoUploadCallback.onSTSTokenExpried();
            }
        }
    }

    public enum AliyunVodUploadStatus {
        VODSVideoStatusIdle,
        VODSVideoStatusResume,
        VODSVideoStatusPause,
        VODSVideoStatusCancel,
        VODSVideoStatusRelease
    }

    public enum AliyunVodUploadStep {
        VODSVideoStepIdle,
        VODSVideoStepCreateImage,
        VODSVideoStepCreateImageFinish,
        VODSVideoStepUploadImage,
        VODSVideoStepUploadImageFinish,
        VODSVideoStepCreateVideo,
        VODSVideoStepCreateVideoFinish,
        VODSVideoStepUploadVideo,
        VODSVideoStepFinish
    }

    public class OSSUploadCallback implements com.alibaba.sdk.android.vod.upload.internal.OSSUploadListener {
        public OSSUploadCallback() {
        }

        @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploadListener
        public void onUploadFailed(java.lang.String str, java.lang.String str2) {
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug(com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.TAG, "[OSSUploader]:code:" + str + "message" + str2);
            if (com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.videoUploadCallback != null) {
                com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.videoUploadCallback.onUploadFailed(str, str2);
                com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.cancel();
            }
        }

        @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploadListener
        public void onUploadProgress(java.lang.Object obj, long j, long j2) {
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug(com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.TAG, "[OSSUploader]:uploadedSize" + j + "totalSize" + j2);
            if (com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.videoUploadCallback != null) {
                if (com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.step == com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStep.VODSVideoStepUploadImage) {
                    com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.videoUploadCallback.onUploadProgress(j, j2 + com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.videoSize);
                } else if (com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.step == com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStep.VODSVideoStepUploadVideo) {
                    com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.videoUploadCallback.onUploadProgress(j + com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.imageSize, j2 + com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.imageSize);
                }
            }
        }

        @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploadListener
        public void onUploadRetry(java.lang.String str, java.lang.String str2) {
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug(com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.TAG, "[OSSUploader]:onUploadRetry");
            if (com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.videoUploadCallback != null) {
                com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.videoUploadCallback.onUploadRetry(str, str2);
            }
        }

        @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploadListener
        public void onUploadRetryResume() {
            if (com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.videoUploadCallback != null) {
                com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.videoUploadCallback.onUploadRetryResume();
            }
        }

        @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploadListener
        public void onUploadSucceed() {
            if (com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.step == com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStep.VODSVideoStepUploadVideo) {
                com.alibaba.sdk.android.oss.common.OSSLog.logDebug(com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.TAG, "[VODSVideoUploader]: stepVODSVideoStepUploadVideoFinish");
                if (com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.resumeableSession != null && com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.sVideoConfig != null) {
                    com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.resumeableSession.deleteResumeableFileInfo(com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.sVideoConfig.getVideoPath());
                }
                if (com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.videoUploadCallback != null && com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.sVideoConfig != null && com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.sVideoConfig.getVodInfo() != null) {
                    com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.videoUploadCallback.onUploadSucceed(com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.sVideoConfig.getVideoId(), com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.sVideoConfig.getVodInfo().getCoverUrl());
                }
                com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.step = com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStep.VODSVideoStepFinish;
                return;
            }
            if (com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.step == com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStep.VODSVideoStepUploadImage) {
                com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.step = com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStep.VODSVideoStepUploadImageFinish;
                if (com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.resumeableSession != null && com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.sVideoConfig != null) {
                    com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.resumeableSession.deleteResumeableFileInfo(com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.sVideoConfig.getImagePath());
                }
                com.alibaba.sdk.android.oss.common.OSSLog.logDebug(com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.TAG, "[VODSVideoUploader]: stepVODSVideoStepUploadImageFinish");
                java.lang.String resumeableFileVideoID = com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.resumeableSession.getResumeableFileVideoID(com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.sVideoConfig.getVideoPath());
                if (android.text.TextUtils.isEmpty(resumeableFileVideoID)) {
                    com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.aliyunVodAuth.createUploadVideo(com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.sVideoConfig.getAccessKeyId(), com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.sVideoConfig.getAccessKeySecret(), com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.sVideoConfig.getSecrityToken(), com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.sVideoConfig.getVodInfo(), com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.sVideoConfig.isTranscode(), com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.sVideoConfig.getTemplateGroupId(), com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.sVideoConfig.getStorageLocation(), com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.sVideoConfig.getWorkFlowId(), com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.sVideoConfig.getAppId(), com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.sVideoConfig.getRequestId() == null ? com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.requestIDSession.getRequestID() : com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.sVideoConfig.getRequestId());
                } else {
                    com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.aliyunVodAuth.refreshUploadVideo(com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.sVideoConfig.getAccessKeyId(), com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.sVideoConfig.getAccessKeySecret(), com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.sVideoConfig.getSecrityToken(), resumeableFileVideoID, com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.sVideoConfig.getVodInfo().getCoverUrl(), com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.requestIDSession.getRequestID());
                }
                com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.step = com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStep.VODSVideoStepCreateVideo;
            }
        }

        @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploadListener
        public void onUploadTokenExpired() {
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug(com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.TAG, "[OSSUploader]:onUploadTokenExpired");
            if (com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.videoUploadCallback != null) {
                com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.this.videoUploadCallback.onSTSTokenExpried();
            }
        }
    }

    public VODSVideoUploadClientImpl(android.content.Context context) {
        this.context = new java.lang.ref.WeakReference<>(context);
        com.aliyun.vod.common.httpfinal.QupaiHttpFinal.getInstance().initOkHttpFinal();
        this.fileList = java.util.Collections.synchronizedList(new java.util.ArrayList());
        this.ossConfig = new com.alibaba.sdk.android.vod.upload.model.OSSConfig();
        this.resumeableSession = new com.alibaba.sdk.android.vod.upload.internal.ResumeableSession(context.getApplicationContext());
        this.requestIDSession = new com.alibaba.sdk.android.vod.upload.common.RequestIDSession();
        this.sVideoConfig = new com.alibaba.sdk.android.vod.upload.model.SVideoConfig();
        com.aliyun.vod.log.core.AliyunLoggerManager.createLogger(context.getApplicationContext(), com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.class.getName());
    }

    private void addFile(com.alibaba.sdk.android.vod.upload.model.VodInfo vodInfo) {
        com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo = new com.alibaba.sdk.android.vod.upload.model.UploadFileInfo();
        uploadFileInfo.setFilePath(this.sVideoConfig.getImagePath());
        uploadFileInfo.setFileType(0);
        uploadFileInfo.setVodInfo(vodInfo);
        com.alibaba.sdk.android.vod.upload.common.UploadStateType uploadStateType = com.alibaba.sdk.android.vod.upload.common.UploadStateType.INIT;
        uploadFileInfo.setStatus(uploadStateType);
        this.fileList.add(uploadFileInfo);
        com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo2 = new com.alibaba.sdk.android.vod.upload.model.UploadFileInfo();
        uploadFileInfo2.setFilePath(this.sVideoConfig.getVideoPath());
        uploadFileInfo.setFileType(1);
        uploadFileInfo2.setVodInfo(vodInfo);
        uploadFileInfo2.setStatus(uploadStateType);
        this.fileList.add(uploadFileInfo2);
    }

    private void createUploadImage() {
        com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth aliyunVodAuth;
        if (this.sVideoConfig.getAccessKeyId() == null || this.sVideoConfig.getAccessKeySecret() == null || this.sVideoConfig.getSecrityToken() == null || (aliyunVodAuth = this.aliyunVodAuth) == null) {
            return;
        }
        this.step = com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStep.VODSVideoStepCreateImage;
        aliyunVodAuth.createUploadImage(this.sVideoConfig.getAccessKeyId(), this.sVideoConfig.getAccessKeySecret(), this.sVideoConfig.getSecrityToken(), this.sVideoConfig.getVodInfo(), this.sVideoConfig.getStorageLocation(), this.sVideoConfig.getAppId(), this.sVideoConfig.getRequestId() == null ? this.requestIDSession.getRequestID() : this.sVideoConfig.getRequestId(), true);
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug(TAG, "VODSVideoStepCreateImage");
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug(TAG, "[VODSVideoUploader] - status:  VODSVideoStepCreateImage");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.alibaba.sdk.android.vod.upload.model.VodInfo generateVodInfo(int i, com.alibaba.sdk.android.vod.upload.model.SVideoConfig sVideoConfig, java.lang.String str) {
        com.alibaba.sdk.android.vod.upload.model.VodInfo vodInfo = new com.alibaba.sdk.android.vod.upload.model.VodInfo();
        vodInfo.setTitle(sVideoConfig.getVodInfo().getTitle());
        vodInfo.setDesc(sVideoConfig.getVodInfo().getDesc());
        if (i == 1) {
            vodInfo.setFileName(new java.io.File(sVideoConfig.getVideoPath()).getName());
            try {
                com.alibaba.sdk.android.vod.upload.model.UserData videoBitrate = com.alibaba.sdk.android.vod.upload.common.utils.VideoInfoUtil.getVideoBitrate(this.context.get(), sVideoConfig.getVideoPath());
                java.lang.String userData = sVideoConfig.getUserData();
                java.lang.String writeValue = this.jsonSupport.writeValue(videoBitrate);
                com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[VODSVideoUploadClientImpl] - userdata-custom : " + userData);
                com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[VODSVideoUploadClientImpl] - userdata-video : " + writeValue);
                if (!android.text.TextUtils.isEmpty(writeValue)) {
                    vodInfo.setUserData(writeValue);
                }
                if (!android.text.TextUtils.isEmpty(userData)) {
                    vodInfo.setUserData(userData);
                }
                if (!android.text.TextUtils.isEmpty(writeValue) && !android.text.TextUtils.isEmpty(userData)) {
                    org.json.JSONObject jSONObject = new org.json.JSONObject(writeValue);
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject(userData);
                    org.json.JSONObject jSONObject3 = new org.json.JSONObject();
                    try {
                        java.util.Iterator<java.lang.String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            java.lang.String next = keys.next();
                            jSONObject3.put(next, jSONObject.get(next));
                        }
                    } catch (org.json.JSONException e) {
                        e.printStackTrace();
                    }
                    try {
                        java.util.Iterator<java.lang.String> keys2 = jSONObject2.keys();
                        while (keys2.hasNext()) {
                            java.lang.String next2 = keys2.next();
                            jSONObject3.put(next2, jSONObject2.get(next2));
                        }
                    } catch (org.json.JSONException e2) {
                        e2.printStackTrace();
                    }
                    com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[VODSVideoUploadClientImpl] - userdata : " + jSONObject3.toString());
                    vodInfo.setUserData(jSONObject3.toString());
                }
            } catch (java.lang.Exception e3) {
                e3.printStackTrace();
                vodInfo.setUserData(null);
            }
            vodInfo.setFileSize(java.lang.String.valueOf(new java.io.File(sVideoConfig.getVideoPath()).length()));
            vodInfo.setIsProcess(sVideoConfig.getVodInfo().getIsProcess());
            vodInfo.setPriority(sVideoConfig.getVodInfo().getPriority());
            vodInfo.setIsShowWaterMark(sVideoConfig.getVodInfo().getIsShowWaterMark());
        } else {
            vodInfo.setFileName(new java.io.File(sVideoConfig.getImagePath()).getName());
        }
        vodInfo.setCateId(sVideoConfig.getVodInfo().getCateId());
        if (str != null) {
            vodInfo.setCoverUrl(str);
        }
        vodInfo.setTags(sVideoConfig.getVodInfo().getTags());
        return vodInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshSTStoken() {
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug(TAG, "[VODSVideoUploader]:  RefreshSTStoken");
        com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStatus aliyunVodUploadStatus = this.status;
        if (aliyunVodUploadStatus == com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStatus.VODSVideoStatusPause || aliyunVodUploadStatus == com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStatus.VODSVideoStatusCancel) {
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug(TAG, "[VODSVideoUploader] - status: " + this.status + " cann't be refreshSTStoken!");
            return;
        }
        com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStep aliyunVodUploadStep = this.step;
        if (aliyunVodUploadStep == com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStep.VODSVideoStepUploadVideo || aliyunVodUploadStep == com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStep.VODSVideoStepUploadImage) {
            com.alibaba.sdk.android.vod.upload.internal.OSSUploader oSSUploader = this.uploader;
            if (oSSUploader != null) {
                oSSUploader.resume();
                return;
            }
            return;
        }
        if (aliyunVodUploadStep == com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStep.VODSVideoStepCreateImage) {
            this.aliyunVodAuth.createUploadImage(this.sVideoConfig.getAccessKeyId(), this.sVideoConfig.getAccessKeySecret(), this.sVideoConfig.getSecrityToken(), this.sVideoConfig.getVodInfo(), this.sVideoConfig.getStorageLocation(), this.sVideoConfig.getAppId(), this.sVideoConfig.getRequestId() == null ? this.requestIDSession.getRequestID() : this.sVideoConfig.getRequestId(), true);
            return;
        }
        if (aliyunVodUploadStep == com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStep.VODSVideoStepCreateVideoFinish) {
            this.aliyunVodAuth.refreshUploadVideo(this.sVideoConfig.getAccessKeyId(), this.sVideoConfig.getAccessKeySecret(), this.sVideoConfig.getSecrityToken(), this.sVideoConfig.getVideoId(), this.sVideoConfig.getVodInfo().getCoverUrl(), this.sVideoConfig.getRequestId() == null ? this.requestIDSession.getRequestID() : this.sVideoConfig.getRequestId());
            return;
        }
        if (aliyunVodUploadStep == com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStep.VODSVideoStepCreateVideo) {
            java.lang.String resumeableFileVideoID = this.resumeableSession.getResumeableFileVideoID(this.sVideoConfig.getVideoPath());
            if (android.text.TextUtils.isEmpty(resumeableFileVideoID)) {
                this.aliyunVodAuth.createUploadVideo(this.sVideoConfig.getAccessKeyId(), this.sVideoConfig.getAccessKeySecret(), this.sVideoConfig.getSecrityToken(), this.sVideoConfig.getVodInfo(), this.sVideoConfig.isTranscode(), this.sVideoConfig.getTemplateGroupId(), this.sVideoConfig.getStorageLocation(), this.sVideoConfig.getWorkFlowId(), this.sVideoConfig.getAppId(), this.sVideoConfig.getRequestId() == null ? this.requestIDSession.getRequestID() : this.sVideoConfig.getRequestId());
            } else {
                this.aliyunVodAuth.refreshUploadVideo(this.sVideoConfig.getAccessKeyId(), this.sVideoConfig.getAccessKeySecret(), this.sVideoConfig.getSecrityToken(), resumeableFileVideoID, this.sVideoConfig.getVodInfo().getCoverUrl(), this.requestIDSession.getRequestID());
            }
        }
    }

    private void startUpload(com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo) {
        if (new java.io.File(uploadFileInfo.getFilePath()).length() < com.alibaba.sdk.android.oss.common.OSSConstants.MIN_PART_SIZE_LIMIT) {
            this.uploader = null;
            com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl oSSPutUploaderImpl = new com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl(this.context.get());
            this.uploader = oSSPutUploaderImpl;
            oSSPutUploaderImpl.init(this.ossConfig, new com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.OSSUploadCallback());
            this.uploader.setOSSClientConfiguration(this.configuration);
            try {
                this.uploader.start(uploadFileInfo);
                return;
            } catch (java.io.FileNotFoundException e) {
                e.printStackTrace();
                this.videoUploadCallback.onUploadFailed(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.FILE_NOT_EXIST, "The file \"" + uploadFileInfo.getFilePath() + "\" is not exist!");
                return;
            }
        }
        this.uploader = null;
        com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl resumableUploaderImpl = new com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl(this.context.get());
        this.uploader = resumableUploaderImpl;
        resumableUploaderImpl.setDomainRegion(this.domainRegion);
        this.uploader.init(this.ossConfig, new com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.OSSUploadCallback());
        this.uploader.setOSSClientConfiguration(this.configuration);
        try {
            this.uploader.start(uploadFileInfo);
        } catch (java.io.FileNotFoundException e2) {
            e2.printStackTrace();
            this.videoUploadCallback.onUploadFailed(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.FILE_NOT_EXIST, "The file \"" + uploadFileInfo.getFilePath() + "\" is not exist!");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startUpload(java.lang.String str, java.lang.String str2, com.alibaba.sdk.android.vod.upload.model.SVideoConfig sVideoConfig) {
        try {
            com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStep aliyunVodUploadStep = this.step;
            if (aliyunVodUploadStep == com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStep.VODSVideoStepCreateImageFinish) {
                com.alibaba.sdk.android.oss.common.OSSLog.logDebug(TAG, "[VODSVIDEOUploader]:step:" + this.step);
                this.step = com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStep.VODSVideoStepUploadImage;
            } else if (aliyunVodUploadStep == com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStep.VODSVideoStepCreateVideoFinish) {
                com.alibaba.sdk.android.oss.common.OSSLog.logDebug(TAG, "[VODSVIDEOUploader]:step:" + this.step);
                this.step = com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStep.VODSVideoStepUploadVideo;
            }
            com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo = new com.alibaba.sdk.android.vod.upload.model.UploadFileInfo();
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(new java.lang.String(android.util.Base64.decode(str, 0)));
                this.ossConfig.setAccessKeyId(jSONObject.optString(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_COMMON_ACCESSKEYID));
                this.ossConfig.setAccessKeySecret(jSONObject.optString("AccessKeySecret"));
                this.ossConfig.setSecrityToken(jSONObject.optString(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_COMMON_SECURITY_TOKEN));
                this.ossConfig.setExpireTime(jSONObject.optString("Expiration"));
                java.lang.String optString = jSONObject.optString("ExpireUTCTime");
                if (!android.text.TextUtils.isEmpty(optString)) {
                    this.ossConfig.setExpireTime(optString);
                }
                com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStep aliyunVodUploadStep2 = this.step;
                com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStep aliyunVodUploadStep3 = com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStep.VODSVideoStepUploadVideo;
                if (aliyunVodUploadStep2 == aliyunVodUploadStep3) {
                    this.ossConfig.setVideoId(sVideoConfig.getVideoId());
                }
                this.ossConfig.setUploadAddress(str2);
                org.json.JSONObject jSONObject2 = new org.json.JSONObject(new java.lang.String(android.util.Base64.decode(str2, 0)));
                uploadFileInfo.setEndpoint(jSONObject2.optString("Endpoint"));
                uploadFileInfo.setBucket(jSONObject2.optString("Bucket"));
                uploadFileInfo.setObject(jSONObject2.optString(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_FILENAME));
                com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStep aliyunVodUploadStep4 = this.step;
                if (aliyunVodUploadStep4 == com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStep.VODSVideoStepUploadImage) {
                    uploadFileInfo.setFilePath(sVideoConfig.getImagePath());
                    uploadFileInfo.setFileType(0);
                } else if (aliyunVodUploadStep4 == aliyunVodUploadStep3) {
                    uploadFileInfo.setFilePath(sVideoConfig.getVideoPath());
                    uploadFileInfo.setFileType(1);
                }
                uploadFileInfo.setVodInfo(sVideoConfig.getVodInfo());
                uploadFileInfo.setStatus(com.alibaba.sdk.android.vod.upload.common.UploadStateType.INIT);
                com.alibaba.sdk.android.vod.upload.model.OSSUploadInfo uploadInfo = com.alibaba.sdk.android.vod.upload.common.utils.SharedPreferencesUtil.getUploadInfo(this.context.get(), com.alibaba.sdk.android.vod.upload.internal.ResumeableSession.SHAREDPREFS_OSSUPLOAD, uploadFileInfo.getFilePath());
                if (uploadInfo == null || !com.alibaba.sdk.android.vod.upload.common.utils.MD5.checkMD5(this.context.get(), uploadInfo.getMd5(), uploadFileInfo.getFilePath())) {
                    this.resumeableSession.saveResumeableFileInfo(uploadFileInfo, sVideoConfig.getVideoId());
                } else {
                    uploadFileInfo = this.resumeableSession.getResumeableFileInfo(uploadFileInfo, sVideoConfig.getVideoId());
                }
                startUpload(uploadFileInfo);
            } catch (org.json.JSONException unused) {
                throw new com.alibaba.sdk.android.vod.upload.exception.VODClientException(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"uploadAuth\" format is error");
            }
        } catch (org.json.JSONException unused2) {
            throw new com.alibaba.sdk.android.vod.upload.exception.VODClientException(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"uploadAddress\" format is error");
        }
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODSVideoUploadClient
    public void cancel() {
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug(TAG, "[VODSVideoUploader]: cancel");
        this.status = com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStatus.VODSVideoStatusIdle;
        this.step = com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStep.VODSVideoStepIdle;
        com.alibaba.sdk.android.vod.upload.internal.OSSUploader oSSUploader = this.uploader;
        if (oSSUploader != null) {
            oSSUploader.cancel();
            this.fileList.clear();
            this.videoUploadCallback = null;
        }
        com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth aliyunVodAuth = this.aliyunVodAuth;
        if (aliyunVodAuth != null) {
            aliyunVodAuth.cancel();
            this.aliyunVodAuth = null;
        }
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODSVideoUploadClient
    public void init() {
        this.jsonSupport = new com.aliyun.vod.jasonparse.JSONSupportImpl();
        this.step = com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStep.VODSVideoStepIdle;
        this.status = com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStatus.VODSVideoStatusIdle;
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODSVideoUploadClient
    public void pause() {
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug(TAG, "[VODSVideoUploader]:  pause");
        com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStatus aliyunVodUploadStatus = this.status;
        if (aliyunVodUploadStatus == com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStatus.VODSVideoStatusIdle || aliyunVodUploadStatus == com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStatus.VODSVideoStatusResume) {
            com.alibaba.sdk.android.vod.upload.internal.OSSUploader oSSUploader = this.uploader;
            if (oSSUploader != null) {
                oSSUploader.pause();
            }
            this.status = com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStatus.VODSVideoStatusPause;
            return;
        }
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[VODSVideoUploadClientImpl] - status: " + this.status + " cann't be pause!");
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODSVideoUploadClient
    public void refreshSTSToken(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        if (com.alibaba.sdk.android.vod.upload.common.utils.StringUtil.isEmpty(str)) {
            throw new com.alibaba.sdk.android.vod.upload.exception.VODClientException(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"accessKeyId\" cannot be null");
        }
        if (com.alibaba.sdk.android.vod.upload.common.utils.StringUtil.isEmpty(str2)) {
            throw new com.alibaba.sdk.android.vod.upload.exception.VODClientException(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"accessKeySecret\" cannot be null");
        }
        if (com.alibaba.sdk.android.vod.upload.common.utils.StringUtil.isEmpty(str3)) {
            throw new com.alibaba.sdk.android.vod.upload.exception.VODClientException(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"accessToken\" cannot be null");
        }
        if (com.alibaba.sdk.android.vod.upload.common.utils.StringUtil.isEmpty(str4)) {
            throw new com.alibaba.sdk.android.vod.upload.exception.VODClientException(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"expriedTime\" cannot be null");
        }
        this.sVideoConfig.setAccessKeyId(str);
        this.sVideoConfig.setAccessKeySecret(str2);
        this.sVideoConfig.setSecrityToken(str3);
        this.sVideoConfig.setExpriedTime(str4);
        this.ossConfig.setAccessKeyId(this.sVideoConfig.getAccessKeyId());
        this.ossConfig.setAccessKeySecret(this.sVideoConfig.getAccessKeySecret());
        this.ossConfig.setSecrityToken(this.sVideoConfig.getSecrityToken());
        this.ossConfig.setExpireTime(this.sVideoConfig.getExpriedTime());
        refreshSTStoken();
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODSVideoUploadClient
    public void release() {
        if (this.sVideoConfig != null) {
            this.sVideoConfig = null;
        }
        if (this.aliyunVodAuth != null) {
            this.aliyunVodAuth = null;
        }
        if (this.uploader != null) {
            this.uploader = null;
        }
        if (this.videoUploadCallback != null) {
            this.videoUploadCallback = null;
        }
        this.status = com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStatus.VODSVideoStatusRelease;
        this.step = com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStep.VODSVideoStepIdle;
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODSVideoUploadClient
    public void resume() {
        com.alibaba.sdk.android.vod.upload.internal.OSSUploader oSSUploader;
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug(TAG, "[VODSVideoUploader]:  resume");
        com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStatus aliyunVodUploadStatus = com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStatus.VODSVideoStatusPause;
        com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStatus aliyunVodUploadStatus2 = this.status;
        if (aliyunVodUploadStatus != aliyunVodUploadStatus2 && com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStatus.VODSVideoStatusIdle != aliyunVodUploadStatus2) {
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[VODSVideoUploadClientImpl] - status: " + this.status + " cann't be resume!");
            return;
        }
        if (aliyunVodUploadStatus2 == aliyunVodUploadStatus) {
            com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStep aliyunVodUploadStep = this.step;
            if (aliyunVodUploadStep == com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStep.VODSVideoStepIdle || aliyunVodUploadStep == com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStep.VODSVideoStepCreateImage || aliyunVodUploadStep == com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStep.VODSVideoStepCreateImageFinish || aliyunVodUploadStep == com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStep.VODSVideoStepCreateVideo) {
                createUploadImage();
            } else if (aliyunVodUploadStep != com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStep.VODSVideoStepFinish && (oSSUploader = this.uploader) != null) {
                oSSUploader.resume();
            }
            this.status = com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStatus.VODSVideoStatusResume;
        }
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODSVideoUploadClient
    public void setAppVersion(java.lang.String str) {
        com.aliyun.vod.log.core.AliyunLogger logger = com.aliyun.vod.log.core.AliyunLoggerManager.getLogger(com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.class.getName());
        if (logger != null) {
            logger.setAppVersion(str);
        }
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODSVideoUploadClient
    public void setRecordUploadProgressEnabled(boolean z) {
        com.alibaba.sdk.android.vod.upload.internal.ResumeableSession resumeableSession = this.resumeableSession;
        if (resumeableSession != null) {
            resumeableSession.setEnabled(z);
        }
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODSVideoUploadClient
    public void setRegion(java.lang.String str) {
        this.domainRegion = str;
    }

    public void setReportEnabled(boolean z) {
        this.reportEnabled = z;
        com.aliyun.vod.log.core.AliyunLoggerManager.toggleLogger(z);
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODSVideoUploadClient
    public void uploadWithVideoAndImg(com.alibaba.sdk.android.vod.upload.session.VodSessionCreateInfo vodSessionCreateInfo, com.alibaba.sdk.android.vod.upload.VODSVideoUploadCallback vODSVideoUploadCallback) {
        if (com.alibaba.sdk.android.vod.upload.common.utils.StringUtil.isEmpty(vodSessionCreateInfo.getAccessKeyId())) {
            throw new com.alibaba.sdk.android.vod.upload.exception.VODClientException(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"accessKeyId\" cannot be null");
        }
        if (com.alibaba.sdk.android.vod.upload.common.utils.StringUtil.isEmpty(vodSessionCreateInfo.getAccessKeySecret())) {
            throw new com.alibaba.sdk.android.vod.upload.exception.VODClientException(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"accessKeySecret\" cannot be null");
        }
        if (com.alibaba.sdk.android.vod.upload.common.utils.StringUtil.isEmpty(vodSessionCreateInfo.getSecurityToken())) {
            throw new com.alibaba.sdk.android.vod.upload.exception.VODClientException(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"securityToken\" cannot be null");
        }
        if (com.alibaba.sdk.android.vod.upload.common.utils.StringUtil.isEmpty(vodSessionCreateInfo.getExpriedTime())) {
            throw new com.alibaba.sdk.android.vod.upload.exception.VODClientException(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"expriedTime\" cannot be null");
        }
        if (!new java.io.File(vodSessionCreateInfo.getVideoPath()).exists()) {
            throw new com.alibaba.sdk.android.vod.upload.exception.VODClientException(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.FILE_NOT_EXIST, "The specified parameter \"videoPath\" file not exists");
        }
        if (!new java.io.File(vodSessionCreateInfo.getImagePath()).exists()) {
            throw new com.alibaba.sdk.android.vod.upload.exception.VODClientException(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.FILE_NOT_EXIST, "The specified parameter \"imagePath\" file not exists");
        }
        if (vODSVideoUploadCallback == null) {
            throw new com.alibaba.sdk.android.vod.upload.exception.VODClientException(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"callback\" cannot be null");
        }
        this.videoUploadCallback = vODSVideoUploadCallback;
        if (this.aliyunVodAuth == null) {
            this.aliyunVodAuth = new com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth(new com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunAuthCallback());
        }
        this.aliyunVodAuth.setDomainRegion(this.domainRegion);
        com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStatus aliyunVodUploadStatus = com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStatus.VODSVideoStatusPause;
        com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStatus aliyunVodUploadStatus2 = this.status;
        if (aliyunVodUploadStatus == aliyunVodUploadStatus2 || com.alibaba.sdk.android.vod.upload.VODSVideoUploadClientImpl.AliyunVodUploadStatus.VODSVideoStatusRelease == aliyunVodUploadStatus2) {
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[VODSVideoUploadClientImpl] - status: " + this.status + " cann't be start upload!");
            return;
        }
        com.aliyun.vod.log.core.AliyunLogger logger = com.aliyun.vod.log.core.AliyunLoggerManager.getLogger(com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.class.getName());
        if (logger != null) {
            logger.setRequestID(vodSessionCreateInfo.getRequestID(), false);
            logger.setProductSVideo(true);
        }
        this.sVideoConfig.setAccessKeyId(vodSessionCreateInfo.getAccessKeyId());
        this.sVideoConfig.setAccessKeySecret(vodSessionCreateInfo.getAccessKeySecret());
        this.sVideoConfig.setSecrityToken(vodSessionCreateInfo.getSecurityToken());
        this.sVideoConfig.setExpriedTime(vodSessionCreateInfo.getExpriedTime());
        this.sVideoConfig.setVideoPath(vodSessionCreateInfo.getVideoPath());
        this.sVideoConfig.setImagePath(vodSessionCreateInfo.getImagePath());
        this.sVideoConfig.setTranscode(vodSessionCreateInfo.isTranscode());
        this.sVideoConfig.setPartSize(vodSessionCreateInfo.getPartSize());
        this.sVideoConfig.setRequestId(vodSessionCreateInfo.getRequestID());
        this.sVideoConfig.setTemplateGroupId(vodSessionCreateInfo.getTemplateGroupId());
        this.sVideoConfig.setStorageLocation(vodSessionCreateInfo.getStorageLocation());
        this.sVideoConfig.setWorkFlowId(vodSessionCreateInfo.getWorkFlowId());
        this.sVideoConfig.setAppId(vodSessionCreateInfo.getAppId());
        this.sVideoConfig.setUserData(vodSessionCreateInfo.getSvideoInfo().getUserData());
        this.imageSize = new java.io.File(vodSessionCreateInfo.getImagePath()).length();
        this.videoSize = new java.io.File(vodSessionCreateInfo.getVideoPath()).length();
        this.ossConfig.setAccessKeyId(this.sVideoConfig.getAccessKeyId());
        this.ossConfig.setAccessKeySecret(this.sVideoConfig.getAccessKeySecret());
        this.ossConfig.setSecrityToken(this.sVideoConfig.getSecrityToken());
        this.ossConfig.setExpireTime(this.sVideoConfig.getExpriedTime());
        this.ossConfig.setPartSize(this.sVideoConfig.getPartSize());
        com.alibaba.sdk.android.vod.upload.model.VodInfo vodInfo = new com.alibaba.sdk.android.vod.upload.model.VodInfo();
        vodInfo.setTitle(vodSessionCreateInfo.getSvideoInfo().getTitle());
        vodInfo.setDesc(vodSessionCreateInfo.getSvideoInfo().getDesc());
        vodInfo.setCateId(vodSessionCreateInfo.getSvideoInfo().getCateId());
        vodInfo.setTags(vodSessionCreateInfo.getSvideoInfo().getTags());
        vodInfo.setIsProcess(java.lang.Boolean.valueOf(vodSessionCreateInfo.getSvideoInfo().isProcess()));
        vodInfo.setIsShowWaterMark(java.lang.Boolean.valueOf(vodSessionCreateInfo.getSvideoInfo().isShowWaterMark()));
        vodInfo.setPriority(java.lang.Integer.valueOf(vodSessionCreateInfo.getSvideoInfo().getPriority()));
        vodInfo.setUserData(vodSessionCreateInfo.getSvideoInfo().getUserData());
        this.sVideoConfig.setVodInfo(vodInfo);
        addFile(this.sVideoConfig.getVodInfo());
        com.alibaba.sdk.android.oss.ClientConfiguration clientConfiguration = new com.alibaba.sdk.android.oss.ClientConfiguration();
        this.configuration = clientConfiguration;
        clientConfiguration.setMaxErrorRetry(vodSessionCreateInfo.getVodHttpClientConfig().getMaxRetryCount());
        this.configuration.setConnectionTimeout(vodSessionCreateInfo.getVodHttpClientConfig().getConnectionTimeout());
        this.configuration.setSocketTimeout(vodSessionCreateInfo.getVodHttpClientConfig().getSocketTimeout());
        createUploadImage();
    }
}
