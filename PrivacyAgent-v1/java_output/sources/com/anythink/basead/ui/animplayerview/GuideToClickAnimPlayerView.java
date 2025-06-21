package com.anythink.basead.ui.animplayerview;

/* loaded from: classes12.dex */
public class GuideToClickAnimPlayerView extends com.anythink.basead.ui.animplayerview.BaseAnimPlayerView {
    private com.anythink.basead.ui.GuideToClickView y;

    public GuideToClickAnimPlayerView(android.content.Context context) {
        super(context);
    }

    public GuideToClickAnimPlayerView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GuideToClickAnimPlayerView(android.content.Context context, android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void a(android.content.Context context) {
        android.graphics.Bitmap bitmap;
        h();
        com.anythink.basead.ui.GuideToClickView guideToClickView = new com.anythink.basead.ui.GuideToClickView(context);
        this.y = guideToClickView;
        addView(guideToClickView, -1, -1);
        java.util.List<android.graphics.Bitmap> list = this.d;
        if (list == null || list.size() <= 0 || (bitmap = this.d.get(0)) == null || bitmap.isRecycled()) {
            return;
        }
        this.y.setFingerImageResource(bitmap);
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView
    public final void a() {
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView
    public final void b() {
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView
    public final void c() {
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView
    public final void d() {
    }

    @Override // com.anythink.basead.ui.animplayerview.BaseAnimPlayerView, com.anythink.basead.ui.animplayerview.BasePlayerView
    public void init(com.anythink.core.common.f.l lVar, com.anythink.core.common.f.m mVar, boolean z, java.util.List<android.graphics.Bitmap> list) {
        android.graphics.Bitmap bitmap;
        super.init(lVar, mVar, z, list);
        android.content.Context applicationContext = getContext().getApplicationContext();
        h();
        com.anythink.basead.ui.GuideToClickView guideToClickView = new com.anythink.basead.ui.GuideToClickView(applicationContext);
        this.y = guideToClickView;
        addView(guideToClickView, -1, -1);
        java.util.List<android.graphics.Bitmap> list2 = this.d;
        if (list2 == null || list2.size() <= 0 || (bitmap = this.d.get(0)) == null || bitmap.isRecycled()) {
            return;
        }
        this.y.setFingerImageResource(bitmap);
    }
}
