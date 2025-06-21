package androidx.core.graphics.drawable;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b¨\u0006\u0005"}, d2 = {"toDrawable", "Landroid/graphics/drawable/BitmapDrawable;", "Landroid/graphics/Bitmap;", "resources", "Landroid/content/res/Resources;", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class BitmapDrawableKt {
    @org.jetbrains.annotations.NotNull
    public static final android.graphics.drawable.BitmapDrawable toDrawable(@org.jetbrains.annotations.NotNull android.graphics.Bitmap toDrawable, @org.jetbrains.annotations.NotNull android.content.res.Resources resources) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(toDrawable, "$this$toDrawable");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(resources, "resources");
        return new android.graphics.drawable.BitmapDrawable(resources, toDrawable);
    }
}
