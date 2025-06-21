package com.google.common.collect;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
final class Serialization {

    public static final class FieldSetter<T> {
        public final java.lang.reflect.Field a;

        public FieldSetter(java.lang.reflect.Field field) {
            this.a = field;
            field.setAccessible(true);
        }

        public /* synthetic */ FieldSetter(java.lang.reflect.Field field, com.google.common.collect.Serialization.AnonymousClass1 anonymousClass1) {
            this(field);
        }

        public void a(T t, int i) {
            try {
                this.a.set(t, java.lang.Integer.valueOf(i));
            } catch (java.lang.IllegalAccessException e) {
                throw new java.lang.AssertionError(e);
            }
        }

        public void b(T t, java.lang.Object obj) {
            try {
                this.a.set(t, obj);
            } catch (java.lang.IllegalAccessException e) {
                throw new java.lang.AssertionError(e);
            }
        }
    }

    public static <T> com.google.common.collect.Serialization.FieldSetter<T> a(java.lang.Class<T> cls, java.lang.String str) {
        try {
            return new com.google.common.collect.Serialization.FieldSetter<>(cls.getDeclaredField(str), null);
        } catch (java.lang.NoSuchFieldException e) {
            throw new java.lang.AssertionError(e);
        }
    }

    public static <K, V> void b(java.util.Map<K, V> map, java.io.ObjectInputStream objectInputStream) throws java.io.IOException, java.lang.ClassNotFoundException {
        c(map, objectInputStream, objectInputStream.readInt());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> void c(java.util.Map<K, V> map, java.io.ObjectInputStream objectInputStream, int i) throws java.io.IOException, java.lang.ClassNotFoundException {
        for (int i2 = 0; i2 < i; i2++) {
            map.put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }

    public static <K, V> void d(com.google.common.collect.Multimap<K, V> multimap, java.io.ObjectInputStream objectInputStream) throws java.io.IOException, java.lang.ClassNotFoundException {
        e(multimap, objectInputStream, objectInputStream.readInt());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> void e(com.google.common.collect.Multimap<K, V> multimap, java.io.ObjectInputStream objectInputStream, int i) throws java.io.IOException, java.lang.ClassNotFoundException {
        for (int i2 = 0; i2 < i; i2++) {
            java.util.Collection collection = multimap.get(objectInputStream.readObject());
            int readInt = objectInputStream.readInt();
            for (int i3 = 0; i3 < readInt; i3++) {
                collection.add(objectInputStream.readObject());
            }
        }
    }

    public static <E> void f(com.google.common.collect.Multiset<E> multiset, java.io.ObjectInputStream objectInputStream) throws java.io.IOException, java.lang.ClassNotFoundException {
        g(multiset, objectInputStream, objectInputStream.readInt());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> void g(com.google.common.collect.Multiset<E> multiset, java.io.ObjectInputStream objectInputStream, int i) throws java.io.IOException, java.lang.ClassNotFoundException {
        for (int i2 = 0; i2 < i; i2++) {
            multiset.add(objectInputStream.readObject(), objectInputStream.readInt());
        }
    }

    public static int h(java.io.ObjectInputStream objectInputStream) throws java.io.IOException {
        return objectInputStream.readInt();
    }

    public static <K, V> void i(java.util.Map<K, V> map, java.io.ObjectOutputStream objectOutputStream) throws java.io.IOException {
        objectOutputStream.writeInt(map.size());
        for (java.util.Map.Entry<K, V> entry : map.entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    public static <K, V> void j(com.google.common.collect.Multimap<K, V> multimap, java.io.ObjectOutputStream objectOutputStream) throws java.io.IOException {
        objectOutputStream.writeInt(multimap.asMap().size());
        for (java.util.Map.Entry<K, java.util.Collection<V>> entry : multimap.asMap().entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(entry.getValue().size());
            java.util.Iterator<V> it = entry.getValue().iterator();
            while (it.hasNext()) {
                objectOutputStream.writeObject(it.next());
            }
        }
    }

    public static <E> void k(com.google.common.collect.Multiset<E> multiset, java.io.ObjectOutputStream objectOutputStream) throws java.io.IOException {
        objectOutputStream.writeInt(multiset.entrySet().size());
        for (com.google.common.collect.Multiset.Entry<E> entry : multiset.entrySet()) {
            objectOutputStream.writeObject(entry.getElement());
            objectOutputStream.writeInt(entry.getCount());
        }
    }
}
