public class Longest_Palindrome_substring {
    int result_start;
    int result_length;

    public String longest_palindrome(String s)
    {
        if(s.length()<2)
        {
            return s;
        }
        for(int start= 0;start < s.length();start++)
        {
            palindrome_check(s, start, start);
            palindrome_check(s, start, start+1);
        }
        return s.substring(result_start, result_start+result_length);
    }
    private void palindrome_check(String str, int begin, int end)
    {
        while(begin >=0 && end<str.length() && str.charAt(begin) == str.charAt(end))
        {
            begin--;
            end++;
        }
        if(result_length < end-begin-1)
        {

            result_start= begin + 1;
            result_length= end-begin-1;
        }
    }
}
