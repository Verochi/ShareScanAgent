package com.google.common.base;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
final class Platform {
    public static final java.util.logging.Logger a = java.util.logging.Logger.getLogger(com.google.common.base.Platform.class.getName());
    public static final com.google.common.base.PatternCompiler b = e();

    public static final class JdkPatternCompiler implements com.google.common.base.PatternCompiler {
        public JdkPatternCompiler() {
        }

        public /* synthetic */ JdkPatternCompiler(com.google.common.base.Platform.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.common.base.PatternCompiler
        public boolean a() {
            return true;
        }

        @Override // com.google.common.base.PatternCompiler
        public com.google.common.base.CommonPattern compile(java.lang.String str) {
            return new com.google.common.base.JdkPattern(java.util.regex.Pattern.compile(str));
        }
    }

    public static com.google.common.base.CommonPattern a(java.lang.String str) {
        com.google.common.base.Preconditions.checkNotNull(str);
        return b.compile(str);
    }

    public static java.lang.String b(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str) {
        if (i(str)) {
            return null;
        }
        return str;
    }

    public static java.lang.String c(double d) {
        return java.lang.String.format(java.util.Locale.ROOT, "%.4g", java.lang.Double.valueOf(d));
    }

    public static <T extends java.lang.Enum<T>> com.google.common.base.Optional<T> d(java.lang.Class<T> cls, java.lang.String str) {
        java.lang.ref.WeakReference<? extends java.lang.Enum<?>> weakReference = com.google.common.base.Enums.a(cls).get(str);
        return weakReference == null ? com.google.common.base.Optional.absent() : com.google.common.base.Optional.of(cls.cast(weakReference.get()));
    }

    public static com.google.common.base.PatternCompiler e() {
        return new com.google.common.base.Platform.JdkPatternCompiler(null);
    }

    public static java.lang.String f(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str) {
        return str == null ? "" : str;
    }

    public static boolean g() {
        return b.a();
    }

    public static com.google.common.base.CharMatcher h(com.google.common.base.CharMatcher charMatcher) {
        return charMatcher.e();
    }

    public static boolean i(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.String str) {
        return str == null || str.isEmpty();
    }

    public static long j() {
        return java.lang.System.nanoTime();
    }
}
