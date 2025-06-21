package androidx.lifecycle;

/* loaded from: classes.dex */
public class LifecycleService extends android.app.Service implements androidx.lifecycle.LifecycleOwner {
    private final androidx.lifecycle.ServiceLifecycleDispatcher mDispatcher = new androidx.lifecycle.ServiceLifecycleDispatcher(this);

    @Override // androidx.lifecycle.LifecycleOwner
    @androidx.annotation.NonNull
    public androidx.lifecycle.Lifecycle getLifecycle() {
        return this.mDispatcher.getLifecycle();
    }

    @Override // android.app.Service
    @androidx.annotation.Nullable
    @androidx.annotation.CallSuper
    public android.os.IBinder onBind(@androidx.annotation.NonNull android.content.Intent intent) {
        this.mDispatcher.onServicePreSuperOnBind();
        return null;
    }

    @Override // android.app.Service
    @androidx.annotation.CallSuper
    public void onCreate() {
        this.mDispatcher.onServicePreSuperOnCreate();
        super.onCreate();
    }

    @Override // android.app.Service
    @androidx.annotation.CallSuper
    public void onDestroy() {
        this.mDispatcher.onServicePreSuperOnDestroy();
        super.onDestroy();
    }

    @Override // android.app.Service
    @androidx.annotation.CallSuper
    public void onStart(@androidx.annotation.Nullable android.content.Intent intent, int i) {
        this.mDispatcher.onServicePreSuperOnStart();
        super.onStart(intent, i);
    }

    @Override // android.app.Service
    @androidx.annotation.CallSuper
    public int onStartCommand(@androidx.annotation.Nullable android.content.Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }
}
