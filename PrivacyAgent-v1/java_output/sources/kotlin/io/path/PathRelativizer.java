package kotlin.io.path;

@kotlin.Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\f\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002R\u001c\u0010\t\u001a\n \u0006*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001c\u0010\u000b\u001a\n \u0006*\u0004\u0018\u00010\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\b¨\u0006\u000e"}, d2 = {"Lkotlin/io/path/PathRelativizer;", "", "Ljava/nio/file/Path;", "path", "base", "a", "kotlin.jvm.PlatformType", "b", "Ljava/nio/file/Path;", "emptyPath", "c", "parentPath", "<init>", "()V", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
final class PathRelativizer {

    @org.jetbrains.annotations.NotNull
    public static final kotlin.io.path.PathRelativizer a = new kotlin.io.path.PathRelativizer();

    /* renamed from: b, reason: from kotlin metadata */
    public static final java.nio.file.Path emptyPath;

    /* renamed from: c, reason: from kotlin metadata */
    public static final java.nio.file.Path parentPath;

    static {
        java.nio.file.Path path;
        java.nio.file.Path path2;
        path = java.nio.file.Paths.get("", new java.lang.String[0]);
        emptyPath = path;
        path2 = java.nio.file.Paths.get("..", new java.lang.String[0]);
        parentPath = path2;
    }

    @org.jetbrains.annotations.NotNull
    public final java.nio.file.Path a(@org.jetbrains.annotations.NotNull java.nio.file.Path path, @org.jetbrains.annotations.NotNull java.nio.file.Path base) {
        java.nio.file.Path normalize;
        java.nio.file.Path r;
        java.nio.file.Path relativize;
        int nameCount;
        int nameCount2;
        java.nio.file.FileSystem fileSystem;
        java.lang.String separator;
        java.nio.file.FileSystem fileSystem2;
        java.nio.file.FileSystem fileSystem3;
        java.lang.String separator2;
        java.lang.String dropLast;
        java.nio.file.Path name;
        java.nio.file.Path name2;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(path, "path");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(base, "base");
        normalize = base.normalize();
        r = path.normalize();
        relativize = normalize.relativize(r);
        nameCount = normalize.getNameCount();
        nameCount2 = r.getNameCount();
        int min = java.lang.Math.min(nameCount, nameCount2);
        for (int i = 0; i < min; i++) {
            name = normalize.getName(i);
            java.nio.file.Path path2 = parentPath;
            if (!kotlin.jvm.internal.Intrinsics.areEqual(name, path2)) {
                break;
            }
            name2 = r.getName(i);
            if (!kotlin.jvm.internal.Intrinsics.areEqual(name2, path2)) {
                throw new java.lang.IllegalArgumentException("Unable to compute relative path");
            }
        }
        if (kotlin.jvm.internal.Intrinsics.areEqual(r, normalize) || !kotlin.jvm.internal.Intrinsics.areEqual(normalize, emptyPath)) {
            java.lang.String obj = relativize.toString();
            fileSystem = relativize.getFileSystem();
            separator = fileSystem.getSeparator();
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(separator, "rn.fileSystem.separator");
            if (kotlin.text.StringsKt__StringsJVMKt.endsWith$default(obj, separator, false, 2, null)) {
                fileSystem2 = relativize.getFileSystem();
                fileSystem3 = relativize.getFileSystem();
                separator2 = fileSystem3.getSeparator();
                dropLast = kotlin.text.StringsKt___StringsKt.dropLast(obj, separator2.length());
                r = fileSystem2.getPath(dropLast, new java.lang.String[0]);
            } else {
                r = relativize;
            }
        }
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r, "r");
        return r;
    }
}
