

import java.util.*;
import java.util.regex.Pattern;
public class JavaFirst {
 public static void main(String[] args) {
 // TODO Auto-generated method stub
 Scanner sc=new Scanner(System.in);
 System.out.println();
 String s=sc.nextLine();
 if(Pattern.matches("[a-zA-Z ]+", s))
 {
 String array[]=s.split(" ");
 String result="";
 for(int k=0;k<array.length;k++)
 {
 String sub="";
 int count=0;
 for(int i=0;i<array[k].length();i++)
 {
 count=0;
 char ch= array[k].charAt(i);
 for(int j=0;j<array[k].length();j++)
 {
 if(i==j)
 continue;
 else if(ch==array[k].charAt(j))
 count++;
 }
 if(count==0) 
	 sub+=ch;
 else
 continue;
 }
 result+=sub+" ";
 }
 System.out.println(result);
 }
 else
 {
 System.out.println(s+" is an invalid sentence");
 return;
 }
 }
} 