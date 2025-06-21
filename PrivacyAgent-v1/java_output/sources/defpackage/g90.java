package defpackage;

/* loaded from: classes4.dex */
public final /* synthetic */ class g90 implements com.moji.dynamic.DynamicLoadListener {
    public final /* synthetic */ android.content.Context a;

    public /* synthetic */ g90(android.content.Context context) {
        this.a = context;
    }

    public final void onTypeReady(com.moji.dynamic.DynamicLoadType dynamicLoadType) {
        com.moji.mjshortvideo.EditNativeLibLoader.a(this.a, dynamicLoadType);
    }
}
