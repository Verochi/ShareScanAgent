package moji.com.mjwallet.view;

@kotlin.Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lmoji/com/mjwallet/view/RecyclerViewMargin;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", com.anythink.expressad.a.B, "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b, "", "getItemOffsets", "", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "I", com.sensorsdata.sf.ui.view.UIProperty.margin, "<init>", "(I)V", "MJWallet_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes20.dex */
public final class RecyclerViewMargin extends androidx.recyclerview.widget.RecyclerView.ItemDecoration {

    /* renamed from: n, reason: from kotlin metadata */
    public final int margin;

    public RecyclerViewMargin(int i) {
        this.margin = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@org.jetbrains.annotations.NotNull android.graphics.Rect outRect, @org.jetbrains.annotations.NotNull android.view.View view, @org.jetbrains.annotations.NotNull androidx.recyclerview.widget.RecyclerView parent, @org.jetbrains.annotations.NotNull androidx.recyclerview.widget.RecyclerView.State state) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(outRect, "outRect");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "view");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parent, "parent");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        outRect.bottom = this.margin;
    }
}
