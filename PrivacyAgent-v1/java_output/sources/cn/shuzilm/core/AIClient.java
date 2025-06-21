package cn.shuzilm.core;

/* loaded from: classes.dex */
public class AIClient {
    private static long Y;
    private static long Z;
    static int a;
    public static boolean isf;
    private android.content.Context aa;
    private java.lang.String ab = null;
    private final int ac = 0;
    private final int ad = 1;
    private final int ae = 2;
    private final int af = 3;
    private final int ag = 4;
    private final int ah = 5;
    private final int ai = 6;
    private final int aj = 7;
    private final int ak = 8;
    private static int[] b = {245, com.getui.gtc.extension.distribution.gbd.d.g.aH, 251, 246, com.getui.gtc.extension.distribution.gbd.d.g.aH, 247, 228, com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_PACKET_SIZE, 246, 251, com.igexin.push.config.c.E, 224, 246, com.getui.gtc.extension.distribution.gbd.d.g.aH, 243, com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_PACKET_SIZE, 255, com.igexin.push.config.c.E, 241, 0};
    private static int[] c = {230, 224, 243, 230, 225, 156, 215, com.qq.e.comm.adevent.AdEventType.VIDEO_INIT, 219, 196, 192, 215, 193, 156, 192, 215, 219, com.qq.e.comm.adevent.AdEventType.VIDEO_PRELOADED, 219, 198, 220, 215, 214, 219, 156, 193, 214, com.qq.e.comm.adevent.AdEventType.VIDEO_LOADING, 156, 193, 223, com.qq.e.comm.adevent.AdEventType.VIDEO_PRELOAD_ERROR, 156, 214, 219, 221, 192, 214, 220, com.qq.e.comm.adevent.AdEventType.VIDEO_LOADING, 156, 215, com.autonavi.amap.mapcore.AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, com.qq.e.comm.adevent.AdEventType.VIDEO_PRELOAD_ERROR, 221, 221, com.qq.e.comm.adevent.AdEventType.VIDEO_PRELOAD_ERROR, 156, 223, 221, com.qq.e.comm.adevent.AdEventType.VIDEO_INIT, 0};
    private static int[] d = {230, 248, 242, 187, 241, com.getui.gtc.extension.distribution.gbd.d.g.aH, 250, 231, 241, 251, tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, 187, 240, 249, 242, 250, 250, 242, 187, 248, 250, 246, 0};
    private static int[] e = {com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_MODE_LIVE, com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL, 170, 181, 177, com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_MODE_LIVE, 144, 167, 138, 164, 173, 170, 176, 170, 183, 177, com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_MODE_LIVE, 181, 167, 130, 138, 237, 175, 162, 173, 177, com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_MODE_LIVE, 183, 173, 170, 237, 177, com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_MODE_LIVE, 170, 165, 170, 183, 173, com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_MODE_LIVE, 167, 170, 237, 176, 167, 162, 237, 176, 174, 164, 237, 167, 170, com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_STREAM_TYPE_AC4, 177, 167, 173, 162, 237, com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_MODE_LIVE, 175, 164, com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_STREAM_TYPE_AC4, com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_STREAM_TYPE_AC4, 164, 237, 174, com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_STREAM_TYPE_AC4, com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL, 0};
    private static int[] f = {218, 171, 169, com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_STREAM_TYPE_AC4, 218, com.autonavi.amap.mapcore.AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 170, com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_STREAM_TYPE_AC4, 168, 218, com.autonavi.amap.mapcore.AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, com.autonavi.amap.mapcore.AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 171, com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_MODE_LIVE, 170, 217, 168, 221, 174, com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_MODE_LIVE, 168, 217, 169, 217, 175, 218, 173, 219, 173, 217, 173, 218, 0};
    private static int[] g = {246, 227, 224, 247, 245, 218, 0};
    private static int[] h = {234, 231, 249, 230, com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL, 231, 235, 249, 239, 251, 230, com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL, 227, 225, 237, 0};
    private static int[] i = {230, 224, 234, 245, 241, 230, 240, com.getui.gtc.extension.distribution.gbd.d.g.aH, 240, 231, 234, 237, 230, 243, 236, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_BACKUP_URLS, 198, 192, 202, com.qq.e.comm.adevent.AdEventType.VIDEO_PRELOAD_ERROR, 198, 199, com.qq.e.comm.adevent.AdEventType.VIDEO_STOP, 198, com.qq.e.comm.adevent.AdEventType.VIDEO_LOADING, 204, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_BACKUP_URLS, com.qq.e.comm.adevent.AdEventType.VIDEO_CLICKED, 202, 199, 204, 214, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_BACKUP_URLS, com.qq.e.comm.adevent.AdEventType.VIDEO_COMPLETE, 204, 192, 0};
    private static int[] j = {com.qq.e.comm.adevent.AdEventType.VIDEO_INIT, 215, 221, 194, 198, com.qq.e.comm.adevent.AdEventType.VIDEO_INIT, 231, 198, com.qq.e.comm.adevent.AdEventType.VIDEO_INIT, 221, com.qq.e.comm.adevent.AdEventType.VIDEO_READY, 221, 192, 218, com.qq.e.comm.adevent.AdEventType.VIDEO_INIT, com.qq.e.comm.adevent.AdEventType.VIDEO_CLICKED, com.igexin.push.config.c.E, com.qq.e.comm.adevent.AdEventType.VIDEO_INIT, 215, 221, 194, com.qq.e.comm.adevent.AdEventType.VIDEO_INIT, 240, 218, com.qq.e.comm.adevent.AdEventType.VIDEO_INIT, 196, 251, 154, 216, com.qq.e.comm.adevent.AdEventType.VIDEO_CLICKED, 221, com.qq.e.comm.adevent.AdEventType.VIDEO_PRELOAD_ERROR, 154, com.qq.e.comm.adevent.AdEventType.VIDEO_INIT, 215, 221, 194, com.qq.e.comm.adevent.AdEventType.VIDEO_INIT, com.qq.e.comm.adevent.AdEventType.VIDEO_CLICKED, 218, com.qq.e.comm.adevent.AdEventType.VIDEO_INIT, 196, 219, 154, 199, 221, com.qq.e.comm.adevent.AdEventType.VIDEO_CLICKED, 219, 193, 154, 217, 219, 215, 0};
    private static int[] k = {243, 245, 255, 224, 228, 243, 229, 242, 255, 243, 245, 255, 224, 243, 242, 184, 255, 227, 236, 184, 251, 249, 245, 0};
    private static int[] l = {195, 197, com.qq.e.comm.adevent.AdEventType.VIDEO_ERROR, com.qq.e.comm.adevent.AdEventType.VIDEO_CLICKED, com.qq.e.comm.adevent.AdEventType.VIDEO_PRELOADED, 195, 245, 194, com.qq.e.comm.adevent.AdEventType.VIDEO_ERROR, 195, 197, com.qq.e.comm.adevent.AdEventType.VIDEO_ERROR, com.qq.e.comm.adevent.AdEventType.VIDEO_CLICKED, 195, 226, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_PACKAGE_NAME, 195, 197, com.qq.e.comm.adevent.AdEventType.VIDEO_ERROR, com.qq.e.comm.adevent.AdEventType.VIDEO_CLICKED, com.qq.e.comm.adevent.AdEventType.VIDEO_PRELOADED, 195, com.qq.e.comm.adevent.AdEventType.VIDEO_PRELOAD_ERROR, 194, com.qq.e.comm.adevent.AdEventType.VIDEO_ERROR, 195, 197, com.qq.e.comm.adevent.AdEventType.VIDEO_ERROR, com.qq.e.comm.adevent.AdEventType.VIDEO_CLICKED, 195, 194, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_PACKAGE_NAME, com.qq.e.comm.adevent.AdEventType.VIDEO_ERROR, com.qq.e.comm.adevent.AdEventType.VIDEO_LOADING, 220, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_PACKAGE_NAME, 203, 201, 197, 0};
    private static int[] m = {204, 202, 200, com.qq.e.comm.adevent.AdEventType.VIDEO_ERROR, 219, 204, 221, 199, 224, com.qq.e.comm.adevent.AdEventType.VIDEO_STOP, 192, 204, 202, 192, 223, 204, 237, 224, 135, 204, 202, 192, 223, 219, 204, 218, com.qq.e.comm.adevent.AdEventType.VIDEO_STOP, 192, 204, 202, 192, 223, 204, com.qq.e.comm.adevent.AdEventType.VIDEO_STOP, 135, 192, 220, com.qq.e.comm.adevent.AdEventType.VIDEO_LOADING, 135, 196, 198, 202, 0};
    private static int[] n = {221, 174, 175, 171, 167, 219, 220, 170, 168, 220, 167, com.autonavi.amap.mapcore.AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 219, com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_MODE_LIVE, 221, 220, 219, com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_MODE_LIVE, 217, 168, com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_STREAM_TYPE_AC4, 168, com.autonavi.amap.mapcore.AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 219, 217, 173, 219, com.autonavi.amap.mapcore.AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 219, 174, 174, 174, 0};
    private static int[] o = {197, 196, com.qq.e.comm.adevent.AdEventType.VIDEO_PRELOAD_ERROR, com.qq.e.comm.adevent.AdEventType.VIDEO_LOADING, com.qq.e.comm.adevent.AdEventType.VIDEO_COMPLETE, com.qq.e.comm.adevent.AdEventType.VIDEO_INIT, com.qq.e.comm.adevent.AdEventType.VIDEO_INIT, com.qq.e.comm.adevent.AdEventType.VIDEO_PRELOADED, com.qq.e.comm.adevent.AdEventType.VIDEO_READY, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MIME_TYPE, 197, 200, com.qq.e.comm.adevent.AdEventType.VIDEO_LOADING, 196, 200, 199, 200, com.qq.e.comm.adevent.AdEventType.VIDEO_PRELOAD_ERROR, com.qq.e.comm.adevent.AdEventType.VIDEO_ERROR, 196, 197, 200, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MIME_TYPE, com.qq.e.comm.adevent.AdEventType.VIDEO_READY, 216, com.qq.e.comm.adevent.AdEventType.VIDEO_READY, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MIME_TYPE, com.qq.e.comm.adevent.AdEventType.VIDEO_PRELOAD_ERROR, com.qq.e.comm.adevent.AdEventType.VIDEO_READY, 200, com.qq.e.comm.adevent.AdEventType.VIDEO_READY, com.qq.e.comm.adevent.AdEventType.VIDEO_LOADING, 196, com.qq.e.comm.adevent.AdEventType.VIDEO_INIT, 0};
    private static int[] p = {233, 255, 243, 238, 232, 255, 234, 245, 232, 202, 247, 255, 238, 233, 227, 201, 180, 233, 245, 180, com.getui.gtc.extension.distribution.gbd.d.g.aI, 243, 245, 232, com.getui.gtc.extension.distribution.gbd.d.g.aI, tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, 251, 0};
    private static int[] q = {tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, 249, com.getui.gtc.extension.distribution.gbd.d.g.aI, 245, 224, 255, 190, 224, 241, 228, 233, 245, 248, 190, com.igexin.push.config.c.E, 255, 243, 0};
    private static int[] r = {197, 195, 201, 214, com.qq.e.comm.adevent.AdEventType.VIDEO_READY, 197, 243, 217, 198, 201, com.qq.e.comm.adevent.AdEventType.VIDEO_PRELOADED, com.qq.e.comm.adevent.AdEventType.VIDEO_COMPLETE, 197, 196, 233, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NOTIFICATION_JUMP_URL, 196, 201, com.qq.e.comm.adevent.AdEventType.VIDEO_COMPLETE, 197, com.qq.e.comm.adevent.AdEventType.VIDEO_CLICKED, com.qq.e.comm.adevent.AdEventType.VIDEO_ERROR, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NOTIFICATION_JUMP_URL, com.qq.e.comm.adevent.AdEventType.VIDEO_CLICKED, 193, com.qq.e.comm.adevent.AdEventType.VIDEO_PRELOADED, 217, 197, 200, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NOTIFICATION_JUMP_URL, com.qq.e.comm.adevent.AdEventType.VIDEO_STOP, com.qq.e.comm.adevent.AdEventType.VIDEO_ERROR, 195, 0};

    /* renamed from: s, reason: collision with root package name */
    private static int[] f73s = {199, 202, 214, 204, 0};
    private static int[] t = {220, com.qq.e.comm.adevent.AdEventType.VIDEO_INIT, 246, com.igexin.push.config.c.E, 232, 215, com.qq.e.comm.adevent.AdEventType.VIDEO_INIT, 182, com.getui.gtc.extension.distribution.gbd.d.g.aH, 241, 246, com.igexin.push.config.c.E, 232, 247, 182, 232, 249, 236, 225, com.igexin.push.config.c.E, 240, 182, 245, 247, 251, 0};
    private static int[] u = {226, 228, 238, 241, 245, 226, tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, 248, 227, 238, 248, 233, 226, 247, 232, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_APP_ICON, 195, com.qq.e.comm.adevent.AdEventType.VIDEO_COMPLETE, 201, 194, 215, 200, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_APP_ICON, 215, 198, com.qq.e.comm.adevent.AdEventType.VIDEO_LOADING, com.autonavi.amap.mapcore.AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 194, com.qq.e.comm.adevent.AdEventType.VIDEO_ERROR, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_APP_ICON, 202, 200, 196, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_APP_ICON, 201, 200, com.qq.e.comm.adevent.AdEventType.VIDEO_COMPLETE, com.qq.e.comm.adevent.AdEventType.VIDEO_LOADING, 196, 198, 0};
    private static int[] v = {234, 248, 230, 165, 248, com.getui.gtc.extension.distribution.gbd.d.g.aI, 248, 234, 165, 230, 228, 232, 0};
    private static int[] w = {217, com.qq.e.comm.adevent.AdEventType.VIDEO_PRELOADED, 217, 194, com.qq.e.comm.adevent.AdEventType.VIDEO_COMPLETE, com.qq.e.comm.adevent.AdEventType.VIDEO_COMPLETE, 216, com.autonavi.amap.mapcore.AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, com.autonavi.amap.mapcore.AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 220, 179, 243, 242, tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, 233, com.getui.gtc.extension.distribution.gbd.d.g.aI, com.getui.gtc.extension.distribution.gbd.d.g.aH, 179, com.getui.gtc.extension.distribution.gbd.d.g.aH, 238, 240, 179, 238, 232, 238, com.getui.gtc.extension.distribution.gbd.d.g.aH, 179, 240, 242, com.getui.gtc.extension.distribution.gbd.d.g.aI, 0};
    private static int[] x = {216, com.qq.e.comm.adevent.AdEventType.VIDEO_PRELOAD_ERROR, 216, 229, 238, com.igexin.push.config.c.E, 232, 242, 249, 241, 249, 240, 236, 236, 233, com.qq.e.comm.adevent.AdEventType.VIDEO_ERROR, 178, com.igexin.push.config.c.E, 239, 241, 178, 239, 233, 239, com.igexin.push.config.c.E, 178, 241, 243, 255, 0};
    private static int[] y = {com.qq.e.comm.adevent.AdEventType.VIDEO_INIT, 215, 221, 194, 198, com.qq.e.comm.adevent.AdEventType.VIDEO_INIT, 231, 240, com.igexin.push.config.c.E, 240, com.qq.e.comm.adevent.AdEventType.VIDEO_STOP, 198, com.qq.e.comm.adevent.AdEventType.VIDEO_PRELOAD_ERROR, 192, 218, com.qq.e.comm.adevent.AdEventType.VIDEO_INIT, 217, com.qq.e.comm.adevent.AdEventType.VIDEO_INIT, 216, 196, 196, 193, 231, 154, 240, com.igexin.push.config.c.E, 240, com.qq.e.comm.adevent.AdEventType.VIDEO_STOP, 198, com.qq.e.comm.adevent.AdEventType.VIDEO_PRELOAD_ERROR, 192, 218, com.qq.e.comm.adevent.AdEventType.VIDEO_INIT, 217, com.qq.e.comm.adevent.AdEventType.VIDEO_INIT, 216, 196, 196, 193, 231, 154, com.qq.e.comm.adevent.AdEventType.VIDEO_PRELOAD_ERROR, 199, 217, 154, 199, 193, 199, com.qq.e.comm.adevent.AdEventType.VIDEO_PRELOAD_ERROR, 154, 217, 219, 215, 0};
    private static int[] z = {203, com.qq.e.comm.adevent.AdEventType.VIDEO_STOP, com.qq.e.comm.adevent.AdEventType.VIDEO_ERROR, 200, 220, 203, 218, 192, 231, 194, 202, 199, 239, 202, 199, 234, 231, 128, 234, 231, 234, 215, 220, com.qq.e.comm.adevent.AdEventType.VIDEO_ERROR, 218, 192, 203, 195, 203, 194, com.autonavi.amap.mapcore.AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, com.autonavi.amap.mapcore.AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 219, com.igexin.push.config.c.E, 128, com.qq.e.comm.adevent.AdEventType.VIDEO_ERROR, 221, 195, 128, 221, 219, 221, com.qq.e.comm.adevent.AdEventType.VIDEO_ERROR, 128, 195, 193, com.qq.e.comm.adevent.AdEventType.VIDEO_STOP, 0};
    private static int[] A = {199, 193, 203, com.qq.e.comm.adevent.AdEventType.VIDEO_PRELOADED, com.qq.e.comm.adevent.AdEventType.VIDEO_CLICKED, 199, com.qq.e.comm.adevent.AdEventType.VIDEO_INIT, 198, 203, 199, 193, 203, com.qq.e.comm.adevent.AdEventType.VIDEO_PRELOADED, 199, 198, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL, 198, 203, com.qq.e.comm.adevent.AdEventType.VIDEO_STOP, com.qq.e.comm.adevent.AdEventType.VIDEO_CLICKED, 198, 204, 195, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL, 197, 204, 215, com.qq.e.comm.adevent.AdEventType.VIDEO_INIT, com.qq.e.comm.adevent.AdEventType.VIDEO_ERROR, 195, com.qq.e.comm.adevent.AdEventType.VIDEO_INIT, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL, com.qq.e.comm.adevent.AdEventType.VIDEO_ERROR, com.qq.e.comm.adevent.AdEventType.VIDEO_STOP, 193, 0};
    private static int[] B = {215, com.qq.e.comm.adevent.AdEventType.VIDEO_INIT, 219, 196, 192, 215, 225, 214, 251, 215, com.qq.e.comm.adevent.AdEventType.VIDEO_INIT, 219, 196, 215, 246, 156, 215, com.qq.e.comm.adevent.AdEventType.VIDEO_INIT, 219, 196, 192, 215, 193, 214, 219, 215, com.qq.e.comm.adevent.AdEventType.VIDEO_INIT, 219, 196, 215, 214, 156, 214, 219, 221, 192, 214, 220, com.qq.e.comm.adevent.AdEventType.VIDEO_LOADING, 156, com.qq.e.comm.adevent.AdEventType.VIDEO_PRELOAD_ERROR, 220, 199, 193, 223, com.qq.e.comm.adevent.AdEventType.VIDEO_LOADING, 193, 156, 223, 221, com.qq.e.comm.adevent.AdEventType.VIDEO_INIT, 0};
    private static int[] C = {214, com.qq.e.comm.adevent.AdEventType.VIDEO_CLICKED, 218, 197, 193, 214, 224, 215, 250, 214, com.qq.e.comm.adevent.AdEventType.VIDEO_CLICKED, 218, 197, 214, 247, 250, 157, 214, com.qq.e.comm.adevent.AdEventType.VIDEO_CLICKED, 218, 197, 193, 214, 192, 215, 218, 214, com.qq.e.comm.adevent.AdEventType.VIDEO_CLICKED, 218, 197, 214, 215, 157, 215, 218, 220, 193, 215, 221, com.qq.e.comm.adevent.AdEventType.VIDEO_READY, 157, com.qq.e.comm.adevent.AdEventType.VIDEO_PRELOADED, 221, 198, 192, com.autonavi.amap.mapcore.AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, com.qq.e.comm.adevent.AdEventType.VIDEO_READY, 192, 157, com.autonavi.amap.mapcore.AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 220, com.qq.e.comm.adevent.AdEventType.VIDEO_CLICKED, 0};
    private static int[] D = {com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL, 200, 199, com.qq.e.comm.adevent.AdEventType.VIDEO_CLICKED, 199, 202, com.qq.e.comm.adevent.AdEventType.VIDEO_STOP, 198, com.qq.e.comm.adevent.AdEventType.VIDEO_LOADING, 204, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_BACKUP_URLS, 198, com.qq.e.comm.adevent.AdEventType.VIDEO_COMPLETE, 218, com.qq.e.comm.adevent.AdEventType.VIDEO_ERROR, 197, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_BACKUP_URLS, 214, 217, 202, 198, com.qq.e.comm.adevent.AdEventType.VIDEO_COMPLETE, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_BACKUP_URLS, com.qq.e.comm.adevent.AdEventType.VIDEO_COMPLETE, 204, 192, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FUNNEL_TYPE, 215, com.qq.e.comm.adevent.AdEventType.VIDEO_STOP, 198, 215, com.qq.e.comm.adevent.AdEventType.VIDEO_STOP, 204, 192, 0};
    private static int[] E = {243, com.getui.gtc.extension.distribution.gbd.d.g.aH, 235, com.getui.gtc.extension.distribution.gbd.d.g.aH, 241, 246, com.igexin.push.config.c.E, 232, 247, 182, com.igexin.push.config.c.E, 245, 225, tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, com.getui.gtc.extension.distribution.gbd.d.g.aI, 182, 237, 226, 241, com.igexin.push.config.c.E, 245, 182, 245, 247, 251, 0};
    private static int[] F = {218, 215, 202, 215, com.qq.e.comm.adevent.AdEventType.VIDEO_STOP, 198, 199, 202, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL, 218, 215, 202, 215, com.qq.e.comm.adevent.AdEventType.VIDEO_STOP, 198, 199, 202, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_BACKUP_URLS, 194, 202, 193, 214, com.qq.e.comm.adevent.AdEventType.VIDEO_STOP, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_BACKUP_URLS, com.qq.e.comm.adevent.AdEventType.VIDEO_STOP, 192, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DOWNLOAD_URL, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FUNNEL_TYPE, 215, com.qq.e.comm.adevent.AdEventType.VIDEO_STOP, 198, 215, com.qq.e.comm.adevent.AdEventType.VIDEO_STOP, 204, 192, 0};
    private static int[] G = {com.qq.e.comm.adevent.AdEventType.VIDEO_STOP, com.qq.e.comm.adevent.AdEventType.VIDEO_INIT, 204, 232, com.qq.e.comm.adevent.AdEventType.VIDEO_LOADING, 196, 197, 200, 215, com.qq.e.comm.adevent.AdEventType.VIDEO_COMPLETE, com.qq.e.comm.adevent.AdEventType.VIDEO_LOADING, 241, 197, 232, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MIME_TYPE, com.qq.e.comm.adevent.AdEventType.VIDEO_STOP, com.qq.e.comm.adevent.AdEventType.VIDEO_INIT, 204, 200, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MIME_TYPE, 197, 200, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MIME_TYPE, 197, 200, com.qq.e.comm.adevent.AdEventType.VIDEO_COMPLETE, com.qq.e.comm.adevent.AdEventType.VIDEO_LOADING, 197, com.qq.e.comm.adevent.AdEventType.VIDEO_ERROR, 192, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MIME_TYPE, 204, com.qq.e.comm.adevent.AdEventType.VIDEO_COMPLETE, 194, 0};
    private static int[] H = {234, 248, 230, 165, 239, 226, 239, 230, 165, 230, 228, 232, 0};
    private static int[] I = {197, 195, 201, 214, com.qq.e.comm.adevent.AdEventType.VIDEO_READY, 197, 243, 204, 235, 193, com.qq.e.comm.adevent.AdEventType.VIDEO_LOADING, 237, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NOTIFICATION_JUMP_URL, 197, 195, 201, 214, com.qq.e.comm.adevent.AdEventType.VIDEO_READY, 197, com.qq.e.comm.adevent.AdEventType.VIDEO_LOADING, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NOTIFICATION_JUMP_URL, 193, com.qq.e.comm.adevent.AdEventType.VIDEO_LOADING, com.qq.e.comm.adevent.AdEventType.VIDEO_STOP, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NOTIFICATION_JUMP_URL, 196, 201, 196, com.qq.e.comm.adevent.AdEventType.VIDEO_STOP, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NOTIFICATION_JUMP_URL, com.qq.e.comm.adevent.AdEventType.VIDEO_STOP, com.qq.e.comm.adevent.AdEventType.VIDEO_ERROR, 195, 0};
    private static int[] J = {250, com.getui.gtc.extension.distribution.gbd.d.g.aH, 246, 233, 237, 250, 236, 177, 235, 237, com.getui.gtc.extension.distribution.gbd.d.g.aI, 235, 236, 177, 241, 240, 246, 235, com.getui.gtc.extension.distribution.gbd.d.g.aH, com.getui.gtc.extension.distribution.gbd.d.g.aI, 177, com.getui.gtc.extension.distribution.gbd.d.g.aI, 236, 242, 177, 241, 234, com.igexin.push.config.c.E, 177, 242, 240, com.getui.gtc.extension.distribution.gbd.d.g.aH, 0};
    private static int[] K = {com.igexin.push.config.c.E, 245, 249, 246, 255, 243, 232, 182, 245, 249, 234, 249, 232, 182, 249, 235, 245, 182, 246, 237, 250, 182, 245, 247, 251, 0};
    private static int[] L = {237, com.getui.gtc.extension.distribution.gbd.d.g.aH, 234, 247, 240, 247, 236, 235, 183, tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, 248, 235, 248, 233, 183, 248, 234, tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, 183, 247, 236, 251, 183, tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, 246, 250, 0};
    private static int[] M = {197, 195, 201, 214, com.qq.e.comm.adevent.AdEventType.VIDEO_READY, 197, 243, 196, 233, 193, com.qq.e.comm.adevent.AdEventType.VIDEO_LOADING, 237, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NOTIFICATION_JUMP_URL, 197, 195, 201, 214, com.qq.e.comm.adevent.AdEventType.VIDEO_READY, 197, com.qq.e.comm.adevent.AdEventType.VIDEO_LOADING, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NOTIFICATION_JUMP_URL, 193, com.qq.e.comm.adevent.AdEventType.VIDEO_LOADING, com.qq.e.comm.adevent.AdEventType.VIDEO_STOP, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NOTIFICATION_JUMP_URL, 196, 201, 196, com.qq.e.comm.adevent.AdEventType.VIDEO_STOP, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NOTIFICATION_JUMP_URL, com.qq.e.comm.adevent.AdEventType.VIDEO_STOP, com.qq.e.comm.adevent.AdEventType.VIDEO_ERROR, 195, 0};
    private static int[] N = {197, 195, 201, 214, com.qq.e.comm.adevent.AdEventType.VIDEO_READY, 197, com.qq.e.comm.adevent.AdEventType.VIDEO_LOADING, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NOTIFICATION_JUMP_URL, com.qq.e.comm.adevent.AdEventType.VIDEO_ERROR, com.qq.e.comm.adevent.AdEventType.VIDEO_PRELOADED, 196, com.qq.e.comm.adevent.AdEventType.VIDEO_COMPLETE, 201, 194, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NOTIFICATION_JUMP_URL, com.qq.e.comm.adevent.AdEventType.VIDEO_COMPLETE, com.qq.e.comm.adevent.AdEventType.VIDEO_ERROR, 201, com.qq.e.comm.adevent.AdEventType.VIDEO_PRELOADED, 195, 193, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NOTIFICATION_JUMP_URL, 193, com.qq.e.comm.adevent.AdEventType.VIDEO_LOADING, com.qq.e.comm.adevent.AdEventType.VIDEO_STOP, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NOTIFICATION_JUMP_URL, com.qq.e.comm.adevent.AdEventType.VIDEO_COMPLETE, com.qq.e.comm.adevent.AdEventType.VIDEO_PRELOAD_ERROR, 194, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NOTIFICATION_JUMP_URL, com.qq.e.comm.adevent.AdEventType.VIDEO_STOP, com.qq.e.comm.adevent.AdEventType.VIDEO_ERROR, 195, 0};
    private static int[] O = {com.getui.gtc.extension.distribution.gbd.d.g.aH, 250, 248, 255, 235, com.getui.gtc.extension.distribution.gbd.d.g.aH, 237, 247, com.qq.e.comm.adevent.AdEventType.VIDEO_CLICKED, com.igexin.push.config.c.E, com.qq.e.comm.adevent.AdEventType.VIDEO_CLICKED, 248, 234, com.qq.e.comm.adevent.AdEventType.VIDEO_PRELOADED, 183, 251, 240, 245, 183, 247, 236, 251, 183, tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, 246, 250, 0};
    private static int[] P = {250, 237, 251, 234, 225, com.getui.gtc.extension.distribution.gbd.d.g.aH, com.getui.gtc.extension.distribution.gbd.d.g.aI, com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL, 231, 251, com.igexin.push.config.c.E, com.igexin.push.config.c.E, com.autonavi.amap.mapcore.tools.GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL, 225, com.getui.gtc.extension.distribution.gbd.d.g.aH, 0};
    private static int[] Q = {202, 214, com.qq.e.comm.adevent.AdEventType.VIDEO_CLICKED, com.qq.e.comm.adevent.AdEventType.VIDEO_CLICKED, 0};
    private static int[] R = {com.qq.e.comm.adevent.AdEventType.VIDEO_PRELOADED, 200, 194, 202, 194, 194, com.qq.e.comm.adevent.AdEventType.VIDEO_PRELOAD_ERROR, 193, 0};
    private static int[] S = {248, 241, 246, 245, 248, 186, 241, 249, 241, 241, 230, 242, 186, 240, 248, com.igexin.push.config.c.E, 225, 246, 186, 251, 230, 0};
    private static int[] T = {238, 232, 245, 234, 234, 239, 233, com.getui.gtc.extension.distribution.gbd.d.g.aI, 243, 255, 249, 243, 236, 255, com.getui.gtc.extension.distribution.gbd.d.g.aI, 180, com.getui.gtc.extension.distribution.gbd.d.g.aI, 251, 234, 246, 245, 245, 249, 180, 247, 245, 249, 0};
    private static int[] U = {com.qq.e.comm.adevent.AdEventType.VIDEO_ERROR, 201, 195, 220, 216, com.qq.e.comm.adevent.AdEventType.VIDEO_ERROR, 249, com.qq.e.comm.adevent.AdEventType.VIDEO_COMPLETE, 227, com.qq.e.comm.adevent.AdEventType.VIDEO_ERROR, 201, 195, 220, com.qq.e.comm.adevent.AdEventType.VIDEO_ERROR, 238, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_ID, com.autonavi.amap.mapcore.AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 216, 197, 218, 218, 223, 217, com.qq.e.comm.adevent.AdEventType.VIDEO_COMPLETE, 195, com.qq.e.comm.adevent.AdEventType.VIDEO_ERROR, 201, 195, 220, com.qq.e.comm.adevent.AdEventType.VIDEO_ERROR, com.qq.e.comm.adevent.AdEventType.VIDEO_COMPLETE, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_ID, com.qq.e.comm.adevent.AdEventType.VIDEO_COMPLETE, 203, 218, 198, 197, 197, 201, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_ID, 199, 197, 201, 0};
    private static int[] V = {217, com.qq.e.comm.adevent.AdEventType.VIDEO_COMPLETE, 204, 202, 197, 202, 230, com.qq.e.comm.adevent.AdEventType.VIDEO_ERROR, 226, com.qq.e.comm.adevent.AdEventType.VIDEO_COMPLETE, 200, 194, 221, com.qq.e.comm.adevent.AdEventType.VIDEO_COMPLETE, 239, 226, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_IS_AD, 223, 217, 196, 219, 219, com.autonavi.amap.mapcore.AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 216, com.qq.e.comm.adevent.AdEventType.VIDEO_ERROR, 194, com.qq.e.comm.adevent.AdEventType.VIDEO_COMPLETE, 200, 194, 221, com.qq.e.comm.adevent.AdEventType.VIDEO_COMPLETE, com.qq.e.comm.adevent.AdEventType.VIDEO_ERROR, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_IS_AD, com.qq.e.comm.adevent.AdEventType.VIDEO_ERROR, 202, 219, 199, 196, 196, 200, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_IS_AD, 198, 196, 200, 0};
    private static int[] W = {204, 202, 192, 223, 219, 204, 250, 237, 224, 232, 230, 224, 135, com.qq.e.comm.adevent.AdEventType.VIDEO_STOP, 192, 200, 198, 135, 204, 202, 192, 223, 219, 204, 218, com.qq.e.comm.adevent.AdEventType.VIDEO_STOP, 220, 198, 197, 202, 135, 219, 198, 199, 198, 193, 192, 193, 135, 196, 198, 202, 0};
    private static int[] X = {169, 174, 171, 221, com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_MODE_LIVE, 167, com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_MODE_LIVE, 220, 174, 168, 169, 219, 169, com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_MODE_LIVE, 168, 217, com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_STREAM_TYPE_AC4, 169, 171, 175, 169, 171, 218, 174, 221, com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_MODE_LIVE, 169, 168, com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_MODE_LIVE, 218, 220, com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_MODE_LIVE, 0};

    /* renamed from: cn.shuzilm.core.AIClient$1, reason: invalid class name */
    class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.util.concurrent.LinkedBlockingQueue a;
        final /* synthetic */ android.os.IBinder b;

        public AnonymousClass1(java.util.concurrent.LinkedBlockingQueue linkedBlockingQueue, android.os.IBinder iBinder) {
            this.a = linkedBlockingQueue;
            this.b = iBinder;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.put(this.b);
            } catch (java.lang.Exception unused) {
            }
        }
    }

    final class AC implements android.content.ServiceConnection {
        boolean a;
        private final java.util.concurrent.LinkedBlockingQueue b;

        private AC() {
            this.a = false;
            this.b = new java.util.concurrent.LinkedBlockingQueue(1);
        }

        public /* synthetic */ AC(cn.shuzilm.core.AIClient.AnonymousClass1 anonymousClass1) {
            this();
        }

        public android.os.IBinder getBinder() {
            if (this.a) {
                throw new java.lang.IllegalStateException();
            }
            this.a = true;
            return (android.os.IBinder) this.b.take();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
            cn.shuzilm.core.AIClient.b(this.b, iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(android.content.ComponentName componentName) {
        }
    }

    final class AI implements android.os.IInterface {
        private android.os.IBinder b;
        private java.lang.String c;
        private int d;

        public AI(android.os.IBinder iBinder, java.lang.String str, int i) {
            this.b = iBinder;
            this.c = str;
            this.d = i;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this.b;
        }

        public java.lang.String getId() {
            java.lang.String str;
            android.os.Parcel obtain = android.os.Parcel.obtain();
            android.os.Parcel obtain2 = android.os.Parcel.obtain();
            java.lang.String str2 = null;
            try {
                str = this.c;
            } catch (java.lang.Throwable unused) {
                obtain2.recycle();
                obtain.recycle();
            }
            if (str != null && this.d >= 0) {
                obtain.writeInterfaceToken(str);
                this.b.transact(this.d, obtain, obtain2, 0);
                obtain2.readException();
                str2 = obtain2.readString();
                obtain2.recycle();
                obtain.recycle();
                return str2;
            }
            return null;
        }
    }

    final class AIO implements android.os.IInterface {
        private android.os.IBinder b;
        private java.lang.String c;

        public AIO(android.os.IBinder iBinder, java.lang.String str) {
            this.b = iBinder;
            this.c = str;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this.b;
        }

        public java.lang.String getId(java.lang.String str, java.lang.String str2, java.lang.String str3) {
            java.lang.String str4;
            android.os.Parcel obtain = android.os.Parcel.obtain();
            android.os.Parcel obtain2 = android.os.Parcel.obtain();
            java.lang.String str5 = null;
            try {
                str4 = this.c;
            } catch (java.lang.Throwable unused) {
                obtain2.recycle();
                obtain.recycle();
            }
            if (str4 == null) {
                return null;
            }
            obtain.writeInterfaceToken(str4);
            obtain.writeString(str);
            obtain.writeString(str2);
            obtain.writeString(str3);
            this.b.transact(1, obtain, obtain2, 0);
            obtain2.readException();
            str5 = obtain2.readString();
            obtain2.recycle();
            obtain.recycle();
            return str5;
        }
    }

    class AO {
        private int[] b;
        private int[] c;
        private android.content.Context d;
        private int[] e;

        private AO(android.content.Context context) {
            this.b = new int[]{246, 251, 243, com.igexin.push.config.c.E, 157, 214, 251, 192, 215, 219, com.qq.e.comm.adevent.AdEventType.VIDEO_PRELOADED, 219, 198, 220, 215, 214, 251, 157, 192, 215, 214, 219, 196, 221, 192, 226, 214, 251, 156, 193, 223, 196, 156, 221, 196, 219, 196, 156, 223, 221, com.qq.e.comm.adevent.AdEventType.VIDEO_INIT, 157, 157, com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_PACKAGE_NAME, 198, 220, 215, 198, 220, 221, com.qq.e.comm.adevent.AdEventType.VIDEO_INIT, 0};
            this.c = new int[]{231, 234, 226, 236, 0};
            this.e = new int[]{194, com.qq.e.comm.adevent.AdEventType.VIDEO_ERROR, 199, 201, 242, 227, 225, 0};
            this.d = context;
        }

        public /* synthetic */ AO(cn.shuzilm.core.AIClient aIClient, android.content.Context context, cn.shuzilm.core.AIClient.AnonymousClass1 anonymousClass1) {
            this(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public java.lang.String a() {
            try {
                android.net.Uri parse = android.net.Uri.parse(cn.shuzilm.core.AIClient.this.a(cn.shuzilm.core.AIClient.F));
                int i = android.os.Build.VERSION.SDK_INT;
                android.content.ContentProviderClient acquireContentProviderClient = this.d.getContentResolver().acquireContentProviderClient(parse);
                if (acquireContentProviderClient == null) {
                    return null;
                }
                android.os.Bundle call = acquireContentProviderClient.call(cn.shuzilm.core.AIClient.this.a(this.e), null, null);
                if (i >= 24) {
                    acquireContentProviderClient.close();
                } else {
                    acquireContentProviderClient.release();
                }
                if (call != null && call.getInt("code", -1) == 0) {
                    return call.getString("id");
                }
                return null;
            } catch (java.lang.Throwable unused) {
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:12:0x0061 A[Catch: all -> 0x0070, TryCatch #0 {all -> 0x0070, blocks: (B:4:0x0004, B:6:0x000a, B:8:0x0055, B:10:0x005b, B:12:0x0061, B:13:0x006d, B:20:0x0028), top: B:2:0x0002 }] */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0055 A[Catch: all -> 0x0070, TryCatch #0 {all -> 0x0070, blocks: (B:4:0x0004, B:6:0x000a, B:8:0x0055, B:10:0x005b, B:12:0x0061, B:13:0x006d, B:20:0x0028), top: B:2:0x0002 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public java.lang.String a(int i) {
            android.database.Cursor query;
            if (i != 4) {
                if (i == 5) {
                    query = this.d.getContentResolver().query(android.net.Uri.parse(cn.shuzilm.core.AIClient.this.a(cn.shuzilm.core.AIClient.D)), null, null, new java.lang.String[]{cn.shuzilm.core.AIClient.this.a(this.c)}, null);
                    if (query != null) {
                    }
                    return r1;
                }
                query = null;
                if (query != null) {
                }
                return r1;
            }
            if (android.os.Build.VERSION.SDK_INT > 27) {
                query = this.d.getContentResolver().query(android.net.Uri.parse(cn.shuzilm.core.AIClient.this.a(this.b)), null, null, null, null);
                if (query != null && !query.isClosed()) {
                    r1 = query.moveToNext() ? query.getString(query.getColumnIndex("value")) : null;
                    query.close();
                }
                return r1;
            }
            query = null;
            if (query != null) {
                if (query.moveToNext()) {
                }
                query.close();
            }
            return r1;
        }
    }

    interface HI {

        public abstract class u extends android.os.Binder implements cn.shuzilm.core.AIClient.HI {

            public class d implements cn.shuzilm.core.AIClient.HI {
                private android.os.IBinder a;

                public d(android.os.IBinder iBinder) {
                    this.a = iBinder;
                }

                @Override // cn.shuzilm.core.AIClient.HI
                public void b(cn.shuzilm.core.AIClient.HII.OI oi) {
                    android.os.Parcel obtain = android.os.Parcel.obtain();
                    android.os.Parcel obtain2 = android.os.Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.hihonor.cloudservice.oaid.IOAIDService");
                        obtain.writeStrongBinder(oi);
                        this.a.transact(2, obtain, obtain2, 0);
                        obtain2.readException();
                    } finally {
                        try {
                        } finally {
                        }
                    }
                }
            }
        }

        void b(cn.shuzilm.core.AIClient.HII.OI oi);
    }

    public interface HII extends android.os.IInterface {

        public abstract class OI extends android.os.Binder implements cn.shuzilm.core.AIClient.HII {
            java.lang.String a = "com.hihonor.cloudservice.oaid.IOAIDCallBack";

            public OI() {
                attachInterface(this, "com.hihonor.cloudservice.oaid.IOAIDCallBack");
            }

            @Override // android.os.IInterface
            public android.os.IBinder asBinder() {
                return this;
            }

            @Override // android.os.Binder
            public boolean onTransact(int i, android.os.Parcel parcel, android.os.Parcel parcel2, int i2) {
                if (i == 2) {
                    try {
                        parcel.enforceInterface(this.a);
                        go(parcel.readInt(), parcel.readInt() == 0 ? null : (android.os.Bundle) android.os.Bundle.CREATOR.createFromParcel(parcel));
                        parcel2.writeNoException();
                        return true;
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                    }
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        void go(int i, android.os.Bundle bundle);
    }

    final class HNO implements android.os.IInterface {
        private android.os.IBinder b;

        public HNO(android.os.IBinder iBinder) {
            this.b = iBinder;
        }

        @Override // android.os.IInterface
        public android.os.IBinder asBinder() {
            return this.b;
        }

        public void getID() {
            try {
                android.os.IBinder iBinder = this.b;
                if (iBinder == null) {
                    return;
                }
                java.lang.Object queryLocalInterface = iBinder.queryLocalInterface(cn.shuzilm.core.AIClient.this.a(cn.shuzilm.core.AIClient.W));
                ((queryLocalInterface == null || !(queryLocalInterface instanceof cn.shuzilm.core.AIClient.HI.u.d)) ? new cn.shuzilm.core.AIClient.HI.u.d(this.b) : (cn.shuzilm.core.AIClient.HI.u.d) queryLocalInterface).b(cn.shuzilm.core.AIClient.this.new gid());
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class gid extends cn.shuzilm.core.AIClient.HII.OI {
        public gid() {
        }

        @Override // cn.shuzilm.core.AIClient.HII
        public void go(int i, android.os.Bundle bundle) {
            try {
                java.lang.String string = bundle.getString(cn.shuzilm.core.AIClient.this.a(new int[]{238, 232, 229, 239, 214, 237, 224, 214, 232, 230, 0}));
                cn.shuzilm.core.AIClient aIClient = cn.shuzilm.core.AIClient.this;
                aIClient.a(string, aIClient.a(cn.shuzilm.core.AIClient.X));
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    public AIClient(android.content.Context context) {
        this.aa = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized java.lang.String a(int[] iArr) {
        java.lang.String str = null;
        if (iArr == null) {
            return null;
        }
        try {
            int length = iArr.length;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            int i2 = length + 126;
            for (int i3 = 0; i3 < length; i3++) {
                if (i3 != 0) {
                    sb.append(java.lang.Character.toString((char) (iArr[(length - i3) - 1] ^ i2)));
                }
            }
            str = sb.toString();
        } catch (java.lang.Exception unused) {
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(java.lang.String str, java.lang.String str2) {
        if (str != null && str2 != null) {
            if (!str.isEmpty() && !str2.isEmpty()) {
                try {
                    byte[] bArr = new byte[3];
                    byte[] encode = android.util.Base64.encode(str.getBytes(), 0);
                    bArr[1] = 115;
                    if (encode != null) {
                        try {
                            byte[] bArr2 = new byte[encode.length];
                            int i2 = 0;
                            for (byte b2 : encode) {
                                if (33 < b2 && b2 < 126) {
                                    bArr2[i2] = b2;
                                    i2++;
                                }
                            }
                            bArr[0] = org.apache.tools.tar.TarConstants.LF_GNUTYPE_LONGLINK;
                            byte[] bArr3 = new byte[i2];
                            java.lang.System.arraycopy(bArr2, 0, bArr3, 0, i2);
                            bArr[2] = 90;
                            if (i2 < 256) {
                                str = new java.lang.String(bArr, "UTF-8") + new java.lang.String(bArr3, "UTF-8");
                            }
                        } catch (java.lang.Exception unused) {
                        }
                    }
                    android.content.SharedPreferences sharedPreferences = this.aa.getSharedPreferences(this.aa.getPackageName() + a(g), 0);
                    if (sharedPreferences != null) {
                        java.lang.String string = sharedPreferences.getString(str2, "a");
                        if (string != null && string.equals(str)) {
                            return;
                        }
                        android.content.SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString(str2, str);
                        edit.apply();
                    }
                } catch (java.lang.Exception unused2) {
                }
            }
        }
    }

    private void a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        android.os.IBinder iBinder;
        try {
            java.lang.reflect.Method declaredMethod = java.lang.Class.forName(str).getDeclaredMethod(str2, java.lang.String.class);
            if (declaredMethod == null || (iBinder = (android.os.IBinder) declaredMethod.invoke(null, str3)) == null) {
                return;
            }
            android.os.Parcel obtain = android.os.Parcel.obtain();
            android.os.Parcel obtain2 = android.os.Parcel.obtain();
            try {
                iBinder.transact(4, obtain, obtain2, 0);
                java.lang.String readString = obtain2.readString();
                if (readString != null && !readString.isEmpty()) {
                    a(readString, str4);
                }
            } catch (java.lang.Exception unused) {
            } catch (java.lang.Throwable th) {
                obtain.recycle();
                obtain2.recycle();
                throw th;
            }
            obtain.recycle();
            obtain2.recycle();
        } catch (java.lang.Throwable unused2) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00f4, code lost:
    
        if (r10 == null) goto L42;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, int i2) {
        android.content.Intent intent;
        android.content.Intent intent2;
        cn.shuzilm.core.AIClient.AI ai;
        java.lang.String id;
        try {
            android.content.Intent intent3 = null;
            cn.shuzilm.core.AIClient.AC ac = new cn.shuzilm.core.AIClient.AC(null);
            if (i2 == 0) {
                android.content.Intent intent4 = new android.content.Intent(str2);
                intent4.setPackage(str3);
                intent3 = intent4;
            } else {
                if (i2 == 1) {
                    intent2 = new android.content.Intent();
                    intent2.setClassName(str, str2);
                } else if (i2 == 2) {
                    intent3 = new android.content.Intent();
                    intent3.setComponent(new android.content.ComponentName(str, str2));
                    intent3.setAction(str3);
                } else {
                    if (i2 == 3) {
                        intent = new android.content.Intent();
                        intent.setAction(str3);
                        intent.setComponent(new android.content.ComponentName(str, str));
                    } else if (i2 == 6) {
                        intent3 = new android.content.Intent();
                        intent3.setClassName(str, str2);
                        intent3.setAction(str3);
                        intent3.putExtra(a(K), this.aa.getApplicationInfo().packageName);
                    } else if (i2 == 7) {
                        intent2 = new android.content.Intent();
                        intent2.setComponent(new android.content.ComponentName(str, str2));
                    } else if (i2 == 8) {
                        intent = new android.content.Intent();
                        intent.setAction(str3);
                        intent.setPackage(str);
                    }
                    intent3 = intent;
                }
                intent3 = intent2;
            }
            if (this.aa.bindService(intent3, ac, 1)) {
                if (i2 == 2) {
                    try {
                        java.lang.Thread.sleep(100L);
                    } catch (java.lang.Exception e2) {
                        e2.printStackTrace();
                    }
                    id = new cn.shuzilm.core.AIClient.AIO(ac.getBinder(), str4).getId(this.aa.getPackageName(), e(), a(f73s));
                    if (id != null) {
                    }
                    this.aa.unbindService(ac);
                }
                if (i2 == 8) {
                    new cn.shuzilm.core.AIClient.HNO(ac.getBinder()).getID();
                } else {
                    if (i2 != 3 && i2 != 6) {
                        ai = i2 == 7 ? new cn.shuzilm.core.AIClient.AI(ac.getBinder(), str4, 2) : new cn.shuzilm.core.AIClient.AI(ac.getBinder(), str4, 1);
                        id = ai.getId();
                    }
                    ai = new cn.shuzilm.core.AIClient.AI(ac.getBinder(), str4, 3);
                    id = ai.getId();
                }
                this.aa.unbindService(ac);
                a(id, str5);
                this.aa.unbindService(ac);
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    private boolean a(java.lang.String str) {
        android.content.SharedPreferences sharedPreferences = this.aa.getSharedPreferences(this.aa.getPackageName() + a(g), 0);
        if (sharedPreferences != null) {
            return sharedPreferences.contains(str);
        }
        return false;
    }

    private boolean a(java.lang.String str, int i2) {
        return true;
    }

    private java.lang.String b(java.lang.String str) {
        try {
            android.content.SharedPreferences sharedPreferences = this.aa.getSharedPreferences(this.aa.getPackageName() + a(g), 0);
            return sharedPreferences != null ? sharedPreferences.getString(str, "") : "";
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(java.util.concurrent.LinkedBlockingQueue linkedBlockingQueue, android.os.IBinder iBinder) {
        try {
            new java.lang.Thread(new cn.shuzilm.core.AIClient.AnonymousClass1(linkedBlockingQueue, iBinder)).start();
        } catch (java.lang.Exception unused) {
        }
    }

    private boolean b(java.lang.String str, int i2) {
        java.lang.String str2;
        java.lang.String absolutePath;
        int lastIndexOf;
        boolean z2 = false;
        try {
            java.io.File externalFilesDir = this.aa.getExternalFilesDir(null);
            if (externalFilesDir == null || (lastIndexOf = (absolutePath = externalFilesDir.getAbsolutePath()).lastIndexOf("/data/")) == -1) {
                str2 = "";
            } else {
                str2 = absolutePath.substring(0, lastIndexOf) + "/data/";
            }
            z2 = new java.io.File(str2 + str).exists();
        } catch (java.lang.Exception unused) {
        }
        if (z2) {
            return true;
        }
        return c(str, i2);
    }

    private java.lang.String c(java.lang.String str) {
        try {
            android.content.SharedPreferences sharedPreferences = this.aa.getSharedPreferences(this.aa.getPackageName() + a(g), 0);
            if (sharedPreferences == null) {
                return "";
            }
            android.content.SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.remove(str);
            edit.apply();
            return "";
        } catch (java.lang.Throwable unused) {
            return "";
        }
    }

    private boolean c(java.lang.String str, int i2) {
        if (str == null) {
            return false;
        }
        try {
            return this.aa.getPackageManager().checkPermission("android.permission.INTERNET", str) == 0;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    private java.lang.String d(java.lang.String str) {
        if (str == null) {
            return null;
        }
        try {
            java.lang.Class<?> cls = java.lang.Class.forName(a(p));
            return (java.lang.String) cls.getMethod(com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, java.lang.String.class, java.lang.String.class).invoke(cls, str, "unknown");
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    private java.lang.String e() {
        android.content.pm.Signature[] signatureArr;
        if (this.ab == null) {
            try {
                signatureArr = this.aa.getPackageManager().getPackageInfo(this.aa.getPackageName(), 64).signatures;
            } catch (java.lang.Exception unused) {
                signatureArr = null;
            }
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("SHA1");
                    if (messageDigest != null) {
                        byte[] digest = messageDigest.digest(byteArray);
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        for (byte b2 : digest) {
                            sb.append(java.lang.Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                        }
                        this.ab = sb.toString();
                    }
                } catch (java.lang.Exception unused2) {
                }
            }
        }
        return this.ab;
    }

    private synchronized java.lang.String e(java.lang.String str) {
        java.lang.String str2 = null;
        if (str == null) {
            return null;
        }
        try {
            byte[] bytes = str.getBytes();
            int length = bytes.length;
            for (int i2 = 0; i2 < length; i2++) {
                bytes[i2] = (byte) (bytes[i2] + 17);
            }
            str2 = new java.lang.String(bytes);
        } catch (java.lang.Exception unused) {
        }
        return str2;
    }

    private void f() {
        try {
            int[] iArr = {255, 232, 251, 255, 232, com.getui.gtc.extension.distribution.gbd.d.g.aI, 236, com.getui.gtc.extension.distribution.gbd.d.g.aI, 224, com.qq.e.comm.adevent.AdEventType.VIDEO_READY, 224, 248, 251, 226, 0};
            int[] iArr2 = {226, 239, 231, 201, 242, 227, 225, 0};
            int[] iArr3 = {170, 174, 171, 173, 167, 171, 218, 220, com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_STREAM_TYPE_AC4, 218, 219, 219, 217, 170, 168, 174, 220, 169, 169, 167, 175, 171, 167, 220, 171, 218, 174, 217, 173, 221, com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_MODE_LIVE, com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_STREAM_TYPE_AC4, 0};
            java.lang.Object systemService = this.aa.getSystemService(a(iArr));
            if (systemService == null) {
                return;
            }
            java.lang.String str = (java.lang.String) systemService.getClass().getDeclaredMethod(a(iArr2), new java.lang.Class[0]).invoke(systemService, new java.lang.Object[0]);
            if (j == null) {
                return;
            }
            a(str, a(iArr3));
        } catch (java.lang.Exception unused) {
        }
    }

    private boolean f(java.lang.String str) {
        if (str == null) {
            return false;
        }
        try {
            java.lang.String str2 = android.os.Build.MANUFACTURER;
            if (str2 == null) {
                return false;
            }
            java.lang.String upperCase = str2.toUpperCase();
            java.lang.String e2 = e(str);
            if (e2 != null) {
                return upperCase.equals(e2);
            }
            return false;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    private void g() {
        try {
            android.app.KeyguardManager keyguardManager = (android.app.KeyguardManager) this.aa.getSystemService("keyguard");
            a((java.lang.String) keyguardManager.getClass().getDeclaredMethod(a(new int[]{237, 224, 232, 198, 231, 224, 232, com.igexin.push.config.c.E, 235, 230, 0}), new java.lang.Class[0]).invoke(keyguardManager, new java.lang.Object[0]), a(new int[]{221, 170, 171, 173, com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_STREAM_TYPE_AC4, com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_STREAM_TYPE_AC4, 168, 174, 220, 173, 220, com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_MODE_LIVE, 220, 175, 220, 175, 168, 167, 221, com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_STREAM_TYPE_AC4, com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_MODE_LIVE, com.autonavi.amap.mapcore.AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, com.autonavi.amap.mapcore.AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 219, 221, 219, 218, 221, 170, com.autonavi.amap.mapcore.AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 219, 174, 0}));
        } catch (java.lang.Throwable unused) {
        }
    }

    private void h() {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName(a(G));
            a((java.lang.String) cls.getMethod(a(new int[]{194, com.qq.e.comm.adevent.AdEventType.VIDEO_ERROR, 199, 201, 242, 227, 225, 0}), android.content.Context.class).invoke(cls.newInstance(), this.aa), a(new int[]{com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_STREAM_TYPE_AC4, 175, 170, 217, 168, 170, com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_STREAM_TYPE_AC4, 221, 174, 173, com.autonavi.amap.mapcore.AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, com.autonavi.amap.mapcore.AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 218, 220, 220, 169, 219, 174, com.autonavi.amap.mapcore.AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 219, 174, 171, 169, 174, com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_STREAM_TYPE_AC4, 169, 219, com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_MODE_LIVE, 173, com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_MODE_LIVE, 171, 175, 0}));
        } catch (java.lang.Exception unused) {
        }
    }

    private boolean i() {
        long j2 = Y;
        long currentTimeMillis = java.lang.System.currentTimeMillis() / 1000;
        if (j2 == 0) {
            Y = currentTimeMillis;
            return true;
        }
        if (currentTimeMillis - Y <= 10) {
            return false;
        }
        Y = java.lang.System.currentTimeMillis() / 1000;
        return true;
    }

    private boolean j() {
        long j2 = Z;
        long currentTimeMillis = java.lang.System.currentTimeMillis() / 1000;
        if (j2 == 0) {
            Z = currentTimeMillis;
            return true;
        }
        if (currentTimeMillis - Z <= 5) {
            return false;
        }
        Z = java.lang.System.currentTimeMillis() / 1000;
        return true;
    }

    private boolean k() {
        java.lang.String d2 = d(a(o));
        return !android.text.TextUtils.isEmpty(d2) && d2.equals("1");
    }

    private boolean l() {
        java.lang.String d2 = d(a(S));
        return !android.text.TextUtils.isEmpty(d2) && d2.equalsIgnoreCase(a(R));
    }

    private boolean n() {
        java.lang.String d2 = d(a(P));
        return (android.text.TextUtils.isEmpty(d2) || d2.equalsIgnoreCase("unknown")) ? false : true;
    }

    private boolean o() {
        android.content.pm.PackageManager packageManager;
        try {
            if (f("<48ID") && (packageManager = this.aa.getPackageManager()) != null) {
                return packageManager.resolveContentProvider(a(E), 0) != null;
            }
            return false;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    private boolean p() {
        if (!f("=D180")) {
            return false;
        }
        int i2 = android.os.Build.VERSION.SDK_INT;
        android.content.ContentProviderClient acquireUnstableContentProviderClient = this.aa.getContentResolver().acquireUnstableContentProviderClient(android.net.Uri.parse(a(F)));
        android.os.Bundle call = acquireUnstableContentProviderClient.call("isSupport", null, null);
        if (call != null) {
            if (i2 >= 24) {
                acquireUnstableContentProviderClient.close();
            } else {
                acquireUnstableContentProviderClient.release();
            }
            if (call.getInt("code", -1) == 0) {
                return call.getBoolean("isSupport", true);
            }
        }
        return false;
    }

    private void q() {
        android.content.Intent intent = new android.content.Intent();
        intent.setClassName(a(H), a(I));
        intent.setAction(a(J));
        intent.putExtra(a(K), this.aa.getApplicationInfo().packageName);
        try {
            intent.putExtra(a(L), true);
            this.aa.startService(intent);
        } catch (java.lang.Exception unused) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(62:8|(1:12)|(3:13|14|(1:18))|20|(2:21|22)|(51:26|27|28|29|30|31|(1:167)|35|36|(1:40)|42|43|(1:45)|47|48|(1:52)|54|(1:56)|57|(1:59)|60|61|(1:65)|67|68|(1:158)|72|73|(1:153)|77|78|(1:82)|84|85|(1:147)|89|(1:93)|94|95|96|(3:100|(1:109)|(1:108)(1:107))|110|(1:112)|113|114|(1:116)|118|119|(4:123|(3:130|131|132)|134|(2:136|(3:138|131|132)))|139|140)|173|30|31|(1:33)|165|167|35|36|(2:38|40)|42|43|(0)|47|48|(2:50|52)|54|(0)|57|(0)|60|61|(2:63|65)|67|68|(1:70)|156|158|72|73|(1:75)|151|153|77|78|(2:80|82)|84|85|(1:87)|145|147|89|(2:91|93)|94|95|96|(6:98|100|(1:102)|109|(1:105)|108)|110|(0)|113|114|(0)|118|119|(5:121|123|(5:125|127|130|131|132)|134|(0))|139|140) */
    /* JADX WARN: Can't wrap try/catch for region: R(64:8|(1:12)|13|14|(1:18)|20|(2:21|22)|(51:26|27|28|29|30|31|(1:167)|35|36|(1:40)|42|43|(1:45)|47|48|(1:52)|54|(1:56)|57|(1:59)|60|61|(1:65)|67|68|(1:158)|72|73|(1:153)|77|78|(1:82)|84|85|(1:147)|89|(1:93)|94|95|96|(3:100|(1:109)|(1:108)(1:107))|110|(1:112)|113|114|(1:116)|118|119|(4:123|(3:130|131|132)|134|(2:136|(3:138|131|132)))|139|140)|173|30|31|(1:33)|165|167|35|36|(2:38|40)|42|43|(0)|47|48|(2:50|52)|54|(0)|57|(0)|60|61|(2:63|65)|67|68|(1:70)|156|158|72|73|(1:75)|151|153|77|78|(2:80|82)|84|85|(1:87)|145|147|89|(2:91|93)|94|95|96|(6:98|100|(1:102)|109|(1:105)|108)|110|(0)|113|114|(0)|118|119|(5:121|123|(5:125|127|130|131|132)|134|(0))|139|140) */
    /* JADX WARN: Can't wrap try/catch for region: R(65:8|(1:12)|13|14|(1:18)|20|21|22|(51:26|27|28|29|30|31|(1:167)|35|36|(1:40)|42|43|(1:45)|47|48|(1:52)|54|(1:56)|57|(1:59)|60|61|(1:65)|67|68|(1:158)|72|73|(1:153)|77|78|(1:82)|84|85|(1:147)|89|(1:93)|94|95|96|(3:100|(1:109)|(1:108)(1:107))|110|(1:112)|113|114|(1:116)|118|119|(4:123|(3:130|131|132)|134|(2:136|(3:138|131|132)))|139|140)|173|30|31|(1:33)|165|167|35|36|(2:38|40)|42|43|(0)|47|48|(2:50|52)|54|(0)|57|(0)|60|61|(2:63|65)|67|68|(1:70)|156|158|72|73|(1:75)|151|153|77|78|(2:80|82)|84|85|(1:87)|145|147|89|(2:91|93)|94|95|96|(6:98|100|(1:102)|109|(1:105)|108)|110|(0)|113|114|(0)|118|119|(5:121|123|(5:125|127|130|131|132)|134|(0))|139|140) */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0a30, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0a31, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0a3d  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0a4c A[Catch: Exception -> 0x0ae7, TRY_LEAVE, TryCatch #11 {Exception -> 0x0ae7, blocks: (B:114:0x0a40, B:116:0x0a4c), top: B:113:0x0a40 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0b42 A[Catch: Exception -> 0x0b77, TryCatch #2 {Exception -> 0x0b77, blocks: (B:119:0x0ae7, B:121:0x0af3, B:123:0x0af9, B:125:0x0b01, B:127:0x0b09, B:130:0x0b12, B:132:0x0b71, B:134:0x0b36, B:136:0x0b42, B:138:0x0b52), top: B:118:0x0ae7 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x02bc A[Catch: Exception -> 0x035d, TRY_LEAVE, TryCatch #8 {Exception -> 0x035d, blocks: (B:43:0x02b4, B:45:0x02bc), top: B:42:0x02b4 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x040f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x042f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void asynAI(int i2) {
        int i3;
        java.lang.String a2;
        java.lang.String a3;
        java.lang.String a4;
        java.lang.String a5;
        java.lang.String a6;
        int[] iArr;
        java.lang.String string;
        java.lang.String str;
        if (isOaidCollectAllowed(i2)) {
            isf = false;
            if (a > 0) {
                return;
            }
            if (k() && i()) {
                a(new cn.shuzilm.core.AIClient.AO(this, this.aa, null).a(4), a(new int[]{com.autonavi.amap.mapcore.AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 167, 217, 167, com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_STREAM_TYPE_AC4, 217, 220, com.autonavi.amap.mapcore.AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 219, com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_MODE_LIVE, 170, 221, 168, 168, 170, 220, com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_STREAM_TYPE_AC4, 174, 171, 173, 174, 217, 175, 174, 221, 221, 219, 218, com.autonavi.amap.mapcore.AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 221, 168, 219, 0}));
            }
            try {
                if (f(";4=>E>") && a(a(k), 0)) {
                    a(a(k), a(l), null, a(m), a(n), 1);
                }
            } catch (java.lang.Exception unused) {
            }
            if (f("<>C>A>;0") && a(a(k), 0)) {
                i3 = 2;
                try {
                    a(a(k), a(l), null, a(m), a(new int[]{168, 170, 173, 221, com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_STREAM_TYPE_AC4, 171, 169, 167, com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_STREAM_TYPE_AC4, com.autonavi.amap.mapcore.AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, com.autonavi.amap.mapcore.AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 217, 217, com.autonavi.amap.mapcore.AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_STREAM_TYPE_AC4, 175, 221, 167, 173, 173, com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_STREAM_TYPE_AC4, com.autonavi.amap.mapcore.AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 217, com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_STREAM_TYPE_AC4, 220, 219, com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_STREAM_TYPE_AC4, 174, 218, 169, com.autonavi.amap.mapcore.AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 217, 0}), 1);
                } catch (java.lang.Exception unused2) {
                }
                if ((!f(">??>") || f("A40;<4")) && a(a(q), 0)) {
                    int[] iArr2 = new int[33];
                    iArr2[0] = 222;
                    iArr2[1] = 174;
                    iArr2[i3] = 168;
                    iArr2[3] = 169;
                    iArr2[4] = 219;
                    iArr2[5] = 170;
                    iArr2[6] = 175;
                    iArr2[7] = 221;
                    iArr2[8] = 218;
                    iArr2[9] = 221;
                    iArr2[10] = 170;
                    iArr2[11] = 218;
                    iArr2[12] = 170;
                    iArr2[13] = 168;
                    iArr2[14] = 173;
                    iArr2[15] = 169;
                    iArr2[16] = 217;
                    iArr2[17] = 169;
                    iArr2[18] = 174;
                    iArr2[19] = 166;
                    iArr2[20] = 175;
                    iArr2[21] = 171;
                    iArr2[22] = 220;
                    iArr2[23] = 168;
                    iArr2[24] = 172;
                    iArr2[25] = 220;
                    iArr2[26] = 222;
                    iArr2[27] = 166;
                    iArr2[28] = 175;
                    iArr2[29] = 167;
                    iArr2[30] = 170;
                    iArr2[31] = 170;
                    iArr2[32] = 0;
                    a(a(q), a(r), a(u), a(t), a(iArr2), 2);
                }
                if (f(">=4?;DB") && a(a(q), i3)) {
                    int[] iArr3 = new int[33];
                    iArr3[0] = 173;
                    iArr3[1] = 169;
                    iArr3[i3] = 167;
                    iArr3[3] = 217;
                    iArr3[4] = 219;
                    iArr3[5] = 219;
                    iArr3[6] = 218;
                    iArr3[7] = 221;
                    iArr3[8] = 220;
                    iArr3[9] = 167;
                    iArr3[10] = 218;
                    iArr3[11] = 220;
                    iArr3[12] = 217;
                    iArr3[13] = 167;
                    iArr3[14] = 222;
                    iArr3[15] = 169;
                    iArr3[16] = 172;
                    iArr3[17] = 172;
                    iArr3[18] = 220;
                    iArr3[19] = 217;
                    iArr3[20] = 219;
                    iArr3[21] = 217;
                    iArr3[22] = 172;
                    iArr3[23] = 168;
                    iArr3[24] = 221;
                    iArr3[25] = 168;
                    iArr3[26] = 221;
                    iArr3[27] = 173;
                    iArr3[28] = 167;
                    iArr3[29] = 175;
                    iArr3[30] = 171;
                    iArr3[31] = 166;
                    iArr3[32] = 0;
                    a(a(q), a(r), a(u), a(t), a(iArr3), 2);
                }
                if (f("0BDB")) {
                    int[] iArr4 = new int[33];
                    iArr4[0] = 217;
                    iArr4[1] = 170;
                    iArr4[i3] = 217;
                    iArr4[3] = 218;
                    iArr4[4] = 166;
                    iArr4[5] = 174;
                    iArr4[6] = 221;
                    iArr4[7] = 222;
                    iArr4[8] = 174;
                    iArr4[9] = 167;
                    iArr4[10] = 171;
                    iArr4[11] = 174;
                    iArr4[12] = 173;
                    iArr4[13] = 217;
                    iArr4[14] = 221;
                    iArr4[15] = 170;
                    iArr4[16] = 171;
                    iArr4[17] = 169;
                    iArr4[18] = 217;
                    iArr4[19] = 221;
                    iArr4[20] = 171;
                    iArr4[21] = 166;
                    iArr4[22] = 167;
                    iArr4[23] = 171;
                    iArr4[24] = 173;
                    iArr4[25] = 218;
                    iArr4[26] = 170;
                    iArr4[27] = 217;
                    iArr4[28] = 172;
                    iArr4[29] = 167;
                    iArr4[30] = 170;
                    iArr4[31] = 171;
                    iArr4[32] = 0;
                    a(a(x), a(y), a(w), a(z), a(iArr4), 3);
                }
                if (f("B0<BD=6") && a(a(A), 0)) {
                    int[] iArr5 = new int[33];
                    iArr5[0] = 175;
                    iArr5[1] = 220;
                    iArr5[i3] = 167;
                    iArr5[3] = 172;
                    iArr5[4] = 175;
                    iArr5[5] = 219;
                    iArr5[6] = 170;
                    iArr5[7] = 173;
                    iArr5[8] = 173;
                    iArr5[9] = 222;
                    iArr5[10] = 175;
                    iArr5[11] = 219;
                    iArr5[12] = 168;
                    iArr5[13] = 219;
                    iArr5[14] = 217;
                    iArr5[15] = 170;
                    iArr5[16] = 221;
                    iArr5[17] = 167;
                    iArr5[18] = 218;
                    iArr5[19] = 175;
                    iArr5[20] = 172;
                    iArr5[21] = 218;
                    iArr5[22] = 217;
                    iArr5[23] = 218;
                    iArr5[24] = 221;
                    iArr5[25] = 219;
                    iArr5[26] = 217;
                    iArr5[27] = 217;
                    iArr5[28] = 172;
                    iArr5[29] = 173;
                    iArr5[30] = 221;
                    iArr5[31] = 174;
                    iArr5[32] = 0;
                    a(a(A), a(B), null, a(C), a(iArr5), 1);
                }
                if (o()) {
                    a(new cn.shuzilm.core.AIClient.AO(this, this.aa, null).a(5), a(new int[]{175, com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_MODE_LIVE, com.autonavi.amap.mapcore.AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 169, 175, 167, com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_STREAM_TYPE_AC4, com.autonavi.amap.mapcore.AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 218, 174, 174, 218, 168, 175, 169, 217, 167, 171, com.autonavi.amap.mapcore.AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 170, 217, 169, 173, 219, 221, 219, 168, com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_STREAM_TYPE_AC4, com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_STREAM_TYPE_AC4, 221, com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_STREAM_TYPE_AC4, 175, 0}));
                }
                if (p()) {
                    a(new cn.shuzilm.core.AIClient.AO(this, this.aa, null).a(), a(new int[]{220, 174, 168, 218, 174, 217, 220, 219, 218, 168, 170, 167, 169, 221, 169, com.autonavi.amap.mapcore.AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_MODE_LIVE, 218, 220, com.autonavi.amap.mapcore.AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 217, com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_STREAM_TYPE_AC4, 170, 167, 219, com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_STREAM_TYPE_AC4, 221, 218, com.google.android.exoplayer2.extractor.ts.TsExtractor.TS_STREAM_TYPE_AC4, 173, 221, 170, 0}));
                }
                if (f("IC4") && a(a(H), i3)) {
                    q();
                    int[] iArr6 = new int[33];
                    iArr6[0] = 167;
                    iArr6[1] = 222;
                    iArr6[i3] = 222;
                    iArr6[3] = 171;
                    iArr6[4] = 171;
                    iArr6[5] = 167;
                    iArr6[6] = 168;
                    iArr6[7] = 217;
                    iArr6[8] = 174;
                    iArr6[9] = 219;
                    iArr6[10] = 166;
                    iArr6[11] = 175;
                    iArr6[12] = 174;
                    iArr6[13] = 168;
                    iArr6[14] = 166;
                    iArr6[15] = 169;
                    iArr6[16] = 217;
                    iArr6[17] = 174;
                    iArr6[18] = 220;
                    iArr6[19] = 218;
                    iArr6[20] = 168;
                    iArr6[21] = 168;
                    iArr6[22] = 217;
                    iArr6[23] = 174;
                    iArr6[24] = 175;
                    iArr6[25] = 174;
                    iArr6[26] = 220;
                    iArr6[27] = 217;
                    iArr6[28] = 175;
                    iArr6[29] = 222;
                    iArr6[30] = 222;
                    iArr6[31] = 220;
                    iArr6[32] = 0;
                    a(a(H), a(M), a(N), a(O), a(iArr6), 6);
                }
                if ((!l() || f("5A44<4>B")) && a(a(H), i3)) {
                    q();
                    int[] iArr7 = new int[33];
                    iArr7[0] = 169;
                    iArr7[1] = 172;
                    iArr7[i3] = 222;
                    iArr7[3] = 170;
                    iArr7[4] = 172;
                    iArr7[5] = 170;
                    iArr7[6] = 171;
                    iArr7[7] = 173;
                    iArr7[8] = 173;
                    iArr7[9] = 218;
                    iArr7[10] = 167;
                    iArr7[11] = 173;
                    iArr7[12] = 170;
                    iArr7[13] = 173;
                    iArr7[14] = 217;
                    iArr7[15] = 171;
                    iArr7[16] = 166;
                    iArr7[17] = 171;
                    iArr7[18] = 218;
                    iArr7[19] = 222;
                    iArr7[20] = 168;
                    iArr7[21] = 169;
                    iArr7[22] = 166;
                    iArr7[23] = 217;
                    iArr7[24] = 171;
                    iArr7[25] = 217;
                    iArr7[26] = 166;
                    iArr7[27] = 171;
                    iArr7[28] = 220;
                    iArr7[29] = 168;
                    iArr7[30] = 168;
                    iArr7[31] = 166;
                    iArr7[32] = 0;
                    a(a(H), a(M), a(N), a(O), a(iArr7), 6);
                }
                if ((!n() || f("BBD8")) && a(a(H), i3)) {
                    q();
                    int[] iArr8 = new int[33];
                    iArr8[0] = 220;
                    iArr8[1] = 170;
                    iArr8[i3] = 221;
                    iArr8[3] = 175;
                    iArr8[4] = 218;
                    iArr8[5] = 175;
                    iArr8[6] = 173;
                    iArr8[7] = 175;
                    iArr8[8] = 217;
                    iArr8[9] = 172;
                    iArr8[10] = 175;
                    iArr8[11] = 220;
                    iArr8[12] = 169;
                    iArr8[13] = 222;
                    iArr8[14] = 217;
                    iArr8[15] = 175;
                    iArr8[16] = 175;
                    iArr8[17] = 172;
                    iArr8[18] = 166;
                    iArr8[19] = 222;
                    iArr8[20] = 174;
                    iArr8[21] = 222;
                    iArr8[22] = 173;
                    iArr8[23] = 218;
                    iArr8[24] = 217;
                    iArr8[25] = 171;
                    iArr8[26] = 166;
                    iArr8[27] = 172;
                    iArr8[28] = 221;
                    iArr8[29] = 218;
                    iArr8[30] = 218;
                    iArr8[31] = 174;
                    iArr8[32] = 0;
                    a(a(H), a(M), a(N), a(O), a(iArr8), 6);
                }
                if (f("2>>;?03") && a(a(T), i3)) {
                    int[] iArr9 = new int[33];
                    iArr9[0] = 169;
                    iArr9[1] = 166;
                    iArr9[i3] = 222;
                    iArr9[3] = 217;
                    iArr9[4] = 167;
                    iArr9[5] = 168;
                    iArr9[6] = 217;
                    iArr9[7] = 220;
                    iArr9[8] = 217;
                    iArr9[9] = 168;
                    iArr9[10] = 172;
                    iArr9[11] = 172;
                    iArr9[12] = 174;
                    iArr9[13] = 169;
                    iArr9[14] = 170;
                    iArr9[15] = 168;
                    iArr9[16] = 171;
                    iArr9[17] = 219;
                    iArr9[18] = 219;
                    iArr9[19] = 221;
                    iArr9[20] = 219;
                    iArr9[21] = 172;
                    iArr9[22] = 222;
                    iArr9[23] = 167;
                    iArr9[24] = 220;
                    iArr9[25] = 217;
                    iArr9[26] = 168;
                    iArr9[27] = 173;
                    iArr9[28] = 174;
                    iArr9[29] = 166;
                    iArr9[30] = 173;
                    iArr9[31] = 166;
                    iArr9[32] = 0;
                    a(a(T), a(U), null, a(V), a(iArr9), 7);
                }
                str = android.os.Build.MANUFACTURER;
                if ((!str.equals("360") || str.equalsIgnoreCase("360UI")) && android.os.Build.VERSION.SDK_INT > 25) {
                    int[] iArr10 = new int[26];
                    iArr10[0] = 234;
                    iArr10[1] = 253;
                    iArr10[i3] = 255;
                    iArr10[3] = 249;
                    iArr10[4] = 246;
                    iArr10[5] = 249;
                    iArr10[6] = 213;
                    iArr10[7] = 253;
                    iArr10[8] = 251;
                    iArr10[9] = 241;
                    iArr10[10] = 238;
                    iArr10[11] = 234;
                    iArr10[12] = 253;
                    iArr10[13] = 203;
                    iArr10[14] = 182;
                    iArr10[15] = 235;
                    iArr10[16] = 247;
                    iArr10[17] = 182;
                    iArr10[18] = 252;
                    iArr10[19] = 241;
                    iArr10[20] = 247;
                    iArr10[21] = 234;
                    iArr10[22] = 252;
                    iArr10[23] = 246;
                    iArr10[24] = 249;
                    iArr10[25] = 0;
                    int[] iArr11 = new int[11];
                    iArr11[0] = 236;
                    iArr11[1] = 234;
                    iArr11[i3] = 224;
                    iArr11[3] = 255;
                    iArr11[4] = 251;
                    iArr11[5] = 236;
                    iArr11[6] = 218;
                    iArr11[7] = 253;
                    iArr11[8] = 236;
                    iArr11[9] = 238;
                    iArr11[10] = 0;
                    int[] iArr12 = new int[7];
                    iArr12[0] = 225;
                    iArr12[1] = 236;
                    iArr12[i3] = 240;
                    iArr12[3] = 238;
                    iArr12[4] = 236;
                    iArr12[5] = 244;
                    iArr12[6] = 0;
                    int[] iArr13 = new int[33];
                    iArr13[0] = 174;
                    iArr13[1] = 219;
                    iArr13[i3] = 174;
                    iArr13[3] = 172;
                    iArr13[4] = 217;
                    iArr13[5] = 172;
                    iArr13[6] = 168;
                    iArr13[7] = 217;
                    iArr13[8] = 172;
                    iArr13[9] = 219;
                    iArr13[10] = 219;
                    iArr13[11] = 171;
                    iArr13[12] = 217;
                    iArr13[13] = 221;
                    iArr13[14] = 168;
                    iArr13[15] = 167;
                    iArr13[16] = 174;
                    iArr13[17] = 220;
                    iArr13[18] = 168;
                    iArr13[19] = 169;
                    iArr13[20] = 217;
                    iArr13[21] = 171;
                    iArr13[22] = 220;
                    iArr13[23] = 175;
                    iArr13[24] = 170;
                    iArr13[25] = 221;
                    iArr13[26] = 175;
                    iArr13[27] = 220;
                    iArr13[28] = 175;
                    iArr13[29] = 220;
                    iArr13[30] = 167;
                    iArr13[31] = 172;
                    iArr13[32] = 0;
                    a(a(iArr10), a(iArr11), a(iArr12), a(iArr13));
                }
                if (f("4411:") && android.os.Build.VERSION.SDK_INT > 27) {
                    f();
                }
                iArr = new int[15];
                iArr[0] = 233;
                iArr[1] = 228;
                iArr[i3] = 163;
                iArr[3] = 255;
                iArr[4] = 226;
                iArr[5] = 227;
                iArr[6] = 226;
                iArr[7] = 229;
                iArr[8] = 228;
                iArr[9] = 229;
                iArr[10] = 163;
                iArr[11] = 224;
                iArr[12] = 226;
                iArr[13] = 238;
                iArr[14] = 0;
                if (f("7>=>A") && b(a(iArr), i3)) {
                    int[] iArr14 = new int[5];
                    iArr14[0] = 231;
                    iArr14[1] = 234;
                    iArr14[i3] = 226;
                    iArr14[3] = 236;
                    iArr14[4] = 0;
                    string = android.provider.Settings.Secure.getString(this.aa.getContentResolver(), a(iArr14));
                    if (string != null || string.isEmpty()) {
                        string = android.provider.Settings.Global.getString(this.aa.getContentResolver(), a(iArr14));
                    }
                    if (string != null || string.isEmpty()) {
                        int[] iArr15 = new int[29];
                        iArr15[0] = 254;
                        iArr15[1] = 248;
                        iArr15[i3] = 242;
                        iArr15[3] = 237;
                        iArr15[4] = 233;
                        iArr15[5] = 254;
                        iArr15[6] = 200;
                        iArr15[7] = 255;
                        iArr15[8] = 210;
                        iArr15[9] = 250;
                        iArr15[10] = 212;
                        iArr15[11] = 245;
                        iArr15[12] = 211;
                        iArr15[13] = 181;
                        iArr15[14] = 255;
                        iArr15[15] = 242;
                        iArr15[16] = 181;
                        iArr15[17] = 233;
                        iArr15[18] = 244;
                        iArr15[19] = 245;
                        iArr15[20] = 244;
                        iArr15[21] = 243;
                        iArr15[22] = 242;
                        iArr15[23] = 243;
                        iArr15[24] = 181;
                        iArr15[25] = 246;
                        iArr15[26] = 244;
                        iArr15[27] = 248;
                        iArr15[28] = 0;
                        a(a(iArr), "", a(iArr15), "", "", 8);
                    } else {
                        a(string, a(X));
                    }
                }
                g();
                if (m()) {
                    h();
                }
                if (b(a(h), 0)) {
                    int[] iArr16 = new int[33];
                    iArr16[0] = 219;
                    iArr16[1] = 220;
                    iArr16[i3] = 218;
                    iArr16[3] = 170;
                    iArr16[4] = 167;
                    iArr16[5] = 218;
                    iArr16[6] = 170;
                    iArr16[7] = 170;
                    iArr16[8] = 221;
                    iArr16[9] = 170;
                    iArr16[10] = 219;
                    iArr16[11] = 170;
                    iArr16[12] = 167;
                    iArr16[13] = 172;
                    iArr16[14] = 167;
                    iArr16[15] = 219;
                    iArr16[16] = 173;
                    iArr16[17] = 175;
                    iArr16[18] = 173;
                    iArr16[19] = 221;
                    iArr16[20] = 217;
                    iArr16[21] = 219;
                    iArr16[22] = 220;
                    iArr16[23] = 171;
                    iArr16[24] = 222;
                    iArr16[25] = 173;
                    iArr16[26] = 168;
                    iArr16[27] = 217;
                    iArr16[28] = 218;
                    iArr16[29] = 219;
                    iArr16[30] = 217;
                    iArr16[31] = 174;
                    iArr16[32] = 0;
                    a(a(h), a(i), a(h), a(j), a(iArr16), 0);
                }
                if (b(a(b), 0) && j()) {
                    if (!f(">??>") && !f("E8E>") && !f(">=4?;DB")) {
                        a2 = a(b);
                        a3 = a(c);
                        a4 = a(d);
                        a5 = a(e);
                        a6 = a(f);
                        a(a2, a3, a4, a5, a6, 0);
                    }
                    if (!a(a(f))) {
                        java.lang.Thread.sleep(60L);
                        if (new java.util.Random().nextInt(3) == 0) {
                            a2 = a(b);
                            a3 = a(c);
                            a4 = a(d);
                            a5 = a(e);
                            a6 = a(f);
                            a(a2, a3, a4, a5, a6, 0);
                        }
                    }
                }
                isf = true;
                a++;
            }
            i3 = 2;
            if (!f(">??>")) {
            }
            int[] iArr22 = new int[33];
            iArr22[0] = 222;
            iArr22[1] = 174;
            iArr22[i3] = 168;
            iArr22[3] = 169;
            iArr22[4] = 219;
            iArr22[5] = 170;
            iArr22[6] = 175;
            iArr22[7] = 221;
            iArr22[8] = 218;
            iArr22[9] = 221;
            iArr22[10] = 170;
            iArr22[11] = 218;
            iArr22[12] = 170;
            iArr22[13] = 168;
            iArr22[14] = 173;
            iArr22[15] = 169;
            iArr22[16] = 217;
            iArr22[17] = 169;
            iArr22[18] = 174;
            iArr22[19] = 166;
            iArr22[20] = 175;
            iArr22[21] = 171;
            iArr22[22] = 220;
            iArr22[23] = 168;
            iArr22[24] = 172;
            iArr22[25] = 220;
            iArr22[26] = 222;
            iArr22[27] = 166;
            iArr22[28] = 175;
            iArr22[29] = 167;
            iArr22[30] = 170;
            iArr22[31] = 170;
            iArr22[32] = 0;
            a(a(q), a(r), a(u), a(t), a(iArr22), 2);
            if (f(">=4?;DB")) {
                int[] iArr32 = new int[33];
                iArr32[0] = 173;
                iArr32[1] = 169;
                iArr32[i3] = 167;
                iArr32[3] = 217;
                iArr32[4] = 219;
                iArr32[5] = 219;
                iArr32[6] = 218;
                iArr32[7] = 221;
                iArr32[8] = 220;
                iArr32[9] = 167;
                iArr32[10] = 218;
                iArr32[11] = 220;
                iArr32[12] = 217;
                iArr32[13] = 167;
                iArr32[14] = 222;
                iArr32[15] = 169;
                iArr32[16] = 172;
                iArr32[17] = 172;
                iArr32[18] = 220;
                iArr32[19] = 217;
                iArr32[20] = 219;
                iArr32[21] = 217;
                iArr32[22] = 172;
                iArr32[23] = 168;
                iArr32[24] = 221;
                iArr32[25] = 168;
                iArr32[26] = 221;
                iArr32[27] = 173;
                iArr32[28] = 167;
                iArr32[29] = 175;
                iArr32[30] = 171;
                iArr32[31] = 166;
                iArr32[32] = 0;
                a(a(q), a(r), a(u), a(t), a(iArr32), 2);
            }
            if (f("0BDB")) {
            }
            if (f("B0<BD=6")) {
                int[] iArr52 = new int[33];
                iArr52[0] = 175;
                iArr52[1] = 220;
                iArr52[i3] = 167;
                iArr52[3] = 172;
                iArr52[4] = 175;
                iArr52[5] = 219;
                iArr52[6] = 170;
                iArr52[7] = 173;
                iArr52[8] = 173;
                iArr52[9] = 222;
                iArr52[10] = 175;
                iArr52[11] = 219;
                iArr52[12] = 168;
                iArr52[13] = 219;
                iArr52[14] = 217;
                iArr52[15] = 170;
                iArr52[16] = 221;
                iArr52[17] = 167;
                iArr52[18] = 218;
                iArr52[19] = 175;
                iArr52[20] = 172;
                iArr52[21] = 218;
                iArr52[22] = 217;
                iArr52[23] = 218;
                iArr52[24] = 221;
                iArr52[25] = 219;
                iArr52[26] = 217;
                iArr52[27] = 217;
                iArr52[28] = 172;
                iArr52[29] = 173;
                iArr52[30] = 221;
                iArr52[31] = 174;
                iArr52[32] = 0;
                a(a(A), a(B), null, a(C), a(iArr52), 1);
            }
            if (o()) {
            }
            if (p()) {
            }
            if (f("IC4")) {
                q();
                int[] iArr62 = new int[33];
                iArr62[0] = 167;
                iArr62[1] = 222;
                iArr62[i3] = 222;
                iArr62[3] = 171;
                iArr62[4] = 171;
                iArr62[5] = 167;
                iArr62[6] = 168;
                iArr62[7] = 217;
                iArr62[8] = 174;
                iArr62[9] = 219;
                iArr62[10] = 166;
                iArr62[11] = 175;
                iArr62[12] = 174;
                iArr62[13] = 168;
                iArr62[14] = 166;
                iArr62[15] = 169;
                iArr62[16] = 217;
                iArr62[17] = 174;
                iArr62[18] = 220;
                iArr62[19] = 218;
                iArr62[20] = 168;
                iArr62[21] = 168;
                iArr62[22] = 217;
                iArr62[23] = 174;
                iArr62[24] = 175;
                iArr62[25] = 174;
                iArr62[26] = 220;
                iArr62[27] = 217;
                iArr62[28] = 175;
                iArr62[29] = 222;
                iArr62[30] = 222;
                iArr62[31] = 220;
                iArr62[32] = 0;
                a(a(H), a(M), a(N), a(O), a(iArr62), 6);
            }
            if (!l()) {
            }
            q();
            int[] iArr72 = new int[33];
            iArr72[0] = 169;
            iArr72[1] = 172;
            iArr72[i3] = 222;
            iArr72[3] = 170;
            iArr72[4] = 172;
            iArr72[5] = 170;
            iArr72[6] = 171;
            iArr72[7] = 173;
            iArr72[8] = 173;
            iArr72[9] = 218;
            iArr72[10] = 167;
            iArr72[11] = 173;
            iArr72[12] = 170;
            iArr72[13] = 173;
            iArr72[14] = 217;
            iArr72[15] = 171;
            iArr72[16] = 166;
            iArr72[17] = 171;
            iArr72[18] = 218;
            iArr72[19] = 222;
            iArr72[20] = 168;
            iArr72[21] = 169;
            iArr72[22] = 166;
            iArr72[23] = 217;
            iArr72[24] = 171;
            iArr72[25] = 217;
            iArr72[26] = 166;
            iArr72[27] = 171;
            iArr72[28] = 220;
            iArr72[29] = 168;
            iArr72[30] = 168;
            iArr72[31] = 166;
            iArr72[32] = 0;
            a(a(H), a(M), a(N), a(O), a(iArr72), 6);
            if (!n()) {
            }
            q();
            int[] iArr82 = new int[33];
            iArr82[0] = 220;
            iArr82[1] = 170;
            iArr82[i3] = 221;
            iArr82[3] = 175;
            iArr82[4] = 218;
            iArr82[5] = 175;
            iArr82[6] = 173;
            iArr82[7] = 175;
            iArr82[8] = 217;
            iArr82[9] = 172;
            iArr82[10] = 175;
            iArr82[11] = 220;
            iArr82[12] = 169;
            iArr82[13] = 222;
            iArr82[14] = 217;
            iArr82[15] = 175;
            iArr82[16] = 175;
            iArr82[17] = 172;
            iArr82[18] = 166;
            iArr82[19] = 222;
            iArr82[20] = 174;
            iArr82[21] = 222;
            iArr82[22] = 173;
            iArr82[23] = 218;
            iArr82[24] = 217;
            iArr82[25] = 171;
            iArr82[26] = 166;
            iArr82[27] = 172;
            iArr82[28] = 221;
            iArr82[29] = 218;
            iArr82[30] = 218;
            iArr82[31] = 174;
            iArr82[32] = 0;
            a(a(H), a(M), a(N), a(O), a(iArr82), 6);
            if (f("2>>;?03")) {
                int[] iArr92 = new int[33];
                iArr92[0] = 169;
                iArr92[1] = 166;
                iArr92[i3] = 222;
                iArr92[3] = 217;
                iArr92[4] = 167;
                iArr92[5] = 168;
                iArr92[6] = 217;
                iArr92[7] = 220;
                iArr92[8] = 217;
                iArr92[9] = 168;
                iArr92[10] = 172;
                iArr92[11] = 172;
                iArr92[12] = 174;
                iArr92[13] = 169;
                iArr92[14] = 170;
                iArr92[15] = 168;
                iArr92[16] = 171;
                iArr92[17] = 219;
                iArr92[18] = 219;
                iArr92[19] = 221;
                iArr92[20] = 219;
                iArr92[21] = 172;
                iArr92[22] = 222;
                iArr92[23] = 167;
                iArr92[24] = 220;
                iArr92[25] = 217;
                iArr92[26] = 168;
                iArr92[27] = 173;
                iArr92[28] = 174;
                iArr92[29] = 166;
                iArr92[30] = 173;
                iArr92[31] = 166;
                iArr92[32] = 0;
                a(a(T), a(U), null, a(V), a(iArr92), 7);
            }
            str = android.os.Build.MANUFACTURER;
            if (!str.equals("360")) {
            }
            int[] iArr102 = new int[26];
            iArr102[0] = 234;
            iArr102[1] = 253;
            iArr102[i3] = 255;
            iArr102[3] = 249;
            iArr102[4] = 246;
            iArr102[5] = 249;
            iArr102[6] = 213;
            iArr102[7] = 253;
            iArr102[8] = 251;
            iArr102[9] = 241;
            iArr102[10] = 238;
            iArr102[11] = 234;
            iArr102[12] = 253;
            iArr102[13] = 203;
            iArr102[14] = 182;
            iArr102[15] = 235;
            iArr102[16] = 247;
            iArr102[17] = 182;
            iArr102[18] = 252;
            iArr102[19] = 241;
            iArr102[20] = 247;
            iArr102[21] = 234;
            iArr102[22] = 252;
            iArr102[23] = 246;
            iArr102[24] = 249;
            iArr102[25] = 0;
            int[] iArr112 = new int[11];
            iArr112[0] = 236;
            iArr112[1] = 234;
            iArr112[i3] = 224;
            iArr112[3] = 255;
            iArr112[4] = 251;
            iArr112[5] = 236;
            iArr112[6] = 218;
            iArr112[7] = 253;
            iArr112[8] = 236;
            iArr112[9] = 238;
            iArr112[10] = 0;
            int[] iArr122 = new int[7];
            iArr122[0] = 225;
            iArr122[1] = 236;
            iArr122[i3] = 240;
            iArr122[3] = 238;
            iArr122[4] = 236;
            iArr122[5] = 244;
            iArr122[6] = 0;
            int[] iArr132 = new int[33];
            iArr132[0] = 174;
            iArr132[1] = 219;
            iArr132[i3] = 174;
            iArr132[3] = 172;
            iArr132[4] = 217;
            iArr132[5] = 172;
            iArr132[6] = 168;
            iArr132[7] = 217;
            iArr132[8] = 172;
            iArr132[9] = 219;
            iArr132[10] = 219;
            iArr132[11] = 171;
            iArr132[12] = 217;
            iArr132[13] = 221;
            iArr132[14] = 168;
            iArr132[15] = 167;
            iArr132[16] = 174;
            iArr132[17] = 220;
            iArr132[18] = 168;
            iArr132[19] = 169;
            iArr132[20] = 217;
            iArr132[21] = 171;
            iArr132[22] = 220;
            iArr132[23] = 175;
            iArr132[24] = 170;
            iArr132[25] = 221;
            iArr132[26] = 175;
            iArr132[27] = 220;
            iArr132[28] = 175;
            iArr132[29] = 220;
            iArr132[30] = 167;
            iArr132[31] = 172;
            iArr132[32] = 0;
            a(a(iArr102), a(iArr112), a(iArr122), a(iArr132));
            if (f("4411:")) {
                f();
            }
            iArr = new int[15];
            iArr[0] = 233;
            iArr[1] = 228;
            iArr[i3] = 163;
            iArr[3] = 255;
            iArr[4] = 226;
            iArr[5] = 227;
            iArr[6] = 226;
            iArr[7] = 229;
            iArr[8] = 228;
            iArr[9] = 229;
            iArr[10] = 163;
            iArr[11] = 224;
            iArr[12] = 226;
            iArr[13] = 238;
            iArr[14] = 0;
            if (f("7>=>A")) {
                int[] iArr142 = new int[5];
                iArr142[0] = 231;
                iArr142[1] = 234;
                iArr142[i3] = 226;
                iArr142[3] = 236;
                iArr142[4] = 0;
                string = android.provider.Settings.Secure.getString(this.aa.getContentResolver(), a(iArr142));
                if (string != null) {
                }
                string = android.provider.Settings.Global.getString(this.aa.getContentResolver(), a(iArr142));
                if (string != null) {
                }
                int[] iArr152 = new int[29];
                iArr152[0] = 254;
                iArr152[1] = 248;
                iArr152[i3] = 242;
                iArr152[3] = 237;
                iArr152[4] = 233;
                iArr152[5] = 254;
                iArr152[6] = 200;
                iArr152[7] = 255;
                iArr152[8] = 210;
                iArr152[9] = 250;
                iArr152[10] = 212;
                iArr152[11] = 245;
                iArr152[12] = 211;
                iArr152[13] = 181;
                iArr152[14] = 255;
                iArr152[15] = 242;
                iArr152[16] = 181;
                iArr152[17] = 233;
                iArr152[18] = 244;
                iArr152[19] = 245;
                iArr152[20] = 244;
                iArr152[21] = 243;
                iArr152[22] = 242;
                iArr152[23] = 243;
                iArr152[24] = 181;
                iArr152[25] = 246;
                iArr152[26] = 244;
                iArr152[27] = 248;
                iArr152[28] = 0;
                a(a(iArr), "", a(iArr152), "", "", 8);
            }
            g();
            if (m()) {
            }
            if (b(a(h), 0)) {
            }
            if (b(a(b), 0)) {
                if (!f(">??>")) {
                    a2 = a(b);
                    a3 = a(c);
                    a4 = a(d);
                    a5 = a(e);
                    a6 = a(f);
                    a(a2, a3, a4, a5, a6, 0);
                }
                if (!a(a(f))) {
                }
            }
            isf = true;
            a++;
        }
    }

    public java.lang.String cm(java.lang.String str) {
        return n() ? a(Q) : l() ? a(R) : str;
    }

    public boolean isOaidCollectAllowed(int i2) {
        java.lang.String b2;
        if (i2 == 2) {
            return true;
        }
        java.lang.String a2 = a(new int[]{com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_MODE_LIVE, 174, 175, 167, 221, com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_MODE_LIVE, 174, 219, 218, com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_MODE_LIVE, 167, com.bytedance.sdk.openadsdk.TTAdConstant.IMAGE_MODE_LIVE, 218, 218, 169, 168, 170, 173, 169, 175, 220, 220, 175, 218, 167, 168, com.autonavi.amap.mapcore.AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 170, 220, 219, 221, 170, 0});
        if (a(a2) && (b2 = b(a2)) != null && !b2.isEmpty()) {
            if (i2 == 1) {
                if (!b2.startsWith(a(new int[]{com.qq.e.comm.adevent.AdEventType.VIDEO_STOP, 198, com.getui.gtc.extension.distribution.gbd.d.g.aI, 192, com.qq.e.comm.adevent.AdEventType.VIDEO_STOP, 219, com.qq.e.comm.adevent.AdEventType.VIDEO_STOP, com.qq.e.comm.adevent.AdEventType.VIDEO_LOADING, 185, 216, 0}))) {
                    return false;
                }
                c(a2);
                return true;
            }
            if (i2 == 3) {
                return !b2.startsWith(a(new int[]{243, 196, 240, 216, 221, 216, com.qq.e.comm.adevent.AdEventType.VIDEO_STOP, 219, 243, 216, 0}));
            }
        }
        return i2 != 1;
    }

    public boolean m() {
        try {
            return java.lang.Class.forName(a(G)).newInstance() != null;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }
}
