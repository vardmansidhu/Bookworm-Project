package com.bookworm.bookworm_middleware.services;

import java.util.List;
import com.bookworm.bookworm_middleware.entities.Language;

public interface ILanguageManager {
    List<Language> getAllLanguages();

    Language getLanguageById(int id);

    Language saveLanguage(Language language);

    void deleteLanguage(int id);

    List<Language> getLanguageDescByTypeId(int typeid);

}