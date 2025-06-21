package com.sijla.f;

/* loaded from: classes19.dex */
public final class a {
    private static final java.lang.Object f = new java.lang.Object();
    private static com.sijla.f.a g;
    private final android.content.Context a;
    private final java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<com.sijla.f.a.b>> b = new java.util.HashMap<>();
    private final java.util.HashMap<java.lang.String, java.util.ArrayList<com.sijla.f.a.b>> c = new java.util.HashMap<>();
    private final java.util.ArrayList<com.sijla.f.a.C0448a> d = new java.util.ArrayList<>();
    private final android.os.Handler e;

    /* renamed from: com.sijla.f.a$a, reason: collision with other inner class name */
    public static final class C0448a {
        final android.content.Intent a;
        final java.util.ArrayList<com.sijla.f.a.b> b;

        public C0448a(android.content.Intent intent, java.util.ArrayList<com.sijla.f.a.b> arrayList) {
            this.a = intent;
            this.b = arrayList;
        }
    }

    public static final class b {
        final android.content.IntentFilter a;
        final android.content.BroadcastReceiver b;
        boolean c;

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
            sb.append(com.alipay.sdk.m.u.i.d);
            return sb.toString();
        }
    }

    private a(android.content.Context context) {
        this.a = context;
        this.e = new com.sijla.f.b(this, context.getMainLooper());
    }

    public static com.sijla.f.a a(android.content.Context context) {
        com.sijla.f.a aVar;
        synchronized (f) {
            if (g == null) {
                g = new com.sijla.f.a(context.getApplicationContext());
            }
            aVar = g;
        }
        return aVar;
    }

    public static void a(android.content.Context context, android.content.Intent intent) {
        try {
            a(context).b(intent);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean a(android.content.Intent intent) {
        int i;
        java.lang.String str;
        java.util.ArrayList arrayList;
        java.util.ArrayList<com.sijla.f.a.b> arrayList2;
        java.lang.String str2;
        synchronized (this.b) {
            java.lang.String action = intent.getAction();
            java.lang.String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.a.getContentResolver());
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
            java.util.ArrayList<com.sijla.f.a.b> arrayList3 = this.c.get(intent.getAction());
            if (arrayList3 != null) {
                if (z) {
                    "Action list: ".concat(java.lang.String.valueOf(arrayList3));
                }
                java.util.ArrayList arrayList4 = null;
                int i2 = 0;
                while (i2 < arrayList3.size()) {
                    com.sijla.f.a.b bVar = arrayList3.get(i2);
                    if (z) {
                        new java.lang.StringBuilder("Matching against filter ").append(bVar.a);
                    }
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
                        int match = bVar.a.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (match >= 0) {
                            if (z) {
                                new java.lang.StringBuilder("  Filter matched!  match=0x").append(java.lang.Integer.toHexString(match));
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
                        ((com.sijla.f.a.b) arrayList5.get(i3)).c = false;
                    }
                    this.d.add(new com.sijla.f.a.C0448a(intent, arrayList5));
                    if (!this.e.hasMessages(1)) {
                        this.e.sendEmptyMessage(1);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    private void b(android.content.Intent intent) {
        if (a(intent)) {
            a();
        }
    }

    public final void a() {
        int size;
        com.sijla.f.a.C0448a[] c0448aArr;
        while (true) {
            synchronized (this.b) {
                size = this.d.size();
                if (size <= 0) {
                    return;
                }
                c0448aArr = new com.sijla.f.a.C0448a[size];
                this.d.toArray(c0448aArr);
                this.d.clear();
            }
            for (int i = 0; i < size; i++) {
                com.sijla.f.a.C0448a c0448a = c0448aArr[i];
                int size2 = c0448a.b.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    c0448a.b.get(i2).b.onReceive(this.a, c0448a.a);
                }
            }
        }
    }

    public final void a(android.content.BroadcastReceiver broadcastReceiver, android.content.IntentFilter intentFilter) {
        synchronized (this.b) {
            com.sijla.f.a.b bVar = new com.sijla.f.a.b(intentFilter, broadcastReceiver);
            java.util.ArrayList<com.sijla.f.a.b> arrayList = this.b.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new java.util.ArrayList<>(1);
                this.b.put(broadcastReceiver, arrayList);
            }
            arrayList.add(bVar);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                java.lang.String action = intentFilter.getAction(i);
                java.util.ArrayList<com.sijla.f.a.b> arrayList2 = this.c.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new java.util.ArrayList<>(1);
                    this.c.put(action, arrayList2);
                }
                arrayList2.add(bVar);
            }
        }
    }
}
