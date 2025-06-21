package com.umeng.analytics.process;

/* loaded from: classes19.dex */
public class DBFileTraversalUtil {
    private static java.util.concurrent.ExecutorService a = java.util.concurrent.Executors.newSingleThreadExecutor();
    private static com.umeng.commonsdk.utils.FileLockUtil b = new com.umeng.commonsdk.utils.FileLockUtil();

    /* renamed from: com.umeng.analytics.process.DBFileTraversalUtil$1, reason: invalid class name */
    public static class AnonymousClass1 implements java.lang.Runnable {
        final /* synthetic */ java.io.File a;
        final /* synthetic */ com.umeng.commonsdk.utils.FileLockCallback b;
        final /* synthetic */ com.umeng.analytics.process.DBFileTraversalUtil.a c;

        public AnonymousClass1(java.io.File file, com.umeng.commonsdk.utils.FileLockCallback fileLockCallback, com.umeng.analytics.process.DBFileTraversalUtil.a aVar) {
            this.a = file;
            this.b = fileLockCallback;
            this.c = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                for (java.io.File file : this.a.listFiles()) {
                    if (file.getName().endsWith(com.umeng.analytics.process.a.d)) {
                        com.umeng.analytics.process.DBFileTraversalUtil.b.doFileOperateion(file, this.b);
                        com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> file: " + file.getName());
                    }
                }
                com.umeng.analytics.process.DBFileTraversalUtil.a aVar = this.c;
                if (aVar != null) {
                    aVar.a();
                }
            } catch (java.lang.Throwable unused) {
            }
            com.umeng.commonsdk.debug.UMRTLog.i(com.umeng.commonsdk.debug.UMRTLog.RTLOG_TAG, "--->>> end *** ");
        }
    }

    public interface a {
        void a();
    }

    public static void traverseDBFiles(java.lang.String str, com.umeng.commonsdk.utils.FileLockCallback fileLockCallback, com.umeng.analytics.process.DBFileTraversalUtil.a aVar) {
        java.io.File file = new java.io.File(str);
        if (file.exists() && file.isDirectory()) {
            a.execute(new com.umeng.analytics.process.DBFileTraversalUtil.AnonymousClass1(file, fileLockCallback, aVar));
        }
    }
}
