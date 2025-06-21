package com.google.android.exoplayer2.trackselection;

/* loaded from: classes22.dex */
public final class TrackSelectorResult {

    @androidx.annotation.Nullable
    public final java.lang.Object info;
    public final int length;
    public final com.google.android.exoplayer2.RendererConfiguration[] rendererConfigurations;
    public final com.google.android.exoplayer2.trackselection.TrackSelectionArray selections;

    public TrackSelectorResult(com.google.android.exoplayer2.RendererConfiguration[] rendererConfigurationArr, com.google.android.exoplayer2.trackselection.TrackSelection[] trackSelectionArr, @androidx.annotation.Nullable java.lang.Object obj) {
        this.rendererConfigurations = rendererConfigurationArr;
        this.selections = new com.google.android.exoplayer2.trackselection.TrackSelectionArray(trackSelectionArr);
        this.info = obj;
        this.length = rendererConfigurationArr.length;
    }

    public boolean isEquivalent(@androidx.annotation.Nullable com.google.android.exoplayer2.trackselection.TrackSelectorResult trackSelectorResult) {
        if (trackSelectorResult == null || trackSelectorResult.selections.length != this.selections.length) {
            return false;
        }
        for (int i = 0; i < this.selections.length; i++) {
            if (!isEquivalent(trackSelectorResult, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEquivalent(@androidx.annotation.Nullable com.google.android.exoplayer2.trackselection.TrackSelectorResult trackSelectorResult, int i) {
        return trackSelectorResult != null && com.google.android.exoplayer2.util.Util.areEqual(this.rendererConfigurations[i], trackSelectorResult.rendererConfigurations[i]) && com.google.android.exoplayer2.util.Util.areEqual(this.selections.get(i), trackSelectorResult.selections.get(i));
    }

    public boolean isRendererEnabled(int i) {
        return this.rendererConfigurations[i] != null;
    }
}
