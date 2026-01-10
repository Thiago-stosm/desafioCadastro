package utils.test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

    public class DateUtil {

        private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd'T'HHmm");

        private DateUtil(){}

        public static String formatarData(LocalDateTime localDateTime)
        {
            String dataFormatada = localDateTime.format(dateFormatter);
            return dataFormatada;
        }

        public static LocalDateTime captarDataLDT(){
            return LocalDateTime.now();
        }
    }

