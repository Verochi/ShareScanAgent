package org.apache.commons.codec.digest;

/* loaded from: classes24.dex */
public class DigestUtils {
    public static byte[] a(java.security.MessageDigest messageDigest, java.io.InputStream inputStream) throws java.io.IOException {
        byte[] bArr = new byte[1024];
        int read = inputStream.read(bArr, 0, 1024);
        while (read > -1) {
            messageDigest.update(bArr, 0, read);
            read = inputStream.read(bArr, 0, 1024);
        }
        return messageDigest.digest();
    }

    public static byte[] b(java.lang.String str) {
        return org.apache.commons.codec.binary.StringUtils.getBytesUtf8(str);
    }

    public static java.security.MessageDigest c(java.lang.String str) {
        try {
            return java.security.MessageDigest.getInstance(str);
        } catch (java.security.NoSuchAlgorithmException e) {
            throw new java.lang.RuntimeException(e.getMessage());
        }
    }

    public static java.security.MessageDigest d() {
        return c("MD5");
    }

    public static java.security.MessageDigest e() {
        return c("SHA-256");
    }

    public static java.security.MessageDigest f() {
        return c("SHA-384");
    }

    public static java.security.MessageDigest g() {
        return c("SHA-512");
    }

    public static java.security.MessageDigest h() {
        return c(com.huawei.secure.android.common.encrypt.hash.SHA.a);
    }

    public static byte[] md5(java.io.InputStream inputStream) throws java.io.IOException {
        return a(d(), inputStream);
    }

    public static byte[] md5(java.lang.String str) {
        return md5(b(str));
    }

    public static byte[] md5(byte[] bArr) {
        return d().digest(bArr);
    }

    public static java.lang.String md5Hex(java.io.InputStream inputStream) throws java.io.IOException {
        return org.apache.commons.codec.binary.Hex.encodeHexString(md5(inputStream));
    }

    public static java.lang.String md5Hex(java.lang.String str) {
        return org.apache.commons.codec.binary.Hex.encodeHexString(md5(str));
    }

    public static java.lang.String md5Hex(byte[] bArr) {
        return org.apache.commons.codec.binary.Hex.encodeHexString(md5(bArr));
    }

    public static byte[] sha(java.io.InputStream inputStream) throws java.io.IOException {
        return a(h(), inputStream);
    }

    public static byte[] sha(java.lang.String str) {
        return sha(b(str));
    }

    public static byte[] sha(byte[] bArr) {
        return h().digest(bArr);
    }

    public static byte[] sha256(java.io.InputStream inputStream) throws java.io.IOException {
        return a(e(), inputStream);
    }

    public static byte[] sha256(java.lang.String str) {
        return sha256(b(str));
    }

    public static byte[] sha256(byte[] bArr) {
        return e().digest(bArr);
    }

    public static java.lang.String sha256Hex(java.io.InputStream inputStream) throws java.io.IOException {
        return org.apache.commons.codec.binary.Hex.encodeHexString(sha256(inputStream));
    }

    public static java.lang.String sha256Hex(java.lang.String str) {
        return org.apache.commons.codec.binary.Hex.encodeHexString(sha256(str));
    }

    public static java.lang.String sha256Hex(byte[] bArr) {
        return org.apache.commons.codec.binary.Hex.encodeHexString(sha256(bArr));
    }

    public static byte[] sha384(java.io.InputStream inputStream) throws java.io.IOException {
        return a(f(), inputStream);
    }

    public static byte[] sha384(java.lang.String str) {
        return sha384(b(str));
    }

    public static byte[] sha384(byte[] bArr) {
        return f().digest(bArr);
    }

    public static java.lang.String sha384Hex(java.io.InputStream inputStream) throws java.io.IOException {
        return org.apache.commons.codec.binary.Hex.encodeHexString(sha384(inputStream));
    }

    public static java.lang.String sha384Hex(java.lang.String str) {
        return org.apache.commons.codec.binary.Hex.encodeHexString(sha384(str));
    }

    public static java.lang.String sha384Hex(byte[] bArr) {
        return org.apache.commons.codec.binary.Hex.encodeHexString(sha384(bArr));
    }

    public static byte[] sha512(java.io.InputStream inputStream) throws java.io.IOException {
        return a(g(), inputStream);
    }

    public static byte[] sha512(java.lang.String str) {
        return sha512(b(str));
    }

    public static byte[] sha512(byte[] bArr) {
        return g().digest(bArr);
    }

    public static java.lang.String sha512Hex(java.io.InputStream inputStream) throws java.io.IOException {
        return org.apache.commons.codec.binary.Hex.encodeHexString(sha512(inputStream));
    }

    public static java.lang.String sha512Hex(java.lang.String str) {
        return org.apache.commons.codec.binary.Hex.encodeHexString(sha512(str));
    }

    public static java.lang.String sha512Hex(byte[] bArr) {
        return org.apache.commons.codec.binary.Hex.encodeHexString(sha512(bArr));
    }

    public static java.lang.String shaHex(java.io.InputStream inputStream) throws java.io.IOException {
        return org.apache.commons.codec.binary.Hex.encodeHexString(sha(inputStream));
    }

    public static java.lang.String shaHex(java.lang.String str) {
        return org.apache.commons.codec.binary.Hex.encodeHexString(sha(str));
    }

    public static java.lang.String shaHex(byte[] bArr) {
        return org.apache.commons.codec.binary.Hex.encodeHexString(sha(bArr));
    }
}
