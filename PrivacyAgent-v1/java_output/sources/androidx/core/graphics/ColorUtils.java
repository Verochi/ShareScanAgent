package androidx.core.graphics;

/* loaded from: classes.dex */
public final class ColorUtils {
    private static final int MIN_ALPHA_SEARCH_MAX_ITERATIONS = 10;
    private static final int MIN_ALPHA_SEARCH_PRECISION = 1;
    private static final java.lang.ThreadLocal<double[]> TEMP_ARRAY = new java.lang.ThreadLocal<>();
    private static final double XYZ_EPSILON = 0.008856d;
    private static final double XYZ_KAPPA = 903.3d;
    private static final double XYZ_WHITE_REFERENCE_X = 95.047d;
    private static final double XYZ_WHITE_REFERENCE_Y = 100.0d;
    private static final double XYZ_WHITE_REFERENCE_Z = 108.883d;

    private ColorUtils() {
    }

    @androidx.annotation.ColorInt
    public static int HSLToColor(@androidx.annotation.NonNull float[] fArr) {
        int round;
        int round2;
        int round3;
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float abs = (1.0f - java.lang.Math.abs((f3 * 2.0f) - 1.0f)) * f2;
        float f4 = f3 - (0.5f * abs);
        float abs2 = (1.0f - java.lang.Math.abs(((f / 60.0f) % 2.0f) - 1.0f)) * abs;
        switch (((int) f) / 60) {
            case 0:
                round = java.lang.Math.round((abs + f4) * 255.0f);
                round2 = java.lang.Math.round((abs2 + f4) * 255.0f);
                round3 = java.lang.Math.round(f4 * 255.0f);
                break;
            case 1:
                round = java.lang.Math.round((abs2 + f4) * 255.0f);
                round2 = java.lang.Math.round((abs + f4) * 255.0f);
                round3 = java.lang.Math.round(f4 * 255.0f);
                break;
            case 2:
                round = java.lang.Math.round(f4 * 255.0f);
                round2 = java.lang.Math.round((abs + f4) * 255.0f);
                round3 = java.lang.Math.round((abs2 + f4) * 255.0f);
                break;
            case 3:
                round = java.lang.Math.round(f4 * 255.0f);
                round2 = java.lang.Math.round((abs2 + f4) * 255.0f);
                round3 = java.lang.Math.round((abs + f4) * 255.0f);
                break;
            case 4:
                round = java.lang.Math.round((abs2 + f4) * 255.0f);
                round2 = java.lang.Math.round(f4 * 255.0f);
                round3 = java.lang.Math.round((abs + f4) * 255.0f);
                break;
            case 5:
            case 6:
                round = java.lang.Math.round((abs + f4) * 255.0f);
                round2 = java.lang.Math.round(f4 * 255.0f);
                round3 = java.lang.Math.round((abs2 + f4) * 255.0f);
                break;
            default:
                round3 = 0;
                round = 0;
                round2 = 0;
                break;
        }
        return android.graphics.Color.rgb(constrain(round, 0, 255), constrain(round2, 0, 255), constrain(round3, 0, 255));
    }

    @androidx.annotation.ColorInt
    public static int LABToColor(@androidx.annotation.FloatRange(from = 0.0d, to = 100.0d) double d, @androidx.annotation.FloatRange(from = -128.0d, to = 127.0d) double d2, @androidx.annotation.FloatRange(from = -128.0d, to = 127.0d) double d3) {
        double[] tempDouble3Array = getTempDouble3Array();
        LABToXYZ(d, d2, d3, tempDouble3Array);
        return XYZToColor(tempDouble3Array[0], tempDouble3Array[1], tempDouble3Array[2]);
    }

    public static void LABToXYZ(@androidx.annotation.FloatRange(from = 0.0d, to = 100.0d) double d, @androidx.annotation.FloatRange(from = -128.0d, to = 127.0d) double d2, @androidx.annotation.FloatRange(from = -128.0d, to = 127.0d) double d3, @androidx.annotation.NonNull double[] dArr) {
        double d4 = (d + 16.0d) / 116.0d;
        double d5 = (d2 / 500.0d) + d4;
        double d6 = d4 - (d3 / 200.0d);
        double pow = java.lang.Math.pow(d5, 3.0d);
        if (pow <= XYZ_EPSILON) {
            pow = ((d5 * 116.0d) - 16.0d) / XYZ_KAPPA;
        }
        double pow2 = d > 7.9996247999999985d ? java.lang.Math.pow(d4, 3.0d) : d / XYZ_KAPPA;
        double pow3 = java.lang.Math.pow(d6, 3.0d);
        if (pow3 <= XYZ_EPSILON) {
            pow3 = ((d6 * 116.0d) - 16.0d) / XYZ_KAPPA;
        }
        dArr[0] = pow * XYZ_WHITE_REFERENCE_X;
        dArr[1] = pow2 * 100.0d;
        dArr[2] = pow3 * XYZ_WHITE_REFERENCE_Z;
    }

    public static void RGBToHSL(@androidx.annotation.IntRange(from = 0, to = 255) int i, @androidx.annotation.IntRange(from = 0, to = 255) int i2, @androidx.annotation.IntRange(from = 0, to = 255) int i3, @androidx.annotation.NonNull float[] fArr) {
        float f;
        float abs;
        float f2 = i / 255.0f;
        float f3 = i2 / 255.0f;
        float f4 = i3 / 255.0f;
        float max = java.lang.Math.max(f2, java.lang.Math.max(f3, f4));
        float min = java.lang.Math.min(f2, java.lang.Math.min(f3, f4));
        float f5 = max - min;
        float f6 = (max + min) / 2.0f;
        if (max == min) {
            f = 0.0f;
            abs = 0.0f;
        } else {
            f = max == f2 ? ((f3 - f4) / f5) % 6.0f : max == f3 ? ((f4 - f2) / f5) + 2.0f : 4.0f + ((f2 - f3) / f5);
            abs = f5 / (1.0f - java.lang.Math.abs((2.0f * f6) - 1.0f));
        }
        float f7 = (f * 60.0f) % 360.0f;
        if (f7 < 0.0f) {
            f7 += 360.0f;
        }
        fArr[0] = constrain(f7, 0.0f, 360.0f);
        fArr[1] = constrain(abs, 0.0f, 1.0f);
        fArr[2] = constrain(f6, 0.0f, 1.0f);
    }

    public static void RGBToLAB(@androidx.annotation.IntRange(from = 0, to = 255) int i, @androidx.annotation.IntRange(from = 0, to = 255) int i2, @androidx.annotation.IntRange(from = 0, to = 255) int i3, @androidx.annotation.NonNull double[] dArr) {
        RGBToXYZ(i, i2, i3, dArr);
        XYZToLAB(dArr[0], dArr[1], dArr[2], dArr);
    }

    public static void RGBToXYZ(@androidx.annotation.IntRange(from = 0, to = 255) int i, @androidx.annotation.IntRange(from = 0, to = 255) int i2, @androidx.annotation.IntRange(from = 0, to = 255) int i3, @androidx.annotation.NonNull double[] dArr) {
        if (dArr.length != 3) {
            throw new java.lang.IllegalArgumentException("outXyz must have a length of 3.");
        }
        double d = i / 255.0d;
        double pow = d < 0.04045d ? d / 12.92d : java.lang.Math.pow((d + 0.055d) / 1.055d, 2.4d);
        double d2 = i2 / 255.0d;
        double pow2 = d2 < 0.04045d ? d2 / 12.92d : java.lang.Math.pow((d2 + 0.055d) / 1.055d, 2.4d);
        double d3 = i3 / 255.0d;
        double pow3 = d3 < 0.04045d ? d3 / 12.92d : java.lang.Math.pow((d3 + 0.055d) / 1.055d, 2.4d);
        dArr[0] = ((0.4124d * pow) + (0.3576d * pow2) + (0.1805d * pow3)) * 100.0d;
        dArr[1] = ((0.2126d * pow) + (0.7152d * pow2) + (0.0722d * pow3)) * 100.0d;
        dArr[2] = ((pow * 0.0193d) + (pow2 * 0.1192d) + (pow3 * 0.9505d)) * 100.0d;
    }

    @androidx.annotation.ColorInt
    public static int XYZToColor(@androidx.annotation.FloatRange(from = 0.0d, to = 95.047d) double d, @androidx.annotation.FloatRange(from = 0.0d, to = 100.0d) double d2, @androidx.annotation.FloatRange(from = 0.0d, to = 108.883d) double d3) {
        double d4 = (((3.2406d * d) + ((-1.5372d) * d2)) + ((-0.4986d) * d3)) / 100.0d;
        double d5 = ((((-0.9689d) * d) + (1.8758d * d2)) + (0.0415d * d3)) / 100.0d;
        double d6 = (((0.0557d * d) + ((-0.204d) * d2)) + (1.057d * d3)) / 100.0d;
        return android.graphics.Color.rgb(constrain((int) java.lang.Math.round((d4 > 0.0031308d ? (java.lang.Math.pow(d4, 0.4166666666666667d) * 1.055d) - 0.055d : d4 * 12.92d) * 255.0d), 0, 255), constrain((int) java.lang.Math.round((d5 > 0.0031308d ? (java.lang.Math.pow(d5, 0.4166666666666667d) * 1.055d) - 0.055d : d5 * 12.92d) * 255.0d), 0, 255), constrain((int) java.lang.Math.round((d6 > 0.0031308d ? (java.lang.Math.pow(d6, 0.4166666666666667d) * 1.055d) - 0.055d : d6 * 12.92d) * 255.0d), 0, 255));
    }

    public static void XYZToLAB(@androidx.annotation.FloatRange(from = 0.0d, to = 95.047d) double d, @androidx.annotation.FloatRange(from = 0.0d, to = 100.0d) double d2, @androidx.annotation.FloatRange(from = 0.0d, to = 108.883d) double d3, @androidx.annotation.NonNull double[] dArr) {
        if (dArr.length != 3) {
            throw new java.lang.IllegalArgumentException("outLab must have a length of 3.");
        }
        double pivotXyzComponent = pivotXyzComponent(d / XYZ_WHITE_REFERENCE_X);
        double pivotXyzComponent2 = pivotXyzComponent(d2 / 100.0d);
        double pivotXyzComponent3 = pivotXyzComponent(d3 / XYZ_WHITE_REFERENCE_Z);
        dArr[0] = java.lang.Math.max(0.0d, (116.0d * pivotXyzComponent2) - 16.0d);
        dArr[1] = (pivotXyzComponent - pivotXyzComponent2) * 500.0d;
        dArr[2] = (pivotXyzComponent2 - pivotXyzComponent3) * 200.0d;
    }

    @androidx.annotation.ColorInt
    public static int blendARGB(@androidx.annotation.ColorInt int i, @androidx.annotation.ColorInt int i2, @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f) {
        float f2 = 1.0f - f;
        return android.graphics.Color.argb((int) ((android.graphics.Color.alpha(i) * f2) + (android.graphics.Color.alpha(i2) * f)), (int) ((android.graphics.Color.red(i) * f2) + (android.graphics.Color.red(i2) * f)), (int) ((android.graphics.Color.green(i) * f2) + (android.graphics.Color.green(i2) * f)), (int) ((android.graphics.Color.blue(i) * f2) + (android.graphics.Color.blue(i2) * f)));
    }

    public static void blendHSL(@androidx.annotation.NonNull float[] fArr, @androidx.annotation.NonNull float[] fArr2, @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f, @androidx.annotation.NonNull float[] fArr3) {
        if (fArr3.length != 3) {
            throw new java.lang.IllegalArgumentException("result must have a length of 3.");
        }
        float f2 = 1.0f - f;
        fArr3[0] = circularInterpolate(fArr[0], fArr2[0], f);
        fArr3[1] = (fArr[1] * f2) + (fArr2[1] * f);
        fArr3[2] = (fArr[2] * f2) + (fArr2[2] * f);
    }

    public static void blendLAB(@androidx.annotation.NonNull double[] dArr, @androidx.annotation.NonNull double[] dArr2, @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) double d, @androidx.annotation.NonNull double[] dArr3) {
        if (dArr3.length != 3) {
            throw new java.lang.IllegalArgumentException("outResult must have a length of 3.");
        }
        double d2 = 1.0d - d;
        dArr3[0] = (dArr[0] * d2) + (dArr2[0] * d);
        dArr3[1] = (dArr[1] * d2) + (dArr2[1] * d);
        dArr3[2] = (dArr[2] * d2) + (dArr2[2] * d);
    }

    public static double calculateContrast(@androidx.annotation.ColorInt int i, @androidx.annotation.ColorInt int i2) {
        if (android.graphics.Color.alpha(i2) != 255) {
            throw new java.lang.IllegalArgumentException("background can not be translucent: #" + java.lang.Integer.toHexString(i2));
        }
        if (android.graphics.Color.alpha(i) < 255) {
            i = compositeColors(i, i2);
        }
        double calculateLuminance = calculateLuminance(i) + 0.05d;
        double calculateLuminance2 = calculateLuminance(i2) + 0.05d;
        return java.lang.Math.max(calculateLuminance, calculateLuminance2) / java.lang.Math.min(calculateLuminance, calculateLuminance2);
    }

    @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d)
    public static double calculateLuminance(@androidx.annotation.ColorInt int i) {
        double[] tempDouble3Array = getTempDouble3Array();
        colorToXYZ(i, tempDouble3Array);
        return tempDouble3Array[1] / 100.0d;
    }

    public static int calculateMinimumAlpha(@androidx.annotation.ColorInt int i, @androidx.annotation.ColorInt int i2, float f) {
        int i3 = 255;
        if (android.graphics.Color.alpha(i2) != 255) {
            throw new java.lang.IllegalArgumentException("background can not be translucent: #" + java.lang.Integer.toHexString(i2));
        }
        double d = f;
        if (calculateContrast(setAlphaComponent(i, 255), i2) < d) {
            return -1;
        }
        int i4 = 0;
        for (int i5 = 0; i5 <= 10 && i3 - i4 > 1; i5++) {
            int i6 = (i4 + i3) / 2;
            if (calculateContrast(setAlphaComponent(i, i6), i2) < d) {
                i4 = i6;
            } else {
                i3 = i6;
            }
        }
        return i3;
    }

    @androidx.annotation.VisibleForTesting
    public static float circularInterpolate(float f, float f2, float f3) {
        if (java.lang.Math.abs(f2 - f) > 180.0f) {
            if (f2 > f) {
                f += 360.0f;
            } else {
                f2 += 360.0f;
            }
        }
        return (f + ((f2 - f) * f3)) % 360.0f;
    }

    public static void colorToHSL(@androidx.annotation.ColorInt int i, @androidx.annotation.NonNull float[] fArr) {
        RGBToHSL(android.graphics.Color.red(i), android.graphics.Color.green(i), android.graphics.Color.blue(i), fArr);
    }

    public static void colorToLAB(@androidx.annotation.ColorInt int i, @androidx.annotation.NonNull double[] dArr) {
        RGBToLAB(android.graphics.Color.red(i), android.graphics.Color.green(i), android.graphics.Color.blue(i), dArr);
    }

    public static void colorToXYZ(@androidx.annotation.ColorInt int i, @androidx.annotation.NonNull double[] dArr) {
        RGBToXYZ(android.graphics.Color.red(i), android.graphics.Color.green(i), android.graphics.Color.blue(i), dArr);
    }

    private static int compositeAlpha(int i, int i2) {
        return 255 - (((255 - i2) * (255 - i)) / 255);
    }

    public static int compositeColors(@androidx.annotation.ColorInt int i, @androidx.annotation.ColorInt int i2) {
        int alpha = android.graphics.Color.alpha(i2);
        int alpha2 = android.graphics.Color.alpha(i);
        int compositeAlpha = compositeAlpha(alpha2, alpha);
        return android.graphics.Color.argb(compositeAlpha, compositeComponent(android.graphics.Color.red(i), alpha2, android.graphics.Color.red(i2), alpha, compositeAlpha), compositeComponent(android.graphics.Color.green(i), alpha2, android.graphics.Color.green(i2), alpha, compositeAlpha), compositeComponent(android.graphics.Color.blue(i), alpha2, android.graphics.Color.blue(i2), alpha, compositeAlpha));
    }

    @androidx.annotation.NonNull
    @androidx.annotation.RequiresApi(26)
    public static android.graphics.Color compositeColors(@androidx.annotation.NonNull android.graphics.Color color, @androidx.annotation.NonNull android.graphics.Color color2) {
        android.graphics.ColorSpace.Model model;
        android.graphics.ColorSpace.Model model2;
        android.graphics.ColorSpace.Model model3;
        android.graphics.ColorSpace.Model model4;
        android.graphics.ColorSpace colorSpace;
        android.graphics.ColorSpace colorSpace2;
        float[] components;
        float[] components2;
        float alpha;
        float alpha2;
        int componentCount;
        android.graphics.ColorSpace colorSpace3;
        android.graphics.Color valueOf;
        android.graphics.ColorSpace colorSpace4;
        model = color.getModel();
        model2 = color2.getModel();
        if (!java.util.Objects.equals(model, model2)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Color models must match (");
            model3 = color.getModel();
            sb.append(model3);
            sb.append(" vs. ");
            model4 = color2.getModel();
            sb.append(model4);
            sb.append(")");
            throw new java.lang.IllegalArgumentException(sb.toString());
        }
        colorSpace = color2.getColorSpace();
        colorSpace2 = color.getColorSpace();
        if (!java.util.Objects.equals(colorSpace, colorSpace2)) {
            colorSpace4 = color2.getColorSpace();
            color = color.convert(colorSpace4);
        }
        components = color.getComponents();
        components2 = color2.getComponents();
        alpha = color.alpha();
        alpha2 = color2.alpha();
        float f = alpha2 * (1.0f - alpha);
        componentCount = color2.getComponentCount();
        int i = componentCount - 1;
        float f2 = alpha + f;
        components2[i] = f2;
        if (f2 > 0.0f) {
            alpha /= f2;
            f /= f2;
        }
        for (int i2 = 0; i2 < i; i2++) {
            components2[i2] = (components[i2] * alpha) + (components2[i2] * f);
        }
        colorSpace3 = color2.getColorSpace();
        valueOf = android.graphics.Color.valueOf(components2, colorSpace3);
        return valueOf;
    }

    private static int compositeComponent(int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            return 0;
        }
        return (((i * 255) * i2) + ((i3 * i4) * (255 - i2))) / (i5 * 255);
    }

    private static float constrain(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    private static int constrain(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    public static double distanceEuclidean(@androidx.annotation.NonNull double[] dArr, @androidx.annotation.NonNull double[] dArr2) {
        return java.lang.Math.sqrt(java.lang.Math.pow(dArr[0] - dArr2[0], 2.0d) + java.lang.Math.pow(dArr[1] - dArr2[1], 2.0d) + java.lang.Math.pow(dArr[2] - dArr2[2], 2.0d));
    }

    private static double[] getTempDouble3Array() {
        java.lang.ThreadLocal<double[]> threadLocal = TEMP_ARRAY;
        double[] dArr = threadLocal.get();
        if (dArr != null) {
            return dArr;
        }
        double[] dArr2 = new double[3];
        threadLocal.set(dArr2);
        return dArr2;
    }

    private static double pivotXyzComponent(double d) {
        return d > XYZ_EPSILON ? java.lang.Math.pow(d, 0.3333333333333333d) : ((d * XYZ_KAPPA) + 16.0d) / 116.0d;
    }

    @androidx.annotation.ColorInt
    public static int setAlphaComponent(@androidx.annotation.ColorInt int i, @androidx.annotation.IntRange(from = 0, to = 255) int i2) {
        if (i2 < 0 || i2 > 255) {
            throw new java.lang.IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (i & 16777215) | (i2 << 24);
    }
}
