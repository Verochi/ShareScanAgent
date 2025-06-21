package com.google.android.exoplayer2.metadata.icy;

/* loaded from: classes22.dex */
public final class IcyInfo implements com.google.android.exoplayer2.metadata.Metadata.Entry {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.icy.IcyInfo> CREATOR = new com.google.android.exoplayer2.metadata.icy.IcyInfo.AnonymousClass1();
    public final byte[] rawMetadata;

    @androidx.annotation.Nullable
    public final java.lang.String title;

    @androidx.annotation.Nullable
    public final java.lang.String url;

    /* renamed from: com.google.android.exoplayer2.metadata.icy.IcyInfo$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.icy.IcyInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.metadata.icy.IcyInfo createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.metadata.icy.IcyInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.metadata.icy.IcyInfo[] newArray(int i) {
            return new com.google.android.exoplayer2.metadata.icy.IcyInfo[i];
        }
    }

    public IcyInfo(android.os.Parcel parcel) {
        this.rawMetadata = (byte[]) com.google.android.exoplayer2.util.Assertions.checkNotNull(parcel.createByteArray());
        this.title = parcel.readString();
        this.url = parcel.readString();
    }

    public IcyInfo(byte[] bArr, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String str2) {
        this.rawMetadata = bArr;
        this.title = str;
        this.url = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.google.android.exoplayer2.metadata.icy.IcyInfo.class != obj.getClass()) {
            return false;
        }
        return java.util.Arrays.equals(this.rawMetadata, ((com.google.android.exoplayer2.metadata.icy.IcyInfo) obj).rawMetadata);
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
        return java.util.Arrays.hashCode(this.rawMetadata);
    }

    public java.lang.String toString() {
        return java.lang.String.format("ICY: title=\"%s\", url=\"%s\", rawMetadata.length=\"%s\"", this.title, this.url, java.lang.Integer.valueOf(this.rawMetadata.length));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeByteArray(this.rawMetadata);
        parcel.writeString(this.title);
        parcel.writeString(this.url);
    }
}
