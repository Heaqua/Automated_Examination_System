package com.company.dao.sqlplus;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Current {
    public static int getCurrentYear(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        String y = sdf.format(date);
        short y2 = Short.parseShort(y);
        return y2;
    }
    public static int getCurrentSem(){
        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        Date date = new Date();
        String m = sdf.format(date);
        int month = Integer.parseInt(m);
        if(month > 8 && month <=12){
            return 1;
        }
        return 2;
    }

}
