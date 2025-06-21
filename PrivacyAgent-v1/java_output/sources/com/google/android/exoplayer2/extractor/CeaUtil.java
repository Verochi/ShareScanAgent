package com.google.android.exoplayer2.extractor;

/* loaded from: classes22.dex */
public final class CeaUtil {
    public static final int USER_DATA_IDENTIFIER_GA94 = 1195456820;
    public static final int USER_DATA_TYPE_CODE_MPEG_CC = 3;

    public static int a(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int i = 0;
        while (parsableByteArray.bytesLeft() != 0) {
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            i += readUnsignedByte;
            if (readUnsignedByte != 255) {
                return i;
            }
        }
        return -1;
    }

    public static void consume(long j, com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, com.google.android.exoplayer2.extractor.TrackOutput[] trackOutputArr) {
        while (true) {
            if (parsableByteArray.bytesLeft() <= 1) {
                return;
            }
            int a = a(parsableByteArray);
            int a2 = a(parsableByteArray);
            int position = parsableByteArray.getPosition() + a2;
            if (a2 == -1 || a2 > parsableByteArray.bytesLeft()) {
                com.google.android.exoplayer2.util.Log.w("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                position = parsableByteArray.limit();
            } else if (a == 4 && a2 >= 8) {
                int readUnsignedByte = parsableByteArray.readUnsignedByte();
                int readUnsignedShort = parsableByteArray.readUnsignedShort();
                int readInt = readUnsignedShort == 49 ? parsableByteArray.readInt() : 0;
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                if (readUnsignedShort == 47) {
                    parsableByteArray.skipBytes(1);
                }
                boolean z = readUnsignedByte == 181 && (readUnsignedShort == 49 || readUnsignedShort == 47) && readUnsignedByte2 == 3;
                if (readUnsignedShort == 49) {
                    z &= readInt == 1195456820;
                }
                if (z) {
                    consumeCcData(j, parsableByteArray, trackOutputArr);
                }
            }
            parsableByteArray.setPosition(position);
        }
    }

    public static void consumeCcData(long j, com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray, com.google.android.exoplayer2.extractor.TrackOutput[] trackOutputArr) {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        if ((readUnsignedByte & 64) != 0) {
            parsableByteArray.skipBytes(1);
            int i = (readUnsignedByte & 31) * 3;
            int position = parsableByteArray.getPosition();
            for (com.google.android.exoplayer2.extractor.TrackOutput trackOutput : trackOutputArr) {
                parsableByteArray.setPosition(position);
                trackOutput.sampleData(parsableByteArray, i);
                trackOutput.sampleMetadata(j, 1, i, 0, null);
            }
        }
    }
}
