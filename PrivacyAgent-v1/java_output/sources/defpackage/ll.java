package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class ll implements kotlin.jvm.functions.Function1 {
    public final /* synthetic */ com.moji.mjweather.feed.ChannelBaseFragment n;
    public final /* synthetic */ org.json.JSONObject t;

    public /* synthetic */ ll(com.moji.mjweather.feed.ChannelBaseFragment channelBaseFragment, org.json.JSONObject jSONObject) {
        this.n = channelBaseFragment;
        this.t = jSONObject;
    }

    @Override // kotlin.jvm.functions.Function1
    public final java.lang.Object invoke(java.lang.Object obj) {
        return com.moji.mjweather.feed.ChannelBaseFragment.b(this.n, this.t, (java.lang.Long) obj);
    }
}
