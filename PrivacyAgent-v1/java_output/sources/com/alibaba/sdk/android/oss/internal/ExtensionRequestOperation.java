package com.alibaba.sdk.android.oss.internal;

/* loaded from: classes.dex */
public class ExtensionRequestOperation {
    private static java.util.concurrent.ExecutorService executorService = java.util.concurrent.Executors.newFixedThreadPool(5, new com.alibaba.sdk.android.oss.internal.ExtensionRequestOperation.AnonymousClass1());
    private com.alibaba.sdk.android.oss.internal.InternalRequestOperation apiOperation;

    /* renamed from: com.alibaba.sdk.android.oss.internal.ExtensionRequestOperation$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.util.concurrent.ThreadFactory {
        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            return new java.lang.Thread(runnable, "oss-android-extensionapi-thread");
        }
    }

    public ExtensionRequestOperation(com.alibaba.sdk.android.oss.internal.InternalRequestOperation internalRequestOperation) {
        this.apiOperation = internalRequestOperation;
    }

    private void setCRC64(com.alibaba.sdk.android.oss.model.OSSRequest oSSRequest) {
        oSSRequest.setCRC64(oSSRequest.getCRC64() != com.alibaba.sdk.android.oss.model.OSSRequest.CRC64Config.NULL ? oSSRequest.getCRC64() : this.apiOperation.getConf().isCheckCRC64() ? com.alibaba.sdk.android.oss.model.OSSRequest.CRC64Config.YES : com.alibaba.sdk.android.oss.model.OSSRequest.CRC64Config.NO);
    }

    public void abortResumableUpload(com.alibaba.sdk.android.oss.model.ResumableUploadRequest resumableUploadRequest) throws java.io.IOException {
        java.lang.String str;
        setCRC64(resumableUploadRequest);
        if (com.alibaba.sdk.android.oss.common.utils.OSSUtils.isEmptyString(resumableUploadRequest.getRecordDirectory())) {
            return;
        }
        java.lang.String uploadFilePath = resumableUploadRequest.getUploadFilePath();
        if (uploadFilePath != null) {
            str = com.alibaba.sdk.android.oss.common.utils.BinaryUtil.calculateMd5Str(uploadFilePath);
        } else {
            android.os.ParcelFileDescriptor openFileDescriptor = this.apiOperation.getApplicationContext().getContentResolver().openFileDescriptor(resumableUploadRequest.getUploadUri(), "r");
            try {
                java.lang.String calculateMd5Str = com.alibaba.sdk.android.oss.common.utils.BinaryUtil.calculateMd5Str(openFileDescriptor.getFileDescriptor());
                openFileDescriptor.close();
                str = calculateMd5Str;
            } catch (java.lang.Throwable th) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                throw th;
            }
        }
        java.lang.Enum crc64 = resumableUploadRequest.getCRC64();
        com.alibaba.sdk.android.oss.model.OSSRequest.CRC64Config cRC64Config = com.alibaba.sdk.android.oss.model.OSSRequest.CRC64Config.YES;
        java.lang.Boolean valueOf = java.lang.Boolean.valueOf(crc64 == cRC64Config);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(str);
        sb.append(resumableUploadRequest.getBucketName());
        sb.append(resumableUploadRequest.getObjectKey());
        sb.append(java.lang.String.valueOf(resumableUploadRequest.getPartSize()));
        sb.append(valueOf.booleanValue() ? "-crc64" : "");
        java.io.File file = new java.io.File(resumableUploadRequest.getRecordDirectory() + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR + com.alibaba.sdk.android.oss.common.utils.BinaryUtil.calculateMd5Str(sb.toString().getBytes()));
        if (file.exists()) {
            java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.FileReader(file));
            java.lang.String readLine = bufferedReader.readLine();
            bufferedReader.close();
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[initUploadId] - Found record file, uploadid: " + readLine);
            if (resumableUploadRequest.getCRC64() == cRC64Config) {
                java.io.File file2 = new java.io.File(resumableUploadRequest.getRecordDirectory() + java.io.File.separator + readLine);
                if (file2.exists()) {
                    file2.delete();
                }
            }
            this.apiOperation.abortMultipartUpload(new com.alibaba.sdk.android.oss.model.AbortMultipartUploadRequest(resumableUploadRequest.getBucketName(), resumableUploadRequest.getObjectKey(), readLine), null);
        }
        file.delete();
    }

    public boolean doesObjectExist(java.lang.String str, java.lang.String str2) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException {
        try {
            this.apiOperation.headObject(new com.alibaba.sdk.android.oss.model.HeadObjectRequest(str, str2), null).getResult();
            return true;
        } catch (com.alibaba.sdk.android.oss.ServiceException e) {
            if (e.getStatusCode() == 404) {
                return false;
            }
            throw e;
        }
    }

    public com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult> multipartUpload(com.alibaba.sdk.android.oss.model.MultipartUploadRequest multipartUploadRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.MultipartUploadRequest, com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult> oSSCompletedCallback) {
        setCRC64(multipartUploadRequest);
        com.alibaba.sdk.android.oss.network.ExecutionContext executionContext = new com.alibaba.sdk.android.oss.network.ExecutionContext(this.apiOperation.getInnerClient(), multipartUploadRequest, this.apiOperation.getApplicationContext());
        return com.alibaba.sdk.android.oss.internal.OSSAsyncTask.wrapRequestTask(executorService.submit(new com.alibaba.sdk.android.oss.internal.MultipartUploadTask(this.apiOperation, multipartUploadRequest, oSSCompletedCallback, executionContext)), executionContext);
    }

    public com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.ResumableDownloadResult> resumableDownload(com.alibaba.sdk.android.oss.model.ResumableDownloadRequest resumableDownloadRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.ResumableDownloadRequest, com.alibaba.sdk.android.oss.model.ResumableDownloadResult> oSSCompletedCallback) {
        com.alibaba.sdk.android.oss.network.ExecutionContext executionContext = new com.alibaba.sdk.android.oss.network.ExecutionContext(this.apiOperation.getInnerClient(), resumableDownloadRequest, this.apiOperation.getApplicationContext());
        return com.alibaba.sdk.android.oss.internal.OSSAsyncTask.wrapRequestTask(executorService.submit(new com.alibaba.sdk.android.oss.internal.ResumableDownloadTask(this.apiOperation, resumableDownloadRequest, oSSCompletedCallback, executionContext)), executionContext);
    }

    public com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.ResumableUploadResult> resumableUpload(com.alibaba.sdk.android.oss.model.ResumableUploadRequest resumableUploadRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.ResumableUploadRequest, com.alibaba.sdk.android.oss.model.ResumableUploadResult> oSSCompletedCallback) {
        setCRC64(resumableUploadRequest);
        com.alibaba.sdk.android.oss.network.ExecutionContext executionContext = new com.alibaba.sdk.android.oss.network.ExecutionContext(this.apiOperation.getInnerClient(), resumableUploadRequest, this.apiOperation.getApplicationContext());
        return com.alibaba.sdk.android.oss.internal.OSSAsyncTask.wrapRequestTask(executorService.submit(new com.alibaba.sdk.android.oss.internal.ResumableUploadTask(resumableUploadRequest, oSSCompletedCallback, executionContext, this.apiOperation)), executionContext);
    }

    public com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.ResumableUploadResult> sequenceUpload(com.alibaba.sdk.android.oss.model.ResumableUploadRequest resumableUploadRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.ResumableUploadRequest, com.alibaba.sdk.android.oss.model.ResumableUploadResult> oSSCompletedCallback) {
        setCRC64(resumableUploadRequest);
        com.alibaba.sdk.android.oss.network.ExecutionContext executionContext = new com.alibaba.sdk.android.oss.network.ExecutionContext(this.apiOperation.getInnerClient(), resumableUploadRequest, this.apiOperation.getApplicationContext());
        return com.alibaba.sdk.android.oss.internal.OSSAsyncTask.wrapRequestTask(executorService.submit(new com.alibaba.sdk.android.oss.internal.SequenceUploadTask(resumableUploadRequest, oSSCompletedCallback, executionContext, this.apiOperation)), executionContext);
    }
}
