package kotlin.io;

@kotlin.Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lkotlin/io/FileSystemException;", "Ljava/io/IOException;", "file", "Ljava/io/File;", "other", "reason", "", "(Ljava/io/File;Ljava/io/File;Ljava/lang/String;)V", "getFile", "()Ljava/io/File;", "getOther", "getReason", "()Ljava/lang/String;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public class FileSystemException extends java.io.IOException {

    @org.jetbrains.annotations.NotNull
    private final java.io.File file;

    @org.jetbrains.annotations.Nullable
    private final java.io.File other;

    @org.jetbrains.annotations.Nullable
    private final java.lang.String reason;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FileSystemException(@org.jetbrains.annotations.NotNull java.io.File file, @org.jetbrains.annotations.Nullable java.io.File file2, @org.jetbrains.annotations.Nullable java.lang.String str) {
        super(r0);
        java.lang.String a;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(file, "file");
        a = kotlin.io.ExceptionsKt.a(file, file2, str);
        this.file = file;
        this.other = file2;
        this.reason = str;
    }

    public /* synthetic */ FileSystemException(java.io.File file, java.io.File file2, java.lang.String str, int i, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i & 2) != 0 ? null : file2, (i & 4) != 0 ? null : str);
    }

    @org.jetbrains.annotations.NotNull
    public final java.io.File getFile() {
        return this.file;
    }

    @org.jetbrains.annotations.Nullable
    public final java.io.File getOther() {
        return this.other;
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.String getReason() {
        return this.reason;
    }
}
