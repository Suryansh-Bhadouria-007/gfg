package mock2.removeComments;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String source[] = {"/*Test program */",
                "int main()",
                "{ ",
                "  // variable declaration ",
                "int a, b, c;",
                "/* This is a test",
                "   multiline  ",
                "   comment for ",
                "   testing */",
                "a = b + c;",
                "}"};
//        String source[] = {"a//*b//*c", "blank", "d/*/e*//f"};
        System.out.println(removeComments(source));
    }

    public static List<String> removeComments(String[] source) {
        List<String> code = new ArrayList<>();
        String str;
        for (int i = 0; i < source.length; ) {
            str = source[i];
            if (str.contains("//") || str.contains("/*")) {
                if (str.contains("//") && str.contains("/*")) {
                    int indexLine = str.indexOf("//");
                    int indexblock = str.indexOf("/*");
                    if (indexLine < indexblock) {
                        //consider as line
                        String split[] = str.split("//");
                        if (split[0].trim().length() > 0) {
                            code.add(split[0]);
                        }
                        i++;
                    } else {
                        //consider as block comment
                        String split[] = str.split("/*");
                        if (split[0].trim().length() > 0) {
                            code.add(split[0]);
                        }
                        if (!((str.indexOf("/*") + 1) == str.lastIndexOf("*/")) && str.indexOf("/*") < str.indexOf("*/")) {
                            //ends in same line
                            split = str.split("\\*/");
                            if (split.length > 1 && split[split.length-1].trim().length() > 0) {
                                if(!split[split.length-1].startsWith("/") && split[split.length-1].trim().length()>0)
                                code.add(split[split.length-1]);
                            }
                        } else {
                            while (i < source.length) {
                                str = source[++i];
                                if (str.contains("*/"))
                                    break;
                            }
                        }
                        i++;
                    }

                } else if (str.contains("//")) {
                    //line comment
                    String split[] = str.split("//");
                    if (split[0].trim().length() > 0) {
                        code.add(split[0]);
                    }
                    i++;
                } else if (str.contains("/*")) {
                    //block comment
                    String split[] = str.split("/*");
                    if (split[0].trim().length() > 0) {
                        code.add(split[0]);
                    }
                    if (!((str.indexOf("/*") + 1) == str.lastIndexOf("*/")) && str.indexOf("/*") < str.indexOf("*/")) {
                        split = str.split("\\*/");
                        if (split.length > 1 && split[split.length-1].trim().length() > 0) {
                            if(split[split.length-1].trim().length()>0)
                                code.add(split[split.length-1]);
                        }
                    } else {
                        while (i < source.length) {
                            str = source[++i];
                            if (str.contains("*/"))
                                break;
                        }
                    }
                    i++;
                }
            } else {
                if (str.trim().length() > 0)
                    code.add(str);
                i++;
            }
        }
        return code;
    }
}
