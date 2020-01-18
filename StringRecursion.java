public class StringRecursion {
    public static int val;

    public static void printLetters(String str) {
        if (str == null || str.length() == 0) {
            // do nothing, just return
            System.out.print(" ");
        } else if (str.length() == 1) {
            System.out.println(str.charAt(0));
        } else {
            System.out.print(str.charAt(0) + "," + " ");
            printLetters(str.substring(1));
        }

    }

    public static String weave(String str1, String str2) {
        String s = "";
        if (str1 == null || str2 == null) {
            return "null string";
        } else if (str1 == "" && (str2 != "")) {
            return s + str2;
        } else if (str2 == "" && (str1 != "")) {
            return s + str1;

        }else if(str1.length() == 1 && str2.length() !=1){
            return s+ str1.charAt(0);
        }else if(str2.length() == 1 && str1.length() !=1){
            return s+ str2.charAt(0);
        }else if(str1.length() ==1 && str2.length() ==1 ){
            return s + str1.charAt(0) + str2.charAt(0);
        }else {
            return s + str1.charAt(0) + str2.charAt(0) + weave(str1.substring(1), str2.substring(1));

        }
    }

    public static int indexOf(char ch, String str) {
        if(val >= str.length()){
            val = -1;
        }
        if (str == null || str == "") {
            val = 0;
        } else {
            if (ch == str.charAt(0)) {
                val = str.indexOf(str.charAt(0));
            } else {
                val = 1 + indexOf(ch, str.substring(1));
            }

        }
        
        return val;
    }

    public static void main(String[] args) {
        printLetters("Jamba");
        System.out.println(weave("hello", "world"));
        String s = "Dog";
        char ch = 'p';
        System.out.println(indexOf(ch, s));

    }

}