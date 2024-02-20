package dev.xelaseventh.authorMS.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorRequest {
    private String name;
    private String nationality;
    private String biography;
}
