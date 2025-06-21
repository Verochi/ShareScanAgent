package com.badlogic.gdx.graphics.g2d;

/* loaded from: classes12.dex */
public class Sprite extends com.badlogic.gdx.graphics.g2d.TextureRegion {
    public final float[] h;
    public final com.badlogic.gdx.graphics.Color i;
    public float j;
    public float k;
    public float l;
    public float m;
    public float n;
    public float o;
    public float p;
    public float q;
    public float r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f290s;
    public com.badlogic.gdx.math.Rectangle t;

    public Sprite() {
        this.h = new float[20];
        this.i = new com.badlogic.gdx.graphics.Color(1.0f, 1.0f, 1.0f, 1.0f);
        this.q = 1.0f;
        this.r = 1.0f;
        this.f290s = true;
        setColor(1.0f, 1.0f, 1.0f, 1.0f);
    }

    public Sprite(com.badlogic.gdx.graphics.Texture texture) {
        this(texture, 0, 0, texture.getWidth(), texture.getHeight());
    }

    public Sprite(com.badlogic.gdx.graphics.Texture texture, int i, int i2) {
        this(texture, 0, 0, i, i2);
    }

    public Sprite(com.badlogic.gdx.graphics.Texture texture, int i, int i2, int i3, int i4) {
        this.h = new float[20];
        this.i = new com.badlogic.gdx.graphics.Color(1.0f, 1.0f, 1.0f, 1.0f);
        this.q = 1.0f;
        this.r = 1.0f;
        this.f290s = true;
        if (texture == null) {
            throw new java.lang.IllegalArgumentException("texture cannot be null.");
        }
        this.a = texture;
        setRegion(i, i2, i3, i4);
        setColor(1.0f, 1.0f, 1.0f, 1.0f);
        setSize(java.lang.Math.abs(i3), java.lang.Math.abs(i4));
        setOrigin(this.l / 2.0f, this.m / 2.0f);
    }

    public Sprite(com.badlogic.gdx.graphics.g2d.Sprite sprite) {
        this.h = new float[20];
        this.i = new com.badlogic.gdx.graphics.Color(1.0f, 1.0f, 1.0f, 1.0f);
        this.q = 1.0f;
        this.r = 1.0f;
        this.f290s = true;
        set(sprite);
    }

    public Sprite(com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion) {
        this.h = new float[20];
        this.i = new com.badlogic.gdx.graphics.Color(1.0f, 1.0f, 1.0f, 1.0f);
        this.q = 1.0f;
        this.r = 1.0f;
        this.f290s = true;
        setRegion(textureRegion);
        setColor(1.0f, 1.0f, 1.0f, 1.0f);
        setSize(textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
        setOrigin(this.l / 2.0f, this.m / 2.0f);
    }

    public Sprite(com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion, int i, int i2, int i3, int i4) {
        this.h = new float[20];
        this.i = new com.badlogic.gdx.graphics.Color(1.0f, 1.0f, 1.0f, 1.0f);
        this.q = 1.0f;
        this.r = 1.0f;
        this.f290s = true;
        setRegion(textureRegion, i, i2, i3, i4);
        setColor(1.0f, 1.0f, 1.0f, 1.0f);
        setSize(java.lang.Math.abs(i3), java.lang.Math.abs(i4));
        setOrigin(this.l / 2.0f, this.m / 2.0f);
    }

    public void draw(com.badlogic.gdx.graphics.g2d.Batch batch) {
        batch.draw(this.a, getVertices(), 0, 20);
    }

    public void draw(com.badlogic.gdx.graphics.g2d.Batch batch, float f) {
        float f2 = getColor().a;
        setAlpha(f * f2);
        draw(batch);
        setAlpha(f2);
    }

    @Override // com.badlogic.gdx.graphics.g2d.TextureRegion
    public void flip(boolean z, boolean z2) {
        super.flip(z, z2);
        float[] fArr = this.h;
        if (z) {
            float f = fArr[3];
            fArr[3] = fArr[13];
            fArr[13] = f;
            float f2 = fArr[8];
            fArr[8] = fArr[18];
            fArr[18] = f2;
        }
        if (z2) {
            float f3 = fArr[4];
            fArr[4] = fArr[14];
            fArr[14] = f3;
            float f4 = fArr[9];
            fArr[9] = fArr[19];
            fArr[19] = f4;
        }
    }

    public com.badlogic.gdx.math.Rectangle getBoundingRectangle() {
        float[] vertices = getVertices();
        float f = vertices[0];
        float f2 = vertices[1];
        float f3 = vertices[5];
        float f4 = f > f3 ? f3 : f;
        float f5 = vertices[10];
        if (f4 > f5) {
            f4 = f5;
        }
        float f6 = vertices[15];
        if (f4 > f6) {
            f4 = f6;
        }
        if (f < f3) {
            f = f3;
        }
        if (f >= f5) {
            f5 = f;
        }
        if (f5 >= f6) {
            f6 = f5;
        }
        float f7 = vertices[6];
        float f8 = f2 > f7 ? f7 : f2;
        float f9 = vertices[11];
        if (f8 > f9) {
            f8 = f9;
        }
        float f10 = vertices[16];
        if (f8 > f10) {
            f8 = f10;
        }
        if (f2 < f7) {
            f2 = f7;
        }
        if (f2 >= f9) {
            f9 = f2;
        }
        if (f9 >= f10) {
            f10 = f9;
        }
        if (this.t == null) {
            this.t = new com.badlogic.gdx.math.Rectangle();
        }
        com.badlogic.gdx.math.Rectangle rectangle = this.t;
        rectangle.x = f4;
        rectangle.y = f8;
        rectangle.width = f6 - f4;
        rectangle.height = f10 - f8;
        return rectangle;
    }

    public com.badlogic.gdx.graphics.Color getColor() {
        int floatToIntColor = com.badlogic.gdx.utils.NumberUtils.floatToIntColor(this.h[2]);
        com.badlogic.gdx.graphics.Color color = this.i;
        color.r = (floatToIntColor & 255) / 255.0f;
        color.g = ((floatToIntColor >>> 8) & 255) / 255.0f;
        color.b = ((floatToIntColor >>> 16) & 255) / 255.0f;
        color.a = ((floatToIntColor >>> 24) & 255) / 255.0f;
        return color;
    }

    public float getHeight() {
        return this.m;
    }

    public float getOriginX() {
        return this.n;
    }

    public float getOriginY() {
        return this.o;
    }

    public float getRotation() {
        return this.p;
    }

    public float getScaleX() {
        return this.q;
    }

    public float getScaleY() {
        return this.r;
    }

    public float[] getVertices() {
        if (this.f290s) {
            this.f290s = false;
            float[] fArr = this.h;
            float f = -this.n;
            float f2 = -this.o;
            float f3 = this.l + f;
            float f4 = this.m + f2;
            float f5 = this.j - f;
            float f6 = this.k - f2;
            float f7 = this.q;
            if (f7 != 1.0f || this.r != 1.0f) {
                f *= f7;
                float f8 = this.r;
                f2 *= f8;
                f3 *= f7;
                f4 *= f8;
            }
            float f9 = this.p;
            if (f9 != 0.0f) {
                float cosDeg = com.badlogic.gdx.math.MathUtils.cosDeg(f9);
                float sinDeg = com.badlogic.gdx.math.MathUtils.sinDeg(this.p);
                float f10 = f * cosDeg;
                float f11 = f * sinDeg;
                float f12 = f2 * cosDeg;
                float f13 = f3 * cosDeg;
                float f14 = cosDeg * f4;
                float f15 = f4 * sinDeg;
                float f16 = (f10 - (f2 * sinDeg)) + f5;
                float f17 = f12 + f11 + f6;
                fArr[0] = f16;
                fArr[1] = f17;
                float f18 = (f10 - f15) + f5;
                float f19 = f11 + f14 + f6;
                fArr[5] = f18;
                fArr[6] = f19;
                float f20 = (f13 - f15) + f5;
                float f21 = f14 + (f3 * sinDeg) + f6;
                fArr[10] = f20;
                fArr[11] = f21;
                fArr[15] = f16 + (f20 - f18);
                fArr[16] = f21 - (f19 - f17);
            } else {
                float f22 = f + f5;
                float f23 = f2 + f6;
                float f24 = f3 + f5;
                float f25 = f4 + f6;
                fArr[0] = f22;
                fArr[1] = f23;
                fArr[5] = f22;
                fArr[6] = f25;
                fArr[10] = f24;
                fArr[11] = f25;
                fArr[15] = f24;
                fArr[16] = f23;
            }
        }
        return this.h;
    }

    public float getWidth() {
        return this.l;
    }

    public float getX() {
        return this.j;
    }

    public float getY() {
        return this.k;
    }

    public void rotate(float f) {
        if (f == 0.0f) {
            return;
        }
        this.p += f;
        this.f290s = true;
    }

    public void rotate90(boolean z) {
        float[] fArr = this.h;
        if (z) {
            float f = fArr[4];
            fArr[4] = fArr[19];
            fArr[19] = fArr[14];
            fArr[14] = fArr[9];
            fArr[9] = f;
            float f2 = fArr[3];
            fArr[3] = fArr[18];
            fArr[18] = fArr[13];
            fArr[13] = fArr[8];
            fArr[8] = f2;
            return;
        }
        float f3 = fArr[4];
        fArr[4] = fArr[9];
        fArr[9] = fArr[14];
        fArr[14] = fArr[19];
        fArr[19] = f3;
        float f4 = fArr[3];
        fArr[3] = fArr[8];
        fArr[8] = fArr[13];
        fArr[13] = fArr[18];
        fArr[18] = f4;
    }

    public void scale(float f) {
        this.q += f;
        this.r += f;
        this.f290s = true;
    }

    @Override // com.badlogic.gdx.graphics.g2d.TextureRegion
    public void scroll(float f, float f2) {
        float[] fArr = this.h;
        if (f != 0.0f) {
            float f3 = (fArr[3] + f) % 1.0f;
            float width = (this.l / this.a.getWidth()) + f3;
            this.b = f3;
            this.d = width;
            fArr[3] = f3;
            fArr[8] = f3;
            fArr[13] = width;
            fArr[18] = width;
        }
        if (f2 != 0.0f) {
            float f4 = (fArr[9] + f2) % 1.0f;
            float height = (this.m / this.a.getHeight()) + f4;
            this.c = f4;
            this.e = height;
            fArr[4] = height;
            fArr[9] = f4;
            fArr[14] = f4;
            fArr[19] = height;
        }
    }

    public void set(com.badlogic.gdx.graphics.g2d.Sprite sprite) {
        if (sprite == null) {
            throw new java.lang.IllegalArgumentException("sprite cannot be null.");
        }
        java.lang.System.arraycopy(sprite.h, 0, this.h, 0, 20);
        this.a = sprite.a;
        this.b = sprite.b;
        this.c = sprite.c;
        this.d = sprite.d;
        this.e = sprite.e;
        this.j = sprite.j;
        this.k = sprite.k;
        this.l = sprite.l;
        this.m = sprite.m;
        this.f = sprite.f;
        this.g = sprite.g;
        this.n = sprite.n;
        this.o = sprite.o;
        this.p = sprite.p;
        this.q = sprite.q;
        this.r = sprite.r;
        this.i.set(sprite.i);
        this.f290s = sprite.f290s;
    }

    public void setAlpha(float f) {
        float intToFloatColor = com.badlogic.gdx.utils.NumberUtils.intToFloatColor((((int) (f * 255.0f)) << 24) | (com.badlogic.gdx.utils.NumberUtils.floatToIntColor(this.h[2]) & 16777215));
        float[] fArr = this.h;
        fArr[2] = intToFloatColor;
        fArr[7] = intToFloatColor;
        fArr[12] = intToFloatColor;
        fArr[17] = intToFloatColor;
    }

    public void setBounds(float f, float f2, float f3, float f4) {
        this.j = f;
        this.k = f2;
        this.l = f3;
        this.m = f4;
        if (this.f290s) {
            return;
        }
        float f5 = f3 + f;
        float f6 = f4 + f2;
        float[] fArr = this.h;
        fArr[0] = f;
        fArr[1] = f2;
        fArr[5] = f;
        fArr[6] = f6;
        fArr[10] = f5;
        fArr[11] = f6;
        fArr[15] = f5;
        fArr[16] = f2;
        if (this.p == 0.0f && this.q == 1.0f && this.r == 1.0f) {
            return;
        }
        this.f290s = true;
    }

    public void setCenter(float f, float f2) {
        setCenterX(f);
        setCenterY(f2);
    }

    public void setCenterX(float f) {
        setX(f - (this.l / 2.0f));
    }

    public void setCenterY(float f) {
        setY(f - (this.m / 2.0f));
    }

    public void setColor(float f) {
        float[] fArr = this.h;
        fArr[2] = f;
        fArr[7] = f;
        fArr[12] = f;
        fArr[17] = f;
    }

    public void setColor(float f, float f2, float f3, float f4) {
        int i = ((int) (f2 * 255.0f)) << 8;
        int i2 = (int) (f * 255.0f);
        float intToFloatColor = com.badlogic.gdx.utils.NumberUtils.intToFloatColor(i2 | i | (((int) (f3 * 255.0f)) << 16) | (((int) (f4 * 255.0f)) << 24));
        float[] fArr = this.h;
        fArr[2] = intToFloatColor;
        fArr[7] = intToFloatColor;
        fArr[12] = intToFloatColor;
        fArr[17] = intToFloatColor;
    }

    public void setColor(com.badlogic.gdx.graphics.Color color) {
        float floatBits = color.toFloatBits();
        float[] fArr = this.h;
        fArr[2] = floatBits;
        fArr[7] = floatBits;
        fArr[12] = floatBits;
        fArr[17] = floatBits;
    }

    public void setFlip(boolean z, boolean z2) {
        flip(isFlipX() != z, isFlipY() != z2);
    }

    public void setOrigin(float f, float f2) {
        this.n = f;
        this.o = f2;
        this.f290s = true;
    }

    public void setOriginCenter() {
        this.n = this.l / 2.0f;
        this.o = this.m / 2.0f;
        this.f290s = true;
    }

    public void setPosition(float f, float f2) {
        translate(f - this.j, f2 - this.k);
    }

    @Override // com.badlogic.gdx.graphics.g2d.TextureRegion
    public void setRegion(float f, float f2, float f3, float f4) {
        super.setRegion(f, f2, f3, f4);
        float[] fArr = this.h;
        fArr[3] = f;
        fArr[4] = f4;
        fArr[8] = f;
        fArr[9] = f2;
        fArr[13] = f3;
        fArr[14] = f2;
        fArr[18] = f3;
        fArr[19] = f4;
    }

    public void setRotation(float f) {
        this.p = f;
        this.f290s = true;
    }

    public void setScale(float f) {
        this.q = f;
        this.r = f;
        this.f290s = true;
    }

    public void setScale(float f, float f2) {
        this.q = f;
        this.r = f2;
        this.f290s = true;
    }

    public void setSize(float f, float f2) {
        this.l = f;
        this.m = f2;
        if (this.f290s) {
            return;
        }
        float f3 = this.j;
        float f4 = f + f3;
        float f5 = this.k;
        float f6 = f2 + f5;
        float[] fArr = this.h;
        fArr[0] = f3;
        fArr[1] = f5;
        fArr[5] = f3;
        fArr[6] = f6;
        fArr[10] = f4;
        fArr[11] = f6;
        fArr[15] = f4;
        fArr[16] = f5;
        if (this.p == 0.0f && this.q == 1.0f && this.r == 1.0f) {
            return;
        }
        this.f290s = true;
    }

    @Override // com.badlogic.gdx.graphics.g2d.TextureRegion
    public void setU(float f) {
        super.setU(f);
        float[] fArr = this.h;
        fArr[3] = f;
        fArr[8] = f;
    }

    @Override // com.badlogic.gdx.graphics.g2d.TextureRegion
    public void setU2(float f) {
        super.setU2(f);
        float[] fArr = this.h;
        fArr[13] = f;
        fArr[18] = f;
    }

    @Override // com.badlogic.gdx.graphics.g2d.TextureRegion
    public void setV(float f) {
        super.setV(f);
        float[] fArr = this.h;
        fArr[9] = f;
        fArr[14] = f;
    }

    @Override // com.badlogic.gdx.graphics.g2d.TextureRegion
    public void setV2(float f) {
        super.setV2(f);
        float[] fArr = this.h;
        fArr[4] = f;
        fArr[19] = f;
    }

    public void setX(float f) {
        translateX(f - this.j);
    }

    public void setY(float f) {
        translateY(f - this.k);
    }

    public void translate(float f, float f2) {
        this.j += f;
        this.k += f2;
        if (this.f290s) {
            return;
        }
        float[] fArr = this.h;
        fArr[0] = fArr[0] + f;
        fArr[1] = fArr[1] + f2;
        fArr[5] = fArr[5] + f;
        fArr[6] = fArr[6] + f2;
        fArr[10] = fArr[10] + f;
        fArr[11] = fArr[11] + f2;
        fArr[15] = fArr[15] + f;
        fArr[16] = fArr[16] + f2;
    }

    public void translateX(float f) {
        this.j += f;
        if (this.f290s) {
            return;
        }
        float[] fArr = this.h;
        fArr[0] = fArr[0] + f;
        fArr[5] = fArr[5] + f;
        fArr[10] = fArr[10] + f;
        fArr[15] = fArr[15] + f;
    }

    public void translateY(float f) {
        this.k += f;
        if (this.f290s) {
            return;
        }
        float[] fArr = this.h;
        fArr[1] = fArr[1] + f;
        fArr[6] = fArr[6] + f;
        fArr[11] = fArr[11] + f;
        fArr[16] = fArr[16] + f;
    }
}
