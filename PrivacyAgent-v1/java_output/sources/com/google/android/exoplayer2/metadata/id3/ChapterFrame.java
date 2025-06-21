package com.google.android.exoplayer2.metadata.id3;

/* loaded from: classes22.dex */
public final class ChapterFrame extends com.google.android.exoplayer2.metadata.id3.Id3Frame {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.id3.ChapterFrame> CREATOR = new com.google.android.exoplayer2.metadata.id3.ChapterFrame.AnonymousClass1();
    public static final java.lang.String ID = "CHAP";
    public final java.lang.String chapterId;
    public final long endOffset;
    public final int endTimeMs;
    public final long startOffset;
    public final int startTimeMs;
    private final com.google.android.exoplayer2.metadata.id3.Id3Frame[] subFrames;

    /* renamed from: com.google.android.exoplayer2.metadata.id3.ChapterFrame$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.id3.ChapterFrame> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.metadata.id3.ChapterFrame createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.metadata.id3.ChapterFrame(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.metadata.id3.ChapterFrame[] newArray(int i) {
            return new com.google.android.exoplayer2.metadata.id3.ChapterFrame[i];
        }
    }

    public ChapterFrame(android.os.Parcel parcel) {
        super("CHAP");
        this.chapterId = (java.lang.String) com.google.android.exoplayer2.util.Util.castNonNull(parcel.readString());
        this.startTimeMs = parcel.readInt();
        this.endTimeMs = parcel.readInt();
        this.startOffset = parcel.readLong();
        this.endOffset = parcel.readLong();
        int readInt = parcel.readInt();
        this.subFrames = new com.google.android.exoplayer2.metadata.id3.Id3Frame[readInt];
        for (int i = 0; i < readInt; i++) {
            this.subFrames[i] = (com.google.android.exoplayer2.metadata.id3.Id3Frame) parcel.readParcelable(com.google.android.exoplayer2.metadata.id3.Id3Frame.class.getClassLoader());
        }
    }

    public ChapterFrame(java.lang.String str, int i, int i2, long j, long j2, com.google.android.exoplayer2.metadata.id3.Id3Frame[] id3FrameArr) {
        super("CHAP");
        this.chapterId = str;
        this.startTimeMs = i;
        this.endTimeMs = i2;
        this.startOffset = j;
        this.endOffset = j2;
        this.subFrames = id3FrameArr;
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@androidx.annotation.Nullable java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || com.google.android.exoplayer2.metadata.id3.ChapterFrame.class != obj.getClass()) {
            return false;
        }
        com.google.android.exoplayer2.metadata.id3.ChapterFrame chapterFrame = (com.google.android.exoplayer2.metadata.id3.ChapterFrame) obj;
        return this.startTimeMs == chapterFrame.startTimeMs && this.endTimeMs == chapterFrame.endTimeMs && this.startOffset == chapterFrame.startOffset && this.endOffset == chapterFrame.endOffset && com.google.android.exoplayer2.util.Util.areEqual(this.chapterId, chapterFrame.chapterId) && java.util.Arrays.equals(this.subFrames, chapterFrame.subFrames);
    }

    public com.google.android.exoplayer2.metadata.id3.Id3Frame getSubFrame(int i) {
        return this.subFrames[i];
    }

    public int getSubFrameCount() {
        return this.subFrames.length;
    }

    public int hashCode() {
        int i = (((((((527 + this.startTimeMs) * 31) + this.endTimeMs) * 31) + ((int) this.startOffset)) * 31) + ((int) this.endOffset)) * 31;
        java.lang.String str = this.chapterId;
        return i + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.chapterId);
        parcel.writeInt(this.startTimeMs);
        parcel.writeInt(this.endTimeMs);
        parcel.writeLong(this.startOffset);
        parcel.writeLong(this.endOffset);
        parcel.writeInt(this.subFrames.length);
        for (com.google.android.exoplayer2.metadata.id3.Id3Frame id3Frame : this.subFrames) {
            parcel.writeParcelable(id3Frame, 0);
        }
    }
}
