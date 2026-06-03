package com.example.securityApplication.SecurityApp.services;

import com.example.securityApplication.SecurityApp.dto.PostDTO;
import com.example.securityApplication.SecurityApp.entities.PostEntity;
import com.example.securityApplication.SecurityApp.exceptions.ResouceNotFoundException;
import com.example.securityApplication.SecurityApp.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PostDTO> getAllPosts() {
        return postRepository.findAll().stream().map(postEntity ->
                modelMapper.map(postEntity,PostDTO.class)).toList();
    }

    @Override
    public PostDTO createNewPost(PostDTO inputPost) {
        PostEntity postEntity=modelMapper.map(inputPost,PostEntity.class);
        return modelMapper.map(postRepository.save(postEntity),PostDTO.class);
    }

    @Override
    public PostDTO getPostById(Long postId) {
        PostEntity postEntity=postRepository.findById(postId)
                .orElseThrow(()->new ResouceNotFoundException("Post Not Found with  id"+postId));
        return modelMapper.map(postEntity,PostDTO.class);
    }
}
