package com.igexin.push.core.i.a;

/* loaded from: classes23.dex */
public abstract class b<T extends android.graphics.drawable.Drawable> implements com.igexin.push.core.i.a.l, com.igexin.push.core.i.a.m<T> {
    protected final T a;

    public b(T t) {
        this.a = (T) com.igexin.push.core.i.a.k.a(t);
    }

    @Override // com.igexin.push.core.i.a.m
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final T c() {
        android.graphics.drawable.Drawable.ConstantState constantState = this.a.getConstantState();
        return constantState == null ? this.a : (T) constantState.newDrawable();
    }

    @Override // com.igexin.push.core.i.a.l
    public void b() {
        T t = this.a;
        if (t instanceof android.graphics.drawable.BitmapDrawable) {
            ((android.graphics.drawable.BitmapDrawable) t).getBitmap().prepareToDraw();
        } else if (t instanceof com.igexin.push.core.i.a.e) {
            ((com.igexin.push.core.i.a.e) t).a().prepareToDraw();
        }
    }
}
