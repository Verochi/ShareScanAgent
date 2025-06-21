package org.apache.tools.ant.types.mappers;

/* loaded from: classes26.dex */
public class FilterMapper extends org.apache.tools.ant.types.FilterChain implements org.apache.tools.ant.util.FileNameMapper {
    @Override // org.apache.tools.ant.util.FileNameMapper
    public java.lang.String[] mapFileName(java.lang.String str) {
        if (str == null) {
            return null;
        }
        try {
            java.io.StringReader stringReader = new java.io.StringReader(str);
            org.apache.tools.ant.filters.util.ChainReaderHelper chainReaderHelper = new org.apache.tools.ant.filters.util.ChainReaderHelper();
            chainReaderHelper.setBufferSize(8192);
            chainReaderHelper.setPrimaryReader(stringReader);
            chainReaderHelper.setProject(getProject());
            java.util.Vector<org.apache.tools.ant.types.FilterChain> vector = new java.util.Vector<>();
            vector.add(this);
            chainReaderHelper.setFilterChains(vector);
            java.lang.String safeReadFully = org.apache.tools.ant.util.FileUtils.safeReadFully(chainReaderHelper.getAssembledReader());
            if (safeReadFully.length() == 0) {
                return null;
            }
            return new java.lang.String[]{safeReadFully};
        } catch (org.apache.tools.ant.BuildException e) {
            throw e;
        } catch (java.lang.Exception e2) {
            throw new org.apache.tools.ant.BuildException(e2);
        }
    }

    @Override // org.apache.tools.ant.util.FileNameMapper
    public void setFrom(java.lang.String str) {
        throw new org.apache.tools.ant.UnsupportedAttributeException("filtermapper doesn't support the \"from\" attribute.", "from");
    }

    @Override // org.apache.tools.ant.util.FileNameMapper
    public void setTo(java.lang.String str) {
        throw new org.apache.tools.ant.UnsupportedAttributeException("filtermapper doesn't support the \"to\" attribute.", com.huawei.hms.push.constant.RemoteMessageConst.TO);
    }
}
