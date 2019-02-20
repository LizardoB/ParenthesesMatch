/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parenthesesmatch;

import java.util.Stack;

/**
 *
 * @author Lizardo
 */
public class ParenthesesMatch {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("(a[0]+b[2c[6]]){24+53} passed: " + parensMatch("(a[0]+b[2c[6]]){24+53} :"));
        System.out.println("(empty) passed: " + !parensMatch("(empty) :"));
        System.out.println("([)] passed: " + !parensMatch("([)] :"));
        System.out.println("   passed: " + !parensMatch("   "));
    }
 
    public static boolean parensMatch(String Sentence){
     
        if (Sentence.charAt(0) == '{')
        {
            return false;
        }
        
        Stack<Character> stack = new Stack<>();

        char c;
        for(int i=0; i < Sentence.length(); i++) {
            c = Sentence.charAt(i);

            switch (c) {
                case '(':
                    stack.push(c);
                    break;
                case '[':
                    stack.push(c);
                    break;
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if(stack.empty())
                        return false;
                    else if(stack.peek() == '(')
                        stack.pop();
                    else
                        return false;
                    break;
                case ']':
                    if(stack.empty())
                        return false;
                    else if(stack.peek() == '[')
                        stack.pop();
                    else
                        return false;
                    break;
                case '}':
                    if(stack.empty())
                        return false;
                    else if(stack.peek() == '{')
                        stack.pop();
                    else
                        return false;
                    break;
                default:
                    break;
            }
        }
        return stack.empty();
    }
}
