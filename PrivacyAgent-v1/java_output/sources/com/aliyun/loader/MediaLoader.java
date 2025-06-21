package com.aliyun.loader;

/* loaded from: classes.dex */
public class MediaLoader {
    public static final int OLD_CODE_EADDED = -300;
    public static final int OLD_CODE_ENOT_ENABLE = -301;
    private static final java.lang.String TAG;
    private static android.os.Handler mMainHandler;
    private static com.aliyun.loader.MediaLoader sInstance;
    private com.aliyun.loader.MediaLoader.OnLoadStatusListener onLoadStatusListener = null;

    /* renamed from: com.aliyun.loader.MediaLoader$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ int val$code;
        final /* synthetic */ java.lang.String val$msg;
        final /* synthetic */ java.lang.String val$url;

        public AnonymousClass1(java.lang.String str, int i, java.lang.String str2) {
            this.val$url = str;
            this.val$code = i;
            this.val$msg = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.loader.MediaLoader.getInstance().onLoadStatusListener != null) {
                com.aliyun.loader.MediaLoader.getInstance().onLoadStatusListener.onError(this.val$url, this.val$code, this.val$msg);
            }
            if (this.val$code != -300) {
                com.aliyun.loader.MediaLoader.getInstance().cancel(this.val$url);
            }
        }
    }

    /* renamed from: com.aliyun.loader.MediaLoader$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ int val$code;
        final /* synthetic */ com.aliyun.player.bean.ErrorCode val$finalErrorCode;
        final /* synthetic */ java.lang.String val$msg;
        final /* synthetic */ java.lang.String val$url;

        public AnonymousClass2(com.aliyun.player.bean.ErrorCode errorCode, java.lang.String str, java.lang.String str2, int i) {
            this.val$finalErrorCode = errorCode;
            this.val$msg = str;
            this.val$url = str2;
            this.val$code = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.loader.MediaLoader.getInstance().onLoadStatusListener != null) {
                com.aliyun.player.bean.ErrorInfo errorInfo = new com.aliyun.player.bean.ErrorInfo();
                errorInfo.setCode(this.val$finalErrorCode);
                errorInfo.setMsg(this.val$msg);
                com.aliyun.loader.MediaLoader.getInstance().onLoadStatusListener.onErrorV2(this.val$url, errorInfo);
            }
            if (this.val$code != com.aliyun.player.bean.ErrorCode.MEDIALOADER_ERROR_ADDED.getValue()) {
                com.aliyun.loader.MediaLoader.getInstance().cancel(this.val$url);
            }
        }
    }

    /* renamed from: com.aliyun.loader.MediaLoader$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$url;

        public AnonymousClass3(java.lang.String str) {
            this.val$url = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.loader.MediaLoader.getInstance().onLoadStatusListener != null) {
                com.aliyun.loader.MediaLoader.getInstance().onLoadStatusListener.onCompleted(this.val$url);
                com.aliyun.loader.MediaLoader.getInstance().cancel(this.val$url);
            }
        }
    }

    /* renamed from: com.aliyun.loader.MediaLoader$4, reason: invalid class name */
    public class AnonymousClass4 implements java.lang.Runnable {
        final /* synthetic */ java.lang.String val$url;

        public AnonymousClass4(java.lang.String str) {
            this.val$url = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.aliyun.loader.MediaLoader.getInstance().onLoadStatusListener != null) {
                com.aliyun.loader.MediaLoader.getInstance().onLoadStatusListener.onCanceled(this.val$url);
            }
        }
    }

    public interface OnLoadStatusListener {
        void onCanceled(java.lang.String str);

        void onCompleted(java.lang.String str);

        @java.lang.Deprecated
        void onError(java.lang.String str, int i, java.lang.String str2);

        void onErrorV2(java.lang.String str, com.aliyun.player.bean.ErrorInfo errorInfo);
    }

    static {
        com.aliyun.utils.f.f();
        TAG = com.aliyun.loader.MediaLoader.class.getSimpleName();
        sInstance = null;
        mMainHandler = new android.os.Handler(android.os.Looper.getMainLooper());
    }

    private MediaLoader() {
    }

    public static com.aliyun.loader.MediaLoader getInstance() {
        if (sInstance == null) {
            synchronized (com.aliyun.loader.MediaLoader.class) {
                if (sInstance == null) {
                    sInstance = new com.aliyun.loader.MediaLoader();
                }
            }
        }
        return sInstance;
    }

    public static void loadClass() {
    }

    private static native void nCancel(java.lang.String str);

    private static native void nCancelAll();

    private static native void nLoad(java.lang.String str, long j, int i);

    @com.cicada.player.utils.NativeUsed
    private static void nOnCanceled(java.lang.String str) {
        mMainHandler.post(new com.aliyun.loader.MediaLoader.AnonymousClass4(str));
    }

    @com.cicada.player.utils.NativeUsed
    private static void nOnCompleted(java.lang.String str) {
        mMainHandler.post(new com.aliyun.loader.MediaLoader.AnonymousClass3(str));
    }

    @com.cicada.player.utils.NativeUsed
    private static void nOnError(java.lang.String str, int i, java.lang.String str2) {
        mMainHandler.post(new com.aliyun.loader.MediaLoader.AnonymousClass1(str, i, str2));
    }

    @com.cicada.player.utils.NativeUsed
    private static void nOnErrorV2(java.lang.String str, int i, java.lang.String str2) {
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
        mMainHandler.post(new com.aliyun.loader.MediaLoader.AnonymousClass2(errorCode, str2, str, i));
    }

    private static native void nPause(boolean z, java.lang.String str);

    public void cancel(java.lang.String str) {
        if (com.aliyun.utils.f.b()) {
            if (android.text.TextUtils.isEmpty(str)) {
                nCancelAll();
            } else {
                nCancel(str);
            }
        }
    }

    public void load(java.lang.String str, long j) {
        if (!com.aliyun.utils.f.b()) {
            com.aliyun.utils.f.f();
        } else {
            if (android.text.TextUtils.isEmpty(str)) {
                return;
            }
            nLoad(str, j, 0);
        }
    }

    public void load(java.lang.String str, long j, int i) {
        if (com.aliyun.utils.f.b() && !android.text.TextUtils.isEmpty(str)) {
            nLoad(str, j, i);
        }
    }

    public void pause(java.lang.String str) {
        if (com.aliyun.utils.f.b()) {
            nPause(true, str);
        }
    }

    public void resume(java.lang.String str) {
        if (com.aliyun.utils.f.b()) {
            nPause(false, str);
        }
    }

    public void setOnLoadStatusListener(com.aliyun.loader.MediaLoader.OnLoadStatusListener onLoadStatusListener) {
        this.onLoadStatusListener = onLoadStatusListener;
    }
}
