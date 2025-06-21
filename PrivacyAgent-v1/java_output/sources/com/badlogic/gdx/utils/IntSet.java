package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
public class IntSet {
    public int[] a;
    public int b;
    public int c;
    public boolean d;
    public float e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public com.badlogic.gdx.utils.IntSet.IntSetIterator k;
    public com.badlogic.gdx.utils.IntSet.IntSetIterator l;
    public int size;

    public static class IntSetIterator {
        public final com.badlogic.gdx.utils.IntSet a;
        public int b;
        public int c;
        public boolean d = true;
        public boolean hasNext;

        public IntSetIterator(com.badlogic.gdx.utils.IntSet intSet) {
            this.a = intSet;
            reset();
        }

        public void a() {
            int i;
            this.hasNext = false;
            com.badlogic.gdx.utils.IntSet intSet = this.a;
            int[] iArr = intSet.a;
            int i2 = intSet.b + intSet.c;
            do {
                i = this.b + 1;
                this.b = i;
                if (i >= i2) {
                    return;
                }
            } while (iArr[i] == 0);
            this.hasNext = true;
        }

        public int next() {
            if (!this.hasNext) {
                throw new java.util.NoSuchElementException();
            }
            if (!this.d) {
                throw new com.badlogic.gdx.utils.GdxRuntimeException("#iterator() cannot be used nested.");
            }
            int i = this.b;
            int i2 = i == -1 ? 0 : this.a.a[i];
            this.c = i;
            a();
            return i2;
        }

        public void remove() {
            int i = this.c;
            if (i == -1) {
                com.badlogic.gdx.utils.IntSet intSet = this.a;
                if (intSet.d) {
                    intSet.d = false;
                    this.c = -2;
                    com.badlogic.gdx.utils.IntSet intSet2 = this.a;
                    intSet2.size--;
                }
            }
            if (i < 0) {
                throw new java.lang.IllegalStateException("next must be called before remove.");
            }
            com.badlogic.gdx.utils.IntSet intSet3 = this.a;
            if (i >= intSet3.b) {
                intSet3.h(i);
                this.b = this.c - 1;
                a();
            } else {
                intSet3.a[i] = 0;
            }
            this.c = -2;
            com.badlogic.gdx.utils.IntSet intSet22 = this.a;
            intSet22.size--;
        }

        public void reset() {
            this.c = -2;
            this.b = -1;
            if (this.a.d) {
                this.hasNext = true;
            } else {
                a();
            }
        }

        public com.badlogic.gdx.utils.IntArray toArray() {
            com.badlogic.gdx.utils.IntArray intArray = new com.badlogic.gdx.utils.IntArray(true, this.a.size);
            while (this.hasNext) {
                intArray.add(next());
            }
            return intArray;
        }
    }

    public IntSet() {
        this(51, 0.8f);
    }

    public IntSet(int i) {
        this(i, 0.8f);
    }

    public IntSet(int i, float f) {
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("initialCapacity must be >= 0: " + i);
        }
        int nextPowerOfTwo = com.badlogic.gdx.math.MathUtils.nextPowerOfTwo((int) java.lang.Math.ceil(i / f));
        if (nextPowerOfTwo > 1073741824) {
            throw new java.lang.IllegalArgumentException("initialCapacity is too large: " + nextPowerOfTwo);
        }
        this.b = nextPowerOfTwo;
        if (f <= 0.0f) {
            throw new java.lang.IllegalArgumentException("loadFactor must be > 0: " + f);
        }
        this.e = f;
        this.h = (int) (nextPowerOfTwo * f);
        this.g = nextPowerOfTwo - 1;
        this.f = 31 - java.lang.Integer.numberOfTrailingZeros(nextPowerOfTwo);
        this.i = java.lang.Math.max(3, ((int) java.lang.Math.ceil(java.lang.Math.log(this.b))) * 2);
        this.j = java.lang.Math.max(java.lang.Math.min(this.b, 8), ((int) java.lang.Math.sqrt(this.b)) / 8);
        this.a = new int[this.b + this.i];
    }

    public IntSet(com.badlogic.gdx.utils.IntSet intSet) {
        this((int) java.lang.Math.floor(intSet.b * intSet.e), intSet.e);
        this.c = intSet.c;
        int[] iArr = intSet.a;
        java.lang.System.arraycopy(iArr, 0, this.a, 0, iArr.length);
        this.size = intSet.size;
        this.d = intSet.d;
    }

    public static com.badlogic.gdx.utils.IntSet with(int... iArr) {
        com.badlogic.gdx.utils.IntSet intSet = new com.badlogic.gdx.utils.IntSet();
        intSet.addAll(iArr);
        return intSet;
    }

    public final void a(int i) {
        if (i == 0) {
            this.d = true;
            return;
        }
        int i2 = i & this.g;
        int[] iArr = this.a;
        int i3 = iArr[i2];
        if (i3 == 0) {
            iArr[i2] = i;
            int i4 = this.size;
            this.size = i4 + 1;
            if (i4 >= this.h) {
                i(this.b << 1);
                return;
            }
            return;
        }
        int d = d(i);
        int[] iArr2 = this.a;
        int i5 = iArr2[d];
        if (i5 == 0) {
            iArr2[d] = i;
            int i6 = this.size;
            this.size = i6 + 1;
            if (i6 >= this.h) {
                i(this.b << 1);
                return;
            }
            return;
        }
        int e = e(i);
        int[] iArr3 = this.a;
        int i7 = iArr3[e];
        if (i7 != 0) {
            f(i, i2, i3, d, i5, e, i7);
            return;
        }
        iArr3[e] = i;
        int i8 = this.size;
        this.size = i8 + 1;
        if (i8 >= this.h) {
            i(this.b << 1);
        }
    }

    public boolean add(int i) {
        int d;
        int i2;
        int e;
        int i3;
        if (i == 0) {
            if (this.d) {
                return false;
            }
            this.d = true;
            this.size++;
            return true;
        }
        int[] iArr = this.a;
        int i4 = i & this.g;
        int i5 = iArr[i4];
        if (i5 == i || (i2 = iArr[(d = d(i))]) == i || (i3 = iArr[(e = e(i))]) == i) {
            return false;
        }
        int i6 = this.b;
        int i7 = this.c + i6;
        while (i6 < i7) {
            if (iArr[i6] == i) {
                return false;
            }
            i6++;
        }
        if (i5 == 0) {
            iArr[i4] = i;
            int i8 = this.size;
            this.size = i8 + 1;
            if (i8 >= this.h) {
                i(this.b << 1);
            }
            return true;
        }
        if (i2 == 0) {
            iArr[d] = i;
            int i9 = this.size;
            this.size = i9 + 1;
            if (i9 >= this.h) {
                i(this.b << 1);
            }
            return true;
        }
        if (i3 != 0) {
            f(i, i4, i5, d, i2, e, i3);
            return true;
        }
        iArr[e] = i;
        int i10 = this.size;
        this.size = i10 + 1;
        if (i10 >= this.h) {
            i(this.b << 1);
        }
        return true;
    }

    public void addAll(com.badlogic.gdx.utils.IntArray intArray) {
        addAll(intArray, 0, intArray.size);
    }

    public void addAll(com.badlogic.gdx.utils.IntArray intArray, int i, int i2) {
        if (i + i2 <= intArray.size) {
            addAll(intArray.items, i, i2);
            return;
        }
        throw new java.lang.IllegalArgumentException("offset + length must be <= size: " + i + " + " + i2 + " <= " + intArray.size);
    }

    public void addAll(com.badlogic.gdx.utils.IntSet intSet) {
        ensureCapacity(intSet.size);
        com.badlogic.gdx.utils.IntSet.IntSetIterator it = intSet.iterator();
        while (it.hasNext) {
            add(it.next());
        }
    }

    public void addAll(int... iArr) {
        addAll(iArr, 0, iArr.length);
    }

    public void addAll(int[] iArr, int i, int i2) {
        ensureCapacity(i2);
        int i3 = i2 + i;
        while (i < i3) {
            add(iArr[i]);
            i++;
        }
    }

    public final void b(int i) {
        int i2 = this.c;
        if (i2 == this.i) {
            i(this.b << 1);
            add(i);
        } else {
            this.a[this.b + i2] = i;
            this.c = i2 + 1;
            this.size++;
        }
    }

    public final boolean c(int i) {
        int[] iArr = this.a;
        int i2 = this.b;
        int i3 = this.c + i2;
        while (i2 < i3) {
            if (iArr[i2] == i) {
                return true;
            }
            i2++;
        }
        return false;
    }

    public void clear() {
        if (this.size == 0) {
            return;
        }
        int[] iArr = this.a;
        int i = this.b + this.c;
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                this.size = 0;
                this.c = 0;
                this.d = false;
                return;
            }
            iArr[i2] = 0;
            i = i2;
        }
    }

    public void clear(int i) {
        if (this.b <= i) {
            clear();
            return;
        }
        this.d = false;
        this.size = 0;
        i(i);
    }

    public boolean contains(int i) {
        if (i == 0) {
            return this.d;
        }
        if (this.a[this.g & i] == i) {
            return true;
        }
        if (this.a[d(i)] == i) {
            return true;
        }
        if (this.a[e(i)] != i) {
            return c(i);
        }
        return true;
    }

    public final int d(int i) {
        int i2 = i * (-1262997959);
        return (i2 ^ (i2 >>> this.f)) & this.g;
    }

    public final int e(int i) {
        int i2 = i * (-825114047);
        return (i2 ^ (i2 >>> this.f)) & this.g;
    }

    public void ensureCapacity(int i) {
        if (this.size + i >= this.h) {
            i(com.badlogic.gdx.math.MathUtils.nextPowerOfTwo((int) java.lang.Math.ceil(r0 / this.e)));
        }
    }

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof com.badlogic.gdx.utils.IntSet)) {
            return false;
        }
        com.badlogic.gdx.utils.IntSet intSet = (com.badlogic.gdx.utils.IntSet) obj;
        if (intSet.size != this.size || intSet.d != this.d) {
            return false;
        }
        int i = this.b + this.c;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.a[i2];
            if (i3 != 0 && !intSet.contains(i3)) {
                return false;
            }
        }
        return true;
    }

    public final void f(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int[] iArr = this.a;
        int i8 = this.g;
        int i9 = this.j;
        int i10 = 0;
        do {
            int random = com.badlogic.gdx.math.MathUtils.random(2);
            if (random == 0) {
                iArr[i2] = i;
                i = i3;
            } else if (random != 1) {
                iArr[i6] = i;
                i = i7;
            } else {
                iArr[i4] = i;
                i = i5;
            }
            i2 = i & i8;
            i3 = iArr[i2];
            if (i3 == 0) {
                iArr[i2] = i;
                int i11 = this.size;
                this.size = i11 + 1;
                if (i11 >= this.h) {
                    i(this.b << 1);
                    return;
                }
                return;
            }
            i4 = d(i);
            i5 = iArr[i4];
            if (i5 == 0) {
                iArr[i4] = i;
                int i12 = this.size;
                this.size = i12 + 1;
                if (i12 >= this.h) {
                    i(this.b << 1);
                    return;
                }
                return;
            }
            i6 = e(i);
            i7 = iArr[i6];
            if (i7 == 0) {
                iArr[i6] = i;
                int i13 = this.size;
                this.size = i13 + 1;
                if (i13 >= this.h) {
                    i(this.b << 1);
                    return;
                }
                return;
            }
            i10++;
        } while (i10 != i9);
        b(i);
    }

    public int first() {
        if (this.d) {
            return 0;
        }
        int[] iArr = this.a;
        int i = this.b + this.c;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2];
            if (i3 != 0) {
                return i3;
            }
        }
        throw new java.lang.IllegalStateException("IntSet is empty.");
    }

    public boolean g(int i) {
        int[] iArr = this.a;
        int i2 = this.b;
        int i3 = this.c + i2;
        while (i2 < i3) {
            if (iArr[i2] == i) {
                h(i2);
                this.size--;
                return true;
            }
            i2++;
        }
        return false;
    }

    public void h(int i) {
        int i2 = this.c - 1;
        this.c = i2;
        int i3 = this.b + i2;
        if (i < i3) {
            int[] iArr = this.a;
            iArr[i] = iArr[i3];
        }
    }

    public int hashCode() {
        int i = this.b + this.c;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = this.a[i3];
            if (i4 != 0) {
                i2 += i4;
            }
        }
        return i2;
    }

    public final void i(int i) {
        int i2 = this.b + this.c;
        this.b = i;
        this.h = (int) (i * this.e);
        this.g = i - 1;
        this.f = 31 - java.lang.Integer.numberOfTrailingZeros(i);
        double d = i;
        this.i = java.lang.Math.max(3, ((int) java.lang.Math.ceil(java.lang.Math.log(d))) * 2);
        this.j = java.lang.Math.max(java.lang.Math.min(i, 8), ((int) java.lang.Math.sqrt(d)) / 8);
        int[] iArr = this.a;
        this.a = new int[i + this.i];
        int i3 = this.size;
        this.size = this.d ? 1 : 0;
        this.c = 0;
        if (i3 > 0) {
            for (int i4 = 0; i4 < i2; i4++) {
                int i5 = iArr[i4];
                if (i5 != 0) {
                    a(i5);
                }
            }
        }
    }

    public com.badlogic.gdx.utils.IntSet.IntSetIterator iterator() {
        if (this.k == null) {
            this.k = new com.badlogic.gdx.utils.IntSet.IntSetIterator(this);
            this.l = new com.badlogic.gdx.utils.IntSet.IntSetIterator(this);
        }
        com.badlogic.gdx.utils.IntSet.IntSetIterator intSetIterator = this.k;
        if (intSetIterator.d) {
            this.l.reset();
            com.badlogic.gdx.utils.IntSet.IntSetIterator intSetIterator2 = this.l;
            intSetIterator2.d = true;
            this.k.d = false;
            return intSetIterator2;
        }
        intSetIterator.reset();
        com.badlogic.gdx.utils.IntSet.IntSetIterator intSetIterator3 = this.k;
        intSetIterator3.d = true;
        this.l.d = false;
        return intSetIterator3;
    }

    public boolean remove(int i) {
        if (i == 0) {
            if (!this.d) {
                return false;
            }
            this.d = false;
            this.size--;
            return true;
        }
        int i2 = this.g & i;
        int[] iArr = this.a;
        if (iArr[i2] == i) {
            iArr[i2] = 0;
            this.size--;
            return true;
        }
        int d = d(i);
        int[] iArr2 = this.a;
        if (iArr2[d] == i) {
            iArr2[d] = 0;
            this.size--;
            return true;
        }
        int e = e(i);
        int[] iArr3 = this.a;
        if (iArr3[e] != i) {
            return g(i);
        }
        iArr3[e] = 0;
        this.size--;
        return true;
    }

    public void shrink(int i) {
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("maximumCapacity must be >= 0: " + i);
        }
        int i2 = this.size;
        if (i2 > i) {
            i = i2;
        }
        if (this.b <= i) {
            return;
        }
        i(com.badlogic.gdx.math.MathUtils.nextPowerOfTwo(i));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x002d -> B:9:0x002e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.lang.String toString() {
        int i;
        if (this.size == 0) {
            return "[]";
        }
        com.badlogic.gdx.utils.StringBuilder stringBuilder = new com.badlogic.gdx.utils.StringBuilder(32);
        stringBuilder.append('[');
        int[] iArr = this.a;
        int length = iArr.length;
        if (this.d) {
            stringBuilder.append("0");
            i = length - 1;
            if (length <= 0) {
                stringBuilder.append(']');
                return stringBuilder.toString();
            }
            int i2 = iArr[i];
            if (i2 != 0) {
                stringBuilder.append(", ");
                stringBuilder.append(i2);
            }
            length = i;
            i = length - 1;
            if (length <= 0) {
            }
        } else {
            while (true) {
                i = length - 1;
                if (length > 0) {
                    int i3 = iArr[i];
                    if (i3 != 0) {
                        stringBuilder.append(i3);
                        break;
                    }
                    length = i;
                } else {
                    break;
                }
            }
            length = i;
            i = length - 1;
            if (length <= 0) {
            }
        }
    }
}
