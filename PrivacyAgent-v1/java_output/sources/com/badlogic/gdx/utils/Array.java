package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
public class Array<T> implements java.lang.Iterable<T> {
    public T[] items;
    public com.badlogic.gdx.utils.Array.ArrayIterable n;
    public boolean ordered;
    public int size;
    public com.badlogic.gdx.utils.Predicate.PredicateIterable<T> t;

    public static class ArrayIterable<T> implements java.lang.Iterable<T> {
        public final com.badlogic.gdx.utils.Array<T> n;
        public final boolean t;
        public com.badlogic.gdx.utils.Array.ArrayIterator u;
        public com.badlogic.gdx.utils.Array.ArrayIterator v;

        public ArrayIterable(com.badlogic.gdx.utils.Array<T> array) {
            this(array, true);
        }

        public ArrayIterable(com.badlogic.gdx.utils.Array<T> array, boolean z) {
            this.n = array;
            this.t = z;
        }

        @Override // java.lang.Iterable
        public java.util.Iterator<T> iterator() {
            if (this.u == null) {
                this.u = new com.badlogic.gdx.utils.Array.ArrayIterator(this.n, this.t);
                this.v = new com.badlogic.gdx.utils.Array.ArrayIterator(this.n, this.t);
            }
            com.badlogic.gdx.utils.Array.ArrayIterator arrayIterator = this.u;
            if (!arrayIterator.v) {
                arrayIterator.u = 0;
                arrayIterator.v = true;
                this.v.v = false;
                return arrayIterator;
            }
            com.badlogic.gdx.utils.Array.ArrayIterator arrayIterator2 = this.v;
            arrayIterator2.u = 0;
            arrayIterator2.v = true;
            arrayIterator.v = false;
            return arrayIterator2;
        }
    }

    public static class ArrayIterator<T> implements java.util.Iterator<T>, java.lang.Iterable<T> {
        public final com.badlogic.gdx.utils.Array<T> n;
        public final boolean t;
        public int u;
        public boolean v;

        public ArrayIterator(com.badlogic.gdx.utils.Array<T> array) {
            this(array, true);
        }

        public ArrayIterator(com.badlogic.gdx.utils.Array<T> array, boolean z) {
            this.v = true;
            this.n = array;
            this.t = z;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.v) {
                return this.u < this.n.size;
            }
            throw new com.badlogic.gdx.utils.GdxRuntimeException("#iterator() cannot be used nested.");
        }

        @Override // java.lang.Iterable
        public java.util.Iterator<T> iterator() {
            return this;
        }

        @Override // java.util.Iterator
        public T next() {
            int i = this.u;
            com.badlogic.gdx.utils.Array<T> array = this.n;
            if (i >= array.size) {
                throw new java.util.NoSuchElementException(java.lang.String.valueOf(this.u));
            }
            if (!this.v) {
                throw new com.badlogic.gdx.utils.GdxRuntimeException("#iterator() cannot be used nested.");
            }
            T[] tArr = array.items;
            this.u = i + 1;
            return tArr[i];
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.t) {
                throw new com.badlogic.gdx.utils.GdxRuntimeException("Remove not allowed.");
            }
            int i = this.u - 1;
            this.u = i;
            this.n.removeIndex(i);
        }

        public void reset() {
            this.u = 0;
        }
    }

    public Array() {
        this(true, 16);
    }

    public Array(int i) {
        this(true, i);
    }

    public Array(com.badlogic.gdx.utils.Array<? extends T> array) {
        this(array.ordered, array.size, array.items.getClass().getComponentType());
        int i = array.size;
        this.size = i;
        java.lang.System.arraycopy(array.items, 0, this.items, 0, i);
    }

    public Array(java.lang.Class cls) {
        this(true, 16, cls);
    }

    public Array(boolean z, int i) {
        this.ordered = z;
        this.items = (T[]) new java.lang.Object[i];
    }

    public Array(boolean z, int i, java.lang.Class cls) {
        this.ordered = z;
        this.items = (T[]) ((java.lang.Object[]) com.badlogic.gdx.utils.reflect.ArrayReflection.newInstance(cls, i));
    }

    public Array(boolean z, T[] tArr, int i, int i2) {
        this(z, i2, tArr.getClass().getComponentType());
        this.size = i2;
        java.lang.System.arraycopy(tArr, i, this.items, 0, i2);
    }

    public Array(T[] tArr) {
        this(true, tArr, 0, tArr.length);
    }

    public static <T> com.badlogic.gdx.utils.Array<T> of(java.lang.Class<T> cls) {
        return new com.badlogic.gdx.utils.Array<>(cls);
    }

    public static <T> com.badlogic.gdx.utils.Array<T> of(boolean z, int i, java.lang.Class<T> cls) {
        return new com.badlogic.gdx.utils.Array<>(z, i, cls);
    }

    public static <T> com.badlogic.gdx.utils.Array<T> with(T... tArr) {
        return new com.badlogic.gdx.utils.Array<>(tArr);
    }

    public void add(T t) {
        T[] tArr = this.items;
        int i = this.size;
        if (i == tArr.length) {
            tArr = resize(java.lang.Math.max(8, (int) (i * 1.75f)));
        }
        int i2 = this.size;
        this.size = i2 + 1;
        tArr[i2] = t;
    }

    public void addAll(com.badlogic.gdx.utils.Array<? extends T> array) {
        addAll(array, 0, array.size);
    }

    public void addAll(com.badlogic.gdx.utils.Array<? extends T> array, int i, int i2) {
        if (i + i2 <= array.size) {
            addAll(array.items, i, i2);
            return;
        }
        throw new java.lang.IllegalArgumentException("start + count must be <= size: " + i + " + " + i2 + " <= " + array.size);
    }

    public void addAll(T... tArr) {
        addAll(tArr, 0, tArr.length);
    }

    public void addAll(T[] tArr, int i, int i2) {
        T[] tArr2 = this.items;
        int i3 = this.size + i2;
        if (i3 > tArr2.length) {
            tArr2 = resize(java.lang.Math.max(8, (int) (i3 * 1.75f)));
        }
        java.lang.System.arraycopy(tArr, i, tArr2, this.size, i2);
        this.size += i2;
    }

    public void clear() {
        T[] tArr = this.items;
        int i = this.size;
        for (int i2 = 0; i2 < i; i2++) {
            tArr[i2] = null;
        }
        this.size = 0;
    }

    public boolean contains(T t, boolean z) {
        T[] tArr = this.items;
        int i = this.size - 1;
        if (z || t == null) {
            while (i >= 0) {
                int i2 = i - 1;
                if (tArr[i] == t) {
                    return true;
                }
                i = i2;
            }
            return false;
        }
        while (i >= 0) {
            int i3 = i - 1;
            if (t.equals(tArr[i])) {
                return true;
            }
            i = i3;
        }
        return false;
    }

    public T[] ensureCapacity(int i) {
        int i2 = this.size + i;
        if (i2 > this.items.length) {
            resize(java.lang.Math.max(8, i2));
        }
        return this.items;
    }

    public boolean equals(java.lang.Object obj) {
        int i;
        if (obj == this) {
            return true;
        }
        if (!this.ordered || !(obj instanceof com.badlogic.gdx.utils.Array)) {
            return false;
        }
        com.badlogic.gdx.utils.Array array = (com.badlogic.gdx.utils.Array) obj;
        if (!array.ordered || (i = this.size) != array.size) {
            return false;
        }
        T[] tArr = this.items;
        T[] tArr2 = array.items;
        for (int i2 = 0; i2 < i; i2++) {
            T t = tArr[i2];
            T t2 = tArr2[i2];
            if (t == null) {
                if (t2 != null) {
                    return false;
                }
            } else {
                if (!t.equals(t2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public T first() {
        if (this.size != 0) {
            return this.items[0];
        }
        throw new java.lang.IllegalStateException("Array is empty.");
    }

    public T get(int i) {
        if (i < this.size) {
            return this.items[i];
        }
        throw new java.lang.IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.size);
    }

    public int hashCode() {
        if (!this.ordered) {
            return super.hashCode();
        }
        T[] tArr = this.items;
        int i = this.size;
        int i2 = 1;
        for (int i3 = 0; i3 < i; i3++) {
            i2 *= 31;
            T t = tArr[i3];
            if (t != null) {
                i2 += t.hashCode();
            }
        }
        return i2;
    }

    public int indexOf(T t, boolean z) {
        T[] tArr = this.items;
        int i = 0;
        if (z || t == null) {
            int i2 = this.size;
            while (i < i2) {
                if (tArr[i] == t) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        int i3 = this.size;
        while (i < i3) {
            if (t.equals(tArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public void insert(int i, T t) {
        int i2 = this.size;
        if (i > i2) {
            throw new java.lang.IndexOutOfBoundsException("index can't be > size: " + i + " > " + this.size);
        }
        T[] tArr = this.items;
        if (i2 == tArr.length) {
            tArr = resize(java.lang.Math.max(8, (int) (i2 * 1.75f)));
        }
        if (this.ordered) {
            java.lang.System.arraycopy(tArr, i, tArr, i + 1, this.size - i);
        } else {
            tArr[this.size] = tArr[i];
        }
        this.size++;
        tArr[i] = t;
    }

    @Override // java.lang.Iterable
    public java.util.Iterator<T> iterator() {
        if (this.n == null) {
            this.n = new com.badlogic.gdx.utils.Array.ArrayIterable(this);
        }
        return this.n.iterator();
    }

    public int lastIndexOf(T t, boolean z) {
        T[] tArr = this.items;
        if (z || t == null) {
            for (int i = this.size - 1; i >= 0; i--) {
                if (tArr[i] == t) {
                    return i;
                }
            }
            return -1;
        }
        for (int i2 = this.size - 1; i2 >= 0; i2--) {
            if (t.equals(tArr[i2])) {
                return i2;
            }
        }
        return -1;
    }

    public T peek() {
        int i = this.size;
        if (i != 0) {
            return this.items[i - 1];
        }
        throw new java.lang.IllegalStateException("Array is empty.");
    }

    public T pop() {
        int i = this.size;
        if (i == 0) {
            throw new java.lang.IllegalStateException("Array is empty.");
        }
        int i2 = i - 1;
        this.size = i2;
        T[] tArr = this.items;
        T t = tArr[i2];
        tArr[i2] = null;
        return t;
    }

    public T random() {
        int i = this.size;
        if (i == 0) {
            return null;
        }
        return this.items[com.badlogic.gdx.math.MathUtils.random(0, i - 1)];
    }

    public boolean removeAll(com.badlogic.gdx.utils.Array<? extends T> array, boolean z) {
        int i;
        int i2 = this.size;
        T[] tArr = this.items;
        if (z) {
            int i3 = array.size;
            i = i2;
            for (int i4 = 0; i4 < i3; i4++) {
                T t = array.get(i4);
                int i5 = 0;
                while (true) {
                    if (i5 >= i) {
                        break;
                    }
                    if (t == tArr[i5]) {
                        removeIndex(i5);
                        i--;
                        break;
                    }
                    i5++;
                }
            }
        } else {
            int i6 = array.size;
            i = i2;
            for (int i7 = 0; i7 < i6; i7++) {
                T t2 = array.get(i7);
                int i8 = 0;
                while (true) {
                    if (i8 >= i) {
                        break;
                    }
                    if (t2.equals(tArr[i8])) {
                        removeIndex(i8);
                        i--;
                        break;
                    }
                    i8++;
                }
            }
        }
        return i != i2;
    }

    public T removeIndex(int i) {
        int i2 = this.size;
        if (i >= i2) {
            throw new java.lang.IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.size);
        }
        T[] tArr = this.items;
        T t = tArr[i];
        int i3 = i2 - 1;
        this.size = i3;
        if (this.ordered) {
            java.lang.System.arraycopy(tArr, i + 1, tArr, i, i3 - i);
        } else {
            tArr[i] = tArr[i3];
        }
        tArr[this.size] = null;
        return t;
    }

    public void removeRange(int i, int i2) {
        int i3 = this.size;
        if (i2 >= i3) {
            throw new java.lang.IndexOutOfBoundsException("end can't be >= size: " + i2 + " >= " + this.size);
        }
        if (i > i2) {
            throw new java.lang.IndexOutOfBoundsException("start can't be > end: " + i + " > " + i2);
        }
        T[] tArr = this.items;
        int i4 = (i2 - i) + 1;
        if (this.ordered) {
            int i5 = i + i4;
            java.lang.System.arraycopy(tArr, i5, tArr, i, i3 - i5);
        } else {
            int i6 = i3 - 1;
            for (int i7 = 0; i7 < i4; i7++) {
                tArr[i + i7] = tArr[i6 - i7];
            }
        }
        this.size -= i4;
    }

    public boolean removeValue(T t, boolean z) {
        T[] tArr = this.items;
        if (z || t == null) {
            int i = this.size;
            for (int i2 = 0; i2 < i; i2++) {
                if (tArr[i2] == t) {
                    removeIndex(i2);
                    return true;
                }
            }
        } else {
            int i3 = this.size;
            for (int i4 = 0; i4 < i3; i4++) {
                if (t.equals(tArr[i4])) {
                    removeIndex(i4);
                    return true;
                }
            }
        }
        return false;
    }

    public T[] resize(int i) {
        T[] tArr = this.items;
        T[] tArr2 = (T[]) ((java.lang.Object[]) com.badlogic.gdx.utils.reflect.ArrayReflection.newInstance(tArr.getClass().getComponentType(), i));
        java.lang.System.arraycopy(tArr, 0, tArr2, 0, java.lang.Math.min(this.size, tArr2.length));
        this.items = tArr2;
        return tArr2;
    }

    public void reverse() {
        T[] tArr = this.items;
        int i = this.size;
        int i2 = i - 1;
        int i3 = i / 2;
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i2 - i4;
            T t = tArr[i4];
            tArr[i4] = tArr[i5];
            tArr[i5] = t;
        }
    }

    public java.lang.Iterable<T> select(com.badlogic.gdx.utils.Predicate<T> predicate) {
        com.badlogic.gdx.utils.Predicate.PredicateIterable<T> predicateIterable = this.t;
        if (predicateIterable == null) {
            this.t = new com.badlogic.gdx.utils.Predicate.PredicateIterable<>(this, predicate);
        } else {
            predicateIterable.set(this, predicate);
        }
        return this.t;
    }

    public T selectRanked(java.util.Comparator<T> comparator, int i) {
        if (i >= 1) {
            return (T) com.badlogic.gdx.utils.Select.instance().select(this.items, comparator, i, this.size);
        }
        throw new com.badlogic.gdx.utils.GdxRuntimeException("nth_lowest must be greater than 0, 1 = first, 2 = second...");
    }

    public int selectRankedIndex(java.util.Comparator<T> comparator, int i) {
        if (i >= 1) {
            return com.badlogic.gdx.utils.Select.instance().selectIndex(this.items, comparator, i, this.size);
        }
        throw new com.badlogic.gdx.utils.GdxRuntimeException("nth_lowest must be greater than 0, 1 = first, 2 = second...");
    }

    public void set(int i, T t) {
        if (i < this.size) {
            this.items[i] = t;
            return;
        }
        throw new java.lang.IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.size);
    }

    public T[] setSize(int i) {
        truncate(i);
        if (i > this.items.length) {
            resize(java.lang.Math.max(8, i));
        }
        this.size = i;
        return this.items;
    }

    public T[] shrink() {
        int length = this.items.length;
        int i = this.size;
        if (length != i) {
            resize(i);
        }
        return this.items;
    }

    public void shuffle() {
        T[] tArr = this.items;
        for (int i = this.size - 1; i >= 0; i--) {
            int random = com.badlogic.gdx.math.MathUtils.random(i);
            T t = tArr[i];
            tArr[i] = tArr[random];
            tArr[random] = t;
        }
    }

    public void sort() {
        com.badlogic.gdx.utils.Sort.instance().sort(this.items, 0, this.size);
    }

    public void sort(java.util.Comparator<? super T> comparator) {
        com.badlogic.gdx.utils.Sort.instance().sort(this.items, comparator, 0, this.size);
    }

    public void swap(int i, int i2) {
        int i3 = this.size;
        if (i >= i3) {
            throw new java.lang.IndexOutOfBoundsException("first can't be >= size: " + i + " >= " + this.size);
        }
        if (i2 < i3) {
            T[] tArr = this.items;
            T t = tArr[i];
            tArr[i] = tArr[i2];
            tArr[i2] = t;
            return;
        }
        throw new java.lang.IndexOutOfBoundsException("second can't be >= size: " + i2 + " >= " + this.size);
    }

    public T[] toArray() {
        return (T[]) toArray(this.items.getClass().getComponentType());
    }

    public <V> V[] toArray(java.lang.Class cls) {
        V[] vArr = (V[]) ((java.lang.Object[]) com.badlogic.gdx.utils.reflect.ArrayReflection.newInstance(cls, this.size));
        java.lang.System.arraycopy(this.items, 0, vArr, 0, this.size);
        return vArr;
    }

    public java.lang.String toString() {
        if (this.size == 0) {
            return "[]";
        }
        T[] tArr = this.items;
        com.badlogic.gdx.utils.StringBuilder stringBuilder = new com.badlogic.gdx.utils.StringBuilder(32);
        stringBuilder.append('[');
        stringBuilder.append(tArr[0]);
        for (int i = 1; i < this.size; i++) {
            stringBuilder.append(", ");
            stringBuilder.append(tArr[i]);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public java.lang.String toString(java.lang.String str) {
        if (this.size == 0) {
            return "";
        }
        T[] tArr = this.items;
        com.badlogic.gdx.utils.StringBuilder stringBuilder = new com.badlogic.gdx.utils.StringBuilder(32);
        stringBuilder.append(tArr[0]);
        for (int i = 1; i < this.size; i++) {
            stringBuilder.append(str);
            stringBuilder.append(tArr[i]);
        }
        return stringBuilder.toString();
    }

    public void truncate(int i) {
        if (this.size <= i) {
            return;
        }
        for (int i2 = i; i2 < this.size; i2++) {
            this.items[i2] = null;
        }
        this.size = i;
    }
}
