package androidx.versionedparcelable;

/* loaded from: classes.dex */
public class ParcelUtils {
    private static final java.lang.String INNER_BUNDLE_KEY = "a";

    private ParcelUtils() {
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static <T extends androidx.versionedparcelable.VersionedParcelable> T fromInputStream(java.io.InputStream inputStream) {
        return (T) new androidx.versionedparcelable.VersionedParcelStream(inputStream, null).readVersionedParcelable();
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static <T extends androidx.versionedparcelable.VersionedParcelable> T fromParcelable(android.os.Parcelable parcelable) {
        if (parcelable instanceof androidx.versionedparcelable.ParcelImpl) {
            return (T) ((androidx.versionedparcelable.ParcelImpl) parcelable).getVersionedParcel();
        }
        throw new java.lang.IllegalArgumentException("Invalid parcel");
    }

    @androidx.annotation.Nullable
    public static <T extends androidx.versionedparcelable.VersionedParcelable> T getVersionedParcelable(@androidx.annotation.NonNull android.os.Bundle bundle, @androidx.annotation.NonNull java.lang.String str) {
        try {
            android.os.Bundle bundle2 = (android.os.Bundle) bundle.getParcelable(str);
            if (bundle2 == null) {
                return null;
            }
            bundle2.setClassLoader(androidx.versionedparcelable.ParcelUtils.class.getClassLoader());
            return (T) fromParcelable(bundle2.getParcelable("a"));
        } catch (java.lang.RuntimeException unused) {
            return null;
        }
    }

    @androidx.annotation.Nullable
    public static <T extends androidx.versionedparcelable.VersionedParcelable> java.util.List<T> getVersionedParcelableList(android.os.Bundle bundle, java.lang.String str) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        try {
            android.os.Bundle bundle2 = (android.os.Bundle) bundle.getParcelable(str);
            bundle2.setClassLoader(androidx.versionedparcelable.ParcelUtils.class.getClassLoader());
            java.util.Iterator it = bundle2.getParcelableArrayList("a").iterator();
            while (it.hasNext()) {
                arrayList.add(fromParcelable((android.os.Parcelable) it.next()));
            }
            return arrayList;
        } catch (java.lang.RuntimeException unused) {
            return null;
        }
    }

    public static void putVersionedParcelable(@androidx.annotation.NonNull android.os.Bundle bundle, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable androidx.versionedparcelable.VersionedParcelable versionedParcelable) {
        if (versionedParcelable == null) {
            return;
        }
        android.os.Bundle bundle2 = new android.os.Bundle();
        bundle2.putParcelable("a", toParcelable(versionedParcelable));
        bundle.putParcelable(str, bundle2);
    }

    public static void putVersionedParcelableList(@androidx.annotation.NonNull android.os.Bundle bundle, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.util.List<? extends androidx.versionedparcelable.VersionedParcelable> list) {
        android.os.Bundle bundle2 = new android.os.Bundle();
        java.util.ArrayList<? extends android.os.Parcelable> arrayList = new java.util.ArrayList<>();
        java.util.Iterator<? extends androidx.versionedparcelable.VersionedParcelable> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(toParcelable(it.next()));
        }
        bundle2.putParcelableArrayList("a", arrayList);
        bundle.putParcelable(str, bundle2);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void toOutputStream(androidx.versionedparcelable.VersionedParcelable versionedParcelable, java.io.OutputStream outputStream) {
        androidx.versionedparcelable.VersionedParcelStream versionedParcelStream = new androidx.versionedparcelable.VersionedParcelStream(null, outputStream);
        versionedParcelStream.writeVersionedParcelable(versionedParcelable);
        versionedParcelStream.closeField();
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static android.os.Parcelable toParcelable(androidx.versionedparcelable.VersionedParcelable versionedParcelable) {
        return new androidx.versionedparcelable.ParcelImpl(versionedParcelable);
    }
}
