package com.otaliastudios.opengl.draw;

@kotlin.Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0086D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/otaliastudios/opengl/draw/Gl3dDrawable;", "Lcom/otaliastudios/opengl/draw/GlDrawable;", "", "f", "I", "getCoordsPerVertex", "()I", "coordsPerVertex", "<init>", "()V", "egloo-metadata_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes19.dex */
public abstract class Gl3dDrawable extends com.otaliastudios.opengl.draw.GlDrawable {

    /* renamed from: f, reason: from kotlin metadata */
    public final int coordsPerVertex = 3;

    @Override // com.otaliastudios.opengl.draw.GlDrawable
    public final int getCoordsPerVertex() {
        return this.coordsPerVertex;
    }
}
