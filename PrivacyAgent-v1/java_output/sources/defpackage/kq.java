package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class kq implements android.content.DialogInterface.OnDismissListener {
    public final /* synthetic */ com.moji.mjweather.me.activity.CommentBindMobileActivity n;

    public /* synthetic */ kq(com.moji.mjweather.me.activity.CommentBindMobileActivity commentBindMobileActivity) {
        this.n = commentBindMobileActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(android.content.DialogInterface dialogInterface) {
        com.moji.mjweather.me.activity.CommentBindMobileActivity.oneKeyBind.1.c(this.n, dialogInterface);
    }
}
