package com.centroinformacion.mail.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmailFileDTO {
    private String[] toUser;
    private String subject;
    private String message;
    MultipartFile file;
}
