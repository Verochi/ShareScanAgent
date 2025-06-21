package com.badlogic.gdx.graphics.g2d;

/* loaded from: classes12.dex */
public class PolygonRegion {
    public final float[] a;
    public final float[] b;
    public final short[] c;
    public final com.badlogic.gdx.graphics.g2d.TextureRegion d;

    public PolygonRegion(com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion, float[] fArr, short[] sArr) {
        this.d = textureRegion;
        this.b = fArr;
        this.c = sArr;
        float[] fArr2 = new float[fArr.length];
        this.a = fArr2;
        float f = textureRegion.b;
        float f2 = textureRegion.c;
        float f3 = textureRegion.d - f;
        float f4 = textureRegion.e - f2;
        int i = textureRegion.f;
        int i2 = textureRegion.g;
        int length = fArr.length;
        int i3 = 0;
        while (i3 < length) {
            fArr2[i3] = ((fArr[i3] / i) * f3) + f;
            int i4 = i3 + 1;
            fArr2[i4] = ((1.0f - (fArr[i4] / i2)) * f4) + f2;
            i3 = i4 + 1;
        }
    }

    public com.badlogic.gdx.graphics.g2d.TextureRegion getRegion() {
        return this.d;
    }

    public float[] getTextureCoords() {
        return this.a;
    }

    public short[] getTriangles() {
        return this.c;
    }

    public float[] getVertices() {
        return this.b;
    }
}
