package com.badlogic.gdx.math;

/* loaded from: classes12.dex */
public final class GeometryUtils {
    public static final com.badlogic.gdx.math.Vector2 a = new com.badlogic.gdx.math.Vector2();
    public static final com.badlogic.gdx.math.Vector2 b = new com.badlogic.gdx.math.Vector2();
    public static final com.badlogic.gdx.math.Vector2 c = new com.badlogic.gdx.math.Vector2();

    public static boolean a(float[] fArr, int i, int i2) {
        if (i2 <= 2) {
            return false;
        }
        int i3 = (i + i2) - 3;
        float f = 0.0f;
        while (i < i3) {
            int i4 = i + 2;
            f += (fArr[i] * fArr[i + 3]) - (fArr[i4] * fArr[i + 1]);
            i = i4;
        }
        return (f + (fArr[i2 + (-2)] * fArr[1])) - (fArr[0] * fArr[i2 - 1]) < 0.0f;
    }

    public static boolean barycoordInsideTriangle(com.badlogic.gdx.math.Vector2 vector2) {
        float f = vector2.x;
        if (f >= 0.0f) {
            float f2 = vector2.y;
            if (f2 >= 0.0f && f + f2 <= 1.0f) {
                return true;
            }
        }
        return false;
    }

    public static boolean colinear(float f, float f2, float f3, float f4, float f5, float f6) {
        return java.lang.Math.abs(((f5 - f3) * (f4 - f2)) - ((f3 - f) * (f6 - f4))) < 1.0E-6f;
    }

    public static void ensureCCW(float[] fArr) {
        if (a(fArr, 0, fArr.length)) {
            int length = fArr.length - 2;
            int length2 = fArr.length / 2;
            for (int i = 0; i < length2; i += 2) {
                int i2 = length - i;
                float f = fArr[i];
                int i3 = i + 1;
                float f2 = fArr[i3];
                fArr[i] = fArr[i2];
                int i4 = i2 + 1;
                fArr[i3] = fArr[i4];
                fArr[i2] = f;
                fArr[i4] = f2;
            }
        }
    }

    public static float fromBarycoord(com.badlogic.gdx.math.Vector2 vector2, float f, float f2, float f3) {
        float f4 = vector2.x;
        float f5 = vector2.y;
        return (((1.0f - f4) - f5) * f) + (f4 * f2) + (f5 * f3);
    }

    public static com.badlogic.gdx.math.Vector2 fromBarycoord(com.badlogic.gdx.math.Vector2 vector2, com.badlogic.gdx.math.Vector2 vector22, com.badlogic.gdx.math.Vector2 vector23, com.badlogic.gdx.math.Vector2 vector24, com.badlogic.gdx.math.Vector2 vector25) {
        float f = vector2.x;
        float f2 = vector2.y;
        float f3 = (1.0f - f) - f2;
        vector25.x = (vector22.x * f3) + (f * vector23.x) + (vector24.x * f2);
        vector25.y = (f3 * vector22.y) + (vector2.x * vector23.y) + (f2 * vector24.y);
        return vector25;
    }

    public static float lowestPositiveRoot(float f, float f2, float f3) {
        float f4 = (f2 * f2) - ((4.0f * f) * f3);
        if (f4 < 0.0f) {
            return Float.NaN;
        }
        float sqrt = (float) java.lang.Math.sqrt(f4);
        float f5 = 1.0f / (f * 2.0f);
        float f6 = -f2;
        float f7 = (f6 - sqrt) * f5;
        float f8 = (f6 + sqrt) * f5;
        if (f7 > f8) {
            f7 = f8;
            f8 = f7;
        }
        if (f7 > 0.0f) {
            return f7;
        }
        if (f8 > 0.0f) {
            return f8;
        }
        return Float.NaN;
    }

    public static float polygonArea(float[] fArr, int i, int i2) {
        int i3 = i2 + i;
        float f = 0.0f;
        int i4 = i;
        while (i4 < i3) {
            int i5 = i4 + 1;
            int i6 = i4 + 2;
            int i7 = i6 % i3;
            if (i7 < i) {
                i7 += i;
            }
            int i8 = (i4 + 3) % i3;
            if (i8 < i) {
                i8 += i;
            }
            f = (f + (fArr[i4] * fArr[i8])) - (fArr[i7] * fArr[i5]);
            i4 = i6;
        }
        return f * 0.5f;
    }

    public static com.badlogic.gdx.math.Vector2 polygonCentroid(float[] fArr, int i, int i2, com.badlogic.gdx.math.Vector2 vector2) {
        if (i2 < 6) {
            throw new java.lang.IllegalArgumentException("A polygon must have 3 or more coordinate pairs.");
        }
        int i3 = (i2 + i) - 2;
        int i4 = i;
        float f = 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        while (i4 < i3) {
            float f4 = fArr[i4];
            float f5 = fArr[i4 + 1];
            int i5 = i4 + 2;
            float f6 = fArr[i5];
            float f7 = fArr[i4 + 3];
            float f8 = (f4 * f7) - (f6 * f5);
            f += f8;
            f2 += (f4 + f6) * f8;
            f3 += (f5 + f7) * f8;
            i4 = i5;
        }
        float f9 = fArr[i4];
        float f10 = fArr[i4 + 1];
        float f11 = fArr[i];
        float f12 = fArr[i + 1];
        float f13 = (f9 * f12) - (f11 * f10);
        float f14 = f + f13;
        float f15 = f2 + ((f9 + f11) * f13);
        float f16 = f3 + ((f10 + f12) * f13);
        if (f14 == 0.0f) {
            vector2.x = 0.0f;
            vector2.y = 0.0f;
        } else {
            float f17 = f14 * 0.5f * 6.0f;
            vector2.x = f15 / f17;
            vector2.y = f16 / f17;
        }
        return vector2;
    }

    public static com.badlogic.gdx.math.Vector2 quadrilateralCentroid(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, com.badlogic.gdx.math.Vector2 vector2) {
        float f9 = ((f3 + f) + f5) / 3.0f;
        float f10 = ((f4 + f2) + f6) / 3.0f;
        vector2.x = f9 - ((f9 - (((f + f7) + f5) / 3.0f)) / 2.0f);
        vector2.y = f10 - ((f10 - (((f2 + f8) + f6) / 3.0f)) / 2.0f);
        return vector2;
    }

    public static com.badlogic.gdx.math.Vector2 toBarycoord(com.badlogic.gdx.math.Vector2 vector2, com.badlogic.gdx.math.Vector2 vector22, com.badlogic.gdx.math.Vector2 vector23, com.badlogic.gdx.math.Vector2 vector24, com.badlogic.gdx.math.Vector2 vector25) {
        com.badlogic.gdx.math.Vector2 sub = a.set(vector23).sub(vector22);
        com.badlogic.gdx.math.Vector2 sub2 = b.set(vector24).sub(vector22);
        com.badlogic.gdx.math.Vector2 sub3 = c.set(vector2).sub(vector22);
        float dot = sub.dot(sub);
        float dot2 = sub.dot(sub2);
        float dot3 = sub2.dot(sub2);
        float dot4 = sub3.dot(sub);
        float dot5 = sub3.dot(sub2);
        float f = (dot * dot3) - (dot2 * dot2);
        vector25.x = ((dot3 * dot4) - (dot2 * dot5)) / f;
        vector25.y = ((dot * dot5) - (dot2 * dot4)) / f;
        return vector25;
    }

    public static float triangleArea(float f, float f2, float f3, float f4, float f5, float f6) {
        return java.lang.Math.abs(((f - f5) * (f4 - f2)) - ((f - f3) * (f6 - f2))) * 0.5f;
    }

    public static com.badlogic.gdx.math.Vector2 triangleCentroid(float f, float f2, float f3, float f4, float f5, float f6, com.badlogic.gdx.math.Vector2 vector2) {
        vector2.x = ((f + f3) + f5) / 3.0f;
        vector2.y = ((f2 + f4) + f6) / 3.0f;
        return vector2;
    }

    public static com.badlogic.gdx.math.Vector2 triangleCircumcenter(float f, float f2, float f3, float f4, float f5, float f6, com.badlogic.gdx.math.Vector2 vector2) {
        float f7 = f3 - f;
        float f8 = f4 - f2;
        float f9 = f5 - f3;
        float f10 = f6 - f4;
        float f11 = f - f5;
        float f12 = f2 - f6;
        float f13 = (f9 * f8) - (f7 * f10);
        if (java.lang.Math.abs(f13) < 1.0E-6f) {
            throw new java.lang.IllegalArgumentException("Triangle points must not be colinear.");
        }
        float f14 = f13 * 2.0f;
        float f15 = (f * f) + (f2 * f2);
        float f16 = (f3 * f3) + (f4 * f4);
        float f17 = (f5 * f5) + (f6 * f6);
        vector2.set((((f10 * f15) + (f12 * f16)) + (f8 * f17)) / f14, (-(((f15 * f9) + (f16 * f11)) + (f17 * f7))) / f14);
        return vector2;
    }

    public static float triangleCircumradius(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7;
        float f8;
        float f9 = f4 - f2;
        if (java.lang.Math.abs(f9) < 1.0E-6f) {
            float f10 = (-(f5 - f3)) / (f6 - f4);
            float f11 = (f5 + f3) / 2.0f;
            f7 = (f3 + f) / 2.0f;
            f8 = (f10 * (f7 - f11)) + ((f4 + f6) / 2.0f);
        } else {
            float f12 = f6 - f4;
            if (java.lang.Math.abs(f12) < 1.0E-6f) {
                float f13 = (-(f3 - f)) / f9;
                float f14 = (f + f3) / 2.0f;
                f7 = (f5 + f3) / 2.0f;
                f8 = (f13 * (f7 - f14)) + ((f4 + f2) / 2.0f);
            } else {
                float f15 = (-(f3 - f)) / f9;
                float f16 = (-(f5 - f3)) / f12;
                float f17 = (f + f3) / 2.0f;
                float f18 = (f3 + f5) / 2.0f;
                float f19 = (f2 + f4) / 2.0f;
                f7 = ((((f15 * f17) - (f18 * f16)) + ((f4 + f6) / 2.0f)) - f19) / (f15 - f16);
                f8 = (f15 * (f7 - f17)) + f19;
            }
        }
        float f20 = f - f7;
        float f21 = f2 - f8;
        return (float) java.lang.Math.sqrt((f20 * f20) + (f21 * f21));
    }

    public static float triangleQuality(float f, float f2, float f3, float f4, float f5, float f6) {
        return java.lang.Math.min((float) java.lang.Math.sqrt((f * f) + (f2 * f2)), java.lang.Math.min((float) java.lang.Math.sqrt((f3 * f3) + (f4 * f4)), (float) java.lang.Math.sqrt((f5 * f5) + (f6 * f6)))) / triangleCircumradius(f, f2, f3, f4, f5, f6);
    }
}
