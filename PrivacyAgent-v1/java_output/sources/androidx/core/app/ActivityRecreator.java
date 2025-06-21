package androidx.core.app;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
final class ActivityRecreator {
    private static final java.lang.String LOG_TAG = "ActivityRecreator";
    protected static final java.lang.Class<?> activityThreadClass;
    private static final android.os.Handler mainHandler = new android.os.Handler(android.os.Looper.getMainLooper());
    protected static final java.lang.reflect.Field mainThreadField;
    protected static final java.lang.reflect.Method performStopActivity2ParamsMethod;
    protected static final java.lang.reflect.Method performStopActivity3ParamsMethod;
    protected static final java.lang.reflect.Method requestRelaunchActivityMethod;
    protected static final java.lang.reflect.Field tokenField;

    /* renamed from: androidx.core.app.ActivityRecreator$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ androidx.core.app.ActivityRecreator.LifecycleCheckCallbacks val$callbacks;
        final /* synthetic */ java.lang.Object val$token;

        public AnonymousClass1(androidx.core.app.ActivityRecreator.LifecycleCheckCallbacks lifecycleCheckCallbacks, java.lang.Object obj) {
            this.val$callbacks = lifecycleCheckCallbacks;
            this.val$token = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$callbacks.currentlyRecreatingToken = this.val$token;
        }
    }

    /* renamed from: androidx.core.app.ActivityRecreator$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ android.app.Application val$application;
        final /* synthetic */ androidx.core.app.ActivityRecreator.LifecycleCheckCallbacks val$callbacks;

        public AnonymousClass2(android.app.Application application, androidx.core.app.ActivityRecreator.LifecycleCheckCallbacks lifecycleCheckCallbacks) {
            this.val$application = application;
            this.val$callbacks = lifecycleCheckCallbacks;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$application.unregisterActivityLifecycleCallbacks(this.val$callbacks);
        }
    }

    /* renamed from: androidx.core.app.ActivityRecreator$3, reason: invalid class name */
    public class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ java.lang.Object val$activityThread;
        final /* synthetic */ java.lang.Object val$token;

        public AnonymousClass3(java.lang.Object obj, java.lang.Object obj2) {
            this.val$activityThread = obj;
            this.val$token = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                java.lang.reflect.Method method = androidx.core.app.ActivityRecreator.performStopActivity3ParamsMethod;
                if (method != null) {
                    method.invoke(this.val$activityThread, this.val$token, java.lang.Boolean.FALSE, "AppCompat recreation");
                } else {
                    androidx.core.app.ActivityRecreator.performStopActivity2ParamsMethod.invoke(this.val$activityThread, this.val$token, java.lang.Boolean.FALSE);
                }
            } catch (java.lang.RuntimeException e) {
                if (e.getClass() == java.lang.RuntimeException.class && e.getMessage() != null && e.getMessage().startsWith("Unable to stop")) {
                    throw e;
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static final class LifecycleCheckCallbacks implements android.app.Application.ActivityLifecycleCallbacks {
        java.lang.Object currentlyRecreatingToken;
        private android.app.Activity mActivity;
        private final int mRecreatingHashCode;
        private boolean mStarted = false;
        private boolean mDestroyed = false;
        private boolean mStopQueued = false;

        public LifecycleCheckCallbacks(@androidx.annotation.NonNull android.app.Activity activity) {
            this.mActivity = activity;
            this.mRecreatingHashCode = activity.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(android.app.Activity activity, android.os.Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(android.app.Activity activity) {
            if (this.mActivity == activity) {
                this.mActivity = null;
                this.mDestroyed = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(android.app.Activity activity) {
            if (!this.mDestroyed || this.mStopQueued || this.mStarted || !androidx.core.app.ActivityRecreator.queueOnStopIfNecessary(this.currentlyRecreatingToken, this.mRecreatingHashCode, activity)) {
                return;
            }
            this.mStopQueued = true;
            this.currentlyRecreatingToken = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(android.app.Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(android.app.Activity activity, android.os.Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(android.app.Activity activity) {
            if (this.mActivity == activity) {
                this.mStarted = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(android.app.Activity activity) {
        }
    }

    static {
        java.lang.Class<?> activityThreadClass2 = getActivityThreadClass();
        activityThreadClass = activityThreadClass2;
        mainThreadField = getMainThreadField();
        tokenField = getTokenField();
        performStopActivity3ParamsMethod = getPerformStopActivity3Params(activityThreadClass2);
        performStopActivity2ParamsMethod = getPerformStopActivity2Params(activityThreadClass2);
        requestRelaunchActivityMethod = getRequestRelaunchActivityMethod(activityThreadClass2);
    }

    private ActivityRecreator() {
    }

    private static java.lang.Class<?> getActivityThreadClass() {
        try {
            return java.lang.Class.forName("android.app.ActivityThread");
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private static java.lang.reflect.Field getMainThreadField() {
        try {
            java.lang.reflect.Field declaredField = android.app.Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private static java.lang.reflect.Method getPerformStopActivity2Params(java.lang.Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            java.lang.reflect.Method declaredMethod = cls.getDeclaredMethod("performStopActivity", android.os.IBinder.class, java.lang.Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private static java.lang.reflect.Method getPerformStopActivity3Params(java.lang.Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            java.lang.reflect.Method declaredMethod = cls.getDeclaredMethod("performStopActivity", android.os.IBinder.class, java.lang.Boolean.TYPE, java.lang.String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private static java.lang.reflect.Method getRequestRelaunchActivityMethod(java.lang.Class<?> cls) {
        if (needsRelaunchCall() && cls != null) {
            try {
                java.lang.Class<?> cls2 = java.lang.Boolean.TYPE;
                java.lang.reflect.Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", android.os.IBinder.class, java.util.List.class, java.util.List.class, java.lang.Integer.TYPE, cls2, android.content.res.Configuration.class, android.content.res.Configuration.class, cls2, cls2);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (java.lang.Throwable unused) {
            }
        }
        return null;
    }

    private static java.lang.reflect.Field getTokenField() {
        try {
            java.lang.reflect.Field declaredField = android.app.Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    private static boolean needsRelaunchCall() {
        int i = android.os.Build.VERSION.SDK_INT;
        return i == 26 || i == 27;
    }

    public static boolean queueOnStopIfNecessary(java.lang.Object obj, int i, android.app.Activity activity) {
        try {
            java.lang.Object obj2 = tokenField.get(activity);
            if (obj2 == obj && activity.hashCode() == i) {
                mainHandler.postAtFrontOfQueue(new androidx.core.app.ActivityRecreator.AnonymousClass3(mainThreadField.get(activity), obj2));
                return true;
            }
        } catch (java.lang.Throwable unused) {
        }
        return false;
    }

    public static boolean recreate(@androidx.annotation.NonNull android.app.Activity activity) {
        java.lang.Object obj;
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        }
        if (needsRelaunchCall() && requestRelaunchActivityMethod == null) {
            return false;
        }
        if (performStopActivity2ParamsMethod == null && performStopActivity3ParamsMethod == null) {
            return false;
        }
        try {
            java.lang.Object obj2 = tokenField.get(activity);
            if (obj2 == null || (obj = mainThreadField.get(activity)) == null) {
                return false;
            }
            android.app.Application application = activity.getApplication();
            androidx.core.app.ActivityRecreator.LifecycleCheckCallbacks lifecycleCheckCallbacks = new androidx.core.app.ActivityRecreator.LifecycleCheckCallbacks(activity);
            application.registerActivityLifecycleCallbacks(lifecycleCheckCallbacks);
            android.os.Handler handler = mainHandler;
            handler.post(new androidx.core.app.ActivityRecreator.AnonymousClass1(lifecycleCheckCallbacks, obj2));
            try {
                if (needsRelaunchCall()) {
                    java.lang.reflect.Method method = requestRelaunchActivityMethod;
                    java.lang.Boolean bool = java.lang.Boolean.FALSE;
                    method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                } else {
                    activity.recreate();
                }
                handler.post(new androidx.core.app.ActivityRecreator.AnonymousClass2(application, lifecycleCheckCallbacks));
                return true;
            } catch (java.lang.Throwable th) {
                mainHandler.post(new androidx.core.app.ActivityRecreator.AnonymousClass2(application, lifecycleCheckCallbacks));
                throw th;
            }
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }
}
