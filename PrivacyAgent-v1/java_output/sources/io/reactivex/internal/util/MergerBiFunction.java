package io.reactivex.internal.util;

/* loaded from: classes13.dex */
public final class MergerBiFunction<T> implements io.reactivex.functions.BiFunction<java.util.List<T>, java.util.List<T>, java.util.List<T>> {
    public final java.util.Comparator<? super T> n;

    public MergerBiFunction(java.util.Comparator<? super T> comparator) {
        this.n = comparator;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0037, code lost:
    
        r3 = null;
     */
    @Override // io.reactivex.functions.BiFunction
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.util.List<T> apply(java.util.List<T> list, java.util.List<T> list2) throws java.lang.Exception {
        T t;
        int size = list.size() + list2.size();
        if (size == 0) {
            return new java.util.ArrayList();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(size);
        java.util.Iterator<T> it = list.iterator();
        java.util.Iterator<T> it2 = list2.iterator();
        T next = it.hasNext() ? it.next() : null;
        if (it2.hasNext()) {
            t = it2.next();
            while (next != null && t != null) {
                if (this.n.compare(next, t) < 0) {
                    arrayList.add(next);
                    next = it.hasNext() ? it.next() : null;
                } else {
                    arrayList.add(t);
                    if (it2.hasNext()) {
                        t = it2.next();
                    }
                }
            }
            if (next != null) {
                arrayList.add(next);
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
            } else {
                arrayList.add(t);
                while (it2.hasNext()) {
                    arrayList.add(it2.next());
                }
            }
            return arrayList;
        }
        t = null;
    }
}
