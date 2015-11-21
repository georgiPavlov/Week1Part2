import java.util.Stack;

/**
 * Created by georgipavlov on 20.11.15.
 */
public class Week1Part2 {
    public boolean isHack(int n){
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
            while (!isHack(n)) {}
            System.out.print("Next number: " + n);
        }
    }

    public int  countVowels(String str,String line){
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


    public int PalindromeScore(int n){
        if(isPalindrome(n)){
            return 1;
        }else {
            int func=0;
            String string = Integer.toString(n);
            StringBuilder b =new StringBuilder(string);
            string=b.reverse().toString();
            func=1+ n+ Integer.parseInt(string);
            return PalindromeScore(func);
        }
    }

    public  boolean isPalindrome(int n){
        String argument= Integer.toString(n);
        int temp=0;
        if(argument.charAt(0) == '-'){
            temp=1;
        }
        int size = argument.length();
        int frond = temp;
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
            temp -=tempCount-count;
            count=3;

        }else  if(w != ' ' && count > 4){
            tempCount = count;
            temp -=tempCount-count;
            count=4;
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
    public void is_credit_card_valid(String number){
        System.out.println("Start");
    }






}
