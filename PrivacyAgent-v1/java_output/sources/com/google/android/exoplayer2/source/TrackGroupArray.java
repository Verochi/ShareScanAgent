package com.google.android.exoplayer2.source;

/* loaded from: classes22.dex */
public final class TrackGroupArray implements android.os.Parcelable {
    private int hashCode;
    public final int length;
    private final com.google.android.exoplayer2.source.TrackGroup[] trackGroups;
    public static final com.google.android.exoplayer2.source.TrackGroupArray EMPTY = new com.google.android.exoplayer2.source.TrackGroupArray(new com.google.android.exoplayer2.source.TrackGroup[0]);
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.source.TrackGroupArray> CREATOR = new com.google.android.exoplayer2.source.TrackGroupArray.AnonymousClass1();

    /* renamed from: com.google.android.exoplayer2.source.TrackGroupArray$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.google.android.exoplayer2.source.TrackGroupArray> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.source.TrackGroupArray createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.source.TrackGroupArray(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.source.TrackGroupArray[] newArray(int i) {
            return new com.google.android.exoplayer2.source.TrackGroupArray[i];
        }
    }

    public TrackGroupArray(android.os.Parcel parcel) {
        int readInt = parcel.readInt();
        this.length = readInt;
        this.trackGroups = new com.google.android.exoplayer2.source.TrackGroup[readInt];
        for (int i = 0; i < this.length; i++) {
            this.trackGroups[i] = (com.google.android.exoplayer2.source.TrackGroup) parcel.readParcelable(com.google.android.exoplayer2.source.TrackGroup.class.getClassLoader());
        }
    }

    public TrackGroupArray(com.google.android.exoplayer2.source.TrackGroup... trackGroupArr) {
        this.trackGroups = trackGroupArr;
        this.length = trackGroupArr.length;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.google.android.exoplayer2.source.TrackGroupArray.class != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray = (com.google.android.exoplayer2.source.TrackGroupArray) obj;
        return this.length == trackGroupArray.length && java.util.Arrays.equals(this.trackGroups, trackGroupArray.trackGroups);
    }

    public com.google.android.exoplayer2.source.TrackGroup get(int i) {
        return this.trackGroups[i];
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = java.util.Arrays.hashCode(this.trackGroups);
        }
        return this.hashCode;
    }

    public int indexOf(com.google.android.exoplayer2.source.TrackGroup trackGroup) {
        for (int i = 0; i < this.length; i++) {
            if (this.trackGroups[i] == trackGroup) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.length);
        for (int i2 = 0; i2 < this.length; i2++) {
            parcel.writeParcelable(this.trackGroups[i2], 0);
        }
    }
}
