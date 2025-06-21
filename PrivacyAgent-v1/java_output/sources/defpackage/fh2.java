package defpackage;

/* loaded from: classes14.dex */
public final /* synthetic */ class fh2 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.shorttime.ui.ShortTimeFragmentV2 n;

    public /* synthetic */ fh2(com.moji.shorttime.ui.ShortTimeFragmentV2 shortTimeFragmentV2) {
        this.n = shortTimeFragmentV2;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.shorttime.ui.ShortTimeFragmentV2.a(this.n, (com.moji.shorttime.ui.ShortTimeUiState) obj);
    }
}
