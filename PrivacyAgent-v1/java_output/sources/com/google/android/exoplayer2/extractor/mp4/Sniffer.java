package com.google.android.exoplayer2.extractor.mp4;

/* loaded from: classes22.dex */
final class Sniffer {
    public static final int[] a = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    public static boolean a(int i) {
        if ((i >>> 8) == 3368816) {
            return true;
        }
        for (int i2 : a) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        return c(extractorInput, true);
    }

    public static boolean c(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput, boolean z) throws java.io.IOException {
        boolean z2;
        boolean z3;
        int i;
        long length = extractorInput.getLength();
        long j = 4096;
        long j2 = -1;
        int i2 = (length > (-1L) ? 1 : (length == (-1L) ? 0 : -1));
        if (i2 != 0 && length <= 4096) {
            j = length;
        }
        int i3 = (int) j;
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(64);
        boolean z4 = false;
        int i4 = 0;
        boolean z5 = false;
        while (i4 < i3) {
            parsableByteArray.reset(8);
            if (!extractorInput.peekFully(parsableByteArray.getData(), z4 ? 1 : 0, 8, true)) {
                break;
            }
            long readUnsignedInt = parsableByteArray.readUnsignedInt();
            int readInt = parsableByteArray.readInt();
            if (readUnsignedInt == 1) {
                extractorInput.peekFully(parsableByteArray.getData(), 8, 8);
                parsableByteArray.setLimit(16);
                readUnsignedInt = parsableByteArray.readLong();
                i = 16;
            } else {
                if (readUnsignedInt == 0) {
                    long length2 = extractorInput.getLength();
                    if (length2 != j2) {
                        readUnsignedInt = (length2 - extractorInput.getPeekPosition()) + 8;
                    }
                }
                i = 8;
            }
            long j3 = i;
            if (readUnsignedInt < j3) {
                return z4;
            }
            i4 += i;
            if (readInt == 1836019574) {
                i3 += (int) readUnsignedInt;
                if (i2 != 0 && i3 > length) {
                    i3 = (int) length;
                }
                j2 = -1;
            } else {
                if (readInt == 1836019558 || readInt == 1836475768) {
                    z2 = true;
                    z3 = true;
                    break;
                }
                int i5 = i2;
                if ((i4 + readUnsignedInt) - j3 >= i3) {
                    break;
                }
                int i6 = (int) (readUnsignedInt - j3);
                i4 += i6;
                if (readInt == 1718909296) {
                    if (i6 < 8) {
                        return false;
                    }
                    parsableByteArray.reset(i6);
                    extractorInput.peekFully(parsableByteArray.getData(), 0, i6);
                    int i7 = i6 / 4;
                    int i8 = 0;
                    while (true) {
                        if (i8 >= i7) {
                            break;
                        }
                        if (i8 == 1) {
                            parsableByteArray.skipBytes(4);
                        } else if (a(parsableByteArray.readInt())) {
                            z5 = true;
                            break;
                        }
                        i8++;
                    }
                    if (!z5) {
                        return false;
                    }
                } else if (i6 != 0) {
                    extractorInput.advancePeekPosition(i6);
                }
                i2 = i5;
                j2 = -1;
                z4 = false;
            }
        }
        z2 = true;
        z3 = false;
        if (z5 && z == z3) {
            return z2;
        }
        return false;
    }

    public static boolean d(com.google.android.exoplayer2.extractor.ExtractorInput extractorInput) throws java.io.IOException {
        return c(extractorInput, false);
    }
}
