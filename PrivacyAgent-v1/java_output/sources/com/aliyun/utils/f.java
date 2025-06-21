package com.aliyun.utils;

/* loaded from: classes12.dex */
public class f {
    private static final java.lang.String a = "f";
    private static boolean b;
    private static boolean c;
    private static boolean d;
    private static boolean e;

    public static synchronized boolean a() {
        synchronized (com.aliyun.utils.f.class) {
            if (c()) {
                return true;
            }
            java.lang.StackTraceElement[] stackTrace = java.lang.Thread.currentThread().getStackTrace();
            java.lang.String methodName = stackTrace.length > 4 ? stackTrace[3].getMethodName() : "";
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("downloader so not loaded, ignore api call: ");
            sb.append(methodName);
            return false;
        }
    }

    public static synchronized boolean b() {
        synchronized (com.aliyun.utils.f.class) {
            if (d()) {
                return true;
            }
            java.lang.StackTraceElement[] stackTrace = java.lang.Thread.currentThread().getStackTrace();
            java.lang.String methodName = stackTrace.length > 4 ? stackTrace[3].getMethodName() : "";
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("player so not loaded, ignore api call: ");
            sb.append(methodName);
            return false;
        }
    }

    public static synchronized boolean c() {
        boolean z;
        synchronized (com.aliyun.utils.f.class) {
            if (!e) {
                z = d;
            }
        }
        return z;
    }

    public static synchronized boolean d() {
        boolean z;
        synchronized (com.aliyun.utils.f.class) {
            if (!c) {
                z = b;
            }
        }
        return z;
    }

    public static synchronized void e() {
        synchronized (com.aliyun.utils.f.class) {
            f();
            if (e) {
                return;
            }
            if (d) {
                return;
            }
            d = com.aliyun.common.AlivcNativeLoader.loadLibrary("saasDownloader");
        }
    }

    public static synchronized void f() {
        synchronized (com.aliyun.utils.f.class) {
            if (c) {
                return;
            }
            if (b) {
                return;
            }
            boolean z = true;
            b = true;
            com.aliyun.player.nativeclass.JniUrlPlayer.loadClass();
            com.aliyun.player.nativeclass.JniSaasPlayer.loadClass();
            com.aliyun.player.nativeclass.JniListPlayerBase.loadClass();
            com.aliyun.player.nativeclass.JniUrlListPlayer.loadClass();
            com.aliyun.player.nativeclass.JniSaasListPlayer.loadClass();
            com.aliyun.private_service.PrivateService.loadClass();
            com.aliyun.dns.DomainProcessor.loadClass();
            com.aliyun.loader.MediaLoader.loadClass();
            com.aliyun.loader.VodMediaLoader.loadClass();
            com.aliyun.player.AliPlayerGlobalSettings.loadClass();
            com.aliyun.player.HlsKeyGenerator.loadClass();
            com.aliyun.player.nativeclass.NativeExternalPlayer.loadClass();
            com.aliyun.player.nativeclass.NativePlayerBase.loadClass();
            com.aliyun.thumbnail.ThumbnailHelper.loadClass();
            com.aliyun.utils.DeviceInfoUtils.loadClass();
            com.cicada.player.utils.Logger.loadClass();
            com.cicada.player.utils.ass.AssUtils.loadClass();
            boolean loadLibrary = com.aliyun.common.AlivcNativeLoader.loadLibrary(com.aliyun.svideosdk.nativeload.AbstractNativeLoader.SHARED_LIBRARY_FFMPEG_NAME);
            b = loadLibrary;
            if (!loadLibrary || !com.aliyun.common.AlivcNativeLoader.loadLibrary(com.aliyun.player.BuildConfig.PLAYER_LIB_NAME)) {
                z = false;
            }
            b = z;
        }
    }
}
