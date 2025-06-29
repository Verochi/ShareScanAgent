package androidx.core.util;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\n\u001a\r\u0010\u0000\u001a\u00020\u0003*\u00020\u0004H\u0087\n\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0087\n\u001a\r\u0010\u0005\u001a\u00020\u0003*\u00020\u0004H\u0087\n¨\u0006\u0006"}, d2 = {"component1", "", "Landroid/util/Size;", "", "Landroid/util/SizeF;", "component2", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class SizeKt {
    @androidx.annotation.RequiresApi(21)
    public static final float component1(@org.jetbrains.annotations.NotNull android.util.SizeF component1) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(component1, "$this$component1");
        return component1.getWidth();
    }

    @androidx.annotation.RequiresApi(21)
    public static final int component1(@org.jetbrains.annotations.NotNull android.util.Size component1) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(component1, "$this$component1");
        return component1.getWidth();
    }

    @androidx.annotation.RequiresApi(21)
    public static final float component2(@org.jetbrains.annotations.NotNull android.util.SizeF component2) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(component2, "$this$component2");
        return component2.getHeight();
    }

    @androidx.annotation.RequiresApi(21)
    public static final int component2(@org.jetbrains.annotations.NotNull android.util.Size component2) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(component2, "$this$component2");
        return component2.getHeight();
    }
}
