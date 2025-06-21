package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class je1 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.newmember.personal.MemberAppointedPlaceNotifDetailsActivity n;

    public /* synthetic */ je1(com.moji.newmember.personal.MemberAppointedPlaceNotifDetailsActivity memberAppointedPlaceNotifDetailsActivity) {
        this.n = memberAppointedPlaceNotifDetailsActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.newmember.personal.MemberAppointedPlaceNotifDetailsActivity.d(this.n, (com.moji.mjcitypicker.data.PickerData) obj);
    }
}
