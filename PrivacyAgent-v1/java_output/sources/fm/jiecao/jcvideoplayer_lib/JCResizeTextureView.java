package fm.jiecao.jcvideoplayer_lib;

@androidx.annotation.RequiresApi(api = 14)
/* loaded from: classes9.dex */
public class JCResizeTextureView extends android.view.TextureView {
    protected static final boolean DEBUG = false;
    protected static final java.lang.String TAG = "JCResizeTextureView";
    protected boolean hasUpdated;
    protected android.graphics.Point mVideoSize;

    public JCResizeTextureView(android.content.Context context) {
        super(context);
        a();
    }

    public JCResizeTextureView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public final void a() {
        this.mVideoSize = new android.graphics.Point(0, 0);
    }

    @Override // android.view.TextureView
    public android.graphics.Bitmap getBitmap() {
        if (this.hasUpdated) {
            return super.getBitmap();
        }
        return null;
    }

    @Override // android.view.TextureView
    public android.graphics.Bitmap getBitmap(int i, int i2) {
        if (this.hasUpdated) {
            return super.getBitmap(i, i2);
        }
        return null;
    }

    @Override // android.view.TextureView
    public android.graphics.Bitmap getBitmap(android.graphics.Bitmap bitmap) {
        if (this.hasUpdated) {
            return super.getBitmap(bitmap);
        }
        return null;
    }

    @Override // android.view.View
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
        int measuredHeight = ((android.view.View) getParent()).getMeasuredHeight();
        int measuredWidth = ((android.view.View) getParent()).getMeasuredWidth();
        if (measuredWidth != 0 && measuredHeight != 0 && i4 != 0 && i5 != 0 && fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.VIDEO_IMAGE_DISPLAY_TYPE == 1) {
            if (rotation == 90 || rotation == 270) {
                measuredWidth = measuredHeight;
                measuredHeight = measuredWidth;
            }
            i5 = (i4 * measuredHeight) / measuredWidth;
        }
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
                    defaultSize = (size2 * i4) / i5;
                    defaultSize2 = size2;
                }
            } else if (mode2 == 1073741824) {
                i3 = (size2 * i4) / i5;
                if (mode == Integer.MIN_VALUE && i3 > size) {
                    defaultSize2 = (size * i5) / i4;
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
                    defaultSize2 = (size * i5) / i4;
                    defaultSize = size;
                }
                defaultSize = i3;
                defaultSize2 = size2;
            }
        }
        if (measuredWidth != 0 && measuredHeight != 0 && i4 != 0 && i5 != 0) {
            int i9 = fm.jiecao.jcvideoplayer_lib.JCVideoPlayer.VIDEO_IMAGE_DISPLAY_TYPE;
            if (i9 != 3) {
                if (i9 == 2) {
                    if (rotation == 90 || rotation == 270) {
                        int i10 = measuredWidth;
                        measuredWidth = measuredHeight;
                        measuredHeight = i10;
                    }
                    double d = i5 / i4;
                    double d2 = measuredHeight;
                    double d3 = measuredWidth;
                    double d4 = d2 / d3;
                    if (d > d4) {
                        i5 = (int) ((d3 / defaultSize) * defaultSize2);
                        i4 = measuredWidth;
                    } else if (d < d4) {
                        i4 = (int) ((d2 / defaultSize2) * defaultSize);
                        i5 = measuredHeight;
                    }
                }
            }
            setMeasuredDimension(i4 + 6, i5);
        }
        i4 = defaultSize;
        i5 = defaultSize2;
        setMeasuredDimension(i4 + 6, i5);
    }

    public void setHasUpdated() {
        this.hasUpdated = true;
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
