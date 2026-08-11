package org.example.bookmarkbackend.service;

import org.example.bookmarkbackend.dto.DataDto;
import org.example.bookmarkbackend.dto.Params;
import org.example.bookmarkbackend.exercises.ArrayExercises;
import org.example.bookmarkbackend.exercises.ListExercises;
import org.example.bookmarkbackend.exercises.StringExercises;
import org.example.bookmarkbackend.exercises.IntExercises;
import org.example.bookmarkbackend.exercises.ListExercises.ListNode;

import java.util.Arrays;
import java.util.List;

public class ExerciseService {
    public static String executeExercise(String id, DataDto dataDto) {
        int ID=Integer.parseInt(id);
        List<Params> data = dataDto.params();
        switch (ID) {

            case 1: //Two-sum
            {
                int[] array = arrayMaker(data.get(0).value());
                return Arrays.toString(ArrayExercises.twoSum(array,Integer.parseInt(data.get(1).value())));
            }

            case 2: //Add Two Numbers
            {
                ListNode l1=listnodeMaker(data.get(0).value());
                ListNode l2=listnodeMaker(data.get(1).value());
                ListNode ans=ListExercises.addTwoNumbers(l1,l2);
                StringBuilder stringBuilder=new StringBuilder();
                while(ans!=null){
                    stringBuilder.append(ans.val);
                    ans=ans.next;
                }
                return stringBuilder.toString();
            }


            case 3: // Longest Substring Without Repeating Characters
                return String.valueOf(
                        StringExercises.lengthOfLongestSubstring(data.get(0).value())
                );

            case 4: // Median of two sorted arrays
            {
                int[] array1 = arrayMaker(data.get(0).value());
                Arrays.sort (array1);
                int[] array2 = arrayMaker(data.get(1).value());
                Arrays.sort(array2);
                return String.valueOf(ArrayExercises.findMedianSortedArrays(array1,array2));

            }
            case 5: // Longest Palindromic Substring
                return StringExercises.longestPalindrome(data.get(0).value());

            case 6: // Zigzag Conversion
                return StringExercises.zigzag(
                        data.get(0).value(),
                        Integer.parseInt(data.get(1).value())
                );

            case 7: // Reverse Integer
                return String.valueOf(
                        IntExercises.reverse(Integer.parseInt(data.get(0).value()))
                );

            case 8: // String to Integer (atoi)
                return String.valueOf(
                        IntExercises.myAtoi(data.get(0).value())
                );

            case 9: // Palindrome Number
                return String.valueOf(
                        IntExercises.isPalindrome(Integer.parseInt(data.get(0).value()))
                );

            case 12: // Integer to Roman
                return IntExercises.intToRoman(Integer.parseInt(data.get(0).value()));

            case 13: // Roman to Integer
                return String.valueOf(
                        IntExercises.romanToInt(data.get(0).value())
                );

            case 14: // Longest Common Prefix
                // Expects a single string with words separated by spaces or commas.
                // Adjust the split if your frontend sends a different format.
                String[] words = data.get(0).value().trim().split("\\s+|,\\s*");
                return StringExercises.longestCommonPrefix(words);

            case 15: //3-sum
            {
                int[] array1 = arrayMaker(data.get(0).value());
                return ArrayExercises.threeSum(array1).toString();
            }

            case 16: //3-sum closest
            {
                int[] array1 = arrayMaker(data.get(0).value());
                return String.valueOf(ArrayExercises.threeSumClosest(array1, Integer.parseInt(data.get(1).value())));
            }

            case 17: // Letter Combinations of a Phone Number
                return StringExercises.letterCombinations(data.get(0).value()).toString();

            case 19: //Remove n-t node from end of list
            {
                ListNode l1=listnodeMaker(data.get(0).value());
                int number = Integer.parseInt(data.get(1).value());
                ListNode l2= ListExercises.removeNthFromEnd(l1, number);
                StringBuilder stringBuilder=new StringBuilder();
                while(l2!=null){
                    stringBuilder.append(l2.val).append(",");
                    l2=l2.next;
                }
                return stringBuilder.toString();
            }

            case 20: // Valid Parentheses
                return String.valueOf(
                        StringExercises.isValid(data.get(0).value())
                );

            case 21: //Merge two sorted lists
            {
                ListNode l1 =  listnodeMaker(data.get(0).value());
                ListNode l2 =  listnodeMaker(data.get(1).value());
                ListNode ans=ListExercises.mergeTwoLists(l1,l2);

                StringBuilder stringBuilder=new StringBuilder();
                while(ans!=null){
                    stringBuilder.append(ans.val).append(",");
                    ans=ans.next;
                }
                return stringBuilder.toString();

            }

            case 22: // Generate Parentheses
                return StringExercises.generateParenthesis(
                        Integer.parseInt(data.get(0).value())
                ).toString();

            case 151: // Reverse Words in a String
                return StringExercises.reverseWords(data.get(0).value());

            case 345: // Reverse Vowels of a String
                return StringExercises.reverseVowels(data.get(0).value());

            case 392: // Is Subsequence
                return String.valueOf(
                        StringExercises.isSubsequence(
                                data.get(0).value(),
                                data.get(1).value()
                        )
                );

            case 394: // Decode String
                return StringExercises.decodeString(data.get(0).value());

            case 649: // Dota2 Senate
                return StringExercises.predictPartyVictory(data.get(0).value());

            case 1071: // Greatest Common Divisor of Strings
                return StringExercises.gcdOfStrings(
                        data.get(0).value(),
                        data.get(1).value()
                );



            case 1456: // Maximum Number of Vowels in a Substring of Given Length
                return String.valueOf(
                        StringExercises.maxVowels(
                                data.get(0).value(),
                                Integer.parseInt(data.get(1).value())
                        )
                );

            case 1657: // Determine if Two Strings Are Close
                return String.valueOf(
                        StringExercises.closeStrings(
                                data.get(0).value(),
                                data.get(1).value()
                        )
                );

            case 1768: // Merge Strings Alternately
                return StringExercises.mergeAlternately(
                        data.get(0).value(),
                        data.get(1).value()
                );

            case 2390: // Removing Stars From a String
                return StringExercises.removeStars(data.get(0).value());

            default:
                return null;
        }
    }

    static int[] arrayMaker(String string){
        String regex=",";
        String[] split = string.split(regex);
        int[] array=new int[split.length];
        for(int i=0;i<split.length;i++){
            array[i]=Integer.parseInt(split[i]);
        }
        return array;
    }

    static ListNode listnodeMaker(String string){
        int[] values=arrayMaker(string);
        ListNode dummy = new ListNode(0);   // dummy node (value doesn't matter)
        ListNode current = dummy;

        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }
}
