package com.likelion.GloBuddyBackend.controller.response.Post;

import com.likelion.GloBuddyBackend.controller.response.ApiResponse;
import com.likelion.GloBuddyBackend.dto.PostDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class PostListResponse extends ApiResponse  {

    private List<PostDto> posts;

    public PostListResponse(List<PostDto> postDto, long count) {
        this.posts = postDto;
    }


}
