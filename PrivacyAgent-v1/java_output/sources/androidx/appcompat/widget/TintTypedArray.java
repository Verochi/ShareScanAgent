package androidx.appcompat.widget;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class TintTypedArray {
    private final android.content.Context mContext;
    private android.util.TypedValue mTypedValue;
    private final android.content.res.TypedArray mWrapped;

    private TintTypedArray(android.content.Context context, android.content.res.TypedArray typedArray) {
        this.mContext = context;
        this.mWrapped = typedArray;
    }

    public static androidx.appcompat.widget.TintTypedArray obtainStyledAttributes(android.content.Context context, int i, int[] iArr) {
        return new androidx.appcompat.widget.TintTypedArray(context, context.obtainStyledAttributes(i, iArr));
    }

    public static androidx.appcompat.widget.TintTypedArray obtainStyledAttributes(android.content.Context context, android.util.AttributeSet attributeSet, int[] iArr) {
        return new androidx.appcompat.widget.TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static androidx.appcompat.widget.TintTypedArray obtainStyledAttributes(android.content.Context context, android.util.AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new androidx.appcompat.widget.TintTypedArray(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public boolean getBoolean(int i, boolean z) {
        return this.mWrapped.getBoolean(i, z);
    }

    @androidx.annotation.RequiresApi(21)
    public int getChangingConfigurations() {
        return this.mWrapped.getChangingConfigurations();
    }

    public int getColor(int i, int i2) {
        return this.mWrapped.getColor(i, i2);
    }

    public android.content.res.ColorStateList getColorStateList(int i) {
        int resourceId;
        android.content.res.ColorStateList colorStateList;
        return (!this.mWrapped.hasValue(i) || (resourceId = this.mWrapped.getResourceId(i, 0)) == 0 || (colorStateList = androidx.appcompat.content.res.AppCompatResources.getColorStateList(this.mContext, resourceId)) == null) ? this.mWrapped.getColorStateList(i) : colorStateList;
    }

    public float getDimension(int i, float f) {
        return this.mWrapped.getDimension(i, f);
    }

    public int getDimensionPixelOffset(int i, int i2) {
        return this.mWrapped.getDimensionPixelOffset(i, i2);
    }

    public int getDimensionPixelSize(int i, int i2) {
        return this.mWrapped.getDimensionPixelSize(i, i2);
    }

    public android.graphics.drawable.Drawable getDrawable(int i) {
        int resourceId;
        return (!this.mWrapped.hasValue(i) || (resourceId = this.mWrapped.getResourceId(i, 0)) == 0) ? this.mWrapped.getDrawable(i) : androidx.appcompat.content.res.AppCompatResources.getDrawable(this.mContext, resourceId);
    }

    public android.graphics.drawable.Drawable getDrawableIfKnown(int i) {
        int resourceId;
        if (!this.mWrapped.hasValue(i) || (resourceId = this.mWrapped.getResourceId(i, 0)) == 0) {
            return null;
        }
        return androidx.appcompat.widget.AppCompatDrawableManager.get().getDrawable(this.mContext, resourceId, true);
    }

    public float getFloat(int i, float f) {
        return this.mWrapped.getFloat(i, f);
    }

    @androidx.annotation.Nullable
    public android.graphics.Typeface getFont(@androidx.annotation.StyleableRes int i, int i2, @androidx.annotation.Nullable androidx.core.content.res.ResourcesCompat.FontCallback fontCallback) {
        int resourceId = this.mWrapped.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.mTypedValue == null) {
            this.mTypedValue = new android.util.TypedValue();
        }
        return androidx.core.content.res.ResourcesCompat.getFont(this.mContext, resourceId, this.mTypedValue, i2, fontCallback);
    }

    public float getFraction(int i, int i2, int i3, float f) {
        return this.mWrapped.getFraction(i, i2, i3, f);
    }

    public int getIndex(int i) {
        return this.mWrapped.getIndex(i);
    }

    public int getIndexCount() {
        return this.mWrapped.getIndexCount();
    }

    public int getInt(int i, int i2) {
        return this.mWrapped.getInt(i, i2);
    }

    public int getInteger(int i, int i2) {
        return this.mWrapped.getInteger(i, i2);
    }

    public int getLayoutDimension(int i, int i2) {
        return this.mWrapped.getLayoutDimension(i, i2);
    }

    public int getLayoutDimension(int i, java.lang.String str) {
        return this.mWrapped.getLayoutDimension(i, str);
    }

    public java.lang.String getNonResourceString(int i) {
        return this.mWrapped.getNonResourceString(i);
    }

    public java.lang.String getPositionDescription() {
        return this.mWrapped.getPositionDescription();
    }

    public int getResourceId(int i, int i2) {
        return this.mWrapped.getResourceId(i, i2);
    }

    public android.content.res.Resources getResources() {
        return this.mWrapped.getResources();
    }

    public java.lang.String getString(int i) {
        return this.mWrapped.getString(i);
    }

    public java.lang.CharSequence getText(int i) {
        return this.mWrapped.getText(i);
    }

    public java.lang.CharSequence[] getTextArray(int i) {
        return this.mWrapped.getTextArray(i);
    }

    public int getType(int i) {
        return this.mWrapped.getType(i);
    }

    public boolean getValue(int i, android.util.TypedValue typedValue) {
        return this.mWrapped.getValue(i, typedValue);
    }

    public android.content.res.TypedArray getWrappedTypeArray() {
        return this.mWrapped;
    }

    public boolean hasValue(int i) {
        return this.mWrapped.hasValue(i);
    }

    public int length() {
        return this.mWrapped.length();
    }

    public android.util.TypedValue peekValue(int i) {
        return this.mWrapped.peekValue(i);
    }

    public void recycle() {
        this.mWrapped.recycle();
    }
}
