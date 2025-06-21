package fm.jiecao.jcvideoplayer_lib;

/* loaded from: classes9.dex */
public class JCResizeImageView extends androidx.appcompat.widget.AppCompatImageView {
    protected static final boolean DEBUG = false;
    protected static final java.lang.String TAG = "JCResizeImageView";
    protected android.graphics.Point mVideoSize;

    public JCResizeImageView(android.content.Context context) {
        super(context);
        init();
    }

    public JCResizeImageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void init() {
        this.mVideoSize = new android.graphics.Point(0, 0);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int rotation = (int) getRotation();
        if (rotation == 90 || rotation == 270) {
            i2 = i;
            i = i2;
        }
        android.graphics.Point point = this.mVideoSize;
        int i4 = point.x;
        int i5 = point.y;
        int defaultSize = android.view.View.getDefaultSize(i4, i);
        int defaultSize2 = android.view.View.getDefaultSize(i5, i2);
        if (i4 > 0 && i5 > 0) {
            int mode = android.view.View.MeasureSpec.getMode(i);
            int size = android.view.View.MeasureSpec.getSize(i);
            int mode2 = android.view.View.MeasureSpec.getMode(i2);
            int size2 = android.view.View.MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                int i6 = i4 * size2;
                int i7 = size * i5;
                if (i6 < i7) {
                    defaultSize = i6 / i5;
                } else if (i6 > i7) {
                    defaultSize2 = i7 / i4;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
                defaultSize2 = size2;
            } else if (mode == 1073741824) {
                int i8 = (size * i5) / i4;
                if (mode2 != Integer.MIN_VALUE || i8 <= size2) {
                    defaultSize2 = i8;
                    defaultSize = size;
                } else {
                    defaultSize = (i4 * size2) / i5;
                    defaultSize2 = size2;
                }
            } else if (mode2 == 1073741824) {
                i3 = (size2 * i4) / i5;
                if (mode == Integer.MIN_VALUE && i3 > size) {
                    defaultSize2 = (i5 * size) / i4;
                    defaultSize = size;
                }
                defaultSize = i3;
                defaultSize2 = size2;
            } else {
                if (mode2 != Integer.MIN_VALUE || i5 <= size2) {
                    size2 = i5;
                    i3 = i4;
                } else {
                    i3 = (size2 * i4) / i5;
                }
                if (mode == Integer.MIN_VALUE && i3 > size) {
                    defaultSize2 = (i5 * size) / i4;
                    defaultSize = size;
                }
                defaultSize = i3;
                defaultSize2 = size2;
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    @Override // android.view.View
    public void setRotation(float f) {
        if (f != getRotation()) {
            super.setRotation(f);
            requestLayout();
        }
    }

    public void setVideoSize(android.graphics.Point point) {
        if (point == null || this.mVideoSize.equals(point)) {
            return;
        }
        this.mVideoSize = point;
        requestLayout();
    }
}
