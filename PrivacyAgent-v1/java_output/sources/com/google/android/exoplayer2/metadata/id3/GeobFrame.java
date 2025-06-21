package com.google.android.exoplayer2.metadata.id3;

/* loaded from: classes22.dex */
public final class GeobFrame extends com.google.android.exoplayer2.metadata.id3.Id3Frame {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.id3.GeobFrame> CREATOR = new com.google.android.exoplayer2.metadata.id3.GeobFrame.AnonymousClass1();
    public static final java.lang.String ID = "GEOB";
    public final byte[] data;
    public final java.lang.String description;
    public final java.lang.String filename;
    public final java.lang.String mimeType;

    /* renamed from: com.google.android.exoplayer2.metadata.id3.GeobFrame$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.id3.GeobFrame> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.metadata.id3.GeobFrame createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.metadata.id3.GeobFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.metadata.id3.GeobFrame[] newArray(int i) {
            return new com.google.android.exoplayer2.metadata.id3.GeobFrame[i];
        }
    }

    public GeobFrame(android.os.Parcel parcel) {
        super("GEOB");
        this.mimeType = (java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(parcel.readString());
        this.filename = (java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(parcel.readString());
        this.description = (java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(parcel.readString());
        this.data = (byte[]) com.google.android.exoplayer2.util.Util.castNonNull(parcel.createByteArray());
    }

    public GeobFrame(java.lang.String str, java.lang.String str2, java.lang.String str3, byte[] bArr) {
        super("GEOB");
        this.mimeType = str;
        this.filename = str2;
        this.description = str3;
        this.data = bArr;
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.google.android.exoplayer2.metadata.id3.GeobFrame.class != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.metadata.id3.GeobFrame geobFrame = (com.google.android.exoplayer2.metadata.id3.GeobFrame) obj;
        return com.google.android.exoplayer2.util.Util.areEqual(this.mimeType, geobFrame.mimeType) && com.google.android.exoplayer2.util.Util.areEqual(this.filename, geobFrame.filename) && com.google.android.exoplayer2.util.Util.areEqual(this.description, geobFrame.description) && java.util.Arrays.equals(this.data, geobFrame.data);
    }

    public int hashCode() {
        java.lang.String str = this.mimeType;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        java.lang.String str2 = this.filename;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        java.lang.String str3 = this.description;
        return ((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + java.util.Arrays.hashCode(this.data);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public java.lang.String toString() {
        java.lang.String str = this.id;
        java.lang.String str2 = this.mimeType;
        java.lang.String str3 = this.filename;
        java.lang.String str4 = this.description;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 36 + java.lang.String.valueOf(str2).length() + java.lang.String.valueOf(str3).length() + java.lang.String.valueOf(str4).length());
        sb.append(str);
        sb.append(": mimeType=");
        sb.append(str2);
        sb.append(", filename=");
        sb.append(str3);
        sb.append(", description=");
        sb.append(str4);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.mimeType);
        parcel.writeString(this.filename);
        parcel.writeString(this.description);
        parcel.writeByteArray(this.data);
    }
}
