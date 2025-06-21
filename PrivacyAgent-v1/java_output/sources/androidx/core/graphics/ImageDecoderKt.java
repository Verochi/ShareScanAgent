package androidx.core.graphics;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aR\u0010\u0000\u001a\u00020\u0001*\u00020\u00022C\b\u0004\u0010\u0003\u001a=\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\u0002\b\fH\u0087\b\u001aR\u0010\r\u001a\u00020\u000e*\u00020\u00022C\b\u0004\u0010\u0003\u001a=\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\u0002\b\fH\u0087\b¨\u0006\u000f"}, d2 = {"decodeBitmap", "Landroid/graphics/Bitmap;", "Landroid/graphics/ImageDecoder$Source;", "action", "Lkotlin/Function3;", "Landroid/graphics/ImageDecoder;", "Landroid/graphics/ImageDecoder$ImageInfo;", "Lkotlin/ParameterName;", "name", "info", com.tencent.open.SocialConstants.PARAM_SOURCE, "", "Lkotlin/ExtensionFunctionType;", "decodeDrawable", "Landroid/graphics/drawable/Drawable;", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class ImageDecoderKt {
    @androidx.annotation.RequiresApi(28)
    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Bitmap decodeBitmap(@org.jetbrains.annotations.NotNull android.graphics.ImageDecoder.Source decodeBitmap, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super android.graphics.ImageDecoder, ? super android.graphics.ImageDecoder.ImageInfo, ? super android.graphics.ImageDecoder.Source, kotlin.Unit> action) {
        android.graphics.Bitmap decodeBitmap2;
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(decodeBitmap, "$this$decodeBitmap");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(action, "action");
        decodeBitmap2 = android.graphics.ImageDecoder.decodeBitmap(decodeBitmap, new androidx.core.graphics.ImageDecoderKt$decodeBitmap$1(action));
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(decodeBitmap2, "ImageDecoder.decodeBitma…ction(info, source)\n    }");
        return decodeBitmap2;
    }

    @androidx.annotation.RequiresApi(28)
    @org.jetbrains.annotations.NotNull
    public static final android.graphics.drawable.Drawable decodeDrawable(@org.jetbrains.annotations.NotNull android.graphics.ImageDecoder.Source decodeDrawable, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super android.graphics.ImageDecoder, ? super android.graphics.ImageDecoder.ImageInfo, ? super android.graphics.ImageDecoder.Source, kotlin.Unit> action) {
        android.graphics.drawable.Drawable decodeDrawable2;
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(decodeDrawable, "$this$decodeDrawable");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(action, "action");
        decodeDrawable2 = android.graphics.ImageDecoder.decodeDrawable(decodeDrawable, new androidx.core.graphics.ImageDecoderKt$decodeDrawable$1(action));
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(decodeDrawable2, "ImageDecoder.decodeDrawa…ction(info, source)\n    }");
        return decodeDrawable2;
    }
}
