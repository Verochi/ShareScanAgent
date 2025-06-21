package com.google.android.exoplayer2.metadata.id3;

/* loaded from: classes22.dex */
public final class InternalFrame extends com.google.android.exoplayer2.metadata.id3.Id3Frame {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.id3.InternalFrame> CREATOR = new com.google.android.exoplayer2.metadata.id3.InternalFrame.AnonymousClass1();
    public static final java.lang.String ID = "----";
    public final java.lang.String description;
    public final java.lang.String domain;
    public final java.lang.String text;

    /* renamed from: com.google.android.exoplayer2.metadata.id3.InternalFrame$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.id3.InternalFrame> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.metadata.id3.InternalFrame createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.metadata.id3.InternalFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.metadata.id3.InternalFrame[] newArray(int i) {
            return new com.google.android.exoplayer2.metadata.id3.InternalFrame[i];
        }
    }

    public InternalFrame(android.os.Parcel parcel) {
        super("----");
        this.domain = (java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(parcel.readString());
        this.description = (java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(parcel.readString());
        this.text = (java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(parcel.readString());
    }

    public InternalFrame(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        super("----");
        this.domain = str;
        this.description = str2;
        this.text = str3;
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.google.android.exoplayer2.metadata.id3.InternalFrame.class != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.metadata.id3.InternalFrame internalFrame = (com.google.android.exoplayer2.metadata.id3.InternalFrame) obj;
        return com.google.android.exoplayer2.util.Util.areEqual(this.description, internalFrame.description) && com.google.android.exoplayer2.util.Util.areEqual(this.domain, internalFrame.domain) && com.google.android.exoplayer2.util.Util.areEqual(this.text, internalFrame.text);
    }

    public int hashCode() {
        java.lang.String str = this.domain;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        java.lang.String str2 = this.description;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        java.lang.String str3 = this.text;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public java.lang.String toString() {
        java.lang.String str = this.id;
        java.lang.String str2 = this.domain;
        java.lang.String str3 = this.description;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 23 + java.lang.String.valueOf(str2).length() + java.lang.String.valueOf(str3).length());
        sb.append(str);
        sb.append(": domain=");
        sb.append(str2);
        sb.append(", description=");
        sb.append(str3);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.domain);
        parcel.writeString(this.text);
    }
}
