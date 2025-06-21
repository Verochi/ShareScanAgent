package com.anythink.expressad.foundation.f;

/* loaded from: classes12.dex */
public final class b {
    public static int a = -2;
    public static int b = -2;
    public static volatile boolean c;
    private final java.util.concurrent.ConcurrentHashMap<java.lang.String, com.anythink.expressad.foundation.f.a.a> d;
    private final android.widget.RelativeLayout.LayoutParams e;
    private com.anythink.expressad.d.a f;

    public static class a {
        private static final com.anythink.expressad.foundation.f.b a = new com.anythink.expressad.foundation.f.b((byte) 0);
    }

    private b() {
        this.d = new java.util.concurrent.ConcurrentHashMap<>();
        this.e = new android.widget.RelativeLayout.LayoutParams(a, b);
    }

    public /* synthetic */ b(byte b2) {
        this();
    }

    public static android.app.Activity a(android.content.Context context) {
        android.app.Activity activity;
        android.content.Context g = com.anythink.expressad.foundation.b.a.b().g();
        android.app.Activity activity2 = null;
        try {
            activity = g instanceof android.app.Activity ? (android.app.Activity) g : null;
        } catch (java.lang.Exception e) {
            e = e;
        }
        try {
            if ((context instanceof android.app.Activity) && !((android.app.Activity) context).isDestroyed()) {
                activity = (android.app.Activity) context;
            }
            if (activity == null || activity.isFinishing()) {
                return null;
            }
            if (activity.isDestroyed()) {
                return null;
            }
            return activity;
        } catch (java.lang.Exception e2) {
            e = e2;
            activity2 = activity;
            e.printStackTrace();
            return activity2;
        }
    }

    public static com.anythink.expressad.foundation.f.b a() {
        return com.anythink.expressad.foundation.f.b.a.a;
    }

    private void a(java.lang.String str, int i, int i2, int i3, float f, float f2, float f3, java.lang.String str2, java.lang.String str3) {
        com.anythink.expressad.foundation.f.a.a a2 = a(str);
        android.content.Context f4 = com.anythink.core.common.b.o.a().f();
        a2.a(com.anythink.expressad.foundation.h.t.b(f4, f), com.anythink.expressad.foundation.h.t.b(f4, f2), com.anythink.expressad.foundation.h.t.b(f4, i), com.anythink.expressad.foundation.h.t.b(f4, i2), com.anythink.expressad.foundation.h.t.b(f4, i3), f3, str2, str3);
    }

    private void a(java.lang.String str, int i, android.view.ViewGroup viewGroup) {
        com.anythink.expressad.foundation.f.a.a a2 = a(str);
        if (a2.c() != null) {
            a2.a(i);
            if (i == 0) {
                a(str, com.anythink.core.common.b.o.a().f(), viewGroup, null, null);
            }
        }
    }

    private void a(java.lang.String str, android.content.Context context, android.view.ViewGroup viewGroup, android.view.ViewGroup.LayoutParams layoutParams) {
        a(str, context, viewGroup, layoutParams, null);
    }

    public static boolean a(android.content.Context context, com.anythink.expressad.widget.a.c cVar) {
        if (cVar == null) {
            return false;
        }
        return b(context, cVar);
    }

    private static boolean b(android.content.Context context, com.anythink.expressad.widget.a.c cVar) {
        android.app.Activity a2 = a(context);
        if (a2 == null || cVar == null || a2.isDestroyed()) {
            return false;
        }
        try {
            if (cVar.isShowing() || a2.isFinishing()) {
                return false;
            }
            cVar.show();
            return true;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void c(java.lang.String str, int i) {
        com.anythink.expressad.foundation.f.a.a a2 = a(str);
        if (i == 1) {
            a2.b();
        } else {
            a2.a();
        }
    }

    private com.anythink.expressad.foundation.f.a.a d(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            str = com.anythink.expressad.foundation.b.a.b().e();
        }
        if (this.d.containsKey(str)) {
            return this.d.get(str);
        }
        return null;
    }

    private void e(java.lang.String str) {
        a(str).e();
    }

    public final com.anythink.expressad.foundation.f.a.a a(java.lang.String str) {
        com.anythink.expressad.foundation.f.a.a aVar;
        if (android.text.TextUtils.isEmpty(str)) {
            str = com.anythink.expressad.foundation.b.a.b().e();
        }
        if (this.d.containsKey(str)) {
            aVar = this.d.get(str);
        } else {
            aVar = new com.anythink.expressad.foundation.f.a.a(str);
            this.d.put(str, aVar);
        }
        if (aVar != null) {
            return aVar;
        }
        com.anythink.expressad.foundation.f.a.a aVar2 = new com.anythink.expressad.foundation.f.a.a(str);
        this.d.put(str, aVar2);
        return aVar2;
    }

    public final void a(java.lang.String str, int i) {
        a(str).b(i);
    }

    public final void a(java.lang.String str, android.content.Context context, android.view.ViewGroup viewGroup, android.view.ViewGroup.LayoutParams layoutParams, com.anythink.expressad.foundation.f.a aVar) {
        if (b()) {
            com.anythink.expressad.foundation.f.a.a a2 = a(str);
            if (aVar != null) {
                a2.a(new com.anythink.expressad.foundation.f.a.a.C0209a(str, aVar));
            }
            com.anythink.expressad.widget.FeedBackButton c2 = a2.c();
            if (c2 != null) {
                if (layoutParams == null) {
                    int b2 = com.anythink.expressad.foundation.h.t.b(com.anythink.core.common.b.o.a().f(), 10.0f);
                    this.e.setMargins(b2, b2, b2, b2);
                    layoutParams = this.e;
                }
                android.view.ViewGroup viewGroup2 = (android.view.ViewGroup) c2.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeView(c2);
                }
                android.app.Activity a3 = a(context);
                if (a3 != null && viewGroup == null) {
                    viewGroup = (android.view.ViewGroup) a3.findViewById(android.R.id.content);
                }
                if (viewGroup != null) {
                    viewGroup.removeView(c2);
                    viewGroup.addView(c2, layoutParams);
                }
            }
        }
    }

    public final void a(java.lang.String str, com.anythink.expressad.foundation.d.c cVar) {
        a(str).a(cVar);
    }

    public final void a(java.lang.String str, com.anythink.expressad.foundation.f.a aVar) {
        a(str).a(new com.anythink.expressad.foundation.f.a.a.C0209a(str, aVar));
    }

    public final void a(java.lang.String str, com.anythink.expressad.widget.FeedBackButton feedBackButton) {
        a(str).a(feedBackButton);
    }

    public final com.anythink.expressad.widget.FeedBackButton b(java.lang.String str) {
        return a(str).c();
    }

    public final void b(java.lang.String str, int i) {
        a(str).c(i);
    }

    public final boolean b() {
        com.anythink.expressad.d.b.a();
        com.anythink.expressad.d.a c2 = com.anythink.expressad.d.b.c();
        this.f = c2;
        return c2.K() != 0;
    }

    public final void c(java.lang.String str) {
        try {
            java.lang.String e = android.text.TextUtils.isEmpty(str) ? com.anythink.expressad.foundation.b.a.b().e() : str;
            com.anythink.expressad.foundation.f.a.a aVar = this.d.containsKey(e) ? this.d.get(e) : null;
            if (aVar != null) {
                aVar.d();
            }
            this.d.remove(str);
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
        }
    }
}
