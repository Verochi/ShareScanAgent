package org.apache.tools.ant.types;

/* loaded from: classes26.dex */
public class FilterChain extends org.apache.tools.ant.types.DataType {
    public java.util.Vector<java.lang.Object> n = new java.util.Vector<>();

    public void add(org.apache.tools.ant.filters.ChainableReader chainableReader) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        setChecked(false);
        this.n.addElement(chainableReader);
    }

    public void addClassConstants(org.apache.tools.ant.filters.ClassConstants classConstants) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        setChecked(false);
        this.n.addElement(classConstants);
    }

    public void addContainsRegex(org.apache.tools.ant.filters.TokenFilter.ContainsRegex containsRegex) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        setChecked(false);
        this.n.addElement(containsRegex);
    }

    public void addDeleteCharacters(org.apache.tools.ant.filters.TokenFilter.DeleteCharacters deleteCharacters) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        setChecked(false);
        this.n.addElement(deleteCharacters);
    }

    public void addEscapeUnicode(org.apache.tools.ant.filters.EscapeUnicode escapeUnicode) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        setChecked(false);
        this.n.addElement(escapeUnicode);
    }

    public void addExpandProperties(org.apache.tools.ant.filters.ExpandProperties expandProperties) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        setChecked(false);
        this.n.addElement(expandProperties);
    }

    public void addFilterReader(org.apache.tools.ant.types.AntFilterReader antFilterReader) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        setChecked(false);
        this.n.addElement(antFilterReader);
    }

    public void addHeadFilter(org.apache.tools.ant.filters.HeadFilter headFilter) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        setChecked(false);
        this.n.addElement(headFilter);
    }

    public void addIgnoreBlank(org.apache.tools.ant.filters.TokenFilter.IgnoreBlank ignoreBlank) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        setChecked(false);
        this.n.addElement(ignoreBlank);
    }

    public void addLineContains(org.apache.tools.ant.filters.LineContains lineContains) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        setChecked(false);
        this.n.addElement(lineContains);
    }

    public void addLineContainsRegExp(org.apache.tools.ant.filters.LineContainsRegExp lineContainsRegExp) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        setChecked(false);
        this.n.addElement(lineContainsRegExp);
    }

    public void addPrefixLines(org.apache.tools.ant.filters.PrefixLines prefixLines) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        setChecked(false);
        this.n.addElement(prefixLines);
    }

    public void addReplaceRegex(org.apache.tools.ant.filters.TokenFilter.ReplaceRegex replaceRegex) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        setChecked(false);
        this.n.addElement(replaceRegex);
    }

    public void addReplaceString(org.apache.tools.ant.filters.TokenFilter.ReplaceString replaceString) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        setChecked(false);
        this.n.addElement(replaceString);
    }

    public void addReplaceTokens(org.apache.tools.ant.filters.ReplaceTokens replaceTokens) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        setChecked(false);
        this.n.addElement(replaceTokens);
    }

    public void addStripJavaComments(org.apache.tools.ant.filters.StripJavaComments stripJavaComments) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        setChecked(false);
        this.n.addElement(stripJavaComments);
    }

    public void addStripLineBreaks(org.apache.tools.ant.filters.StripLineBreaks stripLineBreaks) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        setChecked(false);
        this.n.addElement(stripLineBreaks);
    }

    public void addStripLineComments(org.apache.tools.ant.filters.StripLineComments stripLineComments) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        setChecked(false);
        this.n.addElement(stripLineComments);
    }

    public void addSuffixLines(org.apache.tools.ant.filters.SuffixLines suffixLines) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        setChecked(false);
        this.n.addElement(suffixLines);
    }

    public void addTabsToSpaces(org.apache.tools.ant.filters.TabsToSpaces tabsToSpaces) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        setChecked(false);
        this.n.addElement(tabsToSpaces);
    }

    public void addTailFilter(org.apache.tools.ant.filters.TailFilter tailFilter) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        setChecked(false);
        this.n.addElement(tailFilter);
    }

    public void addTokenFilter(org.apache.tools.ant.filters.TokenFilter tokenFilter) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        setChecked(false);
        this.n.addElement(tokenFilter);
    }

    public void addTrim(org.apache.tools.ant.filters.TokenFilter.Trim trim) {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        setChecked(false);
        this.n.addElement(trim);
    }

    @Override // org.apache.tools.ant.types.DataType
    public synchronized void dieOnCircularReference(java.util.Stack<java.lang.Object> stack, org.apache.tools.ant.Project project) throws org.apache.tools.ant.BuildException {
        if (isChecked()) {
            return;
        }
        if (isReference()) {
            super.dieOnCircularReference(stack, project);
        } else {
            java.util.Iterator<java.lang.Object> it = this.n.iterator();
            while (it.hasNext()) {
                java.lang.Object next = it.next();
                if (next instanceof org.apache.tools.ant.types.DataType) {
                    org.apache.tools.ant.types.DataType.pushAndInvokeCircularReferenceCheck((org.apache.tools.ant.types.DataType) next, stack, project);
                }
            }
            setChecked(true);
        }
    }

    public java.util.Vector<java.lang.Object> getFilterReaders() {
        if (isReference()) {
            return ((org.apache.tools.ant.types.FilterChain) getCheckedRef()).getFilterReaders();
        }
        dieOnCircularReference();
        return this.n;
    }

    @Override // org.apache.tools.ant.types.DataType
    public void setRefid(org.apache.tools.ant.types.Reference reference) throws org.apache.tools.ant.BuildException {
        if (!this.n.isEmpty()) {
            throw tooManyAttributes();
        }
        super.setRefid(reference);
    }
}
