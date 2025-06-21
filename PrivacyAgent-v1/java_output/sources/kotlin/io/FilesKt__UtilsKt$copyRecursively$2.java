package kotlin.io;

@kotlin.Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "f", "Ljava/io/File;", "e", "Ljava/io/IOException;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class FilesKt__UtilsKt$copyRecursively$2 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function2<java.io.File, java.io.IOException, kotlin.Unit> {
    final /* synthetic */ kotlin.jvm.functions.Function2<java.io.File, java.io.IOException, kotlin.io.OnErrorAction> $onError;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FilesKt__UtilsKt$copyRecursively$2(kotlin.jvm.functions.Function2<? super java.io.File, ? super java.io.IOException, ? extends kotlin.io.OnErrorAction> function2) {
        super(2);
        this.$onError = function2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ kotlin.Unit mo5invoke(java.io.File file, java.io.IOException iOException) {
        invoke2(file, iOException);
        return kotlin.Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@org.jetbrains.annotations.NotNull java.io.File f, @org.jetbrains.annotations.NotNull java.io.IOException e) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(f, "f");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(e, "e");
        if (this.$onError.mo5invoke(f, e) == kotlin.io.OnErrorAction.TERMINATE) {
            throw new kotlin.io.TerminateException(f);
        }
    }
}
