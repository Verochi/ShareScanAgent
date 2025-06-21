package androidx.lifecycle;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ReportFragment extends android.app.Fragment {
    private static final java.lang.String REPORT_FRAGMENT_TAG = "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag";
    private androidx.lifecycle.ReportFragment.ActivityInitializationListener mProcessListener;

    public interface ActivityInitializationListener {
        void onCreate();

        void onResume();

        void onStart();
    }

    @androidx.annotation.RequiresApi(29)
    public static class LifecycleCallbacks implements android.app.Application.ActivityLifecycleCallbacks {
        public static void registerIn(android.app.Activity activity) {
            activity.registerActivityLifecycleCallbacks(new androidx.lifecycle.ReportFragment.LifecycleCallbacks());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.Nullable android.os.Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(@androidx.annotation.NonNull android.app.Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(@androidx.annotation.NonNull android.app.Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostCreated(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.Nullable android.os.Bundle bundle) {
            androidx.lifecycle.ReportFragment.dispatch(activity, androidx.lifecycle.Lifecycle.Event.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(@androidx.annotation.NonNull android.app.Activity activity) {
            androidx.lifecycle.ReportFragment.dispatch(activity, androidx.lifecycle.Lifecycle.Event.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(@androidx.annotation.NonNull android.app.Activity activity) {
            androidx.lifecycle.ReportFragment.dispatch(activity, androidx.lifecycle.Lifecycle.Event.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(@androidx.annotation.NonNull android.app.Activity activity) {
            androidx.lifecycle.ReportFragment.dispatch(activity, androidx.lifecycle.Lifecycle.Event.ON_DESTROY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(@androidx.annotation.NonNull android.app.Activity activity) {
            androidx.lifecycle.ReportFragment.dispatch(activity, androidx.lifecycle.Lifecycle.Event.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(@androidx.annotation.NonNull android.app.Activity activity) {
            androidx.lifecycle.ReportFragment.dispatch(activity, androidx.lifecycle.Lifecycle.Event.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(@androidx.annotation.NonNull android.app.Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.NonNull android.os.Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(@androidx.annotation.NonNull android.app.Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(@androidx.annotation.NonNull android.app.Activity activity) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void dispatch(@androidx.annotation.NonNull android.app.Activity activity, @androidx.annotation.NonNull androidx.lifecycle.Lifecycle.Event event) {
        if (activity instanceof androidx.lifecycle.LifecycleRegistryOwner) {
            ((androidx.lifecycle.LifecycleRegistryOwner) activity).getLifecycle().handleLifecycleEvent(event);
        } else if (activity instanceof androidx.lifecycle.LifecycleOwner) {
            androidx.lifecycle.Lifecycle lifecycle = ((androidx.lifecycle.LifecycleOwner) activity).getLifecycle();
            if (lifecycle instanceof androidx.lifecycle.LifecycleRegistry) {
                ((androidx.lifecycle.LifecycleRegistry) lifecycle).handleLifecycleEvent(event);
            }
        }
    }

    private void dispatch(@androidx.annotation.NonNull androidx.lifecycle.Lifecycle.Event event) {
        if (android.os.Build.VERSION.SDK_INT < 29) {
            dispatch(getActivity(), event);
        }
    }

    private void dispatchCreate(androidx.lifecycle.ReportFragment.ActivityInitializationListener activityInitializationListener) {
        if (activityInitializationListener != null) {
            activityInitializationListener.onCreate();
        }
    }

    private void dispatchResume(androidx.lifecycle.ReportFragment.ActivityInitializationListener activityInitializationListener) {
        if (activityInitializationListener != null) {
            activityInitializationListener.onResume();
        }
    }

    private void dispatchStart(androidx.lifecycle.ReportFragment.ActivityInitializationListener activityInitializationListener) {
        if (activityInitializationListener != null) {
            activityInitializationListener.onStart();
        }
    }

    public static androidx.lifecycle.ReportFragment get(android.app.Activity activity) {
        return (androidx.lifecycle.ReportFragment) activity.getFragmentManager().findFragmentByTag(REPORT_FRAGMENT_TAG);
    }

    public static void injectIfNeededIn(android.app.Activity activity) {
        if (android.os.Build.VERSION.SDK_INT >= 29) {
            androidx.lifecycle.ReportFragment.LifecycleCallbacks.registerIn(activity);
        }
        android.app.FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag(REPORT_FRAGMENT_TAG) == null) {
            fragmentManager.beginTransaction().add(new androidx.lifecycle.ReportFragment(), REPORT_FRAGMENT_TAG).commit();
            fragmentManager.executePendingTransactions();
        }
    }

    @Override // android.app.Fragment
    public void onActivityCreated(android.os.Bundle bundle) {
        super.onActivityCreated(bundle);
        dispatchCreate(this.mProcessListener);
        dispatch(androidx.lifecycle.Lifecycle.Event.ON_CREATE);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        dispatch(androidx.lifecycle.Lifecycle.Event.ON_DESTROY);
        this.mProcessListener = null;
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        dispatch(androidx.lifecycle.Lifecycle.Event.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        dispatchResume(this.mProcessListener);
        dispatch(androidx.lifecycle.Lifecycle.Event.ON_RESUME);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        dispatchStart(this.mProcessListener);
        dispatch(androidx.lifecycle.Lifecycle.Event.ON_START);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        dispatch(androidx.lifecycle.Lifecycle.Event.ON_STOP);
    }

    public void setProcessListener(androidx.lifecycle.ReportFragment.ActivityInitializationListener activityInitializationListener) {
        this.mProcessListener = activityInitializationListener;
    }
}
