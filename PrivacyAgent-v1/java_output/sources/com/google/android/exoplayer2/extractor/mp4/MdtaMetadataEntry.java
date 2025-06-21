package com.google.android.exoplayer2.extractor.mp4;

/* loaded from: classes22.dex */
public final class MdtaMetadataEntry implements com.google.android.exoplayer2.metadata.Metadata.Entry {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.extractor.mp4.MdtaMetadataEntry> CREATOR = new com.google.android.exoplayer2.extractor.mp4.MdtaMetadataEntry.AnonymousClass1();
    public final java.lang.String key;
    public final int localeIndicator;
    public final int typeIndicator;
    public final byte[] value;

    /* renamed from: com.google.android.exoplayer2.extractor.mp4.MdtaMetadataEntry$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.google.android.exoplayer2.extractor.mp4.MdtaMetadataEntry> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.extractor.mp4.MdtaMetadataEntry createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.extractor.mp4.MdtaMetadataEntry(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.extractor.mp4.MdtaMetadataEntry[] newArray(int i) {
            return new com.google.android.exoplayer2.extractor.mp4.MdtaMetadataEntry[i];
        }
    }

    private MdtaMetadataEntry(android.os.Parcel parcel) {
        this.key = (java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(parcel.readString());
        this.value = (byte[]) com.google.android.exoplayer2.util.Util.castNonNull(parcel.createByteArray());
        this.localeIndicator = parcel.readInt();
        this.typeIndicator = parcel.readInt();
    }

    public /* synthetic */ MdtaMetadataEntry(android.os.Parcel parcel, com.google.android.exoplayer2.extractor.mp4.MdtaMetadataEntry.AnonymousClass1 anonymousClass1) {
        this(parcel);
    }

    public MdtaMetadataEntry(java.lang.String str, byte[] bArr, int i, int i2) {
        this.key = str;
        this.value = bArr;
        this.localeIndicator = i;
        this.typeIndicator = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.google.android.exoplayer2.extractor.mp4.MdtaMetadataEntry.class != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.extractor.mp4.MdtaMetadataEntry mdtaMetadataEntry = (com.google.android.exoplayer2.extractor.mp4.MdtaMetadataEntry) obj;
        return this.key.equals(mdtaMetadataEntry.key) && java.util.Arrays.equals(this.value, mdtaMetadataEntry.value) && this.localeIndicator == mdtaMetadataEntry.localeIndicator && this.typeIndicator == mdtaMetadataEntry.typeIndicator;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ byte[] getWrappedMetadataBytes() {
        return defpackage.kl1.a(this);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ com.google.android.exoplayer2.Format getWrappedMetadataFormat() {
        return defpackage.kl1.b(this);
    }

    public int hashCode() {
        return ((((((527 + this.key.hashCode()) * 31) + java.util.Arrays.hashCode(this.value)) * 31) + this.localeIndicator) * 31) + this.typeIndicator;
    }

    public java.lang.String toString() {
        java.lang.String valueOf = java.lang.String.valueOf(this.key);
        return valueOf.length() != 0 ? "mdta: key=".concat(valueOf) : new java.lang.String("mdta: key=");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.key);
        parcel.writeByteArray(this.value);
        parcel.writeInt(this.localeIndicator);
        parcel.writeInt(this.typeIndicator);
    }
}
