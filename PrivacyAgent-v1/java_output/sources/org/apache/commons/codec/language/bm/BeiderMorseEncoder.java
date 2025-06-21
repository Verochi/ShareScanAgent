package org.apache.commons.codec.language.bm;

/* loaded from: classes24.dex */
public class BeiderMorseEncoder implements org.apache.commons.codec.StringEncoder {
    public org.apache.commons.codec.language.bm.PhoneticEngine a = new org.apache.commons.codec.language.bm.PhoneticEngine(org.apache.commons.codec.language.bm.NameType.GENERIC, org.apache.commons.codec.language.bm.RuleType.APPROX, true);

    @Override // org.apache.commons.codec.Encoder
    public java.lang.Object encode(java.lang.Object obj) throws org.apache.commons.codec.EncoderException {
        if (obj instanceof java.lang.String) {
            return encode((java.lang.String) obj);
        }
        throw new org.apache.commons.codec.EncoderException("BeiderMorseEncoder encode parameter is not of type String");
    }

    @Override // org.apache.commons.codec.StringEncoder
    public java.lang.String encode(java.lang.String str) throws org.apache.commons.codec.EncoderException {
        if (str == null) {
            return null;
        }
        return this.a.encode(str);
    }

    public org.apache.commons.codec.language.bm.NameType getNameType() {
        return this.a.getNameType();
    }

    public org.apache.commons.codec.language.bm.RuleType getRuleType() {
        return this.a.getRuleType();
    }

    public boolean isConcat() {
        return this.a.isConcat();
    }

    public void setConcat(boolean z) {
        this.a = new org.apache.commons.codec.language.bm.PhoneticEngine(this.a.getNameType(), this.a.getRuleType(), z);
    }

    public void setNameType(org.apache.commons.codec.language.bm.NameType nameType) {
        this.a = new org.apache.commons.codec.language.bm.PhoneticEngine(nameType, this.a.getRuleType(), this.a.isConcat());
    }

    public void setRuleType(org.apache.commons.codec.language.bm.RuleType ruleType) {
        this.a = new org.apache.commons.codec.language.bm.PhoneticEngine(this.a.getNameType(), ruleType, this.a.isConcat());
    }
}
