package com.google.android.exoplayer2.extractor.mp3;

/* loaded from: classes22.dex */
final class VbriSeeker implements com.google.android.exoplayer2.extractor.mp3.Seeker {
    public final long[] a;
    public final long[] b;
    public final long c;
    public final long d;

    public VbriSeeker(long[] jArr, long[] jArr2, long j, long j2) {
        this.a = jArr;
        this.b = jArr2;
        this.c = j;
        this.d = j2;
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.extractor.mp3.VbriSeeker a(long j, long j2, com.google.android.exoplayer2.audio.MpegAudioUtil.Header header, com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int readUnsignedByte;
        parsableByteArray.skipBytes(10);
        int readInt = parsableByteArray.readInt();
        if (readInt <= 0) {
            return null;
        }
        int i = header.sampleRate;
        long scaleLargeTimestamp = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(readInt, (i >= 32000 ? 1152 : 576) * 1000000, i);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
        int readUnsignedShort3 = parsableByteArray.readUnsignedShort();
        parsableByteArray.skipBytes(2);
        long j3 = j2 + header.frameSize;
        long[] jArr = new long[readUnsignedShort];
        long[] jArr2 = new long[readUnsignedShort];
        int i2 = 0;
        long j4 = j2;
        while (i2 < readUnsignedShort) {
            int i3 = readUnsignedShort2;
            long j5 = j3;
            jArr[i2] = (i2 * scaleLargeTimestamp) / readUnsignedShort;
            jArr2[i2] = java.lang.Math.max(j4, j5);
            if (readUnsignedShort3 == 1) {
                readUnsignedByte = parsableByteArray.readUnsignedByte();
            } else if (readUnsignedShort3 == 2) {
                readUnsignedByte = parsableByteArray.readUnsignedShort();
            } else if (readUnsignedShort3 == 3) {
                readUnsignedByte = parsableByteArray.readUnsignedInt24();
            } else {
                if (readUnsignedShort3 != 4) {
                    return null;
                }
                readUnsignedByte = parsableByteArray.readUnsignedIntToInt();
            }
            j4 += readUnsignedByte * i3;
            i2++;
            j3 = j5;
            readUnsignedShort2 = i3;
        }
        if (j != -1 && j != j4) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(67);
            sb.append("VBRI data size mismatch: ");
            sb.append(j);
            sb.append(", ");
            sb.append(j4);
            com.google.android.exoplayer2.util.Log.w("VbriSeeker", sb.toString());
        }
        return new com.google.android.exoplayer2.extractor.mp3.VbriSeeker(jArr, jArr2, scaleLargeTimestamp, j4);
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Seeker
    public long getDataEndPosition() {
        return this.d;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.c;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public com.google.android.exoplayer2.extractor.SeekMap.SeekPoints getSeekPoints(long j) {
        int binarySearchFloor = com.google.android.exoplayer2.util.Util.binarySearchFloor(this.a, j, true, true);
        com.google.android.exoplayer2.extractor.SeekPoint seekPoint = new com.google.android.exoplayer2.extractor.SeekPoint(this.a[binarySearchFloor], this.b[binarySearchFloor]);
        if (seekPoint.timeUs >= j || binarySearchFloor == this.a.length - 1) {
            return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(seekPoint);
        }
        int i = binarySearchFloor + 1;
        return new com.google.android.exoplayer2.extractor.SeekMap.SeekPoints(seekPoint, new com.google.android.exoplayer2.extractor.SeekPoint(this.a[i], this.b[i]));
    }

    @Override // com.google.android.exoplayer2.extractor.mp3.Seeker
    public long getTimeUs(long j) {
        return this.a[com.google.android.exoplayer2.util.Util.binarySearchFloor(this.b, j, true, true)];
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }
}
