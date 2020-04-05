package com.mnsd.social.service;

import com.mnsd.social.model.BanWords;
import com.mnsd.social.repository.BanWordsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BanWordService {
    private BanWordsRepository banWordsRepository;

    public BanWordService(BanWordsRepository banWordsRepository) {
        this.banWordsRepository = banWordsRepository;
    }

    public List<BanWords> addWords(String banWords) {
        String[] words = banWords.split(",");
        List<BanWords> saveWords=new ArrayList<>();
        BanWords banWords1;
        for (String word:words) {
            banWords1=new BanWords();
            banWords1.setWord(word);
            saveWords.add(banWords1);
        }
        this.banWordsRepository.saveAll(saveWords);
        return this.getAllWords();
    }

    public List<BanWords> getAllWords() {
        return this.banWordsRepository.findAll();
    }
}
