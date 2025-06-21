package com.esotericsoftware.spine.attachments;

/* loaded from: classes22.dex */
public class MeshAttachment extends com.esotericsoftware.spine.attachments.VertexAttachment {
    public com.badlogic.gdx.graphics.g2d.TextureRegion g;
    public java.lang.String h;
    public float[] i;
    public float[] j;
    public short[] k;
    public final com.badlogic.gdx.graphics.Color l;
    public int m;
    public com.esotericsoftware.spine.attachments.MeshAttachment n;
    public boolean o;
    public short[] p;
    public float q;
    public float r;

    public MeshAttachment(java.lang.String str) {
        super(str);
        this.l = new com.badlogic.gdx.graphics.Color(1.0f, 1.0f, 1.0f, 1.0f);
    }

    @Override // com.esotericsoftware.spine.attachments.VertexAttachment
    public boolean applyDeform(com.esotericsoftware.spine.attachments.VertexAttachment vertexAttachment) {
        return this == vertexAttachment || (this.o && this.n == vertexAttachment);
    }

    public com.badlogic.gdx.graphics.Color getColor() {
        return this.l;
    }

    public short[] getEdges() {
        return this.p;
    }

    public float getHeight() {
        return this.r;
    }

    public int getHullLength() {
        return this.m;
    }

    public boolean getInheritDeform() {
        return this.o;
    }

    public com.esotericsoftware.spine.attachments.MeshAttachment getParentMesh() {
        return this.n;
    }

    public java.lang.String getPath() {
        return this.h;
    }

    public com.badlogic.gdx.graphics.g2d.TextureRegion getRegion() {
        com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion = this.g;
        if (textureRegion != null) {
            return textureRegion;
        }
        throw new java.lang.IllegalStateException("Region has not been set: " + this);
    }

    public float[] getRegionUVs() {
        return this.i;
    }

    public short[] getTriangles() {
        return this.k;
    }

    public float[] getUVs() {
        return this.j;
    }

    public float getWidth() {
        return this.q;
    }

    public void setEdges(short[] sArr) {
        this.p = sArr;
    }

    public void setHeight(float f) {
        this.r = f;
    }

    public void setHullLength(int i) {
        this.m = i;
    }

    public void setInheritDeform(boolean z) {
        this.o = z;
    }

    public void setParentMesh(com.esotericsoftware.spine.attachments.MeshAttachment meshAttachment) {
        this.n = meshAttachment;
        if (meshAttachment != null) {
            this.c = meshAttachment.c;
            this.d = meshAttachment.d;
            this.i = meshAttachment.i;
            this.k = meshAttachment.k;
            this.m = meshAttachment.m;
            this.e = meshAttachment.e;
            this.p = meshAttachment.p;
            this.q = meshAttachment.q;
            this.r = meshAttachment.r;
        }
    }

    public void setPath(java.lang.String str) {
        this.h = str;
    }

    public void setRegion(com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion) {
        if (textureRegion == null) {
            throw new java.lang.IllegalArgumentException("region cannot be null.");
        }
        this.g = textureRegion;
    }

    public void setRegionUVs(float[] fArr) {
        this.i = fArr;
    }

    public void setTriangles(short[] sArr) {
        this.k = sArr;
    }

    public void setUVs(float[] fArr) {
        this.j = fArr;
    }

    public void setWidth(float f) {
        this.q = f;
    }

    public void updateUVs() {
        float u2;
        float v2;
        float f;
        float f2;
        com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion = this.g;
        if (textureRegion == null) {
            f2 = 0.0f;
            f = 0.0f;
            u2 = 1.0f;
            v2 = 1.0f;
        } else {
            float u = textureRegion.getU();
            float v = this.g.getV();
            u2 = this.g.getU2() - u;
            v2 = this.g.getV2() - v;
            f = u;
            f2 = v;
        }
        float[] fArr = this.i;
        float[] fArr2 = this.j;
        if (fArr2 == null || fArr2.length != fArr.length) {
            this.j = new float[fArr.length];
        }
        float[] fArr3 = this.j;
        com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion2 = this.g;
        int i = 0;
        if ((textureRegion2 instanceof com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion) && ((com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion) textureRegion2).rotate) {
            int length = fArr3.length;
            while (i < length) {
                int i2 = i + 1;
                fArr3[i] = (fArr[i2] * u2) + f;
                fArr3[i2] = (f2 + v2) - (fArr[i] * v2);
                i += 2;
            }
            return;
        }
        int length2 = fArr3.length;
        while (i < length2) {
            fArr3[i] = (fArr[i] * u2) + f;
            int i3 = i + 1;
            fArr3[i3] = (fArr[i3] * v2) + f2;
            i += 2;
        }
    }
}
