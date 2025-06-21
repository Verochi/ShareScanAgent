package androidx.vectordrawable.graphics.drawable;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class PathInterpolatorCompat implements android.view.animation.Interpolator {
    public static final double EPSILON = 1.0E-5d;
    public static final int MAX_NUM_POINTS = 3000;
    private static final float PRECISION = 0.002f;
    private float[] mX;
    private float[] mY;

    public PathInterpolatorCompat(android.content.Context context, android.util.AttributeSet attributeSet, org.xmlpull.v1.XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    public PathInterpolatorCompat(android.content.res.Resources resources, android.content.res.Resources.Theme theme, android.util.AttributeSet attributeSet, org.xmlpull.v1.XmlPullParser xmlPullParser) {
        android.content.res.TypedArray obtainAttributes = androidx.core.content.res.TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.AndroidResources.STYLEABLE_PATH_INTERPOLATOR);
        parseInterpolatorFromTypeArray(obtainAttributes, xmlPullParser);
        obtainAttributes.recycle();
    }

    private void initCubic(float f, float f2, float f3, float f4) {
        android.graphics.Path path = new android.graphics.Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f, f2, f3, f4, 1.0f, 1.0f);
        initPath(path);
    }

    private void initPath(android.graphics.Path path) {
        int i = 0;
        android.graphics.PathMeasure pathMeasure = new android.graphics.PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int min = java.lang.Math.min(3000, ((int) (length / 0.002f)) + 1);
        if (min <= 0) {
            throw new java.lang.IllegalArgumentException("The Path has a invalid length " + length);
        }
        this.mX = new float[min];
        this.mY = new float[min];
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < min; i2++) {
            pathMeasure.getPosTan((i2 * length) / (min - 1), fArr, null);
            this.mX[i2] = fArr[0];
            this.mY[i2] = fArr[1];
        }
        if (java.lang.Math.abs(this.mX[0]) <= 1.0E-5d && java.lang.Math.abs(this.mY[0]) <= 1.0E-5d) {
            int i3 = min - 1;
            if (java.lang.Math.abs(this.mX[i3] - 1.0f) <= 1.0E-5d && java.lang.Math.abs(this.mY[i3] - 1.0f) <= 1.0E-5d) {
                float f = 0.0f;
                int i4 = 0;
                while (i < min) {
                    float[] fArr2 = this.mX;
                    int i5 = i4 + 1;
                    float f2 = fArr2[i4];
                    if (f2 < f) {
                        throw new java.lang.IllegalArgumentException("The Path cannot loop back on itself, x :" + f2);
                    }
                    fArr2[i] = f2;
                    i++;
                    f = f2;
                    i4 = i5;
                }
                if (pathMeasure.nextContour()) {
                    throw new java.lang.IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
                }
                return;
            }
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("The Path must start at (0,0) and end at (1,1) start: ");
        sb.append(this.mX[0]);
        sb.append(",");
        sb.append(this.mY[0]);
        sb.append(" end:");
        int i6 = min - 1;
        sb.append(this.mX[i6]);
        sb.append(",");
        sb.append(this.mY[i6]);
        throw new java.lang.IllegalArgumentException(sb.toString());
    }

    private void initQuad(float f, float f2) {
        android.graphics.Path path = new android.graphics.Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f, f2, 1.0f, 1.0f);
        initPath(path);
    }

    private void parseInterpolatorFromTypeArray(android.content.res.TypedArray typedArray, org.xmlpull.v1.XmlPullParser xmlPullParser) {
        if (androidx.core.content.res.TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
            java.lang.String namedString = androidx.core.content.res.TypedArrayUtils.getNamedString(typedArray, xmlPullParser, "pathData", 4);
            android.graphics.Path createPathFromPathData = androidx.core.graphics.PathParser.createPathFromPathData(namedString);
            if (createPathFromPathData != null) {
                initPath(createPathFromPathData);
                return;
            }
            throw new android.view.InflateException("The path is null, which is created from " + namedString);
        }
        if (!androidx.core.content.res.TypedArrayUtils.hasAttribute(xmlPullParser, "controlX1")) {
            throw new android.view.InflateException("pathInterpolator requires the controlX1 attribute");
        }
        if (!androidx.core.content.res.TypedArrayUtils.hasAttribute(xmlPullParser, "controlY1")) {
            throw new android.view.InflateException("pathInterpolator requires the controlY1 attribute");
        }
        float namedFloat = androidx.core.content.res.TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlX1", 0, 0.0f);
        float namedFloat2 = androidx.core.content.res.TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlY1", 1, 0.0f);
        boolean hasAttribute = androidx.core.content.res.TypedArrayUtils.hasAttribute(xmlPullParser, "controlX2");
        if (hasAttribute != androidx.core.content.res.TypedArrayUtils.hasAttribute(xmlPullParser, "controlY2")) {
            throw new android.view.InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
        }
        if (hasAttribute) {
            initCubic(namedFloat, namedFloat2, androidx.core.content.res.TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlX2", 2, 0.0f), androidx.core.content.res.TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "controlY2", 3, 0.0f));
        } else {
            initQuad(namedFloat, namedFloat2);
        }
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int length = this.mX.length - 1;
        int i = 0;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.mX[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float[] fArr = this.mX;
        float f2 = fArr[length];
        float f3 = fArr[i];
        float f4 = f2 - f3;
        if (f4 == 0.0f) {
            return this.mY[i];
        }
        float f5 = (f - f3) / f4;
        float[] fArr2 = this.mY;
        float f6 = fArr2[i];
        return f6 + (f5 * (fArr2[length] - f6));
    }
}
