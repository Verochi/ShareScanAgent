package com.google.android.exoplayer2.metadata.scte35;

/* loaded from: classes22.dex */
public final class SpliceScheduleCommand extends com.google.android.exoplayer2.metadata.scte35.SpliceCommand {
    public static final android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand> CREATOR = new com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.AnonymousClass1();
    public final java.util.List<com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.Event> events;

    /* renamed from: com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand$1, reason: invalid class name */
    public class AnonymousClass1 implements android.os.Parcelable.Creator<com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand createFromParcel(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand[] newArray(int i) {
            return new com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand[i];
        }
    }

    public static final class ComponentSplice {
        public final int componentTag;
        public final long utcSpliceTime;

        public ComponentSplice(int i, long j) {
            this.componentTag = i;
            this.utcSpliceTime = j;
        }

        public /* synthetic */ ComponentSplice(int i, long j, com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.AnonymousClass1 anonymousClass1) {
            this(i, j);
        }

        public static com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.ComponentSplice c(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.ComponentSplice(parcel.readInt(), parcel.readLong());
        }

        public final void d(android.os.Parcel parcel) {
            parcel.writeInt(this.componentTag);
            parcel.writeLong(this.utcSpliceTime);
        }
    }

    public static final class Event {
        public final boolean autoReturn;
        public final int availNum;
        public final int availsExpected;
        public final long breakDurationUs;
        public final java.util.List<com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.ComponentSplice> componentSpliceList;
        public final boolean outOfNetworkIndicator;
        public final boolean programSpliceFlag;
        public final boolean spliceEventCancelIndicator;
        public final long spliceEventId;
        public final int uniqueProgramId;
        public final long utcSpliceTime;

        public Event(long j, boolean z, boolean z2, boolean z3, java.util.List<com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.ComponentSplice> list, long j2, boolean z4, long j3, int i, int i2, int i3) {
            this.spliceEventId = j;
            this.spliceEventCancelIndicator = z;
            this.outOfNetworkIndicator = z2;
            this.programSpliceFlag = z3;
            this.componentSpliceList = java.util.Collections.unmodifiableList(list);
            this.utcSpliceTime = j2;
            this.autoReturn = z4;
            this.breakDurationUs = j3;
            this.uniqueProgramId = i;
            this.availNum = i2;
            this.availsExpected = i3;
        }

        public Event(android.os.Parcel parcel) {
            this.spliceEventId = parcel.readLong();
            this.spliceEventCancelIndicator = parcel.readByte() == 1;
            this.outOfNetworkIndicator = parcel.readByte() == 1;
            this.programSpliceFlag = parcel.readByte() == 1;
            int readInt = parcel.readInt();
            java.util.ArrayList arrayList = new java.util.ArrayList(readInt);
            for (int i = 0; i < readInt; i++) {
                arrayList.add(com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.ComponentSplice.c(parcel));
            }
            this.componentSpliceList = java.util.Collections.unmodifiableList(arrayList);
            this.utcSpliceTime = parcel.readLong();
            this.autoReturn = parcel.readByte() == 1;
            this.breakDurationUs = parcel.readLong();
            this.uniqueProgramId = parcel.readInt();
            this.availNum = parcel.readInt();
            this.availsExpected = parcel.readInt();
        }

        public static com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.Event d(android.os.Parcel parcel) {
            return new com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.Event(parcel);
        }

        public static com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.Event e(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
            java.util.ArrayList arrayList;
            boolean z;
            long j;
            boolean z2;
            long j2;
            int i;
            int i2;
            int i3;
            boolean z3;
            boolean z4;
            long j3;
            long readUnsignedInt = parsableByteArray.readUnsignedInt();
            boolean z5 = (parsableByteArray.readUnsignedByte() & 128) != 0;
            java.util.ArrayList arrayList2 = new java.util.ArrayList();
            if (z5) {
                arrayList = arrayList2;
                z = false;
                j = -9223372036854775807L;
                z2 = false;
                j2 = -9223372036854775807L;
                i = 0;
                i2 = 0;
                i3 = 0;
                z3 = false;
            } else {
                int readUnsignedByte = parsableByteArray.readUnsignedByte();
                boolean z6 = (readUnsignedByte & 128) != 0;
                boolean z7 = (readUnsignedByte & 64) != 0;
                boolean z8 = (readUnsignedByte & 32) != 0;
                long readUnsignedInt2 = z7 ? parsableByteArray.readUnsignedInt() : -9223372036854775807L;
                if (!z7) {
                    int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                    java.util.ArrayList arrayList3 = new java.util.ArrayList(readUnsignedByte2);
                    for (int i4 = 0; i4 < readUnsignedByte2; i4++) {
                        arrayList3.add(new com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.ComponentSplice(parsableByteArray.readUnsignedByte(), parsableByteArray.readUnsignedInt(), null));
                    }
                    arrayList2 = arrayList3;
                }
                if (z8) {
                    long readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                    boolean z9 = (128 & readUnsignedByte3) != 0;
                    j3 = ((((readUnsignedByte3 & 1) << 32) | parsableByteArray.readUnsignedInt()) * 1000) / 90;
                    z4 = z9;
                } else {
                    z4 = false;
                    j3 = -9223372036854775807L;
                }
                int readUnsignedShort = parsableByteArray.readUnsignedShort();
                int readUnsignedByte4 = parsableByteArray.readUnsignedByte();
                z3 = z7;
                i3 = parsableByteArray.readUnsignedByte();
                j2 = j3;
                arrayList = arrayList2;
                long j4 = readUnsignedInt2;
                i = readUnsignedShort;
                i2 = readUnsignedByte4;
                j = j4;
                boolean z10 = z6;
                z2 = z4;
                z = z10;
            }
            return new com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.Event(readUnsignedInt, z5, z, z3, arrayList, j, z2, j2, i, i2, i3);
        }

        public final void f(android.os.Parcel parcel) {
            parcel.writeLong(this.spliceEventId);
            parcel.writeByte(this.spliceEventCancelIndicator ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.outOfNetworkIndicator ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.programSpliceFlag ? (byte) 1 : (byte) 0);
            int size = this.componentSpliceList.size();
            parcel.writeInt(size);
            for (int i = 0; i < size; i++) {
                this.componentSpliceList.get(i).d(parcel);
            }
            parcel.writeLong(this.utcSpliceTime);
            parcel.writeByte(this.autoReturn ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.breakDurationUs);
            parcel.writeInt(this.uniqueProgramId);
            parcel.writeInt(this.availNum);
            parcel.writeInt(this.availsExpected);
        }
    }

    private SpliceScheduleCommand(android.os.Parcel parcel) {
        int readInt = parcel.readInt();
        java.util.ArrayList arrayList = new java.util.ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add(com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.Event.d(parcel));
        }
        this.events = java.util.Collections.unmodifiableList(arrayList);
    }

    public /* synthetic */ SpliceScheduleCommand(android.os.Parcel parcel, com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.AnonymousClass1 anonymousClass1) {
        this(parcel);
    }

    private SpliceScheduleCommand(java.util.List<com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.Event> list) {
        this.events = java.util.Collections.unmodifiableList(list);
    }

    public static com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand parseFromSection(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        java.util.ArrayList arrayList = new java.util.ArrayList(readUnsignedByte);
        for (int i = 0; i < readUnsignedByte; i++) {
            arrayList.add(com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand.Event.e(parsableByteArray));
        }
        return new com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand(arrayList);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(android.os.Parcel parcel, int i) {
        int size = this.events.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.events.get(i2).f(parcel);
        }
    }
}
