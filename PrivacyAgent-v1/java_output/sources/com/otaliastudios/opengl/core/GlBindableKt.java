package com.otaliastudios.opengl.core;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\u0010\u0007\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006¨\u0006\b"}, d2 = {"use", "", "bindables", "", "Lcom/otaliastudios/opengl/core/GlBindable;", "block", "Lkotlin/Function0;", "([Lcom/otaliastudios/opengl/core/GlBindable;Lkotlin/jvm/functions/Function0;)V", "egloo-metadata_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes19.dex */
public final class GlBindableKt {
    public static final void use(@org.jetbrains.annotations.NotNull com.otaliastudios.opengl.core.GlBindable use, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> block) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(use, "$this$use");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(block, "block");
        use.bind();
        block.invoke();
        use.unbind();
    }

    public static final void use(@org.jetbrains.annotations.NotNull com.otaliastudios.opengl.core.GlBindable[] bindables, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> block) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(bindables, "bindables");
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(block, "block");
        for (com.otaliastudios.opengl.core.GlBindable glBindable : bindables) {
            glBindable.bind();
        }
        block.invoke();
        for (com.otaliastudios.opengl.core.GlBindable glBindable2 : bindables) {
            glBindable2.unbind();
        }
    }
}
