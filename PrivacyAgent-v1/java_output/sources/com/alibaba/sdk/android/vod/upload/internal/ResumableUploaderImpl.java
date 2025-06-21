package com.alibaba.sdk.android.vod.upload.internal;

/* loaded from: classes.dex */
public class ResumableUploaderImpl implements com.alibaba.sdk.android.vod.upload.internal.OSSUploader {
    private static final int DEFAULT_PART_SIZE = 1048576;
    private com.alibaba.sdk.android.oss.ClientConfiguration clientConfig;
    private com.alibaba.sdk.android.vod.upload.model.OSSConfig config;
    private java.lang.ref.WeakReference<android.content.Context> context;
    private com.alibaba.sdk.android.vod.upload.internal.OSSUploadListener listener;
    private com.alibaba.sdk.android.oss.OSS oss;
    private com.alibaba.sdk.android.oss.model.OSSRequest ossRequest;
    private com.alibaba.sdk.android.oss.callback.OSSProgressCallback<com.alibaba.sdk.android.oss.model.ResumableUploadRequest> progressCallback;
    private com.alibaba.sdk.android.vod.upload.common.RequestIDSession requestIDSession;
    private com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.ResumableUploadRequest, com.alibaba.sdk.android.oss.model.ResumableUploadResult> resumableCallback;
    private com.alibaba.sdk.android.oss.internal.OSSAsyncTask rusumebleTask;
    private com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo;
    private com.aliyun.vod.log.report.AliyunUploadProgressReporter uploadProgressReporter;
    private com.aliyun.auth.core.VodThreadService vodThreadService;
    private java.lang.String domainRegion = null;
    private boolean recoredUploadProgressEnabled = true;
    private java.lang.String recordDirectory = getRecordDirectory();

    /* renamed from: com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl resumableUploaderImpl = com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this;
            resumableUploaderImpl.asycResumableUpload(resumableUploaderImpl.uploadFileInfo);
        }
    }

    /* renamed from: com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl$10, reason: invalid class name */
    public class AnonymousClass10 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$code;
        final /* synthetic */ com.aliyun.vod.log.core.AliyunLogger val$logger;
        final /* synthetic */ java.lang.String val$message;

        public AnonymousClass10(java.lang.String str, java.lang.String str2, com.aliyun.vod.log.core.AliyunLogger aliyunLogger) {
            this.val$code = str;
            this.val$message = str2;
            this.val$logger = aliyunLogger;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put(com.aliyun.vod.log.struct.AliyunLogKey.KEY_UPLOAD_PART_FAILED_CODE, this.val$code);
            hashMap.put(com.aliyun.vod.log.struct.AliyunLogKey.KEY_UPLOAD_PART_FAILED_MESSAGE, this.val$message);
            this.val$logger.pushLog(hashMap, "upload", "debug", "upload", "upload", 20004, "upload", com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.requestIDSession.getRequestID());
        }
    }

    /* renamed from: com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl$11, reason: invalid class name */
    public class AnonymousClass11 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$code;
        final /* synthetic */ com.aliyun.vod.log.core.AliyunLogger val$logger;
        final /* synthetic */ java.lang.String val$message;

        public AnonymousClass11(java.lang.String str, java.lang.String str2, com.aliyun.vod.log.core.AliyunLogger aliyunLogger) {
            this.val$code = str;
            this.val$message = str2;
            this.val$logger = aliyunLogger;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put(com.aliyun.vod.log.struct.AliyunLogKey.KEY_UPLOAD_PART_FAILED_CODE, this.val$code);
            hashMap.put(com.aliyun.vod.log.struct.AliyunLogKey.KEY_UPLOAD_PART_FAILED_MESSAGE, this.val$message);
            this.val$logger.pushLog(hashMap, "upload", "debug", "upload", "upload", 20006, "upload", com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.requestIDSession.getRequestID());
        }
    }

    /* renamed from: com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl resumableUploaderImpl = com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this;
                resumableUploaderImpl.start(resumableUploaderImpl.uploadFileInfo);
            } catch (java.io.FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.rusumebleTask.cancel();
        }
    }

    /* renamed from: com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.rusumebleTask.cancel();
            com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.uploadFileInfo.setStatus(com.alibaba.sdk.android.vod.upload.common.UploadStateType.CANCELED);
        }
    }

    /* renamed from: com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        final /* synthetic */ com.alibaba.sdk.android.vod.upload.model.UploadFileInfo val$fileInfo;
        final /* synthetic */ com.aliyun.vod.log.core.AliyunLogger val$logger;

        public AnonymousClass5(com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo, com.aliyun.vod.log.core.AliyunLogger aliyunLogger) {
            this.val$fileInfo = uploadFileInfo;
            this.val$logger = aliyunLogger;
        }

        @Override // java.lang.Runnable
        public void run() {
            android.graphics.Bitmap videoSize = com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.uploadFileInfo.getFileType() == 1 ? com.aliyun.vod.common.utils.FileUtils.getVideoSize(this.val$fileInfo.getFilePath()) : null;
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put(com.aliyun.vod.log.struct.AliyunLogKey.KEY_FILE_TYPE, com.aliyun.vod.common.utils.FileUtils.getMimeType(this.val$fileInfo.getFilePath()));
            hashMap.put(com.aliyun.vod.log.struct.AliyunLogKey.KEY_FILE_SIZE, java.lang.String.valueOf(new java.io.File(this.val$fileInfo.getFilePath()).length()));
            hashMap.put(com.aliyun.vod.log.struct.AliyunLogKey.KEY_FILE_WIDTH, videoSize == null ? "" : java.lang.String.valueOf(videoSize.getWidth()));
            hashMap.put(com.aliyun.vod.log.struct.AliyunLogKey.KEY_FILE_HEIGHT, videoSize != null ? java.lang.String.valueOf(videoSize.getHeight()) : "");
            hashMap.put("fm", com.aliyun.vod.common.utils.FileUtils.getMd5OfFile(this.val$fileInfo.getFilePath()));
            hashMap.put(com.aliyun.vod.log.struct.AliyunLogKey.KEY_PART_SIZE, java.lang.String.valueOf(com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.getPartSize(this.val$fileInfo)));
            hashMap.put(com.aliyun.vod.log.struct.AliyunLogKey.KEY_BUCKET, this.val$fileInfo.getBucket());
            hashMap.put("ok", this.val$fileInfo.getObject());
            this.val$logger.pushLog(hashMap, "upload", "debug", "upload", "upload", 20002, "upload", com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.requestIDSession.getRequestID());
        }
    }

    /* renamed from: com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl$6, reason: invalid class name */
    public class AnonymousClass6 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$filePath;
        final /* synthetic */ com.aliyun.vod.log.core.AliyunLogger val$logger;
        final /* synthetic */ boolean val$retryShouldNotify;
        final /* synthetic */ java.lang.String val$uploadId;

        public AnonymousClass6(java.lang.String str, java.lang.String str2, boolean z, com.aliyun.vod.log.core.AliyunLogger aliyunLogger) {
            this.val$uploadId = str;
            this.val$filePath = str2;
            this.val$retryShouldNotify = z;
            this.val$logger = aliyunLogger;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put("ui", this.val$uploadId);
            hashMap.put("pn", java.lang.String.valueOf(com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.getPartNum(this.val$filePath)));
            hashMap.put("pr", this.val$retryShouldNotify ? "0" : "1");
            this.val$logger.pushLog(hashMap, "upload", "debug", "upload", "upload", 20005, "upload", com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.requestIDSession.getRequestID());
        }
    }

    /* renamed from: com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl$7, reason: invalid class name */
    public class AnonymousClass7 implements java.lang.Runnable {
        final /* synthetic */ com.aliyun.vod.log.core.AliyunLogger val$logger;

        public AnonymousClass7(com.aliyun.vod.log.core.AliyunLogger aliyunLogger) {
            this.val$logger = aliyunLogger;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$logger.pushLog(null, "upload", "debug", "upload", "upload", 20007, "upload", com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.requestIDSession.getRequestID());
        }
    }

    /* renamed from: com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl$8, reason: invalid class name */
    public class AnonymousClass8 implements java.lang.Runnable {
        final /* synthetic */ com.aliyun.vod.log.core.AliyunLogger val$logger;

        public AnonymousClass8(com.aliyun.vod.log.core.AliyunLogger aliyunLogger) {
            this.val$logger = aliyunLogger;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$logger.pushLog(null, "upload", "debug", "upload", "upload", 20003, "upload", com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.requestIDSession.getRequestID());
        }
    }

    /* renamed from: com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl$9, reason: invalid class name */
    public class AnonymousClass9 implements java.lang.Runnable {
        final /* synthetic */ com.aliyun.vod.log.core.AliyunLogger val$logger;

        public AnonymousClass9(com.aliyun.vod.log.core.AliyunLogger aliyunLogger) {
            this.val$logger = aliyunLogger;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$logger.pushLog(null, "upload", "debug", "upload", "upload", 20008, "upload", com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.requestIDSession.getRequestID());
        }
    }

    public class OSSProgressCallbackImpl implements com.alibaba.sdk.android.oss.callback.OSSProgressCallback {
        public OSSProgressCallbackImpl() {
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSProgressCallback
        public void onProgress(java.lang.Object obj, long j, long j2) {
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[OSSUploader] - onProgress..." + ((100 * j) / j2));
            com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.listener.onUploadProgress(obj, j, j2);
            if (com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.uploadProgressReporter != null) {
                com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.uploadProgressReporter.setAuthTimestamp(java.lang.String.valueOf(java.lang.System.currentTimeMillis()));
                com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.uploadProgressReporter.setAuthInfo();
                com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.uploadProgressReporter.setUploadRatio(java.lang.Float.valueOf((j * 1.0f) / j2));
                if (obj instanceof com.alibaba.sdk.android.oss.model.ResumableUploadRequest) {
                    com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.uploadProgressReporter.setUploadId(((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) obj).getUploadId());
                    com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.uploadProgressReporter.setDonePartsCount(java.lang.Integer.valueOf((int) (j / (com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.config.getPartSize() == 0 ? 1048576L : com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.config.getPartSize()))));
                }
                if (com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.uploadFileInfo.getFileType() != 0) {
                    com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.uploadProgressReporter.pushUploadProgress(com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.config.getAccessKeySecret());
                }
            }
        }
    }

    public class ResumableCompletedCallbackImpl implements com.alibaba.sdk.android.oss.callback.OSSCompletedCallback {
        public ResumableCompletedCallbackImpl() {
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
        public void onFailure(com.alibaba.sdk.android.oss.model.OSSRequest oSSRequest, com.alibaba.sdk.android.oss.ClientException clientException, com.alibaba.sdk.android.oss.ServiceException serviceException) {
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[OSSUploader] - onFailure Enter");
            if (clientException != null) {
                com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[OSSUploader] - onFailure ClientException");
                if (clientException.isCanceledException().booleanValue()) {
                    com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[OSSUploader] - onFailure ClientException isCanceledException");
                    if (com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.uploadFileInfo.getStatus() != com.alibaba.sdk.android.vod.upload.common.UploadStateType.CANCELED) {
                        com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.uploadFileInfo.setStatus(com.alibaba.sdk.android.vod.upload.common.UploadStateType.PAUSED);
                        return;
                    }
                    return;
                }
                com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[OSSUploader] - onFailure..." + clientException.getMessage());
                com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.uploadFileInfo.setStatus(com.alibaba.sdk.android.vod.upload.common.UploadStateType.FAIlURE);
                com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.listener.onUploadFailed(com.alibaba.sdk.android.vod.upload.internal.UploaderErrorCode.CLIENT_EXCEPTION, clientException.toString());
                com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.uploadFailedLogger(com.alibaba.sdk.android.vod.upload.internal.UploaderErrorCode.CLIENT_EXCEPTION, clientException.toString());
                com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.uploadPartFailedLogger(com.alibaba.sdk.android.vod.upload.internal.UploaderErrorCode.CLIENT_EXCEPTION, clientException.toString());
                return;
            }
            if (serviceException != null) {
                com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[OSSUploader] - onFailure ServiceException " + serviceException.getStatusCode());
                if (com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.config != null) {
                    com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[OSSUploader] - onFailure ServiceException token" + com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.config.getSecrityToken());
                    com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[OSSUploader] - onFailure ServiceException id" + com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.config.getAccessKeyId());
                    com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[OSSUploader] - onFailure ServiceException secret" + com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.config.getAccessKeySecret());
                }
                if (serviceException.getStatusCode() != 403 || com.alibaba.sdk.android.vod.upload.common.utils.StringUtil.isEmpty(com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.config.getSecrityToken())) {
                    com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[OSSUploader] - onFailure ServiceException onUploadFailed");
                    com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[OSSUploader] - onFailure..." + serviceException.getErrorCode() + serviceException.getMessage());
                    com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.listener.onUploadFailed(serviceException.getErrorCode(), serviceException.getMessage());
                } else {
                    com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[OSSUploader] - onFailure ServiceException onUploadTokenExpired");
                    com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.listener.onUploadTokenExpired();
                }
                com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[OSSUploader] - onFailure ServiceException Done");
                com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.uploadPartFailedLogger(serviceException.getErrorCode(), serviceException.toString());
                com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.uploadFailedLogger(serviceException.getErrorCode(), serviceException.toString());
            }
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
        public void onSuccess(com.alibaba.sdk.android.oss.model.OSSRequest oSSRequest, com.alibaba.sdk.android.oss.model.OSSResult oSSResult) {
            com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.rusumebleTask.isCompleted();
            com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.uploadFileInfo.setStatus(com.alibaba.sdk.android.vod.upload.common.UploadStateType.SUCCESS);
            com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.listener.onUploadSucceed();
            com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.this.uploadSuccessedLogger();
        }
    }

    public ResumableUploaderImpl(android.content.Context context) {
        this.context = new java.lang.ref.WeakReference<>(context);
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("OSS_RECORD : " + this.recordDirectory);
        if (com.aliyun.vod.log.core.AliyunLoggerManager.isLoggerOpen()) {
            this.uploadProgressReporter = new com.aliyun.vod.log.report.AliyunUploadProgressReporter(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asycResumableUpload(com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo) {
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("VODSTS", "OSS:\n\nAccessKeyId:" + this.config.getAccessKeyId() + "\nAccessKeySecret:" + this.config.getAccessKeySecret() + "\nSecrityToken:" + this.config.getSecrityToken());
        this.oss = new com.alibaba.sdk.android.oss.OSSClient(this.context.get(), uploadFileInfo.getEndpoint(), this.config.getProvider(), this.clientConfig);
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("ResumeableUplaod", "BucketName:" + uploadFileInfo.getBucket() + "\nobject:" + uploadFileInfo.getObject() + "\nobject:" + uploadFileInfo.getFilePath());
        if (com.aliyun.vod.common.utils.StringUtils.isUriPath(uploadFileInfo.getFilePath())) {
            this.ossRequest = new com.alibaba.sdk.android.oss.model.ResumableUploadRequest(uploadFileInfo.getBucket(), uploadFileInfo.getObject(), android.net.Uri.parse(uploadFileInfo.getFilePath()), this.recordDirectory);
        } else {
            this.ossRequest = new com.alibaba.sdk.android.oss.model.ResumableUploadRequest(uploadFileInfo.getBucket(), uploadFileInfo.getObject(), uploadFileInfo.getFilePath(), this.recordDirectory);
        }
        ((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.ossRequest).setDeleteUploadOnCancelling(java.lang.Boolean.valueOf(!this.recoredUploadProgressEnabled));
        ((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.ossRequest).setProgressCallback(this.progressCallback);
        long partSize = this.config.getPartSize() == 0 ? 1048576L : this.config.getPartSize();
        java.io.File file = new java.io.File(uploadFileInfo.getFilePath());
        long fileLength = com.aliyun.vod.common.utils.FileUtils.getFileLength(this.context.get(), uploadFileInfo.getFilePath());
        if (fileLength / partSize > 5000) {
            partSize = fileLength / 4999;
        }
        ((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.ossRequest).setPartSize(partSize);
        com.aliyun.vod.log.report.AliyunUploadProgressReporter aliyunUploadProgressReporter = this.uploadProgressReporter;
        if (aliyunUploadProgressReporter != null) {
            aliyunUploadProgressReporter.setDomainRegion(this.domainRegion);
            this.uploadProgressReporter.setFileName(file.getName());
            this.uploadProgressReporter.setFileSize(java.lang.Long.valueOf(file.length()));
            this.uploadProgressReporter.setFileCreateTime(com.aliyun.vod.log.core.AliyunLogParam.generateTimestamp(file.lastModified()));
            this.uploadProgressReporter.setFileHash(com.alibaba.sdk.android.vod.upload.common.utils.MD5.calculateMD5(this.context.get(), uploadFileInfo.getFilePath()));
            this.uploadProgressReporter.setPartSize(java.lang.Long.valueOf(partSize));
            this.uploadProgressReporter.setTotalPart(java.lang.Integer.valueOf((int) (fileLength / partSize)));
            this.uploadProgressReporter.setVideoId(this.config.getVideoId());
            this.uploadProgressReporter.setUploadAddress(this.config.getUploadAddress());
        }
        this.rusumebleTask = this.oss.asyncResumableUpload((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.ossRequest, this.resumableCallback);
        this.uploadFileInfo.setStatus(com.alibaba.sdk.android.vod.upload.common.UploadStateType.UPLOADING);
        startUploadLogger(uploadFileInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getPartNum(java.lang.String str) {
        long length = new java.io.File(str).length() / (this.config.getPartSize() == 0 ? 1048576L : this.config.getPartSize());
        if (length > 5000) {
            return 4999L;
        }
        return length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getPartSize(com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo) {
        long partSize = this.config.getPartSize() == 0 ? 1048576L : this.config.getPartSize();
        long length = new java.io.File(uploadFileInfo.getFilePath()).length();
        return length / partSize > 5000 ? length / 4999 : partSize;
    }

    private java.lang.String getRecordDirectory() {
        return (("mounted".equals(android.os.Environment.getExternalStorageState()) || !android.os.Environment.isExternalStorageRemovable()) ? this.context.get().getApplicationContext().getExternalCacheDir().getPath() : this.context.get().getCacheDir().getPath()) + java.io.File.separator + "oss_record";
    }

    private void startUploadLogger(com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo) {
        com.aliyun.vod.log.core.AliyunLogger logger = com.aliyun.vod.log.core.AliyunLoggerManager.getLogger(com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.class.getName());
        if (logger != null) {
            logger.updateRequestID();
            com.aliyun.vod.log.core.LogService logService = logger.getLogService();
            if (logService != null) {
                logService.execute(new com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.AnonymousClass5(uploadFileInfo, logger));
            }
        }
    }

    private void startUploadPartLogger(java.lang.String str, java.lang.String str2, boolean z) {
        com.aliyun.vod.log.core.LogService logService;
        com.aliyun.vod.log.core.AliyunLogger logger = com.aliyun.vod.log.core.AliyunLoggerManager.getLogger(com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.class.getName());
        if (logger == null || (logService = logger.getLogService()) == null) {
            return;
        }
        logService.execute(new com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.AnonymousClass6(str, str2, z, logger));
    }

    private void uploadCancelLogger() {
        com.aliyun.vod.log.core.LogService logService;
        com.aliyun.vod.log.core.AliyunLogger logger = com.aliyun.vod.log.core.AliyunLoggerManager.getLogger(com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.class.getName());
        if (logger == null || (logService = logger.getLogService()) == null) {
            return;
        }
        logService.execute(new com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.AnonymousClass9(logger));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadFailedLogger(java.lang.String str, java.lang.String str2) {
        com.aliyun.vod.log.core.LogService logService;
        com.aliyun.vod.log.core.AliyunLogger logger = com.aliyun.vod.log.core.AliyunLoggerManager.getLogger(com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.class.getName());
        if (logger == null || (logService = logger.getLogService()) == null) {
            return;
        }
        logService.execute(new com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.AnonymousClass10(str, str2, logger));
    }

    private void uploadPartCompletedLogger() {
        com.aliyun.vod.log.core.LogService logService;
        com.aliyun.vod.log.core.AliyunLogger logger = com.aliyun.vod.log.core.AliyunLoggerManager.getLogger(com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.class.getName());
        if (logger == null || (logService = logger.getLogService()) == null) {
            return;
        }
        logService.execute(new com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.AnonymousClass7(logger));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadPartFailedLogger(java.lang.String str, java.lang.String str2) {
        com.aliyun.vod.log.core.LogService logService;
        com.aliyun.vod.log.core.AliyunLogger logger = com.aliyun.vod.log.core.AliyunLoggerManager.getLogger(com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.class.getName());
        if (logger == null || (logService = logger.getLogService()) == null) {
            return;
        }
        logService.execute(new com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.AnonymousClass11(str, str2, logger));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadSuccessedLogger() {
        com.aliyun.vod.log.core.LogService logService;
        com.aliyun.vod.log.core.AliyunLogger logger = com.aliyun.vod.log.core.AliyunLoggerManager.getLogger(com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.class.getName());
        if (logger == null || (logService = logger.getLogService()) == null) {
            return;
        }
        logService.execute(new com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.AnonymousClass8(logger));
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploader
    public void cancel() {
        if (this.oss == null || this.ossRequest == null) {
            return;
        }
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug(com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.class.getClass().getName(), "Resumeable Uploader Cancel");
        this.vodThreadService.execute(new com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.AnonymousClass4());
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploader
    public void init(com.alibaba.sdk.android.vod.upload.model.OSSConfig oSSConfig, com.alibaba.sdk.android.vod.upload.internal.OSSUploadListener oSSUploadListener) {
        this.config = oSSConfig;
        this.listener = oSSUploadListener;
        com.aliyun.vod.common.httpfinal.QupaiHttpFinal.getInstance().initOkHttpFinal();
        this.progressCallback = new com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.OSSProgressCallbackImpl();
        this.resumableCallback = new com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.ResumableCompletedCallbackImpl();
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
        if (com.alibaba.sdk.android.vod.upload.common.UploadStateType.UPLOADING.equals(status)) {
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[OSSUploader] - pause...");
            this.uploadFileInfo.setStatus(com.alibaba.sdk.android.vod.upload.common.UploadStateType.PAUSING);
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug(com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.class.getClass().getName(), "Resumeable Uploader Pause");
            this.vodThreadService.execute(new com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.AnonymousClass3());
            return;
        }
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[OSSUploader] - status: " + status + " cann't be pause!");
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploader
    public void resume() {
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug(com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.class.getClass().getName(), "Resumeable Uploader Resume");
        this.uploadFileInfo.setStatus(com.alibaba.sdk.android.vod.upload.common.UploadStateType.UPLOADING);
        this.vodThreadService.execute(new com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.AnonymousClass2());
    }

    public void setDomainRegion(java.lang.String str) {
        this.domainRegion = str;
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
        this.recoredUploadProgressEnabled = z;
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploader
    public void start(com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo) throws java.io.FileNotFoundException {
        java.io.File file = new java.io.File(this.recordDirectory);
        if (!file.exists() && !file.mkdirs()) {
            this.listener.onUploadFailed(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.PERMISSION_DENIED, "Create RecordDir Failed! Please Check Permission WRITE_EXTERNAL_STORAGE!");
            return;
        }
        com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo2 = this.uploadFileInfo;
        if (uploadFileInfo2 != null && !uploadFileInfo.equals(uploadFileInfo2)) {
            uploadFileInfo.setStatus(com.alibaba.sdk.android.vod.upload.common.UploadStateType.INIT);
        }
        this.uploadFileInfo = uploadFileInfo;
        this.vodThreadService.execute(new com.alibaba.sdk.android.vod.upload.internal.ResumableUploaderImpl.AnonymousClass1());
    }
}
