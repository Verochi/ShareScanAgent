package com.aliyun.svideo.common.base;

/* loaded from: classes.dex */
public abstract class BaseDialogFragment extends androidx.fragment.app.DialogFragment {
    private static final float DEFAULT_DIMAMOUNT = 0.2f;
    protected java.lang.String tag = getClass().getSimpleName();

    public static final int getScreenHeight(android.content.Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static final int getScreenWidth(android.content.Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public abstract void bindView(android.view.View view);

    public int getDialogAnimationRes() {
        return 0;
    }

    public int getDialogHeight() {
        return -2;
    }

    public int getDialogWidth() {
        return -1;
    }

    public float getDimAmount() {
        return 0.2f;
    }

    public java.lang.String getFragmentTag() {
        return this.tag;
    }

    public int getGravity() {
        return 80;
    }

    public abstract int getLayoutRes();

    public android.content.DialogInterface.OnKeyListener getOnKeyListener() {
        return null;
    }

    public boolean isCancelableOutside() {
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public android.view.View onCreateView(android.view.LayoutInflater layoutInflater, android.view.ViewGroup viewGroup, android.os.Bundle bundle) {
        getDialog().requestWindowFeature(1);
        android.view.View inflate = getLayoutRes() > 0 ? layoutInflater.inflate(getLayoutRes(), viewGroup, false) : null;
        bindView(inflate);
        return inflate;
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

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        android.view.Window window = getDialog().getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(0));
            android.view.WindowManager.LayoutParams attributes = window.getAttributes();
            if (getDialogWidth() > 0) {
                attributes.width = getDialogWidth();
            } else {
                attributes.width = -1;
            }
            if (getDialogHeight() > 0) {
                attributes.height = getDialogHeight();
            } else {
                attributes.height = -2;
            }
            attributes.dimAmount = getDimAmount();
            attributes.gravity = getGravity();
            window.setAttributes(attributes);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onViewCreated(android.view.View view, @androidx.annotation.Nullable android.os.Bundle bundle) {
        super.onViewCreated(view, bundle);
        android.app.Dialog dialog = getDialog();
        dialog.requestWindowFeature(1);
        dialog.setCanceledOnTouchOutside(isCancelableOutside());
        if (dialog.getWindow() != null && getDialogAnimationRes() > 0) {
            dialog.getWindow().setWindowAnimations(getDialogAnimationRes());
        }
        if (getOnKeyListener() != null) {
            dialog.setOnKeyListener(getOnKeyListener());
        }
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z);
    }

    public void show(androidx.fragment.app.FragmentManager fragmentManager) {
        show(fragmentManager, getFragmentTag());
    }
}
