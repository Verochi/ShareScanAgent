package com.otaliastudios.opengl.texture;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes19.dex */
public final class GlFramebuffer$attach$1 extends kotlin.jvm.internal.Lambda implements kotlin.jvm.functions.Function0<kotlin.Unit> {
    final /* synthetic */ int $attachment;
    final /* synthetic */ com.otaliastudios.opengl.texture.GlTexture $texture;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlFramebuffer$attach$1(int i, com.otaliastudios.opengl.texture.GlTexture glTexture) {
        super(0);
        this.$attachment = i;
        this.$texture = glTexture;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ kotlin.Unit invoke() {
        invoke2();
        return kotlin.Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        android.opengl.GLES20.glFramebufferTexture2D(com.otaliastudios.opengl.internal.GlKt.getGL_FRAMEBUFFER(), kotlin.UInt.m191constructorimpl(this.$attachment), kotlin.UInt.m191constructorimpl(this.$texture.getCom.umeng.ccg.a.A java.lang.String()), kotlin.UInt.m191constructorimpl(this.$texture.getId()), 0);
        int m191constructorimpl = kotlin.UInt.m191constructorimpl(android.opengl.GLES20.glCheckFramebufferStatus(com.otaliastudios.opengl.internal.GlKt.getGL_FRAMEBUFFER()));
        if (m191constructorimpl == com.otaliastudios.opengl.internal.GlKt.getGL_FRAMEBUFFER_COMPLETE()) {
            return;
        }
        throw new java.lang.RuntimeException("Invalid framebuffer generation. Error:" + kotlin.UInt.m195toStringimpl(m191constructorimpl));
    }
}
