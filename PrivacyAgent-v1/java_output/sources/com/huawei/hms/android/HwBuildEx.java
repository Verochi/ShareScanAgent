package com.huawei.hms.android;

/* loaded from: classes22.dex */
public class HwBuildEx {

    public static class VERSION {
        public static final int EMUI_SDK_INT = com.huawei.hms.android.HwBuildEx.getSystemPropertiesInt("ro.build.hw_emui_api_level", 0);
    }

    public static class VersionCodes {
        public static final int CUR_DEVELOPMENT = 10000;
        public static final int EMUI_10_0 = 21;
        public static final int EMUI_1_0 = 1;
        public static final int EMUI_1_5 = 2;
        public static final int EMUI_1_6 = 3;
        public static final int EMUI_2_0_JB = 4;
        public static final int EMUI_2_0_KK = 5;
        public static final int EMUI_2_3 = 6;
        public static final int EMUI_3_0 = 7;
        public static final int EMUI_3_0_5 = 8;
        public static final int EMUI_3_1 = 8;
        public static final int EMUI_4_0 = 9;
        public static final int EMUI_4_1 = 10;
        public static final int EMUI_5_0 = 11;
        public static final int EMUI_5_1 = 12;
        public static final int EMUI_5_1_b10x = 13;
        public static final int EMUI_5_1_b200 = 13;
        public static final int EMUI_6_0 = 14;
        public static final int EMUI_9_0 = 17;
        public static final int UNKNOWN_EMUI = 0;
    }

    public static int getSystemPropertiesInt(java.lang.String str, int i) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.os.SystemProperties");
            return ((java.lang.Integer) cls.getDeclaredMethod("getInt", java.lang.String.class, java.lang.Integer.TYPE).invoke(cls, str, java.lang.Integer.valueOf(i))).intValue();
        } catch (java.lang.ClassCastException | java.lang.ClassNotFoundException | java.lang.IllegalAccessException | java.lang.IllegalArgumentException | java.lang.NoSuchMethodException | java.lang.reflect.InvocationTargetException unused) {
            return i;
        }
    }
}
