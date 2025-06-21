package com.bun.miitmdid.c;

/* loaded from: classes.dex */
public enum a {
    UNSUPPORT(-1, "unsupport"),
    HUA_WEI(0, "HUAWEI"),
    XIAOMI(1, "Xiaomi"),
    VIVO(2, com.igexin.assist.util.AssistUtils.BRAND_VIVO),
    OPPO(3, com.igexin.assist.util.AssistUtils.BRAND_OPPO),
    MOTO(4, "motorola"),
    LENOVO(5, "lenovo"),
    ASUS(6, "asus"),
    SAMSUNG(7, "samsung"),
    MEIZU(8, com.igexin.assist.util.AssistUtils.BRAND_MZ),
    NUBIA(10, "nubia"),
    ZTE(11, "ZTE"),
    ONEPLUS(12, "OnePlus"),
    BLACKSHARK(13, "blackshark"),
    FREEMEOS(30, "freemeos"),
    SSUIOS(31, "ssui");

    private java.lang.String a;

    a(int i, java.lang.String str) {
        this.a = str;
    }

    public static com.bun.miitmdid.c.a a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return UNSUPPORT;
        }
        for (com.bun.miitmdid.c.a aVar : values()) {
            if (aVar.a.equalsIgnoreCase(str)) {
                return aVar;
            }
        }
        return UNSUPPORT;
    }
}
