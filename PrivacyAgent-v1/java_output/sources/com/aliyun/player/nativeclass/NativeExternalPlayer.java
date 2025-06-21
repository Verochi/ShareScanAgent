package com.aliyun.player.nativeclass;

@com.cicada.player.utils.NativeUsed
/* loaded from: classes.dex */
public class NativeExternalPlayer {
    private static android.content.Context sContext;
    private com.aliyun.player.ApasaraExternalPlayer mExternPlayer = null;
    private long mNativeInstance = 0;

    /* renamed from: com.aliyun.player.nativeclass.NativeExternalPlayer$1, reason: invalid class name */
    public class AnonymousClass1 implements com.aliyun.player.ApasaraExternalPlayer.OnPreparedListener {
        public AnonymousClass1() {
        }

        @Override // com.aliyun.player.ApasaraExternalPlayer.OnPreparedListener
        public void onPrepared() {
            com.aliyun.player.nativeclass.NativeExternalPlayer nativeExternalPlayer = com.aliyun.player.nativeclass.NativeExternalPlayer.this;
            nativeExternalPlayer.nativeOnPrepared(nativeExternalPlayer.mNativeInstance);
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativeExternalPlayer$10, reason: invalid class name */
    public class AnonymousClass10 implements com.aliyun.player.ApasaraExternalPlayer.OnVideoSizeChangedListener {
        public AnonymousClass10() {
        }

        @Override // com.aliyun.player.ApasaraExternalPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(int i, int i2) {
            com.aliyun.player.nativeclass.NativeExternalPlayer nativeExternalPlayer = com.aliyun.player.nativeclass.NativeExternalPlayer.this;
            nativeExternalPlayer.nativeOnVideoSizeChanged(nativeExternalPlayer.mNativeInstance, i, i2);
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativeExternalPlayer$11, reason: invalid class name */
    public class AnonymousClass11 implements com.aliyun.player.ApasaraExternalPlayer.OnStatusChangedListener {
        public AnonymousClass11() {
        }

        @Override // com.aliyun.player.ApasaraExternalPlayer.OnStatusChangedListener
        public void onStatusChanged(int i, int i2) {
            com.aliyun.player.nativeclass.NativeExternalPlayer nativeExternalPlayer = com.aliyun.player.nativeclass.NativeExternalPlayer.this;
            nativeExternalPlayer.nativeOnStatusChanged(nativeExternalPlayer.mNativeInstance, i, i2);
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativeExternalPlayer$12, reason: invalid class name */
    public class AnonymousClass12 implements com.aliyun.player.ApasaraExternalPlayer.OnVideoRenderedListener {
        public AnonymousClass12() {
        }

        @Override // com.aliyun.player.ApasaraExternalPlayer.OnVideoRenderedListener
        public void onVideoRendered(long j, long j2) {
            com.aliyun.player.nativeclass.NativeExternalPlayer nativeExternalPlayer = com.aliyun.player.nativeclass.NativeExternalPlayer.this;
            nativeExternalPlayer.nativeOnVideoRendered(nativeExternalPlayer.mNativeInstance, j, j2);
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativeExternalPlayer$13, reason: invalid class name */
    public class AnonymousClass13 implements com.aliyun.player.ApasaraExternalPlayer.OnErrorListener {
        public AnonymousClass13() {
        }

        @Override // com.aliyun.player.ApasaraExternalPlayer.OnErrorListener
        public void onError(int i, java.lang.String str) {
            com.aliyun.player.nativeclass.NativeExternalPlayer nativeExternalPlayer = com.aliyun.player.nativeclass.NativeExternalPlayer.this;
            nativeExternalPlayer.nativeOnErrorCallback(nativeExternalPlayer.mNativeInstance, i, str);
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativeExternalPlayer$14, reason: invalid class name */
    public class AnonymousClass14 implements com.aliyun.player.ApasaraExternalPlayer.OnEventListener {
        public AnonymousClass14() {
        }

        @Override // com.aliyun.player.ApasaraExternalPlayer.OnEventListener
        public void onEvent(int i, java.lang.String str) {
            com.aliyun.player.nativeclass.NativeExternalPlayer nativeExternalPlayer = com.aliyun.player.nativeclass.NativeExternalPlayer.this;
            nativeExternalPlayer.nativeOnEventCallback(nativeExternalPlayer.mNativeInstance, i, str);
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativeExternalPlayer$15, reason: invalid class name */
    public class AnonymousClass15 implements com.aliyun.player.ApasaraExternalPlayer.OnStreamInfoGetListener {
        public AnonymousClass15() {
        }

        @Override // com.aliyun.player.ApasaraExternalPlayer.OnStreamInfoGetListener
        public void OnStreamInfoGet(com.aliyun.player.nativeclass.MediaInfo mediaInfo) {
            com.aliyun.player.nativeclass.NativeExternalPlayer nativeExternalPlayer = com.aliyun.player.nativeclass.NativeExternalPlayer.this;
            nativeExternalPlayer.nativeOnStreamInfoGet(nativeExternalPlayer.mNativeInstance, mediaInfo);
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativeExternalPlayer$16, reason: invalid class name */
    public class AnonymousClass16 implements com.aliyun.player.ApasaraExternalPlayer.OnStreamSwitchSucListener {
        public AnonymousClass16() {
        }

        @Override // com.aliyun.player.ApasaraExternalPlayer.OnStreamSwitchSucListener
        public void onStreamSwitchSuc(com.aliyun.player.ApasaraExternalPlayer.StreamType streamType, com.aliyun.player.nativeclass.TrackInfo trackInfo) {
            com.aliyun.player.nativeclass.NativeExternalPlayer nativeExternalPlayer = com.aliyun.player.nativeclass.NativeExternalPlayer.this;
            nativeExternalPlayer.nativeOnStreamSwitchSuc(nativeExternalPlayer.mNativeInstance, streamType.ordinal(), trackInfo);
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativeExternalPlayer$17, reason: invalid class name */
    public class AnonymousClass17 implements com.aliyun.player.ApasaraExternalPlayer.OnCaptureScreenListener {
        public AnonymousClass17() {
        }

        @Override // com.aliyun.player.ApasaraExternalPlayer.OnCaptureScreenListener
        public void onCaptureScreen(int i, int i2, byte[] bArr) {
            com.aliyun.player.nativeclass.NativeExternalPlayer nativeExternalPlayer = com.aliyun.player.nativeclass.NativeExternalPlayer.this;
            nativeExternalPlayer.nativeOnCaptureScreen(nativeExternalPlayer.mNativeInstance, i, i2, bArr);
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativeExternalPlayer$18, reason: invalid class name */
    public class AnonymousClass18 implements com.aliyun.player.ApasaraExternalPlayer.OnSubtitleListener {
        public AnonymousClass18() {
        }

        @Override // com.aliyun.player.ApasaraExternalPlayer.OnSubtitleListener
        public void onSubtitleExtAdded(int i, java.lang.String str) {
            com.aliyun.player.nativeclass.NativeExternalPlayer nativeExternalPlayer = com.aliyun.player.nativeclass.NativeExternalPlayer.this;
            nativeExternalPlayer.nativeOnSubtitleExtAdd(nativeExternalPlayer.mNativeInstance, i, str);
        }

        @Override // com.aliyun.player.ApasaraExternalPlayer.OnSubtitleListener
        public void onSubtitleHide(int i, long j) {
            com.aliyun.player.nativeclass.NativeExternalPlayer nativeExternalPlayer = com.aliyun.player.nativeclass.NativeExternalPlayer.this;
            nativeExternalPlayer.nativeOnSubtitleHide(nativeExternalPlayer.mNativeInstance, i, null);
        }

        @Override // com.aliyun.player.ApasaraExternalPlayer.OnSubtitleListener
        public void onSubtitleShow(int i, long j, java.lang.String str) {
            com.aliyun.player.nativeclass.NativeExternalPlayer nativeExternalPlayer = com.aliyun.player.nativeclass.NativeExternalPlayer.this;
            nativeExternalPlayer.nativeOnSubtitleShow(nativeExternalPlayer.mNativeInstance, i, str.getBytes());
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativeExternalPlayer$19, reason: invalid class name */
    public class AnonymousClass19 implements com.aliyun.player.ApasaraExternalPlayer.OnDRMCallback {
        public AnonymousClass19() {
        }

        @Override // com.aliyun.player.ApasaraExternalPlayer.OnDRMCallback
        public byte[] onRequestKey(java.lang.String str, byte[] bArr) {
            com.aliyun.player.nativeclass.NativeExternalPlayer nativeExternalPlayer = com.aliyun.player.nativeclass.NativeExternalPlayer.this;
            return nativeExternalPlayer.nativeRequestKey(nativeExternalPlayer.mNativeInstance, str, bArr);
        }

        @Override // com.aliyun.player.ApasaraExternalPlayer.OnDRMCallback
        public byte[] onRequestProvision(java.lang.String str, byte[] bArr) {
            com.aliyun.player.nativeclass.NativeExternalPlayer nativeExternalPlayer = com.aliyun.player.nativeclass.NativeExternalPlayer.this;
            return nativeExternalPlayer.nativeRequestProvision(nativeExternalPlayer.mNativeInstance, str, bArr);
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativeExternalPlayer$2, reason: invalid class name */
    public class AnonymousClass2 implements com.aliyun.player.ApasaraExternalPlayer.OnLoopingStartListener {
        public AnonymousClass2() {
        }

        @Override // com.aliyun.player.ApasaraExternalPlayer.OnLoopingStartListener
        public void onLoopingStart() {
            com.aliyun.player.nativeclass.NativeExternalPlayer nativeExternalPlayer = com.aliyun.player.nativeclass.NativeExternalPlayer.this;
            nativeExternalPlayer.nativeOnLoopingStart(nativeExternalPlayer.mNativeInstance);
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativeExternalPlayer$3, reason: invalid class name */
    public class AnonymousClass3 implements com.aliyun.player.ApasaraExternalPlayer.OnCompletionListener {
        public AnonymousClass3() {
        }

        @Override // com.aliyun.player.ApasaraExternalPlayer.OnCompletionListener
        public void onCompletion() {
            com.aliyun.player.nativeclass.NativeExternalPlayer nativeExternalPlayer = com.aliyun.player.nativeclass.NativeExternalPlayer.this;
            nativeExternalPlayer.nativeOnCompletion(nativeExternalPlayer.mNativeInstance);
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativeExternalPlayer$4, reason: invalid class name */
    public class AnonymousClass4 implements com.aliyun.player.ApasaraExternalPlayer.OnFirstFrameRenderListener {
        public AnonymousClass4() {
        }

        @Override // com.aliyun.player.ApasaraExternalPlayer.OnFirstFrameRenderListener
        public void onFirstFrameRender() {
            com.aliyun.player.nativeclass.NativeExternalPlayer nativeExternalPlayer = com.aliyun.player.nativeclass.NativeExternalPlayer.this;
            nativeExternalPlayer.nativeOnFirstFrameShow(nativeExternalPlayer.mNativeInstance);
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativeExternalPlayer$5, reason: invalid class name */
    public class AnonymousClass5 implements com.aliyun.player.ApasaraExternalPlayer.OnLoadStatusListener {
        public AnonymousClass5() {
        }

        @Override // com.aliyun.player.ApasaraExternalPlayer.OnLoadStatusListener
        public void onLoadingEnd() {
            com.aliyun.player.nativeclass.NativeExternalPlayer nativeExternalPlayer = com.aliyun.player.nativeclass.NativeExternalPlayer.this;
            nativeExternalPlayer.nativeOnLoadingEnd(nativeExternalPlayer.mNativeInstance);
        }

        @Override // com.aliyun.player.ApasaraExternalPlayer.OnLoadStatusListener
        public void onLoadingProgress(int i) {
            com.aliyun.player.nativeclass.NativeExternalPlayer nativeExternalPlayer = com.aliyun.player.nativeclass.NativeExternalPlayer.this;
            nativeExternalPlayer.nativeOnLoadingProgress(nativeExternalPlayer.mNativeInstance, i);
        }

        @Override // com.aliyun.player.ApasaraExternalPlayer.OnLoadStatusListener
        public void onLoadingStart() {
            com.aliyun.player.nativeclass.NativeExternalPlayer nativeExternalPlayer = com.aliyun.player.nativeclass.NativeExternalPlayer.this;
            nativeExternalPlayer.nativeOnLoadingStart(nativeExternalPlayer.mNativeInstance);
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativeExternalPlayer$6, reason: invalid class name */
    public class AnonymousClass6 implements com.aliyun.player.ApasaraExternalPlayer.OnAutoPlayStartListener {
        public AnonymousClass6() {
        }

        @Override // com.aliyun.player.ApasaraExternalPlayer.OnAutoPlayStartListener
        public void onAutoPlayStart() {
            com.aliyun.player.nativeclass.NativeExternalPlayer nativeExternalPlayer = com.aliyun.player.nativeclass.NativeExternalPlayer.this;
            nativeExternalPlayer.nativeOnAutoPlayStart(nativeExternalPlayer.mNativeInstance);
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativeExternalPlayer$7, reason: invalid class name */
    public class AnonymousClass7 implements com.aliyun.player.ApasaraExternalPlayer.OnSeekStatusListener {
        public AnonymousClass7() {
        }

        @Override // com.aliyun.player.ApasaraExternalPlayer.OnSeekStatusListener
        public void onSeekEnd(boolean z) {
            com.aliyun.player.nativeclass.NativeExternalPlayer nativeExternalPlayer = com.aliyun.player.nativeclass.NativeExternalPlayer.this;
            nativeExternalPlayer.nativeOnSeekEnd(nativeExternalPlayer.mNativeInstance, z);
        }

        @Override // com.aliyun.player.ApasaraExternalPlayer.OnSeekStatusListener
        public void onSeekStart(boolean z) {
            com.aliyun.player.nativeclass.NativeExternalPlayer nativeExternalPlayer = com.aliyun.player.nativeclass.NativeExternalPlayer.this;
            nativeExternalPlayer.nativeOnSeeking(nativeExternalPlayer.mNativeInstance, z);
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativeExternalPlayer$8, reason: invalid class name */
    public class AnonymousClass8 implements com.aliyun.player.ApasaraExternalPlayer.OnPositionUpdateListener {
        public AnonymousClass8() {
        }

        @Override // com.aliyun.player.ApasaraExternalPlayer.OnPositionUpdateListener
        public void onPositionUpdate(long j) {
            com.aliyun.player.nativeclass.NativeExternalPlayer nativeExternalPlayer = com.aliyun.player.nativeclass.NativeExternalPlayer.this;
            nativeExternalPlayer.nativeOnPositionUpdate(nativeExternalPlayer.mNativeInstance, j);
        }
    }

    /* renamed from: com.aliyun.player.nativeclass.NativeExternalPlayer$9, reason: invalid class name */
    public class AnonymousClass9 implements com.aliyun.player.ApasaraExternalPlayer.OnBufferPositionUpdateListener {
        public AnonymousClass9() {
        }

        @Override // com.aliyun.player.ApasaraExternalPlayer.OnBufferPositionUpdateListener
        public void onBufferPositionUpdate(long j) {
            com.aliyun.player.nativeclass.NativeExternalPlayer nativeExternalPlayer = com.aliyun.player.nativeclass.NativeExternalPlayer.this;
            nativeExternalPlayer.nativeOnBufferPositionUpdate(nativeExternalPlayer.mNativeInstance, j);
        }
    }

    static {
        com.aliyun.utils.f.f();
        sContext = null;
    }

    private int getCurrentStreamIndex(int i) {
        com.aliyun.player.ApasaraExternalPlayer apasaraExternalPlayer = this.mExternPlayer;
        if (apasaraExternalPlayer == null) {
            return -1;
        }
        com.aliyun.player.ApasaraExternalPlayer.StreamType streamType = com.aliyun.player.ApasaraExternalPlayer.StreamType.ST_TYPE_UNKNOWN;
        if (i == 0) {
            streamType = com.aliyun.player.ApasaraExternalPlayer.StreamType.ST_TYPE_VIDEO;
        } else if (i == 1) {
            streamType = com.aliyun.player.ApasaraExternalPlayer.StreamType.ST_TYPE_AUDIO;
        } else if (i == 2) {
            streamType = com.aliyun.player.ApasaraExternalPlayer.StreamType.ST_TYPE_SUB;
        }
        return apasaraExternalPlayer.getCurrentStreamIndex(streamType);
    }

    private java.lang.String getOption(java.lang.String str) {
        com.aliyun.player.ApasaraExternalPlayer apasaraExternalPlayer = this.mExternPlayer;
        if (apasaraExternalPlayer == null) {
            return null;
        }
        return apasaraExternalPlayer.getOption(str);
    }

    private long getPropertyInt(com.aliyun.player.ApasaraExternalPlayer.PropertyKey propertyKey) {
        com.aliyun.player.ApasaraExternalPlayer apasaraExternalPlayer = this.mExternPlayer;
        if (apasaraExternalPlayer == null) {
            return 0L;
        }
        return apasaraExternalPlayer.getPropertyInt(propertyKey);
    }

    private long getPropertyLong(com.aliyun.player.ApasaraExternalPlayer.PropertyKey propertyKey) {
        com.aliyun.player.ApasaraExternalPlayer apasaraExternalPlayer = this.mExternPlayer;
        if (apasaraExternalPlayer == null) {
            return 0L;
        }
        return apasaraExternalPlayer.getPropertyLong(propertyKey);
    }

    private java.lang.String getPropertyString(com.aliyun.player.ApasaraExternalPlayer.PropertyKey propertyKey) {
        com.aliyun.player.ApasaraExternalPlayer apasaraExternalPlayer = this.mExternPlayer;
        if (apasaraExternalPlayer == null) {
            return null;
        }
        return apasaraExternalPlayer.getPropertyString(propertyKey);
    }

    private int invokeComponent(java.lang.String str) {
        com.aliyun.player.ApasaraExternalPlayer apasaraExternalPlayer = this.mExternPlayer;
        if (apasaraExternalPlayer == null) {
            return -1;
        }
        return apasaraExternalPlayer.invokeComponent(str);
    }

    @com.cicada.player.utils.NativeUsed
    public static boolean isSupport(com.aliyun.player.nativeclass.Options options) {
        return com.aliyun.player.ApasaraExternalPlayer.isSupportExternal(options) != null;
    }

    public static void loadClass() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnAutoPlayStart(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnBufferPositionUpdate(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnCaptureScreen(long j, int i, int i2, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnCompletion(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnErrorCallback(long j, long j2, java.lang.String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnEventCallback(long j, long j2, java.lang.String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnFirstFrameShow(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnLoadingEnd(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnLoadingProgress(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnLoadingStart(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnLoopingStart(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnPositionUpdate(long j, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnPrepared(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnSeekEnd(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnSeeking(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnStatusChanged(long j, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnStreamInfoGet(long j, com.aliyun.player.nativeclass.MediaInfo mediaInfo);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnStreamSwitchSuc(long j, int i, com.aliyun.player.nativeclass.TrackInfo trackInfo);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnSubtitleExtAdd(long j, long j2, java.lang.String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnSubtitleHide(long j, long j2, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnSubtitleShow(long j, long j2, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnVideoRendered(long j, long j2, long j3);

    /* JADX INFO: Access modifiers changed from: private */
    public native void nativeOnVideoSizeChanged(long j, int i, int i2);

    /* JADX INFO: Access modifiers changed from: private */
    public native byte[] nativeRequestKey(long j, java.lang.String str, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: private */
    public native byte[] nativeRequestProvision(long j, java.lang.String str, byte[] bArr);

    private int selectExtSubtitle(int i, boolean z) {
        com.aliyun.player.ApasaraExternalPlayer apasaraExternalPlayer = this.mExternPlayer;
        if (apasaraExternalPlayer == null) {
            return -1;
        }
        return apasaraExternalPlayer.selectExtSubtitle(i, z);
    }

    public static void setContext(android.content.Context context) {
        if (sContext != null || context == null) {
            return;
        }
        sContext = context.getApplicationContext();
    }

    private void setDecoderType(int i) {
        com.aliyun.player.ApasaraExternalPlayer apasaraExternalPlayer = this.mExternPlayer;
        if (apasaraExternalPlayer == null) {
            return;
        }
        com.aliyun.player.ApasaraExternalPlayer.DecoderType decoderType = com.aliyun.player.ApasaraExternalPlayer.DecoderType.DT_SOFTWARE;
        if (i == 0 || i == 1) {
            decoderType = com.aliyun.player.ApasaraExternalPlayer.DecoderType.DT_HARDWARE;
        }
        apasaraExternalPlayer.setDecoderType(decoderType);
    }

    private void setMirrorMode(int i) {
        com.aliyun.player.ApasaraExternalPlayer apasaraExternalPlayer = this.mExternPlayer;
        if (apasaraExternalPlayer == null) {
            return;
        }
        com.aliyun.player.IPlayer.MirrorMode mirrorMode = com.aliyun.player.IPlayer.MirrorMode.MIRROR_MODE_NONE;
        if (i != 0) {
            if (i == 1) {
                mirrorMode = com.aliyun.player.IPlayer.MirrorMode.MIRROR_MODE_HORIZONTAL;
            } else if (i == 2) {
                mirrorMode = com.aliyun.player.IPlayer.MirrorMode.MIRROR_MODE_VERTICAL;
            }
        }
        apasaraExternalPlayer.setMirrorMode(mirrorMode);
    }

    private int setOption(java.lang.String str, java.lang.String str2) {
        com.aliyun.player.ApasaraExternalPlayer apasaraExternalPlayer = this.mExternPlayer;
        if (apasaraExternalPlayer == null) {
            return -1;
        }
        return apasaraExternalPlayer.setOption(str, str2);
    }

    private void setRotateMode(int i) {
        com.aliyun.player.ApasaraExternalPlayer apasaraExternalPlayer = this.mExternPlayer;
        if (apasaraExternalPlayer == null) {
            return;
        }
        com.aliyun.player.IPlayer.RotateMode rotateMode = com.aliyun.player.IPlayer.RotateMode.ROTATE_0;
        if (i == 90) {
            rotateMode = com.aliyun.player.IPlayer.RotateMode.ROTATE_90;
        } else if (i == 180) {
            rotateMode = com.aliyun.player.IPlayer.RotateMode.ROTATE_180;
        } else if (i == 270) {
            rotateMode = com.aliyun.player.IPlayer.RotateMode.ROTATE_270;
        }
        apasaraExternalPlayer.setRotateMode(rotateMode);
    }

    private void setScaleMode(int i) {
        com.aliyun.player.ApasaraExternalPlayer apasaraExternalPlayer = this.mExternPlayer;
        if (apasaraExternalPlayer == null) {
            return;
        }
        com.aliyun.player.IPlayer.ScaleMode scaleMode = com.aliyun.player.IPlayer.ScaleMode.SCALE_ASPECT_FIT;
        if (i != 0) {
            if (i == 1) {
                scaleMode = com.aliyun.player.IPlayer.ScaleMode.SCALE_ASPECT_FILL;
            } else if (i == 2) {
                scaleMode = com.aliyun.player.IPlayer.ScaleMode.SCALE_TO_FILL;
            }
        }
        apasaraExternalPlayer.setScaleMode(scaleMode);
    }

    @com.cicada.player.utils.NativeUsed
    public com.aliyun.player.ApasaraExternalPlayer.StreamType SwitchStream(int i) {
        com.aliyun.player.ApasaraExternalPlayer apasaraExternalPlayer = this.mExternPlayer;
        return apasaraExternalPlayer == null ? com.aliyun.player.ApasaraExternalPlayer.StreamType.ST_TYPE_UNKNOWN : apasaraExternalPlayer.switchStream(i);
    }

    public boolean callRbPvD(java.lang.String str, boolean z) {
        return this.mExternPlayer == null ? z : "IsMute".equals(str) ? this.mExternPlayer.isMute() : "isLooping".equals(str) ? this.mExternPlayer.isLooping() : "IsAutoPlay".equals(str) ? this.mExternPlayer.isAutoPlay() : z;
    }

    public float callRfPvD(java.lang.String str, float f) {
        return this.mExternPlayer == null ? f : "GetVideoRenderFps".equals(str) ? this.mExternPlayer.getVideoRenderFps() : "GetVolume".equals(str) ? this.mExternPlayer.getVolume() : "getSpeed".equals(str) ? this.mExternPlayer.getSpeed() : "GetVideoDecodeFps".equals(str) ? this.mExternPlayer.getVideoDecodeFps() : f;
    }

    public int callRiPiD(java.lang.String str, int i, int i2) {
        return this.mExternPlayer == null ? i2 : "GetCurrentStreamIndex".equals(str) ? getCurrentStreamIndex(i) : "SwitchStream".equals(str) ? SwitchStream(i).getValue() : i2;
    }

    public int callRiPvD(java.lang.String str, int i) {
        if (this.mExternPlayer == null) {
            return i;
        }
        if (!"Stop".equals(str)) {
            return "GetScaleMode".equals(str) ? this.mExternPlayer.getScaleMode().getValue() : "GetRotateMode".equals(str) ? this.mExternPlayer.getRotateMode().getValue() : "GetMirrorMode".equals(str) ? this.mExternPlayer.getMirrorMode().getValue() : "GetDecoderType".equals(str) ? this.mExternPlayer.getDecoderType().getValue() : "getVideoWidth".equals(str) ? this.mExternPlayer.getVideoWidth() : "getVideoHeight".equals(str) ? this.mExternPlayer.getVideoHeight() : "GetVideoRotation".equals(str) ? this.mExternPlayer.getVideoRotation() : i;
        }
        this.mExternPlayer.stop();
        return 0;
    }

    public long callRlPvD(java.lang.String str, long j) {
        return this.mExternPlayer == null ? j : "GetDuration".equals(str) ? this.mExternPlayer.getDuration() : "GetPlayingPosition".equals(str) ? this.mExternPlayer.getPlayingPosition() : "GetBufferPosition".equals(str) ? this.mExternPlayer.getBufferPosition() : "GetMasterClockPts".equals(str) ? this.mExternPlayer.getMasterClockPts() : j;
    }

    public java.lang.Object callRoPi(java.lang.String str, int i) {
        if (this.mExternPlayer == null) {
            return null;
        }
        if ("GetCurrentStreamInfo".equals(str)) {
            return getCurrentStreamInfo(i);
        }
        if ("getName".equals(str)) {
            return getName();
        }
        return null;
    }

    public void callRvPf(java.lang.String str, float f) {
        if (this.mExternPlayer == null) {
            return;
        }
        if ("SetVolume".equals(str)) {
            this.mExternPlayer.setVolume(f);
        }
        if ("setSpeed".equals(str)) {
            this.mExternPlayer.setSpeed(f);
        }
    }

    public void callRvPi(java.lang.String str, int i) {
        if (this.mExternPlayer == null) {
            return;
        }
        if ("SetVolume".equals(str)) {
            this.mExternPlayer.setVolume(i);
            return;
        }
        if ("SetScaleMode".equals(str)) {
            setScaleMode(i);
            return;
        }
        if ("SetRotateMode".equals(str)) {
            setRotateMode(i);
            return;
        }
        if ("SetMirrorMode".equals(str)) {
            setMirrorMode(i);
            return;
        }
        if ("SetTimeout".equals(str)) {
            this.mExternPlayer.setTimeout(i);
        } else if ("SetDropBufferThreshold".equals(str)) {
            this.mExternPlayer.setDropBufferThreshold(i);
        } else if ("SetDecoderType".equals(str)) {
            setDecoderType(i);
        }
    }

    public void callRvPlb(java.lang.String str, long j, boolean z) {
        if (this.mExternPlayer == null) {
            return;
        }
        if ("SeekTo".equals(str)) {
            this.mExternPlayer.seekTo(j, z);
            return;
        }
        if ("SetVideoBackgroundColor".equals(str)) {
            this.mExternPlayer.setVideoBackgroundColor(j);
            return;
        }
        if ("Mute".equals(str)) {
            this.mExternPlayer.mute(z);
            return;
        }
        if ("EnterBackGround".equals(str)) {
            this.mExternPlayer.enterBackGround(z);
            return;
        }
        if ("SetLooping".equals(str)) {
            this.mExternPlayer.setLooping(z);
        } else if ("SetAutoPlay".equals(str)) {
            this.mExternPlayer.setAutoPlay(z);
        } else if ("selectExtSubtitle".equals(str)) {
            this.mExternPlayer.selectExtSubtitle((int) j, z);
        }
    }

    public void callRvPo(java.lang.String str, java.lang.Object obj) {
        if (this.mExternPlayer != null && "SetView".equals(str)) {
            this.mExternPlayer.setSurface((android.view.Surface) obj);
        }
    }

    public void callRvPs(java.lang.String str, java.lang.String str2) {
        if (this.mExternPlayer == null) {
            return;
        }
        if ("SetDataSource".equals(str)) {
            this.mExternPlayer.setDataSource(str2);
            return;
        }
        if ("addExtSubtitle".equals(str)) {
            this.mExternPlayer.addExtSubtitle(str2);
            return;
        }
        if ("AddCustomHttpHeader".equals(str)) {
            this.mExternPlayer.addCustomHttpHeader(str2);
        } else if ("SetUserAgent".equals(str)) {
            this.mExternPlayer.setUserAgent(str2);
        } else if ("SetRefer".equals(str)) {
            this.mExternPlayer.setRefer(str2);
        }
    }

    public void callRvPv(java.lang.String str) {
        if (this.mExternPlayer == null) {
            return;
        }
        if ("Release".equals(str)) {
            this.mExternPlayer.release();
            this.mNativeInstance = 0L;
            this.mExternPlayer = null;
            return;
        }
        if ("Prepare".equals(str)) {
            this.mExternPlayer.prepare();
            return;
        }
        if ("Start".equals(str)) {
            this.mExternPlayer.start();
            return;
        }
        if ("Pause".equals(str)) {
            this.mExternPlayer.pause();
            return;
        }
        if ("CaptureScreen".equals(str)) {
            this.mExternPlayer.captureScreen();
        } else if ("reLoad".equals(str)) {
            this.mExternPlayer.reLoad();
        } else if ("RemoveAllCustomHttpHeader".equals(str)) {
            this.mExternPlayer.removeAllCustomHttpHeader();
        }
    }

    @com.cicada.player.utils.NativeUsed
    public void create(long j, com.aliyun.player.nativeclass.Options options) {
        com.aliyun.player.ApasaraExternalPlayer isSupportExternal = com.aliyun.player.ApasaraExternalPlayer.isSupportExternal(options);
        if (isSupportExternal != null) {
            this.mExternPlayer = isSupportExternal.create(sContext, options);
        }
        com.aliyun.player.ApasaraExternalPlayer apasaraExternalPlayer = this.mExternPlayer;
        if (apasaraExternalPlayer == null) {
            return;
        }
        this.mNativeInstance = j;
        apasaraExternalPlayer.setOnPreparedListener(new com.aliyun.player.nativeclass.NativeExternalPlayer.AnonymousClass1());
        this.mExternPlayer.setOnLoopingStartListener(new com.aliyun.player.nativeclass.NativeExternalPlayer.AnonymousClass2());
        this.mExternPlayer.setOnCompletionListener(new com.aliyun.player.nativeclass.NativeExternalPlayer.AnonymousClass3());
        this.mExternPlayer.setOnFirstFrameRenderListener(new com.aliyun.player.nativeclass.NativeExternalPlayer.AnonymousClass4());
        this.mExternPlayer.setOnLoadStatusListener(new com.aliyun.player.nativeclass.NativeExternalPlayer.AnonymousClass5());
        this.mExternPlayer.setOnAutoPlayStartListener(new com.aliyun.player.nativeclass.NativeExternalPlayer.AnonymousClass6());
        this.mExternPlayer.setOnSeekStatusListener(new com.aliyun.player.nativeclass.NativeExternalPlayer.AnonymousClass7());
        this.mExternPlayer.setOnPositionUpdateListener(new com.aliyun.player.nativeclass.NativeExternalPlayer.AnonymousClass8());
        this.mExternPlayer.setOnBufferPositionUpdateListener(new com.aliyun.player.nativeclass.NativeExternalPlayer.AnonymousClass9());
        this.mExternPlayer.setOnVideoSizeChangedListener(new com.aliyun.player.nativeclass.NativeExternalPlayer.AnonymousClass10());
        this.mExternPlayer.setOnStatusChangedListener(new com.aliyun.player.nativeclass.NativeExternalPlayer.AnonymousClass11());
        this.mExternPlayer.setOnVideoRenderedListener(new com.aliyun.player.nativeclass.NativeExternalPlayer.AnonymousClass12());
        this.mExternPlayer.setOnErrorListener(new com.aliyun.player.nativeclass.NativeExternalPlayer.AnonymousClass13());
        this.mExternPlayer.setOnEventListener(new com.aliyun.player.nativeclass.NativeExternalPlayer.AnonymousClass14());
        this.mExternPlayer.setOnStreamInfoGetListener(new com.aliyun.player.nativeclass.NativeExternalPlayer.AnonymousClass15());
        this.mExternPlayer.setOnStreamSwitchSucListener(new com.aliyun.player.nativeclass.NativeExternalPlayer.AnonymousClass16());
        this.mExternPlayer.setOnCaptureScreenListener(new com.aliyun.player.nativeclass.NativeExternalPlayer.AnonymousClass17());
        this.mExternPlayer.setOnSubtitleListener(new com.aliyun.player.nativeclass.NativeExternalPlayer.AnonymousClass18());
        this.mExternPlayer.setDrmCallback(new com.aliyun.player.nativeclass.NativeExternalPlayer.AnonymousClass19());
    }

    public java.lang.Object getCurrentStreamInfo(int i) {
        com.aliyun.player.ApasaraExternalPlayer apasaraExternalPlayer = this.mExternPlayer;
        if (apasaraExternalPlayer == null) {
            return null;
        }
        com.aliyun.player.ApasaraExternalPlayer.StreamType streamType = com.aliyun.player.ApasaraExternalPlayer.StreamType.ST_TYPE_UNKNOWN;
        if (i == 0) {
            streamType = com.aliyun.player.ApasaraExternalPlayer.StreamType.ST_TYPE_VIDEO;
        } else if (i == 1) {
            streamType = com.aliyun.player.ApasaraExternalPlayer.StreamType.ST_TYPE_AUDIO;
        } else if (i == 2) {
            streamType = com.aliyun.player.ApasaraExternalPlayer.StreamType.ST_TYPE_SUB;
        }
        return apasaraExternalPlayer.getCurrentStreamInfo(streamType);
    }

    public java.lang.String getName() {
        com.aliyun.player.ApasaraExternalPlayer apasaraExternalPlayer = this.mExternPlayer;
        if (apasaraExternalPlayer == null) {
            return null;
        }
        return apasaraExternalPlayer.getName();
    }
}
