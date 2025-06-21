package androidx.core.content.res;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class ColorStateListInflaterCompat {
    private ColorStateListInflaterCompat() {
    }

    @androidx.annotation.NonNull
    public static android.content.res.ColorStateList createFromXml(@androidx.annotation.NonNull android.content.res.Resources resources, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser xmlPullParser, @androidx.annotation.Nullable android.content.res.Resources.Theme theme) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
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

    @androidx.annotation.NonNull
    public static android.content.res.ColorStateList createFromXmlInner(@androidx.annotation.NonNull android.content.res.Resources resources, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser xmlPullParser, @androidx.annotation.NonNull android.util.AttributeSet attributeSet, @androidx.annotation.Nullable android.content.res.Resources.Theme theme) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        java.lang.String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return inflate(resources, xmlPullParser, attributeSet, theme);
        }
        throw new org.xmlpull.v1.XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    @androidx.annotation.Nullable
    public static android.content.res.ColorStateList inflate(@androidx.annotation.NonNull android.content.res.Resources resources, @androidx.annotation.XmlRes int i, @androidx.annotation.Nullable android.content.res.Resources.Theme theme) {
        try {
            return createFromXml(resources, resources.getXml(i), theme);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    private static android.content.res.ColorStateList inflate(@androidx.annotation.NonNull android.content.res.Resources resources, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser xmlPullParser, @androidx.annotation.NonNull android.util.AttributeSet attributeSet, @androidx.annotation.Nullable android.content.res.Resources.Theme theme) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        int depth;
        int i = 1;
        int depth2 = xmlPullParser.getDepth() + 1;
        int[][] iArr = new int[20][];
        int[] iArr2 = new int[20];
        int i2 = 0;
        while (true) {
            int next = xmlPullParser.next();
            if (next == i || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                android.content.res.TypedArray obtainAttributes = obtainAttributes(resources, theme, attributeSet, androidx.core.R.styleable.ColorStateListItem);
                int color = obtainAttributes.getColor(androidx.core.R.styleable.ColorStateListItem_android_color, -65281);
                int i3 = androidx.core.R.styleable.ColorStateListItem_android_alpha;
                float f = 1.0f;
                if (obtainAttributes.hasValue(i3)) {
                    f = obtainAttributes.getFloat(i3, 1.0f);
                } else {
                    int i4 = androidx.core.R.styleable.ColorStateListItem_alpha;
                    if (obtainAttributes.hasValue(i4)) {
                        f = obtainAttributes.getFloat(i4, 1.0f);
                    }
                }
                obtainAttributes.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr3 = new int[attributeCount];
                int i5 = 0;
                for (int i6 = 0; i6 < attributeCount; i6++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i6);
                    if (attributeNameResource != 16843173 && attributeNameResource != 16843551 && attributeNameResource != androidx.core.R.attr.alpha) {
                        int i7 = i5 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i6, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr3[i5] = attributeNameResource;
                        i5 = i7;
                    }
                }
                int[] trimStateSet = android.util.StateSet.trimStateSet(iArr3, i5);
                iArr2 = androidx.core.content.res.GrowingArrayUtils.append(iArr2, i2, modulateColorAlpha(color, f));
                iArr = (int[][]) androidx.core.content.res.GrowingArrayUtils.append(iArr, i2, trimStateSet);
                i2++;
            }
            i = 1;
        }
        int[] iArr4 = new int[i2];
        int[][] iArr5 = new int[i2][];
        java.lang.System.arraycopy(iArr2, 0, iArr4, 0, i2);
        java.lang.System.arraycopy(iArr, 0, iArr5, 0, i2);
        return new android.content.res.ColorStateList(iArr5, iArr4);
    }

    @androidx.annotation.ColorInt
    private static int modulateColorAlpha(@androidx.annotation.ColorInt int i, @androidx.annotation.FloatRange(from = 0.0d, to = 1.0d) float f) {
        return (i & 16777215) | (java.lang.Math.round(android.graphics.Color.alpha(i) * f) << 24);
    }

    private static android.content.res.TypedArray obtainAttributes(android.content.res.Resources resources, android.content.res.Resources.Theme theme, android.util.AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
