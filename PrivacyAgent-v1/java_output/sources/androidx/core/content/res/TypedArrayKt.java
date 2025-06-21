package androidx.core.content.res;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u001a\u0016\u0010\u0007\u001a\u00020\u0004*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0014\u0010\b\u001a\u00020\t*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u001a\u0014\u0010\n\u001a\u00020\u000b*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u001a\u0016\u0010\f\u001a\u00020\u0004*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0016\u0010\r\u001a\u00020\u0004*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0014\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u001a\u0014\u0010\u0010\u001a\u00020\u000b*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u001a\u0016\u0010\u0011\u001a\u00020\u0012*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0014\u0010\u0013\u001a\u00020\u0004*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u001a\u0014\u0010\u0014\u001a\u00020\u0004*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u001a\u0016\u0010\u0015\u001a\u00020\u0004*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0014\u0010\u0016\u001a\u00020\u0017*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u001a\u001f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u001b\u001a\u0014\u0010\u001c\u001a\u00020\u001a*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u001a,\u0010\u001d\u001a\u0002H\u001e\"\u0004\b\u0000\u0010\u001e*\u00020\u00022\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u001e0 H\u0086\b¢\u0006\u0002\u0010!¨\u0006\""}, d2 = {"checkAttribute", "", "Landroid/content/res/TypedArray;", "index", "", "getBooleanOrThrow", "", "getColorOrThrow", "getColorStateListOrThrow", "Landroid/content/res/ColorStateList;", "getDimensionOrThrow", "", "getDimensionPixelOffsetOrThrow", "getDimensionPixelSizeOrThrow", "getDrawableOrThrow", "Landroid/graphics/drawable/Drawable;", "getFloatOrThrow", "getFontOrThrow", "Landroid/graphics/Typeface;", "getIntOrThrow", "getIntegerOrThrow", "getResourceIdOrThrow", "getStringOrThrow", "", "getTextArrayOrThrow", "", "", "(Landroid/content/res/TypedArray;I)[Ljava/lang/CharSequence;", "getTextOrThrow", "use", "R", "block", "Lkotlin/Function1;", "(Landroid/content/res/TypedArray;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class TypedArrayKt {
    private static final void checkAttribute(@org.jetbrains.annotations.NotNull android.content.res.TypedArray typedArray, @androidx.annotation.StyleableRes int i) {
        if (!typedArray.hasValue(i)) {
            throw new java.lang.IllegalArgumentException("Attribute not defined in set.");
        }
    }

    public static final boolean getBooleanOrThrow(@org.jetbrains.annotations.NotNull android.content.res.TypedArray getBooleanOrThrow, @androidx.annotation.StyleableRes int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(getBooleanOrThrow, "$this$getBooleanOrThrow");
        checkAttribute(getBooleanOrThrow, i);
        return getBooleanOrThrow.getBoolean(i, false);
    }

    @androidx.annotation.ColorInt
    public static final int getColorOrThrow(@org.jetbrains.annotations.NotNull android.content.res.TypedArray getColorOrThrow, @androidx.annotation.StyleableRes int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(getColorOrThrow, "$this$getColorOrThrow");
        checkAttribute(getColorOrThrow, i);
        return getColorOrThrow.getColor(i, 0);
    }

    @org.jetbrains.annotations.NotNull
    public static final android.content.res.ColorStateList getColorStateListOrThrow(@org.jetbrains.annotations.NotNull android.content.res.TypedArray getColorStateListOrThrow, @androidx.annotation.StyleableRes int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(getColorStateListOrThrow, "$this$getColorStateListOrThrow");
        checkAttribute(getColorStateListOrThrow, i);
        android.content.res.ColorStateList colorStateList = getColorStateListOrThrow.getColorStateList(i);
        if (colorStateList != null) {
            return colorStateList;
        }
        throw new java.lang.IllegalStateException("Attribute value was not a color or color state list.".toString());
    }

    public static final float getDimensionOrThrow(@org.jetbrains.annotations.NotNull android.content.res.TypedArray getDimensionOrThrow, @androidx.annotation.StyleableRes int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(getDimensionOrThrow, "$this$getDimensionOrThrow");
        checkAttribute(getDimensionOrThrow, i);
        return getDimensionOrThrow.getDimension(i, 0.0f);
    }

    @androidx.annotation.Dimension
    public static final int getDimensionPixelOffsetOrThrow(@org.jetbrains.annotations.NotNull android.content.res.TypedArray getDimensionPixelOffsetOrThrow, @androidx.annotation.StyleableRes int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(getDimensionPixelOffsetOrThrow, "$this$getDimensionPixelOffsetOrThrow");
        checkAttribute(getDimensionPixelOffsetOrThrow, i);
        return getDimensionPixelOffsetOrThrow.getDimensionPixelOffset(i, 0);
    }

    @androidx.annotation.Dimension
    public static final int getDimensionPixelSizeOrThrow(@org.jetbrains.annotations.NotNull android.content.res.TypedArray getDimensionPixelSizeOrThrow, @androidx.annotation.StyleableRes int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(getDimensionPixelSizeOrThrow, "$this$getDimensionPixelSizeOrThrow");
        checkAttribute(getDimensionPixelSizeOrThrow, i);
        return getDimensionPixelSizeOrThrow.getDimensionPixelSize(i, 0);
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.drawable.Drawable getDrawableOrThrow(@org.jetbrains.annotations.NotNull android.content.res.TypedArray getDrawableOrThrow, @androidx.annotation.StyleableRes int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(getDrawableOrThrow, "$this$getDrawableOrThrow");
        checkAttribute(getDrawableOrThrow, i);
        android.graphics.drawable.Drawable drawable = getDrawableOrThrow.getDrawable(i);
        if (drawable == null) {
            kotlin.jvm.internal.Intrinsics.throwNpe();
        }
        return drawable;
    }

    public static final float getFloatOrThrow(@org.jetbrains.annotations.NotNull android.content.res.TypedArray getFloatOrThrow, @androidx.annotation.StyleableRes int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(getFloatOrThrow, "$this$getFloatOrThrow");
        checkAttribute(getFloatOrThrow, i);
        return getFloatOrThrow.getFloat(i, 0.0f);
    }

    @androidx.annotation.RequiresApi(26)
    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Typeface getFontOrThrow(@org.jetbrains.annotations.NotNull android.content.res.TypedArray getFontOrThrow, @androidx.annotation.StyleableRes int i) {
        android.graphics.Typeface font;
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(getFontOrThrow, "$this$getFontOrThrow");
        checkAttribute(getFontOrThrow, i);
        font = getFontOrThrow.getFont(i);
        if (font == null) {
            kotlin.jvm.internal.Intrinsics.throwNpe();
        }
        return font;
    }

    public static final int getIntOrThrow(@org.jetbrains.annotations.NotNull android.content.res.TypedArray getIntOrThrow, @androidx.annotation.StyleableRes int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(getIntOrThrow, "$this$getIntOrThrow");
        checkAttribute(getIntOrThrow, i);
        return getIntOrThrow.getInt(i, 0);
    }

    public static final int getIntegerOrThrow(@org.jetbrains.annotations.NotNull android.content.res.TypedArray getIntegerOrThrow, @androidx.annotation.StyleableRes int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(getIntegerOrThrow, "$this$getIntegerOrThrow");
        checkAttribute(getIntegerOrThrow, i);
        return getIntegerOrThrow.getInteger(i, 0);
    }

    @androidx.annotation.AnyRes
    public static final int getResourceIdOrThrow(@org.jetbrains.annotations.NotNull android.content.res.TypedArray getResourceIdOrThrow, @androidx.annotation.StyleableRes int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(getResourceIdOrThrow, "$this$getResourceIdOrThrow");
        checkAttribute(getResourceIdOrThrow, i);
        return getResourceIdOrThrow.getResourceId(i, 0);
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.String getStringOrThrow(@org.jetbrains.annotations.NotNull android.content.res.TypedArray getStringOrThrow, @androidx.annotation.StyleableRes int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(getStringOrThrow, "$this$getStringOrThrow");
        checkAttribute(getStringOrThrow, i);
        java.lang.String string = getStringOrThrow.getString(i);
        if (string != null) {
            return string;
        }
        throw new java.lang.IllegalStateException("Attribute value could not be coerced to String.".toString());
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.CharSequence[] getTextArrayOrThrow(@org.jetbrains.annotations.NotNull android.content.res.TypedArray getTextArrayOrThrow, @androidx.annotation.StyleableRes int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(getTextArrayOrThrow, "$this$getTextArrayOrThrow");
        checkAttribute(getTextArrayOrThrow, i);
        java.lang.CharSequence[] textArray = getTextArrayOrThrow.getTextArray(i);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(textArray, "getTextArray(index)");
        return textArray;
    }

    @org.jetbrains.annotations.NotNull
    public static final java.lang.CharSequence getTextOrThrow(@org.jetbrains.annotations.NotNull android.content.res.TypedArray getTextOrThrow, @androidx.annotation.StyleableRes int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(getTextOrThrow, "$this$getTextOrThrow");
        checkAttribute(getTextOrThrow, i);
        java.lang.CharSequence text = getTextOrThrow.getText(i);
        if (text != null) {
            return text;
        }
        throw new java.lang.IllegalStateException("Attribute value could not be coerced to CharSequence.".toString());
    }

    public static final <R> R use(@org.jetbrains.annotations.NotNull android.content.res.TypedArray use, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.content.res.TypedArray, ? extends R> block) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(use, "$this$use");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(block, "block");
        R invoke = block.invoke(use);
        use.recycle();
        return invoke;
    }
}
