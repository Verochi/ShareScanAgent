package com.otaliastudios.opengl.geometry;

@kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0018\u001a\u00020\u0005\u0012\u0006\u0010\u001b\u001a\u00020\u0005¢\u0006\u0004\b\u001c\u0010\u001dB!\b\u0016\u0012\n\u0010 \u001a\u00060\u001ej\u0002`\u001f\u0012\n\u0010!\u001a\u00060\u001ej\u0002`\u001f¢\u0006\u0004\b\u001c\u0010\"J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0016J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005R\u001b\u0010\u000e\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\rR\u0017\u0010\u0015\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\rR\u0017\u0010\u0018\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0017\u0010\rR\u0017\u0010\u001b\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0010\u001a\u0004\b\u001a\u0010\r¨\u0006#"}, d2 = {"Lcom/otaliastudios/opengl/geometry/SegmentF;", "", "other", "", "intersects", "", "x", "y", "", "orientation", "a", "Lkotlin/Lazy;", "getLength", "()F", "length", "b", "F", "getIx", "ix", "c", "getIy", "iy", "d", "getJx", "jx", "e", "getJy", "jy", "<init>", "(FFFF)V", "Landroid/graphics/PointF;", "Lcom/otaliastudios/opengl/geometry/PointF;", "i", "j", "(Landroid/graphics/PointF;Landroid/graphics/PointF;)V", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes19.dex */
public class SegmentF {

    /* renamed from: a, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public final kotlin.Lazy length;

    /* renamed from: b, reason: from kotlin metadata */
    public final float ix;

    /* renamed from: c, reason: from kotlin metadata */
    public final float iy;

    /* renamed from: d, reason: from kotlin metadata */
    public final float jx;

    /* renamed from: e, reason: from kotlin metadata */
    public final float jy;

    public SegmentF(float f, float f2, float f3, float f4) {
        kotlin.Lazy lazy;
        this.ix = f;
        this.iy = f2;
        this.jx = f3;
        this.jy = f4;
        lazy = kotlin.LazyKt__LazyJVMKt.lazy(new com.otaliastudios.opengl.geometry.SegmentF$length$2(this));
        this.length = lazy;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SegmentF(@org.jetbrains.annotations.NotNull android.graphics.PointF i, @org.jetbrains.annotations.NotNull android.graphics.PointF j) {
        this(i.x, i.y, j.x, j.y);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(i, "i");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(j, "j");
    }

    public final float getIx() {
        return this.ix;
    }

    public final float getIy() {
        return this.iy;
    }

    public final float getJx() {
        return this.jx;
    }

    public final float getJy() {
        return this.jy;
    }

    public final float getLength() {
        return ((java.lang.Number) this.length.getValue()).floatValue();
    }

    public boolean intersects(@org.jetbrains.annotations.NotNull com.otaliastudios.opengl.geometry.SegmentF other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        float min = java.lang.Math.min(this.ix, this.jx);
        float max = java.lang.Math.max(this.ix, this.jx);
        float min2 = java.lang.Math.min(other.ix, other.jx);
        float max2 = java.lang.Math.max(other.ix, other.jx);
        if (min > max2 || max < min2) {
            return false;
        }
        float min3 = java.lang.Math.min(this.iy, this.jy);
        float max3 = java.lang.Math.max(this.iy, this.jy);
        float min4 = java.lang.Math.min(other.iy, other.jy);
        float max4 = java.lang.Math.max(other.iy, other.jy);
        if (min3 > max4 || max3 < min4) {
            return false;
        }
        int orientation = orientation(other.ix, other.iy);
        int orientation2 = orientation(other.jx, other.jy);
        if (orientation > 0 && orientation2 > 0) {
            return false;
        }
        if (orientation < 0 && orientation2 < 0) {
            return false;
        }
        int orientation3 = other.orientation(this.ix, this.iy);
        int orientation4 = other.orientation(this.jx, this.jy);
        if (orientation3 > 0 && orientation4 > 0) {
            return false;
        }
        if (orientation3 < 0 && orientation4 < 0) {
            return false;
        }
        if (orientation == 0 && orientation2 == 0 && orientation3 == 0 && orientation4 == 0) {
            if (min == max2 && min3 == max4) {
                return false;
            }
            if (min == max2 && max3 == min4) {
                return false;
            }
            if (max == min2 && min3 == max4) {
                return false;
            }
            return (max == min2 && max3 == min4) ? false : true;
        }
        float f = this.ix;
        float f2 = other.ix;
        if (f == f2 && this.iy == other.iy) {
            return false;
        }
        float f3 = this.jx;
        float f4 = other.jx;
        if (f3 == f4 && this.jy == other.jy) {
            return false;
        }
        if (f == f4 && this.iy == other.jy) {
            return false;
        }
        return (f3 == f2 && this.jy == other.iy) ? false : true;
    }

    public final int orientation(float x, float y) {
        float f = this.jx;
        float f2 = f - this.ix;
        float f3 = this.jy;
        return (int) java.lang.Math.signum((f2 * (y - f3)) - ((f3 - this.iy) * (x - f)));
    }
}
