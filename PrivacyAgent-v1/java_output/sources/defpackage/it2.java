package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class it2 implements com.moji.pickerview.listener.OnItemSelectedListener {
    public final /* synthetic */ com.moji.mjcitypicker.data.PickerData n;
    public final /* synthetic */ com.moji.newmember.personal.SubscribePickCityBottomDialog t;

    public /* synthetic */ it2(com.moji.mjcitypicker.data.PickerData pickerData, com.moji.newmember.personal.SubscribePickCityBottomDialog subscribePickCityBottomDialog) {
        this.n = pickerData;
        this.t = subscribePickCityBottomDialog;
    }

    public final void onItemSelected(int i) {
        com.moji.newmember.personal.SubscribePickCityBottomDialog.d(this.n, this.t, i);
    }
}
