package androidx.core.net;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\r\u0010\u0003\u001a\u00020\u0002*\u00020\u0001H\u0086\b\u001a\r\u0010\u0003\u001a\u00020\u0002*\u00020\u0004H\u0086\b¨\u0006\u0005"}, d2 = {"toFile", "Ljava/io/File;", "Landroid/net/Uri;", "toUri", "", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class UriKt {
    @org.jetbrains.annotations.NotNull
    public static final java.io.File toFile(@org.jetbrains.annotations.NotNull android.net.Uri toFile) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(toFile, "$this$toFile");
        if (!kotlin.jvm.internal.Intrinsics.areEqual(toFile.getScheme(), "file")) {
            throw new java.lang.IllegalArgumentException(("Uri lacks 'file' scheme: " + toFile).toString());
        }
        java.lang.String path = toFile.getPath();
        if (path != null) {
            return new java.io.File(path);
        }
        throw new java.lang.IllegalArgumentException(("Uri path is null: " + toFile).toString());
    }

    @org.jetbrains.annotations.NotNull
    public static final android.net.Uri toUri(@org.jetbrains.annotations.NotNull java.io.File toUri) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(toUri, "$this$toUri");
        android.net.Uri fromFile = android.net.Uri.fromFile(toUri);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(fromFile, "Uri.fromFile(this)");
        return fromFile;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.net.Uri toUri(@org.jetbrains.annotations.NotNull java.lang.String toUri) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(toUri, "$this$toUri");
        android.net.Uri parse = android.net.Uri.parse(toUri);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(this)");
        return parse;
    }
}
