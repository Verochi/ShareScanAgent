package androidx.core.graphics.drawable;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0004H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0005H\u0087\b¨\u0006\u0006"}, d2 = {"toAdaptiveIcon", "Landroid/graphics/drawable/Icon;", "Landroid/graphics/Bitmap;", "toIcon", "Landroid/net/Uri;", "", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class IconKt {
    @androidx.annotation.RequiresApi(26)
    @org.jetbrains.annotations.NotNull
    public static final android.graphics.drawable.Icon toAdaptiveIcon(@org.jetbrains.annotations.NotNull android.graphics.Bitmap toAdaptiveIcon) {
        android.graphics.drawable.Icon createWithAdaptiveBitmap;
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(toAdaptiveIcon, "$this$toAdaptiveIcon");
        createWithAdaptiveBitmap = android.graphics.drawable.Icon.createWithAdaptiveBitmap(toAdaptiveIcon);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(createWithAdaptiveBitmap, "Icon.createWithAdaptiveBitmap(this)");
        return createWithAdaptiveBitmap;
    }

    @androidx.annotation.RequiresApi(26)
    @org.jetbrains.annotations.NotNull
    public static final android.graphics.drawable.Icon toIcon(@org.jetbrains.annotations.NotNull android.graphics.Bitmap toIcon) {
        android.graphics.drawable.Icon createWithBitmap;
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(toIcon, "$this$toIcon");
        createWithBitmap = android.graphics.drawable.Icon.createWithBitmap(toIcon);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(createWithBitmap, "Icon.createWithBitmap(this)");
        return createWithBitmap;
    }

    @androidx.annotation.RequiresApi(26)
    @org.jetbrains.annotations.NotNull
    public static final android.graphics.drawable.Icon toIcon(@org.jetbrains.annotations.NotNull android.net.Uri toIcon) {
        android.graphics.drawable.Icon createWithContentUri;
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(toIcon, "$this$toIcon");
        createWithContentUri = android.graphics.drawable.Icon.createWithContentUri(toIcon);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(createWithContentUri, "Icon.createWithContentUri(this)");
        return createWithContentUri;
    }

    @androidx.annotation.RequiresApi(26)
    @org.jetbrains.annotations.NotNull
    public static final android.graphics.drawable.Icon toIcon(@org.jetbrains.annotations.NotNull byte[] toIcon) {
        android.graphics.drawable.Icon createWithData;
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(toIcon, "$this$toIcon");
        createWithData = android.graphics.drawable.Icon.createWithData(toIcon, 0, toIcon.length);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(createWithData, "Icon.createWithData(this, 0, size)");
        return createWithData;
    }
}
