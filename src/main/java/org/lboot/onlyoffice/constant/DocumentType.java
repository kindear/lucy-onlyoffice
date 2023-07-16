package org.lboot.onlyoffice.constant;

import java.util.HashSet;
import java.util.Set;

/**
 * @author kindear
 * 文档类型
 */
public class DocumentType {

    // 文本文档类型
    public static final Set<String> WORD_FILE = new HashSet<String>(){
        {
        add("djvu");
        add("doc");
        add("docm");
        add("docx");
        add("docxf");
        add("dot");
        add("dotm");
        add("dotx");
        add("epub");
        add("fb2");
        add("fodt");
        add("htm");
        add("html");
        add("mht");
        add("mhtml");
        add("odt");
        add("ofor");
        add("m");
        add("ott");
        add("oxps");
        add("pdf");
        add("rtf");
        add("stw");
        add("sxw");
        add("txt");
        add("wps");
        add("wpt");
        add("xml");
        add("xps");
        }
    };
    // 电子表格类型
    public static final Set<String> CELL_FILE = new HashSet<String>(){
        {
            add("csv");
            add("et");
            add("ett");
            add("fods");
            add("ods");
            add("ots");
            add("sxc");
            add("xls");
            add("xlsb");
            add("xlsm");
            add("xlsx");
            add("xlt");
            add("xltm");
            add("xltx");
            add("xml");
        }
    };
    // 演示文稿类型
    public static final Set<String> SLIDE_FILE = new HashSet<String>(){
        {
            add("dps");
            add("dpt");
            add("fodp");
            add("odp");
            add("otp");
            add("pot");
            add("potm");
            add("potx");
            add("pps");
            add("ppsm");
            add("ppsx");
            add("ppt");
            add("pptm");
            add("pptx");
            add("sxi");
        }
    };

}
