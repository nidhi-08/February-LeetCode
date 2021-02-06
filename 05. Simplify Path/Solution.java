import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        Deque<String> deque = new LinkedList<>();
        for (int i = 0; i < path.length(); i++) {
            switch (path.charAt(i)) {
                case '.':
                    //if character is a '.'
                    //if it is the last char or if the next char is '/' do nothing
                    if (i + 1 == path.length() || path.charAt(i + 1) == '/')
                        break;
                    //if the next char is also '.' then remove last element of deque
                    if (path.charAt(i + 1) == '.' && (i + 2 == path.length() || path.charAt(i + 2) == '/')) {
                        if (!deque.isEmpty())
                            deque.removeLast();
                        i++;
                        break;
                    }
                    //else add all the elements to the deque till next '/'
                    int sstart = i;
                    while (i + 1 < path.length() && path.charAt(i + 1) != '/') {
                        i++;
                    }
                    deque.add(path.substring(sstart, i + 1));
                    break;


                case '/':
                    // if character is a '/'
                    //if it is the last char or if the next char is '/' do nothing
                    while (i + 1 < path.length() && path.charAt(i + 1) == '/') {
                        i++;
                    }
                    break;

                default:
                    //else for all other characters
                    // add everything to deque
                    int start = i;
                    while (i + 1 < path.length() && path.charAt(i + 1) != '/') {
                        i++;
                    }
                    deque.add(path.substring(start, i + 1));
                    break;
            }  //end of switch
        }   //end of for

        if (deque.size() == 0)
            return "/";
        
        StringBuilder result = new StringBuilder();
        for (String dir : deque)
            result.append("/").append(dir);

        return result.toString();
    }
}
