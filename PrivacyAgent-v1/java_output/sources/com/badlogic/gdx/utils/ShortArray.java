package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
public class ShortArray {
    public short[] items;
    public boolean ordered;
    public int size;

    public ShortArray() {
        this(true, 16);
    }

    public ShortArray(int i) {
        this(true, i);
    }

    public ShortArray(com.badlogic.gdx.utils.ShortArray shortArray) {
        this.ordered = shortArray.ordered;
        int i = shortArray.size;
        this.size = i;
        short[] sArr = new short[i];
        this.items = sArr;
        java.lang.System.arraycopy(shortArray.items, 0, sArr, 0, i);
    }

    public ShortArray(boolean z, int i) {
        this.ordered = z;
        this.items = new short[i];
    }

    public ShortArray(boolean z, short[] sArr, int i, int i2) {
        this(z, i2);
        this.size = i2;
        java.lang.System.arraycopy(sArr, i, this.items, 0, i2);
    }

    public ShortArray(short[] sArr) {
        this(true, sArr, 0, sArr.length);
    }

    public static com.badlogic.gdx.utils.ShortArray with(short... sArr) {
        return new com.badlogic.gdx.utils.ShortArray(sArr);
    }

    public void add(int i) {
        short[] sArr = this.items;
        int i2 = this.size;
        if (i2 == sArr.length) {
            sArr = resize(java.lang.Math.max(8, (int) (i2 * 1.75f)));
        }
        int i3 = this.size;
        this.size = i3 + 1;
        sArr[i3] = (short) i;
    }

    public void add(short s2) {
        short[] sArr = this.items;
        int i = this.size;
        if (i == sArr.length) {
            sArr = resize(java.lang.Math.max(8, (int) (i * 1.75f)));
        }
        int i2 = this.size;
        this.size = i2 + 1;
        sArr[i2] = s2;
    }

    public void addAll(com.badlogic.gdx.utils.ShortArray shortArray) {
        addAll(shortArray, 0, shortArray.size);
    }

    public void addAll(com.badlogic.gdx.utils.ShortArray shortArray, int i, int i2) {
        if (i + i2 <= shortArray.size) {
            addAll(shortArray.items, i, i2);
            return;
        }
        throw new java.lang.IllegalArgumentException("offset + length must be <= size: " + i + " + " + i2 + " <= " + shortArray.size);
    }

    public void addAll(short... sArr) {
        addAll(sArr, 0, sArr.length);
    }

    public void addAll(short[] sArr, int i, int i2) {
        short[] sArr2 = this.items;
        int i3 = this.size + i2;
        if (i3 > sArr2.length) {
            sArr2 = resize(java.lang.Math.max(8, (int) (i3 * 1.75f)));
        }
        java.lang.System.arraycopy(sArr, i, sArr2, this.size, i2);
        this.size += i2;
    }

    public void clear() {
        this.size = 0;
    }

    public boolean contains(short s2) {
        int i = this.size - 1;
        short[] sArr = this.items;
        while (i >= 0) {
            int i2 = i - 1;
            if (sArr[i] == s2) {
                return true;
            }
            i = i2;
        }
        return false;
    }

    public short[] ensureCapacity(int i) {
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
        if (!this.ordered || !(obj instanceof com.badlogic.gdx.utils.ShortArray)) {
            return false;
        }
        com.badlogic.gdx.utils.ShortArray shortArray = (com.badlogic.gdx.utils.ShortArray) obj;
        if (!shortArray.ordered || (i = this.size) != shortArray.size) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (this.items[i2] != shortArray.items[i2]) {
                return false;
            }
        }
        return true;
    }

    public short first() {
        if (this.size != 0) {
            return this.items[0];
        }
        throw new java.lang.IllegalStateException("Array is empty.");
    }

    public short get(int i) {
        if (i < this.size) {
            return this.items[i];
        }
        throw new java.lang.IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.size);
    }

    public int hashCode() {
        if (!this.ordered) {
            return super.hashCode();
        }
        short[] sArr = this.items;
        int i = this.size;
        int i2 = 1;
        for (int i3 = 0; i3 < i; i3++) {
            i2 = (i2 * 31) + sArr[i3];
        }
        return i2;
    }

    public void incr(int i, short s2) {
        if (i < this.size) {
            short[] sArr = this.items;
            sArr[i] = (short) (sArr[i] + s2);
            return;
        }
        throw new java.lang.IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.size);
    }

    public int indexOf(short s2) {
        short[] sArr = this.items;
        int i = this.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (sArr[i2] == s2) {
                return i2;
            }
        }
        return -1;
    }

    public void insert(int i, short s2) {
        int i2 = this.size;
        if (i > i2) {
            throw new java.lang.IndexOutOfBoundsException("index can't be > size: " + i + " > " + this.size);
        }
        short[] sArr = this.items;
        if (i2 == sArr.length) {
            sArr = resize(java.lang.Math.max(8, (int) (i2 * 1.75f)));
        }
        if (this.ordered) {
            java.lang.System.arraycopy(sArr, i, sArr, i + 1, this.size - i);
        } else {
            sArr[this.size] = sArr[i];
        }
        this.size++;
        sArr[i] = s2;
    }

    public int lastIndexOf(char c) {
        short[] sArr = this.items;
        for (int i = this.size - 1; i >= 0; i--) {
            if (sArr[i] == c) {
                return i;
            }
        }
        return -1;
    }

    public void mul(int i, short s2) {
        if (i < this.size) {
            short[] sArr = this.items;
            sArr[i] = (short) (sArr[i] * s2);
            return;
        }
        throw new java.lang.IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.size);
    }

    public short peek() {
        return this.items[this.size - 1];
    }

    public short pop() {
        short[] sArr = this.items;
        int i = this.size - 1;
        this.size = i;
        return sArr[i];
    }

    public short random() {
        int i = this.size;
        if (i == 0) {
            return (short) 0;
        }
        return this.items[com.badlogic.gdx.math.MathUtils.random(0, i - 1)];
    }

    public boolean removeAll(com.badlogic.gdx.utils.ShortArray shortArray) {
        int i = this.size;
        short[] sArr = this.items;
        int i2 = shortArray.size;
        int i3 = i;
        for (int i4 = 0; i4 < i2; i4++) {
            short s2 = shortArray.get(i4);
            int i5 = 0;
            while (true) {
                if (i5 >= i3) {
                    break;
                }
                if (s2 == sArr[i5]) {
                    removeIndex(i5);
                    i3--;
                    break;
                }
                i5++;
            }
        }
        return i3 != i;
    }

    public short removeIndex(int i) {
        int i2 = this.size;
        if (i >= i2) {
            throw new java.lang.IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.size);
        }
        short[] sArr = this.items;
        short s2 = sArr[i];
        int i3 = i2 - 1;
        this.size = i3;
        if (this.ordered) {
            java.lang.System.arraycopy(sArr, i + 1, sArr, i, i3 - i);
        } else {
            sArr[i] = sArr[i3];
        }
        return s2;
    }

    public void removeRange(int i, int i2) {
        int i3 = this.size;
        if (i2 >= i3) {
            throw new java.lang.IndexOutOfBoundsException("end can't be >= size: " + i2 + " >= " + this.size);
        }
        if (i > i2) {
            throw new java.lang.IndexOutOfBoundsException("start can't be > end: " + i + " > " + i2);
        }
        short[] sArr = this.items;
        int i4 = (i2 - i) + 1;
        if (this.ordered) {
            int i5 = i + i4;
            java.lang.System.arraycopy(sArr, i5, sArr, i, i3 - i5);
        } else {
            int i6 = i3 - 1;
            for (int i7 = 0; i7 < i4; i7++) {
                sArr[i + i7] = sArr[i6 - i7];
            }
        }
        this.size -= i4;
    }

    public boolean removeValue(short s2) {
        short[] sArr = this.items;
        int i = this.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (sArr[i2] == s2) {
                removeIndex(i2);
                return true;
            }
        }
        return false;
    }

    public short[] resize(int i) {
        short[] sArr = new short[i];
        java.lang.System.arraycopy(this.items, 0, sArr, 0, java.lang.Math.min(this.size, i));
        this.items = sArr;
        return sArr;
    }

    public void reverse() {
        short[] sArr = this.items;
        int i = this.size;
        int i2 = i - 1;
        int i3 = i / 2;
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i2 - i4;
            short s2 = sArr[i4];
            sArr[i4] = sArr[i5];
            sArr[i5] = s2;
        }
    }

    public void set(int i, short s2) {
        if (i < this.size) {
            this.items[i] = s2;
            return;
        }
        throw new java.lang.IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.size);
    }

    public short[] setSize(int i) {
        if (i > this.items.length) {
            resize(java.lang.Math.max(8, i));
        }
        this.size = i;
        return this.items;
    }

    public short[] shrink() {
        int length = this.items.length;
        int i = this.size;
        if (length != i) {
            resize(i);
        }
        return this.items;
    }

    public void shuffle() {
        short[] sArr = this.items;
        for (int i = this.size - 1; i >= 0; i--) {
            int random = com.badlogic.gdx.math.MathUtils.random(i);
            short s2 = sArr[i];
            sArr[i] = sArr[random];
            sArr[random] = s2;
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
            short[] sArr = this.items;
            short s2 = sArr[i];
            sArr[i] = sArr[i2];
            sArr[i2] = s2;
            return;
        }
        throw new java.lang.IndexOutOfBoundsException("second can't be >= size: " + i2 + " >= " + this.size);
    }

    public short[] toArray() {
        int i = this.size;
        short[] sArr = new short[i];
        java.lang.System.arraycopy(this.items, 0, sArr, 0, i);
        return sArr;
    }

    public java.lang.String toString() {
        if (this.size == 0) {
            return "[]";
        }
        short[] sArr = this.items;
        com.badlogic.gdx.utils.StringBuilder stringBuilder = new com.badlogic.gdx.utils.StringBuilder(32);
        stringBuilder.append('[');
        stringBuilder.append((int) sArr[0]);
        for (int i = 1; i < this.size; i++) {
            stringBuilder.append(", ");
            stringBuilder.append((int) sArr[i]);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public java.lang.String toString(java.lang.String str) {
        if (this.size == 0) {
            return "";
        }
        short[] sArr = this.items;
        com.badlogic.gdx.utils.StringBuilder stringBuilder = new com.badlogic.gdx.utils.StringBuilder(32);
        stringBuilder.append((int) sArr[0]);
        for (int i = 1; i < this.size; i++) {
            stringBuilder.append(str);
            stringBuilder.append((int) sArr[i]);
        }
        return stringBuilder.toString();
    }

    public void truncate(int i) {
        if (this.size > i) {
            this.size = i;
        }
    }
}
