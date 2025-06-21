package com.badlogic.gdx.utils;

/* loaded from: classes12.dex */
public enum Scaling {
    fit,
    fill,
    fillX,
    fillY,
    stretch,
    stretchX,
    stretchY,
    none;

    private static final com.badlogic.gdx.math.Vector2 temp = new com.badlogic.gdx.math.Vector2();

    /* renamed from: com.badlogic.gdx.utils.Scaling$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.badlogic.gdx.utils.Scaling.values().length];
            a = iArr;
            try {
                iArr[com.badlogic.gdx.utils.Scaling.fit.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                a[com.badlogic.gdx.utils.Scaling.fill.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                a[com.badlogic.gdx.utils.Scaling.fillX.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                a[com.badlogic.gdx.utils.Scaling.fillY.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                a[com.badlogic.gdx.utils.Scaling.stretch.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                a[com.badlogic.gdx.utils.Scaling.stretchX.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
            try {
                a[com.badlogic.gdx.utils.Scaling.stretchY.ordinal()] = 7;
            } catch (java.lang.NoSuchFieldError unused7) {
            }
            try {
                a[com.badlogic.gdx.utils.Scaling.none.ordinal()] = 8;
            } catch (java.lang.NoSuchFieldError unused8) {
            }
        }
    }

    public com.badlogic.gdx.math.Vector2 apply(float f, float f2, float f3, float f4) {
        switch (com.badlogic.gdx.utils.Scaling.AnonymousClass1.a[ordinal()]) {
            case 1:
                float f5 = f4 / f3 > f2 / f ? f3 / f : f4 / f2;
                com.badlogic.gdx.math.Vector2 vector2 = temp;
                vector2.x = f * f5;
                vector2.y = f2 * f5;
                break;
            case 2:
                float f6 = f4 / f3 < f2 / f ? f3 / f : f4 / f2;
                com.badlogic.gdx.math.Vector2 vector22 = temp;
                vector22.x = f * f6;
                vector22.y = f2 * f6;
                break;
            case 3:
                float f7 = f3 / f;
                com.badlogic.gdx.math.Vector2 vector23 = temp;
                vector23.x = f * f7;
                vector23.y = f2 * f7;
                break;
            case 4:
                float f8 = f4 / f2;
                com.badlogic.gdx.math.Vector2 vector24 = temp;
                vector24.x = f * f8;
                vector24.y = f2 * f8;
                break;
            case 5:
                com.badlogic.gdx.math.Vector2 vector25 = temp;
                vector25.x = f3;
                vector25.y = f4;
                break;
            case 6:
                com.badlogic.gdx.math.Vector2 vector26 = temp;
                vector26.x = f3;
                vector26.y = f2;
                break;
            case 7:
                com.badlogic.gdx.math.Vector2 vector27 = temp;
                vector27.x = f;
                vector27.y = f4;
                break;
            case 8:
                com.badlogic.gdx.math.Vector2 vector28 = temp;
                vector28.x = f;
                vector28.y = f2;
                break;
        }
        return temp;
    }
}
