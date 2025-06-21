package com.google.android.exoplayer2.trackselection;

/* loaded from: classes22.dex */
public final class TrackSelectionUtil {

    public interface AdaptiveTrackSelectionFactory {
        com.google.android.exoplayer2.trackselection.TrackSelection createAdaptiveTrackSelection(com.google.android.exoplayer2.trackselection.TrackSelection.Definition definition);
    }

    public static com.google.android.exoplayer2.trackselection.TrackSelection[] createTrackSelectionsForDefinitions(com.google.android.exoplayer2.trackselection.TrackSelection.Definition[] definitionArr, com.google.android.exoplayer2.trackselection.TrackSelectionUtil.AdaptiveTrackSelectionFactory adaptiveTrackSelectionFactory) {
        com.google.android.exoplayer2.trackselection.TrackSelection[] trackSelectionArr = new com.google.android.exoplayer2.trackselection.TrackSelection[definitionArr.length];
        boolean z = false;
        for (int i = 0; i < definitionArr.length; i++) {
            com.google.android.exoplayer2.trackselection.TrackSelection.Definition definition = definitionArr[i];
            if (definition != null) {
                int[] iArr = definition.tracks;
                if (iArr.length <= 1 || z) {
                    trackSelectionArr[i] = new com.google.android.exoplayer2.trackselection.FixedTrackSelection(definition.group, iArr[0], definition.reason, definition.data);
                } else {
                    trackSelectionArr[i] = adaptiveTrackSelectionFactory.createAdaptiveTrackSelection(definition);
                    z = true;
                }
            }
        }
        return trackSelectionArr;
    }

    public static com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters updateParametersWithOverride(com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters parameters, int i, com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, boolean z, @androidx.annotation.Nullable com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride selectionOverride) {
        com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder rendererDisabled = parameters.buildUpon().clearSelectionOverrides(i).setRendererDisabled(i, z);
        if (selectionOverride != null) {
            rendererDisabled.setSelectionOverride(i, trackGroupArray, selectionOverride);
        }
        return rendererDisabled.build();
    }
}
