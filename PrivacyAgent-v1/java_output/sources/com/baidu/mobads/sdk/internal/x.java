package com.baidu.mobads.sdk.internal;

/* loaded from: classes.dex */
public interface x {

    public enum a {
        NONE(-1, "未开始"),
        INITING(0, "下载准备中"),
        DOWNLOADING(1, "正在下载"),
        CANCELLED(2, "已取消下载"),
        COMPLETED(3, "下载完成"),
        ERROR(4, "下载失败"),
        COMPLETE_BUT_FILE_REMOVED(5, "下载完但文件异常"),
        PAUSED(6, "已暂停下载");

        private int i;
        private java.lang.String j;

        a(int i, java.lang.String str) {
            this.i = i;
            this.j = str;
        }

        public int b() {
            return this.i;
        }

        public java.lang.String c() {
            return this.j;
        }
    }

    void a();

    void a(boolean z);

    void addObserver(java.util.Observer observer);

    void b();

    void c();

    void d();

    java.lang.String e();

    java.lang.String f();

    java.lang.String g();

    java.lang.String h();

    java.lang.String i();

    int j();

    float k();

    com.baidu.mobads.sdk.internal.x.a l();

    void m();

    boolean n();
}
