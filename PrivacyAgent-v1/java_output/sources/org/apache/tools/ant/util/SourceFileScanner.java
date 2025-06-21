package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class SourceFileScanner implements org.apache.tools.ant.types.ResourceFactory {
    public static final org.apache.tools.ant.util.FileUtils t = org.apache.tools.ant.util.FileUtils.getFileUtils();
    public java.io.File n;
    protected org.apache.tools.ant.Task task;

    /* renamed from: org.apache.tools.ant.util.SourceFileScanner$1, reason: invalid class name */
    public class AnonymousClass1 extends org.apache.tools.ant.types.resources.FileResource {
        public final /* synthetic */ java.lang.String C;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(java.io.File file, java.lang.String str, java.lang.String str2) {
            super(file, str);
            this.C = str2;
        }

        @Override // org.apache.tools.ant.types.resources.FileResource, org.apache.tools.ant.types.Resource
        public java.lang.String getName() {
            return this.C;
        }
    }

    public SourceFileScanner(org.apache.tools.ant.Task task) {
        this.task = task;
    }

    @Override // org.apache.tools.ant.types.ResourceFactory
    public org.apache.tools.ant.types.Resource getResource(java.lang.String str) {
        return new org.apache.tools.ant.types.resources.FileResource(this.n, str);
    }

    public java.lang.String[] restrict(java.lang.String[] strArr, java.io.File file, java.io.File file2, org.apache.tools.ant.util.FileNameMapper fileNameMapper) {
        return restrict(strArr, file, file2, fileNameMapper, t.getFileTimestampGranularity());
    }

    public java.lang.String[] restrict(java.lang.String[] strArr, java.io.File file, java.io.File file2, org.apache.tools.ant.util.FileNameMapper fileNameMapper, long j) {
        this.n = file2;
        java.util.Vector vector = new java.util.Vector();
        for (java.lang.String str : strArr) {
            vector.addElement(new org.apache.tools.ant.util.SourceFileScanner.AnonymousClass1(file, str, str));
        }
        org.apache.tools.ant.types.Resource[] resourceArr = new org.apache.tools.ant.types.Resource[vector.size()];
        vector.copyInto(resourceArr);
        org.apache.tools.ant.types.Resource[] selectOutOfDateSources = org.apache.tools.ant.util.ResourceUtils.selectOutOfDateSources(this.task, resourceArr, fileNameMapper, this, j);
        java.lang.String[] strArr2 = new java.lang.String[selectOutOfDateSources.length];
        for (int i = 0; i < selectOutOfDateSources.length; i++) {
            strArr2[i] = selectOutOfDateSources[i].getName();
        }
        return strArr2;
    }

    public java.io.File[] restrictAsFiles(java.lang.String[] strArr, java.io.File file, java.io.File file2, org.apache.tools.ant.util.FileNameMapper fileNameMapper) {
        return restrictAsFiles(strArr, file, file2, fileNameMapper, t.getFileTimestampGranularity());
    }

    public java.io.File[] restrictAsFiles(java.lang.String[] strArr, java.io.File file, java.io.File file2, org.apache.tools.ant.util.FileNameMapper fileNameMapper, long j) {
        java.lang.String[] restrict = restrict(strArr, file, file2, fileNameMapper, j);
        java.io.File[] fileArr = new java.io.File[restrict.length];
        for (int i = 0; i < restrict.length; i++) {
            fileArr[i] = new java.io.File(file, restrict[i]);
        }
        return fileArr;
    }
}
