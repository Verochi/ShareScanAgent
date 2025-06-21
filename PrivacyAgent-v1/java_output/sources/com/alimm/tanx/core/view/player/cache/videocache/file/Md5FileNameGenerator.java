package com.alimm.tanx.core.view.player.cache.videocache.file;

/* loaded from: classes.dex */
public class Md5FileNameGenerator implements com.alimm.tanx.core.view.player.cache.videocache.file.FileNameGenerator {
    private static final int MAX_EXTENSION_LENGTH = 4;

    private java.lang.String getExtension(java.lang.String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf == -1 || lastIndexOf <= str.lastIndexOf(47) || (lastIndexOf + 2) + 4 <= str.length()) ? "" : str.substring(lastIndexOf + 1, str.length());
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.file.FileNameGenerator
    public java.lang.String generate(java.lang.String str) {
        java.lang.String extension = getExtension(str);
        java.lang.String computeMD5 = com.alimm.tanx.core.view.player.cache.videocache.ProxyCacheUtils.computeMD5(str);
        if (android.text.TextUtils.isEmpty(extension)) {
            return computeMD5;
        }
        return computeMD5 + "." + extension;
    }
}
