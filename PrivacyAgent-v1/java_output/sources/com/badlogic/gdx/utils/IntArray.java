package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
public class IntArray {
    public int[] items;
    public boolean ordered;
    public int size;

    public IntArray() {
        this(true, 16);
    }

    public IntArray(int i) {
        this(true, i);
    }

    public IntArray(com.badlogic.gdx.utils.IntArray intArray) {
        this.ordered = intArray.ordered;
        int i = intArray.size;
        this.size = i;
        int[] iArr = new int[i];
        this.items = iArr;
        java.lang.System.arraycopy(intArray.items, 0, iArr, 0, i);
    }

    public IntArray(boolean z, int i) {
        this.ordered = z;
        this.items = new int[i];
    }

    public IntArray(boolean z, int[] iArr, int i, int i2) {
        this(z, i2);
        this.size = i2;
        java.lang.System.arraycopy(iArr, i, this.items, 0, i2);
    }

    public IntArray(int[] iArr) {
        this(true, iArr, 0, iArr.length);
    }

    public static com.badlogic.gdx.utils.IntArray with(int... iArr) {
        return new com.badlogic.gdx.utils.IntArray(iArr);
    }

    public void add(int i) {
        int[] iArr = this.items;
        int i2 = this.size;
        if (i2 == iArr.length) {
            iArr = resize(java.lang.Math.max(8, (int) (i2 * 1.75f)));
        }
        int i3 = this.size;
        this.size = i3 + 1;
        iArr[i3] = i;
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

    public void addAll(int... iArr) {
        addAll(iArr, 0, iArr.length);
    }

    public void addAll(int[] iArr, int i, int i2) {
        int[] iArr2 = this.items;
        int i3 = this.size + i2;
        if (i3 > iArr2.length) {
            iArr2 = resize(java.lang.Math.max(8, (int) (i3 * 1.75f)));
        }
        java.lang.System.arraycopy(iArr, i, iArr2, this.size, i2);
        this.size += i2;
    }

    public void clear() {
        this.size = 0;
    }

    public boolean contains(int i) {
        int i2 = this.size - 1;
        int[] iArr = this.items;
        while (i2 >= 0) {
            int i3 = i2 - 1;
            if (iArr[i2] == i) {
                return true;
            }
            i2 = i3;
        }
        return false;
    }

    public int[] ensureCapacity(int i) {
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
        if (!this.ordered || !(obj instanceof com.badlogic.gdx.utils.IntArray)) {
            return false;
        }
        com.badlogic.gdx.utils.IntArray intArray = (com.badlogic.gdx.utils.IntArray) obj;
        if (!intArray.ordered || (i = this.size) != intArray.size) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (this.items[i2] != intArray.items[i2]) {
                return false;
            }
        }
        return true;
    }

    public int first() {
        if (this.size != 0) {
            return this.items[0];
        }
        throw new java.lang.IllegalStateException("Array is empty.");
    }

    public int get(int i) {
        if (i < this.size) {
            return this.items[i];
        }
        throw new java.lang.IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.size);
    }

    public int hashCode() {
        if (!this.ordered) {
            return super.hashCode();
        }
        int[] iArr = this.items;
        int i = this.size;
        int i2 = 1;
        for (int i3 = 0; i3 < i; i3++) {
            i2 = (i2 * 31) + iArr[i3];
        }
        return i2;
    }

    public void incr(int i, int i2) {
        if (i < this.size) {
            int[] iArr = this.items;
            iArr[i] = iArr[i] + i2;
            return;
        }
        throw new java.lang.IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.size);
    }

    public int indexOf(int i) {
        int[] iArr = this.items;
        int i2 = this.size;
        for (int i3 = 0; i3 < i2; i3++) {
            if (iArr[i3] == i) {
                return i3;
            }
        }
        return -1;
    }

    public void insert(int i, int i2) {
        int i3 = this.size;
        if (i > i3) {
            throw new java.lang.IndexOutOfBoundsException("index can't be > size: " + i + " > " + this.size);
        }
        int[] iArr = this.items;
        if (i3 == iArr.length) {
            iArr = resize(java.lang.Math.max(8, (int) (i3 * 1.75f)));
        }
        if (this.ordered) {
            java.lang.System.arraycopy(iArr, i, iArr, i + 1, this.size - i);
        } else {
            iArr[this.size] = iArr[i];
        }
        this.size++;
        iArr[i] = i2;
    }

    public int lastIndexOf(int i) {
        int[] iArr = this.items;
        for (int i2 = this.size - 1; i2 >= 0; i2--) {
            if (iArr[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public void mul(int i, int i2) {
        if (i < this.size) {
            int[] iArr = this.items;
            iArr[i] = iArr[i] * i2;
            return;
        }
        throw new java.lang.IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.size);
    }

    public int peek() {
        return this.items[this.size - 1];
    }

    public int pop() {
        int[] iArr = this.items;
        int i = this.size - 1;
        this.size = i;
        return iArr[i];
    }

    public int random() {
        int i = this.size;
        if (i == 0) {
            return 0;
        }
        return this.items[com.badlogic.gdx.math.MathUtils.random(0, i - 1)];
    }

    public boolean removeAll(com.badlogic.gdx.utils.IntArray intArray) {
        int i = this.size;
        int[] iArr = this.items;
        int i2 = intArray.size;
        int i3 = i;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = intArray.get(i4);
            int i6 = 0;
            while (true) {
                if (i6 >= i3) {
                    break;
                }
                if (i5 == iArr[i6]) {
                    removeIndex(i6);
                    i3--;
                    break;
                }
                i6++;
            }
        }
        return i3 != i;
    }

    public int removeIndex(int i) {
        int i2 = this.size;
        if (i >= i2) {
            throw new java.lang.IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.size);
        }
        int[] iArr = this.items;
        int i3 = iArr[i];
        int i4 = i2 - 1;
        this.size = i4;
        if (this.ordered) {
            java.lang.System.arraycopy(iArr, i + 1, iArr, i, i4 - i);
        } else {
            iArr[i] = iArr[i4];
        }
        return i3;
    }

    public void removeRange(int i, int i2) {
        int i3 = this.size;
        if (i2 >= i3) {
            throw new java.lang.IndexOutOfBoundsException("end can't be >= size: " + i2 + " >= " + this.size);
        }
        if (i > i2) {
            throw new java.lang.IndexOutOfBoundsException("start can't be > end: " + i + " > " + i2);
        }
        int[] iArr = this.items;
        int i4 = (i2 - i) + 1;
        if (this.ordered) {
            int i5 = i + i4;
            java.lang.System.arraycopy(iArr, i5, iArr, i, i3 - i5);
        } else {
            int i6 = i3 - 1;
            for (int i7 = 0; i7 < i4; i7++) {
                iArr[i + i7] = iArr[i6 - i7];
            }
        }
        this.size -= i4;
    }

    public boolean removeValue(int i) {
        int[] iArr = this.items;
        int i2 = this.size;
        for (int i3 = 0; i3 < i2; i3++) {
            if (iArr[i3] == i) {
                removeIndex(i3);
                return true;
            }
        }
        return false;
    }

    public int[] resize(int i) {
        int[] iArr = new int[i];
        java.lang.System.arraycopy(this.items, 0, iArr, 0, java.lang.Math.min(this.size, i));
        this.items = iArr;
        return iArr;
    }

    public void reverse() {
        int[] iArr = this.items;
        int i = this.size;
        int i2 = i - 1;
        int i3 = i / 2;
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i2 - i4;
            int i6 = iArr[i4];
            iArr[i4] = iArr[i5];
            iArr[i5] = i6;
        }
    }

    public void set(int i, int i2) {
        if (i < this.size) {
            this.items[i] = i2;
            return;
        }
        throw new java.lang.IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.size);
    }

    public int[] setSize(int i) {
        if (i > this.items.length) {
            resize(java.lang.Math.max(8, i));
        }
        this.size = i;
        return this.items;
    }

    public int[] shrink() {
        int length = this.items.length;
        int i = this.size;
        if (length != i) {
            resize(i);
        }
        return this.items;
    }

    public void shuffle() {
        int[] iArr = this.items;
        for (int i = this.size - 1; i >= 0; i--) {
            int random = com.badlogic.gdx.math.MathUtils.random(i);
            int i2 = iArr[i];
            iArr[i] = iArr[random];
            iArr[random] = i2;
        }
    }

    public void sort() {
        java.util.Arrays.sort(this.items, 0, this.size);
    }

    public void swap(int i, int i2) {
        int i3 = this.size;
        if (i >= i3) {
            throw new java.lang.IndexOutOfBoundsException("first can't be >= size: " + i + " >= " + this.size);
        }
        if (i2 < i3) {
            int[] iArr = this.items;
            int i4 = iArr[i];
            iArr[i] = iArr[i2];
            iArr[i2] = i4;
            return;
        }
        throw new java.lang.IndexOutOfBoundsException("second can't be >= size: " + i2 + " >= " + this.size);
    }

    public int[] toArray() {
        int i = this.size;
        int[] iArr = new int[i];
        java.lang.System.arraycopy(this.items, 0, iArr, 0, i);
        return iArr;
    }

    public java.lang.String toString() {
        if (this.size == 0) {
            return "[]";
        }
        int[] iArr = this.items;
        com.badlogic.gdx.utils.StringBuilder stringBuilder = new com.badlogic.gdx.utils.StringBuilder(32);
        stringBuilder.append('[');
        stringBuilder.append(iArr[0]);
        for (int i = 1; i < this.size; i++) {
            stringBuilder.append(", ");
            stringBuilder.append(iArr[i]);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public java.lang.String toString(java.lang.String str) {
        if (this.size == 0) {
            return "";
        }
        int[] iArr = this.items;
        com.badlogic.gdx.utils.StringBuilder stringBuilder = new com.badlogic.gdx.utils.StringBuilder(32);
        stringBuilder.append(iArr[0]);
        for (int i = 1; i < this.size; i++) {
            stringBuilder.append(str);
            stringBuilder.append(iArr[i]);
        }
        return stringBuilder.toString();
    }

    public void truncate(int i) {
        if (this.size > i) {
            this.size = i;
        }
    }
}
