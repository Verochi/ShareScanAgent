package android.support.v4.media;

@androidx.annotation.RequiresApi(21)
/* loaded from: classes.dex */
class MediaDescriptionCompatApi21 {

    public static class Builder {
        private Builder() {
        }

        public static java.lang.Object build(java.lang.Object obj) {
            return ((android.media.MediaDescription.Builder) obj).build();
        }

        public static java.lang.Object newInstance() {
            return new android.media.MediaDescription.Builder();
        }

        public static void setDescription(java.lang.Object obj, java.lang.CharSequence charSequence) {
            ((android.media.MediaDescription.Builder) obj).setDescription(charSequence);
        }

        public static void setExtras(java.lang.Object obj, android.os.Bundle bundle) {
            ((android.media.MediaDescription.Builder) obj).setExtras(bundle);
        }

        public static void setIconBitmap(java.lang.Object obj, android.graphics.Bitmap bitmap) {
            ((android.media.MediaDescription.Builder) obj).setIconBitmap(bitmap);
        }

        public static void setIconUri(java.lang.Object obj, android.net.Uri uri) {
            ((android.media.MediaDescription.Builder) obj).setIconUri(uri);
        }

        public static void setMediaId(java.lang.Object obj, java.lang.String str) {
            ((android.media.MediaDescription.Builder) obj).setMediaId(str);
        }

        public static void setSubtitle(java.lang.Object obj, java.lang.CharSequence charSequence) {
            ((android.media.MediaDescription.Builder) obj).setSubtitle(charSequence);
        }

        public static void setTitle(java.lang.Object obj, java.lang.CharSequence charSequence) {
            ((android.media.MediaDescription.Builder) obj).setTitle(charSequence);
        }
    }

    private MediaDescriptionCompatApi21() {
    }

    public static java.lang.Object fromParcel(android.os.Parcel parcel) {
        return android.media.MediaDescription.CREATOR.createFromParcel(parcel);
    }

    public static java.lang.CharSequence getDescription(java.lang.Object obj) {
        return ((android.media.MediaDescription) obj).getDescription();
    }

    public static android.os.Bundle getExtras(java.lang.Object obj) {
        return ((android.media.MediaDescription) obj).getExtras();
    }

    public static android.graphics.Bitmap getIconBitmap(java.lang.Object obj) {
        return ((android.media.MediaDescription) obj).getIconBitmap();
    }

    public static android.net.Uri getIconUri(java.lang.Object obj) {
        return ((android.media.MediaDescription) obj).getIconUri();
    }

    public static java.lang.String getMediaId(java.lang.Object obj) {
        return ((android.media.MediaDescription) obj).getMediaId();
    }

    public static java.lang.CharSequence getSubtitle(java.lang.Object obj) {
        return ((android.media.MediaDescription) obj).getSubtitle();
    }

    public static java.lang.CharSequence getTitle(java.lang.Object obj) {
        return ((android.media.MediaDescription) obj).getTitle();
    }

    public static void writeToParcel(java.lang.Object obj, android.os.Parcel parcel, int i) {
        ((android.media.MediaDescription) obj).writeToParcel(parcel, i);
    }
}
