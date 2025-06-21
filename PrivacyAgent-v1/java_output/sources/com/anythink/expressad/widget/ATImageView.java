package com.anythink.expressad.widget;

/* loaded from: classes12.dex */
public class ATImageView extends android.widget.ImageView {
    private static final java.lang.String a = "at-widget-imageview";
    private android.graphics.Bitmap b;
    private java.lang.String c;

    /* renamed from: com.anythink.expressad.widget.ATImageView$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.expressad.foundation.g.d.c {
        public AnonymousClass1() {
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(android.graphics.Bitmap bitmap, java.lang.String str) {
            com.anythink.expressad.widget.ATImageView.this.setImageBitmap(bitmap);
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(java.lang.String str, java.lang.String str2) {
        }
    }

    public ATImageView(android.content.Context context) {
        super(context);
        this.b = null;
    }

    public ATImageView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = null;
    }

    public ATImageView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = null;
    }

    private void a() {
        if (getContext() != null) {
            com.anythink.expressad.foundation.g.d.b.a(getContext()).a(this.c, new com.anythink.expressad.widget.ATImageView.AnonymousClass1());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        try {
            android.graphics.Bitmap bitmap = this.b;
            if (bitmap == null || !bitmap.isRecycled()) {
                super.onDraw(canvas);
            } else if (getContext() != null) {
                com.anythink.expressad.foundation.g.d.b.a(getContext()).a(this.c, new com.anythink.expressad.widget.ATImageView.AnonymousClass1());
            }
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(android.graphics.Bitmap bitmap) {
        this.b = bitmap;
        if (bitmap == null || !bitmap.isRecycled()) {
            super.setImageBitmap(bitmap);
        } else {
            this.b = null;
            super.setImageBitmap(null);
        }
    }

    public void setImageUrl(java.lang.String str) {
        this.c = str;
    }
}
