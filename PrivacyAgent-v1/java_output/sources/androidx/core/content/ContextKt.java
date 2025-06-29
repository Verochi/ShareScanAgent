package androidx.core.content;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\u0086\b¢\u0006\u0002\u0010\u0004\u001aN\u0010\u0005\u001a\u00020\u0006*\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0003\u0010\u000b\u001a\u00020\f2\b\b\u0003\u0010\r\u001a\u00020\f2\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00060\u000f¢\u0006\u0002\b\u0011H\u0086\b\u001a8\u0010\u0005\u001a\u00020\u0006*\u00020\u00032\b\b\u0001\u0010\u0012\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00060\u000f¢\u0006\u0002\b\u0011H\u0086\b¨\u0006\u0013"}, d2 = {"getSystemService", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "", "Landroid/content/Context;", "(Landroid/content/Context;)Ljava/lang/Object;", "withStyledAttributes", "", "set", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "", "defStyleRes", "block", "Lkotlin/Function1;", "Landroid/content/res/TypedArray;", "Lkotlin/ExtensionFunctionType;", "resourceId", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class ContextKt {
    @org.jetbrains.annotations.Nullable
    public static final /* synthetic */ <T> T getSystemService(@org.jetbrains.annotations.NotNull android.content.Context getSystemService) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(getSystemService, "$this$getSystemService");
        kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(4, androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE);
        return (T) androidx.core.content.ContextCompat.getSystemService(getSystemService, java.lang.Object.class);
    }

    public static final void withStyledAttributes(@org.jetbrains.annotations.NotNull android.content.Context withStyledAttributes, @androidx.annotation.StyleRes int i, @org.jetbrains.annotations.NotNull int[] attrs, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.content.res.TypedArray, kotlin.Unit> block) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(withStyledAttributes, "$this$withStyledAttributes");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(attrs, "attrs");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(block, "block");
        android.content.res.TypedArray obtainStyledAttributes = withStyledAttributes.obtainStyledAttributes(i, attrs);
        block.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public static final void withStyledAttributes(@org.jetbrains.annotations.NotNull android.content.Context withStyledAttributes, @org.jetbrains.annotations.Nullable android.util.AttributeSet attributeSet, @org.jetbrains.annotations.NotNull int[] attrs, @androidx.annotation.AttrRes int i, @androidx.annotation.StyleRes int i2, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.content.res.TypedArray, kotlin.Unit> block) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(withStyledAttributes, "$this$withStyledAttributes");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(attrs, "attrs");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(block, "block");
        android.content.res.TypedArray obtainStyledAttributes = withStyledAttributes.obtainStyledAttributes(attributeSet, attrs, i, i2);
        block.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    public static /* synthetic */ void withStyledAttributes$default(android.content.Context withStyledAttributes, android.util.AttributeSet attributeSet, int[] attrs, int i, int i2, kotlin.jvm.functions.Function1 block, int i3, java.lang.Object obj) {
        if ((i3 & 1) != 0) {
            attributeSet = null;
        }
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(withStyledAttributes, "$this$withStyledAttributes");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(attrs, "attrs");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(block, "block");
        android.content.res.TypedArray obtainStyledAttributes = withStyledAttributes.obtainStyledAttributes(attributeSet, attrs, i, i2);
        block.invoke(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }
}
