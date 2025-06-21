package androidx.core.os;

@java.lang.Deprecated
/* loaded from: classes.dex */
public interface ParcelableCompatCreatorCallbacks<T> {
    T createFromParcel(android.os.Parcel parcel, java.lang.ClassLoader classLoader);

    T[] newArray(int i);
}
