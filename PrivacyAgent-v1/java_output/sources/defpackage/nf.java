package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class nf implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjweather.weather.beta.avatar_switch.AvatarListAdapter n;
    public final /* synthetic */ com.moji.mjad.avatar.data.AvatarInfo t;
    public final /* synthetic */ int u;

    public /* synthetic */ nf(com.moji.mjweather.weather.beta.avatar_switch.AvatarListAdapter avatarListAdapter, com.moji.mjad.avatar.data.AvatarInfo avatarInfo, int i) {
        this.n = avatarListAdapter;
        this.t = avatarInfo;
        this.u = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.weather.beta.avatar_switch.AvatarListAdapter.b(this.n, this.t, this.u, view);
    }
}
