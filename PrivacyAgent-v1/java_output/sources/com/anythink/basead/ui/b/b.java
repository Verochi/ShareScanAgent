package com.anythink.basead.ui.b;

/* loaded from: classes12.dex */
public abstract class b {
    protected android.content.Context a;
    protected com.anythink.core.common.f.l b;
    protected com.anythink.core.common.f.m c;
    protected android.view.ViewGroup d;
    protected int e;
    android.widget.RelativeLayout f;
    android.view.View g;
    protected com.anythink.basead.ui.b.b.a h;

    public interface a {
        void a(int i, int i2);
    }

    public abstract void a();

    public abstract void a(int i, java.util.Map<java.lang.String, java.lang.Object> map);

    public void a(android.content.Context context, com.anythink.core.common.f.l lVar, com.anythink.core.common.f.m mVar, android.view.ViewGroup viewGroup, android.widget.RelativeLayout relativeLayout, android.view.View view, int i, com.anythink.basead.ui.b.b.a aVar) {
        this.a = context;
        this.b = lVar;
        this.c = mVar;
        this.d = viewGroup;
        this.e = i;
        this.h = aVar;
        this.f = relativeLayout;
        this.g = view;
    }
}
