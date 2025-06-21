package com.huawei.hms.common;

/* loaded from: classes22.dex */
public final class FeatureCreator implements android.os.Parcelable.Creator<com.huawei.hms.common.Feature> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public final com.huawei.hms.common.Feature createFromParcel(android.os.Parcel parcel) {
        int validateObjectHeader = com.huawei.hms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(parcel);
        java.lang.String str = null;
        int i = 0;
        long j = -1;
        int i2 = 0;
        while (i <= validateObjectHeader && parcel.dataPosition() < validateObjectHeader) {
            i++;
            int readHeader = com.huawei.hms.common.internal.safeparcel.SafeParcelReader.readHeader(parcel);
            int fieldId = com.huawei.hms.common.internal.safeparcel.SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                str = com.huawei.hms.common.internal.safeparcel.SafeParcelReader.createString(parcel, readHeader);
            } else if (fieldId == 2) {
                i2 = com.huawei.hms.common.internal.safeparcel.SafeParcelReader.readInt(parcel, readHeader);
            } else if (fieldId != 3) {
                com.huawei.hms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                j = com.huawei.hms.common.internal.safeparcel.SafeParcelReader.readLong(parcel, readHeader);
            }
        }
        com.huawei.hms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new com.huawei.hms.common.Feature(str, i2, j);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public final com.huawei.hms.common.Feature[] newArray(int i) {
        return new com.huawei.hms.common.Feature[i];
    }
}
