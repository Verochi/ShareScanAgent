package android.support.v4.media;

/* loaded from: classes.dex */
public final class MediaMetadataCompat implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<android.support.v4.media.MediaMetadataCompat> CREATOR;
    static final androidx.collection.ArrayMap<java.lang.String, java.lang.Integer> METADATA_KEYS_TYPE;
    public static final java.lang.String METADATA_KEY_ADVERTISEMENT = "android.media.metadata.ADVERTISEMENT";
    public static final java.lang.String METADATA_KEY_ALBUM = "android.media.metadata.ALBUM";
    public static final java.lang.String METADATA_KEY_ALBUM_ART = "android.media.metadata.ALBUM_ART";
    public static final java.lang.String METADATA_KEY_ALBUM_ARTIST = "android.media.metadata.ALBUM_ARTIST";
    public static final java.lang.String METADATA_KEY_ALBUM_ART_URI = "android.media.metadata.ALBUM_ART_URI";
    public static final java.lang.String METADATA_KEY_ART = "android.media.metadata.ART";
    public static final java.lang.String METADATA_KEY_ARTIST = "android.media.metadata.ARTIST";
    public static final java.lang.String METADATA_KEY_ART_URI = "android.media.metadata.ART_URI";
    public static final java.lang.String METADATA_KEY_AUTHOR = "android.media.metadata.AUTHOR";
    public static final java.lang.String METADATA_KEY_BT_FOLDER_TYPE = "android.media.metadata.BT_FOLDER_TYPE";
    public static final java.lang.String METADATA_KEY_COMPILATION = "android.media.metadata.COMPILATION";
    public static final java.lang.String METADATA_KEY_COMPOSER = "android.media.metadata.COMPOSER";
    public static final java.lang.String METADATA_KEY_DATE = "android.media.metadata.DATE";
    public static final java.lang.String METADATA_KEY_DISC_NUMBER = "android.media.metadata.DISC_NUMBER";
    public static final java.lang.String METADATA_KEY_DISPLAY_DESCRIPTION = "android.media.metadata.DISPLAY_DESCRIPTION";
    public static final java.lang.String METADATA_KEY_DISPLAY_ICON = "android.media.metadata.DISPLAY_ICON";
    public static final java.lang.String METADATA_KEY_DISPLAY_ICON_URI = "android.media.metadata.DISPLAY_ICON_URI";
    public static final java.lang.String METADATA_KEY_DISPLAY_SUBTITLE = "android.media.metadata.DISPLAY_SUBTITLE";
    public static final java.lang.String METADATA_KEY_DISPLAY_TITLE = "android.media.metadata.DISPLAY_TITLE";
    public static final java.lang.String METADATA_KEY_DOWNLOAD_STATUS = "android.media.metadata.DOWNLOAD_STATUS";
    public static final java.lang.String METADATA_KEY_DURATION = "android.media.metadata.DURATION";
    public static final java.lang.String METADATA_KEY_GENRE = "android.media.metadata.GENRE";
    public static final java.lang.String METADATA_KEY_MEDIA_ID = "android.media.metadata.MEDIA_ID";
    public static final java.lang.String METADATA_KEY_MEDIA_URI = "android.media.metadata.MEDIA_URI";
    public static final java.lang.String METADATA_KEY_NUM_TRACKS = "android.media.metadata.NUM_TRACKS";
    public static final java.lang.String METADATA_KEY_RATING = "android.media.metadata.RATING";
    public static final java.lang.String METADATA_KEY_TITLE = "android.media.metadata.TITLE";
    public static final java.lang.String METADATA_KEY_TRACK_NUMBER = "android.media.metadata.TRACK_NUMBER";
    public static final java.lang.String METADATA_KEY_USER_RATING = "android.media.metadata.USER_RATING";
    public static final java.lang.String METADATA_KEY_WRITER = "android.media.metadata.WRITER";
    public static final java.lang.String METADATA_KEY_YEAR = "android.media.metadata.YEAR";
    static final int METADATA_TYPE_BITMAP = 2;
    static final int METADATA_TYPE_LONG = 0;
    static final int METADATA_TYPE_RATING = 3;
    static final int METADATA_TYPE_TEXT = 1;
    private static final java.lang.String[] PREFERRED_BITMAP_ORDER;
    private static final java.lang.String[] PREFERRED_DESCRIPTION_ORDER;
    private static final java.lang.String[] PREFERRED_URI_ORDER;
    private static final java.lang.String TAG = "MediaMetadata";
    final android.os.Bundle mBundle;
    private android.support.v4.media.MediaDescriptionCompat mDescription;
    private java.lang.Object mMetadataObj;

    /* renamed from: android.support.v4.media.MediaMetadataCompat$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<android.support.v4.media.MediaMetadataCompat> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public android.support.v4.media.MediaMetadataCompat createFromParcel(android.os.Parcel parcel) {
            return new android.support.v4.media.MediaMetadataCompat(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public android.support.v4.media.MediaMetadataCompat[] newArray(int i) {
            return new android.support.v4.media.MediaMetadataCompat[i];
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface BitmapKey {
    }

    public static final class Builder {
        private final android.os.Bundle mBundle;

        public Builder() {
            this.mBundle = new android.os.Bundle();
        }

        public Builder(android.support.v4.media.MediaMetadataCompat mediaMetadataCompat) {
            android.os.Bundle bundle = new android.os.Bundle(mediaMetadataCompat.mBundle);
            this.mBundle = bundle;
            android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(bundle);
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public Builder(android.support.v4.media.MediaMetadataCompat mediaMetadataCompat, int i) {
            this(mediaMetadataCompat);
            for (java.lang.String str : this.mBundle.keySet()) {
                java.lang.Object obj = this.mBundle.get(str);
                if (obj instanceof android.graphics.Bitmap) {
                    android.graphics.Bitmap bitmap = (android.graphics.Bitmap) obj;
                    if (bitmap.getHeight() > i || bitmap.getWidth() > i) {
                        putBitmap(str, scaleBitmap(bitmap, i));
                    }
                }
            }
        }

        private android.graphics.Bitmap scaleBitmap(android.graphics.Bitmap bitmap, int i) {
            float f = i;
            float min = java.lang.Math.min(f / bitmap.getWidth(), f / bitmap.getHeight());
            return android.graphics.Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * min), (int) (bitmap.getHeight() * min), true);
        }

        public android.support.v4.media.MediaMetadataCompat build() {
            return new android.support.v4.media.MediaMetadataCompat(this.mBundle);
        }

        public android.support.v4.media.MediaMetadataCompat.Builder putBitmap(java.lang.String str, android.graphics.Bitmap bitmap) {
            androidx.collection.ArrayMap<java.lang.String, java.lang.Integer> arrayMap = android.support.v4.media.MediaMetadataCompat.METADATA_KEYS_TYPE;
            if (!arrayMap.containsKey(str) || arrayMap.get(str).intValue() == 2) {
                this.mBundle.putParcelable(str, bitmap);
                return this;
            }
            throw new java.lang.IllegalArgumentException("The " + str + " key cannot be used to put a Bitmap");
        }

        public android.support.v4.media.MediaMetadataCompat.Builder putLong(java.lang.String str, long j) {
            androidx.collection.ArrayMap<java.lang.String, java.lang.Integer> arrayMap = android.support.v4.media.MediaMetadataCompat.METADATA_KEYS_TYPE;
            if (!arrayMap.containsKey(str) || arrayMap.get(str).intValue() == 0) {
                this.mBundle.putLong(str, j);
                return this;
            }
            throw new java.lang.IllegalArgumentException("The " + str + " key cannot be used to put a long");
        }

        public android.support.v4.media.MediaMetadataCompat.Builder putRating(java.lang.String str, android.support.v4.media.RatingCompat ratingCompat) {
            androidx.collection.ArrayMap<java.lang.String, java.lang.Integer> arrayMap = android.support.v4.media.MediaMetadataCompat.METADATA_KEYS_TYPE;
            if (!arrayMap.containsKey(str) || arrayMap.get(str).intValue() == 3) {
                this.mBundle.putParcelable(str, (android.os.Parcelable) ratingCompat.getRating());
                return this;
            }
            throw new java.lang.IllegalArgumentException("The " + str + " key cannot be used to put a Rating");
        }

        public android.support.v4.media.MediaMetadataCompat.Builder putString(java.lang.String str, java.lang.String str2) {
            androidx.collection.ArrayMap<java.lang.String, java.lang.Integer> arrayMap = android.support.v4.media.MediaMetadataCompat.METADATA_KEYS_TYPE;
            if (!arrayMap.containsKey(str) || arrayMap.get(str).intValue() == 1) {
                this.mBundle.putCharSequence(str, str2);
                return this;
            }
            throw new java.lang.IllegalArgumentException("The " + str + " key cannot be used to put a String");
        }

        public android.support.v4.media.MediaMetadataCompat.Builder putText(java.lang.String str, java.lang.CharSequence charSequence) {
            androidx.collection.ArrayMap<java.lang.String, java.lang.Integer> arrayMap = android.support.v4.media.MediaMetadataCompat.METADATA_KEYS_TYPE;
            if (!arrayMap.containsKey(str) || arrayMap.get(str).intValue() == 1) {
                this.mBundle.putCharSequence(str, charSequence);
                return this;
            }
            throw new java.lang.IllegalArgumentException("The " + str + " key cannot be used to put a CharSequence");
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface LongKey {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface RatingKey {
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface TextKey {
    }

    static {
        androidx.collection.ArrayMap<java.lang.String, java.lang.Integer> arrayMap = new androidx.collection.ArrayMap<>();
        METADATA_KEYS_TYPE = arrayMap;
        arrayMap.put(METADATA_KEY_TITLE, 1);
        arrayMap.put(METADATA_KEY_ARTIST, 1);
        arrayMap.put(METADATA_KEY_DURATION, 0);
        arrayMap.put(METADATA_KEY_ALBUM, 1);
        arrayMap.put(METADATA_KEY_AUTHOR, 1);
        arrayMap.put(METADATA_KEY_WRITER, 1);
        arrayMap.put(METADATA_KEY_COMPOSER, 1);
        arrayMap.put(METADATA_KEY_COMPILATION, 1);
        arrayMap.put(METADATA_KEY_DATE, 1);
        arrayMap.put(METADATA_KEY_YEAR, 0);
        arrayMap.put(METADATA_KEY_GENRE, 1);
        arrayMap.put(METADATA_KEY_TRACK_NUMBER, 0);
        arrayMap.put(METADATA_KEY_NUM_TRACKS, 0);
        arrayMap.put(METADATA_KEY_DISC_NUMBER, 0);
        arrayMap.put(METADATA_KEY_ALBUM_ARTIST, 1);
        arrayMap.put(METADATA_KEY_ART, 2);
        arrayMap.put(METADATA_KEY_ART_URI, 1);
        arrayMap.put(METADATA_KEY_ALBUM_ART, 2);
        arrayMap.put(METADATA_KEY_ALBUM_ART_URI, 1);
        arrayMap.put(METADATA_KEY_USER_RATING, 3);
        arrayMap.put(METADATA_KEY_RATING, 3);
        arrayMap.put(METADATA_KEY_DISPLAY_TITLE, 1);
        arrayMap.put(METADATA_KEY_DISPLAY_SUBTITLE, 1);
        arrayMap.put(METADATA_KEY_DISPLAY_DESCRIPTION, 1);
        arrayMap.put(METADATA_KEY_DISPLAY_ICON, 2);
        arrayMap.put(METADATA_KEY_DISPLAY_ICON_URI, 1);
        arrayMap.put(METADATA_KEY_MEDIA_ID, 1);
        arrayMap.put(METADATA_KEY_BT_FOLDER_TYPE, 0);
        arrayMap.put(METADATA_KEY_MEDIA_URI, 1);
        arrayMap.put(METADATA_KEY_ADVERTISEMENT, 0);
        arrayMap.put(METADATA_KEY_DOWNLOAD_STATUS, 0);
        PREFERRED_DESCRIPTION_ORDER = new java.lang.String[]{METADATA_KEY_TITLE, METADATA_KEY_ARTIST, METADATA_KEY_ALBUM, METADATA_KEY_ALBUM_ARTIST, METADATA_KEY_WRITER, METADATA_KEY_AUTHOR, METADATA_KEY_COMPOSER};
        PREFERRED_BITMAP_ORDER = new java.lang.String[]{METADATA_KEY_DISPLAY_ICON, METADATA_KEY_ART, METADATA_KEY_ALBUM_ART};
        PREFERRED_URI_ORDER = new java.lang.String[]{METADATA_KEY_DISPLAY_ICON_URI, METADATA_KEY_ART_URI, METADATA_KEY_ALBUM_ART_URI};
        CREATOR = new android.support.v4.media.MediaMetadataCompat.AnonymousClass1();
    }

    public MediaMetadataCompat(android.os.Bundle bundle) {
        android.os.Bundle bundle2 = new android.os.Bundle(bundle);
        this.mBundle = bundle2;
        android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(bundle2);
    }

    public MediaMetadataCompat(android.os.Parcel parcel) {
        this.mBundle = parcel.readBundle(android.support.v4.media.session.MediaSessionCompat.class.getClassLoader());
    }

    public static android.support.v4.media.MediaMetadataCompat fromMediaMetadata(java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        android.os.Parcel obtain = android.os.Parcel.obtain();
        android.support.v4.media.MediaMetadataCompatApi21.writeToParcel(obj, obtain, 0);
        obtain.setDataPosition(0);
        android.support.v4.media.MediaMetadataCompat createFromParcel = CREATOR.createFromParcel(obtain);
        obtain.recycle();
        createFromParcel.mMetadataObj = obj;
        return createFromParcel;
    }

    public boolean containsKey(java.lang.String str) {
        return this.mBundle.containsKey(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public android.graphics.Bitmap getBitmap(java.lang.String str) {
        try {
            return (android.graphics.Bitmap) this.mBundle.getParcelable(str);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public android.os.Bundle getBundle() {
        return new android.os.Bundle(this.mBundle);
    }

    public android.support.v4.media.MediaDescriptionCompat getDescription() {
        android.graphics.Bitmap bitmap;
        android.net.Uri uri;
        android.support.v4.media.MediaDescriptionCompat mediaDescriptionCompat = this.mDescription;
        if (mediaDescriptionCompat != null) {
            return mediaDescriptionCompat;
        }
        java.lang.String string = getString(METADATA_KEY_MEDIA_ID);
        java.lang.CharSequence[] charSequenceArr = new java.lang.CharSequence[3];
        java.lang.CharSequence text = getText(METADATA_KEY_DISPLAY_TITLE);
        if (android.text.TextUtils.isEmpty(text)) {
            int i = 0;
            int i2 = 0;
            while (i < 3) {
                java.lang.String[] strArr = PREFERRED_DESCRIPTION_ORDER;
                if (i2 >= strArr.length) {
                    break;
                }
                int i3 = i2 + 1;
                java.lang.CharSequence text2 = getText(strArr[i2]);
                if (!android.text.TextUtils.isEmpty(text2)) {
                    charSequenceArr[i] = text2;
                    i++;
                }
                i2 = i3;
            }
        } else {
            charSequenceArr[0] = text;
            charSequenceArr[1] = getText(METADATA_KEY_DISPLAY_SUBTITLE);
            charSequenceArr[2] = getText(METADATA_KEY_DISPLAY_DESCRIPTION);
        }
        int i4 = 0;
        while (true) {
            java.lang.String[] strArr2 = PREFERRED_BITMAP_ORDER;
            if (i4 >= strArr2.length) {
                bitmap = null;
                break;
            }
            bitmap = getBitmap(strArr2[i4]);
            if (bitmap != null) {
                break;
            }
            i4++;
        }
        int i5 = 0;
        while (true) {
            java.lang.String[] strArr3 = PREFERRED_URI_ORDER;
            if (i5 >= strArr3.length) {
                uri = null;
                break;
            }
            java.lang.String string2 = getString(strArr3[i5]);
            if (!android.text.TextUtils.isEmpty(string2)) {
                uri = android.net.Uri.parse(string2);
                break;
            }
            i5++;
        }
        java.lang.String string3 = getString(METADATA_KEY_MEDIA_URI);
        android.net.Uri parse = android.text.TextUtils.isEmpty(string3) ? null : android.net.Uri.parse(string3);
        android.support.v4.media.MediaDescriptionCompat.Builder builder = new android.support.v4.media.MediaDescriptionCompat.Builder();
        builder.setMediaId(string);
        builder.setTitle(charSequenceArr[0]);
        builder.setSubtitle(charSequenceArr[1]);
        builder.setDescription(charSequenceArr[2]);
        builder.setIconBitmap(bitmap);
        builder.setIconUri(uri);
        builder.setMediaUri(parse);
        android.os.Bundle bundle = new android.os.Bundle();
        if (this.mBundle.containsKey(METADATA_KEY_BT_FOLDER_TYPE)) {
            bundle.putLong(android.support.v4.media.MediaDescriptionCompat.EXTRA_BT_FOLDER_TYPE, getLong(METADATA_KEY_BT_FOLDER_TYPE));
        }
        if (this.mBundle.containsKey(METADATA_KEY_DOWNLOAD_STATUS)) {
            bundle.putLong(android.support.v4.media.MediaDescriptionCompat.EXTRA_DOWNLOAD_STATUS, getLong(METADATA_KEY_DOWNLOAD_STATUS));
        }
        if (!bundle.isEmpty()) {
            builder.setExtras(bundle);
        }
        android.support.v4.media.MediaDescriptionCompat build = builder.build();
        this.mDescription = build;
        return build;
    }

    public long getLong(java.lang.String str) {
        return this.mBundle.getLong(str, 0L);
    }

    public java.lang.Object getMediaMetadata() {
        if (this.mMetadataObj == null) {
            android.os.Parcel obtain = android.os.Parcel.obtain();
            writeToParcel(obtain, 0);
            obtain.setDataPosition(0);
            this.mMetadataObj = android.support.v4.media.MediaMetadataCompatApi21.createFromParcel(obtain);
            obtain.recycle();
        }
        return this.mMetadataObj;
    }

    public android.support.v4.media.RatingCompat getRating(java.lang.String str) {
        try {
            return android.support.v4.media.RatingCompat.fromRating(this.mBundle.getParcelable(str));
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public java.lang.String getString(java.lang.String str) {
        java.lang.CharSequence charSequence = this.mBundle.getCharSequence(str);
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public java.lang.CharSequence getText(java.lang.String str) {
        return this.mBundle.getCharSequence(str);
    }

    public java.util.Set<java.lang.String> keySet() {
        return this.mBundle.keySet();
    }

    public int size() {
        return this.mBundle.size();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeBundle(this.mBundle);
    }
}
