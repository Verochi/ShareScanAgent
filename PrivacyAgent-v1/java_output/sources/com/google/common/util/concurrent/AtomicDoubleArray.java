package com.google.common.util.concurrent;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
public class AtomicDoubleArray implements java.io.Serializable {
    private static final long serialVersionUID = 0;
    private transient java.util.concurrent.atomic.AtomicLongArray longs;

    public AtomicDoubleArray(int i) {
        this.longs = new java.util.concurrent.atomic.AtomicLongArray(i);
    }

    public AtomicDoubleArray(double[] dArr) {
        int length = dArr.length;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = java.lang.Double.doubleToRawLongBits(dArr[i]);
        }
        this.longs = new java.util.concurrent.atomic.AtomicLongArray(jArr);
    }

    private void readObject(java.io.ObjectInputStream objectInputStream) throws java.io.IOException, java.lang.ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        com.google.common.primitives.ImmutableLongArray.Builder builder = com.google.common.primitives.ImmutableLongArray.builder();
        for (int i = 0; i < readInt; i++) {
            builder.add(java.lang.Double.doubleToRawLongBits(objectInputStream.readDouble()));
        }
        this.longs = new java.util.concurrent.atomic.AtomicLongArray(builder.build().toArray());
    }

    private void writeObject(java.io.ObjectOutputStream objectOutputStream) throws java.io.IOException {
        objectOutputStream.defaultWriteObject();
        int length = length();
        objectOutputStream.writeInt(length);
        for (int i = 0; i < length; i++) {
            objectOutputStream.writeDouble(get(i));
        }
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public double addAndGet(int i, double d) {
        long j;
        double longBitsToDouble;
        do {
            j = this.longs.get(i);
            longBitsToDouble = java.lang.Double.longBitsToDouble(j) + d;
        } while (!this.longs.compareAndSet(i, j, java.lang.Double.doubleToRawLongBits(longBitsToDouble)));
        return longBitsToDouble;
    }

    public final boolean compareAndSet(int i, double d, double d2) {
        return this.longs.compareAndSet(i, java.lang.Double.doubleToRawLongBits(d), java.lang.Double.doubleToRawLongBits(d2));
    }

    public final double get(int i) {
        return java.lang.Double.longBitsToDouble(this.longs.get(i));
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public final double getAndAdd(int i, double d) {
        long j;
        double longBitsToDouble;
        do {
            j = this.longs.get(i);
            longBitsToDouble = java.lang.Double.longBitsToDouble(j);
        } while (!this.longs.compareAndSet(i, j, java.lang.Double.doubleToRawLongBits(longBitsToDouble + d)));
        return longBitsToDouble;
    }

    public final double getAndSet(int i, double d) {
        return java.lang.Double.longBitsToDouble(this.longs.getAndSet(i, java.lang.Double.doubleToRawLongBits(d)));
    }

    public final void lazySet(int i, double d) {
        this.longs.lazySet(i, java.lang.Double.doubleToRawLongBits(d));
    }

    public final int length() {
        return this.longs.length();
    }

    public final void set(int i, double d) {
        this.longs.set(i, java.lang.Double.doubleToRawLongBits(d));
    }

    public java.lang.String toString() {
        int length = length() - 1;
        if (length == -1) {
            return "[]";
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder((length + 1) * 19);
        sb.append('[');
        int i = 0;
        while (true) {
            sb.append(java.lang.Double.longBitsToDouble(this.longs.get(i)));
            if (i == length) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(',');
            sb.append(' ');
            i++;
        }
    }

    public final boolean weakCompareAndSet(int i, double d, double d2) {
        return this.longs.weakCompareAndSet(i, java.lang.Double.doubleToRawLongBits(d), java.lang.Double.doubleToRawLongBits(d2));
    }
}
