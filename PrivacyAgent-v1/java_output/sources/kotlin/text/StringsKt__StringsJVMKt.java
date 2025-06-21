package kotlin.text;

/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.Metadata(d1 = {"\u0000X\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a \u0010\u0004\u001a\u00020\u0002*\u0004\u0018\u00010\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u001a$\u0010\b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u001a$\u0010\b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u001a$\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u001a$\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u001a\f\u0010\r\u001a\u00020\u0000*\u00020\fH\u0007\u001a \u0010\r\u001a\u00020\u0000*\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000eH\u0007\u001a \u0010\u0011\u001a\u00020\f*\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000eH\u0007\u001a\f\u0010\u0013\u001a\u00020\u0000*\u00020\u0012H\u0007\u001a*\u0010\u0013\u001a\u00020\u0000*\u00020\u00122\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u0002H\u0007\u001a\f\u0010\u0015\u001a\u00020\u0012*\u00020\u0000H\u0007\u001a*\u0010\u0015\u001a\u00020\u0012*\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u0002H\u0007\u001a\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00000\u001a*\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u000e\u001a\u001c\u0010\u001d\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u001a$\u0010\u001d\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u001a\u001c\u0010\u001f\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u001a\u001c\u0010 \u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u001a\u0019\u0010!\u001a\u00020\u0002*\u0004\u0018\u00010\u00162\b\u0010\u0001\u001a\u0004\u0018\u00010\u0016H\u0087\u0004\u001a \u0010!\u001a\u00020\u0002*\u0004\u0018\u00010\u00162\b\u0010\u0001\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u001a\n\u0010\"\u001a\u00020\u0002*\u00020\u0016\u001a4\u0010&\u001a\u00020\u0002*\u00020\u00162\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010\u0001\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e2\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u001a4\u0010&\u001a\u00020\u0002*\u00020\u00002\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u000e2\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u001a\f\u0010'\u001a\u00020\u0000*\u00020\u0000H\u0007\u001a\u0014\u0010'\u001a\u00020\u0000*\u00020\u00002\u0006\u0010)\u001a\u00020(H\u0007\u001a\f\u0010*\u001a\u00020\u0000*\u00020\u0000H\u0007\u001a\u0014\u0010*\u001a\u00020\u0000*\u00020\u00002\u0006\u0010)\u001a\u00020(H\u0007\u001a\u0012\u0010,\u001a\u00020\u0000*\u00020\u00162\u0006\u0010+\u001a\u00020\u000e\"%\u00102\u001a\u0012\u0012\u0004\u0012\u00020\u00000.j\b\u0012\u0004\u0012\u00020\u0000`/*\u00020-8F¢\u0006\u0006\u001a\u0004\b0\u00101¨\u00063"}, d2 = {"", "other", "", "ignoreCase", "equals", "", "oldChar", "newChar", org.apache.tools.ant.taskdefs.optional.vss.MSVSSConstants.WRITABLE_REPLACE, "oldValue", "newValue", "replaceFirst", "", "concatToString", "", "startIndex", "endIndex", "toCharArray", "", "decodeToString", "throwOnInvalidSequence", "encodeToByteArray", "", "Ljava/util/regex/Pattern;", org.apache.tools.ant.types.selectors.FilenameSelector.REGEX_KEY, "limit", "", "split", com.alibaba.sdk.android.oss.common.RequestParameters.PREFIX, "startsWith", "suffix", "endsWith", "compareTo", "contentEquals", "isBlank", "thisOffset", "otherOffset", "length", "regionMatches", "capitalize", "Ljava/util/Locale;", "locale", "decapitalize", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "repeat", "Lkotlin/String$Companion;", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "getCASE_INSENSITIVE_ORDER", "(Lkotlin/jvm/internal/StringCompanionObject;)Ljava/util/Comparator;", "CASE_INSENSITIVE_ORDER", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/text/StringsKt")
/* loaded from: classes14.dex */
public class StringsKt__StringsJVMKt extends kotlin.text.StringsKt__StringNumberConversionsKt {
    @kotlin.Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @kotlin.ReplaceWith(expression = "replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }", imports = {"java.util.Locale"}))
    @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String capitalize(@org.jetbrains.annotations.NotNull java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        java.util.Locale locale = java.util.Locale.getDefault();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        return capitalize(str, locale);
    }

    @kotlin.SinceKotlin(version = "1.4")
    @org.jetbrains.annotations.NotNull
    @kotlin.Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @kotlin.ReplaceWith(expression = "replaceFirstChar { if (it.isLowerCase()) it.titlecase(locale) else it.toString() }", imports = {}))
    @kotlin.internal.LowPriorityInOverloadResolution
    @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalStdlibApi.class})
    public static final java.lang.String capitalize(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull java.util.Locale locale) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(locale, "locale");
        if (!(str.length() > 0)) {
            return str;
        }
        char charAt = str.charAt(0);
        if (!java.lang.Character.isLowerCase(charAt)) {
            return str;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        char titleCase = java.lang.Character.toTitleCase(charAt);
        if (titleCase != java.lang.Character.toUpperCase(charAt)) {
            sb.append(titleCase);
        } else {
            java.lang.String substring = str.substring(0, 1);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            kotlin.jvm.internal.Intrinsics.checkNotNull(substring, "null cannot be cast to non-null type java.lang.String");
            java.lang.String upperCase = substring.toUpperCase(locale);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
            sb.append(upperCase);
        }
        java.lang.String substring2 = str.substring(1);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
        sb.append(substring2);
        java.lang.String sb2 = sb.toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static final int compareTo(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull java.lang.String other, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        return z ? str.compareToIgnoreCase(other) : str.compareTo(other);
    }

    public static /* synthetic */ int compareTo$default(java.lang.String str, java.lang.String str2, boolean z, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return compareTo(str, str2, z);
    }

    @kotlin.SinceKotlin(version = "1.4")
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalStdlibApi.class})
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String concatToString(@org.jetbrains.annotations.NotNull char[] cArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cArr, "<this>");
        return new java.lang.String(cArr);
    }

    @kotlin.SinceKotlin(version = "1.4")
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalStdlibApi.class})
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String concatToString(@org.jetbrains.annotations.NotNull char[] cArr, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(cArr, "<this>");
        kotlin.collections.AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i, i2, cArr.length);
        return new java.lang.String(cArr, i, i2 - i);
    }

    public static /* synthetic */ java.lang.String concatToString$default(char[] cArr, int i, int i2, int i3, java.lang.Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = cArr.length;
        }
        return concatToString(cArr, i, i2);
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    public static final boolean contentEquals(@org.jetbrains.annotations.Nullable java.lang.CharSequence charSequence, @org.jetbrains.annotations.Nullable java.lang.CharSequence charSequence2) {
        return (!(charSequence instanceof java.lang.String) || charSequence2 == null) ? kotlin.text.StringsKt__StringsKt.contentEqualsImpl(charSequence, charSequence2) : ((java.lang.String) charSequence).contentEquals(charSequence2);
    }

    @kotlin.SinceKotlin(version = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    public static final boolean contentEquals(@org.jetbrains.annotations.Nullable java.lang.CharSequence charSequence, @org.jetbrains.annotations.Nullable java.lang.CharSequence charSequence2, boolean z) {
        return z ? kotlin.text.StringsKt__StringsKt.contentEqualsIgnoreCaseImpl(charSequence, charSequence2) : contentEquals(charSequence, charSequence2);
    }

    @kotlin.Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @kotlin.ReplaceWith(expression = "replaceFirstChar { it.lowercase(Locale.getDefault()) }", imports = {"java.util.Locale"}))
    @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String decapitalize(@org.jetbrains.annotations.NotNull java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        if (!(str.length() > 0) || java.lang.Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String substring = str.substring(0, 1);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        kotlin.jvm.internal.Intrinsics.checkNotNull(substring, "null cannot be cast to non-null type java.lang.String");
        java.lang.String lowerCase = substring.toLowerCase();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        sb.append(lowerCase);
        java.lang.String substring2 = str.substring(1);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
        sb.append(substring2);
        return sb.toString();
    }

    @kotlin.SinceKotlin(version = "1.4")
    @org.jetbrains.annotations.NotNull
    @kotlin.Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @kotlin.ReplaceWith(expression = "replaceFirstChar { it.lowercase(locale) }", imports = {}))
    @kotlin.internal.LowPriorityInOverloadResolution
    @kotlin.DeprecatedSinceKotlin(warningSince = org.apache.tools.ant.util.JavaEnvUtils.JAVA_1_5)
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalStdlibApi.class})
    public static final java.lang.String decapitalize(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull java.util.Locale locale) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(locale, "locale");
        if (!(str.length() > 0) || java.lang.Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String substring = str.substring(0, 1);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        kotlin.jvm.internal.Intrinsics.checkNotNull(substring, "null cannot be cast to non-null type java.lang.String");
        java.lang.String lowerCase = substring.toLowerCase(locale);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        sb.append(lowerCase);
        java.lang.String substring2 = str.substring(1);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
        sb.append(substring2);
        return sb.toString();
    }

    @kotlin.SinceKotlin(version = "1.4")
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalStdlibApi.class})
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String decodeToString(@org.jetbrains.annotations.NotNull byte[] bArr) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bArr, "<this>");
        return new java.lang.String(bArr, kotlin.text.Charsets.UTF_8);
    }

    @kotlin.SinceKotlin(version = "1.4")
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalStdlibApi.class})
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String decodeToString(@org.jetbrains.annotations.NotNull byte[] bArr, int i, int i2, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bArr, "<this>");
        kotlin.collections.AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i, i2, bArr.length);
        if (!z) {
            return new java.lang.String(bArr, i, i2 - i, kotlin.text.Charsets.UTF_8);
        }
        java.lang.String charBuffer = kotlin.text.Charsets.UTF_8.newDecoder().onMalformedInput(java.nio.charset.CodingErrorAction.REPORT).onUnmappableCharacter(java.nio.charset.CodingErrorAction.REPORT).decode(java.nio.ByteBuffer.wrap(bArr, i, i2 - i)).toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(charBuffer, "decoder.decode(ByteBuffe…- startIndex)).toString()");
        return charBuffer;
    }

    public static /* synthetic */ java.lang.String decodeToString$default(byte[] bArr, int i, int i2, boolean z, int i3, java.lang.Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return decodeToString(bArr, i, i2, z);
    }

    @kotlin.SinceKotlin(version = "1.4")
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalStdlibApi.class})
    @org.jetbrains.annotations.NotNull
    public static final byte[] encodeToByteArray(@org.jetbrains.annotations.NotNull java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] bytes = str.getBytes(kotlin.text.Charsets.UTF_8);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    @kotlin.SinceKotlin(version = "1.4")
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalStdlibApi.class})
    @org.jetbrains.annotations.NotNull
    public static final byte[] encodeToByteArray(@org.jetbrains.annotations.NotNull java.lang.String str, int i, int i2, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.collections.AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i, i2, str.length());
        if (!z) {
            java.lang.String substring = str.substring(i, i2);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            java.nio.charset.Charset charset = kotlin.text.Charsets.UTF_8;
            kotlin.jvm.internal.Intrinsics.checkNotNull(substring, "null cannot be cast to non-null type java.lang.String");
            byte[] bytes = substring.getBytes(charset);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            return bytes;
        }
        java.nio.ByteBuffer encode = kotlin.text.Charsets.UTF_8.newEncoder().onMalformedInput(java.nio.charset.CodingErrorAction.REPORT).onUnmappableCharacter(java.nio.charset.CodingErrorAction.REPORT).encode(java.nio.CharBuffer.wrap(str, i, i2));
        if (encode.hasArray() && encode.arrayOffset() == 0) {
            int remaining = encode.remaining();
            byte[] array = encode.array();
            kotlin.jvm.internal.Intrinsics.checkNotNull(array);
            if (remaining == array.length) {
                byte[] array2 = encode.array();
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(array2, "{\n        byteBuffer.array()\n    }");
                return array2;
            }
        }
        byte[] bArr = new byte[encode.remaining()];
        encode.get(bArr);
        return bArr;
    }

    public static /* synthetic */ byte[] encodeToByteArray$default(java.lang.String str, int i, int i2, boolean z, int i3, java.lang.Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return encodeToByteArray(str, i, i2, z);
    }

    public static boolean endsWith(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull java.lang.String suffix, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(suffix, "suffix");
        return !z ? str.endsWith(suffix) : regionMatches(str, str.length() - suffix.length(), suffix, 0, suffix.length(), true);
    }

    public static /* synthetic */ boolean endsWith$default(java.lang.String str, java.lang.String str2, boolean z, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return endsWith(str, str2, z);
    }

    public static boolean equals(@org.jetbrains.annotations.Nullable java.lang.String str, @org.jetbrains.annotations.Nullable java.lang.String str2, boolean z) {
        return str == null ? str2 == null : !z ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static /* synthetic */ boolean equals$default(java.lang.String str, java.lang.String str2, boolean z, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return equals(str, str2, z);
    }

    @org.jetbrains.annotations.NotNull
    public static final java.util.Comparator<java.lang.String> getCASE_INSENSITIVE_ORDER(@org.jetbrains.annotations.NotNull kotlin.jvm.internal.StringCompanionObject stringCompanionObject) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(stringCompanionObject, "<this>");
        java.util.Comparator<java.lang.String> CASE_INSENSITIVE_ORDER = java.lang.String.CASE_INSENSITIVE_ORDER;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(CASE_INSENSITIVE_ORDER, "CASE_INSENSITIVE_ORDER");
        return CASE_INSENSITIVE_ORDER;
    }

    public static boolean isBlank(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence) {
        boolean z;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return true;
        }
        java.lang.Iterable indices = kotlin.text.StringsKt__StringsKt.getIndices(charSequence);
        if (!(indices instanceof java.util.Collection) || !((java.util.Collection) indices).isEmpty()) {
            java.util.Iterator it = indices.iterator();
            while (it.hasNext()) {
                if (!kotlin.text.CharsKt__CharJVMKt.isWhitespace(charSequence.charAt(((kotlin.collections.IntIterator) it).nextInt()))) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        return z;
    }

    public static final boolean regionMatches(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, int i, @org.jetbrains.annotations.NotNull java.lang.CharSequence other, int i2, int i3, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        return ((charSequence instanceof java.lang.String) && (other instanceof java.lang.String)) ? regionMatches((java.lang.String) charSequence, i, (java.lang.String) other, i2, i3, z) : kotlin.text.StringsKt__StringsKt.regionMatchesImpl(charSequence, i, other, i2, i3, z);
    }

    public static boolean regionMatches(@org.jetbrains.annotations.NotNull java.lang.String str, int i, @org.jetbrains.annotations.NotNull java.lang.String other, int i2, int i3, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        return !z ? str.regionMatches(i, other, i2, i3) : str.regionMatches(z, i, other, i2, i3);
    }

    /* JADX WARN: Type inference failed for: r5v3, types: [java.util.Iterator, kotlin.collections.IntIterator] */
    @org.jetbrains.annotations.NotNull
    public static java.lang.String repeat(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (!(i >= 0)) {
            throw new java.lang.IllegalArgumentException(("Count 'n' must be non-negative, but was " + i + '.').toString());
        }
        if (i == 0) {
            return "";
        }
        if (i == 1) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            char charAt = charSequence.charAt(0);
            char[] cArr = new char[i];
            for (int i2 = 0; i2 < i; i2++) {
                cArr[i2] = charAt;
            }
            return new java.lang.String(cArr);
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(charSequence.length() * i);
        ?? it = new kotlin.ranges.IntRange(1, i).iterator();
        while (it.hasNext()) {
            it.nextInt();
            sb.append(charSequence);
        }
        java.lang.String sb2 = sb.toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(sb2, "{\n                    va…tring()\n                }");
        return sb2;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String replace(@org.jetbrains.annotations.NotNull java.lang.String str, char c, char c2, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        if (!z) {
            java.lang.String replace = str.replace(c, c2);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(replace, "this as java.lang.String…replace(oldChar, newChar)");
            return replace;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (kotlin.text.CharsKt__CharKt.equals(charAt, c, z)) {
                charAt = c2;
            }
            sb.append(charAt);
        }
        java.lang.String sb2 = sb.toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String replace(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull java.lang.String oldValue, @org.jetbrains.annotations.NotNull java.lang.String newValue, boolean z) {
        int coerceAtLeast;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(oldValue, "oldValue");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newValue, "newValue");
        int i = 0;
        int indexOf = kotlin.text.StringsKt__StringsKt.indexOf(str, oldValue, 0, z);
        if (indexOf < 0) {
            return str;
        }
        int length = oldValue.length();
        coerceAtLeast = kotlin.ranges.RangesKt___RangesKt.coerceAtLeast(length, 1);
        int length2 = (str.length() - length) + newValue.length();
        if (length2 < 0) {
            throw new java.lang.OutOfMemoryError();
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(length2);
        do {
            sb.append((java.lang.CharSequence) str, i, indexOf);
            sb.append(newValue);
            i = indexOf + length;
            if (indexOf >= str.length()) {
                break;
            }
            indexOf = kotlin.text.StringsKt__StringsKt.indexOf(str, oldValue, indexOf + coerceAtLeast, z);
        } while (indexOf > 0);
        sb.append((java.lang.CharSequence) str, i, str.length());
        java.lang.String sb2 = sb.toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(sb2, "stringBuilder.append(this, i, length).toString()");
        return sb2;
    }

    public static /* synthetic */ java.lang.String replace$default(java.lang.String str, char c, char c2, boolean z, int i, java.lang.Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return replace(str, c, c2, z);
    }

    public static /* synthetic */ java.lang.String replace$default(java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z, int i, java.lang.Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return replace(str, str2, str3, z);
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String replaceFirst(@org.jetbrains.annotations.NotNull java.lang.String str, char c, char c2, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        int indexOf$default = kotlin.text.StringsKt__StringsKt.indexOf$default(str, c, 0, z, 2, (java.lang.Object) null);
        return indexOf$default < 0 ? str : kotlin.text.StringsKt__StringsKt.replaceRange(str, indexOf$default, indexOf$default + 1, java.lang.String.valueOf(c2)).toString();
    }

    @org.jetbrains.annotations.NotNull
    public static java.lang.String replaceFirst(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull java.lang.String oldValue, @org.jetbrains.annotations.NotNull java.lang.String newValue, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(oldValue, "oldValue");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newValue, "newValue");
        int indexOf$default = kotlin.text.StringsKt__StringsKt.indexOf$default(str, oldValue, 0, z, 2, (java.lang.Object) null);
        return indexOf$default < 0 ? str : kotlin.text.StringsKt__StringsKt.replaceRange(str, indexOf$default, oldValue.length() + indexOf$default, newValue).toString();
    }

    public static /* synthetic */ java.lang.String replaceFirst$default(java.lang.String str, char c, char c2, boolean z, int i, java.lang.Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return replaceFirst(str, c, c2, z);
    }

    public static /* synthetic */ java.lang.String replaceFirst$default(java.lang.String str, java.lang.String str2, java.lang.String str3, boolean z, int i, java.lang.Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return replaceFirst(str, str2, str3, z);
    }

    @org.jetbrains.annotations.NotNull
    public static final java.util.List<java.lang.String> split(@org.jetbrains.annotations.NotNull java.lang.CharSequence charSequence, @org.jetbrains.annotations.NotNull java.util.regex.Pattern regex, int i) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(charSequence, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(regex, "regex");
        kotlin.text.StringsKt__StringsKt.requireNonNegativeLimit(i);
        if (i == 0) {
            i = -1;
        }
        java.lang.String[] split = regex.split(charSequence, i);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(split, "regex.split(this, if (limit == 0) -1 else limit)");
        return kotlin.collections.ArraysKt___ArraysJvmKt.asList(split);
    }

    public static /* synthetic */ java.util.List split$default(java.lang.CharSequence charSequence, java.util.regex.Pattern pattern, int i, int i2, java.lang.Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return split(charSequence, pattern, i);
    }

    public static final boolean startsWith(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull java.lang.String prefix, int i, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(prefix, "prefix");
        return !z ? str.startsWith(prefix, i) : regionMatches(str, i, prefix, 0, prefix.length(), z);
    }

    public static final boolean startsWith(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull java.lang.String prefix, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(prefix, "prefix");
        return !z ? str.startsWith(prefix) : regionMatches(str, 0, prefix, 0, prefix.length(), z);
    }

    public static /* synthetic */ boolean startsWith$default(java.lang.String str, java.lang.String str2, int i, boolean z, int i2, java.lang.Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return startsWith(str, str2, i, z);
    }

    public static /* synthetic */ boolean startsWith$default(java.lang.String str, java.lang.String str2, boolean z, int i, java.lang.Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return startsWith(str, str2, z);
    }

    @kotlin.SinceKotlin(version = "1.4")
    @kotlin.WasExperimental(markerClass = {kotlin.ExperimentalStdlibApi.class})
    @org.jetbrains.annotations.NotNull
    public static final char[] toCharArray(@org.jetbrains.annotations.NotNull java.lang.String str, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.collections.AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i, i2, str.length());
        char[] cArr = new char[i2 - i];
        str.getChars(i, i2, cArr, 0);
        return cArr;
    }

    public static /* synthetic */ char[] toCharArray$default(java.lang.String str, int i, int i2, int i3, java.lang.Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return toCharArray(str, i, i2);
    }
}
