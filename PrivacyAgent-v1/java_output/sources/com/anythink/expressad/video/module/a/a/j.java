package com.anythink.expressad.video.module.a.a;

/* loaded from: classes12.dex */
public final class j extends com.anythink.expressad.video.module.a.a.e {
    private int a;

    public j(android.widget.ImageView imageView, int i) {
        super(imageView);
        this.a = i;
    }

    @Override // com.anythink.expressad.video.module.a.a.e, com.anythink.expressad.foundation.g.d.c
    public final void a(android.graphics.Bitmap bitmap, java.lang.String str) {
        android.graphics.Bitmap a;
        if (bitmap == null) {
            return;
        }
        try {
            java.lang.ref.WeakReference<android.widget.ImageView> weakReference = this.c;
            if (weakReference == null || weakReference.get() == null || bitmap.isRecycled() || (a = com.anythink.expressad.foundation.h.n.a(bitmap, this.a)) == null) {
                return;
            }
            this.c.get().setImageBitmap(a);
        } catch (java.lang.Throwable th) {
            if (com.anythink.expressad.a.a) {
                th.printStackTrace();
            }
        }
    }
}
