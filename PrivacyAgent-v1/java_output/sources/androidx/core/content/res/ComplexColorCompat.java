package androidx.core.content.res;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class ComplexColorCompat {
    private static final java.lang.String LOG_TAG = "ComplexColorCompat";
    private int mColor;
    private final android.content.res.ColorStateList mColorStateList;
    private final android.graphics.Shader mShader;

    private ComplexColorCompat(android.graphics.Shader shader, android.content.res.ColorStateList colorStateList, @androidx.annotation.ColorInt int i) {
        this.mShader = shader;
        this.mColorStateList = colorStateList;
        this.mColor = i;
    }

    @androidx.annotation.NonNull
    private static androidx.core.content.res.ComplexColorCompat createFromXml(@androidx.annotation.NonNull android.content.res.Resources resources, @androidx.annotation.ColorRes int i, @androidx.annotation.Nullable android.content.res.Resources.Theme theme) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException {
        int next;
        android.content.res.XmlResourceParser xml = resources.getXml(i);
        android.util.AttributeSet asAttributeSet = android.util.Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new org.xmlpull.v1.XmlPullParserException("No start tag found");
        }
        java.lang.String name = xml.getName();
        name.hashCode();
        if (name.equals("gradient")) {
            return from(androidx.core.content.res.GradientColorInflaterCompat.createFromXmlInner(resources, xml, asAttributeSet, theme));
        }
        if (name.equals("selector")) {
            return from(androidx.core.content.res.ColorStateListInflaterCompat.createFromXmlInner(resources, xml, asAttributeSet, theme));
        }
        throw new org.xmlpull.v1.XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
    }

    public static androidx.core.content.res.ComplexColorCompat from(@androidx.annotation.ColorInt int i) {
        return new androidx.core.content.res.ComplexColorCompat(null, null, i);
    }

    public static androidx.core.content.res.ComplexColorCompat from(@androidx.annotation.NonNull android.content.res.ColorStateList colorStateList) {
        return new androidx.core.content.res.ComplexColorCompat(null, colorStateList, colorStateList.getDefaultColor());
    }

    public static androidx.core.content.res.ComplexColorCompat from(@androidx.annotation.NonNull android.graphics.Shader shader) {
        return new androidx.core.content.res.ComplexColorCompat(shader, null, 0);
    }

    @androidx.annotation.Nullable
    public static androidx.core.content.res.ComplexColorCompat inflate(@androidx.annotation.NonNull android.content.res.Resources resources, @androidx.annotation.ColorRes int i, @androidx.annotation.Nullable android.content.res.Resources.Theme theme) {
        try {
            return createFromXml(resources, i, theme);
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    @androidx.annotation.ColorInt
    public int getColor() {
        return this.mColor;
    }

    @androidx.annotation.Nullable
    public android.graphics.Shader getShader() {
        return this.mShader;
    }

    public boolean isGradient() {
        return this.mShader != null;
    }

    public boolean isStateful() {
        android.content.res.ColorStateList colorStateList;
        return this.mShader == null && (colorStateList = this.mColorStateList) != null && colorStateList.isStateful();
    }

    public boolean onStateChanged(int[] iArr) {
        if (isStateful()) {
            android.content.res.ColorStateList colorStateList = this.mColorStateList;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.mColor) {
                this.mColor = colorForState;
                return true;
            }
        }
        return false;
    }

    public void setColor(@androidx.annotation.ColorInt int i) {
        this.mColor = i;
    }

    public boolean willDraw() {
        return isGradient() || this.mColor != 0;
    }
}
