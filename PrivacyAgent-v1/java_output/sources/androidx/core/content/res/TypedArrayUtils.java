package androidx.core.content.res;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class TypedArrayUtils {
    private static final java.lang.String NAMESPACE = "http://schemas.android.com/apk/res/android";

    private TypedArrayUtils() {
    }

    public static int getAttr(@androidx.annotation.NonNull android.content.Context context, int i, int i2) {
        android.util.TypedValue typedValue = new android.util.TypedValue();
        context.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId != 0 ? i : i2;
    }

    public static boolean getBoolean(@androidx.annotation.NonNull android.content.res.TypedArray typedArray, @androidx.annotation.StyleableRes int i, @androidx.annotation.StyleableRes int i2, boolean z) {
        return typedArray.getBoolean(i, typedArray.getBoolean(i2, z));
    }

    @androidx.annotation.Nullable
    public static android.graphics.drawable.Drawable getDrawable(@androidx.annotation.NonNull android.content.res.TypedArray typedArray, @androidx.annotation.StyleableRes int i, @androidx.annotation.StyleableRes int i2) {
        android.graphics.drawable.Drawable drawable = typedArray.getDrawable(i);
        return drawable == null ? typedArray.getDrawable(i2) : drawable;
    }

    public static int getInt(@androidx.annotation.NonNull android.content.res.TypedArray typedArray, @androidx.annotation.StyleableRes int i, @androidx.annotation.StyleableRes int i2, int i3) {
        return typedArray.getInt(i, typedArray.getInt(i2, i3));
    }

    public static boolean getNamedBoolean(@androidx.annotation.NonNull android.content.res.TypedArray typedArray, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser xmlPullParser, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.StyleableRes int i, boolean z) {
        return !hasAttribute(xmlPullParser, str) ? z : typedArray.getBoolean(i, z);
    }

    @androidx.annotation.ColorInt
    public static int getNamedColor(@androidx.annotation.NonNull android.content.res.TypedArray typedArray, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser xmlPullParser, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.StyleableRes int i, @androidx.annotation.ColorInt int i2) {
        return !hasAttribute(xmlPullParser, str) ? i2 : typedArray.getColor(i, i2);
    }

    @androidx.annotation.Nullable
    public static android.content.res.ColorStateList getNamedColorStateList(@androidx.annotation.NonNull android.content.res.TypedArray typedArray, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser xmlPullParser, @androidx.annotation.Nullable android.content.res.Resources.Theme theme, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.StyleableRes int i) {
        if (!hasAttribute(xmlPullParser, str)) {
            return null;
        }
        android.util.TypedValue typedValue = new android.util.TypedValue();
        typedArray.getValue(i, typedValue);
        int i2 = typedValue.type;
        if (i2 != 2) {
            return (i2 < 28 || i2 > 31) ? androidx.core.content.res.ColorStateListInflaterCompat.inflate(typedArray.getResources(), typedArray.getResourceId(i, 0), theme) : getNamedColorStateListFromInt(typedValue);
        }
        throw new java.lang.UnsupportedOperationException("Failed to resolve attribute at index " + i + ": " + typedValue);
    }

    @androidx.annotation.NonNull
    private static android.content.res.ColorStateList getNamedColorStateListFromInt(@androidx.annotation.NonNull android.util.TypedValue typedValue) {
        return android.content.res.ColorStateList.valueOf(typedValue.data);
    }

    public static androidx.core.content.res.ComplexColorCompat getNamedComplexColor(@androidx.annotation.NonNull android.content.res.TypedArray typedArray, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser xmlPullParser, @androidx.annotation.Nullable android.content.res.Resources.Theme theme, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.StyleableRes int i, @androidx.annotation.ColorInt int i2) {
        if (hasAttribute(xmlPullParser, str)) {
            android.util.TypedValue typedValue = new android.util.TypedValue();
            typedArray.getValue(i, typedValue);
            int i3 = typedValue.type;
            if (i3 >= 28 && i3 <= 31) {
                return androidx.core.content.res.ComplexColorCompat.from(typedValue.data);
            }
            androidx.core.content.res.ComplexColorCompat inflate = androidx.core.content.res.ComplexColorCompat.inflate(typedArray.getResources(), typedArray.getResourceId(i, 0), theme);
            if (inflate != null) {
                return inflate;
            }
        }
        return androidx.core.content.res.ComplexColorCompat.from(i2);
    }

    public static float getNamedFloat(@androidx.annotation.NonNull android.content.res.TypedArray typedArray, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser xmlPullParser, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.StyleableRes int i, float f) {
        return !hasAttribute(xmlPullParser, str) ? f : typedArray.getFloat(i, f);
    }

    public static int getNamedInt(@androidx.annotation.NonNull android.content.res.TypedArray typedArray, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser xmlPullParser, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.StyleableRes int i, int i2) {
        return !hasAttribute(xmlPullParser, str) ? i2 : typedArray.getInt(i, i2);
    }

    @androidx.annotation.AnyRes
    public static int getNamedResourceId(@androidx.annotation.NonNull android.content.res.TypedArray typedArray, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser xmlPullParser, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.StyleableRes int i, @androidx.annotation.AnyRes int i2) {
        return !hasAttribute(xmlPullParser, str) ? i2 : typedArray.getResourceId(i, i2);
    }

    @androidx.annotation.Nullable
    public static java.lang.String getNamedString(@androidx.annotation.NonNull android.content.res.TypedArray typedArray, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser xmlPullParser, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.StyleableRes int i) {
        if (hasAttribute(xmlPullParser, str)) {
            return typedArray.getString(i);
        }
        return null;
    }

    @androidx.annotation.AnyRes
    public static int getResourceId(@androidx.annotation.NonNull android.content.res.TypedArray typedArray, @androidx.annotation.StyleableRes int i, @androidx.annotation.StyleableRes int i2, @androidx.annotation.AnyRes int i3) {
        return typedArray.getResourceId(i, typedArray.getResourceId(i2, i3));
    }

    @androidx.annotation.Nullable
    public static java.lang.String getString(@androidx.annotation.NonNull android.content.res.TypedArray typedArray, @androidx.annotation.StyleableRes int i, @androidx.annotation.StyleableRes int i2) {
        java.lang.String string = typedArray.getString(i);
        return string == null ? typedArray.getString(i2) : string;
    }

    @androidx.annotation.Nullable
    public static java.lang.CharSequence getText(@androidx.annotation.NonNull android.content.res.TypedArray typedArray, @androidx.annotation.StyleableRes int i, @androidx.annotation.StyleableRes int i2) {
        java.lang.CharSequence text = typedArray.getText(i);
        return text == null ? typedArray.getText(i2) : text;
    }

    @androidx.annotation.Nullable
    public static java.lang.CharSequence[] getTextArray(@androidx.annotation.NonNull android.content.res.TypedArray typedArray, @androidx.annotation.StyleableRes int i, @androidx.annotation.StyleableRes int i2) {
        java.lang.CharSequence[] textArray = typedArray.getTextArray(i);
        return textArray == null ? typedArray.getTextArray(i2) : textArray;
    }

    public static boolean hasAttribute(@androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser xmlPullParser, @androidx.annotation.NonNull java.lang.String str) {
        return xmlPullParser.getAttributeValue(NAMESPACE, str) != null;
    }

    @androidx.annotation.NonNull
    public static android.content.res.TypedArray obtainAttributes(@androidx.annotation.NonNull android.content.res.Resources resources, @androidx.annotation.Nullable android.content.res.Resources.Theme theme, @androidx.annotation.NonNull android.util.AttributeSet attributeSet, @androidx.annotation.NonNull int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    @androidx.annotation.Nullable
    public static android.util.TypedValue peekNamedValue(@androidx.annotation.NonNull android.content.res.TypedArray typedArray, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser xmlPullParser, @androidx.annotation.NonNull java.lang.String str, int i) {
        if (hasAttribute(xmlPullParser, str)) {
            return typedArray.peekValue(i);
        }
        return null;
    }
}
