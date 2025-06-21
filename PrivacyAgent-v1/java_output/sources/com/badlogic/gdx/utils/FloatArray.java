package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
public class FloatArray {
    public float[] items;
    public boolean ordered;
    public int size;

    public FloatArray() {
        this(true, 16);
    }

    public FloatArray(int i) {
        this(true, i);
    }

    public FloatArray(com.badlogic.gdx.utils.FloatArray floatArray) {
        this.ordered = floatArray.ordered;
        int i = floatArray.size;
        this.size = i;
        float[] fArr = new float[i];
        this.items = fArr;
        java.lang.System.arraycopy(floatArray.items, 0, fArr, 0, i);
    }

    public FloatArray(boolean z, int i) {
        this.ordered = z;
        this.items = new float[i];
    }

    public FloatArray(boolean z, float[] fArr, int i, int i2) {
        this(z, i2);
        this.size = i2;
        java.lang.System.arraycopy(fArr, i, this.items, 0, i2);
    }

    public FloatArray(float[] fArr) {
        this(true, fArr, 0, fArr.length);
    }

    public static com.badlogic.gdx.utils.FloatArray with(float... fArr) {
        return new com.badlogic.gdx.utils.FloatArray(fArr);
    }

    public void add(float f) {
        float[] fArr = this.items;
        int i = this.size;
        if (i == fArr.length) {
            fArr = resize(java.lang.Math.max(8, (int) (i * 1.75f)));
        }
        int i2 = this.size;
        this.size = i2 + 1;
        fArr[i2] = f;
    }

    public void addAll(com.badlogic.gdx.utils.FloatArray floatArray) {
        addAll(floatArray, 0, floatArray.size);
    }

    public void addAll(com.badlogic.gdx.utils.FloatArray floatArray, int i, int i2) {
        if (i + i2 <= floatArray.size) {
            addAll(floatArray.items, i, i2);
            return;
        }
        throw new java.lang.IllegalArgumentException("offset + length must be <= size: " + i + " + " + i2 + " <= " + floatArray.size);
    }

    public void addAll(float... fArr) {
        addAll(fArr, 0, fArr.length);
    }

    public void addAll(float[] fArr, int i, int i2) {
        float[] fArr2 = this.items;
        int i3 = this.size + i2;
        if (i3 > fArr2.length) {
            fArr2 = resize(java.lang.Math.max(8, (int) (i3 * 1.75f)));
        }
        java.lang.System.arraycopy(fArr, i, fArr2, this.size, i2);
        this.size += i2;
    }

    public void clear() {
        this.size = 0;
    }

    public boolean contains(float f) {
        int i = this.size - 1;
        float[] fArr = this.items;
        while (i >= 0) {
            int i2 = i - 1;
            if (fArr[i] == f) {
                return true;
            }
            i = i2;
        }
        return false;
    }

    public float[] ensureCapacity(int i) {
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
        if (!this.ordered || !(obj instanceof com.badlogic.gdx.utils.FloatArray)) {
            return false;
        }
        com.badlogic.gdx.utils.FloatArray floatArray = (com.badlogic.gdx.utils.FloatArray) obj;
        if (!floatArray.ordered || (i = this.size) != floatArray.size) {
            return false;
        }
        float[] fArr = this.items;
        float[] fArr2 = floatArray.items;
        for (int i2 = 0; i2 < i; i2++) {
            if (fArr[i2] != fArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(java.lang.Object obj, float f) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.badlogic.gdx.utils.FloatArray)) {
            return false;
        }
        com.badlogic.gdx.utils.FloatArray floatArray = (com.badlogic.gdx.utils.FloatArray) obj;
        int i = this.size;
        if (i != floatArray.size || !this.ordered || !floatArray.ordered) {
            return false;
        }
        float[] fArr = this.items;
        float[] fArr2 = floatArray.items;
        for (int i2 = 0; i2 < i; i2++) {
            if (java.lang.Math.abs(fArr[i2] - fArr2[i2]) > f) {
                return false;
            }
        }
        return true;
    }

    public float first() {
        if (this.size != 0) {
            return this.items[0];
        }
        throw new java.lang.IllegalStateException("Array is empty.");
    }

    public float get(int i) {
        if (i < this.size) {
            return this.items[i];
        }
        throw new java.lang.IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.size);
    }

    public int hashCode() {
        if (!this.ordered) {
            return super.hashCode();
        }
        float[] fArr = this.items;
        int i = this.size;
        int i2 = 1;
        for (int i3 = 0; i3 < i; i3++) {
            i2 = (i2 * 31) + java.lang.Float.floatToIntBits(fArr[i3]);
        }
        return i2;
    }

    public void incr(int i, float f) {
        if (i < this.size) {
            float[] fArr = this.items;
            fArr[i] = fArr[i] + f;
            return;
        }
        throw new java.lang.IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.size);
    }

    public int indexOf(float f) {
        float[] fArr = this.items;
        int i = this.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (fArr[i2] == f) {
                return i2;
            }
        }
        return -1;
    }

    public void insert(int i, float f) {
        int i2 = this.size;
        if (i > i2) {
            throw new java.lang.IndexOutOfBoundsException("index can't be > size: " + i + " > " + this.size);
        }
        float[] fArr = this.items;
        if (i2 == fArr.length) {
            fArr = resize(java.lang.Math.max(8, (int) (i2 * 1.75f)));
        }
        if (this.ordered) {
            java.lang.System.arraycopy(fArr, i, fArr, i + 1, this.size - i);
        } else {
            fArr[this.size] = fArr[i];
        }
        this.size++;
        fArr[i] = f;
    }

    public int lastIndexOf(char c) {
        float[] fArr = this.items;
        for (int i = this.size - 1; i >= 0; i--) {
            if (fArr[i] == c) {
                return i;
            }
        }
        return -1;
    }

    public void mul(int i, float f) {
        if (i < this.size) {
            float[] fArr = this.items;
            fArr[i] = fArr[i] * f;
            return;
        }
        throw new java.lang.IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.size);
    }

    public float peek() {
        return this.items[this.size - 1];
    }

    public float pop() {
        float[] fArr = this.items;
        int i = this.size - 1;
        this.size = i;
        return fArr[i];
    }

    public float random() {
        int i = this.size;
        if (i == 0) {
            return 0.0f;
        }
        return this.items[com.badlogic.gdx.math.MathUtils.random(0, i - 1)];
    }

    public boolean removeAll(com.badlogic.gdx.utils.FloatArray floatArray) {
        int i = this.size;
        float[] fArr = this.items;
        int i2 = floatArray.size;
        int i3 = i;
        for (int i4 = 0; i4 < i2; i4++) {
            float f = floatArray.get(i4);
            int i5 = 0;
            while (true) {
                if (i5 >= i3) {
                    break;
                }
                if (f == fArr[i5]) {
                    removeIndex(i5);
                    i3--;
                    break;
                }
                i5++;
            }
        }
        return i3 != i;
    }

    public float removeIndex(int i) {
        int i2 = this.size;
        if (i >= i2) {
            throw new java.lang.IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.size);
        }
        float[] fArr = this.items;
        float f = fArr[i];
        int i3 = i2 - 1;
        this.size = i3;
        if (this.ordered) {
            java.lang.System.arraycopy(fArr, i + 1, fArr, i, i3 - i);
        } else {
            fArr[i] = fArr[i3];
        }
        return f;
    }

    public void removeRange(int i, int i2) {
        int i3 = this.size;
        if (i2 >= i3) {
            throw new java.lang.IndexOutOfBoundsException("end can't be >= size: " + i2 + " >= " + this.size);
        }
        if (i > i2) {
            throw new java.lang.IndexOutOfBoundsException("start can't be > end: " + i + " > " + i2);
        }
        float[] fArr = this.items;
        int i4 = (i2 - i) + 1;
        if (this.ordered) {
            int i5 = i + i4;
            java.lang.System.arraycopy(fArr, i5, fArr, i, i3 - i5);
        } else {
            int i6 = i3 - 1;
            for (int i7 = 0; i7 < i4; i7++) {
                fArr[i + i7] = fArr[i6 - i7];
            }
        }
        this.size -= i4;
    }

    public boolean removeValue(float f) {
        float[] fArr = this.items;
        int i = this.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (fArr[i2] == f) {
                removeIndex(i2);
                return true;
            }
        }
        return false;
    }

    public float[] resize(int i) {
        float[] fArr = new float[i];
        java.lang.System.arraycopy(this.items, 0, fArr, 0, java.lang.Math.min(this.size, i));
        this.items = fArr;
        return fArr;
    }

    public void reverse() {
        float[] fArr = this.items;
        int i = this.size;
        int i2 = i - 1;
        int i3 = i / 2;
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i2 - i4;
            float f = fArr[i4];
            fArr[i4] = fArr[i5];
            fArr[i5] = f;
        }
    }

    public void set(int i, float f) {
        if (i < this.size) {
            this.items[i] = f;
            return;
        }
        throw new java.lang.IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.size);
    }

    public float[] setSize(int i) {
        if (i > this.items.length) {
            resize(java.lang.Math.max(8, i));
        }
        this.size = i;
        return this.items;
    }

    public float[] shrink() {
        int length = this.items.length;
        int i = this.size;
        if (length != i) {
            resize(i);
        }
        return this.items;
    }

    public void shuffle() {
        float[] fArr = this.items;
        for (int i = this.size - 1; i >= 0; i--) {
            int random = com.badlogic.gdx.math.MathUtils.random(i);
            float f = fArr[i];
            fArr[i] = fArr[random];
            fArr[random] = f;
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
            float[] fArr = this.items;
            float f = fArr[i];
            fArr[i] = fArr[i2];
            fArr[i2] = f;
            return;
        }
        throw new java.lang.IndexOutOfBoundsException("second can't be >= size: " + i2 + " >= " + this.size);
    }

    public float[] toArray() {
        int i = this.size;
        float[] fArr = new float[i];
        java.lang.System.arraycopy(this.items, 0, fArr, 0, i);
        return fArr;
    }

    public java.lang.String toString() {
        if (this.size == 0) {
            return "[]";
        }
        float[] fArr = this.items;
        com.badlogic.gdx.utils.StringBuilder stringBuilder = new com.badlogic.gdx.utils.StringBuilder(32);
        stringBuilder.append('[');
        stringBuilder.append(fArr[0]);
        for (int i = 1; i < this.size; i++) {
            stringBuilder.append(", ");
            stringBuilder.append(fArr[i]);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public java.lang.String toString(java.lang.String str) {
        if (this.size == 0) {
            return "";
        }
        float[] fArr = this.items;
        com.badlogic.gdx.utils.StringBuilder stringBuilder = new com.badlogic.gdx.utils.StringBuilder(32);
        stringBuilder.append(fArr[0]);
        for (int i = 1; i < this.size; i++) {
            stringBuilder.append(str);
            stringBuilder.append(fArr[i]);
        }
        return stringBuilder.toString();
    }

    public void truncate(int i) {
        if (this.size > i) {
            this.size = i;
        }
    }
}
