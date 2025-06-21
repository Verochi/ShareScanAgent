package com.aliyun.svideo.common.utils;

/* loaded from: classes.dex */
public class PermissionUtils {
    private static final java.lang.String TAG = "com.aliyun.svideo.common.utils.PermissionUtils";
    public static final java.lang.String[] PERMISSION_STORAGE = {"android.permission.READ_EXTERNAL_STORAGE", com.anythink.china.common.d.b};
    public static final java.lang.String[] PERMISSION_CAMERA = {"android.permission.CAMERA", "android.permission.RECORD_AUDIO", "android.permission.READ_EXTERNAL_STORAGE", com.anythink.china.common.d.b};
    public static final int[] NO_PERMISSION_TIP = {com.aliyun.svideo.common.R.string.alivc_common_no_camera_permission, com.aliyun.svideo.common.R.string.alivc_common_no_record_bluetooth_permission, com.aliyun.svideo.common.R.string.alivc_common_no_record_audio_permission, com.aliyun.svideo.common.R.string.alivc_common_no_read_phone_state_permission, com.aliyun.svideo.common.R.string.alivc_common_no_write_external_storage_permission, com.aliyun.svideo.common.R.string.alivc_common_no_read_external_storage_permission};

    private static boolean checkPermission(android.content.Context context, java.lang.String str) {
        return android.os.Build.VERSION.SDK_INT < 23 || androidx.core.content.ContextCompat.checkSelfPermission(context, str) == 0;
    }

    public static boolean checkPermissionsGroup(android.content.Context context, java.lang.String[] strArr) {
        for (java.lang.String str : strArr) {
            if (!checkPermission(context, str)) {
                return false;
            }
        }
        return true;
    }

    @androidx.annotation.RequiresApi(api = 19)
    public static boolean checkXiaomi(android.content.Context context, java.lang.String[] strArr) {
        android.app.AppOpsManager appOpsManager = (android.app.AppOpsManager) context.getSystemService("appops");
        java.lang.String packageName = context.getPackageName();
        for (java.lang.String str : strArr) {
            if (appOpsManager.checkOp(str, android.os.Binder.getCallingUid(), packageName) == 1) {
                return false;
            }
        }
        return true;
    }

    public static void requestPermissions(android.app.Activity activity, java.lang.String[] strArr, int i) {
        if (checkPermissionsGroup(activity, strArr)) {
            return;
        }
        androidx.core.app.ActivityCompat.requestPermissions(activity, strArr, i);
    }

    public static void showNoPermissionTip(android.content.Context context, java.lang.String str) {
        com.aliyun.svideo.common.utils.ToastUtils.show(context, str, 1);
    }
}
