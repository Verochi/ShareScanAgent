package com.otaliastudios.opengl.draw;

@kotlin.Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b \b\u0016\u0018\u0000 52\u00020\u0001:\u00016B\u0007¢\u0006\u0004\b3\u00104J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J&\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002J\u0012\u0010\r\u001a\u00020\u00042\n\u0010\f\u001a\u00060\nj\u0002`\u000bJ&\u0010\r\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eJ\b\u0010\u0013\u001a\u00020\u0004H\u0014J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0002J<\u0010\u001e\u001a\u00020\u00042\n\u0010\u0018\u001a\u00060\u0016j\u0002`\u00172\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u0002H\u0002R\u0016\u0010!\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010%\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010 R\u0016\u0010'\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010 R\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010 R\u0016\u0010\u0012\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010 R\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010 R\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010 R&\u00102\u001a\u00060\u0016j\u0002`\u00178\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u00067"}, d2 = {"Lcom/otaliastudios/opengl/draw/GlRoundRect;", "Lcom/otaliastudios/opengl/draw/Gl2dDrawable;", "", "corners", "", "setCornersPx", "topLeft", "topRight", "bottomLeft", "bottomRight", "Landroid/graphics/RectF;", "Lcom/otaliastudios/opengl/geometry/RectF;", "rect", "setRect", "", com.sensorsdata.sf.ui.view.UIProperty.left, com.sensorsdata.sf.ui.view.UIProperty.top, com.sensorsdata.sf.ui.view.UIProperty.right, com.sensorsdata.sf.ui.view.UIProperty.bottom, "onViewportSizeChanged", com.bytedance.sdk.openadsdk.mediation.MediationConstant.RIT_TYPE_DRAW, "b", "Ljava/nio/FloatBuffer;", "Lcom/otaliastudios/opengl/types/FloatBuffer;", "array", "pivotX", "pivotY", "width", "height", "startAngle", "a", "g", "F", "topLeftCorner", "h", "topRightCorner", "i", "bottomLeftCorner", "j", "bottomRightCorner", "k", "l", com.anythink.expressad.d.a.b.dH, com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "o", "Ljava/nio/FloatBuffer;", "getVertexArray", "()Ljava/nio/FloatBuffer;", "setVertexArray", "(Ljava/nio/FloatBuffer;)V", "vertexArray", "<init>", "()V", "p", "Companion", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes19.dex */
public class GlRoundRect extends com.otaliastudios.opengl.draw.Gl2dDrawable {

    /* renamed from: g, reason: from kotlin metadata */
    public float topLeftCorner;

    /* renamed from: h, reason: from kotlin metadata */
    public float topRightCorner;

    /* renamed from: i, reason: from kotlin metadata */
    public float bottomLeftCorner;

    /* renamed from: j, reason: from kotlin metadata */
    public float bottomRightCorner;

    /* renamed from: k, reason: from kotlin metadata */
    public float top = 1.0f;

    /* renamed from: l, reason: from kotlin metadata */
    public float bottom = -1.0f;

    /* renamed from: m, reason: from kotlin metadata */
    public float left = -1.0f;

    /* renamed from: n, reason: from kotlin metadata */
    public float right = 1.0f;

    /* renamed from: o, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public java.nio.FloatBuffer vertexArray = com.otaliastudios.opengl.types.BuffersJvmKt.floatBuffer(getCoordsPerVertex() * 82);

    public GlRoundRect() {
        b();
    }

    public final void a(java.nio.FloatBuffer array, float pivotX, float pivotY, float width, float height, int startAngle) {
        int i = startAngle - 90;
        float f = 1.0f / 19;
        float f2 = 0.0f;
        for (int i2 = 0; i2 < 20; i2++) {
            double d = (float) (((startAngle + ((i - startAngle) * f2)) * 3.141592653589793d) / 180);
            double d2 = 2;
            float sqrt = (width * height) / ((float) java.lang.Math.sqrt(((float) java.lang.Math.pow(((float) java.lang.Math.sin(d)) * width, d2)) + ((float) java.lang.Math.pow(((float) java.lang.Math.cos(d)) * height, d2))));
            array.put(pivotX + (((float) java.lang.Math.cos(d)) * sqrt));
            array.put(pivotY + (sqrt * ((float) java.lang.Math.sin(d))));
            f2 += f;
        }
    }

    public final void b() {
        java.nio.FloatBuffer vertexArray = getVertexArray();
        vertexArray.clear();
        float f = (this.right + this.left) / 2.0f;
        float f2 = (this.top + this.bottom) / 2.0f;
        vertexArray.put(f);
        vertexArray.put(f2);
        boolean z = getViewportHeight() > 0 && getViewportWidth() > 0;
        if (z && this.topLeftCorner > 0.0f) {
            float viewportWidth = (this.topLeftCorner / getViewportWidth()) * 2.0f;
            float viewportHeight = (this.topLeftCorner / getViewportHeight()) * 2.0f;
            a(vertexArray, this.left + viewportWidth, this.top - viewportHeight, viewportWidth, viewportHeight, 180);
        } else {
            vertexArray.put(this.left);
            vertexArray.put(this.top);
        }
        if (z && this.topRightCorner > 0.0f) {
            float viewportWidth2 = (this.topRightCorner / getViewportWidth()) * 2.0f;
            float viewportHeight2 = (this.topRightCorner / getViewportHeight()) * 2.0f;
            a(vertexArray, this.right - viewportWidth2, this.top - viewportHeight2, viewportWidth2, viewportHeight2, 90);
        } else {
            vertexArray.put(this.right);
            vertexArray.put(this.top);
        }
        if (z && this.bottomRightCorner > 0.0f) {
            float viewportWidth3 = (this.bottomRightCorner / getViewportWidth()) * 2.0f;
            float viewportHeight3 = (this.bottomRightCorner / getViewportHeight()) * 2.0f;
            a(vertexArray, this.right - viewportWidth3, this.bottom + viewportHeight3, viewportWidth3, viewportHeight3, 0);
        } else {
            vertexArray.put(this.right);
            vertexArray.put(this.bottom);
        }
        if (z && this.bottomLeftCorner > 0.0f) {
            float viewportWidth4 = (this.bottomLeftCorner / getViewportWidth()) * 2.0f;
            float viewportHeight4 = (this.bottomLeftCorner / getViewportHeight()) * 2.0f;
            a(vertexArray, this.left + viewportWidth4, this.bottom + viewportHeight4, viewportWidth4, viewportHeight4, -90);
        } else {
            vertexArray.put(this.left);
            vertexArray.put(this.bottom);
        }
        vertexArray.put(vertexArray.get(2));
        vertexArray.put(vertexArray.get(3));
        vertexArray.flip();
        notifyVertexArrayChange();
    }

    @Override // com.otaliastudios.opengl.draw.GlDrawable
    public void draw() {
        android.opengl.GLES20.glDrawArrays(com.otaliastudios.opengl.internal.GlKt.getGL_TRIANGLE_FAN(), 0, getVertexCount());
        com.otaliastudios.opengl.core.Egloo.checkGlError("glDrawArrays");
    }

    @Override // com.otaliastudios.opengl.draw.GlDrawable
    @org.jetbrains.annotations.NotNull
    public java.nio.FloatBuffer getVertexArray() {
        return this.vertexArray;
    }

    @Override // com.otaliastudios.opengl.core.GlViewportAware
    public void onViewportSizeChanged() {
        super.onViewportSizeChanged();
        b();
    }

    public final void setCornersPx(int corners) {
        setCornersPx(corners, corners, corners, corners);
    }

    public final void setCornersPx(int topLeft, int topRight, int bottomLeft, int bottomRight) {
        this.topLeftCorner = topLeft;
        this.topRightCorner = topRight;
        this.bottomLeftCorner = bottomLeft;
        this.bottomRightCorner = bottomRight;
        b();
    }

    public final void setRect(float left, float top, float right, float bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
        b();
    }

    public final void setRect(@org.jetbrains.annotations.NotNull android.graphics.RectF rect) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(rect, "rect");
        setRect(rect.left, rect.top, rect.right, rect.bottom);
    }

    @Override // com.otaliastudios.opengl.draw.GlDrawable
    public void setVertexArray(@org.jetbrains.annotations.NotNull java.nio.FloatBuffer floatBuffer) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(floatBuffer, "<set-?>");
        this.vertexArray = floatBuffer;
    }
}
