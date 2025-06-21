package com.google.common.base;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
final class SmallCharMatcher extends com.google.common.base.CharMatcher.NamedFastMatcher {
    public final char[] t;
    public final boolean u;
    public final long v;

    public SmallCharMatcher(char[] cArr, long j, boolean z, java.lang.String str) {
        super(str);
        this.t = cArr;
        this.v = j;
        this.u = z;
    }

    @com.google.common.annotations.VisibleForTesting
    public static int j(int i) {
        if (i == 1) {
            return 2;
        }
        int highestOneBit = java.lang.Integer.highestOneBit(i - 1) << 1;
        while (highestOneBit * 0.5d < i) {
            highestOneBit <<= 1;
        }
        return highestOneBit;
    }

    public static com.google.common.base.CharMatcher k(java.util.BitSet bitSet, java.lang.String str) {
        int i;
        int cardinality = bitSet.cardinality();
        boolean z = bitSet.get(0);
        int j = j(cardinality);
        char[] cArr = new char[j];
        int i2 = j - 1;
        int nextSetBit = bitSet.nextSetBit(0);
        long j2 = 0;
        while (nextSetBit != -1) {
            long j3 = (1 << nextSetBit) | j2;
            int l = l(nextSetBit);
            while (true) {
                i = l & i2;
                if (cArr[i] == 0) {
                    break;
                }
                l = i + 1;
            }
            cArr[i] = (char) nextSetBit;
            nextSetBit = bitSet.nextSetBit(nextSetBit + 1);
            j2 = j3;
        }
        return new com.google.common.base.SmallCharMatcher(cArr, j2, z, str);
    }

    public static int l(int i) {
        return java.lang.Integer.rotateLeft(i * (-862048943), 15) * 461845907;
    }

    @Override // com.google.common.base.CharMatcher
    public void g(java.util.BitSet bitSet) {
        if (this.u) {
            bitSet.set(0);
        }
        for (char c : this.t) {
            if (c != 0) {
                bitSet.set(c);
            }
        }
    }

    public final boolean i(int i) {
        return 1 == ((this.v >> i) & 1);
    }

    @Override // com.google.common.base.CharMatcher
    public boolean matches(char c) {
        if (c == 0) {
            return this.u;
        }
        if (!i(c)) {
            return false;
        }
        int length = this.t.length - 1;
        int l = l(c) & length;
        int i = l;
        do {
            char c2 = this.t[i];
            if (c2 == 0) {
                return false;
            }
            if (c2 == c) {
                return true;
            }
            i = (i + 1) & length;
        } while (i != l);
        return false;
    }
}
