package com.google.android.exoplayer2.ui;

/* loaded from: classes22.dex */
public class PlayerNotificationManager {
    public static final java.lang.String ACTION_FAST_FORWARD = "com.google.android.exoplayer.ffwd";
    public static final java.lang.String ACTION_NEXT = "com.google.android.exoplayer.next";
    public static final java.lang.String ACTION_PAUSE = "com.google.android.exoplayer.pause";
    public static final java.lang.String ACTION_PLAY = "com.google.android.exoplayer.play";
    public static final java.lang.String ACTION_PREVIOUS = "com.google.android.exoplayer.prev";
    public static final java.lang.String ACTION_REWIND = "com.google.android.exoplayer.rewind";
    public static final java.lang.String ACTION_STOP = "com.google.android.exoplayer.stop";
    public static final java.lang.String EXTRA_INSTANCE_ID = "INSTANCE_ID";
    public static int K;
    public boolean A;
    public boolean B;
    public int C;
    public boolean D;
    public int E;
    public int F;

    @androidx.annotation.DrawableRes
    public int G;
    public int H;
    public int I;
    public boolean J;
    public final android.content.Context a;
    public final java.lang.String b;
    public final int c;
    public final com.google.android.exoplayer2.ui.PlayerNotificationManager.MediaDescriptionAdapter d;

    @androidx.annotation.Nullable
    public final com.google.android.exoplayer2.ui.PlayerNotificationManager.CustomActionReceiver e;
    public final android.os.Handler f;
    public final androidx.core.app.NotificationManagerCompat g;
    public final android.content.IntentFilter h;
    public final com.google.android.exoplayer2.Player.EventListener i;
    public final com.google.android.exoplayer2.ui.PlayerNotificationManager.NotificationBroadcastReceiver j;
    public final java.util.Map<java.lang.String, androidx.core.app.NotificationCompat.Action> k;
    public final java.util.Map<java.lang.String, androidx.core.app.NotificationCompat.Action> l;
    public final android.app.PendingIntent m;
    public final int n;
    public final com.google.android.exoplayer2.Timeline.Window o;

    @androidx.annotation.Nullable
    public androidx.core.app.NotificationCompat.Builder p;

    @androidx.annotation.Nullable
    public java.util.List<androidx.core.app.NotificationCompat.Action> q;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.Player r;

    /* renamed from: s, reason: collision with root package name */
    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.PlaybackPreparer f365s;
    public com.google.android.exoplayer2.ControlDispatcher t;
    public boolean u;
    public int v;

    @androidx.annotation.Nullable
    public com.google.android.exoplayer2.ui.PlayerNotificationManager.NotificationListener w;

    @androidx.annotation.Nullable
    public android.support.v4.media.session.MediaSessionCompat.Token x;
    public boolean y;
    public boolean z;

    public final class BitmapCallback {
        public final int a;

        public BitmapCallback(int i) {
            this.a = i;
        }

        public /* synthetic */ BitmapCallback(com.google.android.exoplayer2.ui.PlayerNotificationManager playerNotificationManager, int i, com.google.android.exoplayer2.ui.PlayerNotificationManager.AnonymousClass1 anonymousClass1) {
            this(i);
        }

        public void onBitmap(android.graphics.Bitmap bitmap) {
            if (bitmap != null) {
                com.google.android.exoplayer2.ui.PlayerNotificationManager.this.q(bitmap, this.a);
            }
        }
    }

    public interface CustomActionReceiver {
        java.util.Map<java.lang.String, androidx.core.app.NotificationCompat.Action> createCustomActions(android.content.Context context, int i);

        java.util.List<java.lang.String> getCustomActions(com.google.android.exoplayer2.Player player);

        void onCustomAction(com.google.android.exoplayer2.Player player, java.lang.String str, android.content.Intent intent);
    }

    public interface MediaDescriptionAdapter {
        @androidx.annotation.Nullable
        android.app.PendingIntent createCurrentContentIntent(com.google.android.exoplayer2.Player player);

        @androidx.annotation.Nullable
        java.lang.CharSequence getCurrentContentText(com.google.android.exoplayer2.Player player);

        java.lang.CharSequence getCurrentContentTitle(com.google.android.exoplayer2.Player player);

        @androidx.annotation.Nullable
        android.graphics.Bitmap getCurrentLargeIcon(com.google.android.exoplayer2.Player player, com.google.android.exoplayer2.ui.PlayerNotificationManager.BitmapCallback bitmapCallback);

        @androidx.annotation.Nullable
        java.lang.CharSequence getCurrentSubText(com.google.android.exoplayer2.Player player);
    }

    public class NotificationBroadcastReceiver extends android.content.BroadcastReceiver {
        public NotificationBroadcastReceiver() {
        }

        public /* synthetic */ NotificationBroadcastReceiver(com.google.android.exoplayer2.ui.PlayerNotificationManager playerNotificationManager, com.google.android.exoplayer2.ui.PlayerNotificationManager.AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(android.content.Context context, android.content.Intent intent) {
            com.google.android.exoplayer2.Player player = com.google.android.exoplayer2.ui.PlayerNotificationManager.this.r;
            if (player != null && com.google.android.exoplayer2.ui.PlayerNotificationManager.this.u && intent.getIntExtra(com.google.android.exoplayer2.ui.PlayerNotificationManager.EXTRA_INSTANCE_ID, com.google.android.exoplayer2.ui.PlayerNotificationManager.this.n) == com.google.android.exoplayer2.ui.PlayerNotificationManager.this.n) {
                java.lang.String action = intent.getAction();
                if (com.google.android.exoplayer2.ui.PlayerNotificationManager.ACTION_PLAY.equals(action)) {
                    if (player.getPlaybackState() == 1) {
                        if (com.google.android.exoplayer2.ui.PlayerNotificationManager.this.f365s != null) {
                            com.google.android.exoplayer2.ui.PlayerNotificationManager.this.f365s.preparePlayback();
                        }
                    } else if (player.getPlaybackState() == 4) {
                        com.google.android.exoplayer2.ui.PlayerNotificationManager.this.t.dispatchSeekTo(player, player.getCurrentWindowIndex(), -9223372036854775807L);
                    }
                    com.google.android.exoplayer2.ui.PlayerNotificationManager.this.t.dispatchSetPlayWhenReady(player, true);
                    return;
                }
                if (com.google.android.exoplayer2.ui.PlayerNotificationManager.ACTION_PAUSE.equals(action)) {
                    com.google.android.exoplayer2.ui.PlayerNotificationManager.this.t.dispatchSetPlayWhenReady(player, false);
                    return;
                }
                if (com.google.android.exoplayer2.ui.PlayerNotificationManager.ACTION_PREVIOUS.equals(action)) {
                    com.google.android.exoplayer2.ui.PlayerNotificationManager.this.t.dispatchPrevious(player);
                    return;
                }
                if (com.google.android.exoplayer2.ui.PlayerNotificationManager.ACTION_REWIND.equals(action)) {
                    com.google.android.exoplayer2.ui.PlayerNotificationManager.this.t.dispatchRewind(player);
                    return;
                }
                if (com.google.android.exoplayer2.ui.PlayerNotificationManager.ACTION_FAST_FORWARD.equals(action)) {
                    com.google.android.exoplayer2.ui.PlayerNotificationManager.this.t.dispatchFastForward(player);
                    return;
                }
                if (com.google.android.exoplayer2.ui.PlayerNotificationManager.ACTION_NEXT.equals(action)) {
                    com.google.android.exoplayer2.ui.PlayerNotificationManager.this.t.dispatchNext(player);
                    return;
                }
                if (com.google.android.exoplayer2.ui.PlayerNotificationManager.ACTION_STOP.equals(action)) {
                    com.google.android.exoplayer2.ui.PlayerNotificationManager.this.t.dispatchStop(player, true);
                    return;
                }
                if ("com.google.android.exoplayer.dismiss".equals(action)) {
                    com.google.android.exoplayer2.ui.PlayerNotificationManager.this.u(true);
                } else {
                    if (action == null || com.google.android.exoplayer2.ui.PlayerNotificationManager.this.e == null || !com.google.android.exoplayer2.ui.PlayerNotificationManager.this.l.containsKey(action)) {
                        return;
                    }
                    com.google.android.exoplayer2.ui.PlayerNotificationManager.this.e.onCustomAction(player, action, intent);
                }
            }
        }
    }

    public interface NotificationListener {
        @java.lang.Deprecated
        void onNotificationCancelled(int i);

        void onNotificationCancelled(int i, boolean z);

        void onNotificationPosted(int i, android.app.Notification notification, boolean z);

        @java.lang.Deprecated
        void onNotificationStarted(int i, android.app.Notification notification);
    }

    public class PlayerListener implements com.google.android.exoplayer2.Player.EventListener {
        public PlayerListener() {
        }

        public /* synthetic */ PlayerListener(com.google.android.exoplayer2.ui.PlayerNotificationManager playerNotificationManager, com.google.android.exoplayer2.ui.PlayerNotificationManager.AnonymousClass1 anonymousClass1) {
            this();
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
            com.google.android.exoplayer2.ui.PlayerNotificationManager.this.p();
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
            com.google.android.exoplayer2.ui.PlayerNotificationManager.this.p();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlaybackParametersChanged(com.google.android.exoplayer2.PlaybackParameters playbackParameters) {
            com.google.android.exoplayer2.ui.PlayerNotificationManager.this.p();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onPlaybackStateChanged(int i) {
            com.google.android.exoplayer2.ui.PlayerNotificationManager.this.p();
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
            com.google.android.exoplayer2.ui.PlayerNotificationManager.this.p();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onRepeatModeChanged(int i) {
            com.google.android.exoplayer2.ui.PlayerNotificationManager.this.p();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public /* synthetic */ void onSeekProcessed() {
            defpackage.h32.n(this);
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onShuffleModeEnabledChanged(boolean z) {
            com.google.android.exoplayer2.ui.PlayerNotificationManager.this.p();
        }

        @Override // com.google.android.exoplayer2.Player.EventListener
        public void onTimelineChanged(com.google.android.exoplayer2.Timeline timeline, int i) {
            com.google.android.exoplayer2.ui.PlayerNotificationManager.this.p();
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

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Priority {
    }

    @java.lang.annotation.Documented
    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    public @interface Visibility {
    }

    public PlayerNotificationManager(android.content.Context context, java.lang.String str, int i, com.google.android.exoplayer2.ui.PlayerNotificationManager.MediaDescriptionAdapter mediaDescriptionAdapter) {
        this(context, str, i, mediaDescriptionAdapter, null, null);
    }

    public PlayerNotificationManager(android.content.Context context, java.lang.String str, int i, com.google.android.exoplayer2.ui.PlayerNotificationManager.MediaDescriptionAdapter mediaDescriptionAdapter, @androidx.annotation.Nullable com.google.android.exoplayer2.ui.PlayerNotificationManager.CustomActionReceiver customActionReceiver) {
        this(context, str, i, mediaDescriptionAdapter, null, customActionReceiver);
    }

    public PlayerNotificationManager(android.content.Context context, java.lang.String str, int i, com.google.android.exoplayer2.ui.PlayerNotificationManager.MediaDescriptionAdapter mediaDescriptionAdapter, @androidx.annotation.Nullable com.google.android.exoplayer2.ui.PlayerNotificationManager.NotificationListener notificationListener) {
        this(context, str, i, mediaDescriptionAdapter, notificationListener, null);
    }

    public PlayerNotificationManager(android.content.Context context, java.lang.String str, int i, com.google.android.exoplayer2.ui.PlayerNotificationManager.MediaDescriptionAdapter mediaDescriptionAdapter, @androidx.annotation.Nullable com.google.android.exoplayer2.ui.PlayerNotificationManager.NotificationListener notificationListener, @androidx.annotation.Nullable com.google.android.exoplayer2.ui.PlayerNotificationManager.CustomActionReceiver customActionReceiver) {
        android.content.Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.b = str;
        this.c = i;
        this.d = mediaDescriptionAdapter;
        this.w = notificationListener;
        this.e = customActionReceiver;
        this.t = new com.google.android.exoplayer2.DefaultControlDispatcher();
        this.o = new com.google.android.exoplayer2.Timeline.Window();
        int i2 = K;
        K = i2 + 1;
        this.n = i2;
        this.f = com.google.android.exoplayer2.util.Util.createHandler(android.os.Looper.getMainLooper(), new defpackage.k32(this));
        this.g = androidx.core.app.NotificationManagerCompat.from(applicationContext);
        this.i = new com.google.android.exoplayer2.ui.PlayerNotificationManager.PlayerListener(this, null);
        this.j = new com.google.android.exoplayer2.ui.PlayerNotificationManager.NotificationBroadcastReceiver(this, null);
        this.h = new android.content.IntentFilter();
        this.y = true;
        this.A = true;
        this.D = true;
        this.J = true;
        this.F = 0;
        this.G = com.google.android.exoplayer2.ui.R.drawable.exo_notification_small_icon;
        this.E = 0;
        this.I = -1;
        this.C = 1;
        this.H = 1;
        java.util.Map<java.lang.String, androidx.core.app.NotificationCompat.Action> m = m(applicationContext, i2);
        this.k = m;
        java.util.Iterator<java.lang.String> it = m.keySet().iterator();
        while (it.hasNext()) {
            this.h.addAction(it.next());
        }
        java.util.Map<java.lang.String, androidx.core.app.NotificationCompat.Action> createCustomActions = customActionReceiver != null ? customActionReceiver.createCustomActions(applicationContext, this.n) : java.util.Collections.emptyMap();
        this.l = createCustomActions;
        java.util.Iterator<java.lang.String> it2 = createCustomActions.keySet().iterator();
        while (it2.hasNext()) {
            this.h.addAction(it2.next());
        }
        this.m = l("com.google.android.exoplayer.dismiss", applicationContext, this.n);
        this.h.addAction("com.google.android.exoplayer.dismiss");
    }

    public static com.google.android.exoplayer2.ui.PlayerNotificationManager createWithNotificationChannel(android.content.Context context, java.lang.String str, @androidx.annotation.StringRes int i, @androidx.annotation.StringRes int i2, int i3, com.google.android.exoplayer2.ui.PlayerNotificationManager.MediaDescriptionAdapter mediaDescriptionAdapter) {
        com.google.android.exoplayer2.util.NotificationUtil.createNotificationChannel(context, str, i, i2, 2);
        return new com.google.android.exoplayer2.ui.PlayerNotificationManager(context, str, i3, mediaDescriptionAdapter);
    }

    public static com.google.android.exoplayer2.ui.PlayerNotificationManager createWithNotificationChannel(android.content.Context context, java.lang.String str, @androidx.annotation.StringRes int i, @androidx.annotation.StringRes int i2, int i3, com.google.android.exoplayer2.ui.PlayerNotificationManager.MediaDescriptionAdapter mediaDescriptionAdapter, @androidx.annotation.Nullable com.google.android.exoplayer2.ui.PlayerNotificationManager.NotificationListener notificationListener) {
        com.google.android.exoplayer2.util.NotificationUtil.createNotificationChannel(context, str, i, i2, 2);
        return new com.google.android.exoplayer2.ui.PlayerNotificationManager(context, str, i3, mediaDescriptionAdapter, notificationListener);
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.ui.PlayerNotificationManager createWithNotificationChannel(android.content.Context context, java.lang.String str, @androidx.annotation.StringRes int i, int i2, com.google.android.exoplayer2.ui.PlayerNotificationManager.MediaDescriptionAdapter mediaDescriptionAdapter) {
        return createWithNotificationChannel(context, str, i, 0, i2, mediaDescriptionAdapter);
    }

    @java.lang.Deprecated
    public static com.google.android.exoplayer2.ui.PlayerNotificationManager createWithNotificationChannel(android.content.Context context, java.lang.String str, @androidx.annotation.StringRes int i, int i2, com.google.android.exoplayer2.ui.PlayerNotificationManager.MediaDescriptionAdapter mediaDescriptionAdapter, @androidx.annotation.Nullable com.google.android.exoplayer2.ui.PlayerNotificationManager.NotificationListener notificationListener) {
        return createWithNotificationChannel(context, str, i, 0, i2, mediaDescriptionAdapter, notificationListener);
    }

    public static android.app.PendingIntent l(java.lang.String str, android.content.Context context, int i) {
        android.content.Intent intent = new android.content.Intent(str).setPackage(context.getPackageName());
        intent.putExtra(EXTRA_INSTANCE_ID, i);
        return android.app.PendingIntent.getBroadcast(context, i, intent, 134217728);
    }

    public static java.util.Map<java.lang.String, androidx.core.app.NotificationCompat.Action> m(android.content.Context context, int i) {
        java.util.HashMap hashMap = new java.util.HashMap();
        hashMap.put(ACTION_PLAY, new androidx.core.app.NotificationCompat.Action(com.google.android.exoplayer2.ui.R.drawable.exo_notification_play, context.getString(com.google.android.exoplayer2.ui.R.string.exo_controls_play_description), l(ACTION_PLAY, context, i)));
        hashMap.put(ACTION_PAUSE, new androidx.core.app.NotificationCompat.Action(com.google.android.exoplayer2.ui.R.drawable.exo_notification_pause, context.getString(com.google.android.exoplayer2.ui.R.string.exo_controls_pause_description), l(ACTION_PAUSE, context, i)));
        hashMap.put(ACTION_STOP, new androidx.core.app.NotificationCompat.Action(com.google.android.exoplayer2.ui.R.drawable.exo_notification_stop, context.getString(com.google.android.exoplayer2.ui.R.string.exo_controls_stop_description), l(ACTION_STOP, context, i)));
        hashMap.put(ACTION_REWIND, new androidx.core.app.NotificationCompat.Action(com.google.android.exoplayer2.ui.R.drawable.exo_notification_rewind, context.getString(com.google.android.exoplayer2.ui.R.string.exo_controls_rewind_description), l(ACTION_REWIND, context, i)));
        hashMap.put(ACTION_FAST_FORWARD, new androidx.core.app.NotificationCompat.Action(com.google.android.exoplayer2.ui.R.drawable.exo_notification_fastforward, context.getString(com.google.android.exoplayer2.ui.R.string.exo_controls_fastforward_description), l(ACTION_FAST_FORWARD, context, i)));
        hashMap.put(ACTION_PREVIOUS, new androidx.core.app.NotificationCompat.Action(com.google.android.exoplayer2.ui.R.drawable.exo_notification_previous, context.getString(com.google.android.exoplayer2.ui.R.string.exo_controls_previous_description), l(ACTION_PREVIOUS, context, i)));
        hashMap.put(ACTION_NEXT, new androidx.core.app.NotificationCompat.Action(com.google.android.exoplayer2.ui.R.drawable.exo_notification_next, context.getString(com.google.android.exoplayer2.ui.R.string.exo_controls_next_description), l(ACTION_NEXT, context, i)));
        return hashMap;
    }

    public static void r(androidx.core.app.NotificationCompat.Builder builder, @androidx.annotation.Nullable android.graphics.Bitmap bitmap) {
        builder.setLargeIcon(bitmap);
    }

    @androidx.annotation.Nullable
    public androidx.core.app.NotificationCompat.Builder createNotification(com.google.android.exoplayer2.Player player, @androidx.annotation.Nullable androidx.core.app.NotificationCompat.Builder builder, boolean z, @androidx.annotation.Nullable android.graphics.Bitmap bitmap) {
        if (player.getPlaybackState() == 1 && (player.getCurrentTimeline().isEmpty() || this.f365s == null)) {
            this.q = null;
            return null;
        }
        java.util.List<java.lang.String> actions = getActions(player);
        java.util.ArrayList arrayList = new java.util.ArrayList(actions.size());
        for (int i = 0; i < actions.size(); i++) {
            java.lang.String str = actions.get(i);
            androidx.core.app.NotificationCompat.Action action = this.k.containsKey(str) ? this.k.get(str) : this.l.get(str);
            if (action != null) {
                arrayList.add(action);
            }
        }
        if (builder == null || !arrayList.equals(this.q)) {
            builder = new androidx.core.app.NotificationCompat.Builder(this.a, this.b);
            this.q = arrayList;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                builder.addAction((androidx.core.app.NotificationCompat.Action) arrayList.get(i2));
            }
        }
        androidx.media.app.NotificationCompat.MediaStyle mediaStyle = new androidx.media.app.NotificationCompat.MediaStyle();
        android.support.v4.media.session.MediaSessionCompat.Token token = this.x;
        if (token != null) {
            mediaStyle.setMediaSession(token);
        }
        mediaStyle.setShowActionsInCompactView(getActionIndicesForCompactView(actions, player));
        mediaStyle.setShowCancelButton(!z);
        mediaStyle.setCancelButtonIntent(this.m);
        builder.setStyle(mediaStyle);
        builder.setDeleteIntent(this.m);
        builder.setBadgeIconType(this.C).setOngoing(z).setColor(this.F).setColorized(this.D).setSmallIcon(this.G).setVisibility(this.H).setPriority(this.I).setDefaults(this.E);
        if (com.google.android.exoplayer2.util.Util.SDK_INT < 21 || !this.J || !player.isPlaying() || player.isPlayingAd() || player.isCurrentWindowDynamic() || player.getPlaybackParameters().speed != 1.0f) {
            builder.setShowWhen(false).setUsesChronometer(false);
        } else {
            builder.setWhen(java.lang.System.currentTimeMillis() - player.getContentPosition()).setShowWhen(true).setUsesChronometer(true);
        }
        builder.setContentTitle(this.d.getCurrentContentTitle(player));
        builder.setContentText(this.d.getCurrentContentText(player));
        builder.setSubText(this.d.getCurrentSubText(player));
        if (bitmap == null) {
            com.google.android.exoplayer2.ui.PlayerNotificationManager.MediaDescriptionAdapter mediaDescriptionAdapter = this.d;
            int i3 = this.v + 1;
            this.v = i3;
            bitmap = mediaDescriptionAdapter.getCurrentLargeIcon(player, new com.google.android.exoplayer2.ui.PlayerNotificationManager.BitmapCallback(this, i3, null));
        }
        r(builder, bitmap);
        builder.setContentIntent(this.d.createCurrentContentIntent(player));
        return builder;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int[] getActionIndicesForCompactView(java.util.List<java.lang.String> list, com.google.android.exoplayer2.Player player) {
        int i;
        int indexOf = list.indexOf(ACTION_PAUSE);
        int indexOf2 = list.indexOf(ACTION_PLAY);
        int indexOf3 = this.z ? list.indexOf(ACTION_PREVIOUS) : -1;
        int indexOf4 = this.z ? list.indexOf(ACTION_NEXT) : -1;
        int[] iArr = new int[3];
        int i2 = 0;
        if (indexOf3 != -1) {
            iArr[0] = indexOf3;
            i2 = 1;
        }
        boolean s2 = s(player);
        if (indexOf == -1 || !s2) {
            if (indexOf2 != -1 && !s2) {
                i = i2 + 1;
                iArr[i2] = indexOf2;
            }
            if (indexOf4 != -1) {
                iArr[i2] = indexOf4;
                i2++;
            }
            return java.util.Arrays.copyOf(iArr, i2);
        }
        i = i2 + 1;
        iArr[i2] = indexOf;
        i2 = i;
        if (indexOf4 != -1) {
        }
        return java.util.Arrays.copyOf(iArr, i2);
    }

    public java.util.List<java.lang.String> getActions(com.google.android.exoplayer2.Player player) {
        boolean z;
        boolean z2;
        boolean z3;
        com.google.android.exoplayer2.Timeline currentTimeline = player.getCurrentTimeline();
        if (currentTimeline.isEmpty() || player.isPlayingAd()) {
            z = false;
            z2 = false;
            z3 = false;
        } else {
            currentTimeline.getWindow(player.getCurrentWindowIndex(), this.o);
            com.google.android.exoplayer2.Timeline.Window window = this.o;
            boolean z4 = window.isSeekable || !window.isDynamic || player.hasPrevious();
            z2 = this.t.isRewindEnabled();
            z3 = this.t.isFastForwardEnabled();
            r2 = z4;
            z = this.o.isDynamic || player.hasNext();
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (this.y && r2) {
            arrayList.add(ACTION_PREVIOUS);
        }
        if (z2) {
            arrayList.add(ACTION_REWIND);
        }
        if (this.A) {
            if (s(player)) {
                arrayList.add(ACTION_PAUSE);
            } else {
                arrayList.add(ACTION_PLAY);
            }
        }
        if (z3) {
            arrayList.add(ACTION_FAST_FORWARD);
        }
        if (this.y && z) {
            arrayList.add(ACTION_NEXT);
        }
        com.google.android.exoplayer2.ui.PlayerNotificationManager.CustomActionReceiver customActionReceiver = this.e;
        if (customActionReceiver != null) {
            arrayList.addAll(customActionReceiver.getCustomActions(player));
        }
        if (this.B) {
            arrayList.add(ACTION_STOP);
        }
        return arrayList;
    }

    public boolean getOngoing(com.google.android.exoplayer2.Player player) {
        int playbackState = player.getPlaybackState();
        return (playbackState == 2 || playbackState == 3) && player.getPlayWhenReady();
    }

    public void invalidate() {
        if (this.u) {
            p();
        }
    }

    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public final boolean o(android.os.Message message) {
        int i = message.what;
        if (i == 0) {
            com.google.android.exoplayer2.Player player = this.r;
            if (player != null) {
                t(player, null);
            }
        } else {
            if (i != 1) {
                return false;
            }
            com.google.android.exoplayer2.Player player2 = this.r;
            if (player2 != null && this.u && this.v == message.arg1) {
                t(player2, (android.graphics.Bitmap) message.obj);
            }
        }
        return true;
    }

    public final void p() {
        if (this.f.hasMessages(0)) {
            return;
        }
        this.f.sendEmptyMessage(0);
    }

    public final void q(android.graphics.Bitmap bitmap, int i) {
        this.f.obtainMessage(1, i, -1, bitmap).sendToTarget();
    }

    public final boolean s(com.google.android.exoplayer2.Player player) {
        return (player.getPlaybackState() == 4 || player.getPlaybackState() == 1 || !player.getPlayWhenReady()) ? false : true;
    }

    public final void setBadgeIconType(int i) {
        if (this.C == i) {
            return;
        }
        if (i != 0 && i != 1 && i != 2) {
            throw new java.lang.IllegalArgumentException();
        }
        this.C = i;
        invalidate();
    }

    public final void setColor(int i) {
        if (this.F != i) {
            this.F = i;
            invalidate();
        }
    }

    public final void setColorized(boolean z) {
        if (this.D != z) {
            this.D = z;
            invalidate();
        }
    }

    public final void setControlDispatcher(com.google.android.exoplayer2.ControlDispatcher controlDispatcher) {
        if (this.t != controlDispatcher) {
            this.t = controlDispatcher;
            invalidate();
        }
    }

    public final void setDefaults(int i) {
        if (this.E != i) {
            this.E = i;
            invalidate();
        }
    }

    @java.lang.Deprecated
    public final void setFastForwardIncrementMs(long j) {
        com.google.android.exoplayer2.ControlDispatcher controlDispatcher = this.t;
        if (controlDispatcher instanceof com.google.android.exoplayer2.DefaultControlDispatcher) {
            ((com.google.android.exoplayer2.DefaultControlDispatcher) controlDispatcher).setFastForwardIncrementMs(j);
            invalidate();
        }
    }

    public final void setMediaSessionToken(android.support.v4.media.session.MediaSessionCompat.Token token) {
        if (com.google.android.exoplayer2.util.Util.areEqual(this.x, token)) {
            return;
        }
        this.x = token;
        invalidate();
    }

    @java.lang.Deprecated
    public final void setNotificationListener(com.google.android.exoplayer2.ui.PlayerNotificationManager.NotificationListener notificationListener) {
        this.w = notificationListener;
    }

    public void setPlaybackPreparer(@androidx.annotation.Nullable com.google.android.exoplayer2.PlaybackPreparer playbackPreparer) {
        this.f365s = playbackPreparer;
    }

    public final void setPlayer(@androidx.annotation.Nullable com.google.android.exoplayer2.Player player) {
        boolean z = true;
        com.google.android.exoplayer2.util.Assertions.checkState(android.os.Looper.myLooper() == android.os.Looper.getMainLooper());
        if (player != null && player.getApplicationLooper() != android.os.Looper.getMainLooper()) {
            z = false;
        }
        com.google.android.exoplayer2.util.Assertions.checkArgument(z);
        com.google.android.exoplayer2.Player player2 = this.r;
        if (player2 == player) {
            return;
        }
        if (player2 != null) {
            player2.removeListener(this.i);
            if (player == null) {
                u(false);
            }
        }
        this.r = player;
        if (player != null) {
            player.addListener(this.i);
            p();
        }
    }

    public final void setPriority(int i) {
        if (this.I == i) {
            return;
        }
        if (i != -2 && i != -1 && i != 0 && i != 1 && i != 2) {
            throw new java.lang.IllegalArgumentException();
        }
        this.I = i;
        invalidate();
    }

    @java.lang.Deprecated
    public final void setRewindIncrementMs(long j) {
        com.google.android.exoplayer2.ControlDispatcher controlDispatcher = this.t;
        if (controlDispatcher instanceof com.google.android.exoplayer2.DefaultControlDispatcher) {
            ((com.google.android.exoplayer2.DefaultControlDispatcher) controlDispatcher).setRewindIncrementMs(j);
            invalidate();
        }
    }

    public final void setSmallIcon(@androidx.annotation.DrawableRes int i) {
        if (this.G != i) {
            this.G = i;
            invalidate();
        }
    }

    public final void setUseChronometer(boolean z) {
        if (this.J != z) {
            this.J = z;
            invalidate();
        }
    }

    public final void setUseNavigationActions(boolean z) {
        if (this.y != z) {
            this.y = z;
            invalidate();
        }
    }

    public final void setUseNavigationActionsInCompactView(boolean z) {
        if (this.z != z) {
            this.z = z;
            invalidate();
        }
    }

    public final void setUsePlayPauseActions(boolean z) {
        if (this.A != z) {
            this.A = z;
            invalidate();
        }
    }

    public final void setUseStopAction(boolean z) {
        if (this.B == z) {
            return;
        }
        this.B = z;
        invalidate();
    }

    public final void setVisibility(int i) {
        if (this.H == i) {
            return;
        }
        if (i != -1 && i != 0 && i != 1) {
            throw new java.lang.IllegalStateException();
        }
        this.H = i;
        invalidate();
    }

    public final void t(com.google.android.exoplayer2.Player player, @androidx.annotation.Nullable android.graphics.Bitmap bitmap) {
        boolean ongoing = getOngoing(player);
        androidx.core.app.NotificationCompat.Builder createNotification = createNotification(player, this.p, ongoing, bitmap);
        this.p = createNotification;
        if (createNotification == null) {
            u(false);
            return;
        }
        android.app.Notification build = createNotification.build();
        this.g.notify(this.c, build);
        if (!this.u) {
            this.a.registerReceiver(this.j, this.h);
            com.google.android.exoplayer2.ui.PlayerNotificationManager.NotificationListener notificationListener = this.w;
            if (notificationListener != null) {
                notificationListener.onNotificationStarted(this.c, build);
            }
        }
        com.google.android.exoplayer2.ui.PlayerNotificationManager.NotificationListener notificationListener2 = this.w;
        if (notificationListener2 != null) {
            notificationListener2.onNotificationPosted(this.c, build, ongoing || !this.u);
        }
        this.u = true;
    }

    public final void u(boolean z) {
        if (this.u) {
            this.u = false;
            this.f.removeMessages(0);
            this.g.cancel(this.c);
            this.a.unregisterReceiver(this.j);
            com.google.android.exoplayer2.ui.PlayerNotificationManager.NotificationListener notificationListener = this.w;
            if (notificationListener != null) {
                notificationListener.onNotificationCancelled(this.c, z);
                this.w.onNotificationCancelled(this.c);
            }
        }
    }
}
