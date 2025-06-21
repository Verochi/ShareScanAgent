package com.esotericsoftware.spine.attachments;

/* loaded from: classes22.dex */
public class RegionAttachment extends com.esotericsoftware.spine.attachments.Attachment {
    public static final int BLX = 0;
    public static final int BLY = 1;
    public static final int BRX = 6;
    public static final int BRY = 7;
    public static final int ULX = 2;
    public static final int ULY = 3;
    public static final int URX = 4;
    public static final int URY = 5;
    public com.badlogic.gdx.graphics.g2d.TextureRegion b;
    public java.lang.String c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public final float[] k;
    public final float[] l;
    public final com.badlogic.gdx.graphics.Color m;

    public RegionAttachment(java.lang.String str) {
        super(str);
        this.f = 1.0f;
        this.g = 1.0f;
        this.k = new float[8];
        this.l = new float[8];
        this.m = new com.badlogic.gdx.graphics.Color(1.0f, 1.0f, 1.0f, 1.0f);
    }

    public void computeWorldVertices(com.esotericsoftware.spine.Bone bone, float[] fArr, int i, int i2) {
        float[] fArr2 = this.l;
        float worldX = bone.getWorldX();
        float worldY = bone.getWorldY();
        float a = bone.getA();
        float b = bone.getB();
        float c = bone.getC();
        float d = bone.getD();
        float f = fArr2[6];
        float f2 = fArr2[7];
        fArr[i] = (f * a) + (f2 * b) + worldX;
        fArr[i + 1] = (f * c) + (f2 * d) + worldY;
        int i3 = i + i2;
        float f3 = fArr2[0];
        float f4 = fArr2[1];
        fArr[i3] = (f3 * a) + (f4 * b) + worldX;
        fArr[i3 + 1] = (f3 * c) + (f4 * d) + worldY;
        int i4 = i3 + i2;
        float f5 = fArr2[2];
        float f6 = fArr2[3];
        fArr[i4] = (f5 * a) + (f6 * b) + worldX;
        fArr[i4 + 1] = (f5 * c) + (f6 * d) + worldY;
        int i5 = i4 + i2;
        float f7 = fArr2[4];
        float f8 = fArr2[5];
        fArr[i5] = (a * f7) + (b * f8) + worldX;
        fArr[i5 + 1] = (f7 * c) + (f8 * d) + worldY;
    }

    public com.badlogic.gdx.graphics.Color getColor() {
        return this.m;
    }

    public float getHeight() {
        return this.j;
    }

    public float[] getOffset() {
        return this.l;
    }

    public java.lang.String getPath() {
        return this.c;
    }

    public com.badlogic.gdx.graphics.g2d.TextureRegion getRegion() {
        com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion = this.b;
        if (textureRegion != null) {
            return textureRegion;
        }
        throw new java.lang.IllegalStateException("Region has not been set: " + this);
    }

    public float getRotation() {
        return this.h;
    }

    public float getScaleX() {
        return this.f;
    }

    public float getScaleY() {
        return this.g;
    }

    public float[] getUVs() {
        return this.k;
    }

    public float getWidth() {
        return this.i;
    }

    public float getX() {
        return this.d;
    }

    public float getY() {
        return this.e;
    }

    public void setHeight(float f) {
        this.j = f;
    }

    public void setPath(java.lang.String str) {
        this.c = str;
    }

    public void setRegion(com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion) {
        if (textureRegion == null) {
            throw new java.lang.IllegalArgumentException("region cannot be null.");
        }
        this.b = textureRegion;
        float[] fArr = this.k;
        if ((textureRegion instanceof com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion) && ((com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion) textureRegion).rotate) {
            fArr[4] = textureRegion.getU();
            fArr[5] = textureRegion.getV2();
            fArr[6] = textureRegion.getU();
            fArr[7] = textureRegion.getV();
            fArr[0] = textureRegion.getU2();
            fArr[1] = textureRegion.getV();
            fArr[2] = textureRegion.getU2();
            fArr[3] = textureRegion.getV2();
            return;
        }
        fArr[2] = textureRegion.getU();
        fArr[3] = textureRegion.getV2();
        fArr[4] = textureRegion.getU();
        fArr[5] = textureRegion.getV();
        fArr[6] = textureRegion.getU2();
        fArr[7] = textureRegion.getV();
        fArr[0] = textureRegion.getU2();
        fArr[1] = textureRegion.getV2();
    }

    public void setRotation(float f) {
        this.h = f;
    }

    public void setScaleX(float f) {
        this.f = f;
    }

    public void setScaleY(float f) {
        this.g = f;
    }

    public void setWidth(float f) {
        this.i = f;
    }

    public void setX(float f) {
        this.d = f;
    }

    public void setY(float f) {
        this.e = f;
    }

    public void updateOffset() {
        int i;
        float f;
        int i2;
        float width = getWidth();
        float height = getHeight();
        float f2 = width / 2.0f;
        float f3 = height / 2.0f;
        float f4 = -f2;
        float f5 = -f3;
        com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion = this.b;
        if (textureRegion instanceof com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion) {
            com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion atlasRegion = (com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion) textureRegion;
            if (atlasRegion.rotate) {
                float f6 = atlasRegion.offsetX;
                int i3 = atlasRegion.originalWidth;
                f4 += (f6 / i3) * width;
                float f7 = atlasRegion.offsetY;
                i = atlasRegion.originalHeight;
                f5 += (f7 / i) * height;
                f2 -= (((i3 - f6) - atlasRegion.packedHeight) / i3) * width;
                f = i - f7;
                i2 = atlasRegion.packedWidth;
            } else {
                float f8 = atlasRegion.offsetX;
                int i4 = atlasRegion.originalWidth;
                f4 += (f8 / i4) * width;
                float f9 = atlasRegion.offsetY;
                i = atlasRegion.originalHeight;
                f5 += (f9 / i) * height;
                f2 -= (((i4 - f8) - atlasRegion.packedWidth) / i4) * width;
                f = i - f9;
                i2 = atlasRegion.packedHeight;
            }
            f3 -= ((f - i2) / i) * height;
        }
        float scaleX = getScaleX();
        float scaleY = getScaleY();
        float f10 = f4 * scaleX;
        float f11 = f5 * scaleY;
        float f12 = f2 * scaleX;
        float f13 = f3 * scaleY;
        double rotation = getRotation() * 0.017453292f;
        float cos = (float) java.lang.Math.cos(rotation);
        float sin = (float) java.lang.Math.sin(rotation);
        float x = getX();
        float y = getY();
        float f14 = (f10 * cos) + x;
        float f15 = f10 * sin;
        float f16 = (f11 * cos) + y;
        float f17 = f11 * sin;
        float f18 = (f12 * cos) + x;
        float f19 = f12 * sin;
        float f20 = (cos * f13) + y;
        float f21 = f13 * sin;
        float[] fArr = this.l;
        fArr[0] = f14 - f17;
        fArr[1] = f16 + f15;
        fArr[2] = f14 - f21;
        fArr[3] = f15 + f20;
        fArr[4] = f18 - f21;
        fArr[5] = f20 + f19;
        fArr[6] = f18 - f17;
        fArr[7] = f16 + f19;
    }
}
