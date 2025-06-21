package com.anythink.expressad.video.module;

/* loaded from: classes12.dex */
public class AnythinkPlayableView extends com.anythink.expressad.video.module.AnythinkH5EndCardView {
    public AnythinkPlayableView(android.content.Context context) {
        super(context);
    }

    public AnythinkPlayableView(android.content.Context context, android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView
    public final java.lang.String a() {
        return super.a();
    }

    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView, com.anythink.expressad.video.module.AnythinkBaseView
    public void init(android.content.Context context) {
        super.init(context);
    }

    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView
    public void onBackPress() {
        super.onBackPress();
    }

    @Override // com.anythink.expressad.video.module.AnythinkH5EndCardView, com.anythink.expressad.video.signal.f
    public void preLoadData(com.anythink.expressad.video.signal.factory.b bVar) {
        super.preLoadData(bVar);
        super.setLoadPlayable(true);
    }
}
