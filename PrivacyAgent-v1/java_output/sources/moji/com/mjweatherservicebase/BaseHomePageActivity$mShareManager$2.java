package moji.com.mjweatherservicebase;

@kotlin.Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/moji/share/MJThirdShareManager;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes20.dex */
public final class BaseHomePageActivity$mShareManager$2 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function0<com.moji.share.MJThirdShareManager> {
    final /* synthetic */ moji.com.mjweatherservicebase.BaseHomePageActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseHomePageActivity$mShareManager$2(moji.com.mjweatherservicebase.BaseHomePageActivity baseHomePageActivity) {
        super(0);
        this.this$0 = baseHomePageActivity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @org.jetbrains.annotations.NotNull
    public final com.moji.share.MJThirdShareManager invoke() {
        return new com.moji.share.MJThirdShareManager(this.this$0, (com.moji.share.listener.ShareListener) null);
    }
}
