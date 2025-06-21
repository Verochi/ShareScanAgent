package com.google.android.material.resources;

@androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes22.dex */
public final class CancelableFontCallback extends com.google.android.material.resources.TextAppearanceFontCallback {
    private final com.google.android.material.resources.CancelableFontCallback.ApplyFont applyFont;
    private boolean cancelled;
    private final android.graphics.Typeface fallbackFont;

    public interface ApplyFont {
        void apply(android.graphics.Typeface typeface);
    }

    public CancelableFontCallback(com.google.android.material.resources.CancelableFontCallback.ApplyFont applyFont, android.graphics.Typeface typeface) {
        this.fallbackFont = typeface;
        this.applyFont = applyFont;
    }

    private void updateIfNotCancelled(android.graphics.Typeface typeface) {
        if (this.cancelled) {
            return;
        }
        this.applyFont.apply(typeface);
    }

    public void cancel() {
        this.cancelled = true;
    }

    @Override // com.google.android.material.resources.TextAppearanceFontCallback
    public void onFontRetrievalFailed(int i) {
        updateIfNotCancelled(this.fallbackFont);
    }

    @Override // com.google.android.material.resources.TextAppearanceFontCallback
    public void onFontRetrieved(android.graphics.Typeface typeface, boolean z) {
        updateIfNotCancelled(typeface);
    }
}
