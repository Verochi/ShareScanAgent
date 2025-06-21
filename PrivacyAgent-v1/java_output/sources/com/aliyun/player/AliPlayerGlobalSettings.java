package com.aliyun.player;

/* loaded from: classes.dex */
public class AliPlayerGlobalSettings {
    public static final int ALLOW_RTS_DEGRADE = 6;
    public static final int CodecType_H265 = 0;
    public static final int ENABLE_ANDROID_DECODE_REUSE = 4;
    public static final int ENABLE_DECODER_FAST_FIRST_FRAME = 7;
    public static final int ENABLE_H2_MULTIPLEX = 2;
    public static final int NOT_PAUSE_WHEN_PREPARING = 5;
    public static final int SCENE_LOADER = 1;
    public static final int SCENE_PLAYER = 0;
    public static final int SET_DNS_PRIORITY_LOCAL_FIRST = 1;
    public static final int SET_EXTRA_DATA = 3;
    public static final int SET_PRE_CONNECT_DOMAIN = 0;
    private static com.aliyun.player.AliPlayerGlobalSettings.OnGetBackupUrlCallback sOnGetBackupUrlCallback;
    private static com.aliyun.player.AliPlayerGlobalSettings.OnGetUrlHashCallback sOnGetUrlHashCallback;
    private static com.aliyun.player.AliPlayerGlobalSettings.OnNetworkCallback sOnNetworkCallback;

    public interface OnGetBackupUrlCallback {

        public enum BizScene {
            kPLAYER,
            kLOADER
        }

        public enum CodecType {
            kH265
        }

        java.lang.String getBackupUrlCallback(int i, int i2, java.lang.String str);
    }

    public interface OnGetUrlHashCallback {
        java.lang.String getUrlHashCallback(java.lang.String str);
    }

    public interface OnNetworkCallback {
        boolean onNetworkDataProcess(java.lang.String str, java.nio.ByteBuffer byteBuffer, long j, java.nio.ByteBuffer byteBuffer2);
    }

    public enum StreamType {
        STREAM_VOICE_CALL,
        STREAM_SYSTEM,
        STREAM_RING,
        STREAM_MUSIC,
        STREAM_ALARM,
        STREAM_NOTIFICATION
    }

    static {
        com.aliyun.utils.f.f();
        sOnGetUrlHashCallback = null;
        sOnGetBackupUrlCallback = null;
        sOnNetworkCallback = null;
    }

    public static void clearCaches() {
        if (com.aliyun.utils.f.b()) {
            nClearCaches();
        }
    }

    public static void disableCrashUpload(boolean z) {
        if (com.aliyun.utils.f.b()) {
            nDisableCrashUpload(z);
        }
    }

    public static void enableBufferToLocalCache(boolean z) {
        if (com.aliyun.utils.f.b()) {
            nEnableBufferToLocalCache(z);
        }
    }

    public static void enableEnhancedHttpDns(boolean z) {
        if (com.aliyun.utils.f.b()) {
            nEnableEnhancedHttpDns(z);
        }
    }

    @java.lang.Deprecated
    public static void enableHttpDns(boolean z) {
        if (com.aliyun.utils.f.b()) {
            nEnableHttpDns(z);
        }
    }

    public static java.lang.String enableLocalCache(boolean z, android.content.Context context) {
        if (!com.aliyun.utils.f.b()) {
            return "";
        }
        if (context == null) {
            context = com.aliyun.utils.DeviceInfoUtils.getSDKContext();
        }
        if (context == null) {
            nEnableLocalCache(z, 0, "");
            return "";
        }
        java.lang.String file = context.getCacheDir().toString();
        nEnableLocalCache(z, 0, file);
        return file;
    }

    public static void enableLocalCache(boolean z, int i, java.lang.String str) {
        if (com.aliyun.utils.f.b()) {
            nEnableLocalCache(z, i, str);
        }
    }

    public static void enableNetworkBalance(boolean z) {
        if (com.aliyun.utils.f.b()) {
            nEnableNetworkBalance(z);
        }
    }

    public static void forceAudioRendingFormat(boolean z, java.lang.String str, int i, int i2) {
        if (com.aliyun.utils.f.b()) {
            nForceAudioRendingFormat(z, str, i, i2);
        }
    }

    public static void loadClass() {
    }

    private static native void nClearCaches();

    private static native void nDisableCrashUpload(boolean z);

    private static native void nEnableBufferToLocalCache(boolean z);

    private static native void nEnableEnhancedHttpDns(boolean z);

    private static native void nEnableHttpDns(boolean z);

    private static native void nEnableLocalCache(boolean z, int i, java.lang.String str);

    private static native void nEnableNetworkBalance(boolean z);

    private static native void nForceAudioRendingFormat(boolean z, java.lang.String str, int i, int i2);

    @com.cicada.player.utils.NativeUsed
    private static synchronized java.lang.String nOnGetBackupUrlCallback(int i, int i2, java.lang.String str) {
        synchronized (com.aliyun.player.AliPlayerGlobalSettings.class) {
            com.aliyun.player.AliPlayerGlobalSettings.OnGetBackupUrlCallback onGetBackupUrlCallback = sOnGetBackupUrlCallback;
            if (onGetBackupUrlCallback == null) {
                return null;
            }
            return onGetBackupUrlCallback.getBackupUrlCallback(i, i2, str);
        }
    }

    @com.cicada.player.utils.NativeUsed
    private static synchronized java.lang.String nOnGetUrlHashCallback(java.lang.String str) {
        synchronized (com.aliyun.player.AliPlayerGlobalSettings.class) {
            com.aliyun.player.AliPlayerGlobalSettings.OnGetUrlHashCallback onGetUrlHashCallback = sOnGetUrlHashCallback;
            if (onGetUrlHashCallback == null) {
                return null;
            }
            return onGetUrlHashCallback.getUrlHashCallback(str);
        }
    }

    @com.cicada.player.utils.NativeUsed
    private static synchronized boolean nOnNetworkDataProcessCallback(java.lang.String str, java.nio.ByteBuffer byteBuffer, long j, java.nio.ByteBuffer byteBuffer2) {
        synchronized (com.aliyun.player.AliPlayerGlobalSettings.class) {
            com.aliyun.player.AliPlayerGlobalSettings.OnNetworkCallback onNetworkCallback = sOnNetworkCallback;
            if (onNetworkCallback == null) {
                return false;
            }
            return onNetworkCallback.onNetworkDataProcess(str, byteBuffer, j, byteBuffer2);
        }
    }

    private static native void nSetAudioStreamType(int i);

    private static native void nSetCacheFileClearConfig(long j, long j2, long j3);

    private static native void nSetCacheUrlHashCallback(boolean z);

    private static native void nSetDNSResolve(java.lang.String str, java.lang.String str2);

    private static native void nSetGetBackupUrlCallback(boolean z);

    private static native void nSetIPResolveType(int i);

    private static native void nSetNetworkCallback(boolean z);

    private static native void nSetOption(int i, int i2);

    private static native void nSetOption(int i, java.lang.String str);

    private static native void nSetUseHttp2(boolean z);

    public static synchronized void setAdaptiveDecoderGetBackupURLCallback(com.aliyun.player.AliPlayerGlobalSettings.OnGetBackupUrlCallback onGetBackupUrlCallback) {
        synchronized (com.aliyun.player.AliPlayerGlobalSettings.class) {
            if (com.aliyun.utils.f.b()) {
                sOnGetBackupUrlCallback = onGetBackupUrlCallback;
                nSetGetBackupUrlCallback(onGetBackupUrlCallback != null);
            }
        }
    }

    public static void setAudioStreamType(com.aliyun.player.AliPlayerGlobalSettings.StreamType streamType) {
        if (com.aliyun.utils.f.b()) {
            nSetAudioStreamType(streamType.ordinal());
        }
    }

    public static void setCacheFileClearConfig(long j, long j2, long j3) {
        if (com.aliyun.utils.f.b()) {
            nSetCacheFileClearConfig(j, j2, j3);
        }
    }

    public static synchronized void setCacheUrlHashCallback(com.aliyun.player.AliPlayerGlobalSettings.OnGetUrlHashCallback onGetUrlHashCallback) {
        synchronized (com.aliyun.player.AliPlayerGlobalSettings.class) {
            if (com.aliyun.utils.f.b()) {
                sOnGetUrlHashCallback = onGetUrlHashCallback;
                nSetCacheUrlHashCallback(onGetUrlHashCallback != null);
            }
        }
    }

    public static void setDNSResolve(java.lang.String str, java.lang.String str2) {
        if (com.aliyun.utils.f.b()) {
            nSetDNSResolve(str, str2);
        }
    }

    public static void setIPResolveType(com.aliyun.player.IPlayer.IPResolveType iPResolveType) {
        if (com.aliyun.utils.f.b()) {
            nSetIPResolveType(iPResolveType.ordinal());
        }
    }

    public static synchronized void setNetworkCallback(com.aliyun.player.AliPlayerGlobalSettings.OnNetworkCallback onNetworkCallback) {
        synchronized (com.aliyun.player.AliPlayerGlobalSettings.class) {
            if (com.aliyun.utils.f.b()) {
                sOnNetworkCallback = onNetworkCallback;
                nSetNetworkCallback(onNetworkCallback != null);
            }
        }
    }

    public static void setOption(int i, int i2) {
        if (com.aliyun.utils.f.b()) {
            nSetOption(i, i2);
        }
    }

    public static void setOption(int i, java.lang.String str) {
        if (com.aliyun.utils.f.b()) {
            nSetOption(i, str);
        }
    }

    public static void setUseHttp2(boolean z) {
        if (com.aliyun.utils.f.b()) {
            nSetUseHttp2(z);
        }
    }
}
