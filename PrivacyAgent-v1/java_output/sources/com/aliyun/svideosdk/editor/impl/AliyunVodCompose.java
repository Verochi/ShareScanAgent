package com.aliyun.svideosdk.editor.impl;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class AliyunVodCompose implements com.aliyun.svideosdk.editor.AliyunIVodCompose {
    private static final long FIRST_PART_PACKET_SIZE = 102400;
    private static final long PACKET_HEAD_SIZE = 48;
    private static final long PACKET_SIZE = 262144;
    private static java.lang.ref.WeakReference<android.content.Context> contextWeakReference;
    private com.aliyun.svideosdk.editor.AliyunIBaseCompose mAliyunIBaseCompose;
    private com.aliyun.svideosdk.editor.AliyunIVodUpload mAliyunIVodUpload;
    private com.aliyun.svideosdk.editor.ComposeAndUploadCallBack mComposeAndUploadCallBack;
    private java.lang.String mOutputPath;
    private java.io.RandomAccessFile mRandomAccessFile;
    private java.lang.String mTempOutputPath;
    private java.lang.String mUploadAddress;
    private java.lang.String mUploadAuth;
    private java.lang.String mVideoId;
    private com.aliyun.svideosdk.editor.AliyunIVodCompose.AliyunComposeState state;
    private com.aliyun.svideosdk.editor.AliyunIVodCompose.AliyunComposeUploadState uploadState = com.aliyun.svideosdk.editor.AliyunIVodCompose.AliyunComposeUploadState.STATE_IDLE;
    private boolean mReportEnabled = true;
    private long mPartSize = 1048576;
    private long mPartListSize = 0;
    private java.util.List<com.alibaba.sdk.android.vod.upload.model.FilePartInfo> mPartInfoList = new java.util.ArrayList();
    private android.os.HandlerThread mHandleThread = null;
    private android.os.Handler mIOHandler = null;
    private final com.aliyun.svideosdk.editor.a mPacketCallBack = new com.aliyun.svideosdk.editor.impl.AliyunVodCompose.a();

    public class a implements com.aliyun.svideosdk.editor.a {

        /* renamed from: com.aliyun.svideosdk.editor.impl.AliyunVodCompose$a$a, reason: collision with other inner class name */
        public class RunnableC0095a implements java.lang.Runnable {
            final /* synthetic */ int a;
            final /* synthetic */ byte[] b;

            public RunnableC0095a(int i, byte[] bArr) {
                this.a = i;
                this.b = bArr;
            }

            /* JADX WARN: Code restructure failed: missing block: B:24:0x0120, code lost:
            
                if (r1 != null) goto L36;
             */
            /* JADX WARN: Code restructure failed: missing block: B:29:0x012e, code lost:
            
                r1.release();
             */
            /* JADX WARN: Code restructure failed: missing block: B:33:0x012c, code lost:
            
                if (r1 == null) goto L30;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                if (com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.mRandomAccessFile == null) {
                    com.aliyun.svideosdk.editor.impl.AliyunVodCompose aliyunVodCompose = com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this;
                    aliyunVodCompose.mTempOutputPath = aliyunVodCompose.mOutputPath.replace(".mp4", "-temp.mp4");
                    try {
                        com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.mRandomAccessFile = new java.io.RandomAccessFile(com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.mTempOutputPath, "rw");
                    } catch (java.io.FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                java.nio.channels.FileLock fileLock = null;
                try {
                    fileLock = com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.mRandomAccessFile.getChannel().lock(com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.mRandomAccessFile.getFilePointer(), com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.mRandomAccessFile.getFilePointer() + this.a, false);
                    com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.mRandomAccessFile.write(this.b);
                    long length = com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.mRandomAccessFile.length();
                    if (length == 262192) {
                        com.alibaba.sdk.android.vod.upload.model.FilePartInfo filePartInfo = new com.alibaba.sdk.android.vod.upload.model.FilePartInfo();
                        filePartInfo.setPartNumber(1);
                        filePartInfo.setSeek(0L);
                        filePartInfo.setSize(102400L);
                        com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.mPartListSize = filePartInfo.getSize();
                        com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.mPartInfoList.add(filePartInfo);
                    }
                    if (length > 102400) {
                        long j = length - com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.mPartListSize;
                        if (j >= com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.mPartSize) {
                            int i = (int) (j / com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.mPartSize);
                            for (int i2 = 0; i2 < i; i2++) {
                                com.alibaba.sdk.android.vod.upload.model.FilePartInfo filePartInfo2 = new com.alibaba.sdk.android.vod.upload.model.FilePartInfo();
                                filePartInfo2.setPartNumber(com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.mPartInfoList.size() + 1);
                                filePartInfo2.setSeek(com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.mPartListSize);
                                filePartInfo2.setSize(com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.mPartSize);
                                com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.mPartListSize += filePartInfo2.getSize();
                                com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.mPartInfoList.add(filePartInfo2);
                            }
                        }
                    }
                } catch (java.io.IOException unused) {
                } catch (java.lang.Throwable th) {
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (java.io.IOException unused2) {
                        }
                    }
                    throw th;
                }
                com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.onUpload(false);
            }
        }

        public class b implements java.lang.Runnable {
            final /* synthetic */ long a;

            public b(long j) {
                this.a = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.mRandomAccessFile != null) {
                    try {
                        com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.mRandomAccessFile.seek(this.a);
                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public class c implements java.lang.Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.mRandomAccessFile != null) {
                    try {
                        if (com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.mPartListSize != com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.mRandomAccessFile.length()) {
                            com.alibaba.sdk.android.vod.upload.model.FilePartInfo filePartInfo = new com.alibaba.sdk.android.vod.upload.model.FilePartInfo();
                            filePartInfo.setPartNumber(com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.mPartInfoList.size() + 1);
                            filePartInfo.setSeek(com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.mPartListSize);
                            filePartInfo.setSize(com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.mRandomAccessFile.length() - com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.mPartListSize);
                            com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.mPartListSize += filePartInfo.getSize();
                            com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.mPartInfoList.add(filePartInfo);
                            com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.onUpload(true);
                        }
                        com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.mRandomAccessFile.close();
                        com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.mRandomAccessFile = null;
                    } catch (java.io.IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public a() {
        }

        @Override // com.aliyun.svideosdk.editor.a
        public void a(long j, int i) {
            com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.getIOHandler().post(new com.aliyun.svideosdk.editor.impl.AliyunVodCompose.a.b(j));
        }

        @Override // com.aliyun.svideosdk.editor.a
        public void a(java.nio.ByteBuffer byteBuffer, int i) {
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.getIOHandler().post(new com.aliyun.svideosdk.editor.impl.AliyunVodCompose.a.RunnableC0095a(i, bArr));
        }

        @Override // com.aliyun.svideosdk.editor.a
        public void onComposeCompleted() {
            com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.getIOHandler().post(new com.aliyun.svideosdk.editor.impl.AliyunVodCompose.a.c());
        }
    }

    public class b implements com.aliyun.svideosdk.editor.ComposeAndUploadCallBack.VideoUploadAuthCallBack {
        public b() {
        }

        @Override // com.aliyun.svideosdk.editor.ComposeAndUploadCallBack.VideoUploadAuthCallBack
        public void onFailure(int i, java.lang.String str) {
            com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.mComposeAndUploadCallBack.onUploadFailed(java.lang.String.valueOf(i), str);
        }

        @Override // com.aliyun.svideosdk.editor.ComposeAndUploadCallBack.VideoUploadAuthCallBack
        public void onSuccess(java.lang.String str, java.lang.String str2, java.lang.String str3) {
            if (com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.mAliyunIVodUpload == null) {
                com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.mAliyunIVodUpload = new com.aliyun.svideosdk.editor.impl.AliyunVodUpload();
                com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.mAliyunIVodUpload.init((android.content.Context) com.aliyun.svideosdk.editor.impl.AliyunVodCompose.contextWeakReference.get(), com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.mComposeAndUploadCallBack, com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.mReportEnabled);
            }
            com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.mVideoId = str;
            com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.mUploadAddress = str2;
            com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.mUploadAuth = str3;
            com.aliyun.svideosdk.editor.impl.AliyunVodCompose.this.uploadState = com.aliyun.svideosdk.editor.AliyunIVodCompose.AliyunComposeUploadState.STATE_GET_UPLOAD_AUTH_SUCCEED;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.os.Handler getIOHandler() {
        if (this.mIOHandler == null) {
            android.os.HandlerThread handlerThread = new android.os.HandlerThread("PacketIOThread");
            this.mHandleThread = handlerThread;
            handlerThread.start();
            this.mIOHandler = new android.os.Handler(this.mHandleThread.getLooper());
        }
        return this.mIOHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUpload(boolean z) {
        com.aliyun.svideosdk.editor.AliyunIVodCompose.AliyunComposeUploadState aliyunComposeUploadState = this.uploadState;
        if (aliyunComposeUploadState == com.aliyun.svideosdk.editor.AliyunIVodCompose.AliyunComposeUploadState.STATE_IDLE) {
            this.uploadState = com.aliyun.svideosdk.editor.AliyunIVodCompose.AliyunComposeUploadState.STATE_GET_UPLOAD_AUTH;
            this.mComposeAndUploadCallBack.getVideoUploadAuth(new com.aliyun.svideosdk.editor.impl.AliyunVodCompose.b());
        } else if (aliyunComposeUploadState == com.aliyun.svideosdk.editor.AliyunIVodCompose.AliyunComposeUploadState.STATE_GET_UPLOAD_AUTH_SUCCEED && this.mPartInfoList.size() > 1) {
            this.mAliyunIVodUpload.uploadVideoWithVod(this.mTempOutputPath, this.mUploadAddress, this.mUploadAuth, this.mPartInfoList);
            this.uploadState = com.aliyun.svideosdk.editor.AliyunIVodCompose.AliyunComposeUploadState.STATE_VIDEO_UPLOADING;
        } else if (this.uploadState == com.aliyun.svideosdk.editor.AliyunIVodCompose.AliyunComposeUploadState.STATE_VIDEO_UPLOADING) {
            this.mAliyunIVodUpload.updatePartInfoList(this.mTempOutputPath, this.mPartInfoList, z);
        }
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIBaseCompose
    public int cancelCompose() {
        if (this.mAliyunIBaseCompose == null) {
            return -20011023;
        }
        if (this.mComposeAndUploadCallBack != null) {
            cancelUpload();
        }
        return this.mAliyunIBaseCompose.cancelCompose();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodCompose
    public int cancelUpload() {
        com.aliyun.svideosdk.editor.AliyunIVodUpload aliyunIVodUpload = this.mAliyunIVodUpload;
        if (aliyunIVodUpload == null) {
            return -20012002;
        }
        return aliyunIVodUpload.cancelUpload();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIBaseCompose
    public int compose(java.lang.String str, java.lang.String str2, com.aliyun.svideosdk.editor.AliyunIComposeCallBack aliyunIComposeCallBack) {
        com.aliyun.svideosdk.editor.AliyunIBaseCompose aliyunIBaseCompose = this.mAliyunIBaseCompose;
        if (aliyunIBaseCompose == null) {
            return -20011023;
        }
        return aliyunIBaseCompose.compose(str, str2, aliyunIComposeCallBack);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodCompose
    public int composeAndUpload(java.lang.String str, java.lang.String str2, com.aliyun.svideosdk.editor.ComposeAndUploadCallBack composeAndUploadCallBack) {
        this.mOutputPath = str2;
        this.mComposeAndUploadCallBack = composeAndUploadCallBack;
        com.aliyun.svideosdk.editor.AliyunIBaseCompose aliyunIBaseCompose = this.mAliyunIBaseCompose;
        if (aliyunIBaseCompose instanceof com.aliyun.svideosdk.editor.impl.d) {
            ((com.aliyun.svideosdk.editor.impl.d) aliyunIBaseCompose).a(this.mPacketCallBack);
        }
        return compose(str, str2, composeAndUploadCallBack);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodCompose
    public com.aliyun.svideosdk.editor.AliyunIVodCompose.AliyunComposeState getState() {
        return this.state;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodCompose, com.aliyun.svideosdk.editor.AliyunIBaseCompose
    public int init(android.content.Context context) {
        contextWeakReference = new java.lang.ref.WeakReference<>(context);
        if (this.mAliyunIBaseCompose == null) {
            this.mAliyunIBaseCompose = new com.aliyun.svideosdk.editor.impl.d();
        }
        return this.mAliyunIBaseCompose.init(contextWeakReference.get());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodCompose
    public int init(android.content.Context context, boolean z) {
        this.mReportEnabled = z;
        contextWeakReference = new java.lang.ref.WeakReference<>(context);
        if (this.mAliyunIBaseCompose == null) {
            this.mAliyunIBaseCompose = new com.aliyun.svideosdk.editor.impl.d();
        }
        return this.mAliyunIBaseCompose.init(contextWeakReference.get());
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIBaseCompose
    public int pauseCompose() {
        com.aliyun.svideosdk.editor.AliyunIBaseCompose aliyunIBaseCompose = this.mAliyunIBaseCompose;
        if (aliyunIBaseCompose == null) {
            return -20011023;
        }
        return aliyunIBaseCompose.pauseCompose();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodCompose
    public int pauseUpload() {
        com.aliyun.svideosdk.editor.AliyunIVodUpload aliyunIVodUpload = this.mAliyunIVodUpload;
        if (aliyunIVodUpload == null) {
            return -20012002;
        }
        return aliyunIVodUpload.pauseUpload();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodCompose
    public int refreshWithUploadAuth(java.lang.String str) {
        com.aliyun.svideosdk.editor.AliyunIVodUpload aliyunIVodUpload = this.mAliyunIVodUpload;
        if (aliyunIVodUpload == null) {
            return -20012002;
        }
        return aliyunIVodUpload.refreshWithUploadAuth(str);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodCompose, com.aliyun.svideosdk.editor.AliyunIBaseCompose
    public void release() {
        com.aliyun.svideosdk.editor.AliyunIBaseCompose aliyunIBaseCompose = this.mAliyunIBaseCompose;
        if (aliyunIBaseCompose != null) {
            aliyunIBaseCompose.release();
            this.mAliyunIBaseCompose = null;
        }
        com.aliyun.svideosdk.editor.AliyunIVodUpload aliyunIVodUpload = this.mAliyunIVodUpload;
        if (aliyunIVodUpload != null) {
            aliyunIVodUpload.release();
            this.mAliyunIVodUpload = null;
        }
        if (!com.aliyun.common.utils.StringUtils.isEmpty(this.mTempOutputPath)) {
            com.aliyun.common.utils.FileUtils.deleteFile(this.mTempOutputPath);
            this.mTempOutputPath = null;
        }
        if (this.mIOHandler != null) {
            this.mHandleThread.quit();
            this.mHandleThread = null;
            this.mIOHandler = null;
            java.io.RandomAccessFile randomAccessFile = this.mRandomAccessFile;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                    this.mRandomAccessFile = null;
                } catch (java.io.IOException unused) {
                }
            }
        }
        this.mComposeAndUploadCallBack = null;
        com.aliyun.svideosdk.editor.AliyunIVodCompose.AliyunComposeState aliyunComposeState = com.aliyun.svideosdk.editor.AliyunIVodCompose.AliyunComposeState.STATE_IDLE;
        this.state = null;
        this.uploadState = com.aliyun.svideosdk.editor.AliyunIVodCompose.AliyunComposeUploadState.STATE_IDLE;
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIBaseCompose
    public int resumeCompose() {
        com.aliyun.svideosdk.editor.AliyunIBaseCompose aliyunIBaseCompose = this.mAliyunIBaseCompose;
        if (aliyunIBaseCompose == null) {
            return -20011023;
        }
        return aliyunIBaseCompose.resumeCompose();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodCompose
    public int resumeUpload() {
        com.aliyun.svideosdk.editor.AliyunIVodUpload aliyunIVodUpload = this.mAliyunIVodUpload;
        if (aliyunIVodUpload == null) {
            return -20012002;
        }
        return aliyunIVodUpload.resumeUpload();
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodCompose
    public int uploadImageWithVod(java.lang.String str, java.lang.String str2, java.lang.String str3, com.aliyun.svideosdk.editor.AliyunIVodCompose.AliyunIVodUploadCallBack aliyunIVodUploadCallBack) {
        if (this.mAliyunIVodUpload == null) {
            com.aliyun.svideosdk.editor.impl.AliyunVodUpload aliyunVodUpload = new com.aliyun.svideosdk.editor.impl.AliyunVodUpload();
            this.mAliyunIVodUpload = aliyunVodUpload;
            aliyunVodUpload.init(contextWeakReference.get(), aliyunIVodUploadCallBack, this.mReportEnabled);
        }
        this.state = com.aliyun.svideosdk.editor.AliyunIVodCompose.AliyunComposeState.STATE_IMAGE_UPLOADING;
        return this.mAliyunIVodUpload.uploadImageWithVod(str, str2, str3);
    }

    @Override // com.aliyun.svideosdk.editor.AliyunIVodCompose
    public int uploadVideoWithVod(java.lang.String str, java.lang.String str2, java.lang.String str3, com.aliyun.svideosdk.editor.AliyunIVodCompose.AliyunIVodUploadCallBack aliyunIVodUploadCallBack) {
        if (this.mAliyunIVodUpload == null) {
            com.aliyun.svideosdk.editor.impl.AliyunVodUpload aliyunVodUpload = new com.aliyun.svideosdk.editor.impl.AliyunVodUpload();
            this.mAliyunIVodUpload = aliyunVodUpload;
            aliyunVodUpload.init(contextWeakReference.get(), aliyunIVodUploadCallBack, this.mReportEnabled);
        }
        this.state = com.aliyun.svideosdk.editor.AliyunIVodCompose.AliyunComposeState.STATE_VIDEO_UPLOADING;
        return this.mAliyunIVodUpload.uploadVideoWithVod(str, str2, str3);
    }
}
