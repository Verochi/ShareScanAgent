package androidx.localbroadcastmanager.content;

/* loaded from: classes.dex */
public final class LocalBroadcastManager {
    private static final boolean DEBUG = false;
    static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    private static final java.lang.String TAG = "LocalBroadcastManager";
    private static androidx.localbroadcastmanager.content.LocalBroadcastManager mInstance;
    private static final java.lang.Object mLock = new java.lang.Object();
    private final android.content.Context mAppContext;
    private final android.os.Handler mHandler;
    private final java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<androidx.localbroadcastmanager.content.LocalBroadcastManager.ReceiverRecord>> mReceivers = new java.util.HashMap<>();
    private final java.util.HashMap<java.lang.String, java.util.ArrayList<androidx.localbroadcastmanager.content.LocalBroadcastManager.ReceiverRecord>> mActions = new java.util.HashMap<>();
    private final java.util.ArrayList<androidx.localbroadcastmanager.content.LocalBroadcastManager.BroadcastRecord> mPendingBroadcasts = new java.util.ArrayList<>();

    /* renamed from: androidx.localbroadcastmanager.content.LocalBroadcastManager$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.Handler {
        public AnonymousClass1(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            if (message.what != 1) {
                super.handleMessage(message);
            } else {
                androidx.localbroadcastmanager.content.LocalBroadcastManager.this.executePendingBroadcasts();
            }
        }
    }

    public static final class BroadcastRecord {
        final android.content.Intent intent;
        final java.util.ArrayList<androidx.localbroadcastmanager.content.LocalBroadcastManager.ReceiverRecord> receivers;

        public BroadcastRecord(android.content.Intent intent, java.util.ArrayList<androidx.localbroadcastmanager.content.LocalBroadcastManager.ReceiverRecord> arrayList) {
            this.intent = intent;
            this.receivers = arrayList;
        }
    }

    public static final class ReceiverRecord {
        boolean broadcasting;
        boolean dead;
        final android.content.IntentFilter filter;
        final android.content.BroadcastReceiver receiver;

        public ReceiverRecord(android.content.IntentFilter intentFilter, android.content.BroadcastReceiver broadcastReceiver) {
            this.filter = intentFilter;
            this.receiver = broadcastReceiver;
        }

        public java.lang.String toString() {
            java.lang.StringBuilder sb = new java.lang.StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.receiver);
            sb.append(" filter=");
            sb.append(this.filter);
            if (this.dead) {
                sb.append(" DEAD");
            }
            sb.append(com.alipay.sdk.m.u.i.d);
            return sb.toString();
        }
    }

    private LocalBroadcastManager(android.content.Context context) {
        this.mAppContext = context;
        this.mHandler = new androidx.localbroadcastmanager.content.LocalBroadcastManager.AnonymousClass1(context.getMainLooper());
    }

    @androidx.annotation.NonNull
    public static androidx.localbroadcastmanager.content.LocalBroadcastManager getInstance(@androidx.annotation.NonNull android.content.Context context) {
        androidx.localbroadcastmanager.content.LocalBroadcastManager localBroadcastManager;
        synchronized (mLock) {
            if (mInstance == null) {
                mInstance = new androidx.localbroadcastmanager.content.LocalBroadcastManager(context.getApplicationContext());
            }
            localBroadcastManager = mInstance;
        }
        return localBroadcastManager;
    }

    public void executePendingBroadcasts() {
        int size;
        androidx.localbroadcastmanager.content.LocalBroadcastManager.BroadcastRecord[] broadcastRecordArr;
        while (true) {
            synchronized (this.mReceivers) {
                size = this.mPendingBroadcasts.size();
                if (size <= 0) {
                    return;
                }
                broadcastRecordArr = new androidx.localbroadcastmanager.content.LocalBroadcastManager.BroadcastRecord[size];
                this.mPendingBroadcasts.toArray(broadcastRecordArr);
                this.mPendingBroadcasts.clear();
            }
            for (int i = 0; i < size; i++) {
                androidx.localbroadcastmanager.content.LocalBroadcastManager.BroadcastRecord broadcastRecord = broadcastRecordArr[i];
                int size2 = broadcastRecord.receivers.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    androidx.localbroadcastmanager.content.LocalBroadcastManager.ReceiverRecord receiverRecord = broadcastRecord.receivers.get(i2);
                    if (!receiverRecord.dead) {
                        receiverRecord.receiver.onReceive(this.mAppContext, broadcastRecord.intent);
                    }
                }
            }
        }
    }

    public void registerReceiver(@androidx.annotation.NonNull android.content.BroadcastReceiver broadcastReceiver, @androidx.annotation.NonNull android.content.IntentFilter intentFilter) {
        synchronized (this.mReceivers) {
            androidx.localbroadcastmanager.content.LocalBroadcastManager.ReceiverRecord receiverRecord = new androidx.localbroadcastmanager.content.LocalBroadcastManager.ReceiverRecord(intentFilter, broadcastReceiver);
            java.util.ArrayList<androidx.localbroadcastmanager.content.LocalBroadcastManager.ReceiverRecord> arrayList = this.mReceivers.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new java.util.ArrayList<>(1);
                this.mReceivers.put(broadcastReceiver, arrayList);
            }
            arrayList.add(receiverRecord);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                java.lang.String action = intentFilter.getAction(i);
                java.util.ArrayList<androidx.localbroadcastmanager.content.LocalBroadcastManager.ReceiverRecord> arrayList2 = this.mActions.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new java.util.ArrayList<>(1);
                    this.mActions.put(action, arrayList2);
                }
                arrayList2.add(receiverRecord);
            }
        }
    }

    public boolean sendBroadcast(@androidx.annotation.NonNull android.content.Intent intent) {
        int i;
        java.lang.String str;
        java.util.ArrayList arrayList;
        java.util.ArrayList<androidx.localbroadcastmanager.content.LocalBroadcastManager.ReceiverRecord> arrayList2;
        java.lang.String str2;
        synchronized (this.mReceivers) {
            java.lang.String action = intent.getAction();
            java.lang.String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.mAppContext.getContentResolver());
            android.net.Uri data = intent.getData();
            java.lang.String scheme = intent.getScheme();
            java.util.Set<java.lang.String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("Resolving type ");
                sb.append(resolveTypeIfNeeded);
                sb.append(" scheme ");
                sb.append(scheme);
                sb.append(" of intent ");
                sb.append(intent);
            }
            java.util.ArrayList<androidx.localbroadcastmanager.content.LocalBroadcastManager.ReceiverRecord> arrayList3 = this.mActions.get(intent.getAction());
            if (arrayList3 != null) {
                if (z) {
                    java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                    sb2.append("Action list: ");
                    sb2.append(arrayList3);
                }
                java.util.ArrayList arrayList4 = null;
                int i2 = 0;
                while (i2 < arrayList3.size()) {
                    androidx.localbroadcastmanager.content.LocalBroadcastManager.ReceiverRecord receiverRecord = arrayList3.get(i2);
                    if (z) {
                        java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                        sb3.append("Matching against filter ");
                        sb3.append(receiverRecord.filter);
                    }
                    if (receiverRecord.broadcasting) {
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
                        int match = receiverRecord.filter.match(action, resolveTypeIfNeeded, scheme, data, categories, TAG);
                        if (match >= 0) {
                            if (z) {
                                java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
                                sb4.append("  Filter matched!  match=0x");
                                sb4.append(java.lang.Integer.toHexString(match));
                            }
                            arrayList4 = arrayList == null ? new java.util.ArrayList() : arrayList;
                            arrayList4.add(receiverRecord);
                            receiverRecord.broadcasting = true;
                            i2 = i + 1;
                            action = str;
                            arrayList3 = arrayList2;
                            resolveTypeIfNeeded = str2;
                        } else if (z) {
                            java.lang.String str3 = match != -4 ? match != -3 ? match != -2 ? match != -1 ? "unknown reason" : "type" : "data" : "action" : "category";
                            java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
                            sb5.append("  Filter did not match: ");
                            sb5.append(str3);
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
                        ((androidx.localbroadcastmanager.content.LocalBroadcastManager.ReceiverRecord) arrayList5.get(i3)).broadcasting = false;
                    }
                    this.mPendingBroadcasts.add(new androidx.localbroadcastmanager.content.LocalBroadcastManager.BroadcastRecord(intent, arrayList5));
                    if (!this.mHandler.hasMessages(1)) {
                        this.mHandler.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public void sendBroadcastSync(@androidx.annotation.NonNull android.content.Intent intent) {
        if (sendBroadcast(intent)) {
            executePendingBroadcasts();
        }
    }

    public void unregisterReceiver(@androidx.annotation.NonNull android.content.BroadcastReceiver broadcastReceiver) {
        synchronized (this.mReceivers) {
            java.util.ArrayList<androidx.localbroadcastmanager.content.LocalBroadcastManager.ReceiverRecord> remove = this.mReceivers.remove(broadcastReceiver);
            if (remove == null) {
                return;
            }
            for (int size = remove.size() - 1; size >= 0; size--) {
                androidx.localbroadcastmanager.content.LocalBroadcastManager.ReceiverRecord receiverRecord = remove.get(size);
                receiverRecord.dead = true;
                for (int i = 0; i < receiverRecord.filter.countActions(); i++) {
                    java.lang.String action = receiverRecord.filter.getAction(i);
                    java.util.ArrayList<androidx.localbroadcastmanager.content.LocalBroadcastManager.ReceiverRecord> arrayList = this.mActions.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            androidx.localbroadcastmanager.content.LocalBroadcastManager.ReceiverRecord receiverRecord2 = arrayList.get(size2);
                            if (receiverRecord2.receiver == broadcastReceiver) {
                                receiverRecord2.dead = true;
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
