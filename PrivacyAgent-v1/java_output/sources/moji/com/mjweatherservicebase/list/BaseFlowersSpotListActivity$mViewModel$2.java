package moji.com.mjweatherservicebase.list;

@kotlin.Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lmoji/com/mjweatherservicebase/list/BaseFlowersSpotListViewModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes20.dex */
public final class BaseFlowersSpotListActivity$mViewModel$2 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function0<moji.com.mjweatherservicebase.list.BaseFlowersSpotListViewModel> {
    final /* synthetic */ moji.com.mjweatherservicebase.list.BaseFlowersSpotListActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseFlowersSpotListActivity$mViewModel$2(moji.com.mjweatherservicebase.list.BaseFlowersSpotListActivity baseFlowersSpotListActivity) {
        super(0);
        this.this$0 = baseFlowersSpotListActivity;
    }

    @Override // kotlin.jvm.functions.Function0
    @org.jetbrains.annotations.NotNull
    public final moji.com.mjweatherservicebase.list.BaseFlowersSpotListViewModel invoke() {
        return (moji.com.mjweatherservicebase.list.BaseFlowersSpotListViewModel) androidx.lifecycle.ViewModelProviders.of((androidx.fragment.app.FragmentActivity) this.this$0).get(this.this$0.getSpotListViewModelClass());
    }
}
