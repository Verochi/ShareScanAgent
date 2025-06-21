package com.google.android.exoplayer2.source;

/* loaded from: classes22.dex */
public interface ShuffleOrder {

    public static class DefaultShuffleOrder implements com.google.android.exoplayer2.source.ShuffleOrder {
        public final java.util.Random a;
        public final int[] b;
        public final int[] c;

        public DefaultShuffleOrder(int i) {
            this(i, new java.util.Random());
        }

        public DefaultShuffleOrder(int i, long j) {
            this(i, new java.util.Random(j));
        }

        public DefaultShuffleOrder(int i, java.util.Random random) {
            this(a(i, random), random);
        }

        public DefaultShuffleOrder(int[] iArr, long j) {
            this(java.util.Arrays.copyOf(iArr, iArr.length), new java.util.Random(j));
        }

        public DefaultShuffleOrder(int[] iArr, java.util.Random random) {
            this.b = iArr;
            this.a = random;
            this.c = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.c[iArr[i]] = i;
            }
        }

        public static int[] a(int i, java.util.Random random) {
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

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public com.google.android.exoplayer2.source.ShuffleOrder cloneAndClear() {
            return new com.google.android.exoplayer2.source.ShuffleOrder.DefaultShuffleOrder(0, new java.util.Random(this.a.nextLong()));
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public com.google.android.exoplayer2.source.ShuffleOrder cloneAndInsert(int i, int i2) {
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
                    return new com.google.android.exoplayer2.source.ShuffleOrder.DefaultShuffleOrder(iArr3, new java.util.Random(this.a.nextLong()));
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

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public com.google.android.exoplayer2.source.ShuffleOrder cloneAndRemove(int i, int i2) {
            int i3 = i2 - i;
            int[] iArr = new int[this.b.length - i3];
            int i4 = 0;
            int i5 = 0;
            while (true) {
                int[] iArr2 = this.b;
                if (i4 >= iArr2.length) {
                    return new com.google.android.exoplayer2.source.ShuffleOrder.DefaultShuffleOrder(iArr, new java.util.Random(this.a.nextLong()));
                }
                int i6 = iArr2[i4];
                if (i6 < i || i6 >= i2) {
                    int i7 = i4 - i5;
                    if (i6 >= i) {
                        i6 -= i3;
                    }
                    iArr[i7] = i6;
                } else {
                    i5++;
                }
                i4++;
            }
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getFirstIndex() {
            int[] iArr = this.b;
            if (iArr.length > 0) {
                return iArr[0];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getLastIndex() {
            int[] iArr = this.b;
            if (iArr.length > 0) {
                return iArr[iArr.length - 1];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getLength() {
            return this.b.length;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getNextIndex(int i) {
            int i2 = this.c[i] + 1;
            int[] iArr = this.b;
            if (i2 < iArr.length) {
                return iArr[i2];
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getPreviousIndex(int i) {
            int i2 = this.c[i] - 1;
            if (i2 >= 0) {
                return this.b[i2];
            }
            return -1;
        }
    }

    public static final class UnshuffledShuffleOrder implements com.google.android.exoplayer2.source.ShuffleOrder {
        public final int a;

        public UnshuffledShuffleOrder(int i) {
            this.a = i;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public com.google.android.exoplayer2.source.ShuffleOrder cloneAndClear() {
            return new com.google.android.exoplayer2.source.ShuffleOrder.UnshuffledShuffleOrder(0);
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public com.google.android.exoplayer2.source.ShuffleOrder cloneAndInsert(int i, int i2) {
            return new com.google.android.exoplayer2.source.ShuffleOrder.UnshuffledShuffleOrder(this.a + i2);
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public com.google.android.exoplayer2.source.ShuffleOrder cloneAndRemove(int i, int i2) {
            return new com.google.android.exoplayer2.source.ShuffleOrder.UnshuffledShuffleOrder((this.a - i2) + i);
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getFirstIndex() {
            return this.a > 0 ? 0 : -1;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getLastIndex() {
            int i = this.a;
            if (i > 0) {
                return i - 1;
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getLength() {
            return this.a;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getNextIndex(int i) {
            int i2 = i + 1;
            if (i2 < this.a) {
                return i2;
            }
            return -1;
        }

        @Override // com.google.android.exoplayer2.source.ShuffleOrder
        public int getPreviousIndex(int i) {
            int i2 = i - 1;
            if (i2 >= 0) {
                return i2;
            }
            return -1;
        }
    }

    com.google.android.exoplayer2.source.ShuffleOrder cloneAndClear();

    com.google.android.exoplayer2.source.ShuffleOrder cloneAndInsert(int i, int i2);

    com.google.android.exoplayer2.source.ShuffleOrder cloneAndRemove(int i, int i2);

    int getFirstIndex();

    int getLastIndex();

    int getLength();

    int getNextIndex(int i);

    int getPreviousIndex(int i);
}
