package com.liulishuo.filedownloader.notification;

/* loaded from: classes23.dex */
public class FileDownloadNotificationHelper<T extends com.liulishuo.filedownloader.notification.BaseNotificationItem> {
    public final android.util.SparseArray<T> a = new android.util.SparseArray<>();

    public void add(T t) {
        this.a.remove(t.getId());
        this.a.put(t.getId(), t);
    }

    public void cancel(int i) {
        T remove = remove(i);
        if (remove == null) {
            return;
        }
        remove.cancel();
    }

    public void clear() {
        android.util.SparseArray<T> clone = this.a.clone();
        this.a.clear();
        for (int i = 0; i < clone.size(); i++) {
            clone.get(clone.keyAt(i)).cancel();
        }
    }

    public boolean contains(int i) {
        return get(i) != null;
    }

    public T get(int i) {
        return this.a.get(i);
    }

    public T remove(int i) {
        T t = get(i);
        if (t == null) {
            return null;
        }
        this.a.remove(i);
        return t;
    }

    public void showIndeterminate(int i, int i2) {
        T t = get(i);
        if (t == null) {
            return;
        }
        t.updateStatus(i2);
        t.show(false);
    }

    public void showProgress(int i, int i2, int i3) {
        T t = get(i);
        if (t == null) {
            return;
        }
        t.updateStatus(3);
        t.update(i2, i3);
    }
}
