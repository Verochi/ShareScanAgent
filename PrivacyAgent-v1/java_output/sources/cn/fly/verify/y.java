package cn.fly.verify;

/* loaded from: classes.dex */
public class y {
    private static cn.fly.verify.y a;
    private java.security.PublicKey b = null;
    private java.security.PublicKey c = null;

    private y() {
        try {
            b();
            if (this.c == null) {
                c();
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static cn.fly.verify.y a() {
        if (a == null) {
            a = new cn.fly.verify.y();
        }
        return a;
    }

    private void b() throws java.lang.Exception {
        try {
            this.b = java.security.KeyFactory.getInstance(com.alipay.sdk.m.n.d.a).generatePublic(new java.security.spec.X509EncodedKeySpec(android.util.Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDNFGdEpQ1d8cPqekvvEDQyBGnI\nKwvjX9o3OmnnqWMGbIiFYIpc21QeG7aqizuWdXlgS5M9rstDfHQfG/AaPElJ7Yix\nBCau4hdVwFpRmb9NIuqavDeHKP9BKPZ01Ra5/666NGKBqmkRRer3lBCe6EKNUc2U\n/DZg6U/Q3CTPiORt/wIDAQAB", 0)));
        } catch (java.lang.NullPointerException e) {
            e.printStackTrace();
        }
    }

    private void c() throws java.lang.Exception {
        try {
            this.c = java.security.KeyFactory.getInstance(com.alipay.sdk.m.n.d.a).generatePublic(new java.security.spec.X509EncodedKeySpec(android.util.Base64.decode("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuyqBGJVxu+5Z2ZwItIhl\noxI53CVpYUR3OWAQyAQNcMhDDf3nGsxLLHP8kGWqrpLn1uAIgI+EIAl0sM+i1leD\nFD+sYU2rkUVZgpwO7ly+THBFw/YcZNwS094NBdhzxmCCFbCKHVNzDLirlV9T2q4k\nJhjaEmyCOtSU6+mdjcHhbcbF6lKYx8tfQlpPmyM5suFY138qtEoB4b+q/j8q22MI\naUotg1Av257RuMh97hAwoi5D7HS5LH0piLIN/au/X08rxbXnWNdgQtFtUeCNy3vw\nkO0ykg5qH942X8poQ+a9GgBUeDBpY4GSIv6/qq+zJxiJxpoL0SGKAP3FlcuLr07f\nxwIDAQAB", 0)));
        } catch (java.lang.NullPointerException unused) {
            throw new java.lang.Exception("公钥输入流为空");
        }
    }

    public java.lang.String a(byte[] bArr) {
        if (this.b == null) {
            return "";
        }
        try {
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA/ECB/OAEPWithSHA256AndMGF1Padding");
            cipher.init(1, this.b);
            return cn.fly.verify.ab.a(cipher.doFinal(bArr));
        } catch (java.lang.Exception unused) {
            return "";
        }
    }
}
