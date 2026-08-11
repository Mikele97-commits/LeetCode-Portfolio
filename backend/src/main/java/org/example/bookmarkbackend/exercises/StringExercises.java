package org.example.bookmarkbackend.exercises;

import java.util.*;


public class StringExercises {
    public static int lengthOfLongestSubstring(String s) {
        int counter = 0;
        int finalcounter = 0;
        int start = 0;
        int end = 0;
        int step = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (end < s.length()) {
            step++;

            if (map.containsKey(s.charAt(end))&&map.get(s.charAt(end)) >=start) {
                System.out.println("Step: " + step+" Found the same character'"+s.charAt(end)+"' at index: " + end+". Saving counter: " + counter);
                start=map.get(s.charAt(end))+1;
                map.put(s.charAt(end), end);
                if (counter>finalcounter) {
                    System.out.println("Counter " + counter + " is greater than finalcounter " + finalcounter);
                    finalcounter = counter;
                }
                end++;
                counter = end-start;
            }else {
                System.out.println("Step: " + step + ". End got to position: " + end+"w ith letter: " + s.charAt(end)+". Counter: " + counter);
                map.put(s.charAt(end), end);
                end++;
                counter++;
            }
        }
        if (counter>finalcounter) {
            finalcounter = counter;
        }
        return finalcounter;
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }

        if(s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return s;
            }else{
                return s.substring(0,1);
            }
        }
        String longest = "";
        String current = "";
        StringBuilder builder = new StringBuilder();
       //Check for odd-length palindrome
        for (int i = 0; i < s.length(); i++) {
            System.out.println("Checking " + i + " letter");
            int index1=i, index2=i;
            while(index1>=0 && index2<s.length()){
                if(s.charAt(index1)==s.charAt(index2)){
                    System.out.println("Goes for " + i + " letter");
                    index1--;
                    index2++;
                } else {
                    for(int j=index1+1; j<index2; j++){
                        builder.append(s.charAt(j));
                    }
                    current=builder.toString();

                    if(current.length()>longest.length()){
                        longest=current;
                    };
                    builder = new StringBuilder();
                    break;
                }
                if(index1<0 || index2==s.length()){
                    for(int j=index1+1; j<index2; j++){
                        builder.append(s.charAt(j));
                    }
                    current=builder.toString();

                    if(current.length()>longest.length()){
                        longest=current;
                    };
                    builder = new StringBuilder();
                    break;
                }
            }
        }

        //Check for even-length palindrome
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i)==s.charAt(i-1)){
                int index1=i-1, index2=i;
                while(index1>=0 && index2<s.length()){
                    if(s.charAt(index1)==s.charAt(index2)){
                        index1--;
                        index2++;
                    }else{
                        for(int j=index1+1; j<index2; j++){
                            builder.append(s.charAt(j));
                        }
                        current=builder.toString();

                        if(current.length()>longest.length()){
                            longest=current;
                        };
                        builder = new StringBuilder();
                        break;
                    }
                    if(index1<0 || index2==s.length()){
                        for(int j=index1+1; j<index2; j++){
                            builder.append(s.charAt(j));
                        }
                        current=builder.toString();

                        if(current.length()>longest.length()){
                            longest=current;
                        };
                        builder = new StringBuilder();
                        break;
                    }
                }
            }
        }
        System.out.println("Longest Palindrome: " + longest);
        return longest;
    }

    public static String zigzag(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }
        if (s.length() == 1|| s.length()==2) {
            return s;
        }



        if(s.length()<=numRows){
            return s;
        }
        Character[][] matrix = new Character[numRows][s.length()];


        int counter = 0;
        int row = 0;
        int col = 0;
        boolean switchDirection=false;
        while(counter<s.length()){
            if(!switchDirection){
                matrix[row][col] = s.charAt(counter);
                counter++;
                if(row+1==numRows){
                    switchDirection=true;
                }else {
                    row++;
                }
            }

            if (switchDirection) {
                if(counter==s.length()){
                    break;
                }
                row--;
                col++;
                matrix[row][col] = s.charAt(counter);

                counter++;
                if (row==0){
                    row++;
                    switchDirection=false;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<numRows; i++){
            for(int j=0; j<matrix[i].length; j++){
                if(matrix[i][j]!=null){
                    sb.append(matrix[i][j]);
                }
            }
        }
        String zigzag = sb.toString();
        return zigzag;
    }

    public static String longestCommonPrefix(String[] strs) {
        int shortestLength = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < shortestLength) {
                shortestLength = strs[i].length();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shortestLength; i++) {
            for(int j = 1; j < strs.length; j++) {
                if (strs[0].charAt(i) != strs[j].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(strs[0].charAt(i));
        }

        return sb.toString();
    }


    public static List<String> letterCombinations(String digits) {

        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i = 0; i<digits.length(); i++){
            numbers.add((int)digits.charAt(i)-'0');
        }
        char[] two={'a','b','c'};
        char[] three={'d','e','f'};
        char[] four={'g','h','i'};
        char[] five={'j','k','l'};
        char[] six={'m','n','o'};
        char[] seven={'p','q','r','s'};
        char[] eight={'t','u','v'};
        char[] nine={'w','x','y','z'};
        List<char[]> digitsList = new ArrayList<>();
        for(int i = 0; i<digits.length(); i++){
            switch(numbers.get(i)){
                case 2: digitsList.add(two); break;
                case 3: digitsList.add(three); break;
                case 4: digitsList.add(four); break;
                case 5: digitsList.add(five); break;
                case 6: digitsList.add(six); break;
                case 7: digitsList.add(seven); break;
                case 8: digitsList.add(eight); break;
                case 9: digitsList.add(nine); break;
            }
        }
        switch(digits.length()){
            case 1:return lCOne(digitsList);
            case 2:return lCTwo(digitsList);
            case 3:return lCThree(digitsList);
            case 4:return lCFour(digitsList);
        }
        return null;
    }
    public static List<String> lCOne(List<char[]> digits) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<digits.get(0).length; i++){
            sb.append(digits.get(0)[i]);
            result.add(sb.toString());
            sb.delete(0, sb.length());
        }
        return result;
    }
    public static List<String> lCTwo(List<char[]> digits) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<digits.get(0).length; i++){
            for(int j = 0; j<digits.get(1).length; j++){
                sb.append(digits.get(0)[i]).append(digits.get(1)[j]);
                result.add(sb.toString());
                sb.delete(0, sb.length());
            }
        }
        return result;
    }
    public static List<String> lCThree(List<char[]> digits) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<digits.get(0).length; i++){
            for(int j = 0; j<digits.get(1).length; j++){
                for(int k = 0; k<digits.get(2).length; k++) {
                    sb.append(digits.get(0)[i]).append(digits.get(1)[j]).append(digits.get(2)[k]);
                    result.add(sb.toString());
                    sb.delete(0, sb.length());
                }
            }
        }
        return result;
    }
    public static List<String> lCFour(List<char[]> digits) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<digits.get(0).length; i++){
            for(int j = 0; j<digits.get(1).length; j++){
                for(int k = 0; k<digits.get(2).length; k++) {
                    for(int l = 0; l<digits.get(3).length; l++) {
                        sb.append(digits.get(0)[i]).append(digits.get(1)[j]).append(digits.get(2)[k]).append(digits.get(3)[l]);
                        result.add(sb.toString());
                        sb.delete(0, sb.length());
                    }
                }
            }
        }
        return result;
    }

    public static boolean isValid(String s) {
        if(s.length()<2) return false;
        char[] chars= s.toCharArray();
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put('(', ')');
        pairs.put('[', ']');
        pairs.put('{', '}');
        Stack<Character> openings = new Stack<>();
        for (char aChar : chars) {
            if (pairs.containsKey(aChar)) {
                openings.push(aChar);
            } else if (openings.isEmpty()) {
                return false;
            } else if (aChar == pairs.get(openings.peek())) {
                openings.pop();
            } else {
                return false;
            }
        }
        return openings.isEmpty();
    }

    public static List<String> generateParenthesis(int n) {
        ArrayList<ArrayList<Integer>> combinations = new ArrayList<>();
        ArrayList<Integer> numerical = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();
        addNumber(numerical,n,combinations);
        for(ArrayList<Integer> combination : combinations){
            StringBuilder stringBuilder = new StringBuilder();
            for(Integer num : combination){
                if(num.equals(0)) stringBuilder.append("(");
                else stringBuilder.append(")");
            }
            result.add(stringBuilder.toString());
        }
        return result;
    }
    public static void addNumber(ArrayList<Integer> numerical, int num,ArrayList<ArrayList<Integer>> combinations) {
        if (numerical.size() == 2*num) {
            combinations.add(new ArrayList<>(numerical));
            return;
        }
        int zeroes=0;
        int ones=0;
        for (Integer integer : numerical) {
            if (integer == 0) {
                zeroes++;
            }
            if (integer == 1) {
                ones++;
            }
        }
        if (zeroes == num) {
            while(numerical.size()<2*num) {
                numerical.add(1);
            }
            combinations.add(new ArrayList<>(numerical));
            return;
        }
        if(zeroes == ones){
            numerical.add(0);
            addNumber(numerical, num, combinations);
            return;
        }
        if(zeroes > ones){
            ArrayList<Integer> numerical2 = new ArrayList<>(numerical);
            numerical.add(1);
            addNumber(numerical, num, combinations);
            numerical2.add(0);
            addNumber(numerical2, num, combinations);
        }
    }

    public static String mergeAlternately(String word1, String word2) {
        int minlength = Math.min(word1.length(), word2.length());
        StringBuilder result = new StringBuilder();
        for(int i=0;i<minlength;i++){
            result.append(word1.charAt(i));
            result.append(word2.charAt(i));
        }
        if(word1.length()<word2.length()){
            result.append(word2, minlength, word2.length());
        }
        if(word1.length()>word2.length()){
            result.append(word1, minlength, word1.length());
        }
        return result.toString();
    }

    public static String gcdOfStrings(String str1, String str2) {
        String str3 = str1 + str2;
        String str4 = str2 + str1;
        if(!str4.equals(str3)){
            return "";
        }
        return str3.substring(0,gcd(str1.length(),str2.length()));
    }
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static String reverseVowels(String s) {
        char[] charArray = s.toCharArray();
        List<Character> vowels = new ArrayList<>();
        List<Integer> indexes = new ArrayList<>();
        Map<Integer,Character> consonantMap = new HashMap<>();
        for (int i = 0; i < charArray.length; i++) {
            if(charArray[i]=='a'||charArray[i]=='A'||charArray[i]=='e'||charArray[i]=='E'||charArray[i]=='i'||charArray[i]=='I'||charArray[i]=='o'||charArray[i]=='O'||charArray[i]=='u'||charArray[i]=='U') {
                vowels.add(charArray[i]);
                indexes.add(i);
            }else{
                consonantMap.put(i,charArray[i]);
            }
        }
        Collections.reverse(indexes);
        Map<Integer, Character> vowelsMap = new HashMap<>();
        for(int i=0;i<vowels.size();i++){
            vowelsMap.put(indexes.get(i),vowels.get(i));
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(consonantMap.containsKey(i)){
                stringBuilder.append(consonantMap.get(i));
            }else{
                stringBuilder.append(vowelsMap.get(i));
            }
        }
        return stringBuilder.toString();
    }

    public static String reverseWords(String s) {
        List<String> words = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==' '||i==s.length()-1){
                if(s.charAt(i)!=' '){
                    stringBuilder.append(s.charAt(i));
                }
                if(!stringBuilder.isEmpty()){
                    words.add(stringBuilder.toString());
                    stringBuilder = new StringBuilder();
                }
                continue;
            }
            stringBuilder.append(s.charAt(i));
        }
        Collections.reverse(words);
        return String.join(" ", words);

    }

    public static int compress(char[] chars) {
        if(chars.length==1) return chars.length;
        int writingPointer=0;
        int readingPointer=0;
        char current =' ';
        int counter=1;
        while(readingPointer<chars.length){
            if(chars[readingPointer]==current){
                counter++;
            }else if(current!=' '){
                char temp = chars[readingPointer];
                chars[writingPointer]=current;
                writingPointer++;
                if(counter>1){
                    String numbers = String.valueOf(counter);
                    for(int i=0;i<numbers.length();i++){
                        chars[writingPointer]=numbers.charAt(i);
                        writingPointer++;
                    }
                }
                current = temp;
                counter=1;
                chars[writingPointer]=current;
                if(readingPointer==chars.length-1){
                    writingPointer++;
                }
            }else{
                current=chars[readingPointer];
                counter=1;
            }

            readingPointer++;
        }

        if(counter>1){
            chars[writingPointer]=current;
            String numbers = String.valueOf(counter);
            writingPointer++;
            for(int i=0;i<numbers.length();i++){
                chars[writingPointer]=numbers.charAt(i);
                writingPointer++;
            }
        }

        return writingPointer;
    }

    public static boolean isSubsequence(String s, String t) {

        if(s.isEmpty()){
            return true;
        }
        if(t.isEmpty()){
            return false;
        }
        int pointerA=0;
        int pointerB=0;
        while(true){
            if(s.charAt(pointerA)==t.charAt(pointerB)){
                pointerA++;
                pointerB++;
            }else{
                pointerB++;
            }
            if(pointerA==s.length()){
                return true;
            }
            if(pointerB==t.length()){
                return false;
            }
        }
    }

    public static int maxVowels(String s, int k) {
        char[] arr = s.toCharArray();
        int start = 0;
        int end = k-1;
        int biggest = 0;
        int sum = 0;
        boolean first;
        first= arr[0] == 'a' || arr[0] == 'e' || arr[0] == 'i' || arr[0] == 'o' || arr[0] == 'u';
        for (int i = 0; i <= end; i++) {
            if(arr[i]=='a'||arr[i]=='e'||arr[i]=='i'||arr[i]=='o'||arr[i]=='u'){
                sum++;
            }
        }
        biggest = sum;
        start++;
        end++;
        while(end<s.length()){
            if(first) sum--;
            if(arr[end]=='a'||arr[end]=='e'||arr[end]=='i'||arr[end]=='o'||arr[end]=='u'){
                sum++;
            }
            if(sum>biggest){
                biggest=sum;
            }
            if(sum==k){
                return k;
            }
            first= arr[start] == 'a' || arr[start] == 'e' || arr[start] == 'i' || arr[start] == 'o' || arr[start] == 'u';
            start++;
            end++;
        }
        return biggest;
    }

    public static boolean closeStrings(String word1, String word2) {

        if(word1.length()==word2.length()){
            HashSet<Character> set1 = new HashSet<>();
            HashSet<Character> set2 = new HashSet<>();
            char[] arr1 = word1.toCharArray();
            char[] arr2 = word2.toCharArray();

            int[] freq1 = new int[26];
            int[] freq2 = new int[26];

            for (char ch : arr1) {
                freq1[ch - 'a']++;
                set1.add(ch);
            }
            for (char ch : arr2) {
                freq2[ch - 'a']++;
                set2.add(ch);
            }

            Arrays.sort(freq1);
            Arrays.sort(freq2);

            if(Arrays.equals(freq1,freq2)){
                return set1.equals(set2);
            }
        }
        return false;
    }

    public static String removeStars(String s) {
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(arr[i]=='*'){
            i++;
        }
        for(int j=i;j<arr.length;j++){
            sb.append(arr[j]);
            if(j<=arr.length-2){
                while(arr[j+1]=='*'){
                    sb.deleteCharAt(sb.length()-1);
                    j++;
                    if(j==arr.length-1){
                        break;
                    }
                }
            }
        }
        return  sb.toString();
    }

    public static String decodeString(String s) {
        char[] arr = s.toCharArray();
        StringBuilder answer = new StringBuilder();
        StringBuilder number= new StringBuilder();
        int pointer=0;
        while(pointer<s.length()){
            if(arr[pointer]>='a' && arr[pointer]<='z'){
                answer.append(arr[pointer]);
            }
            if(arr[pointer]>='0' && arr[pointer]<='9'){
                number.append(arr[pointer]);
            }
            if(arr[pointer]=='['){
                pointer++;
                Result res= bracket(Integer.parseInt(number.toString()),pointer,arr);
                answer.append(res.word);
                pointer=res.pointer;
                number.delete(0,number.length());
                continue;
            }
            pointer++;
        }
        return answer.toString();
    }
    public record Result(String word, int pointer){};
    public static Result bracket(int number, int pointer, char[] arr){
        StringBuilder words = new StringBuilder();
        StringBuilder numbers = new StringBuilder();
        while(true){
            if(arr[pointer]-'a'>=0 && arr[pointer]-'a'<26){
                words.append(arr[pointer]);
            }
            if(arr[pointer]-'0'>=0 && arr[pointer]-'0'<10){
                numbers.append(arr[pointer]);
            }
            if(arr[pointer]=='['){
                pointer++;
                Result res= bracket(Integer.parseInt(numbers.toString()),pointer,arr);
                numbers.delete(0,numbers.length());
                words.append(res.word);
                pointer=res.pointer;
                continue;
            }
            if(arr[pointer]==']'){
                pointer++;
                break;
            }
            pointer++;
        }
        String sequence=words.toString();
        words.delete(0,words.length());
        for(int i=0;i<number;i++){
            words.append(sequence);
        }
        System.out.println("Giving out "+ sequence+" times " + number);
        return new Result(words.toString(),pointer);
    }

    public static String predictPartyVictory(String senate) {
        Queue<Character> queue = new LinkedList<>();
        int r=0,d=0;
        for(int i=0;i<senate.length();i++){
            if(senate.charAt(i)=='R'){
                r++;
            }else{
                d++;
            }
            queue.offer(senate.charAt(i));
        }

        int rVotes=0;
        int dVotes=0;
        while(r!=0&&d!=0){
            if(queue.peek()=='R'){
                if(dVotes>0){
                    queue.remove();
                    r--;
                    dVotes--;
                }else{
                    rVotes++;
                    queue.add(queue.poll());
                }
            }else{
                if(rVotes>0){
                    queue.remove();
                    d--;
                    rVotes--;
                }else{
                    dVotes++;
                    queue.add(queue.poll());
                }
            }
        }
        if(r>0) return "Radiant"; else return "Dire";
    }

}
