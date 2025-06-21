package com.aliyun.loader;

/* loaded from: classes.dex */
public class VodMediaLoader {
    private static final java.lang.String TAG;
    private static android.os.Handler mMainHandler;
    private static com.aliyun.loader.VodMediaLoader sInstance;
    private com.aliyun.loader.VodMediaLoader.OnLoadStatusListener onLoadStatusListener = null;

    /* renamed from: com.aliyun.loader.VodMediaLoader$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object val$object;

        public AnonymousClass1(java.lang.Object obj) {
            this.val$object = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.loader.VodMediaLoader.getInstance().onLoadStatusListener != null) {
                com.aliyun.loader.VodMediaLoader.getInstance().onLoadStatusListener.onPrepared((com.aliyun.player.nativeclass.MediaInfo) this.val$object);
            }
        }
    }

    /* renamed from: com.aliyun.loader.VodMediaLoader$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ int val$code;
        final /* synthetic */ int val$index;
        final /* synthetic */ java.lang.String val$msg;
        final /* synthetic */ java.lang.String val$vid;

        public AnonymousClass2(java.lang.String str, int i, int i2, java.lang.String str2) {
            this.val$vid = str;
            this.val$index = i;
            this.val$code = i2;
            this.val$msg = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.loader.VodMediaLoader.getInstance().onLoadStatusListener != null) {
                com.aliyun.loader.VodMediaLoader.getInstance().onLoadStatusListener.onError(this.val$vid, this.val$index, this.val$code, this.val$msg);
            }
        }
    }

    /* renamed from: com.aliyun.loader.VodMediaLoader$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ com.aliyun.player.bean.ErrorCode val$finalErrorCode;
        final /* synthetic */ int val$index;
        final /* synthetic */ java.lang.String val$msg;
        final /* synthetic */ java.lang.String val$vid;

        public AnonymousClass3(com.aliyun.player.bean.ErrorCode errorCode, java.lang.String str, java.lang.String str2, int i) {
            this.val$finalErrorCode = errorCode;
            this.val$msg = str;
            this.val$vid = str2;
            this.val$index = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.loader.VodMediaLoader.getInstance().onLoadStatusListener != null) {
                com.aliyun.player.bean.ErrorInfo errorInfo = new com.aliyun.player.bean.ErrorInfo();
                errorInfo.setCode(this.val$finalErrorCode);
                errorInfo.setMsg(this.val$msg);
                com.aliyun.loader.VodMediaLoader.getInstance().onLoadStatusListener.onErrorV2(this.val$vid, this.val$index, errorInfo);
                com.aliyun.loader.MediaLoader.getInstance().cancel(this.val$vid);
            }
        }
    }

    /* renamed from: com.aliyun.loader.VodMediaLoader$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ int val$index;
        final /* synthetic */ java.lang.String val$vid;

        public AnonymousClass4(java.lang.String str, int i) {
            this.val$vid = str;
            this.val$index = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.loader.VodMediaLoader.getInstance().onLoadStatusListener != null) {
                com.aliyun.loader.VodMediaLoader.getInstance().onLoadStatusListener.onCompleted(this.val$vid, this.val$index);
            }
        }
    }

    /* renamed from: com.aliyun.loader.VodMediaLoader$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Runnable {
        final /* synthetic */ int val$index;
        final /* synthetic */ java.lang.String val$vid;

        public AnonymousClass5(java.lang.String str, int i) {
            this.val$vid = str;
            this.val$index = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.loader.VodMediaLoader.getInstance().onLoadStatusListener != null) {
                com.aliyun.loader.VodMediaLoader.getInstance().onLoadStatusListener.onCanceled(this.val$vid, this.val$index);
            }
        }
    }

    public interface OnLoadStatusListener {
        void onCanceled(java.lang.String str, int i);

        void onCompleted(java.lang.String str, int i);

        void onError(java.lang.String str, int i, int i2, java.lang.String str2);

        void onErrorV2(java.lang.String str, int i, com.aliyun.player.bean.ErrorInfo errorInfo);

        void onPrepared(com.aliyun.player.nativeclass.MediaInfo mediaInfo);
    }

    static {
        com.aliyun.utils.f.f();
        TAG = com.aliyun.loader.MediaLoader.class.getSimpleName();
        sInstance = null;
        mMainHandler = new android.os.Handler(android.os.Looper.getMainLooper());
    }

    private VodMediaLoader() {
    }

    public static com.aliyun.loader.VodMediaLoader getInstance() {
        if (sInstance == null) {
            synchronized (com.aliyun.loader.MediaLoader.class) {
                if (sInstance == null) {
                    sInstance = new com.aliyun.loader.VodMediaLoader();
                }
            }
        }
        return sInstance;
    }

    public static void loadClass() {
    }

    private static native void nCancel(java.lang.String str, int i);

    private static native void nLoad(java.lang.String str, int i, long j);

    @com.cicada.player.utils.NativeUsed
    private static void nOnCanceled(java.lang.String str, int i) {
        mMainHandler.post(new com.aliyun.loader.VodMediaLoader.AnonymousClass5(str, i));
    }

    @com.cicada.player.utils.NativeUsed
    private static void nOnCompleted(java.lang.String str, int i) {
        mMainHandler.post(new com.aliyun.loader.VodMediaLoader.AnonymousClass4(str, i));
    }

    @com.cicada.player.utils.NativeUsed
    private static void nOnError(java.lang.String str, int i, int i2, java.lang.String str2) {
        mMainHandler.post(new com.aliyun.loader.VodMediaLoader.AnonymousClass2(str, i, i2, str2));
    }

    @com.cicada.player.utils.NativeUsed
    private static void nOnErrorV2(java.lang.String str, int i, int i2, java.lang.String str2) {
        com.aliyun.player.bean.ErrorCode errorCode = com.aliyun.player.bean.ErrorCode.ERROR_UNKNOWN;
        com.aliyun.player.bean.ErrorCode[] values = com.aliyun.player.bean.ErrorCode.values();
        int length = values.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            com.aliyun.player.bean.ErrorCode errorCode2 = values[i3];
            if (errorCode2.getValue() == i2) {
                errorCode = errorCode2;
                break;
            }
            i3++;
        }
        mMainHandler.post(new com.aliyun.loader.VodMediaLoader.AnonymousClass3(errorCode, str2, str, i));
    }

    @com.cicada.player.utils.NativeUsed
    private static void nOnPrepared(java.lang.Object obj) {
        mMainHandler.post(new com.aliyun.loader.VodMediaLoader.AnonymousClass1(obj));
    }

    private static native void nPause(boolean z, java.lang.String str, int i);

    private static native void nPrepareAuth(java.lang.Object obj);

    private static native void nPrepareSts(java.lang.Object obj);

    private static native void nRemoveSource(java.lang.String str);

    public void cancel(java.lang.String str, int i) {
        if (com.aliyun.utils.f.b()) {
            nCancel(str, i);
        }
    }

    public void load(java.lang.String str, int i, long j) {
        if (!com.aliyun.utils.f.b()) {
            com.aliyun.utils.f.f();
        } else {
            if (android.text.TextUtils.isEmpty(str) || i < 0) {
                return;
            }
            nLoad(str, i, j);
        }
    }

    public void pause(java.lang.String str, int i) {
        if (com.aliyun.utils.f.b() && !android.text.TextUtils.isEmpty(str) && i >= 0) {
            nPause(true, str, i);
        }
    }

    public void prepareVidSource(com.aliyun.player.source.VidAuth vidAuth) {
        if (com.aliyun.utils.f.b()) {
            nPrepareAuth(vidAuth);
        }
    }

    public void prepareVidSource(com.aliyun.player.source.VidSts vidSts) {
        if (com.aliyun.utils.f.b()) {
            nPrepareSts(vidSts);
        }
    }

    public void removeVidSource(java.lang.String str) {
        if (com.aliyun.utils.f.b()) {
            nRemoveSource(str);
        }
    }

    public void resume(java.lang.String str, int i) {
        if (com.aliyun.utils.f.b() && !android.text.TextUtils.isEmpty(str) && i >= 0) {
            nPause(false, str, i);
        }
    }

    public void setOnLoadStatusListener(com.aliyun.loader.VodMediaLoader.OnLoadStatusListener onLoadStatusListener) {
        this.onLoadStatusListener = onLoadStatusListener;
    }
}
