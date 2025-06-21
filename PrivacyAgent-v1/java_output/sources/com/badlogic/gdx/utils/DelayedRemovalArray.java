package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
public class DelayedRemovalArray<T> extends com.badlogic.gdx.utils.Array<T> {
    public int u;
    public com.badlogic.gdx.utils.IntArray v;

    public DelayedRemovalArray() {
        this.v = new com.badlogic.gdx.utils.IntArray(0);
    }

    public DelayedRemovalArray(int i) {
        super(i);
        this.v = new com.badlogic.gdx.utils.IntArray(0);
    }

    public DelayedRemovalArray(com.badlogic.gdx.utils.Array array) {
        super(array);
        this.v = new com.badlogic.gdx.utils.IntArray(0);
    }

    public DelayedRemovalArray(java.lang.Class cls) {
        super(cls);
        this.v = new com.badlogic.gdx.utils.IntArray(0);
    }

    public DelayedRemovalArray(boolean z, int i) {
        super(z, i);
        this.v = new com.badlogic.gdx.utils.IntArray(0);
    }

    public DelayedRemovalArray(boolean z, int i, java.lang.Class cls) {
        super(z, i, cls);
        this.v = new com.badlogic.gdx.utils.IntArray(0);
    }

    public DelayedRemovalArray(boolean z, T[] tArr, int i, int i2) {
        super(z, tArr, i, i2);
        this.v = new com.badlogic.gdx.utils.IntArray(0);
    }

    public DelayedRemovalArray(T[] tArr) {
        super(tArr);
        this.v = new com.badlogic.gdx.utils.IntArray(0);
    }

    public static <T> com.badlogic.gdx.utils.DelayedRemovalArray<T> with(T... tArr) {
        return new com.badlogic.gdx.utils.DelayedRemovalArray<>(tArr);
    }

    public final void a(int i) {
        int i2 = this.v.size;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.v.get(i3);
            if (i == i4) {
                return;
            }
            if (i < i4) {
                this.v.insert(i3, i);
                return;
            }
        }
        this.v.add(i);
    }

    public void begin() {
        this.u++;
    }

    @Override // com.badlogic.gdx.utils.Array
    public void clear() {
        if (this.u > 0) {
            throw new java.lang.IllegalStateException("Invalid between begin/end.");
        }
        super.clear();
    }

    public void end() {
        int i = this.u;
        if (i == 0) {
            throw new java.lang.IllegalStateException("begin must be called before end.");
        }
        int i2 = i - 1;
        this.u = i2;
        if (i2 == 0) {
            int i3 = this.v.size;
            for (int i4 = 0; i4 < i3; i4++) {
                removeIndex(this.v.pop());
            }
        }
    }

    @Override // com.badlogic.gdx.utils.Array
    public void insert(int i, T t) {
        if (this.u > 0) {
            throw new java.lang.IllegalStateException("Invalid between begin/end.");
        }
        super.insert(i, t);
    }

    @Override // com.badlogic.gdx.utils.Array
    public T pop() {
        if (this.u <= 0) {
            return (T) super.pop();
        }
        throw new java.lang.IllegalStateException("Invalid between begin/end.");
    }

    @Override // com.badlogic.gdx.utils.Array
    public T removeIndex(int i) {
        if (this.u <= 0) {
            return (T) super.removeIndex(i);
        }
        a(i);
        return get(i);
    }

    @Override // com.badlogic.gdx.utils.Array
    public void removeRange(int i, int i2) {
        if (this.u <= 0) {
            super.removeRange(i, i2);
            return;
        }
        while (i2 >= i) {
            a(i2);
            i2--;
        }
    }

    @Override // com.badlogic.gdx.utils.Array
    public boolean removeValue(T t, boolean z) {
        if (this.u <= 0) {
            return super.removeValue(t, z);
        }
        int indexOf = indexOf(t, z);
        if (indexOf == -1) {
            return false;
        }
        a(indexOf);
        return true;
    }

    @Override // com.badlogic.gdx.utils.Array
    public void reverse() {
        if (this.u > 0) {
            throw new java.lang.IllegalStateException("Invalid between begin/end.");
        }
        super.reverse();
    }

    @Override // com.badlogic.gdx.utils.Array
    public void set(int i, T t) {
        if (this.u > 0) {
            throw new java.lang.IllegalStateException("Invalid between begin/end.");
        }
        super.set(i, t);
    }

    @Override // com.badlogic.gdx.utils.Array
    public T[] setSize(int i) {
        if (this.u <= 0) {
            return (T[]) super.setSize(i);
        }
        throw new java.lang.IllegalStateException("Invalid between begin/end.");
    }

    @Override // com.badlogic.gdx.utils.Array
    public void shuffle() {
        if (this.u > 0) {
            throw new java.lang.IllegalStateException("Invalid between begin/end.");
        }
        super.shuffle();
    }

    @Override // com.badlogic.gdx.utils.Array
    public void sort() {
        if (this.u > 0) {
            throw new java.lang.IllegalStateException("Invalid between begin/end.");
        }
        super.sort();
    }

    @Override // com.badlogic.gdx.utils.Array
    public void sort(java.util.Comparator<? super T> comparator) {
        if (this.u > 0) {
            throw new java.lang.IllegalStateException("Invalid between begin/end.");
        }
        super.sort(comparator);
    }

    @Override // com.badlogic.gdx.utils.Array
    public void swap(int i, int i2) {
        if (this.u > 0) {
            throw new java.lang.IllegalStateException("Invalid between begin/end.");
        }
        super.swap(i, i2);
    }

    @Override // com.badlogic.gdx.utils.Array
    public void truncate(int i) {
        if (this.u > 0) {
            throw new java.lang.IllegalStateException("Invalid between begin/end.");
        }
        super.truncate(i);
    }
}
