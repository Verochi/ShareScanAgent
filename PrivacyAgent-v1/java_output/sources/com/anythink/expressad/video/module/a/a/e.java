package com.anythink.expressad.video.module.a.a;

/* loaded from: classes12.dex */
public class e implements com.anythink.expressad.foundation.g.d.c {
    protected static final java.lang.String b = "ImageLoaderListener";
    private com.anythink.expressad.foundation.d.c a;
    protected java.lang.ref.WeakReference<android.widget.ImageView> c;
    private java.lang.String d;

    public e(android.widget.ImageView imageView) {
        this.c = new java.lang.ref.WeakReference<>(imageView);
    }

    public e(android.widget.ImageView imageView, com.anythink.expressad.foundation.d.c cVar, java.lang.String str) {
        this.c = new java.lang.ref.WeakReference<>(imageView);
        this.a = cVar;
        this.d = str;
    }

    @Override // com.anythink.expressad.foundation.g.d.c
    public void a(android.graphics.Bitmap bitmap, java.lang.String str) {
        if (bitmap == null) {
            return;
        }
        try {
            java.lang.ref.WeakReference<android.widget.ImageView> weakReference = this.c;
            if (weakReference == null || weakReference.get() == null || bitmap.isRecycled()) {
                return;
            }
            this.c.get().setImageBitmap(bitmap);
            this.c.get().setVisibility(0);
        } catch (java.lang.Throwable th) {
            if (com.anythink.expressad.a.a) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.anythink.expressad.foundation.g.d.c
    public void a(java.lang.String str, java.lang.String str2) {
    }
}
