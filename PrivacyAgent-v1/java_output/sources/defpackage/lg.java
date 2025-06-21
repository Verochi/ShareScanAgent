package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class lg implements android.view.View.OnClickListener {
    public final /* synthetic */ android.widget.ImageView n;
    public final /* synthetic */ android.widget.ImageView t;
    public final /* synthetic */ android.widget.TextView u;
    public final /* synthetic */ android.widget.TextView v;

    public /* synthetic */ lg(android.widget.ImageView imageView, android.widget.ImageView imageView2, android.widget.TextView textView, android.widget.TextView textView2) {
        this.n = imageView;
        this.t = imageView2;
        this.u = textView;
        this.v = textView2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjweather.setting.fragment.BaseAccountFragment.d(this.n, this.t, this.u, this.v, view);
    }
}
