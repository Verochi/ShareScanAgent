package androidx.core.os;

/* loaded from: classes.dex */
public final class ParcelCompat {
    private ParcelCompat() {
    }

    public static boolean readBoolean(@androidx.annotation.NonNull android.os.Parcel parcel) {
        return parcel.readInt() != 0;
    }

    public static void writeBoolean(@androidx.annotation.NonNull android.os.Parcel parcel, boolean z) {
        parcel.writeInt(z ? 1 : 0);
    }
}
