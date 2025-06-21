package androidx.core.graphics;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b\u001a\r\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0086\b¨\u0006\u0007"}, d2 = {"toColorFilter", "Landroid/graphics/PorterDuffColorFilter;", "Landroid/graphics/PorterDuff$Mode;", "color", "", "toXfermode", "Landroid/graphics/PorterDuffXfermode;", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class PorterDuffKt {
    @org.jetbrains.annotations.NotNull
    public static final android.graphics.PorterDuffColorFilter toColorFilter(@org.jetbrains.annotations.NotNull android.graphics.PorterDuff.Mode toColorFilter, int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(toColorFilter, "$this$toColorFilter");
        return new android.graphics.PorterDuffColorFilter(i, toColorFilter);
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.PorterDuffXfermode toXfermode(@org.jetbrains.annotations.NotNull android.graphics.PorterDuff.Mode toXfermode) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(toXfermode, "$this$toXfermode");
        return new android.graphics.PorterDuffXfermode(toXfermode);
    }
}
