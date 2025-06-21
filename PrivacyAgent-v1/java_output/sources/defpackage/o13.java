package defpackage;

/* loaded from: classes16.dex */
public final /* synthetic */ class o13 implements androidx.lifecycle.Observer {
    public final /* synthetic */ com.moji.thunder.thunderstorm.ThunderStormActivity n;

    public /* synthetic */ o13(com.moji.thunder.thunderstorm.ThunderStormActivity thunderStormActivity) {
        this.n = thunderStormActivity;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(java.lang.Object obj) {
        com.moji.thunder.thunderstorm.ThunderStormActivity.b(this.n, (com.moji.common.bean.objMap.ObjMaps.obj_maps) obj);
    }
}
