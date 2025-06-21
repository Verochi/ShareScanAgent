package com.aliyun.svideo.downloader;

/* loaded from: classes.dex */
class ListenerManager {
    private android.util.SparseArray<com.aliyun.svideo.downloader.BridgeListener> mListenerListArray = new android.util.SparseArray<>();

    public com.aliyun.svideo.downloader.BridgeListener getBridgeListener(int i) {
        com.aliyun.svideo.downloader.BridgeListener bridgeListener = this.mListenerListArray.get(i);
        if (bridgeListener == null) {
            bridgeListener = new com.aliyun.svideo.downloader.BridgeListener();
        }
        this.mListenerListArray.put(i, bridgeListener);
        return bridgeListener;
    }

    public void removeAllDownloadListener() {
        for (int i = 0; i < this.mListenerListArray.size(); i++) {
            com.aliyun.svideo.downloader.BridgeListener bridgeListener = this.mListenerListArray.get(this.mListenerListArray.keyAt(i));
            if (bridgeListener != null) {
                bridgeListener.removeAllDownloadListener();
            }
        }
        this.mListenerListArray.clear();
    }

    public void removeAllDownloadListener(int i) {
        com.aliyun.svideo.downloader.BridgeListener bridgeListener = this.mListenerListArray.get(i);
        if (bridgeListener != null) {
            bridgeListener.removeAllDownloadListener();
        }
    }

    public void removeDownloadListener(int i, com.aliyun.svideo.downloader.FileDownloaderCallback fileDownloaderCallback) {
        com.aliyun.svideo.downloader.BridgeListener bridgeListener = this.mListenerListArray.get(i);
        if (bridgeListener != null) {
            bridgeListener.removeDownloadListener(fileDownloaderCallback);
        }
    }
}
