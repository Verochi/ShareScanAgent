package com.aliyun.svideosdk.nativeload;

/* loaded from: classes12.dex */
public abstract class AbstractNativeLoader {
    public static final java.lang.String SHARED_LIBRARY_AECAUDIO = "SpeexAec";
    public static final java.lang.String SHARED_LIBRARY_ALIVC_CONAN = "alivc_conan";
    public static final java.lang.String SHARED_LIBRARY_FACE_AR_INTERFACE = "AliFaceAREngine";
    public static final java.lang.String SHARED_LIBRARY_FFMPEG_NAME = "alivcffmpeg";
    public static final java.lang.String SHARED_LIBRARY_GXX_PERSONALITY = "gxx_personality";
    public static final java.lang.String SHARED_LIBRARY_LIBAUDIO = "audio-shared";
    public static final java.lang.String SHARED_LIBRARY_OPEN_H264 = "live-openh264";
    public static final java.lang.String SHARED_LIBRARY_SVIDEO_CORE = "ugsv";

    static {
        loadLibrary();
    }

    public static void loadLibrary() {
        loadLocalLibrary(SHARED_LIBRARY_FFMPEG_NAME);
        loadLocalLibrary("ugsv");
        if (com.aliyun.svideosdk.project.aliyunnative.BuildConfig.LIB_VOICE_CHANGE_SUPPORTED.booleanValue()) {
            loadLocalLibrary(SHARED_LIBRARY_LIBAUDIO);
        }
        if (com.aliyun.svideosdk.project.aliyunnative.BuildConfig.LIB_3A_SUPPORTED.booleanValue()) {
            loadLocalLibrary(SHARED_LIBRARY_AECAUDIO);
        }
    }

    public static void loadLocalLibrary(java.lang.String str) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("loadLocalLibrary, AlivcSdkCore.APP_PRIVATE_DIR = ");
        sb.append(com.aliyun.svideosdk.AlivcSdkCore.APP_PRIVATE_DIR);
        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
        sb2.append("Load internal library:");
        sb2.append(str);
        try {
            java.lang.System.loadLibrary(str);
        } catch (java.lang.Throwable unused) {
        }
    }
}
