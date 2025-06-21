package tv.danmaku.ijk.media.player.misc;

/* loaded from: classes21.dex */
public class IjkTrackInfo implements tv.danmaku.ijk.media.player.misc.ITrackInfo {
    private tv.danmaku.ijk.media.player.IjkMediaMeta.IjkStreamMeta mStreamMeta;
    private int mTrackType = 0;

    public IjkTrackInfo(tv.danmaku.ijk.media.player.IjkMediaMeta.IjkStreamMeta ijkStreamMeta) {
        this.mStreamMeta = ijkStreamMeta;
    }

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    public tv.danmaku.ijk.media.player.misc.IMediaFormat getFormat() {
        return new tv.danmaku.ijk.media.player.misc.IjkMediaFormat(this.mStreamMeta);
    }

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    public java.lang.String getInfoInline() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(128);
        int i = this.mTrackType;
        if (i == 1) {
            sb.append("VIDEO");
            sb.append(", ");
            sb.append(this.mStreamMeta.getCodecShortNameInline());
            sb.append(", ");
            sb.append(this.mStreamMeta.getBitrateInline());
            sb.append(", ");
            sb.append(this.mStreamMeta.getResolutionInline());
        } else if (i == 2) {
            sb.append("AUDIO");
            sb.append(", ");
            sb.append(this.mStreamMeta.getCodecShortNameInline());
            sb.append(", ");
            sb.append(this.mStreamMeta.getBitrateInline());
            sb.append(", ");
            sb.append(this.mStreamMeta.getSampleRateInline());
        } else if (i == 3) {
            sb.append("TIMEDTEXT");
            sb.append(", ");
            sb.append(this.mStreamMeta.mLanguage);
        } else if (i != 4) {
            sb.append(com.huawei.hms.framework.network.grs.GrsBaseInfo.CountryCodeSource.UNKNOWN);
        } else {
            sb.append("SUBTITLE");
        }
        return sb.toString();
    }

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    public java.lang.String getLanguage() {
        tv.danmaku.ijk.media.player.IjkMediaMeta.IjkStreamMeta ijkStreamMeta = this.mStreamMeta;
        return (ijkStreamMeta == null || android.text.TextUtils.isEmpty(ijkStreamMeta.mLanguage)) ? "und" : this.mStreamMeta.mLanguage;
    }

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    public int getTrackType() {
        return this.mTrackType;
    }

    public void setMediaMeta(tv.danmaku.ijk.media.player.IjkMediaMeta.IjkStreamMeta ijkStreamMeta) {
        this.mStreamMeta = ijkStreamMeta;
    }

    public void setTrackType(int i) {
        this.mTrackType = i;
    }

    public java.lang.String toString() {
        return getClass().getSimpleName() + '{' + getInfoInline() + com.alipay.sdk.m.u.i.d;
    }
}
