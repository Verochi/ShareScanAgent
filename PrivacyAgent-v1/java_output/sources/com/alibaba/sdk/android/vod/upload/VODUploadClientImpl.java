package com.alibaba.sdk.android.vod.upload;

/* loaded from: classes.dex */
public class VODUploadClientImpl implements com.alibaba.sdk.android.vod.upload.internal.OSSUploadListener, com.alibaba.sdk.android.vod.upload.VODUploadClient {
    private com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth aliyunVodAuth;
    private java.lang.String appId;
    private com.alibaba.sdk.android.vod.upload.VODUploadCallback callback;
    private com.alibaba.sdk.android.oss.ClientConfiguration configuration;
    private java.lang.ref.WeakReference<android.content.Context> context;
    private com.alibaba.sdk.android.vod.upload.model.UploadFileInfo curFileInfo;
    private java.util.List<com.alibaba.sdk.android.vod.upload.model.UploadFileInfo> fileList;
    private com.aliyun.vod.jasonparse.JSONSupport jsonSupport;
    private com.alibaba.sdk.android.vod.upload.model.OSSConfig ossConfig;
    private com.alibaba.sdk.android.vod.upload.common.RequestIDSession requestIDSession;
    private com.alibaba.sdk.android.vod.upload.model.VodUploadResult resultInfo;
    private com.alibaba.sdk.android.vod.upload.internal.ResumeableSession resumeableSession;
    private com.alibaba.sdk.android.vod.upload.common.VodUploadStateType status;
    private java.lang.String storageLocation;
    private java.lang.String templateGroupId;
    private com.alibaba.sdk.android.vod.upload.internal.OSSUploader upload;
    private java.lang.String workflowId;
    private boolean isTranscode = true;
    private boolean recordUploadProgressEnabled = true;
    private java.lang.String domainRegion = null;
    private boolean isVODAuthMode = false;
    private boolean reportEnabled = true;
    private android.os.Handler mMainHandler = new android.os.Handler(android.os.Looper.getMainLooper());

    /* renamed from: com.alibaba.sdk.android.vod.upload.VODUploadClientImpl$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.aliyun.vod.log.core.AliyunLogger val$logger;

        public AnonymousClass1(com.aliyun.vod.log.core.AliyunLogger aliyunLogger) {
            this.val$logger = aliyunLogger;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put(com.aliyun.vod.log.struct.AliyunLogKey.KEY_QUEUE_LENGHT, java.lang.String.valueOf(com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.this.listFiles().size()));
            this.val$logger.pushLog(hashMap, "upload", "debug", com.aliyun.vod.log.core.AliyunLogCommon.Module.UPLOADER, "upload", 20001, "upload", com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.this.requestIDSession.getRequestID());
        }
    }

    /* renamed from: com.alibaba.sdk.android.vod.upload.VODUploadClientImpl$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.this.callback != null) {
                com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.this.callback.onUploadTokenExpired();
            }
        }
    }

    public class AliyunAuthCallback implements com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.VodAuthCallBack {
        public AliyunAuthCallback() {
        }

        @Override // com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.VodAuthCallBack
        public void onCreateUploadImaged(com.aliyun.auth.model.CreateImageForm createImageForm) {
            com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.this.status = com.alibaba.sdk.android.vod.upload.common.VodUploadStateType.STARTED;
            com.alibaba.sdk.android.vod.upload.VODUploadClientImpl vODUploadClientImpl = com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.this;
            vODUploadClientImpl.setUploadAuthAndAddress(vODUploadClientImpl.curFileInfo, createImageForm.getUploadAuth(), createImageForm.getUploadAddress());
            com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.this.resultInfo.setImageUrl(createImageForm.getImageURL());
            com.alibaba.sdk.android.vod.upload.VODUploadClientImpl vODUploadClientImpl2 = com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.this;
            vODUploadClientImpl2.startUpload(vODUploadClientImpl2.curFileInfo);
        }

        @Override // com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.VodAuthCallBack
        public void onCreateUploadVideoed(com.aliyun.auth.model.CreateVideoForm createVideoForm, java.lang.String str) {
            com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.this.status = com.alibaba.sdk.android.vod.upload.common.VodUploadStateType.STARTED;
            createVideoForm.getVideoId();
            com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.this.resultInfo.setVideoid(createVideoForm.getVideoId());
            com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.this.ossConfig.setVideoId(createVideoForm.getVideoId());
            com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.this.ossConfig.setUploadAddress(createVideoForm.getUploadAddress());
            com.alibaba.sdk.android.vod.upload.VODUploadClientImpl vODUploadClientImpl = com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.this;
            vODUploadClientImpl.setUploadAuthAndAddress(vODUploadClientImpl.curFileInfo, createVideoForm.getUploadAuth(), createVideoForm.getUploadAddress());
            com.alibaba.sdk.android.vod.upload.VODUploadClientImpl vODUploadClientImpl2 = com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.this;
            vODUploadClientImpl2.startUpload(vODUploadClientImpl2.curFileInfo);
        }

        @Override // com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.VodAuthCallBack
        public void onError(java.lang.String str, java.lang.String str2) {
            if (!com.aliyun.auth.core.AliyunVodErrorCode.VODERRORCODE_INVALIDVIDEO.equals(str) || com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.this.resumeableSession == null) {
                com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.this.callback.onUploadFailed(com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.this.curFileInfo, str, str2);
                return;
            }
            com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.this.resumeableSession.deleteResumeableFileInfo(com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.this.curFileInfo.getFilePath());
            com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.this.needCreateVODUploadAuth();
        }

        @Override // com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth.VodAuthCallBack
        public void onSTSExpired(com.aliyun.auth.common.AliyunVodUploadType aliyunVodUploadType) {
            com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.this.callback.onUploadTokenExpired();
        }
    }

    public VODUploadClientImpl(android.content.Context context) {
        com.aliyun.vod.common.httpfinal.QupaiHttpFinal.getInstance().initOkHttpFinal();
        this.context = new java.lang.ref.WeakReference<>(context);
        this.ossConfig = new com.alibaba.sdk.android.vod.upload.model.OSSConfig();
        this.resultInfo = new com.alibaba.sdk.android.vod.upload.model.VodUploadResult();
        this.resumeableSession = new com.alibaba.sdk.android.vod.upload.internal.ResumeableSession(context.getApplicationContext());
        this.requestIDSession = com.alibaba.sdk.android.vod.upload.common.RequestIDSession.getInstance();
        this.aliyunVodAuth = new com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth(new com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.AliyunAuthCallback());
        this.fileList = java.util.Collections.synchronizedList(new java.util.ArrayList());
        com.aliyun.vod.log.core.AliyunLoggerManager.createLogger(this.context.get(), com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.class.getName());
    }

    private void addFilesLogger() {
        com.aliyun.vod.log.core.LogService logService;
        com.aliyun.vod.log.core.AliyunLogger logger = com.aliyun.vod.log.core.AliyunLoggerManager.getLogger(com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.class.getName());
        if (logger == null || (logService = logger.getLogService()) == null) {
            return;
        }
        logService.execute(new com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.AnonymousClass1(logger));
    }

    private boolean isSTSMode(com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo) {
        return uploadFileInfo.getBucket() == null || uploadFileInfo.getEndpoint() == null || uploadFileInfo.getObject() == null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean needCreateVODUploadAuth() {
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[VODUploadClientImpl] - needCreateVODUploadAuth");
        if (!isSTSMode(this.curFileInfo) || this.isVODAuthMode) {
            return false;
        }
        try {
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[VODUploadClientImpl] filePath : " + this.curFileInfo.getFilePath());
            java.lang.String type = com.aliyun.vod.common.utils.StringUtils.isUriPath(this.curFileInfo.getFilePath()) ? this.context.get().getContentResolver().getType(android.net.Uri.parse(this.curFileInfo.getFilePath())) : com.aliyun.vod.common.utils.FileUtils.getMimeType(com.aliyun.vod.common.utils.FileUtils.percentEncode(this.curFileInfo.getFilePath()));
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[VODUploadClientImpl] file mimeType : " + type);
            if (android.text.TextUtils.isEmpty(type)) {
                com.alibaba.sdk.android.vod.upload.VODUploadCallback vODUploadCallback = this.callback;
                if (vODUploadCallback != null) {
                    vODUploadCallback.onUploadFailed(this.curFileInfo, com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.FILE_NOT_EXIST, "The file mimeType\"" + this.curFileInfo.getFilePath() + "\" is not recognized!");
                }
                return true;
            }
            this.status = com.alibaba.sdk.android.vod.upload.common.VodUploadStateType.GETVODAUTH;
            if (type.substring(0, type.lastIndexOf(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)).equals("video") || type.substring(0, type.lastIndexOf(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)).equals("audio")) {
                if (!com.aliyun.vod.common.utils.StringUtils.isUriPath(this.curFileInfo.getFilePath())) {
                    this.curFileInfo.getVodInfo().setFileName(new java.io.File(this.curFileInfo.getFilePath()).getName());
                } else if (this.context.get() != null) {
                    this.curFileInfo.getVodInfo().setFileName(com.aliyun.vod.common.utils.FileUtils.getFileNameByUri(this.context.get(), android.net.Uri.parse(this.curFileInfo.getFilePath())));
                } else {
                    com.alibaba.sdk.android.vod.upload.VODUploadCallback vODUploadCallback2 = this.callback;
                    if (vODUploadCallback2 != null) {
                        vODUploadCallback2.onUploadFailed(this.curFileInfo, com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.MISSING_ARGUMENT, "VODUploadClientImpl context is null!");
                    }
                }
                java.lang.String resumeableFileVideoID = this.resumeableSession.getResumeableFileVideoID(this.curFileInfo.getFilePath());
                try {
                    com.alibaba.sdk.android.vod.upload.model.UserData videoBitrate = com.alibaba.sdk.android.vod.upload.common.utils.VideoInfoUtil.getVideoBitrate(this.context.get(), this.curFileInfo.getFilePath());
                    java.lang.String userData = this.curFileInfo.getVodInfo().getUserData();
                    java.lang.String writeValue = this.jsonSupport.writeValue(videoBitrate);
                    com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[VODUploadClientImpl] - userdata-custom : " + userData);
                    com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[VODUploadClientImpl] - userdata-video : " + writeValue);
                    if (!android.text.TextUtils.isEmpty(writeValue)) {
                        this.curFileInfo.getVodInfo().setUserData(writeValue);
                    }
                    if (!android.text.TextUtils.isEmpty(userData)) {
                        this.curFileInfo.getVodInfo().setUserData(userData);
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
                        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[VODUploadClientImpl] - userdata : " + jSONObject3.toString());
                        this.curFileInfo.getVodInfo().setUserData(jSONObject3.toString());
                    }
                } catch (java.lang.Exception e3) {
                    e3.printStackTrace();
                    this.curFileInfo.getVodInfo().setUserData(null);
                }
                if (android.text.TextUtils.isEmpty(resumeableFileVideoID)) {
                    this.aliyunVodAuth.createUploadVideo(this.ossConfig.getAccessKeyIdToVOD(), this.ossConfig.getAccessKeySecretToVOD(), this.ossConfig.getSecrityTokenToVOD(), this.curFileInfo.getVodInfo(), this.isTranscode, this.templateGroupId, this.storageLocation, this.workflowId, this.appId, this.requestIDSession.getRequestID());
                } else {
                    this.aliyunVodAuth.refreshUploadVideo(this.ossConfig.getAccessKeyIdToVOD(), this.ossConfig.getAccessKeySecretToVOD(), this.ossConfig.getSecrityTokenToVOD(), resumeableFileVideoID, this.resultInfo.getImageUrl(), this.requestIDSession.getRequestID());
                }
            } else if (type.substring(0, type.lastIndexOf(net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR)).equals("image")) {
                this.aliyunVodAuth.createUploadImage(this.ossConfig.getAccessKeyIdToVOD(), this.ossConfig.getAccessKeySecretToVOD(), this.ossConfig.getSecrityTokenToVOD(), this.curFileInfo.getVodInfo(), this.workflowId, this.appId, this.requestIDSession.getRequestID(), android.text.TextUtils.equals(com.aliyun.auth.common.AliyunVodHttpCommon.ImageType.IMAGETYPE_COVER, this.curFileInfo.getVodInfo().getImageType()));
            }
            return true;
        } catch (java.lang.Exception e4) {
            e4.printStackTrace();
            com.alibaba.sdk.android.vod.upload.VODUploadCallback vODUploadCallback3 = this.callback;
            if (vODUploadCallback3 != null) {
                vODUploadCallback3.onUploadFailed(this.curFileInfo, com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.FILE_NOT_EXIST, "The file \"" + this.curFileInfo.getFilePath() + "\" is not exist!");
            }
            return true;
        }
    }

    private boolean next() {
        com.alibaba.sdk.android.vod.upload.common.VodUploadStateType vodUploadStateType = this.status;
        if (vodUploadStateType != com.alibaba.sdk.android.vod.upload.common.VodUploadStateType.PAUSED && vodUploadStateType != com.alibaba.sdk.android.vod.upload.common.VodUploadStateType.STOPED) {
            for (int i = 0; i < this.fileList.size(); i++) {
                if (this.fileList.get(i).getStatus() == com.alibaba.sdk.android.vod.upload.common.UploadStateType.INIT) {
                    this.curFileInfo = this.fileList.get(i);
                    if (needCreateVODUploadAuth()) {
                        return false;
                    }
                    com.alibaba.sdk.android.vod.upload.VODUploadCallback vODUploadCallback = this.callback;
                    if (vODUploadCallback != null) {
                        vODUploadCallback.onUploadStarted(this.curFileInfo);
                    }
                    startUpload(this.curFileInfo);
                    return true;
                }
            }
            this.status = com.alibaba.sdk.android.vod.upload.common.VodUploadStateType.FINISHED;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startUpload(com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo) {
        if (uploadFileInfo.isMultipart()) {
            this.upload = null;
            com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl oSSUploaderImpl = new com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl(this.context.get());
            this.upload = oSSUploaderImpl;
            oSSUploaderImpl.init(this.ossConfig, this);
            this.upload.setOSSClientConfiguration(this.configuration);
            try {
                this.upload.start(uploadFileInfo);
                return;
            } catch (java.io.FileNotFoundException e) {
                e.printStackTrace();
                this.callback.onUploadFailed(this.curFileInfo, com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.FILE_NOT_EXIST, "The file \"" + this.curFileInfo.getFilePath() + "\" is not exist!");
                return;
            }
        }
        if (com.aliyun.vod.common.utils.FileUtils.getFileLength(this.context.get(), uploadFileInfo.getFilePath()) >= com.alibaba.sdk.android.oss.common.OSSConstants.MIN_PART_SIZE_LIMIT) {
            this.upload = null;
            com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl resumableUploaderImpl = new com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl(this.context.get());
            this.upload = resumableUploaderImpl;
            resumableUploaderImpl.setDomainRegion(this.domainRegion);
            this.upload.init(this.ossConfig, this);
            this.upload.setOSSClientConfiguration(this.configuration);
            try {
                this.upload.start(uploadFileInfo);
                return;
            } catch (java.io.FileNotFoundException e2) {
                e2.printStackTrace();
                this.callback.onUploadFailed(this.curFileInfo, com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.FILE_NOT_EXIST, "The file \"" + this.curFileInfo.getFilePath() + "\" is not exist!");
                return;
            }
        }
        this.upload = null;
        com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl oSSPutUploaderImpl = new com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl(this.context.get());
        this.upload = oSSPutUploaderImpl;
        oSSPutUploaderImpl.init(this.ossConfig, this);
        this.upload.setOSSClientConfiguration(this.configuration);
        try {
            this.upload.start(uploadFileInfo);
        } catch (java.io.FileNotFoundException e3) {
            e3.printStackTrace();
            com.alibaba.sdk.android.vod.upload.VODUploadCallback vODUploadCallback = this.callback;
            if (vODUploadCallback != null) {
                vODUploadCallback.onUploadFailed(this.curFileInfo, com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.FILE_NOT_EXIST, "The file \"" + this.curFileInfo.getFilePath() + "\" is not exist!");
            }
        }
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void addFile(java.lang.String str, com.alibaba.sdk.android.vod.upload.model.VodInfo vodInfo) {
        com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo = new com.alibaba.sdk.android.vod.upload.model.UploadFileInfo();
        uploadFileInfo.setFilePath(str);
        uploadFileInfo.setVodInfo(vodInfo);
        uploadFileInfo.setStatus(com.alibaba.sdk.android.vod.upload.common.UploadStateType.INIT);
        this.fileList.add(uploadFileInfo);
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void addFile(java.lang.String str, com.alibaba.sdk.android.vod.upload.model.VodInfo vodInfo, java.util.List<com.alibaba.sdk.android.vod.upload.model.FilePartInfo> list) {
        com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo = new com.alibaba.sdk.android.vod.upload.model.UploadFileInfo();
        uploadFileInfo.setMultipart(true);
        uploadFileInfo.setPartInfoList(new java.util.ArrayList(list));
        uploadFileInfo.setFilePath(str);
        uploadFileInfo.setVodInfo(vodInfo);
        uploadFileInfo.setStatus(com.alibaba.sdk.android.vod.upload.common.UploadStateType.INIT);
        this.fileList.add(uploadFileInfo);
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void addFile(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        if (com.alibaba.sdk.android.vod.upload.common.utils.StringUtil.isEmpty(str)) {
            throw new com.alibaba.sdk.android.vod.upload.exception.VODClientException(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"localFilePath\" cannot be null");
        }
        if (com.alibaba.sdk.android.vod.upload.common.utils.StringUtil.isEmpty(str2)) {
            throw new com.alibaba.sdk.android.vod.upload.exception.VODClientException(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"endpoint\" cannot be null");
        }
        if (com.alibaba.sdk.android.vod.upload.common.utils.StringUtil.isEmpty(str2)) {
            throw new com.alibaba.sdk.android.vod.upload.exception.VODClientException(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"bucket\" cannot be null");
        }
        if (com.alibaba.sdk.android.vod.upload.common.utils.StringUtil.isEmpty(str4)) {
            throw new com.alibaba.sdk.android.vod.upload.exception.VODClientException(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"object\" cannot be null");
        }
        com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo = new com.alibaba.sdk.android.vod.upload.model.UploadFileInfo();
        uploadFileInfo.setFilePath(str);
        uploadFileInfo.setEndpoint(str2);
        uploadFileInfo.setBucket(str3);
        uploadFileInfo.setObject(str4);
        uploadFileInfo.setStatus(com.alibaba.sdk.android.vod.upload.common.UploadStateType.INIT);
        this.fileList.add(uploadFileInfo);
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void addFile(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, com.alibaba.sdk.android.vod.upload.model.VodInfo vodInfo) {
        if (com.alibaba.sdk.android.vod.upload.common.utils.StringUtil.isEmpty(str)) {
            throw new com.alibaba.sdk.android.vod.upload.exception.VODClientException(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"localFilePath\" cannot be null");
        }
        if (com.alibaba.sdk.android.vod.upload.common.utils.StringUtil.isEmpty(str2)) {
            throw new com.alibaba.sdk.android.vod.upload.exception.VODClientException(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"endpoint\" cannot be null");
        }
        if (com.alibaba.sdk.android.vod.upload.common.utils.StringUtil.isEmpty(str2)) {
            throw new com.alibaba.sdk.android.vod.upload.exception.VODClientException(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"bucket\" cannot be null");
        }
        if (com.alibaba.sdk.android.vod.upload.common.utils.StringUtil.isEmpty(str4)) {
            throw new com.alibaba.sdk.android.vod.upload.exception.VODClientException(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"object\" cannot be null");
        }
        com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo = new com.alibaba.sdk.android.vod.upload.model.UploadFileInfo();
        uploadFileInfo.setFilePath(str);
        uploadFileInfo.setEndpoint(str2);
        uploadFileInfo.setBucket(str3);
        uploadFileInfo.setObject(str4);
        uploadFileInfo.setVodInfo(vodInfo);
        uploadFileInfo.setStatus(com.alibaba.sdk.android.vod.upload.common.UploadStateType.INIT);
        this.fileList.add(uploadFileInfo);
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void cancelFile(int i) {
        com.alibaba.sdk.android.vod.upload.internal.ResumeableSession resumeableSession;
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[VODUploadClientImpl] - cancelFile called status: " + this.status);
        if (i < 0 || i >= this.fileList.size()) {
            throw new com.alibaba.sdk.android.vod.upload.exception.VODClientException(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.INVALID_ARGUMENT, "index out of range");
        }
        com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo = this.fileList.get(i);
        if (uploadFileInfo != null) {
            com.alibaba.sdk.android.vod.upload.common.UploadStateType status = uploadFileInfo.getStatus();
            com.alibaba.sdk.android.vod.upload.common.UploadStateType uploadStateType = com.alibaba.sdk.android.vod.upload.common.UploadStateType.CANCELED;
            if (status == uploadStateType) {
                com.alibaba.sdk.android.oss.common.OSSLog.logDebug("The file \"" + uploadFileInfo.getFilePath() + "\" is already canceled!");
                return;
            }
            if (uploadFileInfo.getStatus() == com.alibaba.sdk.android.vod.upload.common.UploadStateType.UPLOADING) {
                com.alibaba.sdk.android.vod.upload.internal.OSSUploader oSSUploader = this.upload;
                if (oSSUploader != null) {
                    oSSUploader.cancel();
                }
            } else {
                uploadFileInfo.setStatus(uploadStateType);
            }
            if (this.recordUploadProgressEnabled || (resumeableSession = this.resumeableSession) == null) {
                return;
            }
            resumeableSession.deleteResumeableFileInfo(uploadFileInfo.getFilePath(), true);
        }
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void clearFiles() {
        com.alibaba.sdk.android.vod.upload.internal.ResumeableSession resumeableSession;
        java.util.List<com.alibaba.sdk.android.vod.upload.model.UploadFileInfo> list = this.fileList;
        if (list != null && list.size() > 0) {
            for (com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo : this.fileList) {
                if (uploadFileInfo != null && (resumeableSession = this.resumeableSession) != null) {
                    resumeableSession.deleteResumeableFileInfo(uploadFileInfo.getFilePath());
                }
            }
        }
        this.fileList.clear();
        com.alibaba.sdk.android.vod.upload.internal.OSSUploader oSSUploader = this.upload;
        if (oSSUploader != null) {
            oSSUploader.cancel();
        }
        this.status = com.alibaba.sdk.android.vod.upload.common.VodUploadStateType.INIT;
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void deleteFile(int i) {
        com.alibaba.sdk.android.vod.upload.internal.OSSUploader oSSUploader;
        if (i < 0 || i >= this.fileList.size()) {
            throw new com.alibaba.sdk.android.vod.upload.exception.VODClientException(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.INVALID_ARGUMENT, "index out of range");
        }
        com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo = this.fileList.get(i);
        if (uploadFileInfo != null) {
            if (uploadFileInfo.getStatus() == com.alibaba.sdk.android.vod.upload.common.UploadStateType.UPLOADING && (oSSUploader = this.upload) != null) {
                oSSUploader.pause();
            }
            com.alibaba.sdk.android.vod.upload.internal.ResumeableSession resumeableSession = this.resumeableSession;
            if (resumeableSession != null) {
                resumeableSession.deleteResumeableFileInfo(uploadFileInfo.getFilePath());
            }
        }
        this.fileList.remove(i);
        this.status = com.alibaba.sdk.android.vod.upload.common.VodUploadStateType.INIT;
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public com.alibaba.sdk.android.vod.upload.common.VodUploadStateType getStatus() {
        return this.status;
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void init(com.alibaba.sdk.android.vod.upload.VODUploadCallback vODUploadCallback) {
        if (vODUploadCallback == null) {
            throw new com.alibaba.sdk.android.vod.upload.exception.VODClientException(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"callback\" cannot be null");
        }
        this.jsonSupport = new com.aliyun.vod.jasonparse.JSONSupportImpl();
        this.callback = vODUploadCallback;
        this.status = com.alibaba.sdk.android.vod.upload.common.VodUploadStateType.INIT;
        this.isVODAuthMode = true;
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void init(java.lang.String str, java.lang.String str2, com.alibaba.sdk.android.vod.upload.VODUploadCallback vODUploadCallback) {
        if (com.alibaba.sdk.android.vod.upload.common.utils.StringUtil.isEmpty(str)) {
            throw new com.alibaba.sdk.android.vod.upload.exception.VODClientException(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"accessKeyId\" cannot be null");
        }
        if (com.alibaba.sdk.android.vod.upload.common.utils.StringUtil.isEmpty(str2)) {
            throw new com.alibaba.sdk.android.vod.upload.exception.VODClientException(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"accessKeySecret\" cannot be null");
        }
        if (vODUploadCallback == null) {
            throw new com.alibaba.sdk.android.vod.upload.exception.VODClientException(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"callback\" cannot be null");
        }
        this.jsonSupport = new com.aliyun.vod.jasonparse.JSONSupportImpl();
        this.ossConfig.setAccessKeyId(str);
        this.ossConfig.setAccessKeySecret(str2);
        this.callback = vODUploadCallback;
        this.status = com.alibaba.sdk.android.vod.upload.common.VodUploadStateType.INIT;
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void init(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, com.alibaba.sdk.android.vod.upload.VODUploadCallback vODUploadCallback) {
        if (com.alibaba.sdk.android.vod.upload.common.utils.StringUtil.isEmpty(str)) {
            throw new com.alibaba.sdk.android.vod.upload.exception.VODClientException(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"accessKeyId\" cannot be null");
        }
        if (com.alibaba.sdk.android.vod.upload.common.utils.StringUtil.isEmpty(str2)) {
            throw new com.alibaba.sdk.android.vod.upload.exception.VODClientException(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"accessKeySecret\" cannot be null");
        }
        if ((com.alibaba.sdk.android.vod.upload.common.utils.StringUtil.isEmpty(str3) && !com.alibaba.sdk.android.vod.upload.common.utils.StringUtil.isEmpty(str4)) || (!com.alibaba.sdk.android.vod.upload.common.utils.StringUtil.isEmpty(str3) && com.alibaba.sdk.android.vod.upload.common.utils.StringUtil.isEmpty(str4))) {
            throw new com.alibaba.sdk.android.vod.upload.exception.VODClientException(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"secrityToken\" and \"expireTime\" cannot be null");
        }
        if (vODUploadCallback == null) {
            throw new com.alibaba.sdk.android.vod.upload.exception.VODClientException(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"callback\" cannot be null");
        }
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("VODUpload", "init:STS:\n\nAccessKeyId:" + str + "\nAccessKeySecret:" + str2 + "\nSecrityToken:" + str3 + "\nexpireTime:" + str4);
        this.jsonSupport = new com.aliyun.vod.jasonparse.JSONSupportImpl();
        this.ossConfig.setAccessKeyIdToVOD(str);
        this.ossConfig.setAccessKeySecretToVOD(str2);
        this.ossConfig.setSecrityTokenToVOD(str3);
        this.ossConfig.setExpireTimeToVOD(str4);
        this.callback = vODUploadCallback;
        this.status = com.alibaba.sdk.android.vod.upload.common.VodUploadStateType.INIT;
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public java.util.List<com.alibaba.sdk.android.vod.upload.model.UploadFileInfo> listFiles() {
        return this.fileList;
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploadListener
    public void onUploadFailed(java.lang.String str, java.lang.String str2) {
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[VODUploadClientImpl] - onUploadFailed: " + str + str2);
        if (str.equals(com.alibaba.sdk.android.vod.upload.common.UploadStateType.CANCELED.toString())) {
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[VODUploadClientImpl] - onUploadFailed Canceled");
            com.alibaba.sdk.android.vod.upload.common.VodUploadStateType vodUploadStateType = this.status;
            if (vodUploadStateType == com.alibaba.sdk.android.vod.upload.common.VodUploadStateType.STARTED) {
                next();
                return;
            } else {
                if (vodUploadStateType == com.alibaba.sdk.android.vod.upload.common.VodUploadStateType.STOPED) {
                    this.curFileInfo.setStatus(com.alibaba.sdk.android.vod.upload.common.UploadStateType.INIT);
                    return;
                }
                return;
            }
        }
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[VODUploadClientImpl] - onUploadFailed Callback");
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[VODUploadClientImpl] - onUploadFailed Callback " + this.callback);
        com.alibaba.sdk.android.vod.upload.VODUploadCallback vODUploadCallback = this.callback;
        if (vODUploadCallback != null) {
            vODUploadCallback.onUploadFailed(this.curFileInfo, str, str2);
            this.status = com.alibaba.sdk.android.vod.upload.common.VodUploadStateType.FAIlURE;
        }
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploadListener
    public void onUploadProgress(java.lang.Object obj, long j, long j2) {
        com.alibaba.sdk.android.vod.upload.VODUploadCallback vODUploadCallback = this.callback;
        if (vODUploadCallback != null) {
            vODUploadCallback.onUploadProgress(this.curFileInfo, j, j2);
        }
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploadListener
    public void onUploadRetry(java.lang.String str, java.lang.String str2) {
        com.alibaba.sdk.android.vod.upload.VODUploadCallback vODUploadCallback = this.callback;
        if (vODUploadCallback != null) {
            vODUploadCallback.onUploadRetry(str, str2);
        }
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploadListener
    public void onUploadRetryResume() {
        com.alibaba.sdk.android.vod.upload.VODUploadCallback vODUploadCallback = this.callback;
        if (vODUploadCallback != null) {
            vODUploadCallback.onUploadRetryResume();
        }
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploadListener
    public void onUploadSucceed() {
        com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo;
        com.alibaba.sdk.android.vod.upload.VODUploadCallback vODUploadCallback = this.callback;
        if (vODUploadCallback != null) {
            vODUploadCallback.onUploadSucceed(this.curFileInfo, this.resultInfo);
        }
        com.alibaba.sdk.android.vod.upload.internal.ResumeableSession resumeableSession = this.resumeableSession;
        if (resumeableSession != null && (uploadFileInfo = this.curFileInfo) != null) {
            resumeableSession.deleteResumeableFileInfo(uploadFileInfo.getFilePath());
        }
        next();
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploadListener
    public void onUploadTokenExpired() {
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[VODUploadClientImpl] - onUploadTokenExpired");
        this.status = com.alibaba.sdk.android.vod.upload.common.VodUploadStateType.PAUSED;
        this.mMainHandler.post(new com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.AnonymousClass2());
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void pause() {
        com.alibaba.sdk.android.vod.upload.internal.OSSUploader oSSUploader;
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[VODUploadClientImpl] - pause called status: " + this.status);
        if (com.alibaba.sdk.android.vod.upload.common.VodUploadStateType.STARTED != this.status) {
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[VODUploadClientImpl] - status: " + this.status + " cann't be pause!");
            return;
        }
        com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo = this.curFileInfo;
        if (uploadFileInfo == null) {
            return;
        }
        if (uploadFileInfo.getStatus() == com.alibaba.sdk.android.vod.upload.common.UploadStateType.UPLOADING && (oSSUploader = this.upload) != null) {
            oSSUploader.pause();
        }
        this.status = com.alibaba.sdk.android.vod.upload.common.VodUploadStateType.PAUSED;
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[VODUploadClientImpl] - pause called. status: " + this.status + "");
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void resume() {
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[VODUploadClientImpl] - resume called status: " + this.status);
        if (com.alibaba.sdk.android.vod.upload.common.VodUploadStateType.PAUSED != this.status) {
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[VODUploadClientImpl] - status: " + this.status + " cann't be resume!");
            return;
        }
        this.status = com.alibaba.sdk.android.vod.upload.common.VodUploadStateType.STARTED;
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[VODUploadClientImpl] - resume called. status: " + this.status + "");
        if (this.curFileInfo.getStatus() == com.alibaba.sdk.android.vod.upload.common.UploadStateType.PAUSED || this.curFileInfo.getStatus() == com.alibaba.sdk.android.vod.upload.common.UploadStateType.PAUSING) {
            com.alibaba.sdk.android.vod.upload.internal.OSSUploader oSSUploader = this.upload;
            if (oSSUploader != null) {
                oSSUploader.resume();
                return;
            }
            return;
        }
        if (this.curFileInfo.getStatus() == com.alibaba.sdk.android.vod.upload.common.UploadStateType.CANCELED || this.curFileInfo.getStatus() == com.alibaba.sdk.android.vod.upload.common.UploadStateType.SUCCESS || this.curFileInfo.getStatus() == com.alibaba.sdk.android.vod.upload.common.UploadStateType.FAIlURE) {
            next();
        }
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void resumeFile(int i) {
        com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo;
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[VODUploadClientImpl] - resumeFile called status: " + this.status);
        if (i < 0 || i >= this.fileList.size()) {
            throw new com.alibaba.sdk.android.vod.upload.exception.VODClientException(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.INVALID_ARGUMENT, "index out of range");
        }
        com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo2 = this.fileList.get(i);
        if (uploadFileInfo2.getStatus() == com.alibaba.sdk.android.vod.upload.common.UploadStateType.FAIlURE || uploadFileInfo2.getStatus() == com.alibaba.sdk.android.vod.upload.common.UploadStateType.CANCELED) {
            uploadFileInfo2.setStatus(com.alibaba.sdk.android.vod.upload.common.UploadStateType.INIT);
        }
        if (this.status != com.alibaba.sdk.android.vod.upload.common.VodUploadStateType.STARTED || (uploadFileInfo = this.curFileInfo) == null || uploadFileInfo.getStatus() == com.alibaba.sdk.android.vod.upload.common.UploadStateType.UPLOADING) {
            return;
        }
        next();
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void resumeWithAuth(java.lang.String str) {
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[VODUploadClientImpl] - resumeWithAuth called status: " + this.status);
        if (com.alibaba.sdk.android.vod.upload.common.utils.StringUtil.isEmpty(str)) {
            throw new com.alibaba.sdk.android.vod.upload.exception.VODClientException(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"uploadAuth\" cannot be null");
        }
        try {
            java.lang.String str2 = new java.lang.String(android.util.Base64.decode(str, 0));
            org.json.JSONObject jSONObject = new org.json.JSONObject(str2);
            java.lang.String optString = jSONObject.optString("Expiration");
            java.lang.String optString2 = jSONObject.optString("ExpireUTCTime");
            if (!android.text.TextUtils.isEmpty(optString2)) {
                optString = optString2;
            }
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[VODUploadClientImpl] resumeWithAuth : " + str2);
            resumeWithToken(jSONObject.optString(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_COMMON_ACCESSKEYID), jSONObject.optString("AccessKeySecret"), jSONObject.optString(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_COMMON_SECURITY_TOKEN), optString);
        } catch (org.json.JSONException unused) {
            throw new com.alibaba.sdk.android.vod.upload.exception.VODClientException(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"uploadAuth\" format is error");
        }
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void resumeWithToken(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[VODUploadClientImpl] - resumeWithToken called status: " + this.status);
        com.alibaba.sdk.android.vod.upload.common.VodUploadStateType vodUploadStateType = com.alibaba.sdk.android.vod.upload.common.VodUploadStateType.PAUSED;
        com.alibaba.sdk.android.vod.upload.common.VodUploadStateType vodUploadStateType2 = this.status;
        if (vodUploadStateType != vodUploadStateType2 && com.alibaba.sdk.android.vod.upload.common.VodUploadStateType.FAIlURE != vodUploadStateType2 && com.alibaba.sdk.android.vod.upload.common.VodUploadStateType.GETVODAUTH != vodUploadStateType2) {
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[VODUploadClientImpl] - status: " + this.status + " cann't be resume with token!");
            return;
        }
        this.ossConfig.setAccessKeyIdToVOD(str);
        this.ossConfig.setAccessKeySecretToVOD(str2);
        this.ossConfig.setSecrityTokenToVOD(str3);
        this.ossConfig.setExpireTimeToVOD(str4);
        if (this.status == com.alibaba.sdk.android.vod.upload.common.VodUploadStateType.GETVODAUTH) {
            needCreateVODUploadAuth();
            return;
        }
        this.status = com.alibaba.sdk.android.vod.upload.common.VodUploadStateType.STARTED;
        com.alibaba.sdk.android.vod.upload.internal.OSSUploader oSSUploader = this.upload;
        if (oSSUploader != null) {
            oSSUploader.resume();
        }
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void setAppId(java.lang.String str) {
        this.appId = str;
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void setPartSize(long j) {
        com.alibaba.sdk.android.vod.upload.model.OSSConfig oSSConfig = this.ossConfig;
        if (oSSConfig != null) {
            oSSConfig.setPartSize(j);
        }
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void setRecordUploadProgressEnabled(boolean z) {
        this.recordUploadProgressEnabled = z;
        com.alibaba.sdk.android.vod.upload.internal.ResumeableSession resumeableSession = this.resumeableSession;
        if (resumeableSession != null) {
            resumeableSession.setEnabled(z);
        }
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void setRegion(java.lang.String str) {
        if (this.aliyunVodAuth == null) {
            this.aliyunVodAuth = new com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth(new com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.AliyunAuthCallback());
        }
        this.aliyunVodAuth.setDomainRegion(str);
        this.domainRegion = str;
    }

    public void setReportEnabled(boolean z) {
        this.reportEnabled = z;
        com.aliyun.vod.log.core.AliyunLoggerManager.toggleLogger(z);
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void setStorageLocation(java.lang.String str) {
        this.storageLocation = str;
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void setTemplateGroupId(java.lang.String str) {
        this.templateGroupId = str;
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void setTranscodeMode(boolean z) {
        this.isTranscode = z;
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void setUploadAuthAndAddress(com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo, java.lang.String str, java.lang.String str2) {
        com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo2;
        if (uploadFileInfo == null) {
            throw new com.alibaba.sdk.android.vod.upload.exception.VODClientException(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"uploadFileInfo\" cannot be null");
        }
        if (com.alibaba.sdk.android.vod.upload.common.utils.StringUtil.isEmpty(str)) {
            throw new com.alibaba.sdk.android.vod.upload.exception.VODClientException(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"uploadAuth\" cannot be null");
        }
        if (com.alibaba.sdk.android.vod.upload.common.utils.StringUtil.isEmpty(str2)) {
            throw new com.alibaba.sdk.android.vod.upload.exception.VODClientException(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"uploadAddress\" cannot be null");
        }
        int i = 0;
        while (true) {
            if (i >= this.fileList.size()) {
                uploadFileInfo2 = null;
                break;
            }
            if (this.fileList.get(i).getFilePath().equals(uploadFileInfo.getFilePath())) {
                com.alibaba.sdk.android.vod.upload.common.UploadStateType status = this.fileList.get(i).getStatus();
                com.alibaba.sdk.android.vod.upload.common.UploadStateType uploadStateType = com.alibaba.sdk.android.vod.upload.common.UploadStateType.INIT;
                if (status == uploadStateType) {
                    com.alibaba.sdk.android.oss.common.OSSLog.logDebug("setUploadAuthAndAddress" + uploadFileInfo.getFilePath());
                    this.fileList.get(i).setStatus(uploadStateType);
                    uploadFileInfo2 = this.fileList.get(i);
                    break;
                }
            }
            i++;
        }
        if (uploadFileInfo2 == null) {
            throw new com.alibaba.sdk.android.vod.upload.exception.VODClientException(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.INVALID_ARGUMENT, "The specified parameter \"uploadFileInfo\" is invalid");
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(new java.lang.String(android.util.Base64.decode(str, 0)));
            this.ossConfig.setAccessKeyId(jSONObject.optString(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_COMMON_ACCESSKEYID));
            this.ossConfig.setAccessKeySecret(jSONObject.optString("AccessKeySecret"));
            this.ossConfig.setSecrityToken(jSONObject.optString(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_COMMON_SECURITY_TOKEN));
            this.ossConfig.setExpireTime(jSONObject.optString("Expiration"));
            java.lang.String optString = jSONObject.optString("Region");
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("VODSTS", "region : " + optString);
            if (!android.text.TextUtils.isEmpty(optString)) {
                if (this.aliyunVodAuth == null) {
                    this.aliyunVodAuth = new com.alibaba.sdk.android.vod.upload.auth.AliyunVodAuth(new com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.AliyunAuthCallback());
                }
                this.aliyunVodAuth.setDomainRegion(optString);
                this.domainRegion = optString;
            }
            java.lang.String optString2 = jSONObject.optString("ExpireUTCTime");
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("VODSTS", "expirationUTCTime : " + optString2);
            if (!android.text.TextUtils.isEmpty(optString2)) {
                this.ossConfig.setExpireTime(optString2);
            }
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("VODSTS", "AccessKeyId:" + this.ossConfig.getAccessKeyId() + "\nAccessKeySecret:" + this.ossConfig.getAccessKeySecret() + "\nSecrityToken:" + this.ossConfig.getSecrityToken() + "\nRegion:" + optString);
            try {
                org.json.JSONObject jSONObject2 = new org.json.JSONObject(new java.lang.String(android.util.Base64.decode(str2, 0)));
                uploadFileInfo2.setEndpoint(jSONObject2.optString("Endpoint"));
                uploadFileInfo2.setBucket(jSONObject2.optString("Bucket"));
                uploadFileInfo2.setObject(jSONObject2.optString(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_FILENAME));
                this.curFileInfo = uploadFileInfo2;
                com.alibaba.sdk.android.vod.upload.model.OSSUploadInfo uploadInfo = com.alibaba.sdk.android.vod.upload.common.utils.SharedPreferencesUtil.getUploadInfo(this.context.get(), com.alibaba.sdk.android.vod.upload.internal.ResumeableSession.SHAREDPREFS_OSSUPLOAD, this.curFileInfo.getFilePath());
                if (uploadInfo == null || !com.alibaba.sdk.android.vod.upload.common.utils.MD5.checkMD5(this.context.get(), uploadInfo.getMd5(), this.curFileInfo.getFilePath())) {
                    this.resumeableSession.saveResumeableFileInfo(this.curFileInfo, this.resultInfo.getVideoid());
                } else {
                    this.curFileInfo = this.resumeableSession.getResumeableFileInfo(this.curFileInfo, this.resultInfo.getVideoid());
                }
                this.ossConfig.setUploadAddress(str2);
            } catch (org.json.JSONException unused) {
                throw new com.alibaba.sdk.android.vod.upload.exception.VODClientException(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"uploadAddress\" format is error");
            }
        } catch (org.json.JSONException unused2) {
            throw new com.alibaba.sdk.android.vod.upload.exception.VODClientException(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.MISSING_ARGUMENT, "The specified parameter \"uploadAuth\" format is error");
        }
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void setVodHttpClientConfig(com.alibaba.sdk.android.vod.upload.session.VodHttpClientConfig vodHttpClientConfig) {
        com.alibaba.sdk.android.oss.ClientConfiguration clientConfiguration = new com.alibaba.sdk.android.oss.ClientConfiguration();
        this.configuration = clientConfiguration;
        clientConfiguration.setMaxErrorRetry(vodHttpClientConfig.getMaxRetryCount());
        this.configuration.setConnectionTimeout(vodHttpClientConfig.getConnectionTimeout());
        this.configuration.setSocketTimeout(vodHttpClientConfig.getSocketTimeout());
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void setWorkflowId(java.lang.String str) {
        this.workflowId = str;
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public synchronized void start() {
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[VODUploadClientImpl] - start called status: " + this.status);
        com.alibaba.sdk.android.vod.upload.common.VodUploadStateType vodUploadStateType = com.alibaba.sdk.android.vod.upload.common.VodUploadStateType.STARTED;
        com.alibaba.sdk.android.vod.upload.common.VodUploadStateType vodUploadStateType2 = this.status;
        if (vodUploadStateType == vodUploadStateType2 || com.alibaba.sdk.android.vod.upload.common.VodUploadStateType.PAUSED == vodUploadStateType2) {
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[VODUploadClientImpl] - status: " + this.status + " cann't be start!");
        } else {
            this.status = vodUploadStateType;
            addFilesLogger();
            next();
        }
    }

    @Override // com.alibaba.sdk.android.vod.upload.VODUploadClient
    public void stop() {
        com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo;
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[VODUploadClientImpl] - stop called status: " + this.status);
        com.alibaba.sdk.android.vod.upload.common.VodUploadStateType vodUploadStateType = com.alibaba.sdk.android.vod.upload.common.VodUploadStateType.STARTED;
        com.alibaba.sdk.android.vod.upload.common.VodUploadStateType vodUploadStateType2 = this.status;
        if (vodUploadStateType != vodUploadStateType2 && com.alibaba.sdk.android.vod.upload.common.VodUploadStateType.PAUSED != vodUploadStateType2) {
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[VODUploadClientImpl] - status: " + this.status + " cann't be stop!");
            return;
        }
        this.status = com.alibaba.sdk.android.vod.upload.common.VodUploadStateType.STOPED;
        if (this.upload == null || (uploadFileInfo = this.curFileInfo) == null) {
            return;
        }
        if (uploadFileInfo.getStatus() == com.alibaba.sdk.android.vod.upload.common.UploadStateType.UPLOADING || (this.curFileInfo.isMultipart() && this.curFileInfo.getStatus() == com.alibaba.sdk.android.vod.upload.common.UploadStateType.PAUSED)) {
            this.upload.cancel();
        }
    }
}
