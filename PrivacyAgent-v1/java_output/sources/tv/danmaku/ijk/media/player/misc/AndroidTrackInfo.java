package tv.danmaku.ijk.media.player.misc;

/* loaded from: classes21.dex */
public class AndroidTrackInfo implements tv.danmaku.ijk.media.player.misc.ITrackInfo {
    private final android.media.MediaPlayer.TrackInfo mTrackInfo;

    private AndroidTrackInfo(android.media.MediaPlayer.TrackInfo trackInfo) {
        this.mTrackInfo = trackInfo;
    }

    public static tv.danmaku.ijk.media.player.misc.AndroidTrackInfo[] fromMediaPlayer(android.media.MediaPlayer mediaPlayer) {
        return fromTrackInfo(mediaPlayer.getTrackInfo());
    }

    private static tv.danmaku.ijk.media.player.misc.AndroidTrackInfo[] fromTrackInfo(android.media.MediaPlayer.TrackInfo[] trackInfoArr) {
        if (trackInfoArr == null) {
            return null;
        }
        tv.danmaku.ijk.media.player.misc.AndroidTrackInfo[] androidTrackInfoArr = new tv.danmaku.ijk.media.player.misc.AndroidTrackInfo[trackInfoArr.length];
        for (int i = 0; i < trackInfoArr.length; i++) {
            androidTrackInfoArr[i] = new tv.danmaku.ijk.media.player.misc.AndroidTrackInfo(trackInfoArr[i]);
        }
        return androidTrackInfoArr;
    }

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    @android.annotation.TargetApi(19)
    public tv.danmaku.ijk.media.player.misc.IMediaFormat getFormat() {
        android.media.MediaFormat format;
        android.media.MediaPlayer.TrackInfo trackInfo = this.mTrackInfo;
        if (trackInfo == null || (format = trackInfo.getFormat()) == null) {
            return null;
        }
        return new tv.danmaku.ijk.media.player.misc.AndroidMediaFormat(format);
    }

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    @android.annotation.TargetApi(16)
    public java.lang.String getInfoInline() {
        android.media.MediaPlayer.TrackInfo trackInfo = this.mTrackInfo;
        return trackInfo != null ? trackInfo.toString() : com.igexin.push.core.b.m;
    }

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    @android.annotation.TargetApi(16)
    public java.lang.String getLanguage() {
        android.media.MediaPlayer.TrackInfo trackInfo = this.mTrackInfo;
        return trackInfo == null ? "und" : trackInfo.getLanguage();
    }

    @Override // tv.danmaku.ijk.media.player.misc.ITrackInfo
    @android.annotation.TargetApi(16)
    public int getTrackType() {
        android.media.MediaPlayer.TrackInfo trackInfo = this.mTrackInfo;
        if (trackInfo == null) {
            return 0;
        }
        return trackInfo.getTrackType();
    }

    @android.annotation.TargetApi(16)
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append('{');
        android.media.MediaPlayer.TrackInfo trackInfo = this.mTrackInfo;
        if (trackInfo != null) {
            sb.append(trackInfo.toString());
        } else {
            sb.append(com.igexin.push.core.b.m);
        }
        sb.append('}');
        return sb.toString();
    }
}
