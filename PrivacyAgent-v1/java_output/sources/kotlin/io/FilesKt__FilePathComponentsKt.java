package kotlin.io;

@kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a\f\u0010\u0006\u001a\u00020\u0005*\u00020\u0004H\u0000\u001a\u001c\u0010\t\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001H\u0000\"\u0018\u0010\f\u001a\u00020\u0000*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u0018\u0010\u000f\u001a\u00020\u0004*\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"\u0015\u0010\u0011\u001a\u00020\u0010*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"", "", "a", "(Ljava/lang/String;)I", "Ljava/io/File;", "Lkotlin/io/FilePathComponents;", "toComponents", "beginIndex", "endIndex", "subPath", "getRootName", "(Ljava/io/File;)Ljava/lang/String;", "rootName", "getRoot", "(Ljava/io/File;)Ljava/io/File;", "root", "", "isRooted", "(Ljava/io/File;)Z", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xs = "kotlin/io/FilesKt")
/* loaded from: classes14.dex */
class FilesKt__FilePathComponentsKt {
    public static final int a(java.lang.String str) {
        boolean endsWith$default;
        int indexOf$default;
        int indexOf$default2 = kotlin.text.StringsKt__StringsKt.indexOf$default((java.lang.CharSequence) str, java.io.File.separatorChar, 0, false, 4, (java.lang.Object) null);
        if (indexOf$default2 == 0) {
            if (str.length() > 1) {
                char charAt = str.charAt(1);
                char c = java.io.File.separatorChar;
                if (charAt == c && (indexOf$default = kotlin.text.StringsKt__StringsKt.indexOf$default((java.lang.CharSequence) str, c, 2, false, 4, (java.lang.Object) null)) >= 0) {
                    int indexOf$default3 = kotlin.text.StringsKt__StringsKt.indexOf$default((java.lang.CharSequence) str, java.io.File.separatorChar, indexOf$default + 1, false, 4, (java.lang.Object) null);
                    return indexOf$default3 >= 0 ? indexOf$default3 + 1 : str.length();
                }
            }
            return 1;
        }
        if (indexOf$default2 > 0 && str.charAt(indexOf$default2 - 1) == ':') {
            return indexOf$default2 + 1;
        }
        if (indexOf$default2 == -1) {
            endsWith$default = kotlin.text.StringsKt__StringsKt.endsWith$default((java.lang.CharSequence) str, ':', false, 2, (java.lang.Object) null);
            if (endsWith$default) {
                return str.length();
            }
        }
        return 0;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.io.File getRoot(@org.jetbrains.annotations.NotNull java.io.File file) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(file, "<this>");
        return new java.io.File(getRootName(file));
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String getRootName(@org.jetbrains.annotations.NotNull java.io.File file) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(file, "<this>");
        java.lang.String path = file.getPath();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(path, "path");
        java.lang.String path2 = file.getPath();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(path2, "path");
        java.lang.String substring = path.substring(0, a(path2));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final boolean isRooted(@org.jetbrains.annotations.NotNull java.io.File file) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(file, "<this>");
        java.lang.String path = file.getPath();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(path, "path");
        return a(path) > 0;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.io.File subPath(@org.jetbrains.annotations.NotNull java.io.File file, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(file, "<this>");
        return toComponents(file).subPath(i, i2);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.io.FilePathComponents toComponents(@org.jetbrains.annotations.NotNull java.io.File file) {
        java.util.List split$default;
        java.util.List list;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(file, "<this>");
        java.lang.String path = file.getPath();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(path, "path");
        int a = a(path);
        java.lang.String substring = path.substring(0, a);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        java.lang.String substring2 = path.substring(a);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
        if (substring2.length() == 0) {
            list = kotlin.collections.CollectionsKt__CollectionsKt.emptyList();
        } else {
            split$default = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) substring2, new char[]{java.io.File.separatorChar}, false, 0, 6, (java.lang.Object) null);
            java.util.List list2 = split$default;
            java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10));
            java.util.Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(new java.io.File((java.lang.String) it.next()));
            }
            list = arrayList;
        }
        return new kotlin.io.FilePathComponents(new java.io.File(substring), list);
    }
}
