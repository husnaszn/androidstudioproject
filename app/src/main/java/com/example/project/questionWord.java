package com.example.project;

public class questionWord {

    private String quesWord, ansChoi;

    public questionWord(){
        quesWord = "";
        ansChoi = "";
    }

    public String getQuesWord() {
        return quesWord;
    }

    public void setQuesWord(String quesWord) {
        this.quesWord = quesWord;
    }

    public String getAnsChoi() {
        return ansChoi;
    }

    public void setAnsChoi(String ansChoi) {
        this.ansChoi = ansChoi;
    }

    public questionWord(String qw, String ac){
        quesWord = qw;
        ansChoi = ac;
    }
}
