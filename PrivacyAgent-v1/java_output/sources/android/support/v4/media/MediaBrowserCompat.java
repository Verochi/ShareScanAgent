package android.support.v4.media;

/* loaded from: classes.dex */
public final class MediaBrowserCompat {
    public static final java.lang.String CUSTOM_ACTION_DOWNLOAD = "android.support.v4.media.action.DOWNLOAD";
    public static final java.lang.String CUSTOM_ACTION_REMOVE_DOWNLOADED_FILE = "android.support.v4.media.action.REMOVE_DOWNLOADED_FILE";
    public static final java.lang.String EXTRA_DOWNLOAD_PROGRESS = "android.media.browse.extra.DOWNLOAD_PROGRESS";
    public static final java.lang.String EXTRA_MEDIA_ID = "android.media.browse.extra.MEDIA_ID";
    public static final java.lang.String EXTRA_PAGE = "android.media.browse.extra.PAGE";
    public static final java.lang.String EXTRA_PAGE_SIZE = "android.media.browse.extra.PAGE_SIZE";
    private final android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl mImpl;
    static final java.lang.String TAG = "MediaBrowserCompat";
    static final boolean DEBUG = android.util.Log.isLoggable(TAG, 3);

    public static class CallbackHandler extends android.os.Handler {
        private final java.lang.ref.WeakReference<android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl> mCallbackImplRef;
        private java.lang.ref.WeakReference<android.os.Messenger> mCallbacksMessengerRef;

        public CallbackHandler(android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl mediaBrowserServiceCallbackImpl) {
            this.mCallbackImplRef = new java.lang.ref.WeakReference<>(mediaBrowserServiceCallbackImpl);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            java.lang.ref.WeakReference<android.os.Messenger> weakReference = this.mCallbacksMessengerRef;
            if (weakReference == null || weakReference.get() == null || this.mCallbackImplRef.get() == null) {
                return;
            }
            android.os.Bundle data = message.getData();
            android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(data);
            android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl mediaBrowserServiceCallbackImpl = this.mCallbackImplRef.get();
            android.os.Messenger messenger = this.mCallbacksMessengerRef.get();
            try {
                int i = message.what;
                if (i == 1) {
                    android.os.Bundle bundle = data.getBundle(androidx.media.MediaBrowserProtocol.DATA_ROOT_HINTS);
                    android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(bundle);
                    mediaBrowserServiceCallbackImpl.onServiceConnected(messenger, data.getString(androidx.media.MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), (android.support.v4.media.session.MediaSessionCompat.Token) data.getParcelable(androidx.media.MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN), bundle);
                } else if (i == 2) {
                    mediaBrowserServiceCallbackImpl.onConnectionFailed(messenger);
                } else if (i != 3) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("Unhandled message: ");
                    sb.append(message);
                    sb.append("\n  Client version: ");
                    sb.append(1);
                    sb.append("\n  Service version: ");
                    sb.append(message.arg1);
                } else {
                    android.os.Bundle bundle2 = data.getBundle(androidx.media.MediaBrowserProtocol.DATA_OPTIONS);
                    android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(bundle2);
                    android.os.Bundle bundle3 = data.getBundle(androidx.media.MediaBrowserProtocol.DATA_NOTIFY_CHILDREN_CHANGED_OPTIONS);
                    android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(bundle3);
                    mediaBrowserServiceCallbackImpl.onLoadChildren(messenger, data.getString(androidx.media.MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), data.getParcelableArrayList(androidx.media.MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST), bundle2, bundle3);
                }
            } catch (android.os.BadParcelableException unused) {
                if (message.what == 1) {
                    mediaBrowserServiceCallbackImpl.onConnectionFailed(messenger);
                }
            }
        }

        public void setCallbacksMessenger(android.os.Messenger messenger) {
            this.mCallbacksMessengerRef = new java.lang.ref.WeakReference<>(messenger);
        }
    }

    public static class ConnectionCallback {
        final android.media.browse.MediaBrowser.ConnectionCallback mConnectionCallbackFwk = new android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackApi21();
        android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal mConnectionCallbackInternal;

        @androidx.annotation.RequiresApi(21)
        public class ConnectionCallbackApi21 extends android.media.browse.MediaBrowser.ConnectionCallback {
            public ConnectionCallbackApi21() {
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnected() {
                android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal connectionCallbackInternal = android.support.v4.media.MediaBrowserCompat.ConnectionCallback.this.mConnectionCallbackInternal;
                if (connectionCallbackInternal != null) {
                    connectionCallbackInternal.onConnected();
                }
                android.support.v4.media.MediaBrowserCompat.ConnectionCallback.this.onConnected();
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnectionFailed() {
                android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal connectionCallbackInternal = android.support.v4.media.MediaBrowserCompat.ConnectionCallback.this.mConnectionCallbackInternal;
                if (connectionCallbackInternal != null) {
                    connectionCallbackInternal.onConnectionFailed();
                }
                android.support.v4.media.MediaBrowserCompat.ConnectionCallback.this.onConnectionFailed();
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnectionSuspended() {
                android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal connectionCallbackInternal = android.support.v4.media.MediaBrowserCompat.ConnectionCallback.this.mConnectionCallbackInternal;
                if (connectionCallbackInternal != null) {
                    connectionCallbackInternal.onConnectionSuspended();
                }
                android.support.v4.media.MediaBrowserCompat.ConnectionCallback.this.onConnectionSuspended();
            }
        }

        public interface ConnectionCallbackInternal {
            void onConnected();

            void onConnectionFailed();

            void onConnectionSuspended();
        }

        public void onConnected() {
        }

        public void onConnectionFailed() {
        }

        public void onConnectionSuspended() {
        }

        public void setInternalConnectionCallback(android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal connectionCallbackInternal) {
            this.mConnectionCallbackInternal = connectionCallbackInternal;
        }
    }

    public static abstract class CustomActionCallback {
        public void onError(java.lang.String str, android.os.Bundle bundle, android.os.Bundle bundle2) {
        }

        public void onProgressUpdate(java.lang.String str, android.os.Bundle bundle, android.os.Bundle bundle2) {
        }

        public void onResult(java.lang.String str, android.os.Bundle bundle, android.os.Bundle bundle2) {
        }
    }

    public static class CustomActionResultReceiver extends android.support.v4.os.ResultReceiver {
        private final java.lang.String mAction;
        private final android.support.v4.media.MediaBrowserCompat.CustomActionCallback mCallback;
        private final android.os.Bundle mExtras;

        public CustomActionResultReceiver(java.lang.String str, android.os.Bundle bundle, android.support.v4.media.MediaBrowserCompat.CustomActionCallback customActionCallback, android.os.Handler handler) {
            super(handler);
            this.mAction = str;
            this.mExtras = bundle;
            this.mCallback = customActionCallback;
        }

        @Override // android.support.v4.os.ResultReceiver
        public void onReceiveResult(int i, android.os.Bundle bundle) {
            if (this.mCallback == null) {
                return;
            }
            android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(bundle);
            if (i == -1) {
                this.mCallback.onError(this.mAction, this.mExtras, bundle);
                return;
            }
            if (i == 0) {
                this.mCallback.onResult(this.mAction, this.mExtras, bundle);
                return;
            }
            if (i == 1) {
                this.mCallback.onProgressUpdate(this.mAction, this.mExtras, bundle);
                return;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("Unknown result code: ");
            sb.append(i);
            sb.append(" (extras=");
            sb.append(this.mExtras);
            sb.append(", resultData=");
            sb.append(bundle);
            sb.append(")");
        }
    }

    public static abstract class ItemCallback {
        final android.media.browse.MediaBrowser.ItemCallback mItemCallbackFwk;

        @androidx.annotation.RequiresApi(23)
        public class ItemCallbackApi23 extends android.media.browse.MediaBrowser.ItemCallback {
            public ItemCallbackApi23() {
            }

            @Override // android.media.browse.MediaBrowser.ItemCallback
            public void onError(@androidx.annotation.NonNull java.lang.String str) {
                android.support.v4.media.MediaBrowserCompat.ItemCallback.this.onError(str);
            }

            @Override // android.media.browse.MediaBrowser.ItemCallback
            public void onItemLoaded(android.media.browse.MediaBrowser.MediaItem mediaItem) {
                android.support.v4.media.MediaBrowserCompat.ItemCallback.this.onItemLoaded(android.support.v4.media.MediaBrowserCompat.MediaItem.fromMediaItem(mediaItem));
            }
        }

        public ItemCallback() {
            if (android.os.Build.VERSION.SDK_INT >= 23) {
                this.mItemCallbackFwk = new android.support.v4.media.MediaBrowserCompat.ItemCallback.ItemCallbackApi23();
            } else {
                this.mItemCallbackFwk = null;
            }
        }

        public void onError(@androidx.annotation.NonNull java.lang.String str) {
        }

        public void onItemLoaded(android.support.v4.media.MediaBrowserCompat.MediaItem mediaItem) {
        }
    }

    public static class ItemReceiver extends android.support.v4.os.ResultReceiver {
        private final android.support.v4.media.MediaBrowserCompat.ItemCallback mCallback;
        private final java.lang.String mMediaId;

        public ItemReceiver(java.lang.String str, android.support.v4.media.MediaBrowserCompat.ItemCallback itemCallback, android.os.Handler handler) {
            super(handler);
            this.mMediaId = str;
            this.mCallback = itemCallback;
        }

        @Override // android.support.v4.os.ResultReceiver
        public void onReceiveResult(int i, android.os.Bundle bundle) {
            android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(bundle);
            if (i != 0 || bundle == null || !bundle.containsKey(androidx.media.MediaBrowserServiceCompat.KEY_MEDIA_ITEM)) {
                this.mCallback.onError(this.mMediaId);
                return;
            }
            android.os.Parcelable parcelable = bundle.getParcelable(androidx.media.MediaBrowserServiceCompat.KEY_MEDIA_ITEM);
            if (parcelable == null || (parcelable instanceof android.support.v4.media.MediaBrowserCompat.MediaItem)) {
                this.mCallback.onItemLoaded((android.support.v4.media.MediaBrowserCompat.MediaItem) parcelable);
            } else {
                this.mCallback.onError(this.mMediaId);
            }
        }
    }

    public interface MediaBrowserImpl {
        void connect();

        void disconnect();

        @androidx.annotation.Nullable
        android.os.Bundle getExtras();

        void getItem(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull android.support.v4.media.MediaBrowserCompat.ItemCallback itemCallback);

        @androidx.annotation.Nullable
        android.os.Bundle getNotifyChildrenChangedOptions();

        @androidx.annotation.NonNull
        java.lang.String getRoot();

        android.content.ComponentName getServiceComponent();

        @androidx.annotation.NonNull
        android.support.v4.media.session.MediaSessionCompat.Token getSessionToken();

        boolean isConnected();

        void search(@androidx.annotation.NonNull java.lang.String str, android.os.Bundle bundle, @androidx.annotation.NonNull android.support.v4.media.MediaBrowserCompat.SearchCallback searchCallback);

        void sendCustomAction(@androidx.annotation.NonNull java.lang.String str, android.os.Bundle bundle, @androidx.annotation.Nullable android.support.v4.media.MediaBrowserCompat.CustomActionCallback customActionCallback);

        void subscribe(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable android.os.Bundle bundle, @androidx.annotation.NonNull android.support.v4.media.MediaBrowserCompat.SubscriptionCallback subscriptionCallback);

        void unsubscribe(@androidx.annotation.NonNull java.lang.String str, android.support.v4.media.MediaBrowserCompat.SubscriptionCallback subscriptionCallback);
    }

    @androidx.annotation.RequiresApi(21)
    public static class MediaBrowserImplApi21 implements android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl, android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl, android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal {
        protected final android.media.browse.MediaBrowser mBrowserFwk;
        protected android.os.Messenger mCallbacksMessenger;
        final android.content.Context mContext;
        private android.support.v4.media.session.MediaSessionCompat.Token mMediaSessionToken;
        private android.os.Bundle mNotifyChildrenChangedOptions;
        protected final android.os.Bundle mRootHints;
        protected android.support.v4.media.MediaBrowserCompat.ServiceBinderWrapper mServiceBinderWrapper;
        protected int mServiceVersion;
        protected final android.support.v4.media.MediaBrowserCompat.CallbackHandler mHandler = new android.support.v4.media.MediaBrowserCompat.CallbackHandler(this);
        private final androidx.collection.ArrayMap<java.lang.String, android.support.v4.media.MediaBrowserCompat.Subscription> mSubscriptions = new androidx.collection.ArrayMap<>();

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ android.support.v4.media.MediaBrowserCompat.ItemCallback val$cb;
            final /* synthetic */ java.lang.String val$mediaId;

            public AnonymousClass1(android.support.v4.media.MediaBrowserCompat.ItemCallback itemCallback, java.lang.String str) {
                this.val$cb = itemCallback;
                this.val$mediaId = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.val$cb.onError(this.val$mediaId);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            final /* synthetic */ android.support.v4.media.MediaBrowserCompat.ItemCallback val$cb;
            final /* synthetic */ java.lang.String val$mediaId;

            public AnonymousClass2(android.support.v4.media.MediaBrowserCompat.ItemCallback itemCallback, java.lang.String str) {
                this.val$cb = itemCallback;
                this.val$mediaId = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.val$cb.onError(this.val$mediaId);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$3, reason: invalid class name */
        public class AnonymousClass3 implements java.lang.Runnable {
            final /* synthetic */ android.support.v4.media.MediaBrowserCompat.ItemCallback val$cb;
            final /* synthetic */ java.lang.String val$mediaId;

            public AnonymousClass3(android.support.v4.media.MediaBrowserCompat.ItemCallback itemCallback, java.lang.String str) {
                this.val$cb = itemCallback;
                this.val$mediaId = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.val$cb.onError(this.val$mediaId);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$4, reason: invalid class name */
        public class AnonymousClass4 implements java.lang.Runnable {
            final /* synthetic */ android.support.v4.media.MediaBrowserCompat.SearchCallback val$callback;
            final /* synthetic */ android.os.Bundle val$extras;
            final /* synthetic */ java.lang.String val$query;

            public AnonymousClass4(android.support.v4.media.MediaBrowserCompat.SearchCallback searchCallback, java.lang.String str, android.os.Bundle bundle) {
                this.val$callback = searchCallback;
                this.val$query = str;
                this.val$extras = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.val$callback.onError(this.val$query, this.val$extras);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$5, reason: invalid class name */
        public class AnonymousClass5 implements java.lang.Runnable {
            final /* synthetic */ android.support.v4.media.MediaBrowserCompat.SearchCallback val$callback;
            final /* synthetic */ android.os.Bundle val$extras;
            final /* synthetic */ java.lang.String val$query;

            public AnonymousClass5(android.support.v4.media.MediaBrowserCompat.SearchCallback searchCallback, java.lang.String str, android.os.Bundle bundle) {
                this.val$callback = searchCallback;
                this.val$query = str;
                this.val$extras = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.val$callback.onError(this.val$query, this.val$extras);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$6, reason: invalid class name */
        public class AnonymousClass6 implements java.lang.Runnable {
            final /* synthetic */ java.lang.String val$action;
            final /* synthetic */ android.support.v4.media.MediaBrowserCompat.CustomActionCallback val$callback;
            final /* synthetic */ android.os.Bundle val$extras;

            public AnonymousClass6(android.support.v4.media.MediaBrowserCompat.CustomActionCallback customActionCallback, java.lang.String str, android.os.Bundle bundle) {
                this.val$callback = customActionCallback;
                this.val$action = str;
                this.val$extras = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.val$callback.onError(this.val$action, this.val$extras, null);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplApi21$7, reason: invalid class name */
        public class AnonymousClass7 implements java.lang.Runnable {
            final /* synthetic */ java.lang.String val$action;
            final /* synthetic */ android.support.v4.media.MediaBrowserCompat.CustomActionCallback val$callback;
            final /* synthetic */ android.os.Bundle val$extras;

            public AnonymousClass7(android.support.v4.media.MediaBrowserCompat.CustomActionCallback customActionCallback, java.lang.String str, android.os.Bundle bundle) {
                this.val$callback = customActionCallback;
                this.val$action = str;
                this.val$extras = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.val$callback.onError(this.val$action, this.val$extras, null);
            }
        }

        public MediaBrowserImplApi21(android.content.Context context, android.content.ComponentName componentName, android.support.v4.media.MediaBrowserCompat.ConnectionCallback connectionCallback, android.os.Bundle bundle) {
            this.mContext = context;
            android.os.Bundle bundle2 = bundle != null ? new android.os.Bundle(bundle) : new android.os.Bundle();
            this.mRootHints = bundle2;
            bundle2.putInt(androidx.media.MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 1);
            connectionCallback.setInternalConnectionCallback(this);
            this.mBrowserFwk = new android.media.browse.MediaBrowser(context, componentName, connectionCallback.mConnectionCallbackFwk, bundle2);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void connect() {
            this.mBrowserFwk.connect();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void disconnect() {
            android.os.Messenger messenger;
            android.support.v4.media.MediaBrowserCompat.ServiceBinderWrapper serviceBinderWrapper = this.mServiceBinderWrapper;
            if (serviceBinderWrapper != null && (messenger = this.mCallbacksMessenger) != null) {
                try {
                    serviceBinderWrapper.unregisterCallbackMessenger(messenger);
                } catch (android.os.RemoteException unused) {
                }
            }
            this.mBrowserFwk.disconnect();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        @androidx.annotation.Nullable
        public android.os.Bundle getExtras() {
            return this.mBrowserFwk.getExtras();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void getItem(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull android.support.v4.media.MediaBrowserCompat.ItemCallback itemCallback) {
            if (android.text.TextUtils.isEmpty(str)) {
                throw new java.lang.IllegalArgumentException("mediaId is empty");
            }
            if (itemCallback == null) {
                throw new java.lang.IllegalArgumentException("cb is null");
            }
            if (!this.mBrowserFwk.isConnected()) {
                this.mHandler.post(new android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.AnonymousClass1(itemCallback, str));
                return;
            }
            if (this.mServiceBinderWrapper == null) {
                this.mHandler.post(new android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.AnonymousClass2(itemCallback, str));
                return;
            }
            try {
                this.mServiceBinderWrapper.getMediaItem(str, new android.support.v4.media.MediaBrowserCompat.ItemReceiver(str, itemCallback, this.mHandler), this.mCallbacksMessenger);
            } catch (android.os.RemoteException unused) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Remote error getting media item: ");
                sb.append(str);
                this.mHandler.post(new android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.AnonymousClass3(itemCallback, str));
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public android.os.Bundle getNotifyChildrenChangedOptions() {
            return this.mNotifyChildrenChangedOptions;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        @androidx.annotation.NonNull
        public java.lang.String getRoot() {
            return this.mBrowserFwk.getRoot();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public android.content.ComponentName getServiceComponent() {
            return this.mBrowserFwk.getServiceComponent();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        @androidx.annotation.NonNull
        public android.support.v4.media.session.MediaSessionCompat.Token getSessionToken() {
            if (this.mMediaSessionToken == null) {
                this.mMediaSessionToken = android.support.v4.media.session.MediaSessionCompat.Token.fromToken(this.mBrowserFwk.getSessionToken());
            }
            return this.mMediaSessionToken;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public boolean isConnected() {
            return this.mBrowserFwk.isConnected();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void onConnected() {
            try {
                android.os.Bundle extras = this.mBrowserFwk.getExtras();
                if (extras == null) {
                    return;
                }
                this.mServiceVersion = extras.getInt(androidx.media.MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 0);
                android.os.IBinder binder = androidx.core.app.BundleCompat.getBinder(extras, androidx.media.MediaBrowserProtocol.EXTRA_MESSENGER_BINDER);
                if (binder != null) {
                    this.mServiceBinderWrapper = new android.support.v4.media.MediaBrowserCompat.ServiceBinderWrapper(binder, this.mRootHints);
                    android.os.Messenger messenger = new android.os.Messenger(this.mHandler);
                    this.mCallbacksMessenger = messenger;
                    this.mHandler.setCallbacksMessenger(messenger);
                    try {
                        this.mServiceBinderWrapper.registerCallbackMessenger(this.mContext, this.mCallbacksMessenger);
                    } catch (android.os.RemoteException unused) {
                    }
                }
                android.support.v4.media.session.IMediaSession asInterface = android.support.v4.media.session.IMediaSession.Stub.asInterface(androidx.core.app.BundleCompat.getBinder(extras, androidx.media.MediaBrowserProtocol.EXTRA_SESSION_BINDER));
                if (asInterface != null) {
                    this.mMediaSessionToken = android.support.v4.media.session.MediaSessionCompat.Token.fromToken(this.mBrowserFwk.getSessionToken(), asInterface);
                }
            } catch (java.lang.IllegalStateException unused2) {
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void onConnectionFailed() {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onConnectionFailed(android.os.Messenger messenger) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void onConnectionSuspended() {
            this.mServiceBinderWrapper = null;
            this.mCallbacksMessenger = null;
            this.mMediaSessionToken = null;
            this.mHandler.setCallbacksMessenger(null);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onLoadChildren(android.os.Messenger messenger, java.lang.String str, java.util.List list, android.os.Bundle bundle, android.os.Bundle bundle2) {
            if (this.mCallbacksMessenger != messenger) {
                return;
            }
            android.support.v4.media.MediaBrowserCompat.Subscription subscription = this.mSubscriptions.get(str);
            if (subscription == null) {
                if (android.support.v4.media.MediaBrowserCompat.DEBUG) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("onLoadChildren for id that isn't subscribed id=");
                    sb.append(str);
                    return;
                }
                return;
            }
            android.support.v4.media.MediaBrowserCompat.SubscriptionCallback callback = subscription.getCallback(bundle);
            if (callback != null) {
                if (bundle == null) {
                    if (list == null) {
                        callback.onError(str);
                        return;
                    }
                    this.mNotifyChildrenChangedOptions = bundle2;
                    callback.onChildrenLoaded(str, list);
                    this.mNotifyChildrenChangedOptions = null;
                    return;
                }
                if (list == null) {
                    callback.onError(str, bundle);
                    return;
                }
                this.mNotifyChildrenChangedOptions = bundle2;
                callback.onChildrenLoaded(str, list, bundle);
                this.mNotifyChildrenChangedOptions = null;
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onServiceConnected(android.os.Messenger messenger, java.lang.String str, android.support.v4.media.session.MediaSessionCompat.Token token, android.os.Bundle bundle) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void search(@androidx.annotation.NonNull java.lang.String str, android.os.Bundle bundle, @androidx.annotation.NonNull android.support.v4.media.MediaBrowserCompat.SearchCallback searchCallback) {
            if (!isConnected()) {
                throw new java.lang.IllegalStateException("search() called while not connected");
            }
            if (this.mServiceBinderWrapper == null) {
                this.mHandler.post(new android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.AnonymousClass4(searchCallback, str, bundle));
                return;
            }
            try {
                this.mServiceBinderWrapper.search(str, bundle, new android.support.v4.media.MediaBrowserCompat.SearchResultReceiver(str, bundle, searchCallback, this.mHandler), this.mCallbacksMessenger);
            } catch (android.os.RemoteException unused) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Remote error searching items with query: ");
                sb.append(str);
                this.mHandler.post(new android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.AnonymousClass5(searchCallback, str, bundle));
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void sendCustomAction(@androidx.annotation.NonNull java.lang.String str, android.os.Bundle bundle, @androidx.annotation.Nullable android.support.v4.media.MediaBrowserCompat.CustomActionCallback customActionCallback) {
            if (!isConnected()) {
                throw new java.lang.IllegalStateException("Cannot send a custom action (" + str + ") with extras " + bundle + " because the browser is not connected to the service.");
            }
            if (this.mServiceBinderWrapper == null && customActionCallback != null) {
                this.mHandler.post(new android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.AnonymousClass6(customActionCallback, str, bundle));
            }
            try {
                this.mServiceBinderWrapper.sendCustomAction(str, bundle, new android.support.v4.media.MediaBrowserCompat.CustomActionResultReceiver(str, bundle, customActionCallback, this.mHandler), this.mCallbacksMessenger);
            } catch (android.os.RemoteException unused) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Remote error sending a custom action: action=");
                sb.append(str);
                sb.append(", extras=");
                sb.append(bundle);
                if (customActionCallback != null) {
                    this.mHandler.post(new android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21.AnonymousClass7(customActionCallback, str, bundle));
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void subscribe(@androidx.annotation.NonNull java.lang.String str, android.os.Bundle bundle, @androidx.annotation.NonNull android.support.v4.media.MediaBrowserCompat.SubscriptionCallback subscriptionCallback) {
            android.support.v4.media.MediaBrowserCompat.Subscription subscription = this.mSubscriptions.get(str);
            if (subscription == null) {
                subscription = new android.support.v4.media.MediaBrowserCompat.Subscription();
                this.mSubscriptions.put(str, subscription);
            }
            subscriptionCallback.setSubscription(subscription);
            android.os.Bundle bundle2 = bundle == null ? null : new android.os.Bundle(bundle);
            subscription.putCallback(bundle2, subscriptionCallback);
            android.support.v4.media.MediaBrowserCompat.ServiceBinderWrapper serviceBinderWrapper = this.mServiceBinderWrapper;
            if (serviceBinderWrapper == null) {
                this.mBrowserFwk.subscribe(str, subscriptionCallback.mSubscriptionCallbackFwk);
                return;
            }
            try {
                serviceBinderWrapper.addSubscription(str, subscriptionCallback.mToken, bundle2, this.mCallbacksMessenger);
            } catch (android.os.RemoteException unused) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Remote error subscribing media item: ");
                sb.append(str);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void unsubscribe(@androidx.annotation.NonNull java.lang.String str, android.support.v4.media.MediaBrowserCompat.SubscriptionCallback subscriptionCallback) {
            android.support.v4.media.MediaBrowserCompat.Subscription subscription = this.mSubscriptions.get(str);
            if (subscription == null) {
                return;
            }
            android.support.v4.media.MediaBrowserCompat.ServiceBinderWrapper serviceBinderWrapper = this.mServiceBinderWrapper;
            if (serviceBinderWrapper != null) {
                try {
                    if (subscriptionCallback == null) {
                        serviceBinderWrapper.removeSubscription(str, null, this.mCallbacksMessenger);
                    } else {
                        java.util.List<android.support.v4.media.MediaBrowserCompat.SubscriptionCallback> callbacks = subscription.getCallbacks();
                        java.util.List<android.os.Bundle> optionsList = subscription.getOptionsList();
                        for (int size = callbacks.size() - 1; size >= 0; size--) {
                            if (callbacks.get(size) == subscriptionCallback) {
                                this.mServiceBinderWrapper.removeSubscription(str, subscriptionCallback.mToken, this.mCallbacksMessenger);
                                callbacks.remove(size);
                                optionsList.remove(size);
                            }
                        }
                    }
                } catch (android.os.RemoteException unused) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("removeSubscription failed with RemoteException parentId=");
                    sb.append(str);
                }
            } else if (subscriptionCallback == null) {
                this.mBrowserFwk.unsubscribe(str);
            } else {
                java.util.List<android.support.v4.media.MediaBrowserCompat.SubscriptionCallback> callbacks2 = subscription.getCallbacks();
                java.util.List<android.os.Bundle> optionsList2 = subscription.getOptionsList();
                for (int size2 = callbacks2.size() - 1; size2 >= 0; size2--) {
                    if (callbacks2.get(size2) == subscriptionCallback) {
                        callbacks2.remove(size2);
                        optionsList2.remove(size2);
                    }
                }
                if (callbacks2.size() == 0) {
                    this.mBrowserFwk.unsubscribe(str);
                }
            }
            if (subscription.isEmpty() || subscriptionCallback == null) {
                this.mSubscriptions.remove(str);
            }
        }
    }

    @androidx.annotation.RequiresApi(23)
    public static class MediaBrowserImplApi23 extends android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21 {
        public MediaBrowserImplApi23(android.content.Context context, android.content.ComponentName componentName, android.support.v4.media.MediaBrowserCompat.ConnectionCallback connectionCallback, android.os.Bundle bundle) {
            super(context, componentName, connectionCallback, bundle);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21, android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void getItem(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull android.support.v4.media.MediaBrowserCompat.ItemCallback itemCallback) {
            if (this.mServiceBinderWrapper == null) {
                this.mBrowserFwk.getItem(str, itemCallback.mItemCallbackFwk);
            } else {
                super.getItem(str, itemCallback);
            }
        }
    }

    @androidx.annotation.RequiresApi(26)
    public static class MediaBrowserImplApi26 extends android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi23 {
        public MediaBrowserImplApi26(android.content.Context context, android.content.ComponentName componentName, android.support.v4.media.MediaBrowserCompat.ConnectionCallback connectionCallback, android.os.Bundle bundle) {
            super(context, componentName, connectionCallback, bundle);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21, android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void subscribe(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable android.os.Bundle bundle, @androidx.annotation.NonNull android.support.v4.media.MediaBrowserCompat.SubscriptionCallback subscriptionCallback) {
            if (this.mServiceBinderWrapper != null && this.mServiceVersion >= 2) {
                super.subscribe(str, bundle, subscriptionCallback);
            } else if (bundle == null) {
                this.mBrowserFwk.subscribe(str, subscriptionCallback.mSubscriptionCallbackFwk);
            } else {
                this.mBrowserFwk.subscribe(str, bundle, subscriptionCallback.mSubscriptionCallbackFwk);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21, android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void unsubscribe(@androidx.annotation.NonNull java.lang.String str, android.support.v4.media.MediaBrowserCompat.SubscriptionCallback subscriptionCallback) {
            if (this.mServiceBinderWrapper != null && this.mServiceVersion >= 2) {
                super.unsubscribe(str, subscriptionCallback);
            } else if (subscriptionCallback == null) {
                this.mBrowserFwk.unsubscribe(str);
            } else {
                this.mBrowserFwk.unsubscribe(str, subscriptionCallback.mSubscriptionCallbackFwk);
            }
        }
    }

    public static class MediaBrowserImplBase implements android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl, android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl {
        static final int CONNECT_STATE_CONNECTED = 3;
        static final int CONNECT_STATE_CONNECTING = 2;
        static final int CONNECT_STATE_DISCONNECTED = 1;
        static final int CONNECT_STATE_DISCONNECTING = 0;
        static final int CONNECT_STATE_SUSPENDED = 4;
        final android.support.v4.media.MediaBrowserCompat.ConnectionCallback mCallback;
        android.os.Messenger mCallbacksMessenger;
        final android.content.Context mContext;
        private android.os.Bundle mExtras;
        private android.support.v4.media.session.MediaSessionCompat.Token mMediaSessionToken;
        private android.os.Bundle mNotifyChildrenChangedOptions;
        final android.os.Bundle mRootHints;
        private java.lang.String mRootId;
        android.support.v4.media.MediaBrowserCompat.ServiceBinderWrapper mServiceBinderWrapper;
        final android.content.ComponentName mServiceComponent;
        android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection mServiceConnection;
        final android.support.v4.media.MediaBrowserCompat.CallbackHandler mHandler = new android.support.v4.media.MediaBrowserCompat.CallbackHandler(this);
        private final androidx.collection.ArrayMap<java.lang.String, android.support.v4.media.MediaBrowserCompat.Subscription> mSubscriptions = new androidx.collection.ArrayMap<>();
        int mState = 1;

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase mediaBrowserImplBase = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                if (mediaBrowserImplBase.mState == 0) {
                    return;
                }
                mediaBrowserImplBase.mState = 2;
                if (android.support.v4.media.MediaBrowserCompat.DEBUG && mediaBrowserImplBase.mServiceConnection != null) {
                    throw new java.lang.RuntimeException("mServiceConnection should be null. Instead it is " + android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mServiceConnection);
                }
                if (mediaBrowserImplBase.mServiceBinderWrapper != null) {
                    throw new java.lang.RuntimeException("mServiceBinderWrapper should be null. Instead it is " + android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mServiceBinderWrapper);
                }
                if (mediaBrowserImplBase.mCallbacksMessenger != null) {
                    throw new java.lang.RuntimeException("mCallbacksMessenger should be null. Instead it is " + android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mCallbacksMessenger);
                }
                android.content.Intent intent = new android.content.Intent(androidx.media.MediaBrowserServiceCompat.SERVICE_INTERFACE);
                intent.setComponent(android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mServiceComponent);
                android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase mediaBrowserImplBase2 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                mediaBrowserImplBase2.mServiceConnection = mediaBrowserImplBase2.new MediaServiceConnection();
                try {
                    android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase mediaBrowserImplBase3 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                    z = mediaBrowserImplBase3.mContext.bindService(intent, mediaBrowserImplBase3.mServiceConnection, 1);
                } catch (java.lang.Exception unused) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("Failed binding to service ");
                    sb.append(android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mServiceComponent);
                    z = false;
                }
                if (!z) {
                    android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.forceCloseConnection();
                    android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mCallback.onConnectionFailed();
                }
                if (android.support.v4.media.MediaBrowserCompat.DEBUG) {
                    android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.dump();
                }
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            public AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase mediaBrowserImplBase = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                android.os.Messenger messenger = mediaBrowserImplBase.mCallbacksMessenger;
                if (messenger != null) {
                    try {
                        mediaBrowserImplBase.mServiceBinderWrapper.disconnect(messenger);
                    } catch (android.os.RemoteException unused) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("RemoteException during connect for ");
                        sb.append(android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mServiceComponent);
                    }
                }
                android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase mediaBrowserImplBase2 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                int i = mediaBrowserImplBase2.mState;
                mediaBrowserImplBase2.forceCloseConnection();
                if (i != 0) {
                    android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mState = i;
                }
                if (android.support.v4.media.MediaBrowserCompat.DEBUG) {
                    android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.dump();
                }
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$3, reason: invalid class name */
        public class AnonymousClass3 implements java.lang.Runnable {
            final /* synthetic */ android.support.v4.media.MediaBrowserCompat.ItemCallback val$cb;
            final /* synthetic */ java.lang.String val$mediaId;

            public AnonymousClass3(android.support.v4.media.MediaBrowserCompat.ItemCallback itemCallback, java.lang.String str) {
                this.val$cb = itemCallback;
                this.val$mediaId = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.val$cb.onError(this.val$mediaId);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$4, reason: invalid class name */
        public class AnonymousClass4 implements java.lang.Runnable {
            final /* synthetic */ android.support.v4.media.MediaBrowserCompat.ItemCallback val$cb;
            final /* synthetic */ java.lang.String val$mediaId;

            public AnonymousClass4(android.support.v4.media.MediaBrowserCompat.ItemCallback itemCallback, java.lang.String str) {
                this.val$cb = itemCallback;
                this.val$mediaId = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.val$cb.onError(this.val$mediaId);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$5, reason: invalid class name */
        public class AnonymousClass5 implements java.lang.Runnable {
            final /* synthetic */ android.support.v4.media.MediaBrowserCompat.SearchCallback val$callback;
            final /* synthetic */ android.os.Bundle val$extras;
            final /* synthetic */ java.lang.String val$query;

            public AnonymousClass5(android.support.v4.media.MediaBrowserCompat.SearchCallback searchCallback, java.lang.String str, android.os.Bundle bundle) {
                this.val$callback = searchCallback;
                this.val$query = str;
                this.val$extras = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.val$callback.onError(this.val$query, this.val$extras);
            }
        }

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$6, reason: invalid class name */
        public class AnonymousClass6 implements java.lang.Runnable {
            final /* synthetic */ java.lang.String val$action;
            final /* synthetic */ android.support.v4.media.MediaBrowserCompat.CustomActionCallback val$callback;
            final /* synthetic */ android.os.Bundle val$extras;

            public AnonymousClass6(android.support.v4.media.MediaBrowserCompat.CustomActionCallback customActionCallback, java.lang.String str, android.os.Bundle bundle) {
                this.val$callback = customActionCallback;
                this.val$action = str;
                this.val$extras = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.val$callback.onError(this.val$action, this.val$extras, null);
            }
        }

        public class MediaServiceConnection implements android.content.ServiceConnection {

            /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection$1, reason: invalid class name */
            public class AnonymousClass1 implements java.lang.Runnable {
                final /* synthetic */ android.os.IBinder val$binder;
                final /* synthetic */ android.content.ComponentName val$name;

                public AnonymousClass1(android.content.ComponentName componentName, android.os.IBinder iBinder) {
                    this.val$name = componentName;
                    this.val$binder = iBinder;
                }

                @Override // java.lang.Runnable
                public void run() {
                    boolean z = android.support.v4.media.MediaBrowserCompat.DEBUG;
                    if (z) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("MediaServiceConnection.onServiceConnected name=");
                        sb.append(this.val$name);
                        sb.append(" binder=");
                        sb.append(this.val$binder);
                        android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.dump();
                    }
                    if (android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.this.isCurrent("onServiceConnected")) {
                        android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase mediaBrowserImplBase = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                        mediaBrowserImplBase.mServiceBinderWrapper = new android.support.v4.media.MediaBrowserCompat.ServiceBinderWrapper(this.val$binder, mediaBrowserImplBase.mRootHints);
                        android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mCallbacksMessenger = new android.os.Messenger(android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mHandler);
                        android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase mediaBrowserImplBase2 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                        mediaBrowserImplBase2.mHandler.setCallbacksMessenger(mediaBrowserImplBase2.mCallbacksMessenger);
                        android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mState = 2;
                        if (z) {
                            try {
                                android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.dump();
                            } catch (android.os.RemoteException unused) {
                                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                                sb2.append("RemoteException during connect for ");
                                sb2.append(android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mServiceComponent);
                                if (android.support.v4.media.MediaBrowserCompat.DEBUG) {
                                    android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.dump();
                                    return;
                                }
                                return;
                            }
                        }
                        android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase mediaBrowserImplBase3 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                        mediaBrowserImplBase3.mServiceBinderWrapper.connect(mediaBrowserImplBase3.mContext, mediaBrowserImplBase3.mCallbacksMessenger);
                    }
                }
            }

            /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaBrowserImplBase$MediaServiceConnection$2, reason: invalid class name */
            public class AnonymousClass2 implements java.lang.Runnable {
                final /* synthetic */ android.content.ComponentName val$name;

                public AnonymousClass2(android.content.ComponentName componentName) {
                    this.val$name = componentName;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (android.support.v4.media.MediaBrowserCompat.DEBUG) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("MediaServiceConnection.onServiceDisconnected name=");
                        sb.append(this.val$name);
                        sb.append(" this=");
                        sb.append(this);
                        sb.append(" mServiceConnection=");
                        sb.append(android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mServiceConnection);
                        android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.dump();
                    }
                    if (android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.this.isCurrent("onServiceDisconnected")) {
                        android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase mediaBrowserImplBase = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                        mediaBrowserImplBase.mServiceBinderWrapper = null;
                        mediaBrowserImplBase.mCallbacksMessenger = null;
                        mediaBrowserImplBase.mHandler.setCallbacksMessenger(null);
                        android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase mediaBrowserImplBase2 = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                        mediaBrowserImplBase2.mState = 4;
                        mediaBrowserImplBase2.mCallback.onConnectionSuspended();
                    }
                }
            }

            public MediaServiceConnection() {
            }

            private void postOrRun(java.lang.Runnable runnable) {
                if (java.lang.Thread.currentThread() == android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mHandler.getLooper().getThread()) {
                    runnable.run();
                } else {
                    android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mHandler.post(runnable);
                }
            }

            public boolean isCurrent(java.lang.String str) {
                int i;
                android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase mediaBrowserImplBase = android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this;
                if (mediaBrowserImplBase.mServiceConnection == this && (i = mediaBrowserImplBase.mState) != 0 && i != 1) {
                    return true;
                }
                int i2 = mediaBrowserImplBase.mState;
                if (i2 == 0 || i2 == 1) {
                    return false;
                }
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(str);
                sb.append(" for ");
                sb.append(android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mServiceComponent);
                sb.append(" with mServiceConnection=");
                sb.append(android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.this.mServiceConnection);
                sb.append(" this=");
                sb.append(this);
                return false;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
                postOrRun(new android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.AnonymousClass1(componentName, iBinder));
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(android.content.ComponentName componentName) {
                postOrRun(new android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection.AnonymousClass2(componentName));
            }
        }

        public MediaBrowserImplBase(android.content.Context context, android.content.ComponentName componentName, android.support.v4.media.MediaBrowserCompat.ConnectionCallback connectionCallback, android.os.Bundle bundle) {
            if (context == null) {
                throw new java.lang.IllegalArgumentException("context must not be null");
            }
            if (componentName == null) {
                throw new java.lang.IllegalArgumentException("service component must not be null");
            }
            if (connectionCallback == null) {
                throw new java.lang.IllegalArgumentException("connection callback must not be null");
            }
            this.mContext = context;
            this.mServiceComponent = componentName;
            this.mCallback = connectionCallback;
            this.mRootHints = bundle == null ? null : new android.os.Bundle(bundle);
        }

        private static java.lang.String getStateLabel(int i) {
            if (i == 0) {
                return "CONNECT_STATE_DISCONNECTING";
            }
            if (i == 1) {
                return "CONNECT_STATE_DISCONNECTED";
            }
            if (i == 2) {
                return "CONNECT_STATE_CONNECTING";
            }
            if (i == 3) {
                return "CONNECT_STATE_CONNECTED";
            }
            if (i == 4) {
                return "CONNECT_STATE_SUSPENDED";
            }
            return "UNKNOWN/" + i;
        }

        private boolean isCurrent(android.os.Messenger messenger, java.lang.String str) {
            int i;
            if (this.mCallbacksMessenger == messenger && (i = this.mState) != 0 && i != 1) {
                return true;
            }
            int i2 = this.mState;
            if (i2 == 0 || i2 == 1) {
                return false;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(str);
            sb.append(" for ");
            sb.append(this.mServiceComponent);
            sb.append(" with mCallbacksMessenger=");
            sb.append(this.mCallbacksMessenger);
            sb.append(" this=");
            sb.append(this);
            return false;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void connect() {
            int i = this.mState;
            if (i == 0 || i == 1) {
                this.mState = 2;
                this.mHandler.post(new android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.AnonymousClass1());
            } else {
                throw new java.lang.IllegalStateException("connect() called while neigther disconnecting nor disconnected (state=" + getStateLabel(this.mState) + ")");
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void disconnect() {
            this.mState = 0;
            this.mHandler.post(new android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.AnonymousClass2());
        }

        public void dump() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("  mServiceComponent=");
            sb.append(this.mServiceComponent);
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("  mCallback=");
            sb2.append(this.mCallback);
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
            sb3.append("  mRootHints=");
            sb3.append(this.mRootHints);
            java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
            sb4.append("  mState=");
            sb4.append(getStateLabel(this.mState));
            java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
            sb5.append("  mServiceConnection=");
            sb5.append(this.mServiceConnection);
            java.lang.StringBuilder sb6 = new java.lang.StringBuilder();
            sb6.append("  mServiceBinderWrapper=");
            sb6.append(this.mServiceBinderWrapper);
            java.lang.StringBuilder sb7 = new java.lang.StringBuilder();
            sb7.append("  mCallbacksMessenger=");
            sb7.append(this.mCallbacksMessenger);
            java.lang.StringBuilder sb8 = new java.lang.StringBuilder();
            sb8.append("  mRootId=");
            sb8.append(this.mRootId);
            java.lang.StringBuilder sb9 = new java.lang.StringBuilder();
            sb9.append("  mMediaSessionToken=");
            sb9.append(this.mMediaSessionToken);
        }

        public void forceCloseConnection() {
            android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.MediaServiceConnection mediaServiceConnection = this.mServiceConnection;
            if (mediaServiceConnection != null) {
                this.mContext.unbindService(mediaServiceConnection);
            }
            this.mState = 1;
            this.mServiceConnection = null;
            this.mServiceBinderWrapper = null;
            this.mCallbacksMessenger = null;
            this.mHandler.setCallbacksMessenger(null);
            this.mRootId = null;
            this.mMediaSessionToken = null;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        @androidx.annotation.Nullable
        public android.os.Bundle getExtras() {
            if (isConnected()) {
                return this.mExtras;
            }
            throw new java.lang.IllegalStateException("getExtras() called while not connected (state=" + getStateLabel(this.mState) + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void getItem(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull android.support.v4.media.MediaBrowserCompat.ItemCallback itemCallback) {
            if (android.text.TextUtils.isEmpty(str)) {
                throw new java.lang.IllegalArgumentException("mediaId is empty");
            }
            if (itemCallback == null) {
                throw new java.lang.IllegalArgumentException("cb is null");
            }
            if (!isConnected()) {
                this.mHandler.post(new android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.AnonymousClass3(itemCallback, str));
                return;
            }
            try {
                this.mServiceBinderWrapper.getMediaItem(str, new android.support.v4.media.MediaBrowserCompat.ItemReceiver(str, itemCallback, this.mHandler), this.mCallbacksMessenger);
            } catch (android.os.RemoteException unused) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Remote error getting media item: ");
                sb.append(str);
                this.mHandler.post(new android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.AnonymousClass4(itemCallback, str));
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public android.os.Bundle getNotifyChildrenChangedOptions() {
            return this.mNotifyChildrenChangedOptions;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        @androidx.annotation.NonNull
        public java.lang.String getRoot() {
            if (isConnected()) {
                return this.mRootId;
            }
            throw new java.lang.IllegalStateException("getRoot() called while not connected(state=" + getStateLabel(this.mState) + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        @androidx.annotation.NonNull
        public android.content.ComponentName getServiceComponent() {
            if (isConnected()) {
                return this.mServiceComponent;
            }
            throw new java.lang.IllegalStateException("getServiceComponent() called while not connected (state=" + this.mState + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        @androidx.annotation.NonNull
        public android.support.v4.media.session.MediaSessionCompat.Token getSessionToken() {
            if (isConnected()) {
                return this.mMediaSessionToken;
            }
            throw new java.lang.IllegalStateException("getSessionToken() called while not connected(state=" + this.mState + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public boolean isConnected() {
            return this.mState == 3;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onConnectionFailed(android.os.Messenger messenger) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("onConnectFailed for ");
            sb.append(this.mServiceComponent);
            if (isCurrent(messenger, "onConnectFailed")) {
                if (this.mState == 2) {
                    forceCloseConnection();
                    this.mCallback.onConnectionFailed();
                } else {
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append("onConnect from service while mState=");
                    sb2.append(getStateLabel(this.mState));
                    sb2.append("... ignoring");
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onLoadChildren(android.os.Messenger messenger, java.lang.String str, java.util.List list, android.os.Bundle bundle, android.os.Bundle bundle2) {
            if (isCurrent(messenger, "onLoadChildren")) {
                boolean z = android.support.v4.media.MediaBrowserCompat.DEBUG;
                if (z) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("onLoadChildren for ");
                    sb.append(this.mServiceComponent);
                    sb.append(" id=");
                    sb.append(str);
                }
                android.support.v4.media.MediaBrowserCompat.Subscription subscription = this.mSubscriptions.get(str);
                if (subscription == null) {
                    if (z) {
                        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                        sb2.append("onLoadChildren for id that isn't subscribed id=");
                        sb2.append(str);
                        return;
                    }
                    return;
                }
                android.support.v4.media.MediaBrowserCompat.SubscriptionCallback callback = subscription.getCallback(bundle);
                if (callback != null) {
                    if (bundle == null) {
                        if (list == null) {
                            callback.onError(str);
                            return;
                        }
                        this.mNotifyChildrenChangedOptions = bundle2;
                        callback.onChildrenLoaded(str, list);
                        this.mNotifyChildrenChangedOptions = null;
                        return;
                    }
                    if (list == null) {
                        callback.onError(str, bundle);
                        return;
                    }
                    this.mNotifyChildrenChangedOptions = bundle2;
                    callback.onChildrenLoaded(str, list, bundle);
                    this.mNotifyChildrenChangedOptions = null;
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onServiceConnected(android.os.Messenger messenger, java.lang.String str, android.support.v4.media.session.MediaSessionCompat.Token token, android.os.Bundle bundle) {
            if (isCurrent(messenger, "onConnect")) {
                if (this.mState != 2) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("onConnect from service while mState=");
                    sb.append(getStateLabel(this.mState));
                    sb.append("... ignoring");
                    return;
                }
                this.mRootId = str;
                this.mMediaSessionToken = token;
                this.mExtras = bundle;
                this.mState = 3;
                if (android.support.v4.media.MediaBrowserCompat.DEBUG) {
                    dump();
                }
                this.mCallback.onConnected();
                try {
                    for (java.util.Map.Entry<java.lang.String, android.support.v4.media.MediaBrowserCompat.Subscription> entry : this.mSubscriptions.entrySet()) {
                        java.lang.String key = entry.getKey();
                        android.support.v4.media.MediaBrowserCompat.Subscription value = entry.getValue();
                        java.util.List<android.support.v4.media.MediaBrowserCompat.SubscriptionCallback> callbacks = value.getCallbacks();
                        java.util.List<android.os.Bundle> optionsList = value.getOptionsList();
                        for (int i = 0; i < callbacks.size(); i++) {
                            this.mServiceBinderWrapper.addSubscription(key, callbacks.get(i).mToken, optionsList.get(i), this.mCallbacksMessenger);
                        }
                    }
                } catch (android.os.RemoteException unused) {
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void search(@androidx.annotation.NonNull java.lang.String str, android.os.Bundle bundle, @androidx.annotation.NonNull android.support.v4.media.MediaBrowserCompat.SearchCallback searchCallback) {
            if (!isConnected()) {
                throw new java.lang.IllegalStateException("search() called while not connected (state=" + getStateLabel(this.mState) + ")");
            }
            try {
                this.mServiceBinderWrapper.search(str, bundle, new android.support.v4.media.MediaBrowserCompat.SearchResultReceiver(str, bundle, searchCallback, this.mHandler), this.mCallbacksMessenger);
            } catch (android.os.RemoteException unused) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Remote error searching items with query: ");
                sb.append(str);
                this.mHandler.post(new android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.AnonymousClass5(searchCallback, str, bundle));
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void sendCustomAction(@androidx.annotation.NonNull java.lang.String str, android.os.Bundle bundle, @androidx.annotation.Nullable android.support.v4.media.MediaBrowserCompat.CustomActionCallback customActionCallback) {
            if (!isConnected()) {
                throw new java.lang.IllegalStateException("Cannot send a custom action (" + str + ") with extras " + bundle + " because the browser is not connected to the service.");
            }
            try {
                this.mServiceBinderWrapper.sendCustomAction(str, bundle, new android.support.v4.media.MediaBrowserCompat.CustomActionResultReceiver(str, bundle, customActionCallback, this.mHandler), this.mCallbacksMessenger);
            } catch (android.os.RemoteException unused) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Remote error sending a custom action: action=");
                sb.append(str);
                sb.append(", extras=");
                sb.append(bundle);
                if (customActionCallback != null) {
                    this.mHandler.post(new android.support.v4.media.MediaBrowserCompat.MediaBrowserImplBase.AnonymousClass6(customActionCallback, str, bundle));
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void subscribe(@androidx.annotation.NonNull java.lang.String str, android.os.Bundle bundle, @androidx.annotation.NonNull android.support.v4.media.MediaBrowserCompat.SubscriptionCallback subscriptionCallback) {
            android.support.v4.media.MediaBrowserCompat.Subscription subscription = this.mSubscriptions.get(str);
            if (subscription == null) {
                subscription = new android.support.v4.media.MediaBrowserCompat.Subscription();
                this.mSubscriptions.put(str, subscription);
            }
            android.os.Bundle bundle2 = bundle == null ? null : new android.os.Bundle(bundle);
            subscription.putCallback(bundle2, subscriptionCallback);
            if (isConnected()) {
                try {
                    this.mServiceBinderWrapper.addSubscription(str, subscriptionCallback.mToken, bundle2, this.mCallbacksMessenger);
                } catch (android.os.RemoteException unused) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("addSubscription failed with RemoteException parentId=");
                    sb.append(str);
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void unsubscribe(@androidx.annotation.NonNull java.lang.String str, android.support.v4.media.MediaBrowserCompat.SubscriptionCallback subscriptionCallback) {
            android.support.v4.media.MediaBrowserCompat.Subscription subscription = this.mSubscriptions.get(str);
            if (subscription == null) {
                return;
            }
            try {
                if (subscriptionCallback != null) {
                    java.util.List<android.support.v4.media.MediaBrowserCompat.SubscriptionCallback> callbacks = subscription.getCallbacks();
                    java.util.List<android.os.Bundle> optionsList = subscription.getOptionsList();
                    for (int size = callbacks.size() - 1; size >= 0; size--) {
                        if (callbacks.get(size) == subscriptionCallback) {
                            if (isConnected()) {
                                this.mServiceBinderWrapper.removeSubscription(str, subscriptionCallback.mToken, this.mCallbacksMessenger);
                            }
                            callbacks.remove(size);
                            optionsList.remove(size);
                        }
                    }
                } else if (isConnected()) {
                    this.mServiceBinderWrapper.removeSubscription(str, null, this.mCallbacksMessenger);
                }
            } catch (android.os.RemoteException unused) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("removeSubscription failed with RemoteException parentId=");
                sb.append(str);
            }
            if (subscription.isEmpty() || subscriptionCallback == null) {
                this.mSubscriptions.remove(str);
            }
        }
    }

    public interface MediaBrowserServiceCallbackImpl {
        void onConnectionFailed(android.os.Messenger messenger);

        void onLoadChildren(android.os.Messenger messenger, java.lang.String str, java.util.List list, android.os.Bundle bundle, android.os.Bundle bundle2);

        void onServiceConnected(android.os.Messenger messenger, java.lang.String str, android.support.v4.media.session.MediaSessionCompat.Token token, android.os.Bundle bundle);
    }

    public static class MediaItem implements android.os.Parcelable {
        public static final android.os.Parcelable.Creator<android.support.v4.media.MediaBrowserCompat.MediaItem> CREATOR = new android.support.v4.media.MediaBrowserCompat.MediaItem.AnonymousClass1();
        public static final int FLAG_BROWSABLE = 1;
        public static final int FLAG_PLAYABLE = 2;
        private final android.support.v4.media.MediaDescriptionCompat mDescription;
        private final int mFlags;

        /* renamed from: android.support.v4.media.MediaBrowserCompat$MediaItem$1, reason: invalid class name */
        public static class AnonymousClass1 implements android.os.Parcelable.Creator<android.support.v4.media.MediaBrowserCompat.MediaItem> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public android.support.v4.media.MediaBrowserCompat.MediaItem createFromParcel(android.os.Parcel parcel) {
                return new android.support.v4.media.MediaBrowserCompat.MediaItem(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public android.support.v4.media.MediaBrowserCompat.MediaItem[] newArray(int i) {
                return new android.support.v4.media.MediaBrowserCompat.MediaItem[i];
            }
        }

        @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.SOURCE)
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
        public @interface Flags {
        }

        public MediaItem(android.os.Parcel parcel) {
            this.mFlags = parcel.readInt();
            this.mDescription = android.support.v4.media.MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }

        public MediaItem(@androidx.annotation.NonNull android.support.v4.media.MediaDescriptionCompat mediaDescriptionCompat, int i) {
            if (mediaDescriptionCompat == null) {
                throw new java.lang.IllegalArgumentException("description cannot be null");
            }
            if (android.text.TextUtils.isEmpty(mediaDescriptionCompat.getMediaId())) {
                throw new java.lang.IllegalArgumentException("description must have a non-empty media id");
            }
            this.mFlags = i;
            this.mDescription = mediaDescriptionCompat;
        }

        public static android.support.v4.media.MediaBrowserCompat.MediaItem fromMediaItem(java.lang.Object obj) {
            if (obj == null) {
                return null;
            }
            android.media.browse.MediaBrowser.MediaItem mediaItem = (android.media.browse.MediaBrowser.MediaItem) obj;
            return new android.support.v4.media.MediaBrowserCompat.MediaItem(android.support.v4.media.MediaDescriptionCompat.fromMediaDescription(mediaItem.getDescription()), mediaItem.getFlags());
        }

        public static java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem> fromMediaItemList(java.util.List<?> list) {
            if (list == null) {
                return null;
            }
            java.util.ArrayList arrayList = new java.util.ArrayList(list.size());
            java.util.Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(fromMediaItem(it.next()));
            }
            return arrayList;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @androidx.annotation.NonNull
        public android.support.v4.media.MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        public int getFlags() {
            return this.mFlags;
        }

        @androidx.annotation.Nullable
        public java.lang.String getMediaId() {
            return this.mDescription.getMediaId();
        }

        public boolean isBrowsable() {
            return (this.mFlags & 1) != 0;
        }

        public boolean isPlayable() {
            return (this.mFlags & 2) != 0;
        }

        public java.lang.String toString() {
            return "MediaItem{mFlags=" + this.mFlags + ", mDescription=" + this.mDescription + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(android.os.Parcel parcel, int i) {
            parcel.writeInt(this.mFlags);
            this.mDescription.writeToParcel(parcel, i);
        }
    }

    public static abstract class SearchCallback {
        public void onError(@androidx.annotation.NonNull java.lang.String str, android.os.Bundle bundle) {
        }

        public void onSearchResult(@androidx.annotation.NonNull java.lang.String str, android.os.Bundle bundle, @androidx.annotation.NonNull java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem> list) {
        }
    }

    public static class SearchResultReceiver extends android.support.v4.os.ResultReceiver {
        private final android.support.v4.media.MediaBrowserCompat.SearchCallback mCallback;
        private final android.os.Bundle mExtras;
        private final java.lang.String mQuery;

        public SearchResultReceiver(java.lang.String str, android.os.Bundle bundle, android.support.v4.media.MediaBrowserCompat.SearchCallback searchCallback, android.os.Handler handler) {
            super(handler);
            this.mQuery = str;
            this.mExtras = bundle;
            this.mCallback = searchCallback;
        }

        @Override // android.support.v4.os.ResultReceiver
        public void onReceiveResult(int i, android.os.Bundle bundle) {
            java.util.ArrayList arrayList;
            android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(bundle);
            if (i != 0 || bundle == null || !bundle.containsKey(androidx.media.MediaBrowserServiceCompat.KEY_SEARCH_RESULTS)) {
                this.mCallback.onError(this.mQuery, this.mExtras);
                return;
            }
            android.os.Parcelable[] parcelableArray = bundle.getParcelableArray(androidx.media.MediaBrowserServiceCompat.KEY_SEARCH_RESULTS);
            if (parcelableArray != null) {
                arrayList = new java.util.ArrayList();
                for (android.os.Parcelable parcelable : parcelableArray) {
                    arrayList.add((android.support.v4.media.MediaBrowserCompat.MediaItem) parcelable);
                }
            } else {
                arrayList = null;
            }
            this.mCallback.onSearchResult(this.mQuery, this.mExtras, arrayList);
        }
    }

    public static class ServiceBinderWrapper {
        private android.os.Messenger mMessenger;
        private android.os.Bundle mRootHints;

        public ServiceBinderWrapper(android.os.IBinder iBinder, android.os.Bundle bundle) {
            this.mMessenger = new android.os.Messenger(iBinder);
            this.mRootHints = bundle;
        }

        private void sendRequest(int i, android.os.Bundle bundle, android.os.Messenger messenger) throws android.os.RemoteException {
            android.os.Message obtain = android.os.Message.obtain();
            obtain.what = i;
            obtain.arg1 = 1;
            obtain.setData(bundle);
            obtain.replyTo = messenger;
            this.mMessenger.send(obtain);
        }

        public void addSubscription(java.lang.String str, android.os.IBinder iBinder, android.os.Bundle bundle, android.os.Messenger messenger) throws android.os.RemoteException {
            android.os.Bundle bundle2 = new android.os.Bundle();
            bundle2.putString(androidx.media.MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            androidx.core.app.BundleCompat.putBinder(bundle2, androidx.media.MediaBrowserProtocol.DATA_CALLBACK_TOKEN, iBinder);
            bundle2.putBundle(androidx.media.MediaBrowserProtocol.DATA_OPTIONS, bundle);
            sendRequest(3, bundle2, messenger);
        }

        public void connect(android.content.Context context, android.os.Messenger messenger) throws android.os.RemoteException {
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString(androidx.media.MediaBrowserProtocol.DATA_PACKAGE_NAME, context.getPackageName());
            bundle.putBundle(androidx.media.MediaBrowserProtocol.DATA_ROOT_HINTS, this.mRootHints);
            sendRequest(1, bundle, messenger);
        }

        public void disconnect(android.os.Messenger messenger) throws android.os.RemoteException {
            sendRequest(2, null, messenger);
        }

        public void getMediaItem(java.lang.String str, android.support.v4.os.ResultReceiver resultReceiver, android.os.Messenger messenger) throws android.os.RemoteException {
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString(androidx.media.MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            bundle.putParcelable(androidx.media.MediaBrowserProtocol.DATA_RESULT_RECEIVER, resultReceiver);
            sendRequest(5, bundle, messenger);
        }

        public void registerCallbackMessenger(android.content.Context context, android.os.Messenger messenger) throws android.os.RemoteException {
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString(androidx.media.MediaBrowserProtocol.DATA_PACKAGE_NAME, context.getPackageName());
            bundle.putBundle(androidx.media.MediaBrowserProtocol.DATA_ROOT_HINTS, this.mRootHints);
            sendRequest(6, bundle, messenger);
        }

        public void removeSubscription(java.lang.String str, android.os.IBinder iBinder, android.os.Messenger messenger) throws android.os.RemoteException {
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString(androidx.media.MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            androidx.core.app.BundleCompat.putBinder(bundle, androidx.media.MediaBrowserProtocol.DATA_CALLBACK_TOKEN, iBinder);
            sendRequest(4, bundle, messenger);
        }

        public void search(java.lang.String str, android.os.Bundle bundle, android.support.v4.os.ResultReceiver resultReceiver, android.os.Messenger messenger) throws android.os.RemoteException {
            android.os.Bundle bundle2 = new android.os.Bundle();
            bundle2.putString(androidx.media.MediaBrowserProtocol.DATA_SEARCH_QUERY, str);
            bundle2.putBundle(androidx.media.MediaBrowserProtocol.DATA_SEARCH_EXTRAS, bundle);
            bundle2.putParcelable(androidx.media.MediaBrowserProtocol.DATA_RESULT_RECEIVER, resultReceiver);
            sendRequest(8, bundle2, messenger);
        }

        public void sendCustomAction(java.lang.String str, android.os.Bundle bundle, android.support.v4.os.ResultReceiver resultReceiver, android.os.Messenger messenger) throws android.os.RemoteException {
            android.os.Bundle bundle2 = new android.os.Bundle();
            bundle2.putString(androidx.media.MediaBrowserProtocol.DATA_CUSTOM_ACTION, str);
            bundle2.putBundle(androidx.media.MediaBrowserProtocol.DATA_CUSTOM_ACTION_EXTRAS, bundle);
            bundle2.putParcelable(androidx.media.MediaBrowserProtocol.DATA_RESULT_RECEIVER, resultReceiver);
            sendRequest(9, bundle2, messenger);
        }

        public void unregisterCallbackMessenger(android.os.Messenger messenger) throws android.os.RemoteException {
            sendRequest(7, null, messenger);
        }
    }

    public static class Subscription {
        private final java.util.List<android.support.v4.media.MediaBrowserCompat.SubscriptionCallback> mCallbacks = new java.util.ArrayList();
        private final java.util.List<android.os.Bundle> mOptionsList = new java.util.ArrayList();

        public android.support.v4.media.MediaBrowserCompat.SubscriptionCallback getCallback(android.os.Bundle bundle) {
            for (int i = 0; i < this.mOptionsList.size(); i++) {
                if (androidx.media.MediaBrowserCompatUtils.areSameOptions(this.mOptionsList.get(i), bundle)) {
                    return this.mCallbacks.get(i);
                }
            }
            return null;
        }

        public java.util.List<android.support.v4.media.MediaBrowserCompat.SubscriptionCallback> getCallbacks() {
            return this.mCallbacks;
        }

        public java.util.List<android.os.Bundle> getOptionsList() {
            return this.mOptionsList;
        }

        public boolean isEmpty() {
            return this.mCallbacks.isEmpty();
        }

        public void putCallback(android.os.Bundle bundle, android.support.v4.media.MediaBrowserCompat.SubscriptionCallback subscriptionCallback) {
            for (int i = 0; i < this.mOptionsList.size(); i++) {
                if (androidx.media.MediaBrowserCompatUtils.areSameOptions(this.mOptionsList.get(i), bundle)) {
                    this.mCallbacks.set(i, subscriptionCallback);
                    return;
                }
            }
            this.mCallbacks.add(subscriptionCallback);
            this.mOptionsList.add(bundle);
        }
    }

    public static abstract class SubscriptionCallback {
        final android.media.browse.MediaBrowser.SubscriptionCallback mSubscriptionCallbackFwk;
        java.lang.ref.WeakReference<android.support.v4.media.MediaBrowserCompat.Subscription> mSubscriptionRef;
        final android.os.IBinder mToken = new android.os.Binder();

        @androidx.annotation.RequiresApi(21)
        public class SubscriptionCallbackApi21 extends android.media.browse.MediaBrowser.SubscriptionCallback {
            public SubscriptionCallbackApi21() {
            }

            public java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem> applyOptions(java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem> list, android.os.Bundle bundle) {
                if (list == null) {
                    return null;
                }
                int i = bundle.getInt(android.support.v4.media.MediaBrowserCompat.EXTRA_PAGE, -1);
                int i2 = bundle.getInt(android.support.v4.media.MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
                if (i == -1 && i2 == -1) {
                    return list;
                }
                int i3 = i2 * i;
                int i4 = i3 + i2;
                if (i < 0 || i2 < 1 || i3 >= list.size()) {
                    return java.util.Collections.emptyList();
                }
                if (i4 > list.size()) {
                    i4 = list.size();
                }
                return list.subList(i3, i4);
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onChildrenLoaded(@androidx.annotation.NonNull java.lang.String str, java.util.List<android.media.browse.MediaBrowser.MediaItem> list) {
                java.lang.ref.WeakReference<android.support.v4.media.MediaBrowserCompat.Subscription> weakReference = android.support.v4.media.MediaBrowserCompat.SubscriptionCallback.this.mSubscriptionRef;
                android.support.v4.media.MediaBrowserCompat.Subscription subscription = weakReference == null ? null : weakReference.get();
                if (subscription == null) {
                    android.support.v4.media.MediaBrowserCompat.SubscriptionCallback.this.onChildrenLoaded(str, android.support.v4.media.MediaBrowserCompat.MediaItem.fromMediaItemList(list));
                    return;
                }
                java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem> fromMediaItemList = android.support.v4.media.MediaBrowserCompat.MediaItem.fromMediaItemList(list);
                java.util.List<android.support.v4.media.MediaBrowserCompat.SubscriptionCallback> callbacks = subscription.getCallbacks();
                java.util.List<android.os.Bundle> optionsList = subscription.getOptionsList();
                for (int i = 0; i < callbacks.size(); i++) {
                    android.os.Bundle bundle = optionsList.get(i);
                    if (bundle == null) {
                        android.support.v4.media.MediaBrowserCompat.SubscriptionCallback.this.onChildrenLoaded(str, fromMediaItemList);
                    } else {
                        android.support.v4.media.MediaBrowserCompat.SubscriptionCallback.this.onChildrenLoaded(str, applyOptions(fromMediaItemList, bundle), bundle);
                    }
                }
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onError(@androidx.annotation.NonNull java.lang.String str) {
                android.support.v4.media.MediaBrowserCompat.SubscriptionCallback.this.onError(str);
            }
        }

        @androidx.annotation.RequiresApi(26)
        public class SubscriptionCallbackApi26 extends android.support.v4.media.MediaBrowserCompat.SubscriptionCallback.SubscriptionCallbackApi21 {
            public SubscriptionCallbackApi26() {
                super();
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onChildrenLoaded(@androidx.annotation.NonNull java.lang.String str, java.util.List<android.media.browse.MediaBrowser.MediaItem> list, @androidx.annotation.NonNull android.os.Bundle bundle) {
                android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(bundle);
                android.support.v4.media.MediaBrowserCompat.SubscriptionCallback.this.onChildrenLoaded(str, android.support.v4.media.MediaBrowserCompat.MediaItem.fromMediaItemList(list), bundle);
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onError(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull android.os.Bundle bundle) {
                android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(bundle);
                android.support.v4.media.MediaBrowserCompat.SubscriptionCallback.this.onError(str, bundle);
            }
        }

        public SubscriptionCallback() {
            if (android.os.Build.VERSION.SDK_INT >= 26) {
                this.mSubscriptionCallbackFwk = new android.support.v4.media.MediaBrowserCompat.SubscriptionCallback.SubscriptionCallbackApi26();
            } else {
                this.mSubscriptionCallbackFwk = new android.support.v4.media.MediaBrowserCompat.SubscriptionCallback.SubscriptionCallbackApi21();
            }
        }

        public void onChildrenLoaded(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem> list) {
        }

        public void onChildrenLoaded(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem> list, @androidx.annotation.NonNull android.os.Bundle bundle) {
        }

        public void onError(@androidx.annotation.NonNull java.lang.String str) {
        }

        public void onError(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull android.os.Bundle bundle) {
        }

        public void setSubscription(android.support.v4.media.MediaBrowserCompat.Subscription subscription) {
            this.mSubscriptionRef = new java.lang.ref.WeakReference<>(subscription);
        }
    }

    public MediaBrowserCompat(android.content.Context context, android.content.ComponentName componentName, android.support.v4.media.MediaBrowserCompat.ConnectionCallback connectionCallback, android.os.Bundle bundle) {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 26) {
            this.mImpl = new android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi26(context, componentName, connectionCallback, bundle);
        } else if (i >= 23) {
            this.mImpl = new android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi23(context, componentName, connectionCallback, bundle);
        } else {
            this.mImpl = new android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21(context, componentName, connectionCallback, bundle);
        }
    }

    public void connect() {
        this.mImpl.connect();
    }

    public void disconnect() {
        this.mImpl.disconnect();
    }

    @androidx.annotation.Nullable
    public android.os.Bundle getExtras() {
        return this.mImpl.getExtras();
    }

    public void getItem(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull android.support.v4.media.MediaBrowserCompat.ItemCallback itemCallback) {
        this.mImpl.getItem(str, itemCallback);
    }

    @androidx.annotation.Nullable
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public android.os.Bundle getNotifyChildrenChangedOptions() {
        return this.mImpl.getNotifyChildrenChangedOptions();
    }

    @androidx.annotation.NonNull
    public java.lang.String getRoot() {
        return this.mImpl.getRoot();
    }

    @androidx.annotation.NonNull
    public android.content.ComponentName getServiceComponent() {
        return this.mImpl.getServiceComponent();
    }

    @androidx.annotation.NonNull
    public android.support.v4.media.session.MediaSessionCompat.Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }

    public boolean isConnected() {
        return this.mImpl.isConnected();
    }

    public void search(@androidx.annotation.NonNull java.lang.String str, android.os.Bundle bundle, @androidx.annotation.NonNull android.support.v4.media.MediaBrowserCompat.SearchCallback searchCallback) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException("query cannot be empty");
        }
        if (searchCallback == null) {
            throw new java.lang.IllegalArgumentException("callback cannot be null");
        }
        this.mImpl.search(str, bundle, searchCallback);
    }

    public void sendCustomAction(@androidx.annotation.NonNull java.lang.String str, android.os.Bundle bundle, @androidx.annotation.Nullable android.support.v4.media.MediaBrowserCompat.CustomActionCallback customActionCallback) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException("action cannot be empty");
        }
        this.mImpl.sendCustomAction(str, bundle, customActionCallback);
    }

    public void subscribe(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull android.os.Bundle bundle, @androidx.annotation.NonNull android.support.v4.media.MediaBrowserCompat.SubscriptionCallback subscriptionCallback) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException("parentId is empty");
        }
        if (subscriptionCallback == null) {
            throw new java.lang.IllegalArgumentException("callback is null");
        }
        if (bundle == null) {
            throw new java.lang.IllegalArgumentException("options are null");
        }
        this.mImpl.subscribe(str, bundle, subscriptionCallback);
    }

    public void subscribe(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull android.support.v4.media.MediaBrowserCompat.SubscriptionCallback subscriptionCallback) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException("parentId is empty");
        }
        if (subscriptionCallback == null) {
            throw new java.lang.IllegalArgumentException("callback is null");
        }
        this.mImpl.subscribe(str, null, subscriptionCallback);
    }

    public void unsubscribe(@androidx.annotation.NonNull java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException("parentId is empty");
        }
        this.mImpl.unsubscribe(str, null);
    }

    public void unsubscribe(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull android.support.v4.media.MediaBrowserCompat.SubscriptionCallback subscriptionCallback) {
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.lang.IllegalArgumentException("parentId is empty");
        }
        if (subscriptionCallback == null) {
            throw new java.lang.IllegalArgumentException("callback is null");
        }
        this.mImpl.unsubscribe(str, subscriptionCallback);
    }
}
