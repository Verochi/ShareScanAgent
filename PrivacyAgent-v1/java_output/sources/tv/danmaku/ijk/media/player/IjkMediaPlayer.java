package tv.danmaku.ijk.media.player;

/* loaded from: classes21.dex */
public final class IjkMediaPlayer extends tv.danmaku.ijk.media.player.AbstractMediaPlayer {
    public static final int FFP_PROPV_DECODER_AVCODEC = 1;
    public static final int FFP_PROPV_DECODER_MEDIACODEC = 2;
    public static final int FFP_PROPV_DECODER_UNKNOWN = 0;
    public static final int FFP_PROPV_DECODER_VIDEOTOOLBOX = 3;
    public static final int FFP_PROP_FLOAT_DROP_FRAME_RATE = 10007;
    public static final int FFP_PROP_FLOAT_PLAYBACK_RATE = 10003;
    public static final int FFP_PROP_INT64_ASYNC_STATISTIC_BUF_BACKWARDS = 20201;
    public static final int FFP_PROP_INT64_ASYNC_STATISTIC_BUF_CAPACITY = 20203;
    public static final int FFP_PROP_INT64_ASYNC_STATISTIC_BUF_FORWARDS = 20202;
    public static final int FFP_PROP_INT64_AUDIO_CACHED_BYTES = 20008;
    public static final int FFP_PROP_INT64_AUDIO_CACHED_DURATION = 20006;
    public static final int FFP_PROP_INT64_AUDIO_CACHED_PACKETS = 20010;
    public static final int FFP_PROP_INT64_AUDIO_DECODER = 20004;
    public static final int FFP_PROP_INT64_BIT_RATE = 20100;
    public static final int FFP_PROP_INT64_CACHE_STATISTIC_COUNT_BYTES = 20208;
    public static final int FFP_PROP_INT64_CACHE_STATISTIC_FILE_FORWARDS = 20206;
    public static final int FFP_PROP_INT64_CACHE_STATISTIC_FILE_POS = 20207;
    public static final int FFP_PROP_INT64_CACHE_STATISTIC_PHYSICAL_POS = 20205;
    public static final int FFP_PROP_INT64_IMMEDIATE_RECONNECT = 20211;
    public static final int FFP_PROP_INT64_LATEST_SEEK_LOAD_DURATION = 20300;
    public static final int FFP_PROP_INT64_LOGICAL_FILE_SIZE = 20209;
    public static final int FFP_PROP_INT64_SELECTED_AUDIO_STREAM = 20002;
    public static final int FFP_PROP_INT64_SELECTED_TIMEDTEXT_STREAM = 20011;
    public static final int FFP_PROP_INT64_SELECTED_VIDEO_STREAM = 20001;
    public static final int FFP_PROP_INT64_SHARE_CACHE_DATA = 20210;
    public static final int FFP_PROP_INT64_TCP_SPEED = 20200;
    public static final int FFP_PROP_INT64_TRAFFIC_STATISTIC_BYTE_COUNT = 20204;
    public static final int FFP_PROP_INT64_VIDEO_CACHED_BYTES = 20007;
    public static final int FFP_PROP_INT64_VIDEO_CACHED_DURATION = 20005;
    public static final int FFP_PROP_INT64_VIDEO_CACHED_PACKETS = 20009;
    public static final int FFP_PROP_INT64_VIDEO_DECODER = 20003;
    public static final int IJK_LOG_DEBUG = 3;
    public static final int IJK_LOG_DEFAULT = 1;
    public static final int IJK_LOG_ERROR = 6;
    public static final int IJK_LOG_FATAL = 7;
    public static final int IJK_LOG_INFO = 4;
    public static final int IJK_LOG_SILENT = 8;
    public static final int IJK_LOG_UNKNOWN = 0;
    public static final int IJK_LOG_VERBOSE = 2;
    public static final int IJK_LOG_WARN = 5;
    private static final int MEDIA_BUFFERING_UPDATE = 3;
    private static final int MEDIA_ERROR = 100;
    private static final int MEDIA_INFO = 200;
    private static final int MEDIA_NOP = 0;
    private static final int MEDIA_PLAYBACK_COMPLETE = 2;
    private static final int MEDIA_PREPARED = 1;
    private static final int MEDIA_SEEK_COMPLETE = 4;
    protected static final int MEDIA_SET_VIDEO_SAR = 10001;
    private static final int MEDIA_SET_VIDEO_SIZE = 5;
    private static final int MEDIA_TIMED_TEXT = 99;
    public static final int OPT_CATEGORY_CODEC = 2;
    public static final int OPT_CATEGORY_FORMAT = 1;
    public static final int OPT_CATEGORY_PLAYER = 4;
    public static final int OPT_CATEGORY_SWS = 3;
    public static final int PROP_FLOAT_VIDEO_DECODE_FRAMES_PER_SECOND = 10001;
    public static final int PROP_FLOAT_VIDEO_OUTPUT_FRAMES_PER_SECOND = 10002;
    public static final int SDL_FCC_RV16 = 909203026;
    public static final int SDL_FCC_RV32 = 842225234;
    public static final int SDL_FCC_YV12 = 842094169;
    private static final java.lang.String TAG = "tv.danmaku.ijk.media.player.IjkMediaPlayer";
    private java.lang.String mDataSource;
    private tv.danmaku.ijk.media.player.IjkMediaPlayer.EventHandler mEventHandler;

    @tv.danmaku.ijk.media.player.annotations.AccessedByNative
    private int mListenerContext;

    @tv.danmaku.ijk.media.player.annotations.AccessedByNative
    private long mNativeAndroidIO;

    @tv.danmaku.ijk.media.player.annotations.AccessedByNative
    private long mNativeMediaDataSource;

    @tv.danmaku.ijk.media.player.annotations.AccessedByNative
    private long mNativeMediaPlayer;

    @tv.danmaku.ijk.media.player.annotations.AccessedByNative
    private int mNativeSurfaceTexture;
    private tv.danmaku.ijk.media.player.IjkMediaPlayer.OnControlMessageListener mOnControlMessageListener;
    private tv.danmaku.ijk.media.player.IjkMediaPlayer.OnMediaCodecSelectListener mOnMediaCodecSelectListener;
    private tv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener mOnNativeInvokeListener;
    private boolean mScreenOnWhilePlaying;
    private boolean mStayAwake;
    private android.view.SurfaceHolder mSurfaceHolder;
    private int mVideoHeight;
    private int mVideoSarDen;
    private int mVideoSarNum;
    private int mVideoWidth;
    private android.os.PowerManager.WakeLock mWakeLock;
    private static final tv.danmaku.ijk.media.player.IjkLibLoader sLocalLibLoader = new tv.danmaku.ijk.media.player.IjkMediaPlayer.AnonymousClass1();
    private static volatile boolean mIsLibLoaded = false;
    private static volatile boolean mIsNativeInitialized = false;

    /* renamed from: tv.danmaku.ijk.media.player.IjkMediaPlayer$1, reason: invalid class name */
    public static class AnonymousClass1 implements tv.danmaku.ijk.media.player.IjkLibLoader {
        @Override // tv.danmaku.ijk.media.player.IjkLibLoader
        public void loadLibrary(java.lang.String str) throws java.lang.UnsatisfiedLinkError, java.lang.SecurityException {
            java.lang.System.loadLibrary(str);
        }
    }

    public static class DefaultMediaCodecSelector implements tv.danmaku.ijk.media.player.IjkMediaPlayer.OnMediaCodecSelectListener {
        public static final tv.danmaku.ijk.media.player.IjkMediaPlayer.DefaultMediaCodecSelector sInstance = new tv.danmaku.ijk.media.player.IjkMediaPlayer.DefaultMediaCodecSelector();

        @Override // tv.danmaku.ijk.media.player.IjkMediaPlayer.OnMediaCodecSelectListener
        @android.annotation.TargetApi(16)
        public java.lang.String onMediaCodecSelect(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, java.lang.String str, int i, int i2) {
            java.lang.String[] supportedTypes;
            tv.danmaku.ijk.media.player.IjkMediaCodecInfo ijkMediaCodecInfo;
            if (android.text.TextUtils.isEmpty(str)) {
                return null;
            }
            java.lang.String unused = tv.danmaku.ijk.media.player.IjkMediaPlayer.TAG;
            java.lang.String.format(java.util.Locale.US, "onSelectCodec: mime=%s, profile=%d, level=%d", str, java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2));
            java.util.ArrayList arrayList = new java.util.ArrayList();
            int codecCount = android.media.MediaCodecList.getCodecCount();
            for (int i3 = 0; i3 < codecCount; i3++) {
                android.media.MediaCodecInfo codecInfoAt = android.media.MediaCodecList.getCodecInfoAt(i3);
                java.lang.String unused2 = tv.danmaku.ijk.media.player.IjkMediaPlayer.TAG;
                java.lang.String.format(java.util.Locale.US, "  found codec: %s", codecInfoAt.getName());
                if (!codecInfoAt.isEncoder() && (supportedTypes = codecInfoAt.getSupportedTypes()) != null) {
                    for (java.lang.String str2 : supportedTypes) {
                        if (!android.text.TextUtils.isEmpty(str2)) {
                            java.lang.String unused3 = tv.danmaku.ijk.media.player.IjkMediaPlayer.TAG;
                            java.util.Locale locale = java.util.Locale.US;
                            java.lang.String.format(locale, "    mime: %s", str2);
                            if (str2.equalsIgnoreCase(str) && (ijkMediaCodecInfo = tv.danmaku.ijk.media.player.IjkMediaCodecInfo.setupCandidate(codecInfoAt, str)) != null) {
                                arrayList.add(ijkMediaCodecInfo);
                                java.lang.String unused4 = tv.danmaku.ijk.media.player.IjkMediaPlayer.TAG;
                                java.lang.String.format(locale, "candidate codec: %s rank=%d", codecInfoAt.getName(), java.lang.Integer.valueOf(ijkMediaCodecInfo.mRank));
                                ijkMediaCodecInfo.dumpProfileLevels(str);
                            }
                        }
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            tv.danmaku.ijk.media.player.IjkMediaCodecInfo ijkMediaCodecInfo2 = (tv.danmaku.ijk.media.player.IjkMediaCodecInfo) arrayList.get(0);
            java.util.Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                tv.danmaku.ijk.media.player.IjkMediaCodecInfo ijkMediaCodecInfo3 = (tv.danmaku.ijk.media.player.IjkMediaCodecInfo) it.next();
                if (ijkMediaCodecInfo3.mRank > ijkMediaCodecInfo2.mRank) {
                    ijkMediaCodecInfo2 = ijkMediaCodecInfo3;
                }
            }
            if (ijkMediaCodecInfo2.mRank < 600) {
                java.lang.String unused5 = tv.danmaku.ijk.media.player.IjkMediaPlayer.TAG;
                java.lang.String.format(java.util.Locale.US, "unaccetable codec: %s", ijkMediaCodecInfo2.mCodecInfo.getName());
                return null;
            }
            java.lang.String unused6 = tv.danmaku.ijk.media.player.IjkMediaPlayer.TAG;
            java.lang.String.format(java.util.Locale.US, "selected codec: %s rank=%d", ijkMediaCodecInfo2.mCodecInfo.getName(), java.lang.Integer.valueOf(ijkMediaCodecInfo2.mRank));
            return ijkMediaCodecInfo2.mCodecInfo.getName();
        }
    }

    public static class EventHandler extends android.os.Handler {
        private final java.lang.ref.WeakReference<tv.danmaku.ijk.media.player.IjkMediaPlayer> mWeakPlayer;

        public EventHandler(tv.danmaku.ijk.media.player.IjkMediaPlayer ijkMediaPlayer, android.os.Looper looper) {
            super(looper);
            this.mWeakPlayer = new java.lang.ref.WeakReference<>(ijkMediaPlayer);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            tv.danmaku.ijk.media.player.IjkMediaPlayer ijkMediaPlayer = this.mWeakPlayer.get();
            if (ijkMediaPlayer != null) {
                if (ijkMediaPlayer.mNativeMediaPlayer != 0) {
                    int i = message.what;
                    if (i != 0) {
                        if (i == 1) {
                            ijkMediaPlayer.notifyOnPrepared();
                            return;
                        }
                        if (i == 2) {
                            ijkMediaPlayer.stayAwake(false);
                            ijkMediaPlayer.notifyOnCompletion();
                            return;
                        }
                        if (i == 3) {
                            long j = message.arg1;
                            if (j < 0) {
                                j = 0;
                            }
                            long duration = ijkMediaPlayer.getDuration();
                            long j2 = duration > 0 ? (j * 100) / duration : 0L;
                            ijkMediaPlayer.notifyOnBufferingUpdate((int) (j2 < 100 ? j2 : 100L));
                            return;
                        }
                        if (i == 4) {
                            ijkMediaPlayer.notifyOnSeekComplete();
                            return;
                        }
                        if (i == 5) {
                            ijkMediaPlayer.mVideoWidth = message.arg1;
                            ijkMediaPlayer.mVideoHeight = message.arg2;
                            ijkMediaPlayer.notifyOnVideoSizeChanged(ijkMediaPlayer.mVideoWidth, ijkMediaPlayer.mVideoHeight, ijkMediaPlayer.mVideoSarNum, ijkMediaPlayer.mVideoSarDen);
                            return;
                        }
                        if (i == 99) {
                            if (message.obj == null) {
                                ijkMediaPlayer.notifyOnTimedText(null);
                                return;
                            } else {
                                ijkMediaPlayer.notifyOnTimedText(new tv.danmaku.ijk.media.player.IjkTimedText(new android.graphics.Rect(0, 0, 1, 1), (java.lang.String) message.obj));
                                return;
                            }
                        }
                        if (i == 100) {
                            tv.danmaku.ijk.media.player.pragma.DebugLog.e(tv.danmaku.ijk.media.player.IjkMediaPlayer.TAG, "Error (" + message.arg1 + "," + message.arg2 + ")");
                            if (!ijkMediaPlayer.notifyOnError(message.arg1, message.arg2)) {
                                ijkMediaPlayer.notifyOnCompletion();
                            }
                            ijkMediaPlayer.stayAwake(false);
                            return;
                        }
                        if (i == 200) {
                            if (message.arg1 == 3) {
                                tv.danmaku.ijk.media.player.pragma.DebugLog.i(tv.danmaku.ijk.media.player.IjkMediaPlayer.TAG, "Info: MEDIA_INFO_VIDEO_RENDERING_START\n");
                            }
                            ijkMediaPlayer.notifyOnInfo(message.arg1, message.arg2);
                            return;
                        } else if (i == 10001) {
                            ijkMediaPlayer.mVideoSarNum = message.arg1;
                            ijkMediaPlayer.mVideoSarDen = message.arg2;
                            ijkMediaPlayer.notifyOnVideoSizeChanged(ijkMediaPlayer.mVideoWidth, ijkMediaPlayer.mVideoHeight, ijkMediaPlayer.mVideoSarNum, ijkMediaPlayer.mVideoSarDen);
                            return;
                        } else {
                            tv.danmaku.ijk.media.player.pragma.DebugLog.e(tv.danmaku.ijk.media.player.IjkMediaPlayer.TAG, "Unknown message type " + message.what);
                            return;
                        }
                    }
                    return;
                }
            }
            tv.danmaku.ijk.media.player.pragma.DebugLog.w(tv.danmaku.ijk.media.player.IjkMediaPlayer.TAG, "IjkMediaPlayer went away with unhandled events");
        }
    }

    public interface OnControlMessageListener {
        java.lang.String onControlResolveSegmentUrl(int i);
    }

    public interface OnMediaCodecSelectListener {
        java.lang.String onMediaCodecSelect(tv.danmaku.ijk.media.player.IMediaPlayer iMediaPlayer, java.lang.String str, int i, int i2);
    }

    public interface OnNativeInvokeListener {
        public static final java.lang.String ARG_ERROR = "error";
        public static final java.lang.String ARG_FAMILIY = "family";
        public static final java.lang.String ARG_FD = "fd";
        public static final java.lang.String ARG_FILE_SIZE = "file_size";
        public static final java.lang.String ARG_HTTP_CODE = "http_code";
        public static final java.lang.String ARG_IP = "ip";
        public static final java.lang.String ARG_OFFSET = "offset";
        public static final java.lang.String ARG_PORT = "port";
        public static final java.lang.String ARG_RETRY_COUNTER = "retry_counter";
        public static final java.lang.String ARG_SEGMENT_INDEX = "segment_index";
        public static final java.lang.String ARG_URL = "url";
        public static final int CTRL_DID_TCP_OPEN = 131074;
        public static final int CTRL_WILL_CONCAT_RESOLVE_SEGMENT = 131079;
        public static final int CTRL_WILL_HTTP_OPEN = 131075;
        public static final int CTRL_WILL_LIVE_OPEN = 131077;
        public static final int CTRL_WILL_TCP_OPEN = 131073;
        public static final int EVENT_DID_HTTP_OPEN = 2;
        public static final int EVENT_DID_HTTP_SEEK = 4;
        public static final int EVENT_WILL_HTTP_OPEN = 1;
        public static final int EVENT_WILL_HTTP_SEEK = 3;

        boolean onNativeInvoke(int i, android.os.Bundle bundle);
    }

    public IjkMediaPlayer() {
        this(sLocalLibLoader);
    }

    public IjkMediaPlayer(tv.danmaku.ijk.media.player.IjkLibLoader ijkLibLoader) {
        this.mWakeLock = null;
        initPlayer(ijkLibLoader);
    }

    private native java.lang.String _getAudioCodecInfo();

    private static native java.lang.String _getColorFormatName(int i);

    private native int _getLoopCount();

    private native android.os.Bundle _getMediaMeta();

    private native float _getPropertyFloat(int i, float f);

    private native long _getPropertyLong(int i, long j);

    private native java.lang.String _getVideoCodecInfo();

    private native void _pause() throws java.lang.IllegalStateException;

    private native void _release();

    private native void _reset();

    private native void _setAndroidIOCallback(tv.danmaku.ijk.media.player.misc.IAndroidIO iAndroidIO) throws java.lang.IllegalArgumentException, java.lang.SecurityException, java.lang.IllegalStateException;

    private native void _setDataSource(java.lang.String str, java.lang.String[] strArr, java.lang.String[] strArr2) throws java.io.IOException, java.lang.IllegalArgumentException, java.lang.SecurityException, java.lang.IllegalStateException;

    private native void _setDataSource(tv.danmaku.ijk.media.player.misc.IMediaDataSource iMediaDataSource) throws java.lang.IllegalArgumentException, java.lang.SecurityException, java.lang.IllegalStateException;

    private native void _setDataSourceFd(int i) throws java.io.IOException, java.lang.IllegalArgumentException, java.lang.SecurityException, java.lang.IllegalStateException;

    private native void _setFrameAtTime(java.lang.String str, long j, long j2, int i, int i2) throws java.lang.IllegalArgumentException, java.lang.IllegalStateException;

    private native void _setLoopCount(int i);

    private native void _setOption(int i, java.lang.String str, long j);

    private native void _setOption(int i, java.lang.String str, java.lang.String str2);

    private native void _setPropertyFloat(int i, float f);

    private native void _setPropertyLong(int i, long j);

    private native void _setStreamSelected(int i, boolean z);

    private native void _setVideoSurface(android.view.Surface surface);

    private native void _start() throws java.lang.IllegalStateException;

    private native void _stop() throws java.lang.IllegalStateException;

    public static java.lang.String getColorFormatName(int i) {
        return _getColorFormatName(i);
    }

    private static void initNativeOnce() {
        synchronized (tv.danmaku.ijk.media.player.IjkMediaPlayer.class) {
            if (!mIsNativeInitialized) {
                native_init();
                mIsNativeInitialized = true;
            }
        }
    }

    private void initPlayer(tv.danmaku.ijk.media.player.IjkLibLoader ijkLibLoader) {
        loadLibrariesOnce(ijkLibLoader);
        initNativeOnce();
        android.os.Looper myLooper = android.os.Looper.myLooper();
        if (myLooper != null) {
            this.mEventHandler = new tv.danmaku.ijk.media.player.IjkMediaPlayer.EventHandler(this, myLooper);
        } else {
            android.os.Looper mainLooper = android.os.Looper.getMainLooper();
            if (mainLooper != null) {
                this.mEventHandler = new tv.danmaku.ijk.media.player.IjkMediaPlayer.EventHandler(this, mainLooper);
            } else {
                this.mEventHandler = null;
            }
        }
        native_setup(new java.lang.ref.WeakReference(this));
    }

    public static void loadLibrariesOnce(tv.danmaku.ijk.media.player.IjkLibLoader ijkLibLoader) {
        synchronized (tv.danmaku.ijk.media.player.IjkMediaPlayer.class) {
            if (!mIsLibLoaded) {
                if (ijkLibLoader == null) {
                    ijkLibLoader = sLocalLibLoader;
                }
                ijkLibLoader.loadLibrary("ijkffmpeg");
                ijkLibLoader.loadLibrary("ijksdl");
                ijkLibLoader.loadLibrary("ijkplayer");
                mIsLibLoaded = true;
            }
        }
    }

    private native void native_finalize();

    private static native void native_init();

    private native void native_message_loop(java.lang.Object obj);

    public static native void native_profileBegin(java.lang.String str);

    public static native void native_profileEnd();

    public static native void native_setLogLevel(int i);

    private native void native_setup(java.lang.Object obj);

    @tv.danmaku.ijk.media.player.annotations.CalledByNative
    private static boolean onNativeInvoke(java.lang.Object obj, int i, android.os.Bundle bundle) {
        tv.danmaku.ijk.media.player.IjkMediaPlayer.OnControlMessageListener onControlMessageListener;
        tv.danmaku.ijk.media.player.pragma.DebugLog.ifmt(TAG, "onNativeInvoke %d", java.lang.Integer.valueOf(i));
        if (obj == null || !(obj instanceof java.lang.ref.WeakReference)) {
            throw new java.lang.IllegalStateException("<null weakThiz>.onNativeInvoke()");
        }
        tv.danmaku.ijk.media.player.IjkMediaPlayer ijkMediaPlayer = (tv.danmaku.ijk.media.player.IjkMediaPlayer) ((java.lang.ref.WeakReference) obj).get();
        if (ijkMediaPlayer == null) {
            throw new java.lang.IllegalStateException("<null weakPlayer>.onNativeInvoke()");
        }
        tv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener onNativeInvokeListener = ijkMediaPlayer.mOnNativeInvokeListener;
        if (onNativeInvokeListener != null && onNativeInvokeListener.onNativeInvoke(i, bundle)) {
            return true;
        }
        if (i != 131079 || (onControlMessageListener = ijkMediaPlayer.mOnControlMessageListener) == null) {
            return false;
        }
        int i2 = bundle.getInt(tv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener.ARG_SEGMENT_INDEX, -1);
        if (i2 < 0) {
            throw new java.security.InvalidParameterException("onNativeInvoke(invalid segment index)");
        }
        java.lang.String onControlResolveSegmentUrl = onControlMessageListener.onControlResolveSegmentUrl(i2);
        if (onControlResolveSegmentUrl == null) {
            throw new java.lang.RuntimeException(new java.io.IOException("onNativeInvoke() = <NULL newUrl>"));
        }
        bundle.putString("url", onControlResolveSegmentUrl);
        return true;
    }

    @tv.danmaku.ijk.media.player.annotations.CalledByNative
    private static java.lang.String onSelectCodec(java.lang.Object obj, java.lang.String str, int i, int i2) {
        tv.danmaku.ijk.media.player.IjkMediaPlayer ijkMediaPlayer;
        if (obj == null || !(obj instanceof java.lang.ref.WeakReference) || (ijkMediaPlayer = (tv.danmaku.ijk.media.player.IjkMediaPlayer) ((java.lang.ref.WeakReference) obj).get()) == null) {
            return null;
        }
        tv.danmaku.ijk.media.player.IjkMediaPlayer.OnMediaCodecSelectListener onMediaCodecSelectListener = ijkMediaPlayer.mOnMediaCodecSelectListener;
        if (onMediaCodecSelectListener == null) {
            onMediaCodecSelectListener = tv.danmaku.ijk.media.player.IjkMediaPlayer.DefaultMediaCodecSelector.sInstance;
        }
        return onMediaCodecSelectListener.onMediaCodecSelect(ijkMediaPlayer, str, i, i2);
    }

    @tv.danmaku.ijk.media.player.annotations.CalledByNative
    private static void postEventFromNative(java.lang.Object obj, int i, int i2, int i3, java.lang.Object obj2) {
        tv.danmaku.ijk.media.player.IjkMediaPlayer ijkMediaPlayer;
        if (obj == null || (ijkMediaPlayer = (tv.danmaku.ijk.media.player.IjkMediaPlayer) ((java.lang.ref.WeakReference) obj).get()) == null) {
            return;
        }
        if (i == 200 && i2 == 2) {
            ijkMediaPlayer.start();
        }
        tv.danmaku.ijk.media.player.IjkMediaPlayer.EventHandler eventHandler = ijkMediaPlayer.mEventHandler;
        if (eventHandler != null) {
            ijkMediaPlayer.mEventHandler.sendMessage(eventHandler.obtainMessage(i, i2, i3, obj2));
        }
    }

    private void setDataSource(java.io.FileDescriptor fileDescriptor, long j, long j2) throws java.io.IOException, java.lang.IllegalArgumentException, java.lang.IllegalStateException {
        setDataSource(fileDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @android.annotation.SuppressLint({"Wakelock"})
    public void stayAwake(boolean z) {
        android.os.PowerManager.WakeLock wakeLock = this.mWakeLock;
        if (wakeLock != null) {
            if (z && !wakeLock.isHeld()) {
                this.mWakeLock.acquire();
            } else if (!z && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        }
        this.mStayAwake = z;
        updateSurfaceScreenOn();
    }

    private void updateSurfaceScreenOn() {
        android.view.SurfaceHolder surfaceHolder = this.mSurfaceHolder;
        if (surfaceHolder != null) {
            surfaceHolder.setKeepScreenOn(this.mScreenOnWhilePlaying && this.mStayAwake);
        }
    }

    public native void _prepareAsync() throws java.lang.IllegalStateException;

    public void deselectTrack(int i) {
        _setStreamSelected(i, false);
    }

    public void finalize() throws java.lang.Throwable {
        super.finalize();
        native_finalize();
    }

    public long getAsyncStatisticBufBackwards() {
        return _getPropertyLong(FFP_PROP_INT64_ASYNC_STATISTIC_BUF_BACKWARDS, 0L);
    }

    public long getAsyncStatisticBufCapacity() {
        return _getPropertyLong(FFP_PROP_INT64_ASYNC_STATISTIC_BUF_CAPACITY, 0L);
    }

    public long getAsyncStatisticBufForwards() {
        return _getPropertyLong(FFP_PROP_INT64_ASYNC_STATISTIC_BUF_FORWARDS, 0L);
    }

    public long getAudioCachedBytes() {
        return _getPropertyLong(20008, 0L);
    }

    public long getAudioCachedDuration() {
        return _getPropertyLong(20006, 0L);
    }

    public long getAudioCachedPackets() {
        return _getPropertyLong(20010, 0L);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public native int getAudioSessionId();

    public long getBitRate() {
        return _getPropertyLong(FFP_PROP_INT64_BIT_RATE, 0L);
    }

    public long getCacheStatisticCountBytes() {
        return _getPropertyLong(FFP_PROP_INT64_CACHE_STATISTIC_COUNT_BYTES, 0L);
    }

    public long getCacheStatisticFileForwards() {
        return _getPropertyLong(FFP_PROP_INT64_CACHE_STATISTIC_FILE_FORWARDS, 0L);
    }

    public long getCacheStatisticFilePos() {
        return _getPropertyLong(FFP_PROP_INT64_CACHE_STATISTIC_FILE_POS, 0L);
    }

    public long getCacheStatisticPhysicalPos() {
        return _getPropertyLong(FFP_PROP_INT64_CACHE_STATISTIC_PHYSICAL_POS, 0L);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public native long getCurrentPosition();

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public java.lang.String getDataSource() {
        return this.mDataSource;
    }

    public float getDropFrameRate() {
        return _getPropertyFloat(10007, 0.0f);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public native long getDuration();

    public long getFileSize() {
        return _getPropertyLong(FFP_PROP_INT64_LOGICAL_FILE_SIZE, 0L);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public tv.danmaku.ijk.media.player.MediaInfo getMediaInfo() {
        tv.danmaku.ijk.media.player.MediaInfo mediaInfo = new tv.danmaku.ijk.media.player.MediaInfo();
        mediaInfo.mMediaPlayerName = "ijkplayer";
        java.lang.String _getVideoCodecInfo = _getVideoCodecInfo();
        if (!android.text.TextUtils.isEmpty(_getVideoCodecInfo)) {
            java.lang.String[] split = _getVideoCodecInfo.split(",");
            if (split.length >= 2) {
                mediaInfo.mVideoDecoder = split[0];
                mediaInfo.mVideoDecoderImpl = split[1];
            } else if (split.length >= 1) {
                mediaInfo.mVideoDecoder = split[0];
                mediaInfo.mVideoDecoderImpl = "";
            }
        }
        java.lang.String _getAudioCodecInfo = _getAudioCodecInfo();
        if (!android.text.TextUtils.isEmpty(_getAudioCodecInfo)) {
            java.lang.String[] split2 = _getAudioCodecInfo.split(",");
            if (split2.length >= 2) {
                mediaInfo.mAudioDecoder = split2[0];
                mediaInfo.mAudioDecoderImpl = split2[1];
            } else if (split2.length >= 1) {
                mediaInfo.mAudioDecoder = split2[0];
                mediaInfo.mAudioDecoderImpl = "";
            }
        }
        try {
            mediaInfo.mMeta = tv.danmaku.ijk.media.player.IjkMediaMeta.parse(_getMediaMeta());
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return mediaInfo;
    }

    public android.os.Bundle getMediaMeta() {
        return _getMediaMeta();
    }

    public long getSeekLoadDuration() {
        return _getPropertyLong(FFP_PROP_INT64_LATEST_SEEK_LOAD_DURATION, 0L);
    }

    public int getSelectedTrack(int i) {
        long _getPropertyLong;
        if (i == 1) {
            _getPropertyLong = _getPropertyLong(20001, -1L);
        } else if (i == 2) {
            _getPropertyLong = _getPropertyLong(20002, -1L);
        } else {
            if (i != 3) {
                return -1;
            }
            _getPropertyLong = _getPropertyLong(20011, -1L);
        }
        return (int) _getPropertyLong;
    }

    public float getSpeed(float f) {
        return _getPropertyFloat(10003, 0.0f);
    }

    public long getTcpSpeed() {
        return _getPropertyLong(FFP_PROP_INT64_TCP_SPEED, 0L);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public tv.danmaku.ijk.media.player.misc.IjkTrackInfo[] getTrackInfo() {
        tv.danmaku.ijk.media.player.IjkMediaMeta parse;
        android.os.Bundle mediaMeta = getMediaMeta();
        if (mediaMeta == null || (parse = tv.danmaku.ijk.media.player.IjkMediaMeta.parse(mediaMeta)) == null || parse.mStreams == null) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator<tv.danmaku.ijk.media.player.IjkMediaMeta.IjkStreamMeta> it = parse.mStreams.iterator();
        while (it.hasNext()) {
            tv.danmaku.ijk.media.player.IjkMediaMeta.IjkStreamMeta next = it.next();
            tv.danmaku.ijk.media.player.misc.IjkTrackInfo ijkTrackInfo = new tv.danmaku.ijk.media.player.misc.IjkTrackInfo(next);
            if (next.mType.equalsIgnoreCase("video")) {
                ijkTrackInfo.setTrackType(1);
            } else if (next.mType.equalsIgnoreCase("audio")) {
                ijkTrackInfo.setTrackType(2);
            } else if (next.mType.equalsIgnoreCase("timedtext")) {
                ijkTrackInfo.setTrackType(3);
            }
            arrayList.add(ijkTrackInfo);
        }
        return (tv.danmaku.ijk.media.player.misc.IjkTrackInfo[]) arrayList.toArray(new tv.danmaku.ijk.media.player.misc.IjkTrackInfo[arrayList.size()]);
    }

    public long getTrafficStatisticByteCount() {
        return _getPropertyLong(FFP_PROP_INT64_TRAFFIC_STATISTIC_BYTE_COUNT, 0L);
    }

    public long getVideoCachedBytes() {
        return _getPropertyLong(20007, 0L);
    }

    public long getVideoCachedDuration() {
        return _getPropertyLong(20005, 0L);
    }

    public long getVideoCachedPackets() {
        return _getPropertyLong(20009, 0L);
    }

    public float getVideoDecodeFramesPerSecond() {
        return _getPropertyFloat(10001, 0.0f);
    }

    public int getVideoDecoder() {
        return (int) _getPropertyLong(20003, 0L);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    public float getVideoOutputFramesPerSecond() {
        return _getPropertyFloat(10002, 0.0f);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoSarDen() {
        return this.mVideoSarDen;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoSarNum() {
        return this.mVideoSarNum;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    public void httphookReconnect() {
        _setPropertyLong(FFP_PROP_INT64_IMMEDIATE_RECONNECT, 1L);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isLooping() {
        return _getLoopCount() != 1;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public boolean isPlayable() {
        return true;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public native boolean isPlaying();

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void pause() throws java.lang.IllegalStateException {
        stayAwake(false);
        _pause();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void prepareAsync() throws java.lang.IllegalStateException {
        _prepareAsync();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void release() {
        stayAwake(false);
        updateSurfaceScreenOn();
        resetListeners();
        _release();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void reset() {
        stayAwake(false);
        _reset();
        this.mEventHandler.removeCallbacksAndMessages(null);
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
    }

    @Override // tv.danmaku.ijk.media.player.AbstractMediaPlayer
    public void resetListeners() {
        super.resetListeners();
        this.mOnMediaCodecSelectListener = null;
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public native void seekTo(long j) throws java.lang.IllegalStateException;

    public void selectTrack(int i) {
        _setStreamSelected(i, true);
    }

    public void setAndroidIOCallback(tv.danmaku.ijk.media.player.misc.IAndroidIO iAndroidIO) throws java.lang.IllegalArgumentException, java.lang.SecurityException, java.lang.IllegalStateException {
        _setAndroidIOCallback(iAndroidIO);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setAudioStreamType(int i) {
    }

    public void setCacheShare(int i) {
        _setPropertyLong(FFP_PROP_INT64_SHARE_CACHE_DATA, i);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(android.content.Context context, android.net.Uri uri) throws java.io.IOException, java.lang.IllegalArgumentException, java.lang.SecurityException, java.lang.IllegalStateException {
        setDataSource(context, uri, (java.util.Map<java.lang.String, java.lang.String>) null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x007c, code lost:
    
        if (0 == 0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0085, code lost:
    
        setDataSource(r9.toString(), r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008c, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0082, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0080, code lost:
    
        if (0 == 0) goto L37;
     */
    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    @android.annotation.TargetApi(14)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setDataSource(android.content.Context context, android.net.Uri uri, java.util.Map<java.lang.String, java.lang.String> map) throws java.io.IOException, java.lang.IllegalArgumentException, java.lang.SecurityException, java.lang.IllegalStateException {
        java.lang.String scheme = uri.getScheme();
        if ("file".equals(scheme)) {
            setDataSource(uri.getPath());
            return;
        }
        if ("content".equals(scheme) && "settings".equals(uri.getAuthority()) && (uri = android.media.RingtoneManager.getActualDefaultRingtoneUri(context, android.media.RingtoneManager.getDefaultType(uri))) == null) {
            throw new java.io.FileNotFoundException("Failed to resolve default ringtone");
        }
        android.content.res.AssetFileDescriptor assetFileDescriptor = null;
        try {
            android.content.res.AssetFileDescriptor openAssetFileDescriptor = context.getContentResolver().openAssetFileDescriptor(uri, "r");
            if (openAssetFileDescriptor == null) {
                if (openAssetFileDescriptor != null) {
                    openAssetFileDescriptor.close();
                }
            } else {
                if (openAssetFileDescriptor.getDeclaredLength() < 0) {
                    setDataSource(openAssetFileDescriptor.getFileDescriptor());
                } else {
                    setDataSource(openAssetFileDescriptor.getFileDescriptor(), openAssetFileDescriptor.getStartOffset(), openAssetFileDescriptor.getDeclaredLength());
                }
                openAssetFileDescriptor.close();
            }
        } catch (java.io.IOException unused) {
        } catch (java.lang.SecurityException unused2) {
        } catch (java.lang.Throwable th) {
            if (0 != 0) {
                assetFileDescriptor.close();
            }
            throw th;
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    @android.annotation.TargetApi(13)
    public void setDataSource(java.io.FileDescriptor fileDescriptor) throws java.io.IOException, java.lang.IllegalArgumentException, java.lang.IllegalStateException {
        android.os.ParcelFileDescriptor dup = android.os.ParcelFileDescriptor.dup(fileDescriptor);
        try {
            _setDataSourceFd(dup.getFd());
        } finally {
            dup.close();
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(java.lang.String str) throws java.io.IOException, java.lang.IllegalArgumentException, java.lang.SecurityException, java.lang.IllegalStateException {
        this.mDataSource = str;
        _setDataSource(str, null, null);
    }

    public void setDataSource(java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) throws java.io.IOException, java.lang.IllegalArgumentException, java.lang.SecurityException, java.lang.IllegalStateException {
        if (map != null && !map.isEmpty()) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
                sb.append(entry.getKey());
                sb.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
                if (!android.text.TextUtils.isEmpty(entry.getValue())) {
                    sb.append(entry.getValue());
                }
                sb.append("\r\n");
                setOption(1, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_HEADERS, sb.toString());
                setOption(1, "protocol_whitelist", "async,cache,crypto,file,http,https,ijkhttphook,ijkinject,ijklivehook,ijklongurl,ijksegment,ijktcphook,pipe,rtp,tcp,tls,udp,ijkurlhook,data");
            }
        }
        setDataSource(str);
    }

    @Override // tv.danmaku.ijk.media.player.AbstractMediaPlayer, tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDataSource(tv.danmaku.ijk.media.player.misc.IMediaDataSource iMediaDataSource) throws java.lang.IllegalArgumentException, java.lang.SecurityException, java.lang.IllegalStateException {
        _setDataSource(iMediaDataSource);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setDisplay(android.view.SurfaceHolder surfaceHolder) {
        this.mSurfaceHolder = surfaceHolder;
        _setVideoSurface(surfaceHolder != null ? surfaceHolder.getSurface() : null);
        updateSurfaceScreenOn();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setKeepInBackground(boolean z) {
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setLogEnabled(boolean z) {
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setLooping(boolean z) {
        int i = !z ? 1 : 0;
        setOption(4, "loop", i);
        _setLoopCount(i);
    }

    public void setOnControlMessageListener(tv.danmaku.ijk.media.player.IjkMediaPlayer.OnControlMessageListener onControlMessageListener) {
        this.mOnControlMessageListener = onControlMessageListener;
    }

    public void setOnMediaCodecSelectListener(tv.danmaku.ijk.media.player.IjkMediaPlayer.OnMediaCodecSelectListener onMediaCodecSelectListener) {
        this.mOnMediaCodecSelectListener = onMediaCodecSelectListener;
    }

    public void setOnNativeInvokeListener(tv.danmaku.ijk.media.player.IjkMediaPlayer.OnNativeInvokeListener onNativeInvokeListener) {
        this.mOnNativeInvokeListener = onNativeInvokeListener;
    }

    public void setOption(int i, java.lang.String str, long j) {
        _setOption(i, str, j);
    }

    public void setOption(int i, java.lang.String str, java.lang.String str2) {
        _setOption(i, str, str2);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setScreenOnWhilePlaying(boolean z) {
        if (this.mScreenOnWhilePlaying != z) {
            if (z && this.mSurfaceHolder == null) {
                tv.danmaku.ijk.media.player.pragma.DebugLog.w(TAG, "setScreenOnWhilePlaying(true) is ineffective without a SurfaceHolder");
            }
            this.mScreenOnWhilePlaying = z;
            updateSurfaceScreenOn();
        }
    }

    public void setSpeed(float f) {
        _setPropertyFloat(10003, f);
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void setSurface(android.view.Surface surface) {
        if (this.mScreenOnWhilePlaying && surface != null) {
            tv.danmaku.ijk.media.player.pragma.DebugLog.w(TAG, "setScreenOnWhilePlaying(true) is ineffective for Surface");
        }
        this.mSurfaceHolder = null;
        _setVideoSurface(surface);
        updateSurfaceScreenOn();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public native void setVolume(float f, float f2);

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    @android.annotation.SuppressLint({"Wakelock"})
    public void setWakeMode(android.content.Context context, int i) {
        boolean z;
        android.os.PowerManager.WakeLock wakeLock = this.mWakeLock;
        if (wakeLock != null) {
            if (wakeLock.isHeld()) {
                this.mWakeLock.release();
                z = true;
            } else {
                z = false;
            }
            this.mWakeLock = null;
        } else {
            z = false;
        }
        android.os.PowerManager.WakeLock newWakeLock = ((android.os.PowerManager) context.getSystemService("power")).newWakeLock(i | 536870912, tv.danmaku.ijk.media.player.IjkMediaPlayer.class.getName());
        this.mWakeLock = newWakeLock;
        newWakeLock.setReferenceCounted(false);
        if (z) {
            this.mWakeLock.acquire();
        }
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void start() throws java.lang.IllegalStateException {
        stayAwake(true);
        _start();
    }

    @Override // tv.danmaku.ijk.media.player.IMediaPlayer
    public void stop() throws java.lang.IllegalStateException {
        stayAwake(false);
        _stop();
    }
}
