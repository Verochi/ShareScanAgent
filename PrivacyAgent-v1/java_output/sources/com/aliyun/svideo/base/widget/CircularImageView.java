package com.aliyun.svideo.base.widget;

/* loaded from: classes.dex */
public class CircularImageView extends android.view.View {
    private final com.aliyun.svideo.base.widget.CircularImageDrawable _Drawable;

    public CircularImageView(android.content.Context context) {
        this(context, null);
    }

    public CircularImageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircularImageView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        com.aliyun.svideo.base.widget.CircularImageDrawable circularImageDrawable = new com.aliyun.svideo.base.widget.CircularImageDrawable();
        this._Drawable = circularImageDrawable;
        circularImageDrawable.setCallback(this);
        android.content.res.TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.aliyun.svideo.base.R.styleable.QuViewCircularImageView, i, 0);
        android.graphics.drawable.Drawable drawable = obtainStyledAttributes.getDrawable(com.aliyun.svideo.base.R.styleable.QuViewCircularImageView_android_src);
        obtainStyledAttributes.recycle();
        if (drawable != null) {
            setImageDrawable(drawable);
        }
    }

    private android.graphics.Bitmap drawable2Bitmap(android.graphics.drawable.Drawable drawable) {
        android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas = new android.graphics.Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    @Override // android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        canvas.save();
        canvas.translate(getPaddingLeft(), getPaddingTop());
        this._Drawable.draw(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this._Drawable.setBounds(i + getPaddingLeft(), i2 + getPaddingTop(), i3 - getPaddingRight(), i4 - getPaddingBottom());
    }

    public void setImageBitmap(android.graphics.Bitmap bitmap) {
        this._Drawable.setBitmap(bitmap);
    }

    public void setImageDrawable(android.graphics.drawable.Drawable drawable) {
        if (drawable == null) {
            setImageBitmap(null);
        } else {
            setImageBitmap(drawable instanceof android.graphics.drawable.LayerDrawable ? drawable2Bitmap(drawable) : ((android.graphics.drawable.BitmapDrawable) drawable).getBitmap());
        }
    }

    public void setImageResource(int i) {
        setImageDrawable(getResources().getDrawable(i));
    }

    @Override // android.view.View
    public boolean verifyDrawable(android.graphics.drawable.Drawable drawable) {
        if (drawable == this._Drawable) {
            return true;
        }
        return super.verifyDrawable(drawable);
    }
}
