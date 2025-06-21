package kotlin.text;

@kotlin.Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\u0007\u001a\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0006\u001a\f\u0010\u0007\u001a\u00020\u0000*\u00020\u0001H\u0007\u001a\u0014\u0010\u0007\u001a\u00020\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007\u001a\f\u0010\t\u001a\u00020\b*\u00020\u0000H\u0007\u001a\u001c\u0010\r\u001a\u00020\u000b*\u00020\u00002\u0006\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u000b\u001a\n\u0010\u000e\u001a\u00020\u000b*\u00020\u0000¨\u0006\u000f"}, d2 = {"", "", "digitToInt", "radix", "digitToIntOrNull", "(C)Ljava/lang/Integer;", "(CI)Ljava/lang/Integer;", "digitToChar", "", "titlecase", "other", "", "ignoreCase", "equals", "isSurrogate", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/text/CharsKt")
/* loaded from: classes14.dex */
class CharsKt__CharKt extends kotlin.text.CharsKt__CharJVMKt {
    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalStdlibApi.class})
    public static final char digitToChar(int i) {
        if (new kotlin.ranges.IntRange(0, 9).contains(i)) {
            return (char) (i + 48);
        }
        throw new java.lang.IllegalArgumentException("Int " + i + " is not a decimal digit");
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalStdlibApi.class})
    public static final char digitToChar(int i, int i2) {
        if (!new kotlin.ranges.IntRange(2, 36).contains(i2)) {
            throw new java.lang.IllegalArgumentException("Invalid radix: " + i2 + ". Valid radix values are in range 2..36");
        }
        if (i >= 0 && i < i2) {
            return (char) (i < 10 ? i + 48 : ((char) (i + 65)) - '\n');
        }
        throw new java.lang.IllegalArgumentException("Digit " + i + " does not represent a valid digit in radix " + i2);
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalStdlibApi.class})
    public static final int digitToInt(char c) {
        int digitOf = kotlin.text.CharsKt__CharJVMKt.digitOf(c, 10);
        if (digitOf >= 0) {
            return digitOf;
        }
        throw new java.lang.IllegalArgumentException("Char " + c + " is not a decimal digit");
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalStdlibApi.class})
    public static final int digitToInt(char c, int i) {
        java.lang.Integer digitToIntOrNull = digitToIntOrNull(c, i);
        if (digitToIntOrNull != null) {
            return digitToIntOrNull.intValue();
        }
        throw new java.lang.IllegalArgumentException("Char " + c + " is not a digit in the given radix=" + i);
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalStdlibApi.class})
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Integer digitToIntOrNull(char c) {
        java.lang.Integer valueOf = java.lang.Integer.valueOf(kotlin.text.CharsKt__CharJVMKt.digitOf(c, 10));
        if (valueOf.intValue() >= 0) {
            return valueOf;
        }
        return null;
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalStdlibApi.class})
    @org.jetbrains.annotations.Nullable
    public static final java.lang.Integer digitToIntOrNull(char c, int i) {
        kotlin.text.CharsKt__CharJVMKt.checkRadix(i);
        java.lang.Integer valueOf = java.lang.Integer.valueOf(kotlin.text.CharsKt__CharJVMKt.digitOf(c, i));
        if (valueOf.intValue() >= 0) {
            return valueOf;
        }
        return null;
    }

    public static final boolean equals(char c, char c2, boolean z) {
        if (c == c2) {
            return true;
        }
        if (!z) {
            return false;
        }
        char upperCase = java.lang.Character.toUpperCase(c);
        char upperCase2 = java.lang.Character.toUpperCase(c2);
        return upperCase == upperCase2 || java.lang.Character.toLowerCase(upperCase) == java.lang.Character.toLowerCase(upperCase2);
    }

    public static /* synthetic */ boolean equals$default(char c, char c2, boolean z, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return equals(c, c2, z);
    }

    public static final boolean isSurrogate(char c) {
        return new kotlin.ranges.CharRange((char) 55296, (char) 57343).contains(c);
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String titlecase(char c) {
        return kotlin.text._OneToManyTitlecaseMappingsKt.titlecaseImpl(c);
    }
}
