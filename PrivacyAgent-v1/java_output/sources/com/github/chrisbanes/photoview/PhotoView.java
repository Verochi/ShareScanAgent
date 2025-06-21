package com.github.chrisbanes.photoview;

/* loaded from: classes22.dex */
public class PhotoView extends androidx.appcompat.widget.AppCompatImageView {
    public com.github.chrisbanes.photoview.PhotoViewAttacher n;
    public android.widget.ImageView.ScaleType t;

    public PhotoView(android.content.Context context) {
        this(context, null);
    }

    public PhotoView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public com.github.chrisbanes.photoview.PhotoViewAttacher getAttacher() {
        return this.n;
    }

    public void getDisplayMatrix(android.graphics.Matrix matrix) {
        this.n.getDisplayMatrix(matrix);
    }

    public android.graphics.RectF getDisplayRect() {
        return this.n.getDisplayRect();
    }

    @Override // android.widget.ImageView
    public android.graphics.Matrix getImageMatrix() {
        return this.n.getImageMatrix();
    }

    public float getMaximumScale() {
        return this.n.getMaximumScale();
    }

    public float getMediumScale() {
        return this.n.getMediumScale();
    }

    public float getMinimumScale() {
        return this.n.getMinimumScale();
    }

    public float getScale() {
        return this.n.getScale();
    }

    @Override // android.widget.ImageView
    public android.widget.ImageView.ScaleType getScaleType() {
        return this.n.getScaleType();
    }

    public void getSuppMatrix(android.graphics.Matrix matrix) {
        this.n.getSuppMatrix(matrix);
    }

    public final void init() {
        this.n = new com.github.chrisbanes.photoview.PhotoViewAttacher(this);
        super.setScaleType(android.widget.ImageView.ScaleType.MATRIX);
        android.widget.ImageView.ScaleType scaleType = this.t;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.t = null;
        }
    }

    public boolean isZoomable() {
        return this.n.isZoomable();
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.n.setAllowParentInterceptOnEdge(z);
    }

    public boolean setDisplayMatrix(android.graphics.Matrix matrix) {
        return this.n.setDisplayMatrix(matrix);
    }

    @Override // android.widget.ImageView
    public boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        if (frame) {
            this.n.update();
        }
        return frame;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(android.graphics.drawable.Drawable drawable) {
        super.setImageDrawable(drawable);
        com.github.chrisbanes.photoview.PhotoViewAttacher photoViewAttacher = this.n;
        if (photoViewAttacher != null) {
            photoViewAttacher.update();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        com.github.chrisbanes.photoview.PhotoViewAttacher photoViewAttacher = this.n;
        if (photoViewAttacher != null) {
            photoViewAttacher.update();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(android.net.Uri uri) {
        super.setImageURI(uri);
        com.github.chrisbanes.photoview.PhotoViewAttacher photoViewAttacher = this.n;
        if (photoViewAttacher != null) {
            photoViewAttacher.update();
        }
    }

    public void setMaximumScale(float f) {
        this.n.setMaximumScale(f);
    }

    public void setMediumScale(float f) {
        this.n.setMediumScale(f);
    }

    public void setMinimumScale(float f) {
        this.n.setMinimumScale(f);
    }

    @Override // android.view.View
    public void setOnClickListener(android.view.View.OnClickListener onClickListener) {
        this.n.setOnClickListener(onClickListener);
    }

    public void setOnDoubleTapListener(android.view.GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.n.setOnDoubleTapListener(onDoubleTapListener);
    }

    @Override // android.view.View
    public void setOnLongClickListener(android.view.View.OnLongClickListener onLongClickListener) {
        this.n.setOnLongClickListener(onLongClickListener);
    }

    public void setOnMatrixChangeListener(com.github.chrisbanes.photoview.OnMatrixChangedListener onMatrixChangedListener) {
        this.n.setOnMatrixChangeListener(onMatrixChangedListener);
    }

    public void setOnOutsidePhotoTapListener(com.github.chrisbanes.photoview.OnOutsidePhotoTapListener onOutsidePhotoTapListener) {
        this.n.setOnOutsidePhotoTapListener(onOutsidePhotoTapListener);
    }

    public void setOnPhotoTapListener(com.github.chrisbanes.photoview.OnPhotoTapListener onPhotoTapListener) {
        this.n.setOnPhotoTapListener(onPhotoTapListener);
    }

    public void setOnScaleChangeListener(com.github.chrisbanes.photoview.OnScaleChangedListener onScaleChangedListener) {
        this.n.setOnScaleChangeListener(onScaleChangedListener);
    }

    public void setOnSingleFlingListener(com.github.chrisbanes.photoview.OnSingleFlingListener onSingleFlingListener) {
        this.n.setOnSingleFlingListener(onSingleFlingListener);
    }

    public void setOnViewDragListener(com.github.chrisbanes.photoview.OnViewDragListener onViewDragListener) {
        this.n.setOnViewDragListener(onViewDragListener);
    }

    public void setOnViewTapListener(com.github.chrisbanes.photoview.OnViewTapListener onViewTapListener) {
        this.n.setOnViewTapListener(onViewTapListener);
    }

    public void setRotationBy(float f) {
        this.n.setRotationBy(f);
    }

    public void setRotationTo(float f) {
        this.n.setRotationTo(f);
    }

    public void setScale(float f) {
        this.n.setScale(f);
    }

    public void setScale(float f, float f2, float f3, boolean z) {
        this.n.setScale(f, f2, f3, z);
    }

    public void setScale(float f, boolean z) {
        this.n.setScale(f, z);
    }

    public void setScaleLevels(float f, float f2, float f3) {
        this.n.setScaleLevels(f, f2, f3);
    }

    @Override // android.widget.ImageView
    public void setScaleType(android.widget.ImageView.ScaleType scaleType) {
        com.github.chrisbanes.photoview.PhotoViewAttacher photoViewAttacher = this.n;
        if (photoViewAttacher == null) {
            this.t = scaleType;
        } else {
            photoViewAttacher.setScaleType(scaleType);
        }
    }

    public boolean setSuppMatrix(android.graphics.Matrix matrix) {
        return this.n.setDisplayMatrix(matrix);
    }

    public void setZoomTransitionDuration(int i) {
        this.n.setZoomTransitionDuration(i);
    }

    public void setZoomable(boolean z) {
        this.n.setZoomable(z);
    }
}
