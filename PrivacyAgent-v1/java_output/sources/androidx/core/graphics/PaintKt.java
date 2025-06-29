package androidx.core.graphics;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0086\b¨\u0006\u0005"}, d2 = {"setBlendMode", "", "Landroid/graphics/Paint;", "blendModeCompat", "Landroidx/core/graphics/BlendModeCompat;", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class PaintKt {
    public static final boolean setBlendMode(@org.jetbrains.annotations.NotNull android.graphics.Paint setBlendMode, @org.jetbrains.annotations.Nullable androidx.core.graphics.BlendModeCompat blendModeCompat) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(setBlendMode, "$this$setBlendMode");
        return androidx.core.graphics.PaintCompat.setBlendMode(setBlendMode, blendModeCompat);
    }
}
