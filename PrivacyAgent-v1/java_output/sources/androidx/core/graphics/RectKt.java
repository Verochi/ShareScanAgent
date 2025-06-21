package androidx.core.graphics;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\f\u001a\u0015\u0010\u0000\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\f\u001a\r\u0010\u0004\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\u0004\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\r\u0010\u0007\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\u0007\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\r\u0010\b\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\b\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\r\u0010\t\u001a\u00020\u0005*\u00020\u0001H\u0086\n\u001a\r\u0010\t\u001a\u00020\u0006*\u00020\u0003H\u0086\n\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0086\n\u001a\u0015\u0010\n\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\f\u001a\u00020\u000eH\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\rH\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0011*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0005H\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000eH\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u000f\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0006H\u0086\n\u001a\u0015\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u0012\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\rH\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0005H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000eH\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0006H\u0086\n\u001a\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0005H\u0086\n\u001a\u0015\u0010\u0014\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0006H\u0086\n\u001a\u0015\u0010\u0014\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0005H\u0086\n\u001a\r\u0010\u0016\u001a\u00020\u0001*\u00020\u0003H\u0086\b\u001a\r\u0010\u0017\u001a\u00020\u0003*\u00020\u0001H\u0086\b\u001a\r\u0010\u0018\u001a\u00020\u0011*\u00020\u0001H\u0086\b\u001a\r\u0010\u0018\u001a\u00020\u0011*\u00020\u0003H\u0086\b\u001a\u0015\u0010\u0019\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u001bH\u0086\b\u001a\u0015\u0010\u001c\u001a\u00020\u0011*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u001c\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f¨\u0006\u001d"}, d2 = {"and", "Landroid/graphics/Rect;", "r", "Landroid/graphics/RectF;", "component1", "", "", "component2", "component3", "component4", "contains", "", "p", "Landroid/graphics/Point;", "Landroid/graphics/PointF;", "minus", "xy", "Landroid/graphics/Region;", "or", "plus", "times", "factor", "toRect", "toRectF", "toRegion", "transform", com.anythink.expressad.d.a.b.dH, "Landroid/graphics/Matrix;", "xor", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class RectKt {
    @android.annotation.SuppressLint({"CheckResult"})
    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Rect and(@org.jetbrains.annotations.NotNull android.graphics.Rect and, @org.jetbrains.annotations.NotNull android.graphics.Rect r) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(and, "$this$and");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r, "r");
        android.graphics.Rect rect = new android.graphics.Rect(and);
        rect.intersect(r);
        return rect;
    }

    @android.annotation.SuppressLint({"CheckResult"})
    @org.jetbrains.annotations.NotNull
    public static final android.graphics.RectF and(@org.jetbrains.annotations.NotNull android.graphics.RectF and, @org.jetbrains.annotations.NotNull android.graphics.RectF r) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(and, "$this$and");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r, "r");
        android.graphics.RectF rectF = new android.graphics.RectF(and);
        rectF.intersect(r);
        return rectF;
    }

    public static final float component1(@org.jetbrains.annotations.NotNull android.graphics.RectF component1) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(component1, "$this$component1");
        return component1.left;
    }

    public static final int component1(@org.jetbrains.annotations.NotNull android.graphics.Rect component1) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(component1, "$this$component1");
        return component1.left;
    }

    public static final float component2(@org.jetbrains.annotations.NotNull android.graphics.RectF component2) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(component2, "$this$component2");
        return component2.top;
    }

    public static final int component2(@org.jetbrains.annotations.NotNull android.graphics.Rect component2) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(component2, "$this$component2");
        return component2.top;
    }

    public static final float component3(@org.jetbrains.annotations.NotNull android.graphics.RectF component3) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(component3, "$this$component3");
        return component3.right;
    }

    public static final int component3(@org.jetbrains.annotations.NotNull android.graphics.Rect component3) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(component3, "$this$component3");
        return component3.right;
    }

    public static final float component4(@org.jetbrains.annotations.NotNull android.graphics.RectF component4) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(component4, "$this$component4");
        return component4.bottom;
    }

    public static final int component4(@org.jetbrains.annotations.NotNull android.graphics.Rect component4) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(component4, "$this$component4");
        return component4.bottom;
    }

    public static final boolean contains(@org.jetbrains.annotations.NotNull android.graphics.Rect contains, @org.jetbrains.annotations.NotNull android.graphics.Point p) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(p, "p");
        return contains.contains(p.x, p.y);
    }

    public static final boolean contains(@org.jetbrains.annotations.NotNull android.graphics.RectF contains, @org.jetbrains.annotations.NotNull android.graphics.PointF p) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(p, "p");
        return contains.contains(p.x, p.y);
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Rect minus(@org.jetbrains.annotations.NotNull android.graphics.Rect minus, int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(minus, "$this$minus");
        android.graphics.Rect rect = new android.graphics.Rect(minus);
        int i2 = -i;
        rect.offset(i2, i2);
        return rect;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Rect minus(@org.jetbrains.annotations.NotNull android.graphics.Rect minus, @org.jetbrains.annotations.NotNull android.graphics.Point xy) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(minus, "$this$minus");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(xy, "xy");
        android.graphics.Rect rect = new android.graphics.Rect(minus);
        rect.offset(-xy.x, -xy.y);
        return rect;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.RectF minus(@org.jetbrains.annotations.NotNull android.graphics.RectF minus, float f) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(minus, "$this$minus");
        android.graphics.RectF rectF = new android.graphics.RectF(minus);
        float f2 = -f;
        rectF.offset(f2, f2);
        return rectF;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.RectF minus(@org.jetbrains.annotations.NotNull android.graphics.RectF minus, @org.jetbrains.annotations.NotNull android.graphics.PointF xy) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(minus, "$this$minus");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(xy, "xy");
        android.graphics.RectF rectF = new android.graphics.RectF(minus);
        rectF.offset(-xy.x, -xy.y);
        return rectF;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Region minus(@org.jetbrains.annotations.NotNull android.graphics.Rect minus, @org.jetbrains.annotations.NotNull android.graphics.Rect r) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(minus, "$this$minus");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r, "r");
        android.graphics.Region region = new android.graphics.Region(minus);
        region.op(r, android.graphics.Region.Op.DIFFERENCE);
        return region;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Region minus(@org.jetbrains.annotations.NotNull android.graphics.RectF minus, @org.jetbrains.annotations.NotNull android.graphics.RectF r) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(minus, "$this$minus");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r, "r");
        android.graphics.Rect rect = new android.graphics.Rect();
        minus.roundOut(rect);
        android.graphics.Region region = new android.graphics.Region(rect);
        android.graphics.Rect rect2 = new android.graphics.Rect();
        r.roundOut(rect2);
        region.op(rect2, android.graphics.Region.Op.DIFFERENCE);
        return region;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Rect or(@org.jetbrains.annotations.NotNull android.graphics.Rect or, @org.jetbrains.annotations.NotNull android.graphics.Rect r) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(or, "$this$or");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r, "r");
        android.graphics.Rect rect = new android.graphics.Rect(or);
        rect.union(r);
        return rect;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.RectF or(@org.jetbrains.annotations.NotNull android.graphics.RectF or, @org.jetbrains.annotations.NotNull android.graphics.RectF r) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(or, "$this$or");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r, "r");
        android.graphics.RectF rectF = new android.graphics.RectF(or);
        rectF.union(r);
        return rectF;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Rect plus(@org.jetbrains.annotations.NotNull android.graphics.Rect plus, int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        android.graphics.Rect rect = new android.graphics.Rect(plus);
        rect.offset(i, i);
        return rect;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Rect plus(@org.jetbrains.annotations.NotNull android.graphics.Rect plus, @org.jetbrains.annotations.NotNull android.graphics.Point xy) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(xy, "xy");
        android.graphics.Rect rect = new android.graphics.Rect(plus);
        rect.offset(xy.x, xy.y);
        return rect;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Rect plus(@org.jetbrains.annotations.NotNull android.graphics.Rect plus, @org.jetbrains.annotations.NotNull android.graphics.Rect r) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r, "r");
        android.graphics.Rect rect = new android.graphics.Rect(plus);
        rect.union(r);
        return rect;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.RectF plus(@org.jetbrains.annotations.NotNull android.graphics.RectF plus, float f) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        android.graphics.RectF rectF = new android.graphics.RectF(plus);
        rectF.offset(f, f);
        return rectF;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.RectF plus(@org.jetbrains.annotations.NotNull android.graphics.RectF plus, @org.jetbrains.annotations.NotNull android.graphics.PointF xy) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(xy, "xy");
        android.graphics.RectF rectF = new android.graphics.RectF(plus);
        rectF.offset(xy.x, xy.y);
        return rectF;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.RectF plus(@org.jetbrains.annotations.NotNull android.graphics.RectF plus, @org.jetbrains.annotations.NotNull android.graphics.RectF r) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r, "r");
        android.graphics.RectF rectF = new android.graphics.RectF(plus);
        rectF.union(r);
        return rectF;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Rect times(@org.jetbrains.annotations.NotNull android.graphics.Rect times, int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(times, "$this$times");
        android.graphics.Rect rect = new android.graphics.Rect(times);
        rect.top *= i;
        rect.left *= i;
        rect.right *= i;
        rect.bottom *= i;
        return rect;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.RectF times(@org.jetbrains.annotations.NotNull android.graphics.RectF times, float f) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(times, "$this$times");
        android.graphics.RectF rectF = new android.graphics.RectF(times);
        rectF.top *= f;
        rectF.left *= f;
        rectF.right *= f;
        rectF.bottom *= f;
        return rectF;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.RectF times(@org.jetbrains.annotations.NotNull android.graphics.RectF times, int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(times, "$this$times");
        float f = i;
        android.graphics.RectF rectF = new android.graphics.RectF(times);
        rectF.top *= f;
        rectF.left *= f;
        rectF.right *= f;
        rectF.bottom *= f;
        return rectF;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Rect toRect(@org.jetbrains.annotations.NotNull android.graphics.RectF toRect) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(toRect, "$this$toRect");
        android.graphics.Rect rect = new android.graphics.Rect();
        toRect.roundOut(rect);
        return rect;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.RectF toRectF(@org.jetbrains.annotations.NotNull android.graphics.Rect toRectF) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(toRectF, "$this$toRectF");
        return new android.graphics.RectF(toRectF);
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Region toRegion(@org.jetbrains.annotations.NotNull android.graphics.Rect toRegion) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(toRegion, "$this$toRegion");
        return new android.graphics.Region(toRegion);
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Region toRegion(@org.jetbrains.annotations.NotNull android.graphics.RectF toRegion) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(toRegion, "$this$toRegion");
        android.graphics.Rect rect = new android.graphics.Rect();
        toRegion.roundOut(rect);
        return new android.graphics.Region(rect);
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.RectF transform(@org.jetbrains.annotations.NotNull android.graphics.RectF transform, @org.jetbrains.annotations.NotNull android.graphics.Matrix m) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(transform, "$this$transform");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(m, "m");
        m.mapRect(transform);
        return transform;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Region xor(@org.jetbrains.annotations.NotNull android.graphics.Rect xor, @org.jetbrains.annotations.NotNull android.graphics.Rect r) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(xor, "$this$xor");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r, "r");
        android.graphics.Region region = new android.graphics.Region(xor);
        region.op(r, android.graphics.Region.Op.XOR);
        return region;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Region xor(@org.jetbrains.annotations.NotNull android.graphics.RectF xor, @org.jetbrains.annotations.NotNull android.graphics.RectF r) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(xor, "$this$xor");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r, "r");
        android.graphics.Rect rect = new android.graphics.Rect();
        xor.roundOut(rect);
        android.graphics.Region region = new android.graphics.Region(rect);
        android.graphics.Rect rect2 = new android.graphics.Rect();
        r.roundOut(rect2);
        region.op(rect2, android.graphics.Region.Op.XOR);
        return region;
    }
}
