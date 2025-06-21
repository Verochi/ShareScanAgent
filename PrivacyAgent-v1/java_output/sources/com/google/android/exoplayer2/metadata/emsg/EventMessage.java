package com.google.android.exoplayer2.metadata.emsg;

/* loaded from: classes22.dex */
public final class EventMessage implements com.google.android.exoplayer2.metadata.Metadata.Entry {

    @androidx.annotation.VisibleForTesting
    public static final java.lang.String ID3_SCHEME_ID_AOM = "https://aomedia.org/emsg/ID3";
    private static final java.lang.String ID3_SCHEME_ID_APPLE = "https://developer.apple.com/streaming/emsg-id3";

    @androidx.annotation.VisibleForTesting
    public static final java.lang.String SCTE35_SCHEME_ID = "urn:scte:scte35:2014:bin";
    public final long durationMs;
    private int hashCode;
    public final long id;
    public final byte[] messageData;
    public final java.lang.String schemeIdUri;
    public final java.lang.String value;
    private static final com.google.android.exoplayer2.Format ID3_FORMAT = new com.google.android.exoplayer2.Format.Builder().setSampleMimeType("application/id3").build();
    private static final com.google.android.exoplayer2.Format SCTE35_FORMAT = new com.google.android.exoplayer2.Format.Builder().setSampleMimeType("application/x-scte35").build();
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.emsg.EventMessage> CREATOR = new com.google.android.exoplayer2.metadata.emsg.EventMessage.AnonymousClass1();

    /* renamed from: com.google.android.exoplayer2.metadata.emsg.EventMessage$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.emsg.EventMessage> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.metadata.emsg.EventMessage createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.metadata.emsg.EventMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.metadata.emsg.EventMessage[] newArray(int i) {
            return new com.google.android.exoplayer2.metadata.emsg.EventMessage[i];
        }
    }

    public EventMessage(android.os.Parcel parcel) {
        this.schemeIdUri = (java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(parcel.readString());
        this.value = (java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(parcel.readString());
        this.durationMs = parcel.readLong();
        this.id = parcel.readLong();
        this.messageData = (byte[]) com.google.android.exoplayer2.util.Util.castNonNull(parcel.createByteArray());
    }

    public EventMessage(java.lang.String str, java.lang.String str2, long j, long j2, byte[] bArr) {
        this.schemeIdUri = str;
        this.value = str2;
        this.durationMs = j;
        this.id = j2;
        this.messageData = bArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.google.android.exoplayer2.metadata.emsg.EventMessage.class != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.metadata.emsg.EventMessage eventMessage = (com.google.android.exoplayer2.metadata.emsg.EventMessage) obj;
        return this.durationMs == eventMessage.durationMs && this.id == eventMessage.id && com.google.android.exoplayer2.util.Util.areEqual(this.schemeIdUri, eventMessage.schemeIdUri) && com.google.android.exoplayer2.util.Util.areEqual(this.value, eventMessage.value) && java.util.Arrays.equals(this.messageData, eventMessage.messageData);
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    @androidx.annotation.Nullable
    public byte[] getWrappedMetadataBytes() {
        if (getWrappedMetadataFormat() != null) {
            return this.messageData;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.metadata.Metadata.Entry
    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.Format getWrappedMetadataFormat() {
        java.lang.String str = this.schemeIdUri;
        str.hashCode();
        switch (str) {
            case "urn:scte:scte35:2014:bin":
                return SCTE35_FORMAT;
            case "https://aomedia.org/emsg/ID3":
            case "https://developer.apple.com/streaming/emsg-id3":
                return ID3_FORMAT;
            default:
                return null;
        }
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            java.lang.String str = this.schemeIdUri;
            int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
            java.lang.String str2 = this.value;
            int hashCode2 = str2 != null ? str2.hashCode() : 0;
            long j = this.durationMs;
            int i = (((hashCode + hashCode2) * 31) + ((int) (j ^ (j >>> 32)))) * 31;
            long j2 = this.id;
            this.hashCode = ((i + ((int) (j2 ^ (j2 >>> 32)))) * 31) + java.util.Arrays.hashCode(this.messageData);
        }
        return this.hashCode;
    }

    public java.lang.String toString() {
        java.lang.String str = this.schemeIdUri;
        long j = this.id;
        long j2 = this.durationMs;
        java.lang.String str2 = this.value;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str).length() + 79 + java.lang.String.valueOf(str2).length());
        sb.append("EMSG: scheme=");
        sb.append(str);
        sb.append(", id=");
        sb.append(j);
        sb.append(", durationMs=");
        sb.append(j2);
        sb.append(", value=");
        sb.append(str2);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.schemeIdUri);
        parcel.writeString(this.value);
        parcel.writeLong(this.durationMs);
        parcel.writeLong(this.id);
        parcel.writeByteArray(this.messageData);
    }
}
