package com.aliyun.player;

/* loaded from: classes.dex */
public class HlsKeyGenerator {
    private static com.aliyun.player.HlsKeyGenerator instance;
    private com.aliyun.player.HlsKeyGenerator.OnKeyGenerateListener mOnKeyGenerateListener = null;

    public interface OnKeyGenerateListener {
        byte[] getHlsKey(java.lang.String str, java.lang.String str2);

        void onHlsKeyInfoInit(java.lang.String str, int i, java.lang.String str2);
    }

    static {
        com.aliyun.utils.f.f();
        instance = null;
    }

    private HlsKeyGenerator() {
    }

    private static byte[] getHlsKey(java.lang.String str, java.lang.String str2) {
        com.aliyun.player.HlsKeyGenerator.OnKeyGenerateListener onKeyGenerateListener = getInstance().mOnKeyGenerateListener;
        if (onKeyGenerateListener != null) {
            return onKeyGenerateListener.getHlsKey(str, str2);
        }
        return null;
    }

    public static com.aliyun.player.HlsKeyGenerator getInstance() {
        if (instance == null) {
            synchronized (com.aliyun.player.HlsKeyGenerator.class) {
                if (instance == null) {
                    instance = new com.aliyun.player.HlsKeyGenerator();
                }
            }
        }
        return instance;
    }

    public static void loadClass() {
    }

    private static void onHlsKeyInfoInit(java.lang.String str, int i, java.lang.String str2) {
        com.aliyun.player.HlsKeyGenerator.OnKeyGenerateListener onKeyGenerateListener = getInstance().mOnKeyGenerateListener;
        if (onKeyGenerateListener != null) {
            onKeyGenerateListener.onHlsKeyInfoInit(str, i, str2);
        }
    }

    public void setOnKeyGenerateListener(com.aliyun.player.HlsKeyGenerator.OnKeyGenerateListener onKeyGenerateListener) {
        this.mOnKeyGenerateListener = onKeyGenerateListener;
    }
}
