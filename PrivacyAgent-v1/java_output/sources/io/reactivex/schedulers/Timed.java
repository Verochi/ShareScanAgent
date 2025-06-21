package io.reactivex.schedulers;

/* loaded from: classes13.dex */
public final class Timed<T> {
    public final T a;
    public final long b;
    public final java.util.concurrent.TimeUnit c;

    public Timed(@io.reactivex.annotations.NonNull T t, long j, @io.reactivex.annotations.NonNull java.util.concurrent.TimeUnit timeUnit) {
        this.a = t;
        this.b = j;
        this.c = (java.util.concurrent.TimeUnit) io.reactivex.internal.functions.ObjectHelper.requireNonNull(timeUnit, "unit is null");
    }

    public boolean equals(java.lang.Object obj) {
        if (!(obj instanceof io.reactivex.schedulers.Timed)) {
            return false;
        }
        io.reactivex.schedulers.Timed timed = (io.reactivex.schedulers.Timed) obj;
        return io.reactivex.internal.functions.ObjectHelper.equals(this.a, timed.a) && this.b == timed.b && io.reactivex.internal.functions.ObjectHelper.equals(this.c, timed.c);
    }

    public int hashCode() {
        T t = this.a;
        int hashCode = t != null ? t.hashCode() : 0;
        long j = this.b;
        return (((hashCode * 31) + ((int) (j ^ (j >>> 31)))) * 31) + this.c.hashCode();
    }

    public long time() {
        return this.b;
    }

    public long time(@io.reactivex.annotations.NonNull java.util.concurrent.TimeUnit timeUnit) {
        return timeUnit.convert(this.b, this.c);
    }

    public java.lang.String toString() {
        return "Timed[time=" + this.b + ", unit=" + this.c + ", value=" + this.a + "]";
    }

    @io.reactivex.annotations.NonNull
    public java.util.concurrent.TimeUnit unit() {
        return this.c;
    }

    @io.reactivex.annotations.NonNull
    public T value() {
        return this.a;
    }
}
