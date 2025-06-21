package com.aliyun.svideosdk.multirecorder.impl.c.i.a;

/* loaded from: classes12.dex */
public class b implements com.aliyun.svideosdk.multirecorder.impl.c.i.a.c<android.graphics.Bitmap> {
    @Override // com.aliyun.svideosdk.multirecorder.impl.c.i.a.c
    public java.lang.String a() {
        return "DrawingCache";
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.i.a.c
    public void a(android.view.View view, com.aliyun.svideosdk.multirecorder.impl.c.i.a.c.a<android.graphics.Bitmap> aVar) {
        boolean isDrawingCacheEnabled = view.isDrawingCacheEnabled();
        if (isDrawingCacheEnabled) {
            view.destroyDrawingCache();
        } else {
            view.setDrawingCacheEnabled(true);
        }
        android.graphics.Bitmap drawingCache = view.getDrawingCache(true);
        android.graphics.Bitmap createBitmap = drawingCache != null ? android.graphics.Bitmap.createBitmap(drawingCache) : null;
        view.setDrawingCacheEnabled(isDrawingCacheEnabled);
        aVar.a(createBitmap);
    }
}
