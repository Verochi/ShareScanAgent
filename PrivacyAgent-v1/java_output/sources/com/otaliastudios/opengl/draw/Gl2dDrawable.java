package com.otaliastudios.opengl.draw;

@kotlin.Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003R\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0086D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/otaliastudios/opengl/draw/Gl2dDrawable;", "Lcom/otaliastudios/opengl/draw/GlDrawable;", "Landroid/graphics/RectF;", "Lcom/otaliastudios/opengl/geometry/RectF;", "rect", "", "getBounds", "", "f", "I", "getCoordsPerVertex", "()I", "coordsPerVertex", "<init>", "()V", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes19.dex */
public abstract class Gl2dDrawable extends com.otaliastudios.opengl.draw.GlDrawable {

    /* renamed from: f, reason: from kotlin metadata */
    public final int coordsPerVertex = 2;

    public final void getBounds(@org.jetbrains.annotations.NotNull android.graphics.RectF rect) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(rect, "rect");
        float f = -3.4028235E38f;
        float f2 = -3.4028235E38f;
        float f3 = Float.MAX_VALUE;
        float f4 = Float.MAX_VALUE;
        int i = 0;
        while (getVertexArray().hasRemaining()) {
            float f5 = getVertexArray().get();
            if (i % 2 == 0) {
                f3 = java.lang.Math.min(f3, f5);
                f2 = java.lang.Math.max(f2, f5);
            } else {
                f = java.lang.Math.max(f, f5);
                f4 = java.lang.Math.min(f4, f5);
            }
            i++;
        }
        getVertexArray().rewind();
        rect.set(f3, f, f2, f4);
    }

    @Override // com.otaliastudios.opengl.draw.GlDrawable
    public final int getCoordsPerVertex() {
        return this.coordsPerVertex;
    }
}
