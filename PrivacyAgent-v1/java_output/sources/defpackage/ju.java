package defpackage;

/* loaded from: classes4.dex */
public final /* synthetic */ class ju implements android.view.View.OnClickListener {
    public final /* synthetic */ com.moji.mjlunarphase.moondatepicker.MoonDatePickerView n;

    public /* synthetic */ ju(com.moji.mjlunarphase.moondatepicker.MoonDatePickerView moonDatePickerView) {
        this.n = moonDatePickerView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(android.view.View view) {
        com.moji.mjlunarphase.moondatepicker.CurrentViewPresenter.a(this.n, view);
    }
}
