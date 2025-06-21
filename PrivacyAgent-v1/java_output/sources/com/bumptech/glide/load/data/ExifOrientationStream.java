package com.bumptech.glide.load.data;

/* loaded from: classes.dex */
public final class ExifOrientationStream extends java.io.FilterInputStream {
    private static final byte[] EXIF_SEGMENT;
    private static final int ORIENTATION_POSITION;
    private static final int SEGMENT_LENGTH;
    private static final int SEGMENT_START_POSITION = 2;
    private final byte orientation;
    private int position;

    static {
        byte[] bArr = {-1, -31, 0, com.google.common.base.Ascii.FS, 69, org.apache.tools.tar.TarConstants.LF_PAX_EXTENDED_HEADER_LC, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, com.google.common.base.Ascii.DC2, 0, 2, 0, 0, 0, 1, 0};
        EXIF_SEGMENT = bArr;
        int length = bArr.length;
        SEGMENT_LENGTH = length;
        ORIENTATION_POSITION = length + 2;
    }

    public ExifOrientationStream(java.io.InputStream inputStream, int i) {
        super(inputStream);
        if (i >= -1 && i <= 8) {
            this.orientation = (byte) i;
            return;
        }
        throw new java.lang.IllegalArgumentException("Cannot add invalid orientation: " + i);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i) {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws java.io.IOException {
        int i;
        int i2 = this.position;
        int read = (i2 < 2 || i2 > (i = ORIENTATION_POSITION)) ? super.read() : i2 == i ? this.orientation : EXIF_SEGMENT[i2 - 2] & 255;
        if (read != -1) {
            this.position++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@androidx.annotation.NonNull byte[] bArr, int i, int i2) throws java.io.IOException {
        int i3;
        int i4 = this.position;
        int i5 = ORIENTATION_POSITION;
        if (i4 > i5) {
            i3 = super.read(bArr, i, i2);
        } else if (i4 == i5) {
            bArr[i] = this.orientation;
            i3 = 1;
        } else if (i4 < 2) {
            i3 = super.read(bArr, i, 2 - i4);
        } else {
            int min = java.lang.Math.min(i5 - i4, i2);
            java.lang.System.arraycopy(EXIF_SEGMENT, this.position - 2, bArr, i, min);
            i3 = min;
        }
        if (i3 > 0) {
            this.position += i3;
        }
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws java.io.IOException {
        throw new java.lang.UnsupportedOperationException();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws java.io.IOException {
        long skip = super.skip(j);
        if (skip > 0) {
            this.position = (int) (this.position + skip);
        }
        return skip;
    }
}
