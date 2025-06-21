package androidx.core.graphics;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\r\u0010\u0018\u001a\u00020\u0004*\u00020\u0019H\u0087\n\u001a\r\u0010\u0018\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\r\u0010\u0018\u001a\u00020\u0004*\u00020\u0005H\u0087\n\u001a\r\u0010\u001a\u001a\u00020\u0004*\u00020\u0019H\u0087\n\u001a\r\u0010\u001a\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\r\u0010\u001a\u001a\u00020\u0004*\u00020\u0005H\u0087\n\u001a\r\u0010\u001b\u001a\u00020\u0004*\u00020\u0019H\u0087\n\u001a\r\u0010\u001b\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\r\u0010\u001b\u001a\u00020\u0004*\u00020\u0005H\u0087\n\u001a\r\u0010\u001c\u001a\u00020\u0004*\u00020\u0019H\u0087\n\u001a\r\u0010\u001c\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\r\u0010\u001c\u001a\u00020\u0004*\u00020\u0005H\u0087\n\u001a\u0015\u0010\u001d\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\t\u001a\u00020\nH\u0087\f\u001a\u0015\u0010\u001d\u001a\u00020\u0019*\u00020\u00192\u0006\u0010\t\u001a\u00020\u001eH\u0087\f\u001a\u0015\u0010\u001d\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0087\f\u001a\u0015\u0010\u001d\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\t\u001a\u00020\u001eH\u0087\f\u001a\u0015\u0010\u001d\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0087\f\u001a\u0015\u0010\u001d\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\t\u001a\u00020\u001eH\u0087\f\u001a\u0015\u0010\u001f\u001a\u00020\u0019*\u00020\u00192\u0006\u0010 \u001a\u00020\u0019H\u0087\u0002\u001a\r\u0010!\u001a\u00020\u0019*\u00020\u0001H\u0087\b\u001a\r\u0010!\u001a\u00020\u0019*\u00020\u0005H\u0087\b\u001a\r\u0010\"\u001a\u00020\u0001*\u00020\u0005H\u0087\b\u001a\r\u0010\"\u001a\u00020\u0001*\u00020#H\u0087\b\u001a\r\u0010$\u001a\u00020\u0005*\u00020\u0001H\u0087\b\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0000\u001a\u00020\u0004*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0006\"\u0016\u0010\u0007\u001a\u00020\u0001*\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\u0003\"\u0016\u0010\u0007\u001a\u00020\u0004*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006\"\u0016\u0010\t\u001a\u00020\n*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0016\u0010\r\u001a\u00020\u0001*\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0003\"\u0016\u0010\r\u001a\u00020\u0004*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006\"\u0016\u0010\u000f\u001a\u00020\u0010*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011\"\u0016\u0010\u0012\u001a\u00020\u0010*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011\"\u0016\u0010\u0013\u001a\u00020\u0004*\u00020\u00018Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\"\u0016\u0010\u0013\u001a\u00020\u0004*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0006\"\u0016\u0010\u0016\u001a\u00020\u0001*\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0003\"\u0016\u0010\u0016\u001a\u00020\u0004*\u00020\u00058Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0006¨\u0006%"}, d2 = {"alpha", "", "getAlpha", "(I)I", "", "", "(J)F", "blue", "getBlue", "colorSpace", "Landroid/graphics/ColorSpace;", "getColorSpace", "(J)Landroid/graphics/ColorSpace;", "green", "getGreen", "isSrgb", "", "(J)Z", "isWideGamut", "luminance", "getLuminance", "(I)F", "red", "getRed", "component1", "Landroid/graphics/Color;", "component2", "component3", "component4", "convertTo", "Landroid/graphics/ColorSpace$Named;", "plus", "c", "toColor", "toColorInt", "", "toColorLong", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class ColorKt {
    @androidx.annotation.RequiresApi(26)
    public static final float component1(long j) {
        float red;
        red = android.graphics.Color.red(j);
        return red;
    }

    @androidx.annotation.RequiresApi(26)
    public static final float component1(@org.jetbrains.annotations.NotNull android.graphics.Color component1) {
        float component;
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(component1, "$this$component1");
        component = component1.getComponent(0);
        return component;
    }

    public static final int component1(@androidx.annotation.ColorInt int i) {
        return (i >> 24) & 255;
    }

    @androidx.annotation.RequiresApi(26)
    public static final float component2(long j) {
        float green;
        green = android.graphics.Color.green(j);
        return green;
    }

    @androidx.annotation.RequiresApi(26)
    public static final float component2(@org.jetbrains.annotations.NotNull android.graphics.Color component2) {
        float component;
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(component2, "$this$component2");
        component = component2.getComponent(1);
        return component;
    }

    public static final int component2(@androidx.annotation.ColorInt int i) {
        return (i >> 16) & 255;
    }

    @androidx.annotation.RequiresApi(26)
    public static final float component3(long j) {
        float blue;
        blue = android.graphics.Color.blue(j);
        return blue;
    }

    @androidx.annotation.RequiresApi(26)
    public static final float component3(@org.jetbrains.annotations.NotNull android.graphics.Color component3) {
        float component;
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(component3, "$this$component3");
        component = component3.getComponent(2);
        return component;
    }

    public static final int component3(@androidx.annotation.ColorInt int i) {
        return (i >> 8) & 255;
    }

    @androidx.annotation.RequiresApi(26)
    public static final float component4(long j) {
        float alpha;
        alpha = android.graphics.Color.alpha(j);
        return alpha;
    }

    @androidx.annotation.RequiresApi(26)
    public static final float component4(@org.jetbrains.annotations.NotNull android.graphics.Color component4) {
        float component;
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(component4, "$this$component4");
        component = component4.getComponent(3);
        return component;
    }

    public static final int component4(@androidx.annotation.ColorInt int i) {
        return i & 255;
    }

    @androidx.annotation.RequiresApi(26)
    public static final long convertTo(@androidx.annotation.ColorInt int i, @org.jetbrains.annotations.NotNull android.graphics.ColorSpace.Named colorSpace) {
        android.graphics.ColorSpace colorSpace2;
        long convert;
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(colorSpace, "colorSpace");
        colorSpace2 = android.graphics.ColorSpace.get(colorSpace);
        convert = android.graphics.Color.convert(i, colorSpace2);
        return convert;
    }

    @androidx.annotation.RequiresApi(26)
    public static final long convertTo(@androidx.annotation.ColorInt int i, @org.jetbrains.annotations.NotNull android.graphics.ColorSpace colorSpace) {
        long convert;
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(colorSpace, "colorSpace");
        convert = android.graphics.Color.convert(i, colorSpace);
        return convert;
    }

    @androidx.annotation.RequiresApi(26)
    public static final long convertTo(long j, @org.jetbrains.annotations.NotNull android.graphics.ColorSpace.Named colorSpace) {
        android.graphics.ColorSpace colorSpace2;
        long convert;
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(colorSpace, "colorSpace");
        colorSpace2 = android.graphics.ColorSpace.get(colorSpace);
        convert = android.graphics.Color.convert(j, colorSpace2);
        return convert;
    }

    @androidx.annotation.RequiresApi(26)
    public static final long convertTo(long j, @org.jetbrains.annotations.NotNull android.graphics.ColorSpace colorSpace) {
        long convert;
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(colorSpace, "colorSpace");
        convert = android.graphics.Color.convert(j, colorSpace);
        return convert;
    }

    @androidx.annotation.RequiresApi(26)
    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Color convertTo(@org.jetbrains.annotations.NotNull android.graphics.Color convertTo, @org.jetbrains.annotations.NotNull android.graphics.ColorSpace.Named colorSpace) {
        android.graphics.ColorSpace colorSpace2;
        android.graphics.Color convert;
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(convertTo, "$this$convertTo");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(colorSpace, "colorSpace");
        colorSpace2 = android.graphics.ColorSpace.get(colorSpace);
        convert = convertTo.convert(colorSpace2);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(convert, "convert(ColorSpace.get(colorSpace))");
        return convert;
    }

    @androidx.annotation.RequiresApi(26)
    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Color convertTo(@org.jetbrains.annotations.NotNull android.graphics.Color convertTo, @org.jetbrains.annotations.NotNull android.graphics.ColorSpace colorSpace) {
        android.graphics.Color convert;
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(convertTo, "$this$convertTo");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(colorSpace, "colorSpace");
        convert = convertTo.convert(colorSpace);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(convert, "convert(colorSpace)");
        return convert;
    }

    @androidx.annotation.RequiresApi(26)
    public static final float getAlpha(long j) {
        float alpha;
        alpha = android.graphics.Color.alpha(j);
        return alpha;
    }

    public static final int getAlpha(@androidx.annotation.ColorInt int i) {
        return (i >> 24) & 255;
    }

    @androidx.annotation.RequiresApi(26)
    public static final float getBlue(long j) {
        float blue;
        blue = android.graphics.Color.blue(j);
        return blue;
    }

    public static final int getBlue(@androidx.annotation.ColorInt int i) {
        return i & 255;
    }

    @androidx.annotation.RequiresApi(26)
    @org.jetbrains.annotations.NotNull
    public static final android.graphics.ColorSpace getColorSpace(long j) {
        android.graphics.ColorSpace colorSpace;
        colorSpace = android.graphics.Color.colorSpace(j);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(colorSpace, "Color.colorSpace(this)");
        return colorSpace;
    }

    @androidx.annotation.RequiresApi(26)
    public static final float getGreen(long j) {
        float green;
        green = android.graphics.Color.green(j);
        return green;
    }

    public static final int getGreen(@androidx.annotation.ColorInt int i) {
        return (i >> 8) & 255;
    }

    @androidx.annotation.RequiresApi(26)
    public static final float getLuminance(@androidx.annotation.ColorInt int i) {
        float luminance;
        luminance = android.graphics.Color.luminance(i);
        return luminance;
    }

    @androidx.annotation.RequiresApi(26)
    public static final float getLuminance(long j) {
        float luminance;
        luminance = android.graphics.Color.luminance(j);
        return luminance;
    }

    @androidx.annotation.RequiresApi(26)
    public static final float getRed(long j) {
        float red;
        red = android.graphics.Color.red(j);
        return red;
    }

    public static final int getRed(@androidx.annotation.ColorInt int i) {
        return (i >> 16) & 255;
    }

    @androidx.annotation.RequiresApi(26)
    public static final boolean isSrgb(long j) {
        boolean isSrgb;
        isSrgb = android.graphics.Color.isSrgb(j);
        return isSrgb;
    }

    @androidx.annotation.RequiresApi(26)
    public static final boolean isWideGamut(long j) {
        boolean isWideGamut;
        isWideGamut = android.graphics.Color.isWideGamut(j);
        return isWideGamut;
    }

    @androidx.annotation.RequiresApi(26)
    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Color plus(@org.jetbrains.annotations.NotNull android.graphics.Color plus, @org.jetbrains.annotations.NotNull android.graphics.Color c) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(c, "c");
        android.graphics.Color compositeColors = androidx.core.graphics.ColorUtils.compositeColors(c, plus);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(compositeColors, "ColorUtils.compositeColors(c, this)");
        return compositeColors;
    }

    @androidx.annotation.RequiresApi(26)
    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Color toColor(@androidx.annotation.ColorInt int i) {
        android.graphics.Color valueOf;
        valueOf = android.graphics.Color.valueOf(i);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(valueOf, "Color.valueOf(this)");
        return valueOf;
    }

    @androidx.annotation.RequiresApi(26)
    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Color toColor(long j) {
        android.graphics.Color valueOf;
        valueOf = android.graphics.Color.valueOf(j);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(valueOf, "Color.valueOf(this)");
        return valueOf;
    }

    @androidx.annotation.ColorInt
    @androidx.annotation.RequiresApi(26)
    public static final int toColorInt(long j) {
        int argb;
        argb = android.graphics.Color.toArgb(j);
        return argb;
    }

    @androidx.annotation.ColorInt
    public static final int toColorInt(@org.jetbrains.annotations.NotNull java.lang.String toColorInt) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(toColorInt, "$this$toColorInt");
        return android.graphics.Color.parseColor(toColorInt);
    }

    @androidx.annotation.RequiresApi(26)
    public static final long toColorLong(@androidx.annotation.ColorInt int i) {
        long pack;
        pack = android.graphics.Color.pack(i);
        return pack;
    }
}
