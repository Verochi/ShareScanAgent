package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
public class Queue<T> implements java.lang.Iterable<T> {
    protected int head;
    public com.badlogic.gdx.utils.Queue.QueueIterable n;
    public int size;
    protected int tail;
    protected T[] values;

    public static class QueueIterable<T> implements java.lang.Iterable<T> {
        public final com.badlogic.gdx.utils.Queue<T> n;
        public final boolean t;
        public com.badlogic.gdx.utils.Queue.QueueIterator u;
        public com.badlogic.gdx.utils.Queue.QueueIterator v;

        public QueueIterable(com.badlogic.gdx.utils.Queue<T> queue) {
            this(queue, true);
        }

        public QueueIterable(com.badlogic.gdx.utils.Queue<T> queue, boolean z) {
            this.n = queue;
            this.t = z;
        }

        @Override // java.lang.Iterable
        public java.util.Iterator<T> iterator() {
            if (this.u == null) {
                this.u = new com.badlogic.gdx.utils.Queue.QueueIterator(this.n, this.t);
                this.v = new com.badlogic.gdx.utils.Queue.QueueIterator(this.n, this.t);
            }
            com.badlogic.gdx.utils.Queue.QueueIterator queueIterator = this.u;
            if (!queueIterator.v) {
                queueIterator.u = 0;
                queueIterator.v = true;
                this.v.v = false;
                return queueIterator;
            }
            com.badlogic.gdx.utils.Queue.QueueIterator queueIterator2 = this.v;
            queueIterator2.u = 0;
            queueIterator2.v = true;
            queueIterator.v = false;
            return queueIterator2;
        }
    }

    public static class QueueIterator<T> implements java.util.Iterator<T>, java.lang.Iterable<T> {
        public final com.badlogic.gdx.utils.Queue<T> n;
        public final boolean t;
        public int u;
        public boolean v;

        public QueueIterator(com.badlogic.gdx.utils.Queue<T> queue) {
            this(queue, true);
        }

        public QueueIterator(com.badlogic.gdx.utils.Queue<T> queue, boolean z) {
            this.v = true;
            this.n = queue;
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
            com.badlogic.gdx.utils.Queue<T> queue = this.n;
            if (i >= queue.size) {
                throw new java.util.NoSuchElementException(java.lang.String.valueOf(this.u));
            }
            if (!this.v) {
                throw new com.badlogic.gdx.utils.GdxRuntimeException("#iterator() cannot be used nested.");
            }
            this.u = i + 1;
            return queue.get(i);
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

    public Queue() {
        this(16);
    }

    public Queue(int i) {
        this.head = 0;
        this.tail = 0;
        this.size = 0;
        this.values = (T[]) new java.lang.Object[i];
    }

    public Queue(int i, java.lang.Class<T> cls) {
        this.head = 0;
        this.tail = 0;
        this.size = 0;
        this.values = (T[]) ((java.lang.Object[]) com.badlogic.gdx.utils.reflect.ArrayReflection.newInstance(cls, i));
    }

    public void addFirst(T t) {
        T[] tArr = this.values;
        if (this.size == tArr.length) {
            resize(tArr.length << 1);
            tArr = this.values;
        }
        int i = this.head - 1;
        if (i == -1) {
            i = tArr.length - 1;
        }
        tArr[i] = t;
        this.head = i;
        this.size++;
    }

    public void addLast(T t) {
        T[] tArr = this.values;
        if (this.size == tArr.length) {
            resize(tArr.length << 1);
            tArr = this.values;
        }
        int i = this.tail;
        int i2 = i + 1;
        this.tail = i2;
        tArr[i] = t;
        if (i2 == tArr.length) {
            this.tail = 0;
        }
        this.size++;
    }

    public void clear() {
        if (this.size == 0) {
            return;
        }
        T[] tArr = this.values;
        int i = this.head;
        int i2 = this.tail;
        if (i < i2) {
            while (i < i2) {
                tArr[i] = null;
                i++;
            }
        } else {
            while (i < tArr.length) {
                tArr[i] = null;
                i++;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                tArr[i3] = null;
            }
        }
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    public void ensureCapacity(int i) {
        int i2 = this.size + i;
        if (this.values.length < i2) {
            resize(i2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof com.badlogic.gdx.utils.Queue)) {
            return false;
        }
        com.badlogic.gdx.utils.Queue queue = (com.badlogic.gdx.utils.Queue) obj;
        int i = this.size;
        if (queue.size != i) {
            return false;
        }
        T[] tArr = this.values;
        int length = tArr.length;
        T[] tArr2 = queue.values;
        int length2 = tArr2.length;
        int i2 = this.head;
        int i3 = queue.head;
        for (int i4 = 0; i4 < i; i4++) {
            T t = tArr[i2];
            T t2 = tArr2[i3];
            if (t == null) {
                if (t2 != null) {
                    return false;
                }
                i2++;
                i3++;
                if (i2 == length) {
                    i2 = 0;
                }
                if (i3 != length2) {
                    i3 = 0;
                }
            } else {
                if (!t.equals(t2)) {
                    return false;
                }
                i2++;
                i3++;
                if (i2 == length) {
                }
                if (i3 != length2) {
                }
            }
        }
        return true;
    }

    public T first() {
        if (this.size != 0) {
            return this.values[this.head];
        }
        throw new java.util.NoSuchElementException("Queue is empty.");
    }

    public T get(int i) {
        if (i < 0) {
            throw new java.lang.IndexOutOfBoundsException("index can't be < 0: " + i);
        }
        if (i < this.size) {
            T[] tArr = this.values;
            int i2 = this.head + i;
            if (i2 >= tArr.length) {
                i2 -= tArr.length;
            }
            return tArr[i2];
        }
        throw new java.lang.IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.size);
    }

    public int hashCode() {
        int i = this.size;
        T[] tArr = this.values;
        int length = tArr.length;
        int i2 = this.head;
        int i3 = i + 1;
        for (int i4 = 0; i4 < i; i4++) {
            T t = tArr[i2];
            i3 *= 31;
            if (t != null) {
                i3 += t.hashCode();
            }
            i2++;
            if (i2 == length) {
                i2 = 0;
            }
        }
        return i3;
    }

    public int indexOf(T t, boolean z) {
        int length;
        if (this.size == 0) {
            return -1;
        }
        T[] tArr = this.values;
        int i = this.head;
        int i2 = this.tail;
        int i3 = 0;
        if (z || t == null) {
            if (i < i2) {
                while (i < i2) {
                    if (tArr[i] == t) {
                        return i;
                    }
                    i++;
                }
            } else {
                int length2 = tArr.length;
                for (int i4 = i; i4 < length2; i4++) {
                    if (tArr[i4] == t) {
                        return i4 - i;
                    }
                }
                while (i3 < i2) {
                    if (tArr[i3] == t) {
                        length = tArr.length;
                        return (i3 + length) - i;
                    }
                    i3++;
                }
            }
            return -1;
        }
        if (i < i2) {
            while (i < i2) {
                if (t.equals(tArr[i])) {
                    return i;
                }
                i++;
            }
        } else {
            int length3 = tArr.length;
            for (int i5 = i; i5 < length3; i5++) {
                if (t.equals(tArr[i5])) {
                    return i5 - i;
                }
            }
            while (i3 < i2) {
                if (t.equals(tArr[i3])) {
                    length = tArr.length;
                    return (i3 + length) - i;
                }
                i3++;
            }
        }
        return -1;
    }

    @Override // java.lang.Iterable
    public java.util.Iterator<T> iterator() {
        if (this.n == null) {
            this.n = new com.badlogic.gdx.utils.Queue.QueueIterable(this);
        }
        return this.n.iterator();
    }

    public T last() {
        if (this.size == 0) {
            throw new java.util.NoSuchElementException("Queue is empty.");
        }
        T[] tArr = this.values;
        int i = this.tail - 1;
        if (i == -1) {
            i = tArr.length - 1;
        }
        return tArr[i];
    }

    public T removeFirst() {
        int i = this.size;
        if (i == 0) {
            throw new java.util.NoSuchElementException("Queue is empty.");
        }
        T[] tArr = this.values;
        int i2 = this.head;
        T t = tArr[i2];
        tArr[i2] = null;
        int i3 = i2 + 1;
        this.head = i3;
        if (i3 == tArr.length) {
            this.head = 0;
        }
        this.size = i - 1;
        return t;
    }

    public T removeIndex(int i) {
        T t;
        if (i < 0) {
            throw new java.lang.IndexOutOfBoundsException("index can't be < 0: " + i);
        }
        if (i >= this.size) {
            throw new java.lang.IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.size);
        }
        T[] tArr = this.values;
        int i2 = this.head;
        int i3 = this.tail;
        int i4 = i + i2;
        if (i2 < i3) {
            t = tArr[i4];
            java.lang.System.arraycopy(tArr, i4 + 1, tArr, i4, i3 - i4);
            tArr[i3] = null;
            this.tail--;
        } else if (i4 >= tArr.length) {
            int length = i4 - tArr.length;
            t = tArr[length];
            java.lang.System.arraycopy(tArr, length + 1, tArr, length, i3 - length);
            this.tail--;
        } else {
            T t2 = tArr[i4];
            java.lang.System.arraycopy(tArr, i2, tArr, i2 + 1, i4 - i2);
            tArr[i2] = null;
            int i5 = this.head + 1;
            this.head = i5;
            if (i5 == tArr.length) {
                this.head = 0;
            }
            t = t2;
        }
        this.size--;
        return t;
    }

    public T removeLast() {
        int i = this.size;
        if (i == 0) {
            throw new java.util.NoSuchElementException("Queue is empty.");
        }
        T[] tArr = this.values;
        int i2 = this.tail - 1;
        if (i2 == -1) {
            i2 = tArr.length - 1;
        }
        T t = tArr[i2];
        tArr[i2] = null;
        this.tail = i2;
        this.size = i - 1;
        return t;
    }

    public boolean removeValue(T t, boolean z) {
        int indexOf = indexOf(t, z);
        if (indexOf == -1) {
            return false;
        }
        removeIndex(indexOf);
        return true;
    }

    public void resize(int i) {
        T[] tArr = this.values;
        int i2 = this.head;
        int i3 = this.tail;
        T[] tArr2 = (T[]) ((java.lang.Object[]) com.badlogic.gdx.utils.reflect.ArrayReflection.newInstance(tArr.getClass().getComponentType(), i));
        if (i2 < i3) {
            java.lang.System.arraycopy(tArr, i2, tArr2, 0, i3 - i2);
        } else if (this.size > 0) {
            int length = tArr.length - i2;
            java.lang.System.arraycopy(tArr, i2, tArr2, 0, length);
            java.lang.System.arraycopy(tArr, 0, tArr2, length, i3);
        }
        this.values = tArr2;
        this.head = 0;
        this.tail = this.size;
    }

    public java.lang.String toString() {
        if (this.size == 0) {
            return "[]";
        }
        T[] tArr = this.values;
        int i = this.head;
        int i2 = this.tail;
        com.badlogic.gdx.utils.StringBuilder stringBuilder = new com.badlogic.gdx.utils.StringBuilder(64);
        stringBuilder.append('[');
        stringBuilder.append(tArr[i]);
        while (true) {
            i = (i + 1) % tArr.length;
            if (i == i2) {
                stringBuilder.append(']');
                return stringBuilder.toString();
            }
            stringBuilder.append(", ").append(tArr[i]);
        }
    }
}
