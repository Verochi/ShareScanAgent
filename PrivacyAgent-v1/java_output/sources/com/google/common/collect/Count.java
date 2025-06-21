package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
final class Count implements java.io.Serializable {
    private int value;

    public Count(int i) {
        this.value = i;
    }

    public void add(int i) {
        this.value += i;
    }

    public int addAndGet(int i) {
        int i2 = this.value + i;
        this.value = i2;
        return i2;
    }

    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return (obj instanceof com.google.common.collect.Count) && ((com.google.common.collect.Count) obj).value == this.value;
    }

    public int get() {
        return this.value;
    }

    public int getAndSet(int i) {
        int i2 = this.value;
        this.value = i;
        return i2;
    }

    public int hashCode() {
        return this.value;
    }

    public void set(int i) {
        this.value = i;
    }

    public java.lang.String toString() {
        return java.lang.Integer.toString(this.value);
    }
}
