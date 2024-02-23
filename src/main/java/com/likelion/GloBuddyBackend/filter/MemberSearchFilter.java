package com.likelion.GloBuddyBackend.filter;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MemberSearchFilter {

    private String gender;
    private String nation;

    @Builder
    public MemberSearchFilter( String gender, String nation){
        this.gender = gender;
        this.nation = nation;

    }


}
