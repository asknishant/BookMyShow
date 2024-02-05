package com.bms.bookmyshow.controllers;

import com.bms.bookmyshow.dtos.CreateScreenRequest;
import com.bms.bookmyshow.models.Screen;
import com.bms.bookmyshow.services.ScreenService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/screen")
public class ScreenController {
    private ScreenService screenService;
    @PostMapping
    public Screen createScreen(@RequestBody CreateScreenRequest screenRequest) {
        return screenService.createScreen(screenRequest);
    }
}
