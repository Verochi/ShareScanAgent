package defpackage;

/* loaded from: classes8.dex */
public final /* synthetic */ class os2 implements com.moji.pickerview.listener.OnItemSelectedListener {
    public final /* synthetic */ com.moji.newmember.personal.SubScenicChooseBottomDialog n;
    public final /* synthetic */ java.util.LinkedHashMap t;

    public /* synthetic */ os2(com.moji.newmember.personal.SubScenicChooseBottomDialog subScenicChooseBottomDialog, java.util.LinkedHashMap linkedHashMap) {
        this.n = subScenicChooseBottomDialog;
        this.t = linkedHashMap;
    }

    public final void onItemSelected(int i) {
        com.moji.newmember.personal.SubScenicChooseBottomDialog.b(this.n, this.t, i);
    }
}
