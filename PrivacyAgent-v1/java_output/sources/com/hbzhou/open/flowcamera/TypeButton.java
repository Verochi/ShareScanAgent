package com.hbzhou.open.flowcamera;

/* loaded from: classes22.dex */
public class TypeButton extends android.view.View {
    public static final int TYPE_CANCEL = 1;
    public static final int TYPE_CONFIRM = 2;
    public float A;
    public android.graphics.RectF B;
    public int n;
    public int t;
    public float u;
    public float v;
    public float w;
    public android.graphics.Paint x;
    public android.graphics.Path y;
    public float z;

    public TypeButton(android.content.Context context) {
        super(context);
    }

    public TypeButton(android.content.Context context, int i, int i2) {
        super(context);
        this.n = i;
        this.t = i2;
        float f = i2;
        float f2 = f / 2.0f;
        this.w = f2;
        this.u = f2;
        this.v = f2;
        this.x = new android.graphics.Paint();
        this.y = new android.graphics.Path();
        this.z = f / 50.0f;
        this.A = this.t / 12.0f;
        float f3 = this.u;
        float f4 = this.v;
        float f5 = this.A;
        this.B = new android.graphics.RectF(f3, f4 - f5, (2.0f * f5) + f3, f4 + f5);
    }

    @Override // android.view.View
    public void onDraw(android.graphics.Canvas canvas) {
        super.onDraw(canvas);
        if (this.n == 1) {
            this.x.setAntiAlias(true);
            this.x.setColor(-287515428);
            this.x.setStyle(android.graphics.Paint.Style.FILL);
            canvas.drawCircle(this.u, this.v, this.w, this.x);
            this.x.setColor(androidx.core.view.ViewCompat.MEASURED_STATE_MASK);
            this.x.setStyle(android.graphics.Paint.Style.STROKE);
            this.x.setStrokeWidth(this.z);
            android.graphics.Path path = this.y;
            float f = this.u;
            float f2 = this.A;
            path.moveTo(f - (f2 / 7.0f), this.v + f2);
            android.graphics.Path path2 = this.y;
            float f3 = this.u;
            float f4 = this.A;
            path2.lineTo(f3 + f4, this.v + f4);
            this.y.arcTo(this.B, 90.0f, -180.0f);
            android.graphics.Path path3 = this.y;
            float f5 = this.u;
            float f6 = this.A;
            path3.lineTo(f5 - f6, this.v - f6);
            canvas.drawPath(this.y, this.x);
            this.x.setStyle(android.graphics.Paint.Style.FILL);
            this.y.reset();
            android.graphics.Path path4 = this.y;
            float f7 = this.u;
            float f8 = this.A;
            path4.moveTo(f7 - f8, (float) (this.v - (f8 * 1.5d)));
            android.graphics.Path path5 = this.y;
            float f9 = this.u;
            float f10 = this.A;
            path5.lineTo(f9 - f10, (float) (this.v - (f10 / 2.3d)));
            android.graphics.Path path6 = this.y;
            double d = this.u;
            float f11 = this.A;
            path6.lineTo((float) (d - (f11 * 1.6d)), this.v - f11);
            this.y.close();
            canvas.drawPath(this.y, this.x);
        }
        if (this.n == 2) {
            this.x.setAntiAlias(true);
            this.x.setColor(-1);
            this.x.setStyle(android.graphics.Paint.Style.FILL);
            canvas.drawCircle(this.u, this.v, this.w, this.x);
            this.x.setAntiAlias(true);
            this.x.setStyle(android.graphics.Paint.Style.STROKE);
            this.x.setColor(-16724992);
            this.x.setStrokeWidth(this.z);
            this.y.moveTo(this.u - (this.t / 6.0f), this.v);
            android.graphics.Path path7 = this.y;
            float f12 = this.u;
            int i = this.t;
            path7.lineTo(f12 - (i / 21.2f), this.v + (i / 7.7f));
            android.graphics.Path path8 = this.y;
            float f13 = this.u;
            int i2 = this.t;
            path8.lineTo(f13 + (i2 / 4.0f), this.v - (i2 / 8.5f));
            android.graphics.Path path9 = this.y;
            float f14 = this.u;
            int i3 = this.t;
            path9.lineTo(f14 - (i3 / 21.2f), this.v + (i3 / 9.4f));
            this.y.close();
            canvas.drawPath(this.y, this.x);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = this.t;
        setMeasuredDimension(i3, i3);
    }
}
