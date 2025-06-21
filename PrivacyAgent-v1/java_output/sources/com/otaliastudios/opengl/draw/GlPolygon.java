package com.otaliastudios.opengl.draw;

@kotlin.Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00100\u001a\u00020-¢\u0006\u0004\b8\u00109J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\tR\u0016\u0010\u0010\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\tR*\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00078\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00078\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R*\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00078\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\t\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016R*\u0010#\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00078\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\t\u001a\u0004\b!\u0010\u0014\"\u0004\b\"\u0010\u0016R&\u0010,\u001a\u00060$j\u0002`%8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R,\u00107\u001a\u000601j\u0002`22\n\u0010\u0011\u001a\u000601j\u0002`28F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006:"}, d2 = {"Lcom/otaliastudios/opengl/draw/GlPolygon;", "Lcom/otaliastudios/opengl/draw/Gl2dDrawable;", "", "onViewportSizeChanged", com.bytedance.sdk.openadsdk.mediation.MediationConstant.RIT_TYPE_DRAW, "b", "a", "", "g", "F", "viewportTranslationX", "h", "viewportTranslationY", "i", "viewportScaleX", "j", "viewportScaleY", "value", "k", "getRadius", "()F", "setRadius", "(F)V", "radius", "l", "getRotation", "setRotation", "rotation", com.anythink.expressad.d.a.b.dH, "getCenterX", "setCenterX", "centerX", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "getCenterY", "setCenterY", "centerY", "Ljava/nio/FloatBuffer;", "Lcom/otaliastudios/opengl/types/FloatBuffer;", "o", "Ljava/nio/FloatBuffer;", "getVertexArray", "()Ljava/nio/FloatBuffer;", "setVertexArray", "(Ljava/nio/FloatBuffer;)V", "vertexArray", "", "p", "I", "sides", "Landroid/graphics/PointF;", "Lcom/otaliastudios/opengl/geometry/PointF;", "getCenter", "()Landroid/graphics/PointF;", "setCenter", "(Landroid/graphics/PointF;)V", "center", "<init>", "(I)V", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes19.dex */
public class GlPolygon extends com.otaliastudios.opengl.draw.Gl2dDrawable {

    /* renamed from: g, reason: from kotlin metadata */
    public float viewportTranslationX;

    /* renamed from: h, reason: from kotlin metadata */
    public float viewportTranslationY;

    /* renamed from: i, reason: from kotlin metadata */
    public float viewportScaleX;

    /* renamed from: j, reason: from kotlin metadata */
    public float viewportScaleY;

    /* renamed from: k, reason: from kotlin metadata */
    public float radius;

    /* renamed from: l, reason: from kotlin metadata */
    public float rotation;

    /* renamed from: m, reason: from kotlin metadata */
    public float centerX;

    /* renamed from: n, reason: from kotlin metadata */
    public float centerY;

    /* renamed from: o, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public java.nio.FloatBuffer vertexArray;

    /* renamed from: p, reason: from kotlin metadata */
    public final int sides;

    public GlPolygon(int i) {
        this.sides = i;
        if (i < 3) {
            throw new java.lang.IllegalArgumentException("Polygon should have at least 3 sides.");
        }
        this.viewportScaleX = 1.0f;
        this.viewportScaleY = 1.0f;
        this.radius = 1.0f;
        this.vertexArray = com.otaliastudios.opengl.types.BuffersJvmKt.floatBuffer((i + 2) * getCoordsPerVertex());
        b();
    }

    public final void a() {
        com.otaliastudios.opengl.extensions.MatrixKt.scale$default(getModelMatrix(), 1.0f / this.viewportScaleX, 1.0f / this.viewportScaleY, 0.0f, 4, null);
        com.otaliastudios.opengl.extensions.MatrixKt.translate$default(getModelMatrix(), -this.viewportTranslationX, -this.viewportTranslationY, 0.0f, 4, null);
        if (getViewportWidth() > getViewportHeight()) {
            float viewportHeight = getViewportHeight() / getViewportWidth();
            this.viewportScaleX = viewportHeight;
            this.viewportScaleY = 1.0f;
            this.viewportTranslationX = this.centerX * (1 - viewportHeight);
            this.viewportTranslationY = 0.0f;
        } else if (getViewportWidth() < getViewportHeight()) {
            float viewportWidth = getViewportWidth() / getViewportHeight();
            this.viewportScaleY = viewportWidth;
            this.viewportScaleX = 1.0f;
            this.viewportTranslationY = this.centerY * (1 - viewportWidth);
            this.viewportTranslationX = 0.0f;
        } else {
            this.viewportScaleX = 1.0f;
            this.viewportScaleY = 1.0f;
            this.viewportTranslationX = 0.0f;
            this.viewportTranslationY = 0.0f;
        }
        com.otaliastudios.opengl.extensions.MatrixKt.translate$default(getModelMatrix(), this.viewportTranslationX, this.viewportTranslationY, 0.0f, 4, null);
        com.otaliastudios.opengl.extensions.MatrixKt.scale$default(getModelMatrix(), this.viewportScaleX, this.viewportScaleY, 0.0f, 4, null);
    }

    public final void b() {
        java.nio.FloatBuffer vertexArray = getVertexArray();
        vertexArray.clear();
        vertexArray.put(this.centerX);
        vertexArray.put(this.centerY);
        float f = this.rotation * ((float) 0.017453292519943295d);
        int i = this.sides;
        float f2 = ((float) 6.283185307179586d) / i;
        for (int i2 = 0; i2 < i; i2++) {
            double d = f;
            vertexArray.put(this.centerX + (this.radius * ((float) java.lang.Math.cos(d))));
            vertexArray.put(this.centerY + (this.radius * ((float) java.lang.Math.sin(d))));
            f += f2;
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

    @org.jetbrains.annotations.NotNull
    public final android.graphics.PointF getCenter() {
        return new android.graphics.PointF(this.centerX, this.centerY);
    }

    public final float getCenterX() {
        return this.centerX;
    }

    public final float getCenterY() {
        return this.centerY;
    }

    public final float getRadius() {
        return this.radius;
    }

    public final float getRotation() {
        return this.rotation;
    }

    @Override // com.otaliastudios.opengl.draw.GlDrawable
    @org.jetbrains.annotations.NotNull
    public java.nio.FloatBuffer getVertexArray() {
        return this.vertexArray;
    }

    @Override // com.otaliastudios.opengl.core.GlViewportAware
    public void onViewportSizeChanged() {
        super.onViewportSizeChanged();
        a();
    }

    public final void setCenter(@org.jetbrains.annotations.NotNull android.graphics.PointF value) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(value, "value");
        setCenterX(value.x);
        setCenterY(value.y);
    }

    public final void setCenterX(float f) {
        this.centerX = f;
        b();
        a();
    }

    public final void setCenterY(float f) {
        this.centerY = f;
        b();
        a();
    }

    public final void setRadius(float f) {
        this.radius = f;
        b();
    }

    public final void setRotation(float f) {
        this.rotation = f % com.amap.api.maps.utils.SpatialRelationUtil.A_CIRCLE_DEGREE;
        b();
    }

    @Override // com.otaliastudios.opengl.draw.GlDrawable
    public void setVertexArray(@org.jetbrains.annotations.NotNull java.nio.FloatBuffer floatBuffer) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(floatBuffer, "<set-?>");
        this.vertexArray = floatBuffer;
    }
}
