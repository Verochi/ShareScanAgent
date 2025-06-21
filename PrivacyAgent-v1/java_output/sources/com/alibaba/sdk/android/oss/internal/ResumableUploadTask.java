package com.alibaba.sdk.android.oss.internal;

/* loaded from: classes.dex */
public class ResumableUploadTask extends com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask<com.alibaba.sdk.android.oss.model.ResumableUploadRequest, com.alibaba.sdk.android.oss.model.ResumableUploadResult> {
    private com.alibaba.sdk.android.oss.model.ResumableUploadRequest.ExceptionTerminationMode exceptionTerminationMode;
    private java.util.List<java.lang.Integer> mAlreadyUploadIndex;
    private java.io.File mCRC64RecordFile;
    private java.io.File mRecordFile;
    private com.alibaba.sdk.android.oss.common.utils.OSSSharedPreferences mSp;

    /* renamed from: com.alibaba.sdk.android.oss.internal.ResumableUploadTask$1, reason: invalid class name */
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
            com.alibaba.sdk.android.oss.internal.ResumableUploadTask.this.uploadPart(this.val$readIndex, this.val$byteCount, this.val$partNumber);
        }
    }

    public ResumableUploadTask(com.alibaba.sdk.android.oss.model.ResumableUploadRequest resumableUploadRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.ResumableUploadRequest, com.alibaba.sdk.android.oss.model.ResumableUploadResult> oSSCompletedCallback, com.alibaba.sdk.android.oss.network.ExecutionContext executionContext, com.alibaba.sdk.android.oss.internal.InternalRequestOperation internalRequestOperation) {
        super(internalRequestOperation, resumableUploadRequest, oSSCompletedCallback, executionContext);
        this.mAlreadyUploadIndex = new java.util.ArrayList();
        this.mSp = com.alibaba.sdk.android.oss.common.utils.OSSSharedPreferences.instance(this.mContext.getApplicationContext());
        this.exceptionTerminationMode = resumableUploadRequest.getExceptionTerminationMode();
    }

    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    public void abortThisUpload() {
        if (this.mUploadId != null) {
            this.mApiOperation.abortMultipartUpload(new com.alibaba.sdk.android.oss.model.AbortMultipartUploadRequest(((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.mRequest).getBucketName(), ((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.mRequest).getObjectKey(), this.mUploadId), null).waitUntilFinished();
        }
    }

    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    public void checkException() throws java.io.IOException, com.alibaba.sdk.android.oss.ServiceException, com.alibaba.sdk.android.oss.ClientException {
        java.io.ObjectOutputStream objectOutputStream;
        if (this.mContext.getCancellationHandler().isCancelled()) {
            if (((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.mRequest).deleteUploadOnCancelling().booleanValue()) {
                abortThisUpload();
                java.io.File file = this.mRecordFile;
                if (file != null) {
                    file.delete();
                }
            } else {
                java.util.List<com.alibaba.sdk.android.oss.model.PartETag> list = this.mPartETags;
                if (list != null && list.size() > 0 && this.mCheckCRC64 && ((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.mRequest).getRecordDirectory() != null) {
                    java.util.HashMap hashMap = new java.util.HashMap();
                    for (com.alibaba.sdk.android.oss.model.PartETag partETag : this.mPartETags) {
                        hashMap.put(java.lang.Integer.valueOf(partETag.getPartNumber()), java.lang.Long.valueOf(partETag.getCRC64()));
                    }
                    java.io.ObjectOutputStream objectOutputStream2 = null;
                    try {
                        try {
                            java.io.File file2 = new java.io.File(((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.mRequest).getRecordDirectory() + java.io.File.separator + this.mUploadId);
                            this.mCRC64RecordFile = file2;
                            if (!file2.exists()) {
                                this.mCRC64RecordFile.createNewFile();
                            }
                            objectOutputStream = new java.io.ObjectOutputStream(new java.io.FileOutputStream(this.mCRC64RecordFile));
                        } catch (java.lang.Throwable th) {
                            th = th;
                        }
                    } catch (java.io.IOException e) {
                        e = e;
                    }
                    try {
                        objectOutputStream.writeObject(hashMap);
                        objectOutputStream.close();
                    } catch (java.io.IOException e2) {
                        e = e2;
                        objectOutputStream2 = objectOutputStream;
                        com.alibaba.sdk.android.oss.common.OSSLog.logThrowable2Local(e);
                        if (objectOutputStream2 != null) {
                            objectOutputStream2.close();
                        }
                        super.checkException();
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        objectOutputStream2 = objectOutputStream;
                        if (objectOutputStream2 != null) {
                            objectOutputStream2.close();
                        }
                        throw th;
                    }
                }
            }
        }
        super.checkException();
    }

    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    public com.alibaba.sdk.android.oss.model.ResumableUploadResult doMultipartUpload() throws java.io.IOException, com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException, java.lang.InterruptedException {
        java.util.concurrent.ThreadPoolExecutor threadPoolExecutor;
        long j = this.mUploadedLength;
        checkCancel();
        int[] iArr = this.mPartAttr;
        int i = iArr[0];
        int i2 = iArr[1];
        if (this.mPartETags.size() > 0 && this.mAlreadyUploadIndex.size() > 0) {
            long j2 = this.mUploadedLength;
            if (j2 > this.mFileLength) {
                throw new com.alibaba.sdk.android.oss.ClientException("The uploading file is inconsistent with before");
            }
            if (!android.text.TextUtils.isEmpty(this.mSp.getStringValue(this.mUploadId))) {
                j2 = java.lang.Long.valueOf(this.mSp.getStringValue(this.mUploadId)).longValue();
            }
            long j3 = j2;
            com.alibaba.sdk.android.oss.callback.OSSProgressCallback<Request> oSSProgressCallback = this.mProgressCallback;
            if (oSSProgressCallback != 0) {
                oSSProgressCallback.onProgress(this.mRequest, j3, this.mFileLength);
            }
            this.mSp.removeKey(this.mUploadId);
        }
        this.mRunPartTaskCount = this.mPartETags.size();
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.exceptionTerminationMode == com.alibaba.sdk.android.oss.model.ResumableUploadRequest.ExceptionTerminationMode.EXCEPTION) {
                checkException();
            }
            if ((this.mAlreadyUploadIndex.size() == 0 || !this.mAlreadyUploadIndex.contains(java.lang.Integer.valueOf(i3 + 1))) && (threadPoolExecutor = this.mPoolExecutor) != null) {
                if (i3 == i2 - 1) {
                    i = (int) (this.mFileLength - j);
                }
                j += i;
                threadPoolExecutor.execute(new com.alibaba.sdk.android.oss.internal.ResumableUploadTask.AnonymousClass1(i3, i, i2));
            }
        }
        if (checkWaitCondition(i2)) {
            synchronized (this.mLock) {
                this.mLock.wait();
            }
        }
        checkException();
        com.alibaba.sdk.android.oss.model.CompleteMultipartUploadResult completeMultipartUploadResult = completeMultipartUploadResult();
        com.alibaba.sdk.android.oss.model.ResumableUploadResult resumableUploadResult = completeMultipartUploadResult != null ? new com.alibaba.sdk.android.oss.model.ResumableUploadResult(completeMultipartUploadResult) : null;
        java.io.File file = this.mRecordFile;
        if (file != null) {
            file.delete();
        }
        java.io.File file2 = this.mCRC64RecordFile;
        if (file2 != null) {
            file2.delete();
        }
        releasePool();
        return resumableUploadResult;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01cd A[Catch: ServiceException -> 0x0312, ClientException -> 0x0318, TRY_LEAVE, TryCatch #0 {ClientException -> 0x0318, blocks: (B:34:0x01ad, B:37:0x01bb, B:38:0x01c7, B:40:0x01cd, B:42:0x01e9, B:44:0x01ef, B:46:0x01fd, B:47:0x0212, B:79:0x0261, B:82:0x0269, B:54:0x02a6, B:73:0x02b2, B:74:0x02d8, B:58:0x02df, B:86:0x0270, B:87:0x0296), top: B:33:0x01ad }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0331 A[LOOP:0: B:29:0x0187->B:67:0x0331, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x033a A[EDGE_INSN: B:68:0x033a->B:116:0x033a BREAK  A[LOOP:0: B:29:0x0187->B:67:0x0331], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0339 A[SYNTHETIC] */
    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void initMultipartUploadId() throws java.io.IOException, com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException {
        java.lang.String calculateMd5Str;
        java.util.Map map;
        char c;
        int i;
        java.lang.String str;
        java.util.Map map2;
        boolean z;
        java.util.List<com.alibaba.sdk.android.oss.model.PartSummary> parts;
        int i2;
        int i3;
        java.lang.String str2 = "[initUploadId] -  ";
        com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.ListPartsRequest, com.alibaba.sdk.android.oss.model.ListPartsResult> oSSCompletedCallback = null;
        if (!com.alibaba.sdk.android.oss.common.utils.OSSUtils.isEmptyString(((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.mRequest).getRecordDirectory())) {
            if (this.mUploadUri != null) {
                com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[initUploadId] - mUploadFilePath : " + this.mUploadUri.getPath());
                android.os.ParcelFileDescriptor openFileDescriptor = this.mContext.getApplicationContext().getContentResolver().openFileDescriptor(this.mUploadUri, "r");
                try {
                    calculateMd5Str = com.alibaba.sdk.android.oss.common.utils.BinaryUtil.calculateMd5Str(openFileDescriptor.getFileDescriptor());
                    openFileDescriptor.close();
                } catch (java.lang.Throwable th) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    throw th;
                }
            } else {
                com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[initUploadId] - mUploadFilePath : " + this.mUploadFilePath);
                calculateMd5Str = com.alibaba.sdk.android.oss.common.utils.BinaryUtil.calculateMd5Str(this.mUploadFilePath);
            }
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[initUploadId] - mRequest.getPartSize() : " + ((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.mRequest).getPartSize());
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(calculateMd5Str);
            sb.append(((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.mRequest).getBucketName());
            sb.append(((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.mRequest).getObjectKey());
            sb.append(java.lang.String.valueOf(((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.mRequest).getPartSize()));
            sb.append(this.mCheckCRC64 ? "-crc64" : "");
            java.lang.String calculateMd5Str2 = com.alibaba.sdk.android.oss.common.utils.BinaryUtil.calculateMd5Str(sb.toString().getBytes());
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append(((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.mRequest).getRecordDirectory());
            java.lang.String str3 = java.io.File.separator;
            sb2.append(str3);
            sb2.append(calculateMd5Str2);
            java.io.File file = new java.io.File(sb2.toString());
            this.mRecordFile = file;
            if (file.exists()) {
                java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.FileReader(this.mRecordFile));
                this.mUploadId = bufferedReader.readLine();
                bufferedReader.close();
            }
            com.alibaba.sdk.android.oss.common.OSSLog.logDebug("[initUploadId] - mUploadId : " + this.mUploadId);
            if (!com.alibaba.sdk.android.oss.common.utils.OSSUtils.isEmptyString(this.mUploadId)) {
                if (this.mCheckCRC64) {
                    java.io.File file2 = new java.io.File(((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.mRequest).getRecordDirectory() + str3 + this.mUploadId);
                    if (file2.exists()) {
                        java.io.ObjectInputStream objectInputStream = new java.io.ObjectInputStream(new java.io.FileInputStream(file2));
                        try {
                            try {
                                map = (java.util.Map) objectInputStream.readObject();
                            } catch (java.lang.ClassNotFoundException e) {
                                e = e;
                                map = null;
                            }
                            try {
                                file2.delete();
                            } catch (java.lang.ClassNotFoundException e2) {
                                e = e2;
                                com.alibaba.sdk.android.oss.common.OSSLog.logThrowable2Local(e);
                                c = 0;
                                i = 0;
                                while (true) {
                                    com.alibaba.sdk.android.oss.model.ListPartsRequest listPartsRequest = new com.alibaba.sdk.android.oss.model.ListPartsRequest(((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.mRequest).getBucketName(), ((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.mRequest).getObjectKey(), this.mUploadId);
                                    if (i > 0) {
                                    }
                                    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.ListPartsResult> listParts = this.mApiOperation.listParts(listPartsRequest, oSSCompletedCallback);
                                    try {
                                        try {
                                            com.alibaba.sdk.android.oss.model.ListPartsResult result = listParts.getResult();
                                            z = result.isTruncated();
                                            i = result.getNextPartNumberMarker();
                                        } catch (com.alibaba.sdk.android.oss.ClientException e3) {
                                            throw e3;
                                        }
                                    } catch (com.alibaba.sdk.android.oss.ServiceException e4) {
                                        e = e4;
                                        str = str2;
                                    }
                                    try {
                                        parts = result.getParts();
                                        int[] iArr = this.mPartAttr;
                                        int i4 = iArr[c];
                                        int i5 = iArr[1];
                                        i2 = 0;
                                        while (i2 < parts.size()) {
                                        }
                                        str = str2;
                                        map2 = map;
                                    } catch (com.alibaba.sdk.android.oss.ServiceException e5) {
                                        e = e5;
                                        str = str2;
                                        map2 = map;
                                        if (e.getStatusCode() == 404) {
                                        }
                                    }
                                    listParts.waitUntilFinished();
                                    if (z) {
                                    }
                                    str2 = str;
                                    map = map2;
                                    oSSCompletedCallback = null;
                                    c = 0;
                                }
                            }
                            c = 0;
                            i = 0;
                            while (true) {
                                com.alibaba.sdk.android.oss.model.ListPartsRequest listPartsRequest2 = new com.alibaba.sdk.android.oss.model.ListPartsRequest(((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.mRequest).getBucketName(), ((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.mRequest).getObjectKey(), this.mUploadId);
                                if (i > 0) {
                                    listPartsRequest2.setPartNumberMarker(java.lang.Integer.valueOf(i));
                                }
                                com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.ListPartsResult> listParts2 = this.mApiOperation.listParts(listPartsRequest2, oSSCompletedCallback);
                                com.alibaba.sdk.android.oss.model.ListPartsResult result2 = listParts2.getResult();
                                z = result2.isTruncated();
                                i = result2.getNextPartNumberMarker();
                                parts = result2.getParts();
                                int[] iArr2 = this.mPartAttr;
                                int i42 = iArr2[c];
                                int i52 = iArr2[1];
                                i2 = 0;
                                while (i2 < parts.size()) {
                                    com.alibaba.sdk.android.oss.model.PartSummary partSummary = parts.get(i2);
                                    com.alibaba.sdk.android.oss.model.PartETag partETag = new com.alibaba.sdk.android.oss.model.PartETag(partSummary.getPartNumber(), partSummary.getETag());
                                    partETag.setPartSize(partSummary.getSize());
                                    if (map != null && map.size() > 0 && map.containsKey(java.lang.Integer.valueOf(partETag.getPartNumber()))) {
                                        partETag.setCRC64(((java.lang.Long) map.get(java.lang.Integer.valueOf(partETag.getPartNumber()))).longValue());
                                    }
                                    com.alibaba.sdk.android.oss.common.OSSLog.logDebug(str2 + i2 + " part.getPartNumber() : " + partSummary.getPartNumber());
                                    java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                                    sb3.append(str2);
                                    sb3.append(i2);
                                    sb3.append(" part.getSize() : ");
                                    int i6 = i2;
                                    sb3.append(partSummary.getSize());
                                    com.alibaba.sdk.android.oss.common.OSSLog.logDebug(sb3.toString());
                                    boolean z2 = partSummary.getPartNumber() == i52;
                                    if (z2) {
                                        try {
                                            i3 = i;
                                            map2 = map;
                                            try {
                                                if (partSummary.getSize() != this.mLastPartSize) {
                                                    throw new com.alibaba.sdk.android.oss.ClientException("current part size " + partSummary.getSize() + " setting is inconsistent with PartSize : " + i42 + " or lastPartSize : " + this.mLastPartSize);
                                                }
                                            } catch (com.alibaba.sdk.android.oss.ServiceException e6) {
                                                e = e6;
                                                str = str2;
                                                i = i3;
                                                if (e.getStatusCode() == 404) {
                                                    throw e;
                                                }
                                                this.mUploadId = null;
                                                z = false;
                                                listParts2.waitUntilFinished();
                                                if (z) {
                                                }
                                            }
                                        } catch (com.alibaba.sdk.android.oss.ServiceException e7) {
                                            e = e7;
                                            map2 = map;
                                            str = str2;
                                            if (e.getStatusCode() == 404) {
                                            }
                                        }
                                    } else {
                                        i3 = i;
                                        map2 = map;
                                    }
                                    if (z2) {
                                        str = str2;
                                    } else {
                                        str = str2;
                                        if (partSummary.getSize() != i42) {
                                            throw new com.alibaba.sdk.android.oss.ClientException("current part size " + partSummary.getSize() + " setting is inconsistent with PartSize : " + i42 + " or lastPartSize : " + this.mLastPartSize);
                                        }
                                    }
                                    try {
                                        this.mPartETags.add(partETag);
                                        this.mUploadedLength += partSummary.getSize();
                                        this.mAlreadyUploadIndex.add(java.lang.Integer.valueOf(partSummary.getPartNumber()));
                                        i2 = i6 + 1;
                                        str2 = str;
                                        map = map2;
                                        i = i3;
                                    } catch (com.alibaba.sdk.android.oss.ServiceException e8) {
                                        e = e8;
                                        i = i3;
                                        if (e.getStatusCode() == 404) {
                                        }
                                    }
                                }
                                str = str2;
                                map2 = map;
                                listParts2.waitUntilFinished();
                                if (z) {
                                    break;
                                }
                                str2 = str;
                                map = map2;
                                oSSCompletedCallback = null;
                                c = 0;
                            }
                        } finally {
                            objectInputStream.close();
                            file2.delete();
                        }
                    }
                }
                map = null;
                c = 0;
                i = 0;
                while (true) {
                    com.alibaba.sdk.android.oss.model.ListPartsRequest listPartsRequest22 = new com.alibaba.sdk.android.oss.model.ListPartsRequest(((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.mRequest).getBucketName(), ((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.mRequest).getObjectKey(), this.mUploadId);
                    if (i > 0) {
                    }
                    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.ListPartsResult> listParts22 = this.mApiOperation.listParts(listPartsRequest22, oSSCompletedCallback);
                    com.alibaba.sdk.android.oss.model.ListPartsResult result22 = listParts22.getResult();
                    z = result22.isTruncated();
                    i = result22.getNextPartNumberMarker();
                    parts = result22.getParts();
                    int[] iArr22 = this.mPartAttr;
                    int i422 = iArr22[c];
                    int i522 = iArr22[1];
                    i2 = 0;
                    while (i2 < parts.size()) {
                    }
                    str = str2;
                    map2 = map;
                    listParts22.waitUntilFinished();
                    if (z) {
                    }
                    str2 = str;
                    map = map2;
                    oSSCompletedCallback = null;
                    c = 0;
                }
            }
            if (!this.mRecordFile.exists() && !this.mRecordFile.createNewFile()) {
                throw new com.alibaba.sdk.android.oss.ClientException("Can't create file at path: " + this.mRecordFile.getAbsolutePath() + "\nPlease make sure the directory exist!");
            }
        }
        if (com.alibaba.sdk.android.oss.common.utils.OSSUtils.isEmptyString(this.mUploadId)) {
            this.mUploadId = this.mApiOperation.initMultipartUpload(new com.alibaba.sdk.android.oss.model.InitiateMultipartUploadRequest(((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.mRequest).getBucketName(), ((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.mRequest).getObjectKey(), ((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.mRequest).getMetadata()), null).getResult().getUploadId();
            if (this.mRecordFile != null) {
                java.io.BufferedWriter bufferedWriter = new java.io.BufferedWriter(new java.io.FileWriter(this.mRecordFile));
                bufferedWriter.write(this.mUploadId);
                bufferedWriter.close();
            }
        }
        ((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.mRequest).setUploadId(this.mUploadId);
    }

    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    public void processException(java.lang.Exception exc) {
        synchronized (this.mLock) {
            this.mPartExceptionCount++;
            this.mUploadException = exc;
            com.alibaba.sdk.android.oss.common.OSSLog.logThrowable2Local(exc);
            if (this.mContext.getCancellationHandler().isCancelled() && !this.mIsCancel) {
                this.mIsCancel = true;
                this.mLock.notify();
            }
            if (this.exceptionTerminationMode == com.alibaba.sdk.android.oss.model.ResumableUploadRequest.ExceptionTerminationMode.EXCEPTION || this.mPartETags.size() == this.mRunPartTaskCount - this.mPartExceptionCount) {
                notifyMultipartThread();
            }
        }
    }

    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    public void uploadPartFinish(com.alibaba.sdk.android.oss.model.PartETag partETag) throws java.lang.Exception {
        if (!this.mContext.getCancellationHandler().isCancelled() || this.mSp.contains(this.mUploadId)) {
            return;
        }
        this.mSp.setStringValue(this.mUploadId, java.lang.String.valueOf(this.mUploadedLength));
        onProgressCallback(this.mRequest, this.mUploadedLength, this.mFileLength);
    }
}
