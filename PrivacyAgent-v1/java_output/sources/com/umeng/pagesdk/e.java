package com.umeng.pagesdk;

/* loaded from: classes19.dex */
public final class e {
    public static boolean a(android.content.Context context) {
        try {
            java.lang.String currentProcessName = com.efs.sdk.base.core.util.ProcessUtil.getCurrentProcessName();
            java.lang.String packageName = context.getApplicationContext().getPackageName();
            if (android.text.TextUtils.isEmpty(currentProcessName) || android.text.TextUtils.isEmpty(packageName)) {
                return false;
            }
            return currentProcessName.equals(packageName);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
