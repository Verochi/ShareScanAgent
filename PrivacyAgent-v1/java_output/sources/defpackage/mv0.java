package defpackage;

/* loaded from: classes13.dex */
public final /* synthetic */ class mv0 implements android.view.View.OnClickListener {
    public final /* synthetic */ android.view.View n;
    public final /* synthetic */ com.moji.redleaves.adapter.LeafCountryHolder t;

    public /* synthetic */ mv0(android.view.View view, com.moji.redleaves.adapter.LeafCountryHolder leafCountryHolder) {
        this.n = view;
        this.t = leafCountryHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.redleaves.adapter.LeafCountryHolder.a(this.n, this.t, view);
    }
}
