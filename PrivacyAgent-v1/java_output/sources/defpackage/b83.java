package defpackage;

/* loaded from: classes24.dex */
public final /* synthetic */ class b83 implements android.os.Handler.Callback {
    public final /* synthetic */ com.moji.camerax.presenter.Video2WebpPresenter n;
    public final /* synthetic */ android.os.HandlerThread t;

    public /* synthetic */ b83(com.moji.camerax.presenter.Video2WebpPresenter video2WebpPresenter, android.os.HandlerThread handlerThread) {
        this.n = video2WebpPresenter;
        this.t = handlerThread;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(android.os.Message message) {
        return com.moji.camerax.presenter.Video2WebpPresenter.a(this.n, this.t, message);
    }
}
