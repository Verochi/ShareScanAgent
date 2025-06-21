package defpackage;

/* loaded from: classes26.dex */
public final /* synthetic */ class ko implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.index.adapter.ClosetAdapter n;
    public final /* synthetic */ com.moji.index.adapter.ClosetAdapter.ExceptionViewHolder t;

    public /* synthetic */ ko(com.moji.index.adapter.ClosetAdapter closetAdapter, com.moji.index.adapter.ClosetAdapter.ExceptionViewHolder exceptionViewHolder) {
        this.n = closetAdapter;
        this.t = exceptionViewHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.index.adapter.ClosetAdapter.ExceptionViewHolder.a(this.n, this.t, view);
    }
}
