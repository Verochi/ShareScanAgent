package com.google.common.collect;

@com.google.common.annotations.Beta
@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
final class SortedLists {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class KeyAbsentBehavior {
        private static final /* synthetic */ com.google.common.collect.SortedLists.KeyAbsentBehavior[] $VALUES;
        public static final com.google.common.collect.SortedLists.KeyAbsentBehavior INVERTED_INSERTION_INDEX;
        public static final com.google.common.collect.SortedLists.KeyAbsentBehavior NEXT_HIGHER;
        public static final com.google.common.collect.SortedLists.KeyAbsentBehavior NEXT_LOWER;

        /* renamed from: com.google.common.collect.SortedLists$KeyAbsentBehavior$1, reason: invalid class name */
        public enum AnonymousClass1 extends com.google.common.collect.SortedLists.KeyAbsentBehavior {
            public AnonymousClass1(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.collect.SortedLists.KeyAbsentBehavior
            public int resultIndex(int i) {
                return i - 1;
            }
        }

        /* renamed from: com.google.common.collect.SortedLists$KeyAbsentBehavior$2, reason: invalid class name */
        public enum AnonymousClass2 extends com.google.common.collect.SortedLists.KeyAbsentBehavior {
            public AnonymousClass2(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.collect.SortedLists.KeyAbsentBehavior
            public int resultIndex(int i) {
                return i;
            }
        }

        /* renamed from: com.google.common.collect.SortedLists$KeyAbsentBehavior$3, reason: invalid class name */
        public enum AnonymousClass3 extends com.google.common.collect.SortedLists.KeyAbsentBehavior {
            public AnonymousClass3(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.collect.SortedLists.KeyAbsentBehavior
            public int resultIndex(int i) {
                return ~i;
            }
        }

        static {
            com.google.common.collect.SortedLists.KeyAbsentBehavior.AnonymousClass1 anonymousClass1 = new com.google.common.collect.SortedLists.KeyAbsentBehavior.AnonymousClass1("NEXT_LOWER", 0);
            NEXT_LOWER = anonymousClass1;
            com.google.common.collect.SortedLists.KeyAbsentBehavior.AnonymousClass2 anonymousClass2 = new com.google.common.collect.SortedLists.KeyAbsentBehavior.AnonymousClass2("NEXT_HIGHER", 1);
            NEXT_HIGHER = anonymousClass2;
            com.google.common.collect.SortedLists.KeyAbsentBehavior.AnonymousClass3 anonymousClass3 = new com.google.common.collect.SortedLists.KeyAbsentBehavior.AnonymousClass3("INVERTED_INSERTION_INDEX", 2);
            INVERTED_INSERTION_INDEX = anonymousClass3;
            $VALUES = new com.google.common.collect.SortedLists.KeyAbsentBehavior[]{anonymousClass1, anonymousClass2, anonymousClass3};
        }

        private KeyAbsentBehavior(java.lang.String str, int i) {
        }

        public /* synthetic */ KeyAbsentBehavior(java.lang.String str, int i, com.google.common.collect.SortedLists.AnonymousClass1 anonymousClass1) {
            this(str, i);
        }

        public static com.google.common.collect.SortedLists.KeyAbsentBehavior valueOf(java.lang.String str) {
            return (com.google.common.collect.SortedLists.KeyAbsentBehavior) java.lang.Enum.valueOf(com.google.common.collect.SortedLists.KeyAbsentBehavior.class, str);
        }

        public static com.google.common.collect.SortedLists.KeyAbsentBehavior[] values() {
            return (com.google.common.collect.SortedLists.KeyAbsentBehavior[]) $VALUES.clone();
        }

        public abstract int resultIndex(int i);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class KeyPresentBehavior {
        private static final /* synthetic */ com.google.common.collect.SortedLists.KeyPresentBehavior[] $VALUES;
        public static final com.google.common.collect.SortedLists.KeyPresentBehavior ANY_PRESENT;
        public static final com.google.common.collect.SortedLists.KeyPresentBehavior FIRST_AFTER;
        public static final com.google.common.collect.SortedLists.KeyPresentBehavior FIRST_PRESENT;
        public static final com.google.common.collect.SortedLists.KeyPresentBehavior LAST_BEFORE;
        public static final com.google.common.collect.SortedLists.KeyPresentBehavior LAST_PRESENT;

        /* renamed from: com.google.common.collect.SortedLists$KeyPresentBehavior$1, reason: invalid class name */
        public enum AnonymousClass1 extends com.google.common.collect.SortedLists.KeyPresentBehavior {
            public AnonymousClass1(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(java.util.Comparator<? super E> comparator, E e, java.util.List<? extends E> list, int i) {
                return i;
            }
        }

        /* renamed from: com.google.common.collect.SortedLists$KeyPresentBehavior$2, reason: invalid class name */
        public enum AnonymousClass2 extends com.google.common.collect.SortedLists.KeyPresentBehavior {
            public AnonymousClass2(java.lang.String str, int i) {
                super(str, i, null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(java.util.Comparator<? super E> comparator, E e, java.util.List<? extends E> list, int i) {
                int size = list.size() - 1;
                while (i < size) {
                    int i2 = ((i + size) + 1) >>> 1;
                    if (comparator.compare(list.get(i2), e) > 0) {
                        size = i2 - 1;
                    } else {
                        i = i2;
                    }
                }
                return i;
            }
        }

        /* renamed from: com.google.common.collect.SortedLists$KeyPresentBehavior$3, reason: invalid class name */
        public enum AnonymousClass3 extends com.google.common.collect.SortedLists.KeyPresentBehavior {
            public AnonymousClass3(java.lang.String str, int i) {
                super(str, i, null);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(java.util.Comparator<? super E> comparator, E e, java.util.List<? extends E> list, int i) {
                int i2 = 0;
                while (i2 < i) {
                    int i3 = (i2 + i) >>> 1;
                    if (comparator.compare(list.get(i3), e) < 0) {
                        i2 = i3 + 1;
                    } else {
                        i = i3;
                    }
                }
                return i2;
            }
        }

        /* renamed from: com.google.common.collect.SortedLists$KeyPresentBehavior$4, reason: invalid class name */
        public enum AnonymousClass4 extends com.google.common.collect.SortedLists.KeyPresentBehavior {
            public AnonymousClass4(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(java.util.Comparator<? super E> comparator, E e, java.util.List<? extends E> list, int i) {
                return com.google.common.collect.SortedLists.KeyPresentBehavior.LAST_PRESENT.resultIndex(comparator, e, list, i) + 1;
            }
        }

        /* renamed from: com.google.common.collect.SortedLists$KeyPresentBehavior$5, reason: invalid class name */
        public enum AnonymousClass5 extends com.google.common.collect.SortedLists.KeyPresentBehavior {
            public AnonymousClass5(java.lang.String str, int i) {
                super(str, i, null);
            }

            @Override // com.google.common.collect.SortedLists.KeyPresentBehavior
            public <E> int resultIndex(java.util.Comparator<? super E> comparator, E e, java.util.List<? extends E> list, int i) {
                return com.google.common.collect.SortedLists.KeyPresentBehavior.FIRST_PRESENT.resultIndex(comparator, e, list, i) - 1;
            }
        }

        static {
            com.google.common.collect.SortedLists.KeyPresentBehavior.AnonymousClass1 anonymousClass1 = new com.google.common.collect.SortedLists.KeyPresentBehavior.AnonymousClass1("ANY_PRESENT", 0);
            ANY_PRESENT = anonymousClass1;
            com.google.common.collect.SortedLists.KeyPresentBehavior.AnonymousClass2 anonymousClass2 = new com.google.common.collect.SortedLists.KeyPresentBehavior.AnonymousClass2("LAST_PRESENT", 1);
            LAST_PRESENT = anonymousClass2;
            com.google.common.collect.SortedLists.KeyPresentBehavior.AnonymousClass3 anonymousClass3 = new com.google.common.collect.SortedLists.KeyPresentBehavior.AnonymousClass3("FIRST_PRESENT", 2);
            FIRST_PRESENT = anonymousClass3;
            com.google.common.collect.SortedLists.KeyPresentBehavior.AnonymousClass4 anonymousClass4 = new com.google.common.collect.SortedLists.KeyPresentBehavior.AnonymousClass4("FIRST_AFTER", 3);
            FIRST_AFTER = anonymousClass4;
            com.google.common.collect.SortedLists.KeyPresentBehavior.AnonymousClass5 anonymousClass5 = new com.google.common.collect.SortedLists.KeyPresentBehavior.AnonymousClass5("LAST_BEFORE", 4);
            LAST_BEFORE = anonymousClass5;
            $VALUES = new com.google.common.collect.SortedLists.KeyPresentBehavior[]{anonymousClass1, anonymousClass2, anonymousClass3, anonymousClass4, anonymousClass5};
        }

        private KeyPresentBehavior(java.lang.String str, int i) {
        }

        public /* synthetic */ KeyPresentBehavior(java.lang.String str, int i, com.google.common.collect.SortedLists.AnonymousClass1 anonymousClass1) {
            this(str, i);
        }

        public static com.google.common.collect.SortedLists.KeyPresentBehavior valueOf(java.lang.String str) {
            return (com.google.common.collect.SortedLists.KeyPresentBehavior) java.lang.Enum.valueOf(com.google.common.collect.SortedLists.KeyPresentBehavior.class, str);
        }

        public static com.google.common.collect.SortedLists.KeyPresentBehavior[] values() {
            return (com.google.common.collect.SortedLists.KeyPresentBehavior[]) $VALUES.clone();
        }

        public abstract <E> int resultIndex(java.util.Comparator<? super E> comparator, E e, java.util.List<? extends E> list, int i);
    }

    public static <E, K extends java.lang.Comparable> int a(java.util.List<E> list, com.google.common.base.Function<? super E, K> function, @org.checkerframework.checker.nullness.compatqual.NullableDecl K k, com.google.common.collect.SortedLists.KeyPresentBehavior keyPresentBehavior, com.google.common.collect.SortedLists.KeyAbsentBehavior keyAbsentBehavior) {
        return b(list, function, k, com.google.common.collect.Ordering.natural(), keyPresentBehavior, keyAbsentBehavior);
    }

    public static <E, K> int b(java.util.List<E> list, com.google.common.base.Function<? super E, K> function, @org.checkerframework.checker.nullness.compatqual.NullableDecl K k, java.util.Comparator<? super K> comparator, com.google.common.collect.SortedLists.KeyPresentBehavior keyPresentBehavior, com.google.common.collect.SortedLists.KeyAbsentBehavior keyAbsentBehavior) {
        return c(com.google.common.collect.Lists.transform(list, function), k, comparator, keyPresentBehavior, keyAbsentBehavior);
    }

    public static <E> int c(java.util.List<? extends E> list, @org.checkerframework.checker.nullness.compatqual.NullableDecl E e, java.util.Comparator<? super E> comparator, com.google.common.collect.SortedLists.KeyPresentBehavior keyPresentBehavior, com.google.common.collect.SortedLists.KeyAbsentBehavior keyAbsentBehavior) {
        com.google.common.base.Preconditions.checkNotNull(comparator);
        com.google.common.base.Preconditions.checkNotNull(list);
        com.google.common.base.Preconditions.checkNotNull(keyPresentBehavior);
        com.google.common.base.Preconditions.checkNotNull(keyAbsentBehavior);
        if (!(list instanceof java.util.RandomAccess)) {
            list = com.google.common.collect.Lists.newArrayList(list);
        }
        int size = list.size() - 1;
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) >>> 1;
            int compare = comparator.compare(e, list.get(i2));
            if (compare < 0) {
                size = i2 - 1;
            } else {
                if (compare <= 0) {
                    return i + keyPresentBehavior.resultIndex(comparator, e, list.subList(i, size + 1), i2 - i);
                }
                i = i2 + 1;
            }
        }
        return keyAbsentBehavior.resultIndex(i);
    }
}
