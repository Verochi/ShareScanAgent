package com.google.android.exoplayer2.metadata.id3;

/* loaded from: classes22.dex */
public final class ChapterTocFrame extends com.google.android.exoplayer2.metadata.id3.Id3Frame {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.id3.ChapterTocFrame> CREATOR = new com.google.android.exoplayer2.metadata.id3.ChapterTocFrame.AnonymousClass1();
    public static final java.lang.String ID = "CTOC";
    public final java.lang.String[] children;
    public final java.lang.String elementId;
    public final boolean isOrdered;
    public final boolean isRoot;
    private final com.google.android.exoplayer2.metadata.id3.Id3Frame[] subFrames;

    /* renamed from: com.google.android.exoplayer2.metadata.id3.ChapterTocFrame$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.id3.ChapterTocFrame> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.metadata.id3.ChapterTocFrame createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.metadata.id3.ChapterTocFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.metadata.id3.ChapterTocFrame[] newArray(int i) {
            return new com.google.android.exoplayer2.metadata.id3.ChapterTocFrame[i];
        }
    }

    public ChapterTocFrame(android.os.Parcel parcel) {
        super("CTOC");
        this.elementId = (java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(parcel.readString());
        this.isRoot = parcel.readByte() != 0;
        this.isOrdered = parcel.readByte() != 0;
        this.children = (java.lang.String[]) com.google.android.exoplayer2.util.Util.castNonNull(parcel.createStringArray());
        int readInt = parcel.readInt();
        this.subFrames = new com.google.android.exoplayer2.metadata.id3.Id3Frame[readInt];
        for (int i = 0; i < readInt; i++) {
            this.subFrames[i] = (com.google.android.exoplayer2.metadata.id3.Id3Frame) parcel.readParcelable(com.google.android.exoplayer2.metadata.id3.Id3Frame.class.getClassLoader());
        }
    }

    public ChapterTocFrame(java.lang.String str, boolean z, boolean z2, java.lang.String[] strArr, com.google.android.exoplayer2.metadata.id3.Id3Frame[] id3FrameArr) {
        super("CTOC");
        this.elementId = str;
        this.isRoot = z;
        this.isOrdered = z2;
        this.children = strArr;
        this.subFrames = id3FrameArr;
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.google.android.exoplayer2.metadata.id3.ChapterTocFrame.class != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.metadata.id3.ChapterTocFrame chapterTocFrame = (com.google.android.exoplayer2.metadata.id3.ChapterTocFrame) obj;
        return this.isRoot == chapterTocFrame.isRoot && this.isOrdered == chapterTocFrame.isOrdered && com.google.android.exoplayer2.util.Util.areEqual(this.elementId, chapterTocFrame.elementId) && java.util.Arrays.equals(this.children, chapterTocFrame.children) && java.util.Arrays.equals(this.subFrames, chapterTocFrame.subFrames);
    }

    public com.google.android.exoplayer2.metadata.id3.Id3Frame getSubFrame(int i) {
        return this.subFrames[i];
    }

    public int getSubFrameCount() {
        return this.subFrames.length;
    }

    public int hashCode() {
        int i = (((527 + (this.isRoot ? 1 : 0)) * 31) + (this.isOrdered ? 1 : 0)) * 31;
        java.lang.String str = this.elementId;
        return i + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.elementId);
        parcel.writeByte(this.isRoot ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isOrdered ? (byte) 1 : (byte) 0);
        parcel.writeStringArray(this.children);
        parcel.writeInt(this.subFrames.length);
        for (com.google.android.exoplayer2.metadata.id3.Id3Frame id3Frame : this.subFrames) {
            parcel.writeParcelable(id3Frame, 0);
        }
    }
}
