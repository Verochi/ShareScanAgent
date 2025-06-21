package kotlin.text;

/* JADX INFO: Access modifiers changed from: package-private */
@kotlin.Metadata(d1 = {"\u0000\u0018\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0001\u001a\u00020\u0000\u001a\u001e\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00002\b\b\u0002\u0010\u0001\u001a\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0000*\u00020\u0000\u001a\u0014\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0000\u001a\u0014\u0010\b\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u0000\u001a\u0013\u0010\n\u001a\u00020\t*\u00020\u0000H\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a#\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\f2\u0006\u0010\u0007\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"", "marginPrefix", "trimMargin", "newIndent", "replaceIndentByMargin", "trimIndent", "replaceIndent", "indent", "prependIndent", "", "b", "(Ljava/lang/String;)I", "Lkotlin/Function1;", "a", "(Ljava/lang/String;)Lkotlin/jvm/functions/Function1;", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/text/StringsKt")
/* loaded from: classes14.dex */
public class StringsKt__IndentKt extends kotlin.text.StringsKt__AppendableKt {
    public static final kotlin.jvm.functions.Function1<java.lang.String, java.lang.String> a(java.lang.String str) {
        return str.length() == 0 ? kotlin.text.StringsKt__IndentKt$getIndentFunction$1.INSTANCE : new kotlin.text.StringsKt__IndentKt$getIndentFunction$2(str);
    }

    public static final int b(java.lang.String str) {
        int length = str.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            }
            if (!kotlin.text.CharsKt__CharJVMKt.isWhitespace(str.charAt(i))) {
                break;
            }
            i++;
        }
        return i == -1 ? str.length() : i;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String prependIndent(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull java.lang.String indent) {
        java.lang.String joinToString$default;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(indent, "indent");
        joinToString$default = kotlin.sequences.SequencesKt___SequencesKt.joinToString$default(kotlin.sequences.SequencesKt___SequencesKt.map(kotlin.text.StringsKt__StringsKt.lineSequence(str), new kotlin.text.StringsKt__IndentKt$prependIndent$1(indent)), "\n", null, null, 0, null, null, 62, null);
        return joinToString$default;
    }

    public static /* synthetic */ java.lang.String prependIndent$default(java.lang.String str, java.lang.String str2, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            str2 = "    ";
        }
        return prependIndent(str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00bf A[SYNTHETIC] */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final java.lang.String replaceIndent(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull java.lang.String newIndent) {
        boolean isBlank;
        java.lang.String drop;
        java.lang.String invoke;
        boolean isBlank2;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newIndent, "newIndent");
        java.util.List<java.lang.String> lines = kotlin.text.StringsKt__StringsKt.lines(str);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (java.lang.Object obj : lines) {
            isBlank2 = kotlin.text.StringsKt__StringsJVMKt.isBlank((java.lang.String) obj);
            if (!isBlank2) {
                arrayList.add(obj);
            }
        }
        java.util.ArrayList arrayList2 = new java.util.ArrayList(kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(java.lang.Integer.valueOf(b((java.lang.String) it.next())));
        }
        java.lang.Integer num = (java.lang.Integer) kotlin.collections.CollectionsKt___CollectionsKt.minOrNull((java.lang.Iterable) arrayList2);
        int i = 0;
        int intValue = num != null ? num.intValue() : 0;
        int length = str.length() + (newIndent.length() * lines.size());
        kotlin.jvm.functions.Function1<java.lang.String, java.lang.String> a = a(newIndent);
        int lastIndex = kotlin.collections.CollectionsKt__CollectionsKt.getLastIndex(lines);
        java.util.ArrayList arrayList3 = new java.util.ArrayList();
        for (java.lang.Object obj2 : lines) {
            int i2 = i + 1;
            if (i < 0) {
                kotlin.collections.CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            java.lang.String str2 = (java.lang.String) obj2;
            if (i == 0 || i == lastIndex) {
                isBlank = kotlin.text.StringsKt__StringsJVMKt.isBlank(str2);
                if (isBlank) {
                    str2 = null;
                    if (str2 == null) {
                        arrayList3.add(str2);
                    }
                    i = i2;
                }
            }
            drop = kotlin.text.StringsKt___StringsKt.drop(str2, intValue);
            if (drop != null && (invoke = a.invoke(drop)) != null) {
                str2 = invoke;
            }
            if (str2 == null) {
            }
            i = i2;
        }
        java.lang.String sb = ((java.lang.StringBuilder) kotlin.collections.CollectionsKt___CollectionsKt.joinTo$default(arrayList3, new java.lang.StringBuilder(length), "\n", null, null, 0, null, null, 124, null)).toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return sb;
    }

    public static /* synthetic */ java.lang.String replaceIndent$default(java.lang.String str, java.lang.String str2, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            str2 = "";
        }
        return replaceIndent(str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bb A[SYNTHETIC] */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final java.lang.String replaceIndentByMargin(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull java.lang.String newIndent, @org.jetbrains.annotations.NotNull java.lang.String marginPrefix) {
        boolean isBlank;
        boolean isBlank2;
        int i;
        java.lang.String invoke;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(newIndent, "newIndent");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(marginPrefix, "marginPrefix");
        isBlank = kotlin.text.StringsKt__StringsJVMKt.isBlank(marginPrefix);
        if (!(!isBlank)) {
            throw new java.lang.IllegalArgumentException("marginPrefix must be non-blank string.".toString());
        }
        java.util.List<java.lang.String> lines = kotlin.text.StringsKt__StringsKt.lines(str);
        int length = str.length() + (newIndent.length() * lines.size());
        kotlin.jvm.functions.Function1<java.lang.String, java.lang.String> a = a(newIndent);
        int lastIndex = kotlin.collections.CollectionsKt__CollectionsKt.getLastIndex(lines);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int i2 = 0;
        for (java.lang.Object obj : lines) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                kotlin.collections.CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            java.lang.String str2 = (java.lang.String) obj;
            java.lang.String str3 = null;
            if (i2 == 0 || i2 == lastIndex) {
                isBlank2 = kotlin.text.StringsKt__StringsJVMKt.isBlank(str2);
                if (isBlank2) {
                    str2 = null;
                    if (str2 == null) {
                        arrayList.add(str2);
                    }
                    i2 = i3;
                }
            }
            int length2 = str2.length();
            int i4 = 0;
            while (true) {
                if (i4 >= length2) {
                    i = -1;
                    break;
                }
                if (!kotlin.text.CharsKt__CharJVMKt.isWhitespace(str2.charAt(i4))) {
                    i = i4;
                    break;
                }
                i4++;
            }
            if (i != -1) {
                int i5 = i;
                if (kotlin.text.StringsKt__StringsJVMKt.startsWith$default(str2, marginPrefix, i, false, 4, null)) {
                    int length3 = i5 + marginPrefix.length();
                    kotlin.jvm.internal.Intrinsics.checkNotNull(str2, "null cannot be cast to non-null type java.lang.String");
                    str3 = str2.substring(length3);
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(str3, "this as java.lang.String).substring(startIndex)");
                }
            }
            if (str3 != null && (invoke = a.invoke(str3)) != null) {
                str2 = invoke;
            }
            if (str2 == null) {
            }
            i2 = i3;
        }
        java.lang.String sb = ((java.lang.StringBuilder) kotlin.collections.CollectionsKt___CollectionsKt.joinTo$default(arrayList, new java.lang.StringBuilder(length), "\n", null, null, 0, null, null, 124, null)).toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return sb;
    }

    public static /* synthetic */ java.lang.String replaceIndentByMargin$default(java.lang.String str, java.lang.String str2, java.lang.String str3, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            str2 = "";
        }
        if ((i & 2) != 0) {
            str3 = "|";
        }
        return replaceIndentByMargin(str, str2, str3);
    }

    @org.jetbrains.annotations.NotNull
    public static java.lang.String trimIndent(@org.jetbrains.annotations.NotNull java.lang.String str) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        return replaceIndent(str, "");
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String trimMargin(@org.jetbrains.annotations.NotNull java.lang.String str, @org.jetbrains.annotations.NotNull java.lang.String marginPrefix) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(str, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(marginPrefix, "marginPrefix");
        return replaceIndentByMargin(str, "", marginPrefix);
    }

    public static /* synthetic */ java.lang.String trimMargin$default(java.lang.String str, java.lang.String str2, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            str2 = "|";
        }
        return trimMargin(str, str2);
    }
}
