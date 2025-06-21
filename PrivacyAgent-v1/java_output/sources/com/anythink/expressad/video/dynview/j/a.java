package com.anythink.expressad.video.dynview.j;

/* loaded from: classes12.dex */
public final class a {
    public static final java.lang.String a = "DataEnergizeWrapper";
    private static boolean k;
    private com.anythink.expressad.video.dynview.i.c.b c;
    private java.util.Map<java.lang.String, android.graphics.Bitmap> d;
    private volatile boolean e;
    private java.lang.String f = "#FFFFFFFF";
    private java.lang.String g = "#60000000";
    private java.lang.String h = "#FF5F5F5F";
    private java.lang.String i = "#90ECECEC";
    private volatile long j = 0;
    private com.anythink.expressad.video.dynview.i.c.a l = null;
    private boolean m = false;
    private int n = 0;
    public com.anythink.expressad.video.dynview.e.a b = new com.anythink.expressad.video.dynview.j.a.AnonymousClass1();

    /* renamed from: com.anythink.expressad.video.dynview.j.a$1, reason: invalid class name */
    public class AnonymousClass1 implements com.anythink.expressad.video.dynview.e.a {
        public AnonymousClass1() {
        }

        @Override // com.anythink.expressad.video.dynview.e.a
        public final void a() {
            if (!com.anythink.expressad.video.dynview.j.a.this.m || com.anythink.expressad.video.dynview.j.a.this.c == null) {
                return;
            }
            com.anythink.expressad.video.dynview.j.a.this.c.a(com.anythink.expressad.video.dynview.j.a.this.n * 1000, com.anythink.expressad.video.dynview.j.a.this.l);
            com.anythink.expressad.video.dynview.j.a.this.m = false;
        }

        @Override // com.anythink.expressad.video.dynview.e.a
        public final void b() {
        }

        @Override // com.anythink.expressad.video.dynview.e.a
        public final void c() {
            if (com.anythink.expressad.video.dynview.j.a.this.c != null) {
                com.anythink.expressad.video.dynview.j.a.this.c.c();
                com.anythink.expressad.video.dynview.j.a.this.m = true;
            }
        }
    }

    /* renamed from: com.anythink.expressad.video.dynview.j.a$10, reason: invalid class name */
    public class AnonymousClass10 implements com.anythink.expressad.foundation.g.d.c {
        final /* synthetic */ int a;
        final /* synthetic */ android.widget.ImageView b;

        public AnonymousClass10(int i, android.widget.ImageView imageView) {
            this.a = i;
            this.b = imageView;
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(android.graphics.Bitmap bitmap, java.lang.String str) {
            if (bitmap == null || bitmap.isRecycled()) {
                int a = com.anythink.expressad.foundation.h.i.a(this.b.getContext(), "anythink_icon_play_bg", com.anythink.expressad.foundation.h.i.c);
                this.b.setBackgroundColor(android.graphics.Color.parseColor(com.anythink.expressad.video.dynview.j.a.this.h));
                this.b.setImageResource(a);
                this.b.setScaleType(android.widget.ImageView.ScaleType.CENTER);
                return;
            }
            int i = this.a;
            if (i != 501 && i != 802) {
                this.b.setImageBitmap(bitmap);
                return;
            }
            android.widget.ImageView imageView = this.b;
            com.anythink.expressad.video.dynview.i.b.a();
            imageView.setImageBitmap(com.anythink.expressad.video.dynview.i.b.a(bitmap, 0));
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(java.lang.String str, java.lang.String str2) {
            try {
                int a = com.anythink.expressad.foundation.h.i.a(this.b.getContext(), "anythink_icon_play_bg", com.anythink.expressad.foundation.h.i.c);
                this.b.setBackgroundColor(android.graphics.Color.parseColor(com.anythink.expressad.video.dynview.j.a.this.h));
                this.b.setImageResource(a);
                this.b.setScaleType(android.widget.ImageView.ScaleType.CENTER);
            } catch (java.lang.Exception e) {
                e.getMessage();
            }
        }
    }

    /* renamed from: com.anythink.expressad.video.dynview.j.a$2, reason: invalid class name */
    public class AnonymousClass2 implements com.anythink.expressad.foundation.g.d.c {
        final /* synthetic */ android.widget.ImageView a;
        final /* synthetic */ java.lang.String b;
        final /* synthetic */ com.anythink.expressad.video.dynview.c c;
        final /* synthetic */ android.view.View d;

        public AnonymousClass2(android.widget.ImageView imageView, java.lang.String str, com.anythink.expressad.video.dynview.c cVar, android.view.View view) {
            this.a = imageView;
            this.b = str;
            this.c = cVar;
            this.d = view;
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(android.graphics.Bitmap bitmap, java.lang.String str) {
            android.widget.ImageView imageView;
            if (bitmap == null || bitmap.isRecycled() || (imageView = this.a) == null) {
                return;
            }
            imageView.setImageBitmap(bitmap);
            if (com.anythink.expressad.video.dynview.j.a.this.d != null) {
                com.anythink.expressad.video.dynview.j.a.this.d.put(com.anythink.expressad.foundation.h.p.a(this.b), bitmap);
                com.anythink.expressad.video.dynview.j.a.a(com.anythink.expressad.video.dynview.j.a.this, this.c, this.d);
            }
        }

        @Override // com.anythink.expressad.foundation.g.d.c
        public final void a(java.lang.String str, java.lang.String str2) {
        }
    }

    /* renamed from: com.anythink.expressad.video.dynview.j.a$3, reason: invalid class name */
    public class AnonymousClass3 extends com.anythink.expressad.widget.a {
        final /* synthetic */ java.util.Map a;
        final /* synthetic */ java.util.List b;

        public AnonymousClass3(java.util.Map map, java.util.List list) {
            this.a = map;
            this.b = list;
        }

        @Override // com.anythink.expressad.widget.a
        public final void a(android.view.View view) {
            if (com.anythink.expressad.video.dynview.j.a.this.e) {
                return;
            }
            com.anythink.expressad.video.dynview.j.a.f(com.anythink.expressad.video.dynview.j.a.this);
            com.anythink.expressad.video.dynview.j.a.a(com.anythink.expressad.video.dynview.j.a.this, this.a, this.b, 0);
        }
    }

    /* renamed from: com.anythink.expressad.video.dynview.j.a$4, reason: invalid class name */
    public class AnonymousClass4 extends com.anythink.expressad.widget.a {
        final /* synthetic */ java.util.Map a;
        final /* synthetic */ java.util.List b;

        public AnonymousClass4(java.util.Map map, java.util.List list) {
            this.a = map;
            this.b = list;
        }

        @Override // com.anythink.expressad.widget.a
        public final void a(android.view.View view) {
            if (com.anythink.expressad.video.dynview.j.a.this.e) {
                return;
            }
            com.anythink.expressad.video.dynview.j.a.f(com.anythink.expressad.video.dynview.j.a.this);
            com.anythink.expressad.video.dynview.j.a.a(com.anythink.expressad.video.dynview.j.a.this, this.a, this.b, 1);
        }
    }

    /* renamed from: com.anythink.expressad.video.dynview.j.a$5, reason: invalid class name */
    public class AnonymousClass5 extends com.anythink.expressad.widget.a {
        final /* synthetic */ java.util.Map a;

        public AnonymousClass5(java.util.Map map) {
            this.a = map;
        }

        @Override // com.anythink.expressad.widget.a
        public final void a(android.view.View view) {
            if (com.anythink.expressad.video.dynview.j.a.this.e) {
                return;
            }
            com.anythink.expressad.video.dynview.j.a.f(com.anythink.expressad.video.dynview.j.a.this);
            com.anythink.expressad.video.dynview.j.a.a(com.anythink.expressad.video.dynview.j.a.this, this.a);
        }
    }

    /* renamed from: com.anythink.expressad.video.dynview.j.a$6, reason: invalid class name */
    public class AnonymousClass6 implements com.anythink.expressad.video.dynview.i.c.a {
        final /* synthetic */ android.widget.TextView a;
        final /* synthetic */ java.util.Map b;

        public AnonymousClass6(android.widget.TextView textView, java.util.Map map) {
            this.a = textView;
            this.b = map;
        }

        @Override // com.anythink.expressad.video.dynview.i.c.a
        public final void a() {
            com.anythink.expressad.video.dynview.j.a.a(com.anythink.expressad.video.dynview.j.a.this, this.b);
        }

        @Override // com.anythink.expressad.video.dynview.i.c.a
        public final void a(long j) {
            java.lang.String str;
            com.anythink.expressad.video.dynview.j.a.this.n = (int) (j / 1000);
            long j2 = com.anythink.expressad.video.dynview.j.a.this.n;
            android.content.Context context = this.a.getContext();
            java.lang.String f = com.anythink.core.common.o.e.f(context);
            if (f.startsWith(com.anythink.expressad.video.dynview.a.a.Q) || f.startsWith(com.anythink.expressad.video.dynview.a.a.R)) {
                str = j2 + " " + context.getString(com.anythink.expressad.foundation.h.i.a(context, "anythink_cm_video_auto_play_after", com.anythink.expressad.foundation.h.i.g));
            } else if (f.startsWith(com.anythink.expressad.video.dynview.a.a.S)) {
                str = com.anythink.expressad.video.dynview.a.a.G + j2 + " Sekunden";
            } else if (f.startsWith(com.anythink.expressad.video.dynview.a.a.T)) {
                str = j2 + com.anythink.expressad.video.dynview.a.a.H;
            } else if (f.startsWith(com.anythink.expressad.video.dynview.a.a.U)) {
                str = com.anythink.expressad.video.dynview.a.a.I + j2 + " secondes";
            } else if (f.startsWith(com.anythink.expressad.video.dynview.a.a.V)) {
                str = " ثوان" + j2 + com.anythink.expressad.video.dynview.a.a.J;
            } else if (f.startsWith(com.anythink.expressad.video.dynview.a.a.W)) {
                str = com.anythink.expressad.video.dynview.a.a.K + j2 + " секунд";
            } else {
                str = com.anythink.expressad.video.dynview.a.a.F + j2 + " s";
            }
            this.a.setText(str);
            com.anythink.expressad.video.dynview.j.a.this.j++;
        }
    }

    /* renamed from: com.anythink.expressad.video.dynview.j.a$7, reason: invalid class name */
    public class AnonymousClass7 implements android.widget.AdapterView.OnItemClickListener {
        final /* synthetic */ java.util.Map a;
        final /* synthetic */ java.util.List b;

        public AnonymousClass7(java.util.Map map, java.util.List list) {
            this.a = map;
            this.b = list;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onItemClick(android.widget.AdapterView<?> adapterView, android.view.View view, int i, long j) {
            com.anythink.expressad.video.dynview.j.a.a(com.anythink.expressad.video.dynview.j.a.this, this.a, this.b, i);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackListView(adapterView, view, i);
        }
    }

    /* renamed from: com.anythink.expressad.video.dynview.j.a$8, reason: invalid class name */
    public class AnonymousClass8 implements android.widget.AdapterView.OnItemClickListener {
        final /* synthetic */ java.util.Map a;
        final /* synthetic */ java.util.List b;

        public AnonymousClass8(java.util.Map map, java.util.List list) {
            this.a = map;
            this.b = list;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onItemClick(android.widget.AdapterView<?> adapterView, android.view.View view, int i, long j) {
            com.anythink.expressad.video.dynview.j.a.a(com.anythink.expressad.video.dynview.j.a.this, this.a, this.b, i);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackListView(adapterView, view, i);
        }
    }

    /* renamed from: com.anythink.expressad.video.dynview.j.a$9, reason: invalid class name */
    public class AnonymousClass9 implements android.view.View.OnClickListener {
        final /* synthetic */ java.util.Map a;

        public AnonymousClass9(java.util.Map map) {
            this.a = map;
        }

        @Override // android.view.View.OnClickListener
        @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
        public final void onClick(android.view.View view) {
            com.anythink.expressad.video.dynview.j.a.b(com.anythink.expressad.video.dynview.j.a.this, this.a);
            com.sensorsdata.analytics.android.autotrack.aop.SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    private static int a(java.lang.String str) {
        return com.anythink.expressad.foundation.h.i.a(com.anythink.core.common.b.o.a().f(), str, "id");
    }

    private android.graphics.Bitmap a() {
        android.graphics.Bitmap bitmap = null;
        try {
            bitmap = android.graphics.Bitmap.createBitmap(1, 1, android.graphics.Bitmap.Config.ARGB_4444);
            bitmap.eraseColor(android.graphics.Color.parseColor(this.i));
            return bitmap;
        } catch (java.lang.Exception e) {
            if (!com.anythink.expressad.a.a) {
                return bitmap;
            }
            e.printStackTrace();
            return bitmap;
        }
    }

    private void a(android.widget.ImageView imageView, java.lang.String str, int i) {
        if (android.text.TextUtils.isEmpty(str) || imageView == null) {
            return;
        }
        com.anythink.expressad.foundation.g.d.b.a(imageView.getContext()).a(str, new com.anythink.expressad.video.dynview.j.a.AnonymousClass10(i, imageView));
    }

    private void a(com.anythink.expressad.video.dynview.c cVar, android.view.View view) {
        java.util.Map<java.lang.String, android.graphics.Bitmap> map = this.d;
        if (map == null || map.size() <= 1) {
            return;
        }
        new com.anythink.expressad.video.dynview.h.b();
        java.util.Map<java.lang.String, android.graphics.Bitmap> map2 = this.d;
        if (view != null) {
            com.anythink.expressad.video.dynview.i.a.a.a().a(map2, cVar, view);
        }
    }

    public static /* synthetic */ void a(com.anythink.expressad.video.dynview.j.a aVar, com.anythink.expressad.video.dynview.c cVar, android.view.View view) {
        java.util.Map<java.lang.String, android.graphics.Bitmap> map = aVar.d;
        if (map == null || map.size() <= 1) {
            return;
        }
        new com.anythink.expressad.video.dynview.h.b();
        java.util.Map<java.lang.String, android.graphics.Bitmap> map2 = aVar.d;
        if (view != null) {
            com.anythink.expressad.video.dynview.i.a.a.a().a(map2, cVar, view);
        }
    }

    public static /* synthetic */ void a(com.anythink.expressad.video.dynview.j.a aVar, java.util.Map map) {
        if (map != null) {
            try {
                if (map.containsKey(com.anythink.expressad.video.dynview.a.a.D) && (map.get(com.anythink.expressad.video.dynview.a.a.D) instanceof com.anythink.expressad.video.dynview.f.d)) {
                    ((com.anythink.expressad.video.dynview.f.d) map.get(com.anythink.expressad.video.dynview.a.a.D)).a();
                    aVar.b();
                }
            } catch (java.lang.Exception e) {
                e.getMessage();
            }
        }
    }

    public static /* synthetic */ void a(com.anythink.expressad.video.dynview.j.a aVar, java.util.Map map, java.util.List list, int i) {
        if (map == null || list == null || list.size() <= 1) {
            return;
        }
        if (map.containsKey(com.anythink.expressad.video.dynview.a.a.D) && (map.get(com.anythink.expressad.video.dynview.a.a.D) instanceof com.anythink.expressad.video.dynview.f.d)) {
            com.anythink.expressad.video.dynview.f.d dVar = (com.anythink.expressad.video.dynview.f.d) map.get(com.anythink.expressad.video.dynview.a.a.D);
            if (dVar != null) {
                dVar.a((com.anythink.expressad.foundation.d.c) list.get(i));
            }
            aVar.b();
            return;
        }
        if (map.containsKey(com.anythink.expressad.video.dynview.a.a.E) && (map.get(com.anythink.expressad.video.dynview.a.a.E) instanceof com.anythink.expressad.video.dynview.f.c)) {
            com.anythink.expressad.video.dynview.f.c cVar = (com.anythink.expressad.video.dynview.f.c) map.get(com.anythink.expressad.video.dynview.a.a.E);
            if (cVar != null) {
                cVar.a((com.anythink.expressad.foundation.d.c) list.get(i), i);
            }
            aVar.b();
        }
    }

    private void a(java.lang.String str, android.content.Context context, android.view.View view, int i, java.util.Map map) {
        android.widget.FrameLayout.LayoutParams layoutParams;
        java.lang.String a2 = com.anythink.expressad.foundation.h.x.a(str, "cltp");
        long parseLong = !android.text.TextUtils.isEmpty(a2) ? java.lang.Long.parseLong(a2) : 0L;
        if (parseLong != 0) {
            if (map != null && map.containsKey("is_dy_success")) {
                k = ((java.lang.Boolean) map.get("is_dy_success")).booleanValue();
            }
            k = false;
            android.widget.TextView textView = (android.widget.TextView) view.findViewById(a("anythink_choice_one_countdown_tv"));
            textView.setTextSize(11.0f);
            textView.setTextColor(android.graphics.Color.parseColor(this.f));
            java.lang.String str2 = this.g;
            android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
            gradientDrawable.setColor(android.graphics.Color.parseColor(str2));
            gradientDrawable.setCornerRadius(com.anythink.expressad.foundation.h.t.b(textView.getContext(), 12.0f));
            gradientDrawable.setStroke(com.anythink.expressad.foundation.h.t.b(textView.getContext(), 1.0f), android.graphics.Color.parseColor(str2));
            textView.setBackgroundDrawable(gradientDrawable);
            if (i == 2 && (layoutParams = (android.widget.FrameLayout.LayoutParams) textView.getLayoutParams()) != null) {
                int d = com.anythink.expressad.foundation.h.t.d(context);
                int b = com.anythink.expressad.foundation.h.t.b(context, 10.0f);
                layoutParams.setMargins(b, b, d, b);
            }
            textView.setVisibility(0);
            textView.setOnClickListener(new com.anythink.expressad.video.dynview.j.a.AnonymousClass5(map));
            this.l = new com.anythink.expressad.video.dynview.j.a.AnonymousClass6(textView, map);
            com.anythink.expressad.video.dynview.i.c.b a3 = new com.anythink.expressad.video.dynview.i.c.b().a(parseLong * 1000).a().a(this.l);
            this.c = a3;
            a3.b();
        }
    }

    private void a(java.lang.String str, android.widget.ImageView imageView) {
        if (android.text.TextUtils.isEmpty(str) || imageView == null) {
            return;
        }
        a(imageView, str, -1);
    }

    private void a(java.lang.String str, android.widget.ImageView imageView, com.anythink.expressad.video.dynview.c cVar, android.view.View view) {
        com.anythink.expressad.foundation.g.d.b.a(imageView.getContext()).a(str, new com.anythink.expressad.video.dynview.j.a.AnonymousClass2(imageView, str, cVar, view));
        if (a() != null) {
            b(cVar, view);
        }
    }

    private void a(java.util.Map map) {
        if (map != null) {
            try {
                if (map.containsKey(com.anythink.expressad.video.dynview.a.a.D) && (map.get(com.anythink.expressad.video.dynview.a.a.D) instanceof com.anythink.expressad.video.dynview.f.d)) {
                    ((com.anythink.expressad.video.dynview.f.d) map.get(com.anythink.expressad.video.dynview.a.a.D)).a();
                    b();
                }
            } catch (java.lang.Exception e) {
                e.getMessage();
            }
        }
    }

    private void a(java.util.Map map, java.util.List<com.anythink.expressad.foundation.d.c> list, int i) {
        if (map == null || list == null || list.size() <= 1) {
            return;
        }
        if (map.containsKey(com.anythink.expressad.video.dynview.a.a.D) && (map.get(com.anythink.expressad.video.dynview.a.a.D) instanceof com.anythink.expressad.video.dynview.f.d)) {
            com.anythink.expressad.video.dynview.f.d dVar = (com.anythink.expressad.video.dynview.f.d) map.get(com.anythink.expressad.video.dynview.a.a.D);
            if (dVar != null) {
                dVar.a(list.get(i));
            }
            b();
            return;
        }
        if (map.containsKey(com.anythink.expressad.video.dynview.a.a.E) && (map.get(com.anythink.expressad.video.dynview.a.a.E) instanceof com.anythink.expressad.video.dynview.f.c)) {
            com.anythink.expressad.video.dynview.f.c cVar = (com.anythink.expressad.video.dynview.f.c) map.get(com.anythink.expressad.video.dynview.a.a.E);
            if (cVar != null) {
                cVar.a(list.get(i), i);
            }
            b();
        }
    }

    private static int b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return -1;
        }
        return str.hashCode();
    }

    private void b() {
        com.anythink.expressad.video.dynview.i.a.a.a().b();
        com.anythink.expressad.video.dynview.i.c.b bVar = this.c;
        if (bVar != null) {
            bVar.c();
            this.c = null;
        }
        com.anythink.expressad.video.dynview.b.a.a().a = null;
        if (this.b != null) {
            this.b = null;
        }
        java.util.Map<java.lang.String, android.graphics.Bitmap> map = this.d;
        if (map != null) {
            if (map.entrySet() != null) {
                try {
                    java.util.Iterator<java.util.Map.Entry<java.lang.String, android.graphics.Bitmap>> it = this.d.entrySet().iterator();
                    while (it.hasNext()) {
                        java.util.Map.Entry<java.lang.String, android.graphics.Bitmap> next = it.next();
                        if (next != null && next.getValue() != null && !next.getValue().isRecycled()) {
                            next.getValue().recycle();
                        }
                        it.remove();
                    }
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            }
            this.d.clear();
        }
    }

    private static void b(com.anythink.expressad.video.dynview.c cVar, android.view.View view) {
        com.anythink.expressad.video.dynview.g.a.C0228a a2 = com.anythink.expressad.video.dynview.g.a.a();
        a2.a(cVar.e()).a();
        if (cVar.e() != 2) {
            a2.a(cVar.d()).b(cVar.c());
        } else if (cVar.d() > cVar.c()) {
            a2.a(cVar.d()).b(cVar.c());
        } else {
            a2.a(cVar.c()).b(cVar.d());
        }
        if (view.getBackground() == null) {
            view.setBackgroundDrawable(a2.b());
        }
    }

    public static /* synthetic */ void b(com.anythink.expressad.video.dynview.j.a aVar, java.util.Map map) {
        if (map != null) {
            try {
                if (map.containsKey(com.anythink.expressad.video.dynview.a.a.E) && (map.get(com.anythink.expressad.video.dynview.a.a.E) instanceof com.anythink.expressad.video.dynview.f.c)) {
                    ((com.anythink.expressad.video.dynview.f.c) map.get(com.anythink.expressad.video.dynview.a.a.E)).a();
                    aVar.b();
                }
            } catch (java.lang.Exception e) {
                e.getMessage();
            }
        }
    }

    private void b(java.util.Map map) {
        if (map != null) {
            try {
                if (map.containsKey(com.anythink.expressad.video.dynview.a.a.E) && (map.get(com.anythink.expressad.video.dynview.a.a.E) instanceof com.anythink.expressad.video.dynview.f.c)) {
                    ((com.anythink.expressad.video.dynview.f.c) map.get(com.anythink.expressad.video.dynview.a.a.E)).a();
                    b();
                }
            } catch (java.lang.Exception e) {
                e.getMessage();
            }
        }
    }

    public static /* synthetic */ boolean f(com.anythink.expressad.video.dynview.j.a aVar) {
        aVar.e = true;
        return true;
    }

    public final void a(com.anythink.expressad.video.dynview.c cVar, android.view.View view, com.anythink.expressad.video.dynview.f.e eVar) {
        if (eVar == null) {
            return;
        }
        if (cVar == null) {
            eVar.a(com.anythink.expressad.video.dynview.c.b.NOT_FOUND_VIEWOPTION);
            return;
        }
        try {
            android.widget.ImageView imageView = (android.widget.ImageView) view.findViewById(a("anythink_iv_adbanner_bg"));
            if (imageView != null) {
                imageView.setBackgroundColor(android.graphics.Color.parseColor(this.i));
            }
            android.widget.ImageView imageView2 = (android.widget.ImageView) view.findViewById(a("anythink_iv_adbanner"));
            if (imageView2 != null) {
                imageView2.setBackgroundColor(android.graphics.Color.parseColor(this.i));
            }
            eVar.a(view, new java.util.ArrayList());
        } catch (java.lang.Exception e) {
            e.getMessage();
            eVar.a(com.anythink.expressad.video.dynview.c.b.NOT_FOUND_VIEWOPTION);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0281  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(com.anythink.expressad.video.dynview.c cVar, android.view.View view, java.util.Map map, com.anythink.expressad.video.dynview.f.e eVar) {
        com.anythink.expressad.foundation.d.c cVar2;
        com.anythink.expressad.foundation.d.c cVar3;
        android.widget.TextView textView;
        com.anythink.expressad.videocommon.view.RoundImageView roundImageView;
        android.widget.TextView textView2;
        int i;
        com.anythink.expressad.videocommon.view.RoundImageView roundImageView2;
        android.widget.TextView textView3;
        int i2;
        com.anythink.expressad.videocommon.view.RoundImageView roundImageView3;
        android.widget.TextView textView4;
        long parseLong;
        android.widget.FrameLayout.LayoutParams layoutParams;
        if (this.d == null) {
            this.d = new java.util.HashMap();
        }
        java.util.List<com.anythink.expressad.foundation.d.c> g = cVar.g();
        if (view == null) {
            eVar.a(com.anythink.expressad.video.dynview.c.b.NOT_FOUND_ROOTVIEW);
            return;
        }
        android.content.Context context = view.getContext();
        if (context == null) {
            eVar.a(com.anythink.expressad.video.dynview.c.b.NOT_FOUND_CONTEXT);
            return;
        }
        if (g == null || g.size() <= 1) {
            cVar2 = null;
            cVar3 = null;
        } else {
            cVar2 = g.get(0);
            cVar3 = g.get(1);
        }
        if (cVar2 == null && eVar != null) {
            eVar.a(com.anythink.expressad.video.dynview.c.b.CAMPAIGNEX_IS_NULL);
            return;
        }
        if (cVar3 == null && eVar != null) {
            eVar.a(com.anythink.expressad.video.dynview.c.b.CAMPAIGNEX_IS_NULL);
            return;
        }
        k = false;
        android.widget.RelativeLayout relativeLayout = (android.widget.RelativeLayout) view.findViewById(a("anythink_top_item_rl"));
        com.anythink.expressad.video.dynview.widget.ATImageView aTImageView = (com.anythink.expressad.video.dynview.widget.ATImageView) view.findViewById(a("anythink_top_iv"));
        com.anythink.expressad.video.dynview.widget.ATRotationView aTRotationView = (com.anythink.expressad.video.dynview.widget.ATRotationView) view.findViewById(a("anythink_top_ration"));
        view.findViewById(a("anythink_top_icon_iv"));
        android.widget.TextView textView5 = (android.widget.TextView) view.findViewById(a("anythink_top_title_tv"));
        android.widget.RelativeLayout relativeLayout2 = (android.widget.RelativeLayout) view.findViewById(a("anythink_bottom_item_rl"));
        com.anythink.expressad.video.dynview.widget.ATRotationView aTRotationView2 = (com.anythink.expressad.video.dynview.widget.ATRotationView) view.findViewById(a("anythink_bottom_ration"));
        com.anythink.expressad.video.dynview.widget.ATImageView aTImageView2 = (com.anythink.expressad.video.dynview.widget.ATImageView) view.findViewById(a("anythink_bottom_iv"));
        com.anythink.expressad.videocommon.view.RoundImageView roundImageView4 = (com.anythink.expressad.videocommon.view.RoundImageView) view.findViewById(a("anythink_bottom_icon_iv"));
        android.widget.TextView textView6 = (android.widget.TextView) view.findViewById(a("anythink_bottom_title_tv"));
        view.findViewById(a("anythink_reward_choice_one_like_iv"));
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new com.anythink.expressad.video.dynview.j.a.AnonymousClass3(map, g));
        }
        if (aTImageView != null) {
            textView = textView5;
            roundImageView = roundImageView4;
            textView2 = textView6;
            aTImageView.setCustomBorder(20, 20, 0, 0, 10, androidx.core.view.ViewCompat.MEASURED_STATE_MASK);
            a(cVar2.be(), aTImageView, cVar, view);
            if (aTRotationView != null) {
                if (!cVar2.aD()) {
                    i = 0;
                    aTRotationView.setWidthRatio(1.0f);
                    aTRotationView.setHeightRatio(1.0f);
                    aTRotationView.setAutoscroll(false);
                } else if (android.text.TextUtils.isEmpty(cVar2.bd())) {
                    aTRotationView.setWidthRatio(1.0f);
                    aTRotationView.setHeightRatio(1.0f);
                    i = 0;
                    aTRotationView.setAutoscroll(false);
                } else {
                    android.widget.ImageView imageView = new android.widget.ImageView(cVar.a());
                    imageView.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, com.anythink.expressad.foundation.h.t.b(cVar.a(), 200.0f)));
                    imageView.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
                    aTRotationView.addView(imageView);
                    a(cVar2.bd(), imageView);
                    aTRotationView.setWidthRatio(0.45f);
                    aTRotationView.setHeightRatio(0.9f);
                    aTRotationView.setAutoscroll(true);
                }
                roundImageView2 = (com.anythink.expressad.videocommon.view.RoundImageView) view.findViewById(a("anythink_top_icon_iv"));
                if (roundImageView2 != null) {
                    roundImageView2.setType(i);
                    a(cVar2.bd(), roundImageView2);
                }
                textView3 = textView;
                if (textView3 != null) {
                    if (android.text.TextUtils.isEmpty(cVar2.bb())) {
                        textView3.setVisibility(8);
                    } else {
                        textView3.setText(cVar2.bb());
                    }
                }
                if (relativeLayout2 != null) {
                    relativeLayout2.setOnClickListener(new com.anythink.expressad.video.dynview.j.a.AnonymousClass4(map, g));
                }
                if (aTImageView2 != null) {
                    aTImageView2.setCustomBorder(20, 20, 0, 0, 10, androidx.core.view.ViewCompat.MEASURED_STATE_MASK);
                    a(cVar3.be(), aTImageView2, cVar, view);
                    if (aTRotationView2 != null) {
                        if (!cVar3.aD()) {
                            i2 = 0;
                            aTRotationView2.setWidthRatio(1.0f);
                            aTRotationView2.setHeightRatio(1.0f);
                            aTRotationView2.setAutoscroll(false);
                        } else {
                            if (!android.text.TextUtils.isEmpty(cVar3.bd())) {
                                android.widget.ImageView imageView2 = new android.widget.ImageView(cVar.a());
                                imageView2.setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, com.anythink.expressad.foundation.h.t.b(cVar.a(), 200.0f)));
                                imageView2.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
                                aTRotationView2.addView(imageView2);
                                a(cVar3.bd(), imageView2);
                                aTRotationView2.setWidthRatio(0.45f);
                                aTRotationView2.setHeightRatio(0.9f);
                                aTRotationView2.setAutoscroll(true);
                                roundImageView3 = roundImageView;
                                i2 = 0;
                                if (roundImageView3 != null) {
                                    roundImageView3.setType(i2);
                                    a(cVar3.bd(), roundImageView3);
                                }
                                textView4 = textView2;
                                if (textView4 != null) {
                                    textView4.setText(cVar3.bb());
                                }
                                java.lang.String ar = cVar2.ar();
                                int e = cVar.e();
                                java.lang.String a2 = com.anythink.expressad.foundation.h.x.a(ar, "cltp");
                                parseLong = android.text.TextUtils.isEmpty(a2) ? java.lang.Long.parseLong(a2) : 0L;
                                if (parseLong != 0) {
                                    if (map != null && map.containsKey("is_dy_success")) {
                                        k = ((java.lang.Boolean) map.get("is_dy_success")).booleanValue();
                                    }
                                    k = false;
                                    android.widget.TextView textView7 = (android.widget.TextView) view.findViewById(a("anythink_choice_one_countdown_tv"));
                                    textView7.setTextSize(11.0f);
                                    textView7.setTextColor(android.graphics.Color.parseColor(this.f));
                                    java.lang.String str = this.g;
                                    android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
                                    gradientDrawable.setColor(android.graphics.Color.parseColor(str));
                                    gradientDrawable.setCornerRadius(com.anythink.expressad.foundation.h.t.b(textView7.getContext(), 12.0f));
                                    gradientDrawable.setStroke(com.anythink.expressad.foundation.h.t.b(textView7.getContext(), 1.0f), android.graphics.Color.parseColor(str));
                                    textView7.setBackgroundDrawable(gradientDrawable);
                                    if (e == 2 && (layoutParams = (android.widget.FrameLayout.LayoutParams) textView7.getLayoutParams()) != null) {
                                        int d = com.anythink.expressad.foundation.h.t.d(context);
                                        int b = com.anythink.expressad.foundation.h.t.b(context, 10.0f);
                                        layoutParams.setMargins(b, b, d, b);
                                    }
                                    textView7.setVisibility(0);
                                    textView7.setOnClickListener(new com.anythink.expressad.video.dynview.j.a.AnonymousClass5(map));
                                    this.l = new com.anythink.expressad.video.dynview.j.a.AnonymousClass6(textView7, map);
                                    com.anythink.expressad.video.dynview.i.c.b a3 = new com.anythink.expressad.video.dynview.i.c.b().a(parseLong * 1000).a().a(this.l);
                                    this.c = a3;
                                    a3.b();
                                }
                                if (eVar == null) {
                                    eVar.a(view, null);
                                    return;
                                }
                                return;
                            }
                            aTRotationView2.setWidthRatio(1.0f);
                            aTRotationView2.setHeightRatio(1.0f);
                            i2 = 0;
                            aTRotationView2.setAutoscroll(false);
                        }
                        roundImageView3 = roundImageView;
                        if (roundImageView3 != null) {
                        }
                        textView4 = textView2;
                        if (textView4 != null) {
                        }
                        java.lang.String ar2 = cVar2.ar();
                        int e2 = cVar.e();
                        java.lang.String a22 = com.anythink.expressad.foundation.h.x.a(ar2, "cltp");
                        if (android.text.TextUtils.isEmpty(a22)) {
                        }
                        if (parseLong != 0) {
                        }
                        if (eVar == null) {
                        }
                    }
                }
                i2 = 0;
                roundImageView3 = roundImageView;
                if (roundImageView3 != null) {
                }
                textView4 = textView2;
                if (textView4 != null) {
                }
                java.lang.String ar22 = cVar2.ar();
                int e22 = cVar.e();
                java.lang.String a222 = com.anythink.expressad.foundation.h.x.a(ar22, "cltp");
                if (android.text.TextUtils.isEmpty(a222)) {
                }
                if (parseLong != 0) {
                }
                if (eVar == null) {
                }
            }
        } else {
            textView = textView5;
            roundImageView = roundImageView4;
            textView2 = textView6;
        }
        i = 0;
        roundImageView2 = (com.anythink.expressad.videocommon.view.RoundImageView) view.findViewById(a("anythink_top_icon_iv"));
        if (roundImageView2 != null) {
        }
        textView3 = textView;
        if (textView3 != null) {
        }
        if (relativeLayout2 != null) {
        }
        if (aTImageView2 != null) {
        }
        i2 = 0;
        roundImageView3 = roundImageView;
        if (roundImageView3 != null) {
        }
        textView4 = textView2;
        if (textView4 != null) {
        }
        java.lang.String ar222 = cVar2.ar();
        int e222 = cVar.e();
        java.lang.String a2222 = com.anythink.expressad.foundation.h.x.a(ar222, "cltp");
        if (android.text.TextUtils.isEmpty(a2222)) {
        }
        if (parseLong != 0) {
        }
        if (eVar == null) {
        }
    }

    public final void b(com.anythink.expressad.video.dynview.c cVar, android.view.View view, java.util.Map map, com.anythink.expressad.video.dynview.f.e eVar) {
        if (eVar == null) {
            return;
        }
        if (cVar == null) {
            eVar.a(com.anythink.expressad.video.dynview.c.b.NOT_FOUND_VIEWOPTION);
            return;
        }
        if (map != null && map.containsKey("is_dy_success")) {
            k = ((java.lang.Boolean) map.get("is_dy_success")).booleanValue();
        }
        k = false;
        android.widget.ImageView imageView = (android.widget.ImageView) view.findViewById(a("anythink_reward_icon_riv"));
        android.widget.TextView textView = (android.widget.TextView) view.findViewById(a("anythink_reward_title_tv"));
        android.widget.LinearLayout linearLayout = (android.widget.LinearLayout) view.findViewById(a("anythink_reward_stars_mllv"));
        android.widget.TextView textView2 = (android.widget.TextView) view.findViewById(a("anythink_reward_click_tv"));
        android.widget.ImageView imageView2 = (android.widget.ImageView) view.findViewById(a("anythink_videoview_bg"));
        android.widget.TextView textView3 = (android.widget.TextView) view.findViewById(a("anythink_reward_desc_tv"));
        java.util.List<android.view.View> arrayList = new java.util.ArrayList<>();
        java.util.List<com.anythink.expressad.foundation.d.c> g = cVar.g();
        if (g == null || g.size() <= 0) {
            eVar.a(com.anythink.expressad.video.dynview.c.b.CAMPAIGNEX_IS_NULL);
            return;
        }
        com.anythink.expressad.foundation.d.c cVar2 = g.get(0);
        if (cVar2 == null) {
            eVar.a(com.anythink.expressad.video.dynview.c.b.CAMPAIGNEX_IS_NULL);
            return;
        }
        if (imageView != null) {
            ((com.anythink.expressad.videocommon.view.RoundImageView) imageView).setBorderRadius(10);
            a(cVar2.bd(), imageView);
        }
        if (textView != null) {
            textView.setText(cVar2.bb());
        }
        if (textView3 != null) {
            textView3.setText(cVar2.bc());
        }
        if (linearLayout != null) {
            double aX = cVar2.aX();
            if (aX <= 0.0d) {
                aX = 5.0d;
            }
            ((com.anythink.expressad.video.dynview.widget.ATLevelLayoutView) linearLayout).setRatingAndUser(aX, cVar2.aY());
        }
        if (textView2 != null) {
            textView2.setText(cVar2.cU);
        }
        int h = cVar.h();
        if (h == 102 || h == 202 || h == 302) {
            if (textView2 != null) {
                arrayList.add(textView2);
            }
        } else if (h == 802) {
            if (imageView != null) {
                arrayList.add(imageView);
            }
            if (textView2 != null) {
                arrayList.add(textView2);
            }
            a(imageView2, cVar2.be(), h);
        } else if (h == 904 && cVar.k()) {
            arrayList.add(view);
        }
        eVar.a(view, arrayList);
    }

    public final void c(com.anythink.expressad.video.dynview.c cVar, android.view.View view, java.util.Map map, com.anythink.expressad.video.dynview.f.e eVar) {
        try {
            if (this.d == null) {
                this.d = new java.util.HashMap();
            }
            java.util.List<com.anythink.expressad.foundation.d.c> g = cVar.g();
            if (view.getContext() == null) {
                eVar.a(com.anythink.expressad.video.dynview.c.b.NOT_FOUND_CONTEXT);
                return;
            }
            if (map != null && map.containsKey("is_dy_success")) {
                k = ((java.lang.Boolean) map.get("is_dy_success")).booleanValue();
            }
            k = false;
            android.widget.ListView listView = (android.widget.ListView) view.findViewById(a("anythink_order_view_lv"));
            android.widget.GridView gridView = (android.widget.GridView) view.findViewById(a("anythink_order_view_h_lv"));
            android.widget.ImageView imageView = (android.widget.ImageView) view.findViewById(a("anythink_order_view_iv_close"));
            com.anythink.expressad.video.dynview.ordercamp.a.a aVar = new com.anythink.expressad.video.dynview.ordercamp.a.a(g);
            if (cVar.e() == 1) {
                if (listView != null) {
                    listView.setAdapter((android.widget.ListAdapter) aVar);
                    listView.setOnItemClickListener(new com.anythink.expressad.video.dynview.j.a.AnonymousClass7(map, g));
                }
            } else if (gridView != null) {
                int d = (int) cVar.d();
                int size = d / g.size();
                int i = size / 9;
                int i2 = i / 2;
                android.widget.LinearLayout.LayoutParams layoutParams = (android.widget.LinearLayout.LayoutParams) gridView.getLayoutParams();
                layoutParams.width = d - (i * 2);
                gridView.setLayoutParams(layoutParams);
                gridView.setColumnWidth((size - i) - (i2 / 2));
                gridView.setHorizontalSpacing(i2);
                gridView.setStretchMode(0);
                gridView.setNumColumns(g.size());
                gridView.setAdapter((android.widget.ListAdapter) aVar);
                gridView.setOnItemClickListener(new com.anythink.expressad.video.dynview.j.a.AnonymousClass8(map, g));
            }
            if (imageView != null) {
                imageView.setOnClickListener(new com.anythink.expressad.video.dynview.j.a.AnonymousClass9(map));
            }
            if (eVar != null) {
                eVar.a(view, null);
            }
        } catch (java.lang.Exception unused) {
            if (eVar != null) {
                eVar.a(com.anythink.expressad.video.dynview.c.b.NOT_FOUND_VIEWOPTION);
            }
        }
    }
}
