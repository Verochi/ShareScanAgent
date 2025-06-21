package androidx.legacy.widget;

@java.lang.Deprecated
/* loaded from: classes.dex */
public class Space extends android.view.View {
    @java.lang.Deprecated
    public Space(@androidx.annotation.NonNull android.content.Context context) {
        this(context, null);
    }

    @java.lang.Deprecated
    public Space(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @java.lang.Deprecated
    public Space(@androidx.annotation.NonNull android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (getVisibility() == 0) {
            setVisibility(4);
        }
    }

    private static int getDefaultSize2(int i, int i2) {
        int mode = android.view.View.MeasureSpec.getMode(i2);
        int size = android.view.View.MeasureSpec.getSize(i2);
        return mode != Integer.MIN_VALUE ? mode != 1073741824 ? i : size : java.lang.Math.min(i, size);
    }

    @Override // android.view.View
    @android.annotation.SuppressLint({"MissingSuperCall"})
    @java.lang.Deprecated
    public void draw(android.graphics.Canvas canvas) {
    }

    @Override // android.view.View
    @java.lang.Deprecated
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize2(getSuggestedMinimumWidth(), i), getDefaultSize2(getSuggestedMinimumHeight(), i2));
    }
}
