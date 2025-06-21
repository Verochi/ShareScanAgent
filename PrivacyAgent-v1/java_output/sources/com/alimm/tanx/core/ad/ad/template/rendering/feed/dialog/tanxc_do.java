package com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog;

/* loaded from: classes.dex */
public class tanxc_do extends android.app.Dialog {
    public tanxc_do(@androidx.annotation.NonNull android.content.Context context, int i) {
        super(context, i);
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        setContentView(android.view.LayoutInflater.from(getContext()).inflate(i, (android.view.ViewGroup) null, false));
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }
}
