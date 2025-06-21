package com.alibaba.sdk.android.vod.upload.internal;

/* loaded from: classes.dex */
public class OSSPutUploaderImpl implements com.alibaba.sdk.android.vod.upload.internal.OSSUploader {
    private com.alibaba.sdk.android.oss.ClientConfiguration clientConfig;
    private com.alibaba.sdk.android.vod.upload.model.OSSConfig config;
    private java.lang.ref.WeakReference<android.content.Context> context;
    private com.alibaba.sdk.android.vod.upload.internal.OSSUploadListener listener;
    private com.alibaba.sdk.android.oss.OSS oss;
    private com.alibaba.sdk.android.vod.upload.common.RequestIDSession requestIDSession;
    private com.alibaba.sdk.android.oss.internal.OSSAsyncTask task;
    private com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo;
    private com.aliyun.auth.core.VodThreadService vodThreadService;

    /* renamed from: com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.alibaba.sdk.android.vod.upload.model.UploadFileInfo val$uploadFileInfo;

        public AnonymousClass1(com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo) {
            this.val$uploadFileInfo = uploadFileInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl oSSPutUploaderImpl = com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.this;
            oSSPutUploaderImpl.oss = new com.alibaba.sdk.android.oss.OSSClient((android.content.Context) oSSPutUploaderImpl.context.get(), this.val$uploadFileInfo.getEndpoint(), com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.this.config.getProvider(), com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.this.clientConfig);
            com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl oSSPutUploaderImpl2 = com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.this;
            oSSPutUploaderImpl2.asyncPutObjectFromLocalFile(oSSPutUploaderImpl2.uploadFileInfo.getBucket(), com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.this.uploadFileInfo.getObject(), com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.this.uploadFileInfo.getFilePath());
        }
    }

    /* renamed from: com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl$2, reason: invalid class name */
    public class AnonymousClass2 implements com.alibaba.sdk.android.oss.callback.OSSProgressCallback<com.alibaba.sdk.android.oss.model.PutObjectRequest> {
        public AnonymousClass2() {
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSProgressCallback
        public void onProgress(com.alibaba.sdk.android.oss.model.PutObjectRequest putObjectRequest, long j, long j2) {
            com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.this.listener.onUploadProgress(putObjectRequest, j, j2);
        }
    }

    /* renamed from: com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl$3, reason: invalid class name */
    public class AnonymousClass3 implements com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.PutObjectRequest, com.alibaba.sdk.android.oss.model.PutObjectResult> {
        public AnonymousClass3() {
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
        public void onFailure(com.alibaba.sdk.android.oss.model.PutObjectRequest putObjectRequest, com.alibaba.sdk.android.oss.ClientException clientException, com.alibaba.sdk.android.oss.ServiceException serviceException) {
            if (clientException != null) {
                if (clientException.getMessage().equals("multipart cancel\n[ErrorMessage]: multipart cancel\n[ErrorMessage]: com.alibaba.sdk.android.oss.ClientException: multipart cancel\n[ErrorMessage]: multipart cancel")) {
                    if (com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.this.uploadFileInfo.getStatus() != com.alibaba.sdk.android.vod.upload.common.UploadStateType.CANCELED) {
                        com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.this.uploadFileInfo.setStatus(com.alibaba.sdk.android.vod.upload.common.UploadStateType.PAUSED);
                        return;
                    }
                    return;
                }
                com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[OSSUploader] - onFailure..." + clientException.getMessage());
                com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.this.uploadFileInfo.setStatus(com.alibaba.sdk.android.vod.upload.common.UploadStateType.FAIlURE);
                com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.this.listener.onUploadFailed(com.alibaba.sdk.android.vod.upload.internal.UploaderErrorCode.CLIENT_EXCEPTION, clientException.toString());
                com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.this.uploadFailedLogger(com.alibaba.sdk.android.vod.upload.internal.UploaderErrorCode.CLIENT_EXCEPTION, clientException.toString());
                com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.this.uploadPartFailedLogger(com.alibaba.sdk.android.vod.upload.internal.UploaderErrorCode.CLIENT_EXCEPTION, clientException.toString());
                return;
            }
            if (serviceException != null) {
                if (serviceException.getStatusCode() != 403 || com.alibaba.sdk.android.vod.upload.common.utils.StringUtil.isEmpty(com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.this.config.getSecrityToken())) {
                    com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[OSSUploader] - onFailure..." + serviceException.getErrorCode() + serviceException.getMessage());
                    com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.this.listener.onUploadFailed(serviceException.getErrorCode(), serviceException.getMessage());
                } else {
                    com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.this.listener.onUploadTokenExpired();
                }
                com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.this.uploadPartFailedLogger(serviceException.getErrorCode(), serviceException.toString());
                com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.this.uploadFailedLogger(serviceException.getErrorCode(), serviceException.toString());
            }
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
        public void onSuccess(com.alibaba.sdk.android.oss.model.PutObjectRequest putObjectRequest, com.alibaba.sdk.android.oss.model.PutObjectResult putObjectResult) {
            com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.this.uploadFileInfo.setStatus(com.alibaba.sdk.android.vod.upload.common.UploadStateType.SUCCESS);
            com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.this.listener.onUploadSucceed();
            com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.this.uploadSuccessedLogger();
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("PutObject", "UploadSuccess");
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("ETag", putObjectResult.getETag());
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug(com.aliyun.auth.core.AliyunVodKey.KEY_VOD_COMMON_REQUEST_ID, putObjectResult.getRequestId());
        }
    }

    /* renamed from: com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.this.task.cancel();
            com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.this.uploadFileInfo.setStatus(com.alibaba.sdk.android.vod.upload.common.UploadStateType.CANCELED);
        }
    }

    /* renamed from: com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        public AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.this.task.cancel();
        }
    }

    /* renamed from: com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl$6, reason: invalid class name */
    public class AnonymousClass6 implements java.lang.Runnable {
        public AnonymousClass6() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl oSSPutUploaderImpl = com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.this;
                oSSPutUploaderImpl.start(oSSPutUploaderImpl.uploadFileInfo);
            } catch (java.io.FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl$7, reason: invalid class name */
    public class AnonymousClass7 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$code;
        final /* synthetic */ com.aliyun.vod.log.core.AliyunLogger val$logger;
        final /* synthetic */ java.lang.String val$message;

        public AnonymousClass7(java.lang.String str, java.lang.String str2, com.aliyun.vod.log.core.AliyunLogger aliyunLogger) {
            this.val$code = str;
            this.val$message = str2;
            this.val$logger = aliyunLogger;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put(com.aliyun.vod.log.struct.AliyunLogKey.KEY_UPLOAD_PART_FAILED_CODE, this.val$code);
            hashMap.put(com.aliyun.vod.log.struct.AliyunLogKey.KEY_UPLOAD_PART_FAILED_MESSAGE, this.val$message);
            this.val$logger.pushLog(hashMap, "upload", "debug", "upload", "upload", 20004, "upload", com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.this.requestIDSession.getRequestID());
        }
    }

    /* renamed from: com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl$8, reason: invalid class name */
    public class AnonymousClass8 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$code;
        final /* synthetic */ com.aliyun.vod.log.core.AliyunLogger val$logger;
        final /* synthetic */ java.lang.String val$message;

        public AnonymousClass8(java.lang.String str, java.lang.String str2, com.aliyun.vod.log.core.AliyunLogger aliyunLogger) {
            this.val$code = str;
            this.val$message = str2;
            this.val$logger = aliyunLogger;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put(com.aliyun.vod.log.struct.AliyunLogKey.KEY_UPLOAD_PART_FAILED_CODE, this.val$code);
            hashMap.put(com.aliyun.vod.log.struct.AliyunLogKey.KEY_UPLOAD_PART_FAILED_MESSAGE, this.val$message);
            this.val$logger.pushLog(hashMap, "upload", "debug", "upload", "upload", 20006, "upload", com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.this.requestIDSession.getRequestID());
        }
    }

    /* renamed from: com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl$9, reason: invalid class name */
    public class AnonymousClass9 implements java.lang.Runnable {
        final /* synthetic */ com.aliyun.vod.log.core.AliyunLogger val$logger;

        public AnonymousClass9(com.aliyun.vod.log.core.AliyunLogger aliyunLogger) {
            this.val$logger = aliyunLogger;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$logger.pushLog(null, "upload", "debug", "upload", "upload", 20003, "upload", com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.this.requestIDSession.getRequestID());
        }
    }

    public OSSPutUploaderImpl(android.content.Context context) {
        this.context = new java.lang.ref.WeakReference<>(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadFailedLogger(java.lang.String str, java.lang.String str2) {
        com.aliyun.vod.log.core.LogService logService;
        com.aliyun.vod.log.core.AliyunLogger logger = com.aliyun.vod.log.core.AliyunLoggerManager.getLogger(com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.class.getName());
        if (logger == null || (logService = logger.getLogService()) == null) {
            return;
        }
        logService.execute(new com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.AnonymousClass7(str, str2, logger));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadPartFailedLogger(java.lang.String str, java.lang.String str2) {
        com.aliyun.vod.log.core.LogService logService;
        com.aliyun.vod.log.core.AliyunLogger logger = com.aliyun.vod.log.core.AliyunLoggerManager.getLogger(com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.class.getName());
        if (logger == null || (logService = logger.getLogService()) == null) {
            return;
        }
        logService.execute(new com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.AnonymousClass8(str, str2, logger));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadSuccessedLogger() {
        com.aliyun.vod.log.core.LogService logService;
        com.aliyun.vod.log.core.AliyunLogger logger = com.aliyun.vod.log.core.AliyunLoggerManager.getLogger(com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.class.getName());
        if (logger == null || (logService = logger.getLogService()) == null) {
            return;
        }
        logService.execute(new com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.AnonymousClass9(logger));
    }

    public void asyncPutObjectFromLocalFile(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.alibaba.sdk.android.oss.model.PutObjectRequest putObjectRequest = com.aliyun.vod.common.utils.StringUtils.isUriPath(str3) ? new com.alibaba.sdk.android.oss.model.PutObjectRequest(str, str2, android.net.Uri.parse(str3)) : new com.alibaba.sdk.android.oss.model.PutObjectRequest(str, str2, str3);
        putObjectRequest.setProgressCallback(new com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.AnonymousClass2());
        this.task = this.oss.asyncPutObject(putObjectRequest, new com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.AnonymousClass3());
        this.uploadFileInfo.setStatus(com.alibaba.sdk.android.vod.upload.common.UploadStateType.UPLOADING);
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploader
    public void cancel() {
        if (this.oss == null) {
            return;
        }
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug(com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.class.getClass().getName(), "Resumeable Uploader Cancel");
        this.vodThreadService.execute(new com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.AnonymousClass4());
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploader
    public void init(com.alibaba.sdk.android.vod.upload.model.OSSConfig oSSConfig, com.alibaba.sdk.android.vod.upload.internal.OSSUploadListener oSSUploadListener) {
        this.config = oSSConfig;
        this.listener = oSSUploadListener;
        this.requestIDSession = com.alibaba.sdk.android.vod.upload.common.RequestIDSession.getInstance();
        this.vodThreadService = new com.aliyun.auth.core.VodThreadService(java.lang.String.valueOf(java.lang.System.currentTimeMillis()));
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploader
    public void pause() {
        com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo = this.uploadFileInfo;
        if (uploadFileInfo == null) {
            return;
        }
        com.alibaba.sdk.android.vod.upload.common.UploadStateType status = uploadFileInfo.getStatus();
        if (!com.alibaba.sdk.android.vod.upload.common.UploadStateType.UPLOADING.equals(status)) {
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[OSSUploader] - status: " + status + " cann't be pause!");
            return;
        }
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[OSSUploader] - pause...");
        this.uploadFileInfo.setStatus(com.alibaba.sdk.android.vod.upload.common.UploadStateType.PAUSING);
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug(com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.class.getClass().getName(), "Resumeable Uploader Pause");
        if (this.task == null) {
            return;
        }
        this.vodThreadService.execute(new com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.AnonymousClass5());
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploader
    public void resume() {
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug(com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.class.getClass().getName(), "Resumeable Uploader Resume");
        this.uploadFileInfo.setStatus(com.alibaba.sdk.android.vod.upload.common.UploadStateType.UPLOADING);
        this.vodThreadService.execute(new com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.AnonymousClass6());
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploader
    public void setOSSClientConfiguration(com.alibaba.sdk.android.oss.ClientConfiguration clientConfiguration) {
        com.alibaba.sdk.android.oss.ClientConfiguration clientConfiguration2 = new com.alibaba.sdk.android.oss.ClientConfiguration();
        this.clientConfig = clientConfiguration2;
        if (clientConfiguration == null) {
            clientConfiguration2.setMaxErrorRetry(Integer.MAX_VALUE);
            this.clientConfig.setSocketTimeout(com.alibaba.sdk.android.oss.ClientConfiguration.getDefaultConf().getSocketTimeout());
            this.clientConfig.setConnectionTimeout(com.alibaba.sdk.android.oss.ClientConfiguration.getDefaultConf().getSocketTimeout());
        } else {
            clientConfiguration2.setMaxErrorRetry(clientConfiguration.getMaxErrorRetry());
            this.clientConfig.setSocketTimeout(clientConfiguration.getSocketTimeout());
            this.clientConfig.setConnectionTimeout(clientConfiguration.getConnectionTimeout());
        }
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploader
    public void setRecordUploadProgressEnabled(boolean z) {
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploader
    public void start(com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo) throws java.io.FileNotFoundException {
        com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo2 = this.uploadFileInfo;
        if (uploadFileInfo2 != null && !uploadFileInfo.equals(uploadFileInfo2)) {
            uploadFileInfo.setStatus(com.alibaba.sdk.android.vod.upload.common.UploadStateType.INIT);
        }
        this.uploadFileInfo = uploadFileInfo;
        this.vodThreadService.execute(new com.alibaba.sdk.android.vod.upload.internal.OSSPutUploaderImpl.AnonymousClass1(uploadFileInfo));
    }
}
