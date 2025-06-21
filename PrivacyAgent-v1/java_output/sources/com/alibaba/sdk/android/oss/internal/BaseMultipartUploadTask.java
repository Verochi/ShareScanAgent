package com.alibaba.sdk.android.oss.internal;

/* loaded from: classes.dex */
public abstract class BaseMultipartUploadTask<Request extends com.alibaba.sdk.android.oss.model.MultipartUploadRequest, Result extends com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult> implements java.util.concurrent.Callable<Result> {
    protected final int CPU_SIZE;
    protected final int KEEP_ALIVE_TIME;
    protected final int MAX_CORE_POOL_SIZE;
    protected final int MAX_IMUM_POOL_SIZE;
    protected final int MAX_QUEUE_SIZE;
    protected final int PART_SIZE_ALIGN_NUM;
    protected com.alibaba.sdk.android.oss.internal.InternalRequestOperation mApiOperation;
    protected boolean mCheckCRC64;
    protected com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<Request, Result> mCompletedCallback;
    protected com.alibaba.sdk.android.oss.network.ExecutionContext mContext;
    protected long mFileLength;
    protected boolean mIsCancel;
    protected long mLastPartSize;
    protected java.lang.Object mLock;
    protected int[] mPartAttr;
    protected java.util.List<com.alibaba.sdk.android.oss.model.PartETag> mPartETags;
    protected int mPartExceptionCount;
    protected java.util.concurrent.ThreadPoolExecutor mPoolExecutor;
    protected com.alibaba.sdk.android.oss.callback.OSSProgressCallback<Request> mProgressCallback;
    protected Request mRequest;
    protected int mRunPartTaskCount;
    protected java.lang.Exception mUploadException;
    protected java.io.File mUploadFile;
    protected java.lang.String mUploadFilePath;
    protected java.lang.String mUploadId;
    protected android.net.Uri mUploadUri;
    protected long mUploadedLength;

    /* renamed from: com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.concurrent.ThreadFactory {
        public AnonymousClass1() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            return new java.lang.Thread(runnable, "oss-android-multipart-thread");
        }
    }

    /* renamed from: com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask$2, reason: invalid class name */
    public class AnonymousClass2 implements java.util.Comparator<com.alibaba.sdk.android.oss.model.PartETag> {
        public AnonymousClass2() {
        }

        @Override // java.util.Comparator
        public int compare(com.alibaba.sdk.android.oss.model.PartETag partETag, com.alibaba.sdk.android.oss.model.PartETag partETag2) {
            if (partETag.getPartNumber() < partETag2.getPartNumber()) {
                return -1;
            }
            return partETag.getPartNumber() > partETag2.getPartNumber() ? 1 : 0;
        }
    }

    public BaseMultipartUploadTask(com.alibaba.sdk.android.oss.internal.InternalRequestOperation internalRequestOperation, Request request, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<Request, Result> oSSCompletedCallback, com.alibaba.sdk.android.oss.network.ExecutionContext executionContext) {
        int availableProcessors = java.lang.Runtime.getRuntime().availableProcessors() * 2;
        this.CPU_SIZE = availableProcessors;
        int i = availableProcessors < 5 ? availableProcessors : 5;
        this.MAX_CORE_POOL_SIZE = i;
        this.MAX_IMUM_POOL_SIZE = availableProcessors;
        this.KEEP_ALIVE_TIME = 3000;
        this.MAX_QUEUE_SIZE = 5000;
        this.PART_SIZE_ALIGN_NUM = 4096;
        this.mPartETags = new java.util.ArrayList();
        this.mLock = new java.lang.Object();
        this.mUploadedLength = 0L;
        this.mCheckCRC64 = false;
        this.mPartAttr = new int[2];
        this.mApiOperation = internalRequestOperation;
        this.mRequest = request;
        this.mProgressCallback = request.getProgressCallback();
        this.mCompletedCallback = oSSCompletedCallback;
        this.mContext = executionContext;
        this.mCheckCRC64 = request.getCRC64() == com.alibaba.sdk.android.oss.model.OSSRequest.CRC64Config.YES;
        if (request.getThreadNum() != null && request.getThreadNum().intValue() > 0) {
            i = request.getThreadNum().intValue();
            availableProcessors = request.getThreadNum().intValue();
        }
        this.mPoolExecutor = new java.util.concurrent.ThreadPoolExecutor(i, availableProcessors, 3000L, java.util.concurrent.TimeUnit.MILLISECONDS, new java.util.concurrent.ArrayBlockingQueue(5000), new com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask.AnonymousClass1());
    }

    public abstract void abortThisUpload();

    @Override // java.util.concurrent.Callable
    public Result call() throws java.lang.Exception {
        try {
            checkInitData();
            initMultipartUploadId();
            Result doMultipartUpload = doMultipartUpload();
            com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<Request, Result> oSSCompletedCallback = this.mCompletedCallback;
            if (oSSCompletedCallback != null) {
                oSSCompletedCallback.onSuccess(this.mRequest, doMultipartUpload);
            }
            return doMultipartUpload;
        } catch (com.alibaba.sdk.android.oss.ServiceException e) {
            com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<Request, Result> oSSCompletedCallback2 = this.mCompletedCallback;
            if (oSSCompletedCallback2 != null) {
                oSSCompletedCallback2.onFailure(this.mRequest, null, e);
            }
            throw e;
        } catch (java.lang.Exception e2) {
            com.alibaba.sdk.android.oss.ClientException clientException = e2 instanceof com.alibaba.sdk.android.oss.ClientException ? (com.alibaba.sdk.android.oss.ClientException) e2 : new com.alibaba.sdk.android.oss.ClientException(e2.toString(), e2);
            com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<Request, Result> oSSCompletedCallback3 = this.mCompletedCallback;
            if (oSSCompletedCallback3 != null) {
                oSSCompletedCallback3.onFailure(this.mRequest, clientException, null);
            }
            throw clientException;
        }
    }

    public long ceilPartSize(long j) {
        return ((j + 4095) / 4096) * 4096;
    }

    public void checkCancel() throws com.alibaba.sdk.android.oss.ClientException {
        if (this.mContext.getCancellationHandler().isCancelled()) {
            com.alibaba.sdk.android.oss.TaskCancelException taskCancelException = new com.alibaba.sdk.android.oss.TaskCancelException("multipart cancel");
            throw new com.alibaba.sdk.android.oss.ClientException(taskCancelException.getMessage(), taskCancelException, java.lang.Boolean.TRUE);
        }
    }

    public void checkException() throws java.io.IOException, com.alibaba.sdk.android.oss.ServiceException, com.alibaba.sdk.android.oss.ClientException {
        if (this.mUploadException != null) {
            releasePool();
            java.lang.Exception exc = this.mUploadException;
            if (exc instanceof java.io.IOException) {
                throw ((java.io.IOException) exc);
            }
            if (exc instanceof com.alibaba.sdk.android.oss.ServiceException) {
                throw ((com.alibaba.sdk.android.oss.ServiceException) exc);
            }
            if (!(exc instanceof com.alibaba.sdk.android.oss.ClientException)) {
                throw new com.alibaba.sdk.android.oss.ClientException(this.mUploadException.getMessage(), this.mUploadException);
            }
            throw ((com.alibaba.sdk.android.oss.ClientException) exc);
        }
    }

    public void checkInitData() throws com.alibaba.sdk.android.oss.ClientException {
        if (this.mRequest.getUploadFilePath() != null) {
            this.mUploadFilePath = this.mRequest.getUploadFilePath();
            this.mUploadedLength = 0L;
            java.io.File file = new java.io.File(this.mUploadFilePath);
            this.mUploadFile = file;
            this.mFileLength = file.length();
        } else if (this.mRequest.getUploadUri() != null) {
            this.mUploadUri = this.mRequest.getUploadUri();
            android.os.ParcelFileDescriptor parcelFileDescriptor = null;
            try {
                try {
                    parcelFileDescriptor = this.mContext.getApplicationContext().getContentResolver().openFileDescriptor(this.mUploadUri, "r");
                    this.mFileLength = parcelFileDescriptor.getStatSize();
                    try {
                        parcelFileDescriptor.close();
                    } catch (java.io.IOException e) {
                        com.alibaba.sdk.android.oss.common.OSSLog.logThrowable2Local(e);
                    }
                } catch (java.io.IOException e2) {
                    throw new com.alibaba.sdk.android.oss.ClientException(e2.getMessage(), e2, java.lang.Boolean.TRUE);
                }
            } catch (java.lang.Throwable th) {
                if (parcelFileDescriptor != null) {
                    try {
                        parcelFileDescriptor.close();
                    } catch (java.io.IOException e3) {
                        com.alibaba.sdk.android.oss.common.OSSLog.logThrowable2Local(e3);
                    }
                }
                throw th;
            }
        }
        if (this.mFileLength == 0) {
            throw new com.alibaba.sdk.android.oss.ClientException("file length must not be 0");
        }
        checkPartSize(this.mPartAttr);
        long partSize = this.mRequest.getPartSize();
        int i = this.mPartAttr[1];
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[checkInitData] - partNumber : " + i);
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[checkInitData] - partSize : " + partSize);
        if (i > 1 && partSize < com.alibaba.sdk.android.oss.common.OSSConstants.MIN_PART_SIZE_LIMIT) {
            throw new com.alibaba.sdk.android.oss.ClientException("Part size must be greater than or equal to 100KB!");
        }
    }

    public void checkPartSize(int[] iArr) {
        long partSize = this.mRequest.getPartSize();
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[checkPartSize] - mFileLength : " + this.mFileLength);
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[checkPartSize] - partSize : " + partSize);
        long j = this.mFileLength;
        long j2 = j / partSize;
        if (j % partSize != 0) {
            j2++;
        }
        if (j2 == 1) {
            partSize = j;
        } else if (j2 > 5000) {
            partSize = ceilPartSize(j / 4999);
            long j3 = this.mFileLength;
            j2 = (j3 / partSize) + (j3 % partSize == 0 ? 0L : 1L);
        }
        int i = (int) partSize;
        iArr[0] = i;
        iArr[1] = (int) j2;
        this.mRequest.setPartSize(i);
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[checkPartSize] - partNumber : " + j2);
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[checkPartSize] - partSize : " + i);
        long j4 = this.mFileLength % partSize;
        if (j4 != 0) {
            partSize = j4;
        }
        this.mLastPartSize = partSize;
    }

    public boolean checkWaitCondition(int i) {
        return this.mPartETags.size() != i;
    }

    public com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult completeMultipartUploadResult() throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException {
        com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult completeMultipartUploadResult;
        if (this.mPartETags.size() > 0) {
            java.util.Collections.sort(this.mPartETags, new com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask.AnonymousClass2());
            com.alibaba.sdk.android.oss.model.CompleteMultipartUploadRequest completeMultipartUploadRequest = new com.alibaba.sdk.android.oss.model.CompleteMultipartUploadRequest(this.mRequest.getBucketName(), this.mRequest.getObjectKey(), this.mUploadId, this.mPartETags);
            if (this.mRequest.getCallbackParam() != null) {
                completeMultipartUploadRequest.setCallbackParam(this.mRequest.getCallbackParam());
            }
            if (this.mRequest.getCallbackVars() != null) {
                completeMultipartUploadRequest.setCallbackVars(this.mRequest.getCallbackVars());
            }
            if (this.mRequest.getMetadata() != null) {
                com.alibaba.sdk.android.oss.model.ObjectMetadata objectMetadata = new com.alibaba.sdk.android.oss.model.ObjectMetadata();
                for (java.lang.String str : this.mRequest.getMetadata().getRawMetadata().keySet()) {
                    if (!str.equals(com.alibaba.sdk.android.oss.common.OSSHeaders.STORAGE_CLASS)) {
                        objectMetadata.setHeader(str, this.mRequest.getMetadata().getRawMetadata().get(str));
                    }
                }
                completeMultipartUploadRequest.setMetadata(objectMetadata);
            }
            completeMultipartUploadRequest.setCRC64(this.mRequest.getCRC64());
            completeMultipartUploadResult = this.mApiOperation.syncCompleteMultipartUpload(completeMultipartUploadRequest);
        } else {
            completeMultipartUploadResult = null;
        }
        this.mUploadedLength = 0L;
        return completeMultipartUploadResult;
    }

    public abstract Result doMultipartUpload() throws java.io.IOException, com.alibaba.sdk.android.oss.ServiceException, com.alibaba.sdk.android.oss.ClientException, java.lang.InterruptedException;

    public abstract void initMultipartUploadId() throws java.io.IOException, com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException;

    public void notifyMultipartThread() {
        this.mLock.notify();
        this.mPartExceptionCount = 0;
    }

    public void onProgressCallback(Request request, long j, long j2) {
        com.alibaba.sdk.android.oss.callback.OSSProgressCallback<Request> oSSProgressCallback = this.mProgressCallback;
        if (oSSProgressCallback != null) {
            oSSProgressCallback.onProgress(request, j, j2);
        }
    }

    public void preUploadPart(int i, int i2, int i3) throws java.lang.Exception {
    }

    public abstract void processException(java.lang.Exception exc);

    public void releasePool() {
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = this.mPoolExecutor;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.getQueue().clear();
            this.mPoolExecutor.shutdown();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0151 A[Catch: IOException -> 0x0155, TRY_ENTER, TryCatch #1 {IOException -> 0x0155, blocks: (B:35:0x011e, B:37:0x0123, B:39:0x0128, B:57:0x0151, B:59:0x0159, B:61:0x015e), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0159 A[Catch: IOException -> 0x0155, TryCatch #1 {IOException -> 0x0155, blocks: (B:35:0x011e, B:37:0x0123, B:39:0x0128, B:57:0x0151, B:59:0x0159, B:61:0x015e), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x015e A[Catch: IOException -> 0x0155, TRY_LEAVE, TryCatch #1 {IOException -> 0x0155, blocks: (B:35:0x011e, B:37:0x0123, B:39:0x0128, B:57:0x0151, B:59:0x0159, B:61:0x015e), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0172 A[Catch: IOException -> 0x016e, TryCatch #7 {IOException -> 0x016e, blocks: (B:80:0x016a, B:69:0x0172, B:71:0x0177), top: B:79:0x016a }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0177 A[Catch: IOException -> 0x016e, TRY_LEAVE, TryCatch #7 {IOException -> 0x016e, blocks: (B:80:0x016a, B:69:0x0172, B:71:0x0177), top: B:79:0x016a }] */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x016a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void uploadPart(int i, int i2, int i3) {
        java.lang.Throwable th;
        java.io.InputStream inputStream;
        java.io.BufferedInputStream bufferedInputStream;
        java.io.RandomAccessFile randomAccessFile;
        java.io.RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                if (this.mContext.getCancellationHandler().isCancelled()) {
                    this.mPoolExecutor.getQueue().clear();
                    return;
                }
                synchronized (this.mLock) {
                    this.mRunPartTaskCount++;
                }
                preUploadPart(i, i2, i3);
                byte[] bArr = new byte[i2];
                long partSize = i * this.mRequest.getPartSize();
                if (this.mUploadUri != null) {
                    java.io.InputStream openInputStream = this.mContext.getApplicationContext().getContentResolver().openInputStream(this.mUploadUri);
                    try {
                        java.io.BufferedInputStream bufferedInputStream2 = new java.io.BufferedInputStream(openInputStream);
                        try {
                            bufferedInputStream2.skip(partSize);
                            bufferedInputStream2.read(bArr, 0, i2);
                            randomAccessFile = null;
                            bufferedInputStream = bufferedInputStream2;
                            inputStream = openInputStream;
                        } catch (java.lang.Exception e) {
                            e = e;
                            bufferedInputStream = bufferedInputStream2;
                            inputStream = openInputStream;
                            try {
                                processException(e);
                                if (randomAccessFile2 != null) {
                                    randomAccessFile2.close();
                                }
                                if (bufferedInputStream != null) {
                                    bufferedInputStream.close();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                    return;
                                }
                                return;
                            } catch (java.lang.Throwable th2) {
                                th = th2;
                                if (randomAccessFile2 != null) {
                                    try {
                                        randomAccessFile2.close();
                                    } catch (java.io.IOException e2) {
                                        com.alibaba.sdk.android.oss.common.OSSLog.logThrowable2Local(e2);
                                        throw th;
                                    }
                                }
                                if (bufferedInputStream != null) {
                                    bufferedInputStream.close();
                                }
                                if (inputStream != null) {
                                    throw th;
                                }
                                inputStream.close();
                                throw th;
                            }
                        } catch (java.lang.Throwable th3) {
                            th = th3;
                            bufferedInputStream = bufferedInputStream2;
                            inputStream = openInputStream;
                            if (randomAccessFile2 != null) {
                            }
                            if (bufferedInputStream != null) {
                            }
                            if (inputStream != null) {
                            }
                        }
                    } catch (java.lang.Exception e3) {
                        e = e3;
                        bufferedInputStream = null;
                    } catch (java.lang.Throwable th4) {
                        th = th4;
                        bufferedInputStream = null;
                    }
                } else {
                    java.io.RandomAccessFile randomAccessFile3 = new java.io.RandomAccessFile(this.mUploadFile, "r");
                    try {
                        randomAccessFile3.seek(partSize);
                        randomAccessFile3.readFully(bArr, 0, i2);
                        inputStream = null;
                        bufferedInputStream = null;
                        randomAccessFile = randomAccessFile3;
                    } catch (java.lang.Exception e4) {
                        e = e4;
                        inputStream = null;
                        bufferedInputStream = null;
                        randomAccessFile2 = randomAccessFile3;
                        processException(e);
                        if (randomAccessFile2 != null) {
                        }
                        if (bufferedInputStream != null) {
                        }
                        if (inputStream != null) {
                        }
                    } catch (java.lang.Throwable th5) {
                        th = th5;
                        inputStream = null;
                        bufferedInputStream = null;
                        randomAccessFile2 = randomAccessFile3;
                        if (randomAccessFile2 != null) {
                        }
                        if (bufferedInputStream != null) {
                        }
                        if (inputStream != null) {
                        }
                    }
                }
                try {
                    com.alibaba.sdk.android.oss.model.UploadPartRequest uploadPartRequest = new com.alibaba.sdk.android.oss.model.UploadPartRequest(this.mRequest.getBucketName(), this.mRequest.getObjectKey(), this.mUploadId, i + 1);
                    uploadPartRequest.setPartContent(bArr);
                    uploadPartRequest.setMd5Digest(com.alibaba.sdk.android.oss.common.utils.BinaryUtil.calculateBase64Md5(bArr));
                    uploadPartRequest.setCRC64(this.mRequest.getCRC64());
                    com.alibaba.sdk.android.oss.model.UploadPartResult syncUploadPart = this.mApiOperation.syncUploadPart(uploadPartRequest);
                    synchronized (this.mLock) {
                        com.alibaba.sdk.android.oss.model.PartETag partETag = new com.alibaba.sdk.android.oss.model.PartETag(uploadPartRequest.getPartNumber(), syncUploadPart.getETag());
                        long j = i2;
                        partETag.setPartSize(j);
                        if (this.mCheckCRC64) {
                            partETag.setCRC64(syncUploadPart.getClientCRC().longValue());
                        }
                        this.mPartETags.add(partETag);
                        this.mUploadedLength += j;
                        uploadPartFinish(partETag);
                        if (!this.mContext.getCancellationHandler().isCancelled()) {
                            if (this.mPartETags.size() == i3 - this.mPartExceptionCount) {
                                notifyMultipartThread();
                            }
                            onProgressCallback(this.mRequest, this.mUploadedLength, this.mFileLength);
                        } else if (this.mPartETags.size() == this.mRunPartTaskCount - this.mPartExceptionCount) {
                            com.alibaba.sdk.android.oss.TaskCancelException taskCancelException = new com.alibaba.sdk.android.oss.TaskCancelException("multipart cancel");
                            throw new com.alibaba.sdk.android.oss.ClientException(taskCancelException.getMessage(), taskCancelException, java.lang.Boolean.TRUE);
                        }
                    }
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (java.lang.Exception e5) {
                    e = e5;
                    randomAccessFile2 = randomAccessFile;
                    processException(e);
                    if (randomAccessFile2 != null) {
                    }
                    if (bufferedInputStream != null) {
                    }
                    if (inputStream != null) {
                    }
                } catch (java.lang.Throwable th6) {
                    th = th6;
                    randomAccessFile2 = randomAccessFile;
                    if (randomAccessFile2 != null) {
                    }
                    if (bufferedInputStream != null) {
                    }
                    if (inputStream != null) {
                    }
                }
            } catch (java.io.IOException e6) {
                com.alibaba.sdk.android.oss.common.OSSLog.logThrowable2Local(e6);
            }
        } catch (java.lang.Exception e7) {
            e = e7;
            inputStream = null;
            bufferedInputStream = null;
        } catch (java.lang.Throwable th7) {
            th = th7;
            inputStream = null;
            bufferedInputStream = null;
        }
    }

    public void uploadPartFinish(com.alibaba.sdk.android.oss.model.PartETag partETag) throws java.lang.Exception {
    }
}
