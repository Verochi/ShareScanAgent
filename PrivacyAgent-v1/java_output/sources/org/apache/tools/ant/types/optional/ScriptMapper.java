package org.apache.tools.ant.types.optional;

/* loaded from: classes26.dex */
public class ScriptMapper extends org.apache.tools.ant.types.optional.AbstractScriptComponent implements org.apache.tools.ant.util.FileNameMapper {
    public java.util.ArrayList<java.lang.String> u;

    public void addMappedName(java.lang.String str) {
        this.u.add(str);
    }

    public void clear() {
        this.u = new java.util.ArrayList<>(1);
    }

    @Override // org.apache.tools.ant.util.FileNameMapper
    public java.lang.String[] mapFileName(java.lang.String str) {
        initScriptRunner();
        getRunner().addBean(com.tencent.open.SocialConstants.PARAM_SOURCE, str);
        clear();
        executeScript("ant_mapper");
        if (this.u.size() == 0) {
            return null;
        }
        java.util.ArrayList<java.lang.String> arrayList = this.u;
        return (java.lang.String[]) arrayList.toArray(new java.lang.String[arrayList.size()]);
    }

    @Override // org.apache.tools.ant.util.FileNameMapper
    public void setFrom(java.lang.String str) {
    }

    @Override // org.apache.tools.ant.util.FileNameMapper
    public void setTo(java.lang.String str) {
    }
}
