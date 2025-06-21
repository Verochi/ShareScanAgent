package io.reactivex.internal.util;

/* loaded from: classes13.dex */
public class AppendOnlyLinkedArrayList<T> {
    public final int a;
    public final java.lang.Object[] b;
    public java.lang.Object[] c;
    public int d;

    public interface NonThrowingPredicate<T> extends io.reactivex.functions.Predicate<T> {
        @Override // io.reactivex.functions.Predicate
        boolean test(T t);
    }

    public AppendOnlyLinkedArrayList(int i) {
        this.a = i;
        java.lang.Object[] objArr = new java.lang.Object[i + 1];
        this.b = objArr;
        this.c = objArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0019, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <U> boolean accept(io.reactivex.Observer<? super U> observer) {
        java.lang.Object[] objArr = this.b;
        int i = this.a;
        while (true) {
            if (objArr == null) {
                return false;
            }
            for (int i2 = 0; i2 < i; i2++) {
                java.lang.Object[] objArr2 = objArr[i2];
                if (objArr2 == null) {
                    break;
                }
                if (io.reactivex.internal.util.NotificationLite.acceptFull(objArr2, observer)) {
                    return true;
                }
            }
            objArr = objArr[i];
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0019, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <U> boolean accept(org.reactivestreams.Subscriber<? super U> subscriber) {
        java.lang.Object[] objArr = this.b;
        int i = this.a;
        while (true) {
            if (objArr == null) {
                return false;
            }
            for (int i2 = 0; i2 < i; i2++) {
                java.lang.Object[] objArr2 = objArr[i2];
                if (objArr2 == null) {
                    break;
                }
                if (io.reactivex.internal.util.NotificationLite.acceptFull(objArr2, subscriber)) {
                    return true;
                }
            }
            objArr = objArr[i];
        }
    }

    public void add(T t) {
        int i = this.a;
        int i2 = this.d;
        if (i2 == i) {
            java.lang.Object[] objArr = new java.lang.Object[i + 1];
            this.c[i] = objArr;
            this.c = objArr;
            i2 = 0;
        }
        this.c[i2] = t;
        this.d = i2 + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0018, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void forEachWhile(io.reactivex.internal.util.AppendOnlyLinkedArrayList.NonThrowingPredicate<? super T> nonThrowingPredicate) {
        int i = this.a;
        for (java.lang.Object[] objArr = this.b; objArr != null; objArr = (java.lang.Object[]) objArr[i]) {
            for (int i2 = 0; i2 < i; i2++) {
                java.lang.Object obj = objArr[i2];
                if (obj == null) {
                    break;
                } else {
                    if (nonThrowingPredicate.test(obj)) {
                        return;
                    }
                }
            }
        }
    }

    public <S> void forEachWhile(S s2, io.reactivex.functions.BiPredicate<? super S, ? super T> biPredicate) throws java.lang.Exception {
        java.lang.Object[] objArr = this.b;
        int i = this.a;
        while (true) {
            for (int i2 = 0; i2 < i; i2++) {
                java.lang.Object obj = objArr[i2];
                if (obj == null || biPredicate.test(s2, obj)) {
                    return;
                }
            }
            objArr = (java.lang.Object[]) objArr[i];
        }
    }

    public void setFirst(T t) {
        this.b[0] = t;
    }
}
