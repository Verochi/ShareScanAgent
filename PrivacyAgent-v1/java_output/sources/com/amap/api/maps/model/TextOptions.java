package com.amap.api.maps.model;

/* loaded from: classes12.dex */
public final class TextOptions implements android.os.Parcelable, java.lang.Cloneable {
    public static final com.amap.api.maps.model.TextOptionsCreator CREATOR = new com.amap.api.maps.model.TextOptionsCreator();
    java.lang.String a;
    private java.lang.Object object;
    private com.amap.api.maps.model.LatLng position;
    private float rotate;
    private java.lang.String text;
    private android.graphics.Typeface typeface = android.graphics.Typeface.DEFAULT;
    private int alignX = 4;
    private int alignY = 32;
    private int backgroundColor = -1;
    private int fontColor = androidx.core.view.ViewCompat.MEASURED_STATE_MASK;
    private int fontSize = 20;
    private float zIndex = 0.0f;
    private boolean isVisible = true;

    public final com.amap.api.maps.model.TextOptions align(int i, int i2) {
        this.alignX = i;
        this.alignY = i2;
        return this;
    }

    public final com.amap.api.maps.model.TextOptions backgroundColor(int i) {
        this.backgroundColor = i;
        return this;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final com.amap.api.maps.model.TextOptions m25clone() {
        try {
            super.clone();
        } catch (java.lang.CloneNotSupportedException e) {
            e.printStackTrace();
        }
        com.amap.api.maps.model.TextOptions textOptions = new com.amap.api.maps.model.TextOptions();
        textOptions.a = this.a;
        textOptions.position = this.position;
        textOptions.text = this.text;
        textOptions.typeface = this.typeface;
        textOptions.rotate = this.rotate;
        textOptions.alignX = this.alignX;
        textOptions.alignY = this.alignY;
        textOptions.backgroundColor = this.backgroundColor;
        textOptions.fontColor = this.fontColor;
        textOptions.object = this.object;
        textOptions.fontSize = this.fontSize;
        textOptions.zIndex = this.zIndex;
        textOptions.isVisible = this.isVisible;
        return textOptions;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final com.amap.api.maps.model.TextOptions fontColor(int i) {
        this.fontColor = i;
        return this;
    }

    public final com.amap.api.maps.model.TextOptions fontSize(int i) {
        this.fontSize = i;
        return this;
    }

    public final int getAlignX() {
        return this.alignX;
    }

    public final int getAlignY() {
        return this.alignY;
    }

    public final int getBackgroundColor() {
        return this.backgroundColor;
    }

    public final int getFontColor() {
        return this.fontColor;
    }

    public final int getFontSize() {
        return this.fontSize;
    }

    public final java.lang.Object getObject() {
        return this.object;
    }

    public final com.amap.api.maps.model.LatLng getPosition() {
        return this.position;
    }

    public final float getRotate() {
        return this.rotate;
    }

    public final java.lang.String getText() {
        return this.text;
    }

    public final android.graphics.Typeface getTypeface() {
        return this.typeface;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final com.amap.api.maps.model.TextOptions position(com.amap.api.maps.model.LatLng latLng) {
        this.position = latLng;
        return this;
    }

    public final com.amap.api.maps.model.TextOptions rotate(float f) {
        this.rotate = f;
        return this;
    }

    public final com.amap.api.maps.model.TextOptions setObject(java.lang.Object obj) {
        this.object = obj;
        return this;
    }

    public final com.amap.api.maps.model.TextOptions text(java.lang.String str) {
        this.text = str;
        return this;
    }

    public final com.amap.api.maps.model.TextOptions typeface(android.graphics.Typeface typeface) {
        if (typeface != null) {
            this.typeface = typeface;
        }
        return this;
    }

    public final com.amap.api.maps.model.TextOptions visible(boolean z) {
        this.isVisible = z;
        return this;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(android.os.Parcel parcel, int i) {
        parcel.writeString(this.a);
        android.os.Bundle bundle = new android.os.Bundle();
        com.amap.api.maps.model.LatLng latLng = this.position;
        if (latLng != null) {
            bundle.putDouble("lat", latLng.latitude);
            bundle.putDouble("lng", this.position.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeString(this.text);
        parcel.writeInt(this.typeface.getStyle());
        parcel.writeFloat(this.rotate);
        parcel.writeInt(this.alignX);
        parcel.writeInt(this.alignY);
        parcel.writeInt(this.backgroundColor);
        parcel.writeInt(this.fontColor);
        parcel.writeInt(this.fontSize);
        parcel.writeFloat(this.zIndex);
        parcel.writeByte(this.isVisible ? (byte) 1 : (byte) 0);
        if (this.object instanceof android.os.Parcelable) {
            android.os.Bundle bundle2 = new android.os.Bundle();
            bundle2.putParcelable("obj", (android.os.Parcelable) this.object);
            parcel.writeBundle(bundle2);
        }
    }

    public final com.amap.api.maps.model.TextOptions zIndex(float f) {
        this.zIndex = f;
        return this;
    }
}
