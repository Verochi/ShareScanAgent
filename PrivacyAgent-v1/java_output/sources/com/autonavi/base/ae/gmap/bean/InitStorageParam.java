package com.autonavi.base.ae.gmap.bean;

@com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
/* loaded from: classes12.dex */
public class InitStorageParam {
    private static final java.lang.String DIR_NAME = "terrain_dem_files";
    private static final java.lang.String INIT_STORAGE_DIR = "mapcache";

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private int maxFileCount;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private long maxFileSize;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private java.lang.String path;

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    private int version;

    public static class Holder {
        private static java.lang.String sPath;

        public static void initPath(java.lang.String str) {
            java.io.File file = new java.io.File(str);
            java.io.File file2 = new java.io.File(file, com.autonavi.base.ae.gmap.bean.InitStorageParam.INIT_STORAGE_DIR);
            if (file.isDirectory()) {
                if (!file2.exists()) {
                    file2.mkdir();
                }
                java.io.File file3 = new java.io.File(file2, com.autonavi.base.ae.gmap.bean.InitStorageParam.DIR_NAME);
                if (!file3.exists()) {
                    file3.mkdir();
                }
                sPath = file3.getAbsolutePath();
            }
        }
    }

    private InitStorageParam() {
        this(1, com.autonavi.base.ae.gmap.bean.InitStorageParam.Holder.sPath, 1000, 300000L);
    }

    private InitStorageParam(int i, java.lang.String str, int i2, long j) {
        this.version = i;
        this.path = str;
        this.maxFileCount = i2;
        this.maxFileSize = j;
    }

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public static com.autonavi.base.ae.gmap.bean.InitStorageParam obtain() {
        return new com.autonavi.base.ae.gmap.bean.InitStorageParam();
    }

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public static com.autonavi.base.ae.gmap.bean.InitStorageParam obtain(int i, java.lang.String str, int i2, long j) {
        return new com.autonavi.base.ae.gmap.bean.InitStorageParam(i, str, i2, j);
    }

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public int getMaxFileCount() {
        return this.maxFileCount;
    }

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public long getMaxFileSize() {
        return this.maxFileSize;
    }

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public java.lang.String getPath() {
        return this.path;
    }

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public int getVersion() {
        return this.version;
    }

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public void setMaxFileCount(int i) {
        this.maxFileCount = i;
    }

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public void setMaxFileSize(long j) {
        this.maxFileSize = j;
    }

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public void setPath(java.lang.String str) {
        this.path = str;
    }

    @com.autonavi.base.amap.mapcore.jbinding.JBindingInclude
    public void setVersion(int i) {
        this.version = i;
    }

    public java.lang.String toString() {
        return "InitStorageParam{version=" + this.version + ", maxFileCount=" + this.maxFileCount + ", maxFileSize=" + this.maxFileSize + ", path='" + this.path + "'}";
    }
}
