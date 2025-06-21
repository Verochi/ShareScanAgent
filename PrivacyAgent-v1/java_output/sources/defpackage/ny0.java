package defpackage;

/* loaded from: classes27.dex */
public final /* synthetic */ class ny0 implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.liveview.home.discover.ui.LiveViewPublishChoiceActivity n;
    public final /* synthetic */ com.moji.liveview.home.discover.ui.LiveViewPublishChoiceActivity.PublishChoiceConfig t;

    public /* synthetic */ ny0(com.moji.liveview.home.discover.ui.LiveViewPublishChoiceActivity liveViewPublishChoiceActivity, com.moji.liveview.home.discover.ui.LiveViewPublishChoiceActivity.PublishChoiceConfig publishChoiceConfig) {
        this.n = liveViewPublishChoiceActivity;
        this.t = publishChoiceConfig;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.liveview.home.discover.ui.LiveViewPublishChoiceActivity.b(this.n, this.t, view);
    }
}
