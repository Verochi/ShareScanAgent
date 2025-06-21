package com.alimm.tanx.core.view.player.cache.videocache.file;

/* loaded from: classes.dex */
public abstract class LruDiskUsage implements com.alimm.tanx.core.view.player.cache.videocache.file.DiskUsage {
    private static final com.alimm.tanx.core.view.player.cache.videocache.log.Logger LOG = com.alimm.tanx.core.view.player.cache.videocache.log.LoggerFactory.getLogger("LruDiskUsage");
    private final java.util.concurrent.ExecutorService workerThread = java.util.concurrent.Executors.newSingleThreadExecutor();

    public class TouchCallable implements java.util.concurrent.Callable<java.lang.Void> {
        private final java.io.File file;

        public TouchCallable(java.io.File file) {
            this.file = file;
        }

        @Override // java.util.concurrent.Callable
        public java.lang.Void call() throws java.lang.Exception {
            com.alimm.tanx.core.view.player.cache.videocache.file.LruDiskUsage.this.touchInBackground(this.file);
            return null;
        }
    }

    private long countTotalSize(java.util.List<java.io.File> list) {
        java.util.Iterator<java.io.File> it = list.iterator();
        long j = 0;
        while (it.hasNext()) {
            j += it.next().length();
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void touchInBackground(java.io.File file) throws java.io.IOException {
        com.alimm.tanx.core.view.player.cache.videocache.file.Files.setLastModifiedNow(file);
        trim(com.alimm.tanx.core.view.player.cache.videocache.file.Files.getLruListFiles(file.getParentFile()));
    }

    private void trim(java.util.List<java.io.File> list) {
        long countTotalSize = countTotalSize(list);
        int size = list.size();
        for (java.io.File file : list) {
            if (!accept(file, countTotalSize, size)) {
                long length = file.length();
                if (file.delete()) {
                    size--;
                    countTotalSize -= length;
                    LOG.info("Cache file " + file + " is deleted because it exceeds cache limit");
                } else {
                    LOG.error("Error deleting file " + file + " for trimming cache");
                }
            }
        }
    }

    public abstract boolean accept(java.io.File file, long j, int i);

    @Override // com.alimm.tanx.core.view.player.cache.videocache.file.DiskUsage
    public void touch(java.io.File file) throws java.io.IOException {
        this.workerThread.submit(new com.alimm.tanx.core.view.player.cache.videocache.file.LruDiskUsage.TouchCallable(file));
    }
}
