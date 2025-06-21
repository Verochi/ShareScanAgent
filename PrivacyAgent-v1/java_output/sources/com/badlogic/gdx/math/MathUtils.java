package com.badlogic.gdx.math;

/* loaded from: classes12.dex */
public final class MathUtils {
    public static final float E = 2.7182817f;
    public static final float FLOAT_ROUNDING_ERROR = 1.0E-6f;
    public static final float PI = 3.1415927f;
    public static final float PI2 = 6.2831855f;
    public static final float degRad = 0.017453292f;
    public static final float degreesToRadians = 0.017453292f;
    public static final float nanoToSec = 1.0E-9f;
    public static final float radDeg = 57.295776f;
    public static final float radiansToDegrees = 57.295776f;
    public static java.util.Random random = new com.badlogic.gdx.math.RandomXS128();

    public static class Sin {
        public static final float[] a = new float[16384];

        static {
            for (int i = 0; i < 16384; i++) {
                a[i] = (float) java.lang.Math.sin(((i + 0.5f) / 16384.0f) * 6.2831855f);
            }
            for (int i2 = 0; i2 < 360; i2 += 90) {
                a[((int) (45.511112f * i2)) & 16383] = (float) java.lang.Math.sin(r2 * 0.017453292f);
            }
        }
    }

    public static float atan2(float f, float f2) {
        if (f2 == 0.0f) {
            if (f > 0.0f) {
                return 1.5707964f;
            }
            return f == 0.0f ? 0.0f : -1.5707964f;
        }
        float f3 = f / f2;
        if (java.lang.Math.abs(f3) >= 1.0f) {
            float f4 = 1.5707964f - (f3 / ((f3 * f3) + 0.28f));
            return f < 0.0f ? f4 - 3.1415927f : f4;
        }
        float f5 = f3 / (((0.28f * f3) * f3) + 1.0f);
        if (f2 < 0.0f) {
            return f5 + (f < 0.0f ? -3.1415927f : 3.1415927f);
        }
        return f5;
    }

    public static int ceil(float f) {
        return 16384 - ((int) (16384.0d - f));
    }

    public static int ceilPositive(float f) {
        return (int) (f + 0.9999999d);
    }

    public static double clamp(double d, double d2, double d3) {
        return d < d2 ? d2 : d > d3 ? d3 : d;
    }

    public static float clamp(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    public static int clamp(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    public static long clamp(long j, long j2, long j3) {
        return j < j2 ? j2 : j > j3 ? j3 : j;
    }

    public static short clamp(short s2, short s3, short s4) {
        return s2 < s3 ? s3 : s2 > s4 ? s4 : s2;
    }

    public static float cos(float f) {
        return com.badlogic.gdx.math.MathUtils.Sin.a[((int) ((f + 1.5707964f) * 2607.5945f)) & 16383];
    }

    public static float cosDeg(float f) {
        return com.badlogic.gdx.math.MathUtils.Sin.a[((int) ((f + 90.0f) * 45.511112f)) & 16383];
    }

    public static int floor(float f) {
        return ((int) (f + 16384.0d)) - 16384;
    }

    public static int floorPositive(float f) {
        return (int) f;
    }

    public static boolean isEqual(float f, float f2) {
        return java.lang.Math.abs(f - f2) <= 1.0E-6f;
    }

    public static boolean isEqual(float f, float f2, float f3) {
        return java.lang.Math.abs(f - f2) <= f3;
    }

    public static boolean isPowerOfTwo(int i) {
        return i != 0 && (i & (i + (-1))) == 0;
    }

    public static boolean isZero(float f) {
        return java.lang.Math.abs(f) <= 1.0E-6f;
    }

    public static boolean isZero(float f, float f2) {
        return java.lang.Math.abs(f) <= f2;
    }

    public static float lerp(float f, float f2, float f3) {
        return f + ((f2 - f) * f3);
    }

    public static float lerpAngle(float f, float f2, float f3) {
        return ((f + ((((((f2 - f) + 6.2831855f) + 3.1415927f) % 6.2831855f) - 3.1415927f) * f3)) + 6.2831855f) % 6.2831855f;
    }

    public static float lerpAngleDeg(float f, float f2, float f3) {
        return ((f + ((((((f2 - f) + 360.0f) + 180.0f) % 360.0f) - 180.0f) * f3)) + 360.0f) % 360.0f;
    }

    public static float log(float f, float f2) {
        return (float) (java.lang.Math.log(f2) / java.lang.Math.log(f));
    }

    public static float log2(float f) {
        return log(2.0f, f);
    }

    public static int nextPowerOfTwo(int i) {
        if (i == 0) {
            return 1;
        }
        int i2 = i - 1;
        int i3 = i2 | (i2 >> 1);
        int i4 = i3 | (i3 >> 2);
        int i5 = i4 | (i4 >> 4);
        int i6 = i5 | (i5 >> 8);
        return (i6 | (i6 >> 16)) + 1;
    }

    public static float random() {
        return random.nextFloat();
    }

    public static float random(float f) {
        return random.nextFloat() * f;
    }

    public static float random(float f, float f2) {
        return f + (random.nextFloat() * (f2 - f));
    }

    public static int random(int i) {
        return random.nextInt(i + 1);
    }

    public static int random(int i, int i2) {
        return i + random.nextInt((i2 - i) + 1);
    }

    public static long random(long j) {
        return (long) (random.nextDouble() * j);
    }

    public static long random(long j, long j2) {
        return j + ((long) (random.nextDouble() * (j2 - j)));
    }

    public static boolean randomBoolean() {
        return random.nextBoolean();
    }

    public static boolean randomBoolean(float f) {
        return random() < f;
    }

    public static int randomSign() {
        return (random.nextInt() >> 31) | 1;
    }

    public static float randomTriangular() {
        return random.nextFloat() - random.nextFloat();
    }

    public static float randomTriangular(float f) {
        return (random.nextFloat() - random.nextFloat()) * f;
    }

    public static float randomTriangular(float f, float f2) {
        return randomTriangular(f, f2, (f + f2) * 0.5f);
    }

    public static float randomTriangular(float f, float f2, float f3) {
        return random.nextFloat() <= (f3 - f) / (f2 - f) ? f + ((float) java.lang.Math.sqrt(r0 * r1 * r2)) : f2 - ((float) java.lang.Math.sqrt(((1.0f - r0) * r1) * (f2 - f3)));
    }

    public static int round(float f) {
        return ((int) (f + 16384.5d)) - 16384;
    }

    public static int roundPositive(float f) {
        return (int) (f + 0.5f);
    }

    public static float sin(float f) {
        return com.badlogic.gdx.math.MathUtils.Sin.a[((int) (f * 2607.5945f)) & 16383];
    }

    public static float sinDeg(float f) {
        return com.badlogic.gdx.math.MathUtils.Sin.a[((int) (f * 45.511112f)) & 16383];
    }
}
