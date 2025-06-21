package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
public class SnapshotArray<T> extends com.badlogic.gdx.utils.Array<T> {
    public T[] u;
    public T[] v;
    public int w;

    public SnapshotArray() {
    }

    public SnapshotArray(int i) {
        super(i);
    }

    public SnapshotArray(com.badlogic.gdx.utils.Array array) {
        super(array);
    }

    public SnapshotArray(java.lang.Class cls) {
        super(cls);
    }

    public SnapshotArray(boolean z, int i) {
        super(z, i);
    }

    public SnapshotArray(boolean z, int i, java.lang.Class cls) {
        super(z, i, cls);
    }

    public SnapshotArray(boolean z, T[] tArr, int i, int i2) {
        super(z, tArr, i, i2);
    }

    public SnapshotArray(T[] tArr) {
        super(tArr);
    }

    public static <T> com.badlogic.gdx.utils.SnapshotArray<T> with(T... tArr) {
        return new com.badlogic.gdx.utils.SnapshotArray<>(tArr);
    }

    public final void a() {
        T[] tArr;
        T[] tArr2 = this.u;
        if (tArr2 == null || tArr2 != (tArr = this.items)) {
            return;
        }
        T[] tArr3 = this.v;
        if (tArr3 != null) {
            int length = tArr3.length;
            int i = this.size;
            if (length >= i) {
                java.lang.System.arraycopy(tArr, 0, tArr3, 0, i);
                this.items = this.v;
                this.v = null;
                return;
            }
        }
        resize(tArr.length);
    }

    public T[] begin() {
        a();
        T[] tArr = this.items;
        this.u = tArr;
        this.w++;
        return tArr;
    }

    @Override // com.badlogic.gdx.utils.Array
    public void clear() {
        a();
        super.clear();
    }

    public void end() {
        int max = java.lang.Math.max(0, this.w - 1);
        this.w = max;
        T[] tArr = this.u;
        if (tArr == null) {
            return;
        }
        if (tArr != this.items && max == 0) {
            this.v = tArr;
            int length = tArr.length;
            for (int i = 0; i < length; i++) {
                this.v[i] = null;
            }
        }
        this.u = null;
    }

    @Override // com.badlogic.gdx.utils.Array
    public void insert(int i, T t) {
        a();
        super.insert(i, t);
    }

    @Override // com.badlogic.gdx.utils.Array
    public T pop() {
        a();
        return (T) super.pop();
    }

    @Override // com.badlogic.gdx.utils.Array
    public boolean removeAll(com.badlogic.gdx.utils.Array<? extends T> array, boolean z) {
        a();
        return super.removeAll(array, z);
    }

    @Override // com.badlogic.gdx.utils.Array
    public T removeIndex(int i) {
        a();
        return (T) super.removeIndex(i);
    }

    @Override // com.badlogic.gdx.utils.Array
    public void removeRange(int i, int i2) {
        a();
        super.removeRange(i, i2);
    }

    @Override // com.badlogic.gdx.utils.Array
    public boolean removeValue(T t, boolean z) {
        a();
        return super.removeValue(t, z);
    }

    @Override // com.badlogic.gdx.utils.Array
    public void reverse() {
        a();
        super.reverse();
    }

    @Override // com.badlogic.gdx.utils.Array
    public void set(int i, T t) {
        a();
        super.set(i, t);
    }

    @Override // com.badlogic.gdx.utils.Array
    public T[] setSize(int i) {
        a();
        return (T[]) super.setSize(i);
    }

    @Override // com.badlogic.gdx.utils.Array
    public void shuffle() {
        a();
        super.shuffle();
    }

    @Override // com.badlogic.gdx.utils.Array
    public void sort() {
        a();
        super.sort();
    }

    @Override // com.badlogic.gdx.utils.Array
    public void sort(java.util.Comparator<? super T> comparator) {
        a();
        super.sort(comparator);
    }

    @Override // com.badlogic.gdx.utils.Array
    public void swap(int i, int i2) {
        a();
        super.swap(i, i2);
    }

    @Override // com.badlogic.gdx.utils.Array
    public void truncate(int i) {
        a();
        super.truncate(i);
    }
}
