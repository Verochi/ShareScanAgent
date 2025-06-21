package com.google.android.exoplayer2.metadata.scte35;

/* loaded from: classes22.dex */
public final class PrivateCommand extends com.google.android.exoplayer2.metadata.scte35.SpliceCommand {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.scte35.PrivateCommand> CREATOR = new com.google.android.exoplayer2.metadata.scte35.PrivateCommand.AnonymousClass1();
    public final byte[] commandBytes;
    public final long identifier;
    public final long ptsAdjustment;

    /* renamed from: com.google.android.exoplayer2.metadata.scte35.PrivateCommand$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.scte35.PrivateCommand> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.metadata.scte35.PrivateCommand createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.metadata.scte35.PrivateCommand(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.metadata.scte35.PrivateCommand[] newArray(int i) {
            return new com.google.android.exoplayer2.metadata.scte35.PrivateCommand[i];
        }
    }

    private PrivateCommand(long j, byte[] bArr, long j2) {
        this.ptsAdjustment = j2;
        this.identifier = j;
        this.commandBytes = bArr;
    }

    private PrivateCommand(android.os.Parcel parcel) {
        this.ptsAdjustment = parcel.readLong();
        this.identifier = parcel.readLong();
        this.commandBytes = (byte[]) com.google.android.exoplayer2.util.Util.castNonNull(parcel.createByteArray());
    }

    public /* synthetic */ PrivateCommand(android.os.Parcel parcel, com.google.android.exoplayer2.metadata.scte35.PrivateCommand.AnonymousClass1 anonymousClass1) {
        this(parcel);
    }

    public static com.google.android.exoplayer2.metadata.scte35.PrivateCommand parseFromSection(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, int i, long j) {
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        int i2 = i - 4;
        byte[] bArr = new byte[i2];
        parsableByteArray.readBytes(bArr, 0, i2);
        return new com.google.android.exoplayer2.metadata.scte35.PrivateCommand(readUnsignedInt, bArr, j);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeLong(this.ptsAdjustment);
        parcel.writeLong(this.identifier);
        parcel.writeByteArray(this.commandBytes);
    }
}
