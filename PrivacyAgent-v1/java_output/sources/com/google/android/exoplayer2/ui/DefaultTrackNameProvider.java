package com.google.android.exoplayer2.ui;

/* loaded from: classes22.dex */
public class DefaultTrackNameProvider implements com.google.android.exoplayer2.ui.TrackNameProvider {
    public final android.content.res.Resources a;

    public DefaultTrackNameProvider(android.content.res.Resources resources) {
        this.a = (android.content.res.Resources) com.google.android.exoplayer2.util.Assertions.checkNotNull(resources);
    }

    public static int h(com.google.android.exoplayer2.Format format) {
        int trackType = com.google.android.exoplayer2.util.MimeTypes.getTrackType(format.sampleMimeType);
        if (trackType != -1) {
            return trackType;
        }
        if (com.google.android.exoplayer2.util.MimeTypes.getVideoMediaMimeType(format.codecs) != null) {
            return 2;
        }
        if (com.google.android.exoplayer2.util.MimeTypes.getAudioMediaMimeType(format.codecs) != null) {
            return 1;
        }
        if (format.width == -1 && format.height == -1) {
            return (format.channelCount == -1 && format.sampleRate == -1) ? -1 : 1;
        }
        return 2;
    }

    public final java.lang.String a(com.google.android.exoplayer2.Format format) {
        int i = format.channelCount;
        return (i == -1 || i < 1) ? "" : i != 1 ? i != 2 ? (i == 6 || i == 7) ? this.a.getString(com.google.android.exoplayer2.ui.R.string.exo_track_surround_5_point_1) : i != 8 ? this.a.getString(com.google.android.exoplayer2.ui.R.string.exo_track_surround) : this.a.getString(com.google.android.exoplayer2.ui.R.string.exo_track_surround_7_point_1) : this.a.getString(com.google.android.exoplayer2.ui.R.string.exo_track_stereo) : this.a.getString(com.google.android.exoplayer2.ui.R.string.exo_track_mono);
    }

    public final java.lang.String b(com.google.android.exoplayer2.Format format) {
        int i = format.bitrate;
        return i == -1 ? "" : this.a.getString(com.google.android.exoplayer2.ui.R.string.exo_track_bitrate, java.lang.Float.valueOf(i / 1000000.0f));
    }

    public final java.lang.String c(com.google.android.exoplayer2.Format format) {
        return android.text.TextUtils.isEmpty(format.label) ? "" : format.label;
    }

    public final java.lang.String d(com.google.android.exoplayer2.Format format) {
        java.lang.String i = i(e(format), g(format));
        return android.text.TextUtils.isEmpty(i) ? c(format) : i;
    }

    public final java.lang.String e(com.google.android.exoplayer2.Format format) {
        java.lang.String str = format.language;
        if (android.text.TextUtils.isEmpty(str) || "und".equals(str)) {
            return "";
        }
        return (com.google.android.exoplayer2.util.Util.SDK_INT >= 21 ? java.util.Locale.forLanguageTag(str) : new java.util.Locale(str)).getDisplayName();
    }

    public final java.lang.String f(com.google.android.exoplayer2.Format format) {
        int i = format.width;
        int i2 = format.height;
        return (i == -1 || i2 == -1) ? "" : this.a.getString(com.google.android.exoplayer2.ui.R.string.exo_track_resolution, java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2));
    }

    public final java.lang.String g(com.google.android.exoplayer2.Format format) {
        java.lang.String string = (format.roleFlags & 2) != 0 ? this.a.getString(com.google.android.exoplayer2.ui.R.string.exo_track_role_alternate) : "";
        if ((format.roleFlags & 4) != 0) {
            string = i(string, this.a.getString(com.google.android.exoplayer2.ui.R.string.exo_track_role_supplementary));
        }
        if ((format.roleFlags & 8) != 0) {
            string = i(string, this.a.getString(com.google.android.exoplayer2.ui.R.string.exo_track_role_commentary));
        }
        return (format.roleFlags & 1088) != 0 ? i(string, this.a.getString(com.google.android.exoplayer2.ui.R.string.exo_track_role_closed_captions)) : string;
    }

    @Override // com.google.android.exoplayer2.ui.TrackNameProvider
    public java.lang.String getTrackName(com.google.android.exoplayer2.Format format) {
        int h = h(format);
        java.lang.String i = h == 2 ? i(g(format), f(format), b(format)) : h == 1 ? i(d(format), a(format), b(format)) : d(format);
        return i.length() == 0 ? this.a.getString(com.google.android.exoplayer2.ui.R.string.exo_track_unknown) : i;
    }

    public final java.lang.String i(java.lang.String... strArr) {
        java.lang.String str = "";
        for (java.lang.String str2 : strArr) {
            if (str2.length() > 0) {
                str = android.text.TextUtils.isEmpty(str) ? str2 : this.a.getString(com.google.android.exoplayer2.ui.R.string.exo_item_list, str, str2);
            }
        }
        return str;
    }
}
