package com.google.common.cache;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
final class LongAdder extends com.google.common.cache.Striped64 implements java.io.Serializable, com.google.common.cache.LongAddable {
    private static final long serialVersionUID = 7249069246863182397L;

    private void readObject(java.io.ObjectInputStream objectInputStream) throws java.io.IOException, java.lang.ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.busy = 0;
        this.cells = null;
        this.base = objectInputStream.readLong();
    }

    private void writeObject(java.io.ObjectOutputStream objectOutputStream) throws java.io.IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeLong(sum());
    }

    @Override // com.google.common.cache.LongAddable
    public void add(long j) {
        int length;
        com.google.common.cache.Striped64.Cell cell;
        com.google.common.cache.Striped64.Cell[] cellArr = this.cells;
        if (cellArr == null) {
            long j2 = this.base;
            if (casBase(j2, j2 + j)) {
                return;
            }
        }
        int[] iArr = com.google.common.cache.Striped64.threadHashCode.get();
        boolean z = true;
        if (iArr != null && cellArr != null && (length = cellArr.length) >= 1 && (cell = cellArr[(length - 1) & iArr[0]]) != null) {
            long j3 = cell.a;
            z = cell.a(j3, j3 + j);
            if (z) {
                return;
            }
        }
        retryUpdate(j, iArr, z);
    }

    public void decrement() {
        add(-1L);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return sum();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return sum();
    }

    @Override // com.google.common.cache.Striped64
    public final long fn(long j, long j2) {
        return j + j2;
    }

    @Override // com.google.common.cache.LongAddable
    public void increment() {
        add(1L);
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) sum();
    }

    @Override // java.lang.Number
    public long longValue() {
        return sum();
    }

    public void reset() {
        internalReset(0L);
    }

    @Override // com.google.common.cache.LongAddable
    public long sum() {
        long j = this.base;
        com.google.common.cache.Striped64.Cell[] cellArr = this.cells;
        if (cellArr != null) {
            for (com.google.common.cache.Striped64.Cell cell : cellArr) {
                if (cell != null) {
                    j += cell.a;
                }
            }
        }
        return j;
    }

    public long sumThenReset() {
        long j = this.base;
        com.google.common.cache.Striped64.Cell[] cellArr = this.cells;
        this.base = 0L;
        if (cellArr != null) {
            for (com.google.common.cache.Striped64.Cell cell : cellArr) {
                if (cell != null) {
                    j += cell.a;
                    cell.a = 0L;
                }
            }
        }
        return j;
    }

    public java.lang.String toString() {
        return java.lang.Long.toString(sum());
    }
}
