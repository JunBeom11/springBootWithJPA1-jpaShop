package jpabook.jpashop.domain;

import jakarta.persistence.*;
import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class OrderItem {

    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = LAZY) // ManyToOne은 EAGER가 default이고 성능 저하 이슈로 LAZY 추천
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = LAZY) // ManyToOne은 EAGER가 default이고 성능 저하 이슈로 LAZY 추천
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderPrice; // 주문 가격

    private int count; // 주문 수량
}
