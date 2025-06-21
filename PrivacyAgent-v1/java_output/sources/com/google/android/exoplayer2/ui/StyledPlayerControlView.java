package com.google.android.exoplayer2.ui;

/* loaded from: classes22.dex */
public class StyledPlayerControlView extends android.widget.FrameLayout {
    public static final int DEFAULT_REPEAT_TOGGLE_MODES = 0;
    public static final int DEFAULT_SHOW_TIMEOUT_MS = 5000;
    public static final int DEFAULT_TIME_BAR_MIN_UPDATE_INTERVAL_MS = 200;
    public static final int MAX_WINDOWS_FOR_MULTI_WINDOW_TIME_BAR = 100;

    @androidx.annotation.Nullable
    public final android.widget.TextView A;
    public long A0;

    @androidx.annotation.Nullable
    public final android.widget.ImageView B;
    public long B0;

    @androidx.annotation.Nullable
    public final android.widget.ImageView C;
    public long C0;

    @androidx.annotation.Nullable
    public final android.view.View D;
    public com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager D0;

    @androidx.annotation.Nullable
    public final android.widget.TextView E;
    public android.content.res.Resources E0;

    @androidx.annotation.Nullable
    public final android.widget.TextView F;
    public int F0;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.ui.TimeBar G;
    public androidx.recyclerview.widget.RecyclerView G0;
    public final java.lang.StringBuilder H;
    public com.google.android.exoplayer2.ui.StyledPlayerControlView.SettingsAdapter H0;
    public final java.util.Formatter I;
    public com.google.android.exoplayer2.ui.StyledPlayerControlView.SubSettingsAdapter I0;
    public final com.google.android.exoplayer2.Timeline.Period J;
    public android.widget.PopupWindow J0;
    public final com.google.android.exoplayer2.Timeline.Window K;
    public java.util.List<java.lang.String> K0;
    public final java.lang.Runnable L;
    public java.util.List<java.lang.Integer> L0;
    public final android.graphics.drawable.Drawable M;
    public int M0;
    public final android.graphics.drawable.Drawable N;
    public int N0;
    public final android.graphics.drawable.Drawable O;
    public boolean O0;
    public final java.lang.String P;
    public int P0;
    public final java.lang.String Q;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.trackselection.DefaultTrackSelector Q0;
    public final java.lang.String R;
    public com.google.android.exoplayer2.ui.StyledPlayerControlView.TrackSelectionAdapter R0;
    public final android.graphics.drawable.Drawable S;
    public com.google.android.exoplayer2.ui.StyledPlayerControlView.TrackSelectionAdapter S0;
    public final android.graphics.drawable.Drawable T;
    public com.google.android.exoplayer2.ui.TrackNameProvider T0;
    public final float U;

    @androidx.annotation.Nullable
    public android.widget.ImageView U0;
    public final float V;

    @androidx.annotation.Nullable
    public android.widget.ImageView V0;
    public final java.lang.String W;

    @androidx.annotation.Nullable
    public android.view.View W0;
    public final java.lang.String a0;
    public final android.graphics.drawable.Drawable b0;
    public final android.graphics.drawable.Drawable c0;
    public final java.lang.String d0;
    public final java.lang.String e0;
    public final android.graphics.drawable.Drawable f0;
    public final android.graphics.drawable.Drawable g0;
    public final java.lang.String h0;
    public final java.lang.String i0;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.Player j0;
    public com.google.android.exoplayer2.ControlDispatcher k0;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.ui.StyledPlayerControlView.ProgressUpdateListener l0;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.PlaybackPreparer m0;
    public final com.google.android.exoplayer2.ui.StyledPlayerControlView.ComponentListener n;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.ui.StyledPlayerControlView.OnFullScreenModeChangedListener n0;
    public boolean o0;
    public boolean p0;
    public boolean q0;
    public boolean r0;
    public boolean s0;
    public final java.util.concurrent.CopyOnWriteArrayList<com.google.android.exoplayer2.ui.StyledPlayerControlView.VisibilityListener> t;
    public int t0;

    @androidx.annotation.Nullable
    public final android.view.View u;
    public int u0;

    @androidx.annotation.Nullable
    public final android.view.View v;
    public int v0;

    @androidx.annotation.Nullable
    public final android.view.View w;
    public long[] w0;

    @androidx.annotation.Nullable
    public final android.view.View x;
    public boolean[] x0;

    @androidx.annotation.Nullable
    public final android.view.View y;
    public long[] y0;

    @androidx.annotation.Nullable
    public final android.widget.TextView z;
    public boolean[] z0;

    public final class AudioTrackSelectionAdapter extends com.google.android.exoplayer2.ui.StyledPlayerControlView.TrackSelectionAdapter {
        public AudioTrackSelectionAdapter() {
            super();
        }

        public /* synthetic */ AudioTrackSelectionAdapter(com.google.android.exoplayer2.ui.StyledPlayerControlView styledPlayerControlView, com.google.android.exoplayer2.ui.StyledPlayerControlView.AnonymousClass1 anonymousClass1) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i(android.view.View view) {
            if (com.google.android.exoplayer2.ui.StyledPlayerControlView.this.Q0 != null) {
                com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder buildUpon = com.google.android.exoplayer2.ui.StyledPlayerControlView.this.Q0.getParameters().buildUpon();
                for (int i = 0; i < this.n.size(); i++) {
                    buildUpon = buildUpon.clearSelectionOverrides(this.n.get(i).intValue());
                }
                ((com.google.android.exoplayer2.trackselection.DefaultTrackSelector) com.google.android.exoplayer2.util.Assertions.checkNotNull(com.google.android.exoplayer2.ui.StyledPlayerControlView.this.Q0)).setParameters(buildUpon);
            }
            com.google.android.exoplayer2.ui.StyledPlayerControlView.this.H0.c(1, com.google.android.exoplayer2.ui.StyledPlayerControlView.this.getResources().getString(com.google.android.exoplayer2.ui.R.string.exo_track_selection_auto));
            com.google.android.exoplayer2.ui.StyledPlayerControlView.this.J0.dismiss();
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.TrackSelectionAdapter
        public void b(java.util.List<java.lang.Integer> list, java.util.List<com.google.android.exoplayer2.ui.StyledPlayerControlView.TrackInfo> list2, com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo mappedTrackInfo) {
            boolean z;
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 >= list.size()) {
                    z = false;
                    break;
                }
                int intValue = list.get(i2).intValue();
                com.google.android.exoplayer2.source.TrackGroupArray trackGroups = mappedTrackInfo.getTrackGroups(intValue);
                if (com.google.android.exoplayer2.ui.StyledPlayerControlView.this.Q0 != null && com.google.android.exoplayer2.ui.StyledPlayerControlView.this.Q0.getParameters().hasSelectionOverride(intValue, trackGroups)) {
                    z = true;
                    break;
                }
                i2++;
            }
            if (!list2.isEmpty()) {
                if (z) {
                    while (true) {
                        if (i >= list2.size()) {
                            break;
                        }
                        com.google.android.exoplayer2.ui.StyledPlayerControlView.TrackInfo trackInfo = list2.get(i);
                        if (trackInfo.e) {
                            com.google.android.exoplayer2.ui.StyledPlayerControlView.this.H0.c(1, trackInfo.d);
                            break;
                        }
                        i++;
                    }
                } else {
                    com.google.android.exoplayer2.ui.StyledPlayerControlView.this.H0.c(1, com.google.android.exoplayer2.ui.StyledPlayerControlView.this.getResources().getString(com.google.android.exoplayer2.ui.R.string.exo_track_selection_auto));
                }
            } else {
                com.google.android.exoplayer2.ui.StyledPlayerControlView.this.H0.c(1, com.google.android.exoplayer2.ui.StyledPlayerControlView.this.getResources().getString(com.google.android.exoplayer2.ui.R.string.exo_track_selection_none));
            }
            this.n = list;
            this.t = list2;
            this.u = mappedTrackInfo;
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.TrackSelectionAdapter
        public void e(com.google.android.exoplayer2.ui.StyledPlayerControlView.TrackSelectionViewHolder trackSelectionViewHolder) {
            boolean z;
            trackSelectionViewHolder.n.setText(com.google.android.exoplayer2.ui.R.string.exo_track_selection_auto);
            com.google.android.exoplayer2.trackselection.DefaultTrackSelector.Parameters parameters = ((com.google.android.exoplayer2.trackselection.DefaultTrackSelector) com.google.android.exoplayer2.util.Assertions.checkNotNull(com.google.android.exoplayer2.ui.StyledPlayerControlView.this.Q0)).getParameters();
            int i = 0;
            while (true) {
                if (i >= this.n.size()) {
                    z = false;
                    break;
                }
                int intValue = this.n.get(i).intValue();
                if (parameters.hasSelectionOverride(intValue, ((com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.u)).getTrackGroups(intValue))) {
                    z = true;
                    break;
                }
                i++;
            }
            trackSelectionViewHolder.t.setVisibility(z ? 4 : 0);
            trackSelectionViewHolder.itemView.setOnClickListener(new com.google.android.exoplayer2.ui.c(this));
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.TrackSelectionAdapter
        public void g(java.lang.String str) {
            com.google.android.exoplayer2.ui.StyledPlayerControlView.this.H0.c(1, str);
        }
    }

    public final class ComponentListener implements com.google.android.exoplayer2.Player.EventListener, com.google.android.exoplayer2.ui.TimeBar.OnScrubListener, android.view.View.OnClickListener, android.widget.PopupWindow.OnDismissListener {
        public ComponentListener() {
        }

        public /* synthetic */ ComponentListener(com.google.android.exoplayer2.ui.StyledPlayerControlView styledPlayerControlView, com.google.android.exoplayer2.ui.StyledPlayerControlView.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            com.google.android.exoplayer2.Player player = com.google.android.exoplayer2.ui.StyledPlayerControlView.this.j0;
            if (player == null) {
                return;
            }
            com.google.android.exoplayer2.ui.StyledPlayerControlView.this.D0.U();
            if (com.google.android.exoplayer2.ui.StyledPlayerControlView.this.v == view) {
                com.google.android.exoplayer2.ui.StyledPlayerControlView.this.k0.dispatchNext(player);
                return;
            }
            if (com.google.android.exoplayer2.ui.StyledPlayerControlView.this.u == view) {
                com.google.android.exoplayer2.ui.StyledPlayerControlView.this.k0.dispatchPrevious(player);
                return;
            }
            if (com.google.android.exoplayer2.ui.StyledPlayerControlView.this.x == view) {
                if (player.getPlaybackState() != 4) {
                    com.google.android.exoplayer2.ui.StyledPlayerControlView.this.k0.dispatchFastForward(player);
                    return;
                }
                return;
            }
            if (com.google.android.exoplayer2.ui.StyledPlayerControlView.this.y == view) {
                com.google.android.exoplayer2.ui.StyledPlayerControlView.this.k0.dispatchRewind(player);
                return;
            }
            if (com.google.android.exoplayer2.ui.StyledPlayerControlView.this.w == view) {
                com.google.android.exoplayer2.ui.StyledPlayerControlView.this.T(player);
                return;
            }
            if (com.google.android.exoplayer2.ui.StyledPlayerControlView.this.B == view) {
                com.google.android.exoplayer2.ui.StyledPlayerControlView.this.k0.dispatchSetRepeatMode(player, com.google.android.exoplayer2.util.RepeatModeUtil.getNextRepeatMode(player.getRepeatMode(), com.google.android.exoplayer2.ui.StyledPlayerControlView.this.v0));
                return;
            }
            if (com.google.android.exoplayer2.ui.StyledPlayerControlView.this.C == view) {
                com.google.android.exoplayer2.ui.StyledPlayerControlView.this.k0.dispatchSetShuffleModeEnabled(player, !player.getShuffleModeEnabled());
                return;
            }
            if (com.google.android.exoplayer2.ui.StyledPlayerControlView.this.W0 == view) {
                com.google.android.exoplayer2.ui.StyledPlayerControlView.this.D0.T();
                com.google.android.exoplayer2.ui.StyledPlayerControlView styledPlayerControlView = com.google.android.exoplayer2.ui.StyledPlayerControlView.this;
                styledPlayerControlView.U(styledPlayerControlView.H0);
            } else if (com.google.android.exoplayer2.ui.StyledPlayerControlView.this.U0 == view) {
                com.google.android.exoplayer2.ui.StyledPlayerControlView.this.D0.T();
                com.google.android.exoplayer2.ui.StyledPlayerControlView styledPlayerControlView2 = com.google.android.exoplayer2.ui.StyledPlayerControlView.this;
                styledPlayerControlView2.U(styledPlayerControlView2.R0);
            }
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (com.google.android.exoplayer2.ui.StyledPlayerControlView.this.O0) {
                com.google.android.exoplayer2.ui.StyledPlayerControlView.this.D0.U();
            }
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onExperimentalOffloadSchedulingEnabledChanged(boolean z) {
            defpackage.h32.a(this, z);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onIsLoadingChanged(boolean z) {
            defpackage.h32.b(this, z);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onIsPlayingChanged(boolean z) {
            com.google.android.exoplayer2.ui.StyledPlayerControlView.this.n0();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onLoadingChanged(boolean z) {
            defpackage.h32.d(this, z);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onMediaItemTransition(com.google.android.exoplayer2.MediaItem mediaItem, int i) {
            defpackage.h32.e(this, mediaItem, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlayWhenReadyChanged(boolean z, int i) {
            com.google.android.exoplayer2.ui.StyledPlayerControlView.this.m0();
            com.google.android.exoplayer2.ui.StyledPlayerControlView.this.n0();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlaybackParametersChanged(com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
            com.google.android.exoplayer2.ui.StyledPlayerControlView.this.q0();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlaybackStateChanged(int i) {
            com.google.android.exoplayer2.ui.StyledPlayerControlView.this.m0();
            com.google.android.exoplayer2.ui.StyledPlayerControlView.this.n0();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlaybackSuppressionReasonChanged(int i) {
            defpackage.h32.i(this, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlayerError(com.google.android.exoplayer2.ExoPlaybackException exoPlaybackException) {
            defpackage.h32.j(this, exoPlaybackException);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlayerStateChanged(boolean z, int i) {
            defpackage.h32.k(this, z, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPositionDiscontinuity(int i) {
            com.google.android.exoplayer2.ui.StyledPlayerControlView.this.l0();
            com.google.android.exoplayer2.ui.StyledPlayerControlView.this.t0();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onRepeatModeChanged(int i) {
            com.google.android.exoplayer2.ui.StyledPlayerControlView.this.o0();
            com.google.android.exoplayer2.ui.StyledPlayerControlView.this.l0();
        }

        @Override // com.google.android.exoplayer2.ui.TimeBar.OnScrubListener
        public void onScrubMove(com.google.android.exoplayer2.ui.TimeBar timeBar, long j) {
            if (com.google.android.exoplayer2.ui.StyledPlayerControlView.this.F != null) {
                com.google.android.exoplayer2.ui.StyledPlayerControlView.this.F.setText(com.google.android.exoplayer2.util.Util.getStringForTime(com.google.android.exoplayer2.ui.StyledPlayerControlView.this.H, com.google.android.exoplayer2.ui.StyledPlayerControlView.this.I, j));
            }
        }

        @Override // com.google.android.exoplayer2.ui.TimeBar.OnScrubListener
        public void onScrubStart(com.google.android.exoplayer2.ui.TimeBar timeBar, long j) {
            com.google.android.exoplayer2.ui.StyledPlayerControlView.this.s0 = true;
            if (com.google.android.exoplayer2.ui.StyledPlayerControlView.this.F != null) {
                com.google.android.exoplayer2.ui.StyledPlayerControlView.this.F.setText(com.google.android.exoplayer2.util.Util.getStringForTime(com.google.android.exoplayer2.ui.StyledPlayerControlView.this.H, com.google.android.exoplayer2.ui.StyledPlayerControlView.this.I, j));
            }
            com.google.android.exoplayer2.ui.StyledPlayerControlView.this.D0.T();
        }

        @Override // com.google.android.exoplayer2.ui.TimeBar.OnScrubListener
        public void onScrubStop(com.google.android.exoplayer2.ui.TimeBar timeBar, long j, boolean z) {
            com.google.android.exoplayer2.ui.StyledPlayerControlView.this.s0 = false;
            if (!z && com.google.android.exoplayer2.ui.StyledPlayerControlView.this.j0 != null) {
                com.google.android.exoplayer2.ui.StyledPlayerControlView styledPlayerControlView = com.google.android.exoplayer2.ui.StyledPlayerControlView.this;
                styledPlayerControlView.g0(styledPlayerControlView.j0, j);
            }
            com.google.android.exoplayer2.ui.StyledPlayerControlView.this.D0.U();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onSeekProcessed() {
            defpackage.h32.n(this);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onShuffleModeEnabledChanged(boolean z) {
            com.google.android.exoplayer2.ui.StyledPlayerControlView.this.s0();
            com.google.android.exoplayer2.ui.StyledPlayerControlView.this.l0();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onTimelineChanged(com.google.android.exoplayer2.Timeline timeline, int i) {
            com.google.android.exoplayer2.ui.StyledPlayerControlView.this.l0();
            com.google.android.exoplayer2.ui.StyledPlayerControlView.this.t0();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onTimelineChanged(com.google.android.exoplayer2.Timeline timeline, java.lang.Object obj, int i) {
            defpackage.h32.q(this, timeline, obj, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onTracksChanged(com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, com.google.android.exoplayer2.trackselection.TrackSelectionArray trackSelectionArray) {
            com.google.android.exoplayer2.ui.StyledPlayerControlView.this.u0();
        }
    }

    public interface OnFullScreenModeChangedListener {
        void onFullScreenModeChanged(boolean z);
    }

    public interface ProgressUpdateListener {
        void onProgressUpdate(long j, long j2);
    }

    public class SettingViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        public final android.widget.TextView n;
        public final android.widget.TextView t;
        public final android.widget.ImageView u;

        public SettingViewHolder(android.view.View view) {
            super(view);
            this.n = (android.widget.TextView) view.findViewById(com.google.android.exoplayer2.ui.R.id.exo_main_text);
            this.t = (android.widget.TextView) view.findViewById(com.google.android.exoplayer2.ui.R.id.exo_sub_text);
            this.u = (android.widget.ImageView) view.findViewById(com.google.android.exoplayer2.ui.R.id.exo_icon);
            view.setOnClickListener(new com.google.android.exoplayer2.ui.d(this));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(android.view.View view) {
            com.google.android.exoplayer2.ui.StyledPlayerControlView.this.c0(getAdapterPosition());
        }
    }

    public class SettingsAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.google.android.exoplayer2.ui.StyledPlayerControlView.SettingViewHolder> {
        public final java.lang.String[] n;
        public final java.lang.String[] t;
        public final android.graphics.drawable.Drawable[] u;

        public SettingsAdapter(java.lang.String[] strArr, android.graphics.drawable.Drawable[] drawableArr) {
            this.n = strArr;
            this.t = new java.lang.String[strArr.length];
            this.u = drawableArr;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(com.google.android.exoplayer2.ui.StyledPlayerControlView.SettingViewHolder settingViewHolder, int i) {
            settingViewHolder.n.setText(this.n[i]);
            if (this.t[i] == null) {
                settingViewHolder.t.setVisibility(8);
            } else {
                settingViewHolder.t.setText(this.t[i]);
            }
            if (this.u[i] == null) {
                settingViewHolder.u.setVisibility(8);
            } else {
                settingViewHolder.u.setImageDrawable(this.u[i]);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.ui.StyledPlayerControlView.SettingViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
            return com.google.android.exoplayer2.ui.StyledPlayerControlView.this.new SettingViewHolder(android.view.LayoutInflater.from(com.google.android.exoplayer2.ui.StyledPlayerControlView.this.getContext()).inflate(com.google.android.exoplayer2.ui.R.layout.exo_styled_settings_list_item, (android.view.ViewGroup) null));
        }

        public void c(int i, java.lang.String str) {
            this.t[i] = str;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.n.length;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            return i;
        }
    }

    public class SubSettingViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        public final android.widget.TextView n;
        public final android.view.View t;

        public SubSettingViewHolder(android.view.View view) {
            super(view);
            this.n = (android.widget.TextView) view.findViewById(com.google.android.exoplayer2.ui.R.id.exo_text);
            this.t = view.findViewById(com.google.android.exoplayer2.ui.R.id.exo_check);
            view.setOnClickListener(new com.google.android.exoplayer2.ui.e(this));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(android.view.View view) {
            com.google.android.exoplayer2.ui.StyledPlayerControlView.this.d0(getAdapterPosition());
        }
    }

    public class SubSettingsAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.google.android.exoplayer2.ui.StyledPlayerControlView.SubSettingViewHolder> {

        @androidx.annotation.Nullable
        public java.util.List<java.lang.String> n;
        public int t;

        public SubSettingsAdapter() {
        }

        public /* synthetic */ SubSettingsAdapter(com.google.android.exoplayer2.ui.StyledPlayerControlView styledPlayerControlView, com.google.android.exoplayer2.ui.StyledPlayerControlView.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(com.google.android.exoplayer2.ui.StyledPlayerControlView.SubSettingViewHolder subSettingViewHolder, int i) {
            if (this.n != null) {
                subSettingViewHolder.n.setText(this.n.get(i));
            }
            subSettingViewHolder.t.setVisibility(i == this.t ? 0 : 4);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.ui.StyledPlayerControlView.SubSettingViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
            return com.google.android.exoplayer2.ui.StyledPlayerControlView.this.new SubSettingViewHolder(android.view.LayoutInflater.from(com.google.android.exoplayer2.ui.StyledPlayerControlView.this.getContext()).inflate(com.google.android.exoplayer2.ui.R.layout.exo_styled_sub_settings_list_item, (android.view.ViewGroup) null));
        }

        public void c(int i) {
            this.t = i;
        }

        public void d(@androidx.annotation.Nullable java.util.List<java.lang.String> list) {
            this.n = list;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            java.util.List<java.lang.String> list = this.n;
            if (list != null) {
                return list.size();
            }
            return 0;
        }
    }

    public final class TextTrackSelectionAdapter extends com.google.android.exoplayer2.ui.StyledPlayerControlView.TrackSelectionAdapter {
        public TextTrackSelectionAdapter() {
            super();
        }

        public /* synthetic */ TextTrackSelectionAdapter(com.google.android.exoplayer2.ui.StyledPlayerControlView styledPlayerControlView, com.google.android.exoplayer2.ui.StyledPlayerControlView.AnonymousClass1 anonymousClass1) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i(android.view.View view) {
            if (com.google.android.exoplayer2.ui.StyledPlayerControlView.this.Q0 != null) {
                com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder buildUpon = com.google.android.exoplayer2.ui.StyledPlayerControlView.this.Q0.getParameters().buildUpon();
                for (int i = 0; i < this.n.size(); i++) {
                    int intValue = this.n.get(i).intValue();
                    buildUpon = buildUpon.clearSelectionOverrides(intValue).setRendererDisabled(intValue, true);
                }
                ((com.google.android.exoplayer2.trackselection.DefaultTrackSelector) com.google.android.exoplayer2.util.Assertions.checkNotNull(com.google.android.exoplayer2.ui.StyledPlayerControlView.this.Q0)).setParameters(buildUpon);
                com.google.android.exoplayer2.ui.StyledPlayerControlView.this.J0.dismiss();
            }
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.TrackSelectionAdapter
        public void b(java.util.List<java.lang.Integer> list, java.util.List<com.google.android.exoplayer2.ui.StyledPlayerControlView.TrackInfo> list2, com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo mappedTrackInfo) {
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= list2.size()) {
                    break;
                }
                if (list2.get(i).e) {
                    z = true;
                    break;
                }
                i++;
            }
            if (com.google.android.exoplayer2.ui.StyledPlayerControlView.this.U0 != null) {
                android.widget.ImageView imageView = com.google.android.exoplayer2.ui.StyledPlayerControlView.this.U0;
                com.google.android.exoplayer2.ui.StyledPlayerControlView styledPlayerControlView = com.google.android.exoplayer2.ui.StyledPlayerControlView.this;
                imageView.setImageDrawable(z ? styledPlayerControlView.b0 : styledPlayerControlView.c0);
                com.google.android.exoplayer2.ui.StyledPlayerControlView.this.U0.setContentDescription(z ? com.google.android.exoplayer2.ui.StyledPlayerControlView.this.d0 : com.google.android.exoplayer2.ui.StyledPlayerControlView.this.e0);
            }
            this.n = list;
            this.t = list2;
            this.u = mappedTrackInfo;
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.TrackSelectionAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(com.google.android.exoplayer2.ui.StyledPlayerControlView.TrackSelectionViewHolder trackSelectionViewHolder, int i) {
            super.onBindViewHolder(trackSelectionViewHolder, i);
            if (i > 0) {
                trackSelectionViewHolder.t.setVisibility(this.t.get(i + (-1)).e ? 0 : 4);
            }
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.TrackSelectionAdapter
        public void e(com.google.android.exoplayer2.ui.StyledPlayerControlView.TrackSelectionViewHolder trackSelectionViewHolder) {
            boolean z;
            trackSelectionViewHolder.n.setText(com.google.android.exoplayer2.ui.R.string.exo_track_selection_none);
            int i = 0;
            while (true) {
                if (i >= this.t.size()) {
                    z = true;
                    break;
                } else {
                    if (this.t.get(i).e) {
                        z = false;
                        break;
                    }
                    i++;
                }
            }
            trackSelectionViewHolder.t.setVisibility(z ? 0 : 4);
            trackSelectionViewHolder.itemView.setOnClickListener(new com.google.android.exoplayer2.ui.f(this));
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.TrackSelectionAdapter
        public void g(java.lang.String str) {
        }
    }

    public static final class TrackInfo {
        public final int a;
        public final int b;
        public final int c;
        public final java.lang.String d;
        public final boolean e;

        public TrackInfo(int i, int i2, int i3, java.lang.String str, boolean z) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = str;
            this.e = z;
        }
    }

    public abstract class TrackSelectionAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.google.android.exoplayer2.ui.StyledPlayerControlView.TrackSelectionViewHolder> {
        public java.util.List<java.lang.Integer> n = new java.util.ArrayList();
        public java.util.List<com.google.android.exoplayer2.ui.StyledPlayerControlView.TrackInfo> t = new java.util.ArrayList();

        @androidx.annotation.Nullable
        public com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo u = null;

        public TrackSelectionAdapter() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(com.google.android.exoplayer2.ui.StyledPlayerControlView.TrackInfo trackInfo, android.view.View view) {
            if (this.u == null || com.google.android.exoplayer2.ui.StyledPlayerControlView.this.Q0 == null) {
                return;
            }
            com.google.android.exoplayer2.trackselection.DefaultTrackSelector.ParametersBuilder buildUpon = com.google.android.exoplayer2.ui.StyledPlayerControlView.this.Q0.getParameters().buildUpon();
            for (int i = 0; i < this.n.size(); i++) {
                int intValue = this.n.get(i).intValue();
                buildUpon = intValue == trackInfo.a ? buildUpon.setSelectionOverride(intValue, ((com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.u)).getTrackGroups(intValue), new com.google.android.exoplayer2.trackselection.DefaultTrackSelector.SelectionOverride(trackInfo.b, trackInfo.c)).setRendererDisabled(intValue, false) : buildUpon.clearSelectionOverrides(intValue).setRendererDisabled(intValue, true);
            }
            ((com.google.android.exoplayer2.trackselection.DefaultTrackSelector) com.google.android.exoplayer2.util.Assertions.checkNotNull(com.google.android.exoplayer2.ui.StyledPlayerControlView.this.Q0)).setParameters(buildUpon);
            g(trackInfo.d);
            com.google.android.exoplayer2.ui.StyledPlayerControlView.this.J0.dismiss();
        }

        public abstract void b(java.util.List<java.lang.Integer> list, java.util.List<com.google.android.exoplayer2.ui.StyledPlayerControlView.TrackInfo> list2, com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo mappedTrackInfo);

        public void clear() {
            this.t = java.util.Collections.emptyList();
            this.u = null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: d */
        public void onBindViewHolder(com.google.android.exoplayer2.ui.StyledPlayerControlView.TrackSelectionViewHolder trackSelectionViewHolder, int i) {
            if (com.google.android.exoplayer2.ui.StyledPlayerControlView.this.Q0 == null || this.u == null) {
                return;
            }
            if (i == 0) {
                e(trackSelectionViewHolder);
                return;
            }
            com.google.android.exoplayer2.ui.StyledPlayerControlView.TrackInfo trackInfo = this.t.get(i - 1);
            boolean z = ((com.google.android.exoplayer2.trackselection.DefaultTrackSelector) com.google.android.exoplayer2.util.Assertions.checkNotNull(com.google.android.exoplayer2.ui.StyledPlayerControlView.this.Q0)).getParameters().hasSelectionOverride(trackInfo.a, this.u.getTrackGroups(trackInfo.a)) && trackInfo.e;
            trackSelectionViewHolder.n.setText(trackInfo.d);
            trackSelectionViewHolder.t.setVisibility(z ? 0 : 4);
            trackSelectionViewHolder.itemView.setOnClickListener(new com.google.android.exoplayer2.ui.g(this, trackInfo));
        }

        public abstract void e(com.google.android.exoplayer2.ui.StyledPlayerControlView.TrackSelectionViewHolder trackSelectionViewHolder);

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public com.google.android.exoplayer2.ui.StyledPlayerControlView.TrackSelectionViewHolder onCreateViewHolder(android.view.ViewGroup viewGroup, int i) {
            return new com.google.android.exoplayer2.ui.StyledPlayerControlView.TrackSelectionViewHolder(android.view.LayoutInflater.from(com.google.android.exoplayer2.ui.StyledPlayerControlView.this.getContext()).inflate(com.google.android.exoplayer2.ui.R.layout.exo_styled_sub_settings_list_item, (android.view.ViewGroup) null));
        }

        public abstract void g(java.lang.String str);

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (this.t.isEmpty()) {
                return 0;
            }
            return this.t.size() + 1;
        }
    }

    public static class TrackSelectionViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        public final android.widget.TextView n;
        public final android.view.View t;

        public TrackSelectionViewHolder(android.view.View view) {
            super(view);
            this.n = (android.widget.TextView) view.findViewById(com.google.android.exoplayer2.ui.R.id.exo_text);
            this.t = view.findViewById(com.google.android.exoplayer2.ui.R.id.exo_check);
        }
    }

    public interface VisibilityListener {
        void onVisibilityChange(int i);
    }

    static {
        com.google.android.exoplayer2.ExoPlayerLibraryInfo.registerModule("goog.exo.ui");
    }

    public StyledPlayerControlView(android.content.Context context) {
        this(context, null);
    }

    public StyledPlayerControlView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StyledPlayerControlView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, attributeSet);
    }

    public StyledPlayerControlView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i, @androidx.annotation.Nullable android.util.AttributeSet attributeSet2) {
        super(context, attributeSet, i);
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        com.google.android.exoplayer2.ui.StyledPlayerControlView.ComponentListener componentListener;
        boolean z9;
        boolean z10;
        int i2 = com.google.android.exoplayer2.ui.R.layout.exo_styled_player_control_view;
        this.B0 = 5000L;
        this.C0 = 15000L;
        this.t0 = 5000;
        this.v0 = 0;
        this.u0 = 200;
        if (attributeSet2 != null) {
            android.content.res.TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, com.google.android.exoplayer2.ui.R.styleable.StyledPlayerControlView, 0, 0);
            try {
                this.B0 = obtainStyledAttributes.getInt(com.google.android.exoplayer2.ui.R.styleable.StyledPlayerControlView_rewind_increment, (int) this.B0);
                this.C0 = obtainStyledAttributes.getInt(com.google.android.exoplayer2.ui.R.styleable.StyledPlayerControlView_fastforward_increment, (int) this.C0);
                i2 = obtainStyledAttributes.getResourceId(com.google.android.exoplayer2.ui.R.styleable.StyledPlayerControlView_controller_layout_id, i2);
                this.t0 = obtainStyledAttributes.getInt(com.google.android.exoplayer2.ui.R.styleable.StyledPlayerControlView_show_timeout, this.t0);
                this.v0 = W(obtainStyledAttributes, this.v0);
                boolean z11 = obtainStyledAttributes.getBoolean(com.google.android.exoplayer2.ui.R.styleable.StyledPlayerControlView_show_rewind_button, true);
                boolean z12 = obtainStyledAttributes.getBoolean(com.google.android.exoplayer2.ui.R.styleable.StyledPlayerControlView_show_fastforward_button, true);
                boolean z13 = obtainStyledAttributes.getBoolean(com.google.android.exoplayer2.ui.R.styleable.StyledPlayerControlView_show_previous_button, true);
                boolean z14 = obtainStyledAttributes.getBoolean(com.google.android.exoplayer2.ui.R.styleable.StyledPlayerControlView_show_next_button, true);
                boolean z15 = obtainStyledAttributes.getBoolean(com.google.android.exoplayer2.ui.R.styleable.StyledPlayerControlView_show_shuffle_button, false);
                boolean z16 = obtainStyledAttributes.getBoolean(com.google.android.exoplayer2.ui.R.styleable.StyledPlayerControlView_show_subtitle_button, false);
                boolean z17 = obtainStyledAttributes.getBoolean(com.google.android.exoplayer2.ui.R.styleable.StyledPlayerControlView_show_vr_button, false);
                setTimeBarMinUpdateInterval(obtainStyledAttributes.getInt(com.google.android.exoplayer2.ui.R.styleable.StyledPlayerControlView_time_bar_min_update_interval, this.u0));
                boolean z18 = obtainStyledAttributes.getBoolean(com.google.android.exoplayer2.ui.R.styleable.StyledPlayerControlView_animation_enabled, true);
                obtainStyledAttributes.recycle();
                z7 = z15;
                z8 = z16;
                z3 = z11;
                z4 = z12;
                z5 = z13;
                z = z18;
                z6 = z14;
                z2 = z17;
            } catch (java.lang.Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            z = true;
            z2 = false;
            z3 = true;
            z4 = true;
            z5 = true;
            z6 = true;
            z7 = false;
            z8 = false;
        }
        android.view.LayoutInflater.from(context).inflate(i2, this);
        setDescendantFocusability(262144);
        com.google.android.exoplayer2.ui.StyledPlayerControlView.ComponentListener componentListener2 = new com.google.android.exoplayer2.ui.StyledPlayerControlView.ComponentListener(this, null);
        this.n = componentListener2;
        this.t = new java.util.concurrent.CopyOnWriteArrayList<>();
        this.J = new com.google.android.exoplayer2.Timeline.Period();
        this.K = new com.google.android.exoplayer2.Timeline.Window();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        this.H = sb;
        this.I = new java.util.Formatter(sb, java.util.Locale.getDefault());
        this.w0 = new long[0];
        this.x0 = new boolean[0];
        this.y0 = new long[0];
        this.z0 = new boolean[0];
        boolean z19 = z3;
        this.k0 = new com.google.android.exoplayer2.DefaultControlDispatcher(this.C0, this.B0);
        this.L = new defpackage.fs2(this);
        this.E = (android.widget.TextView) findViewById(com.google.android.exoplayer2.ui.R.id.exo_duration);
        this.F = (android.widget.TextView) findViewById(com.google.android.exoplayer2.ui.R.id.exo_position);
        android.widget.ImageView imageView = (android.widget.ImageView) findViewById(com.google.android.exoplayer2.ui.R.id.exo_subtitle);
        this.U0 = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(componentListener2);
        }
        android.widget.ImageView imageView2 = (android.widget.ImageView) findViewById(com.google.android.exoplayer2.ui.R.id.exo_fullscreen);
        this.V0 = imageView2;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
            this.V0.setOnClickListener(new defpackage.gs2(this));
        }
        android.view.View findViewById = findViewById(com.google.android.exoplayer2.ui.R.id.exo_settings);
        this.W0 = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(componentListener2);
        }
        int i3 = com.google.android.exoplayer2.ui.R.id.exo_progress;
        com.google.android.exoplayer2.ui.TimeBar timeBar = (com.google.android.exoplayer2.ui.TimeBar) findViewById(i3);
        android.view.View findViewById2 = findViewById(com.google.android.exoplayer2.ui.R.id.exo_progress_placeholder);
        if (timeBar != null) {
            this.G = timeBar;
            componentListener = componentListener2;
            z9 = z;
            z10 = z2;
        } else if (findViewById2 != null) {
            componentListener = componentListener2;
            z9 = z;
            z10 = z2;
            com.google.android.exoplayer2.ui.DefaultTimeBar defaultTimeBar = new com.google.android.exoplayer2.ui.DefaultTimeBar(context, null, 0, attributeSet2, com.google.android.exoplayer2.ui.R.style.ExoStyledControls_TimeBar);
            defaultTimeBar.setId(i3);
            defaultTimeBar.setLayoutParams(findViewById2.getLayoutParams());
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) findViewById2.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById2);
            viewGroup.removeView(findViewById2);
            viewGroup.addView(defaultTimeBar, indexOfChild);
            this.G = defaultTimeBar;
        } else {
            componentListener = componentListener2;
            z9 = z;
            z10 = z2;
            this.G = null;
        }
        com.google.android.exoplayer2.ui.TimeBar timeBar2 = this.G;
        com.google.android.exoplayer2.ui.StyledPlayerControlView.ComponentListener componentListener3 = componentListener;
        if (timeBar2 != null) {
            timeBar2.addListener(componentListener3);
        }
        android.view.View findViewById3 = findViewById(com.google.android.exoplayer2.ui.R.id.exo_play_pause);
        this.w = findViewById3;
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(componentListener3);
        }
        android.view.View findViewById4 = findViewById(com.google.android.exoplayer2.ui.R.id.exo_prev);
        this.u = findViewById4;
        if (findViewById4 != null) {
            findViewById4.setOnClickListener(componentListener3);
        }
        android.view.View findViewById5 = findViewById(com.google.android.exoplayer2.ui.R.id.exo_next);
        this.v = findViewById5;
        if (findViewById5 != null) {
            findViewById5.setOnClickListener(componentListener3);
        }
        android.graphics.Typeface font = androidx.core.content.res.ResourcesCompat.getFont(context, com.google.android.exoplayer2.ui.R.font.roboto_medium_numbers);
        android.view.View findViewById6 = findViewById(com.google.android.exoplayer2.ui.R.id.exo_rew);
        android.widget.TextView textView = findViewById6 == null ? (android.widget.TextView) findViewById(com.google.android.exoplayer2.ui.R.id.exo_rew_with_amount) : null;
        this.A = textView;
        if (textView != null) {
            textView.setTypeface(font);
        }
        findViewById6 = findViewById6 == null ? textView : findViewById6;
        this.y = findViewById6;
        if (findViewById6 != null) {
            findViewById6.setOnClickListener(componentListener3);
        }
        android.view.View findViewById7 = findViewById(com.google.android.exoplayer2.ui.R.id.exo_ffwd);
        android.widget.TextView textView2 = findViewById7 == null ? (android.widget.TextView) findViewById(com.google.android.exoplayer2.ui.R.id.exo_ffwd_with_amount) : null;
        this.z = textView2;
        if (textView2 != null) {
            textView2.setTypeface(font);
        }
        findViewById7 = findViewById7 == null ? textView2 : findViewById7;
        this.x = findViewById7;
        if (findViewById7 != null) {
            findViewById7.setOnClickListener(componentListener3);
        }
        android.widget.ImageView imageView3 = (android.widget.ImageView) findViewById(com.google.android.exoplayer2.ui.R.id.exo_repeat_toggle);
        this.B = imageView3;
        if (imageView3 != null) {
            imageView3.setOnClickListener(componentListener3);
        }
        android.widget.ImageView imageView4 = (android.widget.ImageView) findViewById(com.google.android.exoplayer2.ui.R.id.exo_shuffle);
        this.C = imageView4;
        if (imageView4 != null) {
            imageView4.setOnClickListener(componentListener3);
        }
        this.E0 = context.getResources();
        this.U = r2.getInteger(com.google.android.exoplayer2.ui.R.integer.exo_media_button_opacity_percentage_enabled) / 100.0f;
        this.V = this.E0.getInteger(com.google.android.exoplayer2.ui.R.integer.exo_media_button_opacity_percentage_disabled) / 100.0f;
        android.view.View findViewById8 = findViewById(com.google.android.exoplayer2.ui.R.id.exo_vr);
        this.D = findViewById8;
        if (findViewById8 != null) {
            j0(false, findViewById8);
        }
        com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager = new com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager(this);
        this.D0 = styledPlayerControlViewLayoutManager;
        styledPlayerControlViewLayoutManager.V(z9);
        this.H0 = new com.google.android.exoplayer2.ui.StyledPlayerControlView.SettingsAdapter(new java.lang.String[]{this.E0.getString(com.google.android.exoplayer2.ui.R.string.exo_controls_playback_speed), this.E0.getString(com.google.android.exoplayer2.ui.R.string.exo_track_selection_title_audio)}, new android.graphics.drawable.Drawable[]{this.E0.getDrawable(com.google.android.exoplayer2.ui.R.drawable.exo_styled_controls_speed), this.E0.getDrawable(com.google.android.exoplayer2.ui.R.drawable.exo_styled_controls_audiotrack)});
        this.K0 = new java.util.ArrayList(java.util.Arrays.asList(this.E0.getStringArray(com.google.android.exoplayer2.ui.R.array.exo_playback_speeds)));
        this.L0 = new java.util.ArrayList();
        for (int i4 : this.E0.getIntArray(com.google.android.exoplayer2.ui.R.array.exo_speed_multiplied_by_100)) {
            this.L0.add(java.lang.Integer.valueOf(i4));
        }
        this.N0 = this.L0.indexOf(100);
        this.M0 = -1;
        this.P0 = this.E0.getDimensionPixelSize(com.google.android.exoplayer2.ui.R.dimen.exo_settings_offset);
        com.google.android.exoplayer2.ui.StyledPlayerControlView.SubSettingsAdapter subSettingsAdapter = new com.google.android.exoplayer2.ui.StyledPlayerControlView.SubSettingsAdapter(this, null);
        this.I0 = subSettingsAdapter;
        subSettingsAdapter.c(-1);
        androidx.recyclerview.widget.RecyclerView recyclerView = (androidx.recyclerview.widget.RecyclerView) android.view.LayoutInflater.from(context).inflate(com.google.android.exoplayer2.ui.R.layout.exo_styled_settings_list, (android.view.ViewGroup) null);
        this.G0 = recyclerView;
        recyclerView.setAdapter(this.H0);
        this.G0.setLayoutManager(new androidx.recyclerview.widget.LinearLayoutManager(getContext()));
        android.widget.PopupWindow popupWindow = new android.widget.PopupWindow((android.view.View) this.G0, -2, -2, true);
        this.J0 = popupWindow;
        popupWindow.setOnDismissListener(this.n);
        this.O0 = true;
        this.T0 = new com.google.android.exoplayer2.ui.DefaultTrackNameProvider(getResources());
        this.b0 = this.E0.getDrawable(com.google.android.exoplayer2.ui.R.drawable.exo_styled_controls_subtitle_on);
        this.c0 = this.E0.getDrawable(com.google.android.exoplayer2.ui.R.drawable.exo_styled_controls_subtitle_off);
        this.d0 = this.E0.getString(com.google.android.exoplayer2.ui.R.string.exo_controls_cc_enabled_description);
        this.e0 = this.E0.getString(com.google.android.exoplayer2.ui.R.string.exo_controls_cc_disabled_description);
        this.R0 = new com.google.android.exoplayer2.ui.StyledPlayerControlView.TextTrackSelectionAdapter(this, null);
        this.S0 = new com.google.android.exoplayer2.ui.StyledPlayerControlView.AudioTrackSelectionAdapter(this, null);
        this.f0 = this.E0.getDrawable(com.google.android.exoplayer2.ui.R.drawable.exo_styled_controls_fullscreen_exit);
        this.g0 = this.E0.getDrawable(com.google.android.exoplayer2.ui.R.drawable.exo_styled_controls_fullscreen_enter);
        this.M = this.E0.getDrawable(com.google.android.exoplayer2.ui.R.drawable.exo_styled_controls_repeat_off);
        this.N = this.E0.getDrawable(com.google.android.exoplayer2.ui.R.drawable.exo_styled_controls_repeat_one);
        this.O = this.E0.getDrawable(com.google.android.exoplayer2.ui.R.drawable.exo_styled_controls_repeat_all);
        this.S = this.E0.getDrawable(com.google.android.exoplayer2.ui.R.drawable.exo_styled_controls_shuffle_on);
        this.T = this.E0.getDrawable(com.google.android.exoplayer2.ui.R.drawable.exo_styled_controls_shuffle_off);
        this.h0 = this.E0.getString(com.google.android.exoplayer2.ui.R.string.exo_controls_fullscreen_exit_description);
        this.i0 = this.E0.getString(com.google.android.exoplayer2.ui.R.string.exo_controls_fullscreen_enter_description);
        this.P = this.E0.getString(com.google.android.exoplayer2.ui.R.string.exo_controls_repeat_off_description);
        this.Q = this.E0.getString(com.google.android.exoplayer2.ui.R.string.exo_controls_repeat_one_description);
        this.R = this.E0.getString(com.google.android.exoplayer2.ui.R.string.exo_controls_repeat_all_description);
        this.W = this.E0.getString(com.google.android.exoplayer2.ui.R.string.exo_controls_shuffle_on_description);
        this.a0 = this.E0.getString(com.google.android.exoplayer2.ui.R.string.exo_controls_shuffle_off_description);
        this.D0.W((android.view.ViewGroup) findViewById(com.google.android.exoplayer2.ui.R.id.exo_bottom_bar), true);
        this.D0.W(this.x, z4);
        this.D0.W(this.y, z19);
        this.D0.W(this.u, z5);
        this.D0.W(this.v, z6);
        this.D0.W(this.C, z7);
        this.D0.W(this.U0, z8);
        this.D0.W(this.D, z10);
        this.D0.W(this.B, this.v0 != 0);
        addOnLayoutChangeListener(new defpackage.hs2(this));
    }

    public static boolean Q(com.google.android.exoplayer2.Timeline timeline, com.google.android.exoplayer2.Timeline.Window window) {
        if (timeline.getWindowCount() > 100) {
            return false;
        }
        int windowCount = timeline.getWindowCount();
        for (int i = 0; i < windowCount; i++) {
            if (timeline.getWindow(i, window).durationUs == -9223372036854775807L) {
                return false;
            }
        }
        return true;
    }

    public static int W(android.content.res.TypedArray typedArray, int i) {
        return typedArray.getInt(com.google.android.exoplayer2.ui.R.styleable.StyledPlayerControlView_repeat_toggle_modes, i);
    }

    @android.annotation.SuppressLint({"InlinedApi"})
    public static boolean Y(int i) {
        return i == 90 || i == 89 || i == 85 || i == 79 || i == 126 || i == 127 || i == 87 || i == 88;
    }

    private void setPlaybackSpeed(float f) {
        com.google.android.exoplayer2.Player player = this.j0;
        if (player == null) {
            return;
        }
        player.setPlaybackParameters(new com.google.android.exoplayer2.PlaybackParameters(f));
    }

    public final void R(com.google.android.exoplayer2.Player player) {
        this.k0.dispatchSetPlayWhenReady(player, false);
    }

    public final void S(com.google.android.exoplayer2.Player player) {
        int playbackState = player.getPlaybackState();
        if (playbackState == 1) {
            com.google.android.exoplayer2.PlaybackPreparer playbackPreparer = this.m0;
            if (playbackPreparer != null) {
                playbackPreparer.preparePlayback();
            }
        } else if (playbackState == 4) {
            f0(player, player.getCurrentWindowIndex(), -9223372036854775807L);
        }
        this.k0.dispatchSetPlayWhenReady(player, true);
    }

    public final void T(com.google.android.exoplayer2.Player player) {
        int playbackState = player.getPlaybackState();
        if (playbackState == 1 || playbackState == 4 || !player.getPlayWhenReady()) {
            S(player);
        } else {
            R(player);
        }
    }

    public final void U(androidx.recyclerview.widget.RecyclerView.Adapter<?> adapter) {
        this.G0.setAdapter(adapter);
        r0();
        this.O0 = false;
        this.J0.dismiss();
        this.O0 = true;
        this.J0.showAsDropDown(this, (getWidth() - this.J0.getWidth()) - this.P0, (-this.J0.getHeight()) - this.P0);
    }

    public final void V(com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo mappedTrackInfo, int i, java.util.List<com.google.android.exoplayer2.ui.StyledPlayerControlView.TrackInfo> list) {
        com.google.android.exoplayer2.source.TrackGroupArray trackGroups = mappedTrackInfo.getTrackGroups(i);
        com.google.android.exoplayer2.trackselection.TrackSelection trackSelection = ((com.google.android.exoplayer2.Player) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.j0)).getCurrentTrackSelections().get(i);
        for (int i2 = 0; i2 < trackGroups.length; i2++) {
            com.google.android.exoplayer2.source.TrackGroup trackGroup = trackGroups.get(i2);
            for (int i3 = 0; i3 < trackGroup.length; i3++) {
                com.google.android.exoplayer2.Format format = trackGroup.getFormat(i3);
                if (mappedTrackInfo.getTrackSupport(i, i2, i3) == 4) {
                    list.add(new com.google.android.exoplayer2.ui.StyledPlayerControlView.TrackInfo(i, i2, i3, this.T0.getTrackName(format), (trackSelection == null || trackSelection.indexOf(format) == -1) ? false : true));
                }
            }
        }
    }

    public final void X() {
        com.google.android.exoplayer2.trackselection.DefaultTrackSelector defaultTrackSelector;
        com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo currentMappedTrackInfo;
        this.R0.clear();
        this.S0.clear();
        if (this.j0 == null || (defaultTrackSelector = this.Q0) == null || (currentMappedTrackInfo = defaultTrackSelector.getCurrentMappedTrackInfo()) == null) {
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.ArrayList arrayList2 = new java.util.ArrayList();
        java.util.ArrayList arrayList3 = new java.util.ArrayList();
        java.util.ArrayList arrayList4 = new java.util.ArrayList();
        for (int i = 0; i < currentMappedTrackInfo.getRendererCount(); i++) {
            if (currentMappedTrackInfo.getRendererType(i) == 3 && this.D0.y(this.U0)) {
                V(currentMappedTrackInfo, i, arrayList);
                arrayList3.add(java.lang.Integer.valueOf(i));
            } else if (currentMappedTrackInfo.getRendererType(i) == 1) {
                V(currentMappedTrackInfo, i, arrayList2);
                arrayList4.add(java.lang.Integer.valueOf(i));
            }
        }
        this.R0.b(arrayList3, arrayList, currentMappedTrackInfo);
        this.S0.b(arrayList4, arrayList2, currentMappedTrackInfo);
    }

    public void Z() {
        java.util.Iterator<com.google.android.exoplayer2.ui.StyledPlayerControlView.VisibilityListener> it = this.t.iterator();
        while (it.hasNext()) {
            it.next().onVisibilityChange(getVisibility());
        }
    }

    public final void a0(android.view.View view) {
        android.widget.ImageView imageView;
        if (this.n0 == null || (imageView = this.V0) == null) {
            return;
        }
        boolean z = !this.o0;
        this.o0 = z;
        if (z) {
            imageView.setImageDrawable(this.f0);
            this.V0.setContentDescription(this.h0);
        } else {
            imageView.setImageDrawable(this.g0);
            this.V0.setContentDescription(this.i0);
        }
        com.google.android.exoplayer2.ui.StyledPlayerControlView.OnFullScreenModeChangedListener onFullScreenModeChangedListener = this.n0;
        if (onFullScreenModeChangedListener != null) {
            onFullScreenModeChangedListener.onFullScreenModeChanged(this.o0);
        }
    }

    public void addVisibilityListener(com.google.android.exoplayer2.ui.StyledPlayerControlView.VisibilityListener visibilityListener) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(visibilityListener);
        this.t.add(visibilityListener);
    }

    public final void b0(android.view.View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9 = i4 - i2;
        int i10 = i8 - i6;
        if (!(i3 - i == i7 - i5 && i9 == i10) && this.J0.isShowing()) {
            r0();
            this.J0.update(view, (getWidth() - this.J0.getWidth()) - this.P0, (-this.J0.getHeight()) - this.P0, -1, -1);
        }
    }

    public final void c0(int i) {
        if (i == 0) {
            this.I0.d(this.K0);
            this.I0.c(this.N0);
            this.F0 = 0;
            U(this.I0);
            return;
        }
        if (i != 1) {
            this.J0.dismiss();
        } else {
            this.F0 = 1;
            U(this.S0);
        }
    }

    public final void d0(int i) {
        if (this.F0 == 0 && i != this.N0) {
            setPlaybackSpeed(this.L0.get(i).intValue() / 100.0f);
        }
        this.J0.dismiss();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(android.view.KeyEvent keyEvent) {
        return dispatchMediaKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchMediaKeyEvent(android.view.KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        com.google.android.exoplayer2.Player player = this.j0;
        if (player == null || !Y(keyCode)) {
            return false;
        }
        if (keyEvent.getAction() != 0) {
            return true;
        }
        if (keyCode == 90) {
            if (player.getPlaybackState() == 4) {
                return true;
            }
            this.k0.dispatchFastForward(player);
            return true;
        }
        if (keyCode == 89) {
            this.k0.dispatchRewind(player);
            return true;
        }
        if (keyEvent.getRepeatCount() != 0) {
            return true;
        }
        if (keyCode == 79 || keyCode == 85) {
            T(player);
            return true;
        }
        if (keyCode == 87) {
            this.k0.dispatchNext(player);
            return true;
        }
        if (keyCode == 88) {
            this.k0.dispatchPrevious(player);
            return true;
        }
        if (keyCode == 126) {
            S(player);
            return true;
        }
        if (keyCode != 127) {
            return true;
        }
        R(player);
        return true;
    }

    public void e0() {
        android.view.View view = this.w;
        if (view != null) {
            view.requestFocus();
        }
    }

    public final boolean f0(com.google.android.exoplayer2.Player player, int i, long j) {
        return this.k0.dispatchSeekTo(player, i, j);
    }

    public final void g0(com.google.android.exoplayer2.Player player, long j) {
        int currentWindowIndex;
        com.google.android.exoplayer2.Timeline currentTimeline = player.getCurrentTimeline();
        if (this.r0 && !currentTimeline.isEmpty()) {
            int windowCount = currentTimeline.getWindowCount();
            currentWindowIndex = 0;
            while (true) {
                long durationMs = currentTimeline.getWindow(currentWindowIndex, this.K).getDurationMs();
                if (j < durationMs) {
                    break;
                }
                if (currentWindowIndex == windowCount - 1) {
                    j = durationMs;
                    break;
                } else {
                    j -= durationMs;
                    currentWindowIndex++;
                }
            }
        } else {
            currentWindowIndex = player.getCurrentWindowIndex();
        }
        if (f0(player, currentWindowIndex, j)) {
            return;
        }
        n0();
    }

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.Player getPlayer() {
        return this.j0;
    }

    public int getRepeatToggleModes() {
        return this.v0;
    }

    public boolean getShowShuffleButton() {
        return this.D0.y(this.C);
    }

    public boolean getShowSubtitleButton() {
        return this.D0.y(this.U0);
    }

    public int getShowTimeoutMs() {
        return this.t0;
    }

    public boolean getShowVrButton() {
        return this.D0.y(this.D);
    }

    public final boolean h0() {
        com.google.android.exoplayer2.Player player = this.j0;
        return (player == null || player.getPlaybackState() == 4 || this.j0.getPlaybackState() == 1 || !this.j0.getPlayWhenReady()) ? false : true;
    }

    public void hide() {
        this.D0.A();
    }

    public void hideImmediately() {
        this.D0.D();
    }

    public void i0() {
        m0();
        l0();
        o0();
        s0();
        u0();
        t0();
    }

    public boolean isAnimationEnabled() {
        return this.D0.G();
    }

    public boolean isFullyVisible() {
        return this.D0.H();
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    public final void j0(boolean z, @androidx.annotation.Nullable android.view.View view) {
        if (view == null) {
            return;
        }
        view.setEnabled(z);
        view.setAlpha(z ? this.U : this.V);
    }

    public final void k0() {
        com.google.android.exoplayer2.ControlDispatcher controlDispatcher = this.k0;
        if (controlDispatcher instanceof com.google.android.exoplayer2.DefaultControlDispatcher) {
            this.C0 = ((com.google.android.exoplayer2.DefaultControlDispatcher) controlDispatcher).getFastForwardIncrementMs();
        }
        int i = (int) (this.C0 / 1000);
        android.widget.TextView textView = this.z;
        if (textView != null) {
            textView.setText(java.lang.String.valueOf(i));
        }
        android.view.View view = this.x;
        if (view != null) {
            view.setContentDescription(this.E0.getQuantityString(com.google.android.exoplayer2.ui.R.plurals.exo_controls_fastforward_by_amount_description, i, java.lang.Integer.valueOf(i)));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void l0() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        com.google.android.exoplayer2.ui.TimeBar timeBar;
        if (!isVisible() || !this.p0) {
            return;
        }
        com.google.android.exoplayer2.Player player = this.j0;
        if (player != null) {
            com.google.android.exoplayer2.Timeline currentTimeline = player.getCurrentTimeline();
            if (!currentTimeline.isEmpty() && !player.isPlayingAd()) {
                currentTimeline.getWindow(player.getCurrentWindowIndex(), this.K);
                com.google.android.exoplayer2.Timeline.Window window = this.K;
                z3 = window.isSeekable;
                z2 = z3 || !window.isDynamic || player.hasPrevious();
                boolean z5 = z3 && this.k0.isRewindEnabled();
                z4 = z3 && this.k0.isFastForwardEnabled();
                z = this.K.isDynamic || player.hasNext();
                r1 = z5;
                if (r1) {
                    p0();
                }
                if (z4) {
                    k0();
                }
                j0(z2, this.u);
                j0(r1, this.y);
                j0(z4, this.x);
                j0(z, this.v);
                timeBar = this.G;
                if (timeBar == null) {
                    timeBar.setEnabled(z3);
                    return;
                }
                return;
            }
        }
        z = false;
        z2 = false;
        z3 = false;
        z4 = false;
        if (r1) {
        }
        if (z4) {
        }
        j0(z2, this.u);
        j0(r1, this.y);
        j0(z4, this.x);
        j0(z, this.v);
        timeBar = this.G;
        if (timeBar == null) {
        }
    }

    public final void m0() {
        if (isVisible() && this.p0 && this.w != null) {
            if (h0()) {
                ((android.widget.ImageView) this.w).setImageDrawable(this.E0.getDrawable(com.google.android.exoplayer2.ui.R.drawable.exo_styled_controls_pause));
                this.w.setContentDescription(this.E0.getString(com.google.android.exoplayer2.ui.R.string.exo_controls_pause_description));
            } else {
                ((android.widget.ImageView) this.w).setImageDrawable(this.E0.getDrawable(com.google.android.exoplayer2.ui.R.drawable.exo_styled_controls_play));
                this.w.setContentDescription(this.E0.getString(com.google.android.exoplayer2.ui.R.string.exo_controls_play_description));
            }
        }
    }

    public final void n0() {
        long j;
        long j2;
        if (isVisible() && this.p0) {
            com.google.android.exoplayer2.Player player = this.j0;
            if (player != null) {
                j = this.A0 + player.getContentPosition();
                j2 = this.A0 + player.getContentBufferedPosition();
            } else {
                j = 0;
                j2 = 0;
            }
            android.widget.TextView textView = this.F;
            if (textView != null && !this.s0) {
                textView.setText(com.google.android.exoplayer2.util.Util.getStringForTime(this.H, this.I, j));
            }
            com.google.android.exoplayer2.ui.TimeBar timeBar = this.G;
            if (timeBar != null) {
                timeBar.setPosition(j);
                this.G.setBufferedPosition(j2);
            }
            com.google.android.exoplayer2.ui.StyledPlayerControlView.ProgressUpdateListener progressUpdateListener = this.l0;
            if (progressUpdateListener != null) {
                progressUpdateListener.onProgressUpdate(j, j2);
            }
            removeCallbacks(this.L);
            int playbackState = player == null ? 1 : player.getPlaybackState();
            if (player == null || !player.isPlaying()) {
                if (playbackState == 4 || playbackState == 1) {
                    return;
                }
                postDelayed(this.L, 1000L);
                return;
            }
            com.google.android.exoplayer2.ui.TimeBar timeBar2 = this.G;
            long min = java.lang.Math.min(timeBar2 != null ? timeBar2.getPreferredUpdateDelay() : 1000L, 1000 - (j % 1000));
            float f = player.getPlaybackParameters().speed;
            postDelayed(this.L, com.google.android.exoplayer2.util.Util.constrainValue(f > 0.0f ? (long) (min / f) : 1000L, this.u0, 1000L));
        }
    }

    public final void o0() {
        android.widget.ImageView imageView;
        if (isVisible() && this.p0 && (imageView = this.B) != null) {
            if (this.v0 == 0) {
                j0(false, imageView);
                return;
            }
            com.google.android.exoplayer2.Player player = this.j0;
            if (player == null) {
                j0(false, imageView);
                this.B.setImageDrawable(this.M);
                this.B.setContentDescription(this.P);
                return;
            }
            j0(true, imageView);
            int repeatMode = player.getRepeatMode();
            if (repeatMode == 0) {
                this.B.setImageDrawable(this.M);
                this.B.setContentDescription(this.P);
            } else if (repeatMode == 1) {
                this.B.setImageDrawable(this.N);
                this.B.setContentDescription(this.Q);
            } else {
                if (repeatMode != 2) {
                    return;
                }
                this.B.setImageDrawable(this.O);
                this.B.setContentDescription(this.R);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.D0.N();
        this.p0 = true;
        if (isFullyVisible()) {
            this.D0.U();
        }
        i0();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.D0.O();
        this.p0 = false;
        removeCallbacks(this.L);
        this.D0.T();
    }

    public final void p0() {
        com.google.android.exoplayer2.ControlDispatcher controlDispatcher = this.k0;
        if (controlDispatcher instanceof com.google.android.exoplayer2.DefaultControlDispatcher) {
            this.B0 = ((com.google.android.exoplayer2.DefaultControlDispatcher) controlDispatcher).getRewindIncrementMs();
        }
        int i = (int) (this.B0 / 1000);
        android.widget.TextView textView = this.A;
        if (textView != null) {
            textView.setText(java.lang.String.valueOf(i));
        }
        android.view.View view = this.y;
        if (view != null) {
            view.setContentDescription(this.E0.getQuantityString(com.google.android.exoplayer2.ui.R.plurals.exo_controls_rewind_by_amount_description, i, java.lang.Integer.valueOf(i)));
        }
    }

    public final void q0() {
        com.google.android.exoplayer2.Player player = this.j0;
        if (player == null) {
            return;
        }
        float f = player.getPlaybackParameters().speed;
        int round = java.lang.Math.round(100.0f * f);
        int indexOf = this.L0.indexOf(java.lang.Integer.valueOf(round));
        if (indexOf == -1) {
            int i = this.M0;
            if (i != -1) {
                this.L0.remove(i);
                this.K0.remove(this.M0);
                this.M0 = -1;
            }
            indexOf = (-java.util.Collections.binarySearch(this.L0, java.lang.Integer.valueOf(round))) - 1;
            java.lang.String string = this.E0.getString(com.google.android.exoplayer2.ui.R.string.exo_controls_custom_playback_speed, java.lang.Float.valueOf(f));
            this.L0.add(indexOf, java.lang.Integer.valueOf(round));
            this.K0.add(indexOf, string);
            this.M0 = indexOf;
        }
        this.N0 = indexOf;
        this.H0.c(0, this.K0.get(indexOf));
    }

    public final void r0() {
        this.G0.measure(0, 0);
        this.J0.setWidth(java.lang.Math.min(this.G0.getMeasuredWidth(), getWidth() - (this.P0 * 2)));
        this.J0.setHeight(java.lang.Math.min(getHeight() - (this.P0 * 2), this.G0.getMeasuredHeight()));
    }

    public void removeVisibilityListener(com.google.android.exoplayer2.ui.StyledPlayerControlView.VisibilityListener visibilityListener) {
        this.t.remove(visibilityListener);
    }

    public final void s0() {
        android.widget.ImageView imageView;
        if (isVisible() && this.p0 && (imageView = this.C) != null) {
            com.google.android.exoplayer2.Player player = this.j0;
            if (!this.D0.y(imageView)) {
                j0(false, this.C);
                return;
            }
            if (player == null) {
                j0(false, this.C);
                this.C.setImageDrawable(this.T);
                this.C.setContentDescription(this.a0);
            } else {
                j0(true, this.C);
                this.C.setImageDrawable(player.getShuffleModeEnabled() ? this.S : this.T);
                this.C.setContentDescription(player.getShuffleModeEnabled() ? this.W : this.a0);
            }
        }
    }

    public void setAnimationEnabled(boolean z) {
        this.D0.V(z);
    }

    public void setControlDispatcher(com.google.android.exoplayer2.ControlDispatcher controlDispatcher) {
        if (this.k0 != controlDispatcher) {
            this.k0 = controlDispatcher;
            l0();
        }
    }

    public void setExtraAdGroupMarkers(@androidx.annotation.Nullable long[] jArr, @androidx.annotation.Nullable boolean[] zArr) {
        if (jArr == null) {
            this.y0 = new long[0];
            this.z0 = new boolean[0];
        } else {
            boolean[] zArr2 = (boolean[]) com.google.android.exoplayer2.util.Assertions.checkNotNull(zArr);
            com.google.android.exoplayer2.util.Assertions.checkArgument(jArr.length == zArr2.length);
            this.y0 = jArr;
            this.z0 = zArr2;
        }
        t0();
    }

    public void setOnFullScreenModeChangedListener(@androidx.annotation.Nullable com.google.android.exoplayer2.ui.StyledPlayerControlView.OnFullScreenModeChangedListener onFullScreenModeChangedListener) {
        android.widget.ImageView imageView = this.V0;
        if (imageView == null) {
            return;
        }
        this.n0 = onFullScreenModeChangedListener;
        if (onFullScreenModeChangedListener == null) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
        }
    }

    public void setPlaybackPreparer(@androidx.annotation.Nullable com.google.android.exoplayer2.PlaybackPreparer playbackPreparer) {
        this.m0 = playbackPreparer;
    }

    public void setPlayer(@androidx.annotation.Nullable com.google.android.exoplayer2.Player player) {
        boolean z = true;
        com.google.android.exoplayer2.util.Assertions.checkState(android.os.Looper.myLooper() == android.os.Looper.getMainLooper());
        if (player != null && player.getApplicationLooper() != android.os.Looper.getMainLooper()) {
            z = false;
        }
        com.google.android.exoplayer2.util.Assertions.checkArgument(z);
        com.google.android.exoplayer2.Player player2 = this.j0;
        if (player2 == player) {
            return;
        }
        if (player2 != null) {
            player2.removeListener(this.n);
        }
        this.j0 = player;
        if (player != null) {
            player.addListener(this.n);
        }
        if (player == null || !(player.getTrackSelector() instanceof com.google.android.exoplayer2.trackselection.DefaultTrackSelector)) {
            this.Q0 = null;
        } else {
            this.Q0 = (com.google.android.exoplayer2.trackselection.DefaultTrackSelector) player.getTrackSelector();
        }
        i0();
        q0();
    }

    public void setProgressUpdateListener(@androidx.annotation.Nullable com.google.android.exoplayer2.ui.StyledPlayerControlView.ProgressUpdateListener progressUpdateListener) {
        this.l0 = progressUpdateListener;
    }

    public void setRepeatToggleModes(int i) {
        this.v0 = i;
        com.google.android.exoplayer2.Player player = this.j0;
        if (player != null) {
            int repeatMode = player.getRepeatMode();
            if (i == 0 && repeatMode != 0) {
                this.k0.dispatchSetRepeatMode(this.j0, 0);
            } else if (i == 1 && repeatMode == 2) {
                this.k0.dispatchSetRepeatMode(this.j0, 1);
            } else if (i == 2 && repeatMode == 1) {
                this.k0.dispatchSetRepeatMode(this.j0, 2);
            }
        }
        this.D0.W(this.B, i != 0);
        o0();
    }

    public void setShowFastForwardButton(boolean z) {
        this.D0.W(this.x, z);
        l0();
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        this.q0 = z;
        t0();
    }

    public void setShowNextButton(boolean z) {
        this.D0.W(this.v, z);
        l0();
    }

    public void setShowPreviousButton(boolean z) {
        this.D0.W(this.u, z);
        l0();
    }

    public void setShowRewindButton(boolean z) {
        this.D0.W(this.y, z);
        l0();
    }

    public void setShowShuffleButton(boolean z) {
        this.D0.W(this.C, z);
        s0();
    }

    public void setShowSubtitleButton(boolean z) {
        this.D0.W(this.U0, z);
    }

    public void setShowTimeoutMs(int i) {
        this.t0 = i;
        if (isFullyVisible()) {
            this.D0.U();
        }
    }

    public void setShowVrButton(boolean z) {
        this.D0.W(this.D, z);
    }

    public void setTimeBarMinUpdateInterval(int i) {
        this.u0 = com.google.android.exoplayer2.util.Util.constrainValue(i, 16, 1000);
    }

    public void setVrButtonListener(@androidx.annotation.Nullable android.view.View.OnClickListener onClickListener) {
        android.view.View view = this.D;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            j0(onClickListener != null, this.D);
        }
    }

    public void show() {
        this.D0.a0();
    }

    public final void t0() {
        int i;
        com.google.android.exoplayer2.Timeline.Window window;
        com.google.android.exoplayer2.Player player = this.j0;
        if (player == null) {
            return;
        }
        boolean z = true;
        this.r0 = this.q0 && Q(player.getCurrentTimeline(), this.K);
        long j = 0;
        this.A0 = 0L;
        com.google.android.exoplayer2.Timeline currentTimeline = player.getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            i = 0;
        } else {
            int currentWindowIndex = player.getCurrentWindowIndex();
            boolean z2 = this.r0;
            int i2 = z2 ? 0 : currentWindowIndex;
            int windowCount = z2 ? currentTimeline.getWindowCount() - 1 : currentWindowIndex;
            long j2 = 0;
            i = 0;
            while (true) {
                if (i2 > windowCount) {
                    break;
                }
                if (i2 == currentWindowIndex) {
                    this.A0 = com.google.android.exoplayer2.C.usToMs(j2);
                }
                currentTimeline.getWindow(i2, this.K);
                com.google.android.exoplayer2.Timeline.Window window2 = this.K;
                if (window2.durationUs == -9223372036854775807L) {
                    com.google.android.exoplayer2.util.Assertions.checkState(this.r0 ^ z);
                    break;
                }
                int i3 = window2.firstPeriodIndex;
                while (true) {
                    window = this.K;
                    if (i3 <= window.lastPeriodIndex) {
                        currentTimeline.getPeriod(i3, this.J);
                        int adGroupCount = this.J.getAdGroupCount();
                        for (int i4 = 0; i4 < adGroupCount; i4++) {
                            long adGroupTimeUs = this.J.getAdGroupTimeUs(i4);
                            if (adGroupTimeUs == Long.MIN_VALUE) {
                                long j3 = this.J.durationUs;
                                if (j3 != -9223372036854775807L) {
                                    adGroupTimeUs = j3;
                                }
                            }
                            long positionInWindowUs = adGroupTimeUs + this.J.getPositionInWindowUs();
                            if (positionInWindowUs >= 0) {
                                long[] jArr = this.w0;
                                if (i == jArr.length) {
                                    int length = jArr.length == 0 ? 1 : jArr.length * 2;
                                    this.w0 = java.util.Arrays.copyOf(jArr, length);
                                    this.x0 = java.util.Arrays.copyOf(this.x0, length);
                                }
                                this.w0[i] = com.google.android.exoplayer2.C.usToMs(j2 + positionInWindowUs);
                                this.x0[i] = this.J.hasPlayedAdGroup(i4);
                                i++;
                            }
                        }
                        i3++;
                    }
                }
                j2 += window.durationUs;
                i2++;
                z = true;
            }
            j = j2;
        }
        long usToMs = com.google.android.exoplayer2.C.usToMs(j);
        android.widget.TextView textView = this.E;
        if (textView != null) {
            textView.setText(com.google.android.exoplayer2.util.Util.getStringForTime(this.H, this.I, usToMs));
        }
        com.google.android.exoplayer2.ui.TimeBar timeBar = this.G;
        if (timeBar != null) {
            timeBar.setDuration(usToMs);
            int length2 = this.y0.length;
            int i5 = i + length2;
            long[] jArr2 = this.w0;
            if (i5 > jArr2.length) {
                this.w0 = java.util.Arrays.copyOf(jArr2, i5);
                this.x0 = java.util.Arrays.copyOf(this.x0, i5);
            }
            java.lang.System.arraycopy(this.y0, 0, this.w0, i, length2);
            java.lang.System.arraycopy(this.z0, 0, this.x0, i, length2);
            this.G.setAdGroupTimesMs(this.w0, this.x0, i5);
        }
        n0();
    }

    public final void u0() {
        X();
        j0(this.R0.getItemCount() > 0, this.U0);
    }
}
