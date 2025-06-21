package com.autonavi.base.amap.mapcore;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public class Rectangle {

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private int beyond180Mode;
    public float bottom;
    public com.autonavi.base.amap.mapcore.FPoint[] clipMapRect;
    public com.autonavi.amap.mapcore.IPoint[] clipRect;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private int[] jniClipRect;
    public float left;
    public android.graphics.Rect rect;
    public float right;
    public float top;

    public Rectangle() {
        this.rect = new android.graphics.Rect();
        this.beyond180Mode = 0;
        this.clipRect = null;
        this.clipMapRect = null;
        this.jniClipRect = new int[8];
    }

    public Rectangle(float f, float f2, float f3, float f4) {
        this.rect = new android.graphics.Rect();
        this.beyond180Mode = 0;
        this.clipRect = null;
        this.clipMapRect = null;
        this.jniClipRect = new int[8];
        if (f >= f2 || f4 <= f3) {
            return;
        }
        this.left = f;
        this.right = f2;
        this.top = f4;
        this.bottom = f3;
    }

    public Rectangle(android.graphics.Rect rect, int i, int i2) {
        new android.graphics.Rect();
        this.beyond180Mode = 0;
        this.clipRect = null;
        this.clipMapRect = null;
        this.jniClipRect = new int[8];
        this.rect = rect;
        if (rect != null) {
            updateRect(rect, i, i2);
            updateClipRect();
            updateClipMapRect(rect.centerX(), rect.centerY());
        }
    }

    private void updateClipMapRect(int i, int i2) {
        int i3 = 0;
        if (this.clipMapRect == null) {
            com.autonavi.base.amap.mapcore.FPoint[] fPointArr = new com.autonavi.base.amap.mapcore.FPoint[4];
            this.clipMapRect = fPointArr;
            fPointArr[0] = com.autonavi.base.amap.mapcore.FPoint.obtain(0.0f, 0.0f);
            this.clipMapRect[1] = com.autonavi.base.amap.mapcore.FPoint.obtain(0.0f, 0.0f);
            this.clipMapRect[2] = com.autonavi.base.amap.mapcore.FPoint.obtain(0.0f, 0.0f);
            this.clipMapRect[3] = com.autonavi.base.amap.mapcore.FPoint.obtain(0.0f, 0.0f);
        }
        android.graphics.Rect rect = this.rect;
        if (rect != null) {
            com.autonavi.base.amap.mapcore.FPoint[] fPointArr2 = this.clipMapRect;
            com.autonavi.base.amap.mapcore.FPoint fPoint = fPointArr2[0];
            int i4 = rect.left;
            ((android.graphics.PointF) fPoint).x = i4 - i;
            int i5 = rect.top;
            ((android.graphics.PointF) fPoint).y = i5 - i2;
            com.autonavi.base.amap.mapcore.FPoint fPoint2 = fPointArr2[1];
            int i6 = rect.right;
            ((android.graphics.PointF) fPoint2).x = i6 - i;
            ((android.graphics.PointF) fPoint2).y = i5 - i2;
            com.autonavi.base.amap.mapcore.FPoint fPoint3 = fPointArr2[2];
            ((android.graphics.PointF) fPoint3).x = i6 - i;
            int i7 = rect.bottom;
            ((android.graphics.PointF) fPoint3).y = i7 - i2;
            com.autonavi.base.amap.mapcore.FPoint fPoint4 = fPointArr2[3];
            ((android.graphics.PointF) fPoint4).x = i4 - i;
            ((android.graphics.PointF) fPoint4).y = i7 - i2;
        }
        if (this.jniClipRect == null) {
            this.jniClipRect = new int[this.clipMapRect.length * 2];
        }
        while (true) {
            com.autonavi.base.amap.mapcore.FPoint[] fPointArr3 = this.clipMapRect;
            if (i3 >= fPointArr3.length) {
                return;
            }
            int[] iArr = this.jniClipRect;
            int i8 = i3 * 2;
            com.autonavi.base.amap.mapcore.FPoint fPoint5 = fPointArr3[i3];
            iArr[i8] = (int) ((android.graphics.PointF) fPoint5).x;
            iArr[i8 + 1] = (int) ((android.graphics.PointF) fPoint5).y;
            i3++;
        }
    }

    private void updateClipRect() {
        if (this.clipRect == null) {
            com.autonavi.amap.mapcore.IPoint[] iPointArr = new com.autonavi.amap.mapcore.IPoint[4];
            this.clipRect = iPointArr;
            iPointArr[0] = com.autonavi.amap.mapcore.IPoint.obtain(0, 0);
            this.clipRect[1] = com.autonavi.amap.mapcore.IPoint.obtain(0, 0);
            this.clipRect[2] = com.autonavi.amap.mapcore.IPoint.obtain(0, 0);
            this.clipRect[3] = com.autonavi.amap.mapcore.IPoint.obtain(0, 0);
        }
        android.graphics.Rect rect = this.rect;
        if (rect != null) {
            com.autonavi.amap.mapcore.IPoint[] iPointArr2 = this.clipRect;
            com.autonavi.amap.mapcore.IPoint iPoint = iPointArr2[0];
            int i = rect.left;
            ((android.graphics.Point) iPoint).x = i;
            int i2 = rect.top;
            ((android.graphics.Point) iPoint).y = i2;
            com.autonavi.amap.mapcore.IPoint iPoint2 = iPointArr2[1];
            int i3 = rect.right;
            ((android.graphics.Point) iPoint2).x = i3;
            ((android.graphics.Point) iPoint2).y = i2;
            com.autonavi.amap.mapcore.IPoint iPoint3 = iPointArr2[2];
            ((android.graphics.Point) iPoint3).x = i3;
            int i4 = rect.bottom;
            ((android.graphics.Point) iPoint3).y = i4;
            com.autonavi.amap.mapcore.IPoint iPoint4 = iPointArr2[3];
            ((android.graphics.Point) iPoint4).x = i;
            ((android.graphics.Point) iPoint4).y = i4;
        }
    }

    public boolean contains(int i, int i2) {
        android.graphics.Rect rect = this.rect;
        if (rect == null) {
            return false;
        }
        if (rect.contains(i, i2)) {
            return true;
        }
        if (this.beyond180Mode != 0) {
            return this.rect.contains(i - 268435456, i2) || this.rect.contains(i + 268435456, i2);
        }
        return false;
    }

    public boolean contains(android.graphics.Rect rect) {
        if (rect == null) {
            return false;
        }
        return this.rect.contains(rect);
    }

    public boolean contains(com.autonavi.amap.mapcore.IPoint iPoint) {
        if (iPoint == null) {
            return false;
        }
        return contains(((android.graphics.Point) iPoint).x, ((android.graphics.Point) iPoint).y);
    }

    public int getBeyond180Mode() {
        return this.beyond180Mode;
    }

    public com.autonavi.base.amap.mapcore.FPoint[] getClipMapRect() {
        return this.clipMapRect;
    }

    public com.autonavi.amap.mapcore.IPoint[] getClipRect() {
        return this.clipRect;
    }

    public android.graphics.Rect getRect() {
        return this.rect;
    }

    public boolean isOverlap(int i, int i2, int i3, int i4) {
        android.graphics.Rect rect = this.rect;
        if (rect != null && rect.left + rect.width() > i) {
            int i5 = i + i3;
            android.graphics.Rect rect2 = this.rect;
            if (i5 > rect2.left && rect2.top + rect2.height() > i2 && i2 + i4 > this.rect.top) {
                return true;
            }
        }
        return false;
    }

    public boolean isOverlap(android.graphics.Rect rect) {
        android.graphics.Rect rect2 = this.rect;
        if (rect2 != null && rect != null) {
            int width = rect2.left + rect2.width();
            int i = rect.left;
            if (width > i) {
                int width2 = i + rect.width();
                android.graphics.Rect rect3 = this.rect;
                if (width2 > rect3.left) {
                    int height = rect3.top + rect3.height();
                    int i2 = rect.top;
                    if (height > i2 && i2 + rect.height() > this.rect.top) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void updateRect(android.graphics.Rect rect, int i, int i2) {
        if (rect != null) {
            this.rect = rect;
            rect.inset((-rect.width()) / 8, (-rect.height()) / 8);
            float f = r4.left / 100000.0f;
            int i3 = this.rect.right;
            if (f * (i3 / 100000.0f) < 0.0f) {
                this.beyond180Mode = -1;
            } else if (i3 > 268435456) {
                this.beyond180Mode = 1;
            } else {
                this.beyond180Mode = 0;
            }
            updateClipRect();
            updateClipMapRect(i, i2);
        }
    }
}
