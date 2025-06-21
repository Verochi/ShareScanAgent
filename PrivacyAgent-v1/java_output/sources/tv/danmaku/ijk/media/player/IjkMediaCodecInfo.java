package tv.danmaku.ijk.media.player;

/* loaded from: classes21.dex */
public class IjkMediaCodecInfo {
    public static final int RANK_ACCEPTABLE = 700;
    public static final int RANK_LAST_CHANCE = 600;
    public static final int RANK_MAX = 1000;
    public static final int RANK_NON_STANDARD = 100;
    public static final int RANK_NO_SENSE = 0;
    public static final int RANK_SECURE = 300;
    public static final int RANK_SOFTWARE = 200;
    public static final int RANK_TESTED = 800;
    private static final java.lang.String TAG = "IjkMediaCodecInfo";
    private static java.util.Map<java.lang.String, java.lang.Integer> sKnownCodecList;
    public android.media.MediaCodecInfo mCodecInfo;
    public java.lang.String mMimeType;
    public int mRank = 0;

    private static synchronized java.util.Map<java.lang.String, java.lang.Integer> getKnownCodecList() {
        synchronized (tv.danmaku.ijk.media.player.IjkMediaCodecInfo.class) {
            java.util.Map<java.lang.String, java.lang.Integer> map = sKnownCodecList;
            if (map != null) {
                return map;
            }
            java.util.TreeMap treeMap = new java.util.TreeMap(java.lang.String.CASE_INSENSITIVE_ORDER);
            sKnownCodecList = treeMap;
            treeMap.put("OMX.Nvidia.h264.decode", 800);
            sKnownCodecList.put("OMX.Nvidia.h264.decode.secure", 300);
            sKnownCodecList.put("OMX.Intel.hw_vd.h264", java.lang.Integer.valueOf(tv.danmaku.ijk.media.player.IMediaPlayer.MEDIA_INFO_NOT_SEEKABLE));
            sKnownCodecList.put("OMX.Intel.VideoDecoder.AVC", 800);
            sKnownCodecList.put("OMX.qcom.video.decoder.avc", 800);
            sKnownCodecList.put("OMX.ittiam.video.decoder.avc", 0);
            sKnownCodecList.put("OMX.SEC.avc.dec", 800);
            sKnownCodecList.put("OMX.SEC.AVC.Decoder", 799);
            sKnownCodecList.put("OMX.SEC.avcdec", 798);
            sKnownCodecList.put("OMX.SEC.avc.sw.dec", 200);
            sKnownCodecList.put("OMX.Exynos.avc.dec", 800);
            sKnownCodecList.put("OMX.Exynos.AVC.Decoder", 799);
            sKnownCodecList.put("OMX.k3.video.decoder.avc", 800);
            sKnownCodecList.put("OMX.IMG.MSVDX.Decoder.AVC", 800);
            sKnownCodecList.put("OMX.TI.DUCATI1.VIDEO.DECODER", 800);
            sKnownCodecList.put("OMX.rk.video_decoder.avc", 800);
            sKnownCodecList.put("OMX.amlogic.avc.decoder.awesome", 800);
            sKnownCodecList.put("OMX.MARVELL.VIDEO.HW.CODA7542DECODER", 800);
            sKnownCodecList.put("OMX.MARVELL.VIDEO.H264DECODER", 200);
            sKnownCodecList.remove("OMX.Action.Video.Decoder");
            sKnownCodecList.remove("OMX.allwinner.video.decoder.avc");
            sKnownCodecList.remove("OMX.BRCM.vc4.decoder.avc");
            sKnownCodecList.remove("OMX.brcm.video.h264.hw.decoder");
            sKnownCodecList.remove("OMX.brcm.video.h264.decoder");
            sKnownCodecList.remove("OMX.cosmo.video.decoder.avc");
            sKnownCodecList.remove("OMX.duos.h264.decoder");
            sKnownCodecList.remove("OMX.hantro.81x0.video.decoder");
            sKnownCodecList.remove("OMX.hantro.G1.video.decoder");
            sKnownCodecList.remove("OMX.hisi.video.decoder");
            sKnownCodecList.remove("OMX.LG.decoder.video.avc");
            sKnownCodecList.remove("OMX.MS.AVC.Decoder");
            sKnownCodecList.remove("OMX.RENESAS.VIDEO.DECODER.H264");
            sKnownCodecList.remove("OMX.RTK.video.decoder");
            sKnownCodecList.remove("OMX.sprd.h264.decoder");
            sKnownCodecList.remove("OMX.ST.VFM.H264Dec");
            sKnownCodecList.remove("OMX.vpu.video_decoder.avc");
            sKnownCodecList.remove("OMX.WMT.decoder.avc");
            sKnownCodecList.remove("OMX.bluestacks.hw.decoder");
            sKnownCodecList.put("OMX.google.h264.decoder", 200);
            sKnownCodecList.put("OMX.google.h264.lc.decoder", 200);
            sKnownCodecList.put("OMX.k3.ffmpeg.decoder", 200);
            sKnownCodecList.put("OMX.ffmpeg.video.decoder", 200);
            sKnownCodecList.put("OMX.sprd.soft.h264.decoder", 200);
            return sKnownCodecList;
        }
    }

    public static java.lang.String getLevelName(int i) {
        if (i == 1) {
            return "1";
        }
        if (i == 2) {
            return "1b";
        }
        switch (i) {
            case 4:
                return com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE;
            case 8:
                return com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SET_AVATAR;
            case 16:
                return "13";
            case 32:
                return "2";
            case 64:
                return "21";
            case 128:
                return com.tencent.connect.common.Constants.VIA_REPORT_TYPE_DATALINE;
            case 256:
                return "3";
            case 512:
                return "31";
            case 1024:
                return "32";
            case 2048:
                return "4";
            case 4096:
                return "41";
            case 8192:
                return androidx.room.RoomMasterTable.DEFAULT_ID;
            case 16384:
                return "5";
            case 32768:
                return "51";
            case 65536:
                return "52";
            default:
                return "0";
        }
    }

    public static java.lang.String getProfileLevelName(int i, int i2) {
        return java.lang.String.format(java.util.Locale.US, " %s Profile Level %s (%d,%d)", getProfileName(i), getLevelName(i2), java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2));
    }

    public static java.lang.String getProfileName(int i) {
        return i != 1 ? i != 2 ? i != 4 ? i != 8 ? i != 16 ? i != 32 ? i != 64 ? "Unknown" : "High444" : "High422" : "High10" : "High" : "Extends" : "Main" : "Baseline";
    }

    @android.annotation.TargetApi(16)
    public static tv.danmaku.ijk.media.player.IjkMediaCodecInfo setupCandidate(android.media.MediaCodecInfo mediaCodecInfo, java.lang.String str) {
        int i;
        if (mediaCodecInfo == null) {
            return null;
        }
        java.lang.String name = mediaCodecInfo.getName();
        if (android.text.TextUtils.isEmpty(name)) {
            return null;
        }
        java.lang.String lowerCase = name.toLowerCase(java.util.Locale.US);
        if (!lowerCase.startsWith("omx.")) {
            i = 100;
        } else if (lowerCase.startsWith("omx.pv") || lowerCase.startsWith("omx.google.") || lowerCase.startsWith("omx.ffmpeg.") || lowerCase.startsWith("omx.k3.ffmpeg.") || lowerCase.startsWith("omx.avcodec.")) {
            i = 200;
        } else if (lowerCase.startsWith("omx.ittiam.")) {
            i = 0;
        } else if (lowerCase.startsWith("omx.mtk.")) {
            i = 800;
        } else {
            java.lang.Integer num = getKnownCodecList().get(lowerCase);
            if (num != null) {
                i = num.intValue();
            } else {
                i = 600;
                try {
                    if (mediaCodecInfo.getCapabilitiesForType(str) != null) {
                        i = 700;
                    }
                } catch (java.lang.Throwable unused) {
                }
            }
        }
        tv.danmaku.ijk.media.player.IjkMediaCodecInfo ijkMediaCodecInfo = new tv.danmaku.ijk.media.player.IjkMediaCodecInfo();
        ijkMediaCodecInfo.mCodecInfo = mediaCodecInfo;
        ijkMediaCodecInfo.mRank = i;
        ijkMediaCodecInfo.mMimeType = str;
        return ijkMediaCodecInfo;
    }

    @android.annotation.TargetApi(16)
    public void dumpProfileLevels(java.lang.String str) {
        int i;
        int i2;
        android.media.MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        try {
            android.media.MediaCodecInfo.CodecCapabilities capabilitiesForType = this.mCodecInfo.getCapabilitiesForType(str);
            if (capabilitiesForType == null || (codecProfileLevelArr = capabilitiesForType.profileLevels) == null) {
                i = 0;
                i2 = 0;
            } else {
                i = 0;
                i2 = 0;
                for (android.media.MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArr) {
                    if (codecProfileLevel != null) {
                        i = java.lang.Math.max(i, codecProfileLevel.profile);
                        i2 = java.lang.Math.max(i2, codecProfileLevel.level);
                    }
                }
            }
            java.lang.String.format(java.util.Locale.US, "%s", getProfileLevelName(i, i2));
        } catch (java.lang.Throwable unused) {
        }
    }
}
