package com.google.android.material.internal;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes22.dex */
public class ParcelableSparseBooleanArray extends android.util.SparseBooleanArray implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.google.android.material.internal.ParcelableSparseBooleanArray> CREATOR = new com.google.android.material.internal.ParcelableSparseBooleanArray.AnonymousClass1();

    /* renamed from: com.google.android.material.internal.ParcelableSparseBooleanArray$1, reason: invalid class name */
    public static class AnonymousClass1 implements android.os.Parcelable.Creator<com.google.android.material.internal.ParcelableSparseBooleanArray> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @androidx.annotation.NonNull
        public com.google.android.material.internal.ParcelableSparseBooleanArray createFromParcel(@androidx.annotation.NonNull android.os.Parcel parcel) {
            int readInt = parcel.readInt();
            com.google.android.material.internal.ParcelableSparseBooleanArray parcelableSparseBooleanArray = new com.google.android.material.internal.ParcelableSparseBooleanArray(readInt);
            int[] iArr = new int[readInt];
            boolean[] zArr = new boolean[readInt];
            parcel.readIntArray(iArr);
            parcel.readBooleanArray(zArr);
            for (int i = 0; i < readInt; i++) {
                parcelableSparseBooleanArray.put(iArr[i], zArr[i]);
            }
            return parcelableSparseBooleanArray;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @androidx.annotation.NonNull
        public com.google.android.material.internal.ParcelableSparseBooleanArray[] newArray(int i) {
            return new com.google.android.material.internal.ParcelableSparseBooleanArray[i];
        }
    }

    public ParcelableSparseBooleanArray() {
    }

    public ParcelableSparseBooleanArray(int i) {
        super(i);
    }

    public ParcelableSparseBooleanArray(@androidx.annotation.NonNull android.util.SparseBooleanArray sparseBooleanArray) {
        super(sparseBooleanArray.size());
        for (int i = 0; i < sparseBooleanArray.size(); i++) {
            put(sparseBooleanArray.keyAt(i), sparseBooleanArray.valueAt(i));
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@androidx.annotation.NonNull android.os.Parcel parcel, int i) {
        int[] iArr = new int[size()];
        boolean[] zArr = new boolean[size()];
        for (int i2 = 0; i2 < size(); i2++) {
            iArr[i2] = keyAt(i2);
            zArr[i2] = valueAt(i2);
        }
        parcel.writeInt(size());
        parcel.writeIntArray(iArr);
        parcel.writeBooleanArray(zArr);
    }
}
