package defpackage;

/* loaded from: classes20.dex */
public final /* synthetic */ class pa0 implements android.view.View.OnClickListener {
    public final /* synthetic */ moji.com.mjwallet.progress.ExtractProgressActivity n;
    public final /* synthetic */ moji.com.mjwallet.progress.ExtractProgressViewModel t;

    public /* synthetic */ pa0(moji.com.mjwallet.progress.ExtractProgressActivity extractProgressActivity, moji.com.mjwallet.progress.ExtractProgressViewModel extractProgressViewModel) {
        this.n = extractProgressActivity;
        this.t = extractProgressViewModel;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        moji.com.mjwallet.progress.ExtractProgressActivity.j(this.n, this.t, view);
    }
}
