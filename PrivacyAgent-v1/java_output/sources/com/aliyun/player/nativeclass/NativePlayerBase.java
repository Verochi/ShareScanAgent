package com.aliyun.player.nativeclass;

/* loaded from: classes.dex */
public class NativePlayerBase {
    private static final java.lang.String TAG = "NativePlayerBase";
    private static final int UPDATE_CURRENT_POSITION = 1000;
    private static final int VIDEO_TYPE_FAIRPLAY = 16;
    private static final int VIDEO_TYPE_HDR10 = 2;
    private static final int VIDEO_TYPE_NONE = 0;
    private static final int VIDEO_TYPE_SDR = 1;
    private static final int VIDEO_TYPE_WIDEVINE_L1 = 4;
    private static final int VIDEO_TYPE_WIDEVINE_L3 = 8;
    private static java.lang.String libPath;
    private static android.content.Context mContext;
    private static com.aliyun.player.IPlayer.ConvertURLCallback sConvertURLCallback;
    private com.aliyun.player.nativeclass.NativePlayerBase.MainHandler mCurrentThreadHandler;
    private long mNativeContext;
    private boolean mSurfaceFromUser = false;
    private boolean mEnableTunnelMode = false;
    private com.aliyun.player.IPlayer.OnRenderFrameCallback mRenderFrameCallback = null;
    private com.aliyun.player.IPlayer.OnPreRenderFrameCallback mPreRenderFrameCallback = null;
    private com.aliyun.player.IPlayer.OnVideoSizeChangedListener mOnVideoSizeChangedListener = null;
    private com.aliyun.player.IPlayer.OnVideoRenderedListener mOnVideoRenderedListener = null;
    private com.aliyun.player.IPlayer.OnInfoListener mOnInfoListener = null;
    private com.aliyun.player.IPlayer.OnTrackReadyListener mOnTrackReadyListener = null;
    private com.aliyun.player.IPlayer.OnSubTrackReadyListener mOnSubTrackReadyListener = null;
    private com.aliyun.player.IPlayer.OnChooseTrackIndexListener mOnChooseTrackIndexListener = null;
    private com.aliyun.player.IPlayer.OnPreparedListener mOnPreparedListener = null;
    private com.aliyun.player.IPlayer.OnCompletionListener mOnCompletionListener = null;
    private com.aliyun.player.IPlayer.OnErrorListener mOnErrorListener = null;
    private com.aliyun.player.IPlayer.OnRenderingStartListener mOnRenderingStartListener = null;
    private com.aliyun.player.IPlayer.OnStreamSwitchedListener mOnStreamSwitchedListener = null;
    private com.aliyun.player.IPlayer.OnTrackChangedListener mOnTrackChangedListener = null;
    private com.aliyun.player.IPlayer.OnSeiDataListener mOnSeiDataListener = null;
    private com.aliyun.player.IPlayer.OnLoadingStatusListener mOnLoadingStatusListener = null;
    private com.aliyun.player.IPlayer.OnAVNotSyncStatusListener mOnAVNotSyncStatusListener = null;
    private com.aliyun.player.IPlayer.OnSeekCompleteListener mOnSeekCompleteListener = null;
    private com.aliyun.player.IPlayer.OnSubtitleDisplayListener mOnSubtitleDisplayListener = null;
    private com.aliyun.player.IPlayer.OnStateChangedListener mOnStateChangedListener = null;
    private com.aliyun.player.IPlayer.OnSnapShotListener mOnSnapShotListener = null;
    private com.aliyun.player.IPlayer.OnReportEventListener mOnEventReportListner = null;
    private com.cicada.player.utils.media.DrmCallback mDrmCallback = null;
    private boolean mDirectRender = false;
    private int mVideoType = 0;
    private com.aliyun.player.videoview.AliDisplayView mAliDisplayView = null;
    private com.aliyun.player.nativeclass.DisplayViewHelper mDisplayViewHelper = null;

    /* renamed from: com.aliyun.player.nativeclass.NativePlayerBase$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ com.aliyun.player.IPlayer.ScaleMode val$scaleMode;

        public AnonymousClass1(com.aliyun.player.IPlayer.ScaleMode scaleMode) {
            this.val$scaleMode = scaleMode;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.player.nativeclass.NativePlayerBase.this.mDisplayViewHelper.setScaleMode(this.val$scaleMode);
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativePlayerBase$10, reason: invalid class name */
    public class AnonymousClass10 implements java.lang.Runnable {
        final /* synthetic */ int val$height;
        final /* synthetic */ int val$width;

        public AnonymousClass10(int i, int i2) {
            this.val$width = i;
            this.val$height = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.player.nativeclass.NativePlayerBase.this.mOnVideoSizeChangedListener != null) {
                com.aliyun.player.nativeclass.NativePlayerBase.this.mOnVideoSizeChangedListener.onVideoSizeChanged(this.val$width, this.val$height);
            }
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativePlayerBase$11, reason: invalid class name */
    public class AnonymousClass11 implements java.lang.Runnable {
        final /* synthetic */ long val$pts;
        final /* synthetic */ long val$timeMs;

        public AnonymousClass11(long j, long j2) {
            this.val$timeMs = j;
            this.val$pts = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.player.nativeclass.NativePlayerBase.this.mOnVideoRenderedListener != null) {
                com.aliyun.player.nativeclass.NativePlayerBase.this.mOnVideoRenderedListener.onVideoRendered(this.val$timeMs, this.val$pts);
            }
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativePlayerBase$12, reason: invalid class name */
    public class AnonymousClass12 implements java.lang.Runnable {
        final /* synthetic */ com.aliyun.player.nativeclass.MediaInfo val$mediaInfo;

        public AnonymousClass12(com.aliyun.player.nativeclass.MediaInfo mediaInfo) {
            this.val$mediaInfo = mediaInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.player.nativeclass.NativePlayerBase.this.mOnTrackReadyListener != null) {
                com.aliyun.player.nativeclass.NativePlayerBase.this.mOnTrackReadyListener.onTrackReady(this.val$mediaInfo);
            }
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativePlayerBase$13, reason: invalid class name */
    public class AnonymousClass13 implements java.lang.Runnable {
        final /* synthetic */ com.aliyun.player.nativeclass.MediaInfo val$mediaInfo;

        public AnonymousClass13(com.aliyun.player.nativeclass.MediaInfo mediaInfo) {
            this.val$mediaInfo = mediaInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.player.nativeclass.NativePlayerBase.this.mOnSubTrackReadyListener != null) {
                com.aliyun.player.nativeclass.NativePlayerBase.this.mOnSubTrackReadyListener.onSubTrackReady(this.val$mediaInfo);
            }
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativePlayerBase$14, reason: invalid class name */
    public class AnonymousClass14 implements java.lang.Runnable {
        final /* synthetic */ int val$code;
        final /* synthetic */ com.aliyun.player.bean.ErrorCode val$finalErrorCode;
        final /* synthetic */ java.lang.String val$msg;
        final /* synthetic */ java.lang.String val$url;

        public AnonymousClass14(int i, java.lang.String str, com.aliyun.player.bean.ErrorCode errorCode, java.lang.String str2) {
            this.val$code = i;
            this.val$url = str;
            this.val$finalErrorCode = errorCode;
            this.val$msg = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.player.nativeclass.NativePlayerBase.this.mOnStreamSwitchedListener != null) {
                if (this.val$code == 0) {
                    com.aliyun.player.nativeclass.NativePlayerBase.this.mOnStreamSwitchedListener.onSwitchedSuccess(this.val$url);
                    return;
                }
                com.aliyun.player.bean.ErrorInfo errorInfo = new com.aliyun.player.bean.ErrorInfo();
                errorInfo.setCode(this.val$finalErrorCode);
                errorInfo.setMsg(this.val$code + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + this.val$msg);
                com.aliyun.player.nativeclass.NativePlayerBase.this.mOnStreamSwitchedListener.onSwitchedFail(this.val$url, errorInfo);
            }
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativePlayerBase$15, reason: invalid class name */
    public class AnonymousClass15 implements java.lang.Runnable {
        final /* synthetic */ com.aliyun.player.nativeclass.TrackInfo val$newInfo;

        public AnonymousClass15(com.aliyun.player.nativeclass.TrackInfo trackInfo) {
            this.val$newInfo = trackInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.player.nativeclass.NativePlayerBase.this.trySetProjectionExtraInfo();
            if (com.aliyun.player.nativeclass.NativePlayerBase.this.mOnTrackChangedListener != null) {
                com.aliyun.player.nativeclass.NativePlayerBase.this.mOnTrackChangedListener.onChangedSuccess(this.val$newInfo);
            }
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativePlayerBase$16, reason: invalid class name */
    public class AnonymousClass16 implements java.lang.Runnable {
        final /* synthetic */ byte[] val$seiData;
        final /* synthetic */ int val$type;
        final /* synthetic */ byte[] val$uuidData;

        public AnonymousClass16(int i, byte[] bArr, byte[] bArr2) {
            this.val$type = i;
            this.val$uuidData = bArr;
            this.val$seiData = bArr2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.player.nativeclass.NativePlayerBase.this.mOnSeiDataListener != null) {
                com.aliyun.player.nativeclass.NativePlayerBase.this.mOnSeiDataListener.onSeiData(this.val$type, this.val$uuidData, this.val$seiData);
            }
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativePlayerBase$17, reason: invalid class name */
    public class AnonymousClass17 implements java.lang.Runnable {
        final /* synthetic */ int val$code;
        final /* synthetic */ com.aliyun.player.bean.ErrorCode val$finalErrorCode;
        final /* synthetic */ java.lang.String val$msg;
        final /* synthetic */ com.aliyun.player.nativeclass.TrackInfo val$targetInfo;

        public AnonymousClass17(com.aliyun.player.bean.ErrorCode errorCode, int i, java.lang.String str, com.aliyun.player.nativeclass.TrackInfo trackInfo) {
            this.val$finalErrorCode = errorCode;
            this.val$code = i;
            this.val$msg = str;
            this.val$targetInfo = trackInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.player.nativeclass.NativePlayerBase.this.mOnTrackChangedListener != null) {
                com.aliyun.player.bean.ErrorInfo errorInfo = new com.aliyun.player.bean.ErrorInfo();
                errorInfo.setCode(this.val$finalErrorCode);
                errorInfo.setMsg(this.val$code + com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR + this.val$msg);
                com.aliyun.player.nativeclass.NativePlayerBase.this.mOnTrackChangedListener.onChangedFail(this.val$targetInfo, errorInfo);
            }
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativePlayerBase$18, reason: invalid class name */
    public class AnonymousClass18 implements java.lang.Runnable {
        final /* synthetic */ int val$newStatus;

        public AnonymousClass18(int i) {
            this.val$newStatus = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.player.nativeclass.NativePlayerBase.this.mOnStateChangedListener != null) {
                com.aliyun.player.nativeclass.NativePlayerBase.this.mOnStateChangedListener.onStateChanged(this.val$newStatus);
            }
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativePlayerBase$19, reason: invalid class name */
    public class AnonymousClass19 implements java.lang.Runnable {
        final /* synthetic */ long val$position;

        public AnonymousClass19(long j) {
            this.val$position = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.player.nativeclass.NativePlayerBase.this.mOnInfoListener != null) {
                com.aliyun.player.bean.InfoBean infoBean = new com.aliyun.player.bean.InfoBean();
                infoBean.setCode(com.aliyun.player.bean.InfoCode.BufferedPosition);
                infoBean.setExtraValue(this.val$position);
                com.aliyun.player.nativeclass.NativePlayerBase.this.mOnInfoListener.onInfo(infoBean);
            }
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativePlayerBase$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {

        /* renamed from: com.aliyun.player.nativeclass.NativePlayerBase$2$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ int val$finalHeight;
            final /* synthetic */ int val$finalWidth;
            final /* synthetic */ android.graphics.Bitmap val$screenShot;

            public AnonymousClass1(android.graphics.Bitmap bitmap, int i, int i2) {
                this.val$screenShot = bitmap;
                this.val$finalWidth = i;
                this.val$finalHeight = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (com.aliyun.player.nativeclass.NativePlayerBase.this.mOnSnapShotListener != null) {
                    com.aliyun.player.nativeclass.NativePlayerBase.this.mOnSnapShotListener.onSnapShot(this.val$screenShot, this.val$finalWidth, this.val$finalHeight);
                }
            }
        }

        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            android.graphics.Bitmap snapshot = com.aliyun.player.nativeclass.NativePlayerBase.this.mDisplayViewHelper.snapshot();
            if (snapshot != null) {
                i = snapshot.getWidth();
                i2 = snapshot.getHeight();
            } else {
                i = 0;
                i2 = 0;
            }
            com.aliyun.player.nativeclass.NativePlayerBase.this.mCurrentThreadHandler.post(new com.aliyun.player.nativeclass.NativePlayerBase.AnonymousClass2.AnonymousClass1(snapshot, i, i2));
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativePlayerBase$20, reason: invalid class name */
    public class AnonymousClass20 implements java.lang.Runnable {
        public AnonymousClass20() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.player.nativeclass.NativePlayerBase.this.mOnLoadingStatusListener != null) {
                com.aliyun.player.nativeclass.NativePlayerBase.this.mOnLoadingStatusListener.onLoadingBegin();
            }
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativePlayerBase$21, reason: invalid class name */
    public class AnonymousClass21 implements java.lang.Runnable {
        final /* synthetic */ float val$percent;

        public AnonymousClass21(float f) {
            this.val$percent = f;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.player.nativeclass.NativePlayerBase.this.mOnLoadingStatusListener != null) {
                com.aliyun.player.nativeclass.NativePlayerBase.this.mOnLoadingStatusListener.onLoadingProgress((int) this.val$percent, 0.0f);
            }
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativePlayerBase$22, reason: invalid class name */
    public class AnonymousClass22 implements java.lang.Runnable {
        final /* synthetic */ int val$type;

        public AnonymousClass22(int i) {
            this.val$type = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.player.nativeclass.NativePlayerBase.this.mOnAVNotSyncStatusListener != null) {
                com.aliyun.player.nativeclass.NativePlayerBase.this.mOnAVNotSyncStatusListener.onAVNotSyncStart(this.val$type);
            }
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativePlayerBase$23, reason: invalid class name */
    public class AnonymousClass23 implements java.lang.Runnable {
        public AnonymousClass23() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.player.nativeclass.NativePlayerBase.this.mOnAVNotSyncStatusListener != null) {
                com.aliyun.player.nativeclass.NativePlayerBase.this.mOnAVNotSyncStatusListener.onAVNotSyncEnd();
            }
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativePlayerBase$24, reason: invalid class name */
    public class AnonymousClass24 implements java.lang.Runnable {
        final /* synthetic */ long val$speed;

        public AnonymousClass24(long j) {
            this.val$speed = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.player.nativeclass.NativePlayerBase.this.mOnInfoListener != null) {
                com.aliyun.player.bean.InfoBean infoBean = new com.aliyun.player.bean.InfoBean();
                infoBean.setCode(com.aliyun.player.bean.InfoCode.CurrentDownloadSpeed);
                infoBean.setExtraValue(this.val$speed);
                com.aliyun.player.nativeclass.NativePlayerBase.this.mOnInfoListener.onInfo(infoBean);
            }
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativePlayerBase$25, reason: invalid class name */
    public class AnonymousClass25 implements java.lang.Runnable {
        final /* synthetic */ long val$UtcTime;

        public AnonymousClass25(long j) {
            this.val$UtcTime = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.player.nativeclass.NativePlayerBase.this.mOnInfoListener != null) {
                com.aliyun.player.bean.InfoBean infoBean = new com.aliyun.player.bean.InfoBean();
                infoBean.setCode(com.aliyun.player.bean.InfoCode.UtcTime);
                infoBean.setExtraValue(this.val$UtcTime);
                com.aliyun.player.nativeclass.NativePlayerBase.this.mOnInfoListener.onInfo(infoBean);
            }
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativePlayerBase$26, reason: invalid class name */
    public class AnonymousClass26 implements java.lang.Runnable {
        final /* synthetic */ long val$size;

        public AnonymousClass26(long j) {
            this.val$size = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.player.nativeclass.NativePlayerBase.this.mOnInfoListener != null) {
                com.aliyun.player.bean.InfoBean infoBean = new com.aliyun.player.bean.InfoBean();
                infoBean.setCode(com.aliyun.player.bean.InfoCode.LocalCacheLoaded);
                infoBean.setExtraValue(this.val$size);
                com.aliyun.player.nativeclass.NativePlayerBase.this.mOnInfoListener.onInfo(infoBean);
            }
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativePlayerBase$27, reason: invalid class name */
    public class AnonymousClass27 implements java.lang.Runnable {
        public AnonymousClass27() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.player.nativeclass.NativePlayerBase.this.mOnLoadingStatusListener != null) {
                com.aliyun.player.nativeclass.NativePlayerBase.this.mOnLoadingStatusListener.onLoadingEnd();
            }
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativePlayerBase$28, reason: invalid class name */
    public class AnonymousClass28 implements java.lang.Runnable {
        public AnonymousClass28() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.player.nativeclass.NativePlayerBase.this.mOnSeekCompleteListener != null) {
                com.aliyun.player.nativeclass.NativePlayerBase.this.mOnSeekCompleteListener.onSeekComplete();
            }
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativePlayerBase$29, reason: invalid class name */
    public class AnonymousClass29 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$content;
        final /* synthetic */ long val$id;
        final /* synthetic */ int val$trackIndex;

        public AnonymousClass29(int i, long j, java.lang.String str) {
            this.val$trackIndex = i;
            this.val$id = j;
            this.val$content = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.player.nativeclass.NativePlayerBase.this.mOnSubtitleDisplayListener != null) {
                com.aliyun.player.nativeclass.NativePlayerBase.this.mOnSubtitleDisplayListener.onSubtitleShow(this.val$trackIndex, this.val$id, this.val$content);
            }
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativePlayerBase$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        public AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.player.nativeclass.NativePlayerBase.this.trySetProjectionExtraInfo();
            if (com.aliyun.player.nativeclass.NativePlayerBase.this.mOnPreparedListener != null) {
                com.aliyun.player.nativeclass.NativePlayerBase.this.mOnPreparedListener.onPrepared();
            }
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativePlayerBase$30, reason: invalid class name */
    public class AnonymousClass30 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$content;
        final /* synthetic */ int val$id;

        public AnonymousClass30(int i, java.lang.String str) {
            this.val$id = i;
            this.val$content = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.player.nativeclass.NativePlayerBase.this.mOnSubtitleDisplayListener != null) {
                com.aliyun.player.nativeclass.NativePlayerBase.this.mOnSubtitleDisplayListener.onSubtitleExtAdded(this.val$id, this.val$content);
            }
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativePlayerBase$31, reason: invalid class name */
    public class AnonymousClass31 implements java.lang.Runnable {
        final /* synthetic */ long val$id;
        final /* synthetic */ int val$trackIndex;

        public AnonymousClass31(int i, long j) {
            this.val$trackIndex = i;
            this.val$id = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.player.nativeclass.NativePlayerBase.this.mOnSubtitleDisplayListener != null) {
                com.aliyun.player.nativeclass.NativePlayerBase.this.mOnSubtitleDisplayListener.onSubtitleHide(this.val$trackIndex, this.val$id);
            }
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativePlayerBase$32, reason: invalid class name */
    public class AnonymousClass32 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$header;
        final /* synthetic */ int val$trackIndex;

        public AnonymousClass32(int i, java.lang.String str) {
            this.val$trackIndex = i;
            this.val$header = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.player.nativeclass.NativePlayerBase.this.mOnSubtitleDisplayListener != null) {
                com.aliyun.player.nativeclass.NativePlayerBase.this.mOnSubtitleDisplayListener.onSubtitleHeader(this.val$trackIndex, this.val$header);
            }
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativePlayerBase$33, reason: invalid class name */
    public class AnonymousClass33 implements java.lang.Runnable {
        final /* synthetic */ android.graphics.Bitmap val$finalBOutput;
        final /* synthetic */ int val$height;
        final /* synthetic */ int val$width;

        public AnonymousClass33(android.graphics.Bitmap bitmap, int i, int i2) {
            this.val$finalBOutput = bitmap;
            this.val$width = i;
            this.val$height = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.player.nativeclass.NativePlayerBase.this.mOnSnapShotListener != null) {
                com.aliyun.player.nativeclass.NativePlayerBase.this.mOnSnapShotListener.onSnapShot(this.val$finalBOutput, this.val$width, this.val$height);
            }
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativePlayerBase$34, reason: invalid class name */
    public class AnonymousClass34 implements java.lang.Runnable {
        final /* synthetic */ com.aliyun.player.videoview.AliDisplayView.DisplayViewType val$finalDisplayViewType;

        public AnonymousClass34(com.aliyun.player.videoview.AliDisplayView.DisplayViewType displayViewType) {
            this.val$finalDisplayViewType = displayViewType;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.player.nativeclass.NativePlayerBase.this.mDisplayViewHelper.createDisplayView(this.val$finalDisplayViewType, com.aliyun.player.nativeclass.NativePlayerBase.this.mDirectRender);
            com.aliyun.player.nativeclass.NativePlayerBase.this.mDisplayViewHelper.setVideoSize(com.aliyun.player.nativeclass.NativePlayerBase.this.getVideoWidth(), com.aliyun.player.nativeclass.NativePlayerBase.this.getVideoHeight(), (int) com.aliyun.player.nativeclass.NativePlayerBase.this.getVideoRotation());
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativePlayerBase$35, reason: invalid class name */
    public class AnonymousClass35 implements com.aliyun.player.videoview.a.a.h {
        public AnonymousClass35() {
        }

        @Override // com.aliyun.player.videoview.a.a.h
        public void onSurfaceCreated(android.view.Surface surface) {
            com.aliyun.player.nativeclass.NativePlayerBase.this.setSurfaceInner(surface, false);
        }

        @Override // com.aliyun.player.videoview.a.a.h
        public void onSurfaceDestroy() {
            com.aliyun.player.nativeclass.NativePlayerBase.this.setSurfaceInner(null, false);
        }

        @Override // com.aliyun.player.videoview.a.a.h
        public void onSurfaceSizeChanged() {
            com.aliyun.player.nativeclass.NativePlayerBase.this.surfaceChanged();
        }

        @Override // com.aliyun.player.videoview.a.a.h
        public void onViewCreated(com.aliyun.player.videoview.AliDisplayView.DisplayViewType displayViewType) {
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativePlayerBase$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.player.nativeclass.NativePlayerBase.this.mOnCompletionListener != null) {
                com.aliyun.player.nativeclass.NativePlayerBase.this.mOnCompletionListener.onCompletion();
            }
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativePlayerBase$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        public AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.player.nativeclass.NativePlayerBase.this.mOnInfoListener != null) {
                com.aliyun.player.bean.InfoBean infoBean = new com.aliyun.player.bean.InfoBean();
                infoBean.setCode(com.aliyun.player.bean.InfoCode.LoopingStart);
                com.aliyun.player.nativeclass.NativePlayerBase.this.mOnInfoListener.onInfo(infoBean);
            }
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativePlayerBase$6, reason: invalid class name */
    public class AnonymousClass6 implements java.lang.Runnable {
        public AnonymousClass6() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.player.nativeclass.NativePlayerBase.this.mOnInfoListener != null) {
                com.aliyun.player.bean.InfoBean infoBean = new com.aliyun.player.bean.InfoBean();
                infoBean.setCode(com.aliyun.player.bean.InfoCode.AutoPlayStart);
                com.aliyun.player.nativeclass.NativePlayerBase.this.mOnInfoListener.onInfo(infoBean);
            }
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativePlayerBase$7, reason: invalid class name */
    public class AnonymousClass7 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$extra;
        final /* synthetic */ com.aliyun.player.bean.ErrorCode val$finalErrorCode;
        final /* synthetic */ java.lang.String val$msg;

        public AnonymousClass7(com.aliyun.player.bean.ErrorCode errorCode, java.lang.String str, java.lang.String str2) {
            this.val$finalErrorCode = errorCode;
            this.val$msg = str;
            this.val$extra = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.player.nativeclass.NativePlayerBase.this.mOnErrorListener != null) {
                com.aliyun.player.bean.ErrorInfo errorInfo = new com.aliyun.player.bean.ErrorInfo();
                errorInfo.setCode(this.val$finalErrorCode);
                errorInfo.setMsg(this.val$msg);
                errorInfo.setExtra(this.val$extra);
                com.aliyun.player.nativeclass.NativePlayerBase.this.mOnErrorListener.onError(errorInfo);
            }
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativePlayerBase$8, reason: invalid class name */
    public class AnonymousClass8 implements java.lang.Runnable {
        final /* synthetic */ com.aliyun.player.bean.InfoCode val$finalInfoCode;
        final /* synthetic */ java.lang.String val$msg;

        public AnonymousClass8(com.aliyun.player.bean.InfoCode infoCode, java.lang.String str) {
            this.val$finalInfoCode = infoCode;
            this.val$msg = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.player.nativeclass.NativePlayerBase.this.mOnInfoListener != null) {
                com.aliyun.player.bean.InfoBean infoBean = new com.aliyun.player.bean.InfoBean();
                infoBean.setCode(this.val$finalInfoCode);
                infoBean.setExtraMsg(this.val$msg);
                com.aliyun.player.nativeclass.NativePlayerBase.this.mOnInfoListener.onInfo(infoBean);
            }
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativePlayerBase$9, reason: invalid class name */
    public class AnonymousClass9 implements java.lang.Runnable {
        public AnonymousClass9() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.player.nativeclass.NativePlayerBase.this.mOnRenderingStartListener != null) {
                com.aliyun.player.nativeclass.NativePlayerBase.this.mOnRenderingStartListener.onRenderingStart();
            }
        }
    }

    public static class MainHandler extends android.os.Handler {
        private java.lang.ref.WeakReference<com.aliyun.player.nativeclass.NativePlayerBase> playerWeakReference;

        public MainHandler(com.aliyun.player.nativeclass.NativePlayerBase nativePlayerBase, android.os.Looper looper) {
            super(looper);
            this.playerWeakReference = new java.lang.ref.WeakReference<>(nativePlayerBase);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            com.aliyun.player.nativeclass.NativePlayerBase nativePlayerBase = this.playerWeakReference.get();
            if (nativePlayerBase != null) {
                nativePlayerBase.handleMessage(message);
            }
            super.handleMessage(message);
        }
    }

    static {
        com.aliyun.utils.f.f();
        mContext = null;
        sConvertURLCallback = null;
    }

    public NativePlayerBase(android.content.Context context) {
        mContext = context;
        if (libPath == null) {
            libPath = getUserNativeLibPath(context);
            loadPlugins();
        }
        com.aliyun.utils.DeviceInfoUtils.setSDKContext(context);
        if (com.aliyun.utils.f.b()) {
            com.aliyun.aio_stat.AioStat.init(context);
        }
        this.mCurrentThreadHandler = new com.aliyun.player.nativeclass.NativePlayerBase.MainHandler(this, android.os.Looper.getMainLooper());
        construct(context);
    }

    private void construct(android.content.Context context) {
        if (com.aliyun.utils.f.b()) {
            nConstruct();
        }
    }

    public static android.content.Context getContext() {
        return mContext;
    }

    public static java.lang.String getSdkVersion() {
        return !com.aliyun.utils.f.b() ? "" : nGetSdkVersion();
    }

    private static java.lang.String getUserNativeLibPath(android.content.Context context) {
        java.lang.String packageName = context.getPackageName();
        java.lang.String str = "/data/data/" + packageName + "/lib/";
        try {
            str = context.getPackageManager().getPackageInfo(packageName, 0).applicationInfo.dataDir + "/lib/";
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
        }
        java.io.File file = new java.io.File(str);
        if (file.exists() && file.listFiles() != null) {
            return str;
        }
        try {
            return context.getPackageManager().getPackageInfo(packageName, 0).applicationInfo.nativeLibraryDir + net.lingala.zip4j.util.InternalZipConstants.ZIP_FILE_SEPARATOR;
        } catch (android.content.pm.PackageManager.NameNotFoundException unused2) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleMessage(android.os.Message message) {
        if (message.what != 1000 || this.mOnInfoListener == null) {
            return;
        }
        com.aliyun.player.bean.InfoBean infoBean = new com.aliyun.player.bean.InfoBean();
        infoBean.setCode(com.aliyun.player.bean.InfoCode.CurrentPosition);
        infoBean.setExtraValue(message.arg1);
        this.mOnInfoListener.onInfo(infoBean);
    }

    public static void loadClass() {
    }

    private void loadPlugins() {
        java.io.File[] listFiles;
        if (android.text.TextUtils.isEmpty(libPath)) {
            return;
        }
        java.io.File file = new java.io.File(libPath);
        if (!file.exists() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
            return;
        }
        for (java.io.File file2 : listFiles) {
            java.lang.String name = file2.getName();
            if (name.contains("cicada_plugin_")) {
                try {
                    java.lang.System.loadLibrary(name.substring(name.indexOf("lib") + 3, name.lastIndexOf(".so")));
                } catch (java.lang.Throwable th) {
                    com.cicada.player.utils.Logger.e(TAG, th.getMessage());
                }
            }
        }
    }

    public static java.lang.String nConvertURLCallback(java.lang.String str, java.lang.String str2) {
        com.aliyun.player.IPlayer.ConvertURLCallback convertURLCallback = sConvertURLCallback;
        if (convertURLCallback != null) {
            return convertURLCallback.convertURL(str, str2);
        }
        return null;
    }

    public static native java.lang.String nGetSdkVersion();

    public static native void nSetBlackType(int i);

    /* JADX WARN: Removed duplicated region for block: B:11:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005e  */
    @com.cicada.player.utils.NativeUsed
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean nUpdateViewCallback(int i) {
        java.lang.String str = TAG;
        com.cicada.player.utils.Logger.i(str, "nUpdateViewCallback videoType = " + i);
        this.mDirectRender = false;
        this.mVideoType = i;
        if (this.mSurfaceFromUser) {
            return false;
        }
        this.mDirectRender = this.mEnableTunnelMode;
        com.aliyun.player.videoview.AliDisplayView.DisplayViewType displayViewType = com.aliyun.player.videoview.AliDisplayView.DisplayViewType.Either;
        if ((i & 2) != 2) {
            if ((i & 4) == 4 || (i & 8) == 8) {
                displayViewType = com.aliyun.player.videoview.AliDisplayView.DisplayViewType.SurfaceView;
            }
            com.cicada.player.utils.Logger.i(str, "mDirectRender  = " + this.mDirectRender);
            if (this.mAliDisplayView != null) {
                com.cicada.player.utils.Logger.e(str, "nCreateViewCallback but view is null");
                return false;
            }
            boolean needUpdateView = this.mDisplayViewHelper.needUpdateView(displayViewType);
            this.mAliDisplayView.post(new com.aliyun.player.nativeclass.NativePlayerBase.AnonymousClass34(displayViewType));
            return needUpdateView;
        }
        displayViewType = com.aliyun.player.videoview.AliDisplayView.DisplayViewType.TextureView;
        this.mDirectRender = true;
        com.cicada.player.utils.Logger.i(str, "mDirectRender  = " + this.mDirectRender);
        if (this.mAliDisplayView != null) {
        }
    }

    @com.cicada.player.utils.NativeUsed
    private void native_onEventReport(java.lang.Object obj) {
        java.util.Map<java.lang.String, java.lang.String> map = (java.util.Map) obj;
        com.aliyun.player.IPlayer.OnReportEventListener onReportEventListener = this.mOnEventReportListner;
        if (onReportEventListener != null) {
            onReportEventListener.onEventParam(map);
        }
    }

    @com.cicada.player.utils.NativeUsed
    private boolean native_onPreRenderFrameCallback(java.lang.Object obj) {
        com.aliyun.player.IPlayer.OnPreRenderFrameCallback onPreRenderFrameCallback = this.mPreRenderFrameCallback;
        if (onPreRenderFrameCallback != null) {
            return onPreRenderFrameCallback.onPreRenderFrame((com.cicada.player.utils.FrameInfo) obj);
        }
        return false;
    }

    @com.cicada.player.utils.NativeUsed
    private boolean native_onRenderFrameCallback(java.lang.Object obj) {
        com.aliyun.player.IPlayer.OnRenderFrameCallback onRenderFrameCallback = this.mRenderFrameCallback;
        if (onRenderFrameCallback != null) {
            return onRenderFrameCallback.onRenderFrame((com.cicada.player.utils.FrameInfo) obj);
        }
        return false;
    }

    public static void setBlackType(int i) {
        if (com.aliyun.utils.f.b()) {
            nSetBlackType(i);
        }
    }

    public static void setConvertURLCb(com.aliyun.player.IPlayer.ConvertURLCallback convertURLCallback) {
        sConvertURLCallback = convertURLCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSurfaceInner(android.view.Surface surface, boolean z) {
        if (com.aliyun.utils.f.b()) {
            if (android.os.Looper.myLooper() != android.os.Looper.getMainLooper()) {
                com.cicada.player.utils.Logger.w(TAG, "set surface not at main thread");
            }
            this.mSurfaceFromUser = z;
            nSetSurface(surface);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void trySetProjectionExtraInfo() {
        com.aliyun.player.nativeclass.PlayerConfig config = getConfig();
        if (config == null || !config.mEnableProjection) {
            return;
        }
        java.lang.String propertyString = getPropertyString(1000);
        try {
            if (!new org.json.JSONObject(propertyString).getBoolean("projectionLicenseEnable")) {
                com.cicada.player.utils.Logger.w(TAG, "projection config enabled but license not activated");
                return;
            }
            try {
                java.lang.reflect.Method declaredMethod = java.lang.Class.forName("com.aliyun.player.aliplayerscreenprojection.AliPlayerScreenProjectionHelper").getDeclaredMethod("setExtraInfo", java.lang.String.class, java.lang.String.class);
                declaredMethod.setAccessible(true);
                java.lang.String userData = getUserData();
                declaredMethod.invoke(null, userData, propertyString);
                com.cicada.player.utils.Logger.i(TAG, "setExtraInfo to projection sdk success, userData:" + userData);
            } catch (java.lang.Exception e) {
                com.cicada.player.utils.Logger.e(TAG, "setExtraInfo to projection sdk failed, seems projection sdk is not integrated. Error:" + e.getMessage());
            }
        } catch (org.json.JSONException unused) {
            com.cicada.player.utils.Logger.e(TAG, "Invalid prepared info:" + propertyString);
        }
    }

    public void addExtSubtitle(java.lang.String str) {
        if (com.aliyun.utils.f.b()) {
            nAddExtSubtitle(str);
        }
    }

    public synchronized void clearScreen() {
        if (com.aliyun.utils.f.b()) {
            nClearScreen();
        }
    }

    public void clearScreenIfNeed() {
        com.aliyun.player.nativeclass.PlayerConfig config = getConfig();
        if (config == null || !config.mClearFrameWhenStop) {
            return;
        }
        this.mDisplayViewHelper.clearScreen();
    }

    public synchronized void enableHardwareDecoder(boolean z) {
        if (com.aliyun.utils.f.b()) {
            nEnableHardwareDecoder(z);
        }
    }

    public synchronized com.aliyun.player.IPlayer.AlphaRenderMode getAlphaRenderMode() {
        if (!com.aliyun.utils.f.b()) {
            return com.aliyun.player.IPlayer.AlphaRenderMode.RENDER_MODE_ALPHA_NONE;
        }
        int nGetAlphaRenderMode = nGetAlphaRenderMode();
        com.aliyun.player.IPlayer.AlphaRenderMode alphaRenderMode = com.aliyun.player.IPlayer.AlphaRenderMode.RENDER_MODE_ALPHA_NONE;
        if (nGetAlphaRenderMode == alphaRenderMode.getValue()) {
            return alphaRenderMode;
        }
        com.aliyun.player.IPlayer.AlphaRenderMode alphaRenderMode2 = com.aliyun.player.IPlayer.AlphaRenderMode.RENDER_MODE_ALPHA_AT_RIGHT;
        if (nGetAlphaRenderMode == alphaRenderMode2.getValue()) {
            return alphaRenderMode2;
        }
        com.aliyun.player.IPlayer.AlphaRenderMode alphaRenderMode3 = com.aliyun.player.IPlayer.AlphaRenderMode.RENDER_MODE_ALPHA_AT_LEFT;
        if (nGetAlphaRenderMode == alphaRenderMode3.getValue()) {
            return alphaRenderMode3;
        }
        com.aliyun.player.IPlayer.AlphaRenderMode alphaRenderMode4 = com.aliyun.player.IPlayer.AlphaRenderMode.RENDER_MODE_ALPHA_AT_TOP;
        if (nGetAlphaRenderMode == alphaRenderMode4.getValue()) {
            return alphaRenderMode4;
        }
        com.aliyun.player.IPlayer.AlphaRenderMode alphaRenderMode5 = com.aliyun.player.IPlayer.AlphaRenderMode.RENDER_MODE_ALPHA_AT_BOTTOM;
        return nGetAlphaRenderMode == alphaRenderMode5.getValue() ? alphaRenderMode5 : alphaRenderMode;
    }

    public synchronized long getBufferedPosition() {
        if (!com.aliyun.utils.f.b()) {
            return 0L;
        }
        return nGetBufferedPosition();
    }

    public java.lang.String getCacheFilePath(java.lang.String str) {
        return nGetCacheFilePath(str);
    }

    public java.lang.String getCacheFilePath(java.lang.String str, java.lang.String str2, java.lang.String str3, int i) {
        return nGetCacheFilePath(str, str2, str3, i);
    }

    public synchronized com.aliyun.player.nativeclass.PlayerConfig getConfig() {
        if (!com.aliyun.utils.f.b()) {
            return new com.aliyun.player.nativeclass.PlayerConfig(0);
        }
        java.lang.Object nGetConfig = nGetConfig();
        if (nGetConfig == null) {
            return null;
        }
        return (com.aliyun.player.nativeclass.PlayerConfig) nGetConfig;
    }

    public synchronized long getCurrentPosition() {
        if (!com.aliyun.utils.f.b()) {
            return 0L;
        }
        return nGetCurrentPosition();
    }

    public synchronized com.aliyun.player.nativeclass.TrackInfo getCurrentTrackInfo(int i) {
        if (com.aliyun.utils.f.b()) {
            return (com.aliyun.player.nativeclass.TrackInfo) nGetCurrentStreamInfo(i);
        }
        return new com.aliyun.player.nativeclass.TrackInfo();
    }

    public synchronized long getDuration() {
        if (!com.aliyun.utils.f.b()) {
            return 0L;
        }
        return nGetDuration();
    }

    public synchronized com.aliyun.player.IPlayer.MirrorMode getMirrorMode() {
        if (!com.aliyun.utils.f.b()) {
            return com.aliyun.player.IPlayer.MirrorMode.MIRROR_MODE_NONE;
        }
        int nGetMirrorMode = nGetMirrorMode();
        com.aliyun.player.IPlayer.MirrorMode mirrorMode = com.aliyun.player.IPlayer.MirrorMode.MIRROR_MODE_NONE;
        if (nGetMirrorMode == mirrorMode.getValue()) {
            return mirrorMode;
        }
        com.aliyun.player.IPlayer.MirrorMode mirrorMode2 = com.aliyun.player.IPlayer.MirrorMode.MIRROR_MODE_HORIZONTAL;
        if (nGetMirrorMode == mirrorMode2.getValue()) {
            return mirrorMode2;
        }
        com.aliyun.player.IPlayer.MirrorMode mirrorMode3 = com.aliyun.player.IPlayer.MirrorMode.MIRROR_MODE_VERTICAL;
        return nGetMirrorMode == mirrorMode3.getValue() ? mirrorMode3 : mirrorMode;
    }

    public long getNativeContext() {
        return this.mNativeContext;
    }

    public synchronized java.lang.Object getOption(com.aliyun.player.IPlayer.Option option) {
        if (!com.aliyun.utils.f.b()) {
            return null;
        }
        java.lang.String nGetOption = nGetOption(option.getValue());
        if (nGetOption == null) {
            return null;
        }
        if (option != com.aliyun.player.IPlayer.Option.RenderFPS && option != com.aliyun.player.IPlayer.Option.DownloadBitrate && option != com.aliyun.player.IPlayer.Option.VideoBitrate && option != com.aliyun.player.IPlayer.Option.AudioBitrate) {
            return nGetOption;
        }
        try {
            return java.lang.Float.valueOf(nGetOption);
        } catch (java.lang.Exception unused) {
            return java.lang.Float.valueOf("0");
        }
    }

    public java.lang.String getPlayerName() {
        return !com.aliyun.utils.f.b() ? "" : nGetPlayerName();
    }

    public synchronized int getPlayerStatus() {
        if (!com.aliyun.utils.f.b()) {
            return 0;
        }
        return nGetPlayerStatus();
    }

    public synchronized java.lang.String getPropertyString(int i) {
        if (!com.aliyun.utils.f.b()) {
            return "";
        }
        return nGetPropertyString(i);
    }

    public synchronized com.aliyun.player.IPlayer.RotateMode getRotateMode() {
        if (!com.aliyun.utils.f.b()) {
            return com.aliyun.player.IPlayer.RotateMode.ROTATE_0;
        }
        int nGetRotateMode = nGetRotateMode();
        com.aliyun.player.IPlayer.RotateMode rotateMode = com.aliyun.player.IPlayer.RotateMode.ROTATE_0;
        if (nGetRotateMode == rotateMode.getValue()) {
            return rotateMode;
        }
        com.aliyun.player.IPlayer.RotateMode rotateMode2 = com.aliyun.player.IPlayer.RotateMode.ROTATE_90;
        if (nGetRotateMode == rotateMode2.getValue()) {
            return rotateMode2;
        }
        com.aliyun.player.IPlayer.RotateMode rotateMode3 = com.aliyun.player.IPlayer.RotateMode.ROTATE_180;
        if (nGetRotateMode == rotateMode3.getValue()) {
            return rotateMode3;
        }
        com.aliyun.player.IPlayer.RotateMode rotateMode4 = com.aliyun.player.IPlayer.RotateMode.ROTATE_270;
        return nGetRotateMode == rotateMode4.getValue() ? rotateMode4 : rotateMode;
    }

    public synchronized com.aliyun.player.IPlayer.ScaleMode getScaleMode() {
        if (!com.aliyun.utils.f.b()) {
            return com.aliyun.player.IPlayer.ScaleMode.SCALE_TO_FILL;
        }
        int nGetScaleMode = nGetScaleMode();
        com.aliyun.player.IPlayer.ScaleMode scaleMode = com.aliyun.player.IPlayer.ScaleMode.SCALE_TO_FILL;
        if (nGetScaleMode == scaleMode.getValue()) {
            return scaleMode;
        }
        com.aliyun.player.IPlayer.ScaleMode scaleMode2 = com.aliyun.player.IPlayer.ScaleMode.SCALE_ASPECT_FIT;
        if (nGetScaleMode == scaleMode2.getValue()) {
            return scaleMode2;
        }
        com.aliyun.player.IPlayer.ScaleMode scaleMode3 = com.aliyun.player.IPlayer.ScaleMode.SCALE_ASPECT_FILL;
        return nGetScaleMode == scaleMode3.getValue() ? scaleMode3 : scaleMode;
    }

    public synchronized float getSpeed() {
        if (!com.aliyun.utils.f.b()) {
            return 0.0f;
        }
        return nGetSpeed();
    }

    public synchronized java.lang.String getUserData() {
        if (!com.aliyun.utils.f.b()) {
            return "";
        }
        return nGetUserData();
    }

    public synchronized int getVideoHeight() {
        if (!com.aliyun.utils.f.b()) {
            return 0;
        }
        return nGetVideoHeight();
    }

    public synchronized float getVideoRotation() {
        if (!com.aliyun.utils.f.b()) {
            return 0.0f;
        }
        return nGetVideoRotation();
    }

    public synchronized int getVideoWidth() {
        if (!com.aliyun.utils.f.b()) {
            return 0;
        }
        return nGetVideoWidth();
    }

    public synchronized float getVolume() {
        if (!com.aliyun.utils.f.b()) {
            return 0.0f;
        }
        return nGetVolume();
    }

    public int invokeComponent(java.lang.String str) {
        if (com.aliyun.utils.f.b()) {
            return nInvokeComponent(str);
        }
        return 0;
    }

    public synchronized boolean isAutoPlay() {
        if (!com.aliyun.utils.f.b()) {
            return false;
        }
        return nIsAutoPlay();
    }

    public synchronized boolean isLoop() {
        if (!com.aliyun.utils.f.b()) {
            return false;
        }
        return nIsLoop();
    }

    public synchronized boolean isMuted() {
        if (!com.aliyun.utils.f.b()) {
            return false;
        }
        return nIsMuted();
    }

    public native void nAddExtSubtitle(java.lang.String str);

    public native void nClearScreen();

    public native void nConstruct();

    public native void nEnableFrameCb(boolean z);

    public native void nEnableHardwareDecoder(boolean z);

    public native void nEnablePreFrameCb(boolean z);

    public native void nEnableVideoRenderedCallback(boolean z);

    public native int nGetAlphaRenderMode();

    public native long nGetBufferedPosition();

    public native java.lang.String nGetCacheFilePath(java.lang.String str);

    public native java.lang.String nGetCacheFilePath(java.lang.String str, java.lang.String str2, java.lang.String str3, int i);

    public native java.lang.Object nGetConfig();

    public native long nGetCurrentPosition();

    public native java.lang.Object nGetCurrentStreamInfo(int i);

    public native long nGetDuration();

    public native int nGetMirrorMode();

    public native java.lang.String nGetOption(java.lang.String str);

    public native java.lang.String nGetPlayerName();

    public native int nGetPlayerStatus();

    public native java.lang.String nGetPropertyString(int i);

    public native int nGetRotateMode();

    public native int nGetScaleMode();

    public native float nGetSpeed();

    public native java.lang.String nGetUserData();

    public native int nGetVideoHeight();

    public native int nGetVideoRotation();

    public native int nGetVideoWidth();

    public native float nGetVolume();

    public native int nInvokeComponent(java.lang.String str);

    public native boolean nIsAutoPlay();

    public native boolean nIsLoop();

    public native boolean nIsMuted();

    public native void nPause();

    public native void nPrepare();

    public native void nRelease();

    public native void nReload();

    public native void nSeekTo(long j, int i);

    public native void nSelectExtSubtitle(int i, boolean z);

    public native void nSelectTrack(int i);

    public native void nSelectTrackA(int i, boolean z);

    public native void nSendCustomEvent(java.lang.String str);

    public native void nSetAlphaRenderMode(int i);

    public native void nSetAutoPlay(boolean z);

    public native void nSetCacheConfig(java.lang.Object obj);

    public native void nSetConfig(java.lang.Object obj);

    public native void nSetConnectivityManager(java.lang.Object obj);

    public native void nSetDefaultBandWidth(int i);

    public native void nSetFastStart(boolean z);

    public native void nSetFilterConfig(java.lang.String str);

    public native void nSetFilterInvalid(java.lang.String str, boolean z);

    public native void nSetFrameCbConfig(boolean z, boolean z2);

    public native void nSetIPResolveType(int i);

    public native void nSetLoop(boolean z);

    public native void nSetMaxAccurateSeekDelta(int i);

    public native void nSetMirrorMode(int i);

    public native void nSetMute(boolean z);

    public native void nSetOption(java.lang.String str, java.lang.String str2);

    public native void nSetOutputAudioChannel(int i);

    public native void nSetPreferPlayerName(java.lang.String str);

    public native void nSetRotateMode(int i);

    public native void nSetScaleMode(int i);

    public native void nSetSpeed(float f);

    public native void nSetStartTime(long j, int i);

    public native void nSetStreamDelayTime(int i, int i2);

    public native void nSetSurface(android.view.Surface surface);

    public native void nSetTraceID(java.lang.String str);

    public native void nSetUserData(java.lang.String str);

    public native void nSetVideoBackgroundColor(int i);

    public native void nSetVideoTag(int[] iArr);

    public native void nSetVolume(float f);

    public native void nSnapShot();

    public native void nStart();

    public native void nStop();

    public native void nSurfaceChanged();

    public native void nSwitchStream(java.lang.String str);

    public native void nUpdateFilterConfig(java.lang.String str, java.lang.String str2);

    public void onAVNotSyncEnd() {
        this.mCurrentThreadHandler.post(new com.aliyun.player.nativeclass.NativePlayerBase.AnonymousClass23());
    }

    public void onAVNotSyncStart(int i) {
        this.mCurrentThreadHandler.post(new com.aliyun.player.nativeclass.NativePlayerBase.AnonymousClass22(i));
    }

    public void onAutoPlayStart() {
        this.mCurrentThreadHandler.post(new com.aliyun.player.nativeclass.NativePlayerBase.AnonymousClass6());
    }

    public void onBufferedPositionUpdate(long j) {
        this.mCurrentThreadHandler.post(new com.aliyun.player.nativeclass.NativePlayerBase.AnonymousClass19(j));
    }

    public void onCaptureScreen(int i, int i2, byte[] bArr) {
        android.graphics.Bitmap bitmap = null;
        if (i > 0 && i2 > 0 && bArr != null && bArr.length > 0) {
            try {
                bitmap = android.graphics.Bitmap.createBitmap(i, i2, android.graphics.Bitmap.Config.ARGB_8888);
                bitmap.copyPixelsFromBuffer(java.nio.ByteBuffer.wrap(bArr));
            } catch (java.lang.Exception unused) {
            }
        }
        this.mCurrentThreadHandler.post(new com.aliyun.player.nativeclass.NativePlayerBase.AnonymousClass33(bitmap, i, i2));
    }

    public int onChooseTrackIndex(com.aliyun.player.nativeclass.TrackInfo[] trackInfoArr) {
        com.aliyun.player.IPlayer.OnChooseTrackIndexListener onChooseTrackIndexListener = this.mOnChooseTrackIndexListener;
        if (onChooseTrackIndexListener != null) {
            return onChooseTrackIndexListener.onChooseTrackIndex(trackInfoArr);
        }
        return -1;
    }

    public void onCircleStart() {
        this.mCurrentThreadHandler.post(new com.aliyun.player.nativeclass.NativePlayerBase.AnonymousClass5());
    }

    public void onCompletion() {
        this.mCurrentThreadHandler.post(new com.aliyun.player.nativeclass.NativePlayerBase.AnonymousClass4());
    }

    public void onCurrentDownloadSpeed(long j) {
        this.mCurrentThreadHandler.post(new com.aliyun.player.nativeclass.NativePlayerBase.AnonymousClass24(j));
    }

    public void onCurrentPositionUpdate(long j) {
        this.mCurrentThreadHandler.sendMessage(this.mCurrentThreadHandler.obtainMessage(1000, (int) j, 0));
    }

    public void onError(int i, java.lang.String str, java.lang.String str2) {
        com.aliyun.player.bean.ErrorCode errorCode = com.aliyun.player.bean.ErrorCode.ERROR_UNKNOWN;
        com.aliyun.player.bean.ErrorCode[] values = com.aliyun.player.bean.ErrorCode.values();
        int length = values.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            com.aliyun.player.bean.ErrorCode errorCode2 = values[i2];
            if (errorCode2.getValue() == i) {
                errorCode = errorCode2;
                break;
            }
            i2++;
        }
        this.mCurrentThreadHandler.post(new com.aliyun.player.nativeclass.NativePlayerBase.AnonymousClass7(errorCode, str, str2));
    }

    public void onEvent(int i, java.lang.String str, java.lang.Object obj) {
        com.aliyun.player.bean.InfoCode infoCode = com.aliyun.player.bean.InfoCode.Unknown;
        com.aliyun.player.bean.InfoCode[] values = com.aliyun.player.bean.InfoCode.values();
        int length = values.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            com.aliyun.player.bean.InfoCode infoCode2 = values[i2];
            if (infoCode2.getValue() == i) {
                infoCode = infoCode2;
                break;
            }
            i2++;
        }
        this.mCurrentThreadHandler.post(new com.aliyun.player.nativeclass.NativePlayerBase.AnonymousClass8(infoCode, str));
    }

    public void onFirstFrameShow() {
        if (this.mAliDisplayView != null) {
            this.mDisplayViewHelper.firstFrameRender(getVideoWidth() > 0);
        }
        this.mCurrentThreadHandler.post(new com.aliyun.player.nativeclass.NativePlayerBase.AnonymousClass9());
    }

    public void onHideSubtitle(int i, long j) {
        this.mCurrentThreadHandler.post(new com.aliyun.player.nativeclass.NativePlayerBase.AnonymousClass31(i, j));
    }

    public void onLoadingEnd() {
        this.mCurrentThreadHandler.post(new com.aliyun.player.nativeclass.NativePlayerBase.AnonymousClass27());
    }

    public void onLoadingProgress(float f) {
        this.mCurrentThreadHandler.post(new com.aliyun.player.nativeclass.NativePlayerBase.AnonymousClass21(f));
    }

    public void onLoadingStart() {
        this.mCurrentThreadHandler.post(new com.aliyun.player.nativeclass.NativePlayerBase.AnonymousClass20());
    }

    public void onLocalCacheLoad(long j) {
        this.mCurrentThreadHandler.post(new com.aliyun.player.nativeclass.NativePlayerBase.AnonymousClass26(j));
    }

    public void onPrepared() {
        this.mCurrentThreadHandler.post(new com.aliyun.player.nativeclass.NativePlayerBase.AnonymousClass3());
    }

    public void onSeekEnd() {
        this.mCurrentThreadHandler.post(new com.aliyun.player.nativeclass.NativePlayerBase.AnonymousClass28());
    }

    public void onSeiDataCallback(int i, byte[] bArr, byte[] bArr2) {
        this.mCurrentThreadHandler.post(new com.aliyun.player.nativeclass.NativePlayerBase.AnonymousClass16(i, bArr, bArr2));
    }

    public void onShowSubtitle(int i, long j, java.lang.String str, java.lang.Object obj) {
        this.mCurrentThreadHandler.post(new com.aliyun.player.nativeclass.NativePlayerBase.AnonymousClass29(i, j, str));
    }

    public void onStatusChanged(int i, int i2) {
        this.mCurrentThreadHandler.post(new com.aliyun.player.nativeclass.NativePlayerBase.AnonymousClass18(i));
    }

    public void onStreamInfoGet(com.aliyun.player.nativeclass.MediaInfo mediaInfo) {
        this.mCurrentThreadHandler.post(new com.aliyun.player.nativeclass.NativePlayerBase.AnonymousClass12(mediaInfo));
    }

    public void onSubStreamInfoGet(com.aliyun.player.nativeclass.MediaInfo mediaInfo) {
        this.mCurrentThreadHandler.post(new com.aliyun.player.nativeclass.NativePlayerBase.AnonymousClass13(mediaInfo));
    }

    public void onSubtitleExtAdded(int i, java.lang.String str) {
        this.mCurrentThreadHandler.post(new com.aliyun.player.nativeclass.NativePlayerBase.AnonymousClass30(i, str));
    }

    public void onSubtitleHeader(int i, java.lang.String str) {
        this.mCurrentThreadHandler.post(new com.aliyun.player.nativeclass.NativePlayerBase.AnonymousClass32(i, str));
    }

    public void onSwitchStreamFail(com.aliyun.player.nativeclass.TrackInfo trackInfo, int i, java.lang.String str) {
        com.aliyun.player.bean.ErrorCode errorCode;
        com.aliyun.player.bean.ErrorCode errorCode2 = com.aliyun.player.bean.ErrorCode.ERROR_UNKNOWN;
        com.aliyun.player.bean.ErrorCode[] values = com.aliyun.player.bean.ErrorCode.values();
        int length = values.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                errorCode = errorCode2;
                break;
            }
            com.aliyun.player.bean.ErrorCode errorCode3 = values[i2];
            if (errorCode3.getValue() == i) {
                errorCode = errorCode3;
                break;
            }
            i2++;
        }
        this.mCurrentThreadHandler.post(new com.aliyun.player.nativeclass.NativePlayerBase.AnonymousClass17(errorCode, i, str, trackInfo));
    }

    public void onSwitchStreamSuccess(com.aliyun.player.nativeclass.TrackInfo trackInfo) {
        this.mCurrentThreadHandler.post(new com.aliyun.player.nativeclass.NativePlayerBase.AnonymousClass15(trackInfo));
    }

    public void onSwitchStreamUrlResult(java.lang.String str, int i, java.lang.String str2) {
        com.aliyun.player.bean.ErrorCode errorCode;
        com.aliyun.player.bean.ErrorCode errorCode2 = com.aliyun.player.bean.ErrorCode.ERROR_UNKNOWN;
        com.aliyun.player.bean.ErrorCode[] values = com.aliyun.player.bean.ErrorCode.values();
        int length = values.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                errorCode = errorCode2;
                break;
            }
            com.aliyun.player.bean.ErrorCode errorCode3 = values[i2];
            if (errorCode3.getValue() == i) {
                errorCode = errorCode3;
                break;
            }
            i2++;
        }
        this.mCurrentThreadHandler.post(new com.aliyun.player.nativeclass.NativePlayerBase.AnonymousClass14(i, str, errorCode, str2));
    }

    public void onUtcTimeUpdate(long j) {
        this.mCurrentThreadHandler.post(new com.aliyun.player.nativeclass.NativePlayerBase.AnonymousClass25(j));
    }

    public void onVideoRendered(long j, long j2) {
        this.mCurrentThreadHandler.post(new com.aliyun.player.nativeclass.NativePlayerBase.AnonymousClass11(j, j2));
    }

    public void onVideoSizeChanged(int i, int i2) {
        this.mCurrentThreadHandler.post(new com.aliyun.player.nativeclass.NativePlayerBase.AnonymousClass10(i, i2));
    }

    public synchronized void pause() {
        if (com.aliyun.utils.f.b()) {
            nPause();
        }
    }

    public synchronized void prepare() {
        if (com.aliyun.utils.f.b()) {
            nPrepare();
        }
    }

    public synchronized void release() {
        if (com.aliyun.utils.f.b()) {
            nRelease();
            mContext = null;
        }
    }

    public synchronized void reload() {
        if (com.aliyun.utils.f.b()) {
            nReload();
        }
    }

    @com.cicada.player.utils.NativeUsed
    public byte[] requestKey(java.lang.String str, byte[] bArr) {
        com.cicada.player.utils.media.DrmCallback drmCallback = this.mDrmCallback;
        if (drmCallback == null) {
            return null;
        }
        return drmCallback.requestKey(str, bArr);
    }

    @com.cicada.player.utils.NativeUsed
    public byte[] requestProvision(java.lang.String str, byte[] bArr) {
        com.cicada.player.utils.media.DrmCallback drmCallback = this.mDrmCallback;
        if (drmCallback == null) {
            return null;
        }
        return drmCallback.requestProvision(str, bArr);
    }

    public synchronized void seekTo(long j) {
        if (com.aliyun.utils.f.b()) {
            this.mCurrentThreadHandler.removeMessages(1000);
            nSeekTo(j, 16);
        }
    }

    public synchronized void seekTo(long j, int i) {
        if (com.aliyun.utils.f.b()) {
            this.mCurrentThreadHandler.removeMessages(1000);
            nSeekTo(j, i);
        }
    }

    public void selectExtSubtitle(int i, boolean z) {
        if (com.aliyun.utils.f.b()) {
            nSelectExtSubtitle(i, z);
        }
    }

    public synchronized void selectTrack(int i) {
        if (com.aliyun.utils.f.b()) {
            nSelectTrack(i);
        }
    }

    public synchronized void selectTrack(int i, boolean z) {
        if (com.aliyun.utils.f.b()) {
            nSelectTrackA(i, z);
        }
    }

    public void sendCustomEvent(java.lang.String str) {
        if (com.aliyun.utils.f.b()) {
            nSendCustomEvent(str);
        }
    }

    public synchronized void setAlphaRenderMode(com.aliyun.player.IPlayer.AlphaRenderMode alphaRenderMode) {
        if (com.aliyun.utils.f.b()) {
            nSetAlphaRenderMode(alphaRenderMode.getValue());
        }
    }

    public synchronized void setAutoPlay(boolean z) {
        if (com.aliyun.utils.f.b()) {
            nSetAutoPlay(z);
        }
    }

    public synchronized void setCacheConfig(com.aliyun.player.nativeclass.CacheConfig cacheConfig) {
        if (com.aliyun.utils.f.b()) {
            nSetCacheConfig(cacheConfig);
        }
    }

    public synchronized void setConfig(com.aliyun.player.nativeclass.PlayerConfig playerConfig) {
        if (com.aliyun.utils.f.b()) {
            this.mEnableTunnelMode = playerConfig.mEnableVideoTunnelRender;
            nSetConfig(playerConfig);
        }
    }

    public synchronized void setDefaultBandWidth(int i) {
        if (com.aliyun.utils.f.b()) {
            nSetDefaultBandWidth(i);
        }
    }

    public void setDisplayView(com.aliyun.player.videoview.AliDisplayView aliDisplayView) {
        this.mAliDisplayView = aliDisplayView;
        if (aliDisplayView == null) {
            this.mDisplayViewHelper = null;
            return;
        }
        com.aliyun.player.nativeclass.DisplayViewHelper displayViewHelper = aliDisplayView.getDisplayViewHelper();
        this.mDisplayViewHelper = displayViewHelper;
        displayViewHelper.setOnViewStatusListener(new com.aliyun.player.nativeclass.NativePlayerBase.AnonymousClass35());
        if (getVideoWidth() > 0 || getVideoHeight() > 0) {
            nUpdateViewCallback(this.mVideoType);
        }
    }

    public void setDrmCallback(com.cicada.player.utils.media.DrmCallback drmCallback) {
        this.mDrmCallback = drmCallback;
    }

    public synchronized void setFastStart(boolean z) {
        if (com.aliyun.utils.f.b()) {
            nSetFastStart(z);
        }
    }

    public void setFilterConfig(com.aliyun.player.FilterConfig filterConfig) {
        if (com.aliyun.utils.f.b()) {
            nSetFilterConfig(filterConfig == null ? null : filterConfig.toString());
        }
    }

    public void setFilterInvalid(java.lang.String str, boolean z) {
        if (com.aliyun.utils.f.b()) {
            nSetFilterInvalid(str, z);
        }
    }

    public synchronized void setIPResolveType(com.aliyun.player.IPlayer.IPResolveType iPResolveType) {
        if (com.aliyun.utils.f.b()) {
            nSetIPResolveType(iPResolveType.ordinal());
        }
    }

    public synchronized void setLoop(boolean z) {
        if (com.aliyun.utils.f.b()) {
            nSetLoop(z);
        }
    }

    public void setMaxAccurateSeekDelta(int i) {
        if (com.aliyun.utils.f.b()) {
            nSetMaxAccurateSeekDelta(i);
        }
    }

    public synchronized void setMirrorMode(com.aliyun.player.IPlayer.MirrorMode mirrorMode) {
        if (com.aliyun.utils.f.b()) {
            if (this.mAliDisplayView != null && this.mDirectRender) {
                this.mDisplayViewHelper.setMirrorMode(mirrorMode);
            }
            nSetMirrorMode(mirrorMode.getValue());
        }
    }

    public synchronized void setMute(boolean z) {
        if (com.aliyun.utils.f.b()) {
            nSetMute(z);
        }
    }

    public void setNativeContext(long j) {
        this.mNativeContext = j;
    }

    public void setOnAVNotSyncStatusListener(com.aliyun.player.IPlayer.OnAVNotSyncStatusListener onAVNotSyncStatusListener) {
        this.mOnAVNotSyncStatusListener = onAVNotSyncStatusListener;
    }

    public void setOnChooseTrackIndexListener(com.aliyun.player.IPlayer.OnChooseTrackIndexListener onChooseTrackIndexListener) {
        this.mOnChooseTrackIndexListener = onChooseTrackIndexListener;
    }

    public void setOnCompletionListener(com.aliyun.player.IPlayer.OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
    }

    public void setOnErrorListener(com.aliyun.player.IPlayer.OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    public void setOnInfoListener(com.aliyun.player.IPlayer.OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
    }

    public void setOnLoadingStatusListener(com.aliyun.player.IPlayer.OnLoadingStatusListener onLoadingStatusListener) {
        this.mOnLoadingStatusListener = onLoadingStatusListener;
    }

    public void setOnPreRenderFrameCallback(com.aliyun.player.IPlayer.OnPreRenderFrameCallback onPreRenderFrameCallback) {
        if (com.aliyun.utils.f.b()) {
            this.mPreRenderFrameCallback = onPreRenderFrameCallback;
            nEnablePreFrameCb(onPreRenderFrameCallback != null);
        }
    }

    public void setOnPreparedListener(com.aliyun.player.IPlayer.OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
    }

    public void setOnRenderFrameCallback(com.aliyun.player.IPlayer.OnRenderFrameCallback onRenderFrameCallback) {
        if (com.aliyun.utils.f.b()) {
            this.mRenderFrameCallback = onRenderFrameCallback;
            nEnableFrameCb(onRenderFrameCallback != null);
        }
    }

    public void setOnRenderingStartListener(com.aliyun.player.IPlayer.OnRenderingStartListener onRenderingStartListener) {
        this.mOnRenderingStartListener = onRenderingStartListener;
    }

    public void setOnReportEventListener(com.aliyun.player.IPlayer.OnReportEventListener onReportEventListener) {
        this.mOnEventReportListner = onReportEventListener;
    }

    public void setOnSeekCompleteListener(com.aliyun.player.IPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.mOnSeekCompleteListener = onSeekCompleteListener;
    }

    public void setOnSeiDataListener(com.aliyun.player.IPlayer.OnSeiDataListener onSeiDataListener) {
        this.mOnSeiDataListener = onSeiDataListener;
    }

    public void setOnSnapShotListener(com.aliyun.player.IPlayer.OnSnapShotListener onSnapShotListener) {
        this.mOnSnapShotListener = onSnapShotListener;
    }

    public void setOnStateChangedListener(com.aliyun.player.IPlayer.OnStateChangedListener onStateChangedListener) {
        this.mOnStateChangedListener = onStateChangedListener;
    }

    public void setOnStreamSwitchedListener(com.aliyun.player.IPlayer.OnStreamSwitchedListener onStreamSwitchedListener) {
        this.mOnStreamSwitchedListener = onStreamSwitchedListener;
    }

    public void setOnSubTrackInfoGetListener(com.aliyun.player.IPlayer.OnSubTrackReadyListener onSubTrackReadyListener) {
        this.mOnSubTrackReadyListener = onSubTrackReadyListener;
    }

    public void setOnSubtitleDisplayListener(com.aliyun.player.IPlayer.OnSubtitleDisplayListener onSubtitleDisplayListener) {
        this.mOnSubtitleDisplayListener = onSubtitleDisplayListener;
    }

    public void setOnTrackInfoGetListener(com.aliyun.player.IPlayer.OnTrackReadyListener onTrackReadyListener) {
        this.mOnTrackReadyListener = onTrackReadyListener;
    }

    public void setOnTrackSelectRetListener(com.aliyun.player.IPlayer.OnTrackChangedListener onTrackChangedListener) {
        this.mOnTrackChangedListener = onTrackChangedListener;
    }

    public void setOnVideoRenderedListener(com.aliyun.player.IPlayer.OnVideoRenderedListener onVideoRenderedListener) {
        this.mOnVideoRenderedListener = onVideoRenderedListener;
        nEnableVideoRenderedCallback(onVideoRenderedListener != null);
    }

    public void setOnVideoSizeChangedListener(com.aliyun.player.IPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mOnVideoSizeChangedListener = onVideoSizeChangedListener;
    }

    public synchronized void setOption(java.lang.String str, java.lang.String str2) {
        if (com.aliyun.utils.f.b()) {
            nSetOption(str, str2);
        }
    }

    public synchronized void setOutputAudioChannel(int i) {
        if (com.aliyun.utils.f.b()) {
            nSetOutputAudioChannel(i);
        }
    }

    public void setPreferPlayerName(java.lang.String str) {
        if (com.aliyun.utils.f.b()) {
            nSetPreferPlayerName(str);
        }
    }

    public void setRenderFrameCallbackConfig(com.aliyun.player.IPlayer.RenderFrameCallbackConfig renderFrameCallbackConfig) {
        if (com.aliyun.utils.f.b()) {
            nSetFrameCbConfig(!renderFrameCallbackConfig.mVideoDataAddr, !renderFrameCallbackConfig.mAudioDataAddr);
        }
    }

    public synchronized void setRotateMode(com.aliyun.player.IPlayer.RotateMode rotateMode) {
        if (com.aliyun.utils.f.b()) {
            if (this.mAliDisplayView != null && this.mDirectRender) {
                this.mDisplayViewHelper.setRotateMode(rotateMode);
            }
            nSetRotateMode(rotateMode.getValue());
        }
    }

    public synchronized void setScaleMode(com.aliyun.player.IPlayer.ScaleMode scaleMode) {
        if (com.aliyun.utils.f.b()) {
            com.aliyun.player.videoview.AliDisplayView aliDisplayView = this.mAliDisplayView;
            if (aliDisplayView != null && this.mDirectRender) {
                aliDisplayView.post(new com.aliyun.player.nativeclass.NativePlayerBase.AnonymousClass1(scaleMode));
            }
            nSetScaleMode(scaleMode.ordinal());
        }
    }

    public synchronized void setSpeed(float f) {
        if (com.aliyun.utils.f.b()) {
            nSetSpeed(f);
        }
    }

    public synchronized void setStartTime(long j, int i) {
        if (com.aliyun.utils.f.b()) {
            this.mCurrentThreadHandler.removeMessages(1000);
            nSetStartTime(j, i);
        }
    }

    public void setStreamDelayTime(int i, int i2) {
        if (com.aliyun.utils.f.b()) {
            nSetStreamDelayTime(i, i2);
        }
    }

    public synchronized void setSurface(android.view.Surface surface) {
        if (this.mAliDisplayView != null) {
            return;
        }
        this.mAliDisplayView = null;
        this.mDisplayViewHelper = null;
        setSurfaceInner(surface, true);
    }

    public synchronized void setTraceId(java.lang.String str) {
        if (com.aliyun.utils.f.b()) {
            nSetTraceID(str);
        }
    }

    public synchronized void setUserData(java.lang.String str) {
        if (com.aliyun.utils.f.b()) {
            nSetUserData(str);
        }
    }

    public synchronized void setVideoBackgroundColor(int i) {
        if (com.aliyun.utils.f.b()) {
            if (this.mAliDisplayView != null && this.mDirectRender) {
                this.mDisplayViewHelper.setBackgroundColor(i);
            }
            nSetVideoBackgroundColor(i);
        }
    }

    public void setVideoTag(int[] iArr) {
        if (com.aliyun.utils.f.b()) {
            nSetVideoTag(iArr);
        }
    }

    public synchronized void setVolume(float f) {
        if (com.aliyun.utils.f.b()) {
            nSetVolume(f);
        }
    }

    public synchronized void snapShot() {
        if (com.aliyun.utils.f.b()) {
            com.aliyun.player.videoview.AliDisplayView aliDisplayView = this.mAliDisplayView;
            if (aliDisplayView == null || !this.mDirectRender) {
                nSnapShot();
            } else {
                aliDisplayView.post(new com.aliyun.player.nativeclass.NativePlayerBase.AnonymousClass2());
            }
        }
    }

    public synchronized void start() {
        if (com.aliyun.utils.f.b()) {
            nStart();
        }
    }

    public synchronized void stop() {
        if (com.aliyun.utils.f.b()) {
            if (this.mAliDisplayView != null && this.mDirectRender) {
                clearScreenIfNeed();
            }
            nStop();
        }
    }

    public void surfaceChanged() {
        if (com.aliyun.utils.f.b()) {
            nSurfaceChanged();
        }
    }

    public synchronized void switchStream(java.lang.String str) {
        if (com.aliyun.utils.f.b()) {
            nSwitchStream(str);
        }
    }

    public void updateFilterConfig(java.lang.String str, com.aliyun.player.FilterConfig.FilterOptions filterOptions) {
        if (com.aliyun.utils.f.b()) {
            nUpdateFilterConfig(str, filterOptions == null ? null : filterOptions.toString());
        }
    }
}
