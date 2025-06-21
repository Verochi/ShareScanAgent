package com.qq.e.comm;

/* loaded from: classes19.dex */
public class a {
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a2 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(android.content.Context context) {
        boolean z;
        boolean z2;
        android.content.Intent intent;
        java.lang.String str;
        try {
            java.lang.String[] strArr = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"};
            for (int i = 0; i < 2; i++) {
                try {
                    str = strArr[i];
                } catch (java.lang.Throwable th) {
                    com.qq.e.comm.util.GDTLogger.e("检查权限时发生异常", th);
                }
                if (context.checkCallingOrSelfPermission(str) == -1) {
                    com.qq.e.comm.util.GDTLogger.e(java.lang.String.format("Permission[%s]需要在AndroidManifest.xml中声明", str));
                    z = false;
                    break;
                }
            }
            z = true;
            if (!z || !a(context, java.lang.Class.forName(com.qq.e.comm.constants.CustomPkgConstants.getADActivityName())) || !a(context, java.lang.Class.forName(com.qq.e.comm.constants.CustomPkgConstants.getPortraitADActivityName())) || !a(context, java.lang.Class.forName(com.qq.e.comm.constants.CustomPkgConstants.getLandscapeADActivityName()))) {
                return false;
            }
            java.lang.Class<?> cls = java.lang.Class.forName(com.qq.e.comm.constants.CustomPkgConstants.getDownLoadServiceName());
            try {
                intent = new android.content.Intent();
                intent.setClass(context, cls);
            } catch (java.lang.Throwable th2) {
                com.qq.e.comm.util.GDTLogger.e("检查Service时发生异常", th2);
            }
            if (context.getPackageManager().resolveService(intent, 65536) == null) {
                com.qq.e.comm.util.GDTLogger.e(java.lang.String.format("Service[%s]需要在AndroidManifest.xml中声明", cls.getName()));
                z2 = false;
                return !z2;
            }
            z2 = true;
            if (!z2) {
            }
        } catch (java.lang.Throwable th3) {
            com.qq.e.comm.util.GDTLogger.e("检查AndroidManifest.xml时发生异常", th3);
            return false;
        }
    }

    private static boolean a(android.content.Context context, java.lang.Class<?>... clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            try {
                android.content.Intent intent = new android.content.Intent();
                intent.setClass(context, clsArr[i]);
                if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
                    com.qq.e.comm.util.GDTLogger.e(java.lang.String.format("Activity[%s]需要在AndroidManifest.xml中声明", clsArr[i].getName()));
                    return false;
                }
            } catch (java.lang.Throwable th) {
                com.qq.e.comm.util.GDTLogger.e("检查Activity时发生异常", th);
                return false;
            }
        }
        return true;
    }
}
