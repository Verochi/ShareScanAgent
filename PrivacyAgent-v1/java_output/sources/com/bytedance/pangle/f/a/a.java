package com.bytedance.pangle.f.a;

/* loaded from: classes12.dex */
final class a {
    int a;
    com.bytedance.pangle.f.a.b b;
    int[] c;
    private boolean i;
    private com.bytedance.pangle.f.a.f k;
    private boolean j = false;
    private final com.bytedance.pangle.f.a.c l = new com.bytedance.pangle.f.a.c();
    int d = 0;
    int e = 1;
    int f = 2;
    int g = 3;
    int h = 4;

    public a() {
        c();
    }

    private void c() {
        this.c = null;
        this.a = -1;
    }

    private int e(int i) {
        if (this.a != 2) {
            throw new java.lang.IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        int i2 = i * 5;
        if (i2 < this.c.length) {
            return i2;
        }
        throw new java.lang.IndexOutOfBoundsException("Invalid attribute index (" + i + ").");
    }

    public final java.lang.String a(int i) {
        int i2 = this.c[e(i) + 1];
        return i2 == -1 ? "" : this.k.a(i2);
    }

    public final void a() {
        if (this.j) {
            this.j = false;
            com.bytedance.pangle.f.a.b bVar = this.b;
            java.io.InputStream inputStream = bVar.a;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (java.io.IOException unused) {
                }
                bVar.a((java.io.InputStream) null);
            }
            this.k = null;
            this.b = null;
            com.bytedance.pangle.f.a.c cVar = this.l;
            cVar.b = 0;
            cVar.c = 0;
            c();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:106:0x0221, code lost:
    
        throw new java.io.IOException("Invalid chunk type (" + r1 + ").");
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0108, code lost:
    
        throw new java.io.IOException("Invalid resource ids size (" + r1 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int b() {
        int i;
        int[] iArr;
        int i2;
        try {
            com.bytedance.pangle.f.a.b bVar = this.b;
            if (bVar == null) {
                throw new java.io.IOException("Parser is not opened.");
            }
            if (this.k == null) {
                bVar.b(524291);
                this.b.b();
                com.bytedance.pangle.f.a.b bVar2 = this.b;
                bVar2.b(1835009);
                int a = bVar2.a();
                int a2 = bVar2.a();
                int a3 = bVar2.a();
                bVar2.a();
                int a4 = bVar2.a();
                int a5 = bVar2.a();
                com.bytedance.pangle.f.a.f fVar = new com.bytedance.pangle.f.a.f();
                fVar.a = bVar2.a(a2);
                if (a3 != 0) {
                    bVar2.a(a3);
                }
                int i3 = (a5 == 0 ? a : a5) - a4;
                if (i3 % 4 != 0) {
                    throw new java.io.IOException();
                }
                fVar.b = bVar2.a(i3 / 4);
                if (a5 != 0) {
                    int i4 = a - a5;
                    if (i4 % 4 != 0) {
                        throw new java.io.IOException();
                    }
                    bVar2.a(i4 / 4);
                }
                this.k = fVar;
                this.l.a();
                this.j = true;
            }
            int i5 = this.a;
            if (i5 != this.e) {
                c();
                while (true) {
                    int i6 = 0;
                    if (this.i) {
                        this.i = false;
                        com.bytedance.pangle.f.a.c cVar = this.l;
                        int i7 = cVar.b;
                        if (i7 != 0) {
                            int i8 = i7 - 1;
                            int i9 = cVar.a[i8] * 2;
                            if ((i8 - 1) - i9 != 0) {
                                cVar.b = i7 - (i9 + 2);
                                cVar.c--;
                            }
                        }
                    }
                    if (i5 == this.g) {
                        com.bytedance.pangle.f.a.c cVar2 = this.l;
                        if (cVar2.c == 1) {
                            int i10 = cVar2.b;
                            if (i10 != 0) {
                                i6 = cVar2.a[i10 - 1];
                            }
                            if (i6 == 0) {
                                this.a = this.e;
                                break;
                            }
                        }
                    }
                    int a6 = i5 == this.d ? 1048834 : this.b.a();
                    if (a6 != 524672) {
                        if (a6 >= 1048832 && a6 <= 1048836) {
                            if (a6 == 1048834 && i5 == -1) {
                                this.a = this.d;
                                break;
                            }
                            this.b.b();
                            this.b.a();
                            this.b.b();
                            if (a6 != 1048832 && a6 != 1048833) {
                                if (a6 == 1048834) {
                                    this.b.a();
                                    this.b.a();
                                    this.b.b();
                                    int a7 = this.b.a() & 65535;
                                    this.b.a();
                                    this.c = this.b.a(a7 * 5);
                                    int i11 = 3;
                                    while (true) {
                                        int[] iArr2 = this.c;
                                        if (i11 >= iArr2.length) {
                                            break;
                                        }
                                        iArr2[i11] = iArr2[i11] >>> 24;
                                        i11 += 5;
                                    }
                                    this.l.a();
                                    this.a = this.f;
                                } else {
                                    if (a6 == 1048835) {
                                        this.b.a();
                                        this.b.a();
                                        this.a = this.g;
                                        this.i = true;
                                        break;
                                    }
                                    if (a6 == 1048836) {
                                        this.b.a();
                                        this.b.b();
                                        this.b.b();
                                        this.a = this.h;
                                        break;
                                    }
                                }
                            }
                            if (a6 == 1048832) {
                                int a8 = this.b.a();
                                int a9 = this.b.a();
                                com.bytedance.pangle.f.a.c cVar3 = this.l;
                                if (cVar3.c == 0) {
                                    cVar3.a();
                                }
                                cVar3.b();
                                int i12 = cVar3.b;
                                int i13 = i12 - 1;
                                int[] iArr3 = cVar3.a;
                                int i14 = iArr3[i13];
                                int i15 = (i13 - 1) - (i14 * 2);
                                int i16 = i14 + 1;
                                iArr3[i15] = i16;
                                iArr3[i13] = a8;
                                iArr3[i13 + 1] = a9;
                                iArr3[i13 + 2] = i16;
                                cVar3.b = i12 + 2;
                            } else {
                                this.b.b();
                                this.b.b();
                                com.bytedance.pangle.f.a.c cVar4 = this.l;
                                int i17 = cVar4.b;
                                if (i17 != 0 && (i2 = (iArr = cVar4.a)[i17 - 1]) != 0) {
                                    int i18 = i2 - 1;
                                    int i19 = i - 2;
                                    iArr[i19] = i18;
                                    iArr[i19 - ((i18 * 2) + 1)] = i18;
                                    cVar4.b = i17 - 2;
                                }
                            }
                        } else {
                            break;
                        }
                    } else {
                        int a10 = this.b.a();
                        if (a10 < 8 || a10 % 4 != 0) {
                            break;
                        }
                        this.b.a((a10 / 4) - 2);
                    }
                }
            }
            return this.a;
        } catch (java.io.IOException e) {
            a();
            throw e;
        }
    }

    public final int b(int i) {
        return this.c[e(i) + 3];
    }

    public final int c(int i) {
        return this.c[e(i) + 4];
    }

    public final java.lang.String d(int i) {
        int e = e(i);
        int[] iArr = this.c;
        if (iArr[e + 3] != 3) {
            return "";
        }
        return this.k.a(iArr[e + 2]);
    }
}
