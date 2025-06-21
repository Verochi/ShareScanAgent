package kotlin.io;

@kotlin.Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0007"}, d2 = {"walk", "Lkotlin/io/FileTreeWalk;", "Ljava/io/File;", com.huawei.hms.support.hianalytics.HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, "Lkotlin/io/FileWalkDirection;", "walkBottomUp", "walkTopDown", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/io/FilesKt")
/* loaded from: classes14.dex */
class FilesKt__FileTreeWalkKt extends kotlin.io.FilesKt__FileReadWriteKt {
    @org.jetbrains.annotations.NotNull
    public static final kotlin.io.FileTreeWalk walk(@org.jetbrains.annotations.NotNull java.io.File file, @org.jetbrains.annotations.NotNull kotlin.io.FileWalkDirection direction) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(file, "<this>");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(direction, "direction");
        return new kotlin.io.FileTreeWalk(file, direction);
    }

    public static /* synthetic */ kotlin.io.FileTreeWalk walk$default(java.io.File file, kotlin.io.FileWalkDirection fileWalkDirection, int i, java.lang.Object obj) {
        if ((i & 1) != 0) {
            fileWalkDirection = kotlin.io.FileWalkDirection.TOP_DOWN;
        }
        return walk(file, fileWalkDirection);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.io.FileTreeWalk walkBottomUp(@org.jetbrains.annotations.NotNull java.io.File file) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(file, "<this>");
        return walk(file, kotlin.io.FileWalkDirection.BOTTOM_UP);
    }

    @org.jetbrains.annotations.NotNull
    public static final kotlin.io.FileTreeWalk walkTopDown(@org.jetbrains.annotations.NotNull java.io.File file) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(file, "<this>");
        return walk(file, kotlin.io.FileWalkDirection.TOP_DOWN);
    }
}
