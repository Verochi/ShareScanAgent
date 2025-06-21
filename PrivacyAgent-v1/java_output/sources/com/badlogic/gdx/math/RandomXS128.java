package com.badlogic.gdx.math;

/* loaded from: classes12.dex */
public class RandomXS128 extends java.util.Random {
    private static final double NORM_DOUBLE = 1.1102230246251565E-16d;
    private static final double NORM_FLOAT = 5.960464477539063E-8d;
    private long seed0;
    private long seed1;

    public RandomXS128() {
        setSeed(new java.util.Random().nextLong());
    }

    public RandomXS128(long j) {
        setSeed(j);
    }

    public RandomXS128(long j, long j2) {
        setState(j, j2);
    }

    private static final long murmurHash3(long j) {
        long j2 = (j ^ (j >>> 33)) * (-49064778989728563L);
        long j3 = (j2 ^ (j2 >>> 33)) * (-4265267296055464877L);
        return j3 ^ (j3 >>> 33);
    }

    public long getState(int i) {
        return i == 0 ? this.seed0 : this.seed1;
    }

    @Override // java.util.Random
    public final int next(int i) {
        return (int) (nextLong() & ((1 << i) - 1));
    }

    @Override // java.util.Random
    public boolean nextBoolean() {
        return (nextLong() & 1) != 0;
    }

    @Override // java.util.Random
    public void nextBytes(byte[] bArr) {
        int length = bArr.length;
        while (length != 0) {
            int i = length < 8 ? length : 8;
            long nextLong = nextLong();
            while (true) {
                int i2 = i - 1;
                if (i != 0) {
                    length--;
                    bArr[length] = (byte) nextLong;
                    nextLong >>= 8;
                    i = i2;
                }
            }
        }
    }

    @Override // java.util.Random
    public double nextDouble() {
        return (nextLong() >>> 11) * NORM_DOUBLE;
    }

    @Override // java.util.Random
    public float nextFloat() {
        return (float) ((nextLong() >>> 40) * NORM_FLOAT);
    }

    @Override // java.util.Random
    public int nextInt() {
        return (int) nextLong();
    }

    @Override // java.util.Random
    public int nextInt(int i) {
        return (int) nextLong(i);
    }

    @Override // java.util.Random
    public long nextLong() {
        long j = this.seed0;
        long j2 = this.seed1;
        this.seed0 = j2;
        long j3 = j ^ (j << 23);
        long j4 = ((j3 >>> 17) ^ (j3 ^ j2)) ^ (j2 >>> 26);
        this.seed1 = j4;
        return j4 + j2;
    }

    public long nextLong(long j) {
        long nextLong;
        long j2;
        if (j <= 0) {
            throw new java.lang.IllegalArgumentException("n must be positive");
        }
        do {
            nextLong = nextLong() >>> 1;
            j2 = nextLong % j;
        } while ((nextLong - j2) + (j - 1) < 0);
        return j2;
    }

    @Override // java.util.Random
    public void setSeed(long j) {
        if (j == 0) {
            j = Long.MIN_VALUE;
        }
        long murmurHash3 = murmurHash3(j);
        setState(murmurHash3, murmurHash3(murmurHash3));
    }

    public void setState(long j, long j2) {
        this.seed0 = j;
        this.seed1 = j2;
    }
}
