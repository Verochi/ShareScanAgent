package com.aliyun.svideosdk.multirecorder.impl.c.i.a;

/* loaded from: classes12.dex */
public class a implements com.aliyun.svideosdk.multirecorder.impl.c.i.a.c<android.graphics.Bitmap> {
    @Override // com.aliyun.svideosdk.multirecorder.impl.c.i.a.c
    public java.lang.String a() {
        return "DrawCanvas";
    }

    @Override // com.aliyun.svideosdk.multirecorder.impl.c.i.a.c
    public void a(android.view.View view, com.aliyun.svideosdk.multirecorder.impl.c.i.a.c.a<android.graphics.Bitmap> aVar) {
        android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(view.getWidth(), view.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas = new android.graphics.Canvas(createBitmap);
        view.computeScroll();
        canvas.translate(view.getScrollX() * (-1), view.getScrollY() * (-1));
        view.draw(canvas);
        aVar.a(createBitmap);
    }
}
