package com.google.android.material.animation;

/* loaded from: classes22.dex */
public class ImageMatrixProperty extends android.util.Property<android.widget.ImageView, android.graphics.Matrix> {
    private final android.graphics.Matrix matrix;

    public ImageMatrixProperty() {
        super(android.graphics.Matrix.class, "imageMatrixProperty");
        this.matrix = new android.graphics.Matrix();
    }

    @Override // android.util.Property
    @androidx.annotation.NonNull
    public android.graphics.Matrix get(@androidx.annotation.NonNull android.widget.ImageView imageView) {
        this.matrix.set(imageView.getImageMatrix());
        return this.matrix;
    }

    @Override // android.util.Property
    public void set(@androidx.annotation.NonNull android.widget.ImageView imageView, @androidx.annotation.NonNull android.graphics.Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }
}
