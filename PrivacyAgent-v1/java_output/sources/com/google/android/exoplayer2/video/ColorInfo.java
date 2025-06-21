package com.google.android.exoplayer2.video;

/* loaded from: classes22.dex */
public final class ColorInfo implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.video.ColorInfo> CREATOR = new com.google.android.exoplayer2.video.ColorInfo.AnonymousClass1();
    public final int colorRange;
    public final int colorSpace;
    public final int colorTransfer;
    private int hashCode;

    @androidx.annotation.Nullable
    public final byte[] hdrStaticInfo;

    /* renamed from: com.google.android.exoplayer2.video.ColorInfo$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.google.android.exoplayer2.video.ColorInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.video.ColorInfo createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.video.ColorInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.video.ColorInfo[] newArray(int i) {
            return new com.google.android.exoplayer2.video.ColorInfo[i];
        }
    }

    public ColorInfo(int i, int i2, int i3, @androidx.annotation.Nullable byte[] bArr) {
        this.colorSpace = i;
        this.colorRange = i2;
        this.colorTransfer = i3;
        this.hdrStaticInfo = bArr;
    }

    public ColorInfo(android.os.Parcel parcel) {
        this.colorSpace = parcel.readInt();
        this.colorRange = parcel.readInt();
        this.colorTransfer = parcel.readInt();
        this.hdrStaticInfo = com.google.android.exoplayer2.util.Util.readBoolean(parcel) ? parcel.createByteArray() : null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.google.android.exoplayer2.video.ColorInfo.class != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.video.ColorInfo colorInfo = (com.google.android.exoplayer2.video.ColorInfo) obj;
        return this.colorSpace == colorInfo.colorSpace && this.colorRange == colorInfo.colorRange && this.colorTransfer == colorInfo.colorTransfer && java.util.Arrays.equals(this.hdrStaticInfo, colorInfo.hdrStaticInfo);
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = ((((((527 + this.colorSpace) * 31) + this.colorRange) * 31) + this.colorTransfer) * 31) + java.util.Arrays.hashCode(this.hdrStaticInfo);
        }
        return this.hashCode;
    }

    public java.lang.String toString() {
        int i = this.colorSpace;
        int i2 = this.colorRange;
        int i3 = this.colorTransfer;
        boolean z = this.hdrStaticInfo != null;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(55);
        sb.append("ColorInfo(");
        sb.append(i);
        sb.append(", ");
        sb.append(i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(z);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.colorSpace);
        parcel.writeInt(this.colorRange);
        parcel.writeInt(this.colorTransfer);
        com.google.android.exoplayer2.util.Util.writeBoolean(parcel, this.hdrStaticInfo != null);
        byte[] bArr = this.hdrStaticInfo;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
    }
}
