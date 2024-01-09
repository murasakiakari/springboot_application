package com.example.springboot;

import com.example.springboot.models.MessageResponse;
import com.example.springboot.services.ConvertToAsciiArtKt;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class Controller {
	private Logger logger = LoggerFactory.getLogger(Controller.class);

	@GetMapping("/")
	public MessageResponse index() {
        return new MessageResponse("Message from Spring Boot Service");
	}

	@PostMapping("/convertToAsciiArt")
	public MessageResponse convertToAscii() {
		return null;
    }
}
