package com.getkeepsafe.relinker.elf;

/* loaded from: classes22.dex */
public class Section64Header extends com.getkeepsafe.relinker.elf.Elf.SectionHeader {
    public Section64Header(com.getkeepsafe.relinker.elf.ElfParser elfParser, com.getkeepsafe.relinker.elf.Elf.Header header, int i) throws java.io.IOException {
        java.nio.ByteBuffer allocate = java.nio.ByteBuffer.allocate(8);
        allocate.order(header.bigEndian ? java.nio.ByteOrder.BIG_ENDIAN : java.nio.ByteOrder.LITTLE_ENDIAN);
        this.info = elfParser.readWord(allocate, header.shoff + (i * header.shentsize) + 44);
    }
}
