package com.google.common.base;

@com.google.common.annotations.GwtIncompatible
/* loaded from: classes22.dex */
final class JdkPattern extends com.google.common.base.CommonPattern implements java.io.Serializable {
    private static final long serialVersionUID = 0;
    private final java.util.regex.Pattern pattern;

    public static final class JdkMatcher extends com.google.common.base.CommonMatcher {
        public final java.util.regex.Matcher a;

        public JdkMatcher(java.util.regex.Matcher matcher) {
            this.a = (java.util.regex.Matcher) com.google.common.base.Preconditions.checkNotNull(matcher);
        }

        @Override // com.google.common.base.CommonMatcher
        public int a() {
            return this.a.end();
        }

        @Override // com.google.common.base.CommonMatcher
        public boolean b() {
            return this.a.find();
        }

        @Override // com.google.common.base.CommonMatcher
        public boolean c(int i) {
            return this.a.find(i);
        }

        @Override // com.google.common.base.CommonMatcher
        public boolean d() {
            return this.a.matches();
        }

        @Override // com.google.common.base.CommonMatcher
        public int e() {
            return this.a.start();
        }
    }

    public JdkPattern(java.util.regex.Pattern pattern) {
        this.pattern = (java.util.regex.Pattern) com.google.common.base.Preconditions.checkNotNull(pattern);
    }

    @Override // com.google.common.base.CommonPattern
    public int flags() {
        return this.pattern.flags();
    }

    @Override // com.google.common.base.CommonPattern
    public com.google.common.base.CommonMatcher matcher(java.lang.CharSequence charSequence) {
        return new com.google.common.base.JdkPattern.JdkMatcher(this.pattern.matcher(charSequence));
    }

    @Override // com.google.common.base.CommonPattern
    public java.lang.String pattern() {
        return this.pattern.pattern();
    }

    @Override // com.google.common.base.CommonPattern
    public java.lang.String toString() {
        return this.pattern.toString();
    }
}
