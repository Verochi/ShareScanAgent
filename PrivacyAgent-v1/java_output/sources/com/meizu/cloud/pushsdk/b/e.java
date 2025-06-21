package com.meizu.cloud.pushsdk.b;

/* loaded from: classes23.dex */
class e {
    private final java.text.SimpleDateFormat a = new java.text.SimpleDateFormat("yyyy-MM-dd");
    private final com.meizu.cloud.pushsdk.b.d b = new com.meizu.cloud.pushsdk.b.d("lo");
    private java.io.BufferedWriter c;

    /* renamed from: com.meizu.cloud.pushsdk.b.e$1, reason: invalid class name */
    public class AnonymousClass1 implements java.io.FileFilter {
        public AnonymousClass1() {
        }

        @Override // java.io.FileFilter
        public boolean accept(java.io.File file) {
            return file.getName().endsWith(".log.txt");
        }
    }

    public class a implements java.util.Comparator<java.io.File> {
        public a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(java.io.File file, java.io.File file2) {
            long lastModified = file.lastModified() - file2.lastModified();
            if (lastModified > 0) {
                return -1;
            }
            return lastModified == 0 ? 0 : 1;
        }
    }

    public void a() throws java.io.IOException {
        java.io.BufferedWriter bufferedWriter = this.c;
        if (bufferedWriter != null) {
            bufferedWriter.flush();
            this.c.close();
            this.c = null;
        }
    }

    public void a(java.io.File file) {
        java.io.File[] listFiles = file.listFiles(new com.meizu.cloud.pushsdk.b.e.AnonymousClass1());
        if (listFiles != null) {
            if (listFiles.length > 7) {
                java.util.Arrays.sort(listFiles, new com.meizu.cloud.pushsdk.b.e.a());
                for (int i = 7; i < listFiles.length; i++) {
                    listFiles[i].delete();
                }
            }
        }
    }

    public void a(java.lang.String str) throws java.io.IOException {
        java.io.File file = new java.io.File(str);
        if (!file.exists() && !file.mkdirs()) {
            throw new java.io.IOException("create " + str + " dir failed!!!");
        }
        java.lang.String format = this.a.format(new java.util.Date());
        java.io.File file2 = new java.io.File(str, format + ".log.txt");
        if (!file2.exists()) {
            if (file2.createNewFile()) {
                a(file);
            } else {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("create new file ");
                sb.append(format);
                sb.append(" failed !!!");
            }
        }
        this.c = new java.io.BufferedWriter(new java.io.FileWriter(file2, true));
    }

    public void a(java.lang.String str, java.lang.String str2, java.lang.String str3) throws java.io.IOException {
        if (this.c != null) {
            this.c.write(this.b.a((str + str2 + " " + str3).getBytes()));
            this.c.write("\r\n");
        }
    }
}
