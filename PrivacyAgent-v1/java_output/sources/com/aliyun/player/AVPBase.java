package com.aliyun.player;

/* loaded from: classes.dex */
public abstract class AVPBase implements com.aliyun.player.IPlayer {
    private static final java.lang.String TAG = "AVPBase";
    protected android.content.Context mContext;
    private com.aliyun.player.nativeclass.NativePlayerBase mCorePlayer;
    protected java.lang.String mTraceID;
    private com.aliyun.player.nativeclass.MediaInfo mOutMediaInfo = null;
    private com.aliyun.player.nativeclass.MediaInfo mOutSubMediaInfo = null;
    private com.aliyun.player.IPlayer.OnPreparedListener mOutOnPreparedListener = null;
    private com.aliyun.player.IPlayer.OnPreparedListener mInnerOnPreparedListener = new com.aliyun.player.AVPBase.InnerPrepareListener(this);
    private com.aliyun.player.IPlayer.OnInfoListener mOutOnInfoListener = null;
    private com.aliyun.player.IPlayer.OnInfoListener mInnerOnInfoListener = new com.aliyun.player.AVPBase.InnerInfoListener(this);
    private com.aliyun.player.IPlayer.OnChooseTrackIndexListener mOutOnChooseTrackIndexListener = null;
    private com.aliyun.player.IPlayer.OnChooseTrackIndexListener mInnerOnChooseTrackIndexListener = new com.aliyun.player.AVPBase.InnerOnChooseTrackIndexListener(this);
    private com.aliyun.player.IPlayer.OnErrorListener mOutOnErrorListener = null;
    private com.aliyun.player.IPlayer.OnErrorListener mInnerOnErrorListener = new com.aliyun.player.AVPBase.InnerErrorListener(this);
    private com.aliyun.player.IPlayer.OnCompletionListener mOutOnCompletionListener = null;
    private com.aliyun.player.IPlayer.OnCompletionListener mInnerOnCompletionListener = new com.aliyun.player.AVPBase.InnerCompletionListener(this);
    private com.aliyun.player.IPlayer.OnRenderingStartListener mOutOnRenderingStartListener = null;
    private com.aliyun.player.IPlayer.OnRenderingStartListener mInnerOnFirstFrameShowListener = new com.aliyun.player.AVPBase.InnerRenderListener(this);
    private com.aliyun.player.IPlayer.OnVideoSizeChangedListener mOutOnVideoSizeChangedListener = null;
    private com.aliyun.player.IPlayer.OnVideoSizeChangedListener mInnerOnVideoSizeChangedListener = new com.aliyun.player.AVPBase.InnerVideoSizeChangedListener(this);
    private com.aliyun.player.IPlayer.OnTrackReadyListener mOutOnTrackReadyListener = null;
    private com.aliyun.player.IPlayer.OnTrackReadyListener mInnerOnTrackReadyListener = new com.aliyun.player.AVPBase.InnerTrackReadyListener(this);
    private com.aliyun.player.IPlayer.OnSubTrackReadyListener mOutOnSubTrackReadyListener = null;
    private com.aliyun.player.IPlayer.OnSubTrackReadyListener mInnerOnSubTrackReadyListener = new com.aliyun.player.AVPBase.InnerSubTrackReadyListener(this);
    private com.aliyun.player.IPlayer.OnAVNotSyncStatusListener mOutOnAVNotSyncStatusListener = null;
    private com.aliyun.player.IPlayer.OnAVNotSyncStatusListener mInnerOnAVNotSyncStatusListener = new com.aliyun.player.AVPBase.InnerAVNotSyncStatusListener(this);
    private com.aliyun.player.IPlayer.OnLoadingStatusListener mOutOnLoadingStatusListener = null;
    private com.aliyun.player.IPlayer.OnLoadingStatusListener mInnerOnLoadingStatusListener = new com.aliyun.player.AVPBase.InnerLoadingStatusListener(this);
    private com.aliyun.player.IPlayer.OnSeekCompleteListener mOutOnSeekEndListener = null;
    private com.aliyun.player.IPlayer.OnSeekCompleteListener mInnerOnSeekEndListener = new com.aliyun.player.AVPBase.InnerSeekEndListener(this);
    private com.aliyun.player.IPlayer.OnSubtitleDisplayListener mOutOnSubtitleDisplayListener = null;
    private com.aliyun.player.IPlayer.OnSubtitleDisplayListener mInnerOnSubtitleDisplayListener = new com.aliyun.player.AVPBase.InnerSubtitleDisplayListener(this);
    private com.aliyun.player.IPlayer.OnSeiDataListener mOutOnSeiDataListener = null;
    private com.aliyun.player.IPlayer.OnSeiDataListener mInnerOnSeiDataListener = new com.aliyun.player.AVPBase.InnerSeiDataListener(this);
    private com.aliyun.player.IPlayer.OnStreamSwitchedListener mOutOnStreamSwitchedListener = null;
    private com.aliyun.player.IPlayer.OnStreamSwitchedListener mInnerOnStreamSwitchedListener = new com.aliyun.player.AVPBase.InnerStreamSwitchedListener(this);
    private com.aliyun.player.IPlayer.OnTrackChangedListener mOutOnTrackChangedListener = null;
    private com.aliyun.player.IPlayer.OnTrackChangedListener mInnerOnTrackChangedListener = new com.aliyun.player.AVPBase.InnerTrackChangedListener(this);
    private com.aliyun.player.IPlayer.OnSnapShotListener mOutOnSnapShotListener = null;
    private com.aliyun.player.IPlayer.OnSnapShotListener mInnerOnSnapShotListener = new com.aliyun.player.AVPBase.InnerSnapShotListener(this);
    private com.aliyun.player.IPlayer.OnStateChangedListener mOutOnStatusChangedListener = null;
    private com.aliyun.player.IPlayer.OnStateChangedListener mInnerOnStatusChangedListener = new com.aliyun.player.AVPBase.InnerStatusChangedListener(this);
    private com.aliyun.player.IPlayer.OnVideoRenderedListener mOutOnVideoRenderedListener = null;
    private com.aliyun.player.IPlayer.OnVideoRenderedListener mInnerOnVideoRenderedListener = new com.aliyun.player.AVPBase.InnerVideoRenderedListener(this);
    private com.aliyun.player.IPlayer.OnReportEventListener mOutEventListener = null;
    private com.aliyun.player.AVPBase.InnerOnReportEventListener mInnerOnReportEventListener = new com.aliyun.player.AVPBase.InnerOnReportEventListener(this);

    /* renamed from: com.aliyun.player.AVPBase$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.aliyun.player.AVPBase.this.stop();
            com.aliyun.player.AVPBase.this.release();
        }
    }

    public static class InnerAVNotSyncStatusListener implements com.aliyun.player.IPlayer.OnAVNotSyncStatusListener {
        private java.lang.ref.WeakReference<com.aliyun.player.AVPBase> avpBaseWR;

        public InnerAVNotSyncStatusListener(com.aliyun.player.AVPBase aVPBase) {
            this.avpBaseWR = new java.lang.ref.WeakReference<>(aVPBase);
        }

        @Override // com.aliyun.player.IPlayer.OnAVNotSyncStatusListener
        public void onAVNotSyncEnd() {
            com.aliyun.player.AVPBase aVPBase = this.avpBaseWR.get();
            if (aVPBase != null) {
                aVPBase.onAVNotSyncEnd();
            }
        }

        @Override // com.aliyun.player.IPlayer.OnAVNotSyncStatusListener
        public void onAVNotSyncStart(int i) {
            com.aliyun.player.AVPBase aVPBase = this.avpBaseWR.get();
            if (aVPBase != null) {
                aVPBase.onAVNotSyncStart(i);
            }
        }
    }

    public static class InnerCompletionListener implements com.aliyun.player.IPlayer.OnCompletionListener {
        private java.lang.ref.WeakReference<com.aliyun.player.AVPBase> avpBaseWR;

        public InnerCompletionListener(com.aliyun.player.AVPBase aVPBase) {
            this.avpBaseWR = new java.lang.ref.WeakReference<>(aVPBase);
        }

        @Override // com.aliyun.player.IPlayer.OnCompletionListener
        public void onCompletion() {
            com.aliyun.player.AVPBase aVPBase = this.avpBaseWR.get();
            if (aVPBase != null) {
                aVPBase.onCompletion();
            }
        }
    }

    public static class InnerErrorListener implements com.aliyun.player.IPlayer.OnErrorListener {
        private java.lang.ref.WeakReference<com.aliyun.player.AVPBase> avpBaseWR;

        public InnerErrorListener(com.aliyun.player.AVPBase aVPBase) {
            this.avpBaseWR = new java.lang.ref.WeakReference<>(aVPBase);
        }

        @Override // com.aliyun.player.IPlayer.OnErrorListener
        public void onError(com.aliyun.player.bean.ErrorInfo errorInfo) {
            com.aliyun.player.AVPBase aVPBase = this.avpBaseWR.get();
            if (aVPBase != null) {
                aVPBase.onError(errorInfo);
            }
        }
    }

    public static class InnerInfoListener implements com.aliyun.player.IPlayer.OnInfoListener {
        private java.lang.ref.WeakReference<com.aliyun.player.AVPBase> avpBaseWR;

        public InnerInfoListener(com.aliyun.player.AVPBase aVPBase) {
            this.avpBaseWR = new java.lang.ref.WeakReference<>(aVPBase);
        }

        @Override // com.aliyun.player.IPlayer.OnInfoListener
        public void onInfo(com.aliyun.player.bean.InfoBean infoBean) {
            com.aliyun.player.AVPBase aVPBase = this.avpBaseWR.get();
            if (aVPBase != null) {
                aVPBase.onInfo(infoBean);
            }
        }
    }

    public static class InnerLoadingStatusListener implements com.aliyun.player.IPlayer.OnLoadingStatusListener {
        private java.lang.ref.WeakReference<com.aliyun.player.AVPBase> avpBaseWR;

        public InnerLoadingStatusListener(com.aliyun.player.AVPBase aVPBase) {
            this.avpBaseWR = new java.lang.ref.WeakReference<>(aVPBase);
        }

        @Override // com.aliyun.player.IPlayer.OnLoadingStatusListener
        public void onLoadingBegin() {
            com.aliyun.player.AVPBase aVPBase = this.avpBaseWR.get();
            if (aVPBase != null) {
                aVPBase.onLoadingBegin();
            }
        }

        @Override // com.aliyun.player.IPlayer.OnLoadingStatusListener
        public void onLoadingEnd() {
            com.aliyun.player.AVPBase aVPBase = this.avpBaseWR.get();
            if (aVPBase != null) {
                aVPBase.onLoadingEnd();
            }
        }

        @Override // com.aliyun.player.IPlayer.OnLoadingStatusListener
        public void onLoadingProgress(int i, float f) {
            com.aliyun.player.AVPBase aVPBase = this.avpBaseWR.get();
            if (aVPBase != null) {
                aVPBase.onLoadingProgress(i, f);
            }
        }
    }

    public static class InnerOnChooseTrackIndexListener implements com.aliyun.player.IPlayer.OnChooseTrackIndexListener {
        private java.lang.ref.WeakReference<com.aliyun.player.AVPBase> avpBaseWR;

        public InnerOnChooseTrackIndexListener(com.aliyun.player.AVPBase aVPBase) {
            this.avpBaseWR = new java.lang.ref.WeakReference<>(aVPBase);
        }

        @Override // com.aliyun.player.IPlayer.OnChooseTrackIndexListener
        public int onChooseTrackIndex(com.aliyun.player.nativeclass.TrackInfo[] trackInfoArr) {
            com.aliyun.player.AVPBase aVPBase = this.avpBaseWR.get();
            if (aVPBase != null) {
                return aVPBase.onChooseTrackIndex(trackInfoArr);
            }
            return -1;
        }
    }

    public static class InnerOnReportEventListener implements com.aliyun.player.IPlayer.OnReportEventListener {
        private java.lang.ref.WeakReference<com.aliyun.player.AVPBase> avpBaseWR;

        public InnerOnReportEventListener(com.aliyun.player.AVPBase aVPBase) {
            this.avpBaseWR = new java.lang.ref.WeakReference<>(aVPBase);
        }

        @Override // com.aliyun.player.IPlayer.OnReportEventListener
        public void onEventParam(java.util.Map<java.lang.String, java.lang.String> map) {
            com.aliyun.player.AVPBase aVPBase = this.avpBaseWR.get();
            if (aVPBase != null) {
                aVPBase.onEventParam(map);
            }
        }
    }

    public static class InnerPrepareListener implements com.aliyun.player.IPlayer.OnPreparedListener {
        private java.lang.ref.WeakReference<com.aliyun.player.AVPBase> avpBaseWR;

        public InnerPrepareListener(com.aliyun.player.AVPBase aVPBase) {
            this.avpBaseWR = new java.lang.ref.WeakReference<>(aVPBase);
        }

        @Override // com.aliyun.player.IPlayer.OnPreparedListener
        public void onPrepared() {
            com.aliyun.player.AVPBase aVPBase = this.avpBaseWR.get();
            if (aVPBase != null) {
                aVPBase.onPrepared();
            }
        }
    }

    public static class InnerRenderListener implements com.aliyun.player.IPlayer.OnRenderingStartListener {
        private java.lang.ref.WeakReference<com.aliyun.player.AVPBase> avpBaseWR;

        public InnerRenderListener(com.aliyun.player.AVPBase aVPBase) {
            this.avpBaseWR = new java.lang.ref.WeakReference<>(aVPBase);
        }

        @Override // com.aliyun.player.IPlayer.OnRenderingStartListener
        public void onRenderingStart() {
            com.aliyun.player.AVPBase aVPBase = this.avpBaseWR.get();
            if (aVPBase != null) {
                aVPBase.onVideoRenderingStart();
            }
        }
    }

    public static class InnerSeekEndListener implements com.aliyun.player.IPlayer.OnSeekCompleteListener {
        private java.lang.ref.WeakReference<com.aliyun.player.AVPBase> avpBaseWR;

        public InnerSeekEndListener(com.aliyun.player.AVPBase aVPBase) {
            this.avpBaseWR = new java.lang.ref.WeakReference<>(aVPBase);
        }

        @Override // com.aliyun.player.IPlayer.OnSeekCompleteListener
        public void onSeekComplete() {
            com.aliyun.player.AVPBase aVPBase = this.avpBaseWR.get();
            if (aVPBase != null) {
                aVPBase.onSeekComplete();
            }
        }
    }

    public static class InnerSeiDataListener implements com.aliyun.player.IPlayer.OnSeiDataListener {
        private java.lang.ref.WeakReference<com.aliyun.player.AVPBase> avpBaseWR;

        public InnerSeiDataListener(com.aliyun.player.AVPBase aVPBase) {
            this.avpBaseWR = new java.lang.ref.WeakReference<>(aVPBase);
        }

        @Override // com.aliyun.player.IPlayer.OnSeiDataListener
        public void onSeiData(int i, byte[] bArr, byte[] bArr2) {
            com.aliyun.player.AVPBase aVPBase = this.avpBaseWR.get();
            if (aVPBase != null) {
                aVPBase.onSeiData(i, bArr, bArr2);
            }
        }
    }

    public static class InnerSnapShotListener implements com.aliyun.player.IPlayer.OnSnapShotListener {
        private java.lang.ref.WeakReference<com.aliyun.player.AVPBase> avpBaseWR;

        public InnerSnapShotListener(com.aliyun.player.AVPBase aVPBase) {
            this.avpBaseWR = new java.lang.ref.WeakReference<>(aVPBase);
        }

        @Override // com.aliyun.player.IPlayer.OnSnapShotListener
        public void onSnapShot(android.graphics.Bitmap bitmap, int i, int i2) {
            com.aliyun.player.AVPBase aVPBase = this.avpBaseWR.get();
            if (aVPBase != null) {
                aVPBase.onSnapShot(bitmap, i, i2);
            }
        }
    }

    public static class InnerStatusChangedListener implements com.aliyun.player.IPlayer.OnStateChangedListener {
        private java.lang.ref.WeakReference<com.aliyun.player.AVPBase> avpBaseWR;

        public InnerStatusChangedListener(com.aliyun.player.AVPBase aVPBase) {
            this.avpBaseWR = new java.lang.ref.WeakReference<>(aVPBase);
        }

        @Override // com.aliyun.player.IPlayer.OnStateChangedListener
        public void onStateChanged(int i) {
            com.aliyun.player.AVPBase aVPBase = this.avpBaseWR.get();
            if (aVPBase != null) {
                aVPBase.onStateChanged(i);
            }
        }
    }

    public static class InnerStreamSwitchedListener implements com.aliyun.player.IPlayer.OnStreamSwitchedListener {
        private java.lang.ref.WeakReference<com.aliyun.player.AVPBase> avpBaseWR;

        public InnerStreamSwitchedListener(com.aliyun.player.AVPBase aVPBase) {
            this.avpBaseWR = new java.lang.ref.WeakReference<>(aVPBase);
        }

        @Override // com.aliyun.player.IPlayer.OnStreamSwitchedListener
        public void onSwitchedFail(java.lang.String str, com.aliyun.player.bean.ErrorInfo errorInfo) {
            com.aliyun.player.AVPBase aVPBase = this.avpBaseWR.get();
            if (aVPBase != null) {
                aVPBase.onSwitchedFail(str, errorInfo);
            }
        }

        @Override // com.aliyun.player.IPlayer.OnStreamSwitchedListener
        public void onSwitchedSuccess(java.lang.String str) {
            com.aliyun.player.AVPBase aVPBase = this.avpBaseWR.get();
            if (aVPBase != null) {
                aVPBase.onSwitchedSuccess(str);
            }
        }
    }

    public static class InnerSubTrackReadyListener implements com.aliyun.player.IPlayer.OnSubTrackReadyListener {
        private java.lang.ref.WeakReference<com.aliyun.player.AVPBase> avpBaseWR;

        public InnerSubTrackReadyListener(com.aliyun.player.AVPBase aVPBase) {
            this.avpBaseWR = new java.lang.ref.WeakReference<>(aVPBase);
        }

        @Override // com.aliyun.player.IPlayer.OnSubTrackReadyListener
        public void onSubTrackReady(com.aliyun.player.nativeclass.MediaInfo mediaInfo) {
            com.aliyun.player.AVPBase aVPBase = this.avpBaseWR.get();
            if (aVPBase != null) {
                aVPBase.onSubTrackReady(mediaInfo);
            }
        }
    }

    public static class InnerSubtitleDisplayListener implements com.aliyun.player.IPlayer.OnSubtitleDisplayListener {
        private java.lang.ref.WeakReference<com.aliyun.player.AVPBase> avpBaseWR;

        public InnerSubtitleDisplayListener(com.aliyun.player.AVPBase aVPBase) {
            this.avpBaseWR = new java.lang.ref.WeakReference<>(aVPBase);
        }

        @Override // com.aliyun.player.IPlayer.OnSubtitleDisplayListener
        public void onSubtitleExtAdded(int i, java.lang.String str) {
            com.aliyun.player.AVPBase aVPBase = this.avpBaseWR.get();
            if (aVPBase != null) {
                aVPBase.onSubtitleExtAdded(i, str);
            }
        }

        @Override // com.aliyun.player.IPlayer.OnSubtitleDisplayListener
        public void onSubtitleHeader(int i, java.lang.String str) {
            com.aliyun.player.AVPBase aVPBase = this.avpBaseWR.get();
            if (aVPBase != null) {
                aVPBase.onSubtitleHeader(i, str);
            }
        }

        @Override // com.aliyun.player.IPlayer.OnSubtitleDisplayListener
        public void onSubtitleHide(int i, long j) {
            com.aliyun.player.AVPBase aVPBase = this.avpBaseWR.get();
            if (aVPBase != null) {
                aVPBase.onSubtitleHide(i, j);
            }
        }

        @Override // com.aliyun.player.IPlayer.OnSubtitleDisplayListener
        public void onSubtitleShow(int i, long j, java.lang.String str) {
            com.aliyun.player.AVPBase aVPBase = this.avpBaseWR.get();
            if (aVPBase != null) {
                aVPBase.onSubtitleShow(i, j, str);
            }
        }
    }

    public static class InnerTrackChangedListener implements com.aliyun.player.IPlayer.OnTrackChangedListener {
        private java.lang.ref.WeakReference<com.aliyun.player.AVPBase> avpBaseWR;

        public InnerTrackChangedListener(com.aliyun.player.AVPBase aVPBase) {
            this.avpBaseWR = new java.lang.ref.WeakReference<>(aVPBase);
        }

        @Override // com.aliyun.player.IPlayer.OnTrackChangedListener
        public void onChangedFail(com.aliyun.player.nativeclass.TrackInfo trackInfo, com.aliyun.player.bean.ErrorInfo errorInfo) {
            com.aliyun.player.AVPBase aVPBase = this.avpBaseWR.get();
            if (aVPBase != null) {
                aVPBase.onChangedFail(trackInfo, errorInfo);
            }
        }

        @Override // com.aliyun.player.IPlayer.OnTrackChangedListener
        public void onChangedSuccess(com.aliyun.player.nativeclass.TrackInfo trackInfo) {
            com.aliyun.player.AVPBase aVPBase = this.avpBaseWR.get();
            if (aVPBase != null) {
                aVPBase.onChangedSuccess(trackInfo);
            }
        }
    }

    public static class InnerTrackReadyListener implements com.aliyun.player.IPlayer.OnTrackReadyListener {
        private java.lang.ref.WeakReference<com.aliyun.player.AVPBase> avpBaseWR;

        public InnerTrackReadyListener(com.aliyun.player.AVPBase aVPBase) {
            this.avpBaseWR = new java.lang.ref.WeakReference<>(aVPBase);
        }

        @Override // com.aliyun.player.IPlayer.OnTrackReadyListener
        public void onTrackReady(com.aliyun.player.nativeclass.MediaInfo mediaInfo) {
            com.aliyun.player.AVPBase aVPBase = this.avpBaseWR.get();
            if (aVPBase != null) {
                aVPBase.onTrackReady(mediaInfo);
            }
        }
    }

    public static class InnerVideoRenderedListener implements com.aliyun.player.IPlayer.OnVideoRenderedListener {
        private java.lang.ref.WeakReference<com.aliyun.player.AVPBase> avpBaseWR;

        public InnerVideoRenderedListener(com.aliyun.player.AVPBase aVPBase) {
            this.avpBaseWR = new java.lang.ref.WeakReference<>(aVPBase);
        }

        @Override // com.aliyun.player.IPlayer.OnVideoRenderedListener
        public void onVideoRendered(long j, long j2) {
            com.aliyun.player.AVPBase aVPBase = this.avpBaseWR.get();
            if (aVPBase != null) {
                aVPBase.onVideoRendered(j, j2);
            }
        }
    }

    public static class InnerVideoSizeChangedListener implements com.aliyun.player.IPlayer.OnVideoSizeChangedListener {
        private java.lang.ref.WeakReference<com.aliyun.player.AVPBase> avpBaseWR;

        public InnerVideoSizeChangedListener(com.aliyun.player.AVPBase aVPBase) {
            this.avpBaseWR = new java.lang.ref.WeakReference<>(aVPBase);
        }

        @Override // com.aliyun.player.IPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(int i, int i2) {
            com.aliyun.player.AVPBase aVPBase = this.avpBaseWR.get();
            if (aVPBase != null) {
                aVPBase.onVideoSizeChanged(i, i2);
            }
        }
    }

    public AVPBase(android.content.Context context, java.lang.String str) {
        this.mContext = null;
        this.mTraceID = null;
        this.mCorePlayer = null;
        this.mContext = context;
        this.mTraceID = str;
        com.aliyun.player.nativeclass.NativePlayerBase createAlivcMediaPlayer = createAlivcMediaPlayer(context);
        this.mCorePlayer = createAlivcMediaPlayer;
        createAlivcMediaPlayer.setTraceId(this.mTraceID);
        bindListeners();
    }

    private void bindListeners() {
        this.mCorePlayer.setOnErrorListener(this.mInnerOnErrorListener);
        this.mCorePlayer.setOnPreparedListener(this.mInnerOnPreparedListener);
        this.mCorePlayer.setOnInfoListener(this.mInnerOnInfoListener);
        this.mCorePlayer.setOnCompletionListener(this.mInnerOnCompletionListener);
        this.mCorePlayer.setOnRenderingStartListener(this.mInnerOnFirstFrameShowListener);
        this.mCorePlayer.setOnLoadingStatusListener(this.mInnerOnLoadingStatusListener);
        this.mCorePlayer.setOnAVNotSyncStatusListener(this.mInnerOnAVNotSyncStatusListener);
        this.mCorePlayer.setOnSeekCompleteListener(this.mInnerOnSeekEndListener);
        this.mCorePlayer.setOnStateChangedListener(this.mInnerOnStatusChangedListener);
        this.mCorePlayer.setOnSubtitleDisplayListener(this.mInnerOnSubtitleDisplayListener);
        this.mCorePlayer.setOnVideoSizeChangedListener(this.mInnerOnVideoSizeChangedListener);
        this.mCorePlayer.setOnChooseTrackIndexListener(this.mInnerOnChooseTrackIndexListener);
        this.mCorePlayer.setOnTrackInfoGetListener(this.mInnerOnTrackReadyListener);
        this.mCorePlayer.setOnStreamSwitchedListener(this.mInnerOnStreamSwitchedListener);
        this.mCorePlayer.setOnSubTrackInfoGetListener(this.mInnerOnSubTrackReadyListener);
        this.mCorePlayer.setOnTrackSelectRetListener(this.mInnerOnTrackChangedListener);
        this.mCorePlayer.setOnSeiDataListener(this.mInnerOnSeiDataListener);
        this.mCorePlayer.setOnSnapShotListener(this.mInnerOnSnapShotListener);
        this.mCorePlayer.setOnReportEventListener(this.mInnerOnReportEventListener);
    }

    private void clearListeners() {
        this.mOutOnCompletionListener = null;
        this.mOutOnErrorListener = null;
        this.mOutOnLoadingStatusListener = null;
        this.mOutOnInfoListener = null;
        this.mOutOnAVNotSyncStatusListener = null;
        this.mOutOnPreparedListener = null;
        this.mOutOnRenderingStartListener = null;
        this.mOutOnSeekEndListener = null;
        this.mOutOnStatusChangedListener = null;
        this.mOutOnSubtitleDisplayListener = null;
        this.mOutOnTrackChangedListener = null;
        this.mOutOnTrackReadyListener = null;
        this.mOutOnSubTrackReadyListener = null;
        this.mOutOnVideoSizeChangedListener = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAVNotSyncEnd() {
        com.aliyun.player.IPlayer.OnAVNotSyncStatusListener onAVNotSyncStatusListener = this.mOutOnAVNotSyncStatusListener;
        if (onAVNotSyncStatusListener != null) {
            onAVNotSyncStatusListener.onAVNotSyncEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onAVNotSyncStart(int i) {
        com.aliyun.player.IPlayer.OnAVNotSyncStatusListener onAVNotSyncStatusListener = this.mOutOnAVNotSyncStatusListener;
        if (onAVNotSyncStatusListener != null) {
            onAVNotSyncStatusListener.onAVNotSyncStart(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onChangedFail(com.aliyun.player.nativeclass.TrackInfo trackInfo, com.aliyun.player.bean.ErrorInfo errorInfo) {
        com.aliyun.player.IPlayer.OnTrackChangedListener onTrackChangedListener = this.mOutOnTrackChangedListener;
        if (onTrackChangedListener != null) {
            onTrackChangedListener.onChangedFail(trackInfo, errorInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onChangedSuccess(com.aliyun.player.nativeclass.TrackInfo trackInfo) {
        com.aliyun.player.IPlayer.OnTrackChangedListener onTrackChangedListener = this.mOutOnTrackChangedListener;
        if (onTrackChangedListener != null) {
            onTrackChangedListener.onChangedSuccess(trackInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int onChooseTrackIndex(com.aliyun.player.nativeclass.TrackInfo[] trackInfoArr) {
        com.aliyun.player.IPlayer.OnChooseTrackIndexListener onChooseTrackIndexListener = this.mOutOnChooseTrackIndexListener;
        if (onChooseTrackIndexListener != null) {
            return onChooseTrackIndexListener.onChooseTrackIndex(trackInfoArr);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCompletion() {
        com.aliyun.player.IPlayer.OnCompletionListener onCompletionListener = this.mOutOnCompletionListener;
        if (onCompletionListener != null) {
            onCompletionListener.onCompletion();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(com.aliyun.player.bean.ErrorInfo errorInfo) {
        com.aliyun.player.IPlayer.OnErrorListener onErrorListener = this.mOutOnErrorListener;
        if (onErrorListener != null) {
            onErrorListener.onError(errorInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onEventParam(java.util.Map<java.lang.String, java.lang.String> map) {
        com.aliyun.player.IPlayer.OnReportEventListener onReportEventListener = this.mOutEventListener;
        if (onReportEventListener != null) {
            onReportEventListener.onEventParam(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onInfo(com.aliyun.player.bean.InfoBean infoBean) {
        com.aliyun.player.IPlayer.OnInfoListener onInfoListener = this.mOutOnInfoListener;
        if (onInfoListener != null) {
            onInfoListener.onInfo(infoBean);
        }
        if (com.aliyun.player.bean.InfoCode.DemuxerTraceID == infoBean.getCode()) {
            this.mCorePlayer.setTraceId(infoBean.getExtraMsg());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoadingBegin() {
        com.aliyun.player.IPlayer.OnLoadingStatusListener onLoadingStatusListener = this.mOutOnLoadingStatusListener;
        if (onLoadingStatusListener != null) {
            onLoadingStatusListener.onLoadingBegin();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoadingEnd() {
        com.aliyun.player.IPlayer.OnLoadingStatusListener onLoadingStatusListener = this.mOutOnLoadingStatusListener;
        if (onLoadingStatusListener != null) {
            onLoadingStatusListener.onLoadingEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLoadingProgress(int i, float f) {
        com.aliyun.player.IPlayer.OnLoadingStatusListener onLoadingStatusListener = this.mOutOnLoadingStatusListener;
        if (onLoadingStatusListener != null) {
            onLoadingStatusListener.onLoadingProgress(i, f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onPrepared() {
        com.aliyun.player.IPlayer.OnPreparedListener onPreparedListener = this.mOutOnPreparedListener;
        if (onPreparedListener != null) {
            onPreparedListener.onPrepared();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSeekComplete() {
        com.aliyun.player.IPlayer.OnSeekCompleteListener onSeekCompleteListener = this.mOutOnSeekEndListener;
        if (onSeekCompleteListener != null) {
            onSeekCompleteListener.onSeekComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSeiData(int i, byte[] bArr, byte[] bArr2) {
        com.aliyun.player.IPlayer.OnSeiDataListener onSeiDataListener = this.mOutOnSeiDataListener;
        if (onSeiDataListener != null) {
            onSeiDataListener.onSeiData(i, bArr, bArr2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSnapShot(android.graphics.Bitmap bitmap, int i, int i2) {
        com.aliyun.player.IPlayer.OnSnapShotListener onSnapShotListener = this.mOutOnSnapShotListener;
        if (onSnapShotListener != null) {
            onSnapShotListener.onSnapShot(bitmap, i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onStateChanged(int i) {
        com.aliyun.player.IPlayer.OnStateChangedListener onStateChangedListener = this.mOutOnStatusChangedListener;
        if (onStateChangedListener != null) {
            onStateChangedListener.onStateChanged(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSubTrackReady(com.aliyun.player.nativeclass.MediaInfo mediaInfo) {
        this.mOutSubMediaInfo = mediaInfo;
        com.aliyun.player.IPlayer.OnSubTrackReadyListener onSubTrackReadyListener = this.mOutOnSubTrackReadyListener;
        if (onSubTrackReadyListener != null) {
            onSubTrackReadyListener.onSubTrackReady(mediaInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSubtitleExtAdded(int i, java.lang.String str) {
        com.aliyun.player.IPlayer.OnSubtitleDisplayListener onSubtitleDisplayListener = this.mOutOnSubtitleDisplayListener;
        if (onSubtitleDisplayListener != null) {
            onSubtitleDisplayListener.onSubtitleExtAdded(i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSubtitleHeader(int i, java.lang.String str) {
        com.aliyun.player.IPlayer.OnSubtitleDisplayListener onSubtitleDisplayListener = this.mOutOnSubtitleDisplayListener;
        if (onSubtitleDisplayListener != null) {
            onSubtitleDisplayListener.onSubtitleHeader(i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSubtitleHide(int i, long j) {
        com.aliyun.player.IPlayer.OnSubtitleDisplayListener onSubtitleDisplayListener = this.mOutOnSubtitleDisplayListener;
        if (onSubtitleDisplayListener != null) {
            onSubtitleDisplayListener.onSubtitleHide(i, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSubtitleShow(int i, long j, java.lang.String str) {
        com.aliyun.player.IPlayer.OnSubtitleDisplayListener onSubtitleDisplayListener = this.mOutOnSubtitleDisplayListener;
        if (onSubtitleDisplayListener != null) {
            onSubtitleDisplayListener.onSubtitleShow(i, j, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSwitchedFail(java.lang.String str, com.aliyun.player.bean.ErrorInfo errorInfo) {
        com.aliyun.player.IPlayer.OnStreamSwitchedListener onStreamSwitchedListener = this.mOutOnStreamSwitchedListener;
        if (onStreamSwitchedListener != null) {
            onStreamSwitchedListener.onSwitchedFail(str, errorInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onSwitchedSuccess(java.lang.String str) {
        com.aliyun.player.IPlayer.OnStreamSwitchedListener onStreamSwitchedListener = this.mOutOnStreamSwitchedListener;
        if (onStreamSwitchedListener != null) {
            onStreamSwitchedListener.onSwitchedSuccess(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTrackReady(com.aliyun.player.nativeclass.MediaInfo mediaInfo) {
        this.mOutMediaInfo = mediaInfo;
        com.aliyun.player.IPlayer.OnTrackReadyListener onTrackReadyListener = this.mOutOnTrackReadyListener;
        if (onTrackReadyListener != null) {
            onTrackReadyListener.onTrackReady(mediaInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onVideoRendered(long j, long j2) {
        com.aliyun.player.IPlayer.OnVideoRenderedListener onVideoRenderedListener = this.mOutOnVideoRenderedListener;
        if (onVideoRenderedListener != null) {
            onVideoRenderedListener.onVideoRendered(j, j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onVideoRenderingStart() {
        com.aliyun.player.IPlayer.OnRenderingStartListener onRenderingStartListener = this.mOutOnRenderingStartListener;
        if (onRenderingStartListener != null) {
            onRenderingStartListener.onRenderingStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onVideoSizeChanged(int i, int i2) {
        com.aliyun.player.IPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener = this.mOutOnVideoSizeChangedListener;
        if (onVideoSizeChangedListener != null) {
            onVideoSizeChangedListener.onVideoSizeChanged(i, i2);
        }
    }

    private void pauseInner() {
        this.mCorePlayer.pause();
    }

    private void startInner() {
        this.mCorePlayer.start();
    }

    @Override // com.aliyun.player.IPlayer
    public void addExtSubtitle(java.lang.String str) {
        this.mCorePlayer.addExtSubtitle(str);
    }

    @Override // com.aliyun.player.IPlayer
    public void clearScreen() {
        this.mCorePlayer.clearScreen();
    }

    public abstract com.aliyun.player.nativeclass.NativePlayerBase createAlivcMediaPlayer(android.content.Context context);

    @Override // com.aliyun.player.IPlayer
    @java.lang.Deprecated
    public com.aliyun.player.nativeclass.TrackInfo currentTrack(int i) {
        return this.mCorePlayer.getCurrentTrackInfo(i);
    }

    @Override // com.aliyun.player.IPlayer
    public com.aliyun.player.nativeclass.TrackInfo currentTrack(com.aliyun.player.nativeclass.TrackInfo.Type type) {
        return this.mCorePlayer.getCurrentTrackInfo(type.ordinal());
    }

    @Override // com.aliyun.player.IPlayer
    public void enableHardwareDecoder(boolean z) {
        this.mCorePlayer.enableHardwareDecoder(z);
    }

    @Override // com.aliyun.player.IPlayer
    public com.aliyun.player.IPlayer.AlphaRenderMode getAlphaRenderMode() {
        return this.mCorePlayer.getAlphaRenderMode();
    }

    @Override // com.aliyun.player.IPlayer
    public long getBufferedPosition() {
        return this.mCorePlayer.getBufferedPosition();
    }

    @Override // com.aliyun.player.IPlayer
    public java.lang.String getCacheFilePath(java.lang.String str) {
        return this.mCorePlayer.getCacheFilePath(str);
    }

    @Override // com.aliyun.player.IPlayer
    public java.lang.String getCacheFilePath(java.lang.String str, java.lang.String str2, java.lang.String str3, int i) {
        return this.mCorePlayer.getCacheFilePath(str, str2, str3, i);
    }

    @Override // com.aliyun.player.IPlayer
    public com.aliyun.player.nativeclass.PlayerConfig getConfig() {
        return this.mCorePlayer.getConfig();
    }

    public com.aliyun.player.nativeclass.NativePlayerBase getCorePlayer() {
        return this.mCorePlayer;
    }

    @Override // com.aliyun.player.IPlayer
    public long getCurrentPosition() {
        return this.mCorePlayer.getCurrentPosition();
    }

    @Override // com.aliyun.player.IPlayer
    public long getDuration() {
        return this.mCorePlayer.getDuration();
    }

    @Override // com.aliyun.player.IPlayer
    public com.aliyun.player.nativeclass.MediaInfo getMediaInfo() {
        return this.mOutMediaInfo;
    }

    @Override // com.aliyun.player.IPlayer
    public com.aliyun.player.IPlayer.MirrorMode getMirrorMode() {
        return this.mCorePlayer.getMirrorMode();
    }

    @Override // com.aliyun.player.IPlayer
    public long getNativeContextAddr() {
        return this.mCorePlayer.getNativeContext();
    }

    @Override // com.aliyun.player.IPlayer
    public java.lang.Object getOption(com.aliyun.player.IPlayer.Option option) {
        return this.mCorePlayer.getOption(option);
    }

    @Override // com.aliyun.player.IPlayer
    public java.lang.String getPlayerName() {
        return this.mCorePlayer.getPlayerName();
    }

    @Override // com.aliyun.player.IPlayer
    public int getPlayerStatus() {
        return this.mCorePlayer.getPlayerStatus();
    }

    @Override // com.aliyun.player.IPlayer
    public java.lang.String getPropertyString(com.aliyun.player.IPlayer.PropertyKey propertyKey) {
        return this.mCorePlayer.getPropertyString(propertyKey.getValue());
    }

    @Override // com.aliyun.player.IPlayer
    public com.aliyun.player.IPlayer.RotateMode getRotateMode() {
        return this.mCorePlayer.getRotateMode();
    }

    @Override // com.aliyun.player.IPlayer
    public com.aliyun.player.IPlayer.ScaleMode getScaleMode() {
        return this.mCorePlayer.getScaleMode();
    }

    @Override // com.aliyun.player.IPlayer
    public float getSpeed() {
        return this.mCorePlayer.getSpeed();
    }

    @Override // com.aliyun.player.IPlayer
    public com.aliyun.player.nativeclass.MediaInfo getSubMediaInfo() {
        return this.mOutSubMediaInfo;
    }

    @Override // com.aliyun.player.IPlayer
    public java.lang.String getUserData() {
        return this.mCorePlayer.getUserData();
    }

    @Override // com.aliyun.player.IPlayer
    public int getVideoHeight() {
        return this.mCorePlayer.getVideoHeight();
    }

    @Override // com.aliyun.player.IPlayer
    public int getVideoRotation() {
        return (int) this.mCorePlayer.getVideoRotation();
    }

    @Override // com.aliyun.player.IPlayer
    public int getVideoWidth() {
        return this.mCorePlayer.getVideoWidth();
    }

    @Override // com.aliyun.player.IPlayer
    public float getVolume() {
        return this.mCorePlayer.getVolume();
    }

    @Override // com.aliyun.player.IPlayer
    public boolean isAutoPlay() {
        return this.mCorePlayer.isAutoPlay();
    }

    @Override // com.aliyun.player.IPlayer
    public boolean isLoop() {
        return this.mCorePlayer.isLoop();
    }

    @Override // com.aliyun.player.IPlayer
    public boolean isMute() {
        return this.mCorePlayer.isMuted();
    }

    @Override // com.aliyun.player.IPlayer
    public void pause() {
        pauseInner();
    }

    @Override // com.aliyun.player.IPlayer
    public void prepare() {
        this.mCorePlayer.prepare();
    }

    @Override // com.aliyun.player.IPlayer
    @java.lang.Deprecated
    public void redraw() {
    }

    @Override // com.aliyun.player.IPlayer
    public void release() {
        this.mCorePlayer.release();
        clearListeners();
    }

    @Override // com.aliyun.player.IPlayer
    public void releaseAsync() {
        com.cicada.player.utils.Logger.i(TAG, "releaseAsync");
        setSurface(null);
        com.aliyun.utils.g.a.execute(new com.aliyun.player.AVPBase.AnonymousClass1());
    }

    @Override // com.aliyun.player.IPlayer
    public void reload() {
        this.mCorePlayer.reload();
    }

    @Override // com.aliyun.player.IPlayer
    public void reset() {
    }

    @Override // com.aliyun.player.IPlayer
    public void seekTo(long j) {
        seekTo(j, com.aliyun.player.IPlayer.SeekMode.Inaccurate);
    }

    @Override // com.aliyun.player.IPlayer
    public void seekTo(long j, com.aliyun.player.IPlayer.SeekMode seekMode) {
        this.mCorePlayer.seekTo(j, seekMode.getValue());
    }

    @Override // com.aliyun.player.IPlayer
    public void selectExtSubtitle(int i, boolean z) {
        this.mCorePlayer.selectExtSubtitle(i, z);
    }

    @Override // com.aliyun.player.IPlayer
    public void selectTrack(int i) {
        this.mCorePlayer.selectTrack(i);
    }

    @Override // com.aliyun.player.IPlayer
    public void selectTrack(int i, boolean z) {
        this.mCorePlayer.selectTrack(i, z);
    }

    @Override // com.aliyun.player.IPlayer
    public void sendCustomEvent(java.lang.String str) {
        this.mCorePlayer.sendCustomEvent(str);
    }

    @Override // com.aliyun.player.IPlayer
    public void setAlphaRenderMode(com.aliyun.player.IPlayer.AlphaRenderMode alphaRenderMode) {
        this.mCorePlayer.setAlphaRenderMode(alphaRenderMode);
    }

    @Override // com.aliyun.player.IPlayer
    public void setAutoPlay(boolean z) {
        this.mCorePlayer.setAutoPlay(z);
    }

    @Override // com.aliyun.player.IPlayer
    public void setCacheConfig(com.aliyun.player.nativeclass.CacheConfig cacheConfig) {
        if (cacheConfig == null) {
            cacheConfig = new com.aliyun.player.nativeclass.CacheConfig();
            cacheConfig.mEnable = false;
        }
        this.mCorePlayer.setCacheConfig(cacheConfig);
    }

    @Override // com.aliyun.player.IPlayer
    public void setConfig(com.aliyun.player.nativeclass.PlayerConfig playerConfig) {
        this.mCorePlayer.setConfig(playerConfig);
    }

    @Override // com.aliyun.player.IPlayer
    public void setDefaultBandWidth(int i) {
        this.mCorePlayer.setDefaultBandWidth(i);
    }

    @Override // com.aliyun.player.IPlayer
    public void setDisplay(android.view.SurfaceHolder surfaceHolder) {
        setSurface(surfaceHolder == null ? null : surfaceHolder.getSurface());
    }

    @Override // com.aliyun.player.IPlayer
    public void setDisplayView(com.aliyun.player.videoview.AliDisplayView aliDisplayView) {
        this.mCorePlayer.setDisplayView(aliDisplayView);
    }

    @Override // com.aliyun.player.IPlayer
    public void setDrmCallback(com.cicada.player.utils.media.DrmCallback drmCallback) {
        this.mCorePlayer.setDrmCallback(drmCallback);
    }

    @Override // com.aliyun.player.IPlayer
    public void setFastStart(boolean z) {
        this.mCorePlayer.setFastStart(z);
    }

    @Override // com.aliyun.player.IPlayer
    public void setFilterConfig(com.aliyun.player.FilterConfig filterConfig) {
        this.mCorePlayer.setFilterConfig(filterConfig);
    }

    @Override // com.aliyun.player.IPlayer
    public void setFilterInvalid(java.lang.String str, boolean z) {
        this.mCorePlayer.setFilterInvalid(str, z);
    }

    @Override // com.aliyun.player.IPlayer
    public void setIPResolveType(com.aliyun.player.IPlayer.IPResolveType iPResolveType) {
        this.mCorePlayer.setIPResolveType(iPResolveType);
    }

    @Override // com.aliyun.player.IPlayer
    public void setLoop(boolean z) {
        this.mCorePlayer.setLoop(z);
    }

    @Override // com.aliyun.player.IPlayer
    public void setMaxAccurateSeekDelta(int i) {
        this.mCorePlayer.setMaxAccurateSeekDelta(i);
    }

    @Override // com.aliyun.player.IPlayer
    public void setMirrorMode(com.aliyun.player.IPlayer.MirrorMode mirrorMode) {
        this.mCorePlayer.setMirrorMode(mirrorMode);
    }

    @Override // com.aliyun.player.IPlayer
    public void setMute(boolean z) {
        this.mCorePlayer.setMute(z);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnAVNotSyncStatusListener(com.aliyun.player.IPlayer.OnAVNotSyncStatusListener onAVNotSyncStatusListener) {
        this.mOutOnAVNotSyncStatusListener = onAVNotSyncStatusListener;
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnChooseTrackIndexListener(com.aliyun.player.IPlayer.OnChooseTrackIndexListener onChooseTrackIndexListener) {
        this.mOutOnChooseTrackIndexListener = onChooseTrackIndexListener;
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnCompletionListener(com.aliyun.player.IPlayer.OnCompletionListener onCompletionListener) {
        this.mOutOnCompletionListener = onCompletionListener;
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnErrorListener(com.aliyun.player.IPlayer.OnErrorListener onErrorListener) {
        this.mOutOnErrorListener = onErrorListener;
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnInfoListener(com.aliyun.player.IPlayer.OnInfoListener onInfoListener) {
        this.mOutOnInfoListener = onInfoListener;
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnLoadingStatusListener(com.aliyun.player.IPlayer.OnLoadingStatusListener onLoadingStatusListener) {
        this.mOutOnLoadingStatusListener = onLoadingStatusListener;
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnPreRenderFrameCallback(com.aliyun.player.IPlayer.OnPreRenderFrameCallback onPreRenderFrameCallback) {
        this.mCorePlayer.setOnPreRenderFrameCallback(onPreRenderFrameCallback);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnPreparedListener(com.aliyun.player.IPlayer.OnPreparedListener onPreparedListener) {
        this.mOutOnPreparedListener = onPreparedListener;
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnRenderFrameCallback(com.aliyun.player.IPlayer.OnRenderFrameCallback onRenderFrameCallback) {
        this.mCorePlayer.setOnRenderFrameCallback(onRenderFrameCallback);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnRenderingStartListener(com.aliyun.player.IPlayer.OnRenderingStartListener onRenderingStartListener) {
        this.mOutOnRenderingStartListener = onRenderingStartListener;
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnReportEventListener(com.aliyun.player.IPlayer.OnReportEventListener onReportEventListener) {
        this.mOutEventListener = onReportEventListener;
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnSeekCompleteListener(com.aliyun.player.IPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.mOutOnSeekEndListener = onSeekCompleteListener;
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnSeiDataListener(com.aliyun.player.IPlayer.OnSeiDataListener onSeiDataListener) {
        this.mOutOnSeiDataListener = onSeiDataListener;
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnSnapShotListener(com.aliyun.player.IPlayer.OnSnapShotListener onSnapShotListener) {
        this.mOutOnSnapShotListener = onSnapShotListener;
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnStateChangedListener(com.aliyun.player.IPlayer.OnStateChangedListener onStateChangedListener) {
        this.mOutOnStatusChangedListener = onStateChangedListener;
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnStreamSwitchedListener(com.aliyun.player.IPlayer.OnStreamSwitchedListener onStreamSwitchedListener) {
        this.mOutOnStreamSwitchedListener = onStreamSwitchedListener;
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnSubTrackReadyListener(com.aliyun.player.IPlayer.OnSubTrackReadyListener onSubTrackReadyListener) {
        this.mOutOnSubTrackReadyListener = onSubTrackReadyListener;
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnSubtitleDisplayListener(com.aliyun.player.IPlayer.OnSubtitleDisplayListener onSubtitleDisplayListener) {
        this.mOutOnSubtitleDisplayListener = onSubtitleDisplayListener;
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnTrackChangedListener(com.aliyun.player.IPlayer.OnTrackChangedListener onTrackChangedListener) {
        this.mOutOnTrackChangedListener = onTrackChangedListener;
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnTrackReadyListener(com.aliyun.player.IPlayer.OnTrackReadyListener onTrackReadyListener) {
        this.mOutOnTrackReadyListener = onTrackReadyListener;
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnVideoRenderedListener(com.aliyun.player.IPlayer.OnVideoRenderedListener onVideoRenderedListener) {
        com.aliyun.player.nativeclass.NativePlayerBase nativePlayerBase;
        com.aliyun.player.IPlayer.OnVideoRenderedListener onVideoRenderedListener2;
        this.mOutOnVideoRenderedListener = onVideoRenderedListener;
        if (onVideoRenderedListener != null) {
            nativePlayerBase = this.mCorePlayer;
            onVideoRenderedListener2 = this.mInnerOnVideoRenderedListener;
        } else {
            nativePlayerBase = this.mCorePlayer;
            onVideoRenderedListener2 = null;
        }
        nativePlayerBase.setOnVideoRenderedListener(onVideoRenderedListener2);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOnVideoSizeChangedListener(com.aliyun.player.IPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mOutOnVideoSizeChangedListener = onVideoSizeChangedListener;
    }

    @Override // com.aliyun.player.IPlayer
    public void setOption(int i, int i2) {
        this.mCorePlayer.setOption("player_option_" + java.lang.String.valueOf(i) + "_int", java.lang.String.valueOf(i2));
    }

    @Override // com.aliyun.player.IPlayer
    public void setOption(int i, java.lang.String str) {
        this.mCorePlayer.setOption("player_option_" + java.lang.String.valueOf(i) + "_str", str);
    }

    @Override // com.aliyun.player.IPlayer
    public void setOutputAudioChannel(com.aliyun.player.IPlayer.OutputAudioChannel outputAudioChannel) {
        this.mCorePlayer.setOutputAudioChannel(outputAudioChannel.getValue());
    }

    @Override // com.aliyun.player.IPlayer
    public void setPreferPlayerName(java.lang.String str) {
        this.mCorePlayer.setPreferPlayerName(str);
    }

    @Override // com.aliyun.player.IPlayer
    public void setRenderFrameCallbackConfig(com.aliyun.player.IPlayer.RenderFrameCallbackConfig renderFrameCallbackConfig) {
        this.mCorePlayer.setRenderFrameCallbackConfig(renderFrameCallbackConfig);
    }

    @Override // com.aliyun.player.IPlayer
    public void setRotateMode(com.aliyun.player.IPlayer.RotateMode rotateMode) {
        this.mCorePlayer.setRotateMode(rotateMode);
    }

    @Override // com.aliyun.player.IPlayer
    public void setScaleMode(com.aliyun.player.IPlayer.ScaleMode scaleMode) {
        this.mCorePlayer.setScaleMode(scaleMode);
    }

    @Override // com.aliyun.player.IPlayer
    public void setSpeed(float f) {
        this.mCorePlayer.setSpeed(f);
    }

    @Override // com.aliyun.player.IPlayer
    public void setStartTime(long j, com.aliyun.player.IPlayer.SeekMode seekMode) {
        this.mCorePlayer.setStartTime(j, seekMode.getValue());
    }

    @Override // com.aliyun.player.IPlayer
    public void setStreamDelayTime(int i, int i2) {
        this.mCorePlayer.setStreamDelayTime(i, i2);
    }

    @Override // com.aliyun.player.IPlayer
    public void setSurface(android.view.Surface surface) {
        this.mCorePlayer.setSurface(surface);
    }

    @Override // com.aliyun.player.IPlayer
    public void setTraceId(java.lang.String str) {
        this.mTraceID = str;
        this.mCorePlayer.setTraceId(str);
    }

    @Override // com.aliyun.player.IPlayer
    public void setUserData(java.lang.String str) {
        this.mCorePlayer.setUserData(str);
    }

    @Override // com.aliyun.player.IPlayer
    public void setVideoBackgroundColor(int i) {
        this.mCorePlayer.setVideoBackgroundColor(i);
    }

    @Override // com.aliyun.player.IPlayer
    public void setVideoTag(int[] iArr) {
        this.mCorePlayer.setVideoTag(iArr);
    }

    @Override // com.aliyun.player.IPlayer
    public void setVolume(float f) {
        this.mCorePlayer.setVolume(f);
    }

    @Override // com.aliyun.player.IPlayer
    public void snapshot() {
        this.mCorePlayer.snapShot();
    }

    @Override // com.aliyun.player.IPlayer
    public void start() {
        startInner();
    }

    @Override // com.aliyun.player.IPlayer
    public void stop() {
        stopInner();
    }

    public void stopInner() {
        this.mCorePlayer.stop();
    }

    @Override // com.aliyun.player.IPlayer
    public void surfaceChanged() {
        this.mCorePlayer.surfaceChanged();
    }

    @Override // com.aliyun.player.IPlayer
    public void switchStream(java.lang.String str) {
        this.mCorePlayer.switchStream(str);
    }

    @Override // com.aliyun.player.IPlayer
    public void updateFilterConfig(java.lang.String str, com.aliyun.player.FilterConfig.FilterOptions filterOptions) {
        this.mCorePlayer.updateFilterConfig(str, filterOptions);
    }
}
