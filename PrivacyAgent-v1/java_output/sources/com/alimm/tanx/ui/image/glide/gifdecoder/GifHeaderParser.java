package com.alimm.tanx.ui.image.glide.gifdecoder;

/* loaded from: classes.dex */
public class GifHeaderParser {
    static final int DEFAULT_FRAME_DELAY = 10;
    private static final int MAX_BLOCK_SIZE = 256;
    static final int MIN_FRAME_DELAY = 3;
    public static final java.lang.String TAG = "GifHeaderParser";
    private final byte[] block = new byte[256];
    private int blockSize = 0;
    private com.alimm.tanx.ui.image.glide.gifdecoder.GifHeader header;
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
        com.alimm.tanx.ui.image.glide.gifdecoder.GifFrame gifFrame = this.header.currentFrame;
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
        com.alimm.tanx.ui.image.glide.gifdecoder.GifHeader gifHeader = this.header;
        gifHeader.frameCount++;
        gifHeader.frames.add(gifHeader.currentFrame);
    }

    private int readBlock() {
        int read = read();
        this.blockSize = read;
        int i = 0;
        if (read > 0) {
            int i2 = 0;
            while (true) {
                try {
                    i2 = this.blockSize;
                    if (i >= i2) {
                        break;
                    }
                    i2 -= i;
                    this.rawData.get(this.block, i, i2);
                    i += i2;
                } catch (java.lang.Exception unused) {
                    if (android.util.Log.isLoggable(TAG, 3)) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("Error Reading Block n: ");
                        sb.append(i);
                        sb.append(" count: ");
                        sb.append(i2);
                        sb.append(" blockSize: ");
                        sb.append(this.blockSize);
                    }
                    this.header.status = 1;
                }
            }
        }
        return i;
    }

    private int[] readColorTable(int i) {
        int[] iArr;
        byte[] bArr = new byte[i * 3];
        try {
            this.rawData.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                try {
                    int i5 = i4 + 1;
                    int i6 = i5 + 1;
                    int i7 = i2 + 1;
                    iArr[i2] = ((bArr[i3] & 255) << 16) | androidx.core.view.ViewCompat.MEASURED_STATE_MASK | ((bArr[i4] & 255) << 8) | (bArr[i5] & 255);
                    i3 = i6;
                    i2 = i7;
                } catch (java.nio.BufferUnderflowException unused) {
                    this.header.status = 1;
                    return iArr;
                }
            }
        } catch (java.nio.BufferUnderflowException unused2) {
            iArr = null;
        }
        return iArr;
    }

    private void readContents() {
        boolean z = false;
        while (!z && !err()) {
            int read = read();
            if (read == 33) {
                int read2 = read();
                if (read2 == 1) {
                    skip();
                } else if (read2 == 249) {
                    this.header.currentFrame = new com.alimm.tanx.ui.image.glide.gifdecoder.GifFrame();
                    readGraphicControlExt();
                } else if (read2 == 254) {
                    skip();
                } else if (read2 != 255) {
                    skip();
                } else {
                    readBlock();
                    java.lang.String str = "";
                    for (int i = 0; i < 11; i++) {
                        java.lang.StringBuilder tanxu_do2 = tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do(str);
                        tanxu_do2.append((char) this.block[i]);
                        str = tanxu_do2.toString();
                    }
                    if (str.equals("NETSCAPE2.0")) {
                        readNetscapeExt();
                    } else {
                        skip();
                    }
                }
            } else if (read == 44) {
                com.alimm.tanx.ui.image.glide.gifdecoder.GifHeader gifHeader = this.header;
                if (gifHeader.currentFrame == null) {
                    gifHeader.currentFrame = new com.alimm.tanx.ui.image.glide.gifdecoder.GifFrame();
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
        com.alimm.tanx.ui.image.glide.gifdecoder.GifFrame gifFrame = this.header.currentFrame;
        int i = (read & 28) >> 2;
        gifFrame.dispose = i;
        if (i == 0) {
            gifFrame.dispose = 1;
        }
        gifFrame.transparency = (read & 1) != 0;
        int readShort = readShort();
        if (readShort < 3) {
            readShort = 10;
        }
        com.alimm.tanx.ui.image.glide.gifdecoder.GifFrame gifFrame2 = this.header.currentFrame;
        gifFrame2.delay = readShort * 10;
        gifFrame2.transIndex = read();
        read();
    }

    private void readHeader() {
        java.lang.String str = "";
        for (int i = 0; i < 6; i++) {
            java.lang.StringBuilder tanxu_do2 = tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do(str);
            tanxu_do2.append((char) read());
            str = tanxu_do2.toString();
        }
        if (!str.startsWith("GIF")) {
            this.header.status = 1;
            return;
        }
        readLSD();
        if (!this.header.gctFlag || err()) {
            return;
        }
        com.alimm.tanx.ui.image.glide.gifdecoder.GifHeader gifHeader = this.header;
        gifHeader.gct = readColorTable(gifHeader.gctSize);
        com.alimm.tanx.ui.image.glide.gifdecoder.GifHeader gifHeader2 = this.header;
        gifHeader2.bgColor = gifHeader2.gct[gifHeader2.bgIndex];
    }

    private void readLSD() {
        this.header.width = readShort();
        this.header.height = readShort();
        int read = read();
        com.alimm.tanx.ui.image.glide.gifdecoder.GifHeader gifHeader = this.header;
        gifHeader.gctFlag = (read & 128) != 0;
        gifHeader.gctSize = 2 << (read & 7);
        gifHeader.bgIndex = read();
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
        this.header = new com.alimm.tanx.ui.image.glide.gifdecoder.GifHeader();
        this.blockSize = 0;
    }

    private void skip() {
        int read;
        do {
            read = read();
            java.nio.ByteBuffer byteBuffer = this.rawData;
            byteBuffer.position(byteBuffer.position() + read);
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

    public com.alimm.tanx.ui.image.glide.gifdecoder.GifHeader parseHeader() {
        if (this.rawData == null) {
            throw new java.lang.IllegalStateException("You must call setData() before parseHeader()");
        }
        if (err()) {
            return this.header;
        }
        readHeader();
        if (!err()) {
            readContents();
            com.alimm.tanx.ui.image.glide.gifdecoder.GifHeader gifHeader = this.header;
            if (gifHeader.frameCount < 0) {
                gifHeader.status = 1;
            }
        }
        return this.header;
    }

    public com.alimm.tanx.ui.image.glide.gifdecoder.GifHeaderParser setData(byte[] bArr) {
        reset();
        if (bArr != null) {
            java.nio.ByteBuffer wrap = java.nio.ByteBuffer.wrap(bArr);
            this.rawData = wrap;
            wrap.rewind();
            this.rawData.order(java.nio.ByteOrder.LITTLE_ENDIAN);
        } else {
            this.rawData = null;
            this.header.status = 2;
        }
        return this;
    }
}
