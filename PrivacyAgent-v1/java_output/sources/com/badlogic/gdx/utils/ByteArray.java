package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
public class ByteArray {
    public byte[] items;
    public boolean ordered;
    public int size;

    public ByteArray() {
        this(true, 16);
    }

    public ByteArray(int i) {
        this(true, i);
    }

    public ByteArray(com.badlogic.gdx.utils.ByteArray byteArray) {
        this.ordered = byteArray.ordered;
        int i = byteArray.size;
        this.size = i;
        byte[] bArr = new byte[i];
        this.items = bArr;
        java.lang.System.arraycopy(byteArray.items, 0, bArr, 0, i);
    }

    public ByteArray(boolean z, int i) {
        this.ordered = z;
        this.items = new byte[i];
    }

    public ByteArray(boolean z, byte[] bArr, int i, int i2) {
        this(z, i2);
        this.size = i2;
        java.lang.System.arraycopy(bArr, i, this.items, 0, i2);
    }

    public ByteArray(byte[] bArr) {
        this(true, bArr, 0, bArr.length);
    }

    public static com.badlogic.gdx.utils.ByteArray with(byte... bArr) {
        return new com.badlogic.gdx.utils.ByteArray(bArr);
    }

    public void add(byte b) {
        byte[] bArr = this.items;
        int i = this.size;
        if (i == bArr.length) {
            bArr = resize(java.lang.Math.max(8, (int) (i * 1.75f)));
        }
        int i2 = this.size;
        this.size = i2 + 1;
        bArr[i2] = b;
    }

    public void addAll(com.badlogic.gdx.utils.ByteArray byteArray) {
        addAll(byteArray, 0, byteArray.size);
    }

    public void addAll(com.badlogic.gdx.utils.ByteArray byteArray, int i, int i2) {
        if (i + i2 <= byteArray.size) {
            addAll(byteArray.items, i, i2);
            return;
        }
        throw new java.lang.IllegalArgumentException("offset + length must be <= size: " + i + " + " + i2 + " <= " + byteArray.size);
    }

    public void addAll(byte... bArr) {
        addAll(bArr, 0, bArr.length);
    }

    public void addAll(byte[] bArr, int i, int i2) {
        byte[] bArr2 = this.items;
        int i3 = this.size + i2;
        if (i3 > bArr2.length) {
            bArr2 = resize(java.lang.Math.max(8, (int) (i3 * 1.75f)));
        }
        java.lang.System.arraycopy(bArr, i, bArr2, this.size, i2);
        this.size += i2;
    }

    public void clear() {
        this.size = 0;
    }

    public boolean contains(byte b) {
        int i = this.size - 1;
        byte[] bArr = this.items;
        while (i >= 0) {
            int i2 = i - 1;
            if (bArr[i] == b) {
                return true;
            }
            i = i2;
        }
        return false;
    }

    public byte[] ensureCapacity(int i) {
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
        if (!this.ordered || !(obj instanceof com.badlogic.gdx.utils.ByteArray)) {
            return false;
        }
        com.badlogic.gdx.utils.ByteArray byteArray = (com.badlogic.gdx.utils.ByteArray) obj;
        if (!byteArray.ordered || (i = this.size) != byteArray.size) {
            return false;
        }
        byte[] bArr = this.items;
        byte[] bArr2 = byteArray.items;
        for (int i2 = 0; i2 < i; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public byte first() {
        if (this.size != 0) {
            return this.items[0];
        }
        throw new java.lang.IllegalStateException("Array is empty.");
    }

    public byte get(int i) {
        if (i < this.size) {
            return this.items[i];
        }
        throw new java.lang.IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.size);
    }

    public int hashCode() {
        if (!this.ordered) {
            return super.hashCode();
        }
        byte[] bArr = this.items;
        int i = this.size;
        int i2 = 1;
        for (int i3 = 0; i3 < i; i3++) {
            i2 = (i2 * 31) + bArr[i3];
        }
        return i2;
    }

    public void incr(int i, byte b) {
        if (i < this.size) {
            byte[] bArr = this.items;
            bArr[i] = (byte) (bArr[i] + b);
            return;
        }
        throw new java.lang.IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.size);
    }

    public int indexOf(byte b) {
        byte[] bArr = this.items;
        int i = this.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (bArr[i2] == b) {
                return i2;
            }
        }
        return -1;
    }

    public void insert(int i, byte b) {
        int i2 = this.size;
        if (i > i2) {
            throw new java.lang.IndexOutOfBoundsException("index can't be > size: " + i + " > " + this.size);
        }
        byte[] bArr = this.items;
        if (i2 == bArr.length) {
            bArr = resize(java.lang.Math.max(8, (int) (i2 * 1.75f)));
        }
        if (this.ordered) {
            java.lang.System.arraycopy(bArr, i, bArr, i + 1, this.size - i);
        } else {
            bArr[this.size] = bArr[i];
        }
        this.size++;
        bArr[i] = b;
    }

    public int lastIndexOf(byte b) {
        byte[] bArr = this.items;
        for (int i = this.size - 1; i >= 0; i--) {
            if (bArr[i] == b) {
                return i;
            }
        }
        return -1;
    }

    public void mul(int i, byte b) {
        if (i < this.size) {
            byte[] bArr = this.items;
            bArr[i] = (byte) (bArr[i] * b);
            return;
        }
        throw new java.lang.IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.size);
    }

    public byte peek() {
        return this.items[this.size - 1];
    }

    public byte pop() {
        byte[] bArr = this.items;
        int i = this.size - 1;
        this.size = i;
        return bArr[i];
    }

    public byte random() {
        int i = this.size;
        if (i == 0) {
            return (byte) 0;
        }
        return this.items[com.badlogic.gdx.math.MathUtils.random(0, i - 1)];
    }

    public boolean removeAll(com.badlogic.gdx.utils.ByteArray byteArray) {
        int i = this.size;
        byte[] bArr = this.items;
        int i2 = byteArray.size;
        int i3 = i;
        for (int i4 = 0; i4 < i2; i4++) {
            byte b = byteArray.get(i4);
            int i5 = 0;
            while (true) {
                if (i5 >= i3) {
                    break;
                }
                if (b == bArr[i5]) {
                    removeIndex(i5);
                    i3--;
                    break;
                }
                i5++;
            }
        }
        return i3 != i;
    }

    public int removeIndex(int i) {
        int i2 = this.size;
        if (i >= i2) {
            throw new java.lang.IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.size);
        }
        byte[] bArr = this.items;
        byte b = bArr[i];
        int i3 = i2 - 1;
        this.size = i3;
        if (this.ordered) {
            java.lang.System.arraycopy(bArr, i + 1, bArr, i, i3 - i);
        } else {
            bArr[i] = bArr[i3];
        }
        return b;
    }

    public void removeRange(int i, int i2) {
        int i3 = this.size;
        if (i2 >= i3) {
            throw new java.lang.IndexOutOfBoundsException("end can't be >= size: " + i2 + " >= " + this.size);
        }
        if (i > i2) {
            throw new java.lang.IndexOutOfBoundsException("start can't be > end: " + i + " > " + i2);
        }
        byte[] bArr = this.items;
        int i4 = (i2 - i) + 1;
        if (this.ordered) {
            int i5 = i + i4;
            java.lang.System.arraycopy(bArr, i5, bArr, i, i3 - i5);
        } else {
            int i6 = i3 - 1;
            for (int i7 = 0; i7 < i4; i7++) {
                bArr[i + i7] = bArr[i6 - i7];
            }
        }
        this.size -= i4;
    }

    public boolean removeValue(byte b) {
        byte[] bArr = this.items;
        int i = this.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (bArr[i2] == b) {
                removeIndex(i2);
                return true;
            }
        }
        return false;
    }

    public byte[] resize(int i) {
        byte[] bArr = new byte[i];
        java.lang.System.arraycopy(this.items, 0, bArr, 0, java.lang.Math.min(this.size, i));
        this.items = bArr;
        return bArr;
    }

    public void reverse() {
        byte[] bArr = this.items;
        int i = this.size;
        int i2 = i - 1;
        int i3 = i / 2;
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i2 - i4;
            byte b = bArr[i4];
            bArr[i4] = bArr[i5];
            bArr[i5] = b;
        }
    }

    public void set(int i, byte b) {
        if (i < this.size) {
            this.items[i] = b;
            return;
        }
        throw new java.lang.IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.size);
    }

    public byte[] setSize(int i) {
        if (i > this.items.length) {
            resize(java.lang.Math.max(8, i));
        }
        this.size = i;
        return this.items;
    }

    public byte[] shrink() {
        int length = this.items.length;
        int i = this.size;
        if (length != i) {
            resize(i);
        }
        return this.items;
    }

    public void shuffle() {
        byte[] bArr = this.items;
        for (int i = this.size - 1; i >= 0; i--) {
            int random = com.badlogic.gdx.math.MathUtils.random(i);
            byte b = bArr[i];
            bArr[i] = bArr[random];
            bArr[random] = b;
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
            byte[] bArr = this.items;
            byte b = bArr[i];
            bArr[i] = bArr[i2];
            bArr[i2] = b;
            return;
        }
        throw new java.lang.IndexOutOfBoundsException("second can't be >= size: " + i2 + " >= " + this.size);
    }

    public byte[] toArray() {
        int i = this.size;
        byte[] bArr = new byte[i];
        java.lang.System.arraycopy(this.items, 0, bArr, 0, i);
        return bArr;
    }

    public java.lang.String toString() {
        if (this.size == 0) {
            return "[]";
        }
        byte[] bArr = this.items;
        com.badlogic.gdx.utils.StringBuilder stringBuilder = new com.badlogic.gdx.utils.StringBuilder(32);
        stringBuilder.append('[');
        stringBuilder.append((int) bArr[0]);
        for (int i = 1; i < this.size; i++) {
            stringBuilder.append(", ");
            stringBuilder.append((int) bArr[i]);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public java.lang.String toString(java.lang.String str) {
        if (this.size == 0) {
            return "";
        }
        byte[] bArr = this.items;
        com.badlogic.gdx.utils.StringBuilder stringBuilder = new com.badlogic.gdx.utils.StringBuilder(32);
        stringBuilder.append((int) bArr[0]);
        for (int i = 1; i < this.size; i++) {
            stringBuilder.append(str);
            stringBuilder.append((int) bArr[i]);
        }
        return stringBuilder.toString();
    }

    public void truncate(int i) {
        if (this.size > i) {
            this.size = i;
        }
    }
}
