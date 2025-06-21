package cn.jzvd;

/* loaded from: classes.dex */
public class JZTextureView extends android.view.TextureView {
    protected static final java.lang.String TAG = "JZTextureView";
    public int currentVideoHeight;
    public int currentVideoWidth;
    public int n;

    public JZTextureView(android.content.Context context) {
        super(context);
        this.n = 0;
        this.currentVideoWidth = 0;
        this.currentVideoHeight = 0;
    }

    public JZTextureView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = 0;
        this.currentVideoWidth = 0;
        this.currentVideoHeight = 0;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("onMeasure  [");
        sb.append(hashCode());
        sb.append("] ");
        int rotation = (int) getRotation();
        int i7 = this.currentVideoWidth;
        int i8 = this.currentVideoHeight;
        int measuredHeight = ((android.view.View) getParent()).getMeasuredHeight();
        int measuredWidth = ((android.view.View) getParent()).getMeasuredWidth();
        if (measuredWidth != 0 && measuredHeight != 0 && i7 != 0 && i8 != 0 && this.n == 1) {
            if (rotation == 90 || rotation == 270) {
                measuredWidth = measuredHeight;
                measuredHeight = measuredWidth;
            }
            i8 = (i7 * measuredHeight) / measuredWidth;
        }
        if (rotation == 90 || rotation == 270) {
            i3 = i;
            i4 = i2;
        } else {
            i4 = i;
            i3 = i2;
        }
        int defaultSize = android.view.View.getDefaultSize(i7, i4);
        int defaultSize2 = android.view.View.getDefaultSize(i8, i3);
        if (i7 > 0 && i8 > 0) {
            int mode = android.view.View.MeasureSpec.getMode(i4);
            int size = android.view.View.MeasureSpec.getSize(i4);
            int mode2 = android.view.View.MeasureSpec.getMode(i3);
            int size2 = android.view.View.MeasureSpec.getSize(i3);
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("widthMeasureSpec  [");
            sb2.append(android.view.View.MeasureSpec.toString(i4));
            sb2.append("]");
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
            sb3.append("heightMeasureSpec [");
            sb3.append(android.view.View.MeasureSpec.toString(i3));
            sb3.append("]");
            if (mode == 1073741824 && mode2 == 1073741824) {
                int i9 = i7 * size2;
                int i10 = size * i8;
                if (i9 < i10) {
                    defaultSize = i9 / i8;
                } else if (i9 > i10) {
                    i6 = i10 / i7;
                    defaultSize = size;
                    defaultSize2 = i6;
                } else {
                    defaultSize = size;
                }
                defaultSize2 = size2;
            } else if (mode == 1073741824) {
                i6 = (size * i8) / i7;
                if (mode2 == Integer.MIN_VALUE && i6 > size2) {
                    defaultSize = (size2 * i7) / i8;
                    defaultSize2 = size2;
                }
                defaultSize = size;
                defaultSize2 = i6;
            } else if (mode2 == 1073741824) {
                i5 = (size2 * i7) / i8;
                if (mode == Integer.MIN_VALUE && i5 > size) {
                    i6 = (size * i8) / i7;
                    defaultSize = size;
                    defaultSize2 = i6;
                }
                defaultSize = i5;
                defaultSize2 = size2;
            } else {
                if (mode2 != Integer.MIN_VALUE || i8 <= size2) {
                    i5 = i7;
                    size2 = i8;
                } else {
                    i5 = (size2 * i7) / i8;
                }
                if (mode == Integer.MIN_VALUE && i5 > size) {
                    i6 = (size * i8) / i7;
                    defaultSize = size;
                    defaultSize2 = i6;
                }
                defaultSize = i5;
                defaultSize2 = size2;
            }
        }
        if (measuredWidth != 0 && measuredHeight != 0 && i7 != 0 && i8 != 0) {
            int i11 = this.n;
            if (i11 != 3) {
                if (i11 == 2) {
                    if (rotation == 90 || rotation == 270) {
                        int i12 = measuredWidth;
                        measuredWidth = measuredHeight;
                        measuredHeight = i12;
                    }
                    double d = i8 / i7;
                    double d2 = measuredHeight;
                    double d3 = measuredWidth;
                    double d4 = d2 / d3;
                    if (d > d4) {
                        i8 = (int) ((d3 / defaultSize) * defaultSize2);
                        i7 = measuredWidth;
                    } else if (d < d4) {
                        i7 = (int) ((d2 / defaultSize2) * defaultSize);
                        i8 = measuredHeight;
                    }
                }
            }
            setMeasuredDimension(i7, i8);
        }
        i7 = defaultSize;
        i8 = defaultSize2;
        setMeasuredDimension(i7, i8);
    }

    @Override // android.view.View
    public void setRotation(float f) {
        if (f != getRotation()) {
            super.setRotation(f);
            requestLayout();
        }
    }

    public void setVideoImageDisplayType(int i) {
        this.n = i;
        requestLayout();
    }

    public void setVideoSize(int i, int i2) {
        if (this.currentVideoWidth == i && this.currentVideoHeight == i2) {
            return;
        }
        this.currentVideoWidth = i;
        this.currentVideoHeight = i2;
        requestLayout();
    }
}
