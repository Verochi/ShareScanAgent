package com.google.android.gms.common.internal;

/* loaded from: classes22.dex */
public final class zzd implements android.os.Parcelable.Creator<com.google.android.gms.common.internal.ConnectionTelemetryConfiguration> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ com.google.android.gms.common.internal.ConnectionTelemetryConfiguration createFromParcel(android.os.Parcel parcel) {
        int validateObjectHeader = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(parcel);
        com.google.android.gms.common.internal.RootTelemetryConfiguration rootTelemetryConfiguration = null;
        int[] iArr = null;
        boolean z = false;
        boolean z2 = false;
        int i = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(parcel);
            int fieldId = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                rootTelemetryConfiguration = (com.google.android.gms.common.internal.RootTelemetryConfiguration) com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(parcel, readHeader, com.google.android.gms.common.internal.RootTelemetryConfiguration.CREATOR);
            } else if (fieldId == 2) {
                z = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(parcel, readHeader);
            } else if (fieldId == 3) {
                z2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(parcel, readHeader);
            } else if (fieldId == 4) {
                iArr = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createIntArray(parcel, readHeader);
            } else if (fieldId != 5) {
                com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                i = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(parcel, readHeader);
            }
        }
        com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new com.google.android.gms.common.internal.ConnectionTelemetryConfiguration(rootTelemetryConfiguration, z, z2, iArr, i);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ com.google.android.gms.common.internal.ConnectionTelemetryConfiguration[] newArray(int i) {
        return new com.google.android.gms.common.internal.ConnectionTelemetryConfiguration[i];
    }
}
