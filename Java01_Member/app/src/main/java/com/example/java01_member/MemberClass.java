package com.example.java01_member;

public class MemberClass {
    //접근제한자, static 멤버 구분자의 기능 이해하기
    //메인액티비티에서 새게의 변수에 모두 접근 시도해보고 된다면 왜 되는지, 안된다면 왜 안되는지 이유를 알기
    //접근제한자_변수명
    String default_str = "default"; // 접근가능영역 : 같은 패키지 안에서 가능
    public String public_str = "public"; // 접근가능영역 : 어디서든
    private String private_str = "private"; // 접근가능영역 : 같은 멤버안에서(클래스 안에서만 사용 가능)
    //그래서 게터세터가 필요한 것
    //protected 생략
    
    //private에 접근하기 위해서 getter & setter를 만드는데
    //getter & setter는 반드시 접근이 되야해서 기본적으로 public ← 으로 만들어짐

    //default
    void default_method(){

    }

    //public
    public void public_method(){

    }

    //private
    private void private_method(){

    }
}
