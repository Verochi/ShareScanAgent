package com.igexin.push.a;

/* loaded from: classes.dex */
public final class g extends com.igexin.push.a.b {
    public static boolean a;
    private final java.lang.String b = "popupAct";
    private final java.util.ArrayList<com.igexin.push.core.i.a.f> c = new java.util.ArrayList<>();

    /* renamed from: com.igexin.push.a.g$1, reason: invalid class name */
    public class AnonymousClass1 implements com.igexin.push.a.c<com.igexin.push.core.b.l.b> {
        final /* synthetic */ java.util.concurrent.atomic.AtomicLong a;
        final /* synthetic */ android.app.Activity b;
        final /* synthetic */ com.igexin.push.extension.mod.PushTaskBean c;
        final /* synthetic */ android.content.Context d;

        public AnonymousClass1(java.util.concurrent.atomic.AtomicLong atomicLong, android.app.Activity activity, com.igexin.push.extension.mod.PushTaskBean pushTaskBean, android.content.Context context) {
            this.a = atomicLong;
            this.b = activity;
            this.c = pushTaskBean;
            this.d = context;
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private void a2(com.igexin.push.core.b.l.b bVar) {
            try {
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                if (currentTimeMillis - this.a.getAndSet(currentTimeMillis) < 350) {
                    com.igexin.c.a.c.a.b("popupAct", "repetition click");
                    return;
                }
                if (bVar.o.getAction().isClosePopup()) {
                    this.b.finish();
                }
                com.igexin.push.a.g.a(bVar, this.c, this.d);
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }

        @Override // com.igexin.push.a.c
        public final /* synthetic */ void a(com.igexin.push.core.b.l.b bVar) {
            com.igexin.push.core.b.l.b bVar2 = bVar;
            try {
                long currentTimeMillis = java.lang.System.currentTimeMillis();
                if (currentTimeMillis - this.a.getAndSet(currentTimeMillis) < 350) {
                    com.igexin.c.a.c.a.b("popupAct", "repetition click");
                    return;
                }
                if (bVar2.o.getAction().isClosePopup()) {
                    this.b.finish();
                }
                com.igexin.push.a.g.a(bVar2, this.c, this.d);
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }
    }

    /* renamed from: com.igexin.push.a.g$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ com.igexin.push.core.b.l a;
        final /* synthetic */ com.igexin.push.extension.mod.PushTaskBean b;

        public AnonymousClass2(com.igexin.push.core.b.l lVar, com.igexin.push.extension.mod.PushTaskBean pushTaskBean) {
            this.a = lVar;
            this.b = pushTaskBean;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.igexin.push.core.l a = com.igexin.push.core.l.a();
            com.igexin.sdk.message.GTPopupMessage gTPopupMessage = this.a.j;
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putInt("action", com.igexin.sdk.PushConsts.ACTION_POPUP_SHOW);
            bundle.putSerializable(com.igexin.sdk.PushConsts.KEY_POPUP_SHOW, gTPopupMessage);
            a.a(bundle);
            com.igexin.sdk.main.FeedbackImpl.getInstance().feedbackMessageAction(this.b, this.a.i, "ok");
        }
    }

    /* renamed from: com.igexin.push.a.g$3, reason: invalid class name */
    public static class AnonymousClass3 implements java.lang.Runnable {
        final /* synthetic */ com.igexin.push.core.b.l.b a;
        final /* synthetic */ com.igexin.push.extension.mod.PushTaskBean b;
        final /* synthetic */ android.content.Context c;

        public AnonymousClass3(com.igexin.push.core.b.l.b bVar, com.igexin.push.extension.mod.PushTaskBean pushTaskBean, android.content.Context context) {
            this.a = bVar;
            this.b = pushTaskBean;
            this.c = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.igexin.push.core.l a = com.igexin.push.core.l.a();
            com.igexin.sdk.message.GTPopupMessage gTPopupMessage = this.a.o;
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.setClassLoader(com.igexin.sdk.message.GTPopupMessage.class.getClassLoader());
            bundle.putInt("action", com.igexin.sdk.PushConsts.ACTION_POPUP_CLICKED);
            bundle.putSerializable(com.igexin.sdk.PushConsts.KEY_POPUP_CLICKED, gTPopupMessage);
            a.a(bundle);
            com.igexin.sdk.main.FeedbackImpl.getInstance().feedbackMessageAction(this.b, this.a.p, "ok");
            com.igexin.sdk.message.GTPopupMessage.GtAction action = this.a.o.getAction();
            java.lang.String actionType = action.getActionType();
            if (com.igexin.push.core.b.l.a.intent.name().equals(actionType)) {
                new com.igexin.push.core.a.c.j();
                com.igexin.push.core.a.c.j.a(action.getIntent(), this.c);
                return;
            }
            if (!com.igexin.push.core.b.l.a.url.name().equals(actionType)) {
                com.igexin.push.core.b.l.a.closePopup.name().equals(actionType);
                return;
            }
            new com.igexin.push.core.a.c.k();
            java.lang.String url = action.getUrl();
            android.content.Context context = this.c;
            try {
                if (android.text.TextUtils.isEmpty(url)) {
                    return;
                }
                com.igexin.push.core.b.r rVar = new com.igexin.push.core.b.r();
                rVar.a = url;
                com.igexin.push.core.a.c.k.a(rVar, com.igexin.push.core.b.z);
                android.content.Intent intent = new android.content.Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.addCategory("android.intent.category.BROWSABLE");
                intent.setFlags(268435456);
                intent.setPackage(rVar.d);
                intent.setData(android.net.Uri.parse(rVar.a()));
                context.startActivity(intent);
            } catch (java.lang.Exception e) {
                com.igexin.c.a.c.a.a(e);
            }
        }
    }

    /* renamed from: com.igexin.push.a.g$4, reason: invalid class name */
    public class AnonymousClass4 implements android.view.View.OnClickListener {
        final /* synthetic */ com.igexin.push.a.c a;
        final /* synthetic */ com.igexin.push.core.b.l.b b;

        public AnonymousClass4(com.igexin.push.a.c cVar, com.igexin.push.core.b.l.b bVar) {
            this.a = cVar;
            this.b = bVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(android.view.View view) {
            this.a.a(this.b);
        }
    }

    /* renamed from: com.igexin.push.a.g$5, reason: invalid class name */
    public class AnonymousClass5 implements com.igexin.push.a.e.a<android.graphics.Movie> {
        final /* synthetic */ com.igexin.push.core.b.l.b a;
        final /* synthetic */ android.content.Context b;
        final /* synthetic */ int c;
        final /* synthetic */ int d;
        final /* synthetic */ com.igexin.push.a.d e;

        public AnonymousClass5(com.igexin.push.core.b.l.b bVar, android.content.Context context, int i, int i2, com.igexin.push.a.d dVar) {
            this.a = bVar;
            this.b = context;
            this.c = i;
            this.d = i2;
            this.e = dVar;
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private void a2(android.graphics.Movie movie) {
            if (movie.duration() == 0) {
                com.igexin.push.a.g.a(com.igexin.push.a.g.this, this.a, this.b, this.c, this.d, this.e);
                return;
            }
            com.igexin.push.a.d dVar = this.e;
            dVar.a = movie;
            dVar.b = 0L;
            dVar.c = 0;
            dVar.setLayerType(1, null);
            dVar.setImageDrawable(null);
            dVar.requestLayout();
            dVar.invalidate();
            com.igexin.push.a.d dVar2 = this.e;
            if (dVar2.d) {
                dVar2.d = false;
                if (dVar2.a != null) {
                    dVar2.b = android.os.SystemClock.uptimeMillis() - dVar2.c;
                    dVar2.invalidate();
                }
            }
        }

        @Override // com.igexin.push.a.e.a
        public final /* synthetic */ void a(android.graphics.Movie movie) {
            android.graphics.Movie movie2 = movie;
            if (movie2.duration() == 0) {
                com.igexin.push.a.g.a(com.igexin.push.a.g.this, this.a, this.b, this.c, this.d, this.e);
                return;
            }
            com.igexin.push.a.d dVar = this.e;
            dVar.a = movie2;
            dVar.b = 0L;
            dVar.c = 0;
            dVar.setLayerType(1, null);
            dVar.setImageDrawable(null);
            dVar.requestLayout();
            dVar.invalidate();
            com.igexin.push.a.d dVar2 = this.e;
            if (dVar2.d) {
                dVar2.d = false;
                if (dVar2.a != null) {
                    dVar2.b = android.os.SystemClock.uptimeMillis() - dVar2.c;
                    dVar2.invalidate();
                }
            }
        }

        @Override // com.igexin.push.a.e.a
        public final void a(java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    /* renamed from: com.igexin.push.a.g$6, reason: invalid class name */
    public class AnonymousClass6 implements com.igexin.push.a.e.a<android.graphics.Bitmap> {
        final /* synthetic */ com.igexin.push.a.d a;

        public AnonymousClass6(com.igexin.push.a.d dVar) {
            this.a = dVar;
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private void a2(android.graphics.Bitmap bitmap) {
            this.a.setImageBitmap(bitmap);
        }

        @Override // com.igexin.push.a.e.a
        public final /* synthetic */ void a(android.graphics.Bitmap bitmap) {
            this.a.setImageBitmap(bitmap);
        }

        @Override // com.igexin.push.a.e.a
        public final void a(java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    /* renamed from: com.igexin.push.a.g$7, reason: invalid class name */
    public class AnonymousClass7 implements com.igexin.push.a.e.a<android.graphics.Bitmap> {
        final /* synthetic */ android.view.View a;
        final /* synthetic */ int b;

        /* renamed from: com.igexin.push.a.g$7$1, reason: invalid class name */
        public class AnonymousClass1 extends android.view.ViewOutlineProvider {
            public AnonymousClass1() {
            }

            @Override // android.view.ViewOutlineProvider
            public final void getOutline(android.view.View view, android.graphics.Outline outline) {
                outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), com.igexin.push.a.g.AnonymousClass7.this.b);
            }
        }

        public AnonymousClass7(android.view.View view, int i) {
            this.a = view;
            this.b = i;
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private void a2(android.graphics.Bitmap bitmap) {
            try {
                this.a.setBackground(new android.graphics.drawable.BitmapDrawable(this.a.getResources(), bitmap));
                if (this.b > 0) {
                    this.a.setClipToOutline(true);
                    this.a.setOutlineProvider(new com.igexin.push.a.g.AnonymousClass7.AnonymousClass1());
                }
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }

        @Override // com.igexin.push.a.e.a
        public final /* synthetic */ void a(android.graphics.Bitmap bitmap) {
            try {
                this.a.setBackground(new android.graphics.drawable.BitmapDrawable(this.a.getResources(), bitmap));
                if (this.b > 0) {
                    this.a.setClipToOutline(true);
                    this.a.setOutlineProvider(new com.igexin.push.a.g.AnonymousClass7.AnonymousClass1());
                }
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }

        @Override // com.igexin.push.a.e.a
        public final void a(java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    /* renamed from: com.igexin.push.a.g$8, reason: invalid class name */
    public class AnonymousClass8 implements android.view.View.OnClickListener {
        final /* synthetic */ com.igexin.push.a.c a;
        final /* synthetic */ com.igexin.push.core.b.l.b b;

        public AnonymousClass8(com.igexin.push.a.c cVar, com.igexin.push.core.b.l.b bVar) {
            this.a = cVar;
            this.b = bVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(android.view.View view) {
            this.a.a(this.b);
        }
    }

    /* renamed from: com.igexin.push.a.g$9, reason: invalid class name */
    public class AnonymousClass9 implements com.igexin.push.a.e.a<byte[]> {
        final /* synthetic */ com.igexin.push.core.b.l.b a;
        final /* synthetic */ android.content.Context b;
        final /* synthetic */ int c;
        final /* synthetic */ int d;
        final /* synthetic */ com.igexin.push.a.d e;

        public AnonymousClass9(com.igexin.push.core.b.l.b bVar, android.content.Context context, int i, int i2, com.igexin.push.a.d dVar) {
            this.a = bVar;
            this.b = context;
            this.c = i;
            this.d = i2;
            this.e = dVar;
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private void a2(byte[] bArr) {
            try {
                com.igexin.c.a.c.a.b("popupAct", "movie duration is 0 use glide " + this.a.h);
                com.igexin.push.core.i.a.f a = new com.igexin.push.core.i.a.a(this.b).a(java.nio.ByteBuffer.wrap(bArr), this.c, this.d);
                a.b();
                com.igexin.push.core.i.a.e c = a.c();
                this.e.setImageDrawable(c);
                com.igexin.push.core.i.a.k.a(!c.d, "You cannot restart a currently running animation.");
                com.igexin.push.core.i.a.h hVar = c.c.a;
                com.igexin.push.core.i.a.k.a(hVar.c ? false : true, "Can't restart a running animation");
                hVar.d = true;
                if (hVar.i != null) {
                    hVar.i = null;
                }
                c.start();
                com.igexin.push.a.g.this.c.add(a);
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }

        @Override // com.igexin.push.a.e.a
        public final /* synthetic */ void a(byte[] bArr) {
            byte[] bArr2 = bArr;
            try {
                com.igexin.c.a.c.a.b("popupAct", "movie duration is 0 use glide " + this.a.h);
                com.igexin.push.core.i.a.f a = new com.igexin.push.core.i.a.a(this.b).a(java.nio.ByteBuffer.wrap(bArr2), this.c, this.d);
                a.b();
                com.igexin.push.core.i.a.e c = a.c();
                this.e.setImageDrawable(c);
                com.igexin.push.core.i.a.k.a(!c.d, "You cannot restart a currently running animation.");
                com.igexin.push.core.i.a.h hVar = c.c.a;
                com.igexin.push.core.i.a.k.a(hVar.c ? false : true, "Can't restart a running animation");
                hVar.d = true;
                if (hVar.i != null) {
                    hVar.i = null;
                }
                c.start();
                com.igexin.push.a.g.this.c.add(a);
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
        }

        @Override // com.igexin.push.a.e.a
        public final void a(java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    private static int a(com.igexin.push.core.b.l.b bVar) {
        java.lang.String str = bVar.b;
        str.hashCode();
        if (str.equals("center")) {
            return 17;
        }
        return !str.equals(com.sensorsdata.sf.ui.view.UIProperty.right) ? androidx.core.view.GravityCompat.START : androidx.core.view.GravityCompat.END;
    }

    private android.view.View a(com.igexin.push.core.b.l.b bVar, android.content.Context context, com.igexin.push.a.c<com.igexin.push.core.b.l.b> cVar) {
        int i;
        android.view.View view;
        if (bVar == null) {
            return null;
        }
        java.lang.String str = bVar.a;
        str.hashCode();
        switch (str) {
            case "button":
                android.widget.Button button = new android.widget.Button(context);
                button.setAllCaps(false);
                view = button;
                break;
            case "column":
            case "row":
            case "view":
                android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(context);
                linearLayout.setOrientation(!"row".equals(bVar.a) ? 1 : 0);
                android.view.View a2 = a(bVar, linearLayout, cVar);
                if (bVar.g != null) {
                    for (i = 0; i < bVar.g.size(); i++) {
                        linearLayout.addView(a(bVar.g.get(i), context, cVar));
                    }
                }
                return a2;
            case "image":
            case "image_button":
                com.igexin.push.a.d dVar = new com.igexin.push.a.d(context);
                android.view.View a3 = a(bVar, dVar, cVar);
                dVar.setScaleType(android.widget.ImageView.ScaleType.CENTER_CROP);
                try {
                    if (!android.text.TextUtils.isEmpty(bVar.h)) {
                        if (bVar.h.endsWith(".gif")) {
                            com.igexin.push.a.e.b(bVar.h, new com.igexin.push.a.g.AnonymousClass5(bVar, context, bVar.a(), bVar.b(), dVar));
                        } else {
                            com.igexin.push.a.e.a(bVar.h, bVar.a(), new com.igexin.push.a.g.AnonymousClass6(dVar));
                        }
                    }
                } catch (java.lang.Throwable th) {
                    com.igexin.c.a.c.a.a(th);
                }
                return a3;
            case "label":
                view = new android.widget.TextView(context);
                break;
            default:
                throw new java.lang.RuntimeException("can't find type " + bVar.a);
        }
        return a(bVar, view, cVar);
    }

    private android.view.View a(com.igexin.push.core.b.l.b bVar, android.view.View view, com.igexin.push.a.c<com.igexin.push.core.b.l.b> cVar) {
        view.setPadding(bVar.j(), bVar.g(), bVar.i(), bVar.h());
        android.widget.LinearLayout.LayoutParams layoutParams = new android.widget.LinearLayout.LayoutParams(bVar.a(), bVar.b());
        layoutParams.setMargins(bVar.f(), bVar.c(), bVar.e(), bVar.d());
        if (bVar.b != null) {
            layoutParams.gravity = a(bVar);
        }
        android.graphics.drawable.GradientDrawable gradientDrawable = new android.graphics.drawable.GradientDrawable();
        int i = bVar.m;
        if (i != 0) {
            gradientDrawable.setColor(i);
        }
        int m = bVar.m();
        if (m > 0) {
            gradientDrawable.setStroke(m, bVar.n);
        }
        int k = bVar.k();
        if (k > 0) {
            gradientDrawable.setCornerRadius(k);
        }
        view.setBackground(gradientDrawable);
        if (!android.text.TextUtils.isEmpty(bVar.j) && !bVar.j.endsWith(".gif")) {
            com.igexin.push.a.e.a(bVar.j, bVar.a(), new com.igexin.push.a.g.AnonymousClass7(view, k));
        }
        view.setLayoutParams(layoutParams);
        if (view instanceof android.widget.TextView) {
            android.widget.TextView textView = (android.widget.TextView) view;
            textView.setText(!android.text.TextUtils.isEmpty(bVar.k) ? bVar.k : bVar.d);
            int i2 = bVar.l;
            if (i2 != 0) {
                textView.setTextColor(i2);
            }
            float l = bVar.l();
            if (l != 0.0f) {
                textView.setTextSize(0, l);
            }
            if (bVar.i) {
                textView.setTypeface(android.graphics.Typeface.DEFAULT_BOLD);
                textView.getPaint().setFakeBoldText(true);
            }
            if (bVar.n() != 0) {
                textView.setMaxHeight(bVar.n());
                textView.setMovementMethod(android.text.method.ScrollingMovementMethod.getInstance());
            }
            if (!android.text.TextUtils.isEmpty(bVar.c)) {
                textView.setGravity(a(bVar));
            }
        }
        com.igexin.sdk.message.GTPopupMessage gTPopupMessage = bVar.o;
        if (gTPopupMessage != null) {
            com.igexin.sdk.message.GTPopupMessage.GtAction action = gTPopupMessage.getAction();
            if (action.isClosePopup() || !com.igexin.push.core.b.l.a.closePopup.name().equals(action.getActionType())) {
                view.setOnClickListener(new com.igexin.push.a.g.AnonymousClass8(cVar, bVar));
                return view;
            }
        }
        view.setClickable(true);
        view.setFocusable(true);
        return view;
    }

    private android.widget.LinearLayout a(com.igexin.push.a.c cVar, com.igexin.push.core.b.l lVar, android.content.Context context) {
        com.igexin.push.core.b.l.b bVar = lVar.a;
        android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -1));
        linearLayout.setBackgroundColor(bVar.m);
        com.igexin.sdk.message.GTPopupMessage gTPopupMessage = bVar.o;
        if (gTPopupMessage != null) {
            com.igexin.sdk.message.GTPopupMessage.GtAction action = gTPopupMessage.getAction();
            if (action.isClosePopup() || !com.igexin.push.core.b.l.a.closePopup.name().equals(action.getActionType())) {
                linearLayout.setOnClickListener(new com.igexin.push.a.g.AnonymousClass4(cVar, bVar));
            } else {
                linearLayout.setClickable(true);
                linearLayout.setFocusable(true);
            }
        }
        android.view.View a2 = a(lVar.b, context, (com.igexin.push.a.c<com.igexin.push.core.b.l.b>) cVar);
        if (a2 != null) {
            linearLayout.addView(a2);
        }
        return linearLayout;
    }

    public static /* synthetic */ void a(com.igexin.push.a.g gVar, com.igexin.push.core.b.l.b bVar, android.content.Context context, int i, int i2, com.igexin.push.a.d dVar) {
        com.igexin.push.a.e.a(bVar.h, gVar.new AnonymousClass9(bVar, context, i, i2, dVar));
    }

    private void a(com.igexin.push.core.b.l.b bVar, android.content.Context context, int i, int i2, com.igexin.push.a.d dVar) {
        com.igexin.push.a.e.a(bVar.h, new com.igexin.push.a.g.AnonymousClass9(bVar, context, i, i2, dVar));
    }

    public static /* synthetic */ void a(com.igexin.push.core.b.l.b bVar, com.igexin.push.extension.mod.PushTaskBean pushTaskBean, android.content.Context context) {
        com.igexin.b.a.a().a.execute(new com.igexin.push.a.g.AnonymousClass3(bVar, pushTaskBean, context));
    }

    private static void b(com.igexin.push.core.b.l.b bVar, com.igexin.push.extension.mod.PushTaskBean pushTaskBean, android.content.Context context) {
        com.igexin.b.a.a().a.execute(new com.igexin.push.a.g.AnonymousClass3(bVar, pushTaskBean, context));
    }

    private void c(android.app.Activity activity) {
        android.content.Intent intent = activity.getIntent();
        try {
            a = true;
            android.content.Context applicationContext = activity.getApplicationContext();
            com.getui.gtc.base.GtcProvider.setContext(applicationContext);
            try {
                if (android.os.Build.VERSION.SDK_INT != 26) {
                    if (1 == applicationContext.getResources().getConfiguration().orientation) {
                        activity.setRequestedOrientation(7);
                    } else {
                        activity.setRequestedOrientation(6);
                    }
                }
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
            java.util.concurrent.atomic.AtomicLong atomicLong = new java.util.concurrent.atomic.AtomicLong(0L);
            com.igexin.push.core.b.l lVar = (com.igexin.push.core.b.l) intent.getExtras().getSerializable("bean");
            com.igexin.push.extension.mod.PushTaskBean pushTaskBean = new com.igexin.push.extension.mod.PushTaskBean();
            pushTaskBean.setAppid(lVar.e);
            pushTaskBean.setMessageId(lVar.f);
            pushTaskBean.setTaskId(lVar.g);
            pushTaskBean.setAppKey(lVar.h);
            com.igexin.push.core.b.l.a(applicationContext);
            com.igexin.push.a.g.AnonymousClass1 anonymousClass1 = new com.igexin.push.a.g.AnonymousClass1(atomicLong, activity, pushTaskBean, applicationContext);
            com.igexin.push.core.b.l.b bVar = lVar.a;
            android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(applicationContext);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -1));
            linearLayout.setBackgroundColor(bVar.m);
            com.igexin.sdk.message.GTPopupMessage gTPopupMessage = bVar.o;
            if (gTPopupMessage != null) {
                com.igexin.sdk.message.GTPopupMessage.GtAction action = gTPopupMessage.getAction();
                if (action.isClosePopup() || !com.igexin.push.core.b.l.a.closePopup.name().equals(action.getActionType())) {
                    linearLayout.setOnClickListener(new com.igexin.push.a.g.AnonymousClass4(anonymousClass1, bVar));
                } else {
                    linearLayout.setClickable(true);
                    linearLayout.setFocusable(true);
                }
            }
            android.view.View a2 = a(lVar.b, applicationContext, anonymousClass1);
            if (a2 != null) {
                linearLayout.addView(a2);
            }
            activity.setContentView(linearLayout);
            com.igexin.b.a.a().a.execute(new com.igexin.push.a.g.AnonymousClass2(lVar, pushTaskBean));
        } catch (java.lang.Throwable th2) {
            com.igexin.c.a.c.a.a(th2);
            activity.finish();
        }
    }

    @Override // com.igexin.push.a.b
    public final void a(android.app.Activity activity) {
        try {
            if (android.os.Build.VERSION.SDK_INT == 26) {
                activity.finish();
            }
        } catch (java.lang.Throwable th) {
            com.igexin.c.a.c.a.a(th);
        }
    }

    @Override // com.igexin.push.a.b
    public final boolean a() {
        return false;
    }

    @Override // com.igexin.push.a.b
    public final void b(android.app.Activity activity) {
        android.content.Intent intent = activity.getIntent();
        try {
            a = true;
            android.content.Context applicationContext = activity.getApplicationContext();
            com.getui.gtc.base.GtcProvider.setContext(applicationContext);
            try {
                if (android.os.Build.VERSION.SDK_INT != 26) {
                    if (1 == applicationContext.getResources().getConfiguration().orientation) {
                        activity.setRequestedOrientation(7);
                    } else {
                        activity.setRequestedOrientation(6);
                    }
                }
            } catch (java.lang.Throwable th) {
                com.igexin.c.a.c.a.a(th);
            }
            java.util.concurrent.atomic.AtomicLong atomicLong = new java.util.concurrent.atomic.AtomicLong(0L);
            com.igexin.push.core.b.l lVar = (com.igexin.push.core.b.l) intent.getExtras().getSerializable("bean");
            com.igexin.push.extension.mod.PushTaskBean pushTaskBean = new com.igexin.push.extension.mod.PushTaskBean();
            pushTaskBean.setAppid(lVar.e);
            pushTaskBean.setMessageId(lVar.f);
            pushTaskBean.setTaskId(lVar.g);
            pushTaskBean.setAppKey(lVar.h);
            com.igexin.push.core.b.l.a(applicationContext);
            com.igexin.push.a.g.AnonymousClass1 anonymousClass1 = new com.igexin.push.a.g.AnonymousClass1(atomicLong, activity, pushTaskBean, applicationContext);
            com.igexin.push.core.b.l.b bVar = lVar.a;
            android.widget.LinearLayout linearLayout = new android.widget.LinearLayout(applicationContext);
            linearLayout.setOrientation(1);
            linearLayout.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -1));
            linearLayout.setBackgroundColor(bVar.m);
            com.igexin.sdk.message.GTPopupMessage gTPopupMessage = bVar.o;
            if (gTPopupMessage != null) {
                com.igexin.sdk.message.GTPopupMessage.GtAction action = gTPopupMessage.getAction();
                if (action.isClosePopup() || !com.igexin.push.core.b.l.a.closePopup.name().equals(action.getActionType())) {
                    linearLayout.setOnClickListener(new com.igexin.push.a.g.AnonymousClass4(anonymousClass1, bVar));
                } else {
                    linearLayout.setClickable(true);
                    linearLayout.setFocusable(true);
                }
            }
            android.view.View a2 = a(lVar.b, applicationContext, anonymousClass1);
            if (a2 != null) {
                linearLayout.addView(a2);
            }
            activity.setContentView(linearLayout);
            com.igexin.b.a.a().a.execute(new com.igexin.push.a.g.AnonymousClass2(lVar, pushTaskBean));
        } catch (java.lang.Throwable th2) {
            com.igexin.c.a.c.a.a(th2);
            activity.finish();
        }
    }

    @Override // com.igexin.push.a.b
    public final boolean b() {
        return false;
    }

    @Override // com.igexin.push.a.b
    public final void c() {
    }

    @Override // com.igexin.push.a.b
    public final void d() {
    }

    @Override // com.igexin.push.a.b
    public final void e() {
    }

    @Override // com.igexin.push.a.b
    public final void f() {
    }

    @Override // com.igexin.push.a.b
    public final void g() {
    }

    @Override // com.igexin.push.a.b
    public final void h() {
    }

    @Override // com.igexin.push.a.b
    public final void i() {
        a = false;
        java.util.Iterator<com.igexin.push.core.i.a.f> it = this.c.iterator();
        while (it.hasNext()) {
            com.igexin.push.core.i.a.f next = it.next();
            if (next != null) {
                next.f();
            }
        }
        this.c.clear();
    }

    @Override // com.igexin.push.a.b
    public final void j() {
    }

    @Override // com.igexin.push.a.b
    public final void k() {
    }
}
