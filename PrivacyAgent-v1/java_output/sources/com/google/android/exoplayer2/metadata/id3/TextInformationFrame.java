package com.google.android.exoplayer2.metadata.id3;

/* loaded from: classes22.dex */
public final class TextInformationFrame extends com.google.android.exoplayer2.metadata.id3.Id3Frame {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.id3.TextInformationFrame> CREATOR = new com.google.android.exoplayer2.metadata.id3.TextInformationFrame.AnonymousClass1();

    @androidx.annotation.Nullable
    public final java.lang.String description;
    public final java.lang.String value;

    /* renamed from: com.google.android.exoplayer2.metadata.id3.TextInformationFrame$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.id3.TextInformationFrame> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.metadata.id3.TextInformationFrame createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.metadata.id3.TextInformationFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.metadata.id3.TextInformationFrame[] newArray(int i) {
            return new com.google.android.exoplayer2.metadata.id3.TextInformationFrame[i];
        }
    }

    public TextInformationFrame(android.os.Parcel parcel) {
        super((java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(parcel.readString()));
        this.description = parcel.readString();
        this.value = (java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(parcel.readString());
    }

    public TextInformationFrame(java.lang.String str, @androidx.annotation.Nullable java.lang.String str2, java.lang.String str3) {
        super(str);
        this.description = str2;
        this.value = str3;
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.google.android.exoplayer2.metadata.id3.TextInformationFrame.class != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.metadata.id3.TextInformationFrame textInformationFrame = (com.google.android.exoplayer2.metadata.id3.TextInformationFrame) obj;
        return this.id.equals(textInformationFrame.id) && com.google.android.exoplayer2.util.Util.areEqual(this.description, textInformationFrame.description) && com.google.android.exoplayer2.util.Util.areEqual(this.value, textInformationFrame.value);
    }

    public int hashCode() {
        int hashCode = (527 + this.id.hashCode()) * 31;
        java.lang.String str = this.description;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        java.lang.String str2 = this.value;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public java.lang.String toString() {
        java.lang.String str = this.id;
        java.lang.String str2 = this.description;
        java.lang.String str3 = this.value;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 22 + java.lang.String.valueOf(str2).length() + java.lang.String.valueOf(str3).length());
        sb.append(str);
        sb.append(": description=");
        sb.append(str2);
        sb.append(": value=");
        sb.append(str3);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.description);
        parcel.writeString(this.value);
    }
}
