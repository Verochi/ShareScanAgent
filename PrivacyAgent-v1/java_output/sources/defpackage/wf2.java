package defpackage;

/* loaded from: classes25.dex */
public final /* synthetic */ class wf2 implements com.moji.share.ChannelShareHandler {
    public final /* synthetic */ android.app.Activity a;

    public /* synthetic */ wf2(android.app.Activity activity) {
        this.a = activity;
    }

    public final void onChannelClick(com.moji.share.entity.ShareChannelType shareChannelType, com.moji.share.entity.ShareContentConfig shareContentConfig, com.moji.share.entity.ShareRealContent shareRealContent) {
        com.moji.earlywarning.ShareHelper.a(this.a, shareChannelType, shareContentConfig, shareRealContent);
    }
}
