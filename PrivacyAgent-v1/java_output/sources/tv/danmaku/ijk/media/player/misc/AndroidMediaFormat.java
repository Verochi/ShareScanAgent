package tv.danmaku.ijk.media.player.misc;

/* loaded from: classes21.dex */
public class AndroidMediaFormat implements tv.danmaku.ijk.media.player.misc.IMediaFormat {
    private final android.media.MediaFormat mMediaFormat;

    public AndroidMediaFormat(android.media.MediaFormat mediaFormat) {
        this.mMediaFormat = mediaFormat;
    }

    @Override // tv.danmaku.ijk.media.player.misc.IMediaFormat
    @android.annotation.TargetApi(16)
    public int getInteger(java.lang.String str) {
        android.media.MediaFormat mediaFormat = this.mMediaFormat;
        if (mediaFormat == null) {
            return 0;
        }
        return mediaFormat.getInteger(str);
    }

    @Override // tv.danmaku.ijk.media.player.misc.IMediaFormat
    @android.annotation.TargetApi(16)
    public java.lang.String getString(java.lang.String str) {
        android.media.MediaFormat mediaFormat = this.mMediaFormat;
        if (mediaFormat == null) {
            return null;
        }
        return mediaFormat.getString(str);
    }

    @android.annotation.TargetApi(16)
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder(128);
        sb.append(getClass().getName());
        sb.append('{');
        android.media.MediaFormat mediaFormat = this.mMediaFormat;
        if (mediaFormat != null) {
            sb.append(mediaFormat.toString());
        } else {
            sb.append(com.igexin.push.core.b.m);
        }
        sb.append('}');
        return sb.toString();
    }
}
