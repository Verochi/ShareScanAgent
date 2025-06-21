package com.aliyun.svideosdk.multirecorder.impl.c.i.a;

/* loaded from: classes12.dex */
public class d implements com.aliyun.svideosdk.multirecorder.impl.c.i.a.c<android.graphics.Bitmap> {
    private static android.os.Handler a = new android.os.Handler(android.os.Looper.getMainLooper());

    public class a implements java.lang.Runnable {
        final /* synthetic */ com.aliyun.svideosdk.multirecorder.impl.c.i.a.c.a a;

        public a(com.aliyun.svideosdk.multirecorder.impl.c.i.a.d dVar, com.aliyun.svideosdk.multirecorder.impl.c.i.a.c.a aVar) {
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a(null);
        }
    }

    public class b implements android.view.PixelCopy.OnPixelCopyFinishedListener {
        final /* synthetic */ com.aliyun.svideosdk.multirecorder.impl.c.i.a.c.a a;
        final /* synthetic */ android.graphics.Bitmap b;

        public b(com.aliyun.svideosdk.multirecorder.impl.c.i.a.c.a aVar, android.graphics.Bitmap bitmap) {
            this.a = aVar;
            this.b = bitmap;
        }

        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
        public void onPixelCopyFinished(int i) {
            com.aliyun.svideosdk.multirecorder.impl.c.i.a.d.this.a(i, this.a, this.b);
        }
    }

    public class c implements android.view.PixelCopy.OnPixelCopyFinishedListener {
        final /* synthetic */ com.aliyun.svideosdk.multirecorder.impl.c.i.a.c.a a;
        final /* synthetic */ android.graphics.Bitmap b;

        public c(com.aliyun.svideosdk.multirecorder.impl.c.i.a.c.a aVar, android.graphics.Bitmap bitmap) {
            this.a = aVar;
            this.b = bitmap;
        }

        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
        public void onPixelCopyFinished(int i) {
            com.aliyun.svideosdk.multirecorder.impl.c.i.a.d.this.a(i, this.a, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, com.aliyun.svideosdk.multirecorder.impl.c.i.a.c.a<android.graphics.Bitmap> aVar, android.graphics.Bitmap bitmap) {
        if (i == 0) {
            aVar.a(bitmap);
        } else {
            aVar.a(null);
        }
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.i.a.c
    public java.lang.String a() {
        return "PixelCopy";
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.i.a.c
    public void a(android.view.View view, com.aliyun.svideosdk.multirecorder.impl.c.i.a.c.a<android.graphics.Bitmap> aVar) {
        if (android.os.Build.VERSION.SDK_INT < 26 || !view.isAttachedToWindow()) {
            a.post(new com.aliyun.svideosdk.multirecorder.impl.c.i.a.d.a(this, aVar));
            return;
        }
        android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(view.getWidth(), view.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        if (view instanceof android.view.SurfaceView) {
            android.view.PixelCopy.request((android.view.SurfaceView) view, (android.graphics.Rect) null, createBitmap, new com.aliyun.svideosdk.multirecorder.impl.c.i.a.d.b(aVar, createBitmap), a);
            return;
        }
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        android.view.Window window = ((android.app.Activity) view.getContext()).getWindow();
        int i = iArr[0];
        android.view.PixelCopy.request(window, new android.graphics.Rect(i, iArr[1], view.getWidth() + i, iArr[1] + view.getHeight()), createBitmap, new com.aliyun.svideosdk.multirecorder.impl.c.i.a.d.c(aVar, createBitmap), a);
    }
}
