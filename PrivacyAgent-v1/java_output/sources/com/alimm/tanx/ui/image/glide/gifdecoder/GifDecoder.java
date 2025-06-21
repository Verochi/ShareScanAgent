package com.alimm.tanx.ui.image.glide.gifdecoder;

/* loaded from: classes.dex */
public class GifDecoder {
    private static final android.graphics.Bitmap.Config BITMAP_CONFIG = android.graphics.Bitmap.Config.ARGB_8888;
    private static final int DISPOSAL_BACKGROUND = 2;
    private static final int DISPOSAL_NONE = 1;
    private static final int DISPOSAL_PREVIOUS = 3;
    private static final int DISPOSAL_UNSPECIFIED = 0;
    private static final int INITIAL_FRAME_POINTER = -1;
    private static final int MAX_STACK_SIZE = 4096;
    private static final int NULL_CODE = -1;
    public static final int STATUS_FORMAT_ERROR = 1;
    public static final int STATUS_OK = 0;
    public static final int STATUS_OPEN_ERROR = 2;
    public static final int STATUS_PARTIAL_DECODE = 3;
    private static final java.lang.String TAG = "GifDecoder";
    public static final int TOTAL_ITERATION_COUNT_FOREVER = 0;
    private int[] act;
    private com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder.BitmapProvider bitmapProvider;
    private byte[] data;
    private int framePointer;
    private byte[] mainPixels;
    private int[] mainScratch;
    private com.alimm.tanx.ui.image.glide.gifdecoder.GifHeaderParser parser;
    private byte[] pixelStack;
    private short[] prefix;
    private android.graphics.Bitmap previousImage;
    private java.nio.ByteBuffer rawData;
    private boolean savePrevious;
    private int status;
    private byte[] suffix;
    private final int[] pct = new int[256];
    private final byte[] block = new byte[256];
    private com.alimm.tanx.ui.image.glide.gifdecoder.GifHeader header = new com.alimm.tanx.ui.image.glide.gifdecoder.GifHeader();

    public interface BitmapProvider {
        android.graphics.Bitmap obtain(int i, int i2, android.graphics.Bitmap.Config config);

        void release(android.graphics.Bitmap bitmap);
    }

    public GifDecoder(com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder.BitmapProvider bitmapProvider) {
        this.bitmapProvider = bitmapProvider;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0133 A[LOOP:5: B:62:0x0131->B:63:0x0133, LOOP_END] */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v31, types: [short] */
    /* JADX WARN: Type inference failed for: r1v33 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void decodeBitmapData(com.alimm.tanx.ui.image.glide.gifdecoder.GifFrame gifFrame) {
        int i;
        int i2;
        int i3;
        int i4;
        short s2;
        if (gifFrame != null) {
            this.rawData.position(gifFrame.bufferFrameStart);
        }
        if (gifFrame == null) {
            com.alimm.tanx.ui.image.glide.gifdecoder.GifHeader gifHeader = this.header;
            i = gifHeader.width;
            i2 = gifHeader.height;
        } else {
            i = gifFrame.iw;
            i2 = gifFrame.ih;
        }
        int i5 = i * i2;
        byte[] bArr = this.mainPixels;
        if (bArr == null || bArr.length < i5) {
            this.mainPixels = new byte[i5];
        }
        if (this.prefix == null) {
            this.prefix = new short[4096];
        }
        if (this.suffix == null) {
            this.suffix = new byte[4096];
        }
        if (this.pixelStack == null) {
            this.pixelStack = new byte[4097];
        }
        int read = read();
        int i6 = 1;
        int i7 = 1 << read;
        int i8 = i7 + 1;
        int i9 = i7 + 2;
        int i10 = read + 1;
        int i11 = (1 << i10) - 1;
        for (int i12 = 0; i12 < i7; i12++) {
            this.prefix[i12] = 0;
            this.suffix[i12] = (byte) i12;
        }
        int i13 = -1;
        int i14 = i10;
        int i15 = i9;
        int i16 = i11;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = -1;
        int i24 = 0;
        int i25 = 0;
        while (true) {
            if (i17 >= i5) {
                break;
            }
            if (i18 == 0) {
                i18 = readBlock();
                if (i18 <= 0) {
                    this.status = 3;
                    break;
                }
                i20 = 0;
            }
            i21 += (this.block[i20] & 255) << i19;
            i19 += 8;
            i20 += i6;
            i18 += i13;
            int i26 = i23;
            int i27 = i14;
            int i28 = i15;
            int i29 = i25;
            while (i19 >= i27) {
                int i30 = i21 & i16;
                i21 >>= i27;
                i19 -= i27;
                if (i30 != i7) {
                    if (i30 > i28) {
                        i3 = i10;
                        this.status = 3;
                    } else {
                        i3 = i10;
                        if (i30 != i8) {
                            if (i26 == -1) {
                                this.pixelStack[i24] = this.suffix[i30];
                                i26 = i30;
                                i29 = i26;
                                i24++;
                                i10 = i3;
                            } else {
                                if (i30 >= i28) {
                                    i4 = i8;
                                    this.pixelStack[i24] = (byte) i29;
                                    s2 = i26;
                                    i24++;
                                } else {
                                    i4 = i8;
                                    s2 = i30;
                                }
                                while (s2 >= i7) {
                                    this.pixelStack[i24] = this.suffix[s2];
                                    s2 = this.prefix[s2];
                                    i24++;
                                    i7 = i7;
                                }
                                int i31 = i7;
                                byte[] bArr2 = this.suffix;
                                int i32 = bArr2[s2] & 255;
                                int i33 = i24 + 1;
                                int i34 = i9;
                                byte b = (byte) i32;
                                this.pixelStack[i24] = b;
                                if (i28 < 4096) {
                                    this.prefix[i28] = (short) i26;
                                    bArr2[i28] = b;
                                    i28++;
                                    if ((i28 & i16) == 0) {
                                        if (i28 < 4096) {
                                            i27++;
                                            i16 += i28;
                                        }
                                        i24 = i33;
                                        while (i24 > 0) {
                                            i24--;
                                            this.mainPixels[i22] = this.pixelStack[i24];
                                            i17++;
                                            i22++;
                                        }
                                        i26 = i30;
                                        i7 = i31;
                                        i8 = i4;
                                        i9 = i34;
                                        i29 = i32;
                                        i10 = i3;
                                    }
                                }
                                i24 = i33;
                                while (i24 > 0) {
                                }
                                i26 = i30;
                                i7 = i31;
                                i8 = i4;
                                i9 = i34;
                                i29 = i32;
                                i10 = i3;
                            }
                        }
                    }
                    i23 = i26;
                    i14 = i27;
                    i15 = i28;
                    i10 = i3;
                    i25 = i29;
                    break;
                }
                i27 = i10;
                i28 = i9;
                i16 = i11;
                i26 = -1;
            }
            i23 = i26;
            i14 = i27;
            i25 = i29;
            i15 = i28;
            i8 = i8;
            i6 = 1;
            i13 = -1;
        }
        for (int i35 = i22; i35 < i5; i35++) {
            this.mainPixels[i35] = 0;
        }
    }

    private com.alimm.tanx.ui.image.glide.gifdecoder.GifHeaderParser getHeaderParser() {
        if (this.parser == null) {
            this.parser = new com.alimm.tanx.ui.image.glide.gifdecoder.GifHeaderParser();
        }
        return this.parser;
    }

    private android.graphics.Bitmap getNextBitmap() {
        com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder.BitmapProvider bitmapProvider = this.bitmapProvider;
        com.alimm.tanx.ui.image.glide.gifdecoder.GifHeader gifHeader = this.header;
        int i = gifHeader.width;
        int i2 = gifHeader.height;
        android.graphics.Bitmap.Config config = BITMAP_CONFIG;
        android.graphics.Bitmap obtain = bitmapProvider.obtain(i, i2, config);
        if (obtain == null) {
            com.alimm.tanx.ui.image.glide.gifdecoder.GifHeader gifHeader2 = this.header;
            obtain = android.graphics.Bitmap.createBitmap(gifHeader2.width, gifHeader2.height, config);
        }
        setAlpha(obtain);
        return obtain;
    }

    private int read() {
        try {
            return this.rawData.get() & 255;
        } catch (java.lang.Exception unused) {
            this.status = 1;
            return 0;
        }
    }

    private int readBlock() {
        int read = read();
        int i = 0;
        if (read > 0) {
            while (i < read) {
                int i2 = read - i;
                try {
                    this.rawData.get(this.block, i, i2);
                    i += i2;
                } catch (java.lang.Exception unused) {
                    this.status = 1;
                }
            }
        }
        return i;
    }

    @android.annotation.TargetApi(12)
    private static void setAlpha(android.graphics.Bitmap bitmap) {
        bitmap.setHasAlpha(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
    
        if (r4.bgIndex == r17.transIndex) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00bc A[EDGE_INSN: B:59:0x00bc->B:60:0x00bc BREAK  A[LOOP:2: B:29:0x0067->B:56:0x00b7], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private android.graphics.Bitmap setPixels(com.alimm.tanx.ui.image.glide.gifdecoder.GifFrame gifFrame, com.alimm.tanx.ui.image.glide.gifdecoder.GifFrame gifFrame2) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        android.graphics.Bitmap bitmap;
        int i7;
        int i8;
        int i9;
        com.alimm.tanx.ui.image.glide.gifdecoder.GifHeader gifHeader = this.header;
        int i10 = gifHeader.width;
        int i11 = gifHeader.height;
        int[] iArr = this.mainScratch;
        int i12 = 0;
        if (gifFrame2 == null) {
            java.util.Arrays.fill(iArr, 0);
        }
        if (gifFrame2 != null && (i6 = gifFrame2.dispose) > 0) {
            if (i6 == 2) {
                if (!gifFrame.transparency) {
                    com.alimm.tanx.ui.image.glide.gifdecoder.GifHeader gifHeader2 = this.header;
                    i7 = gifHeader2.bgColor;
                    if (gifFrame.lct != null) {
                    }
                    i8 = (gifFrame2.iy * i10) + gifFrame2.ix;
                    i9 = (gifFrame2.ih * i10) + i8;
                    while (i8 < i9) {
                        int i13 = gifFrame2.iw + i8;
                        for (int i14 = i8; i14 < i13; i14++) {
                            iArr[i14] = i7;
                        }
                        i8 += i10;
                    }
                }
                i7 = 0;
                i8 = (gifFrame2.iy * i10) + gifFrame2.ix;
                i9 = (gifFrame2.ih * i10) + i8;
                while (i8 < i9) {
                }
            } else if (i6 == 3 && (bitmap = this.previousImage) != null) {
                i = 2;
                bitmap.getPixels(iArr, 0, i10, 0, 0, i10, i11);
                decodeBitmapData(gifFrame);
                int i15 = 8;
                i2 = 0;
                int i16 = 1;
                while (true) {
                    i3 = gifFrame.ih;
                    if (i12 < i3) {
                        break;
                    }
                    if (gifFrame.interlace) {
                        if (i2 >= i3) {
                            i16++;
                            if (i16 == i) {
                                i2 = 4;
                            } else if (i16 == 3) {
                                i15 = 4;
                                i2 = 2;
                            } else if (i16 == 4) {
                                i15 = 2;
                                i2 = 1;
                            }
                        }
                        i5 = i2 + i15;
                    } else {
                        i5 = i2;
                        i2 = i12;
                    }
                    int i17 = i2 + gifFrame.iy;
                    com.alimm.tanx.ui.image.glide.gifdecoder.GifHeader gifHeader3 = this.header;
                    if (i17 < gifHeader3.height) {
                        int i18 = gifHeader3.width;
                        int i19 = i17 * i18;
                        int i20 = gifFrame.ix + i19;
                        int i21 = gifFrame.iw;
                        int i22 = i20 + i21;
                        int i23 = i19 + i18;
                        if (i23 < i22) {
                            i22 = i23;
                        }
                        int i24 = i21 * i12;
                        while (i20 < i22) {
                            int i25 = i24 + 1;
                            int i26 = this.act[this.mainPixels[i24] & 255];
                            if (i26 != 0) {
                                iArr[i20] = i26;
                            }
                            i20++;
                            i24 = i25;
                        }
                    }
                    i12++;
                    i2 = i5;
                    i = 2;
                }
                if (this.savePrevious && ((i4 = gifFrame.dispose) == 0 || i4 == 1)) {
                    if (this.previousImage == null) {
                        this.previousImage = getNextBitmap();
                    }
                    this.previousImage.setPixels(iArr, 0, i10, 0, 0, i10, i11);
                }
                android.graphics.Bitmap nextBitmap = getNextBitmap();
                nextBitmap.setPixels(iArr, 0, i10, 0, 0, i10, i11);
                return nextBitmap;
            }
        }
        i = 2;
        decodeBitmapData(gifFrame);
        int i152 = 8;
        i2 = 0;
        int i162 = 1;
        while (true) {
            i3 = gifFrame.ih;
            if (i12 < i3) {
            }
            i12++;
            i2 = i5;
            i = 2;
        }
        if (this.savePrevious) {
            if (this.previousImage == null) {
            }
            this.previousImage.setPixels(iArr, 0, i10, 0, 0, i10, i11);
        }
        android.graphics.Bitmap nextBitmap2 = getNextBitmap();
        nextBitmap2.setPixels(iArr, 0, i10, 0, 0, i10, i11);
        return nextBitmap2;
    }

    public void advance() {
        this.framePointer = (this.framePointer + 1) % this.header.frameCount;
    }

    public void clear() {
        this.header = null;
        this.data = null;
        this.mainPixels = null;
        this.mainScratch = null;
        android.graphics.Bitmap bitmap = this.previousImage;
        if (bitmap != null) {
            this.bitmapProvider.release(bitmap);
        }
        this.previousImage = null;
        this.rawData = null;
    }

    public int getCurrentFrameIndex() {
        return this.framePointer;
    }

    public byte[] getData() {
        return this.data;
    }

    public int getDelay(int i) {
        if (i >= 0) {
            com.alimm.tanx.ui.image.glide.gifdecoder.GifHeader gifHeader = this.header;
            if (i < gifHeader.frameCount) {
                return gifHeader.frames.get(i).delay;
            }
        }
        return -1;
    }

    public int getFrameCount() {
        return this.header.frameCount;
    }

    public int getHeight() {
        return this.header.height;
    }

    @java.lang.Deprecated
    public int getLoopCount() {
        int i = this.header.loopCount;
        if (i == -1) {
            return 1;
        }
        return i;
    }

    public int getNetscapeLoopCount() {
        return this.header.loopCount;
    }

    public int getNextDelay() {
        int i;
        if (this.header.frameCount <= 0 || (i = this.framePointer) < 0) {
            return -1;
        }
        return getDelay(i);
    }

    public synchronized android.graphics.Bitmap getNextFrame() {
        if (this.header.frameCount <= 0 || this.framePointer < 0) {
            if (android.util.Log.isLoggable(TAG, 3)) {
                java.lang.StringBuilder tanxu_do2 = tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do("unable to decode frame, frameCount=");
                tanxu_do2.append(this.header.frameCount);
                tanxu_do2.append(" framePointer=");
                tanxu_do2.append(this.framePointer);
            }
            this.status = 1;
        }
        int i = this.status;
        if (i != 1 && i != 2) {
            this.status = 0;
            com.alimm.tanx.ui.image.glide.gifdecoder.GifFrame gifFrame = this.header.frames.get(this.framePointer);
            int i2 = this.framePointer - 1;
            com.alimm.tanx.ui.image.glide.gifdecoder.GifFrame gifFrame2 = i2 >= 0 ? this.header.frames.get(i2) : null;
            int[] iArr = gifFrame.lct;
            if (iArr == null) {
                iArr = this.header.gct;
            }
            this.act = iArr;
            if (iArr == null) {
                android.util.Log.isLoggable(TAG, 3);
                this.status = 1;
                return null;
            }
            if (gifFrame.transparency) {
                java.lang.System.arraycopy(iArr, 0, this.pct, 0, iArr.length);
                int[] iArr2 = this.pct;
                this.act = iArr2;
                iArr2[gifFrame.transIndex] = 0;
            }
            return setPixels(gifFrame, gifFrame2);
        }
        if (android.util.Log.isLoggable(TAG, 3)) {
            tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do.tanxu_do("Unable to decode frame, status=").append(this.status);
        }
        return null;
    }

    public int getStatus() {
        return this.status;
    }

    public int getTotalIterationCount() {
        int i = this.header.loopCount;
        if (i == -1) {
            return 1;
        }
        if (i == 0) {
            return 0;
        }
        return i + 1;
    }

    public int getWidth() {
        return this.header.width;
    }

    public int read(java.io.InputStream inputStream, int i) {
        if (inputStream != null) {
            try {
                java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(i > 0 ? i + 4096 : 16384);
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr, 0, 16384);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.flush();
                read(byteArrayOutputStream.toByteArray());
            } catch (java.io.IOException unused) {
            }
        } else {
            this.status = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (java.io.IOException unused2) {
            }
        }
        return this.status;
    }

    public int read(byte[] bArr) {
        this.data = bArr;
        this.header = getHeaderParser().setData(bArr).parseHeader();
        if (bArr != null) {
            java.nio.ByteBuffer wrap = java.nio.ByteBuffer.wrap(bArr);
            this.rawData = wrap;
            wrap.rewind();
            this.rawData.order(java.nio.ByteOrder.LITTLE_ENDIAN);
            com.alimm.tanx.ui.image.glide.gifdecoder.GifHeader gifHeader = this.header;
            int i = gifHeader.width * gifHeader.height;
            this.mainPixels = new byte[i];
            this.mainScratch = new int[i];
            this.savePrevious = false;
            java.util.Iterator<com.alimm.tanx.ui.image.glide.gifdecoder.GifFrame> it = gifHeader.frames.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (it.next().dispose == 3) {
                    this.savePrevious = true;
                    break;
                }
            }
        }
        return this.status;
    }

    public void resetFrameIndex() {
        this.framePointer = -1;
    }

    public void setData(com.alimm.tanx.ui.image.glide.gifdecoder.GifHeader gifHeader, byte[] bArr) {
        this.header = gifHeader;
        this.data = bArr;
        this.status = 0;
        this.framePointer = -1;
        java.nio.ByteBuffer wrap = java.nio.ByteBuffer.wrap(bArr);
        this.rawData = wrap;
        wrap.rewind();
        this.rawData.order(java.nio.ByteOrder.LITTLE_ENDIAN);
        this.savePrevious = false;
        java.util.Iterator<com.alimm.tanx.ui.image.glide.gifdecoder.GifFrame> it = gifHeader.frames.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().dispose == 3) {
                this.savePrevious = true;
                break;
            }
        }
        int i = gifHeader.width * gifHeader.height;
        this.mainPixels = new byte[i];
        this.mainScratch = new int[i];
    }
}
