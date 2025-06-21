package com.google.android.exoplayer2.metadata.dvbsi;

/* loaded from: classes22.dex */
public final class AppInfoTable implements com.google.android.exoplayer2.metadata.Metadata.Entry {
    public static final int CONTROL_CODE_AUTOSTART = 1;
    public static final int CONTROL_CODE_PRESENT = 2;
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.dvbsi.AppInfoTable> CREATOR = new com.google.android.exoplayer2.metadata.dvbsi.AppInfoTable.AnonymousClass1();
    public final int controlCode;
    public final java.lang.String url;

    /* renamed from: com.google.android.exoplayer2.metadata.dvbsi.AppInfoTable$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.dvbsi.AppInfoTable> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.metadata.dvbsi.AppInfoTable createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.metadata.dvbsi.AppInfoTable(parcel.readInt(), (java.lang.String) com.google.android.exoplayer2.util.Assertions.checkNotNull(parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.metadata.dvbsi.AppInfoTable[] newArray(int i) {
            return new com.google.android.exoplayer2.metadata.dvbsi.AppInfoTable[i];
        }
    }

    public AppInfoTable(int i, java.lang.String str) {
        this.controlCode = i;
        this.url = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ byte[] getWrappedMetadataBytes() {
        return defpackage.kl1.a(this);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    public /* synthetic */ com.google.android.exoplayer2.Format getWrappedMetadataFormat() {
        return defpackage.kl1.b(this);
    }

    public java.lang.String toString() {
        int i = this.controlCode;
        java.lang.String str = this.url;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 33);
        sb.append("Ait(controlCode=");
        sb.append(i);
        sb.append(",url=");
        sb.append(str);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.url);
        parcel.writeInt(this.controlCode);
    }
}
