package com.google.android.exoplayer2.ui;

/* loaded from: classes22.dex */
public class PlayerControlView extends android.widget.FrameLayout {
    public static final int DEFAULT_REPEAT_TOGGLE_MODES = 0;
    public static final int DEFAULT_SHOW_TIMEOUT_MS = 5000;
    public static final int DEFAULT_TIME_BAR_MIN_UPDATE_INTERVAL_MS = 200;
    public static final int MAX_WINDOWS_FOR_MULTI_WINDOW_TIME_BAR = 100;

    @androidx.annotation.Nullable
    public final android.widget.ImageView A;

    @androidx.annotation.Nullable
    public final android.widget.ImageView B;

    @androidx.annotation.Nullable
    public final android.view.View C;

    @androidx.annotation.Nullable
    public final android.widget.TextView D;

    @androidx.annotation.Nullable
    public final android.widget.TextView E;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.ui.TimeBar F;
    public final java.lang.StringBuilder G;
    public final java.util.Formatter H;
    public final com.google.android.exoplayer2.Timeline.Period I;
    public final com.google.android.exoplayer2.Timeline.Window J;
    public final java.lang.Runnable K;
    public final java.lang.Runnable L;
    public final android.graphics.drawable.Drawable M;
    public final android.graphics.drawable.Drawable N;
    public final android.graphics.drawable.Drawable O;
    public final java.lang.String P;
    public final java.lang.String Q;
    public final java.lang.String R;
    public final android.graphics.drawable.Drawable S;
    public final android.graphics.drawable.Drawable T;
    public final float U;
    public final float V;
    public final java.lang.String W;
    public final java.lang.String a0;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.Player b0;
    public com.google.android.exoplayer2.ControlDispatcher c0;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.ui.PlayerControlView.ProgressUpdateListener d0;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.PlaybackPreparer e0;
    public boolean f0;
    public boolean g0;
    public boolean h0;
    public boolean i0;
    public int j0;
    public int k0;
    public int l0;
    public boolean m0;
    public final com.google.android.exoplayer2.ui.PlayerControlView.ComponentListener n;
    public boolean n0;
    public boolean o0;
    public boolean p0;
    public boolean q0;
    public long r0;
    public long[] s0;
    public final java.util.concurrent.CopyOnWriteArrayList<com.google.android.exoplayer2.ui.PlayerControlView.VisibilityListener> t;
    public boolean[] t0;

    @androidx.annotation.Nullable
    public final android.view.View u;
    public long[] u0;

    @androidx.annotation.Nullable
    public final android.view.View v;
    public boolean[] v0;

    @androidx.annotation.Nullable
    public final android.view.View w;
    public long w0;

    @androidx.annotation.Nullable
    public final android.view.View x;

    @androidx.annotation.Nullable
    public final android.view.View y;

    @androidx.annotation.Nullable
    public final android.view.View z;

    public final class ComponentListener implements com.google.android.exoplayer2.Player.EventListener, com.google.android.exoplayer2.ui.TimeBar.OnScrubListener, android.view.View.OnClickListener {
        public ComponentListener() {
        }

        public /* synthetic */ ComponentListener(com.google.android.exoplayer2.ui.PlayerControlView playerControlView, com.google.android.exoplayer2.ui.PlayerControlView.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(android.view.View view) {
            com.google.android.exoplayer2.Player player = com.google.android.exoplayer2.ui.PlayerControlView.this.b0;
            if (player == null) {
                return;
            }
            if (com.google.android.exoplayer2.ui.PlayerControlView.this.v == view) {
                com.google.android.exoplayer2.ui.PlayerControlView.this.c0.dispatchNext(player);
                return;
            }
            if (com.google.android.exoplayer2.ui.PlayerControlView.this.u == view) {
                com.google.android.exoplayer2.ui.PlayerControlView.this.c0.dispatchPrevious(player);
                return;
            }
            if (com.google.android.exoplayer2.ui.PlayerControlView.this.y == view) {
                if (player.getPlaybackState() != 4) {
                    com.google.android.exoplayer2.ui.PlayerControlView.this.c0.dispatchFastForward(player);
                    return;
                }
                return;
            }
            if (com.google.android.exoplayer2.ui.PlayerControlView.this.z == view) {
                com.google.android.exoplayer2.ui.PlayerControlView.this.c0.dispatchRewind(player);
                return;
            }
            if (com.google.android.exoplayer2.ui.PlayerControlView.this.w == view) {
                com.google.android.exoplayer2.ui.PlayerControlView.this.B(player);
                return;
            }
            if (com.google.android.exoplayer2.ui.PlayerControlView.this.x == view) {
                com.google.android.exoplayer2.ui.PlayerControlView.this.A(player);
            } else if (com.google.android.exoplayer2.ui.PlayerControlView.this.A == view) {
                com.google.android.exoplayer2.ui.PlayerControlView.this.c0.dispatchSetRepeatMode(player, com.google.android.exoplayer2.util.RepeatModeUtil.getNextRepeatMode(player.getRepeatMode(), com.google.android.exoplayer2.ui.PlayerControlView.this.l0));
            } else if (com.google.android.exoplayer2.ui.PlayerControlView.this.B == view) {
                com.google.android.exoplayer2.ui.PlayerControlView.this.c0.dispatchSetShuffleModeEnabled(player, !player.getShuffleModeEnabled());
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
            com.google.android.exoplayer2.ui.PlayerControlView.this.O();
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
            com.google.android.exoplayer2.ui.PlayerControlView.this.N();
            com.google.android.exoplayer2.ui.PlayerControlView.this.O();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlaybackParametersChanged(com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
            defpackage.h32.g(this, playbackParameters);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlaybackStateChanged(int i) {
            com.google.android.exoplayer2.ui.PlayerControlView.this.N();
            com.google.android.exoplayer2.ui.PlayerControlView.this.O();
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
            com.google.android.exoplayer2.ui.PlayerControlView.this.M();
            com.google.android.exoplayer2.ui.PlayerControlView.this.R();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onRepeatModeChanged(int i) {
            com.google.android.exoplayer2.ui.PlayerControlView.this.P();
            com.google.android.exoplayer2.ui.PlayerControlView.this.M();
        }

        @Override // com.google.android.exoplayer2.ui.TimeBar.OnScrubListener
        public void onScrubMove(com.google.android.exoplayer2.ui.TimeBar timeBar, long j) {
            if (com.google.android.exoplayer2.ui.PlayerControlView.this.E != null) {
                com.google.android.exoplayer2.ui.PlayerControlView.this.E.setText(com.google.android.exoplayer2.util.Util.getStringForTime(com.google.android.exoplayer2.ui.PlayerControlView.this.G, com.google.android.exoplayer2.ui.PlayerControlView.this.H, j));
            }
        }

        @Override // com.google.android.exoplayer2.ui.TimeBar.OnScrubListener
        public void onScrubStart(com.google.android.exoplayer2.ui.TimeBar timeBar, long j) {
            com.google.android.exoplayer2.ui.PlayerControlView.this.i0 = true;
            if (com.google.android.exoplayer2.ui.PlayerControlView.this.E != null) {
                com.google.android.exoplayer2.ui.PlayerControlView.this.E.setText(com.google.android.exoplayer2.util.Util.getStringForTime(com.google.android.exoplayer2.ui.PlayerControlView.this.G, com.google.android.exoplayer2.ui.PlayerControlView.this.H, j));
            }
        }

        @Override // com.google.android.exoplayer2.ui.TimeBar.OnScrubListener
        public void onScrubStop(com.google.android.exoplayer2.ui.TimeBar timeBar, long j, boolean z) {
            com.google.android.exoplayer2.ui.PlayerControlView.this.i0 = false;
            if (z || com.google.android.exoplayer2.ui.PlayerControlView.this.b0 == null) {
                return;
            }
            com.google.android.exoplayer2.ui.PlayerControlView playerControlView = com.google.android.exoplayer2.ui.PlayerControlView.this;
            playerControlView.I(playerControlView.b0, j);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onSeekProcessed() {
            defpackage.h32.n(this);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onShuffleModeEnabledChanged(boolean z) {
            com.google.android.exoplayer2.ui.PlayerControlView.this.Q();
            com.google.android.exoplayer2.ui.PlayerControlView.this.M();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onTimelineChanged(com.google.android.exoplayer2.Timeline timeline, int i) {
            com.google.android.exoplayer2.ui.PlayerControlView.this.M();
            com.google.android.exoplayer2.ui.PlayerControlView.this.R();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onTimelineChanged(com.google.android.exoplayer2.Timeline timeline, java.lang.Object obj, int i) {
            defpackage.h32.q(this, timeline, obj, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onTracksChanged(com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, com.google.android.exoplayer2.trackselection.TrackSelectionArray trackSelectionArray) {
            defpackage.h32.r(this, trackGroupArray, trackSelectionArray);
        }
    }

    public interface ProgressUpdateListener {
        void onProgressUpdate(long j, long j2);
    }

    public interface VisibilityListener {
        void onVisibilityChange(int i);
    }

    static {
        com.google.android.exoplayer2.ExoPlayerLibraryInfo.registerModule("goog.exo.ui");
    }

    public PlayerControlView(android.content.Context context) {
        this(context, null);
    }

    public PlayerControlView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PlayerControlView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, attributeSet);
    }

    public PlayerControlView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i, @androidx.annotation.Nullable android.util.AttributeSet attributeSet2) {
        super(context, attributeSet, i);
        int i2 = com.google.android.exoplayer2.ui.R.layout.exo_player_control_view;
        int i3 = 5000;
        this.j0 = 5000;
        this.l0 = 0;
        this.k0 = 200;
        this.r0 = -9223372036854775807L;
        this.m0 = true;
        this.n0 = true;
        this.o0 = true;
        this.p0 = true;
        this.q0 = false;
        int i4 = 15000;
        if (attributeSet2 != null) {
            android.content.res.TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, com.google.android.exoplayer2.ui.R.styleable.PlayerControlView, 0, 0);
            try {
                i3 = obtainStyledAttributes.getInt(com.google.android.exoplayer2.ui.R.styleable.PlayerControlView_rewind_increment, 5000);
                i4 = obtainStyledAttributes.getInt(com.google.android.exoplayer2.ui.R.styleable.PlayerControlView_fastforward_increment, 15000);
                this.j0 = obtainStyledAttributes.getInt(com.google.android.exoplayer2.ui.R.styleable.PlayerControlView_show_timeout, this.j0);
                i2 = obtainStyledAttributes.getResourceId(com.google.android.exoplayer2.ui.R.styleable.PlayerControlView_controller_layout_id, i2);
                this.l0 = D(obtainStyledAttributes, this.l0);
                this.m0 = obtainStyledAttributes.getBoolean(com.google.android.exoplayer2.ui.R.styleable.PlayerControlView_show_rewind_button, this.m0);
                this.n0 = obtainStyledAttributes.getBoolean(com.google.android.exoplayer2.ui.R.styleable.PlayerControlView_show_fastforward_button, this.n0);
                this.o0 = obtainStyledAttributes.getBoolean(com.google.android.exoplayer2.ui.R.styleable.PlayerControlView_show_previous_button, this.o0);
                this.p0 = obtainStyledAttributes.getBoolean(com.google.android.exoplayer2.ui.R.styleable.PlayerControlView_show_next_button, this.p0);
                this.q0 = obtainStyledAttributes.getBoolean(com.google.android.exoplayer2.ui.R.styleable.PlayerControlView_show_shuffle_button, this.q0);
                setTimeBarMinUpdateInterval(obtainStyledAttributes.getInt(com.google.android.exoplayer2.ui.R.styleable.PlayerControlView_time_bar_min_update_interval, this.k0));
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.t = new java.util.concurrent.CopyOnWriteArrayList<>();
        this.I = new com.google.android.exoplayer2.Timeline.Period();
        this.J = new com.google.android.exoplayer2.Timeline.Window();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        this.G = sb;
        this.H = new java.util.Formatter(sb, java.util.Locale.getDefault());
        this.s0 = new long[0];
        this.t0 = new boolean[0];
        this.u0 = new long[0];
        this.v0 = new boolean[0];
        com.google.android.exoplayer2.ui.PlayerControlView.ComponentListener componentListener = new com.google.android.exoplayer2.ui.PlayerControlView.ComponentListener(this, null);
        this.n = componentListener;
        this.c0 = new com.google.android.exoplayer2.DefaultControlDispatcher(i4, i3);
        this.K = new defpackage.i32(this);
        this.L = new defpackage.j32(this);
        android.view.LayoutInflater.from(context).inflate(i2, this);
        setDescendantFocusability(262144);
        int i5 = com.google.android.exoplayer2.ui.R.id.exo_progress;
        com.google.android.exoplayer2.ui.TimeBar timeBar = (com.google.android.exoplayer2.ui.TimeBar) findViewById(i5);
        android.view.View findViewById = findViewById(com.google.android.exoplayer2.ui.R.id.exo_progress_placeholder);
        if (timeBar != null) {
            this.F = timeBar;
        } else if (findViewById != null) {
            com.google.android.exoplayer2.ui.DefaultTimeBar defaultTimeBar = new com.google.android.exoplayer2.ui.DefaultTimeBar(context, null, 0, attributeSet2);
            defaultTimeBar.setId(i5);
            defaultTimeBar.setLayoutParams(findViewById.getLayoutParams());
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) findViewById.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById);
            viewGroup.removeView(findViewById);
            viewGroup.addView(defaultTimeBar, indexOfChild);
            this.F = defaultTimeBar;
        } else {
            this.F = null;
        }
        this.D = (android.widget.TextView) findViewById(com.google.android.exoplayer2.ui.R.id.exo_duration);
        this.E = (android.widget.TextView) findViewById(com.google.android.exoplayer2.ui.R.id.exo_position);
        com.google.android.exoplayer2.ui.TimeBar timeBar2 = this.F;
        if (timeBar2 != null) {
            timeBar2.addListener(componentListener);
        }
        android.view.View findViewById2 = findViewById(com.google.android.exoplayer2.ui.R.id.exo_play);
        this.w = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(componentListener);
        }
        android.view.View findViewById3 = findViewById(com.google.android.exoplayer2.ui.R.id.exo_pause);
        this.x = findViewById3;
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(componentListener);
        }
        android.view.View findViewById4 = findViewById(com.google.android.exoplayer2.ui.R.id.exo_prev);
        this.u = findViewById4;
        if (findViewById4 != null) {
            findViewById4.setOnClickListener(componentListener);
        }
        android.view.View findViewById5 = findViewById(com.google.android.exoplayer2.ui.R.id.exo_next);
        this.v = findViewById5;
        if (findViewById5 != null) {
            findViewById5.setOnClickListener(componentListener);
        }
        android.view.View findViewById6 = findViewById(com.google.android.exoplayer2.ui.R.id.exo_rew);
        this.z = findViewById6;
        if (findViewById6 != null) {
            findViewById6.setOnClickListener(componentListener);
        }
        android.view.View findViewById7 = findViewById(com.google.android.exoplayer2.ui.R.id.exo_ffwd);
        this.y = findViewById7;
        if (findViewById7 != null) {
            findViewById7.setOnClickListener(componentListener);
        }
        android.widget.ImageView imageView = (android.widget.ImageView) findViewById(com.google.android.exoplayer2.ui.R.id.exo_repeat_toggle);
        this.A = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(componentListener);
        }
        android.widget.ImageView imageView2 = (android.widget.ImageView) findViewById(com.google.android.exoplayer2.ui.R.id.exo_shuffle);
        this.B = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(componentListener);
        }
        android.view.View findViewById8 = findViewById(com.google.android.exoplayer2.ui.R.id.exo_vr);
        this.C = findViewById8;
        setShowVrButton(false);
        L(false, false, findViewById8);
        android.content.res.Resources resources = context.getResources();
        this.U = resources.getInteger(com.google.android.exoplayer2.ui.R.integer.exo_media_button_opacity_percentage_enabled) / 100.0f;
        this.V = resources.getInteger(com.google.android.exoplayer2.ui.R.integer.exo_media_button_opacity_percentage_disabled) / 100.0f;
        this.M = resources.getDrawable(com.google.android.exoplayer2.ui.R.drawable.exo_controls_repeat_off);
        this.N = resources.getDrawable(com.google.android.exoplayer2.ui.R.drawable.exo_controls_repeat_one);
        this.O = resources.getDrawable(com.google.android.exoplayer2.ui.R.drawable.exo_controls_repeat_all);
        this.S = resources.getDrawable(com.google.android.exoplayer2.ui.R.drawable.exo_controls_shuffle_on);
        this.T = resources.getDrawable(com.google.android.exoplayer2.ui.R.drawable.exo_controls_shuffle_off);
        this.P = resources.getString(com.google.android.exoplayer2.ui.R.string.exo_controls_repeat_off_description);
        this.Q = resources.getString(com.google.android.exoplayer2.ui.R.string.exo_controls_repeat_one_description);
        this.R = resources.getString(com.google.android.exoplayer2.ui.R.string.exo_controls_repeat_all_description);
        this.W = resources.getString(com.google.android.exoplayer2.ui.R.string.exo_controls_shuffle_on_description);
        this.a0 = resources.getString(com.google.android.exoplayer2.ui.R.string.exo_controls_shuffle_off_description);
    }

    public static int D(android.content.res.TypedArray typedArray, int i) {
        return typedArray.getInt(com.google.android.exoplayer2.ui.R.styleable.PlayerControlView_repeat_toggle_modes, i);
    }

    @android.annotation.SuppressLint({"InlinedApi"})
    public static boolean F(int i) {
        return i == 90 || i == 89 || i == 85 || i == 79 || i == 126 || i == 127 || i == 87 || i == 88;
    }

    public static boolean z(com.google.android.exoplayer2.Timeline timeline, com.google.android.exoplayer2.Timeline.Window window) {
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

    public final void A(com.google.android.exoplayer2.Player player) {
        this.c0.dispatchSetPlayWhenReady(player, false);
    }

    public final void B(com.google.android.exoplayer2.Player player) {
        int playbackState = player.getPlaybackState();
        if (playbackState == 1) {
            com.google.android.exoplayer2.PlaybackPreparer playbackPreparer = this.e0;
            if (playbackPreparer != null) {
                playbackPreparer.preparePlayback();
            }
        } else if (playbackState == 4) {
            H(player, player.getCurrentWindowIndex(), -9223372036854775807L);
        }
        this.c0.dispatchSetPlayWhenReady(player, true);
    }

    public final void C(com.google.android.exoplayer2.Player player) {
        int playbackState = player.getPlaybackState();
        if (playbackState == 1 || playbackState == 4 || !player.getPlayWhenReady()) {
            B(player);
        } else {
            A(player);
        }
    }

    public final void E() {
        removeCallbacks(this.L);
        if (this.j0 <= 0) {
            this.r0 = -9223372036854775807L;
            return;
        }
        long uptimeMillis = android.os.SystemClock.uptimeMillis();
        int i = this.j0;
        this.r0 = uptimeMillis + i;
        if (this.f0) {
            postDelayed(this.L, i);
        }
    }

    public final void G() {
        android.view.View view;
        android.view.View view2;
        boolean J = J();
        if (!J && (view2 = this.w) != null) {
            view2.requestFocus();
        } else {
            if (!J || (view = this.x) == null) {
                return;
            }
            view.requestFocus();
        }
    }

    public final boolean H(com.google.android.exoplayer2.Player player, int i, long j) {
        return this.c0.dispatchSeekTo(player, i, j);
    }

    public final void I(com.google.android.exoplayer2.Player player, long j) {
        int currentWindowIndex;
        com.google.android.exoplayer2.Timeline currentTimeline = player.getCurrentTimeline();
        if (this.h0 && !currentTimeline.isEmpty()) {
            int windowCount = currentTimeline.getWindowCount();
            currentWindowIndex = 0;
            while (true) {
                long durationMs = currentTimeline.getWindow(currentWindowIndex, this.J).getDurationMs();
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
        if (H(player, currentWindowIndex, j)) {
            return;
        }
        O();
    }

    public final boolean J() {
        com.google.android.exoplayer2.Player player = this.b0;
        return (player == null || player.getPlaybackState() == 4 || this.b0.getPlaybackState() == 1 || !this.b0.getPlayWhenReady()) ? false : true;
    }

    public final void K() {
        N();
        M();
        P();
        Q();
        R();
    }

    public final void L(boolean z, boolean z2, @androidx.annotation.Nullable android.view.View view) {
        if (view == null) {
            return;
        }
        view.setEnabled(z2);
        view.setAlpha(z2 ? this.U : this.V);
        view.setVisibility(z ? 0 : 8);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void M() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        com.google.android.exoplayer2.ui.TimeBar timeBar;
        if (!isVisible() || !this.f0) {
            return;
        }
        com.google.android.exoplayer2.Player player = this.b0;
        if (player != null) {
            com.google.android.exoplayer2.Timeline currentTimeline = player.getCurrentTimeline();
            if (!currentTimeline.isEmpty() && !player.isPlayingAd()) {
                currentTimeline.getWindow(player.getCurrentWindowIndex(), this.J);
                com.google.android.exoplayer2.Timeline.Window window = this.J;
                z2 = window.isSeekable;
                boolean z5 = z2 || !window.isDynamic || player.hasPrevious();
                z3 = z2 && this.c0.isRewindEnabled();
                z4 = z2 && this.c0.isFastForwardEnabled();
                z = this.J.isDynamic || player.hasNext();
                r1 = z5;
                L(this.o0, r1, this.u);
                L(this.m0, z3, this.z);
                L(this.n0, z4, this.y);
                L(this.p0, z, this.v);
                timeBar = this.F;
                if (timeBar == null) {
                    timeBar.setEnabled(z2);
                    return;
                }
                return;
            }
        }
        z = false;
        z2 = false;
        z3 = false;
        z4 = false;
        L(this.o0, r1, this.u);
        L(this.m0, z3, this.z);
        L(this.n0, z4, this.y);
        L(this.p0, z, this.v);
        timeBar = this.F;
        if (timeBar == null) {
        }
    }

    public final void N() {
        boolean z;
        if (isVisible() && this.f0) {
            boolean J = J();
            android.view.View view = this.w;
            if (view != null) {
                z = (J && view.isFocused()) | false;
                this.w.setVisibility(J ? 8 : 0);
            } else {
                z = false;
            }
            android.view.View view2 = this.x;
            if (view2 != null) {
                z |= !J && view2.isFocused();
                this.x.setVisibility(J ? 0 : 8);
            }
            if (z) {
                G();
            }
        }
    }

    public final void O() {
        long j;
        long j2;
        if (isVisible() && this.f0) {
            com.google.android.exoplayer2.Player player = this.b0;
            if (player != null) {
                j = this.w0 + player.getContentPosition();
                j2 = this.w0 + player.getContentBufferedPosition();
            } else {
                j = 0;
                j2 = 0;
            }
            android.widget.TextView textView = this.E;
            if (textView != null && !this.i0) {
                textView.setText(com.google.android.exoplayer2.util.Util.getStringForTime(this.G, this.H, j));
            }
            com.google.android.exoplayer2.ui.TimeBar timeBar = this.F;
            if (timeBar != null) {
                timeBar.setPosition(j);
                this.F.setBufferedPosition(j2);
            }
            com.google.android.exoplayer2.ui.PlayerControlView.ProgressUpdateListener progressUpdateListener = this.d0;
            if (progressUpdateListener != null) {
                progressUpdateListener.onProgressUpdate(j, j2);
            }
            removeCallbacks(this.K);
            int playbackState = player == null ? 1 : player.getPlaybackState();
            if (player == null || !player.isPlaying()) {
                if (playbackState == 4 || playbackState == 1) {
                    return;
                }
                postDelayed(this.K, 1000L);
                return;
            }
            com.google.android.exoplayer2.ui.TimeBar timeBar2 = this.F;
            long min = java.lang.Math.min(timeBar2 != null ? timeBar2.getPreferredUpdateDelay() : 1000L, 1000 - (j % 1000));
            float f = player.getPlaybackParameters().speed;
            postDelayed(this.K, com.google.android.exoplayer2.util.Util.constrainValue(f > 0.0f ? (long) (min / f) : 1000L, this.k0, 1000L));
        }
    }

    public final void P() {
        android.widget.ImageView imageView;
        if (isVisible() && this.f0 && (imageView = this.A) != null) {
            if (this.l0 == 0) {
                L(false, false, imageView);
                return;
            }
            com.google.android.exoplayer2.Player player = this.b0;
            if (player == null) {
                L(true, false, imageView);
                this.A.setImageDrawable(this.M);
                this.A.setContentDescription(this.P);
                return;
            }
            L(true, true, imageView);
            int repeatMode = player.getRepeatMode();
            if (repeatMode == 0) {
                this.A.setImageDrawable(this.M);
                this.A.setContentDescription(this.P);
            } else if (repeatMode == 1) {
                this.A.setImageDrawable(this.N);
                this.A.setContentDescription(this.Q);
            } else if (repeatMode == 2) {
                this.A.setImageDrawable(this.O);
                this.A.setContentDescription(this.R);
            }
            this.A.setVisibility(0);
        }
    }

    public final void Q() {
        android.widget.ImageView imageView;
        if (isVisible() && this.f0 && (imageView = this.B) != null) {
            com.google.android.exoplayer2.Player player = this.b0;
            if (!this.q0) {
                L(false, false, imageView);
                return;
            }
            if (player == null) {
                L(true, false, imageView);
                this.B.setImageDrawable(this.T);
                this.B.setContentDescription(this.a0);
            } else {
                L(true, true, imageView);
                this.B.setImageDrawable(player.getShuffleModeEnabled() ? this.S : this.T);
                this.B.setContentDescription(player.getShuffleModeEnabled() ? this.W : this.a0);
            }
        }
    }

    public final void R() {
        int i;
        com.google.android.exoplayer2.Timeline.Window window;
        com.google.android.exoplayer2.Player player = this.b0;
        if (player == null) {
            return;
        }
        boolean z = true;
        this.h0 = this.g0 && z(player.getCurrentTimeline(), this.J);
        long j = 0;
        this.w0 = 0L;
        com.google.android.exoplayer2.Timeline currentTimeline = player.getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            i = 0;
        } else {
            int currentWindowIndex = player.getCurrentWindowIndex();
            boolean z2 = this.h0;
            int i2 = z2 ? 0 : currentWindowIndex;
            int windowCount = z2 ? currentTimeline.getWindowCount() - 1 : currentWindowIndex;
            long j2 = 0;
            i = 0;
            while (true) {
                if (i2 > windowCount) {
                    break;
                }
                if (i2 == currentWindowIndex) {
                    this.w0 = com.google.android.exoplayer2.C.usToMs(j2);
                }
                currentTimeline.getWindow(i2, this.J);
                com.google.android.exoplayer2.Timeline.Window window2 = this.J;
                if (window2.durationUs == -9223372036854775807L) {
                    com.google.android.exoplayer2.util.Assertions.checkState(this.h0 ^ z);
                    break;
                }
                int i3 = window2.firstPeriodIndex;
                while (true) {
                    window = this.J;
                    if (i3 <= window.lastPeriodIndex) {
                        currentTimeline.getPeriod(i3, this.I);
                        int adGroupCount = this.I.getAdGroupCount();
                        for (int i4 = 0; i4 < adGroupCount; i4++) {
                            long adGroupTimeUs = this.I.getAdGroupTimeUs(i4);
                            if (adGroupTimeUs == Long.MIN_VALUE) {
                                long j3 = this.I.durationUs;
                                if (j3 != -9223372036854775807L) {
                                    adGroupTimeUs = j3;
                                }
                            }
                            long positionInWindowUs = adGroupTimeUs + this.I.getPositionInWindowUs();
                            if (positionInWindowUs >= 0) {
                                long[] jArr = this.s0;
                                if (i == jArr.length) {
                                    int length = jArr.length == 0 ? 1 : jArr.length * 2;
                                    this.s0 = java.util.Arrays.copyOf(jArr, length);
                                    this.t0 = java.util.Arrays.copyOf(this.t0, length);
                                }
                                this.s0[i] = com.google.android.exoplayer2.C.usToMs(j2 + positionInWindowUs);
                                this.t0[i] = this.I.hasPlayedAdGroup(i4);
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
        android.widget.TextView textView = this.D;
        if (textView != null) {
            textView.setText(com.google.android.exoplayer2.util.Util.getStringForTime(this.G, this.H, usToMs));
        }
        com.google.android.exoplayer2.ui.TimeBar timeBar = this.F;
        if (timeBar != null) {
            timeBar.setDuration(usToMs);
            int length2 = this.u0.length;
            int i5 = i + length2;
            long[] jArr2 = this.s0;
            if (i5 > jArr2.length) {
                this.s0 = java.util.Arrays.copyOf(jArr2, i5);
                this.t0 = java.util.Arrays.copyOf(this.t0, i5);
            }
            java.lang.System.arraycopy(this.u0, 0, this.s0, i, length2);
            java.lang.System.arraycopy(this.v0, 0, this.t0, i, length2);
            this.F.setAdGroupTimesMs(this.s0, this.t0, i5);
        }
        O();
    }

    public void addVisibilityListener(com.google.android.exoplayer2.ui.PlayerControlView.VisibilityListener visibilityListener) {
        com.google.android.exoplayer2.util.Assertions.checkNotNull(visibilityListener);
        this.t.add(visibilityListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(android.view.KeyEvent keyEvent) {
        return dispatchMediaKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchMediaKeyEvent(android.view.KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        com.google.android.exoplayer2.Player player = this.b0;
        if (player == null || !F(keyCode)) {
            return false;
        }
        if (keyEvent.getAction() != 0) {
            return true;
        }
        if (keyCode == 90) {
            if (player.getPlaybackState() == 4) {
                return true;
            }
            this.c0.dispatchFastForward(player);
            return true;
        }
        if (keyCode == 89) {
            this.c0.dispatchRewind(player);
            return true;
        }
        if (keyEvent.getRepeatCount() != 0) {
            return true;
        }
        if (keyCode == 79 || keyCode == 85) {
            C(player);
            return true;
        }
        if (keyCode == 87) {
            this.c0.dispatchNext(player);
            return true;
        }
        if (keyCode == 88) {
            this.c0.dispatchPrevious(player);
            return true;
        }
        if (keyCode == 126) {
            B(player);
            return true;
        }
        if (keyCode != 127) {
            return true;
        }
        A(player);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            removeCallbacks(this.L);
        } else if (motionEvent.getAction() == 1) {
            E();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.Player getPlayer() {
        return this.b0;
    }

    public int getRepeatToggleModes() {
        return this.l0;
    }

    public boolean getShowShuffleButton() {
        return this.q0;
    }

    public int getShowTimeoutMs() {
        return this.j0;
    }

    public boolean getShowVrButton() {
        android.view.View view = this.C;
        return view != null && view.getVisibility() == 0;
    }

    public void hide() {
        if (isVisible()) {
            setVisibility(8);
            java.util.Iterator<com.google.android.exoplayer2.ui.PlayerControlView.VisibilityListener> it = this.t.iterator();
            while (it.hasNext()) {
                it.next().onVisibilityChange(getVisibility());
            }
            removeCallbacks(this.K);
            removeCallbacks(this.L);
            this.r0 = -9223372036854775807L;
        }
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f0 = true;
        long j = this.r0;
        if (j != -9223372036854775807L) {
            long uptimeMillis = j - android.os.SystemClock.uptimeMillis();
            if (uptimeMillis <= 0) {
                hide();
            } else {
                postDelayed(this.L, uptimeMillis);
            }
        } else if (isVisible()) {
            E();
        }
        K();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f0 = false;
        removeCallbacks(this.K);
        removeCallbacks(this.L);
    }

    public void removeVisibilityListener(com.google.android.exoplayer2.ui.PlayerControlView.VisibilityListener visibilityListener) {
        this.t.remove(visibilityListener);
    }

    public void setControlDispatcher(com.google.android.exoplayer2.ControlDispatcher controlDispatcher) {
        if (this.c0 != controlDispatcher) {
            this.c0 = controlDispatcher;
            M();
        }
    }

    public void setExtraAdGroupMarkers(@androidx.annotation.Nullable long[] jArr, @androidx.annotation.Nullable boolean[] zArr) {
        if (jArr == null) {
            this.u0 = new long[0];
            this.v0 = new boolean[0];
        } else {
            boolean[] zArr2 = (boolean[]) com.google.android.exoplayer2.util.Assertions.checkNotNull(zArr);
            com.google.android.exoplayer2.util.Assertions.checkArgument(jArr.length == zArr2.length);
            this.u0 = jArr;
            this.v0 = zArr2;
        }
        R();
    }

    @java.lang.Deprecated
    public void setFastForwardIncrementMs(int i) {
        com.google.android.exoplayer2.ControlDispatcher controlDispatcher = this.c0;
        if (controlDispatcher instanceof com.google.android.exoplayer2.DefaultControlDispatcher) {
            ((com.google.android.exoplayer2.DefaultControlDispatcher) controlDispatcher).setFastForwardIncrementMs(i);
            M();
        }
    }

    public void setPlaybackPreparer(@androidx.annotation.Nullable com.google.android.exoplayer2.PlaybackPreparer playbackPreparer) {
        this.e0 = playbackPreparer;
    }

    public void setPlayer(@androidx.annotation.Nullable com.google.android.exoplayer2.Player player) {
        boolean z = true;
        com.google.android.exoplayer2.util.Assertions.checkState(android.os.Looper.myLooper() == android.os.Looper.getMainLooper());
        if (player != null && player.getApplicationLooper() != android.os.Looper.getMainLooper()) {
            z = false;
        }
        com.google.android.exoplayer2.util.Assertions.checkArgument(z);
        com.google.android.exoplayer2.Player player2 = this.b0;
        if (player2 == player) {
            return;
        }
        if (player2 != null) {
            player2.removeListener(this.n);
        }
        this.b0 = player;
        if (player != null) {
            player.addListener(this.n);
        }
        K();
    }

    public void setProgressUpdateListener(@androidx.annotation.Nullable com.google.android.exoplayer2.ui.PlayerControlView.ProgressUpdateListener progressUpdateListener) {
        this.d0 = progressUpdateListener;
    }

    public void setRepeatToggleModes(int i) {
        this.l0 = i;
        com.google.android.exoplayer2.Player player = this.b0;
        if (player != null) {
            int repeatMode = player.getRepeatMode();
            if (i == 0 && repeatMode != 0) {
                this.c0.dispatchSetRepeatMode(this.b0, 0);
            } else if (i == 1 && repeatMode == 2) {
                this.c0.dispatchSetRepeatMode(this.b0, 1);
            } else if (i == 2 && repeatMode == 1) {
                this.c0.dispatchSetRepeatMode(this.b0, 2);
            }
        }
        P();
    }

    @java.lang.Deprecated
    public void setRewindIncrementMs(int i) {
        com.google.android.exoplayer2.ControlDispatcher controlDispatcher = this.c0;
        if (controlDispatcher instanceof com.google.android.exoplayer2.DefaultControlDispatcher) {
            ((com.google.android.exoplayer2.DefaultControlDispatcher) controlDispatcher).setRewindIncrementMs(i);
            M();
        }
    }

    public void setShowFastForwardButton(boolean z) {
        this.n0 = z;
        M();
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        this.g0 = z;
        R();
    }

    public void setShowNextButton(boolean z) {
        this.p0 = z;
        M();
    }

    public void setShowPreviousButton(boolean z) {
        this.o0 = z;
        M();
    }

    public void setShowRewindButton(boolean z) {
        this.m0 = z;
        M();
    }

    public void setShowShuffleButton(boolean z) {
        this.q0 = z;
        Q();
    }

    public void setShowTimeoutMs(int i) {
        this.j0 = i;
        if (isVisible()) {
            E();
        }
    }

    public void setShowVrButton(boolean z) {
        android.view.View view = this.C;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public void setTimeBarMinUpdateInterval(int i) {
        this.k0 = com.google.android.exoplayer2.util.Util.constrainValue(i, 16, 1000);
    }

    public void setVrButtonListener(@androidx.annotation.Nullable android.view.View.OnClickListener onClickListener) {
        android.view.View view = this.C;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            L(getShowVrButton(), onClickListener != null, this.C);
        }
    }

    public void show() {
        if (!isVisible()) {
            setVisibility(0);
            java.util.Iterator<com.google.android.exoplayer2.ui.PlayerControlView.VisibilityListener> it = this.t.iterator();
            while (it.hasNext()) {
                it.next().onVisibilityChange(getVisibility());
            }
            K();
            G();
        }
        E();
    }
}
