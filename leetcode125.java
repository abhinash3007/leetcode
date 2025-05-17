public class leetcode125 {
    public boolean isPalindrome(String s) {
        String s1="";
        s=s.toLowerCase();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if((c>='a' && c<='z') || (c>='0' && c<='9')){
                s1+=c;
            }
        }
        String s2 = new StringBuilder(s1).reverse().toString();
        return s1.equals(s2); 
    }
}
