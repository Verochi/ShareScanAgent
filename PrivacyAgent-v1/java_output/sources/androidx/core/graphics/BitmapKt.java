package androidx.core.graphics;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0086\b\u001a7\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a&\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0002\b\u0010H\u0086\b\u001a\u0015\u0010\u0011\u001a\u00020\b*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0013H\u0086\n\u001a\u0015\u0010\u0011\u001a\u00020\b*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0014H\u0086\n\u001a\u001d\u0010\u0015\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\u0086\n\u001a'\u0010\u0018\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\bH\u0086\b\u001a'\u0010\u001a\u001a\u00020\u000f*\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\b\b\u0001\u0010\u001b\u001a\u00020\u0003H\u0086\n¨\u0006\u001c"}, d2 = {"createBitmap", "Landroid/graphics/Bitmap;", "width", "", "height", "config", "Landroid/graphics/Bitmap$Config;", "hasAlpha", "", "colorSpace", "Landroid/graphics/ColorSpace;", "applyCanvas", "block", "Lkotlin/Function1;", "Landroid/graphics/Canvas;", "", "Lkotlin/ExtensionFunctionType;", "contains", "p", "Landroid/graphics/Point;", "Landroid/graphics/PointF;", com.ss.android.socialbase.downloader.constants.MonitorConstants.CONNECT_TYPE_GET, "x", "y", "scale", "filter", "set", "color", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class BitmapKt {
    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Bitmap applyCanvas(@org.jetbrains.annotations.NotNull android.graphics.Bitmap applyCanvas, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.graphics.Canvas, kotlin.Unit> block) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(applyCanvas, "$this$applyCanvas");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(block, "block");
        block.invoke(new android.graphics.Canvas(applyCanvas));
        return applyCanvas;
    }

    public static final boolean contains(@org.jetbrains.annotations.NotNull android.graphics.Bitmap contains, @org.jetbrains.annotations.NotNull android.graphics.Point p) {
        int i;
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(p, "p");
        int i2 = p.x;
        return i2 >= 0 && i2 < contains.getWidth() && (i = p.y) >= 0 && i < contains.getHeight();
    }

    public static final boolean contains(@org.jetbrains.annotations.NotNull android.graphics.Bitmap contains, @org.jetbrains.annotations.NotNull android.graphics.PointF p) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(p, "p");
        float f = p.x;
        float f2 = 0;
        if (f < f2 || f >= contains.getWidth()) {
            return false;
        }
        float f3 = p.y;
        return f3 >= f2 && f3 < ((float) contains.getHeight());
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Bitmap createBitmap(int i, int i2, @org.jetbrains.annotations.NotNull android.graphics.Bitmap.Config config) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(config, "config");
        android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(i, i2, config);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(createBitmap, "Bitmap.createBitmap(width, height, config)");
        return createBitmap;
    }

    @androidx.annotation.RequiresApi(26)
    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Bitmap createBitmap(int i, int i2, @org.jetbrains.annotations.NotNull android.graphics.Bitmap.Config config, boolean z, @org.jetbrains.annotations.NotNull android.graphics.ColorSpace colorSpace) {
        android.graphics.Bitmap createBitmap;
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(config, "config");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(colorSpace, "colorSpace");
        createBitmap = android.graphics.Bitmap.createBitmap(i, i2, config, z, colorSpace);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(createBitmap, "Bitmap.createBitmap(widt…ig, hasAlpha, colorSpace)");
        return createBitmap;
    }

    public static /* synthetic */ android.graphics.Bitmap createBitmap$default(int i, int i2, android.graphics.Bitmap.Config config, int i3, java.lang.Object obj) {
        if ((i3 & 4) != 0) {
            config = android.graphics.Bitmap.Config.ARGB_8888;
        }
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(config, "config");
        android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(i, i2, config);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(createBitmap, "Bitmap.createBitmap(width, height, config)");
        return createBitmap;
    }

    public static /* synthetic */ android.graphics.Bitmap createBitmap$default(int i, int i2, android.graphics.Bitmap.Config config, boolean z, android.graphics.ColorSpace colorSpace, int i3, java.lang.Object obj) {
        android.graphics.Bitmap createBitmap;
        android.graphics.ColorSpace.Named named;
        if ((i3 & 4) != 0) {
            config = android.graphics.Bitmap.Config.ARGB_8888;
        }
        if ((i3 & 8) != 0) {
            z = true;
        }
        if ((i3 & 16) != 0) {
            named = android.graphics.ColorSpace.Named.SRGB;
            colorSpace = android.graphics.ColorSpace.get(named);
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(colorSpace, "ColorSpace.get(ColorSpace.Named.SRGB)");
        }
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(config, "config");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(colorSpace, "colorSpace");
        createBitmap = android.graphics.Bitmap.createBitmap(i, i2, config, z, colorSpace);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(createBitmap, "Bitmap.createBitmap(widt…ig, hasAlpha, colorSpace)");
        return createBitmap;
    }

    public static final int get(@org.jetbrains.annotations.NotNull android.graphics.Bitmap get, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(get, "$this$get");
        return get.getPixel(i, i2);
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Bitmap scale(@org.jetbrains.annotations.NotNull android.graphics.Bitmap scale, int i, int i2, boolean z) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(scale, "$this$scale");
        android.graphics.Bitmap createScaledBitmap = android.graphics.Bitmap.createScaledBitmap(scale, i, i2, z);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(createScaledBitmap, "Bitmap.createScaledBitma…s, width, height, filter)");
        return createScaledBitmap;
    }

    public static /* synthetic */ android.graphics.Bitmap scale$default(android.graphics.Bitmap scale, int i, int i2, boolean z, int i3, java.lang.Object obj) {
        if ((i3 & 4) != 0) {
            z = true;
        }
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(scale, "$this$scale");
        android.graphics.Bitmap createScaledBitmap = android.graphics.Bitmap.createScaledBitmap(scale, i, i2, z);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(createScaledBitmap, "Bitmap.createScaledBitma…s, width, height, filter)");
        return createScaledBitmap;
    }

    public static final void set(@org.jetbrains.annotations.NotNull android.graphics.Bitmap set, int i, int i2, @androidx.annotation.ColorInt int i3) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(set, "$this$set");
        set.setPixel(i, i2, i3);
    }
}
