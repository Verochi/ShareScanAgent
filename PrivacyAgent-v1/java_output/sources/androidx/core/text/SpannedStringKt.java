package androidx.core.text;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\u001a:\u0010\u0000\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0086\b¢\u0006\u0002\u0010\b\u001a\r\u0010\t\u001a\u00020\u0004*\u00020\nH\u0086\b¨\u0006\u000b"}, d2 = {"getSpans", "", androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE, "", "Landroid/text/Spanned;", com.anythink.expressad.foundation.d.c.bT, "", "end", "(Landroid/text/Spanned;II)[Ljava/lang/Object;", "toSpanned", "", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class SpannedStringKt {
    @org.jetbrains.annotations.NotNull
    public static final /* synthetic */ <T> T[] getSpans(@org.jetbrains.annotations.NotNull android.text.Spanned getSpans, int i, int i2) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(getSpans, "$this$getSpans");
        kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(4, androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE);
        T[] tArr = (T[]) getSpans.getSpans(i, i2, java.lang.Object.class);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(tArr, "getSpans(start, end, T::class.java)");
        return tArr;
    }

    public static /* synthetic */ java.lang.Object[] getSpans$default(android.text.Spanned getSpans, int i, int i2, int i3, java.lang.Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = getSpans.length();
        }
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(getSpans, "$this$getSpans");
        kotlin.jvm.internal.Intrinsics.reifiedOperationMarker(4, androidx.exifinterface.media.ExifInterface.GPS_DIRECTION_TRUE);
        java.lang.Object[] spans = getSpans.getSpans(i, i2, java.lang.Object.class);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(spans, "getSpans(start, end, T::class.java)");
        return spans;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.text.Spanned toSpanned(@org.jetbrains.annotations.NotNull java.lang.CharSequence toSpanned) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(toSpanned, "$this$toSpanned");
        android.text.SpannedString valueOf = android.text.SpannedString.valueOf(toSpanned);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(valueOf, "SpannedString.valueOf(this)");
        return valueOf;
    }
}
