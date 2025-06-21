package com.otaliastudios.opengl.draw;

@kotlin.Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017J\u0014\u0010\u0005\u001a\u00020\u00042\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007H\u0017J\u0012\u0010\t\u001a\u00020\u00042\n\u0010\b\u001a\u00060\u0006j\u0002`\u0007J&\u0010\t\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nJ\b\u0010\u000f\u001a\u00020\u0004H\u0016R&\u0010\u0017\u001a\u00060\u0010j\u0002`\u00118\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0005\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/otaliastudios/opengl/draw/GlRect;", "Lcom/otaliastudios/opengl/draw/Gl2dDrawable;", "", "array", "", "setVertexArray", "Landroid/graphics/RectF;", "Lcom/otaliastudios/opengl/geometry/RectF;", "rect", "setRect", "", com.sensorsdata.sf.ui.view.UIProperty.left, com.sensorsdata.sf.ui.view.UIProperty.top, com.sensorsdata.sf.ui.view.UIProperty.right, com.sensorsdata.sf.ui.view.UIProperty.bottom, com.bytedance.sdk.openadsdk.mediation.MediationConstant.RIT_TYPE_DRAW, "Ljava/nio/FloatBuffer;", "Lcom/otaliastudios/opengl/types/FloatBuffer;", "g", "Ljava/nio/FloatBuffer;", "getVertexArray", "()Ljava/nio/FloatBuffer;", "(Ljava/nio/FloatBuffer;)V", "vertexArray", "<init>", "()V", "i", "Companion", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes19.dex */
public class GlRect extends com.otaliastudios.opengl.draw.Gl2dDrawable {

    /* renamed from: g, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public java.nio.FloatBuffer vertexArray;
    public static final float[] h = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    public GlRect() {
        float[] fArr = h;
        java.nio.FloatBuffer floatBuffer = com.otaliastudios.opengl.types.BuffersJvmKt.floatBuffer(fArr.length);
        floatBuffer.put(fArr);
        floatBuffer.clear();
        kotlin.Unit unit = kotlin.Unit.INSTANCE;
        this.vertexArray = floatBuffer;
    }

    @Override // com.otaliastudios.opengl.draw.GlDrawable
    public void draw() {
        com.otaliastudios.opengl.core.Egloo.checkGlError("glDrawArrays start");
        android.opengl.GLES20.glDrawArrays(com.otaliastudios.opengl.internal.GlKt.getGL_TRIANGLE_STRIP(), 0, getVertexCount());
        com.otaliastudios.opengl.core.Egloo.checkGlError("glDrawArrays end");
    }

    @Override // com.otaliastudios.opengl.draw.GlDrawable
    @org.jetbrains.annotations.NotNull
    public java.nio.FloatBuffer getVertexArray() {
        return this.vertexArray;
    }

    public final void setRect(float left, float top, float right, float bottom) {
        getVertexArray().clear();
        getVertexArray().put(left);
        getVertexArray().put(bottom);
        getVertexArray().put(right);
        getVertexArray().put(bottom);
        getVertexArray().put(left);
        getVertexArray().put(top);
        getVertexArray().put(right);
        getVertexArray().put(top);
        getVertexArray().flip();
        notifyVertexArrayChange();
    }

    public final void setRect(@org.jetbrains.annotations.NotNull android.graphics.RectF rect) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(rect, "rect");
        setRect(rect.left, rect.top, rect.right, rect.bottom);
    }

    @kotlin.Deprecated(message = "Use setRect", replaceWith = @kotlin.ReplaceWith(expression = "setRect(rect)", imports = {}))
    public void setVertexArray(@org.jetbrains.annotations.NotNull android.graphics.RectF rect) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(rect, "rect");
        setRect(rect);
    }

    @Override // com.otaliastudios.opengl.draw.GlDrawable
    public void setVertexArray(@org.jetbrains.annotations.NotNull java.nio.FloatBuffer floatBuffer) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(floatBuffer, "<set-?>");
        this.vertexArray = floatBuffer;
    }

    @kotlin.Deprecated(message = "Use setRect", replaceWith = @kotlin.ReplaceWith(expression = "setRect(rect)", imports = {}))
    public void setVertexArray(@org.jetbrains.annotations.NotNull float[] array) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(array, "array");
        if (array.length != getCoordsPerVertex() * 4) {
            throw new java.lang.IllegalArgumentException("Vertex array should have 8 values.");
        }
        getVertexArray().clear();
        getVertexArray().put(array);
        getVertexArray().flip();
        notifyVertexArrayChange();
    }
}
