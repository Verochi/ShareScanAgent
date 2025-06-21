package fm.jiecao.jcvideoplayer_lib;

@androidx.annotation.RequiresApi(api = 21)
/* loaded from: classes9.dex */
public class AdViewOutlineProvider extends android.view.ViewOutlineProvider {
    public float a;

    public AdViewOutlineProvider(float f) {
        this.a = f;
    }

    @Override // android.view.ViewOutlineProvider
    public void getOutline(android.view.View view, android.graphics.Outline outline) {
        android.graphics.Rect rect = new android.graphics.Rect();
        view.getGlobalVisibleRect(rect);
        outline.setRoundRect(new android.graphics.Rect(0, 0, (rect.right - rect.left) - 0, (rect.bottom - rect.top) - 0), this.a);
    }
}
