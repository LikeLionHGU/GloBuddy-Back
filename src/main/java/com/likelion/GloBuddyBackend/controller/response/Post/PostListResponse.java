package com.likelion.GloBuddyBackend.controller.response.Post;

import com.likelion.GloBuddyBackend.controller.response.ApiResponse;
import com.likelion.GloBuddyBackend.dto.PostDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.likelion.GloBuddyBackend.domain.Post;

import java.util.List;

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class PostListResponse extends ApiResponse  {

    private List<PostDto> posts;

    public PostListResponse(List<PostDto> postDto) {
        this.posts = postDto;
    }


}
