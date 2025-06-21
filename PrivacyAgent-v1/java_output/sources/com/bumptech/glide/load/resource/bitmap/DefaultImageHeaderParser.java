package com.bumptech.glide.load.resource.bitmap;

/* loaded from: classes.dex */
public final class DefaultImageHeaderParser implements com.bumptech.glide.load.ImageHeaderParser {
    static final int EXIF_MAGIC_NUMBER = 65496;
    static final int EXIF_SEGMENT_TYPE = 225;
    private static final int GIF_HEADER = 4671814;
    private static final int INTEL_TIFF_MAGIC_NUMBER = 18761;
    private static final int MARKER_EOI = 217;
    private static final int MOTOROLA_TIFF_MAGIC_NUMBER = 19789;
    private static final int ORIENTATION_TAG_TYPE = 274;
    private static final int PNG_HEADER = -1991225785;
    private static final int RIFF_HEADER = 1380533830;
    private static final int SEGMENT_SOS = 218;
    static final int SEGMENT_START_ID = 255;
    private static final java.lang.String TAG = "DfltImageHeaderParser";
    private static final int VP8_HEADER = 1448097792;
    private static final int VP8_HEADER_MASK = -256;
    private static final int VP8_HEADER_TYPE_EXTENDED = 88;
    private static final int VP8_HEADER_TYPE_LOSSLESS = 76;
    private static final int VP8_HEADER_TYPE_MASK = 255;
    private static final int WEBP_EXTENDED_ALPHA_FLAG = 16;
    private static final int WEBP_HEADER = 1464156752;
    private static final int WEBP_LOSSLESS_ALPHA_FLAG = 8;
    private static final java.lang.String JPEG_EXIF_SEGMENT_PREAMBLE = "Exif\u0000\u0000";
    static final byte[] JPEG_EXIF_SEGMENT_PREAMBLE_BYTES = JPEG_EXIF_SEGMENT_PREAMBLE.getBytes(java.nio.charset.Charset.forName("UTF-8"));
    private static final int[] BYTES_PER_FORMAT = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    public static final class ByteBufferReader implements com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader {
        private final java.nio.ByteBuffer byteBuffer;

        public ByteBufferReader(java.nio.ByteBuffer byteBuffer) {
            this.byteBuffer = byteBuffer;
            byteBuffer.order(java.nio.ByteOrder.BIG_ENDIAN);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int getUInt16() throws com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader.EndOfFileException {
            return (getUInt8() << 8) | getUInt8();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public short getUInt8() throws com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader.EndOfFileException {
            if (this.byteBuffer.remaining() >= 1) {
                return (short) (this.byteBuffer.get() & 255);
            }
            throw new com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader.EndOfFileException();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int read(byte[] bArr, int i) {
            int min = java.lang.Math.min(i, this.byteBuffer.remaining());
            if (min == 0) {
                return -1;
            }
            this.byteBuffer.get(bArr, 0, min);
            return min;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public long skip(long j) {
            int min = (int) java.lang.Math.min(this.byteBuffer.remaining(), j);
            java.nio.ByteBuffer byteBuffer = this.byteBuffer;
            byteBuffer.position(byteBuffer.position() + min);
            return min;
        }
    }

    public static final class RandomAccessReader {
        private final java.nio.ByteBuffer data;

        public RandomAccessReader(byte[] bArr, int i) {
            this.data = (java.nio.ByteBuffer) java.nio.ByteBuffer.wrap(bArr).order(java.nio.ByteOrder.BIG_ENDIAN).limit(i);
        }

        private boolean isAvailable(int i, int i2) {
            return this.data.remaining() - i >= i2;
        }

        public short getInt16(int i) {
            if (isAvailable(i, 2)) {
                return this.data.getShort(i);
            }
            return (short) -1;
        }

        public int getInt32(int i) {
            if (isAvailable(i, 4)) {
                return this.data.getInt(i);
            }
            return -1;
        }

        public int length() {
            return this.data.remaining();
        }

        public void order(java.nio.ByteOrder byteOrder) {
            this.data.order(byteOrder);
        }
    }

    public interface Reader {

        public static final class EndOfFileException extends java.io.IOException {
            private static final long serialVersionUID = 1;

            public EndOfFileException() {
                super("Unexpectedly reached end of a file");
            }
        }

        int getUInt16() throws java.io.IOException;

        short getUInt8() throws java.io.IOException;

        int read(byte[] bArr, int i) throws java.io.IOException;

        long skip(long j) throws java.io.IOException;
    }

    public static final class StreamReader implements com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader {
        private final java.io.InputStream is;

        public StreamReader(java.io.InputStream inputStream) {
            this.is = inputStream;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int getUInt16() throws java.io.IOException {
            return (getUInt8() << 8) | getUInt8();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public short getUInt8() throws java.io.IOException {
            int read = this.is.read();
            if (read != -1) {
                return (short) read;
            }
            throw new com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader.EndOfFileException();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int read(byte[] bArr, int i) throws java.io.IOException {
            int i2 = 0;
            int i3 = 0;
            while (i2 < i && (i3 = this.is.read(bArr, i2, i - i2)) != -1) {
                i2 += i3;
            }
            if (i2 == 0 && i3 == -1) {
                throw new com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader.EndOfFileException();
            }
            return i2;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
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

    private static int calcTagOffset(int i, int i2) {
        return i + 2 + (i2 * 12);
    }

    private int getOrientation(com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader reader, com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) throws java.io.IOException {
        try {
            int uInt16 = reader.getUInt16();
            if (!handles(uInt16)) {
                if (android.util.Log.isLoggable(TAG, 3)) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("Parser doesn't handle magic number: ");
                    sb.append(uInt16);
                }
                return -1;
            }
            int moveToExifSegmentAndGetLength = moveToExifSegmentAndGetLength(reader);
            if (moveToExifSegmentAndGetLength == -1) {
                return -1;
            }
            byte[] bArr = (byte[]) arrayPool.get(moveToExifSegmentAndGetLength, byte[].class);
            try {
                return parseExifSegment(reader, bArr, moveToExifSegmentAndGetLength);
            } finally {
                arrayPool.put(bArr);
            }
        } catch (com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader.EndOfFileException unused) {
            return -1;
        }
    }

    @androidx.annotation.NonNull
    private com.bumptech.glide.load.ImageHeaderParser.ImageType getType(com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader reader) throws java.io.IOException {
        try {
            int uInt16 = reader.getUInt16();
            if (uInt16 == EXIF_MAGIC_NUMBER) {
                return com.bumptech.glide.load.ImageHeaderParser.ImageType.JPEG;
            }
            int uInt8 = (uInt16 << 8) | reader.getUInt8();
            if (uInt8 == GIF_HEADER) {
                return com.bumptech.glide.load.ImageHeaderParser.ImageType.GIF;
            }
            int uInt82 = (uInt8 << 8) | reader.getUInt8();
            if (uInt82 == PNG_HEADER) {
                reader.skip(21L);
                try {
                    return reader.getUInt8() >= 3 ? com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG_A : com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG;
                } catch (com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader.EndOfFileException unused) {
                    return com.bumptech.glide.load.ImageHeaderParser.ImageType.PNG;
                }
            }
            if (uInt82 != 1380533830) {
                return com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN;
            }
            reader.skip(4L);
            if (((reader.getUInt16() << 16) | reader.getUInt16()) != WEBP_HEADER) {
                return com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN;
            }
            int uInt162 = (reader.getUInt16() << 16) | reader.getUInt16();
            if ((uInt162 & (-256)) != VP8_HEADER) {
                return com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN;
            }
            int i = uInt162 & 255;
            if (i == 88) {
                reader.skip(4L);
                return (reader.getUInt8() & 16) != 0 ? com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP_A : com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP;
            }
            if (i != 76) {
                return com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP;
            }
            reader.skip(4L);
            return (reader.getUInt8() & 8) != 0 ? com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP_A : com.bumptech.glide.load.ImageHeaderParser.ImageType.WEBP;
        } catch (com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader.EndOfFileException unused2) {
            return com.bumptech.glide.load.ImageHeaderParser.ImageType.UNKNOWN;
        }
    }

    private static boolean handles(int i) {
        return (i & EXIF_MAGIC_NUMBER) == EXIF_MAGIC_NUMBER || i == MOTOROLA_TIFF_MAGIC_NUMBER || i == INTEL_TIFF_MAGIC_NUMBER;
    }

    private boolean hasJpegExifPreamble(byte[] bArr, int i) {
        boolean z = bArr != null && i > JPEG_EXIF_SEGMENT_PREAMBLE_BYTES.length;
        if (z) {
            int i2 = 0;
            while (true) {
                byte[] bArr2 = JPEG_EXIF_SEGMENT_PREAMBLE_BYTES;
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

    private int moveToExifSegmentAndGetLength(com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader reader) throws java.io.IOException {
        short uInt8;
        int uInt16;
        long j;
        long skip;
        do {
            short uInt82 = reader.getUInt8();
            if (uInt82 != 255) {
                if (android.util.Log.isLoggable(TAG, 3)) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("Unknown segmentId=");
                    sb.append((int) uInt82);
                }
                return -1;
            }
            uInt8 = reader.getUInt8();
            if (uInt8 == SEGMENT_SOS || uInt8 == MARKER_EOI) {
                return -1;
            }
            uInt16 = reader.getUInt16() - 2;
            if (uInt8 == EXIF_SEGMENT_TYPE) {
                return uInt16;
            }
            j = uInt16;
            skip = reader.skip(j);
        } while (skip == j);
        if (android.util.Log.isLoggable(TAG, 3)) {
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("Unable to skip enough data, type: ");
            sb2.append((int) uInt8);
            sb2.append(", wanted to skip: ");
            sb2.append(uInt16);
            sb2.append(", but actually skipped: ");
            sb2.append(skip);
        }
        return -1;
    }

    private static int parseExifSegment(com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.RandomAccessReader randomAccessReader) {
        java.nio.ByteOrder byteOrder;
        short int16 = randomAccessReader.getInt16(6);
        if (int16 == INTEL_TIFF_MAGIC_NUMBER) {
            byteOrder = java.nio.ByteOrder.LITTLE_ENDIAN;
        } else if (int16 != MOTOROLA_TIFF_MAGIC_NUMBER) {
            if (android.util.Log.isLoggable(TAG, 3)) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Unknown endianness = ");
                sb.append((int) int16);
            }
            byteOrder = java.nio.ByteOrder.BIG_ENDIAN;
        } else {
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
                    sb6.append("Got invalid format code = ");
                    sb6.append((int) int164);
                }
            }
        }
        return -1;
    }

    private int parseExifSegment(com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader reader, byte[] bArr, int i) throws java.io.IOException {
        int read = reader.read(bArr, i);
        if (read == i) {
            if (hasJpegExifPreamble(bArr, i)) {
                return parseExifSegment(new com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.RandomAccessReader(bArr, i));
            }
            return -1;
        }
        if (android.util.Log.isLoggable(TAG, 3)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Unable to read exif segment data, length: ");
            sb.append(i);
            sb.append(", actually read: ");
            sb.append(read);
        }
        return -1;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int getOrientation(@androidx.annotation.NonNull java.io.InputStream inputStream, @androidx.annotation.NonNull com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) throws java.io.IOException {
        return getOrientation(new com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.StreamReader((java.io.InputStream) com.bumptech.glide.util.Preconditions.checkNotNull(inputStream)), (com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool) com.bumptech.glide.util.Preconditions.checkNotNull(arrayPool));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int getOrientation(@androidx.annotation.NonNull java.nio.ByteBuffer byteBuffer, @androidx.annotation.NonNull com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool arrayPool) throws java.io.IOException {
        return getOrientation(new com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.ByteBufferReader((java.nio.ByteBuffer) com.bumptech.glide.util.Preconditions.checkNotNull(byteBuffer)), (com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool) com.bumptech.glide.util.Preconditions.checkNotNull(arrayPool));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @androidx.annotation.NonNull
    public com.bumptech.glide.load.ImageHeaderParser.ImageType getType(@androidx.annotation.NonNull java.io.InputStream inputStream) throws java.io.IOException {
        return getType(new com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.StreamReader((java.io.InputStream) com.bumptech.glide.util.Preconditions.checkNotNull(inputStream)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @androidx.annotation.NonNull
    public com.bumptech.glide.load.ImageHeaderParser.ImageType getType(@androidx.annotation.NonNull java.nio.ByteBuffer byteBuffer) throws java.io.IOException {
        return getType(new com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.ByteBufferReader((java.nio.ByteBuffer) com.bumptech.glide.util.Preconditions.checkNotNull(byteBuffer)));
    }
}
