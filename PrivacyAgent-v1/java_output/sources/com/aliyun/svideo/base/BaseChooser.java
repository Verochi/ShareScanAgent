package com.aliyun.svideo.base;

/* loaded from: classes.dex */
public class BaseChooser extends androidx.fragment.app.DialogFragment {
    private com.aliyun.svideo.base.BaseChooser.DialogVisibleListener dismissListener;

    public interface DialogVisibleListener {
        void onDialogDismiss();

        void onDialogShow();
    }

    private int getTECNOCF8NotchAndNaviHeight() {
        return android.os.Build.MODEL.toUpperCase().contains("TECNO CF8") ? 72 : 0;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(android.os.Bundle bundle) {
        super.onActivityCreated(bundle);
        android.view.Window window = getDialog().getWindow();
        if (window != null) {
            window.getAttributes().windowAnimations = com.aliyun.svideo.base.R.style.record_bottom_dialog_animation;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@androidx.annotation.Nullable android.os.Bundle bundle) {
        super.onCreate(bundle);
        setStyle(2, com.aliyun.svideo.base.R.style.QUDemoFullStyle);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(android.content.DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        com.aliyun.svideo.base.BaseChooser.DialogVisibleListener dialogVisibleListener = this.dismissListener;
        if (dialogVisibleListener != null) {
            dialogVisibleListener.onDialogDismiss();
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
        android.app.Dialog dialog = getDialog();
        window.setGravity(80);
        android.util.DisplayMetrics displayMetrics = new android.util.DisplayMetrics();
        window.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        android.view.WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.dimAmount = 0.0f;
        attributes.y = 100;
        window.setAttributes(attributes);
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(true);
            if (android.os.Build.MODEL.toUpperCase().contains("TECNO CF8")) {
                attributes.height = displayMetrics.heightPixels - getTECNOCF8NotchAndNaviHeight();
                dialog.getWindow().setLayout(displayMetrics.widthPixels, attributes.height);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void onViewCreated(android.view.View view, android.os.Bundle bundle) {
        super.onViewCreated(view, bundle);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public void setDismissListener(com.aliyun.svideo.base.BaseChooser.DialogVisibleListener dialogVisibleListener) {
        this.dismissListener = dialogVisibleListener;
    }

    @Override // androidx.fragment.app.Fragment
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        com.sensorsdata.analytics.android.autotrack.aop.FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z);
    }

    @Override // androidx.fragment.app.DialogFragment
    public int show(androidx.fragment.app.FragmentTransaction fragmentTransaction, java.lang.String str) {
        com.aliyun.svideo.base.BaseChooser.DialogVisibleListener dialogVisibleListener = this.dismissListener;
        if (dialogVisibleListener != null) {
            dialogVisibleListener.onDialogShow();
        }
        return super.show(fragmentTransaction, str);
    }

    @Override // androidx.fragment.app.DialogFragment
    public void show(androidx.fragment.app.FragmentManager fragmentManager, java.lang.String str) {
        if (isStateSaved()) {
            return;
        }
        super.show(fragmentManager, str);
        com.aliyun.svideo.base.BaseChooser.DialogVisibleListener dialogVisibleListener = this.dismissListener;
        if (dialogVisibleListener != null) {
            dialogVisibleListener.onDialogShow();
        }
    }
}
