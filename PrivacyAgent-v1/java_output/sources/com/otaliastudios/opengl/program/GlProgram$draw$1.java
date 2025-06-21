package com.otaliastudios.opengl.program;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes19.dex */
public final class GlProgram$draw$1 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function0<kotlin.Unit> {
    final /* synthetic */ com.otaliastudios.opengl.draw.GlDrawable $drawable;
    final /* synthetic */ float[] $modelViewProjectionMatrix;
    final /* synthetic */ com.otaliastudios.opengl.program.GlProgram this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlProgram$draw$1(com.otaliastudios.opengl.program.GlProgram glProgram, com.otaliastudios.opengl.draw.GlDrawable glDrawable, float[] fArr) {
        super(0);
        this.this$0 = glProgram;
        this.$drawable = glDrawable;
        this.$modelViewProjectionMatrix = fArr;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ kotlin.Unit invoke() {
        invoke2();
        return kotlin.Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.onPreDraw(this.$drawable, this.$modelViewProjectionMatrix);
        this.this$0.onDraw(this.$drawable);
        this.this$0.onPostDraw(this.$drawable);
    }
}
