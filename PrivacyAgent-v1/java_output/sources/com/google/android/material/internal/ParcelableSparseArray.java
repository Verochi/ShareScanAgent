package com.google.android.material.internal;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes22.dex */
public class ParcelableSparseArray extends android.util.SparseArray<android.os.Parcelable> implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.google.android.material.internal.ParcelableSparseArray> CREATOR = new com.google.android.material.internal.ParcelableSparseArray.AnonymousClass1();

    /* renamed from: com.google.android.material.internal.ParcelableSparseArray$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.ClassLoaderCreator<com.google.android.material.internal.ParcelableSparseArray> {
        @Override // android.os.Parcelable.Creator
        @androidx.annotation.Nullable
        public com.google.android.material.internal.ParcelableSparseArray createFromParcel(@androidx.annotation.NonNull android.os.Parcel parcel) {
            return new com.google.android.material.internal.ParcelableSparseArray(parcel, null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.ClassLoaderCreator
        @androidx.annotation.NonNull
        public com.google.android.material.internal.ParcelableSparseArray createFromParcel(@androidx.annotation.NonNull android.os.Parcel parcel, java.lang.ClassLoader classLoader) {
            return new com.google.android.material.internal.ParcelableSparseArray(parcel, classLoader);
        }

        @Override // android.os.Parcelable.Creator
        @androidx.annotation.NonNull
        public com.google.android.material.internal.ParcelableSparseArray[] newArray(int i) {
            return new com.google.android.material.internal.ParcelableSparseArray[i];
        }
    }

    public ParcelableSparseArray() {
    }

    public ParcelableSparseArray(@androidx.annotation.NonNull android.os.Parcel parcel, @androidx.annotation.Nullable java.lang.ClassLoader classLoader) {
        int readInt = parcel.readInt();
        int[] iArr = new int[readInt];
        parcel.readIntArray(iArr);
        android.os.Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
        for (int i = 0; i < readInt; i++) {
            put(iArr[i], readParcelableArray[i]);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@androidx.annotation.NonNull android.os.Parcel parcel, int i) {
        int size = size();
        int[] iArr = new int[size];
        android.os.Parcelable[] parcelableArr = new android.os.Parcelable[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr[i2] = keyAt(i2);
            parcelableArr[i2] = valueAt(i2);
        }
        parcel.writeInt(size);
        parcel.writeIntArray(iArr);
        parcel.writeParcelableArray(parcelableArr, i);
    }
}
