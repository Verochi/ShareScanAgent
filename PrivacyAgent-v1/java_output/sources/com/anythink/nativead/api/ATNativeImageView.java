package com.anythink.nativead.api;

/* loaded from: classes12.dex */
public class ATNativeImageView extends android.widget.ImageView {
    public static final java.lang.String TAG = "ATNativeImageView";
    java.lang.String mImageUrl;

    /* renamed from: com.anythink.nativead.api.ATNativeImageView$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.core.common.res.b.a {
        final /* synthetic */ java.lang.ref.WeakReference val$imageViewWeakReference;

        public AnonymousClass1(java.lang.ref.WeakReference weakReference) {
            this.val$imageViewWeakReference = weakReference;
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onFail(java.lang.String str, java.lang.String str2) {
            java.lang.String str3 = com.anythink.nativead.api.ATNativeImageView.TAG;
            "load: image load fail:".concat(java.lang.String.valueOf(str2));
        }

        @Override // com.anythink.core.common.res.b.a
        public final void onSuccess(java.lang.String str, android.graphics.Bitmap bitmap) {
            com.anythink.nativead.api.ATNativeImageView aTNativeImageView = (com.anythink.nativead.api.ATNativeImageView) this.val$imageViewWeakReference.get();
            if (!android.text.TextUtils.equals(com.anythink.nativead.api.ATNativeImageView.this.mImageUrl, str) || aTNativeImageView == null) {
                return;
            }
            aTNativeImageView.setImageBitmap(bitmap);
        }
    }

    public ATNativeImageView(android.content.Context context) {
        super(context);
    }

    public ATNativeImageView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ATNativeImageView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.View
    public void dispatchDraw(android.graphics.Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
        } catch (java.lang.Throwable unused) {
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (java.lang.Throwable unused) {
        }
    }

    public void setImage(java.lang.String str) {
        android.view.ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            setImage(str, layoutParams.width, layoutParams.height);
        } else {
            setImage(str, -1, -1);
        }
    }

    public void setImage(java.lang.String str, int i, int i2) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.mImageUrl = str;
        com.anythink.core.common.res.b.a(getContext()).a(new com.anythink.core.common.res.e(2, str), i, i2, new com.anythink.nativead.api.ATNativeImageView.AnonymousClass1(new java.lang.ref.WeakReference(this)));
    }
}
