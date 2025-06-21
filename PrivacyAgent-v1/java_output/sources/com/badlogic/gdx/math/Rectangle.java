package com.badlogic.gdx.math;

/* loaded from: classes12.dex */
public class Rectangle implements java.io.Serializable, com.badlogic.gdx.math.Shape2D {
    private static final long serialVersionUID = 5733252015138115702L;
    public static final com.badlogic.gdx.math.Rectangle tmp = new com.badlogic.gdx.math.Rectangle();
    public static final com.badlogic.gdx.math.Rectangle tmp2 = new com.badlogic.gdx.math.Rectangle();
    public float height;
    public float width;
    public float x;
    public float y;

    public Rectangle() {
    }

    public Rectangle(float f, float f2, float f3, float f4) {
        this.x = f;
        this.y = f2;
        this.width = f3;
        this.height = f4;
    }

    public Rectangle(com.badlogic.gdx.math.Rectangle rectangle) {
        this.x = rectangle.x;
        this.y = rectangle.y;
        this.width = rectangle.width;
        this.height = rectangle.height;
    }

    public float area() {
        return this.width * this.height;
    }

    @Override // com.badlogic.gdx.math.Shape2D
    public boolean contains(float f, float f2) {
        float f3 = this.x;
        if (f3 <= f && f3 + this.width >= f) {
            float f4 = this.y;
            if (f4 <= f2 && f4 + this.height >= f2) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(com.badlogic.gdx.math.Circle circle) {
        float f = circle.x;
        float f2 = circle.radius;
        float f3 = f - f2;
        float f4 = this.x;
        if (f3 >= f4 && f + f2 <= f4 + this.width) {
            float f5 = circle.y;
            float f6 = f5 - f2;
            float f7 = this.y;
            if (f6 >= f7 && f5 + f2 <= f7 + this.height) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(com.badlogic.gdx.math.Rectangle rectangle) {
        float f = rectangle.x;
        float f2 = rectangle.width + f;
        float f3 = rectangle.y;
        float f4 = rectangle.height + f3;
        float f5 = this.x;
        if (f > f5) {
            float f6 = this.width;
            if (f < f5 + f6 && f2 > f5 && f2 < f5 + f6) {
                float f7 = this.y;
                if (f3 > f7) {
                    float f8 = this.height;
                    if (f3 < f7 + f8 && f4 > f7 && f4 < f7 + f8) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.badlogic.gdx.math.Shape2D
    public boolean contains(com.badlogic.gdx.math.Vector2 vector2) {
        return contains(vector2.x, vector2.y);
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        com.badlogic.gdx.math.Rectangle rectangle = (com.badlogic.gdx.math.Rectangle) obj;
        return com.badlogic.gdx.utils.NumberUtils.floatToRawIntBits(this.height) == com.badlogic.gdx.utils.NumberUtils.floatToRawIntBits(rectangle.height) && com.badlogic.gdx.utils.NumberUtils.floatToRawIntBits(this.width) == com.badlogic.gdx.utils.NumberUtils.floatToRawIntBits(rectangle.width) && com.badlogic.gdx.utils.NumberUtils.floatToRawIntBits(this.x) == com.badlogic.gdx.utils.NumberUtils.floatToRawIntBits(rectangle.x) && com.badlogic.gdx.utils.NumberUtils.floatToRawIntBits(this.y) == com.badlogic.gdx.utils.NumberUtils.floatToRawIntBits(rectangle.y);
    }

    public com.badlogic.gdx.math.Rectangle fitInside(com.badlogic.gdx.math.Rectangle rectangle) {
        float aspectRatio = getAspectRatio();
        if (aspectRatio < rectangle.getAspectRatio()) {
            float f = rectangle.height;
            setSize(aspectRatio * f, f);
        } else {
            float f2 = rectangle.width;
            setSize(f2, f2 / aspectRatio);
        }
        setPosition((rectangle.x + (rectangle.width / 2.0f)) - (this.width / 2.0f), (rectangle.y + (rectangle.height / 2.0f)) - (this.height / 2.0f));
        return this;
    }

    public com.badlogic.gdx.math.Rectangle fitOutside(com.badlogic.gdx.math.Rectangle rectangle) {
        float aspectRatio = getAspectRatio();
        if (aspectRatio > rectangle.getAspectRatio()) {
            float f = rectangle.height;
            setSize(aspectRatio * f, f);
        } else {
            float f2 = rectangle.width;
            setSize(f2, f2 / aspectRatio);
        }
        setPosition((rectangle.x + (rectangle.width / 2.0f)) - (this.width / 2.0f), (rectangle.y + (rectangle.height / 2.0f)) - (this.height / 2.0f));
        return this;
    }

    public com.badlogic.gdx.math.Rectangle fromString(java.lang.String str) {
        int indexOf = str.indexOf(44, 1);
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(44, i);
        int i2 = indexOf2 + 1;
        int indexOf3 = str.indexOf(44, i2);
        if (indexOf != -1 && indexOf2 != -1 && indexOf3 != -1 && str.charAt(0) == '[' && str.charAt(str.length() - 1) == ']') {
            try {
                return set(java.lang.Float.parseFloat(str.substring(1, indexOf)), java.lang.Float.parseFloat(str.substring(i, indexOf2)), java.lang.Float.parseFloat(str.substring(i2, indexOf3)), java.lang.Float.parseFloat(str.substring(indexOf3 + 1, str.length() - 1)));
            } catch (java.lang.NumberFormatException unused) {
            }
        }
        throw new com.badlogic.gdx.utils.GdxRuntimeException("Malformed Rectangle: " + str);
    }

    public float getAspectRatio() {
        float f = this.height;
        if (f == 0.0f) {
            return Float.NaN;
        }
        return this.width / f;
    }

    public com.badlogic.gdx.math.Vector2 getCenter(com.badlogic.gdx.math.Vector2 vector2) {
        vector2.x = this.x + (this.width / 2.0f);
        vector2.y = this.y + (this.height / 2.0f);
        return vector2;
    }

    public float getHeight() {
        return this.height;
    }

    public com.badlogic.gdx.math.Vector2 getPosition(com.badlogic.gdx.math.Vector2 vector2) {
        return vector2.set(this.x, this.y);
    }

    public com.badlogic.gdx.math.Vector2 getSize(com.badlogic.gdx.math.Vector2 vector2) {
        return vector2.set(this.width, this.height);
    }

    public float getWidth() {
        return this.width;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public int hashCode() {
        return ((((((com.badlogic.gdx.utils.NumberUtils.floatToRawIntBits(this.height) + 31) * 31) + com.badlogic.gdx.utils.NumberUtils.floatToRawIntBits(this.width)) * 31) + com.badlogic.gdx.utils.NumberUtils.floatToRawIntBits(this.x)) * 31) + com.badlogic.gdx.utils.NumberUtils.floatToRawIntBits(this.y);
    }

    public com.badlogic.gdx.math.Rectangle merge(float f, float f2) {
        float min = java.lang.Math.min(this.x, f);
        float max = java.lang.Math.max(this.x + this.width, f);
        this.x = min;
        this.width = max - min;
        float min2 = java.lang.Math.min(this.y, f2);
        float max2 = java.lang.Math.max(this.y + this.height, f2);
        this.y = min2;
        this.height = max2 - min2;
        return this;
    }

    public com.badlogic.gdx.math.Rectangle merge(com.badlogic.gdx.math.Rectangle rectangle) {
        float min = java.lang.Math.min(this.x, rectangle.x);
        float max = java.lang.Math.max(this.x + this.width, rectangle.x + rectangle.width);
        this.x = min;
        this.width = max - min;
        float min2 = java.lang.Math.min(this.y, rectangle.y);
        float max2 = java.lang.Math.max(this.y + this.height, rectangle.y + rectangle.height);
        this.y = min2;
        this.height = max2 - min2;
        return this;
    }

    public com.badlogic.gdx.math.Rectangle merge(com.badlogic.gdx.math.Vector2 vector2) {
        return merge(vector2.x, vector2.y);
    }

    public com.badlogic.gdx.math.Rectangle merge(com.badlogic.gdx.math.Vector2[] vector2Arr) {
        float f = this.x;
        float f2 = this.width + f;
        float f3 = this.y;
        float f4 = this.height + f3;
        for (com.badlogic.gdx.math.Vector2 vector2 : vector2Arr) {
            f = java.lang.Math.min(f, vector2.x);
            f2 = java.lang.Math.max(f2, vector2.x);
            f3 = java.lang.Math.min(f3, vector2.y);
            f4 = java.lang.Math.max(f4, vector2.y);
        }
        this.x = f;
        this.width = f2 - f;
        this.y = f3;
        this.height = f4 - f3;
        return this;
    }

    public boolean overlaps(com.badlogic.gdx.math.Rectangle rectangle) {
        float f = this.x;
        float f2 = rectangle.x;
        if (f < rectangle.width + f2 && f + this.width > f2) {
            float f3 = this.y;
            float f4 = rectangle.y;
            if (f3 < rectangle.height + f4 && f3 + this.height > f4) {
                return true;
            }
        }
        return false;
    }

    public float perimeter() {
        return (this.width + this.height) * 2.0f;
    }

    public com.badlogic.gdx.math.Rectangle set(float f, float f2, float f3, float f4) {
        this.x = f;
        this.y = f2;
        this.width = f3;
        this.height = f4;
        return this;
    }

    public com.badlogic.gdx.math.Rectangle set(com.badlogic.gdx.math.Rectangle rectangle) {
        this.x = rectangle.x;
        this.y = rectangle.y;
        this.width = rectangle.width;
        this.height = rectangle.height;
        return this;
    }

    public com.badlogic.gdx.math.Rectangle setCenter(float f, float f2) {
        setPosition(f - (this.width / 2.0f), f2 - (this.height / 2.0f));
        return this;
    }

    public com.badlogic.gdx.math.Rectangle setCenter(com.badlogic.gdx.math.Vector2 vector2) {
        setPosition(vector2.x - (this.width / 2.0f), vector2.y - (this.height / 2.0f));
        return this;
    }

    public com.badlogic.gdx.math.Rectangle setHeight(float f) {
        this.height = f;
        return this;
    }

    public com.badlogic.gdx.math.Rectangle setPosition(float f, float f2) {
        this.x = f;
        this.y = f2;
        return this;
    }

    public com.badlogic.gdx.math.Rectangle setPosition(com.badlogic.gdx.math.Vector2 vector2) {
        this.x = vector2.x;
        this.y = vector2.y;
        return this;
    }

    public com.badlogic.gdx.math.Rectangle setSize(float f) {
        this.width = f;
        this.height = f;
        return this;
    }

    public com.badlogic.gdx.math.Rectangle setSize(float f, float f2) {
        this.width = f;
        this.height = f2;
        return this;
    }

    public com.badlogic.gdx.math.Rectangle setWidth(float f) {
        this.width = f;
        return this;
    }

    public com.badlogic.gdx.math.Rectangle setX(float f) {
        this.x = f;
        return this;
    }

    public com.badlogic.gdx.math.Rectangle setY(float f) {
        this.y = f;
        return this;
    }

    public java.lang.String toString() {
        return "[" + this.x + "," + this.y + "," + this.width + "," + this.height + "]";
    }
}
