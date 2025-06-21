package com.ss.android.socialbase.downloader.utils;

/* loaded from: classes19.dex */
public class DownloadStenographer {
    private static final int MAX_NODE_COUNT = 20;
    private static final int SECONDS_TO_MILLS = 1000;
    private int count;
    private com.ss.android.socialbase.downloader.utils.DownloadStenographer.Node head;
    private int maxCount;
    private com.ss.android.socialbase.downloader.utils.DownloadStenographer.Node tail;

    public static class Node {
        long curBytes;
        com.ss.android.socialbase.downloader.utils.DownloadStenographer.Node next;
        com.ss.android.socialbase.downloader.utils.DownloadStenographer.Node prev;
        long when;

        private Node() {
        }

        public /* synthetic */ Node(com.ss.android.socialbase.downloader.utils.DownloadStenographer.AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public DownloadStenographer() {
        this.maxCount = 10;
    }

    public DownloadStenographer(int i) {
        this.maxCount = i > 20 ? 20 : i;
    }

    private com.ss.android.socialbase.downloader.utils.DownloadStenographer.Node findFirstNodeNearWhen(long j) {
        com.ss.android.socialbase.downloader.utils.DownloadStenographer.Node node = this.head;
        com.ss.android.socialbase.downloader.utils.DownloadStenographer.Node node2 = null;
        while (node != null && node.when > j) {
            node2 = node;
            node = node.next;
        }
        return (node == null || node2 == null || node == node2 || j - node.when >= node2.when - j) ? node2 : node;
    }

    private com.ss.android.socialbase.downloader.utils.DownloadStenographer.Node obtainNode() {
        com.ss.android.socialbase.downloader.utils.DownloadStenographer.Node node;
        int i = this.count;
        if (i < this.maxCount || (node = this.tail) == null) {
            this.count = i + 1;
            return new com.ss.android.socialbase.downloader.utils.DownloadStenographer.Node(null);
        }
        com.ss.android.socialbase.downloader.utils.DownloadStenographer.Node node2 = node.prev;
        node.prev = null;
        this.tail = node2;
        if (node2 != null) {
            node2.next = null;
        }
        return node;
    }

    public long getRecentDownloadSpeed(long j, long j2) {
        synchronized (this) {
            com.ss.android.socialbase.downloader.utils.DownloadStenographer.Node node = this.head;
            if (node == null) {
                return -1L;
            }
            com.ss.android.socialbase.downloader.utils.DownloadStenographer.Node findFirstNodeNearWhen = findFirstNodeNearWhen(j);
            if (findFirstNodeNearWhen == null) {
                return -1L;
            }
            long j3 = node.curBytes - findFirstNodeNearWhen.curBytes;
            long j4 = j2 - findFirstNodeNearWhen.when;
            if (j3 < 0 || j4 <= 0) {
                return -1L;
            }
            return j3 / j4;
        }
    }

    public boolean markProgress(long j, long j2) {
        synchronized (this) {
            com.ss.android.socialbase.downloader.utils.DownloadStenographer.Node node = this.head;
            if (node != null) {
                if (j >= node.curBytes && j2 >= node.when) {
                    com.ss.android.socialbase.downloader.utils.DownloadStenographer.Node node2 = node.next;
                    if (node2 != null && j2 - node2.when < 1000) {
                        node.curBytes = j;
                        node.when = j2;
                        return true;
                    }
                }
                return false;
            }
            com.ss.android.socialbase.downloader.utils.DownloadStenographer.Node obtainNode = obtainNode();
            obtainNode.curBytes = j;
            obtainNode.when = j2;
            if (node != null) {
                obtainNode.next = node;
                node.prev = obtainNode;
            }
            this.head = obtainNode;
            return true;
        }
    }
}
