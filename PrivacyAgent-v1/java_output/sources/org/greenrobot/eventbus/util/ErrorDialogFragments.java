package org.greenrobot.eventbus.util;

/* loaded from: classes26.dex */
public class ErrorDialogFragments {
    public static int ERROR_DIALOG_ICON;
    public static java.lang.Class<?> EVENT_TYPE_ON_CLICK;

    @android.annotation.TargetApi(11)
    public static class Honeycomb extends android.app.DialogFragment implements android.content.DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            org.greenrobot.eventbus.util.ErrorDialogFragments.handleOnClick(dialogInterface, i, getActivity(), getArguments());
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i);
        }

        @Override // android.app.DialogFragment
        public android.app.Dialog onCreateDialog(android.os.Bundle bundle) {
            return org.greenrobot.eventbus.util.ErrorDialogFragments.createDialog(getActivity(), getArguments(), this);
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
            super.onPause();
            com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentPause(this);
        }

        @Override // android.app.Fragment
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onResume() {
            super.onResume();
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

    public static class Support extends androidx.fragment.app.DialogFragment implements android.content.DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            org.greenrobot.eventbus.util.ErrorDialogFragments.handleOnClick(dialogInterface, i, getActivity(), getArguments());
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i);
        }

        @Override // androidx.fragment.app.DialogFragment
        public android.app.Dialog onCreateDialog(android.os.Bundle bundle) {
            return org.greenrobot.eventbus.util.ErrorDialogFragments.createDialog(getActivity(), getArguments(), this);
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
            super.onPause();
            com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentPause(this);
        }

        @Override // androidx.fragment.app.Fragment
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onResume() {
            super.onResume();
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

    public static android.app.Dialog createDialog(android.content.Context context, android.os.Bundle bundle, android.content.DialogInterface.OnClickListener onClickListener) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setTitle(bundle.getString(org.greenrobot.eventbus.util.ErrorDialogManager.KEY_TITLE));
        builder.setMessage(bundle.getString(org.greenrobot.eventbus.util.ErrorDialogManager.KEY_MESSAGE));
        int i = ERROR_DIALOG_ICON;
        if (i != 0) {
            builder.setIcon(i);
        }
        builder.setPositiveButton(android.R.string.ok, onClickListener);
        return builder.create();
    }

    public static void handleOnClick(android.content.DialogInterface dialogInterface, int i, android.app.Activity activity, android.os.Bundle bundle) {
        java.lang.Class<?> cls = EVENT_TYPE_ON_CLICK;
        if (cls != null) {
            try {
                org.greenrobot.eventbus.util.ErrorDialogManager.factory.config.a().post(cls.newInstance());
            } catch (java.lang.Exception e) {
                throw new java.lang.RuntimeException("Event cannot be constructed", e);
            }
        }
        if (!bundle.getBoolean(org.greenrobot.eventbus.util.ErrorDialogManager.KEY_FINISH_AFTER_DIALOG, false) || activity == null) {
            return;
        }
        activity.finish();
    }
}
