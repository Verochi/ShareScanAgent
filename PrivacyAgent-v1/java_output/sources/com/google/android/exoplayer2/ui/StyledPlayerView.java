package com.google.android.exoplayer2.ui;

/* loaded from: classes22.dex */
public class StyledPlayerView extends android.widget.FrameLayout implements com.google.android.exoplayer2.source.ads.AdsLoader.AdViewProvider {
    public static final int SHOW_BUFFERING_ALWAYS = 2;
    public static final int SHOW_BUFFERING_NEVER = 0;
    public static final int SHOW_BUFFERING_WHEN_PLAYING = 1;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.ui.StyledPlayerControlView A;

    @androidx.annotation.Nullable
    public final android.widget.FrameLayout B;

    @androidx.annotation.Nullable
    public final android.widget.FrameLayout C;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.Player D;
    public boolean E;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.ui.StyledPlayerControlView.VisibilityListener F;
    public boolean G;

    @androidx.annotation.Nullable
    public android.graphics.drawable.Drawable H;
    public int I;
    public boolean J;
    public boolean K;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.util.ErrorMessageProvider<? super com.google.android.exoplayer2.ExoPlaybackException> L;

    @androidx.annotation.Nullable
    public java.lang.CharSequence M;
    public int N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public int R;
    public boolean S;
    public final com.google.android.exoplayer2.ui.StyledPlayerView.ComponentListener n;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.ui.AspectRatioFrameLayout t;

    @androidx.annotation.Nullable
    public final android.view.View u;

    @androidx.annotation.Nullable
    public final android.view.View v;

    @androidx.annotation.Nullable
    public final android.widget.ImageView w;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.ui.SubtitleView x;

    @androidx.annotation.Nullable
    public final android.view.View y;

    @androidx.annotation.Nullable
    public final android.widget.TextView z;

    public final class ComponentListener implements com.google.android.exoplayer2.Player.EventListener, com.google.android.exoplayer2.text.TextOutput, com.google.android.exoplayer2.video.VideoListener, android.view.View.OnLayoutChangeListener, com.google.android.exoplayer2.ui.spherical.SingleTapListener, com.google.android.exoplayer2.ui.StyledPlayerControlView.VisibilityListener {
        public final com.google.android.exoplayer2.Timeline.Period n = new com.google.android.exoplayer2.Timeline.Period();

        @androidx.annotation.Nullable
        public java.lang.Object t;

        public ComponentListener() {
        }

        @Override // com.google.android.exoplayer2.text.TextOutput
        public void onCues(java.util.List<com.google.android.exoplayer2.text.Cue> list) {
            if (com.google.android.exoplayer2.ui.StyledPlayerView.this.x != null) {
                com.google.android.exoplayer2.ui.StyledPlayerView.this.x.onCues(list);
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
        public /* synthetic */ void onIsPlayingChanged(boolean z) {
            defpackage.h32.c(this, z);
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(android.view.View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            com.google.android.exoplayer2.ui.StyledPlayerView.q((android.view.TextureView) view, com.google.android.exoplayer2.ui.StyledPlayerView.this.R);
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
            com.google.android.exoplayer2.ui.StyledPlayerView.this.E();
            com.google.android.exoplayer2.ui.StyledPlayerView.this.G();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onPlaybackParametersChanged(com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
            defpackage.h32.g(this, playbackParameters);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlaybackStateChanged(int i) {
            com.google.android.exoplayer2.ui.StyledPlayerView.this.E();
            com.google.android.exoplayer2.ui.StyledPlayerView.this.H();
            com.google.android.exoplayer2.ui.StyledPlayerView.this.G();
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
            if (com.google.android.exoplayer2.ui.StyledPlayerView.this.w() && com.google.android.exoplayer2.ui.StyledPlayerView.this.P) {
                com.google.android.exoplayer2.ui.StyledPlayerView.this.hideController();
            }
        }

        @Override // com.google.android.exoplayer2.video.VideoListener
        public void onRenderedFirstFrame() {
            if (com.google.android.exoplayer2.ui.StyledPlayerView.this.u != null) {
                com.google.android.exoplayer2.ui.StyledPlayerView.this.u.setVisibility(4);
            }
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onRepeatModeChanged(int i) {
            defpackage.h32.m(this, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onSeekProcessed() {
            defpackage.h32.n(this);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onShuffleModeEnabledChanged(boolean z) {
            defpackage.h32.o(this, z);
        }

        @Override // com.google.android.exoplayer2.ui.spherical.SingleTapListener
        public boolean onSingleTapUp(android.view.MotionEvent motionEvent) {
            return com.google.android.exoplayer2.ui.StyledPlayerView.this.D();
        }

        @Override // com.google.android.exoplayer2.video.VideoListener
        public /* synthetic */ void onSurfaceSizeChanged(int i, int i2) {
            defpackage.y93.b(this, i, i2);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onTimelineChanged(com.google.android.exoplayer2.Timeline timeline, int i) {
            defpackage.h32.p(this, timeline, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onTimelineChanged(com.google.android.exoplayer2.Timeline timeline, java.lang.Object obj, int i) {
            defpackage.h32.q(this, timeline, obj, i);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onTracksChanged(com.google.android.exoplayer2.source.TrackGroupArray trackGroupArray, com.google.android.exoplayer2.trackselection.TrackSelectionArray trackSelectionArray) {
            com.google.android.exoplayer2.Player player = (com.google.android.exoplayer2.Player) com.google.android.exoplayer2.util.Assertions.checkNotNull(com.google.android.exoplayer2.ui.StyledPlayerView.this.D);
            com.google.android.exoplayer2.Timeline currentTimeline = player.getCurrentTimeline();
            if (currentTimeline.isEmpty()) {
                this.t = null;
            } else if (player.getCurrentTrackGroups().isEmpty()) {
                java.lang.Object obj = this.t;
                if (obj != null) {
                    int indexOfPeriod = currentTimeline.getIndexOfPeriod(obj);
                    if (indexOfPeriod != -1) {
                        if (player.getCurrentWindowIndex() == currentTimeline.getPeriod(indexOfPeriod, this.n).windowIndex) {
                            return;
                        }
                    }
                    this.t = null;
                }
            } else {
                this.t = currentTimeline.getPeriod(player.getCurrentPeriodIndex(), this.n, true).uid;
            }
            com.google.android.exoplayer2.ui.StyledPlayerView.this.I(false);
        }

        @Override // com.google.android.exoplayer2.video.VideoListener
        public void onVideoSizeChanged(int i, int i2, int i3, float f) {
            float f2 = (i2 == 0 || i == 0) ? 1.0f : (i * f) / i2;
            if (com.google.android.exoplayer2.ui.StyledPlayerView.this.v instanceof android.view.TextureView) {
                if (i3 == 90 || i3 == 270) {
                    f2 = 1.0f / f2;
                }
                if (com.google.android.exoplayer2.ui.StyledPlayerView.this.R != 0) {
                    com.google.android.exoplayer2.ui.StyledPlayerView.this.v.removeOnLayoutChangeListener(this);
                }
                com.google.android.exoplayer2.ui.StyledPlayerView.this.R = i3;
                if (com.google.android.exoplayer2.ui.StyledPlayerView.this.R != 0) {
                    com.google.android.exoplayer2.ui.StyledPlayerView.this.v.addOnLayoutChangeListener(this);
                }
                com.google.android.exoplayer2.ui.StyledPlayerView.q((android.view.TextureView) com.google.android.exoplayer2.ui.StyledPlayerView.this.v, com.google.android.exoplayer2.ui.StyledPlayerView.this.R);
            }
            com.google.android.exoplayer2.ui.StyledPlayerView styledPlayerView = com.google.android.exoplayer2.ui.StyledPlayerView.this;
            styledPlayerView.onContentAspectRatioChanged(f2, styledPlayerView.t, com.google.android.exoplayer2.ui.StyledPlayerView.this.v);
        }

        @Override // com.google.android.exoplayer2.ui.StyledPlayerControlView.VisibilityListener
        public void onVisibilityChange(int i) {
            com.google.android.exoplayer2.ui.StyledPlayerView.this.F();
        }
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface ShowBuffering {
    }

    public StyledPlayerView(android.content.Context context) {
        this(context, null);
    }

    public StyledPlayerView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StyledPlayerView(android.content.Context context, @androidx.annotation.Nullable android.util.AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        boolean z;
        int i2;
        boolean z2;
        int i3;
        boolean z3;
        int i4;
        int i5;
        boolean z4;
        boolean z5;
        int i6;
        int i7;
        boolean z6;
        com.google.android.exoplayer2.ui.StyledPlayerView.ComponentListener componentListener = new com.google.android.exoplayer2.ui.StyledPlayerView.ComponentListener();
        this.n = componentListener;
        if (isInEditMode()) {
            this.t = null;
            this.u = null;
            this.v = null;
            this.w = null;
            this.x = null;
            this.y = null;
            this.z = null;
            this.A = null;
            this.B = null;
            this.C = null;
            android.widget.ImageView imageView = new android.widget.ImageView(context);
            if (com.google.android.exoplayer2.util.Util.SDK_INT >= 23) {
                t(getResources(), imageView);
            } else {
                s(getResources(), imageView);
            }
            addView(imageView);
            return;
        }
        int i8 = com.google.android.exoplayer2.ui.R.layout.exo_styled_player_view;
        this.K = true;
        if (attributeSet != null) {
            android.content.res.TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, com.google.android.exoplayer2.ui.R.styleable.StyledPlayerView, 0, 0);
            try {
                int i9 = com.google.android.exoplayer2.ui.R.styleable.StyledPlayerView_shutter_background_color;
                boolean hasValue = obtainStyledAttributes.hasValue(i9);
                int color = obtainStyledAttributes.getColor(i9, 0);
                int resourceId = obtainStyledAttributes.getResourceId(com.google.android.exoplayer2.ui.R.styleable.StyledPlayerView_player_layout_id, i8);
                boolean z7 = obtainStyledAttributes.getBoolean(com.google.android.exoplayer2.ui.R.styleable.StyledPlayerView_use_artwork, true);
                int resourceId2 = obtainStyledAttributes.getResourceId(com.google.android.exoplayer2.ui.R.styleable.StyledPlayerView_default_artwork, 0);
                boolean z8 = obtainStyledAttributes.getBoolean(com.google.android.exoplayer2.ui.R.styleable.StyledPlayerView_use_controller, true);
                int i10 = obtainStyledAttributes.getInt(com.google.android.exoplayer2.ui.R.styleable.StyledPlayerView_surface_type, 1);
                int i11 = obtainStyledAttributes.getInt(com.google.android.exoplayer2.ui.R.styleable.StyledPlayerView_resize_mode, 0);
                int i12 = obtainStyledAttributes.getInt(com.google.android.exoplayer2.ui.R.styleable.StyledPlayerView_show_timeout, 5000);
                boolean z9 = obtainStyledAttributes.getBoolean(com.google.android.exoplayer2.ui.R.styleable.StyledPlayerView_hide_on_touch, true);
                boolean z10 = obtainStyledAttributes.getBoolean(com.google.android.exoplayer2.ui.R.styleable.StyledPlayerView_auto_show, true);
                i2 = obtainStyledAttributes.getInteger(com.google.android.exoplayer2.ui.R.styleable.StyledPlayerView_show_buffering, 0);
                this.J = obtainStyledAttributes.getBoolean(com.google.android.exoplayer2.ui.R.styleable.StyledPlayerView_keep_content_on_player_reset, this.J);
                boolean z11 = obtainStyledAttributes.getBoolean(com.google.android.exoplayer2.ui.R.styleable.StyledPlayerView_hide_during_ads, true);
                this.K = obtainStyledAttributes.getBoolean(com.google.android.exoplayer2.ui.R.styleable.StyledPlayerView_use_sensor_rotation, this.K);
                obtainStyledAttributes.recycle();
                z3 = z9;
                i8 = resourceId;
                z = z10;
                z2 = z11;
                i7 = i12;
                z6 = z8;
                i3 = i11;
                i6 = resourceId2;
                z5 = z7;
                z4 = hasValue;
                i5 = color;
                i4 = i10;
            } catch (java.lang.Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            z = true;
            i2 = 0;
            z2 = true;
            i3 = 0;
            z3 = true;
            i4 = 1;
            i5 = 0;
            z4 = false;
            z5 = true;
            i6 = 0;
            i7 = 5000;
            z6 = true;
        }
        android.view.LayoutInflater.from(context).inflate(i8, this);
        setDescendantFocusability(262144);
        com.google.android.exoplayer2.ui.AspectRatioFrameLayout aspectRatioFrameLayout = (com.google.android.exoplayer2.ui.AspectRatioFrameLayout) findViewById(com.google.android.exoplayer2.ui.R.id.exo_content_frame);
        this.t = aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            A(aspectRatioFrameLayout, i3);
        }
        android.view.View findViewById = findViewById(com.google.android.exoplayer2.ui.R.id.exo_shutter);
        this.u = findViewById;
        if (findViewById != null && z4) {
            findViewById.setBackgroundColor(i5);
        }
        if (aspectRatioFrameLayout == null || i4 == 0) {
            this.v = null;
        } else {
            android.view.ViewGroup.LayoutParams layoutParams = new android.view.ViewGroup.LayoutParams(-1, -1);
            if (i4 == 2) {
                this.v = new android.view.TextureView(context);
            } else if (i4 == 3) {
                com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView sphericalGLSurfaceView = new com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView(context);
                sphericalGLSurfaceView.setSingleTapListener(componentListener);
                sphericalGLSurfaceView.setUseSensorRotation(this.K);
                this.v = sphericalGLSurfaceView;
            } else if (i4 != 4) {
                this.v = new android.view.SurfaceView(context);
            } else {
                this.v = new com.google.android.exoplayer2.video.VideoDecoderGLSurfaceView(context);
            }
            this.v.setLayoutParams(layoutParams);
            aspectRatioFrameLayout.addView(this.v, 0);
        }
        this.B = (android.widget.FrameLayout) findViewById(com.google.android.exoplayer2.ui.R.id.exo_ad_overlay);
        this.C = (android.widget.FrameLayout) findViewById(com.google.android.exoplayer2.ui.R.id.exo_overlay);
        android.widget.ImageView imageView2 = (android.widget.ImageView) findViewById(com.google.android.exoplayer2.ui.R.id.exo_artwork);
        this.w = imageView2;
        this.G = z5 && imageView2 != null;
        if (i6 != 0) {
            this.H = androidx.core.content.ContextCompat.getDrawable(getContext(), i6);
        }
        com.google.android.exoplayer2.ui.SubtitleView subtitleView = (com.google.android.exoplayer2.ui.SubtitleView) findViewById(com.google.android.exoplayer2.ui.R.id.exo_subtitles);
        this.x = subtitleView;
        if (subtitleView != null) {
            subtitleView.setUserDefaultStyle();
            subtitleView.setUserDefaultTextSize();
        }
        android.view.View findViewById2 = findViewById(com.google.android.exoplayer2.ui.R.id.exo_buffering);
        this.y = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setVisibility(8);
        }
        this.I = i2;
        android.widget.TextView textView = (android.widget.TextView) findViewById(com.google.android.exoplayer2.ui.R.id.exo_error_message);
        this.z = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        int i13 = com.google.android.exoplayer2.ui.R.id.exo_controller;
        com.google.android.exoplayer2.ui.StyledPlayerControlView styledPlayerControlView = (com.google.android.exoplayer2.ui.StyledPlayerControlView) findViewById(i13);
        android.view.View findViewById3 = findViewById(com.google.android.exoplayer2.ui.R.id.exo_controller_placeholder);
        if (styledPlayerControlView != null) {
            this.A = styledPlayerControlView;
        } else if (findViewById3 != null) {
            com.google.android.exoplayer2.ui.StyledPlayerControlView styledPlayerControlView2 = new com.google.android.exoplayer2.ui.StyledPlayerControlView(context, null, 0, attributeSet);
            this.A = styledPlayerControlView2;
            styledPlayerControlView2.setId(i13);
            styledPlayerControlView2.setLayoutParams(findViewById3.getLayoutParams());
            android.view.ViewGroup viewGroup = (android.view.ViewGroup) findViewById3.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById3);
            viewGroup.removeView(findViewById3);
            viewGroup.addView(styledPlayerControlView2, indexOfChild);
        } else {
            this.A = null;
        }
        com.google.android.exoplayer2.ui.StyledPlayerControlView styledPlayerControlView3 = this.A;
        this.N = styledPlayerControlView3 != null ? i7 : 0;
        this.Q = z3;
        this.O = z;
        this.P = z2;
        this.E = z6 && styledPlayerControlView3 != null;
        if (styledPlayerControlView3 != null) {
            styledPlayerControlView3.hideImmediately();
            this.A.addVisibilityListener(componentListener);
        }
        F();
    }

    public static void A(com.google.android.exoplayer2.ui.AspectRatioFrameLayout aspectRatioFrameLayout, int i) {
        aspectRatioFrameLayout.setResizeMode(i);
    }

    public static void q(android.view.TextureView textureView, int i) {
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        float width = textureView.getWidth();
        float height = textureView.getHeight();
        if (width != 0.0f && height != 0.0f && i != 0) {
            float f = width / 2.0f;
            float f2 = height / 2.0f;
            matrix.postRotate(i, f, f2);
            android.graphics.RectF rectF = new android.graphics.RectF(0.0f, 0.0f, width, height);
            android.graphics.RectF rectF2 = new android.graphics.RectF();
            matrix.mapRect(rectF2, rectF);
            matrix.postScale(width / rectF2.width(), height / rectF2.height(), f, f2);
        }
        textureView.setTransform(matrix);
    }

    public static void s(android.content.res.Resources resources, android.widget.ImageView imageView) {
        imageView.setImageDrawable(resources.getDrawable(com.google.android.exoplayer2.ui.R.drawable.exo_edit_mode_logo));
        imageView.setBackgroundColor(resources.getColor(com.google.android.exoplayer2.ui.R.color.exo_edit_mode_background_color));
    }

    public static void switchTargetView(com.google.android.exoplayer2.Player player, @androidx.annotation.Nullable com.google.android.exoplayer2.ui.StyledPlayerView styledPlayerView, @androidx.annotation.Nullable com.google.android.exoplayer2.ui.StyledPlayerView styledPlayerView2) {
        if (styledPlayerView == styledPlayerView2) {
            return;
        }
        if (styledPlayerView2 != null) {
            styledPlayerView2.setPlayer(player);
        }
        if (styledPlayerView != null) {
            styledPlayerView.setPlayer(null);
        }
    }

    @androidx.annotation.RequiresApi(23)
    public static void t(android.content.res.Resources resources, android.widget.ImageView imageView) {
        int color;
        imageView.setImageDrawable(resources.getDrawable(com.google.android.exoplayer2.ui.R.drawable.exo_edit_mode_logo, null));
        color = resources.getColor(com.google.android.exoplayer2.ui.R.color.exo_edit_mode_background_color, null);
        imageView.setBackgroundColor(color);
    }

    public final boolean B() {
        com.google.android.exoplayer2.Player player = this.D;
        if (player == null) {
            return true;
        }
        int playbackState = player.getPlaybackState();
        return this.O && !this.D.getCurrentTimeline().isEmpty() && (playbackState == 1 || playbackState == 4 || !((com.google.android.exoplayer2.Player) com.google.android.exoplayer2.util.Assertions.checkNotNull(this.D)).getPlayWhenReady());
    }

    public final void C(boolean z) {
        if (K()) {
            this.A.setShowTimeoutMs(z ? 0 : this.N);
            this.A.show();
        }
    }

    public final boolean D() {
        if (K() && this.D != null) {
            if (!this.A.isFullyVisible()) {
                x(true);
                return true;
            }
            if (this.Q) {
                this.A.hide();
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
    
        if (r4.D.getPlayWhenReady() == false) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void E() {
        boolean z;
        if (this.y != null) {
            com.google.android.exoplayer2.Player player = this.D;
            if (player != null && player.getPlaybackState() == 2) {
                int i = this.I;
                z = true;
                if (i != 2) {
                    if (i == 1) {
                    }
                }
                this.y.setVisibility(z ? 0 : 8);
            }
            z = false;
            this.y.setVisibility(z ? 0 : 8);
        }
    }

    public final void F() {
        com.google.android.exoplayer2.ui.StyledPlayerControlView styledPlayerControlView = this.A;
        if (styledPlayerControlView == null || !this.E) {
            setContentDescription(null);
        } else if (styledPlayerControlView.isFullyVisible()) {
            setContentDescription(this.Q ? getResources().getString(com.google.android.exoplayer2.ui.R.string.exo_controls_hide) : null);
        } else {
            setContentDescription(getResources().getString(com.google.android.exoplayer2.ui.R.string.exo_controls_show));
        }
    }

    public final void G() {
        if (w() && this.P) {
            hideController();
        } else {
            x(false);
        }
    }

    public final void H() {
        com.google.android.exoplayer2.util.ErrorMessageProvider<? super com.google.android.exoplayer2.ExoPlaybackException> errorMessageProvider;
        android.widget.TextView textView = this.z;
        if (textView != null) {
            java.lang.CharSequence charSequence = this.M;
            if (charSequence != null) {
                textView.setText(charSequence);
                this.z.setVisibility(0);
                return;
            }
            com.google.android.exoplayer2.Player player = this.D;
            com.google.android.exoplayer2.ExoPlaybackException playerError = player != null ? player.getPlayerError() : null;
            if (playerError == null || (errorMessageProvider = this.L) == null) {
                this.z.setVisibility(8);
            } else {
                this.z.setText((java.lang.CharSequence) errorMessageProvider.getErrorMessage(playerError).second);
                this.z.setVisibility(0);
            }
        }
    }

    public final void I(boolean z) {
        com.google.android.exoplayer2.Player player = this.D;
        if (player == null || player.getCurrentTrackGroups().isEmpty()) {
            if (this.J) {
                return;
            }
            u();
            r();
            return;
        }
        if (z && !this.J) {
            r();
        }
        com.google.android.exoplayer2.trackselection.TrackSelectionArray currentTrackSelections = player.getCurrentTrackSelections();
        for (int i = 0; i < currentTrackSelections.length; i++) {
            if (player.getRendererType(i) == 2 && currentTrackSelections.get(i) != null) {
                u();
                return;
            }
        }
        r();
        if (J()) {
            for (int i2 = 0; i2 < currentTrackSelections.length; i2++) {
                com.google.android.exoplayer2.trackselection.TrackSelection trackSelection = currentTrackSelections.get(i2);
                if (trackSelection != null) {
                    for (int i3 = 0; i3 < trackSelection.length(); i3++) {
                        com.google.android.exoplayer2.metadata.Metadata metadata = trackSelection.getFormat(i3).metadata;
                        if (metadata != null && y(metadata)) {
                            return;
                        }
                    }
                }
            }
            if (z(this.H)) {
                return;
            }
        }
        u();
    }

    @org.checkerframework.checker.nullness.qual.EnsuresNonNullIf(expression = {"artworkView"}, result = true)
    public final boolean J() {
        if (!this.G) {
            return false;
        }
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.w);
        return true;
    }

    @org.checkerframework.checker.nullness.qual.EnsuresNonNullIf(expression = {"controller"}, result = true)
    public final boolean K() {
        if (!this.E) {
            return false;
        }
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.A);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(android.view.KeyEvent keyEvent) {
        com.google.android.exoplayer2.Player player = this.D;
        if (player != null && player.isPlayingAd()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        boolean v = v(keyEvent.getKeyCode());
        if (v && K() && !this.A.isFullyVisible()) {
            x(true);
            return true;
        }
        if (dispatchMediaKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent)) {
            x(true);
            return true;
        }
        if (v && K()) {
            x(true);
        }
        return false;
    }

    public boolean dispatchMediaKeyEvent(android.view.KeyEvent keyEvent) {
        return K() && this.A.dispatchMediaKeyEvent(keyEvent);
    }

    @Override // com.google.android.exoplayer2.source.ads.AdsLoader.AdViewProvider
    public java.util.List<com.google.android.exoplayer2.source.ads.AdsLoader.OverlayInfo> getAdOverlayInfos() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        android.widget.FrameLayout frameLayout = this.C;
        if (frameLayout != null) {
            arrayList.add(new com.google.android.exoplayer2.source.ads.AdsLoader.OverlayInfo(frameLayout, 3, "Transparent overlay does not impact viewability"));
        }
        com.google.android.exoplayer2.ui.StyledPlayerControlView styledPlayerControlView = this.A;
        if (styledPlayerControlView != null) {
            arrayList.add(new com.google.android.exoplayer2.source.ads.AdsLoader.OverlayInfo(styledPlayerControlView, 0));
        }
        return com.google.common.collect.ImmutableList.copyOf((java.util.Collection) arrayList);
    }

    @Override // com.google.android.exoplayer2.source.ads.AdsLoader.AdViewProvider
    public /* synthetic */ android.view.View[] getAdOverlayViews() {
        return defpackage.w7.b(this);
    }

    @Override // com.google.android.exoplayer2.source.ads.AdsLoader.AdViewProvider
    public android.view.ViewGroup getAdViewGroup() {
        return (android.view.ViewGroup) com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.B, "exo_ad_overlay must be present for ad playback");
    }

    public boolean getControllerAutoShow() {
        return this.O;
    }

    public boolean getControllerHideOnTouch() {
        return this.Q;
    }

    public int getControllerShowTimeoutMs() {
        return this.N;
    }

    @androidx.annotation.Nullable
    public android.graphics.drawable.Drawable getDefaultArtwork() {
        return this.H;
    }

    @androidx.annotation.Nullable
    public android.widget.FrameLayout getOverlayFrameLayout() {
        return this.C;
    }

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.Player getPlayer() {
        return this.D;
    }

    public int getResizeMode() {
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.t);
        return this.t.getResizeMode();
    }

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.ui.SubtitleView getSubtitleView() {
        return this.x;
    }

    public boolean getUseArtwork() {
        return this.G;
    }

    public boolean getUseController() {
        return this.E;
    }

    @androidx.annotation.Nullable
    public android.view.View getVideoSurfaceView() {
        return this.v;
    }

    public void hideController() {
        com.google.android.exoplayer2.ui.StyledPlayerControlView styledPlayerControlView = this.A;
        if (styledPlayerControlView != null) {
            styledPlayerControlView.hide();
        }
    }

    public boolean isControllerFullyVisible() {
        com.google.android.exoplayer2.ui.StyledPlayerControlView styledPlayerControlView = this.A;
        return styledPlayerControlView != null && styledPlayerControlView.isFullyVisible();
    }

    public void onContentAspectRatioChanged(float f, @androidx.annotation.Nullable com.google.android.exoplayer2.ui.AspectRatioFrameLayout aspectRatioFrameLayout, @androidx.annotation.Nullable android.view.View view) {
        if (aspectRatioFrameLayout != null) {
            if (view instanceof com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView) {
                f = 0.0f;
            }
            aspectRatioFrameLayout.setAspectRatio(f);
        }
    }

    public void onPause() {
        android.view.View view = this.v;
        if (view instanceof com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView) {
            ((com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView) view).onPause();
        }
    }

    public void onResume() {
        android.view.View view = this.v;
        if (view instanceof com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView) {
            ((com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView) view).onResume();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        if (!K() || this.D == null) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.S = true;
            return true;
        }
        if (action != 1 || !this.S) {
            return false;
        }
        this.S = false;
        return performClick();
    }

    @Override // android.view.View
    public boolean onTrackballEvent(android.view.MotionEvent motionEvent) {
        if (!K() || this.D == null) {
            return false;
        }
        x(true);
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        super.performClick();
        return D();
    }

    public final void r() {
        android.view.View view = this.u;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public void setAspectRatioListener(@androidx.annotation.Nullable com.google.android.exoplayer2.ui.AspectRatioFrameLayout.AspectRatioListener aspectRatioListener) {
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.t);
        this.t.setAspectRatioListener(aspectRatioListener);
    }

    public void setControlDispatcher(com.google.android.exoplayer2.ControlDispatcher controlDispatcher) {
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.A);
        this.A.setControlDispatcher(controlDispatcher);
    }

    public void setControllerAutoShow(boolean z) {
        this.O = z;
    }

    public void setControllerHideDuringAds(boolean z) {
        this.P = z;
    }

    public void setControllerHideOnTouch(boolean z) {
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.A);
        this.Q = z;
        F();
    }

    public void setControllerOnFullScreenModeChangedListener(@androidx.annotation.Nullable com.google.android.exoplayer2.ui.StyledPlayerControlView.OnFullScreenModeChangedListener onFullScreenModeChangedListener) {
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.A);
        this.A.setOnFullScreenModeChangedListener(onFullScreenModeChangedListener);
    }

    public void setControllerShowTimeoutMs(int i) {
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.A);
        this.N = i;
        if (this.A.isFullyVisible()) {
            showController();
        }
    }

    public void setControllerVisibilityListener(@androidx.annotation.Nullable com.google.android.exoplayer2.ui.StyledPlayerControlView.VisibilityListener visibilityListener) {
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.A);
        com.google.android.exoplayer2.ui.StyledPlayerControlView.VisibilityListener visibilityListener2 = this.F;
        if (visibilityListener2 == visibilityListener) {
            return;
        }
        if (visibilityListener2 != null) {
            this.A.removeVisibilityListener(visibilityListener2);
        }
        this.F = visibilityListener;
        if (visibilityListener != null) {
            this.A.addVisibilityListener(visibilityListener);
        }
    }

    public void setCustomErrorMessage(@androidx.annotation.Nullable java.lang.CharSequence charSequence) {
        com.google.android.exoplayer2.util.Assertions.checkState(this.z != null);
        this.M = charSequence;
        H();
    }

    public void setDefaultArtwork(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        if (this.H != drawable) {
            this.H = drawable;
            I(false);
        }
    }

    public void setErrorMessageProvider(@androidx.annotation.Nullable com.google.android.exoplayer2.util.ErrorMessageProvider<? super com.google.android.exoplayer2.ExoPlaybackException> errorMessageProvider) {
        if (this.L != errorMessageProvider) {
            this.L = errorMessageProvider;
            H();
        }
    }

    public void setExtraAdGroupMarkers(@androidx.annotation.Nullable long[] jArr, @androidx.annotation.Nullable boolean[] zArr) {
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.A);
        this.A.setExtraAdGroupMarkers(jArr, zArr);
    }

    public void setKeepContentOnPlayerReset(boolean z) {
        if (this.J != z) {
            this.J = z;
            I(false);
        }
    }

    public void setPlaybackPreparer(@androidx.annotation.Nullable com.google.android.exoplayer2.PlaybackPreparer playbackPreparer) {
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.A);
        this.A.setPlaybackPreparer(playbackPreparer);
    }

    public void setPlayer(@androidx.annotation.Nullable com.google.android.exoplayer2.Player player) {
        com.google.android.exoplayer2.util.Assertions.checkState(android.os.Looper.myLooper() == android.os.Looper.getMainLooper());
        com.google.android.exoplayer2.util.Assertions.checkArgument(player == null || player.getApplicationLooper() == android.os.Looper.getMainLooper());
        com.google.android.exoplayer2.Player player2 = this.D;
        if (player2 == player) {
            return;
        }
        if (player2 != null) {
            player2.removeListener(this.n);
            com.google.android.exoplayer2.Player.VideoComponent videoComponent = player2.getVideoComponent();
            if (videoComponent != null) {
                videoComponent.removeVideoListener(this.n);
                android.view.View view = this.v;
                if (view instanceof android.view.TextureView) {
                    videoComponent.clearVideoTextureView((android.view.TextureView) view);
                } else if (view instanceof com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView) {
                    ((com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView) view).setVideoComponent(null);
                } else if (view instanceof com.google.android.exoplayer2.video.VideoDecoderGLSurfaceView) {
                    videoComponent.setVideoDecoderOutputBufferRenderer(null);
                } else if (view instanceof android.view.SurfaceView) {
                    videoComponent.clearVideoSurfaceView((android.view.SurfaceView) view);
                }
            }
            com.google.android.exoplayer2.Player.TextComponent textComponent = player2.getTextComponent();
            if (textComponent != null) {
                textComponent.removeTextOutput(this.n);
            }
        }
        com.google.android.exoplayer2.ui.SubtitleView subtitleView = this.x;
        if (subtitleView != null) {
            subtitleView.setCues(null);
        }
        this.D = player;
        if (K()) {
            this.A.setPlayer(player);
        }
        E();
        H();
        I(true);
        if (player == null) {
            hideController();
            return;
        }
        com.google.android.exoplayer2.Player.VideoComponent videoComponent2 = player.getVideoComponent();
        if (videoComponent2 != null) {
            android.view.View view2 = this.v;
            if (view2 instanceof android.view.TextureView) {
                videoComponent2.setVideoTextureView((android.view.TextureView) view2);
            } else if (view2 instanceof com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView) {
                ((com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView) view2).setVideoComponent(videoComponent2);
            } else if (view2 instanceof com.google.android.exoplayer2.video.VideoDecoderGLSurfaceView) {
                videoComponent2.setVideoDecoderOutputBufferRenderer(((com.google.android.exoplayer2.video.VideoDecoderGLSurfaceView) view2).getVideoDecoderOutputBufferRenderer());
            } else if (view2 instanceof android.view.SurfaceView) {
                videoComponent2.setVideoSurfaceView((android.view.SurfaceView) view2);
            }
            videoComponent2.addVideoListener(this.n);
        }
        com.google.android.exoplayer2.Player.TextComponent textComponent2 = player.getTextComponent();
        if (textComponent2 != null) {
            textComponent2.addTextOutput(this.n);
            com.google.android.exoplayer2.ui.SubtitleView subtitleView2 = this.x;
            if (subtitleView2 != null) {
                subtitleView2.setCues(textComponent2.getCurrentCues());
            }
        }
        player.addListener(this.n);
        x(false);
    }

    public void setRepeatToggleModes(int i) {
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.A);
        this.A.setRepeatToggleModes(i);
    }

    public void setResizeMode(int i) {
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.t);
        this.t.setResizeMode(i);
    }

    public void setShowBuffering(int i) {
        if (this.I != i) {
            this.I = i;
            E();
        }
    }

    public void setShowFastForwardButton(boolean z) {
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.A);
        this.A.setShowFastForwardButton(z);
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.A);
        this.A.setShowMultiWindowTimeBar(z);
    }

    public void setShowNextButton(boolean z) {
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.A);
        this.A.setShowNextButton(z);
    }

    public void setShowPreviousButton(boolean z) {
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.A);
        this.A.setShowPreviousButton(z);
    }

    public void setShowRewindButton(boolean z) {
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.A);
        this.A.setShowRewindButton(z);
    }

    public void setShowShuffleButton(boolean z) {
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.A);
        this.A.setShowShuffleButton(z);
    }

    public void setShowSubtitleButton(boolean z) {
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.A);
        this.A.setShowSubtitleButton(z);
    }

    public void setShowVrButton(boolean z) {
        com.google.android.exoplayer2.util.Assertions.checkStateNotNull(this.A);
        this.A.setShowVrButton(z);
    }

    public void setShutterBackgroundColor(int i) {
        android.view.View view = this.u;
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    public void setUseArtwork(boolean z) {
        com.google.android.exoplayer2.util.Assertions.checkState((z && this.w == null) ? false : true);
        if (this.G != z) {
            this.G = z;
            I(false);
        }
    }

    public void setUseController(boolean z) {
        com.google.android.exoplayer2.util.Assertions.checkState((z && this.A == null) ? false : true);
        if (this.E == z) {
            return;
        }
        this.E = z;
        if (K()) {
            this.A.setPlayer(this.D);
        } else {
            com.google.android.exoplayer2.ui.StyledPlayerControlView styledPlayerControlView = this.A;
            if (styledPlayerControlView != null) {
                styledPlayerControlView.hide();
                this.A.setPlayer(null);
            }
        }
        F();
    }

    public void setUseSensorRotation(boolean z) {
        if (this.K != z) {
            this.K = z;
            android.view.View view = this.v;
            if (view instanceof com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView) {
                ((com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView) view).setUseSensorRotation(z);
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        android.view.View view = this.v;
        if (view instanceof android.view.SurfaceView) {
            view.setVisibility(i);
        }
    }

    public void showController() {
        C(B());
    }

    public final void u() {
        android.widget.ImageView imageView = this.w;
        if (imageView != null) {
            imageView.setImageResource(android.R.color.transparent);
            this.w.setVisibility(4);
        }
    }

    @android.annotation.SuppressLint({"InlinedApi"})
    public final boolean v(int i) {
        return i == 19 || i == 270 || i == 22 || i == 271 || i == 20 || i == 269 || i == 21 || i == 268 || i == 23;
    }

    public final boolean w() {
        com.google.android.exoplayer2.Player player = this.D;
        return player != null && player.isPlayingAd() && this.D.getPlayWhenReady();
    }

    public final void x(boolean z) {
        if (!(w() && this.P) && K()) {
            boolean z2 = this.A.isFullyVisible() && this.A.getShowTimeoutMs() <= 0;
            boolean B = B();
            if (z || z2 || B) {
                C(B);
            }
        }
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"artworkView"})
    public final boolean y(com.google.android.exoplayer2.metadata.Metadata metadata) {
        byte[] bArr;
        int i;
        int i2 = -1;
        boolean z = false;
        for (int i3 = 0; i3 < metadata.length(); i3++) {
            com.google.android.exoplayer2.metadata.Metadata.Entry entry = metadata.get(i3);
            if (entry instanceof com.google.android.exoplayer2.metadata.id3.ApicFrame) {
                com.google.android.exoplayer2.metadata.id3.ApicFrame apicFrame = (com.google.android.exoplayer2.metadata.id3.ApicFrame) entry;
                bArr = apicFrame.pictureData;
                i = apicFrame.pictureType;
            } else if (entry instanceof com.google.android.exoplayer2.metadata.flac.PictureFrame) {
                com.google.android.exoplayer2.metadata.flac.PictureFrame pictureFrame = (com.google.android.exoplayer2.metadata.flac.PictureFrame) entry;
                bArr = pictureFrame.pictureData;
                i = pictureFrame.pictureType;
            } else {
                continue;
            }
            if (i2 == -1 || i == 3) {
                z = z(new android.graphics.drawable.BitmapDrawable(getResources(), android.graphics.BitmapFactory.decodeByteArray(bArr, 0, bArr.length)));
                if (i == 3) {
                    break;
                }
                i2 = i;
            }
        }
        return z;
    }

    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"artworkView"})
    public final boolean z(@androidx.annotation.Nullable android.graphics.drawable.Drawable drawable) {
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                onContentAspectRatioChanged(intrinsicWidth / intrinsicHeight, this.t, this.w);
                this.w.setImageDrawable(drawable);
                this.w.setVisibility(0);
                return true;
            }
        }
        return false;
    }
}
