package com.huawei.hms.adapter.sysobs;

/* loaded from: classes22.dex */
public final class SystemManager {
    public static com.huawei.hms.adapter.sysobs.SystemManager a = new com.huawei.hms.adapter.sysobs.SystemManager();
    public static final java.lang.Object b = new java.lang.Object();
    public static com.huawei.hms.adapter.sysobs.SystemNotifier c = new com.huawei.hms.adapter.sysobs.SystemManager.a();

    public static class a implements com.huawei.hms.adapter.sysobs.SystemNotifier {
        public final java.util.List<com.huawei.hms.adapter.sysobs.SystemObserver> a = new java.util.ArrayList();

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void notifyNoticeObservers(int i) {
            synchronized (com.huawei.hms.adapter.sysobs.SystemManager.b) {
                java.util.Iterator<com.huawei.hms.adapter.sysobs.SystemObserver> it = this.a.iterator();
                while (it.hasNext()) {
                    if (it.next().onNoticeResult(i)) {
                        it.remove();
                    }
                }
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void notifyObservers(int i) {
            synchronized (com.huawei.hms.adapter.sysobs.SystemManager.b) {
                java.util.Iterator<com.huawei.hms.adapter.sysobs.SystemObserver> it = this.a.iterator();
                while (it.hasNext()) {
                    if (it.next().onUpdateResult(i)) {
                        it.remove();
                    }
                }
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void notifyObservers(android.content.Intent intent, java.lang.String str) {
            synchronized (com.huawei.hms.adapter.sysobs.SystemManager.b) {
                java.util.Iterator<com.huawei.hms.adapter.sysobs.SystemObserver> it = this.a.iterator();
                while (it.hasNext()) {
                    if (it.next().onSolutionResult(intent, str)) {
                        it.remove();
                    }
                }
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void registerObserver(com.huawei.hms.adapter.sysobs.SystemObserver systemObserver) {
            if (systemObserver == null || this.a.contains(systemObserver)) {
                return;
            }
            synchronized (com.huawei.hms.adapter.sysobs.SystemManager.b) {
                this.a.add(systemObserver);
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void unRegisterObserver(com.huawei.hms.adapter.sysobs.SystemObserver systemObserver) {
            synchronized (com.huawei.hms.adapter.sysobs.SystemManager.b) {
                this.a.remove(systemObserver);
            }
        }
    }

    public static com.huawei.hms.adapter.sysobs.SystemManager getInstance() {
        return a;
    }

    public static com.huawei.hms.adapter.sysobs.SystemNotifier getSystemNotifier() {
        return c;
    }

    public void notifyNoticeResult(int i) {
        c.notifyNoticeObservers(i);
    }

    public void notifyResolutionResult(android.content.Intent intent, java.lang.String str) {
        c.notifyObservers(intent, str);
    }

    public void notifyUpdateResult(int i) {
        c.notifyObservers(i);
    }
}
