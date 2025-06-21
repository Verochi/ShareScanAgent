package androidx.core.content.res;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
final class GradientColorInflaterCompat {
    private static final int TILE_MODE_CLAMP = 0;
    private static final int TILE_MODE_MIRROR = 2;
    private static final int TILE_MODE_REPEAT = 1;

    public static final class ColorStops {
        final int[] mColors;
        final float[] mOffsets;

        public ColorStops(@androidx.annotation.ColorInt int i, @androidx.annotation.ColorInt int i2) {
            this.mColors = new int[]{i, i2};
            this.mOffsets = new float[]{0.0f, 1.0f};
        }

        public ColorStops(@androidx.annotation.ColorInt int i, @androidx.annotation.ColorInt int i2, @androidx.annotation.ColorInt int i3) {
            this.mColors = new int[]{i, i2, i3};
            this.mOffsets = new float[]{0.0f, 0.5f, 1.0f};
        }

        public ColorStops(@androidx.annotation.NonNull java.util.List<java.lang.Integer> list, @androidx.annotation.NonNull java.util.List<java.lang.Float> list2) {
            int size = list.size();
            this.mColors = new int[size];
            this.mOffsets = new float[size];
            for (int i = 0; i < size; i++) {
                this.mColors[i] = list.get(i).intValue();
                this.mOffsets[i] = list2.get(i).floatValue();
            }
        }
    }

    private GradientColorInflaterCompat() {
    }

    private static androidx.core.content.res.GradientColorInflaterCompat.ColorStops checkColors(@androidx.annotation.Nullable androidx.core.content.res.GradientColorInflaterCompat.ColorStops colorStops, @androidx.annotation.ColorInt int i, @androidx.annotation.ColorInt int i2, boolean z, @androidx.annotation.ColorInt int i3) {
        return colorStops != null ? colorStops : z ? new androidx.core.content.res.GradientColorInflaterCompat.ColorStops(i, i3, i2) : new androidx.core.content.res.GradientColorInflaterCompat.ColorStops(i, i2);
    }

    public static android.graphics.Shader createFromXml(@androidx.annotation.NonNull android.content.res.Resources resources, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser xmlPullParser, @androidx.annotation.Nullable android.content.res.Resources.Theme theme) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        int next;
        android.util.AttributeSet asAttributeSet = android.util.Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return createFromXmlInner(resources, xmlPullParser, asAttributeSet, theme);
        }
        throw new org.xmlpull.v1.XmlPullParserException("No start tag found");
    }

    public static android.graphics.Shader createFromXmlInner(@androidx.annotation.NonNull android.content.res.Resources resources, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser xmlPullParser, @androidx.annotation.NonNull android.util.AttributeSet attributeSet, @androidx.annotation.Nullable android.content.res.Resources.Theme theme) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException {
        java.lang.String name = xmlPullParser.getName();
        if (!name.equals("gradient")) {
            throw new org.xmlpull.v1.XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
        }
        android.content.res.TypedArray obtainAttributes = androidx.core.content.res.TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, androidx.core.R.styleable.GradientColor);
        float namedFloat = androidx.core.content.res.TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "startX", androidx.core.R.styleable.GradientColor_android_startX, 0.0f);
        float namedFloat2 = androidx.core.content.res.TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "startY", androidx.core.R.styleable.GradientColor_android_startY, 0.0f);
        float namedFloat3 = androidx.core.content.res.TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "endX", androidx.core.R.styleable.GradientColor_android_endX, 0.0f);
        float namedFloat4 = androidx.core.content.res.TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "endY", androidx.core.R.styleable.GradientColor_android_endY, 0.0f);
        float namedFloat5 = androidx.core.content.res.TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "centerX", androidx.core.R.styleable.GradientColor_android_centerX, 0.0f);
        float namedFloat6 = androidx.core.content.res.TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "centerY", androidx.core.R.styleable.GradientColor_android_centerY, 0.0f);
        int namedInt = androidx.core.content.res.TypedArrayUtils.getNamedInt(obtainAttributes, xmlPullParser, "type", androidx.core.R.styleable.GradientColor_android_type, 0);
        int namedColor = androidx.core.content.res.TypedArrayUtils.getNamedColor(obtainAttributes, xmlPullParser, "startColor", androidx.core.R.styleable.GradientColor_android_startColor, 0);
        boolean hasAttribute = androidx.core.content.res.TypedArrayUtils.hasAttribute(xmlPullParser, "centerColor");
        int namedColor2 = androidx.core.content.res.TypedArrayUtils.getNamedColor(obtainAttributes, xmlPullParser, "centerColor", androidx.core.R.styleable.GradientColor_android_centerColor, 0);
        int namedColor3 = androidx.core.content.res.TypedArrayUtils.getNamedColor(obtainAttributes, xmlPullParser, "endColor", androidx.core.R.styleable.GradientColor_android_endColor, 0);
        int namedInt2 = androidx.core.content.res.TypedArrayUtils.getNamedInt(obtainAttributes, xmlPullParser, "tileMode", androidx.core.R.styleable.GradientColor_android_tileMode, 0);
        float namedFloat7 = androidx.core.content.res.TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "gradientRadius", androidx.core.R.styleable.GradientColor_android_gradientRadius, 0.0f);
        obtainAttributes.recycle();
        androidx.core.content.res.GradientColorInflaterCompat.ColorStops checkColors = checkColors(inflateChildElements(resources, xmlPullParser, attributeSet, theme), namedColor, namedColor3, hasAttribute, namedColor2);
        if (namedInt != 1) {
            return namedInt != 2 ? new android.graphics.LinearGradient(namedFloat, namedFloat2, namedFloat3, namedFloat4, checkColors.mColors, checkColors.mOffsets, parseTileMode(namedInt2)) : new android.graphics.SweepGradient(namedFloat5, namedFloat6, checkColors.mColors, checkColors.mOffsets);
        }
        if (namedFloat7 > 0.0f) {
            return new android.graphics.RadialGradient(namedFloat5, namedFloat6, namedFloat7, checkColors.mColors, checkColors.mOffsets, parseTileMode(namedInt2));
        }
        throw new org.xmlpull.v1.XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0080, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r10.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static androidx.core.content.res.GradientColorInflaterCompat.ColorStops inflateChildElements(@androidx.annotation.NonNull android.content.res.Resources resources, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser xmlPullParser, @androidx.annotation.NonNull android.util.AttributeSet attributeSet, @androidx.annotation.Nullable android.content.res.Resources.Theme theme) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        int depth;
        int depth2 = xmlPullParser.getDepth() + 1;
        java.util.ArrayList arrayList = new java.util.ArrayList(20);
        java.util.ArrayList arrayList2 = new java.util.ArrayList(20);
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                android.content.res.TypedArray obtainAttributes = androidx.core.content.res.TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, androidx.core.R.styleable.GradientColorItem);
                int i = androidx.core.R.styleable.GradientColorItem_android_color;
                boolean hasValue = obtainAttributes.hasValue(i);
                int i2 = androidx.core.R.styleable.GradientColorItem_android_offset;
                boolean hasValue2 = obtainAttributes.hasValue(i2);
                if (!hasValue || !hasValue2) {
                    break;
                }
                int color = obtainAttributes.getColor(i, 0);
                float f = obtainAttributes.getFloat(i2, 0.0f);
                obtainAttributes.recycle();
                arrayList2.add(java.lang.Integer.valueOf(color));
                arrayList.add(java.lang.Float.valueOf(f));
            }
        }
        if (arrayList2.size() > 0) {
            return new androidx.core.content.res.GradientColorInflaterCompat.ColorStops(arrayList2, arrayList);
        }
        return null;
    }

    private static android.graphics.Shader.TileMode parseTileMode(int i) {
        return i != 1 ? i != 2 ? android.graphics.Shader.TileMode.CLAMP : android.graphics.Shader.TileMode.MIRROR : android.graphics.Shader.TileMode.REPEAT;
    }
}
