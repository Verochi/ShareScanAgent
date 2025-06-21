package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
public class BooleanArray {
    public boolean[] items;
    public boolean ordered;
    public int size;

    public BooleanArray() {
        this(true, 16);
    }

    public BooleanArray(int i) {
        this(true, i);
    }

    public BooleanArray(com.badlogic.gdx.utils.BooleanArray booleanArray) {
        this.ordered = booleanArray.ordered;
        int i = booleanArray.size;
        this.size = i;
        boolean[] zArr = new boolean[i];
        this.items = zArr;
        java.lang.System.arraycopy(booleanArray.items, 0, zArr, 0, i);
    }

    public BooleanArray(boolean z, int i) {
        this.ordered = z;
        this.items = new boolean[i];
    }

    public BooleanArray(boolean z, boolean[] zArr, int i, int i2) {
        this(z, i2);
        this.size = i2;
        java.lang.System.arraycopy(zArr, i, this.items, 0, i2);
    }

    public BooleanArray(boolean[] zArr) {
        this(true, zArr, 0, zArr.length);
    }

    public static com.badlogic.gdx.utils.BooleanArray with(boolean... zArr) {
        return new com.badlogic.gdx.utils.BooleanArray(zArr);
    }

    public void add(boolean z) {
        boolean[] zArr = this.items;
        int i = this.size;
        if (i == zArr.length) {
            zArr = resize(java.lang.Math.max(8, (int) (i * 1.75f)));
        }
        int i2 = this.size;
        this.size = i2 + 1;
        zArr[i2] = z;
    }

    public void addAll(com.badlogic.gdx.utils.BooleanArray booleanArray) {
        addAll(booleanArray, 0, booleanArray.size);
    }

    public void addAll(com.badlogic.gdx.utils.BooleanArray booleanArray, int i, int i2) {
        if (i + i2 <= booleanArray.size) {
            addAll(booleanArray.items, i, i2);
            return;
        }
        throw new java.lang.IllegalArgumentException("offset + length must be <= size: " + i + " + " + i2 + " <= " + booleanArray.size);
    }

    public void addAll(boolean... zArr) {
        addAll(zArr, 0, zArr.length);
    }

    public void addAll(boolean[] zArr, int i, int i2) {
        boolean[] zArr2 = this.items;
        int i3 = this.size + i2;
        if (i3 > zArr2.length) {
            zArr2 = resize(java.lang.Math.max(8, (int) (i3 * 1.75f)));
        }
        java.lang.System.arraycopy(zArr, i, zArr2, this.size, i2);
        this.size += i2;
    }

    public void clear() {
        this.size = 0;
    }

    public boolean[] ensureCapacity(int i) {
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
        if (!this.ordered || !(obj instanceof com.badlogic.gdx.utils.BooleanArray)) {
            return false;
        }
        com.badlogic.gdx.utils.BooleanArray booleanArray = (com.badlogic.gdx.utils.BooleanArray) obj;
        if (!booleanArray.ordered || (i = this.size) != booleanArray.size) {
            return false;
        }
        boolean[] zArr = this.items;
        boolean[] zArr2 = booleanArray.items;
        for (int i2 = 0; i2 < i; i2++) {
            if (zArr[i2] != zArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public boolean first() {
        if (this.size != 0) {
            return this.items[0];
        }
        throw new java.lang.IllegalStateException("Array is empty.");
    }

    public boolean get(int i) {
        if (i < this.size) {
            return this.items[i];
        }
        throw new java.lang.IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.size);
    }

    public int hashCode() {
        if (!this.ordered) {
            return super.hashCode();
        }
        boolean[] zArr = this.items;
        int i = this.size;
        int i2 = 1;
        for (int i3 = 0; i3 < i; i3++) {
            i2 = (i2 * 31) + (zArr[i3] ? 1231 : 1237);
        }
        return i2;
    }

    public void insert(int i, boolean z) {
        int i2 = this.size;
        if (i > i2) {
            throw new java.lang.IndexOutOfBoundsException("index can't be > size: " + i + " > " + this.size);
        }
        boolean[] zArr = this.items;
        if (i2 == zArr.length) {
            zArr = resize(java.lang.Math.max(8, (int) (i2 * 1.75f)));
        }
        if (this.ordered) {
            java.lang.System.arraycopy(zArr, i, zArr, i + 1, this.size - i);
        } else {
            zArr[this.size] = zArr[i];
        }
        this.size++;
        zArr[i] = z;
    }

    public boolean peek() {
        return this.items[this.size - 1];
    }

    public boolean pop() {
        boolean[] zArr = this.items;
        int i = this.size - 1;
        this.size = i;
        return zArr[i];
    }

    public boolean random() {
        int i = this.size;
        if (i == 0) {
            return false;
        }
        return this.items[com.badlogic.gdx.math.MathUtils.random(0, i - 1)];
    }

    public boolean removeAll(com.badlogic.gdx.utils.BooleanArray booleanArray) {
        int i = this.size;
        boolean[] zArr = this.items;
        int i2 = booleanArray.size;
        int i3 = i;
        for (int i4 = 0; i4 < i2; i4++) {
            boolean z = booleanArray.get(i4);
            int i5 = 0;
            while (true) {
                if (i5 >= i3) {
                    break;
                }
                if (z == zArr[i5]) {
                    removeIndex(i5);
                    i3--;
                    break;
                }
                i5++;
            }
        }
        return i3 != i;
    }

    public boolean removeIndex(int i) {
        int i2 = this.size;
        if (i >= i2) {
            throw new java.lang.IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.size);
        }
        boolean[] zArr = this.items;
        boolean z = zArr[i];
        int i3 = i2 - 1;
        this.size = i3;
        if (this.ordered) {
            java.lang.System.arraycopy(zArr, i + 1, zArr, i, i3 - i);
        } else {
            zArr[i] = zArr[i3];
        }
        return z;
    }

    public void removeRange(int i, int i2) {
        int i3 = this.size;
        if (i2 >= i3) {
            throw new java.lang.IndexOutOfBoundsException("end can't be >= size: " + i2 + " >= " + this.size);
        }
        if (i > i2) {
            throw new java.lang.IndexOutOfBoundsException("start can't be > end: " + i + " > " + i2);
        }
        boolean[] zArr = this.items;
        int i4 = (i2 - i) + 1;
        if (this.ordered) {
            int i5 = i + i4;
            java.lang.System.arraycopy(zArr, i5, zArr, i, i3 - i5);
        } else {
            int i6 = i3 - 1;
            for (int i7 = 0; i7 < i4; i7++) {
                zArr[i + i7] = zArr[i6 - i7];
            }
        }
        this.size -= i4;
    }

    public boolean[] resize(int i) {
        boolean[] zArr = new boolean[i];
        java.lang.System.arraycopy(this.items, 0, zArr, 0, java.lang.Math.min(this.size, i));
        this.items = zArr;
        return zArr;
    }

    public void reverse() {
        boolean[] zArr = this.items;
        int i = this.size;
        int i2 = i - 1;
        int i3 = i / 2;
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i2 - i4;
            boolean z = zArr[i4];
            zArr[i4] = zArr[i5];
            zArr[i5] = z;
        }
    }

    public void set(int i, boolean z) {
        if (i < this.size) {
            this.items[i] = z;
            return;
        }
        throw new java.lang.IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.size);
    }

    public boolean[] setSize(int i) {
        if (i > this.items.length) {
            resize(java.lang.Math.max(8, i));
        }
        this.size = i;
        return this.items;
    }

    public boolean[] shrink() {
        int length = this.items.length;
        int i = this.size;
        if (length != i) {
            resize(i);
        }
        return this.items;
    }

    public void shuffle() {
        boolean[] zArr = this.items;
        for (int i = this.size - 1; i >= 0; i--) {
            int random = com.badlogic.gdx.math.MathUtils.random(i);
            boolean z = zArr[i];
            zArr[i] = zArr[random];
            zArr[random] = z;
        }
    }

    public void swap(int i, int i2) {
        int i3 = this.size;
        if (i >= i3) {
            throw new java.lang.IndexOutOfBoundsException("first can't be >= size: " + i + " >= " + this.size);
        }
        if (i2 < i3) {
            boolean[] zArr = this.items;
            boolean z = zArr[i];
            zArr[i] = zArr[i2];
            zArr[i2] = z;
            return;
        }
        throw new java.lang.IndexOutOfBoundsException("second can't be >= size: " + i2 + " >= " + this.size);
    }

    public boolean[] toArray() {
        int i = this.size;
        boolean[] zArr = new boolean[i];
        java.lang.System.arraycopy(this.items, 0, zArr, 0, i);
        return zArr;
    }

    public java.lang.String toString() {
        if (this.size == 0) {
            return "[]";
        }
        boolean[] zArr = this.items;
        com.badlogic.gdx.utils.StringBuilder stringBuilder = new com.badlogic.gdx.utils.StringBuilder(32);
        stringBuilder.append('[');
        stringBuilder.append(zArr[0]);
        for (int i = 1; i < this.size; i++) {
            stringBuilder.append(", ");
            stringBuilder.append(zArr[i]);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public java.lang.String toString(java.lang.String str) {
        if (this.size == 0) {
            return "";
        }
        boolean[] zArr = this.items;
        com.badlogic.gdx.utils.StringBuilder stringBuilder = new com.badlogic.gdx.utils.StringBuilder(32);
        stringBuilder.append(zArr[0]);
        for (int i = 1; i < this.size; i++) {
            stringBuilder.append(str);
            stringBuilder.append(zArr[i]);
        }
        return stringBuilder.toString();
    }

    public void truncate(int i) {
        if (this.size > i) {
            this.size = i;
        }
    }
}
