package com.alibaba.sdk.android.oss.internal;

/* loaded from: classes.dex */
public class SequenceUploadTask extends com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask<com.alibaba.sdk.android.oss.model.ResumableUploadRequest, com.alibaba.sdk.android.oss.model.ResumableUploadResult> {
    private java.util.List<java.lang.Integer> mAlreadyUploadIndex;
    private java.io.File mCRC64RecordFile;
    private long mFirstPartSize;
    private java.io.File mRecordFile;
    private com.alibaba.sdk.android.oss.common.utils.OSSSharedPreferences mSp;

    public SequenceUploadTask(com.alibaba.sdk.android.oss.model.ResumableUploadRequest resumableUploadRequest, com.alibaba.sdk.android.oss.callback.OSSCompletedCallback<com.alibaba.sdk.android.oss.model.ResumableUploadRequest, com.alibaba.sdk.android.oss.model.ResumableUploadResult> oSSCompletedCallback, com.alibaba.sdk.android.oss.network.ExecutionContext executionContext, com.alibaba.sdk.android.oss.internal.InternalRequestOperation internalRequestOperation) {
        super(internalRequestOperation, resumableUploadRequest, oSSCompletedCallback, executionContext);
        this.mAlreadyUploadIndex = new java.util.ArrayList();
        this.mSp = com.alibaba.sdk.android.oss.common.utils.OSSSharedPreferences.instance(this.mContext.getApplicationContext());
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
            if (this.mFirstPartSize != i) {
                throw new com.alibaba.sdk.android.oss.ClientException("The part size setting is inconsistent with before");
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
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.mAlreadyUploadIndex.size() == 0 || !this.mAlreadyUploadIndex.contains(java.lang.Integer.valueOf(i3 + 1))) {
                if (i3 == i2 - 1) {
                    i = (int) (this.mFileLength - j);
                }
                com.alibaba.sdk.android.oss.common.OSSLog.logDebug("upload part readByte : " + i);
                j += (long) i;
                uploadPart(i3, i, i2);
                if (this.mUploadException != null) {
                    break;
                }
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
        return resumableUploadResult;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x017c A[Catch: ClientException -> 0x01e7, ServiceException -> 0x01e9, TryCatch #6 {ClientException -> 0x01e7, ServiceException -> 0x01e9, blocks: (B:34:0x0163, B:35:0x0176, B:37:0x017c, B:39:0x0198, B:41:0x019e, B:43:0x01ac, B:44:0x01c1, B:46:0x01de), top: B:33:0x0163 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0237  */
    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void initMultipartUploadId() throws java.io.IOException, com.alibaba.sdk.android.oss.ClientException, com.alibaba.sdk.android.oss.ServiceException {
        java.lang.String calculateMd5Str;
        java.util.Map map;
        int i;
        boolean z;
        java.util.List<com.alibaba.sdk.android.oss.model.PartSummary> parts;
        int i2;
        if (!com.alibaba.sdk.android.oss.common.utils.OSSUtils.isEmptyString(((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.mRequest).getRecordDirectory())) {
            if (this.mUploadUri != null) {
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
                calculateMd5Str = com.alibaba.sdk.android.oss.common.utils.BinaryUtil.calculateMd5Str(this.mUploadFilePath);
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(calculateMd5Str);
            sb.append(((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.mRequest).getBucketName());
            sb.append(((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.mRequest).getObjectKey());
            sb.append(java.lang.String.valueOf(((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.mRequest).getPartSize()));
            sb.append(this.mCheckCRC64 ? "-crc64" : "");
            sb.append("-sequence");
            java.lang.String calculateMd5Str2 = com.alibaba.sdk.android.oss.common.utils.BinaryUtil.calculateMd5Str(sb.toString().getBytes());
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append(((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.mRequest).getRecordDirectory());
            java.lang.String str = java.io.File.separator;
            sb2.append(str);
            sb2.append(calculateMd5Str2);
            java.io.File file = new java.io.File(sb2.toString());
            this.mRecordFile = file;
            if (file.exists()) {
                java.io.BufferedReader bufferedReader = new java.io.BufferedReader(new java.io.FileReader(this.mRecordFile));
                this.mUploadId = bufferedReader.readLine();
                bufferedReader.close();
                com.alibaba.sdk.android.oss.common.OSSLog.logDebug("sequence [initUploadId] - Found record file, uploadid: " + this.mUploadId);
            }
            if (!com.alibaba.sdk.android.oss.common.utils.OSSUtils.isEmptyString(this.mUploadId)) {
                if (this.mCheckCRC64) {
                    java.io.File file2 = new java.io.File(((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.mRequest).getRecordDirectory() + str + this.mUploadId);
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
                                i = 0;
                                do {
                                    com.alibaba.sdk.android.oss.model.ListPartsRequest listPartsRequest = new com.alibaba.sdk.android.oss.model.ListPartsRequest(((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.mRequest).getBucketName(), ((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.mRequest).getObjectKey(), this.mUploadId);
                                    if (i > 0) {
                                    }
                                    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.ListPartsResult> listParts = this.mApiOperation.listParts(listPartsRequest, null);
                                    try {
                                        com.alibaba.sdk.android.oss.model.ListPartsResult result = listParts.getResult();
                                        z = result.isTruncated();
                                        i = result.getNextPartNumberMarker();
                                        parts = result.getParts();
                                        while (i2 < parts.size()) {
                                        }
                                    } catch (com.alibaba.sdk.android.oss.ClientException e3) {
                                        throw e3;
                                    } catch (com.alibaba.sdk.android.oss.ServiceException e4) {
                                        if (e4.getStatusCode() != 404) {
                                            throw e4;
                                        }
                                        this.mUploadId = null;
                                        z = false;
                                    }
                                    listParts.waitUntilFinished();
                                } while (z);
                                if (!this.mRecordFile.exists()) {
                                    throw new com.alibaba.sdk.android.oss.ClientException("Can't create file at path: " + this.mRecordFile.getAbsolutePath() + "\nPlease make sure the directory exist!");
                                }
                                if (com.alibaba.sdk.android.oss.common.utils.OSSUtils.isEmptyString(this.mUploadId)) {
                                }
                                ((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.mRequest).setUploadId(this.mUploadId);
                            }
                            i = 0;
                            do {
                                com.alibaba.sdk.android.oss.model.ListPartsRequest listPartsRequest2 = new com.alibaba.sdk.android.oss.model.ListPartsRequest(((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.mRequest).getBucketName(), ((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.mRequest).getObjectKey(), this.mUploadId);
                                if (i > 0) {
                                    listPartsRequest2.setPartNumberMarker(java.lang.Integer.valueOf(i));
                                }
                                com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.ListPartsResult> listParts2 = this.mApiOperation.listParts(listPartsRequest2, null);
                                com.alibaba.sdk.android.oss.model.ListPartsResult result2 = listParts2.getResult();
                                z = result2.isTruncated();
                                i = result2.getNextPartNumberMarker();
                                parts = result2.getParts();
                                for (i2 = 0; i2 < parts.size(); i2++) {
                                    com.alibaba.sdk.android.oss.model.PartSummary partSummary = parts.get(i2);
                                    com.alibaba.sdk.android.oss.model.PartETag partETag = new com.alibaba.sdk.android.oss.model.PartETag(partSummary.getPartNumber(), partSummary.getETag());
                                    partETag.setPartSize(partSummary.getSize());
                                    if (map != null && map.size() > 0 && map.containsKey(java.lang.Integer.valueOf(partETag.getPartNumber()))) {
                                        partETag.setCRC64(((java.lang.Long) map.get(java.lang.Integer.valueOf(partETag.getPartNumber()))).longValue());
                                    }
                                    this.mPartETags.add(partETag);
                                    this.mUploadedLength += partSummary.getSize();
                                    this.mAlreadyUploadIndex.add(java.lang.Integer.valueOf(partSummary.getPartNumber()));
                                    if (i2 == 0) {
                                        this.mFirstPartSize = partSummary.getSize();
                                    }
                                }
                                listParts2.waitUntilFinished();
                            } while (z);
                        } finally {
                            objectInputStream.close();
                            file2.delete();
                        }
                    }
                }
                map = null;
                i = 0;
                do {
                    com.alibaba.sdk.android.oss.model.ListPartsRequest listPartsRequest22 = new com.alibaba.sdk.android.oss.model.ListPartsRequest(((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.mRequest).getBucketName(), ((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.mRequest).getObjectKey(), this.mUploadId);
                    if (i > 0) {
                    }
                    com.alibaba.sdk.android.oss.internal.OSSAsyncTask<com.alibaba.sdk.android.oss.model.ListPartsResult> listParts22 = this.mApiOperation.listParts(listPartsRequest22, null);
                    com.alibaba.sdk.android.oss.model.ListPartsResult result22 = listParts22.getResult();
                    z = result22.isTruncated();
                    i = result22.getNextPartNumberMarker();
                    parts = result22.getParts();
                    while (i2 < parts.size()) {
                    }
                    listParts22.waitUntilFinished();
                } while (z);
            }
            if (!this.mRecordFile.exists() && !this.mRecordFile.createNewFile()) {
                throw new com.alibaba.sdk.android.oss.ClientException("Can't create file at path: " + this.mRecordFile.getAbsolutePath() + "\nPlease make sure the directory exist!");
            }
        }
        if (com.alibaba.sdk.android.oss.common.utils.OSSUtils.isEmptyString(this.mUploadId)) {
            com.alibaba.sdk.android.oss.model.InitiateMultipartUploadRequest initiateMultipartUploadRequest = new com.alibaba.sdk.android.oss.model.InitiateMultipartUploadRequest(((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.mRequest).getBucketName(), ((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.mRequest).getObjectKey(), ((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.mRequest).getMetadata());
            initiateMultipartUploadRequest.isSequential = true;
            this.mUploadId = this.mApiOperation.initMultipartUpload(initiateMultipartUploadRequest, null).getResult().getUploadId();
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
        if (this.mUploadException == null || !exc.getMessage().equals(this.mUploadException.getMessage())) {
            this.mUploadException = exc;
        }
        com.alibaba.sdk.android.oss.common.OSSLog.logThrowable2Local(exc);
        if (!this.mContext.getCancellationHandler().isCancelled() || this.mIsCancel) {
            return;
        }
        this.mIsCancel = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0151 A[Catch: all -> 0x01a8, TryCatch #8 {all -> 0x01a8, blocks: (B:16:0x0071, B:18:0x008a, B:20:0x00ba, B:21:0x00c5, B:23:0x00de, B:32:0x00f9, B:33:0x010b, B:37:0x0149, B:39:0x0151, B:48:0x0155, B:50:0x016f, B:51:0x018d), top: B:15:0x0071 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x019a A[Catch: IOException -> 0x0132, TRY_ENTER, TryCatch #9 {IOException -> 0x0132, blocks: (B:25:0x00ea, B:27:0x00ef, B:29:0x00f4, B:59:0x012e, B:61:0x0136, B:63:0x013b, B:41:0x019a, B:43:0x019f, B:45:0x01a4), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x019f A[Catch: IOException -> 0x0132, TryCatch #9 {IOException -> 0x0132, blocks: (B:25:0x00ea, B:27:0x00ef, B:29:0x00f4, B:59:0x012e, B:61:0x0136, B:63:0x013b, B:41:0x019a, B:43:0x019f, B:45:0x01a4), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x01a4 A[Catch: IOException -> 0x0132, TRY_LEAVE, TryCatch #9 {IOException -> 0x0132, blocks: (B:25:0x00ea, B:27:0x00ef, B:29:0x00f4, B:59:0x012e, B:61:0x0136, B:63:0x013b, B:41:0x019a, B:43:0x019f, B:45:0x01a4), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0155 A[Catch: all -> 0x01a8, TryCatch #8 {all -> 0x01a8, blocks: (B:16:0x0071, B:18:0x008a, B:20:0x00ba, B:21:0x00c5, B:23:0x00de, B:32:0x00f9, B:33:0x010b, B:37:0x0149, B:39:0x0151, B:48:0x0155, B:50:0x016f, B:51:0x018d), top: B:15:0x0071 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x012e A[Catch: IOException -> 0x0132, TRY_ENTER, TryCatch #9 {IOException -> 0x0132, blocks: (B:25:0x00ea, B:27:0x00ef, B:29:0x00f4, B:59:0x012e, B:61:0x0136, B:63:0x013b, B:41:0x019a, B:43:0x019f, B:45:0x01a4), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0136 A[Catch: IOException -> 0x0132, TryCatch #9 {IOException -> 0x0132, blocks: (B:25:0x00ea, B:27:0x00ef, B:29:0x00f4, B:59:0x012e, B:61:0x0136, B:63:0x013b, B:41:0x019a, B:43:0x019f, B:45:0x01a4), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x013b A[Catch: IOException -> 0x0132, TRY_LEAVE, TryCatch #9 {IOException -> 0x0132, blocks: (B:25:0x00ea, B:27:0x00ef, B:29:0x00f4, B:59:0x012e, B:61:0x0136, B:63:0x013b, B:41:0x019a, B:43:0x019f, B:45:0x01a4), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01b4 A[Catch: IOException -> 0x01b0, TryCatch #10 {IOException -> 0x01b0, blocks: (B:79:0x01ac, B:70:0x01b4, B:72:0x01b9), top: B:78:0x01ac }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01b9 A[Catch: IOException -> 0x01b0, TRY_LEAVE, TryCatch #10 {IOException -> 0x01b0, blocks: (B:79:0x01ac, B:70:0x01b4, B:72:0x01b9), top: B:78:0x01ac }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01ac A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.alibaba.sdk.android.oss.model.UploadPartRequest] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask, com.alibaba.sdk.android.oss.internal.SequenceUploadTask] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.io.RandomAccessFile] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // com.alibaba.sdk.android.oss.internal.BaseMultipartUploadTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void uploadPart(int i, int i2, int i3) {
        java.io.InputStream inputStream;
        ?? r5;
        ?? r3;
        ?? r0 = 0;
        r0 = 0;
        r0 = 0;
        r0 = 0;
        r0 = 0;
        r0 = 0;
        r0 = 0;
        r0 = 0;
        r0 = 0;
        try {
            try {
                if (this.mContext.getCancellationHandler().isCancelled()) {
                    return;
                }
                this.mRunPartTaskCount++;
                preUploadPart(i, i2, i3);
                long partSize = i * ((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.mRequest).getPartSize();
                byte[] bArr = new byte[i2];
                if (this.mUploadUri != null) {
                    java.io.InputStream openInputStream = this.mContext.getApplicationContext().getContentResolver().openInputStream(this.mUploadUri);
                    try {
                        r5 = new java.io.BufferedInputStream(openInputStream);
                        try {
                            r5.skip(partSize);
                            r5.read(bArr, 0, i2);
                            inputStream = openInputStream;
                            r3 = 0;
                            r5 = r5;
                        } catch (com.alibaba.sdk.android.oss.ServiceException e) {
                            e = e;
                            inputStream = openInputStream;
                            r3 = 0;
                            if (e.getStatusCode() != 409) {
                            }
                            if (r3 != 0) {
                            }
                            if (inputStream != null) {
                            }
                            if (r5 != 0) {
                            }
                        } catch (java.lang.Exception e2) {
                            e = e2;
                            inputStream = openInputStream;
                            r5 = r5;
                            try {
                                processException(e);
                                if (r0 != 0) {
                                }
                                if (inputStream != null) {
                                }
                                if (r5 != 0) {
                                }
                            } catch (java.lang.Throwable th) {
                                th = th;
                                if (r0 != 0) {
                                    try {
                                        r0.close();
                                    } catch (java.io.IOException e3) {
                                        com.alibaba.sdk.android.oss.common.OSSLog.logThrowable2Local(e3);
                                        throw th;
                                    }
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (r5 != 0) {
                                    r5.close();
                                }
                                throw th;
                            }
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                            inputStream = openInputStream;
                            if (r0 != 0) {
                            }
                            if (inputStream != null) {
                            }
                            if (r5 != 0) {
                            }
                            throw th;
                        }
                    } catch (com.alibaba.sdk.android.oss.ServiceException e4) {
                        e = e4;
                        r5 = 0;
                        inputStream = openInputStream;
                        r3 = 0;
                    } catch (java.lang.Exception e5) {
                        e = e5;
                        r5 = 0;
                    } catch (java.lang.Throwable th3) {
                        th = th3;
                        r5 = 0;
                    }
                } else {
                    r3 = new java.io.RandomAccessFile(this.mUploadFile, "r");
                    try {
                        r3.seek(partSize);
                        r3.readFully(bArr, 0, i2);
                        inputStream = null;
                        r5 = 0;
                        r3 = r3;
                    } catch (com.alibaba.sdk.android.oss.ServiceException e6) {
                        e = e6;
                        inputStream = null;
                        r5 = 0;
                        if (e.getStatusCode() != 409) {
                        }
                        if (r3 != 0) {
                        }
                        if (inputStream != null) {
                        }
                        if (r5 != 0) {
                        }
                    } catch (java.lang.Exception e7) {
                        e = e7;
                        inputStream = null;
                        r5 = 0;
                        r0 = r3;
                        r5 = r5;
                        processException(e);
                        if (r0 != 0) {
                        }
                        if (inputStream != null) {
                        }
                        if (r5 != 0) {
                        }
                    } catch (java.lang.Throwable th4) {
                        th = th4;
                        inputStream = null;
                        r5 = 0;
                        r0 = r3;
                        if (r0 != 0) {
                        }
                        if (inputStream != null) {
                        }
                        if (r5 != 0) {
                        }
                        throw th;
                    }
                }
                try {
                    try {
                        try {
                            com.alibaba.sdk.android.oss.model.UploadPartRequest uploadPartRequest = new com.alibaba.sdk.android.oss.model.UploadPartRequest(((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.mRequest).getBucketName(), ((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.mRequest).getObjectKey(), this.mUploadId, i + 1);
                            try {
                                uploadPartRequest.setPartContent(bArr);
                                uploadPartRequest.setMd5Digest(com.alibaba.sdk.android.oss.common.utils.BinaryUtil.calculateBase64Md5(bArr));
                                uploadPartRequest.setCRC64(((com.alibaba.sdk.android.oss.model.ResumableUploadRequest) this.mRequest).getCRC64());
                                com.alibaba.sdk.android.oss.model.UploadPartResult syncUploadPart = this.mApiOperation.syncUploadPart(uploadPartRequest);
                                com.alibaba.sdk.android.oss.model.PartETag partETag = new com.alibaba.sdk.android.oss.model.PartETag(uploadPartRequest.getPartNumber(), syncUploadPart.getETag());
                                long j = i2;
                                partETag.setPartSize(j);
                                if (this.mCheckCRC64) {
                                    partETag.setCRC64(syncUploadPart.getClientCRC().longValue());
                                }
                                this.mPartETags.add(partETag);
                                this.mUploadedLength += j;
                                uploadPartFinish(partETag);
                                if (this.mContext.getCancellationHandler().isCancelled()) {
                                    com.alibaba.sdk.android.oss.TaskCancelException taskCancelException = new com.alibaba.sdk.android.oss.TaskCancelException("sequence upload task cancel");
                                    throw new com.alibaba.sdk.android.oss.ClientException(taskCancelException.getMessage(), taskCancelException, java.lang.Boolean.TRUE);
                                }
                                onProgressCallback(this.mRequest, this.mUploadedLength, this.mFileLength);
                                if (r3 != 0) {
                                    r3.close();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (r5 != 0) {
                                    r5.close();
                                }
                            } catch (com.alibaba.sdk.android.oss.ServiceException e8) {
                                e = e8;
                                r0 = uploadPartRequest;
                                if (e.getStatusCode() != 409) {
                                    processException(e);
                                } else {
                                    com.alibaba.sdk.android.oss.model.PartETag partETag2 = new com.alibaba.sdk.android.oss.model.PartETag(r0.getPartNumber(), e.getPartEtag());
                                    partETag2.setPartSize(r0.getPartContent().length);
                                    if (this.mCheckCRC64) {
                                        partETag2.setCRC64(new java.util.zip.CheckedInputStream(new java.io.ByteArrayInputStream(r0.getPartContent()), new com.alibaba.sdk.android.oss.common.utils.CRC64()).getChecksum().getValue());
                                    }
                                    this.mPartETags.add(partETag2);
                                    this.mUploadedLength += i2;
                                }
                                if (r3 != 0) {
                                    r3.close();
                                }
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                if (r5 != 0) {
                                    r5.close();
                                }
                            }
                        } catch (java.lang.Exception e9) {
                            e = e9;
                            r0 = r3;
                            r5 = r5;
                            processException(e);
                            if (r0 != 0) {
                                r0.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (r5 != 0) {
                                r5.close();
                            }
                        }
                    } catch (java.lang.Throwable th5) {
                        th = th5;
                        r0 = r3;
                        if (r0 != 0) {
                        }
                        if (inputStream != null) {
                        }
                        if (r5 != 0) {
                        }
                        throw th;
                    }
                } catch (com.alibaba.sdk.android.oss.ServiceException e10) {
                    e = e10;
                }
            } catch (java.io.IOException e11) {
                com.alibaba.sdk.android.oss.common.OSSLog.logThrowable2Local(e11);
            }
        } catch (com.alibaba.sdk.android.oss.ServiceException e12) {
            e = e12;
            inputStream = r0;
            r3 = inputStream;
            r5 = r3;
        } catch (java.lang.Exception e13) {
            e = e13;
            inputStream = r0;
            r5 = inputStream;
            r0 = r0;
        } catch (java.lang.Throwable th6) {
            th = th6;
            inputStream = r0;
            r5 = inputStream;
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
