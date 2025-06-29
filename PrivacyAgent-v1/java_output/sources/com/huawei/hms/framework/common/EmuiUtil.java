package com.huawei.hms.framework.common;

/* loaded from: classes22.dex */
public class EmuiUtil {
    private static final java.lang.String BUILDEX_NAME = "com.huawei.android.os.BuildEx";
    public static final java.lang.String BUILDEX_VERSION = "com.huawei.android.os.BuildEx$VERSION";
    private static final int EMUI_3_0 = 7;
    private static final int EMUI_3_1 = 8;
    private static final int EMUI_4_0 = 9;
    private static final int EMUI_4_1 = 10;
    private static final int EMUI_5_0 = 11;
    private static final int EMUI_6_0 = 14;
    private static final int EMUI_8_0_1 = 15;
    private static final int EMUI_9_0 = 17;
    public static final java.lang.String EMUI_SDK_INT = "EMUI_SDK_INT";
    private static final int EMUI_TYPE_UNKOWN = -1;
    public static final java.lang.String GET_PRIMARY_COLOR = "getPrimaryColor";
    public static final java.lang.String GET_SUGGESTION_FOR_GROUND_COLOR_STYLE = "getSuggestionForgroundColorStyle";
    public static final java.lang.String IMMERSION_STYLE = "com.huawei.android.immersion.ImmersionStyle";
    private static final java.lang.String TAG = "KPMS_Util_Emui";
    private static final int TYPE_EMUI_30 = 30;
    private static final int TYPE_EMUI_31 = 31;
    private static final int TYPE_EMUI_40 = 40;
    private static final int TYPE_EMUI_41 = 41;
    private static final int TYPE_EMUI_50 = 50;
    private static final int TYPE_EMUI_60 = 60;
    private static final int TYPE_EMUI_801 = 81;
    private static final int TYPE_EMUI_90 = 90;
    private static int emuiType = -1;

    static {
        initEmuiType();
    }

    public static int getEMUIVersionCode() {
        int intValue;
        java.lang.Object staticFieldObj = com.huawei.hms.framework.common.ReflectionUtils.getStaticFieldObj(BUILDEX_VERSION, EMUI_SDK_INT);
        if (staticFieldObj != null) {
            try {
                intValue = ((java.lang.Integer) staticFieldObj).intValue();
            } catch (java.lang.ClassCastException e) {
                com.huawei.hms.framework.common.Logger.e(TAG, "getEMUIVersionCode ClassCastException:", e);
            }
            com.huawei.hms.framework.common.Logger.d(TAG, "the emui version code is::" + intValue);
            return intValue;
        }
        intValue = 0;
        com.huawei.hms.framework.common.Logger.d(TAG, "the emui version code is::" + intValue);
        return intValue;
    }

    private static void initEmuiType() {
        int eMUIVersionCode = getEMUIVersionCode();
        com.huawei.hms.framework.common.Logger.d(TAG, "getEmuiType emuiVersionCode=" + eMUIVersionCode);
        if (eMUIVersionCode >= 17) {
            emuiType = 90;
        } else if (eMUIVersionCode >= 15) {
            emuiType = 81;
        } else if (eMUIVersionCode >= 14) {
            emuiType = 60;
        } else if (eMUIVersionCode >= 11) {
            emuiType = 50;
        } else if (eMUIVersionCode >= 10) {
            emuiType = 41;
        } else if (eMUIVersionCode >= 9) {
            emuiType = 40;
        } else if (eMUIVersionCode >= 8) {
            emuiType = 31;
        } else if (eMUIVersionCode >= 7) {
            emuiType = 30;
        }
        if (emuiType == -1) {
            com.huawei.hms.framework.common.Logger.i(TAG, "emuiType is unkown");
        }
    }

    public static boolean isEMUI() {
        return -1 != emuiType;
    }

    public static boolean isUpPVersion() {
        if (!com.huawei.hms.framework.common.ReflectionUtils.checkCompatible(BUILDEX_NAME)) {
            com.huawei.hms.framework.common.Logger.w(TAG, "com.huawei.android.os.BuildEx : false");
            return false;
        }
        com.huawei.hms.framework.common.Logger.d(TAG, "com.huawei.android.os.BuildEx.VERSION.EMUI_SDK_INT: " + com.huawei.android.os.BuildEx.VERSION.EMUI_SDK_INT);
        return com.huawei.android.os.BuildEx.VERSION.EMUI_SDK_INT >= 17;
    }
}
