package com.google.common.util.concurrent;

/* loaded from: classes22.dex */
public class AtomicDouble extends java.lang.Number implements java.io.Serializable {
    private static final long serialVersionUID = 0;
    private transient java.util.concurrent.atomic.AtomicLong value;

    public AtomicDouble() {
        this(0.0d);
    }

    public AtomicDouble(double d) {
        this.value = new java.util.concurrent.atomic.AtomicLong(java.lang.Double.doubleToRawLongBits(d));
    }

    private void readObject(java.io.ObjectInputStream objectInputStream) throws java.io.IOException, java.lang.ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.value = new java.util.concurrent.atomic.AtomicLong();
        set(objectInputStream.readDouble());
    }

    private void writeObject(java.io.ObjectOutputStream objectOutputStream) throws java.io.IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeDouble(get());
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public final double addAndGet(double d) {
        long j;
        double longBitsToDouble;
        do {
            j = this.value.get();
            longBitsToDouble = java.lang.Double.longBitsToDouble(j) + d;
        } while (!this.value.compareAndSet(j, java.lang.Double.doubleToRawLongBits(longBitsToDouble)));
        return longBitsToDouble;
    }

    public final boolean compareAndSet(double d, double d2) {
        return this.value.compareAndSet(java.lang.Double.doubleToRawLongBits(d), java.lang.Double.doubleToRawLongBits(d2));
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return get();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) get();
    }

    public final double get() {
        return java.lang.Double.longBitsToDouble(this.value.get());
    }

    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public final double getAndAdd(double d) {
        long j;
        double longBitsToDouble;
        do {
            j = this.value.get();
            longBitsToDouble = java.lang.Double.longBitsToDouble(j);
        } while (!this.value.compareAndSet(j, java.lang.Double.doubleToRawLongBits(longBitsToDouble + d)));
        return longBitsToDouble;
    }

    public final double getAndSet(double d) {
        return java.lang.Double.longBitsToDouble(this.value.getAndSet(java.lang.Double.doubleToRawLongBits(d)));
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) get();
    }

    public final void lazySet(double d) {
        this.value.lazySet(java.lang.Double.doubleToRawLongBits(d));
    }

    @Override // java.lang.Number
    public long longValue() {
        return (long) get();
    }

    public final void set(double d) {
        this.value.set(java.lang.Double.doubleToRawLongBits(d));
    }

    public java.lang.String toString() {
        return java.lang.Double.toString(get());
    }

    public final boolean weakCompareAndSet(double d, double d2) {
        return this.value.weakCompareAndSet(java.lang.Double.doubleToRawLongBits(d), java.lang.Double.doubleToRawLongBits(d2));
    }
}
