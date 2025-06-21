package com.otaliastudios.opengl.geometry;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes19.dex */
public final class SegmentF$length$2 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function0<java.lang.Float> {
    final /* synthetic */ com.otaliastudios.opengl.geometry.SegmentF this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SegmentF$length$2(com.otaliastudios.opengl.geometry.SegmentF segmentF) {
        super(0);
        this.this$0 = segmentF;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final float invoke2() {
        double d = 2;
        return (float) java.lang.Math.sqrt(((float) java.lang.Math.pow(this.this$0.getIx() - this.this$0.getJx(), d)) + ((float) java.lang.Math.pow(this.this$0.getIy() - this.this$0.getJy(), d)));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ java.lang.Float invoke() {
        return java.lang.Float.valueOf(invoke2());
    }
}
