package com.abcd.theaterward.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "member")
public class Member {
    @Id
    private int member_no;

    private String member_name;

    public int getMember_no() {
        return member_no;
    }

    public void setMember_no(int member_no) {
        this.member_no = member_no;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }
}
