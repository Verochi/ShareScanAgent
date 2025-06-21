package com.aliyun.svideosdk.common;

@com.aliyun.Visible
/* loaded from: classes12.dex */
public class NativeAdaptiveUtil extends com.aliyun.svideosdk.nativeload.AbstractNativeLoader {
    public static void decoderAdaptiveList(java.lang.String[] strArr, int[] iArr) {
        nativeDecoderAdaptiveList(strArr, iArr);
    }

    public static void disableHardDecoderAdaptiveList(java.lang.String[] strArr, int[] iArr) {
        nativeDisableHardDecoderAdaptiveList(strArr, iArr);
    }

    public static void encoderAdaptiveList(java.lang.String[] strArr, int[] iArr) {
        nativeEncoderAdaptiveList(strArr, iArr);
    }

    public static boolean isDeviceDecoderEnable() {
        return nativeIsDeviceDecoderEnable();
    }

    private static native void nativeDecoderAdaptiveList(java.lang.String[] strArr, int[] iArr);

    private static native void nativeDisableHardDecoderAdaptiveList(java.lang.String[] strArr, int[] iArr);

    private static native void nativeEncoderAdaptiveList(java.lang.String[] strArr, int[] iArr);

    private static native boolean nativeIsDeviceDecoderEnable();

    private static native void nativeSetFastEncode(boolean z);

    private static native void nativeSetHWDecoderEnable(boolean z);

    private static native void nativeSetHWEncoderEnable(boolean z);

    public static void setFastEncode(boolean z) {
        nativeSetFastEncode(z);
    }

    public static void setHWDecoderEnable(boolean z) {
        nativeSetHWDecoderEnable(z);
    }

    public static void setHWEncoderEnable(boolean z) {
        nativeSetHWEncoderEnable(z);
    }
}
