package com.cicada.player.utils.media;

@com.cicada.player.utils.NativeUsed
/* loaded from: classes22.dex */
public class EncryptionInfo {
    public java.lang.String scheme;
    public int crypt_byte_block = 0;
    public int skip_byte_block = 0;
    public byte[] key_id = null;
    public byte[] iv = null;
    public java.util.List<com.cicada.player.utils.media.SubsampleEncryptionInfo> subsamples = null;

    public void setIv(byte[] bArr) {
        this.iv = bArr;
    }

    public void setKeyId(byte[] bArr) {
        this.key_id = bArr;
    }

    public void setScheme(java.lang.String str) {
        this.scheme = str;
    }

    public void setSubsamples(java.lang.Object obj) {
        this.subsamples = (java.util.List) obj;
    }
}
