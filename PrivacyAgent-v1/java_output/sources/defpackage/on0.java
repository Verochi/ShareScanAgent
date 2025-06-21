package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class on0 implements com.moji.dialog.publish.OnPublishListener {
    public final /* synthetic */ com.moji.mjweather.feed.newvideo.model.HomeFeedModel a;
    public final /* synthetic */ androidx.fragment.app.FragmentActivity b;
    public final /* synthetic */ com.moji.http.feedvideo.entity.HomeFeed c;
    public final /* synthetic */ java.lang.String d;

    public /* synthetic */ on0(com.moji.mjweather.feed.newvideo.model.HomeFeedModel homeFeedModel, androidx.fragment.app.FragmentActivity fragmentActivity, com.moji.http.feedvideo.entity.HomeFeed homeFeed, java.lang.String str) {
        this.a = homeFeedModel;
        this.b = fragmentActivity;
        this.c = homeFeed;
        this.d = str;
    }

    public final void onAgree() {
        com.moji.mjweather.feed.newvideo.model.HomeFeedModel.a(this.a, this.b, this.c, this.d);
    }
}
