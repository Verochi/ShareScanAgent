package com.google.common.base;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
public final class Splitter {
    public final com.google.common.base.CharMatcher a;
    public final boolean b;
    public final com.google.common.base.Splitter.Strategy c;
    public final int d;

    /* renamed from: com.google.common.base.Splitter$1, reason: invalid class name */
    public static class AnonymousClass1 implements com.google.common.base.Splitter.Strategy {
        public final /* synthetic */ com.google.common.base.CharMatcher a;

        /* renamed from: com.google.common.base.Splitter$1$1, reason: invalid class name and collision with other inner class name */
        public class C03361 extends com.google.common.base.Splitter.SplittingIterator {
            public C03361(com.google.common.base.Splitter splitter, java.lang.CharSequence charSequence) {
                super(splitter, charSequence);
            }

            @Override // com.google.common.base.Splitter.SplittingIterator
            public int e(int i) {
                return i + 1;
            }

            @Override // com.google.common.base.Splitter.SplittingIterator
            public int f(int i) {
                return com.google.common.base.Splitter.AnonymousClass1.this.a.indexIn(this.u, i);
            }
        }

        public AnonymousClass1(com.google.common.base.CharMatcher charMatcher) {
            this.a = charMatcher;
        }

        @Override // com.google.common.base.Splitter.Strategy
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.common.base.Splitter.SplittingIterator a(com.google.common.base.Splitter splitter, java.lang.CharSequence charSequence) {
            return new com.google.common.base.Splitter.AnonymousClass1.C03361(splitter, charSequence);
        }
    }

    /* renamed from: com.google.common.base.Splitter$2, reason: invalid class name */
    public static class AnonymousClass2 implements com.google.common.base.Splitter.Strategy {
        public final /* synthetic */ java.lang.String a;

        /* renamed from: com.google.common.base.Splitter$2$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.base.Splitter.SplittingIterator {
            public AnonymousClass1(com.google.common.base.Splitter splitter, java.lang.CharSequence charSequence) {
                super(splitter, charSequence);
            }

            @Override // com.google.common.base.Splitter.SplittingIterator
            public int e(int i) {
                return i + com.google.common.base.Splitter.AnonymousClass2.this.a.length();
            }

            /* JADX WARN: Code restructure failed: missing block: B:9:0x0026, code lost:
            
                r6 = r6 + 1;
             */
            @Override // com.google.common.base.Splitter.SplittingIterator
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public int f(int i) {
                int length = com.google.common.base.Splitter.AnonymousClass2.this.a.length();
                int length2 = this.u.length() - length;
                while (i <= length2) {
                    for (int i2 = 0; i2 < length; i2++) {
                        if (this.u.charAt(i2 + i) != com.google.common.base.Splitter.AnonymousClass2.this.a.charAt(i2)) {
                            break;
                        }
                    }
                    return i;
                }
                return -1;
            }
        }

        public AnonymousClass2(java.lang.String str) {
            this.a = str;
        }

        @Override // com.google.common.base.Splitter.Strategy
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.common.base.Splitter.SplittingIterator a(com.google.common.base.Splitter splitter, java.lang.CharSequence charSequence) {
            return new com.google.common.base.Splitter.AnonymousClass2.AnonymousClass1(splitter, charSequence);
        }
    }

    /* renamed from: com.google.common.base.Splitter$3, reason: invalid class name */
    public static class AnonymousClass3 implements com.google.common.base.Splitter.Strategy {
        public final /* synthetic */ com.google.common.base.CommonPattern a;

        /* renamed from: com.google.common.base.Splitter$3$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.base.Splitter.SplittingIterator {
            public final /* synthetic */ com.google.common.base.CommonMatcher z;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(com.google.common.base.Splitter splitter, java.lang.CharSequence charSequence, com.google.common.base.CommonMatcher commonMatcher) {
                super(splitter, charSequence);
                this.z = commonMatcher;
            }

            @Override // com.google.common.base.Splitter.SplittingIterator
            public int e(int i) {
                return this.z.a();
            }

            @Override // com.google.common.base.Splitter.SplittingIterator
            public int f(int i) {
                if (this.z.c(i)) {
                    return this.z.e();
                }
                return -1;
            }
        }

        public AnonymousClass3(com.google.common.base.CommonPattern commonPattern) {
            this.a = commonPattern;
        }

        @Override // com.google.common.base.Splitter.Strategy
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.common.base.Splitter.SplittingIterator a(com.google.common.base.Splitter splitter, java.lang.CharSequence charSequence) {
            return new com.google.common.base.Splitter.AnonymousClass3.AnonymousClass1(splitter, charSequence, this.a.matcher(charSequence));
        }
    }

    /* renamed from: com.google.common.base.Splitter$4, reason: invalid class name */
    public static class AnonymousClass4 implements com.google.common.base.Splitter.Strategy {
        public final /* synthetic */ int a;

        /* renamed from: com.google.common.base.Splitter$4$1, reason: invalid class name */
        public class AnonymousClass1 extends com.google.common.base.Splitter.SplittingIterator {
            public AnonymousClass1(com.google.common.base.Splitter splitter, java.lang.CharSequence charSequence) {
                super(splitter, charSequence);
            }

            @Override // com.google.common.base.Splitter.SplittingIterator
            public int e(int i) {
                return i;
            }

            @Override // com.google.common.base.Splitter.SplittingIterator
            public int f(int i) {
                int i2 = i + com.google.common.base.Splitter.AnonymousClass4.this.a;
                if (i2 < this.u.length()) {
                    return i2;
                }
                return -1;
            }
        }

        public AnonymousClass4(int i) {
            this.a = i;
        }

        @Override // com.google.common.base.Splitter.Strategy
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.common.base.Splitter.SplittingIterator a(com.google.common.base.Splitter splitter, java.lang.CharSequence charSequence) {
            return new com.google.common.base.Splitter.AnonymousClass4.AnonymousClass1(splitter, charSequence);
        }
    }

    /* renamed from: com.google.common.base.Splitter$5, reason: invalid class name */
    public class AnonymousClass5 implements java.lang.Iterable<java.lang.String> {
        public final /* synthetic */ java.lang.CharSequence n;

        public AnonymousClass5(java.lang.CharSequence charSequence) {
            this.n = charSequence;
        }

        @Override // java.lang.Iterable
        public java.util.Iterator<java.lang.String> iterator() {
            return com.google.common.base.Splitter.this.f(this.n);
        }

        public java.lang.String toString() {
            com.google.common.base.Joiner on = com.google.common.base.Joiner.on(", ");
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append('[');
            java.lang.StringBuilder appendTo = on.appendTo(sb, (java.lang.Iterable<?>) this);
            appendTo.append(']');
            return appendTo.toString();
        }
    }

    @com.google.common.annotations.Beta
    public static final class MapSplitter {
        public final com.google.common.base.Splitter a;
        public final com.google.common.base.Splitter b;

        public MapSplitter(com.google.common.base.Splitter splitter, com.google.common.base.Splitter splitter2) {
            this.a = splitter;
            this.b = (com.google.common.base.Splitter) com.google.common.base.Preconditions.checkNotNull(splitter2);
        }

        public /* synthetic */ MapSplitter(com.google.common.base.Splitter splitter, com.google.common.base.Splitter splitter2, com.google.common.base.Splitter.AnonymousClass1 anonymousClass1) {
            this(splitter, splitter2);
        }

        public java.util.Map<java.lang.String, java.lang.String> split(java.lang.CharSequence charSequence) {
            java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap();
            for (java.lang.String str : this.a.split(charSequence)) {
                java.util.Iterator f = this.b.f(str);
                com.google.common.base.Preconditions.checkArgument(f.hasNext(), "Chunk [%s] is not a valid entry", str);
                java.lang.String str2 = (java.lang.String) f.next();
                com.google.common.base.Preconditions.checkArgument(!linkedHashMap.containsKey(str2), "Duplicate key [%s] found.", str2);
                com.google.common.base.Preconditions.checkArgument(f.hasNext(), "Chunk [%s] is not a valid entry", str);
                linkedHashMap.put(str2, (java.lang.String) f.next());
                com.google.common.base.Preconditions.checkArgument(!f.hasNext(), "Chunk [%s] is not a valid entry", str);
            }
            return java.util.Collections.unmodifiableMap(linkedHashMap);
        }
    }

    public static abstract class SplittingIterator extends com.google.common.base.AbstractIterator<java.lang.String> {
        public final java.lang.CharSequence u;
        public final com.google.common.base.CharMatcher v;
        public final boolean w;
        public int x = 0;
        public int y;

        public SplittingIterator(com.google.common.base.Splitter splitter, java.lang.CharSequence charSequence) {
            this.v = splitter.a;
            this.w = splitter.b;
            this.y = splitter.d;
            this.u = charSequence;
        }

        @Override // com.google.common.base.AbstractIterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public java.lang.String a() {
            int f;
            int i = this.x;
            while (true) {
                int i2 = this.x;
                if (i2 == -1) {
                    return b();
                }
                f = f(i2);
                if (f == -1) {
                    f = this.u.length();
                    this.x = -1;
                } else {
                    this.x = e(f);
                }
                int i3 = this.x;
                if (i3 == i) {
                    int i4 = i3 + 1;
                    this.x = i4;
                    if (i4 > this.u.length()) {
                        this.x = -1;
                    }
                } else {
                    while (i < f && this.v.matches(this.u.charAt(i))) {
                        i++;
                    }
                    while (f > i && this.v.matches(this.u.charAt(f - 1))) {
                        f--;
                    }
                    if (!this.w || i != f) {
                        break;
                    }
                    i = this.x;
                }
            }
            int i5 = this.y;
            if (i5 == 1) {
                f = this.u.length();
                this.x = -1;
                while (f > i && this.v.matches(this.u.charAt(f - 1))) {
                    f--;
                }
            } else {
                this.y = i5 - 1;
            }
            return this.u.subSequence(i, f).toString();
        }

        public abstract int e(int i);

        public abstract int f(int i);
    }

    public interface Strategy {
        java.util.Iterator<java.lang.String> a(com.google.common.base.Splitter splitter, java.lang.CharSequence charSequence);
    }

    public Splitter(com.google.common.base.Splitter.Strategy strategy) {
        this(strategy, false, com.google.common.base.CharMatcher.none(), Integer.MAX_VALUE);
    }

    public Splitter(com.google.common.base.Splitter.Strategy strategy, boolean z, com.google.common.base.CharMatcher charMatcher, int i) {
        this.c = strategy;
        this.b = z;
        this.a = charMatcher;
        this.d = i;
    }

    public static com.google.common.base.Splitter e(com.google.common.base.CommonPattern commonPattern) {
        com.google.common.base.Preconditions.checkArgument(!commonPattern.matcher("").d(), "The pattern may not match the empty string: %s", commonPattern);
        return new com.google.common.base.Splitter(new com.google.common.base.Splitter.AnonymousClass3(commonPattern));
    }

    public static com.google.common.base.Splitter fixedLength(int i) {
        com.google.common.base.Preconditions.checkArgument(i > 0, "The length may not be less than 1");
        return new com.google.common.base.Splitter(new com.google.common.base.Splitter.AnonymousClass4(i));
    }

    public static com.google.common.base.Splitter on(char c) {
        return on(com.google.common.base.CharMatcher.is(c));
    }

    public static com.google.common.base.Splitter on(com.google.common.base.CharMatcher charMatcher) {
        com.google.common.base.Preconditions.checkNotNull(charMatcher);
        return new com.google.common.base.Splitter(new com.google.common.base.Splitter.AnonymousClass1(charMatcher));
    }

    public static com.google.common.base.Splitter on(java.lang.String str) {
        com.google.common.base.Preconditions.checkArgument(str.length() != 0, "The separator may not be the empty string.");
        return str.length() == 1 ? on(str.charAt(0)) : new com.google.common.base.Splitter(new com.google.common.base.Splitter.AnonymousClass2(str));
    }

    @com.google.common.annotations.GwtIncompatible
    public static com.google.common.base.Splitter on(java.util.regex.Pattern pattern) {
        return e(new com.google.common.base.JdkPattern(pattern));
    }

    @com.google.common.annotations.GwtIncompatible
    public static com.google.common.base.Splitter onPattern(java.lang.String str) {
        return e(com.google.common.base.Platform.a(str));
    }

    public final java.util.Iterator<java.lang.String> f(java.lang.CharSequence charSequence) {
        return this.c.a(this, charSequence);
    }

    public com.google.common.base.Splitter limit(int i) {
        com.google.common.base.Preconditions.checkArgument(i > 0, "must be greater than zero: %s", i);
        return new com.google.common.base.Splitter(this.c, this.b, this.a, i);
    }

    public com.google.common.base.Splitter omitEmptyStrings() {
        return new com.google.common.base.Splitter(this.c, true, this.a, this.d);
    }

    public java.lang.Iterable<java.lang.String> split(java.lang.CharSequence charSequence) {
        com.google.common.base.Preconditions.checkNotNull(charSequence);
        return new com.google.common.base.Splitter.AnonymousClass5(charSequence);
    }

    public java.util.List<java.lang.String> splitToList(java.lang.CharSequence charSequence) {
        com.google.common.base.Preconditions.checkNotNull(charSequence);
        java.util.Iterator<java.lang.String> f = f(charSequence);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        while (f.hasNext()) {
            arrayList.add(f.next());
        }
        return java.util.Collections.unmodifiableList(arrayList);
    }

    public com.google.common.base.Splitter trimResults() {
        return trimResults(com.google.common.base.CharMatcher.whitespace());
    }

    public com.google.common.base.Splitter trimResults(com.google.common.base.CharMatcher charMatcher) {
        com.google.common.base.Preconditions.checkNotNull(charMatcher);
        return new com.google.common.base.Splitter(this.c, this.b, charMatcher, this.d);
    }

    @com.google.common.annotations.Beta
    public com.google.common.base.Splitter.MapSplitter withKeyValueSeparator(char c) {
        return withKeyValueSeparator(on(c));
    }

    @com.google.common.annotations.Beta
    public com.google.common.base.Splitter.MapSplitter withKeyValueSeparator(com.google.common.base.Splitter splitter) {
        return new com.google.common.base.Splitter.MapSplitter(this, splitter, null);
    }

    @com.google.common.annotations.Beta
    public com.google.common.base.Splitter.MapSplitter withKeyValueSeparator(java.lang.String str) {
        return withKeyValueSeparator(on(str));
    }
}
