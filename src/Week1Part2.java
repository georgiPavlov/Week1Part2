import java.math.BigInteger;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by georgipavlov on 20.11.15.
 */
public class Week1Part2 {

    public boolean isHack(int n){
        n = Math.abs(n);
        Stack<Integer> stack = new Stack<>();
       int temp;
        while(n != 0 ){
            temp = n % 2;
            stack.add(temp);
        }
        String string;
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            b.append(stack.pop());
        }
        string = b.toString();
        int count=0;
        if(string.length() % 2 != 0){
            for (int i = 0; i < string.length(); i++) {
                if(string.charAt(0) == 1){
                    count++;
                }
            }
            if(count % 2 != 0){
                return true;
            }
        }
        return false;

    }



    public void nextHack(int n){
        if(isHack(n)){
            n++;
            while (!isHack(n)) {
               if(n == Integer.MAX_VALUE){
                   System.out.println("no next hack number");
                   return;
               }
                n++;
            }
            System.out.print("Next number: " + n);
        }
    }

    public int  countVowels(String str){
       String line ="aeiouy";
        char[] charArray = str.toCharArray() ;
        int count=0;
        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j <line.length() ; j++) {
               if(Character.isLetter(line.charAt(j))) {
                    if (Character.toLowerCase(charArray[i]) ==
                            Character.toLowerCase(line.charAt(j))) {
                        count++;
                    }
                }
            }
        }
        return count;

    }


    public int  countConsonants(String str){
        String line ="bcdfghjklmnpqrstvwxz";
        char[] charArray = str.toCharArray() ;
        int count=0;
        for (int i = 0; i < charArray.length; i++) {
            for (int j = 0; j <line.length() ; j++) {
                if(Character.isLetter(line.charAt(j))) {
                    if (Character.toLowerCase(charArray[i]) ==
                            Character.toLowerCase(line.charAt(j))) {
                        count++;
                    }
                }
            }
        }
        return count;

    }




    private  int count;
    private boolean palTrue=true;

    public int PalindromeScore(int n){
        if(isPalindrome(n) && palTrue){
            return 1;
        }else if(!palTrue){
            System.out.println("palindrome not found ");
            return 0;
        } else {
            int func=pScore(n);
            return PalindromeScore(func);
        }
    }


    public int pScore(int n){
        int func;
        String string = Integer.toString(n);
        StringBuilder b =new StringBuilder(string);
        string=b.reverse().toString();
        BigInteger bigInteger = BigInteger.valueOf(n);
        bigInteger.add(BigInteger.valueOf(Integer.parseInt(string)));
        bigInteger.add(BigInteger.valueOf(1));
        if(bigInteger.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) == -1){
            func = Integer.parseInt(bigInteger.toString());
            return func;
        }
        palTrue=false;
        return 0;
    }

    public  boolean isPalindrome(int n){
        n= Math.abs(n);
        String argument= Integer.toString(n);
        int size = argument.length();
        int frond = 0;
        int back = size;

        while (frond <= back) {
            char start = argument.charAt(frond);
            char end = argument.charAt(back);

            if (!(start == end)) {
                return false;
            }
            frond++;
            back--;
        }
        return true;
    }

    private int[] pressedSequence;
     private StringBuilder b = new StringBuilder();
     private boolean upperLetter=false;

    public String numbersToMessage(int[] pressedSequence1){
        pressedSequence=pressedSequence1;

        p: for (int i = 0; i < pressedSequence.length; i++) {


            if(pressedSequence[i]==1){
                upperLetter=true;
            }
            if(pressedSequence[i]==0){
                b.append(" ");
            }else {
                switch (pressedSequence[i]){
                    case 2:
                        i= Letter(i ,'a','b','c',' ');
                        continue p;

                    case 3:
                        i= Letter(i ,'d','e','f',' ');
                        continue p;

                    case 4:
                        i= Letter(i ,'g','h','i',' ');
                        continue p;


                    case 5:
                        i= Letter(i ,'j','k','l',' ');
                        continue p;


                    case 6:
                        i= Letter(i ,'m','n','o',' ');
                        continue p;

                    case 7:
                        i= Letter(i ,'p','q','r','s');
                        continue p;

                    case 8:
                        i= Letter(i ,'t','u','v',' ');
                        continue p;

                    case 9:
                        i= Letter(i ,'w','x','y','z');
                        continue p;
                }
            }
        }
        return b.toString();
    }

    private int Letter(int i,char x,char y,char z,char w ) {
        int temp =i;
        int count=1;
        int tempCount;
        while (pressedSequence[i]==pressedSequence[temp]){
            if(pressedSequence[i]== -1){
                break ;
            }
            temp++;
            count++;
        }
        if(w == ' ' && count > 3){
            tempCount = count;
            count=3;
            temp -=tempCount-count;


        }else  if(w != ' ' && count > 4){
            tempCount = count;
            count=4;
            temp -=tempCount-count;

        }
        if(count == 2){
            if(upperLetter){b.append(Character.toUpperCase(x));
                upperLetter=false;}
            else {b.append(x);}
        }else  if(count == 2){
            if(upperLetter){b.append(Character.toUpperCase(y));
                upperLetter=false;}
            else {b.append(y);}
        }else if(count == 3){
            if(upperLetter){b.append(Character.toUpperCase(z));
                upperLetter=false;}
            else {b.append(z);}
        }else{
            if(upperLetter){b.append(Character.toUpperCase(w));
                upperLetter=false;}
            else {b.append(w);}
        }
        return temp;
    }



    private int index=0;
    public int friday_years(String start, String end){
        int w;
        index=hasStartOneMoreFriday("0",start);
        w = hasStartOneMoreFriday(start,end);
        return w;
    }



    public int  hasStartOneMoreFriday(String start,String end){
        if((!march2(start)) || (!march2(end))){
            System.out.println("invalid input years must be positive and from 0 to 100000");
            return 0;
        }
        String[] days= {
            "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY",
            "THURSDAY", "FRIDAY", "SATURDAY"
        };
        int startYear = Integer.parseInt(start);
        int endYear =Integer.parseInt(end);
        int count=8;
        int c=index;
        boolean isLeap=false;
        StringBuilder b = new StringBuilder();
        int weaks=0;
        for (int year = startYear; year <= endYear; year++) {
            if(((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)){
                count = 9;
                isLeap=true;
            }
            for (int j = 0; j < count; j++) {
                if(c > days.length){
                    c=0;
                }
                if(b.length() > 0){
                    b.setLength(0);
                }
                b.append(days[c]);
                c++;
            }
            if(isLeap || b.equals("FRIDAY")){
               weaks +=53;
                isLeap=false;
            }else {
                weaks +=52;
            }
            count=8;
        }
        return  index == 0 ? c : weaks;

    }


    //weak2
    private Pattern pattern;
    private Pattern pattern2;

    private Matcher matcher;
    private Matcher matcher2;


    public boolean march(String number){
         final String USERNAME_PATTERN = "^[0-9]$";
        pattern = Pattern.compile(USERNAME_PATTERN);
        matcher = pattern.matcher(number);

        return matcher.matches();

    }

    public boolean march2(String number){
        final String USERNAME_PATTERN = "^[0-9]{0,1000000}$";
        pattern2 = Pattern.compile(USERNAME_PATTERN);
        matcher2 = pattern2.matcher(number);

        return matcher2.matches();

    }

    public boolean is_credit_card_valid(String number){
        if(number.length() % 2 == 0 || march(number)){
            System.out.println("string length is not odd or" +
                    " it contains not only numbers");
            return false;
        }
        long sum=0;
        BigInteger bigFac = BigInteger.valueOf(0);
        for (int i = 0; i < number.length() ; i++) {
           if(i % 2 != 0){
               bigFac.add(BigInteger.valueOf(Integer.parseInt(String.valueOf(number.charAt(i)))));
           }else {
               bigFac.add(BigInteger.valueOf(Integer.parseInt(String.valueOf(number.charAt(i)))));
           }
        }
        if(bigFac.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) == 1){
            int res = Integer.parseInt(bigFac.toString());
            if(res % 10 == 0){
                return true;
            }
        }else {
            System.out.println("Too big value");
        }
        return false;
    }


     public boolean is_an_bn(String word){

         if(word.length() % 2 != 0 ){
             return false;
         }
         int n = word.length() / 2;
         for (int i = 0; i < n ; i++) {
             if(word.charAt(i) != 'a'){
                 return false;
             }
         }

         for (int i = n ; i < word.length() ; i++) {
             if(word.charAt(i) != 'b'){
                 return false;
             }
         }

         return true;

     }


    public static String reduce_file_path(String path){
        if(path.charAt(0) != '/'){
            System.out.println("Invalid path");
            return "";
        }
        StringBuilder temp = new StringBuilder();
        int size=0;
        String[] arr = path.split("[/]+");
        p:for (int i = 1; i <arr.length ; i++) {
            System.out.println(arr[i]);

            if(arr[i].charAt(0) == '.' && arr[i].length() == 1){
                System.out.println("res");
                continue p;
            } else if(arr[i].equals("..")){
                if(temp.length() == 0){
                    System.out.println("invalid path");
                    return "";
                }
                temp.delete(size,temp.length());
                continue p;
            }
            size=temp.length();
            temp.append(arr[i]);
            temp.append("/");

        }
        String result = "/";
        if(!(temp.length() == 0)){ result +=temp; }
        return result;
    }


    public static int zero_insert(int n){
        boolean minus=false;
        if(n<0){
            n = Math.abs(n);
            minus = true;
        }
        String num = Integer.toString(n);
        StringBuilder b= new StringBuilder();
        int j=0;
        for (int i = 1; i <num.length() ; i++) {
            if(b.length() == 0){
                b.append(num.charAt(j));
            }
            if(num.charAt(i) == num.charAt(j)){
                b.append('0');
            }else if( (Integer.parseInt(String.valueOf(num.charAt(i))) +
                    Integer.parseInt(String.valueOf(num.charAt(j))))% 10 == 0){
                b.append('0');
            }
            b.append(num.charAt(i));
            j++;

        }
        BigInteger big = BigInteger.valueOf(Integer.MAX_VALUE);
        if(big.compareTo(new BigInteger( b.toString() )) == -1){
            System.out.println("too big number for integer");
            return 0;
        }
        String res =null;
        if(minus){
            res = "-";
        }
        res += b.toString();
        n= Integer.parseInt(res);
        return n;
    }
















}
