package com.bytedance.pangle.receiver;

/* loaded from: classes12.dex */
public final class c {
    private static com.bytedance.pangle.receiver.c d;
    public final java.util.Map<java.lang.String, com.bytedance.pangle.receiver.c.a> a = new java.util.concurrent.ConcurrentHashMap();
    public final java.util.Map<com.bytedance.pangle.receiver.PluginBroadcastReceiver, android.content.BroadcastReceiver> b = new java.util.concurrent.ConcurrentHashMap();
    public final java.util.Set<java.lang.Integer> c = new java.util.concurrent.CopyOnWriteArraySet();

    public static class a {
        public java.lang.String a;
        public final java.util.Set<com.bytedance.pangle.receiver.PluginBroadcastReceiver> b = new java.util.concurrent.CopyOnWriteArraySet();

        public final void a(android.content.Context context, android.content.Intent intent) {
            java.util.Set<com.bytedance.pangle.receiver.PluginBroadcastReceiver> set = this.b;
            if (set == null || set.size() <= 0) {
                return;
            }
            for (com.bytedance.pangle.receiver.PluginBroadcastReceiver pluginBroadcastReceiver : this.b) {
                if (pluginBroadcastReceiver != null) {
                    try {
                        pluginBroadcastReceiver.onReceive(context, intent);
                    } catch (java.lang.Throwable th) {
                        com.bytedance.pangle.log.ZeusLogger.w(com.bytedance.pangle.log.ZeusLogger.TAG_RECEIVER, "plugin-receiver->action:" + (intent != null ? intent.getAction() : "") + "[exception]:", th);
                    }
                }
            }
        }

        public final void a(com.bytedance.pangle.receiver.PluginBroadcastReceiver pluginBroadcastReceiver) {
            if (pluginBroadcastReceiver != null) {
                this.b.add(pluginBroadcastReceiver);
            }
        }
    }

    private c() {
    }

    public static com.bytedance.pangle.receiver.c a() {
        if (d == null) {
            synchronized (com.bytedance.pangle.service.a.a.class) {
                if (d == null) {
                    d = new com.bytedance.pangle.receiver.c();
                }
            }
        }
        return d;
    }

    public final void a(android.content.Context context, android.content.Intent intent) {
        com.bytedance.pangle.receiver.c.a value;
        if (intent == null || intent.getAction() == null) {
            return;
        }
        java.lang.String action = intent.getAction();
        java.util.Map<java.lang.String, com.bytedance.pangle.receiver.c.a> map = this.a;
        if (map == null || map.size() <= 0) {
            return;
        }
        for (java.util.Map.Entry<java.lang.String, com.bytedance.pangle.receiver.c.a> entry : this.a.entrySet()) {
            if (action.equals(entry.getKey()) && (value = entry.getValue()) != null) {
                value.a(context, intent);
            }
        }
    }

    public final void a(android.content.IntentFilter intentFilter, com.bytedance.pangle.receiver.PluginBroadcastReceiver pluginBroadcastReceiver) {
        if (intentFilter == null || intentFilter.actionsIterator() == null) {
            return;
        }
        java.util.Iterator<java.lang.String> actionsIterator = intentFilter.actionsIterator();
        while (actionsIterator.hasNext()) {
            java.lang.String next = actionsIterator.next();
            if (next != null) {
                com.bytedance.pangle.receiver.c.a aVar = this.a.get(next);
                if (aVar != null) {
                    aVar.a(pluginBroadcastReceiver);
                } else {
                    com.bytedance.pangle.receiver.c.a aVar2 = new com.bytedance.pangle.receiver.c.a();
                    aVar2.a = next;
                    aVar2.a(pluginBroadcastReceiver);
                    this.a.put(next, aVar2);
                }
            }
        }
    }
}
