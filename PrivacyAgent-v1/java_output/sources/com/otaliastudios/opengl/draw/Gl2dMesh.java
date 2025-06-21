package com.otaliastudios.opengl.draw;

@kotlin.Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002J\"\u0010\u0007\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\u0016\u0010\u000f\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0002H\u0002R&\u0010\u0018\u001a\u00060\u0010j\u0002`\u00118\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001d\u001a\n\u0018\u00010\u0019j\u0004\u0018\u0001`\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/otaliastudios/opengl/draw/Gl2dMesh;", "Lcom/otaliastudios/opengl/draw/Gl2dDrawable;", "", "Landroid/graphics/PointF;", "Lcom/otaliastudios/opengl/geometry/PointF;", "points", "", "setPoints", "", "x", "y", com.bytedance.sdk.openadsdk.mediation.MediationConstant.RIT_TYPE_DRAW, "release", "Lcom/otaliastudios/opengl/geometry/IndexedSegmentF;", com.ss.android.socialbase.downloader.constants.DBDefinition.SEGMENT_TABLE_NAME, "a", "Ljava/nio/FloatBuffer;", "Lcom/otaliastudios/opengl/types/FloatBuffer;", "g", "Ljava/nio/FloatBuffer;", "getVertexArray", "()Ljava/nio/FloatBuffer;", "setVertexArray", "(Ljava/nio/FloatBuffer;)V", "vertexArray", "Ljava/nio/ByteBuffer;", "Lcom/otaliastudios/opengl/types/ByteBuffer;", "h", "Ljava/nio/ByteBuffer;", "vertexIndices", "<init>", "()V", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes19.dex */
public class Gl2dMesh extends com.otaliastudios.opengl.draw.Gl2dDrawable {

    /* renamed from: g, reason: from kotlin metadata */
    @org.jetbrains.annotations.NotNull
    public java.nio.FloatBuffer vertexArray = com.otaliastudios.opengl.types.BuffersJvmKt.floatBuffer(6);

    /* renamed from: h, reason: from kotlin metadata */
    public java.nio.ByteBuffer vertexIndices;

    public final void a(java.util.List<com.otaliastudios.opengl.geometry.IndexedSegmentF> segments) {
        int i;
        float ix;
        float iy;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int size = segments.size();
        int i2 = 0;
        while (i2 < size) {
            com.otaliastudios.opengl.geometry.IndexedSegmentF indexedSegmentF = segments.get(i2);
            i2++;
            int size2 = segments.size();
            boolean z = false;
            boolean z2 = false;
            for (int i3 = i2; i3 < size2 && (!z || !z2); i3++) {
                com.otaliastudios.opengl.geometry.IndexedSegmentF indexedSegmentF2 = segments.get(i3);
                if (indexedSegmentF.hasIndex(indexedSegmentF2.getI())) {
                    i = indexedSegmentF2.getJ();
                    ix = indexedSegmentF2.getJx();
                    iy = indexedSegmentF2.getJy();
                } else if (indexedSegmentF.hasIndex(indexedSegmentF2.getJ())) {
                    i = indexedSegmentF2.getI();
                    ix = indexedSegmentF2.getIx();
                    iy = indexedSegmentF2.getIy();
                }
                int orientation = indexedSegmentF.orientation(ix, iy);
                if (orientation != 0 && ((orientation <= 0 || !z) && (orientation >= 0 || !z2))) {
                    int size3 = segments.size();
                    for (int i4 = i3 + 1; i4 < size3; i4++) {
                        com.otaliastudios.opengl.geometry.IndexedSegmentF indexedSegmentF3 = segments.get(i4);
                        if (indexedSegmentF3.hasIndex(i) && (indexedSegmentF3.hasIndex(indexedSegmentF.getI()) || indexedSegmentF3.hasIndex(indexedSegmentF.getJ()))) {
                            arrayList.add(java.lang.Byte.valueOf((byte) indexedSegmentF.getI()));
                            arrayList.add(java.lang.Byte.valueOf((byte) indexedSegmentF.getJ()));
                            arrayList.add(java.lang.Byte.valueOf((byte) i));
                            if (orientation > 0) {
                                z = true;
                            }
                            if (orientation < 0) {
                                z2 = true;
                            }
                        }
                    }
                }
            }
        }
        java.nio.ByteBuffer byteBuffer = this.vertexIndices;
        if (byteBuffer != null) {
            com.otaliastudios.opengl.types.BuffersKt.dispose(byteBuffer);
        }
        java.nio.ByteBuffer byteBuffer2 = com.otaliastudios.opengl.types.BuffersJvmKt.byteBuffer(arrayList.size());
        java.util.Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            byteBuffer2.put(((java.lang.Number) it.next()).byteValue());
        }
        byteBuffer2.clear();
        kotlin.Unit unit = kotlin.Unit.INSTANCE;
        this.vertexIndices = byteBuffer2;
    }

    @Override // com.otaliastudios.opengl.draw.GlDrawable
    public void draw() {
        java.nio.ByteBuffer byteBuffer = this.vertexIndices;
        if (byteBuffer != null) {
            com.otaliastudios.opengl.core.Egloo.checkGlError("glDrawElements start");
            android.opengl.GLES20.glDrawElements(com.otaliastudios.opengl.internal.GlKt.getGL_TRIANGLES(), byteBuffer.limit(), com.otaliastudios.opengl.internal.GlKt.getGL_UNSIGNED_BYTE(), byteBuffer);
            com.otaliastudios.opengl.core.Egloo.checkGlError("glDrawElements end");
        }
    }

    @Override // com.otaliastudios.opengl.draw.GlDrawable
    @org.jetbrains.annotations.NotNull
    public java.nio.FloatBuffer getVertexArray() {
        return this.vertexArray;
    }

    @Override // com.otaliastudios.opengl.draw.GlDrawable
    public void release() {
        super.release();
        java.nio.ByteBuffer byteBuffer = this.vertexIndices;
        if (byteBuffer != null) {
            com.otaliastudios.opengl.types.BuffersKt.dispose(byteBuffer);
        }
    }

    public final void setPoints(@org.jetbrains.annotations.NotNull java.util.List<? extends android.graphics.PointF> points) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(points, "points");
        java.util.List<? extends android.graphics.PointF> list = points;
        java.util.ArrayList arrayList = new java.util.ArrayList(kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        java.util.Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(java.lang.Float.valueOf(((android.graphics.PointF) it.next()).x));
        }
        java.util.ArrayList arrayList2 = new java.util.ArrayList(kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        java.util.Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(java.lang.Float.valueOf(((android.graphics.PointF) it2.next()).y));
        }
        setPoints(arrayList, arrayList2);
    }

    public final void setPoints(@org.jetbrains.annotations.NotNull java.util.List<java.lang.Float> x, @org.jetbrains.annotations.NotNull java.util.List<java.lang.Float> y) {
        boolean z;
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(x, "x");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(y, "y");
        if (x.size() != y.size()) {
            throw new java.lang.IllegalArgumentException("x.size != y.size");
        }
        int size = x.size();
        int i = size * 2;
        if (getVertexArray().capacity() < i) {
            com.otaliastudios.opengl.types.BuffersKt.dispose(getVertexArray());
            setVertexArray(com.otaliastudios.opengl.types.BuffersJvmKt.floatBuffer(i));
        } else {
            getVertexArray().clear();
        }
        java.util.ArrayList<com.otaliastudios.opengl.geometry.IndexedSegmentF> arrayList = new java.util.ArrayList();
        int i2 = 0;
        while (i2 < size) {
            float floatValue = x.get(i2).floatValue();
            float floatValue2 = y.get(i2).floatValue();
            getVertexArray().put(floatValue);
            getVertexArray().put(floatValue2);
            int i3 = i2 + 1;
            for (int i4 = i3; i4 < size; i4++) {
                arrayList.add(new com.otaliastudios.opengl.geometry.IndexedSegmentF(i2, i4, floatValue, floatValue2, x.get(i4).floatValue(), y.get(i4).floatValue()));
            }
            i2 = i3;
        }
        getVertexArray().flip();
        notifyVertexArrayChange();
        if (arrayList.size() > 1) {
            kotlin.collections.CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, new com.otaliastudios.opengl.draw.Gl2dMesh$setPoints$$inlined$sortBy$1());
        }
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        for (com.otaliastudios.opengl.geometry.IndexedSegmentF indexedSegmentF : arrayList) {
            if (!arrayList2.isEmpty()) {
                java.util.Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    if (((com.otaliastudios.opengl.geometry.IndexedSegmentF) it.next()).intersects(indexedSegmentF)) {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            if (z) {
                arrayList2.add(indexedSegmentF);
            }
        }
        a(arrayList2);
    }

    @Override // com.otaliastudios.opengl.draw.GlDrawable
    public void setVertexArray(@org.jetbrains.annotations.NotNull java.nio.FloatBuffer floatBuffer) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(floatBuffer, "<set-?>");
        this.vertexArray = floatBuffer;
    }
}
