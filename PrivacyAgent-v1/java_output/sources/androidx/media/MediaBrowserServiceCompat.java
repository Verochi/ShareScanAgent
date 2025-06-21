package androidx.media;

/* loaded from: classes.dex */
public abstract class MediaBrowserServiceCompat extends android.app.Service {
    private static final float EPSILON = 1.0E-5f;

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public static final java.lang.String KEY_MEDIA_ITEM = "media_item";

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public static final java.lang.String KEY_SEARCH_RESULTS = "search_results";

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public static final int RESULT_ERROR = -1;
    static final int RESULT_FLAG_ON_LOAD_ITEM_NOT_IMPLEMENTED = 2;
    static final int RESULT_FLAG_ON_SEARCH_NOT_IMPLEMENTED = 4;
    static final int RESULT_FLAG_OPTION_NOT_HANDLED = 1;

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public static final int RESULT_OK = 0;

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public static final int RESULT_PROGRESS_UPDATE = 1;
    public static final java.lang.String SERVICE_INTERFACE = "android.media.browse.MediaBrowserService";
    androidx.media.MediaBrowserServiceCompat.ConnectionRecord mCurConnection;
    private androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl mImpl;
    android.support.v4.media.session.MediaSessionCompat.Token mSession;
    static final java.lang.String TAG = "MBServiceCompat";
    static final boolean DEBUG = android.util.Log.isLoggable(TAG, 3);
    final androidx.collection.ArrayMap<android.os.IBinder, androidx.media.MediaBrowserServiceCompat.ConnectionRecord> mConnections = new androidx.collection.ArrayMap<>();
    final androidx.media.MediaBrowserServiceCompat.ServiceHandler mHandler = new androidx.media.MediaBrowserServiceCompat.ServiceHandler();

    /* renamed from: androidx.media.MediaBrowserServiceCompat$1, reason: invalid class name */
    public class AnonymousClass1 extends androidx.media.MediaBrowserServiceCompat.Result<java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem>> {
        final /* synthetic */ androidx.media.MediaBrowserServiceCompat.ConnectionRecord val$connection;
        final /* synthetic */ android.os.Bundle val$notifyChildrenChangedOptions;
        final /* synthetic */ java.lang.String val$parentId;
        final /* synthetic */ android.os.Bundle val$subscribeOptions;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(java.lang.Object obj, androidx.media.MediaBrowserServiceCompat.ConnectionRecord connectionRecord, java.lang.String str, android.os.Bundle bundle, android.os.Bundle bundle2) {
            super(obj);
            this.val$connection = connectionRecord;
            this.val$parentId = str;
            this.val$subscribeOptions = bundle;
            this.val$notifyChildrenChangedOptions = bundle2;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.Result
        public void onResultSent(java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem> list) {
            if (androidx.media.MediaBrowserServiceCompat.this.mConnections.get(this.val$connection.callbacks.asBinder()) != this.val$connection) {
                if (androidx.media.MediaBrowserServiceCompat.DEBUG) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("Not sending onLoadChildren result for connection that has been disconnected. pkg=");
                    sb.append(this.val$connection.pkg);
                    sb.append(" id=");
                    sb.append(this.val$parentId);
                    return;
                }
                return;
            }
            if ((getFlags() & 1) != 0) {
                list = androidx.media.MediaBrowserServiceCompat.this.applyOptions(list, this.val$subscribeOptions);
            }
            try {
                this.val$connection.callbacks.onLoadChildren(this.val$parentId, list, this.val$subscribeOptions, this.val$notifyChildrenChangedOptions);
            } catch (android.os.RemoteException unused) {
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append("Calling onLoadChildren() failed for id=");
                sb2.append(this.val$parentId);
                sb2.append(" package=");
                sb2.append(this.val$connection.pkg);
            }
        }
    }

    /* renamed from: androidx.media.MediaBrowserServiceCompat$2, reason: invalid class name */
    public class AnonymousClass2 extends androidx.media.MediaBrowserServiceCompat.Result<android.support.v4.media.MediaBrowserCompat.MediaItem> {
        final /* synthetic */ android.support.v4.os.ResultReceiver val$receiver;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(java.lang.Object obj, android.support.v4.os.ResultReceiver resultReceiver) {
            super(obj);
            this.val$receiver = resultReceiver;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.Result
        public void onResultSent(android.support.v4.media.MediaBrowserCompat.MediaItem mediaItem) {
            if ((getFlags() & 2) != 0) {
                this.val$receiver.send(-1, null);
                return;
            }
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putParcelable(androidx.media.MediaBrowserServiceCompat.KEY_MEDIA_ITEM, mediaItem);
            this.val$receiver.send(0, bundle);
        }
    }

    /* renamed from: androidx.media.MediaBrowserServiceCompat$3, reason: invalid class name */
    public class AnonymousClass3 extends androidx.media.MediaBrowserServiceCompat.Result<java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem>> {
        final /* synthetic */ android.support.v4.os.ResultReceiver val$receiver;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(java.lang.Object obj, android.support.v4.os.ResultReceiver resultReceiver) {
            super(obj);
            this.val$receiver = resultReceiver;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.Result
        public void onResultSent(java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem> list) {
            if ((getFlags() & 4) != 0 || list == null) {
                this.val$receiver.send(-1, null);
                return;
            }
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putParcelableArray(androidx.media.MediaBrowserServiceCompat.KEY_SEARCH_RESULTS, (android.os.Parcelable[]) list.toArray(new android.support.v4.media.MediaBrowserCompat.MediaItem[0]));
            this.val$receiver.send(0, bundle);
        }
    }

    /* renamed from: androidx.media.MediaBrowserServiceCompat$4, reason: invalid class name */
    public class AnonymousClass4 extends androidx.media.MediaBrowserServiceCompat.Result<android.os.Bundle> {
        final /* synthetic */ android.support.v4.os.ResultReceiver val$receiver;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(java.lang.Object obj, android.support.v4.os.ResultReceiver resultReceiver) {
            super(obj);
            this.val$receiver = resultReceiver;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.Result
        public void onErrorSent(android.os.Bundle bundle) {
            this.val$receiver.send(-1, bundle);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.Result
        public void onProgressUpdateSent(android.os.Bundle bundle) {
            this.val$receiver.send(1, bundle);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.Result
        public void onResultSent(android.os.Bundle bundle) {
            this.val$receiver.send(0, bundle);
        }
    }

    public static final class BrowserRoot {
        public static final java.lang.String EXTRA_OFFLINE = "android.service.media.extra.OFFLINE";
        public static final java.lang.String EXTRA_RECENT = "android.service.media.extra.RECENT";
        public static final java.lang.String EXTRA_SUGGESTED = "android.service.media.extra.SUGGESTED";

        @java.lang.Deprecated
        public static final java.lang.String EXTRA_SUGGESTION_KEYWORDS = "android.service.media.extra.SUGGESTION_KEYWORDS";
        private final android.os.Bundle mExtras;
        private final java.lang.String mRootId;

        public BrowserRoot(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.Nullable android.os.Bundle bundle) {
            if (str == null) {
                throw new java.lang.IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead.");
            }
            this.mRootId = str;
            this.mExtras = bundle;
        }

        public android.os.Bundle getExtras() {
            return this.mExtras;
        }

        public java.lang.String getRootId() {
            return this.mRootId;
        }
    }

    public class ConnectionRecord implements android.os.IBinder.DeathRecipient {
        public final androidx.media.MediaSessionManager.RemoteUserInfo browserInfo;
        public final androidx.media.MediaBrowserServiceCompat.ServiceCallbacks callbacks;
        public final int pid;
        public final java.lang.String pkg;
        public androidx.media.MediaBrowserServiceCompat.BrowserRoot root;
        public final android.os.Bundle rootHints;
        public final java.util.HashMap<java.lang.String, java.util.List<androidx.core.util.Pair<android.os.IBinder, android.os.Bundle>>> subscriptions = new java.util.HashMap<>();
        public final int uid;

        /* renamed from: androidx.media.MediaBrowserServiceCompat$ConnectionRecord$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            public AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                androidx.media.MediaBrowserServiceCompat.ConnectionRecord connectionRecord = androidx.media.MediaBrowserServiceCompat.ConnectionRecord.this;
                androidx.media.MediaBrowserServiceCompat.this.mConnections.remove(connectionRecord.callbacks.asBinder());
            }
        }

        public ConnectionRecord(java.lang.String str, int i, int i2, android.os.Bundle bundle, androidx.media.MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks) {
            this.pkg = str;
            this.pid = i;
            this.uid = i2;
            this.browserInfo = new androidx.media.MediaSessionManager.RemoteUserInfo(str, i, i2);
            this.rootHints = bundle;
            this.callbacks = serviceCallbacks;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            androidx.media.MediaBrowserServiceCompat.this.mHandler.post(new androidx.media.MediaBrowserServiceCompat.ConnectionRecord.AnonymousClass1());
        }
    }

    public interface MediaBrowserServiceImpl {
        android.os.Bundle getBrowserRootHints();

        androidx.media.MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo();

        void notifyChildrenChanged(androidx.media.MediaSessionManager.RemoteUserInfo remoteUserInfo, java.lang.String str, android.os.Bundle bundle);

        void notifyChildrenChanged(java.lang.String str, android.os.Bundle bundle);

        android.os.IBinder onBind(android.content.Intent intent);

        void onCreate();

        void setSessionToken(android.support.v4.media.session.MediaSessionCompat.Token token);
    }

    @androidx.annotation.RequiresApi(21)
    public class MediaBrowserServiceImplApi21 implements androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl, androidx.media.MediaBrowserServiceCompatApi21.ServiceCompatProxy {
        android.os.Messenger mMessenger;
        final java.util.List<android.os.Bundle> mRootExtrasList = new java.util.ArrayList();
        java.lang.Object mServiceObj;

        /* renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ android.support.v4.media.session.MediaSessionCompat.Token val$token;

            public AnonymousClass1(android.support.v4.media.session.MediaSessionCompat.Token token) {
                this.val$token = token;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.this.mRootExtrasList.isEmpty()) {
                    android.support.v4.media.session.IMediaSession extraBinder = this.val$token.getExtraBinder();
                    if (extraBinder != null) {
                        java.util.Iterator<android.os.Bundle> it = androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.this.mRootExtrasList.iterator();
                        while (it.hasNext()) {
                            androidx.core.app.BundleCompat.putBinder(it.next(), androidx.media.MediaBrowserProtocol.EXTRA_SESSION_BINDER, extraBinder.asBinder());
                        }
                    }
                    androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.this.mRootExtrasList.clear();
                }
                androidx.media.MediaBrowserServiceCompatApi21.setSessionToken(androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.this.mServiceObj, this.val$token.getToken());
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$2, reason: invalid class name */
        public class AnonymousClass2 extends androidx.media.MediaBrowserServiceCompat.Result<java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem>> {
            final /* synthetic */ androidx.media.MediaBrowserServiceCompatApi21.ResultWrapper val$resultWrapper;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(java.lang.Object obj, androidx.media.MediaBrowserServiceCompatApi21.ResultWrapper resultWrapper) {
                super(obj);
                this.val$resultWrapper = resultWrapper;
            }

            @Override // androidx.media.MediaBrowserServiceCompat.Result
            public void detach() {
                this.val$resultWrapper.detach();
            }

            @Override // androidx.media.MediaBrowserServiceCompat.Result
            public void onResultSent(java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem> list) {
                java.util.ArrayList arrayList;
                if (list != null) {
                    arrayList = new java.util.ArrayList();
                    for (android.support.v4.media.MediaBrowserCompat.MediaItem mediaItem : list) {
                        android.os.Parcel obtain = android.os.Parcel.obtain();
                        mediaItem.writeToParcel(obtain, 0);
                        arrayList.add(obtain);
                    }
                } else {
                    arrayList = null;
                }
                this.val$resultWrapper.sendResult(arrayList);
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$3, reason: invalid class name */
        public class AnonymousClass3 implements java.lang.Runnable {
            final /* synthetic */ android.os.Bundle val$options;
            final /* synthetic */ java.lang.String val$parentId;

            public AnonymousClass3(java.lang.String str, android.os.Bundle bundle) {
                this.val$parentId = str;
                this.val$options = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                java.util.Iterator<android.os.IBinder> it = androidx.media.MediaBrowserServiceCompat.this.mConnections.keySet().iterator();
                while (it.hasNext()) {
                    androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.this.notifyChildrenChangedForCompatOnHandler(androidx.media.MediaBrowserServiceCompat.this.mConnections.get(it.next()), this.val$parentId, this.val$options);
                }
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$4, reason: invalid class name */
        public class AnonymousClass4 implements java.lang.Runnable {
            final /* synthetic */ android.os.Bundle val$options;
            final /* synthetic */ java.lang.String val$parentId;
            final /* synthetic */ androidx.media.MediaSessionManager.RemoteUserInfo val$remoteUserInfo;

            public AnonymousClass4(androidx.media.MediaSessionManager.RemoteUserInfo remoteUserInfo, java.lang.String str, android.os.Bundle bundle) {
                this.val$remoteUserInfo = remoteUserInfo;
                this.val$parentId = str;
                this.val$options = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                for (int i = 0; i < androidx.media.MediaBrowserServiceCompat.this.mConnections.size(); i++) {
                    androidx.media.MediaBrowserServiceCompat.ConnectionRecord valueAt = androidx.media.MediaBrowserServiceCompat.this.mConnections.valueAt(i);
                    if (valueAt.browserInfo.equals(this.val$remoteUserInfo)) {
                        androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.this.notifyChildrenChangedForCompatOnHandler(valueAt, this.val$parentId, this.val$options);
                    }
                }
            }
        }

        public MediaBrowserServiceImplApi21() {
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public android.os.Bundle getBrowserRootHints() {
            if (this.mMessenger == null) {
                return null;
            }
            androidx.media.MediaBrowserServiceCompat.ConnectionRecord connectionRecord = androidx.media.MediaBrowserServiceCompat.this.mCurConnection;
            if (connectionRecord == null) {
                throw new java.lang.IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
            }
            if (connectionRecord.rootHints == null) {
                return null;
            }
            return new android.os.Bundle(androidx.media.MediaBrowserServiceCompat.this.mCurConnection.rootHints);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public androidx.media.MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
            androidx.media.MediaBrowserServiceCompat.ConnectionRecord connectionRecord = androidx.media.MediaBrowserServiceCompat.this.mCurConnection;
            if (connectionRecord != null) {
                return connectionRecord.browserInfo;
            }
            throw new java.lang.IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(androidx.media.MediaSessionManager.RemoteUserInfo remoteUserInfo, java.lang.String str, android.os.Bundle bundle) {
            notifyChildrenChangedForCompat(remoteUserInfo, str, bundle);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(java.lang.String str, android.os.Bundle bundle) {
            notifyChildrenChangedForFramework(str, bundle);
            notifyChildrenChangedForCompat(str, bundle);
        }

        public void notifyChildrenChangedForCompat(androidx.media.MediaSessionManager.RemoteUserInfo remoteUserInfo, java.lang.String str, android.os.Bundle bundle) {
            androidx.media.MediaBrowserServiceCompat.this.mHandler.post(new androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.AnonymousClass4(remoteUserInfo, str, bundle));
        }

        public void notifyChildrenChangedForCompat(java.lang.String str, android.os.Bundle bundle) {
            androidx.media.MediaBrowserServiceCompat.this.mHandler.post(new androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.AnonymousClass3(str, bundle));
        }

        public void notifyChildrenChangedForCompatOnHandler(androidx.media.MediaBrowserServiceCompat.ConnectionRecord connectionRecord, java.lang.String str, android.os.Bundle bundle) {
            java.util.List<androidx.core.util.Pair<android.os.IBinder, android.os.Bundle>> list = connectionRecord.subscriptions.get(str);
            if (list != null) {
                for (androidx.core.util.Pair<android.os.IBinder, android.os.Bundle> pair : list) {
                    if (androidx.media.MediaBrowserCompatUtils.hasDuplicatedItems(bundle, pair.second)) {
                        androidx.media.MediaBrowserServiceCompat.this.performLoadChildren(str, connectionRecord, pair.second, bundle);
                    }
                }
            }
        }

        public void notifyChildrenChangedForFramework(java.lang.String str, android.os.Bundle bundle) {
            androidx.media.MediaBrowserServiceCompatApi21.notifyChildrenChanged(this.mServiceObj, str);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public android.os.IBinder onBind(android.content.Intent intent) {
            return androidx.media.MediaBrowserServiceCompatApi21.onBind(this.mServiceObj, intent);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            java.lang.Object createService = androidx.media.MediaBrowserServiceCompatApi21.createService(androidx.media.MediaBrowserServiceCompat.this, this);
            this.mServiceObj = createService;
            androidx.media.MediaBrowserServiceCompatApi21.onCreate(createService);
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi21.ServiceCompatProxy
        public androidx.media.MediaBrowserServiceCompatApi21.BrowserRoot onGetRoot(java.lang.String str, int i, android.os.Bundle bundle) {
            android.os.Bundle bundle2;
            if (bundle == null || bundle.getInt(androidx.media.MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 0) == 0) {
                bundle2 = null;
            } else {
                bundle.remove(androidx.media.MediaBrowserProtocol.EXTRA_CLIENT_VERSION);
                this.mMessenger = new android.os.Messenger(androidx.media.MediaBrowserServiceCompat.this.mHandler);
                bundle2 = new android.os.Bundle();
                bundle2.putInt(androidx.media.MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 2);
                androidx.core.app.BundleCompat.putBinder(bundle2, androidx.media.MediaBrowserProtocol.EXTRA_MESSENGER_BINDER, this.mMessenger.getBinder());
                android.support.v4.media.session.MediaSessionCompat.Token token = androidx.media.MediaBrowserServiceCompat.this.mSession;
                if (token != null) {
                    android.support.v4.media.session.IMediaSession extraBinder = token.getExtraBinder();
                    androidx.core.app.BundleCompat.putBinder(bundle2, androidx.media.MediaBrowserProtocol.EXTRA_SESSION_BINDER, extraBinder == null ? null : extraBinder.asBinder());
                } else {
                    this.mRootExtrasList.add(bundle2);
                }
            }
            androidx.media.MediaBrowserServiceCompat mediaBrowserServiceCompat = androidx.media.MediaBrowserServiceCompat.this;
            mediaBrowserServiceCompat.mCurConnection = mediaBrowserServiceCompat.new ConnectionRecord(str, -1, i, bundle, null);
            androidx.media.MediaBrowserServiceCompat.BrowserRoot onGetRoot = androidx.media.MediaBrowserServiceCompat.this.onGetRoot(str, i, bundle);
            androidx.media.MediaBrowserServiceCompat.this.mCurConnection = null;
            if (onGetRoot == null) {
                return null;
            }
            if (bundle2 == null) {
                bundle2 = onGetRoot.getExtras();
            } else if (onGetRoot.getExtras() != null) {
                bundle2.putAll(onGetRoot.getExtras());
            }
            return new androidx.media.MediaBrowserServiceCompatApi21.BrowserRoot(onGetRoot.getRootId(), bundle2);
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi21.ServiceCompatProxy
        public void onLoadChildren(java.lang.String str, androidx.media.MediaBrowserServiceCompatApi21.ResultWrapper<java.util.List<android.os.Parcel>> resultWrapper) {
            androidx.media.MediaBrowserServiceCompat.this.onLoadChildren(str, new androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.AnonymousClass2(str, resultWrapper));
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void setSessionToken(android.support.v4.media.session.MediaSessionCompat.Token token) {
            androidx.media.MediaBrowserServiceCompat.this.mHandler.postOrRun(new androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21.AnonymousClass1(token));
        }
    }

    @androidx.annotation.RequiresApi(23)
    public class MediaBrowserServiceImplApi23 extends androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21 implements androidx.media.MediaBrowserServiceCompatApi23.ServiceCompatProxy {

        /* renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi23$1, reason: invalid class name */
        public class AnonymousClass1 extends androidx.media.MediaBrowserServiceCompat.Result<android.support.v4.media.MediaBrowserCompat.MediaItem> {
            final /* synthetic */ androidx.media.MediaBrowserServiceCompatApi21.ResultWrapper val$resultWrapper;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(java.lang.Object obj, androidx.media.MediaBrowserServiceCompatApi21.ResultWrapper resultWrapper) {
                super(obj);
                this.val$resultWrapper = resultWrapper;
            }

            @Override // androidx.media.MediaBrowserServiceCompat.Result
            public void detach() {
                this.val$resultWrapper.detach();
            }

            @Override // androidx.media.MediaBrowserServiceCompat.Result
            public void onResultSent(android.support.v4.media.MediaBrowserCompat.MediaItem mediaItem) {
                if (mediaItem == null) {
                    this.val$resultWrapper.sendResult(null);
                    return;
                }
                android.os.Parcel obtain = android.os.Parcel.obtain();
                mediaItem.writeToParcel(obtain, 0);
                this.val$resultWrapper.sendResult(obtain);
            }
        }

        public MediaBrowserServiceImplApi23() {
            super();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            java.lang.Object createService = androidx.media.MediaBrowserServiceCompatApi23.createService(androidx.media.MediaBrowserServiceCompat.this, this);
            this.mServiceObj = createService;
            androidx.media.MediaBrowserServiceCompatApi21.onCreate(createService);
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi23.ServiceCompatProxy
        public void onLoadItem(java.lang.String str, androidx.media.MediaBrowserServiceCompatApi21.ResultWrapper<android.os.Parcel> resultWrapper) {
            androidx.media.MediaBrowserServiceCompat.this.onLoadItem(str, new androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi23.AnonymousClass1(str, resultWrapper));
        }
    }

    @androidx.annotation.RequiresApi(26)
    public class MediaBrowserServiceImplApi26 extends androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi23 implements androidx.media.MediaBrowserServiceCompatApi26.ServiceCompatProxy {

        /* renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi26$1, reason: invalid class name */
        public class AnonymousClass1 extends androidx.media.MediaBrowserServiceCompat.Result<java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem>> {
            final /* synthetic */ androidx.media.MediaBrowserServiceCompatApi26.ResultWrapper val$resultWrapper;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(java.lang.Object obj, androidx.media.MediaBrowserServiceCompatApi26.ResultWrapper resultWrapper) {
                super(obj);
                this.val$resultWrapper = resultWrapper;
            }

            @Override // androidx.media.MediaBrowserServiceCompat.Result
            public void detach() {
                this.val$resultWrapper.detach();
            }

            @Override // androidx.media.MediaBrowserServiceCompat.Result
            public void onResultSent(java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem> list) {
                java.util.ArrayList arrayList;
                if (list != null) {
                    arrayList = new java.util.ArrayList();
                    for (android.support.v4.media.MediaBrowserCompat.MediaItem mediaItem : list) {
                        android.os.Parcel obtain = android.os.Parcel.obtain();
                        mediaItem.writeToParcel(obtain, 0);
                        arrayList.add(obtain);
                    }
                } else {
                    arrayList = null;
                }
                this.val$resultWrapper.sendResult(arrayList, getFlags());
            }
        }

        public MediaBrowserServiceImplApi26() {
            super();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public android.os.Bundle getBrowserRootHints() {
            androidx.media.MediaBrowserServiceCompat.ConnectionRecord connectionRecord = androidx.media.MediaBrowserServiceCompat.this.mCurConnection;
            if (connectionRecord == null) {
                return androidx.media.MediaBrowserServiceCompatApi26.getBrowserRootHints(this.mServiceObj);
            }
            if (connectionRecord.rootHints == null) {
                return null;
            }
            return new android.os.Bundle(androidx.media.MediaBrowserServiceCompat.this.mCurConnection.rootHints);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21
        public void notifyChildrenChangedForFramework(java.lang.String str, android.os.Bundle bundle) {
            if (bundle != null) {
                androidx.media.MediaBrowserServiceCompatApi26.notifyChildrenChanged(this.mServiceObj, str, bundle);
            } else {
                super.notifyChildrenChangedForFramework(str, bundle);
            }
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi23, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            java.lang.Object createService = androidx.media.MediaBrowserServiceCompatApi26.createService(androidx.media.MediaBrowserServiceCompat.this, this);
            this.mServiceObj = createService;
            androidx.media.MediaBrowserServiceCompatApi21.onCreate(createService);
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi26.ServiceCompatProxy
        public void onLoadChildren(java.lang.String str, androidx.media.MediaBrowserServiceCompatApi26.ResultWrapper resultWrapper, android.os.Bundle bundle) {
            androidx.media.MediaBrowserServiceCompat.this.onLoadChildren(str, new androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi26.AnonymousClass1(str, resultWrapper), bundle);
        }
    }

    @androidx.annotation.RequiresApi(28)
    public class MediaBrowserServiceImplApi28 extends androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi26 {
        public MediaBrowserServiceImplApi28() {
            super();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public androidx.media.MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
            android.media.session.MediaSessionManager.RemoteUserInfo currentBrowserInfo;
            androidx.media.MediaBrowserServiceCompat.ConnectionRecord connectionRecord = androidx.media.MediaBrowserServiceCompat.this.mCurConnection;
            if (connectionRecord != null) {
                return connectionRecord.browserInfo;
            }
            currentBrowserInfo = ((android.service.media.MediaBrowserService) this.mServiceObj).getCurrentBrowserInfo();
            return new androidx.media.MediaSessionManager.RemoteUserInfo(currentBrowserInfo);
        }
    }

    public class MediaBrowserServiceImplBase implements androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl {
        private android.os.Messenger mMessenger;

        /* renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplBase$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ android.support.v4.media.session.MediaSessionCompat.Token val$token;

            public AnonymousClass1(android.support.v4.media.session.MediaSessionCompat.Token token) {
                this.val$token = token;
            }

            @Override // java.lang.Runnable
            public void run() {
                java.util.Iterator<androidx.media.MediaBrowserServiceCompat.ConnectionRecord> it = androidx.media.MediaBrowserServiceCompat.this.mConnections.values().iterator();
                while (it.hasNext()) {
                    androidx.media.MediaBrowserServiceCompat.ConnectionRecord next = it.next();
                    try {
                        next.callbacks.onConnect(next.root.getRootId(), this.val$token, next.root.getExtras());
                    } catch (android.os.RemoteException unused) {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append("Connection for ");
                        sb.append(next.pkg);
                        sb.append(" is no longer valid.");
                        it.remove();
                    }
                }
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplBase$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            final /* synthetic */ android.os.Bundle val$options;
            final /* synthetic */ java.lang.String val$parentId;

            public AnonymousClass2(java.lang.String str, android.os.Bundle bundle) {
                this.val$parentId = str;
                this.val$options = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                java.util.Iterator<android.os.IBinder> it = androidx.media.MediaBrowserServiceCompat.this.mConnections.keySet().iterator();
                while (it.hasNext()) {
                    androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplBase.this.notifyChildrenChangedOnHandler(androidx.media.MediaBrowserServiceCompat.this.mConnections.get(it.next()), this.val$parentId, this.val$options);
                }
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplBase$3, reason: invalid class name */
        public class AnonymousClass3 implements java.lang.Runnable {
            final /* synthetic */ android.os.Bundle val$options;
            final /* synthetic */ java.lang.String val$parentId;
            final /* synthetic */ androidx.media.MediaSessionManager.RemoteUserInfo val$remoteUserInfo;

            public AnonymousClass3(androidx.media.MediaSessionManager.RemoteUserInfo remoteUserInfo, java.lang.String str, android.os.Bundle bundle) {
                this.val$remoteUserInfo = remoteUserInfo;
                this.val$parentId = str;
                this.val$options = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                for (int i = 0; i < androidx.media.MediaBrowserServiceCompat.this.mConnections.size(); i++) {
                    androidx.media.MediaBrowserServiceCompat.ConnectionRecord valueAt = androidx.media.MediaBrowserServiceCompat.this.mConnections.valueAt(i);
                    if (valueAt.browserInfo.equals(this.val$remoteUserInfo)) {
                        androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplBase.this.notifyChildrenChangedOnHandler(valueAt, this.val$parentId, this.val$options);
                        return;
                    }
                }
            }
        }

        public MediaBrowserServiceImplBase() {
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public android.os.Bundle getBrowserRootHints() {
            androidx.media.MediaBrowserServiceCompat.ConnectionRecord connectionRecord = androidx.media.MediaBrowserServiceCompat.this.mCurConnection;
            if (connectionRecord == null) {
                throw new java.lang.IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
            }
            if (connectionRecord.rootHints == null) {
                return null;
            }
            return new android.os.Bundle(androidx.media.MediaBrowserServiceCompat.this.mCurConnection.rootHints);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public androidx.media.MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
            androidx.media.MediaBrowserServiceCompat.ConnectionRecord connectionRecord = androidx.media.MediaBrowserServiceCompat.this.mCurConnection;
            if (connectionRecord != null) {
                return connectionRecord.browserInfo;
            }
            throw new java.lang.IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(@androidx.annotation.NonNull androidx.media.MediaSessionManager.RemoteUserInfo remoteUserInfo, @androidx.annotation.NonNull java.lang.String str, android.os.Bundle bundle) {
            androidx.media.MediaBrowserServiceCompat.this.mHandler.post(new androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplBase.AnonymousClass3(remoteUserInfo, str, bundle));
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(@androidx.annotation.NonNull java.lang.String str, android.os.Bundle bundle) {
            androidx.media.MediaBrowserServiceCompat.this.mHandler.post(new androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplBase.AnonymousClass2(str, bundle));
        }

        public void notifyChildrenChangedOnHandler(androidx.media.MediaBrowserServiceCompat.ConnectionRecord connectionRecord, java.lang.String str, android.os.Bundle bundle) {
            java.util.List<androidx.core.util.Pair<android.os.IBinder, android.os.Bundle>> list = connectionRecord.subscriptions.get(str);
            if (list != null) {
                for (androidx.core.util.Pair<android.os.IBinder, android.os.Bundle> pair : list) {
                    if (androidx.media.MediaBrowserCompatUtils.hasDuplicatedItems(bundle, pair.second)) {
                        androidx.media.MediaBrowserServiceCompat.this.performLoadChildren(str, connectionRecord, pair.second, bundle);
                    }
                }
            }
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public android.os.IBinder onBind(android.content.Intent intent) {
            if (androidx.media.MediaBrowserServiceCompat.SERVICE_INTERFACE.equals(intent.getAction())) {
                return this.mMessenger.getBinder();
            }
            return null;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            this.mMessenger = new android.os.Messenger(androidx.media.MediaBrowserServiceCompat.this.mHandler);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void setSessionToken(android.support.v4.media.session.MediaSessionCompat.Token token) {
            androidx.media.MediaBrowserServiceCompat.this.mHandler.post(new androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplBase.AnonymousClass1(token));
        }
    }

    public static class Result<T> {
        private final java.lang.Object mDebug;
        private boolean mDetachCalled;
        private int mFlags;
        private boolean mSendErrorCalled;
        private boolean mSendProgressUpdateCalled;
        private boolean mSendResultCalled;

        public Result(java.lang.Object obj) {
            this.mDebug = obj;
        }

        private void checkExtraFields(android.os.Bundle bundle) {
            if (bundle != null && bundle.containsKey(android.support.v4.media.MediaBrowserCompat.EXTRA_DOWNLOAD_PROGRESS)) {
                float f = bundle.getFloat(android.support.v4.media.MediaBrowserCompat.EXTRA_DOWNLOAD_PROGRESS);
                if (f < -1.0E-5f || f > 1.00001f) {
                    throw new java.lang.IllegalArgumentException("The value of the EXTRA_DOWNLOAD_PROGRESS field must be a float number within [0.0, 1.0].");
                }
            }
        }

        public void detach() {
            if (this.mDetachCalled) {
                throw new java.lang.IllegalStateException("detach() called when detach() had already been called for: " + this.mDebug);
            }
            if (this.mSendResultCalled) {
                throw new java.lang.IllegalStateException("detach() called when sendResult() had already been called for: " + this.mDebug);
            }
            if (!this.mSendErrorCalled) {
                this.mDetachCalled = true;
                return;
            }
            throw new java.lang.IllegalStateException("detach() called when sendError() had already been called for: " + this.mDebug);
        }

        public int getFlags() {
            return this.mFlags;
        }

        public boolean isDone() {
            return this.mDetachCalled || this.mSendResultCalled || this.mSendErrorCalled;
        }

        public void onErrorSent(android.os.Bundle bundle) {
            throw new java.lang.UnsupportedOperationException("It is not supported to send an error for " + this.mDebug);
        }

        public void onProgressUpdateSent(android.os.Bundle bundle) {
            throw new java.lang.UnsupportedOperationException("It is not supported to send an interim update for " + this.mDebug);
        }

        public void onResultSent(T t) {
        }

        public void sendError(android.os.Bundle bundle) {
            if (!this.mSendResultCalled && !this.mSendErrorCalled) {
                this.mSendErrorCalled = true;
                onErrorSent(bundle);
            } else {
                throw new java.lang.IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.mDebug);
            }
        }

        public void sendProgressUpdate(android.os.Bundle bundle) {
            if (this.mSendResultCalled || this.mSendErrorCalled) {
                throw new java.lang.IllegalStateException("sendProgressUpdate() called when either sendResult() or sendError() had already been called for: " + this.mDebug);
            }
            checkExtraFields(bundle);
            this.mSendProgressUpdateCalled = true;
            onProgressUpdateSent(bundle);
        }

        public void sendResult(T t) {
            if (!this.mSendResultCalled && !this.mSendErrorCalled) {
                this.mSendResultCalled = true;
                onResultSent(t);
            } else {
                throw new java.lang.IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.mDebug);
            }
        }

        public void setFlags(int i) {
            this.mFlags = i;
        }
    }

    public class ServiceBinderImpl {

        /* renamed from: androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl$1, reason: invalid class name */
        public class AnonymousClass1 implements java.lang.Runnable {
            final /* synthetic */ androidx.media.MediaBrowserServiceCompat.ServiceCallbacks val$callbacks;
            final /* synthetic */ int val$pid;
            final /* synthetic */ java.lang.String val$pkg;
            final /* synthetic */ android.os.Bundle val$rootHints;
            final /* synthetic */ int val$uid;

            public AnonymousClass1(androidx.media.MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks, java.lang.String str, int i, int i2, android.os.Bundle bundle) {
                this.val$callbacks = serviceCallbacks;
                this.val$pkg = str;
                this.val$pid = i;
                this.val$uid = i2;
                this.val$rootHints = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                android.os.IBinder asBinder = this.val$callbacks.asBinder();
                androidx.media.MediaBrowserServiceCompat.this.mConnections.remove(asBinder);
                androidx.media.MediaBrowserServiceCompat.ConnectionRecord connectionRecord = androidx.media.MediaBrowserServiceCompat.this.new ConnectionRecord(this.val$pkg, this.val$pid, this.val$uid, this.val$rootHints, this.val$callbacks);
                androidx.media.MediaBrowserServiceCompat mediaBrowserServiceCompat = androidx.media.MediaBrowserServiceCompat.this;
                mediaBrowserServiceCompat.mCurConnection = connectionRecord;
                androidx.media.MediaBrowserServiceCompat.BrowserRoot onGetRoot = mediaBrowserServiceCompat.onGetRoot(this.val$pkg, this.val$uid, this.val$rootHints);
                connectionRecord.root = onGetRoot;
                androidx.media.MediaBrowserServiceCompat mediaBrowserServiceCompat2 = androidx.media.MediaBrowserServiceCompat.this;
                mediaBrowserServiceCompat2.mCurConnection = null;
                if (onGetRoot == null) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("No root for client ");
                    sb.append(this.val$pkg);
                    sb.append(" from service ");
                    sb.append(getClass().getName());
                    try {
                        this.val$callbacks.onConnectFailed();
                        return;
                    } catch (android.os.RemoteException unused) {
                        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                        sb2.append("Calling onConnectFailed() failed. Ignoring. pkg=");
                        sb2.append(this.val$pkg);
                        return;
                    }
                }
                try {
                    mediaBrowserServiceCompat2.mConnections.put(asBinder, connectionRecord);
                    asBinder.linkToDeath(connectionRecord, 0);
                    if (androidx.media.MediaBrowserServiceCompat.this.mSession != null) {
                        this.val$callbacks.onConnect(connectionRecord.root.getRootId(), androidx.media.MediaBrowserServiceCompat.this.mSession, connectionRecord.root.getExtras());
                    }
                } catch (android.os.RemoteException unused2) {
                    java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                    sb3.append("Calling onConnect() failed. Dropping client. pkg=");
                    sb3.append(this.val$pkg);
                    androidx.media.MediaBrowserServiceCompat.this.mConnections.remove(asBinder);
                }
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl$2, reason: invalid class name */
        public class AnonymousClass2 implements java.lang.Runnable {
            final /* synthetic */ androidx.media.MediaBrowserServiceCompat.ServiceCallbacks val$callbacks;

            public AnonymousClass2(androidx.media.MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks) {
                this.val$callbacks = serviceCallbacks;
            }

            @Override // java.lang.Runnable
            public void run() {
                androidx.media.MediaBrowserServiceCompat.ConnectionRecord remove = androidx.media.MediaBrowserServiceCompat.this.mConnections.remove(this.val$callbacks.asBinder());
                if (remove != null) {
                    remove.callbacks.asBinder().unlinkToDeath(remove, 0);
                }
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl$3, reason: invalid class name */
        public class AnonymousClass3 implements java.lang.Runnable {
            final /* synthetic */ androidx.media.MediaBrowserServiceCompat.ServiceCallbacks val$callbacks;
            final /* synthetic */ java.lang.String val$id;
            final /* synthetic */ android.os.Bundle val$options;
            final /* synthetic */ android.os.IBinder val$token;

            public AnonymousClass3(androidx.media.MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks, java.lang.String str, android.os.IBinder iBinder, android.os.Bundle bundle) {
                this.val$callbacks = serviceCallbacks;
                this.val$id = str;
                this.val$token = iBinder;
                this.val$options = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                androidx.media.MediaBrowserServiceCompat.ConnectionRecord connectionRecord = androidx.media.MediaBrowserServiceCompat.this.mConnections.get(this.val$callbacks.asBinder());
                if (connectionRecord != null) {
                    androidx.media.MediaBrowserServiceCompat.this.addSubscription(this.val$id, connectionRecord, this.val$token, this.val$options);
                    return;
                }
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("addSubscription for callback that isn't registered id=");
                sb.append(this.val$id);
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl$4, reason: invalid class name */
        public class AnonymousClass4 implements java.lang.Runnable {
            final /* synthetic */ androidx.media.MediaBrowserServiceCompat.ServiceCallbacks val$callbacks;
            final /* synthetic */ java.lang.String val$id;
            final /* synthetic */ android.os.IBinder val$token;

            public AnonymousClass4(androidx.media.MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks, java.lang.String str, android.os.IBinder iBinder) {
                this.val$callbacks = serviceCallbacks;
                this.val$id = str;
                this.val$token = iBinder;
            }

            @Override // java.lang.Runnable
            public void run() {
                androidx.media.MediaBrowserServiceCompat.ConnectionRecord connectionRecord = androidx.media.MediaBrowserServiceCompat.this.mConnections.get(this.val$callbacks.asBinder());
                if (connectionRecord == null) {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("removeSubscription for callback that isn't registered id=");
                    sb.append(this.val$id);
                } else {
                    if (androidx.media.MediaBrowserServiceCompat.this.removeSubscription(this.val$id, connectionRecord, this.val$token)) {
                        return;
                    }
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append("removeSubscription called for ");
                    sb2.append(this.val$id);
                    sb2.append(" which is not subscribed");
                }
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl$5, reason: invalid class name */
        public class AnonymousClass5 implements java.lang.Runnable {
            final /* synthetic */ androidx.media.MediaBrowserServiceCompat.ServiceCallbacks val$callbacks;
            final /* synthetic */ java.lang.String val$mediaId;
            final /* synthetic */ android.support.v4.os.ResultReceiver val$receiver;

            public AnonymousClass5(androidx.media.MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks, java.lang.String str, android.support.v4.os.ResultReceiver resultReceiver) {
                this.val$callbacks = serviceCallbacks;
                this.val$mediaId = str;
                this.val$receiver = resultReceiver;
            }

            @Override // java.lang.Runnable
            public void run() {
                androidx.media.MediaBrowserServiceCompat.ConnectionRecord connectionRecord = androidx.media.MediaBrowserServiceCompat.this.mConnections.get(this.val$callbacks.asBinder());
                if (connectionRecord != null) {
                    androidx.media.MediaBrowserServiceCompat.this.performLoadItem(this.val$mediaId, connectionRecord, this.val$receiver);
                    return;
                }
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("getMediaItem for callback that isn't registered id=");
                sb.append(this.val$mediaId);
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl$6, reason: invalid class name */
        public class AnonymousClass6 implements java.lang.Runnable {
            final /* synthetic */ androidx.media.MediaBrowserServiceCompat.ServiceCallbacks val$callbacks;
            final /* synthetic */ int val$pid;
            final /* synthetic */ java.lang.String val$pkg;
            final /* synthetic */ android.os.Bundle val$rootHints;
            final /* synthetic */ int val$uid;

            public AnonymousClass6(androidx.media.MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks, java.lang.String str, int i, int i2, android.os.Bundle bundle) {
                this.val$callbacks = serviceCallbacks;
                this.val$pkg = str;
                this.val$pid = i;
                this.val$uid = i2;
                this.val$rootHints = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                android.os.IBinder asBinder = this.val$callbacks.asBinder();
                androidx.media.MediaBrowserServiceCompat.this.mConnections.remove(asBinder);
                androidx.media.MediaBrowserServiceCompat.ConnectionRecord connectionRecord = androidx.media.MediaBrowserServiceCompat.this.new ConnectionRecord(this.val$pkg, this.val$pid, this.val$uid, this.val$rootHints, this.val$callbacks);
                androidx.media.MediaBrowserServiceCompat.this.mConnections.put(asBinder, connectionRecord);
                try {
                    asBinder.linkToDeath(connectionRecord, 0);
                } catch (android.os.RemoteException unused) {
                }
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl$7, reason: invalid class name */
        public class AnonymousClass7 implements java.lang.Runnable {
            final /* synthetic */ androidx.media.MediaBrowserServiceCompat.ServiceCallbacks val$callbacks;

            public AnonymousClass7(androidx.media.MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks) {
                this.val$callbacks = serviceCallbacks;
            }

            @Override // java.lang.Runnable
            public void run() {
                android.os.IBinder asBinder = this.val$callbacks.asBinder();
                androidx.media.MediaBrowserServiceCompat.ConnectionRecord remove = androidx.media.MediaBrowserServiceCompat.this.mConnections.remove(asBinder);
                if (remove != null) {
                    asBinder.unlinkToDeath(remove, 0);
                }
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl$8, reason: invalid class name */
        public class AnonymousClass8 implements java.lang.Runnable {
            final /* synthetic */ androidx.media.MediaBrowserServiceCompat.ServiceCallbacks val$callbacks;
            final /* synthetic */ android.os.Bundle val$extras;
            final /* synthetic */ java.lang.String val$query;
            final /* synthetic */ android.support.v4.os.ResultReceiver val$receiver;

            public AnonymousClass8(androidx.media.MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks, java.lang.String str, android.os.Bundle bundle, android.support.v4.os.ResultReceiver resultReceiver) {
                this.val$callbacks = serviceCallbacks;
                this.val$query = str;
                this.val$extras = bundle;
                this.val$receiver = resultReceiver;
            }

            @Override // java.lang.Runnable
            public void run() {
                androidx.media.MediaBrowserServiceCompat.ConnectionRecord connectionRecord = androidx.media.MediaBrowserServiceCompat.this.mConnections.get(this.val$callbacks.asBinder());
                if (connectionRecord != null) {
                    androidx.media.MediaBrowserServiceCompat.this.performSearch(this.val$query, this.val$extras, connectionRecord, this.val$receiver);
                    return;
                }
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("search for callback that isn't registered query=");
                sb.append(this.val$query);
            }
        }

        /* renamed from: androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl$9, reason: invalid class name */
        public class AnonymousClass9 implements java.lang.Runnable {
            final /* synthetic */ java.lang.String val$action;
            final /* synthetic */ androidx.media.MediaBrowserServiceCompat.ServiceCallbacks val$callbacks;
            final /* synthetic */ android.os.Bundle val$extras;
            final /* synthetic */ android.support.v4.os.ResultReceiver val$receiver;

            public AnonymousClass9(androidx.media.MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks, java.lang.String str, android.os.Bundle bundle, android.support.v4.os.ResultReceiver resultReceiver) {
                this.val$callbacks = serviceCallbacks;
                this.val$action = str;
                this.val$extras = bundle;
                this.val$receiver = resultReceiver;
            }

            @Override // java.lang.Runnable
            public void run() {
                androidx.media.MediaBrowserServiceCompat.ConnectionRecord connectionRecord = androidx.media.MediaBrowserServiceCompat.this.mConnections.get(this.val$callbacks.asBinder());
                if (connectionRecord != null) {
                    androidx.media.MediaBrowserServiceCompat.this.performCustomAction(this.val$action, this.val$extras, connectionRecord, this.val$receiver);
                    return;
                }
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("sendCustomAction for callback that isn't registered action=");
                sb.append(this.val$action);
                sb.append(", extras=");
                sb.append(this.val$extras);
            }
        }

        public ServiceBinderImpl() {
        }

        public void addSubscription(java.lang.String str, android.os.IBinder iBinder, android.os.Bundle bundle, androidx.media.MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks) {
            androidx.media.MediaBrowserServiceCompat.this.mHandler.postOrRun(new androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.AnonymousClass3(serviceCallbacks, str, iBinder, bundle));
        }

        public void connect(java.lang.String str, int i, int i2, android.os.Bundle bundle, androidx.media.MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks) {
            if (androidx.media.MediaBrowserServiceCompat.this.isValidPackage(str, i2)) {
                androidx.media.MediaBrowserServiceCompat.this.mHandler.postOrRun(new androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.AnonymousClass1(serviceCallbacks, str, i, i2, bundle));
                return;
            }
            throw new java.lang.IllegalArgumentException("Package/uid mismatch: uid=" + i2 + " package=" + str);
        }

        public void disconnect(androidx.media.MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks) {
            androidx.media.MediaBrowserServiceCompat.this.mHandler.postOrRun(new androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.AnonymousClass2(serviceCallbacks));
        }

        public void getMediaItem(java.lang.String str, android.support.v4.os.ResultReceiver resultReceiver, androidx.media.MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks) {
            if (android.text.TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            androidx.media.MediaBrowserServiceCompat.this.mHandler.postOrRun(new androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.AnonymousClass5(serviceCallbacks, str, resultReceiver));
        }

        public void registerCallbacks(androidx.media.MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks, java.lang.String str, int i, int i2, android.os.Bundle bundle) {
            androidx.media.MediaBrowserServiceCompat.this.mHandler.postOrRun(new androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.AnonymousClass6(serviceCallbacks, str, i, i2, bundle));
        }

        public void removeSubscription(java.lang.String str, android.os.IBinder iBinder, androidx.media.MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks) {
            androidx.media.MediaBrowserServiceCompat.this.mHandler.postOrRun(new androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.AnonymousClass4(serviceCallbacks, str, iBinder));
        }

        public void search(java.lang.String str, android.os.Bundle bundle, android.support.v4.os.ResultReceiver resultReceiver, androidx.media.MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks) {
            if (android.text.TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            androidx.media.MediaBrowserServiceCompat.this.mHandler.postOrRun(new androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.AnonymousClass8(serviceCallbacks, str, bundle, resultReceiver));
        }

        public void sendCustomAction(java.lang.String str, android.os.Bundle bundle, android.support.v4.os.ResultReceiver resultReceiver, androidx.media.MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks) {
            if (android.text.TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            androidx.media.MediaBrowserServiceCompat.this.mHandler.postOrRun(new androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.AnonymousClass9(serviceCallbacks, str, bundle, resultReceiver));
        }

        public void unregisterCallbacks(androidx.media.MediaBrowserServiceCompat.ServiceCallbacks serviceCallbacks) {
            androidx.media.MediaBrowserServiceCompat.this.mHandler.postOrRun(new androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl.AnonymousClass7(serviceCallbacks));
        }
    }

    public interface ServiceCallbacks {
        android.os.IBinder asBinder();

        void onConnect(java.lang.String str, android.support.v4.media.session.MediaSessionCompat.Token token, android.os.Bundle bundle) throws android.os.RemoteException;

        void onConnectFailed() throws android.os.RemoteException;

        void onLoadChildren(java.lang.String str, java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem> list, android.os.Bundle bundle, android.os.Bundle bundle2) throws android.os.RemoteException;
    }

    public static class ServiceCallbacksCompat implements androidx.media.MediaBrowserServiceCompat.ServiceCallbacks {
        final android.os.Messenger mCallbacks;

        public ServiceCallbacksCompat(android.os.Messenger messenger) {
            this.mCallbacks = messenger;
        }

        private void sendRequest(int i, android.os.Bundle bundle) throws android.os.RemoteException {
            android.os.Message obtain = android.os.Message.obtain();
            obtain.what = i;
            obtain.arg1 = 2;
            obtain.setData(bundle);
            this.mCallbacks.send(obtain);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public android.os.IBinder asBinder() {
            return this.mCallbacks.getBinder();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public void onConnect(java.lang.String str, android.support.v4.media.session.MediaSessionCompat.Token token, android.os.Bundle bundle) throws android.os.RemoteException {
            if (bundle == null) {
                bundle = new android.os.Bundle();
            }
            bundle.putInt(androidx.media.MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 2);
            android.os.Bundle bundle2 = new android.os.Bundle();
            bundle2.putString(androidx.media.MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            bundle2.putParcelable(androidx.media.MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN, token);
            bundle2.putBundle(androidx.media.MediaBrowserProtocol.DATA_ROOT_HINTS, bundle);
            sendRequest(1, bundle2);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public void onConnectFailed() throws android.os.RemoteException {
            sendRequest(2, null);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public void onLoadChildren(java.lang.String str, java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem> list, android.os.Bundle bundle, android.os.Bundle bundle2) throws android.os.RemoteException {
            android.os.Bundle bundle3 = new android.os.Bundle();
            bundle3.putString(androidx.media.MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            bundle3.putBundle(androidx.media.MediaBrowserProtocol.DATA_OPTIONS, bundle);
            bundle3.putBundle(androidx.media.MediaBrowserProtocol.DATA_NOTIFY_CHILDREN_CHANGED_OPTIONS, bundle2);
            if (list != null) {
                bundle3.putParcelableArrayList(androidx.media.MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST, list instanceof java.util.ArrayList ? (java.util.ArrayList) list : new java.util.ArrayList<>(list));
            }
            sendRequest(3, bundle3);
        }
    }

    public final class ServiceHandler extends android.os.Handler {
        private final androidx.media.MediaBrowserServiceCompat.ServiceBinderImpl mServiceBinderImpl;

        public ServiceHandler() {
            this.mServiceBinderImpl = androidx.media.MediaBrowserServiceCompat.this.new ServiceBinderImpl();
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            android.os.Bundle data = message.getData();
            switch (message.what) {
                case 1:
                    android.os.Bundle bundle = data.getBundle(androidx.media.MediaBrowserProtocol.DATA_ROOT_HINTS);
                    android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(bundle);
                    this.mServiceBinderImpl.connect(data.getString(androidx.media.MediaBrowserProtocol.DATA_PACKAGE_NAME), data.getInt(androidx.media.MediaBrowserProtocol.DATA_CALLING_PID), data.getInt(androidx.media.MediaBrowserProtocol.DATA_CALLING_UID), bundle, new androidx.media.MediaBrowserServiceCompat.ServiceCallbacksCompat(message.replyTo));
                    break;
                case 2:
                    this.mServiceBinderImpl.disconnect(new androidx.media.MediaBrowserServiceCompat.ServiceCallbacksCompat(message.replyTo));
                    break;
                case 3:
                    android.os.Bundle bundle2 = data.getBundle(androidx.media.MediaBrowserProtocol.DATA_OPTIONS);
                    android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(bundle2);
                    this.mServiceBinderImpl.addSubscription(data.getString(androidx.media.MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), androidx.core.app.BundleCompat.getBinder(data, androidx.media.MediaBrowserProtocol.DATA_CALLBACK_TOKEN), bundle2, new androidx.media.MediaBrowserServiceCompat.ServiceCallbacksCompat(message.replyTo));
                    break;
                case 4:
                    this.mServiceBinderImpl.removeSubscription(data.getString(androidx.media.MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), androidx.core.app.BundleCompat.getBinder(data, androidx.media.MediaBrowserProtocol.DATA_CALLBACK_TOKEN), new androidx.media.MediaBrowserServiceCompat.ServiceCallbacksCompat(message.replyTo));
                    break;
                case 5:
                    this.mServiceBinderImpl.getMediaItem(data.getString(androidx.media.MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), (android.support.v4.os.ResultReceiver) data.getParcelable(androidx.media.MediaBrowserProtocol.DATA_RESULT_RECEIVER), new androidx.media.MediaBrowserServiceCompat.ServiceCallbacksCompat(message.replyTo));
                    break;
                case 6:
                    android.os.Bundle bundle3 = data.getBundle(androidx.media.MediaBrowserProtocol.DATA_ROOT_HINTS);
                    android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(bundle3);
                    this.mServiceBinderImpl.registerCallbacks(new androidx.media.MediaBrowserServiceCompat.ServiceCallbacksCompat(message.replyTo), data.getString(androidx.media.MediaBrowserProtocol.DATA_PACKAGE_NAME), data.getInt(androidx.media.MediaBrowserProtocol.DATA_CALLING_PID), data.getInt(androidx.media.MediaBrowserProtocol.DATA_CALLING_UID), bundle3);
                    break;
                case 7:
                    this.mServiceBinderImpl.unregisterCallbacks(new androidx.media.MediaBrowserServiceCompat.ServiceCallbacksCompat(message.replyTo));
                    break;
                case 8:
                    android.os.Bundle bundle4 = data.getBundle(androidx.media.MediaBrowserProtocol.DATA_SEARCH_EXTRAS);
                    android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(bundle4);
                    this.mServiceBinderImpl.search(data.getString(androidx.media.MediaBrowserProtocol.DATA_SEARCH_QUERY), bundle4, (android.support.v4.os.ResultReceiver) data.getParcelable(androidx.media.MediaBrowserProtocol.DATA_RESULT_RECEIVER), new androidx.media.MediaBrowserServiceCompat.ServiceCallbacksCompat(message.replyTo));
                    break;
                case 9:
                    android.os.Bundle bundle5 = data.getBundle(androidx.media.MediaBrowserProtocol.DATA_CUSTOM_ACTION_EXTRAS);
                    android.support.v4.media.session.MediaSessionCompat.ensureClassLoader(bundle5);
                    this.mServiceBinderImpl.sendCustomAction(data.getString(androidx.media.MediaBrowserProtocol.DATA_CUSTOM_ACTION), bundle5, (android.support.v4.os.ResultReceiver) data.getParcelable(androidx.media.MediaBrowserProtocol.DATA_RESULT_RECEIVER), new androidx.media.MediaBrowserServiceCompat.ServiceCallbacksCompat(message.replyTo));
                    break;
                default:
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("Unhandled message: ");
                    sb.append(message);
                    sb.append("\n  Service version: ");
                    sb.append(2);
                    sb.append("\n  Client version: ");
                    sb.append(message.arg1);
                    break;
            }
        }

        public void postOrRun(java.lang.Runnable runnable) {
            if (java.lang.Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(android.os.Message message, long j) {
            android.os.Bundle data = message.getData();
            data.setClassLoader(android.support.v4.media.MediaBrowserCompat.class.getClassLoader());
            data.putInt(androidx.media.MediaBrowserProtocol.DATA_CALLING_UID, android.os.Binder.getCallingUid());
            data.putInt(androidx.media.MediaBrowserProtocol.DATA_CALLING_PID, android.os.Binder.getCallingPid());
            return super.sendMessageAtTime(message, j);
        }
    }

    public void addSubscription(java.lang.String str, androidx.media.MediaBrowserServiceCompat.ConnectionRecord connectionRecord, android.os.IBinder iBinder, android.os.Bundle bundle) {
        java.util.List<androidx.core.util.Pair<android.os.IBinder, android.os.Bundle>> list = connectionRecord.subscriptions.get(str);
        if (list == null) {
            list = new java.util.ArrayList<>();
        }
        for (androidx.core.util.Pair<android.os.IBinder, android.os.Bundle> pair : list) {
            if (iBinder == pair.first && androidx.media.MediaBrowserCompatUtils.areSameOptions(bundle, pair.second)) {
                return;
            }
        }
        list.add(new androidx.core.util.Pair<>(iBinder, bundle));
        connectionRecord.subscriptions.put(str, list);
        performLoadChildren(str, connectionRecord, bundle, null);
        this.mCurConnection = connectionRecord;
        onSubscribe(str, bundle);
        this.mCurConnection = null;
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

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    public void attachToBaseContext(android.content.Context context) {
        attachBaseContext(context);
    }

    @Override // android.app.Service
    public void dump(java.io.FileDescriptor fileDescriptor, java.io.PrintWriter printWriter, java.lang.String[] strArr) {
    }

    public final android.os.Bundle getBrowserRootHints() {
        return this.mImpl.getBrowserRootHints();
    }

    @androidx.annotation.NonNull
    public final androidx.media.MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
        return this.mImpl.getCurrentBrowserInfo();
    }

    @androidx.annotation.Nullable
    public android.support.v4.media.session.MediaSessionCompat.Token getSessionToken() {
        return this.mSession;
    }

    public boolean isValidPackage(java.lang.String str, int i) {
        if (str == null) {
            return false;
        }
        for (java.lang.String str2 : getPackageManager().getPackagesForUid(i)) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public void notifyChildrenChanged(@androidx.annotation.NonNull androidx.media.MediaSessionManager.RemoteUserInfo remoteUserInfo, @androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull android.os.Bundle bundle) {
        if (remoteUserInfo == null) {
            throw new java.lang.IllegalArgumentException("remoteUserInfo cannot be null in notifyChildrenChanged");
        }
        if (str == null) {
            throw new java.lang.IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }
        if (bundle == null) {
            throw new java.lang.IllegalArgumentException("options cannot be null in notifyChildrenChanged");
        }
        this.mImpl.notifyChildrenChanged(remoteUserInfo, str, bundle);
    }

    public void notifyChildrenChanged(@androidx.annotation.NonNull java.lang.String str) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }
        this.mImpl.notifyChildrenChanged(str, null);
    }

    public void notifyChildrenChanged(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull android.os.Bundle bundle) {
        if (str == null) {
            throw new java.lang.IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }
        if (bundle == null) {
            throw new java.lang.IllegalArgumentException("options cannot be null in notifyChildrenChanged");
        }
        this.mImpl.notifyChildrenChanged(str, bundle);
    }

    @Override // android.app.Service
    public android.os.IBinder onBind(android.content.Intent intent) {
        return this.mImpl.onBind(intent);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 28) {
            this.mImpl = new androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi28();
        } else if (i >= 26) {
            this.mImpl = new androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi26();
        } else if (i >= 23) {
            this.mImpl = new androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi23();
        } else {
            this.mImpl = new androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21();
        }
        this.mImpl.onCreate();
    }

    public void onCustomAction(@androidx.annotation.NonNull java.lang.String str, android.os.Bundle bundle, @androidx.annotation.NonNull androidx.media.MediaBrowserServiceCompat.Result<android.os.Bundle> result) {
        result.sendError(null);
    }

    @androidx.annotation.Nullable
    public abstract androidx.media.MediaBrowserServiceCompat.BrowserRoot onGetRoot(@androidx.annotation.NonNull java.lang.String str, int i, @androidx.annotation.Nullable android.os.Bundle bundle);

    public abstract void onLoadChildren(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull androidx.media.MediaBrowserServiceCompat.Result<java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem>> result);

    public void onLoadChildren(@androidx.annotation.NonNull java.lang.String str, @androidx.annotation.NonNull androidx.media.MediaBrowserServiceCompat.Result<java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem>> result, @androidx.annotation.NonNull android.os.Bundle bundle) {
        result.setFlags(1);
        onLoadChildren(str, result);
    }

    public void onLoadItem(java.lang.String str, @androidx.annotation.NonNull androidx.media.MediaBrowserServiceCompat.Result<android.support.v4.media.MediaBrowserCompat.MediaItem> result) {
        result.setFlags(2);
        result.sendResult(null);
    }

    public void onSearch(@androidx.annotation.NonNull java.lang.String str, android.os.Bundle bundle, @androidx.annotation.NonNull androidx.media.MediaBrowserServiceCompat.Result<java.util.List<android.support.v4.media.MediaBrowserCompat.MediaItem>> result) {
        result.setFlags(4);
        result.sendResult(null);
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public void onSubscribe(java.lang.String str, android.os.Bundle bundle) {
    }

    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
    public void onUnsubscribe(java.lang.String str) {
    }

    public void performCustomAction(java.lang.String str, android.os.Bundle bundle, androidx.media.MediaBrowserServiceCompat.ConnectionRecord connectionRecord, android.support.v4.os.ResultReceiver resultReceiver) {
        androidx.media.MediaBrowserServiceCompat.AnonymousClass4 anonymousClass4 = new androidx.media.MediaBrowserServiceCompat.AnonymousClass4(str, resultReceiver);
        this.mCurConnection = connectionRecord;
        onCustomAction(str, bundle, anonymousClass4);
        this.mCurConnection = null;
        if (anonymousClass4.isDone()) {
            return;
        }
        throw new java.lang.IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + str + " extras=" + bundle);
    }

    public void performLoadChildren(java.lang.String str, androidx.media.MediaBrowserServiceCompat.ConnectionRecord connectionRecord, android.os.Bundle bundle, android.os.Bundle bundle2) {
        androidx.media.MediaBrowserServiceCompat.AnonymousClass1 anonymousClass1 = new androidx.media.MediaBrowserServiceCompat.AnonymousClass1(str, connectionRecord, str, bundle, bundle2);
        this.mCurConnection = connectionRecord;
        if (bundle == null) {
            onLoadChildren(str, anonymousClass1);
        } else {
            onLoadChildren(str, anonymousClass1, bundle);
        }
        this.mCurConnection = null;
        if (anonymousClass1.isDone()) {
            return;
        }
        throw new java.lang.IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + connectionRecord.pkg + " id=" + str);
    }

    public void performLoadItem(java.lang.String str, androidx.media.MediaBrowserServiceCompat.ConnectionRecord connectionRecord, android.support.v4.os.ResultReceiver resultReceiver) {
        androidx.media.MediaBrowserServiceCompat.AnonymousClass2 anonymousClass2 = new androidx.media.MediaBrowserServiceCompat.AnonymousClass2(str, resultReceiver);
        this.mCurConnection = connectionRecord;
        onLoadItem(str, anonymousClass2);
        this.mCurConnection = null;
        if (anonymousClass2.isDone()) {
            return;
        }
        throw new java.lang.IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + str);
    }

    public void performSearch(java.lang.String str, android.os.Bundle bundle, androidx.media.MediaBrowserServiceCompat.ConnectionRecord connectionRecord, android.support.v4.os.ResultReceiver resultReceiver) {
        androidx.media.MediaBrowserServiceCompat.AnonymousClass3 anonymousClass3 = new androidx.media.MediaBrowserServiceCompat.AnonymousClass3(str, resultReceiver);
        this.mCurConnection = connectionRecord;
        onSearch(str, bundle, anonymousClass3);
        this.mCurConnection = null;
        if (anonymousClass3.isDone()) {
            return;
        }
        throw new java.lang.IllegalStateException("onSearch must call detach() or sendResult() before returning for query=" + str);
    }

    public boolean removeSubscription(java.lang.String str, androidx.media.MediaBrowserServiceCompat.ConnectionRecord connectionRecord, android.os.IBinder iBinder) {
        boolean z = false;
        try {
            if (iBinder == null) {
                return connectionRecord.subscriptions.remove(str) != null;
            }
            java.util.List<androidx.core.util.Pair<android.os.IBinder, android.os.Bundle>> list = connectionRecord.subscriptions.get(str);
            if (list != null) {
                java.util.Iterator<androidx.core.util.Pair<android.os.IBinder, android.os.Bundle>> it = list.iterator();
                while (it.hasNext()) {
                    if (iBinder == it.next().first) {
                        it.remove();
                        z = true;
                    }
                }
                if (list.size() == 0) {
                    connectionRecord.subscriptions.remove(str);
                }
            }
            return z;
        } finally {
            this.mCurConnection = connectionRecord;
            onUnsubscribe(str);
            this.mCurConnection = null;
        }
    }

    public void setSessionToken(android.support.v4.media.session.MediaSessionCompat.Token token) {
        if (token == null) {
            throw new java.lang.IllegalArgumentException("Session token may not be null.");
        }
        if (this.mSession != null) {
            throw new java.lang.IllegalStateException("The session token has already been set.");
        }
        this.mSession = token;
        this.mImpl.setSessionToken(token);
    }
}
