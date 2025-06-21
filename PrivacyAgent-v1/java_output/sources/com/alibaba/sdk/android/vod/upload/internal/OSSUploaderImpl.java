package com.alibaba.sdk.android.vod.upload.internal;

/* loaded from: classes.dex */
public class OSSUploaderImpl implements com.alibaba.sdk.android.vod.upload.internal.OSSUploader {
    private static final int RETRY_INTERVAL = 3000;
    private com.alibaba.sdk.android.oss.ClientConfiguration clientConfig;
    private com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.CompleteMultipartUploadRequest, com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult> completedCallback;
    private com.alibaba.sdk.android.vod.upload.model.OSSConfig config;
    private android.content.Context context;
    private int curPartNumber;
    private long currentPartSize;
    private com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.InitiateMultipartUploadRequest, com.alibaba.sdk.android.oss.model.InitiateMultipartUploadResult> initCallback;
    private com.alibaba.sdk.android.vod.upload.internal.OSSUploadListener listener;
    private com.alibaba.sdk.android.oss.OSS oss;
    private com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.UploadPartRequest, com.alibaba.sdk.android.oss.model.UploadPartResult> partCallback;
    private boolean retryShouldNotify;
    private com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo;
    private java.lang.String uploadId;
    private java.lang.Long uploadedSize;
    private java.util.List<com.alibaba.sdk.android.oss.model.PartETag> uploadedParts = new java.util.ArrayList();
    private final android.os.HandlerThread mHandleThread = new android.os.HandlerThread("UploadThread");
    private android.os.Handler mHandler = null;

    /* renamed from: com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.alibaba.sdk.android.vod.upload.model.UploadFileInfo val$uploadFileInfo;

        public AnonymousClass1(com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo) {
            this.val$uploadFileInfo = uploadFileInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[OSSUploader] - start Runnable");
            if (!this.val$uploadFileInfo.equals(com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadFileInfo)) {
                this.val$uploadFileInfo.setStatus(com.alibaba.sdk.android.vod.upload.common.UploadStateType.INIT);
            }
            com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadFileInfo = this.val$uploadFileInfo;
            com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl oSSUploaderImpl = com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this;
            oSSUploaderImpl.oss = new com.alibaba.sdk.android.oss.OSSClient(oSSUploaderImpl.context, this.val$uploadFileInfo.getEndpoint(), com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.config.getProvider(), com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.clientConfig);
            com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadedSize = -1L;
            com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.curPartNumber = 2;
            com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadedParts.clear();
            com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.retryShouldNotify = true;
            this.val$uploadFileInfo.setStatus(com.alibaba.sdk.android.vod.upload.common.UploadStateType.UPLOADING);
            com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.initMultiPartUpload();
        }
    }

    /* renamed from: com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl$10, reason: invalid class name */
    public class AnonymousClass10 implements java.lang.Runnable {
        final /* synthetic */ com.aliyun.vod.log.core.AliyunLogger val$logger;

        public AnonymousClass10(com.aliyun.vod.log.core.AliyunLogger aliyunLogger) {
            this.val$logger = aliyunLogger;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$logger.pushLog(null, "upload", "debug", "upload", "upload", 20007, "upload", null);
        }
    }

    /* renamed from: com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl$11, reason: invalid class name */
    public class AnonymousClass11 implements java.lang.Runnable {
        final /* synthetic */ com.aliyun.vod.log.core.AliyunLogger val$logger;

        public AnonymousClass11(com.aliyun.vod.log.core.AliyunLogger aliyunLogger) {
            this.val$logger = aliyunLogger;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$logger.pushLog(null, "upload", "debug", "upload", "upload", 20003, "upload", null);
        }
    }

    /* renamed from: com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl$12, reason: invalid class name */
    public class AnonymousClass12 implements java.lang.Runnable {
        final /* synthetic */ com.aliyun.vod.log.core.AliyunLogger val$logger;

        public AnonymousClass12(com.aliyun.vod.log.core.AliyunLogger aliyunLogger) {
            this.val$logger = aliyunLogger;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$logger.pushLog(null, "upload", "debug", "upload", "upload", 20008, "upload", null);
        }
    }

    /* renamed from: com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl$13, reason: invalid class name */
    public class AnonymousClass13 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$code;
        final /* synthetic */ com.aliyun.vod.log.core.AliyunLogger val$logger;
        final /* synthetic */ java.lang.String val$message;

        public AnonymousClass13(java.lang.String str, java.lang.String str2, com.aliyun.vod.log.core.AliyunLogger aliyunLogger) {
            this.val$code = str;
            this.val$message = str2;
            this.val$logger = aliyunLogger;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put(com.aliyun.vod.log.struct.AliyunLogKey.KEY_UPLOAD_PART_FAILED_CODE, this.val$code);
            hashMap.put(com.aliyun.vod.log.struct.AliyunLogKey.KEY_UPLOAD_PART_FAILED_MESSAGE, this.val$message);
            this.val$logger.pushLog(hashMap, "upload", "debug", "upload", "upload", 20004, "upload", null);
        }
    }

    /* renamed from: com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl$14, reason: invalid class name */
    public class AnonymousClass14 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$code;
        final /* synthetic */ com.aliyun.vod.log.core.AliyunLogger val$logger;
        final /* synthetic */ java.lang.String val$message;

        public AnonymousClass14(java.lang.String str, java.lang.String str2, com.aliyun.vod.log.core.AliyunLogger aliyunLogger) {
            this.val$code = str;
            this.val$message = str2;
            this.val$logger = aliyunLogger;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put(com.aliyun.vod.log.struct.AliyunLogKey.KEY_UPLOAD_PART_FAILED_CODE, this.val$code);
            hashMap.put(com.aliyun.vod.log.struct.AliyunLogKey.KEY_UPLOAD_PART_FAILED_MESSAGE, this.val$message);
            this.val$logger.pushLog(hashMap, "upload", "debug", "upload", "upload", 20006, "upload", null);
        }
    }

    /* renamed from: com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl$15, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass15 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$sdk$android$vod$upload$internal$OSSUploadRetryType;

        static {
            int[] iArr = new int[com.alibaba.sdk.android.vod.upload.internal.OSSUploadRetryType.values().length];
            $SwitchMap$com$alibaba$sdk$android$vod$upload$internal$OSSUploadRetryType = iArr;
            try {
                iArr[com.alibaba.sdk.android.vod.upload.internal.OSSUploadRetryType.ShouldRetry.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$sdk$android$vod$upload$internal$OSSUploadRetryType[com.alibaba.sdk.android.vod.upload.internal.OSSUploadRetryType.ShouldGetSTS.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$sdk$android$vod$upload$internal$OSSUploadRetryType[com.alibaba.sdk.android.vod.upload.internal.OSSUploadRetryType.ShouldNotRetry.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
        }
    }

    /* renamed from: com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[OSSUploader] - This task is cancelled!");
            com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadPartFailedLogger(com.alibaba.sdk.android.vod.upload.common.UploadStateType.CANCELED.toString(), "This task is user cancelled!");
            com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.abortUpload();
            com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.release();
        }
    }

    /* renamed from: com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ com.alibaba.sdk.android.vod.upload.common.UploadStateType val$status;

        public AnonymousClass3(com.alibaba.sdk.android.vod.upload.common.UploadStateType uploadStateType) {
            this.val$status = uploadStateType;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[OSSUploader] - resume Runnable");
            if (com.alibaba.sdk.android.vod.upload.common.UploadStateType.PAUSING.equals(this.val$status)) {
                com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadFileInfo.setStatus(com.alibaba.sdk.android.vod.upload.common.UploadStateType.UPLOADING);
                return;
            }
            if (com.alibaba.sdk.android.vod.upload.common.UploadStateType.PAUSED.equals(this.val$status)) {
                com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadFileInfo.setStatus(com.alibaba.sdk.android.vod.upload.common.UploadStateType.UPLOADING);
                if (com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadedSize.longValue() == -1) {
                    com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.initMultiPartUpload();
                } else if (com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.curPartNumber != -1) {
                    com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadPart();
                } else {
                    com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.completeMultiPartUpload();
                }
            }
        }
    }

    /* renamed from: com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[OSSUploader] - initMultiPartUpload");
            com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl oSSUploaderImpl = com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this;
            oSSUploaderImpl.startUploadLogger(oSSUploaderImpl.uploadFileInfo);
            com.alibaba.sdk.android.oss.model.InitiateMultipartUploadRequest initiateMultipartUploadRequest = new com.alibaba.sdk.android.oss.model.InitiateMultipartUploadRequest(com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadFileInfo.getBucket(), com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadFileInfo.getObject());
            try {
                com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.initCallback.onSuccess(initiateMultipartUploadRequest, com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.oss.initMultipartUpload(initiateMultipartUploadRequest));
            } catch (com.alibaba.sdk.android.oss.ClientException e) {
                com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.initCallback.onFailure(initiateMultipartUploadRequest, e, null);
            } catch (com.alibaba.sdk.android.oss.ServiceException e2) {
                com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.initCallback.onFailure(initiateMultipartUploadRequest, null, e2);
            }
        }
    }

    /* renamed from: com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        public AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[OSSUploader] - completeMultiPartUpload");
            com.alibaba.sdk.android.oss.model.CompleteMultipartUploadRequest completeMultipartUploadRequest = new com.alibaba.sdk.android.oss.model.CompleteMultipartUploadRequest(com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadFileInfo.getBucket(), com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadFileInfo.getObject(), com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadId, com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadedParts);
            com.alibaba.sdk.android.oss.model.ObjectMetadata metadata = completeMultipartUploadRequest.getMetadata();
            if (metadata == null) {
                metadata = new com.alibaba.sdk.android.oss.model.ObjectMetadata();
            }
            if (com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadFileInfo.getVodInfo() != null) {
                metadata.addUserMetadata("x-oss-notification", com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadFileInfo.getVodInfo().toVodJsonStringWithBase64());
            }
            completeMultipartUploadRequest.setMetadata(metadata);
            try {
                com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.completedCallback.onSuccess(completeMultipartUploadRequest, com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.oss.completeMultipartUpload(completeMultipartUploadRequest));
            } catch (com.alibaba.sdk.android.oss.ClientException e) {
                com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.completedCallback.onFailure(completeMultipartUploadRequest, e, null);
                e.printStackTrace();
            } catch (com.alibaba.sdk.android.oss.ServiceException e2) {
                com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.completedCallback.onFailure(completeMultipartUploadRequest, null, e2);
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl$6, reason: invalid class name */
    public class AnonymousClass6 implements java.lang.Runnable {

        /* renamed from: com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl$6$1, reason: invalid class name */
        public class AnonymousClass1 implements com.alibaba.sdk.android.oss.callback.OSSProgressCallback<com.alibaba.sdk.android.oss.model.UploadPartRequest> {
            public AnonymousClass1() {
            }

            @Override // com.alibaba.sdk.android.oss.callback.OSSProgressCallback
            public void onProgress(com.alibaba.sdk.android.oss.model.UploadPartRequest uploadPartRequest, long j, long j2) {
                com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.listener.onUploadProgress(uploadPartRequest, com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadedSize.longValue() + j, com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadFileInfo.getFileLength());
            }
        }

        public AnonymousClass6() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x00b5, code lost:
        
            if (r5 == null) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x00b7, code lost:
        
            r5.release();
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00e6, code lost:
        
            if (r5 == null) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00d5, code lost:
        
            if (r5 == null) goto L38;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:59:0x0134 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:65:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:66:0x012d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r4v1, types: [int] */
        /* JADX WARN: Type inference failed for: r4v2 */
        /* JADX WARN: Type inference failed for: r4v3 */
        /* JADX WARN: Type inference failed for: r4v4 */
        /* JADX WARN: Type inference failed for: r4v5, types: [java.io.RandomAccessFile] */
        /* JADX WARN: Type inference failed for: r4v6, types: [java.io.RandomAccessFile] */
        /* JADX WARN: Type inference failed for: r4v8, types: [java.io.RandomAccessFile] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            com.alibaba.sdk.android.vod.upload.model.FilePartInfo filePartInfo;
            java.nio.channels.FileLock fileLock;
            java.nio.channels.FileLock fileLock2;
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[OSSUploader] - uploadPart PartNumber:" + com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.curPartNumber);
            java.lang.String bucket = com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadFileInfo.getBucket();
            java.lang.String object = com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadFileInfo.getObject();
            java.lang.String str = com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadId;
            ?? r4 = com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.curPartNumber;
            com.alibaba.sdk.android.oss.model.UploadPartRequest uploadPartRequest = new com.alibaba.sdk.android.oss.model.UploadPartRequest(bucket, object, str, r4);
            if (com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadFileInfo.getPartInfoList().size() < com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.curPartNumber) {
                com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadFileInfo.setStatus(com.alibaba.sdk.android.vod.upload.common.UploadStateType.PAUSED);
                return;
            }
            filePartInfo = com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadFileInfo.getPartInfoList().get(com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.curPartNumber - 1);
            byte[] bArr = new byte[(int) filePartInfo.getSize()];
            java.io.RandomAccessFile randomAccessFile = null;
            try {
                try {
                    r4 = new java.io.RandomAccessFile(com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadFileInfo.getFilePath(), "r");
                } catch (java.lang.Throwable th) {
                    th = th;
                }
            } catch (java.io.FileNotFoundException unused) {
                r4 = 0;
                fileLock2 = null;
            } catch (java.io.IOException unused2) {
                r4 = 0;
                fileLock2 = null;
            } catch (java.lang.Throwable th2) {
                th = th2;
                fileLock = null;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (java.io.IOException unused3) {
                    }
                }
                if (fileLock != null) {
                    throw th;
                }
                try {
                    fileLock.release();
                    throw th;
                } catch (java.io.IOException unused4) {
                    throw th;
                }
            }
            try {
                fileLock2 = r4.getChannel().lock(filePartInfo.getSeek(), filePartInfo.getSize(), true);
                try {
                    r4.seek(filePartInfo.getSeek());
                    r4.read(bArr);
                    uploadPartRequest.setPartContent(bArr);
                    try {
                        r4.close();
                    } catch (java.io.IOException unused5) {
                    }
                } catch (java.io.FileNotFoundException unused6) {
                    com.alibaba.sdk.android.oss.common.OSSLog.logError("[OSSUploader] - uploadPart RandomAccessFile FileNotFoundException");
                    if (r4 != 0) {
                        try {
                            r4.close();
                        } catch (java.io.IOException unused7) {
                        }
                    }
                } catch (java.io.IOException unused8) {
                    com.alibaba.sdk.android.oss.common.OSSLog.logError("[OSSUploader] - uploadPart RandomAccessFile IOException");
                    if (r4 != 0) {
                        try {
                            r4.close();
                        } catch (java.io.IOException unused9) {
                        }
                    }
                }
            } catch (java.io.FileNotFoundException unused10) {
                fileLock2 = null;
            } catch (java.io.IOException unused11) {
                fileLock2 = null;
            } catch (java.lang.Throwable th3) {
                th = th3;
                fileLock = null;
                randomAccessFile = r4;
                if (randomAccessFile != null) {
                }
                if (fileLock != null) {
                }
            }
            com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.currentPartSize = filePartInfo.getSize();
            uploadPartRequest.setProgressCallback(new com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.AnonymousClass6.AnonymousClass1());
            try {
                com.alibaba.sdk.android.oss.model.UploadPartResult uploadPart = com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.oss.uploadPart(uploadPartRequest);
                com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.startUploadPartLogger();
                com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.partCallback.onSuccess(uploadPartRequest, uploadPart);
            } catch (com.alibaba.sdk.android.oss.ClientException e) {
                com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.partCallback.onFailure(uploadPartRequest, e, null);
            } catch (com.alibaba.sdk.android.oss.ServiceException e2) {
                com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.partCallback.onFailure(uploadPartRequest, null, e2);
            }
        }
    }

    /* renamed from: com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl$7, reason: invalid class name */
    public class AnonymousClass7 implements java.lang.Runnable {
        final /* synthetic */ com.alibaba.sdk.android.oss.model.OSSRequest val$request;

        public AnonymousClass7(com.alibaba.sdk.android.oss.model.OSSRequest oSSRequest) {
            this.val$request = oSSRequest;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.alibaba.sdk.android.oss.model.OSSRequest oSSRequest = this.val$request;
                if (oSSRequest instanceof com.alibaba.sdk.android.oss.model.InitiateMultipartUploadRequest) {
                    com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.initCallback.onSuccess((com.alibaba.sdk.android.oss.model.InitiateMultipartUploadRequest) this.val$request, com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.oss.initMultipartUpload((com.alibaba.sdk.android.oss.model.InitiateMultipartUploadRequest) this.val$request));
                } else if (oSSRequest instanceof com.alibaba.sdk.android.oss.model.CompleteMultipartUploadRequest) {
                    com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.completedCallback.onSuccess((com.alibaba.sdk.android.oss.model.CompleteMultipartUploadRequest) this.val$request, com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.oss.completeMultipartUpload((com.alibaba.sdk.android.oss.model.CompleteMultipartUploadRequest) this.val$request));
                } else if (oSSRequest instanceof com.alibaba.sdk.android.oss.model.UploadPartRequest) {
                    com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.partCallback.onSuccess((com.alibaba.sdk.android.oss.model.UploadPartRequest) this.val$request, com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.oss.uploadPart((com.alibaba.sdk.android.oss.model.UploadPartRequest) this.val$request));
                }
            } catch (com.alibaba.sdk.android.oss.ClientException e) {
                com.alibaba.sdk.android.oss.model.OSSRequest oSSRequest2 = this.val$request;
                if (oSSRequest2 instanceof com.alibaba.sdk.android.oss.model.InitiateMultipartUploadRequest) {
                    com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.initCallback.onFailure((com.alibaba.sdk.android.oss.model.InitiateMultipartUploadRequest) this.val$request, e, null);
                } else if (oSSRequest2 instanceof com.alibaba.sdk.android.oss.model.CompleteMultipartUploadRequest) {
                    com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.completedCallback.onFailure((com.alibaba.sdk.android.oss.model.CompleteMultipartUploadRequest) this.val$request, e, null);
                } else if (oSSRequest2 instanceof com.alibaba.sdk.android.oss.model.UploadPartRequest) {
                    com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.partCallback.onFailure((com.alibaba.sdk.android.oss.model.UploadPartRequest) this.val$request, e, null);
                }
            } catch (com.alibaba.sdk.android.oss.ServiceException e2) {
                com.alibaba.sdk.android.oss.model.OSSRequest oSSRequest3 = this.val$request;
                if (oSSRequest3 instanceof com.alibaba.sdk.android.oss.model.InitiateMultipartUploadRequest) {
                    com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.initCallback.onFailure((com.alibaba.sdk.android.oss.model.InitiateMultipartUploadRequest) this.val$request, null, e2);
                } else if (oSSRequest3 instanceof com.alibaba.sdk.android.oss.model.CompleteMultipartUploadRequest) {
                    com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.completedCallback.onFailure((com.alibaba.sdk.android.oss.model.CompleteMultipartUploadRequest) this.val$request, null, e2);
                } else if (oSSRequest3 instanceof com.alibaba.sdk.android.oss.model.UploadPartRequest) {
                    com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.partCallback.onFailure((com.alibaba.sdk.android.oss.model.UploadPartRequest) this.val$request, null, e2);
                }
            }
        }
    }

    /* renamed from: com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl$8, reason: invalid class name */
    public class AnonymousClass8 implements java.lang.Runnable {
        final /* synthetic */ com.alibaba.sdk.android.vod.upload.model.UploadFileInfo val$fileInfo;
        final /* synthetic */ com.aliyun.vod.log.core.AliyunLogger val$logger;

        public AnonymousClass8(com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo, com.aliyun.vod.log.core.AliyunLogger aliyunLogger) {
            this.val$fileInfo = uploadFileInfo;
            this.val$logger = aliyunLogger;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put(com.aliyun.vod.log.struct.AliyunLogKey.KEY_BUCKET, this.val$fileInfo.getBucket());
            hashMap.put("ok", this.val$fileInfo.getObject());
            this.val$logger.pushLog(hashMap, "upload", "debug", "upload", "upload", 20002, "upload", null);
        }
    }

    /* renamed from: com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl$9, reason: invalid class name */
    public class AnonymousClass9 implements java.lang.Runnable {
        final /* synthetic */ com.aliyun.vod.log.core.AliyunLogger val$logger;

        public AnonymousClass9(com.aliyun.vod.log.core.AliyunLogger aliyunLogger) {
            this.val$logger = aliyunLogger;
        }

        @Override // java.lang.Runnable
        public void run() {
            java.util.HashMap hashMap = new java.util.HashMap();
            hashMap.put("ui", com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadId);
            hashMap.put("pn", java.lang.String.valueOf(com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.curPartNumber));
            hashMap.put("pr", com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.retryShouldNotify ? "0" : "1");
            this.val$logger.pushLog(hashMap, "upload", "debug", "upload", "upload", 20005, "upload", null);
        }
    }

    public class OSSCompletedCallbackImpl implements com.alibaba.sdk.android.oss.callback.OSSCompletedCallback {
        public OSSCompletedCallbackImpl() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
        public void onFailure(com.alibaba.sdk.android.oss.model.OSSRequest oSSRequest, com.alibaba.sdk.android.oss.ClientException clientException, com.alibaba.sdk.android.oss.ServiceException serviceException) {
            com.alibaba.sdk.android.vod.upload.common.UploadStateType status = com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadFileInfo.getStatus();
            com.alibaba.sdk.android.oss.ClientException clientException2 = clientException != null ? clientException : serviceException != 0 ? serviceException : null;
            if (clientException2 == null) {
                com.alibaba.sdk.android.oss.common.OSSLog.logError("onFailure error: exception is null.");
                return;
            }
            if (com.alibaba.sdk.android.vod.upload.common.UploadStateType.CANCELED.equals(status)) {
                com.alibaba.sdk.android.oss.common.OSSLog.logError("onFailure error: upload has been canceled, ignore notify.");
                com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadCancelLogger();
                return;
            }
            int i = com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.AnonymousClass15.$SwitchMap$com$alibaba$sdk$android$vod$upload$internal$OSSUploadRetryType[com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.shouldRetry(clientException2).ordinal()];
            if (i == 1) {
                if (com.alibaba.sdk.android.vod.upload.common.UploadStateType.PAUSING.equals(status)) {
                    com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[OSSUploader] - This task is pausing!");
                    com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadFileInfo.setStatus(com.alibaba.sdk.android.vod.upload.common.UploadStateType.PAUSED);
                    return;
                }
                try {
                    java.lang.Thread.sleep(3000L);
                } catch (java.lang.InterruptedException e) {
                    e.printStackTrace();
                }
                com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.onRetry(oSSRequest);
                if (com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.retryShouldNotify) {
                    if (clientException != null) {
                        com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.listener.onUploadRetry(com.alibaba.sdk.android.vod.upload.internal.UploaderErrorCode.CLIENT_EXCEPTION, clientException.toString());
                        if (oSSRequest instanceof com.alibaba.sdk.android.oss.model.UploadPartRequest) {
                            com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadPartFailedLogger(com.alibaba.sdk.android.vod.upload.internal.UploaderErrorCode.CLIENT_EXCEPTION, clientException.getMessage().toString());
                        } else {
                            com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadFailedLogger(com.alibaba.sdk.android.vod.upload.internal.UploaderErrorCode.CLIENT_EXCEPTION, clientException.getMessage().toString());
                        }
                    } else if (serviceException != 0) {
                        com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.listener.onUploadRetry(serviceException.getErrorCode(), serviceException.getMessage());
                        if (oSSRequest instanceof com.alibaba.sdk.android.oss.model.UploadPartRequest) {
                            com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadPartFailedLogger(serviceException.getErrorCode(), serviceException.getMessage());
                        } else {
                            com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadFailedLogger(serviceException.getErrorCode(), serviceException.getMessage());
                        }
                    }
                    com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.retryShouldNotify = false;
                    return;
                }
                return;
            }
            if (i == 2) {
                com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadFileInfo.setStatus(com.alibaba.sdk.android.vod.upload.common.UploadStateType.PAUSED);
                com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.listener.onUploadTokenExpired();
                com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadFailedLogger(com.alibaba.sdk.android.vod.upload.exception.VODErrorCode.UPLOAD_EXPIRED, "Upload Token Expired");
                return;
            }
            if (i != 3) {
                return;
            }
            com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadFileInfo.setStatus(com.alibaba.sdk.android.vod.upload.common.UploadStateType.FAIlURE);
            if (clientException != null) {
                com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.listener.onUploadFailed(com.alibaba.sdk.android.vod.upload.internal.UploaderErrorCode.CLIENT_EXCEPTION, clientException.toString());
                if (oSSRequest instanceof com.alibaba.sdk.android.oss.model.UploadPartRequest) {
                    com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadPartFailedLogger(com.alibaba.sdk.android.vod.upload.internal.UploaderErrorCode.CLIENT_EXCEPTION, clientException.getMessage().toString());
                    return;
                } else {
                    com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadFailedLogger(com.alibaba.sdk.android.vod.upload.internal.UploaderErrorCode.CLIENT_EXCEPTION, clientException.getMessage().toString());
                    return;
                }
            }
            if (serviceException != 0) {
                com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.listener.onUploadFailed(serviceException.getErrorCode(), serviceException.getMessage());
                if (oSSRequest instanceof com.alibaba.sdk.android.oss.model.UploadPartRequest) {
                    com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadPartFailedLogger(serviceException.getErrorCode(), serviceException.getMessage());
                } else {
                    com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadFailedLogger(serviceException.getErrorCode(), serviceException.getMessage());
                }
            }
        }

        @Override // com.alibaba.sdk.android.oss.callback.OSSCompletedCallback
        public void onSuccess(com.alibaba.sdk.android.oss.model.OSSRequest oSSRequest, com.alibaba.sdk.android.oss.model.OSSResult oSSResult) {
            com.alibaba.sdk.android.vod.upload.common.UploadStateType status = com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadFileInfo.getStatus();
            com.alibaba.sdk.android.vod.upload.common.UploadStateType uploadStateType = com.alibaba.sdk.android.vod.upload.common.UploadStateType.CANCELED;
            if (uploadStateType.equals(status)) {
                com.alibaba.sdk.android.oss.common.OSSLog.logError("onSuccess: upload has been canceled, ignore notify.");
                com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadCancelLogger();
                return;
            }
            if (!com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.retryShouldNotify) {
                com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.listener.onUploadRetryResume();
                com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.retryShouldNotify = true;
            }
            if (oSSResult instanceof com.alibaba.sdk.android.oss.model.InitiateMultipartUploadResult) {
                com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadId = ((com.alibaba.sdk.android.oss.model.InitiateMultipartUploadResult) oSSResult).getUploadId();
                com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[OSSUploader] - InitiateMultipartUploadResult uploadId:" + com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadId);
                com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadedSize = 0L;
                com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadPart();
                return;
            }
            if (!(oSSResult instanceof com.alibaba.sdk.android.oss.model.UploadPartResult)) {
                if (oSSResult instanceof com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult) {
                    com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[OSSUploader] - CompleteMultipartUploadResult onSuccess ------------------");
                    com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadFileInfo.setStatus(com.alibaba.sdk.android.vod.upload.common.UploadStateType.SUCCESS);
                    com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.listener.onUploadSucceed();
                    com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadSuccessedLogger();
                    com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.release();
                    return;
                }
                return;
            }
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[OSSUploader] - UploadPartResult onSuccess ------------------" + ((com.alibaba.sdk.android.oss.model.UploadPartRequest) oSSRequest).getPartNumber());
            com.alibaba.sdk.android.oss.model.UploadPartResult uploadPartResult = (com.alibaba.sdk.android.oss.model.UploadPartResult) oSSResult;
            if (com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.curPartNumber == 1) {
                com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadedParts.add(0, new com.alibaba.sdk.android.oss.model.PartETag(com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.curPartNumber, uploadPartResult.getETag()));
            } else {
                com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadedParts.add(new com.alibaba.sdk.android.oss.model.PartETag(com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.curPartNumber, uploadPartResult.getETag()));
            }
            com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl oSSUploaderImpl = com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this;
            oSSUploaderImpl.uploadedSize = java.lang.Long.valueOf(oSSUploaderImpl.uploadedSize.longValue() + com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.currentPartSize);
            com.alibaba.sdk.android.vod.upload.model.FilePartInfo filePartInfo = com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadFileInfo.getPartInfoList().get(com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.curPartNumber - 1);
            if (com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.curPartNumber == 1) {
                com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.curPartNumber = -1;
            } else if (com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadFileInfo.getFileLength() == -1 || com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadFileInfo.getFileLength() != filePartInfo.getSeek() + filePartInfo.getSize()) {
                com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.access$608(com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this);
            } else {
                com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.curPartNumber = 1;
            }
            com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadPartCompletedLogger();
            if (uploadStateType.equals(status)) {
                return;
            }
            if (com.alibaba.sdk.android.vod.upload.common.UploadStateType.UPLOADING.equals(status)) {
                if (com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.curPartNumber == -1) {
                    com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.completeMultiPartUpload();
                    return;
                } else {
                    com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadPart();
                    return;
                }
            }
            if (com.alibaba.sdk.android.vod.upload.common.UploadStateType.PAUSING.equals(status)) {
                com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[OSSUploader] - This task is pausing!");
                com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.this.uploadFileInfo.setStatus(com.alibaba.sdk.android.vod.upload.common.UploadStateType.PAUSED);
            }
        }
    }

    public OSSUploaderImpl(android.content.Context context) {
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abortUpload() {
        if (this.uploadId != null) {
            try {
                this.oss.abortMultipartUpload(new com.alibaba.sdk.android.oss.model.AbortMultipartUploadRequest(this.uploadFileInfo.getBucket(), this.uploadFileInfo.getObject(), this.uploadId));
            } catch (com.alibaba.sdk.android.oss.ClientException e) {
                com.alibaba.sdk.android.oss.common.OSSLog.logWarn("[OSSUploader] - abort ClientException!code:" + e.getCause() + ", message:" + e.getMessage());
            } catch (com.alibaba.sdk.android.oss.ServiceException e2) {
                com.alibaba.sdk.android.oss.common.OSSLog.logWarn("[OSSUploader] - abort ServiceException!code:" + e2.getCause() + ", message:" + e2.getMessage());
            }
        }
    }

    public static /* synthetic */ int access$608(com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl oSSUploaderImpl) {
        int i = oSSUploaderImpl.curPartNumber;
        oSSUploaderImpl.curPartNumber = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void completeMultiPartUpload() {
        getHandler().post(new com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.AnonymousClass5());
    }

    private android.os.Handler getHandler() {
        if (this.mHandler == null) {
            this.mHandleThread.start();
            this.mHandler = new android.os.Handler(this.mHandleThread.getLooper());
        }
        return this.mHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initMultiPartUpload() {
        getHandler().post(new com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.AnonymousClass4());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRetry(com.alibaba.sdk.android.oss.model.OSSRequest oSSRequest) {
        getHandler().post(new com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.AnonymousClass7(oSSRequest));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        if (this.mHandler != null) {
            this.mHandleThread.quit();
            this.mHandler = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startUploadLogger(com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo) {
        com.aliyun.vod.log.core.AliyunLogger logger = com.aliyun.vod.log.core.AliyunLoggerManager.getLogger(com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.class.getName());
        if (logger != null) {
            logger.updateRequestID();
            com.aliyun.vod.log.core.LogService logService = logger.getLogService();
            if (logService != null) {
                logService.execute(new com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.AnonymousClass8(uploadFileInfo, logger));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startUploadPartLogger() {
        com.aliyun.vod.log.core.LogService logService;
        com.aliyun.vod.log.core.AliyunLogger logger = com.aliyun.vod.log.core.AliyunLoggerManager.getLogger(com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.class.getName());
        if (logger == null || (logService = logger.getLogService()) == null) {
            return;
        }
        logService.execute(new com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.AnonymousClass9(logger));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadCancelLogger() {
        com.aliyun.vod.log.core.LogService logService;
        com.aliyun.vod.log.core.AliyunLogger logger = com.aliyun.vod.log.core.AliyunLoggerManager.getLogger(com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.class.getName());
        if (logger == null || (logService = logger.getLogService()) == null) {
            return;
        }
        logService.execute(new com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.AnonymousClass12(logger));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadFailedLogger(java.lang.String str, java.lang.String str2) {
        com.aliyun.vod.log.core.LogService logService;
        com.aliyun.vod.log.core.AliyunLogger logger = com.aliyun.vod.log.core.AliyunLoggerManager.getLogger(com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.class.getName());
        if (logger == null || (logService = logger.getLogService()) == null) {
            return;
        }
        logService.execute(new com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.AnonymousClass13(str, str2, logger));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadPart() {
        getHandler().post(new com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.AnonymousClass6());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadPartCompletedLogger() {
        com.aliyun.vod.log.core.LogService logService;
        com.aliyun.vod.log.core.AliyunLogger logger = com.aliyun.vod.log.core.AliyunLoggerManager.getLogger(com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.class.getName());
        if (logger == null || (logService = logger.getLogService()) == null) {
            return;
        }
        logService.execute(new com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.AnonymousClass10(logger));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadPartFailedLogger(java.lang.String str, java.lang.String str2) {
        com.aliyun.vod.log.core.LogService logService;
        com.aliyun.vod.log.core.AliyunLogger logger = com.aliyun.vod.log.core.AliyunLoggerManager.getLogger(com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.class.getName());
        if (logger == null || (logService = logger.getLogService()) == null) {
            return;
        }
        logService.execute(new com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.AnonymousClass14(str, str2, logger));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadSuccessedLogger() {
        com.aliyun.vod.log.core.LogService logService;
        com.aliyun.vod.log.core.AliyunLogger logger = com.aliyun.vod.log.core.AliyunLoggerManager.getLogger(com.alibaba.sdk.android.vod.upload.VODUploadClientImpl.class.getName());
        if (logger == null || (logService = logger.getLogService()) == null) {
            return;
        }
        logService.execute(new com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.AnonymousClass11(logger));
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploader
    public void cancel() {
        com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo = this.uploadFileInfo;
        if (uploadFileInfo == null) {
            return;
        }
        com.alibaba.sdk.android.vod.upload.common.UploadStateType status = uploadFileInfo.getStatus();
        if (com.alibaba.sdk.android.vod.upload.common.UploadStateType.INIT.equals(status) || com.alibaba.sdk.android.vod.upload.common.UploadStateType.UPLOADING.equals(status) || com.alibaba.sdk.android.vod.upload.common.UploadStateType.PAUSED.equals(status) || com.alibaba.sdk.android.vod.upload.common.UploadStateType.PAUSING.equals(status)) {
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[OSSUploader] - cancel...");
            this.uploadFileInfo.setStatus(com.alibaba.sdk.android.vod.upload.common.UploadStateType.CANCELED);
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler.post(new com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.AnonymousClass2());
            return;
        }
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[OSSUploader] - status: " + status + " cann't be cancel!");
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploader
    public void init(com.alibaba.sdk.android.vod.upload.model.OSSConfig oSSConfig, com.alibaba.sdk.android.vod.upload.internal.OSSUploadListener oSSUploadListener) {
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[OSSUploader] - init...");
        this.config = oSSConfig;
        this.listener = oSSUploadListener;
        com.aliyun.vod.common.httpfinal.QupaiHttpFinal.getInstance().initOkHttpFinal();
        this.initCallback = new com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.OSSCompletedCallbackImpl();
        this.partCallback = new com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.OSSCompletedCallbackImpl();
        this.completedCallback = new com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.OSSCompletedCallbackImpl();
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploader
    public void pause() {
        com.alibaba.sdk.android.vod.upload.common.UploadStateType status = this.uploadFileInfo.getStatus();
        if (com.alibaba.sdk.android.vod.upload.common.UploadStateType.UPLOADING.equals(status)) {
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[OSSUploader] - pause...");
            this.uploadFileInfo.setStatus(com.alibaba.sdk.android.vod.upload.common.UploadStateType.PAUSING);
            return;
        }
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[OSSUploader] - status: " + status + " cann't be pause!");
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploader
    public void resume() {
        com.alibaba.sdk.android.vod.upload.common.UploadStateType status = this.uploadFileInfo.getStatus();
        if (com.alibaba.sdk.android.vod.upload.common.UploadStateType.PAUSING.equals(status) || com.alibaba.sdk.android.vod.upload.common.UploadStateType.PAUSED.equals(status)) {
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[OSSUploader] - resume...");
            getHandler().post(new com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.AnonymousClass3(status));
            return;
        }
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[OSSUploader] - status: " + status + " cann't be resume!");
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

    public com.alibaba.sdk.android.vod.upload.internal.OSSUploadRetryType shouldRetry(java.lang.Exception exc) {
        if (!(exc instanceof com.alibaba.sdk.android.oss.ClientException)) {
            if (!(exc instanceof com.alibaba.sdk.android.oss.ServiceException)) {
                return com.alibaba.sdk.android.vod.upload.internal.OSSUploadRetryType.ShouldNotRetry;
            }
            com.alibaba.sdk.android.oss.ServiceException serviceException = (com.alibaba.sdk.android.oss.ServiceException) exc;
            if ((serviceException.getErrorCode() == null || !serviceException.getErrorCode().equalsIgnoreCase("RequestTimeTooSkewed")) && serviceException.getStatusCode() < 500) {
                return (serviceException.getStatusCode() != 403 || com.alibaba.sdk.android.vod.upload.common.utils.StringUtil.isEmpty(this.config.getSecrityToken())) ? com.alibaba.sdk.android.vod.upload.internal.OSSUploadRetryType.ShouldNotRetry : com.alibaba.sdk.android.vod.upload.internal.OSSUploadRetryType.ShouldGetSTS;
            }
            return com.alibaba.sdk.android.vod.upload.internal.OSSUploadRetryType.ShouldRetry;
        }
        java.lang.Exception exc2 = (java.lang.Exception) exc.getCause();
        if ((exc2 instanceof java.io.InterruptedIOException) && !(exc2 instanceof java.net.SocketTimeoutException)) {
            com.alibaba.sdk.android.oss.common.OSSLog.logError("[shouldNotetry] - is interrupted!");
            return com.alibaba.sdk.android.vod.upload.internal.OSSUploadRetryType.ShouldNotRetry;
        }
        if (!(exc2 instanceof java.lang.IllegalArgumentException) && !(exc2 instanceof java.net.SocketTimeoutException) && !(exc2 instanceof javax.net.ssl.SSLHandshakeException)) {
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("shouldRetry - " + exc.toString());
            if (exc.getCause() != null) {
                exc.getCause().printStackTrace();
            }
            return com.alibaba.sdk.android.vod.upload.internal.OSSUploadRetryType.ShouldRetry;
        }
        return com.alibaba.sdk.android.vod.upload.internal.OSSUploadRetryType.ShouldNotRetry;
    }

    @Override // com.alibaba.sdk.android.vod.upload.internal.OSSUploader
    public void start(com.alibaba.sdk.android.vod.upload.model.UploadFileInfo uploadFileInfo) {
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[OSSUploader] - start");
        getHandler().post(new com.alibaba.sdk.android.vod.upload.internal.OSSUploaderImpl.AnonymousClass1(uploadFileInfo));
    }
}
