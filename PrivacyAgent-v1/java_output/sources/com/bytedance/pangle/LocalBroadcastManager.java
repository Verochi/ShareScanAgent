package com.bytedance.pangle;

@androidx.annotation.Keep
/* loaded from: classes12.dex */
public final class LocalBroadcastManager {
    private static final boolean DEBUG = false;
    static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    private static final java.lang.String TAG = "LocalBroadcastManager";
    private static com.bytedance.pangle.LocalBroadcastManager mInstance;
    private static final java.lang.Object mLock = new java.lang.Object();
    private final android.content.Context mAppContext;
    private final android.os.Handler mHandler;
    private final java.util.HashMap<com.bytedance.pangle.receiver.PluginBroadcastReceiver, java.util.ArrayList<com.bytedance.pangle.LocalBroadcastManager.b>> mReceivers = new java.util.HashMap<>();
    private final java.util.HashMap<java.lang.String, java.util.ArrayList<com.bytedance.pangle.LocalBroadcastManager.b>> mActions = new java.util.HashMap<>();
    private final java.util.ArrayList<com.bytedance.pangle.LocalBroadcastManager.a> mPendingBroadcasts = new java.util.ArrayList<>();

    /* renamed from: com.bytedance.pangle.LocalBroadcastManager$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.Handler {
        public AnonymousClass1(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(android.os.Message message) {
            if (message.what != 1) {
                super.handleMessage(message);
            } else {
                com.bytedance.pangle.LocalBroadcastManager.this.executePendingBroadcasts();
            }
        }
    }

    public static final class a {
        final android.content.Intent a;
        final java.util.ArrayList<com.bytedance.pangle.LocalBroadcastManager.b> b;

        public a(android.content.Intent intent, java.util.ArrayList<com.bytedance.pangle.LocalBroadcastManager.b> arrayList) {
            this.a = intent;
            this.b = arrayList;
        }
    }

    public static final class b {
        final android.content.IntentFilter a;
        final com.bytedance.pangle.receiver.PluginBroadcastReceiver b;
        boolean c;
        boolean d;

        public b(android.content.IntentFilter intentFilter, com.bytedance.pangle.receiver.PluginBroadcastReceiver pluginBroadcastReceiver) {
            this.a = intentFilter;
            this.b = pluginBroadcastReceiver;
        }

        public final java.lang.String toString() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.b);
            sb.append(" filter=");
            sb.append(this.a);
            if (this.d) {
                sb.append(" DEAD");
            }
            sb.append(com.alipay.sdk.m.u.i.d);
            return sb.toString();
        }
    }

    private LocalBroadcastManager(android.content.Context context) {
        this.mAppContext = context;
        this.mHandler = new com.bytedance.pangle.LocalBroadcastManager.AnonymousClass1(context.getMainLooper());
    }

    public static com.bytedance.pangle.LocalBroadcastManager getInstance(android.content.Context context) {
        com.bytedance.pangle.LocalBroadcastManager localBroadcastManager;
        synchronized (mLock) {
            if (mInstance == null) {
                mInstance = new com.bytedance.pangle.LocalBroadcastManager(context.getApplicationContext());
            }
            localBroadcastManager = mInstance;
        }
        return localBroadcastManager;
    }

    public final void executePendingBroadcasts() {
        int size;
        com.bytedance.pangle.LocalBroadcastManager.a[] aVarArr;
        while (true) {
            synchronized (this.mReceivers) {
                size = this.mPendingBroadcasts.size();
                if (size <= 0) {
                    return;
                }
                aVarArr = new com.bytedance.pangle.LocalBroadcastManager.a[size];
                this.mPendingBroadcasts.toArray(aVarArr);
                this.mPendingBroadcasts.clear();
            }
            for (int i = 0; i < size; i++) {
                com.bytedance.pangle.LocalBroadcastManager.a aVar = aVarArr[i];
                int size2 = aVar.b.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    com.bytedance.pangle.LocalBroadcastManager.b bVar = aVar.b.get(i2);
                    if (!bVar.d) {
                        bVar.b.onReceive(this.mAppContext, aVar.a);
                    }
                }
            }
        }
    }

    public final void registerReceiver(com.bytedance.pangle.receiver.PluginBroadcastReceiver pluginBroadcastReceiver, android.content.IntentFilter intentFilter) {
        synchronized (this.mReceivers) {
            com.bytedance.pangle.LocalBroadcastManager.b bVar = new com.bytedance.pangle.LocalBroadcastManager.b(intentFilter, pluginBroadcastReceiver);
            java.util.ArrayList<com.bytedance.pangle.LocalBroadcastManager.b> arrayList = this.mReceivers.get(pluginBroadcastReceiver);
            if (arrayList == null) {
                arrayList = new java.util.ArrayList<>(1);
                this.mReceivers.put(pluginBroadcastReceiver, arrayList);
            }
            arrayList.add(bVar);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                java.lang.String action = intentFilter.getAction(i);
                java.util.ArrayList<com.bytedance.pangle.LocalBroadcastManager.b> arrayList2 = this.mActions.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new java.util.ArrayList<>(1);
                    this.mActions.put(action, arrayList2);
                }
                arrayList2.add(bVar);
            }
        }
    }

    public final boolean sendBroadcast(android.content.Intent intent) {
        int i;
        java.lang.String str;
        java.util.ArrayList arrayList;
        java.util.ArrayList<com.bytedance.pangle.LocalBroadcastManager.b> arrayList2;
        java.lang.String str2;
        synchronized (this.mReceivers) {
            java.lang.String action = intent.getAction();
            java.lang.String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.mAppContext.getContentResolver());
            android.net.Uri data = intent.getData();
            java.lang.String scheme = intent.getScheme();
            java.util.Set<java.lang.String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            java.util.ArrayList<com.bytedance.pangle.LocalBroadcastManager.b> arrayList3 = this.mActions.get(intent.getAction());
            if (arrayList3 != null) {
                if (z) {
                    "Action list: ".concat(java.lang.String.valueOf(arrayList3));
                }
                java.util.ArrayList arrayList4 = null;
                int i2 = 0;
                while (i2 < arrayList3.size()) {
                    com.bytedance.pangle.LocalBroadcastManager.b bVar = arrayList3.get(i2);
                    if (bVar.c) {
                        i = i2;
                        arrayList2 = arrayList3;
                        str = action;
                        str2 = resolveTypeIfNeeded;
                        arrayList = arrayList4;
                    } else {
                        i = i2;
                        str = action;
                        arrayList = arrayList4;
                        arrayList2 = arrayList3;
                        str2 = resolveTypeIfNeeded;
                        int match = bVar.a.match(action, resolveTypeIfNeeded, scheme, data, categories, TAG);
                        if (match >= 0) {
                            if (z) {
                                java.lang.Integer.toHexString(match);
                            }
                            arrayList4 = arrayList == null ? new java.util.ArrayList() : arrayList;
                            arrayList4.add(bVar);
                            bVar.c = true;
                            i2 = i + 1;
                            action = str;
                            arrayList3 = arrayList2;
                            resolveTypeIfNeeded = str2;
                        } else if (z) {
                            "  Filter did not match: ".concat(match != -4 ? match != -3 ? match != -2 ? match != -1 ? "unknown reason" : "type" : "data" : "action" : "category");
                        }
                    }
                    arrayList4 = arrayList;
                    i2 = i + 1;
                    action = str;
                    arrayList3 = arrayList2;
                    resolveTypeIfNeeded = str2;
                }
                java.util.ArrayList arrayList5 = arrayList4;
                if (arrayList5 != null) {
                    for (int i3 = 0; i3 < arrayList5.size(); i3++) {
                        ((com.bytedance.pangle.LocalBroadcastManager.b) arrayList5.get(i3)).c = false;
                    }
                    this.mPendingBroadcasts.add(new com.bytedance.pangle.LocalBroadcastManager.a(intent, arrayList5));
                    if (!this.mHandler.hasMessages(1)) {
                        this.mHandler.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public final void sendBroadcastSync(android.content.Intent intent) {
        if (sendBroadcast(intent)) {
            executePendingBroadcasts();
        }
    }

    public final void unregisterReceiver(com.bytedance.pangle.receiver.PluginBroadcastReceiver pluginBroadcastReceiver) {
        synchronized (this.mReceivers) {
            java.util.ArrayList<com.bytedance.pangle.LocalBroadcastManager.b> remove = this.mReceivers.remove(pluginBroadcastReceiver);
            if (remove == null) {
                return;
            }
            for (int size = remove.size() - 1; size >= 0; size--) {
                com.bytedance.pangle.LocalBroadcastManager.b bVar = remove.get(size);
                bVar.d = true;
                for (int i = 0; i < bVar.a.countActions(); i++) {
                    java.lang.String action = bVar.a.getAction(i);
                    java.util.ArrayList<com.bytedance.pangle.LocalBroadcastManager.b> arrayList = this.mActions.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            com.bytedance.pangle.LocalBroadcastManager.b bVar2 = arrayList.get(size2);
                            if (bVar2.b == pluginBroadcastReceiver) {
                                bVar2.d = true;
                                arrayList.remove(size2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.mActions.remove(action);
                        }
                    }
                }
            }
        }
    }
}
