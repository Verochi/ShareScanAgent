package com.google.android.exoplayer2.video.spherical;

/* loaded from: classes22.dex */
public final class ProjectionDecoder {
    public static int a(int i) {
        return (-(i & 1)) ^ (i >> 1);
    }

    public static boolean b(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        parsableByteArray.skipBytes(4);
        int readInt = parsableByteArray.readInt();
        parsableByteArray.setPosition(0);
        return readInt == 1886547818;
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.video.spherical.Projection.Mesh c(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int readInt = parsableByteArray.readInt();
        if (readInt > 10000) {
            return null;
        }
        float[] fArr = new float[readInt];
        for (int i = 0; i < readInt; i++) {
            fArr[i] = parsableByteArray.readFloat();
        }
        int readInt2 = parsableByteArray.readInt();
        if (readInt2 > 32000) {
            return null;
        }
        double d = 2.0d;
        double log = java.lang.Math.log(2.0d);
        int ceil = (int) java.lang.Math.ceil(java.lang.Math.log(readInt * 2.0d) / log);
        com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray = new com.google.android.exoplayer2.util.ParsableBitArray(parsableByteArray.getData());
        int i2 = 8;
        parsableBitArray.setPosition(parsableByteArray.getPosition() * 8);
        float[] fArr2 = new float[readInt2 * 5];
        int i3 = 5;
        int[] iArr = new int[5];
        int i4 = 0;
        int i5 = 0;
        while (i4 < readInt2) {
            int i6 = 0;
            while (i6 < i3) {
                int a = iArr[i6] + a(parsableBitArray.readBits(ceil));
                if (a >= readInt || a < 0) {
                    return null;
                }
                fArr2[i5] = fArr[a];
                iArr[i6] = a;
                i6++;
                i5++;
                i3 = 5;
            }
            i4++;
            i3 = 5;
        }
        parsableBitArray.setPosition((parsableBitArray.getPosition() + 7) & (-8));
        int i7 = 32;
        int readBits = parsableBitArray.readBits(32);
        com.google.android.exoplayer2.video.spherical.Projection.SubMesh[] subMeshArr = new com.google.android.exoplayer2.video.spherical.Projection.SubMesh[readBits];
        int i8 = 0;
        while (i8 < readBits) {
            int readBits2 = parsableBitArray.readBits(i2);
            int readBits3 = parsableBitArray.readBits(i2);
            int readBits4 = parsableBitArray.readBits(i7);
            if (readBits4 > 128000) {
                return null;
            }
            int ceil2 = (int) java.lang.Math.ceil(java.lang.Math.log(readInt2 * d) / log);
            float[] fArr3 = new float[readBits4 * 3];
            float[] fArr4 = new float[readBits4 * 2];
            int i9 = 0;
            for (int i10 = 0; i10 < readBits4; i10++) {
                i9 += a(parsableBitArray.readBits(ceil2));
                if (i9 < 0 || i9 >= readInt2) {
                    return null;
                }
                int i11 = i10 * 3;
                int i12 = i9 * 5;
                fArr3[i11] = fArr2[i12];
                fArr3[i11 + 1] = fArr2[i12 + 1];
                fArr3[i11 + 2] = fArr2[i12 + 2];
                int i13 = i10 * 2;
                fArr4[i13] = fArr2[i12 + 3];
                fArr4[i13 + 1] = fArr2[i12 + 4];
            }
            subMeshArr[i8] = new com.google.android.exoplayer2.video.spherical.Projection.SubMesh(readBits2, fArr3, fArr4, readBits3);
            i8++;
            i7 = 32;
            d = 2.0d;
            i2 = 8;
        }
        return new com.google.android.exoplayer2.video.spherical.Projection.Mesh(subMeshArr);
    }

    @androidx.annotation.Nullable
    public static java.util.ArrayList<com.google.android.exoplayer2.video.spherical.Projection.Mesh> d(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        if (parsableByteArray.readUnsignedByte() != 0) {
            return null;
        }
        parsableByteArray.skipBytes(7);
        int readInt = parsableByteArray.readInt();
        if (readInt == 1684433976) {
            com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray2 = new com.google.android.exoplayer2.util.ParsableByteArray();
            java.util.zip.Inflater inflater = new java.util.zip.Inflater(true);
            try {
                if (!com.google.android.exoplayer2.util.Util.inflate(parsableByteArray, parsableByteArray2, inflater)) {
                    return null;
                }
                inflater.end();
                parsableByteArray = parsableByteArray2;
            } finally {
                inflater.end();
            }
        } else if (readInt != 1918990112) {
            return null;
        }
        return f(parsableByteArray);
    }

    @androidx.annotation.Nullable
    public static com.google.android.exoplayer2.video.spherical.Projection decode(byte[] bArr, int i) {
        java.util.ArrayList<com.google.android.exoplayer2.video.spherical.Projection.Mesh> arrayList;
        com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray = new com.google.android.exoplayer2.util.ParsableByteArray(bArr);
        try {
            arrayList = b(parsableByteArray) ? e(parsableByteArray) : d(parsableByteArray);
        } catch (java.lang.ArrayIndexOutOfBoundsException unused) {
            arrayList = null;
        }
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        if (size == 1) {
            return new com.google.android.exoplayer2.video.spherical.Projection(arrayList.get(0), i);
        }
        if (size != 2) {
            return null;
        }
        return new com.google.android.exoplayer2.video.spherical.Projection(arrayList.get(0), arrayList.get(1), i);
    }

    @androidx.annotation.Nullable
    public static java.util.ArrayList<com.google.android.exoplayer2.video.spherical.Projection.Mesh> e(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        int readInt;
        parsableByteArray.skipBytes(8);
        int position = parsableByteArray.getPosition();
        int limit = parsableByteArray.limit();
        while (position < limit && (readInt = parsableByteArray.readInt() + position) > position && readInt <= limit) {
            int readInt2 = parsableByteArray.readInt();
            if (readInt2 == 2037673328 || readInt2 == 1836279920) {
                parsableByteArray.setLimit(readInt);
                return d(parsableByteArray);
            }
            parsableByteArray.setPosition(readInt);
            position = readInt;
        }
        return null;
    }

    @androidx.annotation.Nullable
    public static java.util.ArrayList<com.google.android.exoplayer2.video.spherical.Projection.Mesh> f(com.google.android.exoplayer2.util.ParsableByteArray parsableByteArray) {
        java.util.ArrayList<com.google.android.exoplayer2.video.spherical.Projection.Mesh> arrayList = new java.util.ArrayList<>();
        int position = parsableByteArray.getPosition();
        int limit = parsableByteArray.limit();
        while (position < limit) {
            int readInt = parsableByteArray.readInt() + position;
            if (readInt <= position || readInt > limit) {
                return null;
            }
            if (parsableByteArray.readInt() == 1835365224) {
                com.google.android.exoplayer2.video.spherical.Projection.Mesh c = c(parsableByteArray);
                if (c == null) {
                    return null;
                }
                arrayList.add(c);
            }
            parsableByteArray.setPosition(readInt);
            position = readInt;
        }
        return arrayList;
    }
}
