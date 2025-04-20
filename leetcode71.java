import java.util.Stack;

public class leetcode71 {
    public String simplifyPath(String path) {
        Stack<String>st=new Stack<>();
        String[]newString=path.split("/");
        for(int i=0;i<newString.length;i++){
            if(newString[i].equals(".") || newString[i].equals("")){
                continue;
            }else if(newString[i].equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }else{
                st.push(newString[i]);
            }
        }if(st.isEmpty()){
            return "/";
        }
        String result="";
        while(!st.isEmpty()){
            result="/"+st.peek()+result;
            st.pop();
        }
        return result;
    }
}
