package com.jd.ad.sdk.jad_te;

/* loaded from: classes23.dex */
public final class jad_hu implements com.jd.ad.sdk.jad_ju.jad_fs {
    public static final byte[] jad_an = "Exif\u0000\u0000".getBytes(java.nio.charset.Charset.forName("UTF-8"));
    public static final int[] jad_bo = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    public static final class jad_an implements com.jd.ad.sdk.jad_te.jad_hu.jad_cp {
        public final java.nio.ByteBuffer jad_an;

        public jad_an(java.nio.ByteBuffer byteBuffer) {
            this.jad_an = byteBuffer;
            byteBuffer.order(java.nio.ByteOrder.BIG_ENDIAN);
        }

        @Override // com.jd.ad.sdk.jad_te.jad_hu.jad_cp
        public int jad_an(byte[] bArr, int i) {
            int min = java.lang.Math.min(i, this.jad_an.remaining());
            if (min == 0) {
                return -1;
            }
            this.jad_an.get(bArr, 0, min);
            return min;
        }

        @Override // com.jd.ad.sdk.jad_te.jad_hu.jad_cp
        public long jad_an(long j) {
            int min = (int) java.lang.Math.min(this.jad_an.remaining(), j);
            java.nio.ByteBuffer byteBuffer = this.jad_an;
            byteBuffer.position(byteBuffer.position() + min);
            return min;
        }

        @Override // com.jd.ad.sdk.jad_te.jad_hu.jad_cp
        public short jad_an() {
            if (this.jad_an.remaining() >= 1) {
                return (short) (this.jad_an.get() & 255);
            }
            throw new com.jd.ad.sdk.jad_te.jad_hu.jad_cp.jad_an();
        }

        @Override // com.jd.ad.sdk.jad_te.jad_hu.jad_cp
        public int jad_bo() {
            return (jad_an() << 8) | jad_an();
        }
    }

    public static final class jad_bo {
        public final java.nio.ByteBuffer jad_an;

        public jad_bo(byte[] bArr, int i) {
            this.jad_an = (java.nio.ByteBuffer) java.nio.ByteBuffer.wrap(bArr).order(java.nio.ByteOrder.BIG_ENDIAN).limit(i);
        }

        public short jad_an(int i) {
            if (this.jad_an.remaining() - i >= 2) {
                return this.jad_an.getShort(i);
            }
            return (short) -1;
        }

        public int jad_bo(int i) {
            if (this.jad_an.remaining() - i >= 4) {
                return this.jad_an.getInt(i);
            }
            return -1;
        }
    }

    public interface jad_cp {

        public static final class jad_an extends java.io.IOException {
            public jad_an() {
                super("Unexpectedly reached end of a file");
            }
        }

        int jad_an(byte[] bArr, int i);

        long jad_an(long j);

        short jad_an();

        int jad_bo();
    }

    public static final class jad_dq implements com.jd.ad.sdk.jad_te.jad_hu.jad_cp {
        public final java.io.InputStream jad_an;

        public jad_dq(java.io.InputStream inputStream) {
            this.jad_an = inputStream;
        }

        @Override // com.jd.ad.sdk.jad_te.jad_hu.jad_cp
        public int jad_an(byte[] bArr, int i) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < i && (i3 = this.jad_an.read(bArr, i2, i - i2)) != -1) {
                i2 += i3;
            }
            if (i2 == 0 && i3 == -1) {
                throw new com.jd.ad.sdk.jad_te.jad_hu.jad_cp.jad_an();
            }
            return i2;
        }

        @Override // com.jd.ad.sdk.jad_te.jad_hu.jad_cp
        public long jad_an(long j) {
            if (j < 0) {
                return 0L;
            }
            long j2 = j;
            while (j2 > 0) {
                long skip = this.jad_an.skip(j2);
                if (skip <= 0) {
                    if (this.jad_an.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j2 -= skip;
            }
            return j - j2;
        }

        @Override // com.jd.ad.sdk.jad_te.jad_hu.jad_cp
        public short jad_an() {
            int read = this.jad_an.read();
            if (read != -1) {
                return (short) read;
            }
            throw new com.jd.ad.sdk.jad_te.jad_hu.jad_cp.jad_an();
        }

        @Override // com.jd.ad.sdk.jad_te.jad_hu.jad_cp
        public int jad_bo() {
            return (jad_an() << 8) | jad_an();
        }
    }

    public final int jad_an(com.jd.ad.sdk.jad_te.jad_hu.jad_cp jad_cpVar, com.jd.ad.sdk.jad_ny.jad_bo jad_boVar) {
        try {
            int jad_bo2 = jad_cpVar.jad_bo();
            if (!((jad_bo2 & 65496) == 65496 || jad_bo2 == 19789 || jad_bo2 == 18761)) {
                if (android.util.Log.isLoggable("DfltImageHeaderParser", 3)) {
                    com.jd.ad.sdk.logger.Logger.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + jad_bo2);
                }
                return -1;
            }
            int jad_bo3 = jad_bo(jad_cpVar);
            if (jad_bo3 == -1) {
                if (android.util.Log.isLoggable("DfltImageHeaderParser", 3)) {
                    com.jd.ad.sdk.logger.Logger.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
                }
                return -1;
            }
            byte[] bArr = (byte[]) jad_boVar.jad_an(jad_bo3, byte[].class);
            try {
                return jad_an(jad_cpVar, bArr, jad_bo3);
            } finally {
                jad_boVar.jad_an((com.jd.ad.sdk.jad_ny.jad_bo) bArr);
            }
        } catch (com.jd.ad.sdk.jad_te.jad_hu.jad_cp.jad_an unused) {
            return -1;
        }
    }

    public final int jad_an(com.jd.ad.sdk.jad_te.jad_hu.jad_cp jad_cpVar, byte[] bArr, int i) {
        java.nio.ByteOrder byteOrder;
        int jad_an2 = jad_cpVar.jad_an(bArr, i);
        int i2 = 1;
        if (jad_an2 != i) {
            if (android.util.Log.isLoggable("DfltImageHeaderParser", 3)) {
                com.jd.ad.sdk.logger.Logger.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i + ", actually read: " + jad_an2);
            }
            return -1;
        }
        if (!jad_an(bArr, i)) {
            if (!android.util.Log.isLoggable("DfltImageHeaderParser", 3)) {
                return -1;
            }
            com.jd.ad.sdk.logger.Logger.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
            return -1;
        }
        com.jd.ad.sdk.jad_te.jad_hu.jad_bo jad_boVar = new com.jd.ad.sdk.jad_te.jad_hu.jad_bo(bArr, i);
        short jad_an3 = jad_boVar.jad_an(6);
        if (jad_an3 != 18761) {
            if (jad_an3 != 19789 && android.util.Log.isLoggable("DfltImageHeaderParser", 3)) {
                com.jd.ad.sdk.logger.Logger.d("DfltImageHeaderParser", "Unknown endianness = " + ((int) jad_an3));
            }
            byteOrder = java.nio.ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = java.nio.ByteOrder.LITTLE_ENDIAN;
        }
        jad_boVar.jad_an.order(byteOrder);
        int jad_bo2 = jad_boVar.jad_bo(10) + 6;
        short jad_an4 = jad_boVar.jad_an(jad_bo2);
        int i3 = 0;
        while (i3 < jad_an4) {
            int i4 = (i3 * 12) + jad_bo2 + 2;
            short jad_an5 = jad_boVar.jad_an(i4);
            if (jad_an5 == 274) {
                short jad_an6 = jad_boVar.jad_an(i4 + 2);
                if (jad_an6 >= i2 && jad_an6 <= 12) {
                    int jad_bo3 = jad_boVar.jad_bo(i4 + 4);
                    if (jad_bo3 >= 0) {
                        if (android.util.Log.isLoggable("DfltImageHeaderParser", 3)) {
                            java.lang.Object[] objArr = new java.lang.Object[i2];
                            objArr[0] = "Got tagIndex=" + i3 + " tagType=" + ((int) jad_an5) + " formatCode=" + ((int) jad_an6) + " componentCount=" + jad_bo3;
                            com.jd.ad.sdk.logger.Logger.d("DfltImageHeaderParser", objArr);
                        }
                        int i5 = jad_bo3 + jad_bo[jad_an6];
                        if (i5 <= 4) {
                            int i6 = i4 + 8;
                            if (i6 < 0 || i6 > jad_boVar.jad_an.remaining()) {
                                if (android.util.Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    com.jd.ad.sdk.logger.Logger.d("DfltImageHeaderParser", "Illegal tagValueOffset=" + i6 + " tagType=" + ((int) jad_an5));
                                }
                            } else {
                                if (i5 >= 0 && i5 + i6 <= jad_boVar.jad_an.remaining()) {
                                    return jad_boVar.jad_an(i6);
                                }
                                if (android.util.Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    com.jd.ad.sdk.logger.Logger.d("DfltImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + ((int) jad_an5));
                                }
                            }
                        } else if (android.util.Log.isLoggable("DfltImageHeaderParser", 3)) {
                            com.jd.ad.sdk.logger.Logger.d("DfltImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) jad_an6));
                        }
                    } else if (android.util.Log.isLoggable("DfltImageHeaderParser", 3)) {
                        java.lang.Object[] objArr2 = new java.lang.Object[i2];
                        objArr2[0] = "Negative tiff component count";
                        com.jd.ad.sdk.logger.Logger.d("DfltImageHeaderParser", objArr2);
                    }
                } else if (android.util.Log.isLoggable("DfltImageHeaderParser", 3)) {
                    com.jd.ad.sdk.logger.Logger.d("DfltImageHeaderParser", "Got invalid format code = " + ((int) jad_an6));
                }
            }
            i3++;
            i2 = 1;
        }
        return -1;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_fs
    public int jad_an(@androidx.annotation.NonNull java.io.InputStream inputStream, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ny.jad_bo jad_boVar) {
        if (inputStream == null) {
            throw new java.lang.NullPointerException("Argument must not be null");
        }
        com.jd.ad.sdk.jad_te.jad_hu.jad_dq jad_dqVar = new com.jd.ad.sdk.jad_te.jad_hu.jad_dq(inputStream);
        if (jad_boVar != null) {
            return jad_an(jad_dqVar, jad_boVar);
        }
        throw new java.lang.NullPointerException("Argument must not be null");
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_fs
    public int jad_an(@androidx.annotation.NonNull java.nio.ByteBuffer byteBuffer, @androidx.annotation.NonNull com.jd.ad.sdk.jad_ny.jad_bo jad_boVar) {
        if (byteBuffer == null) {
            throw new java.lang.NullPointerException("Argument must not be null");
        }
        com.jd.ad.sdk.jad_te.jad_hu.jad_an jad_anVar = new com.jd.ad.sdk.jad_te.jad_hu.jad_an(byteBuffer);
        if (jad_boVar != null) {
            return jad_an(jad_anVar, jad_boVar);
        }
        throw new java.lang.NullPointerException("Argument must not be null");
    }

    @androidx.annotation.NonNull
    public final com.jd.ad.sdk.jad_ju.jad_fs.jad_bo jad_an(com.jd.ad.sdk.jad_te.jad_hu.jad_cp jad_cpVar) {
        try {
            int jad_bo2 = jad_cpVar.jad_bo();
            if (jad_bo2 == 65496) {
                return com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.JPEG;
            }
            int jad_an2 = (jad_bo2 << 8) | jad_cpVar.jad_an();
            if (jad_an2 == 4671814) {
                return com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.GIF;
            }
            int jad_an3 = (jad_an2 << 8) | jad_cpVar.jad_an();
            if (jad_an3 == -1991225785) {
                jad_cpVar.jad_an(21L);
                try {
                    return jad_cpVar.jad_an() >= 3 ? com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.PNG_A : com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.PNG;
                } catch (com.jd.ad.sdk.jad_te.jad_hu.jad_cp.jad_an unused) {
                    return com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.PNG;
                }
            }
            if (jad_an3 == 1380533830) {
                jad_cpVar.jad_an(4L);
                if (((jad_cpVar.jad_bo() << 16) | jad_cpVar.jad_bo()) != 1464156752) {
                    return com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.UNKNOWN;
                }
                int jad_bo3 = (jad_cpVar.jad_bo() << 16) | jad_cpVar.jad_bo();
                if ((jad_bo3 & androidx.core.view.InputDeviceCompat.SOURCE_ANY) != 1448097792) {
                    return com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.UNKNOWN;
                }
                int i = jad_bo3 & 255;
                if (i == 88) {
                    jad_cpVar.jad_an(4L);
                    short jad_an4 = jad_cpVar.jad_an();
                    return (jad_an4 & 2) != 0 ? com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.ANIMATED_WEBP : (jad_an4 & 16) != 0 ? com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.WEBP_A : com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.WEBP;
                }
                if (i != 76) {
                    return com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.WEBP;
                }
                jad_cpVar.jad_an(4L);
                return (jad_cpVar.jad_an() & 8) != 0 ? com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.WEBP_A : com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.WEBP;
            }
            boolean z = false;
            if (((jad_cpVar.jad_bo() << 16) | jad_cpVar.jad_bo()) == 1718909296) {
                int jad_bo4 = (jad_cpVar.jad_bo() << 16) | jad_cpVar.jad_bo();
                if (jad_bo4 != 1635150182 && jad_bo4 != 1635150195) {
                    jad_cpVar.jad_an(4L);
                    int i2 = jad_an3 - 16;
                    if (i2 % 4 == 0) {
                        int i3 = 0;
                        while (i3 < 5 && i2 > 0) {
                            int jad_bo5 = (jad_cpVar.jad_bo() << 16) | jad_cpVar.jad_bo();
                            if (jad_bo5 != 1635150182 && jad_bo5 != 1635150195) {
                                i3++;
                                i2 -= 4;
                            }
                        }
                    }
                }
                z = true;
                break;
            }
            return z ? com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.AVIF : com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.UNKNOWN;
        } catch (com.jd.ad.sdk.jad_te.jad_hu.jad_cp.jad_an unused2) {
            return com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.UNKNOWN;
        }
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_fs
    @androidx.annotation.NonNull
    public com.jd.ad.sdk.jad_ju.jad_fs.jad_bo jad_an(@androidx.annotation.NonNull java.io.InputStream inputStream) {
        if (inputStream != null) {
            return jad_an(new com.jd.ad.sdk.jad_te.jad_hu.jad_dq(inputStream));
        }
        throw new java.lang.NullPointerException("Argument must not be null");
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_fs
    @androidx.annotation.NonNull
    public com.jd.ad.sdk.jad_ju.jad_fs.jad_bo jad_an(@androidx.annotation.NonNull java.nio.ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            return jad_an(new com.jd.ad.sdk.jad_te.jad_hu.jad_an(byteBuffer));
        }
        throw new java.lang.NullPointerException("Argument must not be null");
    }

    public final boolean jad_an(byte[] bArr, int i) {
        boolean z = bArr != null && i > jad_an.length;
        if (z) {
            int i2 = 0;
            while (true) {
                byte[] bArr2 = jad_an;
                if (i2 >= bArr2.length) {
                    break;
                }
                if (bArr[i2] != bArr2[i2]) {
                    return false;
                }
                i2++;
            }
        }
        return z;
    }

    public final int jad_bo(com.jd.ad.sdk.jad_te.jad_hu.jad_cp jad_cpVar) {
        short jad_an2;
        int jad_bo2;
        long j;
        long jad_an3;
        do {
            short jad_an4 = jad_cpVar.jad_an();
            if (jad_an4 != 255) {
                if (android.util.Log.isLoggable("DfltImageHeaderParser", 3)) {
                    com.jd.ad.sdk.logger.Logger.d("DfltImageHeaderParser", "Unknown segmentId=" + ((int) jad_an4));
                }
                return -1;
            }
            jad_an2 = jad_cpVar.jad_an();
            if (jad_an2 == 218) {
                return -1;
            }
            if (jad_an2 == 217) {
                if (android.util.Log.isLoggable("DfltImageHeaderParser", 3)) {
                    com.jd.ad.sdk.logger.Logger.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            jad_bo2 = jad_cpVar.jad_bo() - 2;
            if (jad_an2 == 225) {
                return jad_bo2;
            }
            j = jad_bo2;
            jad_an3 = jad_cpVar.jad_an(j);
        } while (jad_an3 == j);
        if (android.util.Log.isLoggable("DfltImageHeaderParser", 3)) {
            com.jd.ad.sdk.logger.Logger.d("DfltImageHeaderParser", "Unable to skip enough data, type: " + ((int) jad_an2) + ", wanted to skip: " + jad_bo2 + ", but actually skipped: " + jad_an3);
        }
        return -1;
    }
}
