package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class e60 implements com.moji.dialog.control.MJDialogDefaultControl.SingleButtonCallback {
    public final /* synthetic */ com.moji.mjweather.feed.dress.api.DressAPIImpl a;
    public final /* synthetic */ android.app.Activity b;
    public final /* synthetic */ java.lang.String c;
    public final /* synthetic */ java.lang.String d;

    public /* synthetic */ e60(com.moji.mjweather.feed.dress.api.DressAPIImpl dressAPIImpl, android.app.Activity activity, java.lang.String str, java.lang.String str2) {
        this.a = dressAPIImpl;
        this.b = activity;
        this.c = str;
        this.d = str2;
    }

    public final void onClick(com.moji.dialog.MJDialog mJDialog, com.moji.dialog.type.ETypeAction eTypeAction) {
        com.moji.mjweather.feed.dress.api.DressAPIImpl.a(this.a, this.b, this.c, this.d, mJDialog, eTypeAction);
    }
}
