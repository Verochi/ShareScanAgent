package com.alimm.tanx.core.view.player.cache.videocache.file;

/* loaded from: classes.dex */
class Files {
    private static final com.alimm.tanx.core.view.player.cache.videocache.log.Logger LOG = com.alimm.tanx.core.view.player.cache.videocache.log.LoggerFactory.getLogger("Files");

    public static final class LastModifiedComparator implements java.util.Comparator<java.io.File> {
        private LastModifiedComparator() {
        }

        public /* synthetic */ LastModifiedComparator(com.alimm.tanx.core.view.player.cache.videocache.file.Files.AnonymousClass1 anonymousClass1) {
            this();
        }

        private int compareLong(long j, long j2) {
            if (j < j2) {
                return -1;
            }
            return j == j2 ? 0 : 1;
        }

        @Override // java.util.Comparator
        public int compare(java.io.File file, java.io.File file2) {
            return compareLong(file.lastModified(), file2.lastModified());
        }
    }

    public static java.util.List<java.io.File> getLruListFiles(java.io.File file) {
        java.util.LinkedList linkedList = new java.util.LinkedList();
        java.io.File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return linkedList;
        }
        java.util.List<java.io.File> asList = java.util.Arrays.asList(listFiles);
        java.util.Collections.sort(asList, new com.alimm.tanx.core.view.player.cache.videocache.file.Files.LastModifiedComparator(null));
        return asList;
    }

    public static void makeDir(java.io.File file) throws java.io.IOException {
        if (!file.exists()) {
            if (!file.mkdirs()) {
                throw new java.io.IOException(java.lang.String.format("Directory %s can't be created", file.getAbsolutePath()));
            }
        } else {
            if (file.isDirectory()) {
                return;
            }
            throw new java.io.IOException("File " + file + " is not directory!");
        }
    }

    public static void modify(java.io.File file) throws java.io.IOException {
        long length = file.length();
        if (length == 0) {
            recreateZeroSizeFile(file);
            return;
        }
        java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(file, "rwd");
        long j = length - 1;
        randomAccessFile.seek(j);
        byte readByte = randomAccessFile.readByte();
        randomAccessFile.seek(j);
        randomAccessFile.write(readByte);
        randomAccessFile.close();
    }

    private static void recreateZeroSizeFile(java.io.File file) throws java.io.IOException {
        if (file.delete() && file.createNewFile()) {
            return;
        }
        throw new java.io.IOException("Error recreate zero-size file " + file);
    }

    public static void setLastModifiedNow(java.io.File file) throws java.io.IOException {
        if (file.exists()) {
            long currentTimeMillis = java.lang.System.currentTimeMillis();
            if (file.setLastModified(currentTimeMillis)) {
                return;
            }
            modify(file);
            if (file.lastModified() < currentTimeMillis) {
                LOG.warn("Last modified date {} is not set for file {}", new java.util.Date(file.lastModified()).toString(), file.getAbsolutePath());
            }
        }
    }
}
