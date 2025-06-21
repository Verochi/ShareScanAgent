package androidx.core.graphics;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "decoder", "Landroid/graphics/ImageDecoder;", "info", "Landroid/graphics/ImageDecoder$ImageInfo;", com.tencent.open.SocialConstants.PARAM_SOURCE, "Landroid/graphics/ImageDecoder$Source;", "onHeaderDecoded"}, k = 3, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class ImageDecoderKt$decodeBitmap$1 implements android.graphics.ImageDecoder.OnHeaderDecodedListener {
    final /* synthetic */ kotlin.jvm.functions.Function3 $action;

    public ImageDecoderKt$decodeBitmap$1(kotlin.jvm.functions.Function3 function3) {
        this.$action = function3;
    }

    @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
    public final void onHeaderDecoded(@org.jetbrains.annotations.NotNull android.graphics.ImageDecoder decoder, @org.jetbrains.annotations.NotNull android.graphics.ImageDecoder.ImageInfo info, @org.jetbrains.annotations.NotNull android.graphics.ImageDecoder.Source source) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(decoder, "decoder");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(info, "info");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(source, "source");
        this.$action.invoke(decoder, info, source);
    }
}
