package com.hbzhou.open.flowcamera;

@kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0014R\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/hbzhou/open/flowcamera/AutoFitTextureView;", "Landroid/view/TextureView;", "", "width", "height", "", "setAspectRatio", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", com.baidu.mobads.sdk.api.IAdInterListener.AdReqParam.AD_COUNT, "I", "ratioWidth", "t", "ratioHeight", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "MJCameraModule_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes22.dex */
public final class AutoFitTextureView extends android.view.TextureView {

    /* renamed from: n, reason: from kotlin metadata */
    public int ratioWidth;

    /* renamed from: t, reason: from kotlin metadata */
    public int ratioHeight;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @kotlin.jvm.JvmOverloads
    public AutoFitTextureView(@org.jetbrains.annotations.NotNull android.content.Context context) {
        this(context, null, 0, 6, null);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @kotlin.jvm.JvmOverloads
    public AutoFitTextureView(@org.jetbrains.annotations.NotNull android.content.Context context, @org.jetbrains.annotations.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @kotlin.jvm.JvmOverloads
    public AutoFitTextureView(@org.jetbrains.annotations.NotNull android.content.Context context, @org.jetbrains.annotations.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AutoFitTextureView(android.content.Context context, android.util.AttributeSet attributeSet, int i, int i2, kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int size = android.view.View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = android.view.View.MeasureSpec.getSize(heightMeasureSpec);
        int i2 = this.ratioWidth;
        if (i2 == 0 || (i = this.ratioHeight) == 0) {
            setMeasuredDimension(size, size2);
        } else if (size < (size2 * i2) / i) {
            setMeasuredDimension(size, (i * size) / i2);
        } else {
            setMeasuredDimension((i2 * size2) / i, size2);
        }
    }

    public final void setAspectRatio(int width, int height) {
        if (width < 0 || height < 0) {
            throw new java.lang.IllegalArgumentException("Size cannot be negative.");
        }
        this.ratioWidth = width;
        this.ratioHeight = height;
        requestLayout();
    }
}
