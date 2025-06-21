package com.otaliastudios.opengl.geometry;

@kotlin.Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016B\u0019\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u0017¢\u0006\u0004\b\u0015\u0010\u0018J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\u000e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005R\u0017\u0010\f\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/otaliastudios/opengl/geometry/IndexedSegmentF;", "Lcom/otaliastudios/opengl/geometry/SegmentF;", "other", "", "intersects", "", "index", "hasIndex", "f", "I", "getI", "()I", "i", "g", "getJ", "j", "", "ix", "iy", "jx", "jy", "<init>", "(IIFFFF)V", "Lcom/otaliastudios/opengl/geometry/IndexedPointF;", "(Lcom/otaliastudios/opengl/geometry/IndexedPointF;Lcom/otaliastudios/opengl/geometry/IndexedPointF;)V", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes19.dex */
public final class IndexedSegmentF extends com.otaliastudios.opengl.geometry.SegmentF {

    /* renamed from: f, reason: from kotlin metadata */
    public final int i;

    /* renamed from: g, reason: from kotlin metadata */
    public final int j;

    public IndexedSegmentF(int i, int i2, float f, float f2, float f3, float f4) {
        super(f, f2, f3, f4);
        this.i = i;
        this.j = i2;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IndexedSegmentF(@org.jetbrains.annotations.NotNull com.otaliastudios.opengl.geometry.IndexedPointF i, @org.jetbrains.annotations.NotNull com.otaliastudios.opengl.geometry.IndexedPointF j) {
        this(i.getIndex(), j.getIndex(), ((android.graphics.PointF) i).x, ((android.graphics.PointF) i).y, ((android.graphics.PointF) j).x, ((android.graphics.PointF) j).y);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(i, "i");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(j, "j");
    }

    public final int getI() {
        return this.i;
    }

    public final int getJ() {
        return this.j;
    }

    public final boolean hasIndex(int index) {
        return index == this.i || index == this.j;
    }

    @Override // com.otaliastudios.opengl.geometry.SegmentF
    public boolean intersects(@org.jetbrains.annotations.NotNull com.otaliastudios.opengl.geometry.SegmentF other) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(other, "other");
        if (other instanceof com.otaliastudios.opengl.geometry.IndexedSegmentF) {
            com.otaliastudios.opengl.geometry.IndexedSegmentF indexedSegmentF = (com.otaliastudios.opengl.geometry.IndexedSegmentF) other;
            if (indexedSegmentF.hasIndex(this.i) && indexedSegmentF.hasIndex(this.j)) {
                return true;
            }
            if (indexedSegmentF.hasIndex(this.i) || indexedSegmentF.hasIndex(this.j)) {
                return false;
            }
        }
        return super.intersects(other);
    }
}
