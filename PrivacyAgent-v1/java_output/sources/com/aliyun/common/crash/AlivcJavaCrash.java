package com.aliyun.common.crash;

@com.aliyun.aio.keep.CalledByNative
/* loaded from: classes.dex */
public class AlivcJavaCrash {
    private static final java.lang.String TAG = "AlivcJavaCrash";
    private java.lang.ref.WeakReference<android.content.Context> mContextRef;
    private com.aliyun.common.crash.a mExceptHandler;
    private volatile boolean mIsRegister = false;
    private com.aliyun.common.crash.b mLifeTracker;

    public static native void nativeForegroundChange(boolean z);

    public static native void nativeOnCrashCallback(int i, long j, java.lang.String str, java.lang.String str2);

    public void active() {
        com.aliyun.common.crash.a aVar;
        if (!this.mIsRegister || (aVar = this.mExceptHandler) == null) {
            return;
        }
        aVar.a();
    }

    public void inactive() {
        com.aliyun.common.crash.a aVar;
        if (!this.mIsRegister || (aVar = this.mExceptHandler) == null) {
            return;
        }
        aVar.b();
    }

    public void register(android.content.Context context) {
        if (this.mIsRegister) {
            return;
        }
        this.mIsRegister = true;
        this.mExceptHandler = new com.aliyun.common.crash.a();
        if (context != null) {
            this.mLifeTracker = new com.aliyun.common.crash.b();
            if (!(context instanceof android.app.Application)) {
                context = context.getApplicationContext();
            }
            android.app.Application application = (android.app.Application) context;
            this.mContextRef = new java.lang.ref.WeakReference<>(application);
            application.registerActivityLifecycleCallbacks(this.mLifeTracker);
            application.registerComponentCallbacks(this.mLifeTracker);
        }
    }

    public void unRegister() {
    }
}
