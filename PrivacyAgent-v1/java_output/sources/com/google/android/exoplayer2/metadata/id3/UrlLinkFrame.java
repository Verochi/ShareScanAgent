package com.google.android.exoplayer2.metadata.id3;

/* loaded from: classes22.dex */
public final class UrlLinkFrame extends com.google.android.exoplayer2.metadata.id3.Id3Frame {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.id3.UrlLinkFrame> CREATOR = new com.google.android.exoplayer2.metadata.id3.UrlLinkFrame.AnonymousClass1();

    @androidx.annotation.Nullable
    public final java.lang.String description;
    public final java.lang.String url;

    /* renamed from: com.google.android.exoplayer2.metadata.id3.UrlLinkFrame$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.id3.UrlLinkFrame> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.metadata.id3.UrlLinkFrame createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.metadata.id3.UrlLinkFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.metadata.id3.UrlLinkFrame[] newArray(int i) {
            return new com.google.android.exoplayer2.metadata.id3.UrlLinkFrame[i];
        }
    }

    public UrlLinkFrame(android.os.Parcel parcel) {
        super((java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(parcel.readString()));
        this.description = parcel.readString();
        this.url = (java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(parcel.readString());
    }

    public UrlLinkFrame(java.lang.String str, @androidx.annotation.Nullable java.lang.String str2, java.lang.String str3) {
        super(str);
        this.description = str2;
        this.url = str3;
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.google.android.exoplayer2.metadata.id3.UrlLinkFrame.class != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.metadata.id3.UrlLinkFrame urlLinkFrame = (com.google.android.exoplayer2.metadata.id3.UrlLinkFrame) obj;
        return this.id.equals(urlLinkFrame.id) && com.google.android.exoplayer2.util.Util.areEqual(this.description, urlLinkFrame.description) && com.google.android.exoplayer2.util.Util.areEqual(this.url, urlLinkFrame.url);
    }

    public int hashCode() {
        int hashCode = (527 + this.id.hashCode()) * 31;
        java.lang.String str = this.description;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        java.lang.String str2 = this.url;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public java.lang.String toString() {
        java.lang.String str = this.id;
        java.lang.String str2 = this.url;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 6 + java.lang.String.valueOf(str2).length());
        sb.append(str);
        sb.append(": url=");
        sb.append(str2);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.description);
        parcel.writeString(this.url);
    }
}
