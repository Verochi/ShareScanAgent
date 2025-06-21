package com.anythink.basead.ui.animplayerview;

/* loaded from: classes12.dex */
public class RedPacketAnimPlayerView extends com.anythink.basead.ui.animplayerview.BaseMainAnimPlayerView {
    private java.util.List<android.graphics.Bitmap> y;
    private com.anythink.basead.ui.animplayerview.redpacket.RedPacketAnimatorView z;

    public RedPacketAnimPlayerView(android.content.Context context) {
        this(context, null);
    }

    public RedPacketAnimPlayerView(android.content.Context context, android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RedPacketAnimPlayerView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private android.view.ViewGroup.LayoutParams j() {
        if (!com.anythink.core.common.o.i.c(getContext())) {
            return new android.view.ViewGroup.LayoutParams(-1, -1);
        }
        android.widget.RelativeLayout.LayoutParams layoutParams = new android.widget.RelativeLayout.LayoutParams(getContext().getResources().getDisplayMetrics().heightPixels, -1);
        layoutParams.addRule(13);
        return layoutParams;
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView
    public final void a() {
        com.anythink.basead.ui.animplayerview.redpacket.RedPacketAnimatorView redPacketAnimatorView = this.z;
        if (redPacketAnimatorView != null) {
            redPacketAnimatorView.start();
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseMainAnimPlayerView
    public final void a(android.content.Context context) {
        android.view.ViewGroup.LayoutParams layoutParams;
        super.a(context);
        com.anythink.basead.ui.animplayerview.redpacket.RedPacketAnimatorView redPacketAnimatorView = new com.anythink.basead.ui.animplayerview.redpacket.RedPacketAnimatorView(context);
        this.z = redPacketAnimatorView;
        if (com.anythink.core.common.o.i.c(getContext())) {
            android.widget.RelativeLayout.LayoutParams layoutParams2 = new android.widget.RelativeLayout.LayoutParams(getContext().getResources().getDisplayMetrics().heightPixels, -1);
            layoutParams2.addRule(13);
            layoutParams = layoutParams2;
        } else {
            layoutParams = new android.view.ViewGroup.LayoutParams(-1, -1);
        }
        redPacketAnimatorView.setLayoutParams(layoutParams);
        this.z.setBitmapResources(this.y);
        addView(this.z);
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView
    public final void b() {
        com.anythink.basead.ui.animplayerview.redpacket.RedPacketAnimatorView redPacketAnimatorView = this.z;
        if (redPacketAnimatorView != null) {
            redPacketAnimatorView.pause();
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView
    public final void c() {
        com.anythink.basead.ui.animplayerview.redpacket.RedPacketAnimatorView redPacketAnimatorView = this.z;
        if (redPacketAnimatorView != null) {
            redPacketAnimatorView.stop();
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView
    public final void d() {
        com.anythink.basead.ui.animplayerview.redpacket.RedPacketAnimatorView redPacketAnimatorView = this.z;
        if (redPacketAnimatorView != null) {
            redPacketAnimatorView.release();
            this.z = null;
        }
        java.util.List<android.graphics.Bitmap> list = this.y;
        if (list != null) {
            for (android.graphics.Bitmap bitmap : list) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
        }
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseMainAnimPlayerView, com.anythink.basead.ui.animplayerview.BaseAnimPlayerView, com.anythink.basead.ui.animplayerview.BasePlayerView
    public void init(com.anythink.core.common.f.l lVar, com.anythink.core.common.f.m mVar, boolean z, java.util.List<android.graphics.Bitmap> list) {
        this.y = list;
        super.init(lVar, mVar, z, list);
    }
}
