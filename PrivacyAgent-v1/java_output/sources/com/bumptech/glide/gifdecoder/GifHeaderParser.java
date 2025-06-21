package com.bumptech.glide.gifdecoder;

/* loaded from: classes.dex */
public class GifHeaderParser {
    static final int DEFAULT_FRAME_DELAY = 10;
    private static final int DESCRIPTOR_MASK_INTERLACE_FLAG = 64;
    private static final int DESCRIPTOR_MASK_LCT_FLAG = 128;
    private static final int DESCRIPTOR_MASK_LCT_SIZE = 7;
    private static final int EXTENSION_INTRODUCER = 33;
    private static final int GCE_DISPOSAL_METHOD_SHIFT = 2;
    private static final int GCE_MASK_DISPOSAL_METHOD = 28;
    private static final int GCE_MASK_TRANSPARENT_COLOR_FLAG = 1;
    private static final int IMAGE_SEPARATOR = 44;
    private static final int LABEL_APPLICATION_EXTENSION = 255;
    private static final int LABEL_COMMENT_EXTENSION = 254;
    private static final int LABEL_GRAPHIC_CONTROL_EXTENSION = 249;
    private static final int LABEL_PLAIN_TEXT_EXTENSION = 1;
    private static final int LSD_MASK_GCT_FLAG = 128;
    private static final int LSD_MASK_GCT_SIZE = 7;
    private static final int MASK_INT_LOWEST_BYTE = 255;
    private static final int MAX_BLOCK_SIZE = 256;
    static final int MIN_FRAME_DELAY = 2;
    private static final java.lang.String TAG = "GifHeaderParser";
    private static final int TRAILER = 59;
    private final byte[] block = new byte[256];
    private int blockSize = 0;
    private com.bumptech.glide.gifdecoder.GifHeader header;
    private java.nio.ByteBuffer rawData;

    private boolean err() {
        return this.header.status != 0;
    }

    private int read() {
        try {
            return this.rawData.get() & 255;
        } catch (java.lang.Exception unused) {
            this.header.status = 1;
            return 0;
        }
    }

    private void readBitmap() {
        this.header.currentFrame.ix = readShort();
        this.header.currentFrame.iy = readShort();
        this.header.currentFrame.iw = readShort();
        this.header.currentFrame.ih = readShort();
        int read = read();
        boolean z = (read & 128) != 0;
        int pow = (int) java.lang.Math.pow(2.0d, (read & 7) + 1);
        com.bumptech.glide.gifdecoder.GifFrame gifFrame = this.header.currentFrame;
        gifFrame.interlace = (read & 64) != 0;
        if (z) {
            gifFrame.lct = readColorTable(pow);
        } else {
            gifFrame.lct = null;
        }
        this.header.currentFrame.bufferFrameStart = this.rawData.position();
        skipImageData();
        if (err()) {
            return;
        }
        com.bumptech.glide.gifdecoder.GifHeader gifHeader = this.header;
        gifHeader.frameCount++;
        gifHeader.frames.add(gifHeader.currentFrame);
    }

    private void readBlock() {
        int read = read();
        this.blockSize = read;
        if (read <= 0) {
            return;
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            try {
                i2 = this.blockSize;
                if (i >= i2) {
                    return;
                }
                i2 -= i;
                this.rawData.get(this.block, i, i2);
                i += i2;
            } catch (java.lang.Exception unused) {
                if (android.util.Log.isLoggable("GifHeaderParser", 3)) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("Error Reading Block n: ");
                    sb.append(i);
                    sb.append(" count: ");
                    sb.append(i2);
                    sb.append(" blockSize: ");
                    sb.append(this.blockSize);
                }
                this.header.status = 1;
                return;
            }
        }
    }

    @androidx.annotation.Nullable
    private int[] readColorTable(int i) {
        byte[] bArr = new byte[i * 3];
        int[] iArr = null;
        try {
            this.rawData.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                int i5 = bArr[i3] & 255;
                int i6 = i4 + 1;
                int i7 = bArr[i4] & 255;
                int i8 = i6 + 1;
                int i9 = i2 + 1;
                iArr[i2] = (i5 << 16) | androidx.core.view.ViewCompat.MEASURED_STATE_MASK | (i7 << 8) | (bArr[i6] & 255);
                i3 = i8;
                i2 = i9;
            }
        } catch (java.nio.BufferUnderflowException unused) {
            this.header.status = 1;
        }
        return iArr;
    }

    private void readContents() {
        readContents(Integer.MAX_VALUE);
    }

    private void readContents(int i) {
        boolean z = false;
        while (!z && !err() && this.header.frameCount <= i) {
            int read = read();
            if (read == 33) {
                int read2 = read();
                if (read2 == 1) {
                    skip();
                } else if (read2 == LABEL_GRAPHIC_CONTROL_EXTENSION) {
                    this.header.currentFrame = new com.bumptech.glide.gifdecoder.GifFrame();
                    readGraphicControlExt();
                } else if (read2 == 254) {
                    skip();
                } else if (read2 != 255) {
                    skip();
                } else {
                    readBlock();
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    for (int i2 = 0; i2 < 11; i2++) {
                        sb.append((char) this.block[i2]);
                    }
                    if (sb.toString().equals("NETSCAPE2.0")) {
                        readNetscapeExt();
                    } else {
                        skip();
                    }
                }
            } else if (read == 44) {
                com.bumptech.glide.gifdecoder.GifHeader gifHeader = this.header;
                if (gifHeader.currentFrame == null) {
                    gifHeader.currentFrame = new com.bumptech.glide.gifdecoder.GifFrame();
                }
                readBitmap();
            } else if (read != 59) {
                this.header.status = 1;
            } else {
                z = true;
            }
        }
    }

    private void readGraphicControlExt() {
        read();
        int read = read();
        com.bumptech.glide.gifdecoder.GifFrame gifFrame = this.header.currentFrame;
        int i = (read & 28) >> 2;
        gifFrame.dispose = i;
        if (i == 0) {
            gifFrame.dispose = 1;
        }
        gifFrame.transparency = (read & 1) != 0;
        int readShort = readShort();
        if (readShort < 2) {
            readShort = 10;
        }
        com.bumptech.glide.gifdecoder.GifFrame gifFrame2 = this.header.currentFrame;
        gifFrame2.delay = readShort * 10;
        gifFrame2.transIndex = read();
        read();
    }

    private void readHeader() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append((char) read());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.header.status = 1;
            return;
        }
        readLSD();
        if (!this.header.gctFlag || err()) {
            return;
        }
        com.bumptech.glide.gifdecoder.GifHeader gifHeader = this.header;
        gifHeader.gct = readColorTable(gifHeader.gctSize);
        com.bumptech.glide.gifdecoder.GifHeader gifHeader2 = this.header;
        gifHeader2.bgColor = gifHeader2.gct[gifHeader2.bgIndex];
    }

    private void readLSD() {
        this.header.width = readShort();
        this.header.height = readShort();
        int read = read();
        com.bumptech.glide.gifdecoder.GifHeader gifHeader = this.header;
        gifHeader.gctFlag = (read & 128) != 0;
        gifHeader.gctSize = (int) java.lang.Math.pow(2.0d, (read & 7) + 1);
        this.header.bgIndex = read();
        this.header.pixelAspect = read();
    }

    private void readNetscapeExt() {
        do {
            readBlock();
            byte[] bArr = this.block;
            if (bArr[0] == 1) {
                this.header.loopCount = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.blockSize <= 0) {
                return;
            }
        } while (!err());
    }

    private int readShort() {
        return this.rawData.getShort();
    }

    private void reset() {
        this.rawData = null;
        java.util.Arrays.fill(this.block, (byte) 0);
        this.header = new com.bumptech.glide.gifdecoder.GifHeader();
        this.blockSize = 0;
    }

    private void skip() {
        int read;
        do {
            read = read();
            this.rawData.position(java.lang.Math.min(this.rawData.position() + read, this.rawData.limit()));
        } while (read > 0);
    }

    private void skipImageData() {
        read();
        skip();
    }

    public void clear() {
        this.rawData = null;
        this.header = null;
    }

    public boolean isAnimated() {
        readHeader();
        if (!err()) {
            readContents(2);
        }
        return this.header.frameCount > 1;
    }

    @androidx.annotation.NonNull
    public com.bumptech.glide.gifdecoder.GifHeader parseHeader() {
        if (this.rawData == null) {
            throw new java.lang.IllegalStateException("You must call setData() before parseHeader()");
        }
        if (err()) {
            return this.header;
        }
        readHeader();
        if (!err()) {
            readContents();
            com.bumptech.glide.gifdecoder.GifHeader gifHeader = this.header;
            if (gifHeader.frameCount < 0) {
                gifHeader.status = 1;
            }
        }
        return this.header;
    }

    public com.bumptech.glide.gifdecoder.GifHeaderParser setData(@androidx.annotation.NonNull java.nio.ByteBuffer byteBuffer) {
        reset();
        java.nio.ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.rawData = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.rawData.order(java.nio.ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    public com.bumptech.glide.gifdecoder.GifHeaderParser setData(@androidx.annotation.Nullable byte[] bArr) {
        if (bArr != null) {
            setData(java.nio.ByteBuffer.wrap(bArr));
        } else {
            this.rawData = null;
            this.header.status = 2;
        }
        return this;
    }
}
