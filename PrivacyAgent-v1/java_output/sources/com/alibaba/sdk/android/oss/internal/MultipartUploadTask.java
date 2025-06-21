package com.alibaba.sdk.android.oss.internal;

/* loaded from: classes.dex */
public class MultipartUploadTask extends com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask<com.alibaba.sdk.android.oss.model.MultipartUploadRequest, com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult> {

    /* renamed from: com.alibaba.sdk.android.oss.internal.MultipartUploadTask$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ int val$byteCount;
        final /* synthetic */ int val$partNumber;
        final /* synthetic */ int val$readIndex;

        public AnonymousClass1(int i, int i2, int i3) {
            this.val$readIndex = i;
            this.val$byteCount = i2;
            this.val$partNumber = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.alibaba.sdk.android.oss.internal.MultipartUploadTask.this.uploadPart(this.val$readIndex, this.val$byteCount, this.val$partNumber);
        }
    }

    public MultipartUploadTask(com.alibaba.sdk.android.oss.internal.InternalRequestOperation internalRequestOperation, com.alibaba.sdk.android.oss.model.MultipartUploadRequest multipartUploadRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.MultipartUploadRequest, com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult> oSSCompletedCallback, com.alibaba.sdk.android.oss.network.ExecutionContext executionContext) {
        super(internalRequestOperation, multipartUploadRequest, oSSCompletedCallback, executionContext);
    }

    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    public void abortThisUpload() {
        if (this.mUploadId != null) {
            this.mApiOperation.abortMultipartUpload(new com.alibaba.sdk.android.oss.model.AbortMultipartUploadRequest(this.mRequest.getBucketName(), this.mRequest.getObjectKey(), this.mUploadId), null).waitUntilFinished();
        }
    }

    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    public com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult doMultipartUpload() throws java.io.IOException, com.alibaba.sdk.android.oss.ServiceException, com.alibaba.sdk.android.oss.ClientException, java.lang.InterruptedException {
        checkCancel();
        int[] iArr = this.mPartAttr;
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = i;
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            checkException();
            java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = this.mPoolExecutor;
            if (threadPoolExecutor != null) {
                if (i5 == i2 - 1) {
                    i3 = (int) (this.mFileLength - i4);
                }
                i4 += i3;
                threadPoolExecutor.execute(new com.alibaba.sdk.android.oss.internal.MultipartUploadTask.AnonymousClass1(i5, i3, i2));
            }
        }
        if (checkWaitCondition(i2)) {
            synchronized (this.mLock) {
                this.mLock.wait();
            }
        }
        if (this.mUploadException != null) {
            abortThisUpload();
        }
        checkException();
        com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult completeMultipartUploadResult = completeMultipartUploadResult();
        releasePool();
        return completeMultipartUploadResult;
    }

    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    public void initMultipartUploadId() throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException {
        java.lang.String uploadId = this.mApiOperation.initMultipartUpload(new com.alibaba.sdk.android.oss.model.InitiateMultipartUploadRequest(this.mRequest.getBucketName(), this.mRequest.getObjectKey(), this.mRequest.getMetadata()), null).getResult().getUploadId();
        this.mUploadId = uploadId;
        this.mRequest.setUploadId(uploadId);
    }

    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    public void preUploadPart(int i, int i2, int i3) throws java.lang.Exception {
        checkException();
    }

    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    public void processException(java.lang.Exception exc) {
        synchronized (this.mLock) {
            this.mPartExceptionCount++;
            if (this.mUploadException == null) {
                this.mUploadException = exc;
                this.mLock.notify();
            }
        }
    }
}
