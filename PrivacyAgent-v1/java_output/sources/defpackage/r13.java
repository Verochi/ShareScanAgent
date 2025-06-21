package defpackage;

/* loaded from: classes16.dex */
public final /* synthetic */ class r13 implements android.view.View.OnTouchListener {
    public final /* synthetic */ com.moji.thunder.databinding.ActivityThunderStormBinding n;

    public /* synthetic */ r13(com.moji.thunder.databinding.ActivityThunderStormBinding activityThunderStormBinding) {
        this.n = activityThunderStormBinding;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(android.view.View view, android.view.MotionEvent motionEvent) {
        return com.moji.thunder.thunderstorm.ThunderStormActivity.e(this.n, view, motionEvent);
    }
}
