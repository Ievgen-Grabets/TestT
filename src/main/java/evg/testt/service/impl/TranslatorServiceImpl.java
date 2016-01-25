package evg.testt.service.impl;

import evg.testt.dto.TranslatorDto;
import evg.testt.service.TranslatorService;
import org.springframework.stereotype.Service;


@Service
public class TranslatorServiceImpl implements TranslatorService {

    public TranslatorDto translate(TranslatorDto translatorDto) {
        translatorDto.setTextOut("Якось так ми i перекладаемо...");
        return translatorDto;
    }

}
