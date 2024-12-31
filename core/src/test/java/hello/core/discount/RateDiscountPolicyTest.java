package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest {
    //이게 정말 10%할인이 되는건지
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다")
    void vip_o(){
        //given : member의 조건
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        
        //when : member의 price가 10000원인 상황
        int discount = discountPolicy.discount(member, 10000);
        
        //then : 할인된 금액은 1000원이 나와야 함
        assertThat(discount).isEqualTo(1000);
    }

    //실패 테스트도 꼭 필요함 : vip가 아닌 경우
    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다")
    void vip_x() {
        //given : 등급이 BASIC인 회원
        Member member = new Member(2L, "memberBASIC", Grade.BASIC);
        //when : 가격이 10000원인 제품 구매할때
        int discount = discountPolicy.discount(member, 10000);
        //then : 할인안됨
        assertThat(discount).isEqualTo(0);
    }
}