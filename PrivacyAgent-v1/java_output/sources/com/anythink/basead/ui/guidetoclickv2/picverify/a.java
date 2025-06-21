package com.anythink.basead.ui.guidetoclickv2.picverify;

/* loaded from: classes12.dex */
public abstract class a {
    protected android.content.Context a;

    public a(android.content.Context context) {
        this.a = context;
    }

    private android.content.Context c() {
        return this.a;
    }

    public abstract android.graphics.Paint a();

    public abstract android.graphics.Path a(int i);

    public abstract com.anythink.basead.ui.guidetoclickv2.picverify.c a(int i, int i2, int i3);

    public void a(android.content.Context context, android.graphics.Canvas canvas, android.graphics.Path path) {
    }

    public abstract android.graphics.Paint b();

    public com.anythink.basead.ui.guidetoclickv2.picverify.c b(int i, int i2, int i3) {
        return a(i, i2, i3);
    }
}
