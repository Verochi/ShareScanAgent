package androidx.versionedparcelable;

@android.annotation.SuppressLint({"BanParcelableUsage"})
@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class ParcelImpl implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<androidx.versionedparcelable.ParcelImpl> CREATOR = new androidx.versionedparcelable.ParcelImpl.AnonymousClass1();
    private final androidx.versionedparcelable.VersionedParcelable mParcel;

    /* renamed from: androidx.versionedparcelable.ParcelImpl$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<androidx.versionedparcelable.ParcelImpl> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public androidx.versionedparcelable.ParcelImpl createFromParcel(android.os.Parcel parcel) {
            return new androidx.versionedparcelable.ParcelImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public androidx.versionedparcelable.ParcelImpl[] newArray(int i) {
            return new androidx.versionedparcelable.ParcelImpl[i];
        }
    }

    public ParcelImpl(android.os.Parcel parcel) {
        this.mParcel = new androidx.versionedparcelable.VersionedParcelParcel(parcel).readVersionedParcelable();
    }

    public ParcelImpl(androidx.versionedparcelable.VersionedParcelable versionedParcelable) {
        this.mParcel = versionedParcelable;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public <T extends androidx.versionedparcelable.VersionedParcelable> T getVersionedParcel() {
        return (T) this.mParcel;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        new androidx.versionedparcelable.VersionedParcelParcel(parcel).writeVersionedParcelable(this.mParcel);
    }
}
