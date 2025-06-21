package android.support.v4.media;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public final class AudioAttributesImplApi21Parcelizer extends androidx.media.AudioAttributesImplApi21Parcelizer {
    public static androidx.media.AudioAttributesImplApi21 read(androidx.versionedparcelable.VersionedParcel versionedParcel) {
        return androidx.media.AudioAttributesImplApi21Parcelizer.read(versionedParcel);
    }

    public static void write(androidx.media.AudioAttributesImplApi21 audioAttributesImplApi21, androidx.versionedparcelable.VersionedParcel versionedParcel) {
        androidx.media.AudioAttributesImplApi21Parcelizer.write(audioAttributesImplApi21, versionedParcel);
    }
}
