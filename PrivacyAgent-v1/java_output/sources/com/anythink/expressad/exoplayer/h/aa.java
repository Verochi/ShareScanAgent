package com.anythink.expressad.exoplayer.h;

/* loaded from: classes12.dex */
public interface aa {

    public static class a implements com.anythink.expressad.exoplayer.h.aa {
        private final java.util.Random a;
        private final int[] b;
        private final int[] c;

        public a() {
            this(0, new java.util.Random());
        }

        private a(int i, long j) {
            this(i, new java.util.Random(j));
        }

        private a(int i, java.util.Random random) {
            this(a(i, random), random);
        }

        private a(int[] iArr, java.util.Random random) {
            this.b = iArr;
            this.a = random;
            this.c = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.c[iArr[i]] = i;
            }
        }

        private static int[] a(int i, java.util.Random random) {
            int[] iArr = new int[i];
            int i2 = 0;
            while (i2 < i) {
                int i3 = i2 + 1;
                int nextInt = random.nextInt(i3);
                iArr[i2] = iArr[nextInt];
                iArr[nextInt] = i2;
                i2 = i3;
            }
            return iArr;
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final int a() {
            return this.b.length;
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final int a(int i) {
            int i2 = this.c[i] + 1;
            int[] iArr = this.b;
            if (i2 < iArr.length) {
                return iArr[i2];
            }
            return -1;
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final com.anythink.expressad.exoplayer.h.aa a(int i, int i2) {
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            int i3 = 0;
            int i4 = 0;
            while (i4 < i2) {
                iArr[i4] = this.a.nextInt(this.b.length + 1);
                int i5 = i4 + 1;
                int nextInt = this.a.nextInt(i5);
                iArr2[i4] = iArr2[nextInt];
                iArr2[nextInt] = i4 + i;
                i4 = i5;
            }
            java.util.Arrays.sort(iArr);
            int[] iArr3 = new int[this.b.length + i2];
            int i6 = 0;
            int i7 = 0;
            while (true) {
                int[] iArr4 = this.b;
                if (i3 >= iArr4.length + i2) {
                    return new com.anythink.expressad.exoplayer.h.aa.a(iArr3, new java.util.Random(this.a.nextLong()));
                }
                if (i6 >= i2 || i7 != iArr[i6]) {
                    int i8 = i7 + 1;
                    int i9 = iArr4[i7];
                    iArr3[i3] = i9;
                    if (i9 >= i) {
                        iArr3[i3] = i9 + i2;
                    }
                    i7 = i8;
                } else {
                    iArr3[i3] = iArr2[i6];
                    i6++;
                }
                i3++;
            }
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final int b() {
            int[] iArr = this.b;
            if (iArr.length > 0) {
                return iArr[iArr.length - 1];
            }
            return -1;
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final int b(int i) {
            int i2 = this.c[i] - 1;
            if (i2 >= 0) {
                return this.b[i2];
            }
            return -1;
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final int c() {
            int[] iArr = this.b;
            if (iArr.length > 0) {
                return iArr[0];
            }
            return -1;
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final com.anythink.expressad.exoplayer.h.aa c(int i) {
            int[] iArr = new int[this.b.length - 1];
            int i2 = 0;
            boolean z = false;
            while (true) {
                int[] iArr2 = this.b;
                if (i2 >= iArr2.length) {
                    return new com.anythink.expressad.exoplayer.h.aa.a(iArr, new java.util.Random(this.a.nextLong()));
                }
                int i3 = iArr2[i2];
                if (i3 == i) {
                    z = true;
                } else {
                    int i4 = z ? i2 - 1 : i2;
                    if (i3 > i) {
                        i3--;
                    }
                    iArr[i4] = i3;
                }
                i2++;
            }
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final com.anythink.expressad.exoplayer.h.aa d() {
            return new com.anythink.expressad.exoplayer.h.aa.a(0, new java.util.Random(this.a.nextLong()));
        }
    }

    public static final class b implements com.anythink.expressad.exoplayer.h.aa {
        private final int a;

        public b(int i) {
            this.a = i;
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final int a() {
            return this.a;
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final int a(int i) {
            int i2 = i + 1;
            if (i2 < this.a) {
                return i2;
            }
            return -1;
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final com.anythink.expressad.exoplayer.h.aa a(int i, int i2) {
            return new com.anythink.expressad.exoplayer.h.aa.b(this.a + i2);
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final int b() {
            int i = this.a;
            if (i > 0) {
                return i - 1;
            }
            return -1;
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final int b(int i) {
            int i2 = i - 1;
            if (i2 >= 0) {
                return i2;
            }
            return -1;
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final int c() {
            return this.a > 0 ? 0 : -1;
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final com.anythink.expressad.exoplayer.h.aa c(int i) {
            return new com.anythink.expressad.exoplayer.h.aa.b(this.a - 1);
        }

        @Override // com.anythink.expressad.exoplayer.h.aa
        public final com.anythink.expressad.exoplayer.h.aa d() {
            return new com.anythink.expressad.exoplayer.h.aa.b(0);
        }
    }

    int a();

    int a(int i);

    com.anythink.expressad.exoplayer.h.aa a(int i, int i2);

    int b();

    int b(int i);

    int c();

    com.anythink.expressad.exoplayer.h.aa c(int i);

    com.anythink.expressad.exoplayer.h.aa d();
}
