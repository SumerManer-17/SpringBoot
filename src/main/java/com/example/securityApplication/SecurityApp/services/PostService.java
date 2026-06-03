package com.example.securityApplication.SecurityApp.services;


import com.example.securityApplication.SecurityApp.dto.PostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostService {
    List<PostDTO>getAllPosts();

    PostDTO createNewPost(PostDTO inputPost);

    PostDTO getPostById(Long postId);
}
