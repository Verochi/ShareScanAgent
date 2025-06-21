package androidx.core.graphics;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\n\u001a\r\u0010\u0000\u001a\u00020\u0003*\u00020\u0004H\u0086\n\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0086\n\u001a\r\u0010\u0005\u001a\u00020\u0003*\u00020\u0004H\u0086\n\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0086\n\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0086\n\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\b\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\t\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0086\n\u001a\u0015\u0010\t\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0001H\u0086\n\u001a\u0015\u0010\t\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0086\n\u001a\u0015\u0010\t\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\b\u001a\u00020\u0003H\u0086\n\u001a\r\u0010\n\u001a\u00020\u0002*\u00020\u0004H\u0086\b\u001a\r\u0010\u000b\u001a\u00020\u0004*\u00020\u0002H\u0086\b\u001a\r\u0010\f\u001a\u00020\u0002*\u00020\u0002H\u0086\n\u001a\r\u0010\f\u001a\u00020\u0004*\u00020\u0004H\u0086\n¨\u0006\r"}, d2 = {"component1", "", "Landroid/graphics/Point;", "", "Landroid/graphics/PointF;", "component2", "minus", "p", "xy", "plus", "toPoint", "toPointF", "unaryMinus", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class PointKt {
    public static final float component1(@org.jetbrains.annotations.NotNull android.graphics.PointF component1) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(component1, "$this$component1");
        return component1.x;
    }

    public static final int component1(@org.jetbrains.annotations.NotNull android.graphics.Point component1) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(component1, "$this$component1");
        return component1.x;
    }

    public static final float component2(@org.jetbrains.annotations.NotNull android.graphics.PointF component2) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(component2, "$this$component2");
        return component2.y;
    }

    public static final int component2(@org.jetbrains.annotations.NotNull android.graphics.Point component2) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(component2, "$this$component2");
        return component2.y;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Point minus(@org.jetbrains.annotations.NotNull android.graphics.Point minus, int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(minus, "$this$minus");
        android.graphics.Point point = new android.graphics.Point(minus.x, minus.y);
        int i2 = -i;
        point.offset(i2, i2);
        return point;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Point minus(@org.jetbrains.annotations.NotNull android.graphics.Point minus, @org.jetbrains.annotations.NotNull android.graphics.Point p) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(minus, "$this$minus");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(p, "p");
        android.graphics.Point point = new android.graphics.Point(minus.x, minus.y);
        point.offset(-p.x, -p.y);
        return point;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.PointF minus(@org.jetbrains.annotations.NotNull android.graphics.PointF minus, float f) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(minus, "$this$minus");
        android.graphics.PointF pointF = new android.graphics.PointF(minus.x, minus.y);
        float f2 = -f;
        pointF.offset(f2, f2);
        return pointF;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.PointF minus(@org.jetbrains.annotations.NotNull android.graphics.PointF minus, @org.jetbrains.annotations.NotNull android.graphics.PointF p) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(minus, "$this$minus");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(p, "p");
        android.graphics.PointF pointF = new android.graphics.PointF(minus.x, minus.y);
        pointF.offset(-p.x, -p.y);
        return pointF;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Point plus(@org.jetbrains.annotations.NotNull android.graphics.Point plus, int i) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        android.graphics.Point point = new android.graphics.Point(plus.x, plus.y);
        point.offset(i, i);
        return point;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Point plus(@org.jetbrains.annotations.NotNull android.graphics.Point plus, @org.jetbrains.annotations.NotNull android.graphics.Point p) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(p, "p");
        android.graphics.Point point = new android.graphics.Point(plus.x, plus.y);
        point.offset(p.x, p.y);
        return point;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.PointF plus(@org.jetbrains.annotations.NotNull android.graphics.PointF plus, float f) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        android.graphics.PointF pointF = new android.graphics.PointF(plus.x, plus.y);
        pointF.offset(f, f);
        return pointF;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.PointF plus(@org.jetbrains.annotations.NotNull android.graphics.PointF plus, @org.jetbrains.annotations.NotNull android.graphics.PointF p) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(p, "p");
        android.graphics.PointF pointF = new android.graphics.PointF(plus.x, plus.y);
        pointF.offset(p.x, p.y);
        return pointF;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Point toPoint(@org.jetbrains.annotations.NotNull android.graphics.PointF toPoint) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(toPoint, "$this$toPoint");
        return new android.graphics.Point((int) toPoint.x, (int) toPoint.y);
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.PointF toPointF(@org.jetbrains.annotations.NotNull android.graphics.Point toPointF) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(toPointF, "$this$toPointF");
        return new android.graphics.PointF(toPointF);
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Point unaryMinus(@org.jetbrains.annotations.NotNull android.graphics.Point unaryMinus) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(unaryMinus, "$this$unaryMinus");
        return new android.graphics.Point(-unaryMinus.x, -unaryMinus.y);
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.PointF unaryMinus(@org.jetbrains.annotations.NotNull android.graphics.PointF unaryMinus) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(unaryMinus, "$this$unaryMinus");
        return new android.graphics.PointF(-unaryMinus.x, -unaryMinus.y);
    }
}
