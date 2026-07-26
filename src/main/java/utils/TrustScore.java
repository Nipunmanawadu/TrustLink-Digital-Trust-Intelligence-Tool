package utils;

import model.Risk;
import java.util.ArrayList;

public class TrustScore {


    public int calculateScore(ArrayList<Risk> risks) {

        int score = 100;


        for (Risk risk : risks) {

            score -= risk.getScore();

        }


        if (score < 0) {

            score = 0;

        }


        return score;

    }



    public String getStatus(int score) {


        if (score >= 80) {

            return "SAFE 🟢";

        }
        else if (score >= 50) {

            return "MEDIUM RISK 🟠";

        }
        else {

            return "HIGH RISK 🔴";

        }

    }



    public String getTrustLevel(int score) {


        if (score >= 90) {

            return "Very Trusted";

        }
        else if (score >= 70) {

            return "Trusted";

        }
        else if (score >= 40) {

            return "Suspicious";

        }
        else {

            return "Dangerous";

        }

    }

}