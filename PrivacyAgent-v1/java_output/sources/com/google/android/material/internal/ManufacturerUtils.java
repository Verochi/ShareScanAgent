package com.google.android.material.internal;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes22.dex */
public class ManufacturerUtils {
    private static final java.lang.String LGE = "lge";
    private static final java.lang.String MEIZU = "meizu";
    private static final java.lang.String SAMSUNG = "samsung";

    private ManufacturerUtils() {
    }

    public static boolean isDateInputKeyboardMissingSeparatorCharacters() {
        return isLGEDevice() || isSamsungDevice();
    }

    public static boolean isLGEDevice() {
        return android.os.Build.MANUFACTURER.toLowerCase(java.util.Locale.ENGLISH).equals(LGE);
    }

    public static boolean isMeizuDevice() {
        return android.os.Build.MANUFACTURER.toLowerCase(java.util.Locale.ENGLISH).equals("meizu");
    }

    public static boolean isSamsungDevice() {
        return android.os.Build.MANUFACTURER.toLowerCase(java.util.Locale.ENGLISH).equals(SAMSUNG);
    }
}
