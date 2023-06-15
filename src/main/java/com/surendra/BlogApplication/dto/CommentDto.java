package com.surendra.BlogApplication.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {
    private Long commentId;
    private String name;
    private String email;
    private String comment;
}
