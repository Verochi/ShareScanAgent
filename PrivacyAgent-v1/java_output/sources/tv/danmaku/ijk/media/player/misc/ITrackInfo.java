package tv.danmaku.ijk.media.player.misc;

/* loaded from: classes21.dex */
public interface ITrackInfo {
    public static final int MEDIA_TRACK_TYPE_AUDIO = 2;
    public static final int MEDIA_TRACK_TYPE_METADATA = 5;
    public static final int MEDIA_TRACK_TYPE_SUBTITLE = 4;
    public static final int MEDIA_TRACK_TYPE_TIMEDTEXT = 3;
    public static final int MEDIA_TRACK_TYPE_UNKNOWN = 0;
    public static final int MEDIA_TRACK_TYPE_VIDEO = 1;

    tv.danmaku.ijk.media.player.misc.IMediaFormat getFormat();

    java.lang.String getInfoInline();

    java.lang.String getLanguage();

    int getTrackType();
}
