package com.huawei.hms.common.data;

/* loaded from: classes22.dex */
public final class DataHolderCreator implements android.os.Parcelable.Creator<com.huawei.hms.common.data.DataHolder> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public final com.huawei.hms.common.data.DataHolder createFromParcel(android.os.Parcel parcel) {
        int validateObjectHeader = com.huawei.hms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        java.lang.String[] strArr = null;
        android.database.CursorWindow[] cursorWindowArr = null;
        android.os.Bundle bundle = null;
        int i2 = 0;
        int i3 = 0;
        while (i <= validateObjectHeader && parcel.dataPosition() < validateObjectHeader) {
            i++;
            int readHeader = com.huawei.hms.common.internal.safeparcel.SafeParcelReader.readHeader(parcel);
            int fieldId = com.huawei.hms.common.internal.safeparcel.SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1000) {
                i2 = com.huawei.hms.common.internal.safeparcel.SafeParcelReader.readInt(parcel, readHeader);
            } else if (fieldId == 1) {
                strArr = com.huawei.hms.common.internal.safeparcel.SafeParcelReader.createStringArray(parcel, readHeader);
            } else if (fieldId == 2) {
                cursorWindowArr = (android.database.CursorWindow[]) com.huawei.hms.common.internal.safeparcel.SafeParcelReader.createTypedArray(parcel, readHeader, android.database.CursorWindow.CREATOR);
            } else if (fieldId == 3) {
                i3 = com.huawei.hms.common.internal.safeparcel.SafeParcelReader.readInt(parcel, readHeader);
            } else if (fieldId != 4) {
                com.huawei.hms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                bundle = com.huawei.hms.common.internal.safeparcel.SafeParcelReader.createBundle(parcel, readHeader);
            }
        }
        com.huawei.hms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new com.huawei.hms.common.data.DataHolder(i2, strArr, cursorWindowArr, i3, bundle);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public final com.huawei.hms.common.data.DataHolder[] newArray(int i) {
        return new com.huawei.hms.common.data.DataHolder[i];
    }
}
