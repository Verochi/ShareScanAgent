package defpackage;

/* loaded from: classes24.dex */
public final /* synthetic */ class bb1 implements com.moji.dynamic.DynamicLoadListener {
    public final /* synthetic */ android.content.Context a;

    public /* synthetic */ bb1(android.content.Context context) {
        this.a = context;
    }

    public final void onTypeReady(com.moji.dynamic.DynamicLoadType dynamicLoadType) {
        com.moji.base.mapbox.MapNativeLibLoader.a(this.a, dynamicLoadType);
    }
}
