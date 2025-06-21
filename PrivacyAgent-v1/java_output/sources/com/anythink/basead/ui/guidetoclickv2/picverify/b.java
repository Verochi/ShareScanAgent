package com.anythink.basead.ui.guidetoclickv2.picverify;

/* loaded from: classes12.dex */
public final class b extends com.anythink.basead.ui.guidetoclickv2.picverify.a {
    public b(android.content.Context context) {
        super(context);
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.picverify.a
    public final android.graphics.Paint a() {
        android.graphics.Paint paint = new android.graphics.Paint();
        paint.setColor(android.graphics.Color.parseColor("#000000"));
        paint.setAlpha(127);
        return paint;
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.picverify.a
    public final android.graphics.Path a(int i) {
        android.graphics.Path path = new android.graphics.Path();
        path.moveTo(0.0f, 0.0f);
        float f = i;
        path.rLineTo(f, 0.0f);
        path.rLineTo(0.0f, f);
        float f2 = -i;
        path.rLineTo(f2, 0.0f);
        path.rLineTo(0.0f, f2);
        path.close();
        return path;
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.picverify.a
    @androidx.annotation.NonNull
    public final com.anythink.basead.ui.guidetoclickv2.picverify.c a(int i, int i2, int i3) {
        return new com.anythink.basead.ui.guidetoclickv2.picverify.c((i - i3) - ((int) (i * 0.15d)), (int) ((i2 / 2.0d) - (i3 * 1.5d)));
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.picverify.a
    public final void a(android.content.Context context, android.graphics.Canvas canvas, android.graphics.Path path) {
        android.graphics.Paint paint = new android.graphics.Paint();
        paint.setColor(android.graphics.Color.parseColor("#FFFFFF"));
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        paint.setStrokeWidth(com.anythink.core.common.o.i.a(context, 2.0f));
        paint.setPathEffect(new android.graphics.DashPathEffect(new float[]{20.0f, 20.0f}, 10.0f));
        canvas.drawPath(new android.graphics.Path(path), paint);
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.picverify.a
    public final android.graphics.Paint b() {
        return new android.graphics.Paint();
    }

    @Override // com.anythink.basead.ui.guidetoclickv2.picverify.a
    @androidx.annotation.NonNull
    public final com.anythink.basead.ui.guidetoclickv2.picverify.c b(int i, int i2, int i3) {
        return new com.anythink.basead.ui.guidetoclickv2.picverify.c((int) (i * 0.15d), (int) ((i2 / 2.0d) - (i3 * 1.5d)));
    }
}
