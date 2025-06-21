package com.ss.android.socialbase.downloader.impls;

/* loaded from: classes19.dex */
public class DownloadCache implements com.ss.android.socialbase.downloader.downloader.IDownloadCache {
    private final android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadInfo> downloadInfoMap = new android.util.SparseArray<>();
    private final android.util.SparseArray<java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk>> chunkListMap = new android.util.SparseArray<>();
    private final android.util.SparseArray<java.util.Map<java.lang.Long, com.ss.android.socialbase.downloader.segment.Segment>> segmentListMap = new android.util.SparseArray<>();

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskCancel(int i, long j) {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = getDownloadInfo(i);
        if (downloadInfo != null) {
            downloadInfo.setCurBytes(j, false);
            downloadInfo.setStatus(-4);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskCompleted(int i, long j) {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = getDownloadInfo(i);
        if (downloadInfo != null) {
            downloadInfo.setCurBytes(j, false);
            downloadInfo.setStatus(-3);
            downloadInfo.setFirstDownload(false);
            downloadInfo.setFirstSuccess(false);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskConnected(int i, long j, java.lang.String str, java.lang.String str2) {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = getDownloadInfo(i);
        if (downloadInfo != null) {
            downloadInfo.setTotalBytes(j);
            downloadInfo.seteTag(str);
            if (android.text.TextUtils.isEmpty(downloadInfo.getName()) && !android.text.TextUtils.isEmpty(str2)) {
                downloadInfo.setName(str2);
            }
            downloadInfo.setStatus(3);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskError(int i, long j) {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = getDownloadInfo(i);
        if (downloadInfo != null) {
            downloadInfo.setCurBytes(j, false);
            downloadInfo.setStatus(-1);
            downloadInfo.setFirstDownload(false);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskIntercept(int i) {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = getDownloadInfo(i);
        if (downloadInfo != null) {
            downloadInfo.setStatus(-7);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskPause(int i, long j) {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = getDownloadInfo(i);
        if (downloadInfo != null) {
            downloadInfo.setCurBytes(j, false);
            downloadInfo.setStatus(-2);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskPrepare(int i) {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = getDownloadInfo(i);
        if (downloadInfo != null) {
            downloadInfo.setStatus(1);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskProgress(int i, long j) {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = getDownloadInfo(i);
        if (downloadInfo != null) {
            downloadInfo.setCurBytes(j, false);
            if (downloadInfo.getStatus() != -3 && downloadInfo.getStatus() != -2 && !com.ss.android.socialbase.downloader.constants.DownloadStatus.isFailedStatus(downloadInfo.getStatus()) && downloadInfo.getStatus() != -4) {
                downloadInfo.setStatus(4);
            }
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public com.ss.android.socialbase.downloader.model.DownloadInfo OnDownloadTaskRetry(int i) {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = getDownloadInfo(i);
        if (downloadInfo != null) {
            downloadInfo.setStatus(5);
            downloadInfo.setFirstDownload(false);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void addDownloadChunk(com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk) {
        int id = downloadChunk.getId();
        java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> list = this.chunkListMap.get(id);
        if (list == null) {
            list = new java.util.ArrayList<>();
            this.chunkListMap.put(id, list);
        }
        list.add(downloadChunk);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void addSubDownloadChunk(com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean cacheExist(int i) {
        return getDownloadInfo(i) != null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public synchronized void clearData() {
        this.downloadInfoMap.clear();
        this.chunkListMap.clear();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean ensureDownloadCacheSyncSuccess() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public synchronized java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getAllDownloadInfo() {
        if (this.downloadInfoMap.size() == 0) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList(this.downloadInfoMap.size());
        for (int i = 0; i < this.downloadInfoMap.size(); i++) {
            com.ss.android.socialbase.downloader.model.DownloadInfo valueAt = this.downloadInfoMap.valueAt(i);
            if (valueAt != null) {
                arrayList.add(valueAt);
            }
        }
        return arrayList;
    }

    public android.util.SparseArray<java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk>> getChunkListMap() {
        return this.chunkListMap;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public synchronized java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> getDownloadChunk(int i) {
        return this.chunkListMap.get(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public synchronized com.ss.android.socialbase.downloader.model.DownloadInfo getDownloadInfo(int i) {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo;
        try {
            downloadInfo = this.downloadInfoMap.get(i);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            downloadInfo = null;
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public synchronized java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getDownloadInfoList(java.lang.String str) {
        java.util.ArrayList arrayList;
        arrayList = new java.util.ArrayList();
        try {
            int size = this.downloadInfoMap.size();
            for (int i = 0; i < size; i++) {
                com.ss.android.socialbase.downloader.model.DownloadInfo valueAt = this.downloadInfoMap.valueAt(i);
                if (str != null && str.equals(valueAt.getUrl())) {
                    arrayList.add(valueAt);
                }
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

    public android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadInfo> getDownloadInfoMap() {
        return this.downloadInfoMap;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public synchronized java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getFailedDownloadInfosWithMimeType(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.downloadInfoMap.size() == 0) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < this.downloadInfoMap.size(); i++) {
            com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = this.downloadInfoMap.get(this.downloadInfoMap.keyAt(i));
            if (downloadInfo != null && !android.text.TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && com.ss.android.socialbase.downloader.constants.DownloadStatus.isFailedStatus(downloadInfo.getStatus())) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public synchronized java.util.Map<java.lang.Long, com.ss.android.socialbase.downloader.segment.Segment> getSegmentMap(int i) {
        return this.segmentListMap.get(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public synchronized java.util.List<com.ss.android.socialbase.downloader.segment.Segment> getSegments(int i) {
        java.util.Map<java.lang.Long, com.ss.android.socialbase.downloader.segment.Segment> map = this.segmentListMap.get(i);
        if (map != null && !map.isEmpty()) {
            return new java.util.ArrayList(map.values());
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public synchronized java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getSuccessedDownloadInfosWithMimeType(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.downloadInfoMap.size() == 0) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < this.downloadInfoMap.size(); i++) {
            com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = this.downloadInfoMap.get(this.downloadInfoMap.keyAt(i));
            if (downloadInfo != null && !android.text.TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && downloadInfo.getStatus() == -3) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public synchronized java.util.List<com.ss.android.socialbase.downloader.model.DownloadInfo> getUnCompletedDownloadInfosWithMimeType(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.downloadInfoMap.size() == 0) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (int i = 0; i < this.downloadInfoMap.size(); i++) {
            com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = this.downloadInfoMap.get(this.downloadInfoMap.keyAt(i));
            if (downloadInfo != null && !android.text.TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && com.ss.android.socialbase.downloader.constants.DownloadStatus.isUnCompletedStatus(downloadInfo.getStatus())) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void init() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean isDownloadCacheSyncSuccess() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public com.ss.android.socialbase.downloader.model.DownloadInfo onDownloadTaskStart(int i) {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo = getDownloadInfo(i);
        if (downloadInfo != null) {
            downloadInfo.setStatus(2);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public synchronized void removeAllDownloadChunk(int i) {
        this.chunkListMap.remove(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public synchronized boolean removeDownloadInfo(int i) {
        this.downloadInfoMap.remove(i);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public boolean removeDownloadTaskData(int i) {
        removeDownloadInfo(i);
        removeAllDownloadChunk(i);
        removeSegments(i);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public synchronized void removeSegments(int i) {
        this.segmentListMap.remove(i);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public synchronized void syncDownloadChunks(int i, java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> list) {
        if (list == null) {
            return;
        }
        removeAllDownloadChunk(i);
        for (com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk : list) {
            if (downloadChunk != null) {
                addDownloadChunk(downloadChunk);
                if (downloadChunk.hasChunkDivided()) {
                    java.util.Iterator<com.ss.android.socialbase.downloader.model.DownloadChunk> it = downloadChunk.getSubChunkList().iterator();
                    while (it.hasNext()) {
                        addDownloadChunk(it.next());
                    }
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadInfo(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        updateDownloadInfo(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void syncDownloadInfoFromOtherCache(int i, java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> list) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public synchronized com.ss.android.socialbase.downloader.model.DownloadInfo updateChunkCount(int i, int i2) {
        com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo;
        downloadInfo = getDownloadInfo(i);
        if (downloadInfo != null) {
            downloadInfo.setChunkCount(i2);
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public synchronized void updateDownloadChunk(int i, int i2, long j) {
        java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> downloadChunk = getDownloadChunk(i);
        if (downloadChunk == null) {
            return;
        }
        for (com.ss.android.socialbase.downloader.model.DownloadChunk downloadChunk2 : downloadChunk) {
            if (downloadChunk2 != null && downloadChunk2.getChunkIndex() == i2) {
                downloadChunk2.setCurrentOffset(j);
                return;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public synchronized boolean updateDownloadInfo(com.ss.android.socialbase.downloader.model.DownloadInfo downloadInfo) {
        boolean z = true;
        if (downloadInfo == null) {
            return true;
        }
        if (this.downloadInfoMap.get(downloadInfo.getId()) == null) {
            z = false;
        }
        this.downloadInfoMap.put(downloadInfo.getId(), downloadInfo);
        return z;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public synchronized boolean updateSegments(int i, java.util.Map<java.lang.Long, com.ss.android.socialbase.downloader.segment.Segment> map) {
        this.segmentListMap.put(i, map);
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x002b, code lost:
    
        if (r0.getSubChunkList() == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002d, code lost:
    
        r3 = r0.getSubChunkList().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0039, code lost:
    
        if (r3.hasNext() == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003b, code lost:
    
        r5 = r3.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0041, code lost:
    
        if (r5 == null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0047, code lost:
    
        if (r5.getChunkIndex() != r4) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0049, code lost:
    
        r5.setCurrentOffset(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x004f, code lost:
    
        return;
     */
    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void updateSubDownloadChunk(int i, int i2, int i3, long j) {
        java.util.List<com.ss.android.socialbase.downloader.model.DownloadChunk> downloadChunk = getDownloadChunk(i);
        if (downloadChunk == null) {
            return;
        }
        java.util.Iterator<com.ss.android.socialbase.downloader.model.DownloadChunk> it = downloadChunk.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.ss.android.socialbase.downloader.model.DownloadChunk next = it.next();
            if (next != null && next.getChunkIndex() == i3 && !next.hasChunkDivided()) {
                break;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.IDownloadCache
    public void updateSubDownloadChunkIndex(int i, int i2, int i3, int i4) {
    }
}
