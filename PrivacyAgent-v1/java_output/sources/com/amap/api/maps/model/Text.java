package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public final class Text {
    public static final int ALIGN_BOTTOM = 16;
    public static final int ALIGN_CENTER_HORIZONTAL = 4;
    public static final int ALIGN_CENTER_VERTICAL = 32;
    public static final int ALIGN_LEFT = 1;
    public static final int ALIGN_RIGHT = 2;
    public static final int ALIGN_TOP = 8;
    private com.amap.api.maps.model.Marker marker;
    private com.amap.api.maps.model.TextOptions textOptions;

    public Text(com.amap.api.maps.model.Marker marker, com.amap.api.maps.model.TextOptions textOptions) {
        this.marker = marker;
        this.textOptions = textOptions;
    }

    private void a() {
        this.marker.setIcon(com.amap.api.mapcore.util.cc.b(this.textOptions));
    }

    public final void destroy() {
        try {
            this.marker.destroy();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean equals(java.lang.Object obj) {
        if (!(obj instanceof com.amap.api.maps.model.Text)) {
            return false;
        }
        try {
            return this.marker.equals(((com.amap.api.maps.model.Text) obj).marker);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final int getAlignX() {
        try {
            return this.textOptions.getAlignX();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final int getAlignY() {
        try {
            return this.textOptions.getAlignY();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final int getBackgroundColor() {
        try {
            return this.textOptions.getBackgroundColor();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final int getFontColor() {
        try {
            return this.textOptions.getFontColor();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final int getFontSize() {
        try {
            return this.textOptions.getFontSize();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final java.lang.String getId() {
        try {
            return this.marker.getId();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final java.lang.Object getObject() {
        return this.marker.getObject();
    }

    public final com.amap.api.maps.model.LatLng getPosition() {
        try {
            return this.marker.getPosition();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final float getRotate() {
        return this.marker.getRotateAngle();
    }

    public final java.lang.String getText() {
        try {
            return this.textOptions.getText();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final android.graphics.Typeface getTypeface() {
        try {
            return this.textOptions.getTypeface();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final float getZIndex() {
        return this.marker.getZIndex();
    }

    public final int hashCode() {
        return this.marker.hashCode();
    }

    public final boolean isVisible() {
        try {
            return this.marker.isVisible();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final void remove() {
        try {
            this.marker.remove();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setAlign(int i, int i2) {
        try {
            this.textOptions.align(i, i2);
            this.marker.setAnchor(com.amap.api.mapcore.util.cc.a(this.textOptions.getAlignX(), true), com.amap.api.mapcore.util.cc.a(this.textOptions.getAlignY(), false));
            a();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setBackgroundColor(int i) {
        try {
            this.textOptions.backgroundColor(i);
            a();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setFontColor(int i) {
        try {
            this.textOptions.fontColor(i);
            a();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setFontSize(int i) {
        try {
            this.textOptions.fontSize(i);
            a();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setObject(java.lang.Object obj) {
        this.marker.setObject(obj);
    }

    public final void setPosition(com.amap.api.maps.model.LatLng latLng) {
        try {
            this.marker.setPosition(latLng);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setRotate(float f) {
        try {
            this.marker.setRotateAngle(f);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setText(java.lang.String str) {
        try {
            this.textOptions.text(str);
            a();
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setTypeface(android.graphics.Typeface typeface) {
        try {
            this.textOptions.typeface(typeface);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setVisible(boolean z) {
        try {
            this.marker.setVisible(z);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setZIndex(float f) {
        this.marker.setZIndex(f);
    }
}
