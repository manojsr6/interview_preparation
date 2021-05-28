public class find_angle {
    public static int calcAngle(double hour, double minutes)
    {
        if(hour == 12)
            hour= 0;
        if(minutes == 60)
        {
            minutes= 0;
            hour +=1;
            if(hour > 12)
            {
                hour= hour - 12;
            }
        }
        int hour_angle= (int)(0.5*(hour*60+minutes));
        int minute_angle= (int)(6*minutes);
        int angle= Math.abs(hour_angle - minute_angle);

        angle= Math.min(360 - angle, angle);

        return  angle;
    }

    // Driver Code
    public static void main (String[] args)
    {
        System.out.println(calcAngle(9, 60)+" degree");
        System.out.println(calcAngle(3, 30)+" degree");
    }
}
