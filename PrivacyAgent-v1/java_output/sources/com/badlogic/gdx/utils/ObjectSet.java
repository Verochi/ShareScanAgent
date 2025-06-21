package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
public class ObjectSet<T> implements java.lang.Iterable<T> {
    public int A;
    public com.badlogic.gdx.utils.ObjectSet.ObjectSetIterator B;
    public com.badlogic.gdx.utils.ObjectSet.ObjectSetIterator C;
    public T[] n;
    public int size;
    public int t;
    public int u;
    public float v;
    public int w;
    public int x;
    public int y;
    public int z;

    public static class ObjectSetIterator<K> implements java.lang.Iterable<K>, java.util.Iterator<K> {
        public boolean hasNext;
        public final com.badlogic.gdx.utils.ObjectSet<K> n;
        public int t;
        public int u;
        public boolean v = true;

        public ObjectSetIterator(com.badlogic.gdx.utils.ObjectSet<K> objectSet) {
            this.n = objectSet;
            reset();
        }

        public void a() {
            int i;
            this.hasNext = false;
            com.badlogic.gdx.utils.ObjectSet<K> objectSet = this.n;
            K[] kArr = objectSet.n;
            int i2 = objectSet.t + objectSet.u;
            do {
                i = this.t + 1;
                this.t = i;
                if (i >= i2) {
                    return;
                }
            } while (kArr[i] == null);
            this.hasNext = true;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.v) {
                return this.hasNext;
            }
            throw new com.badlogic.gdx.utils.GdxRuntimeException("#iterator() cannot be used nested.");
        }

        @Override // java.lang.Iterable
        public com.badlogic.gdx.utils.ObjectSet.ObjectSetIterator<K> iterator() {
            return this;
        }

        @Override // java.util.Iterator
        public K next() {
            if (!this.hasNext) {
                throw new java.util.NoSuchElementException();
            }
            if (!this.v) {
                throw new com.badlogic.gdx.utils.GdxRuntimeException("#iterator() cannot be used nested.");
            }
            K[] kArr = this.n.n;
            int i = this.t;
            K k = kArr[i];
            this.u = i;
            a();
            return k;
        }

        @Override // java.util.Iterator
        public void remove() {
            int i = this.u;
            if (i < 0) {
                throw new java.lang.IllegalStateException("next must be called before remove.");
            }
            com.badlogic.gdx.utils.ObjectSet<K> objectSet = this.n;
            if (i >= objectSet.t) {
                objectSet.h(i);
                this.t = this.u - 1;
                a();
            } else {
                objectSet.n[i] = null;
            }
            this.u = -1;
            com.badlogic.gdx.utils.ObjectSet<K> objectSet2 = this.n;
            objectSet2.size--;
        }

        public void reset() {
            this.u = -1;
            this.t = -1;
            a();
        }

        public com.badlogic.gdx.utils.Array<K> toArray() {
            return toArray(new com.badlogic.gdx.utils.Array<>(true, this.n.size));
        }

        public com.badlogic.gdx.utils.Array<K> toArray(com.badlogic.gdx.utils.Array<K> array) {
            while (this.hasNext) {
                array.add(next());
            }
            return array;
        }
    }

    public ObjectSet() {
        this(51, 0.8f);
    }

    public ObjectSet(int i) {
        this(i, 0.8f);
    }

    public ObjectSet(int i, float f) {
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("initialCapacity must be >= 0: " + i);
        }
        int nextPowerOfTwo = com.badlogic.gdx.math.MathUtils.nextPowerOfTwo((int) java.lang.Math.ceil(i / f));
        if (nextPowerOfTwo > 1073741824) {
            throw new java.lang.IllegalArgumentException("initialCapacity is too large: " + nextPowerOfTwo);
        }
        this.t = nextPowerOfTwo;
        if (f <= 0.0f) {
            throw new java.lang.IllegalArgumentException("loadFactor must be > 0: " + f);
        }
        this.v = f;
        this.y = (int) (nextPowerOfTwo * f);
        this.x = nextPowerOfTwo - 1;
        this.w = 31 - java.lang.Integer.numberOfTrailingZeros(nextPowerOfTwo);
        this.z = java.lang.Math.max(3, ((int) java.lang.Math.ceil(java.lang.Math.log(this.t))) * 2);
        this.A = java.lang.Math.max(java.lang.Math.min(this.t, 8), ((int) java.lang.Math.sqrt(this.t)) / 8);
        this.n = (T[]) new java.lang.Object[this.t + this.z];
    }

    public ObjectSet(com.badlogic.gdx.utils.ObjectSet objectSet) {
        this((int) java.lang.Math.floor(objectSet.t * objectSet.v), objectSet.v);
        this.u = objectSet.u;
        T[] tArr = objectSet.n;
        java.lang.System.arraycopy(tArr, 0, this.n, 0, tArr.length);
        this.size = objectSet.size;
    }

    public static <T> com.badlogic.gdx.utils.ObjectSet<T> with(T... tArr) {
        com.badlogic.gdx.utils.ObjectSet<T> objectSet = new com.badlogic.gdx.utils.ObjectSet<>();
        objectSet.addAll(tArr);
        return objectSet;
    }

    public final void a(T t) {
        int hashCode = t.hashCode();
        int i = hashCode & this.x;
        T[] tArr = this.n;
        T t2 = tArr[i];
        if (t2 == null) {
            tArr[i] = t;
            int i2 = this.size;
            this.size = i2 + 1;
            if (i2 >= this.y) {
                i(this.t << 1);
                return;
            }
            return;
        }
        int d = d(hashCode);
        T[] tArr2 = this.n;
        T t3 = tArr2[d];
        if (t3 == null) {
            tArr2[d] = t;
            int i3 = this.size;
            this.size = i3 + 1;
            if (i3 >= this.y) {
                i(this.t << 1);
                return;
            }
            return;
        }
        int e = e(hashCode);
        T[] tArr3 = this.n;
        T t4 = tArr3[e];
        if (t4 != null) {
            f(t, i, t2, d, t3, e, t4);
            return;
        }
        tArr3[e] = t;
        int i4 = this.size;
        this.size = i4 + 1;
        if (i4 >= this.y) {
            i(this.t << 1);
        }
    }

    public boolean add(T t) {
        if (t == null) {
            throw new java.lang.IllegalArgumentException("key cannot be null.");
        }
        java.lang.Object[] objArr = this.n;
        int hashCode = t.hashCode();
        int i = hashCode & this.x;
        T t2 = objArr[i];
        if (t.equals(t2)) {
            return false;
        }
        int d = d(hashCode);
        T t3 = objArr[d];
        if (t.equals(t3)) {
            return false;
        }
        int e = e(hashCode);
        T t4 = objArr[e];
        if (t.equals(t4)) {
            return false;
        }
        int i2 = this.t;
        int i3 = this.u + i2;
        while (i2 < i3) {
            if (t.equals(objArr[i2])) {
                return false;
            }
            i2++;
        }
        if (t2 == null) {
            objArr[i] = t;
            int i4 = this.size;
            this.size = i4 + 1;
            if (i4 >= this.y) {
                i(this.t << 1);
            }
            return true;
        }
        if (t3 == null) {
            objArr[d] = t;
            int i5 = this.size;
            this.size = i5 + 1;
            if (i5 >= this.y) {
                i(this.t << 1);
            }
            return true;
        }
        if (t4 != null) {
            f(t, i, t2, d, t3, e, t4);
            return true;
        }
        objArr[e] = t;
        int i6 = this.size;
        this.size = i6 + 1;
        if (i6 >= this.y) {
            i(this.t << 1);
        }
        return true;
    }

    public void addAll(com.badlogic.gdx.utils.Array<? extends T> array) {
        addAll(array, 0, array.size);
    }

    public void addAll(com.badlogic.gdx.utils.Array<? extends T> array, int i, int i2) {
        if (i + i2 <= array.size) {
            addAll(array.items, i, i2);
            return;
        }
        throw new java.lang.IllegalArgumentException("offset + length must be <= size: " + i + " + " + i2 + " <= " + array.size);
    }

    public void addAll(com.badlogic.gdx.utils.ObjectSet<T> objectSet) {
        ensureCapacity(objectSet.size);
        com.badlogic.gdx.utils.ObjectSet.ObjectSetIterator<T> it = objectSet.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    public void addAll(T... tArr) {
        addAll(tArr, 0, tArr.length);
    }

    public void addAll(T[] tArr, int i, int i2) {
        ensureCapacity(i2);
        int i3 = i2 + i;
        while (i < i3) {
            add(tArr[i]);
            i++;
        }
    }

    public final void b(T t) {
        int i = this.u;
        if (i == this.z) {
            i(this.t << 1);
            add(t);
        } else {
            this.n[this.t + i] = t;
            this.u = i + 1;
            this.size++;
        }
    }

    public final boolean c(T t) {
        T[] tArr = this.n;
        int i = this.t;
        int i2 = this.u + i;
        while (i < i2) {
            if (t.equals(tArr[i])) {
                return true;
            }
            i++;
        }
        return false;
    }

    public void clear() {
        if (this.size == 0) {
            return;
        }
        T[] tArr = this.n;
        int i = this.t + this.u;
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                this.size = 0;
                this.u = 0;
                return;
            } else {
                tArr[i2] = null;
                i = i2;
            }
        }
    }

    public void clear(int i) {
        if (this.t <= i) {
            clear();
        } else {
            this.size = 0;
            i(i);
        }
    }

    public boolean contains(T t) {
        int hashCode = t.hashCode();
        if (t.equals(this.n[this.x & hashCode])) {
            return true;
        }
        if (t.equals(this.n[d(hashCode)])) {
            return true;
        }
        if (t.equals(this.n[e(hashCode)])) {
            return true;
        }
        return c(t);
    }

    public final int d(int i) {
        int i2 = i * (-1262997959);
        return (i2 ^ (i2 >>> this.w)) & this.x;
    }

    public final int e(int i) {
        int i2 = i * (-825114047);
        return (i2 ^ (i2 >>> this.w)) & this.x;
    }

    public void ensureCapacity(int i) {
        if (this.size + i >= this.y) {
            i(com.badlogic.gdx.math.MathUtils.nextPowerOfTwo((int) java.lang.Math.ceil(r0 / this.v)));
        }
    }

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof com.badlogic.gdx.utils.ObjectSet)) {
            return false;
        }
        com.badlogic.gdx.utils.ObjectSet objectSet = (com.badlogic.gdx.utils.ObjectSet) obj;
        if (objectSet.size != this.size) {
            return false;
        }
        int i = this.t + this.u;
        for (int i2 = 0; i2 < i; i2++) {
            T t = this.n[i2];
            if (t != null && !objectSet.contains(t)) {
                return false;
            }
        }
        return true;
    }

    public final void f(T t, int i, T t2, int i2, T t3, int i3, T t4) {
        T[] tArr = this.n;
        int i4 = this.x;
        int i5 = this.A;
        int i6 = 0;
        while (true) {
            int random = com.badlogic.gdx.math.MathUtils.random(2);
            if (random == 0) {
                tArr[i] = t;
                t = t2;
            } else if (random != 1) {
                tArr[i3] = t;
                t = t4;
            } else {
                tArr[i2] = t;
                t = t3;
            }
            int hashCode = t.hashCode();
            int i7 = hashCode & i4;
            T t5 = tArr[i7];
            if (t5 == null) {
                tArr[i7] = t;
                int i8 = this.size;
                this.size = i8 + 1;
                if (i8 >= this.y) {
                    i(this.t << 1);
                    return;
                }
                return;
            }
            int d = d(hashCode);
            T t6 = tArr[d];
            if (t6 == null) {
                tArr[d] = t;
                int i9 = this.size;
                this.size = i9 + 1;
                if (i9 >= this.y) {
                    i(this.t << 1);
                    return;
                }
                return;
            }
            int e = e(hashCode);
            t4 = tArr[e];
            if (t4 == null) {
                tArr[e] = t;
                int i10 = this.size;
                this.size = i10 + 1;
                if (i10 >= this.y) {
                    i(this.t << 1);
                    return;
                }
                return;
            }
            i6++;
            if (i6 == i5) {
                b(t);
                return;
            }
            i3 = e;
            i = i7;
            t2 = t5;
            i2 = d;
            t3 = t6;
        }
    }

    public T first() {
        T[] tArr = this.n;
        int i = this.t + this.u;
        for (int i2 = 0; i2 < i; i2++) {
            T t = tArr[i2];
            if (t != null) {
                return t;
            }
        }
        throw new java.lang.IllegalStateException("ObjectSet is empty.");
    }

    public boolean g(T t) {
        T[] tArr = this.n;
        int i = this.t;
        int i2 = this.u + i;
        while (i < i2) {
            if (t.equals(tArr[i])) {
                h(i);
                this.size--;
                return true;
            }
            i++;
        }
        return false;
    }

    public void h(int i) {
        int i2 = this.u - 1;
        this.u = i2;
        int i3 = this.t + i2;
        if (i < i3) {
            T[] tArr = this.n;
            tArr[i] = tArr[i3];
        }
    }

    public int hashCode() {
        int i = this.t + this.u;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            T t = this.n[i3];
            if (t != null) {
                i2 += t.hashCode();
            }
        }
        return i2;
    }

    public final void i(int i) {
        int i2 = this.t + this.u;
        this.t = i;
        this.y = (int) (i * this.v);
        this.x = i - 1;
        this.w = 31 - java.lang.Integer.numberOfTrailingZeros(i);
        double d = i;
        this.z = java.lang.Math.max(3, ((int) java.lang.Math.ceil(java.lang.Math.log(d))) * 2);
        this.A = java.lang.Math.max(java.lang.Math.min(i, 8), ((int) java.lang.Math.sqrt(d)) / 8);
        T[] tArr = this.n;
        this.n = (T[]) new java.lang.Object[i + this.z];
        int i3 = this.size;
        this.size = 0;
        this.u = 0;
        if (i3 > 0) {
            for (int i4 = 0; i4 < i2; i4++) {
                T t = tArr[i4];
                if (t != null) {
                    a(t);
                }
            }
        }
    }

    @Override // java.lang.Iterable
    public com.badlogic.gdx.utils.ObjectSet.ObjectSetIterator<T> iterator() {
        if (this.B == null) {
            this.B = new com.badlogic.gdx.utils.ObjectSet.ObjectSetIterator(this);
            this.C = new com.badlogic.gdx.utils.ObjectSet.ObjectSetIterator(this);
        }
        com.badlogic.gdx.utils.ObjectSet.ObjectSetIterator objectSetIterator = this.B;
        if (objectSetIterator.v) {
            this.C.reset();
            com.badlogic.gdx.utils.ObjectSet.ObjectSetIterator<T> objectSetIterator2 = this.C;
            objectSetIterator2.v = true;
            this.B.v = false;
            return objectSetIterator2;
        }
        objectSetIterator.reset();
        com.badlogic.gdx.utils.ObjectSet.ObjectSetIterator<T> objectSetIterator3 = this.B;
        objectSetIterator3.v = true;
        this.C.v = false;
        return objectSetIterator3;
    }

    public boolean remove(T t) {
        int hashCode = t.hashCode();
        int i = this.x & hashCode;
        if (t.equals(this.n[i])) {
            this.n[i] = null;
            this.size--;
            return true;
        }
        int d = d(hashCode);
        if (t.equals(this.n[d])) {
            this.n[d] = null;
            this.size--;
            return true;
        }
        int e = e(hashCode);
        if (!t.equals(this.n[e])) {
            return g(t);
        }
        this.n[e] = null;
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
        if (this.t <= i) {
            return;
        }
        i(com.badlogic.gdx.math.MathUtils.nextPowerOfTwo(i));
    }

    public java.lang.String toString() {
        return '{' + toString(", ") + '}';
    }

    public java.lang.String toString(java.lang.String str) {
        int i;
        if (this.size == 0) {
            return "";
        }
        com.badlogic.gdx.utils.StringBuilder stringBuilder = new com.badlogic.gdx.utils.StringBuilder(32);
        T[] tArr = this.n;
        int length = tArr.length;
        while (true) {
            i = length - 1;
            if (length > 0) {
                T t = tArr[i];
                if (t != null) {
                    stringBuilder.append(t);
                    break;
                }
                length = i;
            } else {
                break;
            }
        }
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return stringBuilder.toString();
            }
            T t2 = tArr[i2];
            if (t2 != null) {
                stringBuilder.append(str);
                stringBuilder.append(t2);
            }
            i = i2;
        }
    }
}
