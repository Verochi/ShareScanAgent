package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
public class ObjectFloatMap<K> implements java.lang.Iterable<com.badlogic.gdx.utils.ObjectFloatMap.Entry<K>> {
    public int A;
    public int B;
    public com.badlogic.gdx.utils.ObjectFloatMap.Entries C;
    public com.badlogic.gdx.utils.ObjectFloatMap.Entries D;
    public com.badlogic.gdx.utils.ObjectFloatMap.Values E;
    public com.badlogic.gdx.utils.ObjectFloatMap.Values F;
    public com.badlogic.gdx.utils.ObjectFloatMap.Keys G;
    public com.badlogic.gdx.utils.ObjectFloatMap.Keys H;
    public K[] n;
    public int size;
    public float[] t;
    public int u;
    public int v;
    public float w;
    public int x;
    public int y;
    public int z;

    public static class Entries<K> extends com.badlogic.gdx.utils.ObjectFloatMap.MapIterator<K> implements java.lang.Iterable<com.badlogic.gdx.utils.ObjectFloatMap.Entry<K>>, java.util.Iterator<com.badlogic.gdx.utils.ObjectFloatMap.Entry<K>> {
        public com.badlogic.gdx.utils.ObjectFloatMap.Entry<K> w;

        public Entries(com.badlogic.gdx.utils.ObjectFloatMap<K> objectFloatMap) {
            super(objectFloatMap);
            this.w = new com.badlogic.gdx.utils.ObjectFloatMap.Entry<>();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.v) {
                return this.hasNext;
            }
            throw new com.badlogic.gdx.utils.GdxRuntimeException("#iterator() cannot be used nested.");
        }

        @Override // java.lang.Iterable
        public com.badlogic.gdx.utils.ObjectFloatMap.Entries<K> iterator() {
            return this;
        }

        @Override // java.util.Iterator
        public com.badlogic.gdx.utils.ObjectFloatMap.Entry<K> next() {
            if (!this.hasNext) {
                throw new java.util.NoSuchElementException();
            }
            if (!this.v) {
                throw new com.badlogic.gdx.utils.GdxRuntimeException("#iterator() cannot be used nested.");
            }
            com.badlogic.gdx.utils.ObjectFloatMap<K> objectFloatMap = this.n;
            K[] kArr = objectFloatMap.n;
            com.badlogic.gdx.utils.ObjectFloatMap.Entry<K> entry = this.w;
            int i = this.t;
            entry.key = kArr[i];
            entry.value = objectFloatMap.t[i];
            this.u = i;
            a();
            return this.w;
        }

        @Override // com.badlogic.gdx.utils.ObjectFloatMap.MapIterator, java.util.Iterator
        public void remove() {
            super.remove();
        }

        @Override // com.badlogic.gdx.utils.ObjectFloatMap.MapIterator
        public /* bridge */ /* synthetic */ void reset() {
            super.reset();
        }
    }

    public static class Entry<K> {
        public K key;
        public float value;

        public java.lang.String toString() {
            return this.key + com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER + this.value;
        }
    }

    public static class Keys<K> extends com.badlogic.gdx.utils.ObjectFloatMap.MapIterator<K> implements java.lang.Iterable<K>, java.util.Iterator<K> {
        public Keys(com.badlogic.gdx.utils.ObjectFloatMap<K> objectFloatMap) {
            super(objectFloatMap);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.v) {
                return this.hasNext;
            }
            throw new com.badlogic.gdx.utils.GdxRuntimeException("#iterator() cannot be used nested.");
        }

        @Override // java.lang.Iterable
        public com.badlogic.gdx.utils.ObjectFloatMap.Keys<K> iterator() {
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

        @Override // com.badlogic.gdx.utils.ObjectFloatMap.MapIterator, java.util.Iterator
        public void remove() {
            super.remove();
        }

        @Override // com.badlogic.gdx.utils.ObjectFloatMap.MapIterator
        public /* bridge */ /* synthetic */ void reset() {
            super.reset();
        }

        public com.badlogic.gdx.utils.Array<K> toArray() {
            com.badlogic.gdx.utils.Array<K> array = new com.badlogic.gdx.utils.Array<>(true, this.n.size);
            while (this.hasNext) {
                array.add(next());
            }
            return array;
        }

        public com.badlogic.gdx.utils.Array<K> toArray(com.badlogic.gdx.utils.Array<K> array) {
            while (this.hasNext) {
                array.add(next());
            }
            return array;
        }
    }

    public static class MapIterator<K> {
        public boolean hasNext;
        public final com.badlogic.gdx.utils.ObjectFloatMap<K> n;
        public int t;
        public int u;
        public boolean v = true;

        public MapIterator(com.badlogic.gdx.utils.ObjectFloatMap<K> objectFloatMap) {
            this.n = objectFloatMap;
            reset();
        }

        public void a() {
            int i;
            this.hasNext = false;
            com.badlogic.gdx.utils.ObjectFloatMap<K> objectFloatMap = this.n;
            K[] kArr = objectFloatMap.n;
            int i2 = objectFloatMap.u + objectFloatMap.v;
            do {
                i = this.t + 1;
                this.t = i;
                if (i >= i2) {
                    return;
                }
            } while (kArr[i] == null);
            this.hasNext = true;
        }

        public void remove() {
            int i = this.u;
            if (i < 0) {
                throw new java.lang.IllegalStateException("next must be called before remove.");
            }
            com.badlogic.gdx.utils.ObjectFloatMap<K> objectFloatMap = this.n;
            if (i >= objectFloatMap.u) {
                objectFloatMap.j(i);
                this.t = this.u - 1;
                a();
            } else {
                objectFloatMap.n[i] = null;
            }
            this.u = -1;
            com.badlogic.gdx.utils.ObjectFloatMap<K> objectFloatMap2 = this.n;
            objectFloatMap2.size--;
        }

        public void reset() {
            this.u = -1;
            this.t = -1;
            a();
        }
    }

    public static class Values extends com.badlogic.gdx.utils.ObjectFloatMap.MapIterator<java.lang.Object> {
        public Values(com.badlogic.gdx.utils.ObjectFloatMap<?> objectFloatMap) {
            super(objectFloatMap);
        }

        public boolean hasNext() {
            if (this.v) {
                return this.hasNext;
            }
            throw new com.badlogic.gdx.utils.GdxRuntimeException("#iterator() cannot be used nested.");
        }

        public float next() {
            if (!this.hasNext) {
                throw new java.util.NoSuchElementException();
            }
            if (!this.v) {
                throw new com.badlogic.gdx.utils.GdxRuntimeException("#iterator() cannot be used nested.");
            }
            float[] fArr = this.n.t;
            int i = this.t;
            float f = fArr[i];
            this.u = i;
            a();
            return f;
        }

        @Override // com.badlogic.gdx.utils.ObjectFloatMap.MapIterator, java.util.Iterator
        public /* bridge */ /* synthetic */ void remove() {
            super.remove();
        }

        @Override // com.badlogic.gdx.utils.ObjectFloatMap.MapIterator
        public /* bridge */ /* synthetic */ void reset() {
            super.reset();
        }

        public com.badlogic.gdx.utils.FloatArray toArray() {
            com.badlogic.gdx.utils.FloatArray floatArray = new com.badlogic.gdx.utils.FloatArray(true, this.n.size);
            while (this.hasNext) {
                floatArray.add(next());
            }
            return floatArray;
        }
    }

    public ObjectFloatMap() {
        this(51, 0.8f);
    }

    public ObjectFloatMap(int i) {
        this(i, 0.8f);
    }

    public ObjectFloatMap(int i, float f) {
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("initialCapacity must be >= 0: " + i);
        }
        int nextPowerOfTwo = com.badlogic.gdx.math.MathUtils.nextPowerOfTwo((int) java.lang.Math.ceil(i / f));
        if (nextPowerOfTwo > 1073741824) {
            throw new java.lang.IllegalArgumentException("initialCapacity is too large: " + nextPowerOfTwo);
        }
        this.u = nextPowerOfTwo;
        if (f <= 0.0f) {
            throw new java.lang.IllegalArgumentException("loadFactor must be > 0: " + f);
        }
        this.w = f;
        this.z = (int) (nextPowerOfTwo * f);
        this.y = nextPowerOfTwo - 1;
        this.x = 31 - java.lang.Integer.numberOfTrailingZeros(nextPowerOfTwo);
        this.A = java.lang.Math.max(3, ((int) java.lang.Math.ceil(java.lang.Math.log(this.u))) * 2);
        this.B = java.lang.Math.max(java.lang.Math.min(this.u, 8), ((int) java.lang.Math.sqrt(this.u)) / 8);
        K[] kArr = (K[]) new java.lang.Object[this.u + this.A];
        this.n = kArr;
        this.t = new float[kArr.length];
    }

    public ObjectFloatMap(com.badlogic.gdx.utils.ObjectFloatMap<? extends K> objectFloatMap) {
        this((int) java.lang.Math.floor(objectFloatMap.u * objectFloatMap.w), objectFloatMap.w);
        this.v = objectFloatMap.v;
        java.lang.Object[] objArr = objectFloatMap.n;
        java.lang.System.arraycopy(objArr, 0, this.n, 0, objArr.length);
        float[] fArr = objectFloatMap.t;
        java.lang.System.arraycopy(fArr, 0, this.t, 0, fArr.length);
        this.size = objectFloatMap.size;
    }

    public final boolean a(K k) {
        K[] kArr = this.n;
        int i = this.u;
        int i2 = this.v + i;
        while (i < i2) {
            if (k.equals(kArr[i])) {
                return true;
            }
            i++;
        }
        return false;
    }

    public final float b(K k, float f, float f2) {
        K[] kArr = this.n;
        int i = this.u;
        int i2 = this.v + i;
        while (i < i2) {
            if (k.equals(kArr[i])) {
                float[] fArr = this.t;
                float f3 = fArr[i];
                fArr[i] = f2 + f3;
                return f3;
            }
            i++;
        }
        put(k, f2 + f);
        return f;
    }

    public final float c(K k, float f) {
        K[] kArr = this.n;
        int i = this.u;
        int i2 = this.v + i;
        while (i < i2) {
            if (k.equals(kArr[i])) {
                return this.t[i];
            }
            i++;
        }
        return f;
    }

    public void clear() {
        if (this.size == 0) {
            return;
        }
        K[] kArr = this.n;
        int i = this.u + this.v;
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                this.size = 0;
                this.v = 0;
                return;
            } else {
                kArr[i2] = null;
                i = i2;
            }
        }
    }

    public void clear(int i) {
        if (this.u <= i) {
            clear();
        } else {
            this.size = 0;
            k(i);
        }
    }

    public boolean containsKey(K k) {
        int hashCode = k.hashCode();
        if (k.equals(this.n[this.y & hashCode])) {
            return true;
        }
        if (k.equals(this.n[d(hashCode)])) {
            return true;
        }
        if (k.equals(this.n[e(hashCode)])) {
            return true;
        }
        return a(k);
    }

    public boolean containsValue(float f) {
        K[] kArr = this.n;
        float[] fArr = this.t;
        int i = this.u + this.v;
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return false;
            }
            if (kArr[i2] != null && fArr[i2] == f) {
                return true;
            }
            i = i2;
        }
    }

    public final int d(int i) {
        int i2 = i * (-1262997959);
        return (i2 ^ (i2 >>> this.x)) & this.y;
    }

    public final int e(int i) {
        int i2 = i * (-825114047);
        return (i2 ^ (i2 >>> this.x)) & this.y;
    }

    public void ensureCapacity(int i) {
        if (this.size + i >= this.z) {
            k(com.badlogic.gdx.math.MathUtils.nextPowerOfTwo((int) java.lang.Math.ceil(r0 / this.w)));
        }
    }

    public com.badlogic.gdx.utils.ObjectFloatMap.Entries<K> entries() {
        if (this.C == null) {
            this.C = new com.badlogic.gdx.utils.ObjectFloatMap.Entries(this);
            this.D = new com.badlogic.gdx.utils.ObjectFloatMap.Entries(this);
        }
        com.badlogic.gdx.utils.ObjectFloatMap.Entries entries = this.C;
        if (entries.v) {
            this.D.reset();
            com.badlogic.gdx.utils.ObjectFloatMap.Entries<K> entries2 = this.D;
            entries2.v = true;
            this.C.v = false;
            return entries2;
        }
        entries.reset();
        com.badlogic.gdx.utils.ObjectFloatMap.Entries<K> entries3 = this.C;
        entries3.v = true;
        this.D.v = false;
        return entries3;
    }

    public boolean equals(java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.badlogic.gdx.utils.ObjectFloatMap)) {
            return false;
        }
        com.badlogic.gdx.utils.ObjectFloatMap objectFloatMap = (com.badlogic.gdx.utils.ObjectFloatMap) obj;
        if (objectFloatMap.size != this.size) {
            return false;
        }
        K[] kArr = this.n;
        float[] fArr = this.t;
        int i = this.u + this.v;
        for (int i2 = 0; i2 < i; i2++) {
            K k = kArr[i2];
            if (k != null) {
                float f = objectFloatMap.get(k, 0.0f);
                if ((f == 0.0f && !objectFloatMap.containsKey(k)) || f != fArr[i2]) {
                    return false;
                }
            }
        }
        return true;
    }

    public final void f(K k, float f, int i, K k2, int i2, K k3, int i3, K k4) {
        K[] kArr = this.n;
        float[] fArr = this.t;
        int i4 = this.y;
        int i5 = this.B;
        K k5 = k;
        float f2 = f;
        int i6 = i;
        K k6 = k2;
        int i7 = i2;
        K k7 = k3;
        int i8 = i3;
        K k8 = k4;
        int i9 = 0;
        while (true) {
            int random = com.badlogic.gdx.math.MathUtils.random(2);
            if (random == 0) {
                float f3 = fArr[i6];
                kArr[i6] = k5;
                fArr[i6] = f2;
                k5 = k6;
                f2 = f3;
            } else if (random != 1) {
                float f4 = fArr[i8];
                kArr[i8] = k5;
                fArr[i8] = f2;
                f2 = f4;
                k5 = k8;
            } else {
                float f5 = fArr[i7];
                kArr[i7] = k5;
                fArr[i7] = f2;
                f2 = f5;
                k5 = k7;
            }
            int hashCode = k5.hashCode();
            int i10 = hashCode & i4;
            K k9 = kArr[i10];
            if (k9 == null) {
                kArr[i10] = k5;
                fArr[i10] = f2;
                int i11 = this.size;
                this.size = i11 + 1;
                if (i11 >= this.z) {
                    k(this.u << 1);
                    return;
                }
                return;
            }
            int d = d(hashCode);
            K k10 = kArr[d];
            if (k10 == null) {
                kArr[d] = k5;
                fArr[d] = f2;
                int i12 = this.size;
                this.size = i12 + 1;
                if (i12 >= this.z) {
                    k(this.u << 1);
                    return;
                }
                return;
            }
            int e = e(hashCode);
            k8 = kArr[e];
            if (k8 == null) {
                kArr[e] = k5;
                fArr[e] = f2;
                int i13 = this.size;
                this.size = i13 + 1;
                if (i13 >= this.z) {
                    k(this.u << 1);
                    return;
                }
                return;
            }
            i9++;
            if (i9 == i5) {
                h(k5, f2);
                return;
            }
            i8 = e;
            i6 = i10;
            k6 = k9;
            i7 = d;
            k7 = k10;
        }
    }

    public K findKey(float f) {
        K[] kArr = this.n;
        float[] fArr = this.t;
        int i = this.u + this.v;
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                return null;
            }
            K k = kArr[i2];
            if (k != null && fArr[i2] == f) {
                return k;
            }
            i = i2;
        }
    }

    public final void g(K k, float f) {
        int hashCode = k.hashCode();
        int i = hashCode & this.y;
        K[] kArr = this.n;
        K k2 = kArr[i];
        if (k2 == null) {
            kArr[i] = k;
            this.t[i] = f;
            int i2 = this.size;
            this.size = i2 + 1;
            if (i2 >= this.z) {
                k(this.u << 1);
                return;
            }
            return;
        }
        int d = d(hashCode);
        K[] kArr2 = this.n;
        K k3 = kArr2[d];
        if (k3 == null) {
            kArr2[d] = k;
            this.t[d] = f;
            int i3 = this.size;
            this.size = i3 + 1;
            if (i3 >= this.z) {
                k(this.u << 1);
                return;
            }
            return;
        }
        int e = e(hashCode);
        K[] kArr3 = this.n;
        K k4 = kArr3[e];
        if (k4 != null) {
            f(k, f, i, k2, d, k3, e, k4);
            return;
        }
        kArr3[e] = k;
        this.t[e] = f;
        int i4 = this.size;
        this.size = i4 + 1;
        if (i4 >= this.z) {
            k(this.u << 1);
        }
    }

    public float get(K k, float f) {
        int hashCode = k.hashCode();
        int i = this.y & hashCode;
        if (!k.equals(this.n[i])) {
            i = d(hashCode);
            if (!k.equals(this.n[i])) {
                i = e(hashCode);
                if (!k.equals(this.n[i])) {
                    return c(k, f);
                }
            }
        }
        return this.t[i];
    }

    public float getAndIncrement(K k, float f, float f2) {
        int hashCode = k.hashCode();
        int i = this.y & hashCode;
        if (!k.equals(this.n[i])) {
            i = d(hashCode);
            if (!k.equals(this.n[i])) {
                i = e(hashCode);
                if (!k.equals(this.n[i])) {
                    return b(k, f, f2);
                }
            }
        }
        float[] fArr = this.t;
        float f3 = fArr[i];
        fArr[i] = f2 + f3;
        return f3;
    }

    public final void h(K k, float f) {
        int i = this.v;
        if (i == this.A) {
            k(this.u << 1);
            put(k, f);
            return;
        }
        int i2 = this.u + i;
        this.n[i2] = k;
        this.t[i2] = f;
        this.v = i + 1;
        this.size++;
    }

    public int hashCode() {
        K[] kArr = this.n;
        float[] fArr = this.t;
        int i = this.u + this.v;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            K k = kArr[i3];
            if (k != null) {
                i2 = i2 + (k.hashCode() * 31) + java.lang.Float.floatToIntBits(fArr[i3]);
            }
        }
        return i2;
    }

    public float i(K k, float f) {
        K[] kArr = this.n;
        int i = this.u;
        int i2 = this.v + i;
        while (i < i2) {
            if (k.equals(kArr[i])) {
                float f2 = this.t[i];
                j(i);
                this.size--;
                return f2;
            }
            i++;
        }
        return f;
    }

    @Override // java.lang.Iterable
    public com.badlogic.gdx.utils.ObjectFloatMap.Entries<K> iterator() {
        return entries();
    }

    public void j(int i) {
        int i2 = this.v - 1;
        this.v = i2;
        int i3 = this.u + i2;
        if (i < i3) {
            K[] kArr = this.n;
            kArr[i] = kArr[i3];
            float[] fArr = this.t;
            fArr[i] = fArr[i3];
        }
    }

    public final void k(int i) {
        int i2 = this.u + this.v;
        this.u = i;
        this.z = (int) (i * this.w);
        this.y = i - 1;
        this.x = 31 - java.lang.Integer.numberOfTrailingZeros(i);
        double d = i;
        this.A = java.lang.Math.max(3, ((int) java.lang.Math.ceil(java.lang.Math.log(d))) * 2);
        this.B = java.lang.Math.max(java.lang.Math.min(i, 8), ((int) java.lang.Math.sqrt(d)) / 8);
        K[] kArr = this.n;
        float[] fArr = this.t;
        int i3 = this.A;
        this.n = (K[]) new java.lang.Object[i + i3];
        this.t = new float[i + i3];
        int i4 = this.size;
        this.size = 0;
        this.v = 0;
        if (i4 > 0) {
            for (int i5 = 0; i5 < i2; i5++) {
                K k = kArr[i5];
                if (k != null) {
                    g(k, fArr[i5]);
                }
            }
        }
    }

    public com.badlogic.gdx.utils.ObjectFloatMap.Keys<K> keys() {
        if (this.G == null) {
            this.G = new com.badlogic.gdx.utils.ObjectFloatMap.Keys(this);
            this.H = new com.badlogic.gdx.utils.ObjectFloatMap.Keys(this);
        }
        com.badlogic.gdx.utils.ObjectFloatMap.Keys keys = this.G;
        if (keys.v) {
            this.H.reset();
            com.badlogic.gdx.utils.ObjectFloatMap.Keys<K> keys2 = this.H;
            keys2.v = true;
            this.G.v = false;
            return keys2;
        }
        keys.reset();
        com.badlogic.gdx.utils.ObjectFloatMap.Keys<K> keys3 = this.G;
        keys3.v = true;
        this.H.v = false;
        return keys3;
    }

    public void put(K k, float f) {
        if (k == null) {
            throw new java.lang.IllegalArgumentException("key cannot be null.");
        }
        java.lang.Object[] objArr = this.n;
        int hashCode = k.hashCode();
        int i = hashCode & this.y;
        K k2 = objArr[i];
        if (k.equals(k2)) {
            this.t[i] = f;
            return;
        }
        int d = d(hashCode);
        K k3 = objArr[d];
        if (k.equals(k3)) {
            this.t[d] = f;
            return;
        }
        int e = e(hashCode);
        K k4 = objArr[e];
        if (k.equals(k4)) {
            this.t[e] = f;
            return;
        }
        int i2 = this.u;
        int i3 = this.v + i2;
        while (i2 < i3) {
            if (k.equals(objArr[i2])) {
                this.t[i2] = f;
                return;
            }
            i2++;
        }
        if (k2 == null) {
            objArr[i] = k;
            this.t[i] = f;
            int i4 = this.size;
            this.size = i4 + 1;
            if (i4 >= this.z) {
                k(this.u << 1);
                return;
            }
            return;
        }
        if (k3 == null) {
            objArr[d] = k;
            this.t[d] = f;
            int i5 = this.size;
            this.size = i5 + 1;
            if (i5 >= this.z) {
                k(this.u << 1);
                return;
            }
            return;
        }
        if (k4 != null) {
            f(k, f, i, k2, d, k3, e, k4);
            return;
        }
        objArr[e] = k;
        this.t[e] = f;
        int i6 = this.size;
        this.size = i6 + 1;
        if (i6 >= this.z) {
            k(this.u << 1);
        }
    }

    public void putAll(com.badlogic.gdx.utils.ObjectFloatMap<K> objectFloatMap) {
        com.badlogic.gdx.utils.ObjectFloatMap.Entries<K> it = objectFloatMap.entries().iterator();
        while (it.hasNext()) {
            com.badlogic.gdx.utils.ObjectFloatMap.Entry<K> next = it.next();
            put(next.key, next.value);
        }
    }

    public float remove(K k, float f) {
        int hashCode = k.hashCode();
        int i = this.y & hashCode;
        if (k.equals(this.n[i])) {
            this.n[i] = null;
            this.size--;
            return this.t[i];
        }
        int d = d(hashCode);
        if (k.equals(this.n[d])) {
            this.n[d] = null;
            this.size--;
            return this.t[d];
        }
        int e = e(hashCode);
        if (!k.equals(this.n[e])) {
            return i(k, f);
        }
        this.n[e] = null;
        this.size--;
        return this.t[e];
    }

    public void shrink(int i) {
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("maximumCapacity must be >= 0: " + i);
        }
        int i2 = this.size;
        if (i2 > i) {
            i = i2;
        }
        if (this.u <= i) {
            return;
        }
        k(com.badlogic.gdx.math.MathUtils.nextPowerOfTwo(i));
    }

    public java.lang.String toString() {
        int i;
        if (this.size == 0) {
            return "{}";
        }
        com.badlogic.gdx.utils.StringBuilder stringBuilder = new com.badlogic.gdx.utils.StringBuilder(32);
        stringBuilder.append('{');
        K[] kArr = this.n;
        float[] fArr = this.t;
        int length = kArr.length;
        while (true) {
            i = length - 1;
            if (length > 0) {
                K k = kArr[i];
                if (k != null) {
                    stringBuilder.append(k);
                    stringBuilder.append(com.alipay.sdk.m.n.a.h);
                    stringBuilder.append(fArr[i]);
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
                stringBuilder.append('}');
                return stringBuilder.toString();
            }
            K k2 = kArr[i2];
            if (k2 != null) {
                stringBuilder.append(", ");
                stringBuilder.append(k2);
                stringBuilder.append(com.alipay.sdk.m.n.a.h);
                stringBuilder.append(fArr[i2]);
            }
            i = i2;
        }
    }

    public com.badlogic.gdx.utils.ObjectFloatMap.Values values() {
        if (this.E == null) {
            this.E = new com.badlogic.gdx.utils.ObjectFloatMap.Values(this);
            this.F = new com.badlogic.gdx.utils.ObjectFloatMap.Values(this);
        }
        com.badlogic.gdx.utils.ObjectFloatMap.Values values = this.E;
        if (values.v) {
            this.F.reset();
            com.badlogic.gdx.utils.ObjectFloatMap.Values values2 = this.F;
            values2.v = true;
            this.E.v = false;
            return values2;
        }
        values.reset();
        com.badlogic.gdx.utils.ObjectFloatMap.Values values3 = this.E;
        values3.v = true;
        this.F.v = false;
        return values3;
    }
}
