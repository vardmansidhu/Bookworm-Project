package com.bookworm.bookworm_middleware.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bookworm.bookworm_middleware.repositories.ILanguageRepository;
import com.bookworm.bookworm_middleware.entities.Language;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageManagerImpl implements ILanguageManager {

    @Autowired
    private ILanguageRepository languageRepository;

    @Override
    public List<Language> getAllLanguages() {
        return languageRepository.findAll();
    }

    @Override
    public Language getLanguageById(int id) {
        Optional<Language> optional = languageRepository.findById(id);
        return optional.orElse(null);
    }

    @Override
    public Language saveLanguage(Language language) {
        return languageRepository.save(language);
    }

    @Override
    public void deleteLanguage(int id) {
        languageRepository.deleteById(id);
    }

    @Override
    public List<Language> getLanguageDescByTypeId(int typeid) {
        return languageRepository.findLanguageDescByTypeId(typeid);
    }

}