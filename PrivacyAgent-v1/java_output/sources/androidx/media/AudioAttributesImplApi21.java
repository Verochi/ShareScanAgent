package androidx.media;

@androidx.annotation.RequiresApi(21)
@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class AudioAttributesImplApi21 implements androidx.media.AudioAttributesImpl {
    private static final java.lang.String TAG = "AudioAttributesCompat21";
    static java.lang.reflect.Method sAudioAttributesToLegacyStreamType;

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public android.media.AudioAttributes mAudioAttributes;

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public int mLegacyStreamType;

    public AudioAttributesImplApi21() {
        this.mLegacyStreamType = -1;
    }

    public AudioAttributesImplApi21(android.media.AudioAttributes audioAttributes) {
        this(audioAttributes, -1);
    }

    public AudioAttributesImplApi21(android.media.AudioAttributes audioAttributes, int i) {
        this.mAudioAttributes = audioAttributes;
        this.mLegacyStreamType = i;
    }

    public static androidx.media.AudioAttributesImpl fromBundle(android.os.Bundle bundle) {
        android.media.AudioAttributes audioAttributes;
        if (bundle == null || (audioAttributes = (android.media.AudioAttributes) bundle.getParcelable("androidx.media.audio_attrs.FRAMEWORKS")) == null) {
            return null;
        }
        return new androidx.media.AudioAttributesImplApi21(audioAttributes, bundle.getInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", -1));
    }

    public static java.lang.reflect.Method getAudioAttributesToLegacyStreamTypeMethod() {
        try {
            if (sAudioAttributesToLegacyStreamType == null) {
                sAudioAttributesToLegacyStreamType = android.media.AudioAttributes.class.getMethod("toLegacyStreamType", android.media.AudioAttributes.class);
            }
            return sAudioAttributesToLegacyStreamType;
        } catch (java.lang.NoSuchMethodException unused) {
            return null;
        }
    }

    public boolean equals(java.lang.Object obj) {
        if (obj instanceof androidx.media.AudioAttributesImplApi21) {
            return this.mAudioAttributes.equals(((androidx.media.AudioAttributesImplApi21) obj).mAudioAttributes);
        }
        return false;
    }

    @Override // androidx.media.AudioAttributesImpl
    public java.lang.Object getAudioAttributes() {
        return this.mAudioAttributes;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getContentType() {
        return this.mAudioAttributes.getContentType();
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getFlags() {
        return this.mAudioAttributes.getFlags();
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getLegacyStreamType() {
        int i = this.mLegacyStreamType;
        if (i != -1) {
            return i;
        }
        java.lang.reflect.Method audioAttributesToLegacyStreamTypeMethod = getAudioAttributesToLegacyStreamTypeMethod();
        if (audioAttributesToLegacyStreamTypeMethod == null) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("No AudioAttributes#toLegacyStreamType() on API: ");
            sb.append(android.os.Build.VERSION.SDK_INT);
            return -1;
        }
        try {
            return ((java.lang.Integer) audioAttributesToLegacyStreamTypeMethod.invoke(null, this.mAudioAttributes)).intValue();
        } catch (java.lang.IllegalAccessException | java.lang.reflect.InvocationTargetException unused) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("getLegacyStreamType() failed on API: ");
            sb2.append(android.os.Build.VERSION.SDK_INT);
            return -1;
        }
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getRawLegacyStreamType() {
        return this.mLegacyStreamType;
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getUsage() {
        return this.mAudioAttributes.getUsage();
    }

    @Override // androidx.media.AudioAttributesImpl
    public int getVolumeControlStream() {
        int volumeControlStream;
        if (android.os.Build.VERSION.SDK_INT < 26) {
            return androidx.media.AudioAttributesCompat.toVolumeStreamType(true, getFlags(), getUsage());
        }
        volumeControlStream = this.mAudioAttributes.getVolumeControlStream();
        return volumeControlStream;
    }

    public int hashCode() {
        return this.mAudioAttributes.hashCode();
    }

    @Override // androidx.media.AudioAttributesImpl
    @androidx.annotation.NonNull
    public android.os.Bundle toBundle() {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putParcelable("androidx.media.audio_attrs.FRAMEWORKS", this.mAudioAttributes);
        int i = this.mLegacyStreamType;
        if (i != -1) {
            bundle.putInt("androidx.media.audio_attrs.LEGACY_STREAM_TYPE", i);
        }
        return bundle;
    }

    public java.lang.String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.mAudioAttributes;
    }
}
