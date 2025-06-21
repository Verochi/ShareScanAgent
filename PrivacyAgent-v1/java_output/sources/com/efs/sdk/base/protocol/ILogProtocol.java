package com.efs.sdk.base.protocol;

/* loaded from: classes22.dex */
public interface ILogProtocol {
    public static final java.lang.String KEY_PREFIX_NUM = "wl_";
    public static final java.lang.String KEY_PREFIX_STRING = "wk_";
    public static final java.lang.String KEY_PREFIX_TIMESTAMP = "wd_";
    public static final int LOG_BODY_TYPE_BYTE_ARRAY = 0;
    public static final int LOG_BODY_TYPE_FILE_PATH = 1;
    public static final java.lang.String LOG_KEY_TYPE = "type";
    public static final byte LOG_PROTOCOL_FILE = 2;
    public static final byte LOG_PROTOCOL_MIXED = 3;
    public static final byte LOG_PROTOCOL_NONE = 0;
    public static final byte LOG_PROTOCOL_RECORD = 1;

    byte[] generate();

    java.lang.String generateString();

    int getBodyType();

    java.lang.String getFilePath();

    java.lang.String getLinkId();

    java.lang.String getLinkKey();

    long getLogBeginTime();

    long getLogEndTime();

    byte getLogProtocol();

    java.lang.String getLogType();

    void insertGlobal(com.efs.sdk.base.core.config.GlobalInfo globalInfo);

    void setLogBeginTime(long j);

    void setLogEndTime(long j);
}
