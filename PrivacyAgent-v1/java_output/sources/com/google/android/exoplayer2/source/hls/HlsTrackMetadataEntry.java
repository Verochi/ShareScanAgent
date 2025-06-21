package com.google.android.exoplayer2.source.hls;

/* loaded from: classes22.dex */
public final class HlsTrackMetadataEntry implements com.google.android.exoplayer2.metadata.Metadata.Entry {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry> CREATOR = new com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry.AnonymousClass1();

    @androidx.annotation.Nullable
    public final java.lang.String groupId;

    @androidx.annotation.Nullable
    public final java.lang.String name;
    public final java.util.List<com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry.VariantInfo> variantInfos;

    /* renamed from: com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry[] newArray(int i) {
            return new com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry[i];
        }
    }

    public static final class VariantInfo implements android.os.Parcelable {
        public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry.VariantInfo> CREATOR = new com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry.VariantInfo.AnonymousClass1();

        @androidx.annotation.Nullable
        public final java.lang.String audioGroupId;
        public final int averageBitrate;

        @androidx.annotation.Nullable
        public final java.lang.String captionGroupId;
        public final int peakBitrate;

        @androidx.annotation.Nullable
        public final java.lang.String subtitleGroupId;

        @androidx.annotation.Nullable
        public final java.lang.String videoGroupId;

        /* renamed from: com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry$VariantInfo$1, reason: invalid class name */
        public class AnonymousClass1 implements android.os.Parcelable.Creator<com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry.VariantInfo> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry.VariantInfo createFromParcel(android.os.Parcel parcel) {
                return new com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry.VariantInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry.VariantInfo[] newArray(int i) {
                return new com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry.VariantInfo[i];
            }
        }

        public VariantInfo(int i, int i2, @androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String str2, @androidx.annotation.Nullable java.lang.String str3, @androidx.annotation.Nullable java.lang.String str4) {
            this.averageBitrate = i;
            this.peakBitrate = i2;
            this.videoGroupId = str;
            this.audioGroupId = str2;
            this.subtitleGroupId = str3;
            this.captionGroupId = str4;
        }

        public VariantInfo(android.os.Parcel parcel) {
            this.averageBitrate = parcel.readInt();
            this.peakBitrate = parcel.readInt();
            this.videoGroupId = parcel.readString();
            this.audioGroupId = parcel.readString();
            this.subtitleGroupId = parcel.readString();
            this.captionGroupId = parcel.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry.VariantInfo.class != obj.getClass()) {
                return false;
            }
            com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry.VariantInfo variantInfo = (com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry.VariantInfo) obj;
            return this.averageBitrate == variantInfo.averageBitrate && this.peakBitrate == variantInfo.peakBitrate && android.text.TextUtils.equals(this.videoGroupId, variantInfo.videoGroupId) && android.text.TextUtils.equals(this.audioGroupId, variantInfo.audioGroupId) && android.text.TextUtils.equals(this.subtitleGroupId, variantInfo.subtitleGroupId) && android.text.TextUtils.equals(this.captionGroupId, variantInfo.captionGroupId);
        }

        public int hashCode() {
            int i = ((this.averageBitrate * 31) + this.peakBitrate) * 31;
            java.lang.String str = this.videoGroupId;
            int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
            java.lang.String str2 = this.audioGroupId;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            java.lang.String str3 = this.subtitleGroupId;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            java.lang.String str4 = this.captionGroupId;
            return hashCode3 + (str4 != null ? str4.hashCode() : 0);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            parcel.writeInt(this.averageBitrate);
            parcel.writeInt(this.peakBitrate);
            parcel.writeString(this.videoGroupId);
            parcel.writeString(this.audioGroupId);
            parcel.writeString(this.subtitleGroupId);
            parcel.writeString(this.captionGroupId);
        }
    }

    public HlsTrackMetadataEntry(android.os.Parcel parcel) {
        this.groupId = parcel.readString();
        this.name = parcel.readString();
        int readInt = parcel.readInt();
        java.util.ArrayList arrayList = new java.util.ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add((com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry.VariantInfo) parcel.readParcelable(com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry.VariantInfo.class.getClassLoader()));
        }
        this.variantInfos = java.util.Collections.unmodifiableList(arrayList);
    }

    public HlsTrackMetadataEntry(@androidx.annotation.Nullable java.lang.String str, @androidx.annotation.Nullable java.lang.String str2, java.util.List<com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry.VariantInfo> list) {
        this.groupId = str;
        this.name = str2;
        this.variantInfos = java.util.Collections.unmodifiableList(new java.util.ArrayList(list));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry.class != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry hlsTrackMetadataEntry = (com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry) obj;
        return android.text.TextUtils.equals(this.groupId, hlsTrackMetadataEntry.groupId) && android.text.TextUtils.equals(this.name, hlsTrackMetadataEntry.name) && this.variantInfos.equals(hlsTrackMetadataEntry.variantInfos);
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
        java.lang.String str = this.groupId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        java.lang.String str2 = this.name;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.variantInfos.hashCode();
    }

    public java.lang.String toString() {
        java.lang.String str;
        java.lang.String str2 = this.groupId;
        if (str2 != null) {
            java.lang.String str3 = this.name;
            java.lang.StringBuilder sb = new java.lang.StringBuilder(java.lang.String.valueOf(str2).length() + 5 + java.lang.String.valueOf(str3).length());
            sb.append(" [");
            sb.append(str2);
            sb.append(", ");
            sb.append(str3);
            sb.append("]");
            str = sb.toString();
        } else {
            str = "";
        }
        java.lang.String valueOf = java.lang.String.valueOf(str);
        return valueOf.length() != 0 ? "HlsTrackMetadataEntry".concat(valueOf) : new java.lang.String("HlsTrackMetadataEntry");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.groupId);
        parcel.writeString(this.name);
        int size = this.variantInfos.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeParcelable(this.variantInfos.get(i2), 0);
        }
    }
}
