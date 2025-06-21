package com.google.android.exoplayer2.metadata.flac;

/* loaded from: classes22.dex */
public final class VorbisComment implements com.google.android.exoplayer2.metadata.Metadata.Entry {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.flac.VorbisComment> CREATOR = new com.google.android.exoplayer2.metadata.flac.VorbisComment.AnonymousClass1();
    public final java.lang.String key;
    public final java.lang.String value;

    /* renamed from: com.google.android.exoplayer2.metadata.flac.VorbisComment$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.flac.VorbisComment> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.metadata.flac.VorbisComment createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.metadata.flac.VorbisComment(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.metadata.flac.VorbisComment[] newArray(int i) {
            return new com.google.android.exoplayer2.metadata.flac.VorbisComment[i];
        }
    }

    public VorbisComment(android.os.Parcel parcel) {
        this.key = (java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(parcel.readString());
        this.value = (java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(parcel.readString());
    }

    public VorbisComment(java.lang.String str, java.lang.String str2) {
        this.key = str;
        this.value = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.google.android.exoplayer2.metadata.flac.VorbisComment.class != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.metadata.flac.VorbisComment vorbisComment = (com.google.android.exoplayer2.metadata.flac.VorbisComment) obj;
        return this.key.equals(vorbisComment.key) && this.value.equals(vorbisComment.value);
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
        return ((527 + this.key.hashCode()) * 31) + this.value.hashCode();
    }

    public java.lang.String toString() {
        java.lang.String str = this.key;
        java.lang.String str2 = this.value;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 5 + java.lang.String.valueOf(str2).length());
        sb.append("VC: ");
        sb.append(str);
        sb.append(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER);
        sb.append(str2);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.key);
        parcel.writeString(this.value);
    }
}
