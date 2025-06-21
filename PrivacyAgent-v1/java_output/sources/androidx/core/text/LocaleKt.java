package androidx.core.text;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"layoutDirection", "", "Ljava/util/Locale;", "getLayoutDirection", "(Ljava/util/Locale;)I", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class LocaleKt {
    @androidx.annotation.RequiresApi(17)
    public static final int getLayoutDirection(@org.jetbrains.annotations.NotNull java.util.Locale layoutDirection) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(layoutDirection, "$this$layoutDirection");
        return android.text.TextUtils.getLayoutDirectionFromLocale(layoutDirection);
    }
}
