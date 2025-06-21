package com.igexin.push.core.i.a;

/* loaded from: classes23.dex */
public class n implements com.igexin.push.core.i.a.d {
    private static final java.lang.String f = "n";
    private static final int g = 4096;
    private static final int h = -1;
    private static final int i = -1;
    private static final int j = 4;
    private static final int k = 255;
    private static final int l = 0;
    private boolean A;
    private int B;
    private int C;
    private int D;
    private int E;
    private java.lang.Boolean F;
    private android.graphics.Bitmap.Config G;
    private int[] m;
    private final int[] n;
    private final com.igexin.push.core.i.a.d.a o;
    private java.nio.ByteBuffer p;
    private byte[] q;
    private com.igexin.push.core.i.a.j r;

    /* renamed from: s, reason: collision with root package name */
    private short[] f391s;
    private byte[] t;
    private byte[] u;
    private byte[] v;
    private int[] w;
    private int x;
    private com.igexin.push.core.i.a.i y;
    private android.graphics.Bitmap z;

    private n(com.igexin.push.core.i.a.d.a aVar) {
        this.n = new int[256];
        this.G = android.graphics.Bitmap.Config.ARGB_8888;
        this.o = aVar;
        this.y = new com.igexin.push.core.i.a.i();
    }

    private n(com.igexin.push.core.i.a.d.a aVar, com.igexin.push.core.i.a.i iVar, java.nio.ByteBuffer byteBuffer) {
        this(aVar, iVar, byteBuffer, 1);
    }

    public n(com.igexin.push.core.i.a.d.a aVar, com.igexin.push.core.i.a.i iVar, java.nio.ByteBuffer byteBuffer, int i2) {
        this(aVar);
        a(iVar, byteBuffer, i2);
    }

    private int a(int i2, int i3, int i4) {
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = i2; i10 < this.C + i2; i10++) {
            byte[] bArr = this.v;
            if (i10 >= bArr.length || i10 >= i3) {
                break;
            }
            int i11 = this.m[bArr[i10] & 255];
            if (i11 != 0) {
                i5 += (i11 >> 24) & 255;
                i6 += (i11 >> 16) & 255;
                i7 += (i11 >> 8) & 255;
                i8 += i11 & 255;
                i9++;
            }
        }
        int i12 = i2 + i4;
        for (int i13 = i12; i13 < this.C + i12; i13++) {
            byte[] bArr2 = this.v;
            if (i13 >= bArr2.length || i13 >= i3) {
                break;
            }
            int i14 = this.m[bArr2[i13] & 255];
            if (i14 != 0) {
                i5 += (i14 >> 24) & 255;
                i6 += (i14 >> 16) & 255;
                i7 += (i14 >> 8) & 255;
                i8 += i14 & 255;
                i9++;
            }
        }
        if (i9 == 0) {
            return 0;
        }
        return ((i5 / i9) << 24) | ((i6 / i9) << 16) | ((i7 / i9) << 8) | (i8 / i9);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0041, code lost:
    
        if (r3.l == r34.l) goto L26;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v32, types: [short] */
    /* JADX WARN: Type inference failed for: r5v34 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private android.graphics.Bitmap a(com.igexin.push.core.i.a.g gVar, com.igexin.push.core.i.a.g gVar2) {
        int i2;
        java.lang.Boolean bool;
        boolean booleanValue;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        short s2;
        int i15;
        android.graphics.Bitmap bitmap;
        int i16;
        int i17;
        int i18;
        int[] iArr = this.w;
        if (gVar2 == null) {
            android.graphics.Bitmap bitmap2 = this.z;
            if (bitmap2 != null) {
                this.o.a(bitmap2);
            }
            this.z = null;
            java.util.Arrays.fill(iArr, 0);
        }
        if (gVar2 != null && gVar2.k == 3 && this.z == null) {
            java.util.Arrays.fill(iArr, 0);
        }
        if (gVar2 != null && (i15 = gVar2.k) > 0) {
            if (i15 == 2) {
                if (!gVar.j) {
                    com.igexin.push.core.i.a.i iVar = this.y;
                    i16 = iVar.n;
                    if (gVar.o != null) {
                    }
                    int i19 = gVar2.h;
                    int i20 = this.C;
                    int i21 = i19 / i20;
                    int i22 = gVar2.f / i20;
                    int i23 = gVar2.g / i20;
                    int i24 = gVar2.e / i20;
                    int i25 = this.E;
                    i17 = (i22 * i25) + i24;
                    i18 = (i21 * i25) + i17;
                    while (i17 < i18) {
                        int i26 = i17 + i23;
                        for (int i27 = i17; i27 < i26; i27++) {
                            iArr[i27] = i16;
                        }
                        i17 += this.E;
                    }
                }
                i16 = 0;
                int i192 = gVar2.h;
                int i202 = this.C;
                int i212 = i192 / i202;
                int i222 = gVar2.f / i202;
                int i232 = gVar2.g / i202;
                int i242 = gVar2.e / i202;
                int i252 = this.E;
                i17 = (i222 * i252) + i242;
                i18 = (i212 * i252) + i17;
                while (i17 < i18) {
                }
            } else if (i15 == 3 && (bitmap = this.z) != null) {
                int i28 = this.E;
                bitmap.getPixels(iArr, 0, i28, 0, 0, i28, this.D);
            }
        }
        if (gVar != null) {
            this.p.position(gVar.n);
        }
        if (gVar == null) {
            com.igexin.push.core.i.a.i iVar2 = this.y;
            i2 = iVar2.h * iVar2.i;
        } else {
            i2 = gVar.h * gVar.g;
        }
        byte[] bArr = this.v;
        if (bArr == null || bArr.length < i2) {
            this.v = this.o.a(i2);
        }
        byte[] bArr2 = this.v;
        if (this.f391s == null) {
            this.f391s = new short[4096];
        }
        short[] sArr = this.f391s;
        if (this.t == null) {
            this.t = new byte[4096];
        }
        byte[] bArr3 = this.t;
        if (this.u == null) {
            this.u = new byte[4097];
        }
        byte[] bArr4 = this.u;
        int q = q();
        int i29 = 1 << q;
        int i30 = i29 + 1;
        int i31 = i29 + 2;
        int i32 = q + 1;
        int i33 = (1 << i32) - 1;
        for (int i34 = 0; i34 < i29; i34++) {
            sArr[i34] = 0;
            bArr3[i34] = (byte) i34;
        }
        byte[] bArr5 = this.q;
        int i35 = i32;
        int i36 = i31;
        int i37 = i33;
        int i38 = 0;
        int i39 = -1;
        int i40 = 0;
        int i41 = 0;
        int i42 = 0;
        int i43 = 0;
        int i44 = 0;
        int i45 = 0;
        int i46 = 0;
        while (true) {
            if (i38 >= i2) {
                break;
            }
            if (i40 == 0) {
                int q2 = q();
                if (q2 <= 0) {
                    i13 = i32;
                    i14 = i38;
                } else {
                    java.nio.ByteBuffer byteBuffer = this.p;
                    i13 = i32;
                    i14 = i38;
                    byteBuffer.get(this.q, 0, java.lang.Math.min(q2, byteBuffer.remaining()));
                }
                if (q2 <= 0) {
                    this.B = 3;
                    break;
                }
                i40 = q2;
                i42 = 0;
            } else {
                i13 = i32;
                i14 = i38;
            }
            i41 += (bArr5[i42] & 255) << i43;
            i42++;
            i40--;
            int i47 = i39;
            int i48 = i43 + 8;
            int i49 = i36;
            int i50 = i35;
            i38 = i14;
            byte[] bArr6 = bArr5;
            int i51 = i45;
            while (true) {
                if (i48 < i50) {
                    i45 = i51;
                    i35 = i50;
                    i43 = i48;
                    i36 = i49;
                    bArr5 = bArr6;
                    i32 = i13;
                    i39 = i47;
                    break;
                }
                int[] iArr2 = iArr;
                int i52 = i41 & i37;
                i41 >>= i50;
                i48 -= i50;
                if (i52 != i29) {
                    if (i52 == i30) {
                        i45 = i51;
                        i35 = i50;
                        bArr5 = bArr6;
                        iArr = iArr2;
                        i43 = i48;
                        i32 = i13;
                        i39 = i47;
                        i36 = i49;
                        break;
                    }
                    if (i47 == -1) {
                        bArr2[i44] = bArr3[i52];
                        i44++;
                        i38++;
                        i51 = i52;
                        i47 = i51;
                        iArr = iArr2;
                        i48 = i48;
                    } else {
                        if (i52 >= i49) {
                            bArr4[i46] = (byte) i51;
                            i46++;
                            s2 = i47;
                        } else {
                            s2 = i52;
                        }
                        while (s2 >= i29) {
                            bArr4[i46] = bArr3[s2];
                            i46++;
                            s2 = sArr[s2];
                        }
                        int i53 = bArr3[s2] & 255;
                        byte b = (byte) i53;
                        bArr2[i44] = b;
                        while (true) {
                            i44++;
                            i38++;
                            if (i46 <= 0) {
                                break;
                            }
                            i46--;
                            bArr2[i44] = bArr4[i46];
                        }
                        if (i49 < 4096) {
                            sArr[i49] = (short) i47;
                            bArr3[i49] = b;
                            i49++;
                            if ((i49 & i37) == 0 && i49 < 4096) {
                                i50++;
                                i37 += i49;
                            }
                        }
                        i47 = i52;
                        iArr = iArr2;
                        i48 = i48;
                        i51 = i53;
                    }
                } else {
                    i49 = i31;
                    i37 = i33;
                    iArr = iArr2;
                    i50 = i13;
                    i47 = -1;
                }
            }
        }
        int[] iArr3 = iArr;
        java.util.Arrays.fill(bArr2, i44, i2, (byte) 0);
        if (gVar.i || this.C != 1) {
            int[] iArr4 = this.w;
            int i54 = gVar.h;
            int i55 = this.C;
            int i56 = i54 / i55;
            int i57 = gVar.f / i55;
            int i58 = gVar.g / i55;
            int i59 = gVar.e / i55;
            boolean z = this.x == 0;
            int i60 = this.E;
            int i61 = this.D;
            byte[] bArr7 = this.v;
            int[] iArr5 = this.m;
            java.lang.Boolean bool2 = this.F;
            int i62 = 0;
            int i63 = 0;
            int i64 = 1;
            int i65 = 8;
            while (true) {
                bool = bool2;
                if (i62 >= i56) {
                    break;
                }
                if (gVar.i) {
                    if (i63 >= i56) {
                        int i66 = i64 + 1;
                        i3 = i56;
                        if (i66 == 2) {
                            i64 = i66;
                            i63 = 4;
                        } else if (i66 != 3) {
                            i64 = i66;
                            if (i66 == 4) {
                                i63 = 1;
                                i65 = 2;
                            }
                        } else {
                            i64 = i66;
                            i63 = 2;
                            i65 = 4;
                        }
                    } else {
                        i3 = i56;
                    }
                    i4 = i63 + i65;
                } else {
                    i3 = i56;
                    i4 = i63;
                    i63 = i62;
                }
                int i67 = i63 + i57;
                boolean z2 = i55 == 1;
                if (i67 < i61) {
                    int i68 = i67 * i60;
                    int i69 = i68 + i59;
                    i5 = i4;
                    int i70 = i69 + i58;
                    int i71 = i68 + i60;
                    if (i71 < i70) {
                        i70 = i71;
                    }
                    i6 = i57;
                    int i72 = i62 * i55 * gVar.g;
                    if (z2) {
                        bool2 = bool;
                        int i73 = i69;
                        while (true) {
                            i7 = i58;
                            if (i73 >= i70) {
                                break;
                            }
                            int i74 = iArr5[bArr7[i72] & 255];
                            if (i74 != 0) {
                                iArr4[i73] = i74;
                            } else if (z && bool2 == null) {
                                bool2 = java.lang.Boolean.TRUE;
                            }
                            i72 += i55;
                            i73++;
                            i58 = i7;
                        }
                    } else {
                        i7 = i58;
                        int i75 = ((i70 - i69) * i55) + i72;
                        bool2 = bool;
                        int i76 = i69;
                        while (i76 < i70) {
                            int i77 = i70;
                            int i78 = gVar.g;
                            int i79 = i59;
                            int i80 = i60;
                            int i81 = i72;
                            int i82 = 0;
                            int i83 = 0;
                            int i84 = 0;
                            int i85 = 0;
                            int i86 = 0;
                            while (true) {
                                if (i81 >= this.C + i72) {
                                    i11 = i61;
                                    break;
                                }
                                byte[] bArr8 = this.v;
                                i11 = i61;
                                if (i81 >= bArr8.length || i81 >= i75) {
                                    break;
                                }
                                int i87 = this.m[bArr8[i81] & 255];
                                if (i87 != 0) {
                                    i82 += (i87 >> 24) & 255;
                                    i83 += (i87 >> 16) & 255;
                                    i84 += (i87 >> 8) & 255;
                                    i85 += i87 & 255;
                                    i86++;
                                }
                                i81++;
                                i61 = i11;
                            }
                            int i88 = i78 + i72;
                            for (int i89 = i88; i89 < this.C + i88; i89++) {
                                byte[] bArr9 = this.v;
                                if (i89 >= bArr9.length || i89 >= i75) {
                                    break;
                                }
                                int i90 = this.m[bArr9[i89] & 255];
                                if (i90 != 0) {
                                    i82 += (i90 >> 24) & 255;
                                    i83 += (i90 >> 16) & 255;
                                    i84 += (i90 >> 8) & 255;
                                    i85 += i90 & 255;
                                    i86++;
                                }
                            }
                            int i91 = i86 == 0 ? 0 : ((i82 / i86) << 24) | ((i83 / i86) << 16) | ((i84 / i86) << 8) | (i85 / i86);
                            if (i91 != 0) {
                                iArr4[i76] = i91;
                            } else if (z && bool2 == null) {
                                bool2 = java.lang.Boolean.TRUE;
                            }
                            i72 += i55;
                            i76++;
                            i70 = i77;
                            i59 = i79;
                            i60 = i80;
                            i61 = i11;
                        }
                    }
                    i8 = i59;
                    i9 = i60;
                    i10 = i61;
                } else {
                    i5 = i4;
                    i6 = i57;
                    i7 = i58;
                    i8 = i59;
                    i9 = i60;
                    i10 = i61;
                    bool2 = bool;
                }
                i62++;
                i56 = i3;
                i63 = i5;
                i57 = i6;
                i58 = i7;
                i59 = i8;
                i60 = i9;
                i61 = i10;
            }
            if (this.F == null) {
                if (bool != null) {
                    booleanValue = bool.booleanValue();
                    this.F = java.lang.Boolean.valueOf(booleanValue);
                }
                booleanValue = false;
                this.F = java.lang.Boolean.valueOf(booleanValue);
            }
        } else {
            int[] iArr6 = this.w;
            int i92 = gVar.h;
            int i93 = gVar.f;
            int i94 = gVar.g;
            int i95 = gVar.e;
            boolean z3 = this.x == 0;
            int i96 = this.E;
            byte[] bArr10 = this.v;
            int[] iArr7 = this.m;
            byte b2 = -1;
            for (int i97 = 0; i97 < i92; i97++) {
                int i98 = (i97 + i93) * i96;
                int i99 = i98 + i95;
                int i100 = i99 + i94;
                int i101 = i98 + i96;
                if (i101 < i100) {
                    i100 = i101;
                }
                int i102 = gVar.g * i97;
                while (true) {
                    int i103 = i92;
                    if (i99 < i100) {
                        byte b3 = bArr10[i102];
                        int i104 = i93;
                        int i105 = b3 & 255;
                        if (i105 != b2) {
                            int i106 = iArr7[i105];
                            if (i106 != 0) {
                                iArr6[i99] = i106;
                            } else {
                                b2 = b3;
                            }
                        }
                        i102++;
                        i99++;
                        i92 = i103;
                        i93 = i104;
                    }
                }
            }
            java.lang.Boolean bool3 = this.F;
            if ((bool3 != null && bool3.booleanValue()) || (this.F == null && z3 && b2 != -1)) {
                booleanValue = true;
                this.F = java.lang.Boolean.valueOf(booleanValue);
            }
            booleanValue = false;
            this.F = java.lang.Boolean.valueOf(booleanValue);
        }
        if (this.A && ((i12 = gVar.k) == 0 || i12 == 1)) {
            if (this.z == null) {
                this.z = s();
            }
            android.graphics.Bitmap bitmap3 = this.z;
            int i107 = this.E;
            bitmap3.setPixels(iArr3, 0, i107, 0, 0, i107, this.D);
        }
        android.graphics.Bitmap s3 = s();
        int i108 = this.E;
        s3.setPixels(iArr3, 0, i108, 0, 0, i108, this.D);
        return s3;
    }

    private void a(com.igexin.push.core.i.a.g gVar) {
        com.igexin.push.core.i.a.g gVar2 = gVar;
        int[] iArr = this.w;
        int i2 = gVar2.h;
        int i3 = gVar2.f;
        int i4 = gVar2.g;
        int i5 = gVar2.e;
        boolean z = this.x == 0;
        int i6 = this.E;
        byte[] bArr = this.v;
        int[] iArr2 = this.m;
        int i7 = 0;
        byte b = -1;
        while (i7 < i2) {
            int i8 = (i7 + i3) * i6;
            int i9 = i8 + i5;
            int i10 = i9 + i4;
            int i11 = i8 + i6;
            if (i11 < i10) {
                i10 = i11;
            }
            int i12 = gVar2.g * i7;
            int i13 = i9;
            while (i13 < i10) {
                byte b2 = bArr[i12];
                int i14 = i2;
                int i15 = b2 & 255;
                if (i15 != b) {
                    int i16 = iArr2[i15];
                    if (i16 != 0) {
                        iArr[i13] = i16;
                    } else {
                        b = b2;
                    }
                }
                i12++;
                i13++;
                i2 = i14;
            }
            i7++;
            gVar2 = gVar;
        }
        java.lang.Boolean bool = this.F;
        this.F = java.lang.Boolean.valueOf((bool != null && bool.booleanValue()) || (this.F == null && z && b != -1));
    }

    private void b(com.igexin.push.core.i.a.g gVar) {
        java.lang.Boolean bool;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        com.igexin.push.core.i.a.g gVar2 = gVar;
        int[] iArr = this.w;
        int i8 = gVar2.h;
        int i9 = this.C;
        int i10 = i8 / i9;
        int i11 = gVar2.f / i9;
        int i12 = gVar2.g / i9;
        int i13 = gVar2.e / i9;
        boolean z = this.x == 0;
        int i14 = this.E;
        int i15 = this.D;
        byte[] bArr = this.v;
        int[] iArr2 = this.m;
        java.lang.Boolean bool2 = this.F;
        int i16 = 0;
        int i17 = 0;
        int i18 = 1;
        int i19 = 8;
        while (true) {
            bool = bool2;
            if (i17 >= i10) {
                break;
            }
            if (gVar2.i) {
                if (i16 >= i10) {
                    int i20 = i18 + 1;
                    i2 = i10;
                    if (i20 == 2) {
                        i18 = i20;
                        i16 = 4;
                    } else if (i20 != 3) {
                        i18 = i20;
                        if (i20 == 4) {
                            i16 = 1;
                            i19 = 2;
                        }
                    } else {
                        i18 = i20;
                        i16 = 2;
                        i19 = 4;
                    }
                } else {
                    i2 = i10;
                }
                i3 = i16 + i19;
            } else {
                i2 = i10;
                i3 = i16;
                i16 = i17;
            }
            int i21 = i16 + i11;
            boolean z2 = i9 == 1;
            if (i21 < i15) {
                int i22 = i21 * i14;
                int i23 = i22 + i13;
                int i24 = i23 + i12;
                int i25 = i22 + i14;
                if (i25 < i24) {
                    i24 = i25;
                }
                i4 = i3;
                int i26 = i17 * i9 * gVar2.g;
                if (z2) {
                    int i27 = i23;
                    while (true) {
                        i5 = i11;
                        if (i27 >= i24) {
                            break;
                        }
                        int i28 = iArr2[bArr[i26] & 255];
                        if (i28 != 0) {
                            iArr[i27] = i28;
                        } else if (z && bool == null) {
                            bool = java.lang.Boolean.TRUE;
                        }
                        i26 += i9;
                        i27++;
                        i11 = i5;
                    }
                } else {
                    i5 = i11;
                    int i29 = ((i24 - i23) * i9) + i26;
                    int i30 = i23;
                    while (true) {
                        i6 = i12;
                        if (i30 < i24) {
                            int i31 = gVar2.g;
                            int i32 = i13;
                            int i33 = i26;
                            int i34 = 0;
                            int i35 = 0;
                            int i36 = 0;
                            int i37 = 0;
                            int i38 = 0;
                            while (true) {
                                if (i33 >= this.C + i26) {
                                    i7 = i14;
                                    break;
                                }
                                byte[] bArr2 = this.v;
                                i7 = i14;
                                if (i33 >= bArr2.length || i33 >= i29) {
                                    break;
                                }
                                int i39 = this.m[bArr2[i33] & 255];
                                if (i39 != 0) {
                                    i34 += (i39 >> 24) & 255;
                                    i35 += (i39 >> 16) & 255;
                                    i36 += (i39 >> 8) & 255;
                                    i37 += i39 & 255;
                                    i38++;
                                }
                                i33++;
                                i14 = i7;
                            }
                            int i40 = i31 + i26;
                            for (int i41 = i40; i41 < this.C + i40; i41++) {
                                byte[] bArr3 = this.v;
                                if (i41 >= bArr3.length || i41 >= i29) {
                                    break;
                                }
                                int i42 = this.m[bArr3[i41] & 255];
                                if (i42 != 0) {
                                    i34 += (i42 >> 24) & 255;
                                    i35 += (i42 >> 16) & 255;
                                    i36 += (i42 >> 8) & 255;
                                    i37 += i42 & 255;
                                    i38++;
                                }
                            }
                            int i43 = i38 == 0 ? 0 : ((i34 / i38) << 24) | ((i35 / i38) << 16) | ((i36 / i38) << 8) | (i37 / i38);
                            if (i43 != 0) {
                                iArr[i30] = i43;
                            } else if (z && bool == null) {
                                bool = java.lang.Boolean.TRUE;
                            }
                            i26 += i9;
                            i30++;
                            gVar2 = gVar;
                            i12 = i6;
                            i13 = i32;
                            i14 = i7;
                        }
                    }
                    bool2 = bool;
                    i17++;
                    gVar2 = gVar;
                    i11 = i5;
                    i10 = i2;
                    i12 = i6;
                    i16 = i4;
                    i13 = i13;
                    i14 = i14;
                }
            } else {
                i4 = i3;
                i5 = i11;
            }
            i6 = i12;
            bool2 = bool;
            i17++;
            gVar2 = gVar;
            i11 = i5;
            i10 = i2;
            i12 = i6;
            i16 = i4;
            i13 = i13;
            i14 = i14;
        }
        if (this.F == null) {
            this.F = java.lang.Boolean.valueOf(bool == null ? false : bool.booleanValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [short] */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    private void c(com.igexin.push.core.i.a.g gVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        short s2;
        com.igexin.push.core.i.a.n nVar = this;
        if (gVar != null) {
            nVar.p.position(gVar.n);
        }
        if (gVar == null) {
            com.igexin.push.core.i.a.i iVar = nVar.y;
            i2 = iVar.h;
            i3 = iVar.i;
        } else {
            i2 = gVar.g;
            i3 = gVar.h;
        }
        int i6 = i2 * i3;
        byte[] bArr = nVar.v;
        if (bArr == null || bArr.length < i6) {
            nVar.v = nVar.o.a(i6);
        }
        byte[] bArr2 = nVar.v;
        if (nVar.f391s == null) {
            nVar.f391s = new short[4096];
        }
        short[] sArr = nVar.f391s;
        if (nVar.t == null) {
            nVar.t = new byte[4096];
        }
        byte[] bArr3 = nVar.t;
        if (nVar.u == null) {
            nVar.u = new byte[4097];
        }
        byte[] bArr4 = nVar.u;
        int q = q();
        int i7 = 1 << q;
        int i8 = i7 + 1;
        int i9 = i7 + 2;
        int i10 = q + 1;
        int i11 = (1 << i10) - 1;
        for (int i12 = 0; i12 < i7; i12++) {
            sArr[i12] = 0;
            bArr3[i12] = (byte) i12;
        }
        byte[] bArr5 = nVar.q;
        int i13 = i10;
        int i14 = i9;
        int i15 = i11;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = -1;
        int i23 = 0;
        int i24 = 0;
        while (true) {
            if (i16 >= i6) {
                break;
            }
            if (i17 == 0) {
                int q2 = q();
                if (q2 <= 0) {
                    i4 = i16;
                    i5 = i10;
                } else {
                    java.nio.ByteBuffer byteBuffer = nVar.p;
                    i4 = i16;
                    i5 = i10;
                    byteBuffer.get(nVar.q, 0, java.lang.Math.min(q2, byteBuffer.remaining()));
                }
                if (q2 <= 0) {
                    nVar.B = 3;
                    break;
                } else {
                    i17 = q2;
                    i18 = 0;
                }
            } else {
                i4 = i16;
                i5 = i10;
            }
            i20 += (bArr5[i18] & 255) << i19;
            i18++;
            i17--;
            int i25 = i19 + 8;
            int i26 = i14;
            int i27 = i13;
            int i28 = i22;
            int i29 = i23;
            while (i25 >= i27) {
                int i30 = i20 & i15;
                i20 >>= i27;
                i25 -= i27;
                if (i30 == i7) {
                    i26 = i9;
                    i15 = i11;
                    i27 = i5;
                    i28 = -1;
                } else if (i30 != i8) {
                    if (i28 == -1) {
                        bArr2[i21] = bArr3[i30];
                        i21++;
                        i4++;
                        i28 = i30;
                        i29 = i28;
                    } else {
                        if (i30 >= i26) {
                            bArr4[i24] = (byte) i29;
                            i24++;
                            s2 = i28;
                        } else {
                            s2 = i30;
                        }
                        while (s2 >= i7) {
                            bArr4[i24] = bArr3[s2];
                            i24++;
                            s2 = sArr[s2];
                        }
                        int i31 = bArr3[s2] & 255;
                        byte b = (byte) i31;
                        bArr2[i21] = b;
                        while (true) {
                            i21++;
                            i4++;
                            if (i24 <= 0) {
                                break;
                            }
                            i24--;
                            bArr2[i21] = bArr4[i24];
                        }
                        if (i26 < 4096) {
                            sArr[i26] = (short) i28;
                            bArr3[i26] = b;
                            i26++;
                            if ((i26 & i15) == 0 && i26 < 4096) {
                                i27++;
                                i15 += i26;
                            }
                        }
                        i28 = i30;
                        i29 = i31;
                    }
                }
            }
            nVar = this;
            i22 = i28;
            i19 = i25;
            i14 = i26;
            i13 = i27;
            i16 = i4;
            i10 = i5;
            i23 = i29;
        }
        java.util.Arrays.fill(bArr2, i21, i6, (byte) 0);
    }

    private com.igexin.push.core.i.a.j p() {
        if (this.r == null) {
            this.r = new com.igexin.push.core.i.a.j();
        }
        return this.r;
    }

    private int q() {
        return this.p.get() & 255;
    }

    private int r() {
        int q = q();
        if (q <= 0) {
            return q;
        }
        java.nio.ByteBuffer byteBuffer = this.p;
        byteBuffer.get(this.q, 0, java.lang.Math.min(q, byteBuffer.remaining()));
        return q;
    }

    private android.graphics.Bitmap s() {
        java.lang.Boolean bool = this.F;
        android.graphics.Bitmap a = this.o.a(this.E, this.D, (bool == null || bool.booleanValue()) ? android.graphics.Bitmap.Config.ARGB_8888 : this.G, this.x);
        a.setHasAlpha(true);
        return a;
    }

    @Override // com.igexin.push.core.i.a.d
    public final int a() {
        return this.y.h;
    }

    @Override // com.igexin.push.core.i.a.d
    public final int a(int i2) {
        if (i2 >= 0) {
            com.igexin.push.core.i.a.i iVar = this.y;
            if (i2 < iVar.e) {
                return iVar.g.get(i2).m;
            }
        }
        return -1;
    }

    @Override // com.igexin.push.core.i.a.d
    public final int a(java.io.InputStream inputStream, int i2) {
        if (inputStream != null) {
            try {
                java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream(i2 > 0 ? i2 + 4096 : 16384);
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr, 0, 16384);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.flush();
                a(byteArrayOutputStream.toByteArray());
            } catch (java.io.IOException unused) {
            }
        } else {
            this.B = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (java.io.IOException unused2) {
            }
        }
        return this.B;
    }

    @Override // com.igexin.push.core.i.a.d
    public final synchronized int a(byte[] bArr) {
        if (this.r == null) {
            this.r = new com.igexin.push.core.i.a.j();
        }
        com.igexin.push.core.i.a.j jVar = this.r;
        if (bArr != null) {
            jVar.a(java.nio.ByteBuffer.wrap(bArr));
        } else {
            jVar.c = null;
            jVar.d.d = 2;
        }
        com.igexin.push.core.i.a.i b = jVar.b();
        this.y = b;
        if (bArr != null) {
            a(b, bArr);
        }
        return this.B;
    }

    @Override // com.igexin.push.core.i.a.d
    public final void a(android.graphics.Bitmap.Config config) {
        if (config == android.graphics.Bitmap.Config.ARGB_8888 || config == android.graphics.Bitmap.Config.RGB_565) {
            this.G = config;
            return;
        }
        throw new java.lang.IllegalArgumentException("Unsupported format: " + config + ", must be one of " + android.graphics.Bitmap.Config.ARGB_8888 + " or " + android.graphics.Bitmap.Config.RGB_565);
    }

    @Override // com.igexin.push.core.i.a.d
    public final synchronized void a(com.igexin.push.core.i.a.i iVar, java.nio.ByteBuffer byteBuffer) {
        a(iVar, byteBuffer, 1);
    }

    @Override // com.igexin.push.core.i.a.d
    public final synchronized void a(com.igexin.push.core.i.a.i iVar, java.nio.ByteBuffer byteBuffer, int i2) {
        if (i2 <= 0) {
            throw new java.lang.IllegalArgumentException("Sample size must be >=0, not: ".concat(java.lang.String.valueOf(i2)));
        }
        int highestOneBit = java.lang.Integer.highestOneBit(i2);
        this.B = 0;
        this.y = iVar;
        this.x = -1;
        java.nio.ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.p = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.p.order(java.nio.ByteOrder.LITTLE_ENDIAN);
        this.A = false;
        java.util.Iterator<com.igexin.push.core.i.a.g> it = iVar.g.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().k == 3) {
                this.A = true;
                break;
            }
        }
        this.C = highestOneBit;
        int i3 = iVar.h;
        this.E = i3 / highestOneBit;
        int i4 = iVar.i;
        this.D = i4 / highestOneBit;
        this.v = this.o.a(i3 * i4);
        this.w = this.o.b(this.E * this.D);
    }

    @Override // com.igexin.push.core.i.a.d
    public final synchronized void a(com.igexin.push.core.i.a.i iVar, byte[] bArr) {
        a(iVar, java.nio.ByteBuffer.wrap(bArr));
    }

    @Override // com.igexin.push.core.i.a.d
    public final int b() {
        return this.y.i;
    }

    @Override // com.igexin.push.core.i.a.d
    public final java.nio.ByteBuffer c() {
        return this.p;
    }

    @Override // com.igexin.push.core.i.a.d
    public final int d() {
        return this.B;
    }

    @Override // com.igexin.push.core.i.a.d
    public final void e() {
        this.x = (this.x + 1) % this.y.e;
    }

    @Override // com.igexin.push.core.i.a.d
    public final int f() {
        int i2;
        com.igexin.push.core.i.a.i iVar = this.y;
        int i3 = iVar.e;
        if (i3 <= 0 || (i2 = this.x) < 0) {
            return 0;
        }
        if (i2 < 0 || i2 >= i3) {
            return -1;
        }
        return iVar.g.get(i2).m;
    }

    @Override // com.igexin.push.core.i.a.d
    public final int g() {
        return this.y.e;
    }

    @Override // com.igexin.push.core.i.a.d
    public final int h() {
        return this.x;
    }

    @Override // com.igexin.push.core.i.a.d
    public final void i() {
        this.x = -1;
    }

    @Override // com.igexin.push.core.i.a.d
    @java.lang.Deprecated
    public final int j() {
        int i2 = this.y.o;
        if (i2 == -1) {
            return 1;
        }
        return i2;
    }

    @Override // com.igexin.push.core.i.a.d
    public final int k() {
        return this.y.o;
    }

    @Override // com.igexin.push.core.i.a.d
    public final int l() {
        int i2 = this.y.o;
        if (i2 == -1) {
            return 1;
        }
        if (i2 == 0) {
            return 0;
        }
        return i2 + 1;
    }

    @Override // com.igexin.push.core.i.a.d
    public final int m() {
        return this.p.limit() + this.v.length + (this.w.length * 4);
    }

    @Override // com.igexin.push.core.i.a.d
    public final synchronized android.graphics.Bitmap n() {
        if (this.y.e <= 0 || this.x < 0) {
            com.igexin.c.a.c.a.b(f, "Unable to decode frame, frameCount=" + this.y.e + ", framePointer=" + this.x);
            this.B = 1;
        }
        int i2 = this.B;
        if (i2 != 1 && i2 != 2) {
            this.B = 0;
            if (this.q == null) {
                this.q = this.o.a(255);
            }
            com.igexin.push.core.i.a.g gVar = this.y.g.get(this.x);
            int i3 = this.x - 1;
            com.igexin.push.core.i.a.g gVar2 = i3 >= 0 ? this.y.g.get(i3) : null;
            int[] iArr = gVar.o;
            if (iArr == null) {
                iArr = this.y.c;
            }
            this.m = iArr;
            if (iArr == null) {
                com.igexin.c.a.c.a.b(f, "No valid color table found for frame #" + this.x);
                this.B = 1;
                return null;
            }
            if (gVar.j) {
                java.lang.System.arraycopy(iArr, 0, this.n, 0, iArr.length);
                int[] iArr2 = this.n;
                this.m = iArr2;
                iArr2[gVar.l] = 0;
                if (gVar.k == 2 && this.x == 0) {
                    this.F = java.lang.Boolean.TRUE;
                }
            }
            return a(gVar, gVar2);
        }
        com.igexin.c.a.c.a.b(f, "Unable to decode frame, status=" + this.B);
        return null;
    }

    @Override // com.igexin.push.core.i.a.d
    public final void o() {
        this.y = null;
        android.graphics.Bitmap bitmap = this.z;
        if (bitmap != null) {
            this.o.a(bitmap);
        }
        this.z = null;
        this.p = null;
        this.F = null;
        this.o.a();
    }
}
