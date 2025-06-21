package com.aliyun.player;

/* loaded from: classes.dex */
public class AliPlayerFactory {
    private static java.util.List<com.aliyun.player.AliPlayerFactory.DeviceInfo> sInnerBlackList = new java.util.ArrayList();

    public enum BlackType {
        HW_Decode_H264,
        HW_Decode_HEVC
    }

    public static class DeviceInfo {
        public java.lang.String model;
    }

    public enum SupportFeatureType {
        FeatureDolbyAudio
    }

    static {
        initInnerBlackList();
        addBlackList(com.aliyun.player.AliPlayerFactory.BlackType.HW_Decode_H264, sInnerBlackList);
        com.aliyun.player.ApasaraExternalPlayer.registerExternalPlayer(new com.aliyun.player.a.a());
    }

    public static void addBlackDevice(com.aliyun.player.AliPlayerFactory.BlackType blackType, com.aliyun.player.AliPlayerFactory.DeviceInfo deviceInfo) {
        if (deviceInfo == null || blackType == null) {
            return;
        }
        java.lang.String str = android.os.Build.MODEL;
        if ((blackType == com.aliyun.player.AliPlayerFactory.BlackType.HW_Decode_H264 || blackType == com.aliyun.player.AliPlayerFactory.BlackType.HW_Decode_HEVC) && str.equals(deviceInfo.model)) {
            com.aliyun.player.nativeclass.NativePlayerBase.setBlackType(blackType.ordinal());
        }
    }

    public static void addBlackList(com.aliyun.player.AliPlayerFactory.BlackType blackType, java.util.List<com.aliyun.player.AliPlayerFactory.DeviceInfo> list) {
        if (list == null) {
            return;
        }
        java.util.Iterator<com.aliyun.player.AliPlayerFactory.DeviceInfo> it = list.iterator();
        while (it.hasNext()) {
            addBlackDevice(blackType, it.next());
        }
    }

    public static com.aliyun.player.AliListPlayer createAliListPlayer(android.content.Context context) {
        return createAliListPlayer(context, null);
    }

    public static com.aliyun.player.AliListPlayer createAliListPlayer(android.content.Context context, java.lang.String str) {
        if (!com.aliyun.utils.f.b()) {
            com.aliyun.utils.f.f();
        }
        com.aliyun.private_service.PrivateService.preInitService(context);
        com.aliyun.player.nativeclass.NativeExternalPlayer.setContext(context);
        com.cicada.player.utils.ContentDataSource.setContext(context);
        return new com.aliyun.player.ApsaraVideoListPlayer(context, str);
    }

    public static com.aliyun.player.AliLiveShiftPlayer createAliLiveShiftPlayer(android.content.Context context) {
        return createAliLiveShiftPlayer(context, null);
    }

    public static com.aliyun.player.AliLiveShiftPlayer createAliLiveShiftPlayer(android.content.Context context, java.lang.String str) {
        if (!com.aliyun.utils.f.b()) {
            com.aliyun.utils.f.f();
        }
        com.aliyun.private_service.PrivateService.preInitService(context);
        com.aliyun.player.nativeclass.NativeExternalPlayer.setContext(context);
        com.cicada.player.utils.ContentDataSource.setContext(context);
        return new com.aliyun.player.ApsaraLiveShiftPlayer(context, str);
    }

    public static com.aliyun.player.AliPlayer createAliPlayer(android.content.Context context) {
        return createAliPlayer(context, null);
    }

    public static com.aliyun.player.AliPlayer createAliPlayer(android.content.Context context, java.lang.String str) {
        if (!com.aliyun.utils.f.b()) {
            com.aliyun.utils.f.f();
        }
        com.aliyun.private_service.PrivateService.preInitService(context);
        com.aliyun.player.nativeclass.NativeExternalPlayer.setContext(context);
        com.cicada.player.utils.ContentDataSource.setContext(context);
        return new com.aliyun.player.ApsaraVideoPlayer(context, str);
    }

    public static java.lang.String getDeviceUUID() {
        return com.aliyun.utils.DeviceInfoUtils.getDeviceUUID();
    }

    public static java.lang.String getSdkVersion() {
        return com.aliyun.player.nativeclass.NativePlayerBase.getSdkVersion();
    }

    private static void initInnerBlackList() {
        com.aliyun.player.AliPlayerFactory.DeviceInfo deviceInfo = new com.aliyun.player.AliPlayerFactory.DeviceInfo();
        deviceInfo.model = "Lenovo K320t";
        sInnerBlackList.add(deviceInfo);
    }

    public static boolean isFeatureSupport(com.aliyun.player.AliPlayerFactory.SupportFeatureType supportFeatureType) {
        if (supportFeatureType == com.aliyun.player.AliPlayerFactory.SupportFeatureType.FeatureDolbyAudio) {
            return com.cicada.player.utils.media.MediaCodecUtils.isDolbyAudioSupport();
        }
        return false;
    }

    public static void setConvertURLCallback(com.aliyun.player.IPlayer.ConvertURLCallback convertURLCallback) {
        com.aliyun.player.nativeclass.NativePlayerBase.setConvertURLCb(convertURLCallback);
    }
}
