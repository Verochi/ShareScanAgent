package com.otaliastudios.opengl.types;

@kotlin.Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u0003¨\u0006\u0004"}, d2 = {"dispose", "", "Ljava/nio/Buffer;", "Lcom/otaliastudios/opengl/types/Buffer;", "egloo-metadata_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes19.dex */
public final class BuffersKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final void dispose(@org.jetbrains.annotations.NotNull java.nio.Buffer dispose) {
        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(dispose, "$this$dispose");
        if (dispose instanceof com.otaliastudios.opengl.types.Disposable) {
            ((com.otaliastudios.opengl.types.Disposable) dispose).dispose();
        }
    }
}
