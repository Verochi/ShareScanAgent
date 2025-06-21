package com.google.common.net;

@com.google.errorprone.annotations.Immutable
@com.google.common.annotations.Beta
@com.google.common.annotations.GwtCompatible
/* loaded from: classes22.dex */
public final class InternetDomainName {
    public static final com.google.common.base.CharMatcher e = com.google.common.base.CharMatcher.anyOf(".。．｡");
    public static final com.google.common.base.Splitter f = com.google.common.base.Splitter.on('.');
    public static final com.google.common.base.Joiner g = com.google.common.base.Joiner.on('.');
    public static final com.google.common.base.CharMatcher h;
    public static final com.google.common.base.CharMatcher i;
    public final java.lang.String a;
    public final com.google.common.collect.ImmutableList<java.lang.String> b;
    public final int c;
    public final int d;

    static {
        com.google.common.base.CharMatcher anyOf = com.google.common.base.CharMatcher.anyOf("-_");
        h = anyOf;
        i = com.google.common.base.CharMatcher.javaLetterOrDigit().or(anyOf);
    }

    public InternetDomainName(java.lang.String str) {
        java.lang.String lowerCase = com.google.common.base.Ascii.toLowerCase(e.replaceFrom((java.lang.CharSequence) str, '.'));
        lowerCase = lowerCase.endsWith(".") ? lowerCase.substring(0, lowerCase.length() - 1) : lowerCase;
        com.google.common.base.Preconditions.checkArgument(lowerCase.length() <= 253, "Domain name too long: '%s':", lowerCase);
        this.a = lowerCase;
        com.google.common.collect.ImmutableList<java.lang.String> copyOf = com.google.common.collect.ImmutableList.copyOf(f.split(lowerCase));
        this.b = copyOf;
        com.google.common.base.Preconditions.checkArgument(copyOf.size() <= 127, "Domain has too many parts: '%s'", lowerCase);
        com.google.common.base.Preconditions.checkArgument(f(copyOf), "Not a valid domain name: '%s'", lowerCase);
        this.c = b(com.google.common.base.Optional.absent());
        this.d = b(com.google.common.base.Optional.of(com.google.thirdparty.publicsuffix.PublicSuffixType.REGISTRY));
    }

    public static boolean c(com.google.common.base.Optional<com.google.thirdparty.publicsuffix.PublicSuffixType> optional, com.google.common.base.Optional<com.google.thirdparty.publicsuffix.PublicSuffixType> optional2) {
        return optional.isPresent() ? optional.equals(optional2) : optional2.isPresent();
    }

    public static boolean d(com.google.common.base.Optional<com.google.thirdparty.publicsuffix.PublicSuffixType> optional, java.lang.String str) {
        java.util.List<java.lang.String> splitToList = f.limit(2).splitToList(str);
        return splitToList.size() == 2 && c(optional, com.google.common.base.Optional.fromNullable(com.google.thirdparty.publicsuffix.PublicSuffixPatterns.UNDER.get(splitToList.get(1))));
    }

    public static boolean e(java.lang.String str, boolean z) {
        if (str.length() >= 1 && str.length() <= 63) {
            if (!i.matchesAllOf(com.google.common.base.CharMatcher.ascii().retainFrom(str))) {
                return false;
            }
            com.google.common.base.CharMatcher charMatcher = h;
            if (!charMatcher.matches(str.charAt(0)) && !charMatcher.matches(str.charAt(str.length() - 1))) {
                return (z && com.google.common.base.CharMatcher.digit().matches(str.charAt(0))) ? false : true;
            }
        }
        return false;
    }

    public static boolean f(java.util.List<java.lang.String> list) {
        int size = list.size() - 1;
        if (!e(list.get(size), true)) {
            return false;
        }
        for (int i2 = 0; i2 < size; i2++) {
            if (!e(list.get(i2), false)) {
                return false;
            }
        }
        return true;
    }

    public static com.google.common.net.InternetDomainName from(java.lang.String str) {
        return new com.google.common.net.InternetDomainName((java.lang.String) com.google.common.base.Preconditions.checkNotNull(str));
    }

    public static boolean isValid(java.lang.String str) {
        try {
            from(str);
            return true;
        } catch (java.lang.IllegalArgumentException unused) {
            return false;
        }
    }

    public final com.google.common.net.InternetDomainName a(int i2) {
        com.google.common.base.Joiner joiner = g;
        com.google.common.collect.ImmutableList<java.lang.String> immutableList = this.b;
        return from(joiner.join(immutableList.subList(i2, immutableList.size())));
    }

    public final int b(com.google.common.base.Optional<com.google.thirdparty.publicsuffix.PublicSuffixType> optional) {
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            java.lang.String join = g.join(this.b.subList(i2, size));
            if (c(optional, com.google.common.base.Optional.fromNullable(com.google.thirdparty.publicsuffix.PublicSuffixPatterns.EXACT.get(join)))) {
                return i2;
            }
            if (com.google.thirdparty.publicsuffix.PublicSuffixPatterns.EXCLUDED.containsKey(join)) {
                return i2 + 1;
            }
            if (d(optional, join)) {
                return i2;
            }
        }
        return -1;
    }

    public com.google.common.net.InternetDomainName child(java.lang.String str) {
        return from(((java.lang.String) com.google.common.base.Preconditions.checkNotNull(str)) + "." + this.a);
    }

    public boolean equals(@org.checkerframework.checker.nullness.compatqual.NullableDecl java.lang.Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof com.google.common.net.InternetDomainName) {
            return this.a.equals(((com.google.common.net.InternetDomainName) obj).a);
        }
        return false;
    }

    public boolean hasParent() {
        return this.b.size() > 1;
    }

    public boolean hasPublicSuffix() {
        return this.c != -1;
    }

    public boolean hasRegistrySuffix() {
        return this.d != -1;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public boolean isPublicSuffix() {
        return this.c == 0;
    }

    public boolean isRegistrySuffix() {
        return this.d == 0;
    }

    public boolean isTopDomainUnderRegistrySuffix() {
        return this.d == 1;
    }

    public boolean isTopPrivateDomain() {
        return this.c == 1;
    }

    public boolean isUnderPublicSuffix() {
        return this.c > 0;
    }

    public boolean isUnderRegistrySuffix() {
        return this.d > 0;
    }

    public com.google.common.net.InternetDomainName parent() {
        com.google.common.base.Preconditions.checkState(hasParent(), "Domain '%s' has no parent", this.a);
        return a(1);
    }

    public com.google.common.collect.ImmutableList<java.lang.String> parts() {
        return this.b;
    }

    public com.google.common.net.InternetDomainName publicSuffix() {
        if (hasPublicSuffix()) {
            return a(this.c);
        }
        return null;
    }

    public com.google.common.net.InternetDomainName registrySuffix() {
        if (hasRegistrySuffix()) {
            return a(this.d);
        }
        return null;
    }

    public java.lang.String toString() {
        return this.a;
    }

    public com.google.common.net.InternetDomainName topDomainUnderRegistrySuffix() {
        if (isTopDomainUnderRegistrySuffix()) {
            return this;
        }
        com.google.common.base.Preconditions.checkState(isUnderRegistrySuffix(), "Not under a registry suffix: %s", this.a);
        return a(this.d - 1);
    }

    public com.google.common.net.InternetDomainName topPrivateDomain() {
        if (isTopPrivateDomain()) {
            return this;
        }
        com.google.common.base.Preconditions.checkState(isUnderPublicSuffix(), "Not under a public suffix: %s", this.a);
        return a(this.c - 1);
    }
}
