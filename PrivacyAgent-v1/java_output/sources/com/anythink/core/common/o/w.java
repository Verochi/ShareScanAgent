package com.anythink.core.common.o;

/* loaded from: classes12.dex */
public final class w {
    private static boolean a;

    /* renamed from: com.anythink.core.common.o.w$1, reason: invalid class name */
    public class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ android.view.View a;
        final /* synthetic */ int b;
        final /* synthetic */ android.view.View c;

        public AnonymousClass1(android.view.View view, int i, android.view.View view2) {
            this.a = view;
            this.b = i;
            this.c = view2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            android.graphics.Rect rect = new android.graphics.Rect();
            this.a.getHitRect(rect);
            int i = rect.top;
            int i2 = this.b;
            rect.top = i - i2;
            rect.bottom += i2;
            rect.left -= i2;
            rect.right += i2;
            this.c.setTouchDelegate(new android.view.TouchDelegate(rect, this.a));
        }
    }

    /* renamed from: com.anythink.core.common.o.w$2, reason: invalid class name */
    public class AnonymousClass2 implements java.lang.Runnable {
        final /* synthetic */ android.view.View a;
        final /* synthetic */ float b;
        final /* synthetic */ android.view.View c;

        public AnonymousClass2(android.view.View view, float f, android.view.View view2) {
            this.a = view;
            this.b = f;
            this.c = view2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            android.graphics.Rect rect = new android.graphics.Rect();
            this.a.getHitRect(rect);
            int width = ((int) (rect.width() * (this.b - 1.0f))) / 2;
            int height = ((int) (rect.height() * (this.b - 1.0f))) / 2;
            int i = rect.top;
            if (i - height < 0) {
                rect.top = 0;
            } else {
                rect.top = i - height;
            }
            if (rect.bottom + height > this.c.getHeight()) {
                rect.bottom = this.c.getHeight();
            } else {
                rect.bottom += height;
            }
            int i2 = rect.left;
            if (i2 - width < 0) {
                rect.left = 0;
            } else {
                rect.left = i2 - width;
            }
            if (rect.right + width > this.c.getWidth()) {
                rect.right = this.c.getWidth();
            } else {
                rect.right += width;
            }
            this.c.setTouchDelegate(new android.view.TouchDelegate(rect, this.a));
        }
    }

    private static android.graphics.Path a(int i, int i2, int i3) {
        android.graphics.Path path = new android.graphics.Path();
        float f = i;
        path.moveTo(f, 0.0f);
        float f2 = i2 - i;
        path.lineTo(f2, 0.0f);
        float f3 = i2;
        path.quadTo(f3, 0.0f, f3, f);
        float f4 = i3 - i;
        path.lineTo(f3, f4);
        float f5 = i3;
        path.quadTo(f3, f5, f2, f5);
        path.lineTo(f, f5);
        path.quadTo(0.0f, f5, 0.0f, f4);
        path.lineTo(0.0f, f);
        path.quadTo(0.0f, 0.0f, f, 0.0f);
        path.close();
        return path;
    }

    public static void a(android.graphics.Canvas canvas, int i, int i2, int i3) {
        try {
            android.graphics.Paint paint = new android.graphics.Paint(1);
            paint.setColor(-1);
            android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(i, i2, android.graphics.Bitmap.Config.ARGB_8888);
            android.graphics.Canvas canvas2 = new android.graphics.Canvas(createBitmap);
            android.graphics.Path path = new android.graphics.Path();
            float f = i3;
            path.moveTo(f, 0.0f);
            float f2 = i - i3;
            path.lineTo(f2, 0.0f);
            float f3 = i;
            path.quadTo(f3, 0.0f, f3, f);
            float f4 = i2 - i3;
            path.lineTo(f3, f4);
            float f5 = i2;
            path.quadTo(f3, f5, f2, f5);
            path.lineTo(f, f5);
            path.quadTo(0.0f, f5, 0.0f, f4);
            path.lineTo(0.0f, f);
            path.quadTo(0.0f, 0.0f, f, 0.0f);
            path.close();
            canvas2.drawPath(path, paint);
            paint.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_IN));
            canvas.drawBitmap(createBitmap, 0.0f, 0.0f, paint);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(android.graphics.Canvas canvas, int i, int i2, android.graphics.RectF rectF) {
        try {
            android.graphics.Paint paint = new android.graphics.Paint(1);
            paint.setColor(-1);
            paint.setStyle(android.graphics.Paint.Style.FILL);
            android.graphics.Bitmap createBitmap = android.graphics.Bitmap.createBitmap(i, i2, android.graphics.Bitmap.Config.ARGB_8888);
            new android.graphics.Canvas(createBitmap).drawArc(rectF, 0.0f, 180.0f, true, paint);
            paint.setXfermode(new android.graphics.PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_IN));
            canvas.drawBitmap(createBitmap, 0.0f, 0.0f, paint);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(android.view.View view) {
        if (view != null) {
            try {
                android.view.ViewParent parent = view.getParent();
                if (parent instanceof android.view.ViewGroup) {
                    ((android.view.ViewGroup) parent).removeView(view);
                }
            } catch (java.lang.Throwable unused) {
            }
        }
    }

    public static void a(android.view.View view, float f) {
        android.view.View view2 = (android.view.View) view.getParent();
        view2.post(new com.anythink.core.common.o.w.AnonymousClass2(view, f, view2));
    }

    private static void a(android.view.View view, int i) {
        android.view.View view2 = (android.view.View) view.getParent();
        view2.post(new com.anythink.core.common.o.w.AnonymousClass1(view, i, view2));
    }

    public static void a(boolean z) {
        a = z;
    }

    public static boolean a(android.view.View view, com.anythink.core.common.o.a.f.b bVar) {
        if (view != null && view.getParent() != null && bVar != null) {
            java.lang.Object parent = view.getParent();
            if ((parent instanceof android.view.View) && bVar.a((android.view.View) parent, view, 100, 0) && !a) {
                return true;
            }
        }
        return false;
    }

    public static int[] a(int i, int i2, float f) {
        if (f > i / i2) {
            i2 = (int) java.lang.Math.ceil(r0 / f);
        } else {
            i = (int) java.lang.Math.ceil(r1 * f);
        }
        return new int[]{i, i2};
    }

    private static boolean b(android.view.View view, float f) {
        android.graphics.Rect rect = new android.graphics.Rect();
        return view.getLocalVisibleRect(rect) && rect.top >= 0 && rect.bottom <= view.getHeight() && ((float) rect.height()) > ((float) view.getHeight()) * f;
    }
}
