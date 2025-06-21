package com.google.android.exoplayer2.ui;

/* loaded from: classes22.dex */
public final class TrackSelectionDialogBuilder {
    public final android.content.Context a;

    @androidx.annotation.StyleRes
    public int b;
    public final java.lang.CharSequence c;
    public final com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo d;
    public final int e;
    public final com.google.android.exoplayer2.ui.TrackSelectionDialogBuilder.DialogCallback f;
    public boolean g;
    public boolean h;
    public boolean i;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.ui.TrackNameProvider j;
    public boolean k;
    public java.util.List<com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> l;

    @androidx.annotation.Nullable
    public java.util.Comparator<com.google.android.exoplayer2.Format> m;

    public interface DialogCallback {
        void onTracksSelected(boolean z, java.util.List<com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> list);
    }

    public TrackSelectionDialogBuilder(android.content.Context context, java.lang.CharSequence charSequence, com.google.android.exoplayer2.trackselection.DefaultTrackSelector defaultTrackSelector, int i) {
        this.a = context;
        this.c = charSequence;
        com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo mappedTrackInfo = (com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo) com.google.android.exoplayer2.util.Assertions.checkNotNull(defaultTrackSelector.getCurrentMappedTrackInfo());
        this.d = mappedTrackInfo;
        this.e = i;
        com.google.android.exoplayer2.source.TrackGroupArray trackGroups = mappedTrackInfo.getTrackGroups(i);
        com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters parameters = defaultTrackSelector.getParameters();
        this.k = parameters.getRendererDisabled(i);
        com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride selectionOverride = parameters.getSelectionOverride(i, trackGroups);
        this.l = selectionOverride == null ? java.util.Collections.emptyList() : java.util.Collections.singletonList(selectionOverride);
        this.f = new defpackage.s33(defaultTrackSelector, parameters, i, trackGroups);
    }

    public TrackSelectionDialogBuilder(android.content.Context context, java.lang.CharSequence charSequence, com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int i, com.google.android.exoplayer2.ui.TrackSelectionDialogBuilder.DialogCallback dialogCallback) {
        this.a = context;
        this.c = charSequence;
        this.d = mappedTrackInfo;
        this.e = i;
        this.f = dialogCallback;
        this.l = java.util.Collections.emptyList();
    }

    public static /* synthetic */ void e(com.google.android.exoplayer2.trackselection.DefaultTrackSelector defaultTrackSelector, com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters parameters, int i, com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, boolean z, java.util.List list) {
        defaultTrackSelector.setParameters(com.google.android.exoplayer2.trackselection.TrackSelectionUtil.updateParametersWithOverride(parameters, i, trackGroupArray, z, list.isEmpty() ? null : (com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride) list.get(0)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(com.google.android.exoplayer2.ui.TrackSelectionView trackSelectionView, android.content.DialogInterface dialogInterface, int i) {
        this.f.onTracksSelected(trackSelectionView.getIsDisabled(), trackSelectionView.getOverrides());
    }

    public android.app.Dialog build() {
        android.app.Dialog c = c();
        return c == null ? d() : c;
    }

    @androidx.annotation.Nullable
    public final android.app.Dialog c() {
        try {
            java.lang.Class cls = java.lang.Integer.TYPE;
            java.lang.Object newInstance = androidx.appcompat.app.AlertDialog.Builder.class.getConstructor(android.content.Context.class, cls).newInstance(this.a, java.lang.Integer.valueOf(this.b));
            android.view.View inflate = android.view.LayoutInflater.from((android.content.Context) androidx.appcompat.app.AlertDialog.Builder.class.getMethod("getContext", new java.lang.Class[0]).invoke(newInstance, new java.lang.Object[0])).inflate(com.google.android.exoplayer2.ui.R.layout.exo_track_selection_dialog, (android.view.ViewGroup) null);
            android.content.DialogInterface.OnClickListener g = g(inflate);
            androidx.appcompat.app.AlertDialog.Builder.class.getMethod(com.alipay.sdk.m.x.d.o, java.lang.CharSequence.class).invoke(newInstance, this.c);
            androidx.appcompat.app.AlertDialog.Builder.class.getMethod("setView", android.view.View.class).invoke(newInstance, inflate);
            androidx.appcompat.app.AlertDialog.Builder.class.getMethod("setPositiveButton", cls, android.content.DialogInterface.OnClickListener.class).invoke(newInstance, java.lang.Integer.valueOf(android.R.string.ok), g);
            androidx.appcompat.app.AlertDialog.Builder.class.getMethod("setNegativeButton", cls, android.content.DialogInterface.OnClickListener.class).invoke(newInstance, java.lang.Integer.valueOf(android.R.string.cancel), null);
            return (android.app.Dialog) androidx.appcompat.app.AlertDialog.Builder.class.getMethod("create", new java.lang.Class[0]).invoke(newInstance, new java.lang.Object[0]);
        } catch (java.lang.ClassNotFoundException unused) {
            return null;
        } catch (java.lang.Exception e) {
            throw new java.lang.IllegalStateException(e);
        }
    }

    public final android.app.Dialog d() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this.a, this.b);
        android.view.View inflate = android.view.LayoutInflater.from(builder.getContext()).inflate(com.google.android.exoplayer2.ui.R.layout.exo_track_selection_dialog, (android.view.ViewGroup) null);
        return builder.setTitle(this.c).setView(inflate).setPositiveButton(android.R.string.ok, g(inflate)).setNegativeButton(android.R.string.cancel, (android.content.DialogInterface.OnClickListener) null).create();
    }

    public final android.content.DialogInterface.OnClickListener g(android.view.View view) {
        com.google.android.exoplayer2.ui.TrackSelectionView trackSelectionView = (com.google.android.exoplayer2.ui.TrackSelectionView) view.findViewById(com.google.android.exoplayer2.ui.R.id.exo_track_selection_view);
        trackSelectionView.setAllowMultipleOverrides(this.h);
        trackSelectionView.setAllowAdaptiveSelections(this.g);
        trackSelectionView.setShowDisableOption(this.i);
        com.google.android.exoplayer2.ui.TrackNameProvider trackNameProvider = this.j;
        if (trackNameProvider != null) {
            trackSelectionView.setTrackNameProvider(trackNameProvider);
        }
        trackSelectionView.init(this.d, this.e, this.k, this.l, this.m, null);
        return new defpackage.r33(this, trackSelectionView);
    }

    public com.google.android.exoplayer2.ui.TrackSelectionDialogBuilder setAllowAdaptiveSelections(boolean z) {
        this.g = z;
        return this;
    }

    public com.google.android.exoplayer2.ui.TrackSelectionDialogBuilder setAllowMultipleOverrides(boolean z) {
        this.h = z;
        return this;
    }

    public com.google.android.exoplayer2.ui.TrackSelectionDialogBuilder setIsDisabled(boolean z) {
        this.k = z;
        return this;
    }

    public com.google.android.exoplayer2.ui.TrackSelectionDialogBuilder setOverride(@androidx.annotation.Nullable com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride selectionOverride) {
        return setOverrides(selectionOverride == null ? java.util.Collections.emptyList() : java.util.Collections.singletonList(selectionOverride));
    }

    public com.google.android.exoplayer2.ui.TrackSelectionDialogBuilder setOverrides(java.util.List<com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride> list) {
        this.l = list;
        return this;
    }

    public com.google.android.exoplayer2.ui.TrackSelectionDialogBuilder setShowDisableOption(boolean z) {
        this.i = z;
        return this;
    }

    public com.google.android.exoplayer2.ui.TrackSelectionDialogBuilder setTheme(@androidx.annotation.StyleRes int i) {
        this.b = i;
        return this;
    }

    public void setTrackFormatComparator(@androidx.annotation.Nullable java.util.Comparator<com.google.android.exoplayer2.Format> comparator) {
        this.m = comparator;
    }

    public com.google.android.exoplayer2.ui.TrackSelectionDialogBuilder setTrackNameProvider(@androidx.annotation.Nullable com.google.android.exoplayer2.ui.TrackNameProvider trackNameProvider) {
        this.j = trackNameProvider;
        return this;
    }
}
