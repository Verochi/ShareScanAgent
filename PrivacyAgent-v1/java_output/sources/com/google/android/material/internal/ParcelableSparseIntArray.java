package com.google.android.material.internal;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes22.dex */
public class ParcelableSparseIntArray extends android.util.SparseIntArray implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.google.android.material.internal.ParcelableSparseIntArray> CREATOR = new com.google.android.material.internal.ParcelableSparseIntArray.AnonymousClass1();

    /* renamed from: com.google.android.material.internal.ParcelableSparseIntArray$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.google.android.material.internal.ParcelableSparseIntArray> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @androidx.annotation.NonNull
        public com.google.android.material.internal.ParcelableSparseIntArray createFromParcel(@androidx.annotation.NonNull android.os.Parcel parcel) {
            int readInt = parcel.readInt();
            com.google.android.material.internal.ParcelableSparseIntArray parcelableSparseIntArray = new com.google.android.material.internal.ParcelableSparseIntArray(readInt);
            int[] iArr = new int[readInt];
            int[] iArr2 = new int[readInt];
            parcel.readIntArray(iArr);
            parcel.readIntArray(iArr2);
            for (int i = 0; i < readInt; i++) {
                parcelableSparseIntArray.put(iArr[i], iArr2[i]);
            }
            return parcelableSparseIntArray;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @androidx.annotation.NonNull
        public com.google.android.material.internal.ParcelableSparseIntArray[] newArray(int i) {
            return new com.google.android.material.internal.ParcelableSparseIntArray[i];
        }
    }

    public ParcelableSparseIntArray() {
    }

    public ParcelableSparseIntArray(int i) {
        super(i);
    }

    public ParcelableSparseIntArray(@androidx.annotation.NonNull android.util.SparseIntArray sparseIntArray) {
        for (int i = 0; i < sparseIntArray.size(); i++) {
            put(sparseIntArray.keyAt(i), sparseIntArray.valueAt(i));
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@androidx.annotation.NonNull android.os.Parcel parcel, int i) {
        int[] iArr = new int[size()];
        int[] iArr2 = new int[size()];
        for (int i2 = 0; i2 < size(); i2++) {
            iArr[i2] = keyAt(i2);
            iArr2[i2] = valueAt(i2);
        }
        parcel.writeInt(size());
        parcel.writeIntArray(iArr);
        parcel.writeIntArray(iArr2);
    }
}
