package androidx.core.graphics.drawable;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0003H\u0086\b¨\u0006\u0004"}, d2 = {"toDrawable", "Landroid/graphics/drawable/ColorDrawable;", "Landroid/graphics/Color;", "", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class ColorDrawableKt {
    @org.jetbrains.annotations.NotNull
    public static final android.graphics.drawable.ColorDrawable toDrawable(@androidx.annotation.ColorInt int i) {
        return new android.graphics.drawable.ColorDrawable(i);
    }

    @androidx.annotation.RequiresApi(26)
    @org.jetbrains.annotations.NotNull
    public static final android.graphics.drawable.ColorDrawable toDrawable(@org.jetbrains.annotations.NotNull android.graphics.Color toDrawable) {
        int argb;
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(toDrawable, "$this$toDrawable");
        argb = toDrawable.toArgb();
        return new android.graphics.drawable.ColorDrawable(argb);
    }
}
