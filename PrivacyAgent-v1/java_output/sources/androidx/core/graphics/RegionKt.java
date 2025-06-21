package androidx.core.graphics;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0007\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\n\u001a0\u0010\b\u001a\u00020\t*\u00020\u00012!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t0\u000bH\u0086\b\u001a\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010*\u00020\u0001H\u0086\u0002\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\r\u0010\u0012\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0016\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0016\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f¨\u0006\u0017"}, d2 = {"and", "Landroid/graphics/Region;", "r", "Landroid/graphics/Rect;", "contains", "", "p", "Landroid/graphics/Point;", "forEach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "rect", "iterator", "", "minus", "not", "or", "plus", "unaryMinus", "xor", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class RegionKt {
    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Region and(@org.jetbrains.annotations.NotNull android.graphics.Region and, @org.jetbrains.annotations.NotNull android.graphics.Rect r) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(and, "$this$and");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r, "r");
        android.graphics.Region region = new android.graphics.Region(and);
        region.op(r, android.graphics.Region.Op.INTERSECT);
        return region;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Region and(@org.jetbrains.annotations.NotNull android.graphics.Region and, @org.jetbrains.annotations.NotNull android.graphics.Region r) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(and, "$this$and");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r, "r");
        android.graphics.Region region = new android.graphics.Region(and);
        region.op(r, android.graphics.Region.Op.INTERSECT);
        return region;
    }

    public static final boolean contains(@org.jetbrains.annotations.NotNull android.graphics.Region contains, @org.jetbrains.annotations.NotNull android.graphics.Point p) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(p, "p");
        return contains.contains(p.x, p.y);
    }

    public static final void forEach(@org.jetbrains.annotations.NotNull android.graphics.Region forEach, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super android.graphics.Rect, kotlin.Unit> action) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(forEach, "$this$forEach");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(action, "action");
        android.graphics.RegionIterator regionIterator = new android.graphics.RegionIterator(forEach);
        while (true) {
            android.graphics.Rect rect = new android.graphics.Rect();
            if (!regionIterator.next(rect)) {
                return;
            } else {
                action.invoke(rect);
            }
        }
    }

    @org.jetbrains.annotations.NotNull
    public static final java.util.Iterator<android.graphics.Rect> iterator(@org.jetbrains.annotations.NotNull android.graphics.Region iterator) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(iterator, "$this$iterator");
        return new androidx.core.graphics.RegionKt$iterator$1(iterator);
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Region minus(@org.jetbrains.annotations.NotNull android.graphics.Region minus, @org.jetbrains.annotations.NotNull android.graphics.Rect r) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(minus, "$this$minus");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r, "r");
        android.graphics.Region region = new android.graphics.Region(minus);
        region.op(r, android.graphics.Region.Op.DIFFERENCE);
        return region;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Region minus(@org.jetbrains.annotations.NotNull android.graphics.Region minus, @org.jetbrains.annotations.NotNull android.graphics.Region r) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(minus, "$this$minus");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r, "r");
        android.graphics.Region region = new android.graphics.Region(minus);
        region.op(r, android.graphics.Region.Op.DIFFERENCE);
        return region;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Region not(@org.jetbrains.annotations.NotNull android.graphics.Region not) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(not, "$this$not");
        android.graphics.Region region = new android.graphics.Region(not.getBounds());
        region.op(not, android.graphics.Region.Op.DIFFERENCE);
        return region;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Region or(@org.jetbrains.annotations.NotNull android.graphics.Region or, @org.jetbrains.annotations.NotNull android.graphics.Rect r) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(or, "$this$or");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r, "r");
        android.graphics.Region region = new android.graphics.Region(or);
        region.union(r);
        return region;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Region or(@org.jetbrains.annotations.NotNull android.graphics.Region or, @org.jetbrains.annotations.NotNull android.graphics.Region r) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(or, "$this$or");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r, "r");
        android.graphics.Region region = new android.graphics.Region(or);
        region.op(r, android.graphics.Region.Op.UNION);
        return region;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Region plus(@org.jetbrains.annotations.NotNull android.graphics.Region plus, @org.jetbrains.annotations.NotNull android.graphics.Rect r) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r, "r");
        android.graphics.Region region = new android.graphics.Region(plus);
        region.union(r);
        return region;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Region plus(@org.jetbrains.annotations.NotNull android.graphics.Region plus, @org.jetbrains.annotations.NotNull android.graphics.Region r) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r, "r");
        android.graphics.Region region = new android.graphics.Region(plus);
        region.op(r, android.graphics.Region.Op.UNION);
        return region;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Region unaryMinus(@org.jetbrains.annotations.NotNull android.graphics.Region unaryMinus) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(unaryMinus, "$this$unaryMinus");
        android.graphics.Region region = new android.graphics.Region(unaryMinus.getBounds());
        region.op(unaryMinus, android.graphics.Region.Op.DIFFERENCE);
        return region;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Region xor(@org.jetbrains.annotations.NotNull android.graphics.Region xor, @org.jetbrains.annotations.NotNull android.graphics.Rect r) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(xor, "$this$xor");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r, "r");
        android.graphics.Region region = new android.graphics.Region(xor);
        region.op(r, android.graphics.Region.Op.XOR);
        return region;
    }

    @org.jetbrains.annotations.NotNull
    public static final android.graphics.Region xor(@org.jetbrains.annotations.NotNull android.graphics.Region xor, @org.jetbrains.annotations.NotNull android.graphics.Region r) {
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(xor, "$this$xor");
        kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r, "r");
        android.graphics.Region region = new android.graphics.Region(xor);
        region.op(r, android.graphics.Region.Op.XOR);
        return region;
    }
}
