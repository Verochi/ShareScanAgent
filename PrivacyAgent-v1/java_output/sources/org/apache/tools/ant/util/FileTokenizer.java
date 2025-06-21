package org.apache.tools.ant.util;

/* loaded from: classes26.dex */
public class FileTokenizer extends org.apache.tools.ant.ProjectComponent implements org.apache.tools.ant.util.Tokenizer {
    @Override // org.apache.tools.ant.util.Tokenizer
    public java.lang.String getPostToken() {
        return "";
    }

    @Override // org.apache.tools.ant.util.Tokenizer
    public java.lang.String getToken(java.io.Reader reader) throws java.io.IOException {
        return org.apache.tools.ant.util.FileUtils.readFully(reader);
    }
}
