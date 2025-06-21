package com.google.android.exoplayer2.text.dvb;

/* loaded from: classes22.dex */
final class DvbParser {
    public static final byte[] h = {0, 7, 8, 15};
    public static final byte[] i = {0, 119, -120, -1};
    public static final byte[] j = {0, 17, 34, org.apache.tools.tar.TarConstants.LF_CHR, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    public final android.graphics.Paint a;
    public final android.graphics.Paint b;
    public final android.graphics.Canvas c;
    public final com.google.android.exoplayer2.text.dvb.DvbParser.DisplayDefinition d;
    public final com.google.android.exoplayer2.text.dvb.DvbParser.ClutDefinition e;
    public final com.google.android.exoplayer2.text.dvb.DvbParser.SubtitleService f;
    public android.graphics.Bitmap g;

    public static final class ClutDefinition {
        public final int a;
        public final int[] b;
        public final int[] c;
        public final int[] d;

        public ClutDefinition(int i, int[] iArr, int[] iArr2, int[] iArr3) {
            this.a = i;
            this.b = iArr;
            this.c = iArr2;
            this.d = iArr3;
        }
    }

    public static final class DisplayDefinition {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;

        public DisplayDefinition(int i, int i2, int i3, int i4, int i5, int i6) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
        }
    }

    public static final class ObjectData {
        public final int a;
        public final boolean b;
        public final byte[] c;
        public final byte[] d;

        public ObjectData(int i, boolean z, byte[] bArr, byte[] bArr2) {
            this.a = i;
            this.b = z;
            this.c = bArr;
            this.d = bArr2;
        }
    }

    public static final class PageComposition {
        public final int a;
        public final int b;
        public final int c;
        public final android.util.SparseArray<com.google.android.exoplayer2.text.dvb.DvbParser.PageRegion> d;

        public PageComposition(int i, int i2, int i3, android.util.SparseArray<com.google.android.exoplayer2.text.dvb.DvbParser.PageRegion> sparseArray) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = sparseArray;
        }
    }

    public static final class PageRegion {
        public final int a;
        public final int b;

        public PageRegion(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    public static final class RegionComposition {
        public final int a;
        public final boolean b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final int i;
        public final int j;
        public final android.util.SparseArray<com.google.android.exoplayer2.text.dvb.DvbParser.RegionObject> k;

        public RegionComposition(int i, boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, android.util.SparseArray<com.google.android.exoplayer2.text.dvb.DvbParser.RegionObject> sparseArray) {
            this.a = i;
            this.b = z;
            this.c = i2;
            this.d = i3;
            this.e = i4;
            this.f = i5;
            this.g = i6;
            this.h = i7;
            this.i = i8;
            this.j = i9;
            this.k = sparseArray;
        }

        public void a(com.google.android.exoplayer2.text.dvb.DvbParser.RegionComposition regionComposition) {
            android.util.SparseArray<com.google.android.exoplayer2.text.dvb.DvbParser.RegionObject> sparseArray = regionComposition.k;
            for (int i = 0; i < sparseArray.size(); i++) {
                this.k.put(sparseArray.keyAt(i), sparseArray.valueAt(i));
            }
        }
    }

    public static final class RegionObject {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;

        public RegionObject(int i, int i2, int i3, int i4, int i5, int i6) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
        }
    }

    public static final class SubtitleService {
        public final int a;
        public final int b;
        public final android.util.SparseArray<com.google.android.exoplayer2.text.dvb.DvbParser.RegionComposition> c = new android.util.SparseArray<>();
        public final android.util.SparseArray<com.google.android.exoplayer2.text.dvb.DvbParser.ClutDefinition> d = new android.util.SparseArray<>();
        public final android.util.SparseArray<com.google.android.exoplayer2.text.dvb.DvbParser.ObjectData> e = new android.util.SparseArray<>();
        public final android.util.SparseArray<com.google.android.exoplayer2.text.dvb.DvbParser.ClutDefinition> f = new android.util.SparseArray<>();
        public final android.util.SparseArray<com.google.android.exoplayer2.text.dvb.DvbParser.ObjectData> g = new android.util.SparseArray<>();

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.text.dvb.DvbParser.DisplayDefinition h;

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.text.dvb.DvbParser.PageComposition i;

        public SubtitleService(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public void a() {
            this.c.clear();
            this.d.clear();
            this.e.clear();
            this.f.clear();
            this.g.clear();
            this.h = null;
            this.i = null;
        }
    }

    public DvbParser(int i2, int i3) {
        android.graphics.Paint paint = new android.graphics.Paint();
        this.a = paint;
        paint.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        android.graphics.Paint paint2 = new android.graphics.Paint();
        this.b = paint2;
        paint2.setStyle(android.graphics.Paint.Style.FILL);
        paint2.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.c = new android.graphics.Canvas();
        this.d = new com.google.android.exoplayer2.text.dvb.DvbParser.DisplayDefinition(719, 575, 0, 719, 0, 575);
        this.e = new com.google.android.exoplayer2.text.dvb.DvbParser.ClutDefinition(0, c(), d(), e());
        this.f = new com.google.android.exoplayer2.text.dvb.DvbParser.SubtitleService(i2, i3);
    }

    public static byte[] a(int i2, int i3, com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray) {
        byte[] bArr = new byte[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            bArr[i4] = (byte) parsableBitArray.readBits(i3);
        }
        return bArr;
    }

    public static int[] c() {
        return new int[]{0, -1, androidx.core.view.ViewCompat.MEASURED_STATE_MASK, -8421505};
    }

    public static int[] d() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i2 = 1; i2 < 16; i2++) {
            if (i2 < 8) {
                iArr[i2] = f(255, (i2 & 1) != 0 ? 255 : 0, (i2 & 2) != 0 ? 255 : 0, (i2 & 4) != 0 ? 255 : 0);
            } else {
                iArr[i2] = f(255, (i2 & 1) != 0 ? 127 : 0, (i2 & 2) != 0 ? 127 : 0, (i2 & 4) == 0 ? 0 : 127);
            }
        }
        return iArr;
    }

    public static int[] e() {
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            if (i2 < 8) {
                iArr[i2] = f(63, (i2 & 1) != 0 ? 255 : 0, (i2 & 2) != 0 ? 255 : 0, (i2 & 4) == 0 ? 0 : 255);
            } else {
                int i3 = i2 & com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.CALL_DOWNLOAD_MODEL_SET_PACKAGE_NAME;
                if (i3 == 0) {
                    iArr[i2] = f(255, ((i2 & 1) != 0 ? 85 : 0) + ((i2 & 16) != 0 ? 170 : 0), ((i2 & 2) != 0 ? 85 : 0) + ((i2 & 32) != 0 ? 170 : 0), ((i2 & 4) == 0 ? 0 : 85) + ((i2 & 64) == 0 ? 0 : 170));
                } else if (i3 == 8) {
                    iArr[i2] = f(127, ((i2 & 1) != 0 ? 85 : 0) + ((i2 & 16) != 0 ? 170 : 0), ((i2 & 2) != 0 ? 85 : 0) + ((i2 & 32) != 0 ? 170 : 0), ((i2 & 4) == 0 ? 0 : 85) + ((i2 & 64) == 0 ? 0 : 170));
                } else if (i3 == 128) {
                    iArr[i2] = f(255, ((i2 & 1) != 0 ? 43 : 0) + 127 + ((i2 & 16) != 0 ? 85 : 0), ((i2 & 2) != 0 ? 43 : 0) + 127 + ((i2 & 32) != 0 ? 85 : 0), ((i2 & 4) == 0 ? 0 : 43) + 127 + ((i2 & 64) == 0 ? 0 : 85));
                } else if (i3 == 136) {
                    iArr[i2] = f(255, ((i2 & 1) != 0 ? 43 : 0) + ((i2 & 16) != 0 ? 85 : 0), ((i2 & 2) != 0 ? 43 : 0) + ((i2 & 32) != 0 ? 85 : 0), ((i2 & 4) == 0 ? 0 : 43) + ((i2 & 64) == 0 ? 0 : 85));
                }
            }
        }
        return iArr;
    }

    public static int f(int i2, int i3, int i4, int i5) {
        return (i2 << 24) | (i3 << 16) | (i4 << 8) | i5;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0083 A[LOOP:0: B:2:0x0009->B:13:0x0083, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0082 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0063 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int g(com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray, int[] iArr, @androidx.annotation.Nullable byte[] bArr, int i2, int i3, @androidx.annotation.Nullable android.graphics.Paint paint, android.graphics.Canvas canvas) {
        boolean z;
        int i4;
        int readBits;
        int readBits2;
        int i5 = i2;
        boolean z2 = false;
        while (true) {
            int readBits3 = parsableBitArray.readBits(2);
            if (readBits3 != 0) {
                z = z2;
            } else {
                if (parsableBitArray.readBit()) {
                    readBits = parsableBitArray.readBits(3) + 3;
                    readBits2 = parsableBitArray.readBits(2);
                } else if (parsableBitArray.readBit()) {
                    z = z2;
                    readBits3 = 0;
                } else {
                    int readBits4 = parsableBitArray.readBits(2);
                    if (readBits4 == 0) {
                        readBits3 = 0;
                        z = true;
                    } else if (readBits4 == 1) {
                        z = z2;
                        readBits3 = 0;
                        i4 = 2;
                        if (i4 != 0 && paint != null) {
                            if (bArr != null) {
                                readBits3 = bArr[readBits3];
                            }
                            paint.setColor(iArr[readBits3]);
                            canvas.drawRect(i5, i3, i5 + i4, i3 + 1, paint);
                        }
                        i5 += i4;
                        if (!z) {
                            return i5;
                        }
                        z2 = z;
                    } else if (readBits4 == 2) {
                        readBits = parsableBitArray.readBits(4) + 12;
                        readBits2 = parsableBitArray.readBits(2);
                    } else if (readBits4 != 3) {
                        z = z2;
                        readBits3 = 0;
                    } else {
                        readBits = parsableBitArray.readBits(8) + 29;
                        readBits2 = parsableBitArray.readBits(2);
                    }
                    i4 = 0;
                    if (i4 != 0) {
                        if (bArr != null) {
                        }
                        paint.setColor(iArr[readBits3]);
                        canvas.drawRect(i5, i3, i5 + i4, i3 + 1, paint);
                    }
                    i5 += i4;
                    if (!z) {
                    }
                }
                z = z2;
                i4 = readBits;
                readBits3 = readBits2;
                if (i4 != 0) {
                }
                i5 += i4;
                if (!z) {
                }
            }
            i4 = 1;
            if (i4 != 0) {
            }
            i5 += i4;
            if (!z) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0090 A[LOOP:0: B:2:0x0009->B:13:0x0090, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x008f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int h(com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray, int[] iArr, @androidx.annotation.Nullable byte[] bArr, int i2, int i3, @androidx.annotation.Nullable android.graphics.Paint paint, android.graphics.Canvas canvas) {
        boolean z;
        int i4;
        int readBits;
        int readBits2;
        int i5 = i2;
        boolean z2 = false;
        while (true) {
            int readBits3 = parsableBitArray.readBits(4);
            if (readBits3 != 0) {
                z = z2;
            } else {
                if (parsableBitArray.readBit()) {
                    if (parsableBitArray.readBit()) {
                        int readBits4 = parsableBitArray.readBits(2);
                        if (readBits4 == 0) {
                            z = z2;
                            readBits3 = 0;
                        } else if (readBits4 == 1) {
                            z = z2;
                            readBits3 = 0;
                            i4 = 2;
                        } else if (readBits4 == 2) {
                            readBits = parsableBitArray.readBits(4) + 9;
                            readBits2 = parsableBitArray.readBits(4);
                        } else if (readBits4 != 3) {
                            z = z2;
                            readBits3 = 0;
                            i4 = 0;
                        } else {
                            readBits = parsableBitArray.readBits(8) + 25;
                            readBits2 = parsableBitArray.readBits(4);
                        }
                    } else {
                        readBits = parsableBitArray.readBits(2) + 4;
                        readBits2 = parsableBitArray.readBits(4);
                    }
                    z = z2;
                    i4 = readBits;
                    readBits3 = readBits2;
                } else {
                    int readBits5 = parsableBitArray.readBits(3);
                    if (readBits5 != 0) {
                        z = z2;
                        i4 = readBits5 + 2;
                        readBits3 = 0;
                    } else {
                        readBits3 = 0;
                        z = true;
                        i4 = 0;
                    }
                }
                if (i4 != 0 && paint != null) {
                    if (bArr != null) {
                        readBits3 = bArr[readBits3];
                    }
                    paint.setColor(iArr[readBits3]);
                    canvas.drawRect(i5, i3, i5 + i4, i3 + 1, paint);
                }
                i5 += i4;
                if (!z) {
                    return i5;
                }
                z2 = z;
            }
            i4 = 1;
            if (i4 != 0) {
                if (bArr != null) {
                }
                paint.setColor(iArr[readBits3]);
                canvas.drawRect(i5, i3, i5 + i4, i3 + 1, paint);
            }
            i5 += i4;
            if (!z) {
            }
        }
    }

    public static int i(com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray, int[] iArr, @androidx.annotation.Nullable byte[] bArr, int i2, int i3, @androidx.annotation.Nullable android.graphics.Paint paint, android.graphics.Canvas canvas) {
        boolean z;
        int readBits;
        int i4 = i2;
        boolean z2 = false;
        while (true) {
            int readBits2 = parsableBitArray.readBits(8);
            if (readBits2 != 0) {
                z = z2;
                readBits = 1;
            } else if (parsableBitArray.readBit()) {
                z = z2;
                readBits = parsableBitArray.readBits(7);
                readBits2 = parsableBitArray.readBits(8);
            } else {
                int readBits3 = parsableBitArray.readBits(7);
                if (readBits3 != 0) {
                    z = z2;
                    readBits = readBits3;
                    readBits2 = 0;
                } else {
                    readBits2 = 0;
                    z = true;
                    readBits = 0;
                }
            }
            if (readBits != 0 && paint != null) {
                if (bArr != null) {
                    readBits2 = bArr[readBits2];
                }
                paint.setColor(iArr[readBits2]);
                canvas.drawRect(i4, i3, i4 + readBits, i3 + 1, paint);
            }
            i4 += readBits;
            if (z) {
                return i4;
            }
            z2 = z;
        }
    }

    public static void j(byte[] bArr, int[] iArr, int i2, int i3, int i4, @androidx.annotation.Nullable android.graphics.Paint paint, android.graphics.Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        byte[] bArr4;
        com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray = new com.google.android.exoplayer2.util.ParsableBitArray(bArr);
        int i5 = i3;
        int i6 = i4;
        byte[] bArr5 = null;
        byte[] bArr6 = null;
        byte[] bArr7 = null;
        while (parsableBitArray.bitsLeft() != 0) {
            int readBits = parsableBitArray.readBits(8);
            if (readBits != 240) {
                switch (readBits) {
                    case 16:
                        if (i2 != 3) {
                            if (i2 != 2) {
                                bArr2 = null;
                                i5 = g(parsableBitArray, iArr, bArr2, i5, i6, paint, canvas);
                                parsableBitArray.byteAlign();
                                break;
                            } else {
                                bArr3 = bArr7 == null ? h : bArr7;
                            }
                        } else {
                            bArr3 = bArr5 == null ? i : bArr5;
                        }
                        bArr2 = bArr3;
                        i5 = g(parsableBitArray, iArr, bArr2, i5, i6, paint, canvas);
                        parsableBitArray.byteAlign();
                    case 17:
                        if (i2 == 3) {
                            bArr4 = bArr6 == null ? j : bArr6;
                        } else {
                            bArr4 = null;
                        }
                        i5 = h(parsableBitArray, iArr, bArr4, i5, i6, paint, canvas);
                        parsableBitArray.byteAlign();
                        break;
                    case 18:
                        i5 = i(parsableBitArray, iArr, null, i5, i6, paint, canvas);
                        break;
                    default:
                        switch (readBits) {
                            case 32:
                                bArr7 = a(4, 4, parsableBitArray);
                                break;
                            case 33:
                                bArr5 = a(4, 8, parsableBitArray);
                                break;
                            case 34:
                                bArr6 = a(16, 8, parsableBitArray);
                                break;
                        }
                }
            } else {
                i6 += 2;
                i5 = i3;
            }
        }
    }

    public static void k(com.google.android.exoplayer2.text.dvb.DvbParser.ObjectData objectData, com.google.android.exoplayer2.text.dvb.DvbParser.ClutDefinition clutDefinition, int i2, int i3, int i4, @androidx.annotation.Nullable android.graphics.Paint paint, android.graphics.Canvas canvas) {
        int[] iArr = i2 == 3 ? clutDefinition.d : i2 == 2 ? clutDefinition.c : clutDefinition.b;
        j(objectData.c, iArr, i2, i3, i4, paint, canvas);
        j(objectData.d, iArr, i2, i3, i4 + 1, paint, canvas);
    }

    public static com.google.android.exoplayer2.text.dvb.DvbParser.ClutDefinition l(com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray, int i2) {
        int readBits;
        int i3;
        int readBits2;
        int i4;
        int i5;
        int i6 = 8;
        int readBits3 = parsableBitArray.readBits(8);
        parsableBitArray.skipBits(8);
        int i7 = 2;
        int i8 = i2 - 2;
        int[] c = c();
        int[] d = d();
        int[] e = e();
        while (i8 > 0) {
            int readBits4 = parsableBitArray.readBits(i6);
            int readBits5 = parsableBitArray.readBits(i6);
            int i9 = i8 - 2;
            int[] iArr = (readBits5 & 128) != 0 ? c : (readBits5 & 64) != 0 ? d : e;
            if ((readBits5 & 1) != 0) {
                i4 = parsableBitArray.readBits(i6);
                i5 = parsableBitArray.readBits(i6);
                readBits = parsableBitArray.readBits(i6);
                readBits2 = parsableBitArray.readBits(i6);
                i3 = i9 - 4;
            } else {
                int readBits6 = parsableBitArray.readBits(6) << i7;
                int readBits7 = parsableBitArray.readBits(4) << 4;
                readBits = parsableBitArray.readBits(4) << 4;
                i3 = i9 - 2;
                readBits2 = parsableBitArray.readBits(i7) << 6;
                i4 = readBits6;
                i5 = readBits7;
            }
            if (i4 == 0) {
                i5 = 0;
                readBits = 0;
                readBits2 = 255;
            }
            double d2 = i4;
            double d3 = i5 + com.alipay.sdk.m.n.a.g;
            double d4 = readBits + com.alipay.sdk.m.n.a.g;
            iArr[readBits4] = f((byte) (255 - (readBits2 & 255)), com.google.android.exoplayer2.util.Util.constrainValue((int) (d2 + (1.402d * d3)), 0, 255), com.google.android.exoplayer2.util.Util.constrainValue((int) ((d2 - (0.34414d * d4)) - (d3 * 0.71414d)), 0, 255), com.google.android.exoplayer2.util.Util.constrainValue((int) (d2 + (d4 * 1.772d)), 0, 255));
            i8 = i3;
            readBits3 = readBits3;
            i6 = 8;
            i7 = 2;
        }
        return new com.google.android.exoplayer2.text.dvb.DvbParser.ClutDefinition(readBits3, c, d, e);
    }

    public static com.google.android.exoplayer2.text.dvb.DvbParser.DisplayDefinition m(com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray) {
        int i2;
        int i3;
        int i4;
        int i5;
        parsableBitArray.skipBits(4);
        boolean readBit = parsableBitArray.readBit();
        parsableBitArray.skipBits(3);
        int readBits = parsableBitArray.readBits(16);
        int readBits2 = parsableBitArray.readBits(16);
        if (readBit) {
            int readBits3 = parsableBitArray.readBits(16);
            int readBits4 = parsableBitArray.readBits(16);
            int readBits5 = parsableBitArray.readBits(16);
            i3 = parsableBitArray.readBits(16);
            i2 = readBits4;
            i5 = readBits5;
            i4 = readBits3;
        } else {
            i2 = readBits;
            i3 = readBits2;
            i4 = 0;
            i5 = 0;
        }
        return new com.google.android.exoplayer2.text.dvb.DvbParser.DisplayDefinition(readBits, readBits2, i4, i2, i5, i3);
    }

    public static com.google.android.exoplayer2.text.dvb.DvbParser.ObjectData n(com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray) {
        byte[] bArr;
        int readBits = parsableBitArray.readBits(16);
        parsableBitArray.skipBits(4);
        int readBits2 = parsableBitArray.readBits(2);
        boolean readBit = parsableBitArray.readBit();
        parsableBitArray.skipBits(1);
        byte[] bArr2 = com.google.android.exoplayer2.util.Util.EMPTY_BYTE_ARRAY;
        if (readBits2 == 1) {
            parsableBitArray.skipBits(parsableBitArray.readBits(8) * 16);
        } else if (readBits2 == 0) {
            int readBits3 = parsableBitArray.readBits(16);
            int readBits4 = parsableBitArray.readBits(16);
            if (readBits3 > 0) {
                bArr2 = new byte[readBits3];
                parsableBitArray.readBytes(bArr2, 0, readBits3);
            }
            if (readBits4 > 0) {
                bArr = new byte[readBits4];
                parsableBitArray.readBytes(bArr, 0, readBits4);
                return new com.google.android.exoplayer2.text.dvb.DvbParser.ObjectData(readBits, readBit, bArr2, bArr);
            }
        }
        bArr = bArr2;
        return new com.google.android.exoplayer2.text.dvb.DvbParser.ObjectData(readBits, readBit, bArr2, bArr);
    }

    public static com.google.android.exoplayer2.text.dvb.DvbParser.PageComposition o(com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray, int i2) {
        int readBits = parsableBitArray.readBits(8);
        int readBits2 = parsableBitArray.readBits(4);
        int readBits3 = parsableBitArray.readBits(2);
        parsableBitArray.skipBits(2);
        int i3 = i2 - 2;
        android.util.SparseArray sparseArray = new android.util.SparseArray();
        while (i3 > 0) {
            int readBits4 = parsableBitArray.readBits(8);
            parsableBitArray.skipBits(8);
            i3 -= 6;
            sparseArray.put(readBits4, new com.google.android.exoplayer2.text.dvb.DvbParser.PageRegion(parsableBitArray.readBits(16), parsableBitArray.readBits(16)));
        }
        return new com.google.android.exoplayer2.text.dvb.DvbParser.PageComposition(readBits, readBits2, readBits3, sparseArray);
    }

    public static com.google.android.exoplayer2.text.dvb.DvbParser.RegionComposition p(com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray, int i2) {
        int readBits;
        int readBits2;
        int readBits3 = parsableBitArray.readBits(8);
        parsableBitArray.skipBits(4);
        boolean readBit = parsableBitArray.readBit();
        parsableBitArray.skipBits(3);
        int i3 = 16;
        int readBits4 = parsableBitArray.readBits(16);
        int readBits5 = parsableBitArray.readBits(16);
        int readBits6 = parsableBitArray.readBits(3);
        int readBits7 = parsableBitArray.readBits(3);
        int i4 = 2;
        parsableBitArray.skipBits(2);
        int readBits8 = parsableBitArray.readBits(8);
        int readBits9 = parsableBitArray.readBits(8);
        int readBits10 = parsableBitArray.readBits(4);
        int readBits11 = parsableBitArray.readBits(2);
        parsableBitArray.skipBits(2);
        int i5 = i2 - 10;
        android.util.SparseArray sparseArray = new android.util.SparseArray();
        while (i5 > 0) {
            int readBits12 = parsableBitArray.readBits(i3);
            int readBits13 = parsableBitArray.readBits(i4);
            int readBits14 = parsableBitArray.readBits(i4);
            int readBits15 = parsableBitArray.readBits(12);
            int i6 = readBits11;
            parsableBitArray.skipBits(4);
            int readBits16 = parsableBitArray.readBits(12);
            i5 -= 6;
            if (readBits13 == 1 || readBits13 == 2) {
                i5 -= 2;
                readBits = parsableBitArray.readBits(8);
                readBits2 = parsableBitArray.readBits(8);
            } else {
                readBits = 0;
                readBits2 = 0;
            }
            sparseArray.put(readBits12, new com.google.android.exoplayer2.text.dvb.DvbParser.RegionObject(readBits13, readBits14, readBits15, readBits16, readBits, readBits2));
            readBits11 = i6;
            i4 = 2;
            i3 = 16;
        }
        return new com.google.android.exoplayer2.text.dvb.DvbParser.RegionComposition(readBits3, readBit, readBits4, readBits5, readBits6, readBits7, readBits8, readBits9, readBits10, readBits11, sparseArray);
    }

    public static void q(com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray, com.google.android.exoplayer2.text.dvb.DvbParser.SubtitleService subtitleService) {
        com.google.android.exoplayer2.text.dvb.DvbParser.RegionComposition regionComposition;
        int readBits = parsableBitArray.readBits(8);
        int readBits2 = parsableBitArray.readBits(16);
        int readBits3 = parsableBitArray.readBits(16);
        int bytePosition = parsableBitArray.getBytePosition() + readBits3;
        if (readBits3 * 8 > parsableBitArray.bitsLeft()) {
            com.google.android.exoplayer2.util.Log.w("DvbParser", "Data field length exceeds limit");
            parsableBitArray.skipBits(parsableBitArray.bitsLeft());
            return;
        }
        switch (readBits) {
            case 16:
                if (readBits2 == subtitleService.a) {
                    com.google.android.exoplayer2.text.dvb.DvbParser.PageComposition pageComposition = subtitleService.i;
                    com.google.android.exoplayer2.text.dvb.DvbParser.PageComposition o = o(parsableBitArray, readBits3);
                    if (o.c == 0) {
                        if (pageComposition != null && pageComposition.b != o.b) {
                            subtitleService.i = o;
                            break;
                        }
                    } else {
                        subtitleService.i = o;
                        subtitleService.c.clear();
                        subtitleService.d.clear();
                        subtitleService.e.clear();
                        break;
                    }
                }
                break;
            case 17:
                com.google.android.exoplayer2.text.dvb.DvbParser.PageComposition pageComposition2 = subtitleService.i;
                if (readBits2 == subtitleService.a && pageComposition2 != null) {
                    com.google.android.exoplayer2.text.dvb.DvbParser.RegionComposition p = p(parsableBitArray, readBits3);
                    if (pageComposition2.c == 0 && (regionComposition = subtitleService.c.get(p.a)) != null) {
                        p.a(regionComposition);
                    }
                    subtitleService.c.put(p.a, p);
                    break;
                }
                break;
            case 18:
                if (readBits2 != subtitleService.a) {
                    if (readBits2 == subtitleService.b) {
                        com.google.android.exoplayer2.text.dvb.DvbParser.ClutDefinition l = l(parsableBitArray, readBits3);
                        subtitleService.f.put(l.a, l);
                        break;
                    }
                } else {
                    com.google.android.exoplayer2.text.dvb.DvbParser.ClutDefinition l2 = l(parsableBitArray, readBits3);
                    subtitleService.d.put(l2.a, l2);
                    break;
                }
                break;
            case 19:
                if (readBits2 != subtitleService.a) {
                    if (readBits2 == subtitleService.b) {
                        com.google.android.exoplayer2.text.dvb.DvbParser.ObjectData n = n(parsableBitArray);
                        subtitleService.g.put(n.a, n);
                        break;
                    }
                } else {
                    com.google.android.exoplayer2.text.dvb.DvbParser.ObjectData n2 = n(parsableBitArray);
                    subtitleService.e.put(n2.a, n2);
                    break;
                }
                break;
            case 20:
                if (readBits2 == subtitleService.a) {
                    subtitleService.h = m(parsableBitArray);
                    break;
                }
                break;
        }
        parsableBitArray.skipBytes(bytePosition - parsableBitArray.getBytePosition());
    }

    public java.util.List<com.google.android.exoplayer2.text.Cue> b(byte[] bArr, int i2) {
        int i3;
        android.util.SparseArray<com.google.android.exoplayer2.text.dvb.DvbParser.RegionObject> sparseArray;
        com.google.android.exoplayer2.util.ParsableBitArray parsableBitArray = new com.google.android.exoplayer2.util.ParsableBitArray(bArr, i2);
        while (parsableBitArray.bitsLeft() >= 48 && parsableBitArray.readBits(8) == 15) {
            q(parsableBitArray, this.f);
        }
        com.google.android.exoplayer2.text.dvb.DvbParser.SubtitleService subtitleService = this.f;
        com.google.android.exoplayer2.text.dvb.DvbParser.PageComposition pageComposition = subtitleService.i;
        if (pageComposition == null) {
            return java.util.Collections.emptyList();
        }
        com.google.android.exoplayer2.text.dvb.DvbParser.DisplayDefinition displayDefinition = subtitleService.h;
        if (displayDefinition == null) {
            displayDefinition = this.d;
        }
        android.graphics.Bitmap bitmap = this.g;
        if (bitmap == null || displayDefinition.a + 1 != bitmap.getWidth() || displayDefinition.b + 1 != this.g.getHeight()) {
            android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(displayDefinition.a + 1, displayDefinition.b + 1, android.graphics.Bitmap.Config.ARGB_8888);
            this.g = createBitmap;
            this.c.setBitmap(createBitmap);
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.util.SparseArray<com.google.android.exoplayer2.text.dvb.DvbParser.PageRegion> sparseArray2 = pageComposition.d;
        for (int i4 = 0; i4 < sparseArray2.size(); i4++) {
            this.c.save();
            com.google.android.exoplayer2.text.dvb.DvbParser.PageRegion valueAt = sparseArray2.valueAt(i4);
            com.google.android.exoplayer2.text.dvb.DvbParser.RegionComposition regionComposition = this.f.c.get(sparseArray2.keyAt(i4));
            int i5 = valueAt.a + displayDefinition.c;
            int i6 = valueAt.b + displayDefinition.e;
            this.c.clipRect(i5, i6, java.lang.Math.min(regionComposition.c + i5, displayDefinition.d), java.lang.Math.min(regionComposition.d + i6, displayDefinition.f));
            com.google.android.exoplayer2.text.dvb.DvbParser.ClutDefinition clutDefinition = this.f.d.get(regionComposition.g);
            if (clutDefinition == null && (clutDefinition = this.f.f.get(regionComposition.g)) == null) {
                clutDefinition = this.e;
            }
            android.util.SparseArray<com.google.android.exoplayer2.text.dvb.DvbParser.RegionObject> sparseArray3 = regionComposition.k;
            int i7 = 0;
            while (i7 < sparseArray3.size()) {
                int keyAt = sparseArray3.keyAt(i7);
                com.google.android.exoplayer2.text.dvb.DvbParser.RegionObject valueAt2 = sparseArray3.valueAt(i7);
                com.google.android.exoplayer2.text.dvb.DvbParser.ObjectData objectData = this.f.e.get(keyAt);
                com.google.android.exoplayer2.text.dvb.DvbParser.ObjectData objectData2 = objectData == null ? this.f.g.get(keyAt) : objectData;
                if (objectData2 != null) {
                    i3 = i7;
                    sparseArray = sparseArray3;
                    k(objectData2, clutDefinition, regionComposition.f, valueAt2.c + i5, i6 + valueAt2.d, objectData2.b ? null : this.a, this.c);
                } else {
                    i3 = i7;
                    sparseArray = sparseArray3;
                }
                i7 = i3 + 1;
                sparseArray3 = sparseArray;
            }
            if (regionComposition.b) {
                int i8 = regionComposition.f;
                this.b.setColor(i8 == 3 ? clutDefinition.d[regionComposition.h] : i8 == 2 ? clutDefinition.c[regionComposition.i] : clutDefinition.b[regionComposition.j]);
                this.c.drawRect(i5, i6, regionComposition.c + i5, regionComposition.d + i6, this.b);
            }
            arrayList.add(new com.google.android.exoplayer2.text.Cue.Builder().setBitmap(android.graphics.Bitmap.createBitmap(this.g, i5, i6, regionComposition.c, regionComposition.d)).setPosition(i5 / displayDefinition.a).setPositionAnchor(0).setLine(i6 / displayDefinition.b, 0).setLineAnchor(0).setSize(regionComposition.c / displayDefinition.a).setBitmapHeight(regionComposition.d / displayDefinition.b).build());
            this.c.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
            this.c.restore();
        }
        return java.util.Collections.unmodifiableList(arrayList);
    }

    public void r() {
        this.f.a();
    }
}
