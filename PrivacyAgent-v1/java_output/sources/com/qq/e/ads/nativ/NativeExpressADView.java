package com.qq.e.ads.nativ;

/* loaded from: classes19.dex */
public abstract class NativeExpressADView extends android.widget.FrameLayout implements com.qq.e.comm.compliance.DownloadConfirmListener, com.qq.e.comm.pi.LADI, com.qq.e.comm.pi.NFBI {
    private int a;
    private double b;
    private double c;

    public interface ViewBindStatusListener {
        void onAttachedToWindow();

        void onDetachedFromWindow();

        void onFinishTemporaryDetach();

        void onStartTemporaryDetach();
    }

    public NativeExpressADView(android.content.Context context) {
        super(context);
        this.a = -1;
        this.b = -1.0d;
        this.c = -1.0d;
    }

    public abstract void destroy();

    public abstract com.qq.e.comm.pi.AdData getBoundData();

    public abstract void negativeFeedback();

    /* JADX WARN: Removed duplicated region for block: B:18:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i, int i2) {
        int min;
        int min2;
        int makeMeasureSpec;
        int i3;
        if (this.a <= 0 || this.b <= 0.0d || this.c <= 0.0d) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = android.view.View.MeasureSpec.getMode(i);
        int mode2 = android.view.View.MeasureSpec.getMode(i2);
        int size = android.view.View.MeasureSpec.getSize(i);
        int size2 = android.view.View.MeasureSpec.getSize(i2);
        com.qq.e.comm.util.GDTLogger.d("onMeasure widthSize, heightSize:" + size + "," + size2);
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (mode2 != 1073741824) {
                min = java.lang.Math.min((int) ((size / this.c) + 0.5d), size2);
                makeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(min, 1073741824);
                i3 = i;
                com.qq.e.comm.util.GDTLogger.d("onMeasure resize widthSize, heightSize:" + android.view.View.MeasureSpec.getSize(i3) + "," + android.view.View.MeasureSpec.getSize(makeMeasureSpec));
                super.onMeasure(i3, makeMeasureSpec);
                if (mode != Integer.MIN_VALUE) {
                    return;
                } else {
                    return;
                }
            }
            min2 = java.lang.Math.min((int) ((size2 * this.c) + 0.5d), size);
            i3 = android.view.View.MeasureSpec.makeMeasureSpec(min2, 1073741824);
            makeMeasureSpec = i2;
            com.qq.e.comm.util.GDTLogger.d("onMeasure resize widthSize, heightSize:" + android.view.View.MeasureSpec.getSize(i3) + "," + android.view.View.MeasureSpec.getSize(makeMeasureSpec));
            super.onMeasure(i3, makeMeasureSpec);
            if (mode != Integer.MIN_VALUE || size == getMeasuredWidth()) {
                return;
            }
            int makeMeasureSpec2 = android.view.View.MeasureSpec.makeMeasureSpec((int) ((getMeasuredWidth() / this.c) + 0.5d), 1073741824);
            int makeMeasureSpec3 = android.view.View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), Integer.MIN_VALUE);
            com.qq.e.comm.util.GDTLogger.d("onMeasure resize again widthSize, heightSize:" + android.view.View.MeasureSpec.getSize(makeMeasureSpec3) + "," + android.view.View.MeasureSpec.getSize(makeMeasureSpec2));
            super.onMeasure(makeMeasureSpec3, makeMeasureSpec2);
            return;
        }
        if (size2 < this.a || size < this.b * size2) {
            double d = this.c;
            double d2 = size2 * d;
            double d3 = size;
            if (d2 < d3) {
                min2 = (int) (d2 + 0.5d);
                i3 = android.view.View.MeasureSpec.makeMeasureSpec(min2, 1073741824);
                makeMeasureSpec = i2;
                com.qq.e.comm.util.GDTLogger.d("onMeasure resize widthSize, heightSize:" + android.view.View.MeasureSpec.getSize(i3) + "," + android.view.View.MeasureSpec.getSize(makeMeasureSpec));
                super.onMeasure(i3, makeMeasureSpec);
                if (mode != Integer.MIN_VALUE) {
                }
            } else {
                min = (int) ((d3 / d) + 0.5d);
                makeMeasureSpec = android.view.View.MeasureSpec.makeMeasureSpec(min, 1073741824);
                i3 = i;
                com.qq.e.comm.util.GDTLogger.d("onMeasure resize widthSize, heightSize:" + android.view.View.MeasureSpec.getSize(i3) + "," + android.view.View.MeasureSpec.getSize(makeMeasureSpec));
                super.onMeasure(i3, makeMeasureSpec);
                if (mode != Integer.MIN_VALUE) {
                }
            }
        } else {
            i3 = i;
            makeMeasureSpec = i2;
            com.qq.e.comm.util.GDTLogger.d("onMeasure resize widthSize, heightSize:" + android.view.View.MeasureSpec.getSize(i3) + "," + android.view.View.MeasureSpec.getSize(makeMeasureSpec));
            super.onMeasure(i3, makeMeasureSpec);
            if (mode != Integer.MIN_VALUE) {
            }
        }
    }

    public abstract void preloadVideo();

    public abstract void render();

    @java.lang.Deprecated
    public abstract void setAdSize(com.qq.e.ads.nativ.ADSize aDSize);

    public abstract void setMediaListener(com.qq.e.ads.nativ.NativeExpressMediaListener nativeExpressMediaListener);

    public void setSizeRules(int i, double d, double d2) {
        this.a = i;
        this.b = d;
        this.c = d2;
    }

    public abstract void setViewBindStatusListener(com.qq.e.ads.nativ.NativeExpressADView.ViewBindStatusListener viewBindStatusListener);
}
