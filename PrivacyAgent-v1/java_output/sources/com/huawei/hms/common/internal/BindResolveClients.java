package com.huawei.hms.common.internal;

/* loaded from: classes22.dex */
public class BindResolveClients {
    private static final java.lang.Object LOCK_INST = new java.lang.Object();
    private java.util.ArrayList<com.huawei.hms.common.internal.ResolveClientBean> mClientList;

    public static class SingletonManager {
        private static final com.huawei.hms.common.internal.BindResolveClients INSTANCE = new com.huawei.hms.common.internal.BindResolveClients(null);

        private SingletonManager() {
        }
    }

    private BindResolveClients() {
        this.mClientList = new java.util.ArrayList<>();
    }

    public /* synthetic */ BindResolveClients(com.huawei.hms.common.internal.BindResolveClients.AnonymousClass1 anonymousClass1) {
        this();
    }

    public static com.huawei.hms.common.internal.BindResolveClients getInstance() {
        return com.huawei.hms.common.internal.BindResolveClients.SingletonManager.INSTANCE;
    }

    public boolean isClientRegistered(com.huawei.hms.common.internal.ResolveClientBean resolveClientBean) {
        boolean contains;
        synchronized (LOCK_INST) {
            contains = this.mClientList.contains(resolveClientBean);
        }
        return contains;
    }

    public void notifyClientReconnect() {
        synchronized (LOCK_INST) {
            java.util.ListIterator<com.huawei.hms.common.internal.ResolveClientBean> listIterator = this.mClientList.listIterator();
            while (listIterator.hasNext()) {
                listIterator.next().clientReconnect();
            }
            this.mClientList.clear();
        }
    }

    public void register(com.huawei.hms.common.internal.ResolveClientBean resolveClientBean) {
        if (resolveClientBean == null) {
            return;
        }
        synchronized (LOCK_INST) {
            if (!this.mClientList.contains(resolveClientBean)) {
                this.mClientList.add(resolveClientBean);
            }
        }
    }

    public void unRegister(com.huawei.hms.common.internal.ResolveClientBean resolveClientBean) {
        if (resolveClientBean == null) {
            return;
        }
        synchronized (LOCK_INST) {
            if (this.mClientList.contains(resolveClientBean)) {
                java.util.ListIterator<com.huawei.hms.common.internal.ResolveClientBean> listIterator = this.mClientList.listIterator();
                while (true) {
                    if (!listIterator.hasNext()) {
                        break;
                    } else if (resolveClientBean.equals(listIterator.next())) {
                        listIterator.remove();
                        break;
                    }
                }
            }
        }
    }

    public void unRegisterAll() {
        synchronized (LOCK_INST) {
            this.mClientList.clear();
        }
    }
}
