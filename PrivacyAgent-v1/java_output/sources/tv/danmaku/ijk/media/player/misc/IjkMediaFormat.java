package tv.danmaku.ijk.media.player.misc;

/* loaded from: classes21.dex */
public class IjkMediaFormat implements tv.danmaku.ijk.media.player.misc.IMediaFormat {
    public static final java.lang.String CODEC_NAME_H264 = "h264";
    public static final java.lang.String KEY_IJK_BIT_RATE_UI = "ijk-bit-rate-ui";
    public static final java.lang.String KEY_IJK_CHANNEL_UI = "ijk-channel-ui";
    public static final java.lang.String KEY_IJK_CODEC_LONG_NAME_UI = "ijk-codec-long-name-ui";
    public static final java.lang.String KEY_IJK_CODEC_NAME_UI = "ijk-codec-name-ui";
    public static final java.lang.String KEY_IJK_CODEC_PIXEL_FORMAT_UI = "ijk-pixel-format-ui";
    public static final java.lang.String KEY_IJK_CODEC_PROFILE_LEVEL_UI = "ijk-profile-level-ui";
    public static final java.lang.String KEY_IJK_FRAME_RATE_UI = "ijk-frame-rate-ui";
    public static final java.lang.String KEY_IJK_RESOLUTION_UI = "ijk-resolution-ui";
    public static final java.lang.String KEY_IJK_SAMPLE_RATE_UI = "ijk-sample-rate-ui";
    private static final java.util.Map<java.lang.String, tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter> sFormatterMap = new java.util.HashMap();
    public final tv.danmaku.ijk.media.player.IjkMediaMeta.IjkStreamMeta mMediaFormat;

    /* renamed from: tv.danmaku.ijk.media.player.misc.IjkMediaFormat$1, reason: invalid class name */
    public class AnonymousClass1 extends tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter {
        public AnonymousClass1() {
            super(null);
        }

        @Override // tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter
        public java.lang.String doFormat(tv.danmaku.ijk.media.player.misc.IjkMediaFormat ijkMediaFormat) {
            return tv.danmaku.ijk.media.player.misc.IjkMediaFormat.this.mMediaFormat.getString(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_CODEC_LONG_NAME);
        }
    }

    /* renamed from: tv.danmaku.ijk.media.player.misc.IjkMediaFormat$2, reason: invalid class name */
    public class AnonymousClass2 extends tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter {
        public AnonymousClass2() {
            super(null);
        }

        @Override // tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter
        public java.lang.String doFormat(tv.danmaku.ijk.media.player.misc.IjkMediaFormat ijkMediaFormat) {
            return tv.danmaku.ijk.media.player.misc.IjkMediaFormat.this.mMediaFormat.getString(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_CODEC_NAME);
        }
    }

    /* renamed from: tv.danmaku.ijk.media.player.misc.IjkMediaFormat$3, reason: invalid class name */
    public class AnonymousClass3 extends tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter {
        public AnonymousClass3() {
            super(null);
        }

        @Override // tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter
        public java.lang.String doFormat(tv.danmaku.ijk.media.player.misc.IjkMediaFormat ijkMediaFormat) {
            int integer = ijkMediaFormat.getInteger(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_BITRATE);
            if (integer <= 0) {
                return null;
            }
            return integer < 1000 ? java.lang.String.format(java.util.Locale.US, "%d bit/s", java.lang.Integer.valueOf(integer)) : java.lang.String.format(java.util.Locale.US, "%d kb/s", java.lang.Integer.valueOf(integer / 1000));
        }
    }

    /* renamed from: tv.danmaku.ijk.media.player.misc.IjkMediaFormat$4, reason: invalid class name */
    public class AnonymousClass4 extends tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter {
        public AnonymousClass4() {
            super(null);
        }

        @Override // tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter
        public java.lang.String doFormat(tv.danmaku.ijk.media.player.misc.IjkMediaFormat ijkMediaFormat) {
            java.lang.String str;
            switch (ijkMediaFormat.getInteger(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_CODEC_PROFILE_ID)) {
                case 44:
                    str = "CAVLC 4:4:4";
                    break;
                case 66:
                    str = "Baseline";
                    break;
                case 77:
                    str = "Main";
                    break;
                case 88:
                    str = "Extended";
                    break;
                case 100:
                    str = "High";
                    break;
                case 110:
                    str = "High 10";
                    break;
                case 122:
                    str = "High 4:2:2";
                    break;
                case 144:
                    str = "High 4:4:4";
                    break;
                case tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE /* 244 */:
                    str = "High 4:4:4 Predictive";
                    break;
                case tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED_BASELINE /* 578 */:
                    str = "Constrained Baseline";
                    break;
                case tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_HIGH_10_INTRA /* 2158 */:
                    str = "High 10 Intra";
                    break;
                case tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_HIGH_422_INTRA /* 2170 */:
                    str = "High 4:2:2 Intra";
                    break;
                case tv.danmaku.ijk.media.player.IjkMediaMeta.FF_PROFILE_H264_HIGH_444_INTRA /* 2292 */:
                    str = "High 4:4:4 Intra";
                    break;
                default:
                    return null;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(str);
            java.lang.String string = ijkMediaFormat.getString(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_CODEC_NAME);
            if (!android.text.TextUtils.isEmpty(string) && string.equalsIgnoreCase(tv.danmaku.ijk.media.player.misc.IjkMediaFormat.CODEC_NAME_H264)) {
                int integer = ijkMediaFormat.getInteger(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_CODEC_LEVEL);
                if (integer < 10) {
                    return sb.toString();
                }
                sb.append(" Profile Level ");
                sb.append((integer / 10) % 10);
                int i = integer % 10;
                if (i != 0) {
                    sb.append(".");
                    sb.append(i);
                }
            }
            return sb.toString();
        }
    }

    /* renamed from: tv.danmaku.ijk.media.player.misc.IjkMediaFormat$5, reason: invalid class name */
    public class AnonymousClass5 extends tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter {
        public AnonymousClass5() {
            super(null);
        }

        @Override // tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter
        public java.lang.String doFormat(tv.danmaku.ijk.media.player.misc.IjkMediaFormat ijkMediaFormat) {
            return ijkMediaFormat.getString(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_CODEC_PIXEL_FORMAT);
        }
    }

    /* renamed from: tv.danmaku.ijk.media.player.misc.IjkMediaFormat$6, reason: invalid class name */
    public class AnonymousClass6 extends tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter {
        public AnonymousClass6() {
            super(null);
        }

        @Override // tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter
        public java.lang.String doFormat(tv.danmaku.ijk.media.player.misc.IjkMediaFormat ijkMediaFormat) {
            int integer = ijkMediaFormat.getInteger("width");
            int integer2 = ijkMediaFormat.getInteger("height");
            int integer3 = ijkMediaFormat.getInteger(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_SAR_NUM);
            int integer4 = ijkMediaFormat.getInteger(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_SAR_DEN);
            if (integer <= 0 || integer2 <= 0) {
                return null;
            }
            return (integer3 <= 0 || integer4 <= 0) ? java.lang.String.format(java.util.Locale.US, "%d x %d", java.lang.Integer.valueOf(integer), java.lang.Integer.valueOf(integer2)) : java.lang.String.format(java.util.Locale.US, "%d x %d [SAR %d:%d]", java.lang.Integer.valueOf(integer), java.lang.Integer.valueOf(integer2), java.lang.Integer.valueOf(integer3), java.lang.Integer.valueOf(integer4));
        }
    }

    /* renamed from: tv.danmaku.ijk.media.player.misc.IjkMediaFormat$7, reason: invalid class name */
    public class AnonymousClass7 extends tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter {
        public AnonymousClass7() {
            super(null);
        }

        @Override // tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter
        public java.lang.String doFormat(tv.danmaku.ijk.media.player.misc.IjkMediaFormat ijkMediaFormat) {
            int integer = ijkMediaFormat.getInteger(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_FPS_NUM);
            int integer2 = ijkMediaFormat.getInteger(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_FPS_DEN);
            if (integer <= 0 || integer2 <= 0) {
                return null;
            }
            return java.lang.String.valueOf(integer / integer2);
        }
    }

    /* renamed from: tv.danmaku.ijk.media.player.misc.IjkMediaFormat$8, reason: invalid class name */
    public class AnonymousClass8 extends tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter {
        public AnonymousClass8() {
            super(null);
        }

        @Override // tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter
        public java.lang.String doFormat(tv.danmaku.ijk.media.player.misc.IjkMediaFormat ijkMediaFormat) {
            int integer = ijkMediaFormat.getInteger(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_SAMPLE_RATE);
            if (integer <= 0) {
                return null;
            }
            return java.lang.String.format(java.util.Locale.US, "%d Hz", java.lang.Integer.valueOf(integer));
        }
    }

    /* renamed from: tv.danmaku.ijk.media.player.misc.IjkMediaFormat$9, reason: invalid class name */
    public class AnonymousClass9 extends tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter {
        public AnonymousClass9() {
            super(null);
        }

        @Override // tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter
        public java.lang.String doFormat(tv.danmaku.ijk.media.player.misc.IjkMediaFormat ijkMediaFormat) {
            int integer = ijkMediaFormat.getInteger(tv.danmaku.ijk.media.player.IjkMediaMeta.IJKM_KEY_CHANNEL_LAYOUT);
            if (integer <= 0) {
                return null;
            }
            long j = integer;
            return j == 4 ? "mono" : j == 3 ? "stereo" : java.lang.String.format(java.util.Locale.US, "%x", java.lang.Integer.valueOf(integer));
        }
    }

    public static abstract class Formatter {
        private Formatter() {
        }

        public /* synthetic */ Formatter(tv.danmaku.ijk.media.player.misc.IjkMediaFormat.AnonymousClass1 anonymousClass1) {
            this();
        }

        public abstract java.lang.String doFormat(tv.danmaku.ijk.media.player.misc.IjkMediaFormat ijkMediaFormat);

        public java.lang.String format(tv.danmaku.ijk.media.player.misc.IjkMediaFormat ijkMediaFormat) {
            java.lang.String doFormat = doFormat(ijkMediaFormat);
            return android.text.TextUtils.isEmpty(doFormat) ? getDefaultString() : doFormat;
        }

        public java.lang.String getDefaultString() {
            return "N/A";
        }
    }

    public IjkMediaFormat(tv.danmaku.ijk.media.player.IjkMediaMeta.IjkStreamMeta ijkStreamMeta) {
        java.util.Map<java.lang.String, tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter> map = sFormatterMap;
        map.put(KEY_IJK_CODEC_LONG_NAME_UI, new tv.danmaku.ijk.media.player.misc.IjkMediaFormat.AnonymousClass1());
        map.put(KEY_IJK_CODEC_NAME_UI, new tv.danmaku.ijk.media.player.misc.IjkMediaFormat.AnonymousClass2());
        map.put(KEY_IJK_BIT_RATE_UI, new tv.danmaku.ijk.media.player.misc.IjkMediaFormat.AnonymousClass3());
        map.put(KEY_IJK_CODEC_PROFILE_LEVEL_UI, new tv.danmaku.ijk.media.player.misc.IjkMediaFormat.AnonymousClass4());
        map.put(KEY_IJK_CODEC_PIXEL_FORMAT_UI, new tv.danmaku.ijk.media.player.misc.IjkMediaFormat.AnonymousClass5());
        map.put(KEY_IJK_RESOLUTION_UI, new tv.danmaku.ijk.media.player.misc.IjkMediaFormat.AnonymousClass6());
        map.put(KEY_IJK_FRAME_RATE_UI, new tv.danmaku.ijk.media.player.misc.IjkMediaFormat.AnonymousClass7());
        map.put(KEY_IJK_SAMPLE_RATE_UI, new tv.danmaku.ijk.media.player.misc.IjkMediaFormat.AnonymousClass8());
        map.put(KEY_IJK_CHANNEL_UI, new tv.danmaku.ijk.media.player.misc.IjkMediaFormat.AnonymousClass9());
        this.mMediaFormat = ijkStreamMeta;
    }

    @Override // tv.danmaku.ijk.media.player.misc.IMediaFormat
    @android.annotation.TargetApi(16)
    public int getInteger(java.lang.String str) {
        tv.danmaku.ijk.media.player.IjkMediaMeta.IjkStreamMeta ijkStreamMeta = this.mMediaFormat;
        if (ijkStreamMeta == null) {
            return 0;
        }
        return ijkStreamMeta.getInt(str);
    }

    @Override // tv.danmaku.ijk.media.player.misc.IMediaFormat
    public java.lang.String getString(java.lang.String str) {
        if (this.mMediaFormat == null) {
            return null;
        }
        java.util.Map<java.lang.String, tv.danmaku.ijk.media.player.misc.IjkMediaFormat.Formatter> map = sFormatterMap;
        return map.containsKey(str) ? map.get(str).format(this) : this.mMediaFormat.getString(str);
    }
}
