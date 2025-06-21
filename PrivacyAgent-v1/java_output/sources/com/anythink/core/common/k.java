package com.anythink.core.common;

/* loaded from: classes12.dex */
public final class k {
    static final int a = 1;
    private static final java.lang.String b = "InnerBroadcastManager";
    private static final boolean c = false;
    private static final java.lang.Object i = new java.lang.Object();
    private static com.anythink.core.common.k j;
    private final android.content.Context d;
    private final java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<com.anythink.core.common.k.b>> e = new java.util.HashMap<>();
    private final java.util.HashMap<java.lang.String, java.util.ArrayList<com.anythink.core.common.k.b>> f = new java.util.HashMap<>();
    private final java.util.ArrayList<com.anythink.core.common.k.a> g = new java.util.ArrayList<>();
    private final android.os.Handler h;

    /* renamed from: com.anythink.core.common.k$1, reason: invalid class name */
    public class AnonymousClass1 extends android.os.Handler {
        public AnonymousClass1(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(android.os.Message message) {
            if (message.what != 1) {
                super.handleMessage(message);
            } else {
                com.anythink.core.common.k.this.a();
            }
        }
    }

    public static final class a {
        final android.content.Intent a;
        final java.util.ArrayList<com.anythink.core.common.k.b> b;

        public a(android.content.Intent intent, java.util.ArrayList<com.anythink.core.common.k.b> arrayList) {
            this.a = intent;
            this.b = arrayList;
        }
    }

    public static final class b {
        final android.content.IntentFilter a;
        final android.content.BroadcastReceiver b;
        boolean c;
        boolean d;

        public b(android.content.IntentFilter intentFilter, android.content.BroadcastReceiver broadcastReceiver) {
            this.a = intentFilter;
            this.b = broadcastReceiver;
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

    private k(android.content.Context context) {
        this.d = context;
        this.h = new com.anythink.core.common.k.AnonymousClass1(context.getMainLooper());
    }

    public static com.anythink.core.common.k a(android.content.Context context) {
        com.anythink.core.common.k kVar;
        synchronized (i) {
            if (j == null) {
                j = new com.anythink.core.common.k(context.getApplicationContext());
            }
            kVar = j;
        }
        return kVar;
    }

    private void b(android.content.Intent intent) {
        if (a(intent)) {
            a();
        }
    }

    public final void a() {
        int size;
        com.anythink.core.common.k.a[] aVarArr;
        while (true) {
            synchronized (this.e) {
                size = this.g.size();
                if (size <= 0) {
                    return;
                }
                aVarArr = new com.anythink.core.common.k.a[size];
                this.g.toArray(aVarArr);
                this.g.clear();
            }
            for (int i2 = 0; i2 < size; i2++) {
                com.anythink.core.common.k.a aVar = aVarArr[i2];
                int size2 = aVar.b.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    com.anythink.core.common.k.b bVar = aVar.b.get(i3);
                    if (!bVar.d) {
                        bVar.b.onReceive(this.d, aVar.a);
                    }
                }
            }
        }
    }

    public final void a(android.content.BroadcastReceiver broadcastReceiver) {
        synchronized (this.e) {
            java.util.ArrayList<com.anythink.core.common.k.b> remove = this.e.remove(broadcastReceiver);
            if (remove != null) {
                for (int size = remove.size() - 1; size >= 0; size--) {
                    com.anythink.core.common.k.b bVar = remove.get(size);
                    bVar.d = true;
                    for (int i2 = 0; i2 < bVar.a.countActions(); i2++) {
                        java.lang.String action = bVar.a.getAction(i2);
                        java.util.ArrayList<com.anythink.core.common.k.b> arrayList = this.f.get(action);
                        if (arrayList != null) {
                            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                                com.anythink.core.common.k.b bVar2 = arrayList.get(size2);
                                if (bVar2.b == broadcastReceiver) {
                                    bVar2.d = true;
                                    arrayList.remove(size2);
                                }
                            }
                            if (arrayList.size() <= 0) {
                                this.f.remove(action);
                            }
                        }
                    }
                }
            }
        }
    }

    public final void a(android.content.BroadcastReceiver broadcastReceiver, android.content.IntentFilter intentFilter) {
        synchronized (this.e) {
            com.anythink.core.common.k.b bVar = new com.anythink.core.common.k.b(intentFilter, broadcastReceiver);
            java.util.ArrayList<com.anythink.core.common.k.b> arrayList = this.e.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new java.util.ArrayList<>(1);
                this.e.put(broadcastReceiver, arrayList);
            }
            arrayList.add(bVar);
            for (int i2 = 0; i2 < intentFilter.countActions(); i2++) {
                java.lang.String action = intentFilter.getAction(i2);
                java.util.ArrayList<com.anythink.core.common.k.b> arrayList2 = this.f.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new java.util.ArrayList<>(1);
                    this.f.put(action, arrayList2);
                }
                arrayList2.add(bVar);
            }
        }
    }

    public final boolean a(android.content.Intent intent) {
        int i2;
        java.lang.String str;
        java.util.ArrayList arrayList;
        java.util.ArrayList<com.anythink.core.common.k.b> arrayList2;
        java.lang.String str2;
        synchronized (this.e) {
            java.lang.String action = intent.getAction();
            java.lang.String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.d.getContentResolver());
            android.net.Uri data = intent.getData();
            java.lang.String scheme = intent.getScheme();
            java.util.Set<java.lang.String> categories = intent.getCategories();
            boolean z = (intent.getFlags() & 8) != 0;
            if (z) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder("Resolving type ");
                sb.append(resolveTypeIfNeeded);
                sb.append(" scheme ");
                sb.append(scheme);
                sb.append(" of intent ");
                sb.append(intent);
            }
            java.util.ArrayList<com.anythink.core.common.k.b> arrayList3 = this.f.get(intent.getAction());
            if (arrayList3 != null) {
                if (z) {
                    "Action list: ".concat(java.lang.String.valueOf(arrayList3));
                }
                java.util.ArrayList arrayList4 = null;
                int i3 = 0;
                while (i3 < arrayList3.size()) {
                    com.anythink.core.common.k.b bVar = arrayList3.get(i3);
                    if (z) {
                        new java.lang.StringBuilder("Matching against filter ").append(bVar.a);
                    }
                    if (bVar.c) {
                        i2 = i3;
                        arrayList2 = arrayList3;
                        str = action;
                        str2 = resolveTypeIfNeeded;
                        arrayList = arrayList4;
                    } else {
                        i2 = i3;
                        str = action;
                        arrayList = arrayList4;
                        arrayList2 = arrayList3;
                        str2 = resolveTypeIfNeeded;
                        int match = bVar.a.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (match >= 0) {
                            if (z) {
                                new java.lang.StringBuilder("  Filter matched!  match=0x").append(java.lang.Integer.toHexString(match));
                            }
                            arrayList4 = arrayList == null ? new java.util.ArrayList() : arrayList;
                            arrayList4.add(bVar);
                            bVar.c = true;
                            i3 = i2 + 1;
                            action = str;
                            arrayList3 = arrayList2;
                            resolveTypeIfNeeded = str2;
                        } else if (z) {
                            "  Filter did not match: ".concat(match != -4 ? match != -3 ? match != -2 ? match != -1 ? "unknown reason" : "type" : "data" : "action" : "category");
                        }
                    }
                    arrayList4 = arrayList;
                    i3 = i2 + 1;
                    action = str;
                    arrayList3 = arrayList2;
                    resolveTypeIfNeeded = str2;
                }
                java.util.ArrayList arrayList5 = arrayList4;
                if (arrayList5 != null) {
                    for (int i4 = 0; i4 < arrayList5.size(); i4++) {
                        ((com.anythink.core.common.k.b) arrayList5.get(i4)).c = false;
                    }
                    this.g.add(new com.anythink.core.common.k.a(intent, arrayList5));
                    if (!this.h.hasMessages(1)) {
                        this.h.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }
}
