package com.huawei.agconnect;

/* loaded from: classes22.dex */
public class LocalBrdMnger {
    public static final java.lang.Object f = new java.lang.Object();
    public static com.huawei.agconnect.LocalBrdMnger g;
    public final android.content.Context a;
    public final java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<android.content.IntentFilter>> b = new java.util.HashMap<>();
    public final java.util.HashMap<java.lang.String, java.util.ArrayList<com.huawei.agconnect.LocalBrdMnger.ReceiverRecord>> c = new java.util.HashMap<>();
    public final java.util.ArrayList<com.huawei.agconnect.LocalBrdMnger.BroadcastRecord> d = new java.util.ArrayList<>();
    public final android.os.Handler e;

    /* renamed from: com.huawei.agconnect.LocalBrdMnger$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.Handler {
        public AnonymousClass1(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            if (message.what == 1) {
                com.huawei.agconnect.LocalBrdMnger.this.b();
            } else {
                super.handleMessage(message);
            }
        }
    }

    public static class BroadcastRecord {
        public final android.content.Intent a;
        public final java.util.ArrayList<com.huawei.agconnect.LocalBrdMnger.ReceiverRecord> b;

        public BroadcastRecord(android.content.Intent intent, java.util.ArrayList<com.huawei.agconnect.LocalBrdMnger.ReceiverRecord> arrayList) {
            this.a = intent;
            this.b = arrayList;
        }
    }

    public static class ReceiverRecord {
        public final android.content.IntentFilter a;
        public final android.content.BroadcastReceiver b;
        public boolean c;

        public ReceiverRecord(android.content.IntentFilter intentFilter, android.content.BroadcastReceiver broadcastReceiver) {
            this.a = intentFilter;
            this.b = broadcastReceiver;
        }

        public java.lang.String toString() {
            return "Receiver{" + this.b + " filter=" + this.a + com.alipay.sdk.m.u.i.d;
        }
    }

    public LocalBrdMnger(android.content.Context context) {
        this.a = context;
        this.e = new com.huawei.agconnect.LocalBrdMnger.AnonymousClass1(context.getMainLooper());
    }

    public static com.huawei.agconnect.LocalBrdMnger getInstance(android.content.Context context) {
        com.huawei.agconnect.LocalBrdMnger localBrdMnger;
        synchronized (f) {
            if (g == null) {
                g = new com.huawei.agconnect.LocalBrdMnger(context.getApplicationContext());
            }
            localBrdMnger = g;
        }
        return localBrdMnger;
    }

    public final void b() {
        int size;
        com.huawei.agconnect.LocalBrdMnger.BroadcastRecord[] broadcastRecordArr;
        while (true) {
            synchronized (this.b) {
                size = this.d.size();
                if (size <= 0) {
                    return;
                }
                broadcastRecordArr = new com.huawei.agconnect.LocalBrdMnger.BroadcastRecord[size];
                this.d.toArray(broadcastRecordArr);
                this.d.clear();
            }
            for (int i = 0; i < size; i++) {
                com.huawei.agconnect.LocalBrdMnger.BroadcastRecord broadcastRecord = broadcastRecordArr[i];
                for (int i2 = 0; i2 < broadcastRecord.b.size(); i2++) {
                    broadcastRecord.b.get(i2).b.onReceive(this.a, broadcastRecord.a);
                }
            }
        }
    }

    public void registerReceiver(android.content.BroadcastReceiver broadcastReceiver, android.content.IntentFilter intentFilter) {
        synchronized (this.b) {
            com.huawei.agconnect.LocalBrdMnger.ReceiverRecord receiverRecord = new com.huawei.agconnect.LocalBrdMnger.ReceiverRecord(intentFilter, broadcastReceiver);
            java.util.ArrayList<android.content.IntentFilter> arrayList = this.b.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new java.util.ArrayList<>(1);
                this.b.put(broadcastReceiver, arrayList);
            }
            arrayList.add(intentFilter);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                java.lang.String action = intentFilter.getAction(i);
                java.util.ArrayList<com.huawei.agconnect.LocalBrdMnger.ReceiverRecord> arrayList2 = this.c.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new java.util.ArrayList<>(1);
                    this.c.put(action, arrayList2);
                }
                arrayList2.add(receiverRecord);
            }
        }
    }

    public boolean sendBroadcast(android.content.Intent intent) {
        boolean z;
        java.lang.String str;
        java.lang.String str2;
        int i;
        java.util.ArrayList arrayList;
        android.net.Uri uri;
        synchronized (this.b) {
            java.lang.String action = intent.getAction();
            java.lang.String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.a.getContentResolver());
            android.net.Uri data = intent.getData();
            java.lang.String scheme = intent.getScheme();
            java.util.Set<java.lang.String> categories = intent.getCategories();
            java.util.ArrayList<com.huawei.agconnect.LocalBrdMnger.ReceiverRecord> arrayList2 = this.c.get(intent.getAction());
            if (arrayList2 != null) {
                java.util.ArrayList arrayList3 = null;
                int i2 = 0;
                while (i2 < arrayList2.size()) {
                    com.huawei.agconnect.LocalBrdMnger.ReceiverRecord receiverRecord = arrayList2.get(i2);
                    if (receiverRecord.c) {
                        i = i2;
                        str = action;
                        str2 = resolveTypeIfNeeded;
                        uri = data;
                        arrayList = arrayList3;
                    } else {
                        str = action;
                        str2 = resolveTypeIfNeeded;
                        i = i2;
                        arrayList = arrayList3;
                        uri = data;
                        if (receiverRecord.a.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager") >= 0) {
                            arrayList3 = arrayList == null ? new java.util.ArrayList() : arrayList;
                            arrayList3.add(receiverRecord);
                            receiverRecord.c = true;
                            i2 = i + 1;
                            action = str;
                            resolveTypeIfNeeded = str2;
                            data = uri;
                        }
                    }
                    arrayList3 = arrayList;
                    i2 = i + 1;
                    action = str;
                    resolveTypeIfNeeded = str2;
                    data = uri;
                }
                java.util.ArrayList arrayList4 = arrayList3;
                z = false;
                if (arrayList4 != null) {
                    for (int i3 = 0; i3 < arrayList4.size(); i3++) {
                        ((com.huawei.agconnect.LocalBrdMnger.ReceiverRecord) arrayList4.get(i3)).c = false;
                    }
                    this.d.add(new com.huawei.agconnect.LocalBrdMnger.BroadcastRecord(intent, arrayList4));
                    if (!this.e.hasMessages(1)) {
                        this.e.sendEmptyMessage(1);
                    }
                    return true;
                }
            } else {
                z = false;
            }
            return z;
        }
    }

    public void unregisterReceiver(android.content.BroadcastReceiver broadcastReceiver) {
        synchronized (this.b) {
            java.util.ArrayList<android.content.IntentFilter> remove = this.b.remove(broadcastReceiver);
            if (remove == null) {
                return;
            }
            for (int i = 0; i < remove.size(); i++) {
                android.content.IntentFilter intentFilter = remove.get(i);
                for (int i2 = 0; i2 < intentFilter.countActions(); i2++) {
                    java.lang.String action = intentFilter.getAction(i2);
                    java.util.ArrayList<com.huawei.agconnect.LocalBrdMnger.ReceiverRecord> arrayList = this.c.get(action);
                    if (arrayList != null) {
                        int i3 = 0;
                        while (i3 < arrayList.size()) {
                            if (arrayList.get(i3).b == broadcastReceiver) {
                                arrayList.remove(i3);
                                i3--;
                            }
                            i3++;
                        }
                        if (arrayList.size() <= 0) {
                            this.c.remove(action);
                        }
                    }
                }
            }
        }
    }
}
