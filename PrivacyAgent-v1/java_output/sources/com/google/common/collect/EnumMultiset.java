package com.google.common.collect;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
public final class EnumMultiset<E extends java.lang.Enum<E>> extends com.google.common.collect.AbstractMultiset<E> implements java.io.Serializable {

    @com.google.common.annotations.GwtIncompatible
    private static final long serialVersionUID = 0;
    private transient int[] counts;
    private transient int distinctElements;
    private transient E[] enumConstants;
    private transient long size;
    private transient java.lang.Class<E> type;

    /* renamed from: com.google.common.collect.EnumMultiset$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.common.collect.EnumMultiset<E>.Itr<E> {
        public AnonymousClass1() {
            super();
        }

        @Override // com.google.common.collect.EnumMultiset.Itr
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public E a(int i) {
            return (E) com.google.common.collect.EnumMultiset.this.enumConstants[i];
        }
    }

    /* renamed from: com.google.common.collect.EnumMultiset$2, reason: invalid class name */
    public class AnonymousClass2 extends com.google.common.collect.EnumMultiset<E>.Itr<com.google.common.collect.Multiset.Entry<E>> {

        /* renamed from: com.google.common.collect.EnumMultiset$2$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.collect.Multisets.AbstractEntry<E> {
            public final /* synthetic */ int n;

            public AnonymousClass1(int i) {
                this.n = i;
            }

            @Override // com.google.common.collect.Multiset.Entry
            public int getCount() {
                return com.google.common.collect.EnumMultiset.this.counts[this.n];
            }

            @Override // com.google.common.collect.Multiset.Entry
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public E getElement() {
                return (E) com.google.common.collect.EnumMultiset.this.enumConstants[this.n];
            }
        }

        public AnonymousClass2() {
            super();
        }

        @Override // com.google.common.collect.EnumMultiset.Itr
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.common.collect.Multiset.Entry<E> a(int i) {
            return new com.google.common.collect.EnumMultiset.AnonymousClass2.AnonymousClass1(i);
        }
    }

    public abstract class Itr<T> implements java.util.Iterator<T> {
        public int n = 0;
        public int t = -1;

        public Itr() {
        }

        public abstract T a(int i);

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (this.n < com.google.common.collect.EnumMultiset.this.enumConstants.length) {
                int[] iArr = com.google.common.collect.EnumMultiset.this.counts;
                int i = this.n;
                if (iArr[i] > 0) {
                    return true;
                }
                this.n = i + 1;
            }
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            T a = a(this.n);
            int i = this.n;
            this.t = i;
            this.n = i + 1;
            return a;
        }

        @Override // java.util.Iterator
        public void remove() {
            com.google.common.collect.CollectPreconditions.e(this.t >= 0);
            if (com.google.common.collect.EnumMultiset.this.counts[this.t] > 0) {
                com.google.common.collect.EnumMultiset.access$210(com.google.common.collect.EnumMultiset.this);
                com.google.common.collect.EnumMultiset.this.size -= com.google.common.collect.EnumMultiset.this.counts[this.t];
                com.google.common.collect.EnumMultiset.this.counts[this.t] = 0;
            }
            this.t = -1;
        }
    }

    private EnumMultiset(java.lang.Class<E> cls) {
        this.type = cls;
        com.google.common.base.Preconditions.checkArgument(cls.isEnum());
        E[] enumConstants = cls.getEnumConstants();
        this.enumConstants = enumConstants;
        this.counts = new int[enumConstants.length];
    }

    public static /* synthetic */ int access$210(com.google.common.collect.EnumMultiset enumMultiset) {
        int i = enumMultiset.distinctElements;
        enumMultiset.distinctElements = i - 1;
        return i;
    }

    public static <E extends java.lang.Enum<E>> com.google.common.collect.EnumMultiset<E> create(java.lang.Class<E> cls) {
        return new com.google.common.collect.EnumMultiset<>(cls);
    }

    public static <E extends java.lang.Enum<E>> com.google.common.collect.EnumMultiset<E> create(java.lang.Iterable<E> iterable) {
        java.util.Iterator<E> it = iterable.iterator();
        com.google.common.base.Preconditions.checkArgument(it.hasNext(), "EnumMultiset constructor passed empty Iterable");
        com.google.common.collect.EnumMultiset<E> enumMultiset = new com.google.common.collect.EnumMultiset<>(it.next().getDeclaringClass());
        com.google.common.collect.Iterables.addAll(enumMultiset, iterable);
        return enumMultiset;
    }

    public static <E extends java.lang.Enum<E>> com.google.common.collect.EnumMultiset<E> create(java.lang.Iterable<E> iterable, java.lang.Class<E> cls) {
        com.google.common.collect.EnumMultiset<E> create = create(cls);
        com.google.common.collect.Iterables.addAll(create, iterable);
        return create;
    }

    private boolean isActuallyE(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (!(obj instanceof java.lang.Enum)) {
            return false;
        }
        java.lang.Enum r5 = (java.lang.Enum) obj;
        int ordinal = r5.ordinal();
        E[] eArr = this.enumConstants;
        return ordinal < eArr.length && eArr[ordinal] == r5;
    }

    @com.google.common.annotations.GwtIncompatible
    private void readObject(java.io.ObjectInputStream objectInputStream) throws java.io.IOException, java.lang.ClassNotFoundException {
        objectInputStream.defaultReadObject();
        java.lang.Class<E> cls = (java.lang.Class) objectInputStream.readObject();
        this.type = cls;
        E[] enumConstants = cls.getEnumConstants();
        this.enumConstants = enumConstants;
        this.counts = new int[enumConstants.length];
        com.google.common.collect.Serialization.f(this, objectInputStream);
    }

    @com.google.common.annotations.GwtIncompatible
    private void writeObject(java.io.ObjectOutputStream objectOutputStream) throws java.io.IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.type);
        com.google.common.collect.Serialization.k(this, objectOutputStream);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public int add(E e, int i) {
        checkIsE(e);
        com.google.common.collect.CollectPreconditions.b(i, "occurrences");
        if (i == 0) {
            return count(e);
        }
        int ordinal = e.ordinal();
        int i2 = this.counts[ordinal];
        long j = i;
        long j2 = i2 + j;
        com.google.common.base.Preconditions.checkArgument(j2 <= 2147483647L, "too many occurrences: %s", j2);
        this.counts[ordinal] = (int) j2;
        if (i2 == 0) {
            this.distinctElements++;
        }
        this.size += j;
        return i2;
    }

    public void checkIsE(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        com.google.common.base.Preconditions.checkNotNull(obj);
        if (isActuallyE(obj)) {
            return;
        }
        throw new java.lang.ClassCastException("Expected an " + this.type + " but got " + obj);
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        java.util.Arrays.fill(this.counts, 0);
        this.size = 0L;
        this.distinctElements = 0;
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean contains(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.Multiset
    public int count(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj == null || !isActuallyE(obj)) {
            return 0;
        }
        return this.counts[((java.lang.Enum) obj).ordinal()];
    }

    @Override // com.google.common.collect.AbstractMultiset
    public int distinctElements() {
        return this.distinctElements;
    }

    @Override // com.google.common.collect.AbstractMultiset
    public java.util.Iterator<E> elementIterator() {
        return new com.google.common.collect.EnumMultiset.AnonymousClass1();
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ java.util.Set elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.AbstractMultiset
    public java.util.Iterator<com.google.common.collect.Multiset.Entry<E>> entryIterator() {
        return new com.google.common.collect.EnumMultiset.AnonymousClass2();
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ java.util.Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public java.util.Iterator<E> iterator() {
        return com.google.common.collect.Multisets.h(this);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public int remove(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj, int i) {
        if (obj == null || !isActuallyE(obj)) {
            return 0;
        }
        java.lang.Enum r1 = (java.lang.Enum) obj;
        com.google.common.collect.CollectPreconditions.b(i, "occurrences");
        if (i == 0) {
            return count(obj);
        }
        int ordinal = r1.ordinal();
        int[] iArr = this.counts;
        int i2 = iArr[ordinal];
        if (i2 == 0) {
            return 0;
        }
        if (i2 <= i) {
            iArr[ordinal] = 0;
            this.distinctElements--;
            this.size -= i2;
        } else {
            iArr[ordinal] = i2 - i;
            this.size -= i;
        }
        return i2;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    public int setCount(E e, int i) {
        checkIsE(e);
        com.google.common.collect.CollectPreconditions.b(i, me.leolin.shortcutbadger.impl.NewHtcHomeBadger.COUNT);
        int ordinal = e.ordinal();
        int[] iArr = this.counts;
        int i2 = iArr[ordinal];
        iArr[ordinal] = i;
        this.size += i - i2;
        if (i2 == 0 && i > 0) {
            this.distinctElements++;
        } else if (i2 > 0 && i == 0) {
            this.distinctElements--;
        }
        return i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        return com.google.common.primitives.Ints.saturatedCast(this.size);
    }
}
