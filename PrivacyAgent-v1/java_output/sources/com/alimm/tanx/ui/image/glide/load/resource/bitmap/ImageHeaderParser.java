package com.alimm.tanx.ui.image.glide.load.resource.bitmap;

/* loaded from: classes.dex */
public class ImageHeaderParser {
    private static final int[] BYTES_PER_FORMAT = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
    private static final int EXIF_MAGIC_NUMBER = 65496;
    private static final int EXIF_SEGMENT_TYPE = 225;
    private static final int GIF_HEADER = 4671814;
    private static final int INTEL_TIFF_MAGIC_NUMBER = 18761;
    private static final java.lang.String JPEG_EXIF_SEGMENT_PREAMBLE = "Exif\u0000\u0000";
    private static final byte[] JPEG_EXIF_SEGMENT_PREAMBLE_BYTES;
    private static final int MARKER_EOI = 217;
    private static final int MOTOROLA_TIFF_MAGIC_NUMBER = 19789;
    private static final int ORIENTATION_TAG_TYPE = 274;
    private static final int PNG_HEADER = -1991225785;
    private static final int SEGMENT_SOS = 218;
    private static final int SEGMENT_START_ID = 255;
    private static final java.lang.String TAG = "ImageHeaderParser";
    private final com.alimm.tanx.ui.image.glide.load.resource.bitmap.ImageHeaderParser.StreamReader streamReader;

    public enum ImageType {
        GIF(true),
        JPEG(false),
        PNG_A(true),
        PNG(false),
        UNKNOWN(false);

        private final boolean hasAlpha;

        ImageType(boolean z) {
            this.hasAlpha = z;
        }

        public boolean hasAlpha() {
            return this.hasAlpha;
        }
    }

    public static class RandomAccessReader {
        private final java.nio.ByteBuffer data;

        public RandomAccessReader(byte[] bArr) {
            java.nio.ByteBuffer wrap = java.nio.ByteBuffer.wrap(bArr);
            this.data = wrap;
            wrap.order(java.nio.ByteOrder.BIG_ENDIAN);
        }

        public short getInt16(int i) {
            return this.data.getShort(i);
        }

        public int getInt32(int i) {
            return this.data.getInt(i);
        }

        public int length() {
            return this.data.array().length;
        }

        public void order(java.nio.ByteOrder byteOrder) {
            this.data.order(byteOrder);
        }
    }

    public static class StreamReader {
        private final java.io.InputStream is;

        public StreamReader(java.io.InputStream inputStream) {
            this.is = inputStream;
        }

        public int getByte() throws java.io.IOException {
            return this.is.read();
        }

        public int getUInt16() throws java.io.IOException {
            return ((this.is.read() << 8) & androidx.core.view.MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (this.is.read() & 255);
        }

        public short getUInt8() throws java.io.IOException {
            return (short) (this.is.read() & 255);
        }

        public int read(byte[] bArr) throws java.io.IOException {
            int length = bArr.length;
            while (length > 0) {
                int read = this.is.read(bArr, bArr.length - length, length);
                if (read == -1) {
                    break;
                }
                length -= read;
            }
            return bArr.length - length;
        }

        public long skip(long j) throws java.io.IOException {
            if (j < 0) {
                return 0L;
            }
            long j2 = j;
            while (j2 > 0) {
                long skip = this.is.skip(j2);
                if (skip <= 0) {
                    if (this.is.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j2 -= skip;
            }
            return j - j2;
        }
    }

    static {
        byte[] bArr = new byte[0];
        try {
            bArr = JPEG_EXIF_SEGMENT_PREAMBLE.getBytes("UTF-8");
        } catch (java.io.UnsupportedEncodingException unused) {
        }
        JPEG_EXIF_SEGMENT_PREAMBLE_BYTES = bArr;
    }

    public ImageHeaderParser(java.io.InputStream inputStream) {
        this.streamReader = new com.alimm.tanx.ui.image.glide.load.resource.bitmap.ImageHeaderParser.StreamReader(inputStream);
    }

    private static int calcTagOffset(int i, int i2) {
        return (i2 * 12) + i + 2;
    }

    private byte[] getExifSegment() throws java.io.IOException {
        short uInt8;
        int uInt16;
        long j;
        long skip;
        do {
            short uInt82 = this.streamReader.getUInt8();
            if (uInt82 != 255) {
                if (android.util.Log.isLoggable(TAG, 3)) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("Unknown segmentId=");
                    sb.append((int) uInt82);
                }
                return null;
            }
            uInt8 = this.streamReader.getUInt8();
            if (uInt8 == SEGMENT_SOS || uInt8 == MARKER_EOI) {
                return null;
            }
            uInt16 = this.streamReader.getUInt16() - 2;
            if (uInt8 == EXIF_SEGMENT_TYPE) {
                byte[] bArr = new byte[uInt16];
                int read = this.streamReader.read(bArr);
                if (read == uInt16) {
                    return bArr;
                }
                if (android.util.Log.isLoggable(TAG, 3)) {
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append("Unable to read segment data, type: ");
                    sb2.append((int) uInt8);
                    sb2.append(", length: ");
                    sb2.append(uInt16);
                    sb2.append(", actually read: ");
                    sb2.append(read);
                }
                return null;
            }
            j = uInt16;
            skip = this.streamReader.skip(j);
        } while (skip == j);
        if (android.util.Log.isLoggable(TAG, 3)) {
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
            sb3.append("Unable to skip enough data, type: ");
            sb3.append((int) uInt8);
            sb3.append(", wanted to skip: ");
            sb3.append(uInt16);
            sb3.append(", but actually skipped: ");
            sb3.append(skip);
        }
        return null;
    }

    private static boolean handles(int i) {
        return (i & EXIF_MAGIC_NUMBER) == EXIF_MAGIC_NUMBER || i == MOTOROLA_TIFF_MAGIC_NUMBER || i == INTEL_TIFF_MAGIC_NUMBER;
    }

    private static int parseExifSegment(com.alimm.tanx.ui.image.glide.load.resource.bitmap.ImageHeaderParser.RandomAccessReader randomAccessReader) {
        java.nio.ByteOrder byteOrder;
        short int16 = randomAccessReader.getInt16(6);
        if (int16 == MOTOROLA_TIFF_MAGIC_NUMBER) {
            byteOrder = java.nio.ByteOrder.BIG_ENDIAN;
        } else if (int16 == INTEL_TIFF_MAGIC_NUMBER) {
            byteOrder = java.nio.ByteOrder.LITTLE_ENDIAN;
        } else {
            if (android.util.Log.isLoggable(TAG, 3)) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Unknown endianness = ");
                sb.append((int) int16);
            }
            byteOrder = java.nio.ByteOrder.BIG_ENDIAN;
        }
        randomAccessReader.order(byteOrder);
        int int32 = randomAccessReader.getInt32(10) + 6;
        short int162 = randomAccessReader.getInt16(int32);
        for (int i = 0; i < int162; i++) {
            int calcTagOffset = calcTagOffset(int32, i);
            short int163 = randomAccessReader.getInt16(calcTagOffset);
            if (int163 == ORIENTATION_TAG_TYPE) {
                short int164 = randomAccessReader.getInt16(calcTagOffset + 2);
                if (int164 >= 1 && int164 <= 12) {
                    int int322 = randomAccessReader.getInt32(calcTagOffset + 4);
                    if (int322 >= 0) {
                        if (android.util.Log.isLoggable(TAG, 3)) {
                            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                            sb2.append("Got tagIndex=");
                            sb2.append(i);
                            sb2.append(" tagType=");
                            sb2.append((int) int163);
                            sb2.append(" formatCode=");
                            sb2.append((int) int164);
                            sb2.append(" componentCount=");
                            sb2.append(int322);
                        }
                        int i2 = int322 + BYTES_PER_FORMAT[int164];
                        if (i2 <= 4) {
                            int i3 = calcTagOffset + 8;
                            if (i3 >= 0 && i3 <= randomAccessReader.length()) {
                                if (i2 >= 0 && i2 + i3 <= randomAccessReader.length()) {
                                    return randomAccessReader.getInt16(i3);
                                }
                                if (android.util.Log.isLoggable(TAG, 3)) {
                                    java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                                    sb3.append("Illegal number of bytes for TI tag data tagType=");
                                    sb3.append((int) int163);
                                }
                            } else if (android.util.Log.isLoggable(TAG, 3)) {
                                java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
                                sb4.append("Illegal tagValueOffset=");
                                sb4.append(i3);
                                sb4.append(" tagType=");
                                sb4.append((int) int163);
                            }
                        } else if (android.util.Log.isLoggable(TAG, 3)) {
                            java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
                            sb5.append("Got byte count > 4, not orientation, continuing, formatCode=");
                            sb5.append((int) int164);
                        }
                    } else {
                        continue;
                    }
                } else if (android.util.Log.isLoggable(TAG, 3)) {
                    java.lang.StringBuilder sb6 = new java.lang.StringBuilder();
                    sb6.append("Got invalid format code=");
                    sb6.append((int) int164);
                }
            }
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getOrientation() throws java.io.IOException {
        if (!handles(this.streamReader.getUInt16())) {
            return -1;
        }
        byte[] exifSegment = getExifSegment();
        boolean z = false;
        boolean z2 = exifSegment != null && exifSegment.length > JPEG_EXIF_SEGMENT_PREAMBLE_BYTES.length;
        if (z2) {
            int i = 0;
            while (true) {
                byte[] bArr = JPEG_EXIF_SEGMENT_PREAMBLE_BYTES;
                if (i >= bArr.length) {
                    break;
                }
                if (exifSegment[i] != bArr[i]) {
                    break;
                }
                i++;
            }
            if (z) {
                return -1;
            }
            return parseExifSegment(new com.alimm.tanx.ui.image.glide.load.resource.bitmap.ImageHeaderParser.RandomAccessReader(exifSegment));
        }
        z = z2;
        if (z) {
        }
    }

    public com.alimm.tanx.ui.image.glide.load.resource.bitmap.ImageHeaderParser.ImageType getType() throws java.io.IOException {
        int uInt16 = this.streamReader.getUInt16();
        if (uInt16 == EXIF_MAGIC_NUMBER) {
            return com.alimm.tanx.ui.image.glide.load.resource.bitmap.ImageHeaderParser.ImageType.JPEG;
        }
        int uInt162 = ((uInt16 << 16) & androidx.core.internal.view.SupportMenu.CATEGORY_MASK) | (this.streamReader.getUInt16() & 65535);
        if (uInt162 != PNG_HEADER) {
            return (uInt162 >> 8) == GIF_HEADER ? com.alimm.tanx.ui.image.glide.load.resource.bitmap.ImageHeaderParser.ImageType.GIF : com.alimm.tanx.ui.image.glide.load.resource.bitmap.ImageHeaderParser.ImageType.UNKNOWN;
        }
        this.streamReader.skip(21L);
        return this.streamReader.getByte() >= 3 ? com.alimm.tanx.ui.image.glide.load.resource.bitmap.ImageHeaderParser.ImageType.PNG_A : com.alimm.tanx.ui.image.glide.load.resource.bitmap.ImageHeaderParser.ImageType.PNG;
    }

    public boolean hasAlpha() throws java.io.IOException {
        return getType().hasAlpha();
    }
}
