package com.google.android.exoplayer2.metadata.id3;

/* loaded from: classes22.dex */
public final class BinaryFrame extends com.google.android.exoplayer2.metadata.id3.Id3Frame {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.id3.BinaryFrame> CREATOR = new com.google.android.exoplayer2.metadata.id3.BinaryFrame.AnonymousClass1();
    public final byte[] data;

    /* renamed from: com.google.android.exoplayer2.metadata.id3.BinaryFrame$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.id3.BinaryFrame> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.metadata.id3.BinaryFrame createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.metadata.id3.BinaryFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.metadata.id3.BinaryFrame[] newArray(int i) {
            return new com.google.android.exoplayer2.metadata.id3.BinaryFrame[i];
        }
    }

    public BinaryFrame(android.os.Parcel parcel) {
        super((java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(parcel.readString()));
        this.data = (byte[]) com.google.android.exoplayer2.util.Util.castNonNull(parcel.createByteArray());
    }

    public BinaryFrame(java.lang.String str, byte[] bArr) {
        super(str);
        this.data = bArr;
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.google.android.exoplayer2.metadata.id3.BinaryFrame.class != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.metadata.id3.BinaryFrame binaryFrame = (com.google.android.exoplayer2.metadata.id3.BinaryFrame) obj;
        return this.id.equals(binaryFrame.id) && java.util.Arrays.equals(this.data, binaryFrame.data);
    }

    public int hashCode() {
        return ((527 + this.id.hashCode()) * 31) + java.util.Arrays.hashCode(this.data);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeByteArray(this.data);
    }
}
