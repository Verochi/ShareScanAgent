package com.google.android.exoplayer2.metadata.scte35;

/* loaded from: classes22.dex */
public final class SpliceNullCommand extends com.google.android.exoplayer2.metadata.scte35.SpliceCommand {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.scte35.SpliceNullCommand> CREATOR = new com.google.android.exoplayer2.metadata.scte35.SpliceNullCommand.AnonymousClass1();

    /* renamed from: com.google.android.exoplayer2.metadata.scte35.SpliceNullCommand$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.scte35.SpliceNullCommand> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.metadata.scte35.SpliceNullCommand createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.metadata.scte35.SpliceNullCommand();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.metadata.scte35.SpliceNullCommand[] newArray(int i) {
            return new com.google.android.exoplayer2.metadata.scte35.SpliceNullCommand[i];
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
    }
}
