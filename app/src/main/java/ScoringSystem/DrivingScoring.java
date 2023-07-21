package ScoringSystem;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.text.DecimalFormat;

public class DrivingScoring {
    private final String url = "http://api.openweather.org/data/2.5/weather";
    private final String appid = "";
    private String tmp = "";
    long overallScore = 0;
    public long REWARDS = 0;
    DecimalFormat df = new DecimalFormat("#.##");
    public void getWeatherDetails(View view, String city){
        String tmp = "";
        city = "";
        String appid = "";
        if(city.equals(""))
        {
            Toast.makeText(view.getContext(), "Fetching current location", Toast.LENGTH_SHORT).show();
        }
        else
        {
            tmp = url + "?q=" + city + "," + "india" + appid;
        }
    }

    public void totalScore(double speed, double acc, double dec, int weather, int roadType, double distance)
    {
        double recommended;
        if(roadType == 0)
        {
            recommended = 30;
        }
        else if(roadType == 1)
        {
            recommended = 50;
        }
        else if(roadType == 2)
        {
            recommended = 70;
        }
        else
        {
            recommended = 110;
        }



        if(weather == 0)
        {
            if((speed - recommended > 10) || (recommended - speed > 10))
            {
                Log.i("Information","It is risky");
            }
            else if((speed - recommended < 10) || (recommended-speed < 10))
            {
                if(distance > 0 && distance < 10)
                {
                    //Score += 30
                }
                else if(distance > 10 && distance < 50)
                {
                    //Score += 40
                }
                else
                {
                    //Score += 50
                }
            }
            else if((speed - recommended < 1) || (recommended - speed < 1))
            {
                if(distance > 0 && distance < 10)
                {
                    //Score += 36
                }
                else if(distance > 10 && distance < 50)
                {
                    //Score += 48
                }
                else
                {
                    //Score += 60
                }
            }
        }
        else if(weather == 1)
        {
            recommended -= 10;
            if((speed - recommended > 10) || (recommended - speed > 10))
            {
                Log.i("Information","It is risky");
            }
            else if((speed - recommended < 10) || (recommended-speed < 10))
            {
                if(distance > 0 && distance < 10)
                {
                    //Score += 30
                }
                else if(distance > 10 && distance < 50)
                {
                    //Score += 40
                }
                else
                {
                    //Score += 50
                }
            }
            else if((speed - recommended < 1) || (recommended - speed < 1))
            {
                if(distance > 0 && distance < 10)
                {
                    //Score += 36
                }
                else if(distance > 10 && distance < 50)
                {
                    //Score += 48
                }
                else
                {
                    //Score += 60
                }
            }
        }
        else
        {
            recommended -= 20;
            if((speed - recommended > 10) || (recommended - speed > 10))
            {
                Log.i("Information","It is risky");
            }
            else if((speed - recommended < 10) || (recommended-speed < 10))
            {
                if(distance > 0 && distance < 10)
                {
                    //Score += 30
                }
                else if(distance > 10 && distance < 50)
                {
                    //Score += 40
                }
                else
                {
                    //Score += 50
                }
            }
            else if((speed - recommended < 1) || (recommended - speed < 1))
            {
                if(distance > 0 && distance < 10)
                {
                    //Score += 36
                }
                else if(distance > 10 && distance < 50)
                {
                    //Score += 48
                }
                else
                {
                    //Score += 60
                }
            }
        }

        if(overallScore > 10000)
        {
            overallScore -= 10000;
            REWARDS++;
        }
    }
}
