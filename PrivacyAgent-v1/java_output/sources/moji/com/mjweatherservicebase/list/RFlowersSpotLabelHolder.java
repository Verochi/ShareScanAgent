package moji.com.mjweatherservicebase.list;

@kotlin.Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lmoji/com/mjweatherservicebase/list/RFlowersSpotLabelHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bindData", "", "spot", "Lcom/moji/http/rapeflowers/RapeFlowersSpotResp$ListBean;", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes20.dex */
public final class RFlowersSpotLabelHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RFlowersSpotLabelHolder(@org.jetbrains.annotations.NotNull android.view.View itemView) {
        super(itemView);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(itemView, "itemView");
    }

    public final void bindData(@org.jetbrains.annotations.NotNull com.moji.http.rapeflowers.RapeFlowersSpotResp.ListBean spot) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(spot, "spot");
        android.widget.TextView textView = (android.widget.TextView) this.itemView;
        int i = spot.type;
        textView.setText(i == 1 ? com.moji.tool.DeviceTool.getStringById(moji.com.mjweatherservicebase.R.string.rapeflowers_spot_inner) : i == 7 ? com.moji.tool.DeviceTool.getStringById(moji.com.mjweatherservicebase.R.string.rapeflowers_spot_outer) : com.moji.tool.DeviceTool.getStringById(moji.com.mjweatherservicebase.R.string.rapeflowers_spot_outer));
    }
}
