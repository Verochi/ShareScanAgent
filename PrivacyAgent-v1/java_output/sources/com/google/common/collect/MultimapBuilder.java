package com.google.common.collect;

@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public abstract class MultimapBuilder<K0, V0> {

    /* renamed from: com.google.common.collect.MultimapBuilder$1, reason: invalid class name */
    public static class AnonymousClass1 extends com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys<java.lang.Object> {
        public final /* synthetic */ int a;

        public AnonymousClass1(int i) {
            this.a = i;
        }

        @Override // com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys
        public <K, V> java.util.Map<K, java.util.Collection<V>> a() {
            return com.google.common.collect.Platform.c(this.a);
        }
    }

    /* renamed from: com.google.common.collect.MultimapBuilder$2, reason: invalid class name */
    public static class AnonymousClass2 extends com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys<java.lang.Object> {
        public final /* synthetic */ int a;

        public AnonymousClass2(int i) {
            this.a = i;
        }

        @Override // com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys
        public <K, V> java.util.Map<K, java.util.Collection<V>> a() {
            return com.google.common.collect.Platform.e(this.a);
        }
    }

    /* renamed from: com.google.common.collect.MultimapBuilder$3, reason: invalid class name */
    public static class AnonymousClass3 extends com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys<K0> {
        public final /* synthetic */ java.util.Comparator a;

        public AnonymousClass3(java.util.Comparator comparator) {
            this.a = comparator;
        }

        @Override // com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys
        public <K extends K0, V> java.util.Map<K, java.util.Collection<V>> a() {
            return new java.util.TreeMap(this.a);
        }
    }

    /* renamed from: com.google.common.collect.MultimapBuilder$4, reason: invalid class name */
    public static class AnonymousClass4 extends com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys<K0> {
        public final /* synthetic */ java.lang.Class a;

        public AnonymousClass4(java.lang.Class cls) {
            this.a = cls;
        }

        @Override // com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys
        public <K extends K0, V> java.util.Map<K, java.util.Collection<V>> a() {
            return new java.util.EnumMap(this.a);
        }
    }

    public static final class ArrayListSupplier<V> implements com.google.common.base.Supplier<java.util.List<V>>, java.io.Serializable {
        private final int expectedValuesPerKey;

        public ArrayListSupplier(int i) {
            this.expectedValuesPerKey = com.google.common.collect.CollectPreconditions.b(i, "expectedValuesPerKey");
        }

        @Override // com.google.common.base.Supplier
        public java.util.List<V> get() {
            return new java.util.ArrayList(this.expectedValuesPerKey);
        }
    }

    public static final class EnumSetSupplier<V extends java.lang.Enum<V>> implements com.google.common.base.Supplier<java.util.Set<V>>, java.io.Serializable {
        private final java.lang.Class<V> clazz;

        public EnumSetSupplier(java.lang.Class<V> cls) {
            this.clazz = (java.lang.Class) com.google.common.base.Preconditions.checkNotNull(cls);
        }

        @Override // com.google.common.base.Supplier
        public java.util.Set<V> get() {
            return java.util.EnumSet.noneOf(this.clazz);
        }
    }

    public static final class HashSetSupplier<V> implements com.google.common.base.Supplier<java.util.Set<V>>, java.io.Serializable {
        private final int expectedValuesPerKey;

        public HashSetSupplier(int i) {
            this.expectedValuesPerKey = com.google.common.collect.CollectPreconditions.b(i, "expectedValuesPerKey");
        }

        @Override // com.google.common.base.Supplier
        public java.util.Set<V> get() {
            return com.google.common.collect.Platform.d(this.expectedValuesPerKey);
        }
    }

    public static final class LinkedHashSetSupplier<V> implements com.google.common.base.Supplier<java.util.Set<V>>, java.io.Serializable {
        private final int expectedValuesPerKey;

        public LinkedHashSetSupplier(int i) {
            this.expectedValuesPerKey = com.google.common.collect.CollectPreconditions.b(i, "expectedValuesPerKey");
        }

        @Override // com.google.common.base.Supplier
        public java.util.Set<V> get() {
            return com.google.common.collect.Platform.f(this.expectedValuesPerKey);
        }
    }

    public enum LinkedListSupplier implements com.google.common.base.Supplier<java.util.List<java.lang.Object>> {
        INSTANCE;

        public static <V> com.google.common.base.Supplier<java.util.List<V>> instance() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Supplier
        public java.util.List<java.lang.Object> get() {
            return new java.util.LinkedList();
        }
    }

    public static abstract class ListMultimapBuilder<K0, V0> extends com.google.common.collect.MultimapBuilder<K0, V0> {
        public ListMultimapBuilder() {
            super(null);
        }

        @Override // com.google.common.collect.MultimapBuilder
        public abstract <K extends K0, V extends V0> com.google.common.collect.ListMultimap<K, V> build();

        @Override // com.google.common.collect.MultimapBuilder
        public <K extends K0, V extends V0> com.google.common.collect.ListMultimap<K, V> build(com.google.common.collect.Multimap<? extends K, ? extends V> multimap) {
            return (com.google.common.collect.ListMultimap) super.build((com.google.common.collect.Multimap) multimap);
        }
    }

    public static abstract class MultimapBuilderWithKeys<K0> {

        /* renamed from: com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.collect.MultimapBuilder.ListMultimapBuilder<K0, java.lang.Object> {
            public final /* synthetic */ int a;

            public AnonymousClass1(int i) {
                this.a = i;
            }

            @Override // com.google.common.collect.MultimapBuilder.ListMultimapBuilder, com.google.common.collect.MultimapBuilder
            public <K extends K0, V> com.google.common.collect.ListMultimap<K, V> build() {
                return com.google.common.collect.Multimaps.newListMultimap(com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys.this.a(), new com.google.common.collect.MultimapBuilder.ArrayListSupplier(this.a));
            }
        }

        /* renamed from: com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys$2, reason: invalid class name */
        public class AnonymousClass2 extends com.google.common.collect.MultimapBuilder.ListMultimapBuilder<K0, java.lang.Object> {
            public AnonymousClass2() {
            }

            @Override // com.google.common.collect.MultimapBuilder.ListMultimapBuilder, com.google.common.collect.MultimapBuilder
            public <K extends K0, V> com.google.common.collect.ListMultimap<K, V> build() {
                return com.google.common.collect.Multimaps.newListMultimap(com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys.this.a(), com.google.common.collect.MultimapBuilder.LinkedListSupplier.instance());
            }
        }

        /* renamed from: com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys$3, reason: invalid class name */
        public class AnonymousClass3 extends com.google.common.collect.MultimapBuilder.SetMultimapBuilder<K0, java.lang.Object> {
            public final /* synthetic */ int a;

            public AnonymousClass3(int i) {
                this.a = i;
            }

            @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
            public <K extends K0, V> com.google.common.collect.SetMultimap<K, V> build() {
                return com.google.common.collect.Multimaps.newSetMultimap(com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys.this.a(), new com.google.common.collect.MultimapBuilder.HashSetSupplier(this.a));
            }
        }

        /* renamed from: com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys$4, reason: invalid class name */
        public class AnonymousClass4 extends com.google.common.collect.MultimapBuilder.SetMultimapBuilder<K0, java.lang.Object> {
            public final /* synthetic */ int a;

            public AnonymousClass4(int i) {
                this.a = i;
            }

            @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
            public <K extends K0, V> com.google.common.collect.SetMultimap<K, V> build() {
                return com.google.common.collect.Multimaps.newSetMultimap(com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys.this.a(), new com.google.common.collect.MultimapBuilder.LinkedHashSetSupplier(this.a));
            }
        }

        /* renamed from: com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys$5, reason: invalid class name */
        public class AnonymousClass5 extends com.google.common.collect.MultimapBuilder.SortedSetMultimapBuilder<K0, V0> {
            public final /* synthetic */ java.util.Comparator a;

            public AnonymousClass5(java.util.Comparator comparator) {
                this.a = comparator;
            }

            @Override // com.google.common.collect.MultimapBuilder.SortedSetMultimapBuilder, com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
            public <K extends K0, V extends V0> com.google.common.collect.SortedSetMultimap<K, V> build() {
                return com.google.common.collect.Multimaps.newSortedSetMultimap(com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys.this.a(), new com.google.common.collect.MultimapBuilder.TreeSetSupplier(this.a));
            }
        }

        /* renamed from: com.google.common.collect.MultimapBuilder$MultimapBuilderWithKeys$6, reason: invalid class name */
        public class AnonymousClass6 extends com.google.common.collect.MultimapBuilder.SetMultimapBuilder<K0, V0> {
            public final /* synthetic */ java.lang.Class a;

            public AnonymousClass6(java.lang.Class cls) {
                this.a = cls;
            }

            @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
            public <K extends K0, V extends V0> com.google.common.collect.SetMultimap<K, V> build() {
                return com.google.common.collect.Multimaps.newSetMultimap(com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys.this.a(), new com.google.common.collect.MultimapBuilder.EnumSetSupplier(this.a));
            }
        }

        public abstract <K extends K0, V> java.util.Map<K, java.util.Collection<V>> a();

        public com.google.common.collect.MultimapBuilder.ListMultimapBuilder<K0, java.lang.Object> arrayListValues() {
            return arrayListValues(2);
        }

        public com.google.common.collect.MultimapBuilder.ListMultimapBuilder<K0, java.lang.Object> arrayListValues(int i) {
            com.google.common.collect.CollectPreconditions.b(i, "expectedValuesPerKey");
            return new com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys.AnonymousClass1(i);
        }

        public <V0 extends java.lang.Enum<V0>> com.google.common.collect.MultimapBuilder.SetMultimapBuilder<K0, V0> enumSetValues(java.lang.Class<V0> cls) {
            com.google.common.base.Preconditions.checkNotNull(cls, "valueClass");
            return new com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys.AnonymousClass6(cls);
        }

        public com.google.common.collect.MultimapBuilder.SetMultimapBuilder<K0, java.lang.Object> hashSetValues() {
            return hashSetValues(2);
        }

        public com.google.common.collect.MultimapBuilder.SetMultimapBuilder<K0, java.lang.Object> hashSetValues(int i) {
            com.google.common.collect.CollectPreconditions.b(i, "expectedValuesPerKey");
            return new com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys.AnonymousClass3(i);
        }

        public com.google.common.collect.MultimapBuilder.SetMultimapBuilder<K0, java.lang.Object> linkedHashSetValues() {
            return linkedHashSetValues(2);
        }

        public com.google.common.collect.MultimapBuilder.SetMultimapBuilder<K0, java.lang.Object> linkedHashSetValues(int i) {
            com.google.common.collect.CollectPreconditions.b(i, "expectedValuesPerKey");
            return new com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys.AnonymousClass4(i);
        }

        public com.google.common.collect.MultimapBuilder.ListMultimapBuilder<K0, java.lang.Object> linkedListValues() {
            return new com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys.AnonymousClass2();
        }

        public com.google.common.collect.MultimapBuilder.SortedSetMultimapBuilder<K0, java.lang.Comparable> treeSetValues() {
            return treeSetValues(com.google.common.collect.Ordering.natural());
        }

        public <V0> com.google.common.collect.MultimapBuilder.SortedSetMultimapBuilder<K0, V0> treeSetValues(java.util.Comparator<V0> comparator) {
            com.google.common.base.Preconditions.checkNotNull(comparator, "comparator");
            return new com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys.AnonymousClass5(comparator);
        }
    }

    public static abstract class SetMultimapBuilder<K0, V0> extends com.google.common.collect.MultimapBuilder<K0, V0> {
        public SetMultimapBuilder() {
            super(null);
        }

        @Override // com.google.common.collect.MultimapBuilder
        public abstract <K extends K0, V extends V0> com.google.common.collect.SetMultimap<K, V> build();

        @Override // com.google.common.collect.MultimapBuilder
        public <K extends K0, V extends V0> com.google.common.collect.SetMultimap<K, V> build(com.google.common.collect.Multimap<? extends K, ? extends V> multimap) {
            return (com.google.common.collect.SetMultimap) super.build((com.google.common.collect.Multimap) multimap);
        }
    }

    public static abstract class SortedSetMultimapBuilder<K0, V0> extends com.google.common.collect.MultimapBuilder.SetMultimapBuilder<K0, V0> {
        @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
        public abstract <K extends K0, V extends V0> com.google.common.collect.SortedSetMultimap<K, V> build();

        @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
        public <K extends K0, V extends V0> com.google.common.collect.SortedSetMultimap<K, V> build(com.google.common.collect.Multimap<? extends K, ? extends V> multimap) {
            return (com.google.common.collect.SortedSetMultimap) super.build((com.google.common.collect.Multimap) multimap);
        }
    }

    public static final class TreeSetSupplier<V> implements com.google.common.base.Supplier<java.util.SortedSet<V>>, java.io.Serializable {
        private final java.util.Comparator<? super V> comparator;

        public TreeSetSupplier(java.util.Comparator<? super V> comparator) {
            this.comparator = (java.util.Comparator) com.google.common.base.Preconditions.checkNotNull(comparator);
        }

        @Override // com.google.common.base.Supplier
        public java.util.SortedSet<V> get() {
            return new java.util.TreeSet(this.comparator);
        }
    }

    public MultimapBuilder() {
    }

    public /* synthetic */ MultimapBuilder(com.google.common.collect.MultimapBuilder.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static <K0 extends java.lang.Enum<K0>> com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys<K0> enumKeys(java.lang.Class<K0> cls) {
        com.google.common.base.Preconditions.checkNotNull(cls);
        return new com.google.common.collect.MultimapBuilder.AnonymousClass4(cls);
    }

    public static com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys<java.lang.Object> hashKeys() {
        return hashKeys(8);
    }

    public static com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys<java.lang.Object> hashKeys(int i) {
        com.google.common.collect.CollectPreconditions.b(i, "expectedKeys");
        return new com.google.common.collect.MultimapBuilder.AnonymousClass1(i);
    }

    public static com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys<java.lang.Object> linkedHashKeys() {
        return linkedHashKeys(8);
    }

    public static com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys<java.lang.Object> linkedHashKeys(int i) {
        com.google.common.collect.CollectPreconditions.b(i, "expectedKeys");
        return new com.google.common.collect.MultimapBuilder.AnonymousClass2(i);
    }

    public static com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys<java.lang.Comparable> treeKeys() {
        return treeKeys(com.google.common.collect.Ordering.natural());
    }

    public static <K0> com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys<K0> treeKeys(java.util.Comparator<K0> comparator) {
        com.google.common.base.Preconditions.checkNotNull(comparator);
        return new com.google.common.collect.MultimapBuilder.AnonymousClass3(comparator);
    }

    public abstract <K extends K0, V extends V0> com.google.common.collect.Multimap<K, V> build();

    public <K extends K0, V extends V0> com.google.common.collect.Multimap<K, V> build(com.google.common.collect.Multimap<? extends K, ? extends V> multimap) {
        com.google.common.collect.Multimap<K, V> build = build();
        build.putAll(multimap);
        return build;
    }
}
