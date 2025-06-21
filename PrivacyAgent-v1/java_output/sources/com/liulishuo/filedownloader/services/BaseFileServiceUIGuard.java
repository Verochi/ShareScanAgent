package com.liulishuo.filedownloader.services;

/* loaded from: classes23.dex */
public abstract class BaseFileServiceUIGuard<CALLBACK extends android.os.Binder, INTERFACE extends android.os.IInterface> implements com.liulishuo.filedownloader.IFileDownloadServiceProxy, android.content.ServiceConnection {
    public volatile INTERFACE t;
    public final java.lang.Class<?> u;
    protected boolean runServiceForeground = false;
    public final java.util.HashMap<java.lang.String, java.lang.Object> v = new java.util.HashMap<>();
    public final java.util.List<android.content.Context> w = new java.util.ArrayList();
    public final java.util.ArrayList<java.lang.Runnable> x = new java.util.ArrayList<>();
    public final CALLBACK n = createCallback();

    public BaseFileServiceUIGuard(java.lang.Class<?> cls) {
        this.u = cls;
    }

    public final void a(boolean z) {
        if (!z && this.t != null) {
            try {
                unregisterCallback(this.t, this.n);
            } catch (android.os.RemoteException e) {
                e.printStackTrace();
            }
        }
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "release connect resources %s", this.t);
        }
        this.t = null;
        com.liulishuo.filedownloader.FileDownloadEventPool.getImpl().asyncPublishInNewThread(new com.liulishuo.filedownloader.event.DownloadServiceConnectChangedEvent(z ? com.liulishuo.filedownloader.event.DownloadServiceConnectChangedEvent.ConnectStatus.lost : com.liulishuo.filedownloader.event.DownloadServiceConnectChangedEvent.ConnectStatus.disconnected, this.u));
    }

    public abstract INTERFACE asInterface(android.os.IBinder iBinder);

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public void bindStartByContext(android.content.Context context) {
        bindStartByContext(context, null);
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public void bindStartByContext(android.content.Context context, java.lang.Runnable runnable) {
        if (com.liulishuo.filedownloader.util.FileDownloadUtils.isDownloaderProcess(context)) {
            throw new java.lang.IllegalStateException("Fatal-Exception: You can't bind the FileDownloadService in :filedownloader process.\n It's the invalid operation and is likely to cause unexpected problems.\n Maybe you want to use non-separate process mode for FileDownloader, More detail about non-separate mode, please move to wiki manually: https://github.com/lingochamp/FileDownloader/wiki/filedownloader.properties");
        }
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "bindStartByContext %s", context.getClass().getSimpleName());
        }
        android.content.Intent intent = new android.content.Intent(context, this.u);
        if (runnable != null && !this.x.contains(runnable)) {
            this.x.add(runnable);
        }
        if (!this.w.contains(context)) {
            this.w.add(context);
        }
        boolean needMakeServiceForeground = com.liulishuo.filedownloader.util.FileDownloadUtils.needMakeServiceForeground(context);
        this.runServiceForeground = needMakeServiceForeground;
        intent.putExtra(com.liulishuo.filedownloader.util.ExtraKeys.IS_FOREGROUND, needMakeServiceForeground);
        context.bindService(intent, this, 1);
        if (!this.runServiceForeground) {
            context.startService(intent);
            return;
        }
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "start foreground service", new java.lang.Object[0]);
        }
        if (android.os.Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        }
    }

    public abstract CALLBACK createCallback();

    public CALLBACK getCallback() {
        return this.n;
    }

    public INTERFACE getService() {
        return this.t;
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public boolean isConnected() {
        return getService() != null;
    }

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public boolean isRunServiceForeground() {
        return this.runServiceForeground;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(android.content.ComponentName componentName, android.os.IBinder iBinder) {
        this.t = asInterface(iBinder);
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "onServiceConnected %s %s", componentName, this.t);
        }
        try {
            registerCallback(this.t, this.n);
        } catch (android.os.RemoteException e) {
            e.printStackTrace();
        }
        java.util.List list = (java.util.List) this.x.clone();
        this.x.clear();
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            ((java.lang.Runnable) it.next()).run();
        }
        com.liulishuo.filedownloader.FileDownloadEventPool.getImpl().asyncPublishInNewThread(new com.liulishuo.filedownloader.event.DownloadServiceConnectChangedEvent(com.liulishuo.filedownloader.event.DownloadServiceConnectChangedEvent.ConnectStatus.connected, this.u));
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(android.content.ComponentName componentName) {
        if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
            com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "onServiceDisconnected %s %s", componentName, this.t);
        }
        a(true);
    }

    public java.lang.Object popCache(java.lang.String str) {
        return this.v.remove(str);
    }

    public java.lang.String putCache(java.lang.Object obj) {
        if (obj == null) {
            return null;
        }
        java.lang.String obj2 = obj.toString();
        this.v.put(obj2, obj);
        return obj2;
    }

    public abstract void registerCallback(INTERFACE r1, CALLBACK callback) throws android.os.RemoteException;

    @Override // com.liulishuo.filedownloader.IFileDownloadServiceProxy
    public void unbindByContext(android.content.Context context) {
        if (this.w.contains(context)) {
            if (com.liulishuo.filedownloader.util.FileDownloadLog.NEED_LOG) {
                com.liulishuo.filedownloader.util.FileDownloadLog.d(this, "unbindByContext %s", context);
            }
            this.w.remove(context);
            if (this.w.isEmpty()) {
                a(false);
            }
            android.content.Intent intent = new android.content.Intent(context, this.u);
            context.unbindService(this);
            context.stopService(intent);
        }
    }

    public abstract void unregisterCallback(INTERFACE r1, CALLBACK callback) throws android.os.RemoteException;
}
