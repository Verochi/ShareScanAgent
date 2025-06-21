package android.support.v4.media;

@androidx.annotation.RequiresApi(23)
/* loaded from: classes.dex */
class MediaDescriptionCompatApi23 {

    public static class Builder {
        private Builder() {
        }

        public static void setMediaUri(java.lang.Object obj, android.net.Uri uri) {
            ((android.media.MediaDescription.Builder) obj).setMediaUri(uri);
        }
    }

    private MediaDescriptionCompatApi23() {
    }

    public static android.net.Uri getMediaUri(java.lang.Object obj) {
        android.net.Uri mediaUri;
        mediaUri = ((android.media.MediaDescription) obj).getMediaUri();
        return mediaUri;
    }
}
