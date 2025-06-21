package com.aliyun.svideo.base.utils;

/* loaded from: classes.dex */
public class VideoInfoUtils {
    public static void printVideoInfo(java.lang.String str) {
        com.aliyun.svideosdk.transcode.NativeParser nativeParser = new com.aliyun.svideosdk.transcode.NativeParser();
        try {
            try {
                nativeParser.init(str);
                java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
                int parseInt = java.lang.Integer.parseInt(nativeParser.getValue(7));
                int parseInt2 = java.lang.Integer.parseInt(nativeParser.getValue(6));
                int parseInt3 = java.lang.Integer.parseInt(nativeParser.getValue(11));
                int parseInt4 = java.lang.Integer.parseInt(nativeParser.getValue(4));
                long parseLong = java.lang.Long.parseLong(nativeParser.getValue(3));
                long parseLong2 = java.lang.Long.parseLong(nativeParser.getValue(5));
                long parseLong3 = java.lang.Long.parseLong(nativeParser.getValue(18));
                linkedHashMap.put("path", str);
                linkedHashMap.put("width", java.lang.Integer.valueOf(parseInt2));
                linkedHashMap.put("height", java.lang.Integer.valueOf(parseInt));
                linkedHashMap.put(com.tencent.connect.share.QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, java.lang.Long.valueOf(parseLong));
                linkedHashMap.put("audioDuration", java.lang.Long.valueOf(parseLong3));
                linkedHashMap.put(com.aliyun.common.log.struct.AliyunLogKey.KEY_GOP, java.lang.Integer.valueOf(parseInt3));
                linkedHashMap.put("frameRate", java.lang.Float.valueOf((parseInt4 / parseLong) * 1000.0f * 1000.0f));
                linkedHashMap.put(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_BITRATE, java.lang.Long.valueOf(parseLong2));
                linkedHashMap.toString();
            } catch (java.lang.Exception e) {
                e.getMessage();
            }
        } finally {
            nativeParser.release();
            nativeParser.dispose();
        }
    }
}
