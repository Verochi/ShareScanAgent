package com.liulishuo.filedownloader.database;

/* loaded from: classes23.dex */
public class NoDatabaseImpl implements com.liulishuo.filedownloader.database.FileDownloadDatabase {
    public final android.util.SparseArray<com.liulishuo.filedownloader.model.FileDownloadModel> a = new android.util.SparseArray<>();
    public final android.util.SparseArray<java.util.List<com.liulishuo.filedownloader.model.ConnectionModel>> b = new android.util.SparseArray<>();

    public class Maintainer implements com.liulishuo.filedownloader.database.FileDownloadDatabase.Maintainer {
        public Maintainer() {
        }

        @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase.Maintainer
        public void changeFileDownloadModelId(int i, com.liulishuo.filedownloader.model.FileDownloadModel fileDownloadModel) {
        }

        @Override // java.lang.Iterable
        public java.util.Iterator<com.liulishuo.filedownloader.model.FileDownloadModel> iterator() {
            return com.liulishuo.filedownloader.database.NoDatabaseImpl.this.new MaintainerIterator();
        }

        @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase.Maintainer
        public void onFinishMaintain() {
        }

        @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase.Maintainer
        public void onRefreshedValidData(com.liulishuo.filedownloader.model.FileDownloadModel fileDownloadModel) {
        }

        @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase.Maintainer
        public void onRemovedInvalidData(com.liulishuo.filedownloader.model.FileDownloadModel fileDownloadModel) {
        }
    }

    public class MaintainerIterator implements java.util.Iterator<com.liulishuo.filedownloader.model.FileDownloadModel> {
        public MaintainerIterator() {
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.liulishuo.filedownloader.model.FileDownloadModel next() {
            return null;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
        }
    }

    public static class Maker implements com.liulishuo.filedownloader.util.FileDownloadHelper.DatabaseCustomMaker {
        @Override // com.liulishuo.filedownloader.util.FileDownloadHelper.DatabaseCustomMaker
        public com.liulishuo.filedownloader.database.FileDownloadDatabase customMake() {
            return new com.liulishuo.filedownloader.database.NoDatabaseImpl();
        }
    }

    public static com.liulishuo.filedownloader.database.NoDatabaseImpl.Maker createMaker() {
        return new com.liulishuo.filedownloader.database.NoDatabaseImpl.Maker();
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void clear() {
        synchronized (this.a) {
            this.a.clear();
        }
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public com.liulishuo.filedownloader.model.FileDownloadModel find(int i) {
        com.liulishuo.filedownloader.model.FileDownloadModel fileDownloadModel;
        synchronized (this.a) {
            fileDownloadModel = this.a.get(i);
        }
        return fileDownloadModel;
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public java.util.List<com.liulishuo.filedownloader.model.ConnectionModel> findConnectionModel(int i) {
        java.util.List<com.liulishuo.filedownloader.model.ConnectionModel> list;
        java.util.ArrayList arrayList = new java.util.ArrayList();
        synchronized (this.b) {
            list = this.b.get(i);
        }
        if (list != null) {
            arrayList.addAll(list);
        }
        return arrayList;
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void insert(com.liulishuo.filedownloader.model.FileDownloadModel fileDownloadModel) {
        synchronized (this.a) {
            this.a.put(fileDownloadModel.getId(), fileDownloadModel);
        }
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void insertConnectionModel(com.liulishuo.filedownloader.model.ConnectionModel connectionModel) {
        int id = connectionModel.getId();
        synchronized (this.b) {
            java.util.List<com.liulishuo.filedownloader.model.ConnectionModel> list = this.b.get(id);
            if (list == null) {
                list = new java.util.ArrayList<>();
                this.b.put(id, list);
            }
            list.add(connectionModel);
        }
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public com.liulishuo.filedownloader.database.FileDownloadDatabase.Maintainer maintainer() {
        return new com.liulishuo.filedownloader.database.NoDatabaseImpl.Maintainer();
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void onTaskStart(int i) {
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public boolean remove(int i) {
        synchronized (this.a) {
            this.a.remove(i);
        }
        return true;
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void removeConnections(int i) {
        synchronized (this.b) {
            this.b.remove(i);
        }
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void update(com.liulishuo.filedownloader.model.FileDownloadModel fileDownloadModel) {
        if (fileDownloadModel == null) {
            com.liulishuo.filedownloader.util.FileDownloadLog.w(this, "update but model == null!", new java.lang.Object[0]);
            return;
        }
        if (find(fileDownloadModel.getId()) == null) {
            insert(fileDownloadModel);
            return;
        }
        synchronized (this.a) {
            this.a.remove(fileDownloadModel.getId());
            this.a.put(fileDownloadModel.getId(), fileDownloadModel);
        }
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void updateCompleted(int i, long j) {
        remove(i);
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void updateConnected(int i, long j, java.lang.String str, java.lang.String str2) {
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void updateConnectionCount(int i, int i2) {
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void updateConnectionModel(int i, int i2, long j) {
        synchronized (this.b) {
            java.util.List<com.liulishuo.filedownloader.model.ConnectionModel> list = this.b.get(i);
            if (list == null) {
                return;
            }
            for (com.liulishuo.filedownloader.model.ConnectionModel connectionModel : list) {
                if (connectionModel.getIndex() == i2) {
                    connectionModel.setCurrentOffset(j);
                    return;
                }
            }
        }
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void updateError(int i, java.lang.Throwable th, long j) {
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void updateOldEtagOverdue(int i, java.lang.String str, long j, long j2, int i2) {
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void updatePause(int i, long j) {
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void updatePending(int i) {
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void updateProgress(int i, long j) {
    }

    @Override // com.liulishuo.filedownloader.database.FileDownloadDatabase
    public void updateRetry(int i, java.lang.Throwable th) {
    }
}
