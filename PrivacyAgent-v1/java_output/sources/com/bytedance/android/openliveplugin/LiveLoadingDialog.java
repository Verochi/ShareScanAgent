package com.bytedance.android.openliveplugin;

/* loaded from: classes.dex */
public class LiveLoadingDialog {
    private static android.app.Dialog loadingDialog;

    /* renamed from: com.bytedance.android.openliveplugin.LiveLoadingDialog$1, reason: invalid class name */
    class AnonymousClass1 implements android.view.View.OnClickListener {
        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.view.View view) {
            com.bytedance.android.openliveplugin.LiveLoadingDialog.loadingDialog.dismiss();
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static boolean dismiss() {
        android.app.Dialog dialog = loadingDialog;
        if (dialog == null || !dialog.isShowing()) {
            return false;
        }
        loadingDialog.dismiss();
        return true;
    }

    public static void show(android.app.Activity activity) {
        if (activity == null) {
            return;
        }
        android.app.Dialog dialog = loadingDialog;
        if (dialog != null) {
            if (dialog.isShowing()) {
                return;
            }
            loadingDialog.show();
            return;
        }
        float f = activity.getResources().getDisplayMetrics().density;
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);
        builder.setCancelable(true);
        android.view.View inflate = activity.getLayoutInflater().inflate(com.bytedance.sdk.openadsdk.R.layout.live_init_progress_dialog, (android.view.ViewGroup) null);
        inflate.findViewById(com.bytedance.sdk.openadsdk.R.id.live_progress_cancel).setOnClickListener(new com.bytedance.android.openliveplugin.LiveLoadingDialog.AnonymousClass1());
        builder.setView(inflate);
        android.app.AlertDialog create = builder.create();
        loadingDialog = create;
        if (create.getWindow() != null) {
            loadingDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            loadingDialog.getWindow().setDimAmount(0.0f);
            loadingDialog.show();
            loadingDialog.getWindow().setLayout(java.lang.Math.round(92.0f * f), java.lang.Math.round(f * 80.0f));
        }
    }
}
