package com.badlogic.gdx.graphics.g2d;

/* loaded from: classes12.dex */
public class TextureRegion {
    public com.badlogic.gdx.graphics.Texture a;
    public float b;
    public float c;
    public float d;
    public float e;
    public int f;
    public int g;

    public TextureRegion() {
    }

    public TextureRegion(com.badlogic.gdx.graphics.Texture texture) {
        if (texture == null) {
            throw new java.lang.IllegalArgumentException("texture cannot be null.");
        }
        this.a = texture;
        setRegion(0, 0, texture.getWidth(), texture.getHeight());
    }

    public TextureRegion(com.badlogic.gdx.graphics.Texture texture, float f, float f2, float f3, float f4) {
        this.a = texture;
        setRegion(f, f2, f3, f4);
    }

    public TextureRegion(com.badlogic.gdx.graphics.Texture texture, int i, int i2) {
        this.a = texture;
        setRegion(0, 0, i, i2);
    }

    public TextureRegion(com.badlogic.gdx.graphics.Texture texture, int i, int i2, int i3, int i4) {
        this.a = texture;
        setRegion(i, i2, i3, i4);
    }

    public TextureRegion(com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion) {
        setRegion(textureRegion);
    }

    public TextureRegion(com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion, int i, int i2, int i3, int i4) {
        setRegion(textureRegion, i, i2, i3, i4);
    }

    public static com.badlogic.gdx.graphics.g2d.TextureRegion[][] split(com.badlogic.gdx.graphics.Texture texture, int i, int i2) {
        return new com.badlogic.gdx.graphics.g2d.TextureRegion(texture).split(i, i2);
    }

    public void flip(boolean z, boolean z2) {
        if (z) {
            float f = this.b;
            this.b = this.d;
            this.d = f;
        }
        if (z2) {
            float f2 = this.c;
            this.c = this.e;
            this.e = f2;
        }
    }

    public int getRegionHeight() {
        return this.g;
    }

    public int getRegionWidth() {
        return this.f;
    }

    public int getRegionX() {
        return java.lang.Math.round(this.b * this.a.getWidth());
    }

    public int getRegionY() {
        return java.lang.Math.round(this.c * this.a.getHeight());
    }

    public com.badlogic.gdx.graphics.Texture getTexture() {
        return this.a;
    }

    public float getU() {
        return this.b;
    }

    public float getU2() {
        return this.d;
    }

    public float getV() {
        return this.c;
    }

    public float getV2() {
        return this.e;
    }

    public boolean isFlipX() {
        return this.b > this.d;
    }

    public boolean isFlipY() {
        return this.c > this.e;
    }

    public void scroll(float f, float f2) {
        if (f != 0.0f) {
            float width = (this.d - this.b) * this.a.getWidth();
            float f3 = (this.b + f) % 1.0f;
            this.b = f3;
            this.d = f3 + (width / this.a.getWidth());
        }
        if (f2 != 0.0f) {
            float height = (this.e - this.c) * this.a.getHeight();
            float f4 = (this.c + f2) % 1.0f;
            this.c = f4;
            this.e = f4 + (height / this.a.getHeight());
        }
    }

    public void setRegion(float f, float f2, float f3, float f4) {
        int width = this.a.getWidth();
        int height = this.a.getHeight();
        float f5 = width;
        this.f = java.lang.Math.round(java.lang.Math.abs(f3 - f) * f5);
        float f6 = height;
        int round = java.lang.Math.round(java.lang.Math.abs(f4 - f2) * f6);
        this.g = round;
        if (this.f == 1 && round == 1) {
            float f7 = 0.25f / f5;
            f += f7;
            f3 -= f7;
            float f8 = 0.25f / f6;
            f2 += f8;
            f4 -= f8;
        }
        this.b = f;
        this.c = f2;
        this.d = f3;
        this.e = f4;
    }

    public void setRegion(int i, int i2, int i3, int i4) {
        float width = 1.0f / this.a.getWidth();
        float height = 1.0f / this.a.getHeight();
        setRegion(i * width, i2 * height, (i + i3) * width, (i2 + i4) * height);
        this.f = java.lang.Math.abs(i3);
        this.g = java.lang.Math.abs(i4);
    }

    public void setRegion(com.badlogic.gdx.graphics.Texture texture) {
        this.a = texture;
        setRegion(0, 0, texture.getWidth(), texture.getHeight());
    }

    public void setRegion(com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion) {
        this.a = textureRegion.a;
        setRegion(textureRegion.b, textureRegion.c, textureRegion.d, textureRegion.e);
    }

    public void setRegion(com.badlogic.gdx.graphics.g2d.TextureRegion textureRegion, int i, int i2, int i3, int i4) {
        this.a = textureRegion.a;
        setRegion(textureRegion.getRegionX() + i, textureRegion.getRegionY() + i2, i3, i4);
    }

    public void setRegionHeight(int i) {
        if (isFlipY()) {
            setV(this.e + (i / this.a.getHeight()));
        } else {
            setV2(this.c + (i / this.a.getHeight()));
        }
    }

    public void setRegionWidth(int i) {
        if (isFlipX()) {
            setU(this.d + (i / this.a.getWidth()));
        } else {
            setU2(this.b + (i / this.a.getWidth()));
        }
    }

    public void setRegionX(int i) {
        setU(i / this.a.getWidth());
    }

    public void setRegionY(int i) {
        setV(i / this.a.getHeight());
    }

    public void setTexture(com.badlogic.gdx.graphics.Texture texture) {
        this.a = texture;
    }

    public void setU(float f) {
        this.b = f;
        this.f = java.lang.Math.round(java.lang.Math.abs(this.d - f) * this.a.getWidth());
    }

    public void setU2(float f) {
        this.d = f;
        this.f = java.lang.Math.round(java.lang.Math.abs(f - this.b) * this.a.getWidth());
    }

    public void setV(float f) {
        this.c = f;
        this.g = java.lang.Math.round(java.lang.Math.abs(this.e - f) * this.a.getHeight());
    }

    public void setV2(float f) {
        this.e = f;
        this.g = java.lang.Math.round(java.lang.Math.abs(f - this.c) * this.a.getHeight());
    }

    public com.badlogic.gdx.graphics.g2d.TextureRegion[][] split(int i, int i2) {
        int regionX = getRegionX();
        int regionY = getRegionY();
        int i3 = this.f;
        int i4 = this.g / i2;
        int i5 = i3 / i;
        com.badlogic.gdx.graphics.g2d.TextureRegion[][] textureRegionArr = (com.badlogic.gdx.graphics.g2d.TextureRegion[][]) java.lang.reflect.Array.newInstance((java.lang.Class<?>) com.badlogic.gdx.graphics.g2d.TextureRegion.class, i4, i5);
        int i6 = regionY;
        int i7 = 0;
        while (i7 < i4) {
            int i8 = regionX;
            int i9 = 0;
            while (i9 < i5) {
                textureRegionArr[i7][i9] = new com.badlogic.gdx.graphics.g2d.TextureRegion(this.a, i8, i6, i, i2);
                i9++;
                i8 += i;
            }
            i7++;
            i6 += i2;
        }
        return textureRegionArr;
    }
}
