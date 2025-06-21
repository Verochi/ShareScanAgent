package com.bytedance.pangle.res.a;

/* loaded from: classes.dex */
public final class b {
    com.bytedance.pangle.res.a.g c;
    private final com.bytedance.pangle.res.a.h i;
    private final byte[] j;
    private int[] l;
    private boolean n;
    private int o;
    private int[] p;
    private int q;
    java.util.HashMap<java.lang.Integer, java.lang.Integer> a = new java.util.HashMap<>();
    boolean b = false;
    private boolean k = false;
    private final com.bytedance.pangle.res.a.b.a m = new com.bytedance.pangle.res.a.b.a();
    int d = 0;
    int e = 1;
    int f = 2;
    int g = 3;
    int h = 4;

    public static final class a {
        int[] a = new int[32];
        int b;
        int c;

        public final void a() {
            b();
            int i = this.b;
            int[] iArr = this.a;
            iArr[i] = 0;
            iArr[i + 1] = 0;
            this.b = i + 2;
            this.c++;
        }

        public final void b() {
            int[] iArr = this.a;
            int length = iArr.length;
            int i = this.b;
            int i2 = length - i;
            if (i2 > 2) {
                return;
            }
            int[] iArr2 = new int[(iArr.length + i2) * 2];
            java.lang.System.arraycopy(iArr, 0, iArr2, 0, i);
            this.a = iArr2;
        }
    }

    public b(byte[] bArr, com.bytedance.pangle.res.a.h hVar) {
        this.i = hVar;
        this.j = bArr;
        c();
    }

    private void c() {
        this.o = -1;
        this.p = null;
        this.q = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:118:0x0294, code lost:
    
        throw new java.io.IOException("Invalid chunk type (" + r6 + ").");
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x012b, code lost:
    
        throw new java.io.IOException("Invalid resource ids size (" + r6 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d() {
        int i;
        int[] iArr;
        int i2;
        int[] iArr2;
        int i3 = 3;
        if (!this.k) {
            int readInt = this.c.readInt();
            if (readInt != 524291 && readInt != 524289) {
                throw new java.io.IOException(java.lang.String.format("Expected: 0x%08x or 0x%08x, got: 0x%08x", 524291, 524289, java.lang.Integer.valueOf(readInt)));
            }
            this.c.skipBytes(4);
            com.bytedance.pangle.res.a.l.a(this.c);
            this.m.a();
            this.k = true;
        }
        int i4 = this.o;
        if (i4 == this.e) {
            return;
        }
        c();
        while (true) {
            if (this.n) {
                this.n = false;
                com.bytedance.pangle.res.a.b.a aVar = this.m;
                int i5 = aVar.b;
                if (i5 != 0) {
                    int i6 = i5 - 1;
                    int i7 = aVar.a[i6] * 2;
                    if ((i6 - 1) - i7 != 0) {
                        aVar.b = i5 - (i7 + 2);
                        aVar.c--;
                    }
                }
            }
            if (i4 == this.g) {
                com.bytedance.pangle.res.a.b.a aVar2 = this.m;
                if (aVar2.c == 1) {
                    int i8 = aVar2.b;
                    if ((i8 == 0 ? 0 : aVar2.a[i8 - 1]) == 0) {
                        this.o = this.e;
                        return;
                    }
                }
            }
            int readInt2 = i4 == this.d ? 1048834 : this.c.readInt();
            if (readInt2 == 524672) {
                this.a.clear();
                int readInt3 = this.c.readInt();
                if (readInt3 < 8 || readInt3 % 4 != 0) {
                    break;
                }
                int a2 = com.bytedance.pangle.res.a.k.a(this.c);
                this.l = this.c.a((readInt3 / 4) - 2);
                java.util.ArrayList arrayList = new java.util.ArrayList();
                int i9 = 0;
                while (true) {
                    int[] iArr3 = this.l;
                    if (i9 >= iArr3.length) {
                        break;
                    }
                    int a3 = com.bytedance.pangle.res.a.k.a(this.j, iArr3[i9], (i9 * 4) + a2, this.i);
                    if (a3 >= 2130706432) {
                        this.a.put(java.lang.Integer.valueOf(i9), java.lang.Integer.valueOf(a3));
                        arrayList.add(java.lang.Integer.valueOf(a3));
                    }
                    i9++;
                }
                java.util.ArrayList arrayList2 = new java.util.ArrayList(arrayList);
                java.util.Collections.sort(arrayList2);
                if (!arrayList.equals(arrayList2)) {
                    this.b = true;
                }
            } else {
                if (readInt2 < 1048832 || readInt2 > 1048836) {
                    break;
                }
                if (readInt2 == 1048834 && i4 == -1) {
                    this.o = this.d;
                    return;
                }
                this.c.skipBytes(4);
                this.c.readInt();
                this.c.skipBytes(4);
                if (readInt2 != 1048832 && readInt2 != 1048833) {
                    if (readInt2 == 1048834) {
                        this.c.readInt();
                        this.c.readInt();
                        this.c.skipBytes(4);
                        int readInt4 = this.c.readInt() & 65535;
                        this.q = (65535 & this.c.readInt()) - 1;
                        int a4 = com.bytedance.pangle.res.a.k.a(this.c);
                        int i10 = readInt4 * 5;
                        this.p = this.c.a(i10);
                        while (true) {
                            iArr2 = this.p;
                            if (i3 >= iArr2.length) {
                                break;
                            }
                            iArr2[i3] = iArr2[i3] >>> 24;
                            i3 += 5;
                        }
                        if (iArr2.length != i10) {
                            throw new java.lang.RuntimeException();
                        }
                        boolean z = false;
                        for (int i11 = 0; i11 < readInt4; i11++) {
                            int i12 = i11 * 5;
                            if (this.a.containsKey(java.lang.Integer.valueOf(this.p[i12 + 1]))) {
                                z = true;
                            }
                            int[] iArr4 = this.p;
                            int i13 = iArr4[i12 + 3];
                            if (i13 == 1 || i13 == 2) {
                                int i14 = i12 + 4;
                                com.bytedance.pangle.res.a.k.a(this.j, iArr4[i14], (i14 * 4) + a4, this.i);
                            }
                        }
                        if (z && this.b) {
                            com.bytedance.pangle.res.a.k.a(a4, this.j, this.p, readInt4, this.a);
                        }
                        this.m.a();
                        this.o = this.f;
                        return;
                    }
                    if (readInt2 == 1048835) {
                        this.c.readInt();
                        this.c.readInt();
                        this.o = this.g;
                        this.n = true;
                        return;
                    }
                    if (readInt2 == 1048836) {
                        this.c.readInt();
                        this.c.skipBytes(4);
                        this.c.skipBytes(4);
                        this.o = this.h;
                        return;
                    }
                } else if (readInt2 == 1048832) {
                    int readInt5 = this.c.readInt();
                    int readInt6 = this.c.readInt();
                    com.bytedance.pangle.res.a.b.a aVar3 = this.m;
                    if (aVar3.c == 0) {
                        aVar3.a();
                    }
                    aVar3.b();
                    int i15 = aVar3.b;
                    int i16 = i15 - 1;
                    int[] iArr5 = aVar3.a;
                    int i17 = iArr5[i16];
                    int i18 = (i16 - 1) - (i17 * 2);
                    int i19 = i17 + 1;
                    iArr5[i18] = i19;
                    iArr5[i16] = readInt5;
                    iArr5[i16 + 1] = readInt6;
                    iArr5[i16 + 2] = i19;
                    aVar3.b = i15 + 2;
                } else {
                    this.c.skipBytes(4);
                    this.c.skipBytes(4);
                    com.bytedance.pangle.res.a.b.a aVar4 = this.m;
                    int i20 = aVar4.b;
                    if (i20 != 0 && (i2 = (iArr = aVar4.a)[i20 - 1]) != 0) {
                        int i21 = i2 - 1;
                        int i22 = i - 2;
                        iArr[i22] = i21;
                        iArr[i22 - ((i21 * 2) + 1)] = i21;
                        aVar4.b = i20 - 2;
                    }
                }
            }
        }
    }

    public final void a() {
        if (this.k) {
            this.k = false;
            this.c = null;
            this.l = null;
            com.bytedance.pangle.res.a.b.a aVar = this.m;
            aVar.b = 0;
            aVar.c = 0;
            c();
        }
    }

    public final int b() {
        if (this.c == null) {
            throw new java.lang.RuntimeException("Parser is not opened.");
        }
        try {
            d();
            return this.o;
        } catch (java.io.IOException e) {
            a();
            throw e;
        }
    }
}
