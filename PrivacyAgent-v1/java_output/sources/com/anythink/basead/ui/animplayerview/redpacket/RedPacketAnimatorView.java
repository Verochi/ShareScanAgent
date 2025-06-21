package com.anythink.basead.ui.animplayerview.redpacket;

/* loaded from: classes12.dex */
public class RedPacketAnimatorView extends android.widget.FrameLayout implements android.os.Handler.Callback, com.anythink.basead.ui.animplayerview.b {
    private final int a;
    private final int b;
    private com.anythink.basead.ui.animplayerview.redpacket.RedPacketView c;
    private android.animation.ObjectAnimator d;
    private android.graphics.Bitmap e;
    private boolean f;
    private boolean g;
    private int h;
    private android.os.Handler i;

    /* renamed from: com.anythink.basead.ui.animplayerview.redpacket.RedPacketAnimatorView$1, reason: invalid class name */
    public class AnonymousClass1 extends com.anythink.basead.ui.animplayerview.a {
        public AnonymousClass1() {
        }

        @Override // com.anythink.basead.ui.animplayerview.a, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(android.animation.Animator animator) {
            if (com.anythink.basead.ui.animplayerview.redpacket.RedPacketAnimatorView.this.i != null) {
                com.anythink.basead.ui.animplayerview.redpacket.RedPacketAnimatorView.this.i.removeMessages(100);
                com.anythink.basead.ui.animplayerview.redpacket.RedPacketAnimatorView.this.i.sendEmptyMessageDelayed(100, 500L);
            }
        }
    }

    public RedPacketAnimatorView(android.content.Context context) {
        this(context, null);
    }

    public RedPacketAnimatorView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RedPacketAnimatorView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 4000;
        this.b = 100;
        this.f = false;
        this.g = false;
        this.i = new android.os.Handler(android.os.Looper.getMainLooper(), this);
        setClipChildren(false);
        com.anythink.basead.ui.animplayerview.redpacket.RedPacketView redPacketView = new com.anythink.basead.ui.animplayerview.redpacket.RedPacketView(getContext());
        this.c = redPacketView;
        addView(redPacketView, new android.view.ViewGroup.LayoutParams(-1, -1));
        this.c.setVisibility(4);
    }

    private static android.view.ViewGroup.LayoutParams a() {
        return new android.view.ViewGroup.LayoutParams(-1, -1);
    }

    private void b() {
        com.anythink.basead.ui.animplayerview.redpacket.RedPacketView redPacketView = this.c;
        if (redPacketView == null) {
            return;
        }
        redPacketView.setTranslationY(-this.h);
        if (this.d == null) {
            this.c.setVisibility(0);
            this.c.initRedPacketList(this.e);
            android.animation.ObjectAnimator ofFloat = android.animation.ObjectAnimator.ofFloat(this.c, "translationY", -r4, this.h);
            this.d = ofFloat;
            ofFloat.addListener(new com.anythink.basead.ui.animplayerview.redpacket.RedPacketAnimatorView.AnonymousClass1());
            this.d.setRepeatCount(0);
            this.d.setDuration(moji.com.mjweatherservicebase.view.sliderbanner.MJAutoSlideBannerView.DELAYED_TIME);
            this.d.setInterpolator(new android.view.animation.LinearInterpolator());
        }
        android.animation.ObjectAnimator objectAnimator = this.d;
        if (objectAnimator != null && !objectAnimator.isStarted()) {
            this.d.start();
        }
        this.f = true;
        this.g = false;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(android.os.Message message) {
        if (message.what != 100) {
            return false;
        }
        b();
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.h = getMeasuredHeight();
    }

    @Override // com.anythink.basead.ui.animplayerview.b
    public void pause() {
        android.os.Handler handler = this.i;
        if (handler != null) {
            handler.removeMessages(100);
        }
        android.animation.ObjectAnimator objectAnimator = this.d;
        if (objectAnimator != null) {
            objectAnimator.pause();
        }
    }

    public void release() {
        if (this.g) {
            return;
        }
        stop();
        com.anythink.basead.ui.animplayerview.redpacket.RedPacketView redPacketView = this.c;
        if (redPacketView != null) {
            redPacketView.release();
        }
        this.g = true;
    }

    @Override // com.anythink.basead.ui.animplayerview.b
    public void resume() {
        android.animation.ObjectAnimator objectAnimator = this.d;
        if (objectAnimator != null) {
            if (objectAnimator.isPaused()) {
                this.d.resume();
            } else {
                b();
            }
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.b
    public void setBitmapResources(java.util.List<android.graphics.Bitmap> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.e = list.get(0);
    }

    @Override // com.anythink.basead.ui.animplayerview.b
    public void start() {
        if (this.f) {
            resume();
            return;
        }
        android.os.Handler handler = this.i;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(100, 500L);
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.b
    public void stop() {
        com.anythink.basead.ui.animplayerview.redpacket.RedPacketView redPacketView = this.c;
        if (redPacketView != null) {
            redPacketView.setTranslationY(-this.h);
        }
        android.animation.ObjectAnimator objectAnimator = this.d;
        if (objectAnimator != null) {
            objectAnimator.removeAllListeners();
            this.d.cancel();
            this.d = null;
        }
        android.os.Handler handler = this.i;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.f = false;
    }
}
