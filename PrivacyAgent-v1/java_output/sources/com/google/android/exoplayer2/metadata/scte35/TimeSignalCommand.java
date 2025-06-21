package com.google.android.exoplayer2.metadata.scte35;

/* loaded from: classes22.dex */
public final class TimeSignalCommand extends com.google.android.exoplayer2.metadata.scte35.SpliceCommand {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand> CREATOR = new com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand.AnonymousClass1();
    public final long playbackPositionUs;
    public final long ptsTime;

    /* renamed from: com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand(parcel.readLong(), parcel.readLong(), null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand[] newArray(int i) {
            return new com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand[i];
        }
    }

    private TimeSignalCommand(long j, long j2) {
        this.ptsTime = j;
        this.playbackPositionUs = j2;
    }

    public /* synthetic */ TimeSignalCommand(long j, long j2, com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand.AnonymousClass1 anonymousClass1) {
        this(j, j2);
    }

    public static com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand parseFromSection(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, long j, com.google.android.exoplayer2.util.TimestampAdjuster timestampAdjuster) {
        long parseSpliceTime = parseSpliceTime(parsableByteArray, j);
        return new com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand(parseSpliceTime, timestampAdjuster.adjustTsTimestamp(parseSpliceTime));
    }

    public static long parseSpliceTime(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, long j) {
        long readUnsignedByte = parsableByteArray.readUnsignedByte();
        if ((128 & readUnsignedByte) != 0) {
            return org.apache.tools.tar.TarConstants.MAXSIZE & ((((readUnsignedByte & 1) << 32) | parsableByteArray.readUnsignedInt()) + j);
        }
        return -9223372036854775807L;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeLong(this.ptsTime);
        parcel.writeLong(this.playbackPositionUs);
    }
}
