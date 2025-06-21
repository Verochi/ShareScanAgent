package org.greenrobot.eventbus.util;

/* loaded from: classes26.dex */
public class ErrorDialogManager {
    public static final java.lang.String KEY_EVENT_TYPE_ON_CLOSE = "de.greenrobot.eventbus.errordialog.event_type_on_close";
    public static final java.lang.String KEY_FINISH_AFTER_DIALOG = "de.greenrobot.eventbus.errordialog.finish_after_dialog";
    public static final java.lang.String KEY_ICON_ID = "de.greenrobot.eventbus.errordialog.icon_id";
    public static final java.lang.String KEY_MESSAGE = "de.greenrobot.eventbus.errordialog.message";
    public static final java.lang.String KEY_TITLE = "de.greenrobot.eventbus.errordialog.title";
    protected static final java.lang.String TAG_ERROR_DIALOG = "de.greenrobot.eventbus.error_dialog";
    protected static final java.lang.String TAG_ERROR_DIALOG_MANAGER = "de.greenrobot.eventbus.error_dialog_manager";
    public static org.greenrobot.eventbus.util.ErrorDialogFragmentFactory<?> factory;

    @android.annotation.TargetApi(11)
    public static class HoneycombManagerFragment extends android.app.Fragment {
        protected android.os.Bundle argumentsForErrorDialog;
        protected boolean finishAfterDialog;
        public org.greenrobot.eventbus.EventBus n;
        public java.lang.Object t;

        public static void attachTo(android.app.Activity activity, java.lang.Object obj, boolean z, android.os.Bundle bundle) {
            android.app.FragmentManager fragmentManager = activity.getFragmentManager();
            org.greenrobot.eventbus.util.ErrorDialogManager.HoneycombManagerFragment honeycombManagerFragment = (org.greenrobot.eventbus.util.ErrorDialogManager.HoneycombManagerFragment) fragmentManager.findFragmentByTag(org.greenrobot.eventbus.util.ErrorDialogManager.TAG_ERROR_DIALOG_MANAGER);
            if (honeycombManagerFragment == null) {
                honeycombManagerFragment = new org.greenrobot.eventbus.util.ErrorDialogManager.HoneycombManagerFragment();
                fragmentManager.beginTransaction().add(honeycombManagerFragment, org.greenrobot.eventbus.util.ErrorDialogManager.TAG_ERROR_DIALOG_MANAGER).commit();
                fragmentManager.executePendingTransactions();
            }
            honeycombManagerFragment.finishAfterDialog = z;
            honeycombManagerFragment.argumentsForErrorDialog = bundle;
            honeycombManagerFragment.t = obj;
        }

        public void onEventMainThread(org.greenrobot.eventbus.util.ThrowableFailureEvent throwableFailureEvent) {
            if (org.greenrobot.eventbus.util.ErrorDialogManager.b(this.t, throwableFailureEvent)) {
                org.greenrobot.eventbus.util.ErrorDialogManager.checkLogException(throwableFailureEvent);
                android.app.FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.executePendingTransactions();
                android.app.DialogFragment dialogFragment = (android.app.DialogFragment) fragmentManager.findFragmentByTag(org.greenrobot.eventbus.util.ErrorDialogManager.TAG_ERROR_DIALOG);
                if (dialogFragment != null) {
                    dialogFragment.dismiss();
                }
                android.app.DialogFragment dialogFragment2 = (android.app.DialogFragment) org.greenrobot.eventbus.util.ErrorDialogManager.factory.prepareErrorFragment(throwableFailureEvent, this.finishAfterDialog, this.argumentsForErrorDialog);
                if (dialogFragment2 != null) {
                    dialogFragment2.show(fragmentManager, org.greenrobot.eventbus.util.ErrorDialogManager.TAG_ERROR_DIALOG);
                }
            }
        }

        @Override // android.app.Fragment
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onHiddenChanged(boolean z) {
            super.onHiddenChanged(z);
            com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackOnHiddenChanged(this, z);
        }

        @Override // android.app.Fragment
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onPause() {
            this.n.unregister(this);
            super.onPause();
            com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentPause(this);
        }

        @Override // android.app.Fragment
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onResume() {
            super.onResume();
            org.greenrobot.eventbus.EventBus a = org.greenrobot.eventbus.util.ErrorDialogManager.factory.config.a();
            this.n = a;
            a.register(this);
            com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentResume(this);
        }

        @Override // android.app.Fragment
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onViewCreated(android.view.View view, android.os.Bundle bundle) {
            super.onViewCreated(view, bundle);
            com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
        }

        @Override // android.app.Fragment
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void setUserVisibleHint(boolean z) {
            super.setUserVisibleHint(z);
            com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z);
        }
    }

    public static class SupportManagerFragment extends androidx.fragment.app.Fragment {
        protected android.os.Bundle argumentsForErrorDialog;
        protected boolean finishAfterDialog;
        public org.greenrobot.eventbus.EventBus t;
        public boolean u;
        public java.lang.Object v;

        public static void attachTo(android.app.Activity activity, java.lang.Object obj, boolean z, android.os.Bundle bundle) {
            androidx.fragment.app.FragmentManager supportFragmentManager = ((androidx.fragment.app.FragmentActivity) activity).getSupportFragmentManager();
            org.greenrobot.eventbus.util.ErrorDialogManager.SupportManagerFragment supportManagerFragment = (org.greenrobot.eventbus.util.ErrorDialogManager.SupportManagerFragment) supportFragmentManager.findFragmentByTag(org.greenrobot.eventbus.util.ErrorDialogManager.TAG_ERROR_DIALOG_MANAGER);
            if (supportManagerFragment == null) {
                supportManagerFragment = new org.greenrobot.eventbus.util.ErrorDialogManager.SupportManagerFragment();
                supportFragmentManager.beginTransaction().add(supportManagerFragment, org.greenrobot.eventbus.util.ErrorDialogManager.TAG_ERROR_DIALOG_MANAGER).commit();
                supportFragmentManager.executePendingTransactions();
            }
            supportManagerFragment.finishAfterDialog = z;
            supportManagerFragment.argumentsForErrorDialog = bundle;
            supportManagerFragment.v = obj;
        }

        @Override // androidx.fragment.app.Fragment
        public void onCreate(android.os.Bundle bundle) {
            super.onCreate(bundle);
            org.greenrobot.eventbus.EventBus a = org.greenrobot.eventbus.util.ErrorDialogManager.factory.config.a();
            this.t = a;
            a.register(this);
            this.u = true;
        }

        public void onEventMainThread(org.greenrobot.eventbus.util.ThrowableFailureEvent throwableFailureEvent) {
            if (org.greenrobot.eventbus.util.ErrorDialogManager.b(this.v, throwableFailureEvent)) {
                org.greenrobot.eventbus.util.ErrorDialogManager.checkLogException(throwableFailureEvent);
                androidx.fragment.app.FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.executePendingTransactions();
                androidx.fragment.app.DialogFragment dialogFragment = (androidx.fragment.app.DialogFragment) fragmentManager.findFragmentByTag(org.greenrobot.eventbus.util.ErrorDialogManager.TAG_ERROR_DIALOG);
                if (dialogFragment != null) {
                    dialogFragment.dismiss();
                }
                androidx.fragment.app.DialogFragment dialogFragment2 = (androidx.fragment.app.DialogFragment) org.greenrobot.eventbus.util.ErrorDialogManager.factory.prepareErrorFragment(throwableFailureEvent, this.finishAfterDialog, this.argumentsForErrorDialog);
                if (dialogFragment2 != null) {
                    dialogFragment2.show(fragmentManager, org.greenrobot.eventbus.util.ErrorDialogManager.TAG_ERROR_DIALOG);
                }
            }
        }

        @Override // androidx.fragment.app.Fragment
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onHiddenChanged(boolean z) {
            super.onHiddenChanged(z);
            com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackOnHiddenChanged(this, z);
        }

        @Override // androidx.fragment.app.Fragment
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onPause() {
            this.t.unregister(this);
            super.onPause();
            com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentPause(this);
        }

        @Override // androidx.fragment.app.Fragment
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onResume() {
            super.onResume();
            if (this.u) {
                this.u = false;
            } else {
                org.greenrobot.eventbus.EventBus a = org.greenrobot.eventbus.util.ErrorDialogManager.factory.config.a();
                this.t = a;
                a.register(this);
            }
            com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentResume(this);
        }

        @Override // androidx.fragment.app.Fragment
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onViewCreated(android.view.View view, android.os.Bundle bundle) {
            super.onViewCreated(view, bundle);
            com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
        }

        @Override // androidx.fragment.app.Fragment
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void setUserVisibleHint(boolean z) {
            super.setUserVisibleHint(z);
            com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z);
        }
    }

    public static void attachTo(android.app.Activity activity) {
        attachTo(activity, false, null);
    }

    public static void attachTo(android.app.Activity activity, java.lang.Object obj, boolean z, android.os.Bundle bundle) {
        if (factory == null) {
            throw new java.lang.RuntimeException("You must set the static factory field to configure error dialogs for your app.");
        }
        if (c(activity)) {
            org.greenrobot.eventbus.util.ErrorDialogManager.SupportManagerFragment.attachTo(activity, obj, z, bundle);
        } else {
            org.greenrobot.eventbus.util.ErrorDialogManager.HoneycombManagerFragment.attachTo(activity, obj, z, bundle);
        }
    }

    public static void attachTo(android.app.Activity activity, boolean z) {
        attachTo(activity, z, null);
    }

    public static void attachTo(android.app.Activity activity, boolean z, android.os.Bundle bundle) {
        attachTo(activity, activity.getClass(), z, bundle);
    }

    public static boolean b(java.lang.Object obj, org.greenrobot.eventbus.util.ThrowableFailureEvent throwableFailureEvent) {
        java.lang.Object executionScope;
        return throwableFailureEvent == null || (executionScope = throwableFailureEvent.getExecutionScope()) == null || executionScope.equals(obj);
    }

    public static boolean c(android.app.Activity activity) {
        java.lang.String name;
        java.lang.Class<?> cls = activity.getClass();
        do {
            cls = cls.getSuperclass();
            if (cls == null) {
                throw new java.lang.RuntimeException("Illegal activity type: " + activity.getClass());
            }
            name = cls.getName();
            if (name.equals("androidx.fragment.app.FragmentActivity")) {
                return true;
            }
            if (name.startsWith("com.actionbarsherlock.app") && (name.endsWith(".SherlockActivity") || name.endsWith(".SherlockListActivity") || name.endsWith(".SherlockPreferenceActivity"))) {
                throw new java.lang.RuntimeException("Please use SherlockFragmentActivity. Illegal activity: " + name);
            }
        } while (!name.equals("android.app.Activity"));
        return false;
    }

    public static void checkLogException(org.greenrobot.eventbus.util.ThrowableFailureEvent throwableFailureEvent) {
        org.greenrobot.eventbus.util.ErrorDialogConfig errorDialogConfig = factory.config;
        if (errorDialogConfig.f) {
            if (errorDialogConfig.g == null) {
                java.lang.String str = org.greenrobot.eventbus.EventBus.TAG;
            }
            java.lang.Throwable th = throwableFailureEvent.throwable;
        }
    }
}
