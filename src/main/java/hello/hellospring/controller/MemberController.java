package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    /*
    Member Controller는 Service를 이용해서 회원가입을 하고 데이터 조회를 해야함.
    그래서 아래와 같이 선언해서 사용할 수도 있으나, MemberService에는 별다른 기능이 없음
    여러개의 인스턴스를 생성하지 않고, 하나만 생성해서 공통으로 사용하면됨.
    즉, 스프링 컨테이너에 등록(어노테이션 정의)을 해서 사용하면됨.
    private final MemberService memberService = new MemberService();
    */

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

}
