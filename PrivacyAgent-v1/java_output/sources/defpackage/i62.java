package defpackage;

/* loaded from: classes11.dex */
public final /* synthetic */ class i62 implements java.lang.Runnable {
    public final /* synthetic */ com.moji.puddle.presenter.PuddleMapViewControl n;
    public final /* synthetic */ com.moji.common.bean.objMap.ObjMaps.obj_maps t;

    public /* synthetic */ i62(com.moji.puddle.presenter.PuddleMapViewControl puddleMapViewControl, com.moji.common.bean.objMap.ObjMaps.obj_maps obj_mapsVar) {
        this.n = puddleMapViewControl;
        this.t = obj_mapsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.moji.puddle.presenter.PuddleMapViewControl.onCameraChangeFinish.1.a(this.n, this.t);
    }
}
