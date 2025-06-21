package com.alimm.tanx.core.utils;

/* loaded from: classes.dex */
public class EncryptUtils implements com.alimm.tanx.core.utils.NotConfused {
    private static final java.lang.String TAG = "EncryptUtils";

    static {
        long currentTimeMillis = java.lang.System.currentTimeMillis();
        java.lang.System.loadLibrary(com.alimm.tanx.core.ad.event.track.expose.ExposeManager.UtArgsNames.nameSpace);
        com.alimm.tanx.core.utils.LogUtils.d(TAG, "so加载耗时：" + (java.lang.System.currentTimeMillis() - currentTimeMillis));
    }

    public static native byte[] d(java.lang.String str, java.lang.String str2);

    public static native byte[] d1(java.lang.String str);

    public static java.lang.String decrypt(java.lang.String str) {
        return decrypt(str, true);
    }

    public static java.lang.String decrypt(java.lang.String str, boolean z) {
        java.lang.String str2;
        java.lang.String str3 = "";
        try {
            if (android.text.TextUtils.isEmpty(str)) {
                com.alimm.tanx.core.utils.LogUtils.d(TAG, "decrypt()中decryptStr为空 ");
                str = "";
            } else {
                if (!com.alimm.tanx.core.TanxCoreSdk.getConfig().isDebugMode()) {
                    str2 = new java.lang.String(d1(str));
                } else if (com.alimm.tanx.core.utils.SharedPreferencesHelper.getInstance().getEncryptBoolean()) {
                    str2 = new java.lang.String(d1(str));
                }
                str = str2;
            }
            str3 = str;
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(TAG, e.getMessage());
            if (z) {
                com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.CRASH_ERROR.getIntCode(), TAG, com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e), "");
            }
            e.printStackTrace();
        }
        com.alimm.tanx.core.utils.LogUtils.d(TAG, str3);
        return str3;
    }

    public static native byte[] e(java.lang.String str, java.lang.String str2);

    public static java.lang.String encrypt(java.lang.String str) {
        return encrypt(str, true);
    }

    public static java.lang.String encrypt(java.lang.String str, boolean z) {
        java.lang.String str2;
        try {
        } catch (java.lang.Exception e) {
            com.alimm.tanx.core.utils.LogUtils.e(TAG, e.getMessage());
            str2 = "";
            if (z) {
                com.alimm.tanx.core.ut.impl.TanxBaseUt.utError(com.alimm.tanx.core.ut.UtErrorCode.CRASH_ERROR.getIntCode(), TAG, com.alimm.tanx.core.utils.LogUtils.getStackTraceMessage(e), "");
            }
            e.printStackTrace();
        }
        if (com.alimm.tanx.core.TanxCoreSdk.getConfig().isDebugMode()) {
            if (com.alimm.tanx.core.utils.SharedPreferencesHelper.getInstance().getEncryptBoolean()) {
                str2 = new java.lang.String(e(str, com.alimm.tanx.core.TanxCoreSdk.getConfig().getAppKey()));
            }
            com.alimm.tanx.core.utils.LogUtils.d(TAG, str);
            return str;
        }
        str2 = new java.lang.String(e(str, com.alimm.tanx.core.TanxCoreSdk.getConfig().getAppKey()));
        str = str2;
        com.alimm.tanx.core.utils.LogUtils.d(TAG, str);
        return str;
    }
}
