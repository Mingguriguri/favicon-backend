package com.example.demo.dto.view;

import com.example.demo.dto.post.PostResponseDto;
import com.example.demo.entity.Post;
import com.example.demo.entity.User;
import com.example.demo.entity.View;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ViewResponseDto {
    private String userId;

    private LocalDateTime createdAt;

    public static ViewResponseDto toDto(View view) {
        return new ViewResponseDto(
              view.getUser().getUserId(),
                view.getCreatedAt()
        );
    }
}
