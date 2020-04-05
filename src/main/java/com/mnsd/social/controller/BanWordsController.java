package com.mnsd.social.controller;

import com.mnsd.social.model.BanWords;
import com.mnsd.social.service.BanWordService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/admin")
@ApiOperation("controller related to ban words")
public class BanWordsController {

    private BanWordService banWordService;

    public BanWordsController(BanWordService banWordService) {
        this.banWordService = banWordService;
    }

    @PostMapping("/add/words")
    public List<BanWords> addBanWords(@RequestBody String banWords){
        return this.banWordService.addWords(banWords);
    }

    @GetMapping("/words")
    public List<BanWords> getAllBanWord(){
        return this.banWordService.getAllWords();
    }
}
