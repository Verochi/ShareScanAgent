package com.sensorsdata.analytics.android.sdk.visual.view;

/* loaded from: classes19.dex */
public class VisualDialog {

    /* renamed from: com.sensorsdata.analytics.android.sdk.visual.view.VisualDialog$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.content.DialogInterface.OnClickListener {
        final /* synthetic */ android.app.Activity val$context;

        public AnonymousClass1(android.app.Activity activity) {
            this.val$context = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.startLaunchActivity(this.val$context);
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.visual.view.VisualDialog$2, reason: invalid class name */
    public static class AnonymousClass2 implements android.content.DialogInterface.OnClickListener {
        final /* synthetic */ android.app.Activity val$context;
        final /* synthetic */ java.lang.String val$featureCode;
        final /* synthetic */ java.lang.String val$postUrl;

        public AnonymousClass2(android.app.Activity activity, java.lang.String str, java.lang.String str2) {
            this.val$context = activity;
            this.val$featureCode = str;
            this.val$postUrl = str2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            com.sensorsdata.analytics.android.sdk.visual.HeatMapService.getInstance().start(this.val$context, this.val$featureCode, this.val$postUrl);
            com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.startLaunchActivity(this.val$context);
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.visual.view.VisualDialog$3, reason: invalid class name */
    public static class AnonymousClass3 implements android.content.DialogInterface.OnClickListener {
        final /* synthetic */ android.app.Activity val$context;

        public AnonymousClass3(android.app.Activity activity) {
            this.val$context = activity;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.startLaunchActivity(this.val$context);
        }
    }

    /* renamed from: com.sensorsdata.analytics.android.sdk.visual.view.VisualDialog$4, reason: invalid class name */
    public static class AnonymousClass4 implements android.content.DialogInterface.OnClickListener {
        final /* synthetic */ android.app.Activity val$context;
        final /* synthetic */ java.lang.String val$featureCode;
        final /* synthetic */ java.lang.String val$postUrl;

        public AnonymousClass4(android.app.Activity activity, java.lang.String str, java.lang.String str2) {
            this.val$context = activity;
            this.val$featureCode = str;
            this.val$postUrl = str2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            com.sensorsdata.analytics.android.sdk.visual.VisualizedAutoTrackService.getInstance().start(this.val$context, this.val$featureCode, this.val$postUrl);
            com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.startLaunchActivity(this.val$context);
        }
    }

    public static void showOpenHeatMapDialog(android.app.Activity activity, java.lang.String str, java.lang.String str2) {
        boolean z;
        try {
            z = "WIFI".equals(com.sensorsdata.analytics.android.sdk.util.NetworkUtils.networkType(activity));
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
            z = false;
        }
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);
        builder.setTitle(com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_common_title));
        if (z) {
            builder.setMessage(com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.android.sdk.visual.R.string.sensors_analytics_heatmap_wifi_name));
        } else {
            builder.setMessage(com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.android.sdk.visual.R.string.sensors_analytics_heatmap_mobile_name));
        }
        builder.setCancelable(false);
        builder.setNegativeButton(com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_common_cancel), new com.sensorsdata.analytics.android.sdk.visual.view.VisualDialog.AnonymousClass1(activity));
        builder.setPositiveButton(com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_common_continue), new com.sensorsdata.analytics.android.sdk.visual.view.VisualDialog.AnonymousClass2(activity, str, str2));
        android.app.AlertDialog create = builder.create();
        com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.dialogShowDismissOld(create);
        try {
            create.getButton(-2).setTextColor(androidx.core.view.ViewCompat.MEASURED_STATE_MASK);
            create.getButton(-2).setBackgroundColor(-1);
            create.getButton(-1).setTextColor(androidx.core.internal.view.SupportMenu.CATEGORY_MASK);
            create.getButton(-1).setBackgroundColor(-1);
            create.getButton(-2).setBackground(com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.getDrawable());
            create.getButton(-1).setBackground(com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.getDrawable());
        } catch (java.lang.Exception e2) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e2);
        }
    }

    public static void showOpenVisualizedAutoTrackDialog(android.app.Activity activity, java.lang.String str, java.lang.String str2) {
        boolean z;
        try {
            z = "WIFI".equals(com.sensorsdata.analytics.android.sdk.util.NetworkUtils.networkType(activity));
        } catch (java.lang.Exception unused) {
            z = false;
        }
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);
        builder.setTitle(com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_common_title));
        if (z) {
            builder.setMessage(com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.android.sdk.visual.R.string.sensors_analytics_visual_wifi_name));
        } else {
            builder.setMessage(com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.android.sdk.visual.R.string.sensors_analytics_visual_mobile_name));
        }
        builder.setCancelable(false);
        builder.setNegativeButton(com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_common_cancel), new com.sensorsdata.analytics.android.sdk.visual.view.VisualDialog.AnonymousClass3(activity));
        builder.setPositiveButton(com.sensorsdata.analytics.android.sdk.util.SADisplayUtil.getStringResource(activity, com.sensorsdata.analytics.android.sdk.R.string.sensors_analytics_common_continue), new com.sensorsdata.analytics.android.sdk.visual.view.VisualDialog.AnonymousClass4(activity, str, str2));
        android.app.AlertDialog create = builder.create();
        com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.dialogShowDismissOld(create);
        try {
            create.getButton(-2).setTextColor(androidx.core.view.ViewCompat.MEASURED_STATE_MASK);
            create.getButton(-2).setBackgroundColor(-1);
            create.getButton(-1).setTextColor(androidx.core.internal.view.SupportMenu.CATEGORY_MASK);
            create.getButton(-1).setBackgroundColor(-1);
            create.getButton(-2).setBackground(com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.getDrawable());
            create.getButton(-1).setBackground(com.sensorsdata.analytics.android.sdk.dialog.SensorsDataDialogUtils.getDrawable());
        } catch (java.lang.Exception e) {
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(e);
        }
    }
}
