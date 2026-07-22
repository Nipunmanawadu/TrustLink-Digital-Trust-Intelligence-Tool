/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

public class ScanHistory {

    private String inputValue;
    private int trustScore;
    private String status;

    public ScanHistory(String inputValue,
                       int trustScore,
                       String status) {

        this.inputValue = inputValue;
        this.trustScore = trustScore;
        this.status = status;

    }

    public String getInputValue() {

        return inputValue;

    }

    public int getTrustScore() {

        return trustScore;

    }

    public String getStatus() {

        return status;

    }

}
