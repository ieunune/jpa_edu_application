package jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {

    // Fields
    private String city;
    private String street;
    private String zipcode;

    // Constructor
    protected Address() {}

    // Setter 사용시 해당 객체의 필드값이 어느 서비스와 관련되어 변경되는지 포인트를 찾을 수 없음.
    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

    // Method


}
