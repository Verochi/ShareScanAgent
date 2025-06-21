package moji.com.moondatepicker;

@kotlin.Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(B\u001b\b\u0016\u0012\u0006\u0010&\u001a\u00020%\u0012\b\u0010*\u001a\u0004\u0018\u00010)¢\u0006\u0004\b'\u0010+B#\b\u0016\u0012\u0006\u0010&\u001a\u00020%\u0012\b\u0010*\u001a\u0004\u0018\u00010)\u0012\u0006\u0010,\u001a\u00020\u0004¢\u0006\u0004\b'\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0014R\"\u0010\u000e\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR$\u0010\u001a\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001e\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010#\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!¨\u0006."}, d2 = {"Lmoji/com/moondatepicker/ItemView;", "Landroid/view/View;", "", "init", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "I", "getWidthSpec", "()I", "setWidthSpec", "(I)V", "widthSpec", "t", "getPositionInList", "setPositionInList", "positionInList", "", com.umeng.analytics.pro.bo.aN, "Ljava/lang/CharSequence;", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "text", "", "v", "Z", "isLongTimer", "()Z", "setLongTimer", "(Z)V", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.WIDTH, "isStartOrEnd", "setStartOrEnd", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "MJLunarPhase_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes20.dex */
public class ItemView extends android.view.View {

    /* renamed from: n, reason: from kotlin metadata */
    public int widthSpec;

    /* renamed from: t, reason: from kotlin metadata */
    public int positionInList;

    /* renamed from: u, reason: from kotlin metadata */
    @org.jetbrains.annotations.Nullable
    public java.lang.CharSequence text;

    /* renamed from: v, reason: from kotlin metadata */
    public boolean isLongTimer;

    /* renamed from: w, reason: from kotlin metadata */
    public boolean isStartOrEnd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemView(@org.jetbrains.annotations.NotNull android.content.Context context) {
        super(context);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemView(@org.jetbrains.annotations.NotNull android.content.Context context, @org.jetbrains.annotations.Nullable android.util.AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        init();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ItemView(@org.jetbrains.annotations.NotNull android.content.Context context, @org.jetbrains.annotations.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
        init();
    }

    public final int getPositionInList() {
        return this.positionInList;
    }

    @org.jetbrains.annotations.Nullable
    public final java.lang.CharSequence getText() {
        return this.text;
    }

    public final int getWidthSpec() {
        return this.widthSpec;
    }

    public void init() {
        this.widthSpec = android.view.View.MeasureSpec.makeMeasureSpec(com.moji.tool.DeviceTool.dp2px(10.0f), 1073741824);
    }

    /* renamed from: isLongTimer, reason: from getter */
    public final boolean getIsLongTimer() {
        return this.isLongTimer;
    }

    /* renamed from: isStartOrEnd, reason: from getter */
    public final boolean getIsStartOrEnd() {
        return this.isStartOrEnd;
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(this.widthSpec, heightMeasureSpec);
    }

    public final void setLongTimer(boolean z) {
        this.isLongTimer = z;
    }

    public final void setPositionInList(int i) {
        this.positionInList = i;
    }

    public final void setStartOrEnd(boolean z) {
        this.isStartOrEnd = z;
    }

    public final void setText(@org.jetbrains.annotations.Nullable java.lang.CharSequence charSequence) {
        this.text = charSequence;
    }

    public final void setWidthSpec(int i) {
        this.widthSpec = i;
    }
}
