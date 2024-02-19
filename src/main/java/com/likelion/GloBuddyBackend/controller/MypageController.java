package com.likelion.GloBuddyBackend.controller;

import com.likelion.GloBuddyBackend.controller.request.MyInfoEditRequest;
import com.likelion.GloBuddyBackend.dto.MyInfoEditDto;
import com.likelion.GloBuddyBackend.service.MemberService;
import com.likelion.GloBuddyBackend.service.MypageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/mypage")
@RequiredArgsConstructor
@CrossOrigin("*")
public class MypageController {

    private final MypageService mypageService;

    @PatchMapping("/edit/{memberId}")
    public ResponseEntity<Void> editMember(
            @PathVariable Long memberId, @RequestBody MyInfoEditRequest request) {

        MyInfoEditDto myInfoEditDto = MyInfoEditDto.of(request);
        mypageService.editMemberInfo(myInfoEditDto,memberId);

        return ResponseEntity.ok().build();
    }


}
