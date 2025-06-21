package defpackage;

/* loaded from: classes7.dex */
public final /* synthetic */ class kf3 implements com.moji.mjweather.weather.view.MainConditionView.UnitBottomListener {
    public final /* synthetic */ com.moji.mjweather.weather.view.MainFeedbackView a;

    public /* synthetic */ kf3(com.moji.mjweather.weather.view.MainFeedbackView mainFeedbackView) {
        this.a = mainFeedbackView;
    }

    public final void onChanged(int i) {
        this.a.onUnitBottomChanged(i);
    }
}
