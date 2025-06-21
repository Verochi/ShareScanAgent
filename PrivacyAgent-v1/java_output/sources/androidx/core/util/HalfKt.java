package androidx.core.util;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\n\n\u0002\u0010\u000e\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0003H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0004H\u0087\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0005H\u0087\b¨\u0006\u0006"}, d2 = {"toHalf", "Landroid/util/Half;", "", "", "", "", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class HalfKt {
    @androidx.annotation.RequiresApi(26)
    @org.jetbrains.annotations.NotNull
    public static final android.util.Half toHalf(double d) {
        android.util.Half valueOf;
        valueOf = android.util.Half.valueOf((float) d);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(valueOf, "Half.valueOf(this)");
        return valueOf;
    }

    @androidx.annotation.RequiresApi(26)
    @org.jetbrains.annotations.NotNull
    public static final android.util.Half toHalf(float f) {
        android.util.Half valueOf;
        valueOf = android.util.Half.valueOf(f);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(valueOf, "Half.valueOf(this)");
        return valueOf;
    }

    @androidx.annotation.RequiresApi(26)
    @org.jetbrains.annotations.NotNull
    public static final android.util.Half toHalf(@org.jetbrains.annotations.NotNull java.lang.String toHalf) {
        android.util.Half valueOf;
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(toHalf, "$this$toHalf");
        valueOf = android.util.Half.valueOf(toHalf);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(valueOf, "Half.valueOf(this)");
        return valueOf;
    }

    @androidx.annotation.RequiresApi(26)
    @org.jetbrains.annotations.NotNull
    public static final android.util.Half toHalf(short s2) {
        android.util.Half valueOf;
        valueOf = android.util.Half.valueOf(s2);
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(valueOf, "Half.valueOf(this)");
        return valueOf;
    }
}
