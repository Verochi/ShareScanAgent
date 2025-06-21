package android.support.v4.media.session;

/* loaded from: classes.dex */
public class MediaSessionCompat {

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public static final java.lang.String ACTION_ARGUMENT_CAPTIONING_ENABLED = "android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED";

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public static final java.lang.String ACTION_ARGUMENT_EXTRAS = "android.support.v4.media.session.action.ARGUMENT_EXTRAS";

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public static final java.lang.String ACTION_ARGUMENT_MEDIA_ID = "android.support.v4.media.session.action.ARGUMENT_MEDIA_ID";

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public static final java.lang.String ACTION_ARGUMENT_QUERY = "android.support.v4.media.session.action.ARGUMENT_QUERY";

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public static final java.lang.String ACTION_ARGUMENT_RATING = "android.support.v4.media.session.action.ARGUMENT_RATING";

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public static final java.lang.String ACTION_ARGUMENT_REPEAT_MODE = "android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE";

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public static final java.lang.String ACTION_ARGUMENT_SHUFFLE_MODE = "android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE";

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public static final java.lang.String ACTION_ARGUMENT_URI = "android.support.v4.media.session.action.ARGUMENT_URI";
    public static final java.lang.String ACTION_FLAG_AS_INAPPROPRIATE = "android.support.v4.media.session.action.FLAG_AS_INAPPROPRIATE";
    public static final java.lang.String ACTION_FOLLOW = "android.support.v4.media.session.action.FOLLOW";

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public static final java.lang.String ACTION_PLAY_FROM_URI = "android.support.v4.media.session.action.PLAY_FROM_URI";

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public static final java.lang.String ACTION_PREPARE = "android.support.v4.media.session.action.PREPARE";

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public static final java.lang.String ACTION_PREPARE_FROM_MEDIA_ID = "android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID";

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public static final java.lang.String ACTION_PREPARE_FROM_SEARCH = "android.support.v4.media.session.action.PREPARE_FROM_SEARCH";

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public static final java.lang.String ACTION_PREPARE_FROM_URI = "android.support.v4.media.session.action.PREPARE_FROM_URI";

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public static final java.lang.String ACTION_SET_CAPTIONING_ENABLED = "android.support.v4.media.session.action.SET_CAPTIONING_ENABLED";

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public static final java.lang.String ACTION_SET_RATING = "android.support.v4.media.session.action.SET_RATING";

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public static final java.lang.String ACTION_SET_REPEAT_MODE = "android.support.v4.media.session.action.SET_REPEAT_MODE";

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public static final java.lang.String ACTION_SET_SHUFFLE_MODE = "android.support.v4.media.session.action.SET_SHUFFLE_MODE";
    public static final java.lang.String ACTION_SKIP_AD = "android.support.v4.media.session.action.SKIP_AD";
    public static final java.lang.String ACTION_UNFOLLOW = "android.support.v4.media.session.action.UNFOLLOW";
    public static final java.lang.String ARGUMENT_MEDIA_ATTRIBUTE = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE";
    public static final java.lang.String ARGUMENT_MEDIA_ATTRIBUTE_VALUE = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE_VALUE";
    private static final java.lang.String DATA_CALLING_PACKAGE = "data_calling_pkg";
    private static final java.lang.String DATA_CALLING_PID = "data_calling_pid";
    private static final java.lang.String DATA_CALLING_UID = "data_calling_uid";
    private static final java.lang.String DATA_EXTRAS = "data_extras";
    public static final int FLAG_HANDLES_MEDIA_BUTTONS = 1;
    public static final int FLAG_HANDLES_QUEUE_COMMANDS = 4;
    public static final int FLAG_HANDLES_TRANSPORT_CONTROLS = 2;

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public static final java.lang.String KEY_EXTRA_BINDER = "android.support.v4.media.session.EXTRA_BINDER";

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public static final java.lang.String KEY_SESSION_TOKEN2_BUNDLE = "android.support.v4.media.session.SESSION_TOKEN2_BUNDLE";

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public static final java.lang.String KEY_TOKEN = "android.support.v4.media.session.TOKEN";
    private static final int MAX_BITMAP_SIZE_IN_DP = 320;
    public static final int MEDIA_ATTRIBUTE_ALBUM = 1;
    public static final int MEDIA_ATTRIBUTE_ARTIST = 0;
    public static final int MEDIA_ATTRIBUTE_PLAYLIST = 2;
    static final java.lang.String TAG = "MediaSessionCompat";
    static int sMaxBitmapSize;
    private final java.util.ArrayList<android.support.v4.media.session.MediaSessionCompat.OnActiveChangeListener> mActiveListeners;
    private final android.support.v4.media.session.MediaControllerCompat mController;
    private final android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl mImpl;

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$1, reason: invalid class name */
    public class AnonymousClass1 extends android.support.v4.media.session.MediaSessionCompat.Callback {
        public AnonymousClass1() {
        }
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$2, reason: invalid class name */
    public class AnonymousClass2 extends android.support.v4.media.session.MediaSessionCompat.Callback {
        public AnonymousClass2() {
        }
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$3, reason: invalid class name */
    public class AnonymousClass3 extends android.support.v4.media.session.MediaSessionCompat.Callback {
        public AnonymousClass3() {
        }
    }

    public static abstract class Callback {
        private android.support.v4.media.session.MediaSessionCompat.Callback.CallbackHandler mCallbackHandler = null;
        final java.lang.Object mCallbackObj;
        private boolean mMediaPlayPauseKeyPending;
        java.lang.ref.WeakReference<android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl> mSessionImpl;

        public class CallbackHandler extends android.os.Handler {
            private static final int MSG_MEDIA_PLAY_PAUSE_KEY_DOUBLE_TAP_TIMEOUT = 1;

            public CallbackHandler(android.os.Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                if (message.what == 1) {
                    android.support.v4.media.session.MediaSessionCompat.Callback.this.handleMediaPlayPauseKeySingleTapIfPending((androidx.media.MediaSessionManager.RemoteUserInfo) message.obj);
                }
            }
        }

        @androidx.annotation.RequiresApi(21)
        public class StubApi21 implements android.support.v4.media.session.MediaSessionCompatApi21.Callback {
            public StubApi21() {
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onCommand(java.lang.String str, android.os.Bundle bundle, android.os.ResultReceiver resultReceiver) {
                try {
                    android.support.v4.media.session.MediaSessionCompat.QueueItem queueItem = null;
                    android.os.IBinder asBinder = null;
                    queueItem = null;
                    if (str.equals(android.support.v4.media.session.MediaControllerCompat.COMMAND_GET_EXTRA_BINDER)) {
                        android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = (android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21) android.support.v4.media.session.MediaSessionCompat.Callback.this.mSessionImpl.get();
                        if (mediaSessionImplApi21 != null) {
                            android.os.Bundle bundle2 = new android.os.Bundle();
                            android.support.v4.media.session.MediaSessionCompat.Token sessionToken = mediaSessionImplApi21.getSessionToken();
                            android.support.v4.media.session.IMediaSession extraBinder = sessionToken.getExtraBinder();
                            if (extraBinder != null) {
                                asBinder = extraBinder.asBinder();
                            }
                            androidx.core.app.BundleCompat.putBinder(bundle2, android.support.v4.media.session.MediaSessionCompat.KEY_EXTRA_BINDER, asBinder);
                            bundle2.putBundle(android.support.v4.media.session.MediaSessionCompat.KEY_SESSION_TOKEN2_BUNDLE, sessionToken.getSessionToken2Bundle());
                            resultReceiver.send(0, bundle2);
                            return;
                        }
                        return;
                    }
                    if (str.equals(android.support.v4.media.session.MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM)) {
                        android.support.v4.media.session.MediaSessionCompat.Callback.this.onAddQueueItem((android.support.v4.media.MediaDescriptionCompat) bundle.getParcelable(android.support.v4.media.session.MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION));
                        return;
                    }
                    if (str.equals(android.support.v4.media.session.MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM_AT)) {
                        android.support.v4.media.session.MediaSessionCompat.Callback.this.onAddQueueItem((android.support.v4.media.MediaDescriptionCompat) bundle.getParcelable(android.support.v4.media.session.MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION), bundle.getInt(android.support.v4.media.session.MediaControllerCompat.COMMAND_ARGUMENT_INDEX));
                        return;
                    }
                    if (str.equals(android.support.v4.media.session.MediaControllerCompat.COMMAND_REMOVE_QUEUE_ITEM)) {
                        android.support.v4.media.session.MediaSessionCompat.Callback.this.onRemoveQueueItem((android.support.v4.media.MediaDescriptionCompat) bundle.getParcelable(android.support.v4.media.session.MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION));
                        return;
                    }
                    if (!str.equals(android.support.v4.media.session.MediaControllerCompat.COMMAND_REMOVE_QUEUE_ITEM_AT)) {
                        android.support.v4.media.session.MediaSessionCompat.Callback.this.onCommand(str, bundle, resultReceiver);
                        return;
                    }
                    android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi212 = (android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21) android.support.v4.media.session.MediaSessionCompat.Callback.this.mSessionImpl.get();
                    if (mediaSessionImplApi212 == null || mediaSessionImplApi212.mQueue == null) {
                        return;
                    }
                    int i = bundle.getInt(android.support.v4.media.session.MediaControllerCompat.COMMAND_ARGUMENT_INDEX, -1);
                    if (i >= 0 && i < mediaSessionImplApi212.mQueue.size()) {
                        queueItem = mediaSessionImplApi212.mQueue.get(i);
                    }
                    if (queueItem != null) {
                        android.support.v4.media.session.MediaSessionCompat.Callback.this.onRemoveQueueItem(queueItem.getDescription());
                    }
                } catch (android.os.BadParcelableException unused) {
                }
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onCustomAction(java.lang.String str, android.os.Bundle bundle) {
                android.os.Bundle bundle2 = bundle.getBundle(android.support.v4.media.session.MediaSessionCompat.ACTION_ARGUMENT_EXTRAS);
                android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(bundle2);
                if (str.equals(android.support.v4.media.session.MediaSessionCompat.ACTION_PLAY_FROM_URI)) {
                    android.support.v4.media.session.MediaSessionCompat.Callback.this.onPlayFromUri((android.net.Uri) bundle.getParcelable(android.support.v4.media.session.MediaSessionCompat.ACTION_ARGUMENT_URI), bundle2);
                    return;
                }
                if (str.equals(android.support.v4.media.session.MediaSessionCompat.ACTION_PREPARE)) {
                    android.support.v4.media.session.MediaSessionCompat.Callback.this.onPrepare();
                    return;
                }
                if (str.equals(android.support.v4.media.session.MediaSessionCompat.ACTION_PREPARE_FROM_MEDIA_ID)) {
                    android.support.v4.media.session.MediaSessionCompat.Callback.this.onPrepareFromMediaId(bundle.getString(android.support.v4.media.session.MediaSessionCompat.ACTION_ARGUMENT_MEDIA_ID), bundle2);
                    return;
                }
                if (str.equals(android.support.v4.media.session.MediaSessionCompat.ACTION_PREPARE_FROM_SEARCH)) {
                    android.support.v4.media.session.MediaSessionCompat.Callback.this.onPrepareFromSearch(bundle.getString(android.support.v4.media.session.MediaSessionCompat.ACTION_ARGUMENT_QUERY), bundle2);
                    return;
                }
                if (str.equals(android.support.v4.media.session.MediaSessionCompat.ACTION_PREPARE_FROM_URI)) {
                    android.support.v4.media.session.MediaSessionCompat.Callback.this.onPrepareFromUri((android.net.Uri) bundle.getParcelable(android.support.v4.media.session.MediaSessionCompat.ACTION_ARGUMENT_URI), bundle2);
                    return;
                }
                if (str.equals(android.support.v4.media.session.MediaSessionCompat.ACTION_SET_CAPTIONING_ENABLED)) {
                    android.support.v4.media.session.MediaSessionCompat.Callback.this.onSetCaptioningEnabled(bundle.getBoolean(android.support.v4.media.session.MediaSessionCompat.ACTION_ARGUMENT_CAPTIONING_ENABLED));
                    return;
                }
                if (str.equals(android.support.v4.media.session.MediaSessionCompat.ACTION_SET_REPEAT_MODE)) {
                    android.support.v4.media.session.MediaSessionCompat.Callback.this.onSetRepeatMode(bundle.getInt(android.support.v4.media.session.MediaSessionCompat.ACTION_ARGUMENT_REPEAT_MODE));
                } else if (str.equals(android.support.v4.media.session.MediaSessionCompat.ACTION_SET_SHUFFLE_MODE)) {
                    android.support.v4.media.session.MediaSessionCompat.Callback.this.onSetShuffleMode(bundle.getInt(android.support.v4.media.session.MediaSessionCompat.ACTION_ARGUMENT_SHUFFLE_MODE));
                } else if (!str.equals(android.support.v4.media.session.MediaSessionCompat.ACTION_SET_RATING)) {
                    android.support.v4.media.session.MediaSessionCompat.Callback.this.onCustomAction(str, bundle);
                } else {
                    android.support.v4.media.session.MediaSessionCompat.Callback.this.onSetRating((android.support.v4.media.RatingCompat) bundle.getParcelable(android.support.v4.media.session.MediaSessionCompat.ACTION_ARGUMENT_RATING), bundle2);
                }
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onFastForward() {
                android.support.v4.media.session.MediaSessionCompat.Callback.this.onFastForward();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public boolean onMediaButtonEvent(android.content.Intent intent) {
                return android.support.v4.media.session.MediaSessionCompat.Callback.this.onMediaButtonEvent(intent);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onPause() {
                android.support.v4.media.session.MediaSessionCompat.Callback.this.onPause();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onPlay() {
                android.support.v4.media.session.MediaSessionCompat.Callback.this.onPlay();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onPlayFromMediaId(java.lang.String str, android.os.Bundle bundle) {
                android.support.v4.media.session.MediaSessionCompat.Callback.this.onPlayFromMediaId(str, bundle);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onPlayFromSearch(java.lang.String str, android.os.Bundle bundle) {
                android.support.v4.media.session.MediaSessionCompat.Callback.this.onPlayFromSearch(str, bundle);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onRewind() {
                android.support.v4.media.session.MediaSessionCompat.Callback.this.onRewind();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onSeekTo(long j) {
                android.support.v4.media.session.MediaSessionCompat.Callback.this.onSeekTo(j);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onSetRating(java.lang.Object obj) {
                android.support.v4.media.session.MediaSessionCompat.Callback.this.onSetRating(android.support.v4.media.RatingCompat.fromRating(obj));
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onSetRating(java.lang.Object obj, android.os.Bundle bundle) {
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onSkipToNext() {
                android.support.v4.media.session.MediaSessionCompat.Callback.this.onSkipToNext();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onSkipToPrevious() {
                android.support.v4.media.session.MediaSessionCompat.Callback.this.onSkipToPrevious();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onSkipToQueueItem(long j) {
                android.support.v4.media.session.MediaSessionCompat.Callback.this.onSkipToQueueItem(j);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onStop() {
                android.support.v4.media.session.MediaSessionCompat.Callback.this.onStop();
            }
        }

        @androidx.annotation.RequiresApi(23)
        public class StubApi23 extends android.support.v4.media.session.MediaSessionCompat.Callback.StubApi21 implements android.support.v4.media.session.MediaSessionCompatApi23.Callback {
            public StubApi23() {
                super();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi23.Callback
            public void onPlayFromUri(android.net.Uri uri, android.os.Bundle bundle) {
                android.support.v4.media.session.MediaSessionCompat.Callback.this.onPlayFromUri(uri, bundle);
            }
        }

        @androidx.annotation.RequiresApi(24)
        public class StubApi24 extends android.support.v4.media.session.MediaSessionCompat.Callback.StubApi23 implements android.support.v4.media.session.MediaSessionCompatApi24.Callback {
            public StubApi24() {
                super();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void onPrepare() {
                android.support.v4.media.session.MediaSessionCompat.Callback.this.onPrepare();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void onPrepareFromMediaId(java.lang.String str, android.os.Bundle bundle) {
                android.support.v4.media.session.MediaSessionCompat.Callback.this.onPrepareFromMediaId(str, bundle);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void onPrepareFromSearch(java.lang.String str, android.os.Bundle bundle) {
                android.support.v4.media.session.MediaSessionCompat.Callback.this.onPrepareFromSearch(str, bundle);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void onPrepareFromUri(android.net.Uri uri, android.os.Bundle bundle) {
                android.support.v4.media.session.MediaSessionCompat.Callback.this.onPrepareFromUri(uri, bundle);
            }
        }

        public Callback() {
            int i = android.os.Build.VERSION.SDK_INT;
            if (i >= 24) {
                this.mCallbackObj = android.support.v4.media.session.MediaSessionCompatApi24.createCallback(new android.support.v4.media.session.MediaSessionCompat.Callback.StubApi24());
            } else if (i >= 23) {
                this.mCallbackObj = android.support.v4.media.session.MediaSessionCompatApi23.createCallback(new android.support.v4.media.session.MediaSessionCompat.Callback.StubApi23());
            } else {
                this.mCallbackObj = android.support.v4.media.session.MediaSessionCompatApi21.createCallback(new android.support.v4.media.session.MediaSessionCompat.Callback.StubApi21());
            }
        }

        public void handleMediaPlayPauseKeySingleTapIfPending(androidx.media.MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            if (this.mMediaPlayPauseKeyPending) {
                this.mMediaPlayPauseKeyPending = false;
                this.mCallbackHandler.removeMessages(1);
                android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl mediaSessionImpl = this.mSessionImpl.get();
                if (mediaSessionImpl == null) {
                    return;
                }
                android.support.v4.media.session.PlaybackStateCompat playbackState = mediaSessionImpl.getPlaybackState();
                long actions = playbackState == null ? 0L : playbackState.getActions();
                boolean z = playbackState != null && playbackState.getState() == 3;
                boolean z2 = (516 & actions) != 0;
                boolean z3 = (actions & 514) != 0;
                mediaSessionImpl.setCurrentControllerInfo(remoteUserInfo);
                if (z && z3) {
                    onPause();
                } else if (!z && z2) {
                    onPlay();
                }
                mediaSessionImpl.setCurrentControllerInfo(null);
            }
        }

        public void onAddQueueItem(android.support.v4.media.MediaDescriptionCompat mediaDescriptionCompat) {
        }

        public void onAddQueueItem(android.support.v4.media.MediaDescriptionCompat mediaDescriptionCompat, int i) {
        }

        public void onCommand(java.lang.String str, android.os.Bundle bundle, android.os.ResultReceiver resultReceiver) {
        }

        public void onCustomAction(java.lang.String str, android.os.Bundle bundle) {
        }

        public void onFastForward() {
        }

        public boolean onMediaButtonEvent(android.content.Intent intent) {
            android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl mediaSessionImpl;
            android.view.KeyEvent keyEvent;
            if (android.os.Build.VERSION.SDK_INT >= 27 || (mediaSessionImpl = this.mSessionImpl.get()) == null || this.mCallbackHandler == null || (keyEvent = (android.view.KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) == null || keyEvent.getAction() != 0) {
                return false;
            }
            androidx.media.MediaSessionManager.RemoteUserInfo currentControllerInfo = mediaSessionImpl.getCurrentControllerInfo();
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 79 && keyCode != 85) {
                handleMediaPlayPauseKeySingleTapIfPending(currentControllerInfo);
                return false;
            }
            if (keyEvent.getRepeatCount() > 0) {
                handleMediaPlayPauseKeySingleTapIfPending(currentControllerInfo);
            } else if (this.mMediaPlayPauseKeyPending) {
                this.mCallbackHandler.removeMessages(1);
                this.mMediaPlayPauseKeyPending = false;
                android.support.v4.media.session.PlaybackStateCompat playbackState = mediaSessionImpl.getPlaybackState();
                if (((playbackState == null ? 0L : playbackState.getActions()) & 32) != 0) {
                    onSkipToNext();
                }
            } else {
                this.mMediaPlayPauseKeyPending = true;
                android.support.v4.media.session.MediaSessionCompat.Callback.CallbackHandler callbackHandler = this.mCallbackHandler;
                callbackHandler.sendMessageDelayed(callbackHandler.obtainMessage(1, currentControllerInfo), android.view.ViewConfiguration.getDoubleTapTimeout());
            }
            return true;
        }

        public void onPause() {
        }

        public void onPlay() {
        }

        public void onPlayFromMediaId(java.lang.String str, android.os.Bundle bundle) {
        }

        public void onPlayFromSearch(java.lang.String str, android.os.Bundle bundle) {
        }

        public void onPlayFromUri(android.net.Uri uri, android.os.Bundle bundle) {
        }

        public void onPrepare() {
        }

        public void onPrepareFromMediaId(java.lang.String str, android.os.Bundle bundle) {
        }

        public void onPrepareFromSearch(java.lang.String str, android.os.Bundle bundle) {
        }

        public void onPrepareFromUri(android.net.Uri uri, android.os.Bundle bundle) {
        }

        public void onRemoveQueueItem(android.support.v4.media.MediaDescriptionCompat mediaDescriptionCompat) {
        }

        @java.lang.Deprecated
        public void onRemoveQueueItemAt(int i) {
        }

        public void onRewind() {
        }

        public void onSeekTo(long j) {
        }

        public void onSetCaptioningEnabled(boolean z) {
        }

        public void onSetRating(android.support.v4.media.RatingCompat ratingCompat) {
        }

        public void onSetRating(android.support.v4.media.RatingCompat ratingCompat, android.os.Bundle bundle) {
        }

        public void onSetRepeatMode(int i) {
        }

        public void onSetShuffleMode(int i) {
        }

        public void onSkipToNext() {
        }

        public void onSkipToPrevious() {
        }

        public void onSkipToQueueItem(long j) {
        }

        public void onStop() {
        }

        public void setSessionImpl(android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl mediaSessionImpl, android.os.Handler handler) {
            this.mSessionImpl = new java.lang.ref.WeakReference<>(mediaSessionImpl);
            android.support.v4.media.session.MediaSessionCompat.Callback.CallbackHandler callbackHandler = this.mCallbackHandler;
            if (callbackHandler != null) {
                callbackHandler.removeCallbacksAndMessages(null);
            }
            this.mCallbackHandler = new android.support.v4.media.session.MediaSessionCompat.Callback.CallbackHandler(handler.getLooper());
        }
    }

    public interface MediaSessionImpl {
        java.lang.String getCallingPackage();

        androidx.media.MediaSessionManager.RemoteUserInfo getCurrentControllerInfo();

        java.lang.Object getMediaSession();

        android.support.v4.media.session.PlaybackStateCompat getPlaybackState();

        java.lang.Object getRemoteControlClient();

        android.support.v4.media.session.MediaSessionCompat.Token getSessionToken();

        boolean isActive();

        void release();

        void sendSessionEvent(java.lang.String str, android.os.Bundle bundle);

        void setActive(boolean z);

        void setCallback(android.support.v4.media.session.MediaSessionCompat.Callback callback, android.os.Handler handler);

        void setCaptioningEnabled(boolean z);

        void setCurrentControllerInfo(androidx.media.MediaSessionManager.RemoteUserInfo remoteUserInfo);

        void setExtras(android.os.Bundle bundle);

        void setFlags(int i);

        void setMediaButtonReceiver(android.app.PendingIntent pendingIntent);

        void setMetadata(android.support.v4.media.MediaMetadataCompat mediaMetadataCompat);

        void setPlaybackState(android.support.v4.media.session.PlaybackStateCompat playbackStateCompat);

        void setPlaybackToLocal(int i);

        void setPlaybackToRemote(androidx.media.VolumeProviderCompat volumeProviderCompat);

        void setQueue(java.util.List<android.support.v4.media.session.MediaSessionCompat.QueueItem> list);

        void setQueueTitle(java.lang.CharSequence charSequence);

        void setRatingType(int i);

        void setRepeatMode(int i);

        void setSessionActivity(android.app.PendingIntent pendingIntent);

        void setShuffleMode(int i);
    }

    @androidx.annotation.RequiresApi(18)
    public static class MediaSessionImplApi18 extends android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase {
        private static boolean sIsMbrPendingIntentSupported = true;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi18$1, reason: invalid class name */
        public class AnonymousClass1 implements android.media.RemoteControlClient.OnPlaybackPositionUpdateListener {
            public AnonymousClass1() {
            }

            @Override // android.media.RemoteControlClient.OnPlaybackPositionUpdateListener
            public void onPlaybackPositionUpdate(long j) {
                android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi18.this.postToHandler(18, -1, -1, java.lang.Long.valueOf(j), null);
            }
        }

        public MediaSessionImplApi18(android.content.Context context, java.lang.String str, android.content.ComponentName componentName, android.app.PendingIntent pendingIntent) {
            super(context, str, componentName, pendingIntent);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        public int getRccTransportControlFlagsFromActions(long j) {
            int rccTransportControlFlagsFromActions = super.getRccTransportControlFlagsFromActions(j);
            return (j & 256) != 0 ? rccTransportControlFlagsFromActions | 256 : rccTransportControlFlagsFromActions;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        public void registerMediaButtonEventReceiver(android.app.PendingIntent pendingIntent, android.content.ComponentName componentName) {
            if (sIsMbrPendingIntentSupported) {
                try {
                    this.mAudioManager.registerMediaButtonEventReceiver(pendingIntent);
                } catch (java.lang.NullPointerException unused) {
                    sIsMbrPendingIntentSupported = false;
                }
            }
            if (sIsMbrPendingIntentSupported) {
                return;
            }
            super.registerMediaButtonEventReceiver(pendingIntent, componentName);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase, android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCallback(android.support.v4.media.session.MediaSessionCompat.Callback callback, android.os.Handler handler) {
            super.setCallback(callback, handler);
            if (callback == null) {
                this.mRcc.setPlaybackPositionUpdateListener(null);
            } else {
                this.mRcc.setPlaybackPositionUpdateListener(new android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi18.AnonymousClass1());
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        public void setRccState(android.support.v4.media.session.PlaybackStateCompat playbackStateCompat) {
            long position = playbackStateCompat.getPosition();
            float playbackSpeed = playbackStateCompat.getPlaybackSpeed();
            long lastPositionUpdateTime = playbackStateCompat.getLastPositionUpdateTime();
            long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
            if (playbackStateCompat.getState() == 3) {
                long j = 0;
                if (position > 0) {
                    if (lastPositionUpdateTime > 0) {
                        j = elapsedRealtime - lastPositionUpdateTime;
                        if (playbackSpeed > 0.0f && playbackSpeed != 1.0f) {
                            j = (long) (j * playbackSpeed);
                        }
                    }
                    position += j;
                }
            }
            this.mRcc.setPlaybackState(getRccStateFromState(playbackStateCompat.getState()), position, playbackSpeed);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        public void unregisterMediaButtonEventReceiver(android.app.PendingIntent pendingIntent, android.content.ComponentName componentName) {
            if (sIsMbrPendingIntentSupported) {
                this.mAudioManager.unregisterMediaButtonEventReceiver(pendingIntent);
            } else {
                super.unregisterMediaButtonEventReceiver(pendingIntent, componentName);
            }
        }
    }

    @androidx.annotation.RequiresApi(19)
    public static class MediaSessionImplApi19 extends android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi18 {

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$MediaSessionImplApi19$1, reason: invalid class name */
        public class AnonymousClass1 implements android.media.RemoteControlClient.OnMetadataUpdateListener {
            public AnonymousClass1() {
            }

            @Override // android.media.RemoteControlClient.OnMetadataUpdateListener
            public void onMetadataUpdate(int i, java.lang.Object obj) {
                if (i == 268435457 && (obj instanceof android.media.Rating)) {
                    android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi19.this.postToHandler(19, -1, -1, android.support.v4.media.RatingCompat.fromRating(obj), null);
                }
            }
        }

        public MediaSessionImplApi19(android.content.Context context, java.lang.String str, android.content.ComponentName componentName, android.app.PendingIntent pendingIntent) {
            super(context, str, componentName, pendingIntent);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        public android.media.RemoteControlClient.MetadataEditor buildRccMetadata(android.os.Bundle bundle) {
            android.media.RemoteControlClient.MetadataEditor buildRccMetadata = super.buildRccMetadata(bundle);
            android.support.v4.media.session.PlaybackStateCompat playbackStateCompat = this.mState;
            if (((playbackStateCompat == null ? 0L : playbackStateCompat.getActions()) & 128) != 0) {
                buildRccMetadata.addEditableKey(268435457);
            }
            if (bundle == null) {
                return buildRccMetadata;
            }
            if (bundle.containsKey(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_YEAR)) {
                buildRccMetadata.putLong(8, bundle.getLong(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_YEAR));
            }
            if (bundle.containsKey(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_RATING)) {
                buildRccMetadata.putObject(101, (java.lang.Object) bundle.getParcelable(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_RATING));
            }
            if (bundle.containsKey(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_USER_RATING)) {
                buildRccMetadata.putObject(268435457, (java.lang.Object) bundle.getParcelable(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_USER_RATING));
            }
            return buildRccMetadata;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi18, android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        public int getRccTransportControlFlagsFromActions(long j) {
            int rccTransportControlFlagsFromActions = super.getRccTransportControlFlagsFromActions(j);
            return (j & 128) != 0 ? rccTransportControlFlagsFromActions | 512 : rccTransportControlFlagsFromActions;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi18, android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase, android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCallback(android.support.v4.media.session.MediaSessionCompat.Callback callback, android.os.Handler handler) {
            super.setCallback(callback, handler);
            if (callback == null) {
                this.mRcc.setMetadataUpdateListener(null);
            } else {
                this.mRcc.setMetadataUpdateListener(new android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi19.AnonymousClass1());
            }
        }
    }

    @androidx.annotation.RequiresApi(21)
    public static class MediaSessionImplApi21 implements android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl {
        boolean mCaptioningEnabled;
        boolean mDestroyed = false;
        final android.os.RemoteCallbackList<android.support.v4.media.session.IMediaControllerCallback> mExtraControllerCallbacks = new android.os.RemoteCallbackList<>();
        android.support.v4.media.MediaMetadataCompat mMetadata;
        android.support.v4.media.session.PlaybackStateCompat mPlaybackState;
        java.util.List<android.support.v4.media.session.MediaSessionCompat.QueueItem> mQueue;
        int mRatingType;
        int mRepeatMode;
        final java.lang.Object mSessionObj;
        int mShuffleMode;
        final android.support.v4.media.session.MediaSessionCompat.Token mToken;

        public class ExtraSession extends android.support.v4.media.session.IMediaSession.Stub {
            public ExtraSession() {
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItem(android.support.v4.media.MediaDescriptionCompat mediaDescriptionCompat) {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItemAt(android.support.v4.media.MediaDescriptionCompat mediaDescriptionCompat, int i) {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void adjustVolume(int i, int i2, java.lang.String str) {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void fastForward() throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public android.os.Bundle getExtras() {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public long getFlags() {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public android.app.PendingIntent getLaunchPendingIntent() {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public android.support.v4.media.MediaMetadataCompat getMetadata() {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public java.lang.String getPackageName() {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public android.support.v4.media.session.PlaybackStateCompat getPlaybackState() {
                android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21.this;
                return android.support.v4.media.session.MediaSessionCompat.getStateWithUpdatedPosition(mediaSessionImplApi21.mPlaybackState, mediaSessionImplApi21.mMetadata);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public java.util.List<android.support.v4.media.session.MediaSessionCompat.QueueItem> getQueue() {
                return null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public java.lang.CharSequence getQueueTitle() {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRatingType() {
                return android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21.this.mRatingType;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRepeatMode() {
                return android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21.this.mRepeatMode;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getShuffleMode() {
                return android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21.this.mShuffleMode;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public java.lang.String getTag() {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public android.support.v4.media.session.ParcelableVolumeInfo getVolumeAttributes() {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isCaptioningEnabled() {
                return android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21.this.mCaptioningEnabled;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isShuffleModeEnabledRemoved() {
                return false;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isTransportControlEnabled() {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void next() throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void pause() throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void play() throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromMediaId(java.lang.String str, android.os.Bundle bundle) throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromSearch(java.lang.String str, android.os.Bundle bundle) throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromUri(android.net.Uri uri, android.os.Bundle bundle) throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepare() throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromMediaId(java.lang.String str, android.os.Bundle bundle) throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromSearch(java.lang.String str, android.os.Bundle bundle) throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromUri(android.net.Uri uri, android.os.Bundle bundle) throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void previous() throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rate(android.support.v4.media.RatingCompat ratingCompat) throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rateWithExtras(android.support.v4.media.RatingCompat ratingCompat, android.os.Bundle bundle) throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void registerCallbackListener(android.support.v4.media.session.IMediaControllerCallback iMediaControllerCallback) {
                android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21.this;
                if (mediaSessionImplApi21.mDestroyed) {
                    return;
                }
                java.lang.String callingPackage = mediaSessionImplApi21.getCallingPackage();
                if (callingPackage == null) {
                    callingPackage = androidx.media.MediaSessionManager.RemoteUserInfo.LEGACY_CONTROLLER;
                }
                android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21.this.mExtraControllerCallbacks.register(iMediaControllerCallback, new androidx.media.MediaSessionManager.RemoteUserInfo(callingPackage, android.os.Binder.getCallingPid(), android.os.Binder.getCallingUid()));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItem(android.support.v4.media.MediaDescriptionCompat mediaDescriptionCompat) {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItemAt(int i) {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rewind() throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void seekTo(long j) throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCommand(java.lang.String str, android.os.Bundle bundle, android.support.v4.media.session.MediaSessionCompat.ResultReceiverWrapper resultReceiverWrapper) {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCustomAction(java.lang.String str, android.os.Bundle bundle) throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean sendMediaButton(android.view.KeyEvent keyEvent) {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setCaptioningEnabled(boolean z) throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setRepeatMode(int i) throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleMode(int i) throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleModeEnabledRemoved(boolean z) throws android.os.RemoteException {
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setVolumeTo(int i, int i2, java.lang.String str) {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void skipToQueueItem(long j) {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void stop() throws android.os.RemoteException {
                throw new java.lang.AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void unregisterCallbackListener(android.support.v4.media.session.IMediaControllerCallback iMediaControllerCallback) {
                android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21.this.mExtraControllerCallbacks.unregister(iMediaControllerCallback);
            }
        }

        public MediaSessionImplApi21(android.content.Context context, java.lang.String str, android.os.Bundle bundle) {
            java.lang.Object createSession = android.support.v4.media.session.MediaSessionCompatApi21.createSession(context, str);
            this.mSessionObj = createSession;
            this.mToken = new android.support.v4.media.session.MediaSessionCompat.Token(android.support.v4.media.session.MediaSessionCompatApi21.getSessionToken(createSession), new android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21.ExtraSession(), bundle);
        }

        public MediaSessionImplApi21(java.lang.Object obj) {
            java.lang.Object verifySession = android.support.v4.media.session.MediaSessionCompatApi21.verifySession(obj);
            this.mSessionObj = verifySession;
            this.mToken = new android.support.v4.media.session.MediaSessionCompat.Token(android.support.v4.media.session.MediaSessionCompatApi21.getSessionToken(verifySession), new android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21.ExtraSession());
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public java.lang.String getCallingPackage() {
            if (android.os.Build.VERSION.SDK_INT < 24) {
                return null;
            }
            return android.support.v4.media.session.MediaSessionCompatApi24.getCallingPackage(this.mSessionObj);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public androidx.media.MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public java.lang.Object getMediaSession() {
            return this.mSessionObj;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public android.support.v4.media.session.PlaybackStateCompat getPlaybackState() {
            return this.mPlaybackState;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public java.lang.Object getRemoteControlClient() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public android.support.v4.media.session.MediaSessionCompat.Token getSessionToken() {
            return this.mToken;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public boolean isActive() {
            return android.support.v4.media.session.MediaSessionCompatApi21.isActive(this.mSessionObj);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void release() {
            this.mDestroyed = true;
            android.support.v4.media.session.MediaSessionCompatApi21.release(this.mSessionObj);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void sendSessionEvent(java.lang.String str, android.os.Bundle bundle) {
            if (android.os.Build.VERSION.SDK_INT < 23) {
                for (int beginBroadcast = this.mExtraControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.mExtraControllerCallbacks.getBroadcastItem(beginBroadcast).onEvent(str, bundle);
                    } catch (android.os.RemoteException unused) {
                    }
                }
                this.mExtraControllerCallbacks.finishBroadcast();
            }
            android.support.v4.media.session.MediaSessionCompatApi21.sendSessionEvent(this.mSessionObj, str, bundle);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setActive(boolean z) {
            android.support.v4.media.session.MediaSessionCompatApi21.setActive(this.mSessionObj, z);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCallback(android.support.v4.media.session.MediaSessionCompat.Callback callback, android.os.Handler handler) {
            android.support.v4.media.session.MediaSessionCompatApi21.setCallback(this.mSessionObj, callback == null ? null : callback.mCallbackObj, handler);
            if (callback != null) {
                callback.setSessionImpl(this, handler);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCaptioningEnabled(boolean z) {
            if (this.mCaptioningEnabled != z) {
                this.mCaptioningEnabled = z;
                for (int beginBroadcast = this.mExtraControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.mExtraControllerCallbacks.getBroadcastItem(beginBroadcast).onCaptioningEnabledChanged(z);
                    } catch (android.os.RemoteException unused) {
                    }
                }
                this.mExtraControllerCallbacks.finishBroadcast();
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCurrentControllerInfo(androidx.media.MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setExtras(android.os.Bundle bundle) {
            android.support.v4.media.session.MediaSessionCompatApi21.setExtras(this.mSessionObj, bundle);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setFlags(int i) {
            android.support.v4.media.session.MediaSessionCompatApi21.setFlags(this.mSessionObj, i);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setMediaButtonReceiver(android.app.PendingIntent pendingIntent) {
            android.support.v4.media.session.MediaSessionCompatApi21.setMediaButtonReceiver(this.mSessionObj, pendingIntent);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setMetadata(android.support.v4.media.MediaMetadataCompat mediaMetadataCompat) {
            this.mMetadata = mediaMetadataCompat;
            android.support.v4.media.session.MediaSessionCompatApi21.setMetadata(this.mSessionObj, mediaMetadataCompat == null ? null : mediaMetadataCompat.getMediaMetadata());
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackState(android.support.v4.media.session.PlaybackStateCompat playbackStateCompat) {
            this.mPlaybackState = playbackStateCompat;
            for (int beginBroadcast = this.mExtraControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.mExtraControllerCallbacks.getBroadcastItem(beginBroadcast).onPlaybackStateChanged(playbackStateCompat);
                } catch (android.os.RemoteException unused) {
                }
            }
            this.mExtraControllerCallbacks.finishBroadcast();
            android.support.v4.media.session.MediaSessionCompatApi21.setPlaybackState(this.mSessionObj, playbackStateCompat == null ? null : playbackStateCompat.getPlaybackState());
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackToLocal(int i) {
            android.support.v4.media.session.MediaSessionCompatApi21.setPlaybackToLocal(this.mSessionObj, i);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackToRemote(androidx.media.VolumeProviderCompat volumeProviderCompat) {
            android.support.v4.media.session.MediaSessionCompatApi21.setPlaybackToRemote(this.mSessionObj, volumeProviderCompat.getVolumeProvider());
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setQueue(java.util.List<android.support.v4.media.session.MediaSessionCompat.QueueItem> list) {
            java.util.ArrayList arrayList;
            this.mQueue = list;
            if (list != null) {
                arrayList = new java.util.ArrayList();
                java.util.Iterator<android.support.v4.media.session.MediaSessionCompat.QueueItem> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().getQueueItem());
                }
            } else {
                arrayList = null;
            }
            android.support.v4.media.session.MediaSessionCompatApi21.setQueue(this.mSessionObj, arrayList);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setQueueTitle(java.lang.CharSequence charSequence) {
            android.support.v4.media.session.MediaSessionCompatApi21.setQueueTitle(this.mSessionObj, charSequence);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setRatingType(int i) {
            if (android.os.Build.VERSION.SDK_INT < 22) {
                this.mRatingType = i;
            } else {
                android.support.v4.media.session.MediaSessionCompatApi22.setRatingType(this.mSessionObj, i);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setRepeatMode(int i) {
            if (this.mRepeatMode != i) {
                this.mRepeatMode = i;
                for (int beginBroadcast = this.mExtraControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.mExtraControllerCallbacks.getBroadcastItem(beginBroadcast).onRepeatModeChanged(i);
                    } catch (android.os.RemoteException unused) {
                    }
                }
                this.mExtraControllerCallbacks.finishBroadcast();
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setSessionActivity(android.app.PendingIntent pendingIntent) {
            android.support.v4.media.session.MediaSessionCompatApi21.setSessionActivity(this.mSessionObj, pendingIntent);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setShuffleMode(int i) {
            if (this.mShuffleMode != i) {
                this.mShuffleMode = i;
                for (int beginBroadcast = this.mExtraControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.mExtraControllerCallbacks.getBroadcastItem(beginBroadcast).onShuffleModeChanged(i);
                    } catch (android.os.RemoteException unused) {
                    }
                }
                this.mExtraControllerCallbacks.finishBroadcast();
            }
        }
    }

    @androidx.annotation.RequiresApi(28)
    public static class MediaSessionImplApi28 extends android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21 {
        public MediaSessionImplApi28(android.content.Context context, java.lang.String str, android.os.Bundle bundle) {
            super(context, str, bundle);
        }

        public MediaSessionImplApi28(java.lang.Object obj) {
            super(obj);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21, android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        @androidx.annotation.NonNull
        public final androidx.media.MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() {
            android.media.session.MediaSessionManager.RemoteUserInfo currentControllerInfo;
            currentControllerInfo = ((android.media.session.MediaSession) this.mSessionObj).getCurrentControllerInfo();
            return new androidx.media.MediaSessionManager.RemoteUserInfo(currentControllerInfo);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21, android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCurrentControllerInfo(androidx.media.MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        }
    }

    public static class MediaSessionImplBase implements android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl {
        static final int RCC_PLAYSTATE_NONE = 0;
        final android.media.AudioManager mAudioManager;
        volatile android.support.v4.media.session.MediaSessionCompat.Callback mCallback;
        boolean mCaptioningEnabled;
        private final android.content.Context mContext;
        android.os.Bundle mExtras;
        int mFlags;
        private android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.MessageHandler mHandler;
        int mLocalStream;
        private final android.content.ComponentName mMediaButtonReceiverComponentName;
        private final android.app.PendingIntent mMediaButtonReceiverIntent;
        android.support.v4.media.MediaMetadataCompat mMetadata;
        final java.lang.String mPackageName;
        java.util.List<android.support.v4.media.session.MediaSessionCompat.QueueItem> mQueue;
        java.lang.CharSequence mQueueTitle;
        int mRatingType;
        final android.media.RemoteControlClient mRcc;
        private androidx.media.MediaSessionManager.RemoteUserInfo mRemoteUserInfo;
        int mRepeatMode;
        android.app.PendingIntent mSessionActivity;
        int mShuffleMode;
        android.support.v4.media.session.PlaybackStateCompat mState;
        private final android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.MediaSessionStub mStub;
        final java.lang.String mTag;
        private final android.support.v4.media.session.MediaSessionCompat.Token mToken;
        androidx.media.VolumeProviderCompat mVolumeProvider;
        int mVolumeType;
        final java.lang.Object mLock = new java.lang.Object();
        final android.os.RemoteCallbackList<android.support.v4.media.session.IMediaControllerCallback> mControllerCallbacks = new android.os.RemoteCallbackList<>();
        boolean mDestroyed = false;
        boolean mIsActive = false;
        private boolean mIsMbrRegistered = false;
        private boolean mIsRccRegistered = false;
        private androidx.media.VolumeProviderCompat.Callback mVolumeCallback = new android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.AnonymousClass1();

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase$1, reason: invalid class name */
        public class AnonymousClass1 extends androidx.media.VolumeProviderCompat.Callback {
            public AnonymousClass1() {
            }

            @Override // androidx.media.VolumeProviderCompat.Callback
            public void onVolumeChanged(androidx.media.VolumeProviderCompat volumeProviderCompat) {
                if (android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mVolumeProvider != volumeProviderCompat) {
                    return;
                }
                android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase mediaSessionImplBase = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this;
                android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.sendVolumeInfoChanged(new android.support.v4.media.session.ParcelableVolumeInfo(mediaSessionImplBase.mVolumeType, mediaSessionImplBase.mLocalStream, volumeProviderCompat.getVolumeControl(), volumeProviderCompat.getMaxVolume(), volumeProviderCompat.getCurrentVolume()));
            }
        }

        public static final class Command {
            public final java.lang.String command;
            public final android.os.Bundle extras;
            public final android.os.ResultReceiver stub;

            public Command(java.lang.String str, android.os.Bundle bundle, android.os.ResultReceiver resultReceiver) {
                this.command = str;
                this.extras = bundle;
                this.stub = resultReceiver;
            }
        }

        public class MediaSessionStub extends android.support.v4.media.session.IMediaSession.Stub {
            public MediaSessionStub() {
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItem(android.support.v4.media.MediaDescriptionCompat mediaDescriptionCompat) {
                postToHandler(25, mediaDescriptionCompat);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItemAt(android.support.v4.media.MediaDescriptionCompat mediaDescriptionCompat, int i) {
                postToHandler(26, mediaDescriptionCompat, i);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void adjustVolume(int i, int i2, java.lang.String str) {
                android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.adjustVolume(i, i2);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void fastForward() throws android.os.RemoteException {
                postToHandler(16);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public android.os.Bundle getExtras() {
                android.os.Bundle bundle;
                synchronized (android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mLock) {
                    bundle = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mExtras;
                }
                return bundle;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public long getFlags() {
                long j;
                synchronized (android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mLock) {
                    j = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mFlags;
                }
                return j;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public android.app.PendingIntent getLaunchPendingIntent() {
                android.app.PendingIntent pendingIntent;
                synchronized (android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mLock) {
                    pendingIntent = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mSessionActivity;
                }
                return pendingIntent;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public android.support.v4.media.MediaMetadataCompat getMetadata() {
                return android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mMetadata;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public java.lang.String getPackageName() {
                return android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mPackageName;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public android.support.v4.media.session.PlaybackStateCompat getPlaybackState() {
                android.support.v4.media.session.PlaybackStateCompat playbackStateCompat;
                android.support.v4.media.MediaMetadataCompat mediaMetadataCompat;
                synchronized (android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mLock) {
                    android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase mediaSessionImplBase = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this;
                    playbackStateCompat = mediaSessionImplBase.mState;
                    mediaMetadataCompat = mediaSessionImplBase.mMetadata;
                }
                return android.support.v4.media.session.MediaSessionCompat.getStateWithUpdatedPosition(playbackStateCompat, mediaMetadataCompat);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public java.util.List<android.support.v4.media.session.MediaSessionCompat.QueueItem> getQueue() {
                java.util.List<android.support.v4.media.session.MediaSessionCompat.QueueItem> list;
                synchronized (android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mLock) {
                    list = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mQueue;
                }
                return list;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public java.lang.CharSequence getQueueTitle() {
                return android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mQueueTitle;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRatingType() {
                return android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mRatingType;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRepeatMode() {
                return android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mRepeatMode;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getShuffleMode() {
                return android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mShuffleMode;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public java.lang.String getTag() {
                return android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mTag;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public android.support.v4.media.session.ParcelableVolumeInfo getVolumeAttributes() {
                int i;
                int i2;
                int i3;
                int streamMaxVolume;
                int streamVolume;
                synchronized (android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mLock) {
                    android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase mediaSessionImplBase = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this;
                    i = mediaSessionImplBase.mVolumeType;
                    i2 = mediaSessionImplBase.mLocalStream;
                    androidx.media.VolumeProviderCompat volumeProviderCompat = mediaSessionImplBase.mVolumeProvider;
                    i3 = 2;
                    if (i == 2) {
                        int volumeControl = volumeProviderCompat.getVolumeControl();
                        int maxVolume = volumeProviderCompat.getMaxVolume();
                        streamVolume = volumeProviderCompat.getCurrentVolume();
                        streamMaxVolume = maxVolume;
                        i3 = volumeControl;
                    } else {
                        streamMaxVolume = mediaSessionImplBase.mAudioManager.getStreamMaxVolume(i2);
                        streamVolume = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mAudioManager.getStreamVolume(i2);
                    }
                }
                return new android.support.v4.media.session.ParcelableVolumeInfo(i, i2, i3, streamMaxVolume, streamVolume);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isCaptioningEnabled() {
                return android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mCaptioningEnabled;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isShuffleModeEnabledRemoved() {
                return false;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isTransportControlEnabled() {
                return (android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mFlags & 2) != 0;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void next() throws android.os.RemoteException {
                postToHandler(14);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void pause() throws android.os.RemoteException {
                postToHandler(12);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void play() throws android.os.RemoteException {
                postToHandler(7);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromMediaId(java.lang.String str, android.os.Bundle bundle) throws android.os.RemoteException {
                postToHandler(8, str, bundle);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromSearch(java.lang.String str, android.os.Bundle bundle) throws android.os.RemoteException {
                postToHandler(9, str, bundle);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromUri(android.net.Uri uri, android.os.Bundle bundle) throws android.os.RemoteException {
                postToHandler(10, uri, bundle);
            }

            public void postToHandler(int i) {
                android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.postToHandler(i, 0, 0, null, null);
            }

            public void postToHandler(int i, int i2) {
                android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.postToHandler(i, i2, 0, null, null);
            }

            public void postToHandler(int i, java.lang.Object obj) {
                android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.postToHandler(i, 0, 0, obj, null);
            }

            public void postToHandler(int i, java.lang.Object obj, int i2) {
                android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.postToHandler(i, i2, 0, obj, null);
            }

            public void postToHandler(int i, java.lang.Object obj, android.os.Bundle bundle) {
                android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.postToHandler(i, 0, 0, obj, bundle);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepare() throws android.os.RemoteException {
                postToHandler(3);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromMediaId(java.lang.String str, android.os.Bundle bundle) throws android.os.RemoteException {
                postToHandler(4, str, bundle);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromSearch(java.lang.String str, android.os.Bundle bundle) throws android.os.RemoteException {
                postToHandler(5, str, bundle);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromUri(android.net.Uri uri, android.os.Bundle bundle) throws android.os.RemoteException {
                postToHandler(6, uri, bundle);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void previous() throws android.os.RemoteException {
                postToHandler(15);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rate(android.support.v4.media.RatingCompat ratingCompat) throws android.os.RemoteException {
                postToHandler(19, ratingCompat);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rateWithExtras(android.support.v4.media.RatingCompat ratingCompat, android.os.Bundle bundle) throws android.os.RemoteException {
                postToHandler(31, ratingCompat, bundle);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void registerCallbackListener(android.support.v4.media.session.IMediaControllerCallback iMediaControllerCallback) {
                if (android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mDestroyed) {
                    try {
                        iMediaControllerCallback.onSessionDestroyed();
                    } catch (java.lang.Exception unused) {
                    }
                } else {
                    android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mControllerCallbacks.register(iMediaControllerCallback, new androidx.media.MediaSessionManager.RemoteUserInfo(androidx.media.MediaSessionManager.RemoteUserInfo.LEGACY_CONTROLLER, android.os.Binder.getCallingPid(), android.os.Binder.getCallingUid()));
                }
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItem(android.support.v4.media.MediaDescriptionCompat mediaDescriptionCompat) {
                postToHandler(27, mediaDescriptionCompat);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItemAt(int i) {
                postToHandler(28, i);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rewind() throws android.os.RemoteException {
                postToHandler(17);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void seekTo(long j) throws android.os.RemoteException {
                postToHandler(18, java.lang.Long.valueOf(j));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCommand(java.lang.String str, android.os.Bundle bundle, android.support.v4.media.session.MediaSessionCompat.ResultReceiverWrapper resultReceiverWrapper) {
                postToHandler(1, new android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.Command(str, bundle, resultReceiverWrapper.mResultReceiver));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCustomAction(java.lang.String str, android.os.Bundle bundle) throws android.os.RemoteException {
                postToHandler(20, str, bundle);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean sendMediaButton(android.view.KeyEvent keyEvent) {
                boolean z = (android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mFlags & 1) != 0;
                if (z) {
                    postToHandler(21, keyEvent);
                }
                return z;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setCaptioningEnabled(boolean z) throws android.os.RemoteException {
                postToHandler(29, java.lang.Boolean.valueOf(z));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setRepeatMode(int i) throws android.os.RemoteException {
                postToHandler(23, i);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleMode(int i) throws android.os.RemoteException {
                postToHandler(30, i);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleModeEnabledRemoved(boolean z) throws android.os.RemoteException {
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setVolumeTo(int i, int i2, java.lang.String str) {
                android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.setVolumeTo(i, i2);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void skipToQueueItem(long j) {
                postToHandler(11, java.lang.Long.valueOf(j));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void stop() throws android.os.RemoteException {
                postToHandler(13);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void unregisterCallbackListener(android.support.v4.media.session.IMediaControllerCallback iMediaControllerCallback) {
                android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mControllerCallbacks.unregister(iMediaControllerCallback);
            }
        }

        public class MessageHandler extends android.os.Handler {
            private static final int KEYCODE_MEDIA_PAUSE = 127;
            private static final int KEYCODE_MEDIA_PLAY = 126;
            private static final int MSG_ADD_QUEUE_ITEM = 25;
            private static final int MSG_ADD_QUEUE_ITEM_AT = 26;
            private static final int MSG_ADJUST_VOLUME = 2;
            private static final int MSG_COMMAND = 1;
            private static final int MSG_CUSTOM_ACTION = 20;
            private static final int MSG_FAST_FORWARD = 16;
            private static final int MSG_MEDIA_BUTTON = 21;
            private static final int MSG_NEXT = 14;
            private static final int MSG_PAUSE = 12;
            private static final int MSG_PLAY = 7;
            private static final int MSG_PLAY_MEDIA_ID = 8;
            private static final int MSG_PLAY_SEARCH = 9;
            private static final int MSG_PLAY_URI = 10;
            private static final int MSG_PREPARE = 3;
            private static final int MSG_PREPARE_MEDIA_ID = 4;
            private static final int MSG_PREPARE_SEARCH = 5;
            private static final int MSG_PREPARE_URI = 6;
            private static final int MSG_PREVIOUS = 15;
            private static final int MSG_RATE = 19;
            private static final int MSG_RATE_EXTRA = 31;
            private static final int MSG_REMOVE_QUEUE_ITEM = 27;
            private static final int MSG_REMOVE_QUEUE_ITEM_AT = 28;
            private static final int MSG_REWIND = 17;
            private static final int MSG_SEEK_TO = 18;
            private static final int MSG_SET_CAPTIONING_ENABLED = 29;
            private static final int MSG_SET_REPEAT_MODE = 23;
            private static final int MSG_SET_SHUFFLE_MODE = 30;
            private static final int MSG_SET_VOLUME = 22;
            private static final int MSG_SKIP_TO_ITEM = 11;
            private static final int MSG_STOP = 13;

            public MessageHandler(android.os.Looper looper) {
                super(looper);
            }

            private void onMediaButtonEvent(android.view.KeyEvent keyEvent, android.support.v4.media.session.MediaSessionCompat.Callback callback) {
                if (keyEvent == null || keyEvent.getAction() != 0) {
                    return;
                }
                android.support.v4.media.session.PlaybackStateCompat playbackStateCompat = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mState;
                long actions = playbackStateCompat == null ? 0L : playbackStateCompat.getActions();
                int keyCode = keyEvent.getKeyCode();
                if (keyCode == 126) {
                    if ((actions & 4) != 0) {
                        callback.onPlay();
                    }
                    return;
                }
                if (keyCode == 127) {
                    if ((actions & 2) != 0) {
                        callback.onPause();
                        return;
                    }
                    return;
                }
                switch (keyCode) {
                    case 86:
                        if ((actions & 1) != 0) {
                            callback.onStop();
                            break;
                        }
                        break;
                    case 87:
                        if ((actions & 32) != 0) {
                            callback.onSkipToNext();
                            break;
                        }
                        break;
                    case 88:
                        if ((actions & 16) != 0) {
                            callback.onSkipToPrevious();
                            break;
                        }
                        break;
                    case 89:
                        if ((actions & 8) != 0) {
                            callback.onRewind();
                            break;
                        }
                        break;
                    case 90:
                        if ((actions & 64) != 0) {
                            callback.onFastForward();
                            break;
                        }
                        break;
                }
            }

            @Override // android.os.Handler
            public void handleMessage(android.os.Message message) {
                android.support.v4.media.session.MediaSessionCompat.Callback callback = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mCallback;
                if (callback == null) {
                    return;
                }
                android.os.Bundle data = message.getData();
                android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(data);
                android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.setCurrentControllerInfo(new androidx.media.MediaSessionManager.RemoteUserInfo(data.getString(android.support.v4.media.session.MediaSessionCompat.DATA_CALLING_PACKAGE), data.getInt("data_calling_pid"), data.getInt("data_calling_uid")));
                android.os.Bundle bundle = data.getBundle(android.support.v4.media.session.MediaSessionCompat.DATA_EXTRAS);
                android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(bundle);
                try {
                    switch (message.what) {
                        case 1:
                            android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.Command command = (android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.Command) message.obj;
                            callback.onCommand(command.command, command.extras, command.stub);
                            break;
                        case 2:
                            android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.adjustVolume(message.arg1, 0);
                            break;
                        case 3:
                            callback.onPrepare();
                            break;
                        case 4:
                            callback.onPrepareFromMediaId((java.lang.String) message.obj, bundle);
                            break;
                        case 5:
                            callback.onPrepareFromSearch((java.lang.String) message.obj, bundle);
                            break;
                        case 6:
                            callback.onPrepareFromUri((android.net.Uri) message.obj, bundle);
                            break;
                        case 7:
                            callback.onPlay();
                            break;
                        case 8:
                            callback.onPlayFromMediaId((java.lang.String) message.obj, bundle);
                            break;
                        case 9:
                            callback.onPlayFromSearch((java.lang.String) message.obj, bundle);
                            break;
                        case 10:
                            callback.onPlayFromUri((android.net.Uri) message.obj, bundle);
                            break;
                        case 11:
                            callback.onSkipToQueueItem(((java.lang.Long) message.obj).longValue());
                            break;
                        case 12:
                            callback.onPause();
                            break;
                        case 13:
                            callback.onStop();
                            break;
                        case 14:
                            callback.onSkipToNext();
                            break;
                        case 15:
                            callback.onSkipToPrevious();
                            break;
                        case 16:
                            callback.onFastForward();
                            break;
                        case 17:
                            callback.onRewind();
                            break;
                        case 18:
                            callback.onSeekTo(((java.lang.Long) message.obj).longValue());
                            break;
                        case 19:
                            callback.onSetRating((android.support.v4.media.RatingCompat) message.obj);
                            break;
                        case 20:
                            callback.onCustomAction((java.lang.String) message.obj, bundle);
                            break;
                        case 21:
                            android.view.KeyEvent keyEvent = (android.view.KeyEvent) message.obj;
                            android.content.Intent intent = new android.content.Intent("android.intent.action.MEDIA_BUTTON");
                            intent.putExtra("android.intent.extra.KEY_EVENT", keyEvent);
                            if (!callback.onMediaButtonEvent(intent)) {
                                onMediaButtonEvent(keyEvent, callback);
                                break;
                            }
                            break;
                        case 22:
                            android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.setVolumeTo(message.arg1, 0);
                            break;
                        case 23:
                            callback.onSetRepeatMode(message.arg1);
                            break;
                        case 25:
                            callback.onAddQueueItem((android.support.v4.media.MediaDescriptionCompat) message.obj);
                            break;
                        case 26:
                            callback.onAddQueueItem((android.support.v4.media.MediaDescriptionCompat) message.obj, message.arg1);
                            break;
                        case 27:
                            callback.onRemoveQueueItem((android.support.v4.media.MediaDescriptionCompat) message.obj);
                            break;
                        case 28:
                            java.util.List<android.support.v4.media.session.MediaSessionCompat.QueueItem> list = android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mQueue;
                            if (list != null) {
                                int i = message.arg1;
                                android.support.v4.media.session.MediaSessionCompat.QueueItem queueItem = (i < 0 || i >= list.size()) ? null : android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.mQueue.get(message.arg1);
                                if (queueItem != null) {
                                    callback.onRemoveQueueItem(queueItem.getDescription());
                                    break;
                                }
                            }
                            break;
                        case 29:
                            callback.onSetCaptioningEnabled(((java.lang.Boolean) message.obj).booleanValue());
                            break;
                        case 30:
                            callback.onSetShuffleMode(message.arg1);
                            break;
                        case 31:
                            callback.onSetRating((android.support.v4.media.RatingCompat) message.obj, bundle);
                            break;
                    }
                } finally {
                    android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.this.setCurrentControllerInfo(null);
                }
            }
        }

        public MediaSessionImplBase(android.content.Context context, java.lang.String str, android.content.ComponentName componentName, android.app.PendingIntent pendingIntent) {
            if (componentName == null) {
                throw new java.lang.IllegalArgumentException("MediaButtonReceiver component may not be null.");
            }
            this.mContext = context;
            this.mPackageName = context.getPackageName();
            this.mAudioManager = (android.media.AudioManager) context.getSystemService("audio");
            this.mTag = str;
            this.mMediaButtonReceiverComponentName = componentName;
            this.mMediaButtonReceiverIntent = pendingIntent;
            android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.MediaSessionStub mediaSessionStub = new android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.MediaSessionStub();
            this.mStub = mediaSessionStub;
            this.mToken = new android.support.v4.media.session.MediaSessionCompat.Token(mediaSessionStub);
            this.mRatingType = 0;
            this.mVolumeType = 1;
            this.mLocalStream = 3;
            this.mRcc = new android.media.RemoteControlClient(pendingIntent);
        }

        private void sendCaptioningEnabled(boolean z) {
            for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onCaptioningEnabledChanged(z);
                } catch (android.os.RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendEvent(java.lang.String str, android.os.Bundle bundle) {
            for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onEvent(str, bundle);
                } catch (android.os.RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendExtras(android.os.Bundle bundle) {
            for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onExtrasChanged(bundle);
                } catch (android.os.RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendMetadata(android.support.v4.media.MediaMetadataCompat mediaMetadataCompat) {
            for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onMetadataChanged(mediaMetadataCompat);
                } catch (android.os.RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendQueue(java.util.List<android.support.v4.media.session.MediaSessionCompat.QueueItem> list) {
            for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onQueueChanged(list);
                } catch (android.os.RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendQueueTitle(java.lang.CharSequence charSequence) {
            for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onQueueTitleChanged(charSequence);
                } catch (android.os.RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendRepeatMode(int i) {
            for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onRepeatModeChanged(i);
                } catch (android.os.RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendSessionDestroyed() {
            for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onSessionDestroyed();
                } catch (android.os.RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
            this.mControllerCallbacks.kill();
        }

        private void sendShuffleMode(int i) {
            for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onShuffleModeChanged(i);
                } catch (android.os.RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendState(android.support.v4.media.session.PlaybackStateCompat playbackStateCompat) {
            for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onPlaybackStateChanged(playbackStateCompat);
                } catch (android.os.RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        public void adjustVolume(int i, int i2) {
            if (this.mVolumeType != 2) {
                this.mAudioManager.adjustStreamVolume(this.mLocalStream, i, i2);
                return;
            }
            androidx.media.VolumeProviderCompat volumeProviderCompat = this.mVolumeProvider;
            if (volumeProviderCompat != null) {
                volumeProviderCompat.onAdjustVolume(i);
            }
        }

        public android.media.RemoteControlClient.MetadataEditor buildRccMetadata(android.os.Bundle bundle) {
            android.media.RemoteControlClient.MetadataEditor editMetadata = this.mRcc.editMetadata(true);
            if (bundle == null) {
                return editMetadata;
            }
            if (bundle.containsKey(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_ART)) {
                android.graphics.Bitmap bitmap = (android.graphics.Bitmap) bundle.getParcelable(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_ART);
                if (bitmap != null) {
                    bitmap = bitmap.copy(bitmap.getConfig(), false);
                }
                editMetadata.putBitmap(100, bitmap);
            } else if (bundle.containsKey(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_ALBUM_ART)) {
                android.graphics.Bitmap bitmap2 = (android.graphics.Bitmap) bundle.getParcelable(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_ALBUM_ART);
                if (bitmap2 != null) {
                    bitmap2 = bitmap2.copy(bitmap2.getConfig(), false);
                }
                editMetadata.putBitmap(100, bitmap2);
            }
            if (bundle.containsKey(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_ALBUM)) {
                editMetadata.putString(1, bundle.getString(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_ALBUM));
            }
            if (bundle.containsKey(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_ALBUM_ARTIST)) {
                editMetadata.putString(13, bundle.getString(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_ALBUM_ARTIST));
            }
            if (bundle.containsKey(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_ARTIST)) {
                editMetadata.putString(2, bundle.getString(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_ARTIST));
            }
            if (bundle.containsKey(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_AUTHOR)) {
                editMetadata.putString(3, bundle.getString(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_AUTHOR));
            }
            if (bundle.containsKey(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_COMPILATION)) {
                editMetadata.putString(15, bundle.getString(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_COMPILATION));
            }
            if (bundle.containsKey(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_COMPOSER)) {
                editMetadata.putString(4, bundle.getString(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_COMPOSER));
            }
            if (bundle.containsKey(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_DATE)) {
                editMetadata.putString(5, bundle.getString(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_DATE));
            }
            if (bundle.containsKey(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_DISC_NUMBER)) {
                editMetadata.putLong(14, bundle.getLong(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_DISC_NUMBER));
            }
            if (bundle.containsKey(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_DURATION)) {
                editMetadata.putLong(9, bundle.getLong(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_DURATION));
            }
            if (bundle.containsKey(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_GENRE)) {
                editMetadata.putString(6, bundle.getString(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_GENRE));
            }
            if (bundle.containsKey(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_TITLE)) {
                editMetadata.putString(7, bundle.getString(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_TITLE));
            }
            if (bundle.containsKey(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_TRACK_NUMBER)) {
                editMetadata.putLong(0, bundle.getLong(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_TRACK_NUMBER));
            }
            if (bundle.containsKey(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_WRITER)) {
                editMetadata.putString(11, bundle.getString(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_WRITER));
            }
            return editMetadata;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public java.lang.String getCallingPackage() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public androidx.media.MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() {
            androidx.media.MediaSessionManager.RemoteUserInfo remoteUserInfo;
            synchronized (this.mLock) {
                remoteUserInfo = this.mRemoteUserInfo;
            }
            return remoteUserInfo;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public java.lang.Object getMediaSession() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public android.support.v4.media.session.PlaybackStateCompat getPlaybackState() {
            android.support.v4.media.session.PlaybackStateCompat playbackStateCompat;
            synchronized (this.mLock) {
                playbackStateCompat = this.mState;
            }
            return playbackStateCompat;
        }

        public int getRccStateFromState(int i) {
            switch (i) {
                case 0:
                    return 0;
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                case 8:
                    return 8;
                case 7:
                    return 9;
                case 9:
                    return 7;
                case 10:
                case 11:
                    return 6;
                default:
                    return -1;
            }
        }

        public int getRccTransportControlFlagsFromActions(long j) {
            int i = (1 & j) != 0 ? 32 : 0;
            if ((2 & j) != 0) {
                i |= 16;
            }
            if ((4 & j) != 0) {
                i |= 4;
            }
            if ((8 & j) != 0) {
                i |= 2;
            }
            if ((16 & j) != 0) {
                i |= 1;
            }
            if ((32 & j) != 0) {
                i |= 128;
            }
            if ((64 & j) != 0) {
                i |= 64;
            }
            return (j & 512) != 0 ? i | 8 : i;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public java.lang.Object getRemoteControlClient() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public android.support.v4.media.session.MediaSessionCompat.Token getSessionToken() {
            return this.mToken;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public boolean isActive() {
            return this.mIsActive;
        }

        public void postToHandler(int i, int i2, int i3, java.lang.Object obj, android.os.Bundle bundle) {
            synchronized (this.mLock) {
                android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.MessageHandler messageHandler = this.mHandler;
                if (messageHandler != null) {
                    android.os.Message obtainMessage = messageHandler.obtainMessage(i, i2, i3, obj);
                    android.os.Bundle bundle2 = new android.os.Bundle();
                    bundle2.putString(android.support.v4.media.session.MediaSessionCompat.DATA_CALLING_PACKAGE, androidx.media.MediaSessionManager.RemoteUserInfo.LEGACY_CONTROLLER);
                    bundle2.putInt("data_calling_pid", android.os.Binder.getCallingPid());
                    bundle2.putInt("data_calling_uid", android.os.Binder.getCallingUid());
                    if (bundle != null) {
                        bundle2.putBundle(android.support.v4.media.session.MediaSessionCompat.DATA_EXTRAS, bundle);
                    }
                    obtainMessage.setData(bundle2);
                    obtainMessage.sendToTarget();
                }
            }
        }

        public void registerMediaButtonEventReceiver(android.app.PendingIntent pendingIntent, android.content.ComponentName componentName) {
            this.mAudioManager.registerMediaButtonEventReceiver(componentName);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void release() {
            this.mIsActive = false;
            this.mDestroyed = true;
            update();
            sendSessionDestroyed();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void sendSessionEvent(java.lang.String str, android.os.Bundle bundle) {
            sendEvent(str, bundle);
        }

        public void sendVolumeInfoChanged(android.support.v4.media.session.ParcelableVolumeInfo parcelableVolumeInfo) {
            for (int beginBroadcast = this.mControllerCallbacks.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    this.mControllerCallbacks.getBroadcastItem(beginBroadcast).onVolumeInfoChanged(parcelableVolumeInfo);
                } catch (android.os.RemoteException unused) {
                }
            }
            this.mControllerCallbacks.finishBroadcast();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setActive(boolean z) {
            if (z == this.mIsActive) {
                return;
            }
            this.mIsActive = z;
            if (update()) {
                setMetadata(this.mMetadata);
                setPlaybackState(this.mState);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCallback(android.support.v4.media.session.MediaSessionCompat.Callback callback, android.os.Handler handler) {
            this.mCallback = callback;
            if (callback != null) {
                if (handler == null) {
                    handler = new android.os.Handler();
                }
                synchronized (this.mLock) {
                    android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.MessageHandler messageHandler = this.mHandler;
                    if (messageHandler != null) {
                        messageHandler.removeCallbacksAndMessages(null);
                    }
                    this.mHandler = new android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase.MessageHandler(handler.getLooper());
                    this.mCallback.setSessionImpl(this, handler);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCaptioningEnabled(boolean z) {
            if (this.mCaptioningEnabled != z) {
                this.mCaptioningEnabled = z;
                sendCaptioningEnabled(z);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCurrentControllerInfo(androidx.media.MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            synchronized (this.mLock) {
                this.mRemoteUserInfo = remoteUserInfo;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setExtras(android.os.Bundle bundle) {
            this.mExtras = bundle;
            sendExtras(bundle);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setFlags(int i) {
            synchronized (this.mLock) {
                this.mFlags = i;
            }
            update();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setMediaButtonReceiver(android.app.PendingIntent pendingIntent) {
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setMetadata(android.support.v4.media.MediaMetadataCompat mediaMetadataCompat) {
            if (mediaMetadataCompat != null) {
                mediaMetadataCompat = new android.support.v4.media.MediaMetadataCompat.Builder(mediaMetadataCompat, android.support.v4.media.session.MediaSessionCompat.sMaxBitmapSize).build();
            }
            synchronized (this.mLock) {
                this.mMetadata = mediaMetadataCompat;
            }
            sendMetadata(mediaMetadataCompat);
            if (this.mIsActive) {
                buildRccMetadata(mediaMetadataCompat == null ? null : mediaMetadataCompat.getBundle()).apply();
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackState(android.support.v4.media.session.PlaybackStateCompat playbackStateCompat) {
            synchronized (this.mLock) {
                this.mState = playbackStateCompat;
            }
            sendState(playbackStateCompat);
            if (this.mIsActive) {
                if (playbackStateCompat == null) {
                    this.mRcc.setPlaybackState(0);
                    this.mRcc.setTransportControlFlags(0);
                } else {
                    setRccState(playbackStateCompat);
                    this.mRcc.setTransportControlFlags(getRccTransportControlFlagsFromActions(playbackStateCompat.getActions()));
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackToLocal(int i) {
            androidx.media.VolumeProviderCompat volumeProviderCompat = this.mVolumeProvider;
            if (volumeProviderCompat != null) {
                volumeProviderCompat.setCallback(null);
            }
            this.mLocalStream = i;
            this.mVolumeType = 1;
            int i2 = this.mVolumeType;
            int i3 = this.mLocalStream;
            sendVolumeInfoChanged(new android.support.v4.media.session.ParcelableVolumeInfo(i2, i3, 2, this.mAudioManager.getStreamMaxVolume(i3), this.mAudioManager.getStreamVolume(this.mLocalStream)));
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackToRemote(androidx.media.VolumeProviderCompat volumeProviderCompat) {
            if (volumeProviderCompat == null) {
                throw new java.lang.IllegalArgumentException("volumeProvider may not be null");
            }
            androidx.media.VolumeProviderCompat volumeProviderCompat2 = this.mVolumeProvider;
            if (volumeProviderCompat2 != null) {
                volumeProviderCompat2.setCallback(null);
            }
            this.mVolumeType = 2;
            this.mVolumeProvider = volumeProviderCompat;
            sendVolumeInfoChanged(new android.support.v4.media.session.ParcelableVolumeInfo(this.mVolumeType, this.mLocalStream, this.mVolumeProvider.getVolumeControl(), this.mVolumeProvider.getMaxVolume(), this.mVolumeProvider.getCurrentVolume()));
            volumeProviderCompat.setCallback(this.mVolumeCallback);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setQueue(java.util.List<android.support.v4.media.session.MediaSessionCompat.QueueItem> list) {
            this.mQueue = list;
            sendQueue(list);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setQueueTitle(java.lang.CharSequence charSequence) {
            this.mQueueTitle = charSequence;
            sendQueueTitle(charSequence);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setRatingType(int i) {
            this.mRatingType = i;
        }

        public void setRccState(android.support.v4.media.session.PlaybackStateCompat playbackStateCompat) {
            this.mRcc.setPlaybackState(getRccStateFromState(playbackStateCompat.getState()));
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setRepeatMode(int i) {
            if (this.mRepeatMode != i) {
                this.mRepeatMode = i;
                sendRepeatMode(i);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setSessionActivity(android.app.PendingIntent pendingIntent) {
            synchronized (this.mLock) {
                this.mSessionActivity = pendingIntent;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setShuffleMode(int i) {
            if (this.mShuffleMode != i) {
                this.mShuffleMode = i;
                sendShuffleMode(i);
            }
        }

        public void setVolumeTo(int i, int i2) {
            if (this.mVolumeType != 2) {
                this.mAudioManager.setStreamVolume(this.mLocalStream, i, i2);
                return;
            }
            androidx.media.VolumeProviderCompat volumeProviderCompat = this.mVolumeProvider;
            if (volumeProviderCompat != null) {
                volumeProviderCompat.onSetVolumeTo(i);
            }
        }

        public void unregisterMediaButtonEventReceiver(android.app.PendingIntent pendingIntent, android.content.ComponentName componentName) {
            this.mAudioManager.unregisterMediaButtonEventReceiver(componentName);
        }

        public boolean update() {
            if (!this.mIsActive) {
                if (this.mIsMbrRegistered) {
                    unregisterMediaButtonEventReceiver(this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
                    this.mIsMbrRegistered = false;
                }
                if (!this.mIsRccRegistered) {
                    return false;
                }
                this.mRcc.setPlaybackState(0);
                this.mAudioManager.unregisterRemoteControlClient(this.mRcc);
                this.mIsRccRegistered = false;
                return false;
            }
            boolean z = this.mIsMbrRegistered;
            if (!z && (this.mFlags & 1) != 0) {
                registerMediaButtonEventReceiver(this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
                this.mIsMbrRegistered = true;
            } else if (z && (this.mFlags & 1) == 0) {
                unregisterMediaButtonEventReceiver(this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
                this.mIsMbrRegistered = false;
            }
            boolean z2 = this.mIsRccRegistered;
            if (!z2 && (this.mFlags & 2) != 0) {
                this.mAudioManager.registerRemoteControlClient(this.mRcc);
                this.mIsRccRegistered = true;
                return true;
            }
            if (!z2 || (this.mFlags & 2) != 0) {
                return false;
            }
            this.mRcc.setPlaybackState(0);
            this.mAudioManager.unregisterRemoteControlClient(this.mRcc);
            this.mIsRccRegistered = false;
            return false;
        }
    }

    public interface OnActiveChangeListener {
        void onActiveChanged();
    }

    public static final class QueueItem implements android.os.Parcelable {
        public static final android.os.Parcelable.Creator<android.support.v4.media.session.MediaSessionCompat.QueueItem> CREATOR = new android.support.v4.media.session.MediaSessionCompat.QueueItem.AnonymousClass1();
        public static final int UNKNOWN_ID = -1;
        private final android.support.v4.media.MediaDescriptionCompat mDescription;
        private final long mId;
        private java.lang.Object mItem;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$QueueItem$1, reason: invalid class name */
        public static class AnonymousClass1 implements android.os.Parcelable.Creator<android.support.v4.media.session.MediaSessionCompat.QueueItem> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public android.support.v4.media.session.MediaSessionCompat.QueueItem createFromParcel(android.os.Parcel parcel) {
                return new android.support.v4.media.session.MediaSessionCompat.QueueItem(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public android.support.v4.media.session.MediaSessionCompat.QueueItem[] newArray(int i) {
                return new android.support.v4.media.session.MediaSessionCompat.QueueItem[i];
            }
        }

        public QueueItem(android.os.Parcel parcel) {
            this.mDescription = android.support.v4.media.MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.mId = parcel.readLong();
        }

        public QueueItem(android.support.v4.media.MediaDescriptionCompat mediaDescriptionCompat, long j) {
            this(null, mediaDescriptionCompat, j);
        }

        private QueueItem(java.lang.Object obj, android.support.v4.media.MediaDescriptionCompat mediaDescriptionCompat, long j) {
            if (mediaDescriptionCompat == null) {
                throw new java.lang.IllegalArgumentException("Description cannot be null.");
            }
            if (j == -1) {
                throw new java.lang.IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            }
            this.mDescription = mediaDescriptionCompat;
            this.mId = j;
            this.mItem = obj;
        }

        public static android.support.v4.media.session.MediaSessionCompat.QueueItem fromQueueItem(java.lang.Object obj) {
            if (obj != null) {
                return new android.support.v4.media.session.MediaSessionCompat.QueueItem(obj, android.support.v4.media.MediaDescriptionCompat.fromMediaDescription(android.support.v4.media.session.MediaSessionCompatApi21.QueueItem.getDescription(obj)), android.support.v4.media.session.MediaSessionCompatApi21.QueueItem.getQueueId(obj));
            }
            return null;
        }

        public static java.util.List<android.support.v4.media.session.MediaSessionCompat.QueueItem> fromQueueItemList(java.util.List<?> list) {
            if (list == null) {
                return null;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList();
            java.util.Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(fromQueueItem(it.next()));
            }
            return arrayList;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public android.support.v4.media.MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        public long getQueueId() {
            return this.mId;
        }

        public java.lang.Object getQueueItem() {
            java.lang.Object obj = this.mItem;
            if (obj != null) {
                return obj;
            }
            java.lang.Object createItem = android.support.v4.media.session.MediaSessionCompatApi21.QueueItem.createItem(this.mDescription.getMediaDescription(), this.mId);
            this.mItem = createItem;
            return createItem;
        }

        public java.lang.String toString() {
            return "MediaSession.QueueItem {Description=" + this.mDescription + ", Id=" + this.mId + " }";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            this.mDescription.writeToParcel(parcel, i);
            parcel.writeLong(this.mId);
        }
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public static final class ResultReceiverWrapper implements android.os.Parcelable {
        public static final android.os.Parcelable.Creator<android.support.v4.media.session.MediaSessionCompat.ResultReceiverWrapper> CREATOR = new android.support.v4.media.session.MediaSessionCompat.ResultReceiverWrapper.AnonymousClass1();
        android.os.ResultReceiver mResultReceiver;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper$1, reason: invalid class name */
        public static class AnonymousClass1 implements android.os.Parcelable.Creator<android.support.v4.media.session.MediaSessionCompat.ResultReceiverWrapper> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public android.support.v4.media.session.MediaSessionCompat.ResultReceiverWrapper createFromParcel(android.os.Parcel parcel) {
                return new android.support.v4.media.session.MediaSessionCompat.ResultReceiverWrapper(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public android.support.v4.media.session.MediaSessionCompat.ResultReceiverWrapper[] newArray(int i) {
                return new android.support.v4.media.session.MediaSessionCompat.ResultReceiverWrapper[i];
            }
        }

        public ResultReceiverWrapper(android.os.Parcel parcel) {
            this.mResultReceiver = (android.os.ResultReceiver) android.os.ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        public ResultReceiverWrapper(android.os.ResultReceiver resultReceiver) {
            this.mResultReceiver = resultReceiver;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            this.mResultReceiver.writeToParcel(parcel, i);
        }
    }

    @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public @interface SessionFlags {
    }

    public static final class Token implements android.os.Parcelable {
        public static final android.os.Parcelable.Creator<android.support.v4.media.session.MediaSessionCompat.Token> CREATOR = new android.support.v4.media.session.MediaSessionCompat.Token.AnonymousClass1();
        private android.support.v4.media.session.IMediaSession mExtraBinder;
        private final java.lang.Object mInner;
        private android.os.Bundle mSessionToken2Bundle;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$Token$1, reason: invalid class name */
        public static class AnonymousClass1 implements android.os.Parcelable.Creator<android.support.v4.media.session.MediaSessionCompat.Token> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public android.support.v4.media.session.MediaSessionCompat.Token createFromParcel(android.os.Parcel parcel) {
                return new android.support.v4.media.session.MediaSessionCompat.Token(parcel.readParcelable(null));
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public android.support.v4.media.session.MediaSessionCompat.Token[] newArray(int i) {
                return new android.support.v4.media.session.MediaSessionCompat.Token[i];
            }
        }

        public Token(java.lang.Object obj) {
            this(obj, null, null);
        }

        public Token(java.lang.Object obj, android.support.v4.media.session.IMediaSession iMediaSession) {
            this(obj, iMediaSession, null);
        }

        public Token(java.lang.Object obj, android.support.v4.media.session.IMediaSession iMediaSession, android.os.Bundle bundle) {
            this.mInner = obj;
            this.mExtraBinder = iMediaSession;
            this.mSessionToken2Bundle = bundle;
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public static android.support.v4.media.session.MediaSessionCompat.Token fromBundle(android.os.Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            android.support.v4.media.session.IMediaSession asInterface = android.support.v4.media.session.IMediaSession.Stub.asInterface(androidx.core.app.BundleCompat.getBinder(bundle, android.support.v4.media.session.MediaSessionCompat.KEY_EXTRA_BINDER));
            android.os.Bundle bundle2 = bundle.getBundle(android.support.v4.media.session.MediaSessionCompat.KEY_SESSION_TOKEN2_BUNDLE);
            android.support.v4.media.session.MediaSessionCompat.Token token = (android.support.v4.media.session.MediaSessionCompat.Token) bundle.getParcelable(android.support.v4.media.session.MediaSessionCompat.KEY_TOKEN);
            if (token == null) {
                return null;
            }
            return new android.support.v4.media.session.MediaSessionCompat.Token(token.mInner, asInterface, bundle2);
        }

        public static android.support.v4.media.session.MediaSessionCompat.Token fromToken(java.lang.Object obj) {
            return fromToken(obj, null);
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public static android.support.v4.media.session.MediaSessionCompat.Token fromToken(java.lang.Object obj, android.support.v4.media.session.IMediaSession iMediaSession) {
            if (obj != null) {
                return new android.support.v4.media.session.MediaSessionCompat.Token(android.support.v4.media.session.MediaSessionCompatApi21.verifyToken(obj), iMediaSession);
            }
            return null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(java.lang.Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof android.support.v4.media.session.MediaSessionCompat.Token)) {
                return false;
            }
            android.support.v4.media.session.MediaSessionCompat.Token token = (android.support.v4.media.session.MediaSessionCompat.Token) obj;
            java.lang.Object obj2 = this.mInner;
            if (obj2 == null) {
                return token.mInner == null;
            }
            java.lang.Object obj3 = token.mInner;
            if (obj3 == null) {
                return false;
            }
            return obj2.equals(obj3);
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public android.support.v4.media.session.IMediaSession getExtraBinder() {
            return this.mExtraBinder;
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public android.os.Bundle getSessionToken2Bundle() {
            return this.mSessionToken2Bundle;
        }

        public java.lang.Object getToken() {
            return this.mInner;
        }

        public int hashCode() {
            java.lang.Object obj = this.mInner;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public void setExtraBinder(android.support.v4.media.session.IMediaSession iMediaSession) {
            this.mExtraBinder = iMediaSession;
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public void setSessionToken2Bundle(android.os.Bundle bundle) {
            this.mSessionToken2Bundle = bundle;
        }

        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public android.os.Bundle toBundle() {
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putParcelable(android.support.v4.media.session.MediaSessionCompat.KEY_TOKEN, this);
            android.support.v4.media.session.IMediaSession iMediaSession = this.mExtraBinder;
            if (iMediaSession != null) {
                androidx.core.app.BundleCompat.putBinder(bundle, android.support.v4.media.session.MediaSessionCompat.KEY_EXTRA_BINDER, iMediaSession.asBinder());
            }
            android.os.Bundle bundle2 = this.mSessionToken2Bundle;
            if (bundle2 != null) {
                bundle.putBundle(android.support.v4.media.session.MediaSessionCompat.KEY_SESSION_TOKEN2_BUNDLE, bundle2);
            }
            return bundle;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            parcel.writeParcelable((android.os.Parcelable) this.mInner, i);
        }
    }

    private MediaSessionCompat(android.content.Context context, android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl mediaSessionImpl) {
        this.mActiveListeners = new java.util.ArrayList<>();
        this.mImpl = mediaSessionImpl;
        if (!android.support.v4.media.session.MediaSessionCompatApi21.hasCallback(mediaSessionImpl.getMediaSession())) {
            setCallback(new android.support.v4.media.session.MediaSessionCompat.AnonymousClass3());
        }
        this.mController = new android.support.v4.media.session.MediaControllerCompat(context, this);
    }

    public MediaSessionCompat(android.content.Context context, java.lang.String str) {
        this(context, str, null, null);
    }

    public MediaSessionCompat(android.content.Context context, java.lang.String str, android.content.ComponentName componentName, android.app.PendingIntent pendingIntent) {
        this(context, str, componentName, pendingIntent, null);
    }

    private MediaSessionCompat(android.content.Context context, java.lang.String str, android.content.ComponentName componentName, android.app.PendingIntent pendingIntent, android.os.Bundle bundle) {
        this.mActiveListeners = new java.util.ArrayList<>();
        if (context == null) {
            throw new java.lang.IllegalArgumentException("context must not be null");
        }
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException("tag must not be null or empty");
        }
        componentName = componentName == null ? androidx.media.session.MediaButtonReceiver.getMediaButtonReceiverComponent(context) : componentName;
        if (componentName != null && pendingIntent == null) {
            android.content.Intent intent = new android.content.Intent("android.intent.action.MEDIA_BUTTON");
            intent.setComponent(componentName);
            pendingIntent = android.app.PendingIntent.getBroadcast(context, 0, intent, 0);
        }
        if (android.os.Build.VERSION.SDK_INT >= 28) {
            android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi28 mediaSessionImplApi28 = new android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi28(context, str, bundle);
            this.mImpl = mediaSessionImplApi28;
            setCallback(new android.support.v4.media.session.MediaSessionCompat.AnonymousClass1());
            mediaSessionImplApi28.setMediaButtonReceiver(pendingIntent);
        } else {
            android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21 mediaSessionImplApi21 = new android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21(context, str, bundle);
            this.mImpl = mediaSessionImplApi21;
            setCallback(new android.support.v4.media.session.MediaSessionCompat.AnonymousClass2());
            mediaSessionImplApi21.setMediaButtonReceiver(pendingIntent);
        }
        this.mController = new android.support.v4.media.session.MediaControllerCompat(context, this);
        if (sMaxBitmapSize == 0) {
            sMaxBitmapSize = (int) (android.util.TypedValue.applyDimension(1, 320.0f, context.getResources().getDisplayMetrics()) + 0.5f);
        }
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public MediaSessionCompat(android.content.Context context, java.lang.String str, android.os.Bundle bundle) {
        this(context, str, null, null, bundle);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public static void ensureClassLoader(@androidx.annotation.Nullable android.os.Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(android.support.v4.media.session.MediaSessionCompat.class.getClassLoader());
        }
    }

    public static android.support.v4.media.session.MediaSessionCompat fromMediaSession(android.content.Context context, java.lang.Object obj) {
        if (context == null || obj == null) {
            return null;
        }
        return new android.support.v4.media.session.MediaSessionCompat(context, new android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21(obj));
    }

    public static android.support.v4.media.session.PlaybackStateCompat getStateWithUpdatedPosition(android.support.v4.media.session.PlaybackStateCompat playbackStateCompat, android.support.v4.media.MediaMetadataCompat mediaMetadataCompat) {
        if (playbackStateCompat == null) {
            return playbackStateCompat;
        }
        long j = -1;
        if (playbackStateCompat.getPosition() == -1) {
            return playbackStateCompat;
        }
        if (playbackStateCompat.getState() != 3 && playbackStateCompat.getState() != 4 && playbackStateCompat.getState() != 5) {
            return playbackStateCompat;
        }
        if (playbackStateCompat.getLastPositionUpdateTime() <= 0) {
            return playbackStateCompat;
        }
        long elapsedRealtime = android.os.SystemClock.elapsedRealtime();
        long playbackSpeed = ((long) (playbackStateCompat.getPlaybackSpeed() * (elapsedRealtime - r0))) + playbackStateCompat.getPosition();
        if (mediaMetadataCompat != null && mediaMetadataCompat.containsKey(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_DURATION)) {
            j = mediaMetadataCompat.getLong(android.support.v4.media.MediaMetadataCompat.METADATA_KEY_DURATION);
        }
        return new android.support.v4.media.session.PlaybackStateCompat.Builder(playbackStateCompat).setState(playbackStateCompat.getState(), (j < 0 || playbackSpeed <= j) ? playbackSpeed < 0 ? 0L : playbackSpeed : j, playbackStateCompat.getPlaybackSpeed(), elapsedRealtime).build();
    }

    public void addOnActiveChangeListener(android.support.v4.media.session.MediaSessionCompat.OnActiveChangeListener onActiveChangeListener) {
        if (onActiveChangeListener == null) {
            throw new java.lang.IllegalArgumentException("Listener may not be null");
        }
        this.mActiveListeners.add(onActiveChangeListener);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public java.lang.String getCallingPackage() {
        return this.mImpl.getCallingPackage();
    }

    public android.support.v4.media.session.MediaControllerCompat getController() {
        return this.mController;
    }

    @androidx.annotation.NonNull
    public final androidx.media.MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() {
        return this.mImpl.getCurrentControllerInfo();
    }

    public java.lang.Object getMediaSession() {
        return this.mImpl.getMediaSession();
    }

    public java.lang.Object getRemoteControlClient() {
        return this.mImpl.getRemoteControlClient();
    }

    public android.support.v4.media.session.MediaSessionCompat.Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }

    public boolean isActive() {
        return this.mImpl.isActive();
    }

    public void release() {
        this.mImpl.release();
    }

    public void removeOnActiveChangeListener(android.support.v4.media.session.MediaSessionCompat.OnActiveChangeListener onActiveChangeListener) {
        if (onActiveChangeListener == null) {
            throw new java.lang.IllegalArgumentException("Listener may not be null");
        }
        this.mActiveListeners.remove(onActiveChangeListener);
    }

    public void sendSessionEvent(java.lang.String str, android.os.Bundle bundle) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException("event cannot be null or empty");
        }
        this.mImpl.sendSessionEvent(str, bundle);
    }

    public void setActive(boolean z) {
        this.mImpl.setActive(z);
        java.util.Iterator<android.support.v4.media.session.MediaSessionCompat.OnActiveChangeListener> it = this.mActiveListeners.iterator();
        while (it.hasNext()) {
            it.next().onActiveChanged();
        }
    }

    public void setCallback(android.support.v4.media.session.MediaSessionCompat.Callback callback) {
        setCallback(callback, null);
    }

    public void setCallback(android.support.v4.media.session.MediaSessionCompat.Callback callback, android.os.Handler handler) {
        if (callback == null) {
            this.mImpl.setCallback(null, null);
            return;
        }
        android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl mediaSessionImpl = this.mImpl;
        if (handler == null) {
            handler = new android.os.Handler();
        }
        mediaSessionImpl.setCallback(callback, handler);
    }

    public void setCaptioningEnabled(boolean z) {
        this.mImpl.setCaptioningEnabled(z);
    }

    public void setExtras(android.os.Bundle bundle) {
        this.mImpl.setExtras(bundle);
    }

    public void setFlags(int i) {
        this.mImpl.setFlags(i);
    }

    public void setMediaButtonReceiver(android.app.PendingIntent pendingIntent) {
        this.mImpl.setMediaButtonReceiver(pendingIntent);
    }

    public void setMetadata(android.support.v4.media.MediaMetadataCompat mediaMetadataCompat) {
        this.mImpl.setMetadata(mediaMetadataCompat);
    }

    public void setPlaybackState(android.support.v4.media.session.PlaybackStateCompat playbackStateCompat) {
        this.mImpl.setPlaybackState(playbackStateCompat);
    }

    public void setPlaybackToLocal(int i) {
        this.mImpl.setPlaybackToLocal(i);
    }

    public void setPlaybackToRemote(androidx.media.VolumeProviderCompat volumeProviderCompat) {
        if (volumeProviderCompat == null) {
            throw new java.lang.IllegalArgumentException("volumeProvider may not be null!");
        }
        this.mImpl.setPlaybackToRemote(volumeProviderCompat);
    }

    public void setQueue(java.util.List<android.support.v4.media.session.MediaSessionCompat.QueueItem> list) {
        this.mImpl.setQueue(list);
    }

    public void setQueueTitle(java.lang.CharSequence charSequence) {
        this.mImpl.setQueueTitle(charSequence);
    }

    public void setRatingType(int i) {
        this.mImpl.setRatingType(i);
    }

    public void setRepeatMode(int i) {
        this.mImpl.setRepeatMode(i);
    }

    public void setSessionActivity(android.app.PendingIntent pendingIntent) {
        this.mImpl.setSessionActivity(pendingIntent);
    }

    public void setShuffleMode(int i) {
        this.mImpl.setShuffleMode(i);
    }
}
