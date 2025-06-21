package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class CollectionUtils {

    @java.lang.Deprecated
    public static final java.util.List EMPTY_LIST = java.util.Collections.EMPTY_LIST;

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* renamed from: org.apache.tools.ant.util.CollectionUtils$1, reason: invalid class name */
    public static class AnonymousClass1<E> implements java.util.Enumeration<E> {
        public final /* synthetic */ java.util.Iterator a;

        public AnonymousClass1(java.util.Iterator it) {
            this.a = it;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.a.hasNext();
        }

        @Override // java.util.Enumeration
        public E nextElement() {
            return (E) this.a.next();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    /* renamed from: org.apache.tools.ant.util.CollectionUtils$2, reason: invalid class name */
    public static class AnonymousClass2<E> implements java.util.Iterator<E> {
        public final /* synthetic */ java.util.Enumeration n;

        public AnonymousClass2(java.util.Enumeration enumeration) {
            this.n = enumeration;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.n.hasMoreElements();
        }

        @Override // java.util.Iterator
        public E next() {
            return (E) this.n.nextElement();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }

    public static final class CompoundEnumeration<E> implements java.util.Enumeration<E> {
        public final java.util.Enumeration<E> a;
        public final java.util.Enumeration<E> b;

        public CompoundEnumeration(java.util.Enumeration<E> enumeration, java.util.Enumeration<E> enumeration2) {
            this.a = enumeration;
            this.b = enumeration2;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.a.hasMoreElements() || this.b.hasMoreElements();
        }

        @Override // java.util.Enumeration
        public E nextElement() throws java.util.NoSuchElementException {
            return this.a.hasMoreElements() ? this.a.nextElement() : this.b.nextElement();
        }
    }

    public static final class EmptyEnumeration<E> implements java.util.Enumeration<E> {
        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return false;
        }

        @Override // java.util.Enumeration
        public E nextElement() throws java.util.NoSuchElementException {
            throw new java.util.NoSuchElementException();
        }
    }

    public static <E> java.util.Enumeration<E> append(java.util.Enumeration<E> enumeration, java.util.Enumeration<E> enumeration2) {
        return new org.apache.tools.ant.util.CollectionUtils.CompoundEnumeration(enumeration, enumeration2);
    }

    public static <T> java.util.Collection<T> asCollection(java.util.Iterator<? extends T> it) {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public static <E> java.util.Enumeration<E> asEnumeration(java.util.Iterator<E> it) {
        return new org.apache.tools.ant.util.CollectionUtils.AnonymousClass1(it);
    }

    public static <E> java.util.Iterator<E> asIterator(java.util.Enumeration<E> enumeration) {
        return new org.apache.tools.ant.util.CollectionUtils.AnonymousClass2(enumeration);
    }

    @java.lang.Deprecated
    public static boolean equals(java.util.Dictionary<?, ?> dictionary, java.util.Dictionary<?, ?> dictionary2) {
        if (dictionary == dictionary2) {
            return true;
        }
        if (dictionary == null || dictionary2 == null || dictionary.size() != dictionary2.size()) {
            return false;
        }
        java.util.Enumeration<?> keys = dictionary.keys();
        while (keys.hasMoreElements()) {
            java.lang.Object nextElement = keys.nextElement();
            java.lang.Object obj = dictionary.get(nextElement);
            java.lang.Object obj2 = dictionary2.get(nextElement);
            if (obj2 == null || !obj.equals(obj2)) {
                return false;
            }
        }
        return true;
    }

    @java.lang.Deprecated
    public static boolean equals(java.util.Vector<?> vector, java.util.Vector<?> vector2) {
        if (vector == vector2) {
            return true;
        }
        if (vector == null || vector2 == null) {
            return false;
        }
        return vector.equals(vector2);
    }

    public static java.lang.String flattenToString(java.util.Collection<?> collection) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.lang.Object obj : collection) {
            if (sb.length() != 0) {
                sb.append(",");
            }
            sb.append(obj);
        }
        return sb.toString();
    }

    public static int frequency(java.util.Collection<?> collection, java.lang.Object obj) {
        int i = 0;
        if (collection != null) {
            for (java.lang.Object obj2 : collection) {
                if (obj == null) {
                    if (obj2 == null) {
                        i++;
                    }
                } else if (obj.equals(obj2)) {
                    i++;
                }
            }
        }
        return i;
    }

    @java.lang.Deprecated
    public static <K, V> void putAll(java.util.Dictionary<? super K, ? super V> dictionary, java.util.Dictionary<? extends K, ? extends V> dictionary2) {
        java.util.Enumeration<? extends K> keys = dictionary2.keys();
        while (keys.hasMoreElements()) {
            K nextElement = keys.nextElement();
            dictionary.put(nextElement, dictionary2.get(nextElement));
        }
    }
}
