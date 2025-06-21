package com.aliyun.svideo.editor.util;

/* loaded from: classes12.dex */
public class MatrixUtil {
    private final float[] _Data = new float[9];
    public float rotation;
    public float scaleX;
    public float scaleY;
    public float translateX;
    public float translateY;

    public void clear() {
        this.translateX = 0.0f;
        this.translateY = 0.0f;
        this.scaleX = 1.0f;
        this.scaleY = 1.0f;
        this.rotation = 0.0f;
    }

    public void composeTSR(android.graphics.Matrix matrix) {
        matrix.setRotate(getRotationDeg());
        matrix.postScale(this.scaleX, this.scaleY);
        matrix.postTranslate(this.translateX, this.translateY);
    }

    public void decomposeTSR(android.graphics.Matrix matrix) {
        matrix.getValues(this._Data);
        float[] fArr = this._Data;
        this.translateX = fArr[2];
        this.translateY = fArr[5];
        float f = fArr[0];
        float f2 = fArr[4];
        float f3 = fArr[1];
        float f4 = fArr[3];
        this.scaleX = (float) java.lang.Math.sqrt((f * f) + (f3 * f3));
        this.scaleY = ((float) java.lang.Math.sqrt((f2 * f2) + (f4 * f4))) * java.lang.Math.signum((f2 * f) - (f4 * f3));
        this.rotation = (float) java.lang.Math.atan2(-f3, f);
    }

    public float getRotation() {
        return this.rotation;
    }

    public float getRotationDeg() {
        return (float) ((this.rotation / 3.141592653589793d) * 180.0d);
    }

    public void setRotationDeg(float f) {
        this.rotation = (float) ((f * 3.141592653589793d) / 180.0d);
    }

    public java.lang.String toString() {
        return "MatrixUtil{translateX=" + this.translateX + ", translateY=" + this.translateY + ", scaleX=" + this.scaleX + ", scaleY=" + this.scaleY + ", rotation=" + this.rotation + '}';
    }
}
