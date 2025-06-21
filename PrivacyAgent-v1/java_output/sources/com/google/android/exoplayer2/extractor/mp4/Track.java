package com.google.android.exoplayer2.extractor.mp4;

/* loaded from: classes22.dex */
public final class Track {
    public static final int TRANSFORMATION_CEA608_CDAT = 1;
    public static final int TRANSFORMATION_NONE = 0;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox[] a;
    public final long durationUs;

    @androidx.annotation.Nullable
    public final long[] editListDurations;

    @androidx.annotation.Nullable
    public final long[] editListMediaTimes;
    public final com.google.android.exoplayer2.Format format;
    public final int id;
    public final long movieTimescale;
    public final int nalUnitLengthFieldLength;
    public final int sampleTransformation;
    public final long timescale;
    public final int type;

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Transformation {
    }

    public Track(int i, int i2, long j, long j2, long j3, com.google.android.exoplayer2.Format format, int i3, @androidx.annotation.Nullable com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox[] trackEncryptionBoxArr, int i4, @androidx.annotation.Nullable long[] jArr, @androidx.annotation.Nullable long[] jArr2) {
        this.id = i;
        this.type = i2;
        this.timescale = j;
        this.movieTimescale = j2;
        this.durationUs = j3;
        this.format = format;
        this.sampleTransformation = i3;
        this.a = trackEncryptionBoxArr;
        this.nalUnitLengthFieldLength = i4;
        this.editListDurations = jArr;
        this.editListMediaTimes = jArr2;
    }

    public com.google.android.exoplayer2.extractor.mp4.Track copyWithFormat(com.google.android.exoplayer2.Format format) {
        return new com.google.android.exoplayer2.extractor.mp4.Track(this.id, this.type, this.timescale, this.movieTimescale, this.durationUs, format, this.sampleTransformation, this.a, this.nalUnitLengthFieldLength, this.editListDurations, this.editListMediaTimes);
    }

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox getSampleDescriptionEncryptionBox(int i) {
        com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox[] trackEncryptionBoxArr = this.a;
        if (trackEncryptionBoxArr == null) {
            return null;
        }
        return trackEncryptionBoxArr[i];
    }
}
