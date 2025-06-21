package com.xiaomi.push;

/* loaded from: classes19.dex */
public abstract class dt extends com.xiaomi.push.dr {
    private int a;
    private java.lang.String b;
    android.widget.RemoteViews d;
    public boolean e;
    protected android.graphics.Bitmap f;
    protected java.lang.CharSequence g;
    protected java.lang.CharSequence h;
    protected java.util.Map<java.lang.String, java.lang.String> i;
    private boolean j;
    private java.util.ArrayList<android.app.Notification.Action> k;
    private int l;

    public dt(android.content.Context context, int i, java.lang.String str) {
        super(context);
        this.k = new java.util.ArrayList<>();
        boolean z = false;
        this.l = 0;
        this.b = str;
        this.a = i;
        android.content.res.Resources resources = this.c.getResources();
        if (f() && g()) {
            z = true;
        }
        this.j = z;
        int a = com.xiaomi.push.dr.a(resources, z ? b() : a(), "layout", this.c.getPackageName());
        if (a == 0) {
            com.xiaomi.channel.commonutils.logger.b.a("create RemoteViews failed, no such layout resource was found");
        } else {
            this.d = new android.widget.RemoteViews(this.c.getPackageName(), a);
            this.e = c();
        }
    }

    public dt(android.content.Context context, java.lang.String str) {
        this(context, 0, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.app.Notification.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.xiaomi.push.dt addAction(android.app.Notification.Action action) {
        if (action != null) {
            this.k.add(action);
        }
        this.l++;
        return this;
    }

    public static android.graphics.Bitmap b(android.graphics.Bitmap bitmap) {
        android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), android.graphics.Bitmap.Config.ARGB_8888);
        android.graphics.Canvas canvas = new android.graphics.Canvas(createBitmap);
        android.graphics.Paint paint = new android.graphics.Paint();
        paint.setAntiAlias(true);
        android.graphics.Rect rect = new android.graphics.Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        canvas.drawRoundRect(new android.graphics.RectF(rect), 30.0f, 30.0f, paint);
        paint.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        if (!bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static boolean b(int i) {
        return ((((double) android.graphics.Color.red(i)) * 0.299d) + (((double) android.graphics.Color.green(i)) * 0.587d)) + (((double) android.graphics.Color.blue(i)) * 0.114d) < 192.0d;
    }

    private boolean f() {
        return (android.text.TextUtils.isEmpty(b()) || android.text.TextUtils.isEmpty(this.b)) ? false : true;
    }

    private boolean g() {
        java.util.List<android.service.notification.StatusBarNotification> c = com.xiaomi.push.service.aa.a(this.c, this.b).c();
        if (c != null && !c.isEmpty()) {
            java.util.Iterator<android.service.notification.StatusBarNotification> it = c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                android.service.notification.StatusBarNotification next = it.next();
                if (next.getId() == this.a) {
                    android.app.Notification notification = next.getNotification();
                    if (notification != null && !notification.extras.getBoolean("mipush.customCopyLayout", true)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final int a(float f) {
        return (int) ((f * this.c.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // com.xiaomi.push.dr
    public final com.xiaomi.push.dr a(java.util.Map<java.lang.String, java.lang.String> map) {
        this.i = map;
        return this;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final com.xiaomi.push.dt addAction(int i, java.lang.CharSequence charSequence, android.app.PendingIntent pendingIntent) {
        addAction(new android.app.Notification.Action(i, charSequence, pendingIntent));
        return this;
    }

    @Override // android.app.Notification.Builder
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.xiaomi.push.dt setLargeIcon(android.graphics.Bitmap bitmap) {
        this.f = bitmap;
        return this;
    }

    public abstract java.lang.String a();

    public final void a(int i) {
        android.graphics.Bitmap a = com.xiaomi.push.service.p.a(com.xiaomi.push.ga.g(this.c, this.b));
        if (a != null) {
            this.d.setImageViewBitmap(i, a);
            return;
        }
        int f = com.xiaomi.push.ga.f(this.c, this.b);
        if (f != 0) {
            this.d.setImageViewResource(i, f);
        }
    }

    public abstract java.lang.String b();

    public abstract boolean c();

    @Override // com.xiaomi.push.dr
    public void d() {
        super.d();
        android.os.Bundle bundle = new android.os.Bundle();
        boolean z = false;
        if (f()) {
            bundle.putBoolean("mipush.customCopyLayout", this.j);
        } else {
            bundle.putBoolean("mipush.customCopyLayout", false);
        }
        bundle.putBoolean("miui.customHeight", false);
        bundle.putBoolean("mipush.customNotification", true);
        bundle.putInt("mipush.customLargeIconId", com.xiaomi.push.dr.a(this.c.getResources(), "large_icon", "id", this.c.getPackageName()));
        if (this.k.size() > 0) {
            android.app.Notification.Action[] actionArr = new android.app.Notification.Action[this.k.size()];
            this.k.toArray(actionArr);
            bundle.putParcelableArray("mipush.customActions", actionArr);
        }
        java.util.Map<java.lang.String, java.lang.String> map = this.i;
        if (map != null && java.lang.Boolean.parseBoolean(map.get("custom_builder_set_title"))) {
            z = true;
        }
        if (z || !com.xiaomi.push.service.ab.a(this.c.getContentResolver())) {
            super.setContentTitle(this.g);
            super.setContentText(this.h);
        } else {
            bundle.putCharSequence("mipush.customTitle", this.g);
            bundle.putCharSequence("mipush.customContent", this.h);
        }
        addExtras(bundle);
    }

    public final void e() {
        super.setContentTitle(this.g);
        super.setContentText(this.h);
        android.graphics.Bitmap bitmap = this.f;
        if (bitmap != null) {
            super.setLargeIcon(bitmap);
        }
    }

    @Override // android.app.Notification.Builder
    public /* synthetic */ android.app.Notification.Builder setContentText(java.lang.CharSequence charSequence) {
        this.h = charSequence;
        return this;
    }

    @Override // android.app.Notification.Builder
    public /* synthetic */ android.app.Notification.Builder setContentTitle(java.lang.CharSequence charSequence) {
        this.g = charSequence;
        return this;
    }
}
