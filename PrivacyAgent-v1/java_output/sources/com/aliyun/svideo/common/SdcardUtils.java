package com.aliyun.svideo.common;

/* loaded from: classes.dex */
public class SdcardUtils {
    private static final java.lang.String TAG = "SdcardUtils";

    /* renamed from: com.aliyun.svideo.common.SdcardUtils$1, reason: invalid class name */
    public class AnonymousClass1 implements android.content.DialogInterface.OnClickListener {
        @Override // android.content.DialogInterface.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public void onClick(android.content.DialogInterface dialogInterface, int i) {
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i);
        }
    }

    public static void checkAvailableSize(android.content.Context context, int i) {
        if (com.aliyun.svideo.common.utils.PermissionUtils.checkPermissionsGroup(context, com.aliyun.svideo.common.utils.PermissionUtils.PERMISSION_STORAGE)) {
            long sdcardAvailableSize = (com.aliyun.svideo.common.utils.FileUtils.getSdcardAvailableSize() / 1024) / 1024;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("log_common_SdcardUtils_availableSize : ");
            sb.append(sdcardAvailableSize);
            if (sdcardAvailableSize < i) {
                showAlertDialog(context);
            }
        }
    }

    private static void showAlertDialog(android.content.Context context) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setTitle(context.getResources().getString(com.aliyun.svideo.common.R.string.alivc_common_note));
        builder.setMessage(context.getResources().getString(com.aliyun.svideo.common.R.string.alivc_common_device_memory_not_enough));
        builder.setPositiveButton(context.getResources().getString(com.aliyun.svideo.common.R.string.alivc_common_confirm), new com.aliyun.svideo.common.SdcardUtils.AnonymousClass1());
        builder.setCancelable(false);
        builder.show();
    }
}
