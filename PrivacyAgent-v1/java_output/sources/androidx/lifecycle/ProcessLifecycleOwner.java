package androidx.lifecycle;

/* loaded from: classes.dex */
public class ProcessLifecycleOwner implements androidx.lifecycle.LifecycleOwner {

    @androidx.annotation.VisibleForTesting
    static final long TIMEOUT_MS = 700;
    private static final androidx.lifecycle.ProcessLifecycleOwner sInstance = new androidx.lifecycle.ProcessLifecycleOwner();
    private android.os.Handler mHandler;
    private int mStartedCounter = 0;
    private int mResumedCounter = 0;
    private boolean mPauseSent = true;
    private boolean mStopSent = true;
    private final androidx.lifecycle.LifecycleRegistry mRegistry = new androidx.lifecycle.LifecycleRegistry(this);
    private java.lang.Runnable mDelayedPauseRunnable = new androidx.lifecycle.ProcessLifecycleOwner.AnonymousClass1();
    androidx.lifecycle.ReportFragment.ActivityInitializationListener mInitializationListener = new androidx.lifecycle.ProcessLifecycleOwner.AnonymousClass2();

    /* renamed from: androidx.lifecycle.ProcessLifecycleOwner$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.lifecycle.ProcessLifecycleOwner.this.dispatchPauseIfNeeded();
            androidx.lifecycle.ProcessLifecycleOwner.this.dispatchStopIfNeeded();
        }
    }

    /* renamed from: androidx.lifecycle.ProcessLifecycleOwner$2, reason: invalid class name */
    public class AnonymousClass2 implements androidx.lifecycle.ReportFragment.ActivityInitializationListener {
        public AnonymousClass2() {
        }

        @Override // androidx.lifecycle.ReportFragment.ActivityInitializationListener
        public void onCreate() {
        }

        @Override // androidx.lifecycle.ReportFragment.ActivityInitializationListener
        public void onResume() {
            androidx.lifecycle.ProcessLifecycleOwner.this.activityResumed();
        }

        @Override // androidx.lifecycle.ReportFragment.ActivityInitializationListener
        public void onStart() {
            androidx.lifecycle.ProcessLifecycleOwner.this.activityStarted();
        }
    }

    /* renamed from: androidx.lifecycle.ProcessLifecycleOwner$3, reason: invalid class name */
    public class AnonymousClass3 extends androidx.lifecycle.EmptyActivityLifecycleCallbacks {

        /* renamed from: androidx.lifecycle.ProcessLifecycleOwner$3$1, reason: invalid class name */
        public class AnonymousClass1 extends androidx.lifecycle.EmptyActivityLifecycleCallbacks {
            public AnonymousClass1() {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostResumed(@androidx.annotation.NonNull android.app.Activity activity) {
                androidx.lifecycle.ProcessLifecycleOwner.this.activityResumed();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostStarted(@androidx.annotation.NonNull android.app.Activity activity) {
                androidx.lifecycle.ProcessLifecycleOwner.this.activityStarted();
            }
        }

        public AnonymousClass3() {
        }

        @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
            if (android.os.Build.VERSION.SDK_INT < 29) {
                androidx.lifecycle.ReportFragment.get(activity).setProcessListener(androidx.lifecycle.ProcessLifecycleOwner.this.mInitializationListener);
            }
        }

        @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(android.app.Activity activity) {
            androidx.lifecycle.ProcessLifecycleOwner.this.activityPaused();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        @androidx.annotation.RequiresApi(29)
        public void onActivityPreCreated(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.Nullable android.os.Bundle bundle) {
            activity.registerActivityLifecycleCallbacks(new androidx.lifecycle.ProcessLifecycleOwner.AnonymousClass3.AnonymousClass1());
        }

        @Override // androidx.lifecycle.EmptyActivityLifecycleCallbacks, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(android.app.Activity activity) {
            androidx.lifecycle.ProcessLifecycleOwner.this.activityStopped();
        }
    }

    private ProcessLifecycleOwner() {
    }

    @androidx.annotation.NonNull
    public static androidx.lifecycle.LifecycleOwner get() {
        return sInstance;
    }

    public static void init(android.content.Context context) {
        sInstance.attach(context);
    }

    public void activityPaused() {
        int i = this.mResumedCounter - 1;
        this.mResumedCounter = i;
        if (i == 0) {
            this.mHandler.postDelayed(this.mDelayedPauseRunnable, TIMEOUT_MS);
        }
    }

    public void activityResumed() {
        int i = this.mResumedCounter + 1;
        this.mResumedCounter = i;
        if (i == 1) {
            if (!this.mPauseSent) {
                this.mHandler.removeCallbacks(this.mDelayedPauseRunnable);
            } else {
                this.mRegistry.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_RESUME);
                this.mPauseSent = false;
            }
        }
    }

    public void activityStarted() {
        int i = this.mStartedCounter + 1;
        this.mStartedCounter = i;
        if (i == 1 && this.mStopSent) {
            this.mRegistry.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_START);
            this.mStopSent = false;
        }
    }

    public void activityStopped() {
        this.mStartedCounter--;
        dispatchStopIfNeeded();
    }

    public void attach(android.content.Context context) {
        this.mHandler = new android.os.Handler();
        this.mRegistry.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_CREATE);
        ((android.app.Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new androidx.lifecycle.ProcessLifecycleOwner.AnonymousClass3());
    }

    public void dispatchPauseIfNeeded() {
        if (this.mResumedCounter == 0) {
            this.mPauseSent = true;
            this.mRegistry.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_PAUSE);
        }
    }

    public void dispatchStopIfNeeded() {
        if (this.mStartedCounter == 0 && this.mPauseSent) {
            this.mRegistry.handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event.ON_STOP);
            this.mStopSent = true;
        }
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @androidx.annotation.NonNull
    public androidx.lifecycle.Lifecycle getLifecycle() {
        return this.mRegistry;
    }
}
