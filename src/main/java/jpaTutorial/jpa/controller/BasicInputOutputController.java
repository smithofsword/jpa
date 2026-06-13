package jpaTutorial.jpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/basic")
public class BasicInputOutputController {

    @GetMapping("/hello")
    public BasicResponse sayHello(@RequestParam(defaultValue = "Student") String name) {
        return new BasicResponse(
                "Hello, " + name + "!",
                name,
                LocalDateTime.now()
        );
    }

    @PostMapping("/echo")
    public BasicResponse echoMessage(@RequestBody BasicRequest request) {
        String name = cleanValue(request.name(), "Student");
        String message = cleanValue(request.message(), "No message provided");

        return new BasicResponse(
                name + " said: " + message,
                name,
                LocalDateTime.now()
        );
    }

    private String cleanValue(String value, String fallback) {
        if (value == null || value.isBlank()) {
            return fallback;
        }

        return value.trim();
    }

    public record BasicRequest(String name, String message) {
    }

    public record BasicResponse(String output, String name, LocalDateTime processedAt) {
    }
}
