package model.dto;

import java.time.LocalDate;

public class SuperDto {

    public int checksale(int pprice, LocalDate mdate) {

        if (mdate == null) {
            return pprice;
        }

        LocalDate now = LocalDate.now();

        String strDate = mdate.toString();
        String strNow = now.toString();

        String[] arrayDateStr = strDate.split("-");
        String[] arrayNowStr = strNow.split("-");

        int[] arrayDate = new int[3];
        int[] arrayNow = new int[3];

        for (int i = 0; i <= 2; i++) {
            arrayDate[i] = Integer.parseInt(arrayDateStr[i]);
            arrayNow[i] = Integer.parseInt(arrayNowStr[i]);
        }

        int result =
                (arrayDate[0] - arrayNow[0]) * 365
              + (arrayDate[1] - arrayNow[1]) * 30
              + (arrayDate[2] - arrayNow[2]);

        if (result == 1) {
            return (int)(pprice * 0.8);
        }

        else if (result == 0) {
            return (int)(pprice * 0.7);
        }

        return pprice;
    }
}