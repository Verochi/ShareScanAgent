package defpackage;

/* loaded from: classes16.dex */
public final /* synthetic */ class m13 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.thunder.thunderstorm.fragment.ThunderMapViewControl n;
    public final /* synthetic */ com.moji.common.bean.objMap.ObjMaps.obj_maps.obj_map_info_list t;

    public /* synthetic */ m13(com.moji.thunder.thunderstorm.fragment.ThunderMapViewControl thunderMapViewControl, com.moji.common.bean.objMap.ObjMaps.obj_maps.obj_map_info_list obj_map_info_listVar) {
        this.n = thunderMapViewControl;
        this.t = obj_map_info_listVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.thunder.thunderstorm.fragment.ThunderMapViewControl.a(this.n, this.t);
    }
}
