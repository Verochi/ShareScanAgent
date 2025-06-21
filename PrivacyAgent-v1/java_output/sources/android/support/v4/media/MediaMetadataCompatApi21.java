package android.support.v4.media;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes.dex */
class MediaMetadataCompatApi21 {

    public static class Builder {
        private Builder() {
        }

        public static java.lang.Object build(java.lang.Object obj) {
            return ((android.media.MediaMetadata.Builder) obj).build();
        }

        public static java.lang.Object newInstance() {
            return new android.media.MediaMetadata.Builder();
        }

        public static void putBitmap(java.lang.Object obj, java.lang.String str, android.graphics.Bitmap bitmap) {
            ((android.media.MediaMetadata.Builder) obj).putBitmap(str, bitmap);
        }

        public static void putLong(java.lang.Object obj, java.lang.String str, long j) {
            ((android.media.MediaMetadata.Builder) obj).putLong(str, j);
        }

        public static void putRating(java.lang.Object obj, java.lang.String str, java.lang.Object obj2) {
            ((android.media.MediaMetadata.Builder) obj).putRating(str, (android.media.Rating) obj2);
        }

        public static void putString(java.lang.Object obj, java.lang.String str, java.lang.String str2) {
            ((android.media.MediaMetadata.Builder) obj).putString(str, str2);
        }

        public static void putText(java.lang.Object obj, java.lang.String str, java.lang.CharSequence charSequence) {
            ((android.media.MediaMetadata.Builder) obj).putText(str, charSequence);
        }
    }

    private MediaMetadataCompatApi21() {
    }

    public static java.lang.Object createFromParcel(android.os.Parcel parcel) {
        return android.media.MediaMetadata.CREATOR.createFromParcel(parcel);
    }

    public static android.graphics.Bitmap getBitmap(java.lang.Object obj, java.lang.String str) {
        return ((android.media.MediaMetadata) obj).getBitmap(str);
    }

    public static long getLong(java.lang.Object obj, java.lang.String str) {
        return ((android.media.MediaMetadata) obj).getLong(str);
    }

    public static java.lang.Object getRating(java.lang.Object obj, java.lang.String str) {
        return ((android.media.MediaMetadata) obj).getRating(str);
    }

    public static java.lang.CharSequence getText(java.lang.Object obj, java.lang.String str) {
        return ((android.media.MediaMetadata) obj).getText(str);
    }

    public static java.util.Set<java.lang.String> keySet(java.lang.Object obj) {
        return ((android.media.MediaMetadata) obj).keySet();
    }

    public static void writeToParcel(java.lang.Object obj, android.os.Parcel parcel, int i) {
        ((android.media.MediaMetadata) obj).writeToParcel(parcel, i);
    }
}
