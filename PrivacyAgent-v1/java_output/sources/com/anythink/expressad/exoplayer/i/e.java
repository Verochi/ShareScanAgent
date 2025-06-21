package com.anythink.expressad.exoplayer.i;

/* loaded from: classes12.dex */
public abstract class e extends com.anythink.expressad.exoplayer.i.h {

    @androidx.annotation.Nullable
    private com.anythink.expressad.exoplayer.i.e.a a;

    public static final class a {
        public static final int a = 0;
        public static final int b = 1;
        public static final int c = 2;
        public static final int d = 3;

        @java.lang.Deprecated
        public final int e;
        private final int f;
        private final int[] g;
        private final com.anythink.expressad.exoplayer.h.af[] h;
        private final int[] i;
        private final int[][][] j;
        private final com.anythink.expressad.exoplayer.h.af k;

        @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
        /* renamed from: com.anythink.expressad.exoplayer.i.e$a$a, reason: collision with other inner class name */
        public @interface InterfaceC0202a {
        }

        public a(int[] iArr, com.anythink.expressad.exoplayer.h.af[] afVarArr, int[] iArr2, int[][][] iArr3, com.anythink.expressad.exoplayer.h.af afVar) {
            this.g = iArr;
            this.h = afVarArr;
            this.j = iArr3;
            this.i = iArr2;
            this.k = afVar;
            int length = iArr.length;
            this.f = length;
            this.e = length;
        }

        private int a(int i, int i2, int[] iArr) {
            int i3 = 0;
            java.lang.String str = null;
            boolean z = false;
            int i4 = 0;
            int i5 = 16;
            while (i3 < iArr.length) {
                java.lang.String str2 = this.h[i].a(i2).a(iArr[i3]).h;
                int i6 = i4 + 1;
                if (i4 == 0) {
                    str = str2;
                } else {
                    z |= !com.anythink.expressad.exoplayer.k.af.a((java.lang.Object) str, (java.lang.Object) str2);
                }
                i5 = java.lang.Math.min(i5, this.j[i][i2][i3] & 24);
                i3++;
                i4 = i6;
            }
            return z ? java.lang.Math.min(i5, this.i[i]) : i5;
        }

        @java.lang.Deprecated
        private int b(int i, int i2, int i3) {
            return a(i, i2, i3);
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0025, code lost:
        
            r1 = r1 + 1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private int c(int i) {
            int i2;
            int[][] iArr = this.j[i];
            int i3 = 0;
            int i4 = 0;
            while (i3 < iArr.length) {
                int i5 = 0;
                while (true) {
                    int[] iArr2 = iArr[i3];
                    if (i5 < iArr2.length) {
                        int i6 = iArr2[i5] & 7;
                        if (i6 == 3) {
                            i2 = 2;
                        } else {
                            if (i6 == 4) {
                                return 3;
                            }
                            i2 = 1;
                        }
                        i4 = java.lang.Math.max(i4, i2);
                        i5++;
                    }
                }
            }
            return i4;
        }

        @java.lang.Deprecated
        private com.anythink.expressad.exoplayer.h.af c() {
            return this.k;
        }

        @java.lang.Deprecated
        private int d(int i) {
            int i2;
            int i3 = 0;
            for (int i4 = 0; i4 < this.f; i4++) {
                if (this.g[i4] == i) {
                    int[][] iArr = this.j[i4];
                    int i5 = 0;
                    int i6 = 0;
                    while (true) {
                        if (i5 >= iArr.length) {
                            break;
                        }
                        int i7 = 0;
                        while (true) {
                            int[] iArr2 = iArr[i5];
                            if (i7 < iArr2.length) {
                                int i8 = iArr2[i7] & 7;
                                if (i8 == 3) {
                                    i2 = 2;
                                } else {
                                    if (i8 == 4) {
                                        i6 = 3;
                                        break;
                                    }
                                    i2 = 1;
                                }
                                i6 = java.lang.Math.max(i6, i2);
                                i7++;
                            }
                        }
                        i5++;
                    }
                    i3 = java.lang.Math.max(i3, i6);
                }
            }
            return i3;
        }

        private int e(int i) {
            int i2;
            int i3 = 0;
            for (int i4 = 0; i4 < this.f; i4++) {
                if (this.g[i4] == i) {
                    int[][] iArr = this.j[i4];
                    int i5 = 0;
                    int i6 = 0;
                    while (true) {
                        if (i5 >= iArr.length) {
                            break;
                        }
                        int i7 = 0;
                        while (true) {
                            int[] iArr2 = iArr[i5];
                            if (i7 < iArr2.length) {
                                int i8 = iArr2[i7] & 7;
                                if (i8 == 3) {
                                    i2 = 2;
                                } else {
                                    if (i8 == 4) {
                                        i6 = 3;
                                        break;
                                    }
                                    i2 = 1;
                                }
                                i6 = java.lang.Math.max(i6, i2);
                                i7++;
                            }
                        }
                        i5++;
                    }
                    i3 = java.lang.Math.max(i3, i6);
                }
            }
            return i3;
        }

        public final int a() {
            return this.f;
        }

        public final int a(int i) {
            return this.g[i];
        }

        public final int a(int i, int i2) {
            int i3 = this.h[i].a(i2).a;
            int[] iArr = new int[i3];
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < i3; i6++) {
                if (a(i, i2, i6) == 4) {
                    iArr[i5] = i6;
                    i5++;
                }
            }
            int[] copyOf = java.util.Arrays.copyOf(iArr, i5);
            int i7 = 16;
            java.lang.String str = null;
            boolean z = false;
            int i8 = 0;
            while (i4 < copyOf.length) {
                java.lang.String str2 = this.h[i].a(i2).a(copyOf[i4]).h;
                int i9 = i8 + 1;
                if (i8 == 0) {
                    str = str2;
                } else {
                    z |= !com.anythink.expressad.exoplayer.k.af.a((java.lang.Object) str, (java.lang.Object) str2);
                }
                i7 = java.lang.Math.min(i7, this.j[i][i2][i4] & 24);
                i4++;
                i8 = i9;
            }
            return z ? java.lang.Math.min(i7, this.i[i]) : i7;
        }

        public final int a(int i, int i2, int i3) {
            return this.j[i][i2][i3] & 7;
        }

        public final com.anythink.expressad.exoplayer.h.af b() {
            return this.k;
        }

        public final com.anythink.expressad.exoplayer.h.af b(int i) {
            return this.h[i];
        }
    }

    private static int a(com.anythink.expressad.exoplayer.z[] zVarArr, com.anythink.expressad.exoplayer.h.ae aeVar) {
        int length = zVarArr.length;
        int i = 0;
        for (int i2 = 0; i2 < zVarArr.length; i2++) {
            com.anythink.expressad.exoplayer.z zVar = zVarArr[i2];
            for (int i3 = 0; i3 < aeVar.a; i3++) {
                int a2 = zVar.a(aeVar.a(i3)) & 7;
                if (a2 > i) {
                    if (a2 == 4) {
                        return i2;
                    }
                    length = i2;
                    i = a2;
                }
            }
        }
        return length;
    }

    private static int[] a(com.anythink.expressad.exoplayer.z zVar, com.anythink.expressad.exoplayer.h.ae aeVar) {
        int[] iArr = new int[aeVar.a];
        for (int i = 0; i < aeVar.a; i++) {
            iArr[i] = zVar.a(aeVar.a(i));
        }
        return iArr;
    }

    private static int[] a(com.anythink.expressad.exoplayer.z[] zVarArr) {
        int length = zVarArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = zVarArr[i].m();
        }
        return iArr;
    }

    public abstract android.util.Pair<com.anythink.expressad.exoplayer.aa[], com.anythink.expressad.exoplayer.i.f[]> a(com.anythink.expressad.exoplayer.i.e.a aVar, int[][][] iArr, int[] iArr2);

    @androidx.annotation.Nullable
    public final com.anythink.expressad.exoplayer.i.e.a a() {
        return this.a;
    }

    @Override // com.anythink.expressad.exoplayer.i.h
    public final com.anythink.expressad.exoplayer.i.i a(com.anythink.expressad.exoplayer.z[] zVarArr, com.anythink.expressad.exoplayer.h.af afVar) {
        int[] iArr;
        int[] iArr2 = new int[zVarArr.length + 1];
        int length = zVarArr.length + 1;
        com.anythink.expressad.exoplayer.h.ae[][] aeVarArr = new com.anythink.expressad.exoplayer.h.ae[length][];
        int[][][] iArr3 = new int[zVarArr.length + 1][][];
        for (int i = 0; i < length; i++) {
            int i2 = afVar.b;
            aeVarArr[i] = new com.anythink.expressad.exoplayer.h.ae[i2];
            iArr3[i] = new int[i2][];
        }
        int length2 = zVarArr.length;
        int[] iArr4 = new int[length2];
        for (int i3 = 0; i3 < length2; i3++) {
            iArr4[i3] = zVarArr[i3].m();
        }
        for (int i4 = 0; i4 < afVar.b; i4++) {
            com.anythink.expressad.exoplayer.h.ae a2 = afVar.a(i4);
            int length3 = zVarArr.length;
            int i5 = 0;
            int i6 = 0;
            while (true) {
                if (i5 >= zVarArr.length) {
                    break;
                }
                com.anythink.expressad.exoplayer.z zVar = zVarArr[i5];
                for (int i7 = 0; i7 < a2.a; i7++) {
                    int a3 = zVar.a(a2.a(i7)) & 7;
                    if (a3 > i6) {
                        if (a3 == 4) {
                            length3 = i5;
                            break;
                        }
                        length3 = i5;
                        i6 = a3;
                    }
                }
                i5++;
            }
            if (length3 == zVarArr.length) {
                iArr = new int[a2.a];
            } else {
                com.anythink.expressad.exoplayer.z zVar2 = zVarArr[length3];
                int[] iArr5 = new int[a2.a];
                for (int i8 = 0; i8 < a2.a; i8++) {
                    iArr5[i8] = zVar2.a(a2.a(i8));
                }
                iArr = iArr5;
            }
            int i9 = iArr2[length3];
            aeVarArr[length3][i9] = a2;
            iArr3[length3][i9] = iArr;
            iArr2[length3] = i9 + 1;
        }
        com.anythink.expressad.exoplayer.h.af[] afVarArr = new com.anythink.expressad.exoplayer.h.af[zVarArr.length];
        int[] iArr6 = new int[zVarArr.length];
        for (int i10 = 0; i10 < zVarArr.length; i10++) {
            int i11 = iArr2[i10];
            afVarArr[i10] = new com.anythink.expressad.exoplayer.h.af((com.anythink.expressad.exoplayer.h.ae[]) com.anythink.expressad.exoplayer.k.af.a(aeVarArr[i10], i11));
            iArr3[i10] = (int[][]) com.anythink.expressad.exoplayer.k.af.a(iArr3[i10], i11);
            iArr6[i10] = zVarArr[i10].a();
        }
        com.anythink.expressad.exoplayer.i.e.a aVar = new com.anythink.expressad.exoplayer.i.e.a(iArr6, afVarArr, iArr4, iArr3, new com.anythink.expressad.exoplayer.h.af((com.anythink.expressad.exoplayer.h.ae[]) com.anythink.expressad.exoplayer.k.af.a(aeVarArr[zVarArr.length], iArr2[zVarArr.length])));
        android.util.Pair<com.anythink.expressad.exoplayer.aa[], com.anythink.expressad.exoplayer.i.f[]> a4 = a(aVar, iArr3, iArr4);
        return new com.anythink.expressad.exoplayer.i.i((com.anythink.expressad.exoplayer.aa[]) a4.first, (com.anythink.expressad.exoplayer.i.f[]) a4.second, aVar);
    }

    @Override // com.anythink.expressad.exoplayer.i.h
    public final void a(java.lang.Object obj) {
        this.a = (com.anythink.expressad.exoplayer.i.e.a) obj;
    }
}
