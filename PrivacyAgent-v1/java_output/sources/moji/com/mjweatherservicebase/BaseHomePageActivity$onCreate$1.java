package moji.com.mjweatherservicebase;

@kotlin.Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"moji/com/mjweatherservicebase/BaseHomePageActivity$onCreate$1", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", com.anythink.expressad.a.B, "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", com.anythink.expressad.atsignalcommon.mraid.CallMraidJS.b, "Landroidx/recyclerview/widget/RecyclerView$State;", "MJWeatherServiceBase_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes20.dex */
public final class BaseHomePageActivity$onCreate$1 extends androidx.recyclerview.widget.RecyclerView.ItemDecoration {
    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@org.jetbrains.annotations.NotNull android.graphics.Rect outRect, @org.jetbrains.annotations.NotNull android.view.View view, @org.jetbrains.annotations.NotNull androidx.recyclerview.widget.RecyclerView parent, @org.jetbrains.annotations.NotNull androidx.recyclerview.widget.RecyclerView.State state) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(outRect, "outRect");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(view, "view");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(parent, "parent");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        parent.getChildLayoutPosition(view);
    }
}
