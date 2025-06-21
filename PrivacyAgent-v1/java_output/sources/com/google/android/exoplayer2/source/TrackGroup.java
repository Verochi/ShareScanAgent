package com.google.android.exoplayer2.source;

/* loaded from: classes22.dex */
public final class TrackGroup implements android.os.Parcelable {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.source.TrackGroup> CREATOR = new com.google.android.exoplayer2.source.TrackGroup.AnonymousClass1();
    private final com.google.android.exoplayer2.Format[] formats;
    private int hashCode;
    public final int length;

    /* renamed from: com.google.android.exoplayer2.source.TrackGroup$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.google.android.exoplayer2.source.TrackGroup> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.source.TrackGroup createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.source.TrackGroup(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.source.TrackGroup[] newArray(int i) {
            return new com.google.android.exoplayer2.source.TrackGroup[i];
        }
    }

    public TrackGroup(android.os.Parcel parcel) {
        int readInt = parcel.readInt();
        this.length = readInt;
        this.formats = new com.google.android.exoplayer2.Format[readInt];
        for (int i = 0; i < this.length; i++) {
            this.formats[i] = (com.google.android.exoplayer2.Format) parcel.readParcelable(com.google.android.exoplayer2.Format.class.getClassLoader());
        }
    }

    public TrackGroup(com.google.android.exoplayer2.Format... formatArr) {
        com.google.android.exoplayer2.util.Assertions.checkState(formatArr.length > 0);
        this.formats = formatArr;
        this.length = formatArr.length;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.google.android.exoplayer2.source.TrackGroup.class != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.source.TrackGroup trackGroup = (com.google.android.exoplayer2.source.TrackGroup) obj;
        return this.length == trackGroup.length && java.util.Arrays.equals(this.formats, trackGroup.formats);
    }

    public com.google.android.exoplayer2.Format getFormat(int i) {
        return this.formats[i];
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = 527 + java.util.Arrays.hashCode(this.formats);
        }
        return this.hashCode;
    }

    public int indexOf(com.google.android.exoplayer2.Format format) {
        int i = 0;
        while (true) {
            com.google.android.exoplayer2.Format[] formatArr = this.formats;
            if (i >= formatArr.length) {
                return -1;
            }
            if (format == formatArr[i]) {
                return i;
            }
            i++;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeInt(this.length);
        for (int i2 = 0; i2 < this.length; i2++) {
            parcel.writeParcelable(this.formats[i2], 0);
        }
    }
}
