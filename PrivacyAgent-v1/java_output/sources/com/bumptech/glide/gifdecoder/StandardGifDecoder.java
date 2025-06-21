package com.bumptech.glide.gifdecoder;

/* loaded from: classes.dex */
public class StandardGifDecoder implements com.bumptech.glide.gifdecoder.GifDecoder {
    private static final int BYTES_PER_INTEGER = 4;

    @androidx.annotation.ColorInt
    private static final int COLOR_TRANSPARENT_BLACK = 0;
    private static final int INITIAL_FRAME_POINTER = -1;
    private static final int MASK_INT_LOWEST_BYTE = 255;
    private static final int MAX_STACK_SIZE = 4096;
    private static final int NULL_CODE = -1;
    private static final java.lang.String TAG = "StandardGifDecoder";

    @androidx.annotation.ColorInt
    private int[] act;

    @androidx.annotation.NonNull
    private android.graphics.Bitmap.Config bitmapConfig;
    private final com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider bitmapProvider;
    private byte[] block;
    private int downsampledHeight;
    private int downsampledWidth;
    private int framePointer;
    private com.bumptech.glide.gifdecoder.GifHeader header;

    @androidx.annotation.Nullable
    private java.lang.Boolean isFirstFrameTransparent;
    private byte[] mainPixels;

    @androidx.annotation.ColorInt
    private int[] mainScratch;
    private com.bumptech.glide.gifdecoder.GifHeaderParser parser;

    @androidx.annotation.ColorInt
    private final int[] pct;
    private byte[] pixelStack;
    private short[] prefix;
    private android.graphics.Bitmap previousImage;
    private java.nio.ByteBuffer rawData;
    private int sampleSize;
    private boolean savePrevious;
    private int status;
    private byte[] suffix;

    public StandardGifDecoder(@androidx.annotation.NonNull com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider bitmapProvider) {
        this.pct = new int[256];
        this.bitmapConfig = android.graphics.Bitmap.Config.ARGB_8888;
        this.bitmapProvider = bitmapProvider;
        this.header = new com.bumptech.glide.gifdecoder.GifHeader();
    }

    public StandardGifDecoder(@androidx.annotation.NonNull com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider bitmapProvider, com.bumptech.glide.gifdecoder.GifHeader gifHeader, java.nio.ByteBuffer byteBuffer) {
        this(bitmapProvider, gifHeader, byteBuffer, 1);
    }

    public StandardGifDecoder(@androidx.annotation.NonNull com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider bitmapProvider, com.bumptech.glide.gifdecoder.GifHeader gifHeader, java.nio.ByteBuffer byteBuffer, int i) {
        this(bitmapProvider);
        setData(gifHeader, byteBuffer, i);
    }

    @androidx.annotation.ColorInt
    private int averageColorsNear(int i, int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = i; i9 < this.sampleSize + i; i9++) {
            byte[] bArr = this.mainPixels;
            if (i9 >= bArr.length || i9 >= i2) {
                break;
            }
            int i10 = this.act[bArr[i9] & 255];
            if (i10 != 0) {
                i4 += (i10 >> 24) & 255;
                i5 += (i10 >> 16) & 255;
                i6 += (i10 >> 8) & 255;
                i7 += i10 & 255;
                i8++;
            }
        }
        int i11 = i + i3;
        for (int i12 = i11; i12 < this.sampleSize + i11; i12++) {
            byte[] bArr2 = this.mainPixels;
            if (i12 >= bArr2.length || i12 >= i2) {
                break;
            }
            int i13 = this.act[bArr2[i12] & 255];
            if (i13 != 0) {
                i4 += (i13 >> 24) & 255;
                i5 += (i13 >> 16) & 255;
                i6 += (i13 >> 8) & 255;
                i7 += i13 & 255;
                i8++;
            }
        }
        if (i8 == 0) {
            return 0;
        }
        return ((i4 / i8) << 24) | ((i5 / i8) << 16) | ((i6 / i8) << 8) | (i7 / i8);
    }

    private void copyCopyIntoScratchRobust(com.bumptech.glide.gifdecoder.GifFrame gifFrame) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int[] iArr = this.mainScratch;
        int i6 = gifFrame.ih;
        int i7 = this.sampleSize;
        int i8 = i6 / i7;
        int i9 = gifFrame.iy / i7;
        int i10 = gifFrame.iw / i7;
        int i11 = gifFrame.ix / i7;
        boolean z = this.framePointer == 0;
        int i12 = this.downsampledWidth;
        int i13 = this.downsampledHeight;
        byte[] bArr = this.mainPixels;
        int[] iArr2 = this.act;
        java.lang.Boolean bool = this.isFirstFrameTransparent;
        int i14 = 8;
        int i15 = 0;
        int i16 = 0;
        int i17 = 1;
        while (i16 < i8) {
            java.lang.Boolean bool2 = bool;
            if (gifFrame.interlace) {
                if (i15 >= i8) {
                    int i18 = i17 + 1;
                    i = i8;
                    if (i18 == 2) {
                        i17 = i18;
                        i15 = 4;
                    } else if (i18 == 3) {
                        i17 = i18;
                        i15 = 2;
                        i14 = 4;
                    } else if (i18 != 4) {
                        i17 = i18;
                    } else {
                        i17 = i18;
                        i15 = 1;
                        i14 = 2;
                    }
                } else {
                    i = i8;
                }
                i2 = i15 + i14;
            } else {
                i = i8;
                i2 = i15;
                i15 = i16;
            }
            int i19 = i15 + i9;
            boolean z2 = i7 == 1;
            if (i19 < i13) {
                int i20 = i19 * i12;
                int i21 = i20 + i11;
                int i22 = i21 + i10;
                int i23 = i20 + i12;
                if (i23 < i22) {
                    i22 = i23;
                }
                i3 = i2;
                int i24 = i16 * i7 * gifFrame.iw;
                if (z2) {
                    int i25 = i21;
                    while (i25 < i22) {
                        int i26 = i9;
                        int i27 = iArr2[bArr[i24] & 255];
                        if (i27 != 0) {
                            iArr[i25] = i27;
                        } else if (z && bool2 == null) {
                            bool2 = java.lang.Boolean.TRUE;
                        }
                        i24 += i7;
                        i25++;
                        i9 = i26;
                    }
                } else {
                    i5 = i9;
                    int i28 = ((i22 - i21) * i7) + i24;
                    int i29 = i21;
                    while (true) {
                        i4 = i10;
                        if (i29 < i22) {
                            int averageColorsNear = averageColorsNear(i24, i28, gifFrame.iw);
                            if (averageColorsNear != 0) {
                                iArr[i29] = averageColorsNear;
                            } else if (z && bool2 == null) {
                                bool2 = java.lang.Boolean.TRUE;
                            }
                            i24 += i7;
                            i29++;
                            i10 = i4;
                        }
                    }
                    bool = bool2;
                    i16++;
                    i9 = i5;
                    i8 = i;
                    i10 = i4;
                    i15 = i3;
                }
            } else {
                i3 = i2;
            }
            i5 = i9;
            i4 = i10;
            bool = bool2;
            i16++;
            i9 = i5;
            i8 = i;
            i10 = i4;
            i15 = i3;
        }
        java.lang.Boolean bool3 = bool;
        if (this.isFirstFrameTransparent == null) {
            this.isFirstFrameTransparent = java.lang.Boolean.valueOf(bool3 == null ? false : bool3.booleanValue());
        }
    }

    private void copyIntoScratchFast(com.bumptech.glide.gifdecoder.GifFrame gifFrame) {
        com.bumptech.glide.gifdecoder.GifFrame gifFrame2 = gifFrame;
        int[] iArr = this.mainScratch;
        int i = gifFrame2.ih;
        int i2 = gifFrame2.iy;
        int i3 = gifFrame2.iw;
        int i4 = gifFrame2.ix;
        boolean z = this.framePointer == 0;
        int i5 = this.downsampledWidth;
        byte[] bArr = this.mainPixels;
        int[] iArr2 = this.act;
        int i6 = 0;
        byte b = -1;
        while (i6 < i) {
            int i7 = (i6 + i2) * i5;
            int i8 = i7 + i4;
            int i9 = i8 + i3;
            int i10 = i7 + i5;
            if (i10 < i9) {
                i9 = i10;
            }
            int i11 = gifFrame2.iw * i6;
            int i12 = i8;
            while (i12 < i9) {
                byte b2 = bArr[i11];
                int i13 = i;
                int i14 = b2 & 255;
                if (i14 != b) {
                    int i15 = iArr2[i14];
                    if (i15 != 0) {
                        iArr[i12] = i15;
                    } else {
                        b = b2;
                    }
                }
                i11++;
                i12++;
                i = i13;
            }
            i6++;
            gifFrame2 = gifFrame;
        }
        java.lang.Boolean bool = this.isFirstFrameTransparent;
        this.isFirstFrameTransparent = java.lang.Boolean.valueOf((bool != null && bool.booleanValue()) || (this.isFirstFrameTransparent == null && z && b != -1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v15, types: [short] */
    /* JADX WARN: Type inference failed for: r7v17 */
    private void decodeBitmapData(com.bumptech.glide.gifdecoder.GifFrame gifFrame) {
        int i;
        int i2;
        short s2;
        com.bumptech.glide.gifdecoder.StandardGifDecoder standardGifDecoder = this;
        if (gifFrame != null) {
            standardGifDecoder.rawData.position(gifFrame.bufferFrameStart);
        }
        if (gifFrame == null) {
            com.bumptech.glide.gifdecoder.GifHeader gifHeader = standardGifDecoder.header;
            i = gifHeader.width;
            i2 = gifHeader.height;
        } else {
            i = gifFrame.iw;
            i2 = gifFrame.ih;
        }
        int i3 = i * i2;
        byte[] bArr = standardGifDecoder.mainPixels;
        if (bArr == null || bArr.length < i3) {
            standardGifDecoder.mainPixels = standardGifDecoder.bitmapProvider.obtainByteArray(i3);
        }
        byte[] bArr2 = standardGifDecoder.mainPixels;
        if (standardGifDecoder.prefix == null) {
            standardGifDecoder.prefix = new short[4096];
        }
        short[] sArr = standardGifDecoder.prefix;
        if (standardGifDecoder.suffix == null) {
            standardGifDecoder.suffix = new byte[4096];
        }
        byte[] bArr3 = standardGifDecoder.suffix;
        if (standardGifDecoder.pixelStack == null) {
            standardGifDecoder.pixelStack = new byte[4097];
        }
        byte[] bArr4 = standardGifDecoder.pixelStack;
        int readByte = readByte();
        int i4 = 1 << readByte;
        int i5 = i4 + 1;
        int i6 = i4 + 2;
        int i7 = readByte + 1;
        int i8 = (1 << i7) - 1;
        int i9 = 0;
        for (int i10 = 0; i10 < i4; i10++) {
            sArr[i10] = 0;
            bArr3[i10] = (byte) i10;
        }
        byte[] bArr5 = standardGifDecoder.block;
        int i11 = i7;
        int i12 = i6;
        int i13 = i8;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = -1;
        int i20 = 0;
        int i21 = 0;
        while (true) {
            if (i9 >= i3) {
                break;
            }
            if (i14 == 0) {
                i14 = readBlock();
                if (i14 <= 0) {
                    standardGifDecoder.status = 3;
                    break;
                }
                i15 = 0;
            }
            i17 += (bArr5[i15] & 255) << i16;
            i15++;
            i14--;
            int i22 = i16 + 8;
            int i23 = i12;
            int i24 = i11;
            int i25 = i19;
            int i26 = i7;
            int i27 = i20;
            while (true) {
                if (i22 < i24) {
                    i19 = i25;
                    i12 = i23;
                    i16 = i22;
                    standardGifDecoder = this;
                    i20 = i27;
                    i7 = i26;
                    i11 = i24;
                    break;
                }
                int i28 = i6;
                int i29 = i17 & i13;
                i17 >>= i24;
                i22 -= i24;
                if (i29 == i4) {
                    i13 = i8;
                    i24 = i26;
                    i23 = i28;
                    i6 = i23;
                    i25 = -1;
                } else {
                    if (i29 == i5) {
                        i16 = i22;
                        i20 = i27;
                        i12 = i23;
                        i7 = i26;
                        i6 = i28;
                        i19 = i25;
                        i11 = i24;
                        standardGifDecoder = this;
                        break;
                    }
                    if (i25 == -1) {
                        bArr2[i18] = bArr3[i29];
                        i18++;
                        i9++;
                        i25 = i29;
                        i27 = i25;
                        i6 = i28;
                        i22 = i22;
                    } else {
                        if (i29 >= i23) {
                            bArr4[i21] = (byte) i27;
                            i21++;
                            s2 = i25;
                        } else {
                            s2 = i29;
                        }
                        while (s2 >= i4) {
                            bArr4[i21] = bArr3[s2];
                            i21++;
                            s2 = sArr[s2];
                        }
                        i27 = bArr3[s2] & 255;
                        byte b = (byte) i27;
                        bArr2[i18] = b;
                        while (true) {
                            i18++;
                            i9++;
                            if (i21 <= 0) {
                                break;
                            }
                            i21--;
                            bArr2[i18] = bArr4[i21];
                        }
                        byte[] bArr6 = bArr4;
                        if (i23 < 4096) {
                            sArr[i23] = (short) i25;
                            bArr3[i23] = b;
                            i23++;
                            if ((i23 & i13) == 0 && i23 < 4096) {
                                i24++;
                                i13 += i23;
                            }
                        }
                        i25 = i29;
                        i6 = i28;
                        i22 = i22;
                        bArr4 = bArr6;
                    }
                }
            }
        }
        java.util.Arrays.fill(bArr2, i18, i3, (byte) 0);
    }

    @androidx.annotation.NonNull
    private com.bumptech.glide.gifdecoder.GifHeaderParser getHeaderParser() {
        if (this.parser == null) {
            this.parser = new com.bumptech.glide.gifdecoder.GifHeaderParser();
        }
        return this.parser;
    }

    private android.graphics.Bitmap getNextBitmap() {
        java.lang.Boolean bool = this.isFirstFrameTransparent;
        android.graphics.Bitmap obtain = this.bitmapProvider.obtain(this.downsampledWidth, this.downsampledHeight, (bool == null || bool.booleanValue()) ? android.graphics.Bitmap.Config.ARGB_8888 : this.bitmapConfig);
        obtain.setHasAlpha(true);
        return obtain;
    }

    private int readBlock() {
        int readByte = readByte();
        if (readByte <= 0) {
            return readByte;
        }
        java.nio.ByteBuffer byteBuffer = this.rawData;
        byteBuffer.get(this.block, 0, java.lang.Math.min(readByte, byteBuffer.remaining()));
        return readByte;
    }

    private int readByte() {
        return this.rawData.get() & 255;
    }

    private android.graphics.Bitmap setPixels(com.bumptech.glide.gifdecoder.GifFrame gifFrame, com.bumptech.glide.gifdecoder.GifFrame gifFrame2) {
        int i;
        int i2;
        android.graphics.Bitmap bitmap;
        int[] iArr = this.mainScratch;
        int i3 = 0;
        if (gifFrame2 == null) {
            android.graphics.Bitmap bitmap2 = this.previousImage;
            if (bitmap2 != null) {
                this.bitmapProvider.release(bitmap2);
            }
            this.previousImage = null;
            java.util.Arrays.fill(iArr, 0);
        }
        if (gifFrame2 != null && gifFrame2.dispose == 3 && this.previousImage == null) {
            java.util.Arrays.fill(iArr, 0);
        }
        if (gifFrame2 != null && (i2 = gifFrame2.dispose) > 0) {
            if (i2 == 2) {
                if (!gifFrame.transparency) {
                    com.bumptech.glide.gifdecoder.GifHeader gifHeader = this.header;
                    int i4 = gifHeader.bgColor;
                    if (gifFrame.lct == null || gifHeader.bgIndex != gifFrame.transIndex) {
                        i3 = i4;
                    }
                }
                int i5 = gifFrame2.ih;
                int i6 = this.sampleSize;
                int i7 = i5 / i6;
                int i8 = gifFrame2.iy / i6;
                int i9 = gifFrame2.iw / i6;
                int i10 = gifFrame2.ix / i6;
                int i11 = this.downsampledWidth;
                int i12 = (i8 * i11) + i10;
                int i13 = (i7 * i11) + i12;
                while (i12 < i13) {
                    int i14 = i12 + i9;
                    for (int i15 = i12; i15 < i14; i15++) {
                        iArr[i15] = i3;
                    }
                    i12 += this.downsampledWidth;
                }
            } else if (i2 == 3 && (bitmap = this.previousImage) != null) {
                int i16 = this.downsampledWidth;
                bitmap.getPixels(iArr, 0, i16, 0, 0, i16, this.downsampledHeight);
            }
        }
        decodeBitmapData(gifFrame);
        if (gifFrame.interlace || this.sampleSize != 1) {
            copyCopyIntoScratchRobust(gifFrame);
        } else {
            copyIntoScratchFast(gifFrame);
        }
        if (this.savePrevious && ((i = gifFrame.dispose) == 0 || i == 1)) {
            if (this.previousImage == null) {
                this.previousImage = getNextBitmap();
            }
            android.graphics.Bitmap bitmap3 = this.previousImage;
            int i17 = this.downsampledWidth;
            bitmap3.setPixels(iArr, 0, i17, 0, 0, i17, this.downsampledHeight);
        }
        android.graphics.Bitmap nextBitmap = getNextBitmap();
        int i18 = this.downsampledWidth;
        nextBitmap.setPixels(iArr, 0, i18, 0, 0, i18, this.downsampledHeight);
        return nextBitmap;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void advance() {
        this.framePointer = (this.framePointer + 1) % this.header.frameCount;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void clear() {
        this.header = null;
        byte[] bArr = this.mainPixels;
        if (bArr != null) {
            this.bitmapProvider.release(bArr);
        }
        int[] iArr = this.mainScratch;
        if (iArr != null) {
            this.bitmapProvider.release(iArr);
        }
        android.graphics.Bitmap bitmap = this.previousImage;
        if (bitmap != null) {
            this.bitmapProvider.release(bitmap);
        }
        this.previousImage = null;
        this.rawData = null;
        this.isFirstFrameTransparent = null;
        byte[] bArr2 = this.block;
        if (bArr2 != null) {
            this.bitmapProvider.release(bArr2);
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getByteSize() {
        return this.rawData.limit() + this.mainPixels.length + (this.mainScratch.length * 4);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getCurrentFrameIndex() {
        return this.framePointer;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @androidx.annotation.NonNull
    public java.nio.ByteBuffer getData() {
        return this.rawData;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getDelay(int i) {
        if (i >= 0) {
            com.bumptech.glide.gifdecoder.GifHeader gifHeader = this.header;
            if (i < gifHeader.frameCount) {
                return gifHeader.frames.get(i).delay;
            }
        }
        return -1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getFrameCount() {
        return this.header.frameCount;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getHeight() {
        return this.header.height;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @java.lang.Deprecated
    public int getLoopCount() {
        int i = this.header.loopCount;
        if (i == -1) {
            return 1;
        }
        return i;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getNetscapeLoopCount() {
        return this.header.loopCount;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getNextDelay() {
        int i;
        if (this.header.frameCount <= 0 || (i = this.framePointer) < 0) {
            return 0;
        }
        return getDelay(i);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @androidx.annotation.Nullable
    public synchronized android.graphics.Bitmap getNextFrame() {
        if (this.header.frameCount <= 0 || this.framePointer < 0) {
            if (android.util.Log.isLoggable(TAG, 3)) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Unable to decode frame, frameCount=");
                sb.append(this.header.frameCount);
                sb.append(", framePointer=");
                sb.append(this.framePointer);
            }
            this.status = 1;
        }
        int i = this.status;
        if (i != 1 && i != 2) {
            this.status = 0;
            if (this.block == null) {
                this.block = this.bitmapProvider.obtainByteArray(255);
            }
            com.bumptech.glide.gifdecoder.GifFrame gifFrame = this.header.frames.get(this.framePointer);
            int i2 = this.framePointer - 1;
            com.bumptech.glide.gifdecoder.GifFrame gifFrame2 = i2 >= 0 ? this.header.frames.get(i2) : null;
            int[] iArr = gifFrame.lct;
            if (iArr == null) {
                iArr = this.header.gct;
            }
            this.act = iArr;
            if (iArr == null) {
                if (android.util.Log.isLoggable(TAG, 3)) {
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append("No valid color table found for frame #");
                    sb2.append(this.framePointer);
                }
                this.status = 1;
                return null;
            }
            if (gifFrame.transparency) {
                java.lang.System.arraycopy(iArr, 0, this.pct, 0, iArr.length);
                int[] iArr2 = this.pct;
                this.act = iArr2;
                iArr2[gifFrame.transIndex] = 0;
                if (gifFrame.dispose == 2 && this.framePointer == 0) {
                    this.isFirstFrameTransparent = java.lang.Boolean.TRUE;
                }
            }
            return setPixels(gifFrame, gifFrame2);
        }
        if (android.util.Log.isLoggable(TAG, 3)) {
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
            sb3.append("Unable to decode frame, status=");
            sb3.append(this.status);
        }
        return null;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getStatus() {
        return this.status;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
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

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getWidth() {
        return this.header.width;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int read(@androidx.annotation.Nullable java.io.InputStream inputStream, int i) {
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

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized int read(@androidx.annotation.Nullable byte[] bArr) {
        com.bumptech.glide.gifdecoder.GifHeader parseHeader = getHeaderParser().setData(bArr).parseHeader();
        this.header = parseHeader;
        if (bArr != null) {
            setData(parseHeader, bArr);
        }
        return this.status;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void resetFrameIndex() {
        this.framePointer = -1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void setData(@androidx.annotation.NonNull com.bumptech.glide.gifdecoder.GifHeader gifHeader, @androidx.annotation.NonNull java.nio.ByteBuffer byteBuffer) {
        setData(gifHeader, byteBuffer, 1);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void setData(@androidx.annotation.NonNull com.bumptech.glide.gifdecoder.GifHeader gifHeader, @androidx.annotation.NonNull java.nio.ByteBuffer byteBuffer, int i) {
        if (i <= 0) {
            throw new java.lang.IllegalArgumentException("Sample size must be >=0, not: " + i);
        }
        int highestOneBit = java.lang.Integer.highestOneBit(i);
        this.status = 0;
        this.header = gifHeader;
        this.framePointer = -1;
        java.nio.ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.rawData = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.rawData.order(java.nio.ByteOrder.LITTLE_ENDIAN);
        this.savePrevious = false;
        java.util.Iterator<com.bumptech.glide.gifdecoder.GifFrame> it = gifHeader.frames.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().dispose == 3) {
                this.savePrevious = true;
                break;
            }
        }
        this.sampleSize = highestOneBit;
        int i2 = gifHeader.width;
        this.downsampledWidth = i2 / highestOneBit;
        int i3 = gifHeader.height;
        this.downsampledHeight = i3 / highestOneBit;
        this.mainPixels = this.bitmapProvider.obtainByteArray(i2 * i3);
        this.mainScratch = this.bitmapProvider.obtainIntArray(this.downsampledWidth * this.downsampledHeight);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void setData(@androidx.annotation.NonNull com.bumptech.glide.gifdecoder.GifHeader gifHeader, @androidx.annotation.NonNull byte[] bArr) {
        setData(gifHeader, java.nio.ByteBuffer.wrap(bArr));
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void setDefaultBitmapConfig(@androidx.annotation.NonNull android.graphics.Bitmap.Config config) {
        if (config == android.graphics.Bitmap.Config.ARGB_8888 || config == android.graphics.Bitmap.Config.RGB_565) {
            this.bitmapConfig = config;
            return;
        }
        throw new java.lang.IllegalArgumentException("Unsupported format: " + config + ", must be one of " + android.graphics.Bitmap.Config.ARGB_8888 + " or " + android.graphics.Bitmap.Config.RGB_565);
    }
}
