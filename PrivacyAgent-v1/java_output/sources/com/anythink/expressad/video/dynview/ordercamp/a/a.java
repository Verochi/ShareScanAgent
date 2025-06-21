package com.anythink.expressad.video.dynview.ordercamp.a;

/* loaded from: classes12.dex */
public final class a extends android.widget.BaseAdapter {
    private static final java.lang.String a = "OrderCampAdapter";
    private static final java.lang.String e = "anythink_lv_item_rl";
    private static final java.lang.String f = "anythink_lv_iv";
    private static final java.lang.String g = "anythink_lv_icon_iv";
    private static final java.lang.String h = "anythink_lv_title_tv";
    private static final java.lang.String i = "anythink_lv_tv_install";
    private static final java.lang.String j = "anythink_lv_sv_starlevel";
    private static final java.lang.String k = "anythink_lv_sv_heat_level";
    private static final java.lang.String l = "anythink_lv_ration";
    private static final java.lang.String m = "anythink_lv_desc_tv";
    private static final java.lang.String n = "anythink_iv_flag";
    private static final java.lang.String o = "anythink_order_viewed_tv";
    private static final java.lang.String p = "anythink_order_layout_item";
    private static final java.lang.String q = "anythink_lv_iv_burl";
    private static final java.lang.String r = "501";

    /* renamed from: s, reason: collision with root package name */
    private static final java.lang.String f269s = "\\.xml";
    private static final java.lang.String t = "\\/xml";
    private static final java.lang.String u = "_item.xml";
    private boolean b = false;
    private com.anythink.expressad.video.dynview.ordercamp.a.a.C0229a c;
    private java.util.List<com.anythink.expressad.foundation.d.c> d;

    /* renamed from: com.anythink.expressad.video.dynview.ordercamp.a.a$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.expressad.foundation.g.d.c {
        final /* synthetic */ android.widget.ImageView a;
        final /* synthetic */ boolean b;

        public AnonymousClass1(android.widget.ImageView imageView, boolean z) {
            this.a = imageView;
            this.b = z;
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(android.graphics.Bitmap bitmap, java.lang.String str) {
            try {
                if (bitmap.isRecycled()) {
                    return;
                }
                this.a.setImageBitmap(bitmap);
            } catch (java.lang.Throwable th) {
                th.getMessage();
            }
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(java.lang.String str, java.lang.String str2) {
            if (this.b) {
                this.a.setVisibility(8);
            }
        }
    }

    /* renamed from: com.anythink.expressad.video.dynview.ordercamp.a.a$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.expressad.foundation.g.d.c {
        final /* synthetic */ android.content.Context a;

        public AnonymousClass2(android.content.Context context) {
            this.a = context;
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(android.graphics.Bitmap bitmap, java.lang.String str) {
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            try {
                int b = com.anythink.expressad.foundation.h.t.b(this.a, 12.0f);
                com.anythink.expressad.video.dynview.ordercamp.a.a.this.c.j.getLayoutParams().height = b;
                com.anythink.expressad.video.dynview.ordercamp.a.a.this.c.j.getLayoutParams().width = (int) (b * ((bitmap.getWidth() * 1.0f) / bitmap.getHeight()));
                com.anythink.expressad.video.dynview.ordercamp.a.a.this.c.j.setImageBitmap(bitmap);
                com.anythink.expressad.video.dynview.ordercamp.a.a.this.c.j.setBackgroundColor(1426063360);
            } catch (java.lang.Throwable unused) {
            }
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(java.lang.String str, java.lang.String str2) {
        }
    }

    /* renamed from: com.anythink.expressad.video.dynview.ordercamp.a.a$a, reason: collision with other inner class name */
    public static class C0229a {
        android.widget.RelativeLayout a;
        com.anythink.expressad.video.dynview.widget.ATRotationView b;
        com.anythink.expressad.video.dynview.widget.ATImageView c;
        com.anythink.expressad.videocommon.view.RoundImageView d;
        android.widget.TextView e;
        android.widget.TextView f;
        android.widget.TextView g;
        android.widget.TextView h;
        com.anythink.expressad.video.dynview.widget.ATLevelLayoutView i;
        android.widget.ImageView j;
    }

    public a(java.util.List<com.anythink.expressad.foundation.d.c> list) {
        this.d = list;
    }

    private static int a(java.lang.String str) {
        return com.anythink.expressad.foundation.h.i.a(com.anythink.core.common.b.o.a().f().getApplicationContext(), str, "layout");
    }

    private android.view.View a() {
        android.view.View inflate = android.view.LayoutInflater.from(com.anythink.core.common.b.o.a().f()).inflate(com.anythink.expressad.foundation.h.i.a(com.anythink.core.common.b.o.a().f().getApplicationContext(), p, "layout"), (android.view.ViewGroup) null);
        com.anythink.expressad.video.dynview.ordercamp.a.a.C0229a c0229a = new com.anythink.expressad.video.dynview.ordercamp.a.a.C0229a();
        this.c = c0229a;
        c0229a.c = (com.anythink.expressad.video.dynview.widget.ATImageView) inflate.findViewById(b(f));
        this.c.d = (com.anythink.expressad.videocommon.view.RoundImageView) inflate.findViewById(b(g));
        this.c.i = (com.anythink.expressad.video.dynview.widget.ATLevelLayoutView) inflate.findViewById(b(j));
        this.c.b = (com.anythink.expressad.video.dynview.widget.ATRotationView) inflate.findViewById(b(l));
        inflate.setTag(this.c);
        return inflate;
    }

    private void a(int i2) {
        java.util.List<com.anythink.expressad.foundation.d.c> list = this.d;
        if (list == null || this.c == null || list.size() == 0) {
            return;
        }
        com.anythink.expressad.video.dynview.widget.ATImageView aTImageView = this.c.c;
        if (aTImageView != null) {
            a(aTImageView, this.d.get(i2).be(), false);
        }
        com.anythink.expressad.videocommon.view.RoundImageView roundImageView = this.c.d;
        if (roundImageView != null) {
            roundImageView.setBorderRadius(25);
            a(this.c.d, this.d.get(i2).bd(), true);
        }
        double aX = this.d.get(i2).aX();
        if (aX <= 0.0d) {
            aX = 5.0d;
        }
        com.anythink.expressad.video.dynview.widget.ATLevelLayoutView aTLevelLayoutView = this.c.i;
        if (aTLevelLayoutView != null) {
            aTLevelLayoutView.setRatingAndUser(aX, this.d.get(i2).aY());
            this.c.i.setOrientation(0);
        }
        com.anythink.expressad.video.dynview.widget.ATRotationView aTRotationView = this.c.b;
        if (aTRotationView != null) {
            aTRotationView.setWidthRatio(1.0f);
            this.c.b.setHeightRatio(1.0f);
            this.c.b.setAutoscroll(false);
        }
        com.anythink.expressad.video.dynview.widget.ATImageView aTImageView2 = this.c.c;
        if (aTImageView2 != null) {
            aTImageView2.setCustomBorder(30, 30, 30, 30, 10, -1728053248);
        }
    }

    private void a(android.view.View view) {
        this.c.a = (android.widget.RelativeLayout) view.findViewById(d(e));
        this.c.e = (android.widget.TextView) view.findViewById(d(h));
        this.c.g = (android.widget.TextView) view.findViewById(d(i));
        this.c.f = (android.widget.TextView) view.findViewById(d(m));
        this.c.j = (android.widget.ImageView) view.findViewById(d(n));
        this.c.h = (android.widget.TextView) view.findViewById(d(o));
    }

    private void a(android.widget.ImageView imageView, java.lang.String str, boolean z) {
        if (imageView == null) {
            return;
        }
        if (!android.text.TextUtils.isEmpty(str)) {
            com.anythink.expressad.foundation.g.d.b.a(imageView.getContext()).a(str, new com.anythink.expressad.video.dynview.ordercamp.a.a.AnonymousClass1(imageView, z));
        } else if (z) {
            imageView.setVisibility(8);
        }
    }

    private static int b(java.lang.String str) {
        return com.anythink.expressad.foundation.h.i.a(com.anythink.core.common.b.o.a().f().getApplicationContext(), str, "id");
    }

    private android.view.View b() {
        android.view.View inflate = android.view.LayoutInflater.from(com.anythink.core.common.b.o.a().f()).inflate(com.anythink.expressad.foundation.h.i.a(com.anythink.core.common.b.o.a().f().getApplicationContext(), p, "layout"), (android.view.ViewGroup) null);
        com.anythink.expressad.video.dynview.ordercamp.a.a.C0229a c0229a = new com.anythink.expressad.video.dynview.ordercamp.a.a.C0229a();
        this.c = c0229a;
        c0229a.c = (com.anythink.expressad.video.dynview.widget.ATImageView) inflate.findViewById(b(f));
        this.c.d = (com.anythink.expressad.videocommon.view.RoundImageView) inflate.findViewById(b(g));
        this.c.i = (com.anythink.expressad.video.dynview.widget.ATLevelLayoutView) inflate.findViewById(b(j));
        this.c.b = (com.anythink.expressad.video.dynview.widget.ATRotationView) inflate.findViewById(b(l));
        inflate.setTag(this.c);
        return inflate;
    }

    private void b(int i2) {
        if (this.c != null) {
            com.anythink.expressad.foundation.d.c cVar = this.d.get(i2);
            if (this.c.e != null) {
                this.c.e.setText(cVar.bb());
            }
            if (this.c.f != null) {
                this.c.f.setText(cVar.bc());
            }
            android.widget.TextView textView = this.c.g;
            if (textView != null) {
                java.lang.String str = cVar.cU;
                if (textView instanceof com.anythink.expressad.video.dynview.widget.ATTextView) {
                    new com.anythink.expressad.video.dynview.h.b();
                    ((com.anythink.expressad.video.dynview.widget.ATTextView) this.c.g).setObjectAnimator(com.anythink.expressad.video.dynview.h.b.c(this.c.g));
                }
                this.c.g.setText(str);
            }
            if (this.c.j != null) {
                try {
                    java.util.Locale.getDefault().getLanguage();
                    android.content.Context f2 = com.anythink.core.common.b.o.a().f();
                    com.anythink.expressad.foundation.g.d.b.a(f2).a(cVar.aE(), new com.anythink.expressad.video.dynview.ordercamp.a.a.AnonymousClass2(f2));
                } catch (java.lang.Exception e2) {
                    e2.getMessage();
                }
            }
            if (this.c.h != null) {
                try {
                    this.c.h.setText(com.anythink.core.common.b.o.a().f().getResources().getString(com.anythink.core.common.b.o.a().f().getResources().getIdentifier("anythink_reward_viewed_text_str", com.anythink.expressad.foundation.h.i.g, com.anythink.core.common.b.o.a().f().getPackageName())));
                    this.c.h.setVisibility(0);
                } catch (java.lang.Exception e3) {
                    e3.getMessage();
                }
            }
        }
    }

    private static int c(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return -1;
        }
        return str.hashCode();
    }

    private int d(java.lang.String str) {
        return this.b ? c(str) : b(str);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        java.util.List<com.anythink.expressad.foundation.d.c> list = this.d;
        if (list == null || list.size() <= 0) {
            return 0;
        }
        return this.d.size();
    }

    @Override // android.widget.Adapter
    public final java.lang.Object getItem(int i2) {
        java.util.List<com.anythink.expressad.foundation.d.c> list = this.d;
        if (list != null) {
            return list.get(i2);
        }
        return null;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public final android.view.View getView(int i2, android.view.View view, android.view.ViewGroup viewGroup) {
        try {
            if (view == null) {
                android.view.View inflate = android.view.LayoutInflater.from(com.anythink.core.common.b.o.a().f()).inflate(com.anythink.expressad.foundation.h.i.a(com.anythink.core.common.b.o.a().f().getApplicationContext(), p, "layout"), (android.view.ViewGroup) null);
                com.anythink.expressad.video.dynview.ordercamp.a.a.C0229a c0229a = new com.anythink.expressad.video.dynview.ordercamp.a.a.C0229a();
                this.c = c0229a;
                c0229a.c = (com.anythink.expressad.video.dynview.widget.ATImageView) inflate.findViewById(b(f));
                this.c.d = (com.anythink.expressad.videocommon.view.RoundImageView) inflate.findViewById(b(g));
                this.c.i = (com.anythink.expressad.video.dynview.widget.ATLevelLayoutView) inflate.findViewById(b(j));
                this.c.b = (com.anythink.expressad.video.dynview.widget.ATRotationView) inflate.findViewById(b(l));
                inflate.setTag(this.c);
                view = inflate;
            } else {
                this.c = (com.anythink.expressad.video.dynview.ordercamp.a.a.C0229a) view.getTag();
            }
            this.c.a = (android.widget.RelativeLayout) view.findViewById(d(e));
            this.c.e = (android.widget.TextView) view.findViewById(d(h));
            this.c.g = (android.widget.TextView) view.findViewById(d(i));
            this.c.f = (android.widget.TextView) view.findViewById(d(m));
            this.c.j = (android.widget.ImageView) view.findViewById(d(n));
            this.c.h = (android.widget.TextView) view.findViewById(d(o));
            java.util.List<com.anythink.expressad.foundation.d.c> list = this.d;
            if (list != null && this.c != null && list.size() != 0) {
                com.anythink.expressad.video.dynview.widget.ATImageView aTImageView = this.c.c;
                if (aTImageView != null) {
                    a(aTImageView, this.d.get(i2).be(), false);
                }
                com.anythink.expressad.videocommon.view.RoundImageView roundImageView = this.c.d;
                if (roundImageView != null) {
                    roundImageView.setBorderRadius(25);
                    a(this.c.d, this.d.get(i2).bd(), true);
                }
                double aX = this.d.get(i2).aX();
                if (aX <= 0.0d) {
                    aX = 5.0d;
                }
                com.anythink.expressad.video.dynview.widget.ATLevelLayoutView aTLevelLayoutView = this.c.i;
                if (aTLevelLayoutView != null) {
                    aTLevelLayoutView.setRatingAndUser(aX, this.d.get(i2).aY());
                    this.c.i.setOrientation(0);
                }
                com.anythink.expressad.video.dynview.widget.ATRotationView aTRotationView = this.c.b;
                if (aTRotationView != null) {
                    aTRotationView.setWidthRatio(1.0f);
                    this.c.b.setHeightRatio(1.0f);
                    this.c.b.setAutoscroll(false);
                }
                com.anythink.expressad.video.dynview.widget.ATImageView aTImageView2 = this.c.c;
                if (aTImageView2 != null) {
                    aTImageView2.setCustomBorder(30, 30, 30, 30, 10, -1728053248);
                }
            }
            if (this.c != null) {
                com.anythink.expressad.foundation.d.c cVar = this.d.get(i2);
                if (this.c.e != null) {
                    this.c.e.setText(cVar.bb());
                }
                if (this.c.f != null) {
                    this.c.f.setText(cVar.bc());
                }
                android.widget.TextView textView = this.c.g;
                if (textView != null) {
                    java.lang.String str = cVar.cU;
                    if (textView instanceof com.anythink.expressad.video.dynview.widget.ATTextView) {
                        new com.anythink.expressad.video.dynview.h.b();
                        ((com.anythink.expressad.video.dynview.widget.ATTextView) this.c.g).setObjectAnimator(com.anythink.expressad.video.dynview.h.b.c(this.c.g));
                    }
                    this.c.g.setText(str);
                }
                if (this.c.j != null) {
                    try {
                        java.util.Locale.getDefault().getLanguage();
                        android.content.Context f2 = com.anythink.core.common.b.o.a().f();
                        com.anythink.expressad.foundation.g.d.b.a(f2).a(cVar.aE(), new com.anythink.expressad.video.dynview.ordercamp.a.a.AnonymousClass2(f2));
                    } catch (java.lang.Exception e2) {
                        e2.getMessage();
                    }
                }
                if (this.c.h != null) {
                    try {
                        this.c.h.setText(com.anythink.core.common.b.o.a().f().getResources().getString(com.anythink.core.common.b.o.a().f().getResources().getIdentifier("anythink_reward_viewed_text_str", com.anythink.expressad.foundation.h.i.g, com.anythink.core.common.b.o.a().f().getPackageName())));
                        this.c.h.setVisibility(0);
                    } catch (java.lang.Exception e3) {
                        e3.getMessage();
                    }
                }
            }
        } catch (java.lang.Exception e4) {
            e4.getMessage();
        }
        return view;
    }
}
