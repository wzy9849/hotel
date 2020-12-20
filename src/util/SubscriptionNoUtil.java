package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class SubscriptionNoUtil {
    public static synchronized String getSubscriptionNo(){
        Random random = new Random();
        // 随机数的量 自由定制，这是4位随机数
        Integer r = random.nextInt(9000) + 1000;
        // 返回  10位时间
        DateFormat sdf = new SimpleDateFormat("yyyyMMddss");
        String timeStr = sdf.format(new Date());
        // E+10位时间+2位随机数
        return  "E"+timeStr+r;
    }
}
