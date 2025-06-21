package com.alibaba.sdk.android.oss.internal;

/* loaded from: classes.dex */
public class ResumableDownloadTask<Requst extends com.alibaba.sdk.android.oss.model.ResumableDownloadRequest, Result extends com.alibaba.sdk.android.oss.model.ResumableDownloadResult> implements java.util.concurrent.Callable<Result> {
    protected static final java.lang.String TEMP_SUFFIX = ".temp";
    protected final int CPU_SIZE;
    protected final int KEEP_ALIVE_TIME;
    protected final int MAX_CORE_POOL_SIZE;
    protected final int MAX_IMUM_POOL_SIZE;
    protected final int MAX_QUEUE_SIZE;
    protected final int PART_SIZE_ALIGN_NUM;
    protected java.lang.String checkpointPath;
    protected long completedPartSize;
    protected long downloadPartSize;
    private com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.CheckPoint mCheckPoint;
    private com.alibaba.sdk.android.oss.callback.OSSCompletedCallback mCompletedCallback;
    private com.alibaba.sdk.android.oss.network.ExecutionContext mContext;
    protected java.lang.Exception mDownloadException;
    protected java.lang.Object mLock;
    private com.alibaba.sdk.android.oss.internal.InternalRequestOperation mOperation;
    protected long mPartExceptionCount;
    protected java.util.concurrent.ThreadPoolExecutor mPoolExecutor;
    private com.alibaba.sdk.android.oss.callback.OSSProgressCallback mProgressCallback;
    private com.alibaba.sdk.android.oss.model.ResumableDownloadRequest mRequest;

    /* renamed from: com.alibaba.sdk.android.oss.internal.ResumableDownloadTask$1, reason: invalid class name */
    public class AnonymousClass1 implements java.util.concurrent.ThreadFactory {
        public AnonymousClass1() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public java.lang.Thread newThread(java.lang.Runnable runnable) {
            return new java.lang.Thread(runnable, "oss-android-multipart-thread");
        }
    }

    /* renamed from: com.alibaba.sdk.android.oss.internal.ResumableDownloadTask$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.DownloadPart val$part;
        final /* synthetic */ com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.DownloadFileResult val$result;

        public AnonymousClass2(com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.DownloadFileResult downloadFileResult, com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.DownloadPart downloadPart) {
            this.val$result = downloadFileResult;
            this.val$part = downloadPart;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.this.downloadPart(this.val$result, this.val$part);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("start: ");
            sb.append(this.val$part.start);
            sb.append(", end: ");
            sb.append(this.val$part.end);
        }
    }

    /* renamed from: com.alibaba.sdk.android.oss.internal.ResumableDownloadTask$3, reason: invalid class name */
    public class AnonymousClass3 implements java.util.Comparator<com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.DownloadPartResult> {
        public AnonymousClass3() {
        }

        @Override // java.util.Comparator
        public int compare(com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.DownloadPartResult downloadPartResult, com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.DownloadPartResult downloadPartResult2) {
            return downloadPartResult.partNumber - downloadPartResult2.partNumber;
        }
    }

    public static class CheckPoint implements java.io.Serializable {
        private static final long serialVersionUID = -8470273912385636504L;
        public java.lang.String bucketName;
        public java.lang.String downloadFile;
        public long downloadLength;
        public com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.FileStat fileStat;
        public int md5;
        public java.lang.String objectKey;
        public java.util.ArrayList<com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.DownloadPart> parts;

        private void assign(com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.CheckPoint checkPoint) {
            this.md5 = checkPoint.md5;
            this.downloadFile = checkPoint.downloadFile;
            this.bucketName = checkPoint.bucketName;
            this.objectKey = checkPoint.objectKey;
            this.fileStat = checkPoint.fileStat;
            this.parts = checkPoint.parts;
            this.downloadLength = checkPoint.downloadLength;
        }

        public synchronized void dump(java.lang.String str) throws java.io.IOException {
            java.io.FileOutputStream fileOutputStream;
            this.md5 = hashCode();
            java.io.File file = new java.io.File(str + ".temp");
            java.io.ObjectOutputStream objectOutputStream = null;
            try {
                fileOutputStream = new java.io.FileOutputStream(file);
                try {
                    java.io.ObjectOutputStream objectOutputStream2 = new java.io.ObjectOutputStream(fileOutputStream);
                    try {
                        objectOutputStream2.writeObject(this);
                        file.renameTo(new java.io.File(str));
                        objectOutputStream2.close();
                        fileOutputStream.close();
                    } catch (java.lang.Throwable th) {
                        th = th;
                        objectOutputStream = objectOutputStream2;
                        if (objectOutputStream != null) {
                            objectOutputStream.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw th;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        }

        public int hashCode() {
            java.lang.String str = this.bucketName;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            java.lang.String str2 = this.downloadFile;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            java.lang.String str3 = this.objectKey;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.FileStat fileStat = this.fileStat;
            int hashCode4 = (hashCode3 + (fileStat == null ? 0 : fileStat.hashCode())) * 31;
            java.util.ArrayList<com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.DownloadPart> arrayList = this.parts;
            int hashCode5 = (hashCode4 + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
            long j = this.downloadLength;
            return hashCode5 + ((int) (j ^ (j >>> 32)));
        }

        public synchronized boolean isValid(com.alibaba.sdk.android.oss.internal.InternalRequestOperation internalRequestOperation) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException {
            if (this.md5 != hashCode()) {
                return false;
            }
            com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.FileStat fileStat = com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.FileStat.getFileStat(internalRequestOperation, this.bucketName, this.objectKey);
            com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.FileStat fileStat2 = this.fileStat;
            java.util.Date date = fileStat2.lastModified;
            if (date == null) {
                if (fileStat2.fileLength != fileStat.fileLength || !fileStat2.etag.equals(fileStat.etag)) {
                    return false;
                }
            } else if (fileStat2.fileLength != fileStat.fileLength || !date.equals(fileStat.lastModified) || !this.fileStat.etag.equals(fileStat.etag)) {
                return false;
            }
            return true;
        }

        public synchronized void load(java.lang.String str) throws java.io.IOException, java.lang.ClassNotFoundException {
            java.io.FileInputStream fileInputStream;
            java.lang.Throwable th;
            java.io.ObjectInputStream objectInputStream;
            try {
                try {
                    fileInputStream = new java.io.FileInputStream(str);
                    try {
                        objectInputStream = new java.io.ObjectInputStream(fileInputStream);
                        try {
                            assign((com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.CheckPoint) objectInputStream.readObject());
                            objectInputStream.close();
                            fileInputStream.close();
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            if (objectInputStream != null) {
                                objectInputStream.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            throw th;
                        }
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        objectInputStream = null;
                    }
                } catch (java.lang.Throwable th4) {
                    fileInputStream = null;
                    th = th4;
                    objectInputStream = null;
                }
            } catch (java.lang.Throwable th5) {
                throw th5;
            }
        }

        public synchronized void update(int i, boolean z) throws java.io.IOException {
            this.parts.get(i).isCompleted = z;
            this.downloadLength += this.parts.get(i).length;
        }
    }

    public class DownloadFileResult extends com.alibaba.sdk.android.oss.model.OSSResult {
        public com.alibaba.sdk.android.oss.model.ObjectMetadata metadata;
        public java.util.ArrayList<com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.DownloadPartResult> partResults;

        public DownloadFileResult() {
        }
    }

    public static class DownloadPart implements java.io.Serializable {
        private static final long serialVersionUID = -3506020776131733942L;
        public long crc;
        public long end;
        public long fileStart;
        public boolean isCompleted;
        public long length;
        public int partNumber;
        public long start;

        public int hashCode() {
            int i = (((this.partNumber + 31) * 31) + (this.isCompleted ? 1231 : 1237)) * 31;
            long j = this.end;
            int i2 = (i + ((int) (j ^ (j >>> 32)))) * 31;
            long j2 = this.start;
            long j3 = this.crc;
            return ((i2 + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)));
        }
    }

    public static class DownloadPartResult {
        public java.lang.Long clientCRC;
        public long length;
        public int partNumber;
        public java.lang.String requestId;
    }

    public static class FileStat implements java.io.Serializable {
        private static final long serialVersionUID = 3896323364904643963L;
        public java.lang.String etag;
        public long fileLength;
        public java.util.Date lastModified;
        public java.lang.String md5;
        public java.lang.String requestId;
        public java.lang.Long serverCRC;

        public static com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.FileStat getFileStat(com.alibaba.sdk.android.oss.internal.InternalRequestOperation internalRequestOperation, java.lang.String str, java.lang.String str2) throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException {
            com.alibaba.sdk.android.oss.model.GetObjectMetaResult result = internalRequestOperation.getObjectMeta(new com.alibaba.sdk.android.oss.model.GetObjectMetaRequest(str, str2), null).getResult();
            com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.FileStat fileStat = new com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.FileStat();
            fileStat.fileLength = result.getMetadata().getContentLength();
            fileStat.etag = result.getMetadata().getETag();
            fileStat.lastModified = result.getMetadata().getLastModified();
            fileStat.serverCRC = result.getServerCRC();
            fileStat.requestId = result.getRequestId();
            return fileStat;
        }

        public int hashCode() {
            java.lang.String str = this.etag;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            java.util.Date date = this.lastModified;
            int hashCode2 = (hashCode + (date != null ? date.hashCode() : 0)) * 31;
            long j = this.fileLength;
            return hashCode2 + ((int) (j ^ (j >>> 32)));
        }
    }

    public ResumableDownloadTask(com.alibaba.sdk.android.oss.internal.InternalRequestOperation internalRequestOperation, com.alibaba.sdk.android.oss.model.ResumableDownloadRequest resumableDownloadRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback oSSCompletedCallback, com.alibaba.sdk.android.oss.network.ExecutionContext executionContext) {
        int availableProcessors = java.lang.Runtime.getRuntime().availableProcessors() * 2;
        this.CPU_SIZE = availableProcessors;
        int i = availableProcessors < 5 ? availableProcessors : 5;
        this.MAX_CORE_POOL_SIZE = i;
        this.MAX_IMUM_POOL_SIZE = availableProcessors;
        this.KEEP_ALIVE_TIME = 3000;
        this.PART_SIZE_ALIGN_NUM = 4096;
        this.MAX_QUEUE_SIZE = 5000;
        this.mLock = new java.lang.Object();
        this.mRequest = resumableDownloadRequest;
        this.mOperation = internalRequestOperation;
        this.mCompletedCallback = oSSCompletedCallback;
        this.mContext = executionContext;
        this.mProgressCallback = resumableDownloadRequest.getProgressListener();
        if (resumableDownloadRequest.getThreadNum() != null && resumableDownloadRequest.getThreadNum().intValue() > 0) {
            i = resumableDownloadRequest.getThreadNum().intValue();
            availableProcessors = resumableDownloadRequest.getThreadNum().intValue();
        }
        this.mPoolExecutor = new java.util.concurrent.ThreadPoolExecutor(i, availableProcessors, 3000L, java.util.concurrent.TimeUnit.MILLISECONDS, new java.util.concurrent.ArrayBlockingQueue(5000), new com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.AnonymousClass1());
    }

    private static java.lang.Long calcObjectCRCFromParts(java.util.List<com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.DownloadPartResult> list) {
        long j = 0;
        for (com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.DownloadPartResult downloadPartResult : list) {
            java.lang.Long l = downloadPartResult.clientCRC;
            if (l == null || downloadPartResult.length <= 0) {
                return null;
            }
            j = com.alibaba.sdk.android.oss.common.utils.CRC64.combine(j, l.longValue(), downloadPartResult.length);
        }
        return new java.lang.Long(j);
    }

    private long ceilPartSize(long j) {
        return ((j + 4095) / 4096) * 4096;
    }

    private void checkPartSize(long j, int[] iArr) {
        long partSize = this.mRequest.getPartSize();
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[checkPartSize] - mFileLength : " + j);
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[checkPartSize] - partSize : " + partSize);
        long j2 = j / partSize;
        if (j % partSize != 0) {
            j2++;
        }
        if (j2 != 1) {
            if (j2 > 5000) {
                partSize = ceilPartSize(j / 4999);
                j2 = (j / partSize) + (j % partSize == 0 ? 0L : 1L);
            }
            j = partSize;
        }
        int i = (int) j;
        iArr[0] = i;
        iArr[1] = (int) j2;
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[checkPartSize] - partNumber : " + j2);
        com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[checkPartSize] - partSize : " + i);
    }

    private void copyFile(java.io.InputStream inputStream, java.io.OutputStream outputStream) throws java.io.IOException {
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, read);
            }
        }
    }

    private com.alibaba.sdk.android.oss.model.Range correctRange(com.alibaba.sdk.android.oss.model.Range range, long j) {
        if (range != null) {
            r0 = range.getBegin() != -1 ? range.getBegin() : 0L;
            j = range.getEnd() == -1 ? j - r0 : range.getEnd() - range.getBegin();
        }
        return new com.alibaba.sdk.android.oss.model.Range(r0, j + r0);
    }

    private void createFile(java.lang.String str, long j) throws java.io.IOException {
        java.io.RandomAccessFile randomAccessFile;
        java.lang.Throwable th;
        try {
            randomAccessFile = new java.io.RandomAccessFile(new java.io.File(str), "rw");
            try {
                randomAccessFile.setLength(j);
                randomAccessFile.close();
            } catch (java.lang.Throwable th2) {
                th = th2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        } catch (java.lang.Throwable th3) {
            randomAccessFile = null;
            th = th3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0187 A[Catch: IOException -> 0x0183, TRY_LEAVE, TryCatch #2 {IOException -> 0x0183, blocks: (B:69:0x017f, B:62:0x0187), top: B:68:0x017f }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x017f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void downloadPart(com.alibaba.sdk.android.oss.internal.ResumableDownloadTask<Requst, Result>.DownloadFileResult downloadFileResult, com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.DownloadPart downloadPart) {
        java.io.InputStream inputStream;
        java.io.RandomAccessFile randomAccessFile = null;
        r0 = null;
        java.io.InputStream inputStream2 = null;
        randomAccessFile = null;
        try {
            try {
                if (this.mContext.getCancellationHandler().isCancelled()) {
                    this.mPoolExecutor.getQueue().clear();
                }
                this.downloadPartSize++;
                java.io.RandomAccessFile randomAccessFile2 = new java.io.RandomAccessFile(this.mRequest.getTempFilePath(), "rw");
                try {
                    randomAccessFile2.seek(downloadPart.fileStart);
                    java.util.Map<java.lang.String, java.lang.String> requestHeader = this.mRequest.getRequestHeader();
                    com.alibaba.sdk.android.oss.model.GetObjectRequest getObjectRequest = new com.alibaba.sdk.android.oss.model.GetObjectRequest(this.mRequest.getBucketName(), this.mRequest.getObjectKey());
                    getObjectRequest.setRange(new com.alibaba.sdk.android.oss.model.Range(downloadPart.start, downloadPart.end));
                    getObjectRequest.setRequestHeaders(requestHeader);
                    com.alibaba.sdk.android.oss.model.GetObjectResult result = this.mOperation.getObject(getObjectRequest, null).getResult();
                    inputStream2 = result.getObjectContent();
                    byte[] bArr = new byte[(int) downloadPart.length];
                    if (this.mRequest.getCRC64() == com.alibaba.sdk.android.oss.model.OSSRequest.CRC64Config.YES) {
                        inputStream2 = new java.util.zip.CheckedInputStream(inputStream2, new com.alibaba.sdk.android.oss.common.utils.CRC64());
                    }
                    while (true) {
                        long read = inputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        } else {
                            randomAccessFile2.write(bArr, 0, (int) read);
                        }
                    }
                    synchronized (this.mLock) {
                        com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.DownloadPartResult downloadPartResult = new com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.DownloadPartResult();
                        downloadPartResult.partNumber = downloadPart.partNumber;
                        downloadPartResult.requestId = result.getRequestId();
                        downloadPartResult.length = result.getContentLength();
                        if (this.mRequest.getCRC64() == com.alibaba.sdk.android.oss.model.OSSRequest.CRC64Config.YES) {
                            java.lang.Long valueOf = java.lang.Long.valueOf(((java.util.zip.CheckedInputStream) inputStream2).getChecksum().getValue());
                            downloadPartResult.clientCRC = valueOf;
                            downloadPart.crc = valueOf.longValue();
                        }
                        downloadFileResult.partResults.add(downloadPartResult);
                        if (downloadFileResult.metadata == null) {
                            downloadFileResult.metadata = result.getMetadata();
                        }
                        this.completedPartSize++;
                        if (!this.mContext.getCancellationHandler().isCancelled()) {
                            if (this.mCheckPoint.parts.size() == this.completedPartSize - this.mPartExceptionCount) {
                                notifyMultipartThread();
                            }
                            this.mCheckPoint.update(downloadPart.partNumber, true);
                            if (this.mRequest.getEnableCheckPoint().booleanValue()) {
                                this.mCheckPoint.dump(this.checkpointPath);
                            }
                            com.alibaba.sdk.android.oss.model.Range correctRange = correctRange(this.mRequest.getRange(), this.mCheckPoint.fileStat.fileLength);
                            com.alibaba.sdk.android.oss.callback.OSSProgressCallback oSSProgressCallback = this.mProgressCallback;
                            if (oSSProgressCallback != null) {
                                oSSProgressCallback.onProgress(this.mRequest, this.mCheckPoint.downloadLength, correctRange.getEnd() - correctRange.getBegin());
                            }
                        } else if (this.downloadPartSize == this.completedPartSize - this.mPartExceptionCount) {
                            checkCancel();
                        }
                    }
                    randomAccessFile2.close();
                    inputStream2.close();
                } catch (java.lang.Exception e) {
                    e = e;
                    inputStream = inputStream2;
                    randomAccessFile = randomAccessFile2;
                    try {
                        processException(e);
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (java.io.IOException e2) {
                                com.alibaba.sdk.android.oss.common.OSSLog.logThrowable2Local(e2);
                                throw th;
                            }
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        throw th;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    inputStream = inputStream2;
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                    }
                    if (inputStream != null) {
                    }
                    throw th;
                }
            } catch (java.io.IOException e3) {
                com.alibaba.sdk.android.oss.common.OSSLog.logThrowable2Local(e3);
            }
        } catch (java.lang.Exception e4) {
            e = e4;
            inputStream = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            inputStream = null;
        }
    }

    private void initCheckPoint() throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException, java.io.IOException {
        com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.FileStat fileStat = com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.FileStat.getFileStat(this.mOperation, this.mRequest.getBucketName(), this.mRequest.getObjectKey());
        com.alibaba.sdk.android.oss.model.Range correctRange = correctRange(this.mRequest.getRange(), fileStat.fileLength);
        createFile(this.mRequest.getTempFilePath(), correctRange.getEnd() - correctRange.getBegin());
        this.mCheckPoint.bucketName = this.mRequest.getBucketName();
        this.mCheckPoint.objectKey = this.mRequest.getObjectKey();
        com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.CheckPoint checkPoint = this.mCheckPoint;
        checkPoint.fileStat = fileStat;
        checkPoint.parts = splitFile(correctRange, fileStat.fileLength, this.mRequest.getPartSize());
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void moveFile(java.io.File file, java.io.File file2) throws java.io.IOException {
        java.io.FileOutputStream fileOutputStream;
        if (file.renameTo(file2)) {
            return;
        }
        java.io.FileInputStream fileInputStream = null;
        try {
            java.io.FileInputStream fileInputStream2 = new java.io.FileInputStream(file);
            try {
                fileOutputStream = new java.io.FileOutputStream(file2);
            } catch (java.io.FileNotFoundException e) {
                e = e;
                fileOutputStream = null;
            } catch (java.lang.Throwable th) {
                th = th;
                fileOutputStream = null;
            }
            try {
                copyFile(fileInputStream2, fileOutputStream);
                if (file.delete()) {
                    fileInputStream2.close();
                    fileOutputStream.close();
                } else {
                    throw new java.io.IOException("Failed to delete original file '" + file + "'");
                }
            } catch (java.io.FileNotFoundException e2) {
                e = e2;
                fileInputStream = fileInputStream2;
                try {
                    throw e;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                throw th;
            }
        } catch (java.io.FileNotFoundException e3) {
            e = e3;
            fileOutputStream = null;
        } catch (java.lang.Throwable th4) {
            th = th4;
            fileOutputStream = null;
        }
    }

    private java.util.ArrayList<com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.DownloadPart> splitFile(com.alibaba.sdk.android.oss.model.Range range, long j, long j2) {
        long j3;
        int i = 0;
        if (j <= 0) {
            com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.DownloadPart downloadPart = new com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.DownloadPart();
            downloadPart.start = 0L;
            downloadPart.end = -1L;
            downloadPart.length = 0L;
            downloadPart.partNumber = 0;
            java.util.ArrayList<com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.DownloadPart> arrayList = new java.util.ArrayList<>();
            arrayList.add(downloadPart);
            return arrayList;
        }
        long begin = range.getBegin();
        long end = range.getEnd() - range.getBegin();
        int[] iArr = new int[2];
        checkPartSize(end, iArr);
        long j4 = iArr[0];
        long j5 = iArr[1];
        java.util.ArrayList<com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.DownloadPart> arrayList2 = new java.util.ArrayList<>();
        while (true) {
            long j6 = i;
            if (j6 >= j5) {
                return arrayList2;
            }
            com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.DownloadPart downloadPart2 = new com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.DownloadPart();
            long j7 = j6 * j4;
            long j8 = begin + j7;
            downloadPart2.start = j8;
            int i2 = i + 1;
            long j9 = j5;
            long j10 = ((i2 * j4) + begin) - 1;
            downloadPart2.end = j10;
            long j11 = j4;
            downloadPart2.length = (j10 - j8) + 1;
            long j12 = begin + end;
            if (j10 >= j12) {
                j3 = -1;
                downloadPart2.end = -1L;
                downloadPart2.length = j12 - j8;
            } else {
                j3 = -1;
            }
            downloadPart2.partNumber = i;
            downloadPart2.fileStart = j7;
            arrayList2.add(downloadPart2);
            i = i2;
            j4 = j11;
            j5 = j9;
        }
    }

    @Override // java.util.concurrent.Callable
    public Result call() throws java.lang.Exception {
        try {
            checkInitData();
            Result result = (Result) doMultipartDownload();
            com.alibaba.sdk.android.oss.callback.OSSCompletedCallback oSSCompletedCallback = this.mCompletedCallback;
            if (oSSCompletedCallback != null) {
                oSSCompletedCallback.onSuccess(this.mRequest, result);
            }
            return result;
        } catch (com.alibaba.sdk.android.oss.ServiceException e) {
            com.alibaba.sdk.android.oss.callback.OSSCompletedCallback oSSCompletedCallback2 = this.mCompletedCallback;
            if (oSSCompletedCallback2 != null) {
                oSSCompletedCallback2.onFailure(this.mRequest, null, e);
            }
            throw e;
        } catch (java.lang.Exception e2) {
            com.alibaba.sdk.android.oss.ClientException clientException = e2 instanceof com.alibaba.sdk.android.oss.ClientException ? (com.alibaba.sdk.android.oss.ClientException) e2 : new com.alibaba.sdk.android.oss.ClientException(e2.toString(), e2);
            com.alibaba.sdk.android.oss.callback.OSSCompletedCallback oSSCompletedCallback3 = this.mCompletedCallback;
            if (oSSCompletedCallback3 != null) {
                oSSCompletedCallback3.onFailure(this.mRequest, clientException, null);
            }
            throw clientException;
        }
    }

    public void checkCancel() throws com.alibaba.sdk.android.oss.ClientException {
        if (this.mContext.getCancellationHandler().isCancelled()) {
            com.alibaba.sdk.android.oss.TaskCancelException taskCancelException = new com.alibaba.sdk.android.oss.TaskCancelException("Resumable download cancel");
            throw new com.alibaba.sdk.android.oss.ClientException(taskCancelException.getMessage(), taskCancelException, java.lang.Boolean.TRUE);
        }
    }

    public void checkException() throws java.io.IOException, com.alibaba.sdk.android.oss.ServiceException, com.alibaba.sdk.android.oss.ClientException {
        if (this.mDownloadException != null) {
            releasePool();
            java.lang.Exception exc = this.mDownloadException;
            if (exc instanceof java.io.IOException) {
                throw ((java.io.IOException) exc);
            }
            if (exc instanceof com.alibaba.sdk.android.oss.ServiceException) {
                throw ((com.alibaba.sdk.android.oss.ServiceException) exc);
            }
            if (!(exc instanceof com.alibaba.sdk.android.oss.ClientException)) {
                throw new com.alibaba.sdk.android.oss.ClientException(this.mDownloadException.getMessage(), this.mDownloadException);
            }
            throw ((com.alibaba.sdk.android.oss.ClientException) exc);
        }
    }

    public void checkInitData() throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException, java.io.IOException {
        if (this.mRequest.getRange() != null && !this.mRequest.getRange().checkIsValid()) {
            throw new com.alibaba.sdk.android.oss.ClientException("Range is invalid");
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(this.mRequest.getBucketName());
        sb.append(this.mRequest.getObjectKey());
        sb.append(java.lang.String.valueOf(this.mRequest.getPartSize()));
        sb.append(this.mRequest.getCRC64() == com.alibaba.sdk.android.oss.model.OSSRequest.CRC64Config.YES ? "-crc64" : "");
        this.checkpointPath = this.mRequest.getCheckPointFilePath() + java.io.File.separator + com.alibaba.sdk.android.oss.common.utils.BinaryUtil.calculateMd5Str(sb.toString().getBytes());
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append(this.checkpointPath);
        sb2.append(".temp");
        java.lang.String sb3 = sb2.toString();
        this.mCheckPoint = new com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.CheckPoint();
        if (!this.mRequest.getEnableCheckPoint().booleanValue()) {
            initCheckPoint();
            return;
        }
        try {
            this.mCheckPoint.load(this.checkpointPath);
        } catch (java.lang.Exception unused) {
            removeFile(this.checkpointPath);
            removeFile(sb3);
            removeFile(this.mRequest.getTempFilePath());
        }
        if (this.mCheckPoint.isValid(this.mOperation)) {
            return;
        }
        removeFile(this.checkpointPath);
        removeFile(sb3);
        removeFile(this.mRequest.getTempFilePath());
        initCheckPoint();
    }

    public boolean checkWaitCondition(int i) {
        return this.completedPartSize != ((long) i);
    }

    public com.alibaba.sdk.android.oss.model.ResumableDownloadResult doMultipartDownload() throws com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException, java.io.IOException, java.lang.InterruptedException {
        java.lang.String str = this.checkpointPath + ".temp";
        checkCancel();
        com.alibaba.sdk.android.oss.model.ResumableDownloadResult resumableDownloadResult = new com.alibaba.sdk.android.oss.model.ResumableDownloadResult();
        com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.DownloadFileResult downloadFileResult = new com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.DownloadFileResult();
        downloadFileResult.partResults = new java.util.ArrayList<>();
        java.util.Iterator<com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.DownloadPart> it = this.mCheckPoint.parts.iterator();
        while (it.hasNext()) {
            com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.DownloadPart next = it.next();
            checkException();
            java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = this.mPoolExecutor;
            if (threadPoolExecutor == null || next.isCompleted) {
                com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.DownloadPartResult downloadPartResult = new com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.DownloadPartResult();
                downloadPartResult.partNumber = next.partNumber;
                downloadPartResult.requestId = this.mCheckPoint.fileStat.requestId;
                downloadPartResult.length = next.length;
                if (this.mRequest.getCRC64() == com.alibaba.sdk.android.oss.model.OSSRequest.CRC64Config.YES) {
                    downloadPartResult.clientCRC = java.lang.Long.valueOf(next.crc);
                }
                downloadFileResult.partResults.add(downloadPartResult);
                this.downloadPartSize++;
                this.completedPartSize++;
            } else {
                threadPoolExecutor.execute(new com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.AnonymousClass2(downloadFileResult, next));
            }
        }
        if (checkWaitCondition(this.mCheckPoint.parts.size())) {
            synchronized (this.mLock) {
                this.mLock.wait();
            }
        }
        checkException();
        java.util.Collections.sort(downloadFileResult.partResults, new com.alibaba.sdk.android.oss.internal.ResumableDownloadTask.AnonymousClass3());
        if (this.mRequest.getCRC64() == com.alibaba.sdk.android.oss.model.OSSRequest.CRC64Config.YES && this.mRequest.getRange() == null) {
            java.lang.Long calcObjectCRCFromParts = calcObjectCRCFromParts(downloadFileResult.partResults);
            resumableDownloadResult.setClientCRC(calcObjectCRCFromParts);
            try {
                com.alibaba.sdk.android.oss.common.utils.OSSUtils.checkChecksum(calcObjectCRCFromParts, this.mCheckPoint.fileStat.serverCRC, downloadFileResult.partResults.get(0).requestId);
            } catch (com.alibaba.sdk.android.oss.exception.InconsistentException e) {
                removeFile(this.checkpointPath);
                removeFile(str);
                removeFile(this.mRequest.getTempFilePath());
                throw e;
            }
        }
        removeFile(this.checkpointPath);
        removeFile(str);
        moveFile(new java.io.File(this.mRequest.getTempFilePath()), new java.io.File(this.mRequest.getDownloadToFilePath()));
        resumableDownloadResult.setServerCRC(this.mCheckPoint.fileStat.serverCRC);
        resumableDownloadResult.setMetadata(downloadFileResult.metadata);
        resumableDownloadResult.setRequestId(downloadFileResult.partResults.get(0).requestId);
        resumableDownloadResult.setStatusCode(200);
        return resumableDownloadResult;
    }

    public void notifyMultipartThread() {
        this.mLock.notify();
        this.mPartExceptionCount = 0L;
    }

    public void processException(java.lang.Exception exc) {
        synchronized (this.mLock) {
            this.mPartExceptionCount++;
            if (this.mDownloadException == null) {
                this.mDownloadException = exc;
                this.mLock.notify();
            }
        }
    }

    public void releasePool() {
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = this.mPoolExecutor;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.getQueue().clear();
            this.mPoolExecutor.shutdown();
        }
    }

    public boolean removeFile(java.lang.String str) {
        java.io.File file = new java.io.File(str);
        if (file.isFile() && file.exists()) {
            return file.delete();
        }
        return false;
    }
}
