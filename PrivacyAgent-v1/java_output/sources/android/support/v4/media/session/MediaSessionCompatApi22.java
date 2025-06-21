package android.support.v4.media.session;

@androidx.annotation.RequiresApi(22)
/* loaded from: classes.dex */
class MediaSessionCompatApi22 {
    private MediaSessionCompatApi22() {
    }

    public static void setRatingType(java.lang.Object obj, int i) {
        ((android.media.session.MediaSession) obj).setRatingType(i);
    }
}
