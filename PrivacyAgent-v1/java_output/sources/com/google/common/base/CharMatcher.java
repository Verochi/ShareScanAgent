package com.google.common.base;

@com.google.common.annotations.GwtCompatible(emulated = true)
/* loaded from: classes22.dex */
public abstract class CharMatcher implements com.google.common.base.Predicate<java.lang.Character> {

    /* renamed from: com.google.common.base.CharMatcher$1, reason: invalid class name */
    public class AnonymousClass1 extends com.google.common.base.CharMatcher.NegatedFastMatcher {
        public final /* synthetic */ java.lang.String t;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(com.google.common.base.CharMatcher charMatcher, java.lang.String str) {
            super(charMatcher);
            this.t = str;
        }

        @Override // com.google.common.base.CharMatcher.Negated, com.google.common.base.CharMatcher
        public java.lang.String toString() {
            return this.t;
        }
    }

    public static final class And extends com.google.common.base.CharMatcher {
        public final com.google.common.base.CharMatcher n;
        public final com.google.common.base.CharMatcher t;

        public And(com.google.common.base.CharMatcher charMatcher, com.google.common.base.CharMatcher charMatcher2) {
            this.n = (com.google.common.base.CharMatcher) com.google.common.base.Preconditions.checkNotNull(charMatcher);
            this.t = (com.google.common.base.CharMatcher) com.google.common.base.Preconditions.checkNotNull(charMatcher2);
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @java.lang.Deprecated
        public /* bridge */ /* synthetic */ boolean apply(java.lang.Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        @com.google.common.annotations.GwtIncompatible
        public void g(java.util.BitSet bitSet) {
            java.util.BitSet bitSet2 = new java.util.BitSet();
            this.n.g(bitSet2);
            java.util.BitSet bitSet3 = new java.util.BitSet();
            this.t.g(bitSet3);
            bitSet2.and(bitSet3);
            bitSet.or(bitSet2);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return this.n.matches(c) && this.t.matches(c);
        }

        @Override // com.google.common.base.CharMatcher
        public java.lang.String toString() {
            return "CharMatcher.and(" + this.n + ", " + this.t + ")";
        }
    }

    public static final class Any extends com.google.common.base.CharMatcher.NamedFastMatcher {
        public static final com.google.common.base.CharMatcher.Any t = new com.google.common.base.CharMatcher.Any();

        public Any() {
            super("CharMatcher.any()");
        }

        @Override // com.google.common.base.CharMatcher
        public com.google.common.base.CharMatcher and(com.google.common.base.CharMatcher charMatcher) {
            return (com.google.common.base.CharMatcher) com.google.common.base.Preconditions.checkNotNull(charMatcher);
        }

        @Override // com.google.common.base.CharMatcher
        public java.lang.String collapseFrom(java.lang.CharSequence charSequence, char c) {
            return charSequence.length() == 0 ? "" : java.lang.String.valueOf(c);
        }

        @Override // com.google.common.base.CharMatcher
        public int countIn(java.lang.CharSequence charSequence) {
            return charSequence.length();
        }

        @Override // com.google.common.base.CharMatcher
        public int indexIn(java.lang.CharSequence charSequence) {
            return charSequence.length() == 0 ? -1 : 0;
        }

        @Override // com.google.common.base.CharMatcher
        public int indexIn(java.lang.CharSequence charSequence, int i) {
            int length = charSequence.length();
            com.google.common.base.Preconditions.checkPositionIndex(i, length);
            if (i == length) {
                return -1;
            }
            return i;
        }

        @Override // com.google.common.base.CharMatcher
        public int lastIndexIn(java.lang.CharSequence charSequence) {
            return charSequence.length() - 1;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return true;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesAllOf(java.lang.CharSequence charSequence) {
            com.google.common.base.Preconditions.checkNotNull(charSequence);
            return true;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesNoneOf(java.lang.CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, com.google.common.base.CharMatcher
        public com.google.common.base.CharMatcher negate() {
            return com.google.common.base.CharMatcher.none();
        }

        @Override // com.google.common.base.CharMatcher
        public com.google.common.base.CharMatcher or(com.google.common.base.CharMatcher charMatcher) {
            com.google.common.base.Preconditions.checkNotNull(charMatcher);
            return this;
        }

        @Override // com.google.common.base.CharMatcher
        public java.lang.String removeFrom(java.lang.CharSequence charSequence) {
            com.google.common.base.Preconditions.checkNotNull(charSequence);
            return "";
        }

        @Override // com.google.common.base.CharMatcher
        public java.lang.String replaceFrom(java.lang.CharSequence charSequence, char c) {
            char[] cArr = new char[charSequence.length()];
            java.util.Arrays.fill(cArr, c);
            return new java.lang.String(cArr);
        }

        @Override // com.google.common.base.CharMatcher
        public java.lang.String replaceFrom(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(charSequence.length() * charSequence2.length());
            for (int i = 0; i < charSequence.length(); i++) {
                sb.append(charSequence2);
            }
            return sb.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public java.lang.String trimFrom(java.lang.CharSequence charSequence) {
            com.google.common.base.Preconditions.checkNotNull(charSequence);
            return "";
        }
    }

    public static final class AnyOf extends com.google.common.base.CharMatcher {
        public final char[] n;

        public AnyOf(java.lang.CharSequence charSequence) {
            char[] charArray = charSequence.toString().toCharArray();
            this.n = charArray;
            java.util.Arrays.sort(charArray);
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @java.lang.Deprecated
        public /* bridge */ /* synthetic */ boolean apply(java.lang.Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        @com.google.common.annotations.GwtIncompatible
        public void g(java.util.BitSet bitSet) {
            for (char c : this.n) {
                bitSet.set(c);
            }
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return java.util.Arrays.binarySearch(this.n, c) >= 0;
        }

        @Override // com.google.common.base.CharMatcher
        public java.lang.String toString() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder("CharMatcher.anyOf(\"");
            for (char c : this.n) {
                sb.append(com.google.common.base.CharMatcher.h(c));
            }
            sb.append("\")");
            return sb.toString();
        }
    }

    public static final class Ascii extends com.google.common.base.CharMatcher.NamedFastMatcher {
        public static final com.google.common.base.CharMatcher.Ascii t = new com.google.common.base.CharMatcher.Ascii();

        public Ascii() {
            super("CharMatcher.ascii()");
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return c <= 127;
        }
    }

    @com.google.common.annotations.GwtIncompatible
    public static final class BitSetMatcher extends com.google.common.base.CharMatcher.NamedFastMatcher {
        public final java.util.BitSet t;

        public BitSetMatcher(java.util.BitSet bitSet, java.lang.String str) {
            super(str);
            this.t = bitSet.length() + 64 < bitSet.size() ? (java.util.BitSet) bitSet.clone() : bitSet;
        }

        public /* synthetic */ BitSetMatcher(java.util.BitSet bitSet, java.lang.String str, com.google.common.base.CharMatcher.AnonymousClass1 anonymousClass1) {
            this(bitSet, str);
        }

        @Override // com.google.common.base.CharMatcher
        public void g(java.util.BitSet bitSet) {
            bitSet.or(this.t);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return this.t.get(c);
        }
    }

    public static final class BreakingWhitespace extends com.google.common.base.CharMatcher {
        public static final com.google.common.base.CharMatcher n = new com.google.common.base.CharMatcher.BreakingWhitespace();

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @java.lang.Deprecated
        public /* bridge */ /* synthetic */ boolean apply(java.lang.Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            if (c != ' ' && c != 133 && c != 5760) {
                if (c == 8199) {
                    return false;
                }
                if (c != 8287 && c != 12288 && c != 8232 && c != 8233) {
                    switch (c) {
                        case '\t':
                        case '\n':
                        case 11:
                        case '\f':
                        case '\r':
                            break;
                        default:
                            return c >= 8192 && c <= 8202;
                    }
                }
            }
            return true;
        }

        @Override // com.google.common.base.CharMatcher
        public java.lang.String toString() {
            return "CharMatcher.breakingWhitespace()";
        }
    }

    public static final class Digit extends com.google.common.base.CharMatcher.RangesMatcher {
        public static final com.google.common.base.CharMatcher.Digit v = new com.google.common.base.CharMatcher.Digit();

        public Digit() {
            super("CharMatcher.digit()", j(), i());
        }

        public static char[] i() {
            char[] cArr = new char[37];
            for (int i = 0; i < 37; i++) {
                cArr[i] = (char) ("0٠۰߀०০੦૦୦௦౦೦൦෦๐໐༠၀႐០᠐᥆᧐᪀᪐᭐᮰᱀᱐꘠꣐꤀꧐꧰꩐꯰０".charAt(i) + '\t');
            }
            return cArr;
        }

        public static char[] j() {
            return "0٠۰߀०০੦૦୦௦౦೦൦෦๐໐༠၀႐០᠐᥆᧐᪀᪐᭐᮰᱀᱐꘠꣐꤀꧐꧰꩐꯰０".toCharArray();
        }
    }

    public static abstract class FastMatcher extends com.google.common.base.CharMatcher {
        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @java.lang.Deprecated
        public /* bridge */ /* synthetic */ boolean apply(java.lang.Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public com.google.common.base.CharMatcher negate() {
            return new com.google.common.base.CharMatcher.NegatedFastMatcher(this);
        }

        @Override // com.google.common.base.CharMatcher
        public final com.google.common.base.CharMatcher precomputed() {
            return this;
        }
    }

    public static final class ForPredicate extends com.google.common.base.CharMatcher {
        public final com.google.common.base.Predicate<? super java.lang.Character> n;

        public ForPredicate(com.google.common.base.Predicate<? super java.lang.Character> predicate) {
            this.n = (com.google.common.base.Predicate) com.google.common.base.Preconditions.checkNotNull(predicate);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public boolean apply(java.lang.Character ch) {
            return this.n.apply(com.google.common.base.Preconditions.checkNotNull(ch));
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return this.n.apply(java.lang.Character.valueOf(c));
        }

        @Override // com.google.common.base.CharMatcher
        public java.lang.String toString() {
            return "CharMatcher.forPredicate(" + this.n + ")";
        }
    }

    public static final class InRange extends com.google.common.base.CharMatcher.FastMatcher {
        public final char n;
        public final char t;

        public InRange(char c, char c2) {
            com.google.common.base.Preconditions.checkArgument(c2 >= c);
            this.n = c;
            this.t = c2;
        }

        @Override // com.google.common.base.CharMatcher
        @com.google.common.annotations.GwtIncompatible
        public void g(java.util.BitSet bitSet) {
            bitSet.set(this.n, this.t + 1);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return this.n <= c && c <= this.t;
        }

        @Override // com.google.common.base.CharMatcher
        public java.lang.String toString() {
            return "CharMatcher.inRange('" + com.google.common.base.CharMatcher.h(this.n) + "', '" + com.google.common.base.CharMatcher.h(this.t) + "')";
        }
    }

    public static final class Invisible extends com.google.common.base.CharMatcher.RangesMatcher {
        public static final com.google.common.base.CharMatcher.Invisible v = new com.google.common.base.CharMatcher.Invisible();

        public Invisible() {
            super("CharMatcher.invisible()", "\u0000\u007f\u00ad\u0600\u061c\u06dd\u070f\u08e2\u1680\u180e\u2000\u2028\u205f\u2066\u3000\ud800\ufeff\ufff9".toCharArray(), "  \u00ad\u0605\u061c\u06dd\u070f\u08e2\u1680\u180e\u200f \u2064\u206f\u3000\uf8ff\ufeff\ufffb".toCharArray());
        }
    }

    public static final class Is extends com.google.common.base.CharMatcher.FastMatcher {
        public final char n;

        public Is(char c) {
            this.n = c;
        }

        @Override // com.google.common.base.CharMatcher
        public com.google.common.base.CharMatcher and(com.google.common.base.CharMatcher charMatcher) {
            return charMatcher.matches(this.n) ? this : com.google.common.base.CharMatcher.none();
        }

        @Override // com.google.common.base.CharMatcher
        @com.google.common.annotations.GwtIncompatible
        public void g(java.util.BitSet bitSet) {
            bitSet.set(this.n);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return c == this.n;
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, com.google.common.base.CharMatcher
        public com.google.common.base.CharMatcher negate() {
            return com.google.common.base.CharMatcher.isNot(this.n);
        }

        @Override // com.google.common.base.CharMatcher
        public com.google.common.base.CharMatcher or(com.google.common.base.CharMatcher charMatcher) {
            return charMatcher.matches(this.n) ? charMatcher : super.or(charMatcher);
        }

        @Override // com.google.common.base.CharMatcher
        public java.lang.String replaceFrom(java.lang.CharSequence charSequence, char c) {
            return charSequence.toString().replace(this.n, c);
        }

        @Override // com.google.common.base.CharMatcher
        public java.lang.String toString() {
            return "CharMatcher.is('" + com.google.common.base.CharMatcher.h(this.n) + "')";
        }
    }

    public static final class IsEither extends com.google.common.base.CharMatcher.FastMatcher {
        public final char n;
        public final char t;

        public IsEither(char c, char c2) {
            this.n = c;
            this.t = c2;
        }

        @Override // com.google.common.base.CharMatcher
        @com.google.common.annotations.GwtIncompatible
        public void g(java.util.BitSet bitSet) {
            bitSet.set(this.n);
            bitSet.set(this.t);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return c == this.n || c == this.t;
        }

        @Override // com.google.common.base.CharMatcher
        public java.lang.String toString() {
            return "CharMatcher.anyOf(\"" + com.google.common.base.CharMatcher.h(this.n) + com.google.common.base.CharMatcher.h(this.t) + "\")";
        }
    }

    public static final class IsNot extends com.google.common.base.CharMatcher.FastMatcher {
        public final char n;

        public IsNot(char c) {
            this.n = c;
        }

        @Override // com.google.common.base.CharMatcher
        public com.google.common.base.CharMatcher and(com.google.common.base.CharMatcher charMatcher) {
            return charMatcher.matches(this.n) ? super.and(charMatcher) : charMatcher;
        }

        @Override // com.google.common.base.CharMatcher
        @com.google.common.annotations.GwtIncompatible
        public void g(java.util.BitSet bitSet) {
            bitSet.set(0, this.n);
            bitSet.set(this.n + 1, 65536);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return c != this.n;
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, com.google.common.base.CharMatcher
        public com.google.common.base.CharMatcher negate() {
            return com.google.common.base.CharMatcher.is(this.n);
        }

        @Override // com.google.common.base.CharMatcher
        public com.google.common.base.CharMatcher or(com.google.common.base.CharMatcher charMatcher) {
            return charMatcher.matches(this.n) ? com.google.common.base.CharMatcher.any() : this;
        }

        @Override // com.google.common.base.CharMatcher
        public java.lang.String toString() {
            return "CharMatcher.isNot('" + com.google.common.base.CharMatcher.h(this.n) + "')";
        }
    }

    public static final class JavaDigit extends com.google.common.base.CharMatcher {
        public static final com.google.common.base.CharMatcher.JavaDigit n = new com.google.common.base.CharMatcher.JavaDigit();

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @java.lang.Deprecated
        public /* bridge */ /* synthetic */ boolean apply(java.lang.Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return java.lang.Character.isDigit(c);
        }

        @Override // com.google.common.base.CharMatcher
        public java.lang.String toString() {
            return "CharMatcher.javaDigit()";
        }
    }

    public static final class JavaIsoControl extends com.google.common.base.CharMatcher.NamedFastMatcher {
        public static final com.google.common.base.CharMatcher.JavaIsoControl t = new com.google.common.base.CharMatcher.JavaIsoControl();

        public JavaIsoControl() {
            super("CharMatcher.javaIsoControl()");
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return c <= 31 || (c >= 127 && c <= 159);
        }
    }

    public static final class JavaLetter extends com.google.common.base.CharMatcher {
        public static final com.google.common.base.CharMatcher.JavaLetter n = new com.google.common.base.CharMatcher.JavaLetter();

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @java.lang.Deprecated
        public /* bridge */ /* synthetic */ boolean apply(java.lang.Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return java.lang.Character.isLetter(c);
        }

        @Override // com.google.common.base.CharMatcher
        public java.lang.String toString() {
            return "CharMatcher.javaLetter()";
        }
    }

    public static final class JavaLetterOrDigit extends com.google.common.base.CharMatcher {
        public static final com.google.common.base.CharMatcher.JavaLetterOrDigit n = new com.google.common.base.CharMatcher.JavaLetterOrDigit();

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @java.lang.Deprecated
        public /* bridge */ /* synthetic */ boolean apply(java.lang.Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return java.lang.Character.isLetterOrDigit(c);
        }

        @Override // com.google.common.base.CharMatcher
        public java.lang.String toString() {
            return "CharMatcher.javaLetterOrDigit()";
        }
    }

    public static final class JavaLowerCase extends com.google.common.base.CharMatcher {
        public static final com.google.common.base.CharMatcher.JavaLowerCase n = new com.google.common.base.CharMatcher.JavaLowerCase();

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @java.lang.Deprecated
        public /* bridge */ /* synthetic */ boolean apply(java.lang.Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return java.lang.Character.isLowerCase(c);
        }

        @Override // com.google.common.base.CharMatcher
        public java.lang.String toString() {
            return "CharMatcher.javaLowerCase()";
        }
    }

    public static final class JavaUpperCase extends com.google.common.base.CharMatcher {
        public static final com.google.common.base.CharMatcher.JavaUpperCase n = new com.google.common.base.CharMatcher.JavaUpperCase();

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @java.lang.Deprecated
        public /* bridge */ /* synthetic */ boolean apply(java.lang.Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return java.lang.Character.isUpperCase(c);
        }

        @Override // com.google.common.base.CharMatcher
        public java.lang.String toString() {
            return "CharMatcher.javaUpperCase()";
        }
    }

    public static abstract class NamedFastMatcher extends com.google.common.base.CharMatcher.FastMatcher {
        public final java.lang.String n;

        public NamedFastMatcher(java.lang.String str) {
            this.n = (java.lang.String) com.google.common.base.Preconditions.checkNotNull(str);
        }

        @Override // com.google.common.base.CharMatcher
        public final java.lang.String toString() {
            return this.n;
        }
    }

    public static class Negated extends com.google.common.base.CharMatcher {
        public final com.google.common.base.CharMatcher n;

        public Negated(com.google.common.base.CharMatcher charMatcher) {
            this.n = (com.google.common.base.CharMatcher) com.google.common.base.Preconditions.checkNotNull(charMatcher);
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @java.lang.Deprecated
        public /* bridge */ /* synthetic */ boolean apply(java.lang.Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public int countIn(java.lang.CharSequence charSequence) {
            return charSequence.length() - this.n.countIn(charSequence);
        }

        @Override // com.google.common.base.CharMatcher
        @com.google.common.annotations.GwtIncompatible
        public void g(java.util.BitSet bitSet) {
            java.util.BitSet bitSet2 = new java.util.BitSet();
            this.n.g(bitSet2);
            bitSet2.flip(0, 65536);
            bitSet.or(bitSet2);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return !this.n.matches(c);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesAllOf(java.lang.CharSequence charSequence) {
            return this.n.matchesNoneOf(charSequence);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesNoneOf(java.lang.CharSequence charSequence) {
            return this.n.matchesAllOf(charSequence);
        }

        @Override // com.google.common.base.CharMatcher
        public com.google.common.base.CharMatcher negate() {
            return this.n;
        }

        @Override // com.google.common.base.CharMatcher
        public java.lang.String toString() {
            return this.n + ".negate()";
        }
    }

    public static class NegatedFastMatcher extends com.google.common.base.CharMatcher.Negated {
        public NegatedFastMatcher(com.google.common.base.CharMatcher charMatcher) {
            super(charMatcher);
        }

        @Override // com.google.common.base.CharMatcher
        public final com.google.common.base.CharMatcher precomputed() {
            return this;
        }
    }

    public static final class None extends com.google.common.base.CharMatcher.NamedFastMatcher {
        public static final com.google.common.base.CharMatcher.None t = new com.google.common.base.CharMatcher.None();

        public None() {
            super("CharMatcher.none()");
        }

        @Override // com.google.common.base.CharMatcher
        public com.google.common.base.CharMatcher and(com.google.common.base.CharMatcher charMatcher) {
            com.google.common.base.Preconditions.checkNotNull(charMatcher);
            return this;
        }

        @Override // com.google.common.base.CharMatcher
        public java.lang.String collapseFrom(java.lang.CharSequence charSequence, char c) {
            return charSequence.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public int countIn(java.lang.CharSequence charSequence) {
            com.google.common.base.Preconditions.checkNotNull(charSequence);
            return 0;
        }

        @Override // com.google.common.base.CharMatcher
        public int indexIn(java.lang.CharSequence charSequence) {
            com.google.common.base.Preconditions.checkNotNull(charSequence);
            return -1;
        }

        @Override // com.google.common.base.CharMatcher
        public int indexIn(java.lang.CharSequence charSequence, int i) {
            com.google.common.base.Preconditions.checkPositionIndex(i, charSequence.length());
            return -1;
        }

        @Override // com.google.common.base.CharMatcher
        public int lastIndexIn(java.lang.CharSequence charSequence) {
            com.google.common.base.Preconditions.checkNotNull(charSequence);
            return -1;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return false;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesAllOf(java.lang.CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesNoneOf(java.lang.CharSequence charSequence) {
            com.google.common.base.Preconditions.checkNotNull(charSequence);
            return true;
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, com.google.common.base.CharMatcher
        public com.google.common.base.CharMatcher negate() {
            return com.google.common.base.CharMatcher.any();
        }

        @Override // com.google.common.base.CharMatcher
        public com.google.common.base.CharMatcher or(com.google.common.base.CharMatcher charMatcher) {
            return (com.google.common.base.CharMatcher) com.google.common.base.Preconditions.checkNotNull(charMatcher);
        }

        @Override // com.google.common.base.CharMatcher
        public java.lang.String removeFrom(java.lang.CharSequence charSequence) {
            return charSequence.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public java.lang.String replaceFrom(java.lang.CharSequence charSequence, char c) {
            return charSequence.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public java.lang.String replaceFrom(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2) {
            com.google.common.base.Preconditions.checkNotNull(charSequence2);
            return charSequence.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public java.lang.String trimFrom(java.lang.CharSequence charSequence) {
            return charSequence.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public java.lang.String trimLeadingFrom(java.lang.CharSequence charSequence) {
            return charSequence.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public java.lang.String trimTrailingFrom(java.lang.CharSequence charSequence) {
            return charSequence.toString();
        }
    }

    public static final class Or extends com.google.common.base.CharMatcher {
        public final com.google.common.base.CharMatcher n;
        public final com.google.common.base.CharMatcher t;

        public Or(com.google.common.base.CharMatcher charMatcher, com.google.common.base.CharMatcher charMatcher2) {
            this.n = (com.google.common.base.CharMatcher) com.google.common.base.Preconditions.checkNotNull(charMatcher);
            this.t = (com.google.common.base.CharMatcher) com.google.common.base.Preconditions.checkNotNull(charMatcher2);
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @java.lang.Deprecated
        public /* bridge */ /* synthetic */ boolean apply(java.lang.Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        @com.google.common.annotations.GwtIncompatible
        public void g(java.util.BitSet bitSet) {
            this.n.g(bitSet);
            this.t.g(bitSet);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return this.n.matches(c) || this.t.matches(c);
        }

        @Override // com.google.common.base.CharMatcher
        public java.lang.String toString() {
            return "CharMatcher.or(" + this.n + ", " + this.t + ")";
        }
    }

    public static class RangesMatcher extends com.google.common.base.CharMatcher {
        public final java.lang.String n;
        public final char[] t;
        public final char[] u;

        public RangesMatcher(java.lang.String str, char[] cArr, char[] cArr2) {
            this.n = str;
            this.t = cArr;
            this.u = cArr2;
            com.google.common.base.Preconditions.checkArgument(cArr.length == cArr2.length);
            int i = 0;
            while (i < cArr.length) {
                com.google.common.base.Preconditions.checkArgument(cArr[i] <= cArr2[i]);
                int i2 = i + 1;
                if (i2 < cArr.length) {
                    com.google.common.base.Preconditions.checkArgument(cArr2[i] < cArr[i2]);
                }
                i = i2;
            }
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @java.lang.Deprecated
        public /* bridge */ /* synthetic */ boolean apply(java.lang.Character ch) {
            return super.apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            int binarySearch = java.util.Arrays.binarySearch(this.t, c);
            if (binarySearch >= 0) {
                return true;
            }
            int i = (~binarySearch) - 1;
            return i >= 0 && c <= this.u[i];
        }

        @Override // com.google.common.base.CharMatcher
        public java.lang.String toString() {
            return this.n;
        }
    }

    public static final class SingleWidth extends com.google.common.base.CharMatcher.RangesMatcher {
        public static final com.google.common.base.CharMatcher.SingleWidth v = new com.google.common.base.CharMatcher.SingleWidth();

        public SingleWidth() {
            super("CharMatcher.singleWidth()", "\u0000־א׳\u0600ݐ\u0e00Ḁ℀ﭐﹰ｡".toCharArray(), "ӹ־ת״ۿݿ\u0e7f₯℺﷿\ufeffￜ".toCharArray());
        }
    }

    @com.google.common.annotations.VisibleForTesting
    public static final class Whitespace extends com.google.common.base.CharMatcher.NamedFastMatcher {
        public static final int t = java.lang.Integer.numberOfLeadingZeros(31);
        public static final com.google.common.base.CharMatcher.Whitespace u = new com.google.common.base.CharMatcher.Whitespace();

        public Whitespace() {
            super("CharMatcher.whitespace()");
        }

        @Override // com.google.common.base.CharMatcher
        @com.google.common.annotations.GwtIncompatible
        public void g(java.util.BitSet bitSet) {
            for (int i = 0; i < 32; i++) {
                bitSet.set("\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001  \f\u2009\u3000\u2004\u3000\u3000\u2028\n \u3000".charAt(i));
            }
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return "\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001  \f\u2009\u3000\u2004\u3000\u3000\u2028\n \u3000".charAt((48906 * c) >>> t) == c;
        }
    }

    public static com.google.common.base.CharMatcher any() {
        return com.google.common.base.CharMatcher.Any.t;
    }

    public static com.google.common.base.CharMatcher anyOf(java.lang.CharSequence charSequence) {
        int length = charSequence.length();
        return length != 0 ? length != 1 ? length != 2 ? new com.google.common.base.CharMatcher.AnyOf(charSequence) : c(charSequence.charAt(0), charSequence.charAt(1)) : is(charSequence.charAt(0)) : none();
    }

    public static com.google.common.base.CharMatcher ascii() {
        return com.google.common.base.CharMatcher.Ascii.t;
    }

    public static com.google.common.base.CharMatcher breakingWhitespace() {
        return com.google.common.base.CharMatcher.BreakingWhitespace.n;
    }

    public static com.google.common.base.CharMatcher.IsEither c(char c, char c2) {
        return new com.google.common.base.CharMatcher.IsEither(c, c2);
    }

    @com.google.common.annotations.GwtIncompatible
    public static boolean d(int i, int i2) {
        return i <= 1023 && i2 > (i * 4) * 16;
    }

    @java.lang.Deprecated
    public static com.google.common.base.CharMatcher digit() {
        return com.google.common.base.CharMatcher.Digit.v;
    }

    @com.google.common.annotations.GwtIncompatible
    public static com.google.common.base.CharMatcher f(int i, java.util.BitSet bitSet, java.lang.String str) {
        if (i == 0) {
            return none();
        }
        if (i == 1) {
            return is((char) bitSet.nextSetBit(0));
        }
        if (i != 2) {
            return d(i, bitSet.length()) ? com.google.common.base.SmallCharMatcher.k(bitSet, str) : new com.google.common.base.CharMatcher.BitSetMatcher(bitSet, str, null);
        }
        char nextSetBit = (char) bitSet.nextSetBit(0);
        return c(nextSetBit, (char) bitSet.nextSetBit(nextSetBit + 1));
    }

    public static com.google.common.base.CharMatcher forPredicate(com.google.common.base.Predicate<? super java.lang.Character> predicate) {
        return predicate instanceof com.google.common.base.CharMatcher ? (com.google.common.base.CharMatcher) predicate : new com.google.common.base.CharMatcher.ForPredicate(predicate);
    }

    public static java.lang.String h(char c) {
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        for (int i = 0; i < 4; i++) {
            cArr[5 - i] = "0123456789ABCDEF".charAt(c & 15);
            c = (char) (c >> 4);
        }
        return java.lang.String.copyValueOf(cArr);
    }

    public static com.google.common.base.CharMatcher inRange(char c, char c2) {
        return new com.google.common.base.CharMatcher.InRange(c, c2);
    }

    @java.lang.Deprecated
    public static com.google.common.base.CharMatcher invisible() {
        return com.google.common.base.CharMatcher.Invisible.v;
    }

    public static com.google.common.base.CharMatcher is(char c) {
        return new com.google.common.base.CharMatcher.Is(c);
    }

    public static com.google.common.base.CharMatcher isNot(char c) {
        return new com.google.common.base.CharMatcher.IsNot(c);
    }

    @java.lang.Deprecated
    public static com.google.common.base.CharMatcher javaDigit() {
        return com.google.common.base.CharMatcher.JavaDigit.n;
    }

    public static com.google.common.base.CharMatcher javaIsoControl() {
        return com.google.common.base.CharMatcher.JavaIsoControl.t;
    }

    @java.lang.Deprecated
    public static com.google.common.base.CharMatcher javaLetter() {
        return com.google.common.base.CharMatcher.JavaLetter.n;
    }

    @java.lang.Deprecated
    public static com.google.common.base.CharMatcher javaLetterOrDigit() {
        return com.google.common.base.CharMatcher.JavaLetterOrDigit.n;
    }

    @java.lang.Deprecated
    public static com.google.common.base.CharMatcher javaLowerCase() {
        return com.google.common.base.CharMatcher.JavaLowerCase.n;
    }

    @java.lang.Deprecated
    public static com.google.common.base.CharMatcher javaUpperCase() {
        return com.google.common.base.CharMatcher.JavaUpperCase.n;
    }

    public static com.google.common.base.CharMatcher none() {
        return com.google.common.base.CharMatcher.None.t;
    }

    public static com.google.common.base.CharMatcher noneOf(java.lang.CharSequence charSequence) {
        return anyOf(charSequence).negate();
    }

    @java.lang.Deprecated
    public static com.google.common.base.CharMatcher singleWidth() {
        return com.google.common.base.CharMatcher.SingleWidth.v;
    }

    public static com.google.common.base.CharMatcher whitespace() {
        return com.google.common.base.CharMatcher.Whitespace.u;
    }

    public com.google.common.base.CharMatcher and(com.google.common.base.CharMatcher charMatcher) {
        return new com.google.common.base.CharMatcher.And(this, charMatcher);
    }

    @Override // com.google.common.base.Predicate
    @java.lang.Deprecated
    public boolean apply(java.lang.Character ch) {
        return matches(ch.charValue());
    }

    public final java.lang.String b(java.lang.CharSequence charSequence, int i, int i2, char c, java.lang.StringBuilder sb, boolean z) {
        while (i < i2) {
            char charAt = charSequence.charAt(i);
            if (!matches(charAt)) {
                sb.append(charAt);
                z = false;
            } else if (!z) {
                sb.append(c);
                z = true;
            }
            i++;
        }
        return sb.toString();
    }

    public java.lang.String collapseFrom(java.lang.CharSequence charSequence, char c) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (matches(charAt)) {
                if (charAt != c || (i != length - 1 && matches(charSequence.charAt(i + 1)))) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder(length);
                    sb.append(charSequence, 0, i);
                    sb.append(c);
                    return b(charSequence, i + 1, length, c, sb, true);
                }
                i++;
            }
            i++;
        }
        return charSequence.toString();
    }

    public int countIn(java.lang.CharSequence charSequence) {
        int i = 0;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            if (matches(charSequence.charAt(i2))) {
                i++;
            }
        }
        return i;
    }

    @com.google.common.annotations.GwtIncompatible
    public com.google.common.base.CharMatcher e() {
        java.lang.String str;
        java.util.BitSet bitSet = new java.util.BitSet();
        g(bitSet);
        int cardinality = bitSet.cardinality();
        if (cardinality * 2 <= 65536) {
            return f(cardinality, bitSet, toString());
        }
        bitSet.flip(0, 65536);
        int i = 65536 - cardinality;
        java.lang.String charMatcher = toString();
        if (charMatcher.endsWith(".negate()")) {
            str = charMatcher.substring(0, charMatcher.length() - 9);
        } else {
            str = charMatcher + ".negate()";
        }
        return new com.google.common.base.CharMatcher.AnonymousClass1(f(i, bitSet, str), charMatcher);
    }

    @com.google.common.annotations.GwtIncompatible
    public void g(java.util.BitSet bitSet) {
        for (int i = 65535; i >= 0; i--) {
            if (matches((char) i)) {
                bitSet.set(i);
            }
        }
    }

    public int indexIn(java.lang.CharSequence charSequence) {
        return indexIn(charSequence, 0);
    }

    public int indexIn(java.lang.CharSequence charSequence, int i) {
        int length = charSequence.length();
        com.google.common.base.Preconditions.checkPositionIndex(i, length);
        while (i < length) {
            if (matches(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public int lastIndexIn(java.lang.CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (matches(charSequence.charAt(length))) {
                return length;
            }
        }
        return -1;
    }

    public abstract boolean matches(char c);

    public boolean matchesAllOf(java.lang.CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!matches(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }

    public boolean matchesAnyOf(java.lang.CharSequence charSequence) {
        return !matchesNoneOf(charSequence);
    }

    public boolean matchesNoneOf(java.lang.CharSequence charSequence) {
        return indexIn(charSequence) == -1;
    }

    public com.google.common.base.CharMatcher negate() {
        return new com.google.common.base.CharMatcher.Negated(this);
    }

    public com.google.common.base.CharMatcher or(com.google.common.base.CharMatcher charMatcher) {
        return new com.google.common.base.CharMatcher.Or(this, charMatcher);
    }

    public com.google.common.base.CharMatcher precomputed() {
        return com.google.common.base.Platform.h(this);
    }

    public java.lang.String removeFrom(java.lang.CharSequence charSequence) {
        java.lang.String charSequence2 = charSequence.toString();
        int indexIn = indexIn(charSequence2);
        if (indexIn == -1) {
            return charSequence2;
        }
        char[] charArray = charSequence2.toCharArray();
        int i = 1;
        while (true) {
            indexIn++;
            while (indexIn != charArray.length) {
                if (matches(charArray[indexIn])) {
                    break;
                }
                charArray[indexIn - i] = charArray[indexIn];
                indexIn++;
            }
            return new java.lang.String(charArray, 0, indexIn - i);
            i++;
        }
    }

    public java.lang.String replaceFrom(java.lang.CharSequence charSequence, char c) {
        java.lang.String charSequence2 = charSequence.toString();
        int indexIn = indexIn(charSequence2);
        if (indexIn == -1) {
            return charSequence2;
        }
        char[] charArray = charSequence2.toCharArray();
        charArray[indexIn] = c;
        while (true) {
            indexIn++;
            if (indexIn >= charArray.length) {
                return new java.lang.String(charArray);
            }
            if (matches(charArray[indexIn])) {
                charArray[indexIn] = c;
            }
        }
    }

    public java.lang.String replaceFrom(java.lang.CharSequence charSequence, java.lang.CharSequence charSequence2) {
        int length = charSequence2.length();
        if (length == 0) {
            return removeFrom(charSequence);
        }
        int i = 0;
        if (length == 1) {
            return replaceFrom(charSequence, charSequence2.charAt(0));
        }
        java.lang.String charSequence3 = charSequence.toString();
        int indexIn = indexIn(charSequence3);
        if (indexIn == -1) {
            return charSequence3;
        }
        int length2 = charSequence3.length();
        java.lang.StringBuilder sb = new java.lang.StringBuilder(((length2 * 3) / 2) + 16);
        do {
            sb.append((java.lang.CharSequence) charSequence3, i, indexIn);
            sb.append(charSequence2);
            i = indexIn + 1;
            indexIn = indexIn(charSequence3, i);
        } while (indexIn != -1);
        sb.append((java.lang.CharSequence) charSequence3, i, length2);
        return sb.toString();
    }

    public java.lang.String retainFrom(java.lang.CharSequence charSequence) {
        return negate().removeFrom(charSequence);
    }

    public java.lang.String toString() {
        return super.toString();
    }

    public java.lang.String trimAndCollapseFrom(java.lang.CharSequence charSequence, char c) {
        int length = charSequence.length();
        int i = length - 1;
        int i2 = 0;
        while (i2 < length && matches(charSequence.charAt(i2))) {
            i2++;
        }
        int i3 = i;
        while (i3 > i2 && matches(charSequence.charAt(i3))) {
            i3--;
        }
        if (i2 == 0 && i3 == i) {
            return collapseFrom(charSequence, c);
        }
        int i4 = i3 + 1;
        return b(charSequence, i2, i4, c, new java.lang.StringBuilder(i4 - i2), false);
    }

    public java.lang.String trimFrom(java.lang.CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        while (i < length && matches(charSequence.charAt(i))) {
            i++;
        }
        int i2 = length - 1;
        while (i2 > i && matches(charSequence.charAt(i2))) {
            i2--;
        }
        return charSequence.subSequence(i, i2 + 1).toString();
    }

    public java.lang.String trimLeadingFrom(java.lang.CharSequence charSequence) {
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            if (!matches(charSequence.charAt(i))) {
                return charSequence.subSequence(i, length).toString();
            }
        }
        return "";
    }

    public java.lang.String trimTrailingFrom(java.lang.CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!matches(charSequence.charAt(length))) {
                return charSequence.subSequence(0, length + 1).toString();
            }
        }
        return "";
    }
}
