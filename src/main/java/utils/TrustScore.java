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

        } else if (score >= 50) {

            return "MEDIUM RISK 🟠";

        } else {

            return "HIGH RISK 🔴";

        }

    }

    public String getTrustLevel(int score) {

        if (score >= 90) {

            return "Very Trusted";

        } else if (score >= 70) {

            return "Trusted";

        } else if (score >= 40) {

            return "Suspicious";

        } else {

            return "Dangerous";

        }

    }

    public String generateExplanation(String value) {

        StringBuilder explanation = new StringBuilder();

        if (value.contains("fake")) {
            explanation.append("✓ Suspicious keyword 'fake' detected.\n");
        }

        if (value.contains("login")) {
            explanation.append("✓ Login page keyword detected.\n");
        }

        if (value.contains("bank")) {
            explanation.append("✓ Banking-related keyword detected.\n");
        }

        if (value.contains("verify")) {
            explanation.append("✓ Verification keyword detected.\n");
        }

        if (value.contains("@")
                && !value.contains("gmail")
                && !value.contains("outlook")
                && !value.contains("yahoo")) {

            explanation.append("✓ Unknown email provider detected.\n");

        }

        if (value.matches(".*\\d.*")) {

            explanation.append("✓ Phone number pattern detected.\n");

        }

        if (explanation.length() == 0) {

            explanation.append("✓ No suspicious indicators were detected.\n");

        }

        return explanation.toString();
    }

    public String getScamType(int score) {

        if (score < 40) {
            return "PHISHING ATTACK";
        }

        if (score < 70) {
            return "POTENTIALLY SUSPICIOUS";
        }

        return "SAFE";
    }

    public String getRecommendation(int score) {

        if (score < 40) {

            return "Do NOT enter passwords.\n"
                    + "Avoid clicking links.\n"
                    + "Use the official website.";

        }

        if (score < 70) {

            return "Verify the source before continuing.";

        }

        return "No immediate threat detected.";
    }

}
