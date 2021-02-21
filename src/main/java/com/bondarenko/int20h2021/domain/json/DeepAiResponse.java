package com.bondarenko.int20h2021.domain.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeepAiResponse {
    private String id;
    private Output output;
}
