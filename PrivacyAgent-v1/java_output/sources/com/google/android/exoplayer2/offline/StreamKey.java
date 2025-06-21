package com.google.android.exoplayer2.offline;

/* loaded from: classes22.dex */
public final class StreamKey implements java.lang.Comparable<com.google.android.exoplayer2.offline.StreamKey>, android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.offline.StreamKey> CREATOR = new com.google.android.exoplayer2.offline.StreamKey.AnonymousClass1();
    public final int groupIndex;
    public final int periodIndex;
    public final int trackIndex;

    /* renamed from: com.google.android.exoplayer2.offline.StreamKey$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.google.android.exoplayer2.offline.StreamKey> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.offline.StreamKey createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.offline.StreamKey(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.offline.StreamKey[] newArray(int i) {
            return new com.google.android.exoplayer2.offline.StreamKey[i];
        }
    }

    public StreamKey(int i, int i2) {
        this(0, i, i2);
    }

    public StreamKey(int i, int i2, int i3) {
        this.periodIndex = i;
        this.groupIndex = i2;
        this.trackIndex = i3;
    }

    public StreamKey(android.os.Parcel parcel) {
        this.periodIndex = parcel.readInt();
        this.groupIndex = parcel.readInt();
        this.trackIndex = parcel.readInt();
    }

    @Override // java.lang.Comparable
    public int compareTo(com.google.android.exoplayer2.offline.StreamKey streamKey) {
        int i = this.periodIndex - streamKey.periodIndex;
        if (i != 0) {
            return i;
        }
        int i2 = this.groupIndex - streamKey.groupIndex;
        return i2 == 0 ? this.trackIndex - streamKey.trackIndex : i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.google.android.exoplayer2.offline.StreamKey.class != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.offline.StreamKey streamKey = (com.google.android.exoplayer2.offline.StreamKey) obj;
        return this.periodIndex == streamKey.periodIndex && this.groupIndex == streamKey.groupIndex && this.trackIndex == streamKey.trackIndex;
    }

    public int hashCode() {
        return (((this.periodIndex * 31) + this.groupIndex) * 31) + this.trackIndex;
    }

    public java.lang.String toString() {
        int i = this.periodIndex;
        int i2 = this.groupIndex;
        int i3 = this.trackIndex;
        java.lang.StringBuilder sb = new java.lang.StringBuilder(35);
        sb.append(i);
        sb.append(".");
        sb.append(i2);
        sb.append(".");
        sb.append(i3);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.periodIndex);
        parcel.writeInt(this.groupIndex);
        parcel.writeInt(this.trackIndex);
    }
}
